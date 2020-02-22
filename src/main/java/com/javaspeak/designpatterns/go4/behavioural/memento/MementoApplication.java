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

import java.util.Deque;
import java.util.LinkedList;


/**
 * Text book description:
 * <ul>
 * Memento: Capture and restore an object's internal state. Without violating encapsulation, 
 * capture and externalize an object’s internal state so that the object can be restored to this 
 * state later.
 * </ul>
 * This example uses the Memento pattern for undo operations. In the Memento pattern there is a 
 * Caretaker, Originator and Memento.
 * <p>
 * The Originator is the class that has state that needs to be rolled back  to the previous version.   
 * The Caretaker manages the backup and restoration  of state to the Originator.  The Caretaker asks 
 * the Originator for a  Memento object that holds a snapshot of its current state. The Caretaker  
 * then adds this to a Deque (LIFO queue) it is managing.  Later on an undo operation involves 
 * taking the last Memento put on the LIFO queue and passing  it to the Originator so that the 
 * Originator has the information to roll back  its state to the last saved version.
 * <p>
 * In this example we are modelling the saving operation of a text editor.  Every time  the document 
 * is saved the Caretaker (ApplicationMemento) asks the  Originator (DocumentImpl) for a 
 * DocumentMemento which it adds to a momentoDeque (LIFO queue).  After saving 3 times and printing 
 * the saved text  to the console an undo operation is called two times restoreFromMemento()). 
 * <p>
 * After each undo operation the document text is printed to the console so you can see that the 
 * multiple undo has worked.
 *
 * @author John Dickerson - 22 Feb 2020
 */
public class MementoApplication implements Caretaker {

    private Document document = new DocumentImpl();
    private Deque<Memento> momentoDeque = new LinkedList<Memento>();


    @Override
    public void saveMemento( Memento memento ) {

        momentoDeque.offerLast( memento );
    }


    @Override
    public void restoreFromMemento() {

        momentoDeque.removeLast();
        Memento lastSavedMemento = momentoDeque.peekLast();
        document.restoreFromMemento( lastSavedMemento );
    }


    /**
     * Runs the example application.  This application is modelling a the saving operation of a 
     * text application. Note that the document has: font family, font size and document text 
     * properties but the DocumentMemento only saves the document text state.  This is because we 
     * only want to undo text edits and not change of font size or font family edits.
     * <p>
     * Every time we call saveDocumentText(..) on the Document we also call the saveMemento(..) 
     * method to save the documentText in a DocumentMemento object and place it at the end of a 
     * deque (LIFO queue).
     * <p>
     * Every time we ant to undo a text operation we remove the last DocumentMemento off the end of 
     * the Deque and read the last DocumentMemento still remaining on the the end of the Deque.  We 
     * then use this DocumentMemento to roll back the state of the Document.
     */
    public void runExample() {

        document.saveFontFamily( "arial" );
        document.saveFontSize( 12 );
        document.saveDocumentText( "Hello World!" );
        saveMemento( document.getMemento() );
        document.saveDocumentText( document.getDocumentText() + " Saving a Second Time." );
        saveMemento( document.getMemento() );
        document.saveDocumentText( document.getDocumentText() + " Saving a Third Time." );
        saveMemento( document.getMemento() );
        System.out.println( "===============================================" );
        System.out.println( document.getDocumentText() );
        System.out.println( "===============================================" );
        restoreFromMemento();
        System.out.println( document.getDocumentText() );
        System.out.println( "===============================================" );
        restoreFromMemento();
        System.out.println( document.getDocumentText() );
        System.out.println( "===============================================" );
    }


    public static void main( String[] args ) {

        MementoApplication mementoApplication = new MementoApplication();
        mementoApplication.runExample();
    }
}
