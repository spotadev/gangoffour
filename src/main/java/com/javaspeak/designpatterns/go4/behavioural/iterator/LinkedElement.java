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
public class LinkedElement<E> implements Cloneable {

    // This is not populated by add or remove method. It is used for post processing such as when 
    // creating an SnapshotIterator
    LinkedElement<E> previousLinkedElement;

    // In ConcurrentLinkedList there is a an AtomicReferenceFieldUpdater which is used to update 
    // this volatile field using CAS
    volatile LinkedElement<E> nextLinkedElement;

    // The object
    E object;


    public LinkedElement( E object ) {

        this.object = object;
    }


    @Override
    protected LinkedElement<E> clone() throws CloneNotSupportedException {

        // This method is used to clone a chain of LinkedElement to create a Snapshot Iterator
        LinkedElement<E> clonedLinkedElement = new LinkedElement<E>( object );

        if ( nextLinkedElement != null ) {

            clonedLinkedElement.nextLinkedElement = nextLinkedElement.clone();
        }

        return clonedLinkedElement;
    }
}
