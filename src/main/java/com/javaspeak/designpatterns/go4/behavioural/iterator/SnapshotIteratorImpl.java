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


/**
 * @author John Dickerson - 21 Feb 2020
 */
public class SnapshotIteratorImpl<E> implements SnapshotIterator<E> {

    private LinkedElement<E> linkedElement;

    /**
     * Constructor
     * <p>
     * The LinkedElement passed through this constructor is the first LinkedElement that was added
     * by a user. It is also the element that is at the end of the chain of LinkedElements.
     * <p>
     * As new elements are added at the beginning of the chain of LinkedElements, this last 
     * LinkedElement in the chain represents the first element that was added to the 
     * ConcurrentLinkedList.
     * <p>
     * To navigate through the linkedElements the field previousLinkedElement is used in the 
     * LinkedElements.
     *
     * @param last element in the linkedElement chain
     */
    public SnapshotIteratorImpl( LinkedElement<E> linkedElement ) {

        this.linkedElement = linkedElement;
    }


    @Override
    public boolean hasNext() {

        if ( linkedElement != null ) {
            return true;
        }
        return false;
    }


    @Override
    public E next() {

        // as the
        E objectToReturn;

        if ( linkedElement != null ) {

            objectToReturn = linkedElement.object;
            linkedElement = linkedElement.previousLinkedElement;
            return objectToReturn;
        }

        return null;
    }
}
