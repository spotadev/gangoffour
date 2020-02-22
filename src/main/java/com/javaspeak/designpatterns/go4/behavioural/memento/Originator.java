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
package com.javaspeak.designpatterns.go4.behavioural.memento;


/**
 * The Originator is the class that needs having it state backed up or restored (DocumentImpl).
 * <p>
 * Every time the Documents text is saved the Caretaker (ApplicationMemento) calls getMemento() on 
 * the Document to get a snapshot of its state in the form of a DocumentMemento. The 
 * DocumentMemento is placed on the end of a Deque (LIFO queue).  Every time a text operation needs 
 * to be undone, the Caretaker retrieves a DocumentMemento from the end of the Deque (LIFO queue)
 * and calls the restoreFromMemento(..) method on the Originator (DocumentImpl) so that the Document 
 * can roll its state back to how it was last time it saved.
 *
 * @author John Dickerson - 22 Feb 2020
 */
public interface Originator {

    /**
     * Asks the Originator (DocumentImpl) for a snapshot of its current state encapsulated in a 
     * Memento (DocumentMemento).
     *
     * @return Memento (DocumentMemento)
     */
    public Memento getMemento();


    /**
     * Asks the Originator (DocumentImpl) to roll back its state to the same state as specified in 
     * the Memento (DocumentMemento)
     *
     * @param memento 
     *      The Memento holding a copy of the state that needs to be set in the Originator 
     *      (DocumentImpl)
     */
    public void restoreFromMemento( Memento memento );
}
