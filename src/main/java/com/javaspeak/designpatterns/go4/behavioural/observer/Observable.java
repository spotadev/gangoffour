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
package com.javaspeak.designpatterns.go4.behavioural.observer;

/**
 * The class which is having its state observed implements this interface.
 * <p>
 * When a certain event happens the Observable will notify all its subscribed observers that the 
 * event has occurred.
 *
 * @author John Dickerson - 22 Feb 2020
 */
public interface Observable {

    /**
     * Add a subscribed observer to its list of observers.  The subscribed observers can be said 
     * from that point in time to be listening to ObservableEvents.
     *
     * @param observer 
     *      The observer which has subscribed to the ObservableEvents
     */
    public void addObserver( Observer observer );


    /**
     * The Observable calls this method to inform all its subscribed observers that an 
     * ObservableEvent has occurred.
     *
     * @param observableEvent 
     *      The ObservableEvent to inform all its subscribed observers that it has occurred. 
     *      Internally the notifyObservers(..) method loops through all its subscribed observers 
     *      and calls the receiveObservableEvent(..) method on each of them. Each of the subscribed
     *      observers in turn calls the getMessage() method on the ObservableEvent they received and 
     *      prints the message to the console.
     */
    public void notifyObservers( ObservableEvent observableEvent );
}
