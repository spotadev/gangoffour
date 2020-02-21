/*
    =======================================================================================
    This code is part of SpotADev.

    SpotADev is e-commerce software for East Africa. SpotADev is a design from JavaSpeak.
    JavaSpeak is a name given to a collective of developers managed by John Dickerson.
    
    The following were the licensors of SpotADev at the time this file was 
    created / last edited:
    
    John Dickerson, Ronald Kasaija, Joel Mumo, Stephen Juma, Stephen Mwanzi, Jackline Gitari, 
    Samuel Kisilu, Nixon Chebii, Mercy Chepkoech
    
    The individual voting rights / control / share of profits to the individual developers 
    is roughly proportional to their contribution.
    
    Additional Licensors may be added to this license if the licensors agree to it based
    on their voting rights.   In the case that a contributor is to work on the project
    and not be a licensor they need to sign a waiver that they understand they do not
    have voting rights, control or a share of profits.  This waiver remains in force
    until the current licensors agree to add the licensor to this license as a licensor.
    
    The SpotADev software has a proprietary license. Please look at or request
    spotadev_license.txt for further details.

    Copyright (C) 2019 JavaSpeak

    Email:  john.charles.dickerson@gmail.com

    ========================================================================================
    Author : John Dickerson
    ========================================================================================
*/
package com.javaspeak.designpatterns.go4.behavioural.iterator;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * ConcurrentLinkedList uses Compare and Swap (CAS) operations to add and remove elements to the 
 * list.  This is less expensive than traditional blocking synchronisation.
 * <p>
 * In ConcurrentLinkedList there is a AtomicReference field called 
 * lastAddedLinkedElementAtomicReference which references a LinkedElement. LinkedElement has a 
 * field which can references other LinkedElements.
 * <p>
 * When the first LinkedElement, is added lastAddedLinkedElementAtomicReference references A.
 * <p>
 * When the next LinkedElement is added lastAddedLinkedElementAtomicReference references B. 
 * B itself references A.  In other words: B ==> A
 * <p>
 * When the next LinkedElement, C, is added lastAddedLinkedElementAtomicReference references C. 
 * C itself references B which in turn references A. In other words: C ==> B ==> A
 * <p>
 * LinkedElement provides a wrapper for the element being added and also has nextLinkedElement 
 * and previousLinkedElement fields.  When an element is added a new LinkedElement is created and 
 * its nextLinkedElement field is mapped to the LinkedElement currently stored in 
 * lastAddedLinkedElementAtomicReference.  The current LinkedElement is then replaced with the 
 * new LinkedElement in the lastAddedLinkedElementAtomicReference.  The CAS operation only occurs 
 * on the lastAddedLinkedElementAtomicReference field.  The previousLinkedElement fields are not 
 * updated at this point in time and are used for creating snapshot iterators.
 * 
 * @author John Dickerson - 21 Feb 2020
 */
public class ConcurrentLinkedList<E> implements SnapshotIterable<E> {

    // references the last added LinkedElement.  New LinkedElements are created
    // and updated in this AtomicReference using a CAS operation.
    private AtomicReference<LinkedElement<E>> lastAddedLinkedElementAtomicReference =
            new AtomicReference<LinkedElement<E>>();

    /**
     * This AtomicReferenceFieldUpdater is used to update the nextLinkedElement volatile field of 
     * a LinkedElement with another LinkedElement.  AtomicReferenceFieldUpdater uses CAS hardware 
     * support to update the field.  AtomicReferenceFieldUpdater is more efficient in updating 
     * fields that using AtomicReference when there are many instances to update. If it is not used 
     * then multiple AtomicReference would need to be used, one for each instance which could be 
     * quite expensive on memory resources.
     */
    @SuppressWarnings( "rawtypes" )
    private AtomicReferenceFieldUpdater<LinkedElement, LinkedElement> nextLinkedElementUpdater =
            AtomicReferenceFieldUpdater.newUpdater(
                    LinkedElement.class, LinkedElement.class, "nextLinkedElement" );

    /**
     * A non expensive CAS operation is used to update a reference in 
     * lastAddedLinkedElementAtomicReferencein to the last added LinkedElement.
     * <p>
     * The newly added LinkedElement references the LinkedElements already in the chain.
     * <p>
     * LinkedElements are used to wrap the element being added and to provide a reference to the 
     * next LinkedElement in the chain.
     * <p>
     * The LinkedElement placed at the beginning of the chain is always the last LinkedElement 
     * added.
     *
     * @param object 
     *      Element to add
     */
    public void add( E object ) {

        LinkedElement<E> linkedElement = new LinkedElement<E>( object );

        // Keep trying to update the reference to the new LinkedElement being added using a CAS 
        // operation until it succeeds.  CAS operations avoid the expense of traditional 
        // synchronization.  Instead of blocking all other threads until the current thread
        // releases the lock, CAS operations read the current value of a field, do some processing 
        // and before replacing the current value with a new value, check that the old value has 
        // not changed in the meantime.  If the old value has changed that means the old value
        // was changed by another thread and the operation is repeated until successful.  CAS 
        // methods make use of CAS functionality in the hardware.
        while ( true ) {

            linkedElement.nextLinkedElement =
                    lastAddedLinkedElementAtomicReference.get();

            // if the old value from lastAddedLinkedElementAtomicReference has not changed replace 
            // it with the new reference in a CAS operation.
            if ( lastAddedLinkedElementAtomicReference.compareAndSet(
                    linkedElement.nextLinkedElement, linkedElement ) ) {

                break;
            }
        }
    }


    /***
     * Recursively looks for the element to remove in the chain of LinkedElement and returns true 
     * if the CAS operation to remove the element was successful. Given the chain A ==> B ==> C 
     * removing B entails joining A with C as follows:  A ==> C
     *
     * @param linkedElement 
     *      LinkedElement
     *      
     * @param nextLinkedElement 
     *      nextLinkedElement of linkedElement
     *      
     * @param objectToRemove 
     *      Object to remove
     */
    private boolean removeObject(
            LinkedElement<E> linkedElement, LinkedElement<E> nextLinkedElement, E objectToRemove ) {

        if ( nextLinkedElement == null ) {

            throw new RuntimeException( "Cannot find element to remove" );
        }

        LinkedElement<E> nextNextLinkedElement = nextLinkedElement.nextLinkedElement;

        if ( nextLinkedElement.object.equals( objectToRemove ) ) {

            return nextLinkedElementUpdater.compareAndSet(
                    linkedElement, linkedElement.nextLinkedElement, nextNextLinkedElement );
        }
        else {

            return removeObject( nextLinkedElement, nextNextLinkedElement, objectToRemove );
        }
    }


    /**
     * This method is called to populate the cloned copy of the LinkedElement in 
     * lastAddedLinkedElementAtomicReference so that all LinkedElements in the chain have the 
     * previousLinkedElement populated.  The Last element in the chain is returned.  The last 
     * element in the chain is the first element that was added to ConcurrentLinkedList.
     *
     * @param linkedElementIn 
     *      The linkedElement to populate its chain of LinkedElements with the previousLinkedElement
     *
     * @return 
     *      the last element in the chain.
     */
    private LinkedElement<E> populatePreviousLinks(
            LinkedElement<E> linkedElementIn ) {

        LinkedElement<E> linkedElement = linkedElementIn;
        LinkedElement<E> nextLinkedElement;

        while ( ( nextLinkedElement = linkedElement.nextLinkedElement ) != null ) {

            nextLinkedElement.previousLinkedElement = linkedElement;
            linkedElement = nextLinkedElement;
        }

        return linkedElement;
    }


    /**
     * Uses CAS to remove the element.  The remove method will be continuously executed until the 
     * remove succeeds.
     *
     * @param objectToRemove
     *      Object to remove
     */
    public void remove( E objectToRemove ){

        while ( true ){

            LinkedElement<E> lastAddedLinkedElement = lastAddedLinkedElementAtomicReference.get();

            if ( lastAddedLinkedElement == null ){

                throw new RuntimeException( "Cannot find element to remove" );
            }

            LinkedElement<E> nextLinkedElement = lastAddedLinkedElement.nextLinkedElement;

            // If lastAddedLinkedElement contains the object set it to reference the next element 
            // in the chain instead.
            if ( lastAddedLinkedElement.object.equals( objectToRemove ) ){

                lastAddedLinkedElementAtomicReference.set( nextLinkedElement );
                break;
            }
            else {

                // recursively look for the object to remove.  If the CAS operation fails try the 
                // whole remove operation again
                if ( removeObject( lastAddedLinkedElement, nextLinkedElement, objectToRemove ) ) {

                    break;
                }
            }
        }
    }


    @Override
    public SnapshotIterator<E> getSnapshotIterator() {

        LinkedElement<E> linkedElement = lastAddedLinkedElementAtomicReference.get();

        try {
            // clone the LinkedElement we wish to create the iterator for
            LinkedElement<E> clonedLinkedElement = ( LinkedElement<E> )linkedElement.clone();

            // look through the chain of LinkedElements and populate the previousLinkedElement 
            // fields. Return the last LinkedElement in the chain. The last LinkedElement is the 
            // first element that was added
            LinkedElement<E> lastLinkedElement = populatePreviousLinks( clonedLinkedElement );

            // Create the iterator
            SnapshotIterator<E> snapshotIterator = new SnapshotIteratorImpl<E>( lastLinkedElement );
            return snapshotIterator;
        }
        catch ( CloneNotSupportedException e ) {

            throw new RuntimeException( e );
        }
    }
}
