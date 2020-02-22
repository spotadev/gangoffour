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

import java.util.ArrayList;
import java.util.List;


/**
 * Text book description:
 * <ul>
 *      Observer: A way of notifying change to a number of classes. Define a one-to-many dependency 
 *      between objects so that when one object changes state, all its dependents are notified and 
 *      updated automatically.
 * </ul>
 * This example uses the Observer pattern.
 * <p>
 * In the Observer pattern there is one Observable and there are many Observers.
 * <p>
 * The idea is that when something specific happens with the Observable all Observers are notified 
 * of this happening.
 * <p>
 * In this example we have a Observable called ObservableImpl which adds three different Observers 
 * to its list of Observers using its addObserver(..) method.  Each of the Observers implements 
 * Observer.
 * <p>
 * ObservableImpl then calls notifyObservers(ObservableEvent e) to inform all subscribed observers 
 * of a new happening.  The happening is encapsulated in a ObservableEventImpl which holds a 
 * messages. The message is "Hello Everyone!".
 * <p>
 * Internally the notifyObservers(..) method loops through all its subscribed Observers and 
 * calls the receiveObservableEvent(ObservableEvent e ) on each of them.
 * <p>
 * Each Observer then retrieves the message from then ObservableEvent and prints it to the console.
 * 
 * @author John Dickerson - 22 Feb 2020
 */
public class ObserverApplication implements Observable {

    List<Observer> observers = new ArrayList<Observer>();

    @Override
    public void addObserver( Observer observer ) {

        observers.add( observer );
    }


    @Override
    public void notifyObservers( ObservableEvent observableEvent ) {

        for ( Observer observer : observers ) {

            observer.receiveObservableEvent( observableEvent );
        }
    }


    public void runExample() {

        // This class is the Observable

        // First we create some Observers
        Observer observerOne = new ObserverImpl( "ObserverOne" );
        Observer observerTwo = new ObserverImpl( "ObserverTwo" );
        Observer observerThree = new ObserverImpl( "ObserverTwo" );

        // Next we subscribe those observers so that they are observing the Observable. "Observing" 
        // in this example means they are waiting for ObservavleEvents. In other words the Observers 
        // are waiting for their receiveObservableEvent(..) method to be called.
        addObserver( observerOne );
        addObserver( observerTwo );
        addObserver( observerThree );

        // The Observable (this class) loops through its sunscribed observers and calls 
        // receiveObservableEvent(..) on each of them. A ObservableEvent is passed to each of the 
        // Observers which has the message, "Hello Everyone!" in it.  The Observers in turn print 
        // the message to the console.
        notifyObservers( new ObservableEventImpl( "Hello Everyone!" ) );
    }


    public static void main( String[] args ) {

        ObserverApplication application = new ObserverApplication();
        application.runExample();
    }
}
