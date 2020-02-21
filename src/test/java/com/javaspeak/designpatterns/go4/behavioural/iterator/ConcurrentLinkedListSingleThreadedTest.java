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

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Text book description:
 * <ul>
 *     Iterator: Sequentially access the elements of a collection. Provide a way to access the 
 *     elements of an aggregate object sequentially without exposing its underlying representation.
 * </ul>
 * An Iterator has methods like hasNext() and next() which allows the underlying collection to 
 * be accessed:
 *
 * while ( snapshotIterator.hasNext() ){
 *
 *    value= snapshotIterator.next();
 * }
 *
 * This example shows an implementation of a concurrent LinkedList which uses Compare And Swap 
 * operations to add and remove elements.  CAS operations make use of CAS features of hardware 
 * to update fields. 
 *
 * The principle behind a CAS operation is that the value of a field is retrieved; an operation 
 * is then performed to get a new value for the field; but before updating the old value with the 
 * new value, a CAS operation is made to check whether the old value is still the same. If the 
 * old value is the same, it is replaced with the new value.  If the old value is not the same 
 * it means that it has been updated by another thread during the duration of the processing. In 
 * other words the old value has become stale as the processing could not be completed before 
 * the old value was updated by another thread.  The CAS compareAndSwap() method call will return 
 * false and the calling code can attempt to perform the operation again until it succeeds.
 *
 * A snapshot iterator is returned.  It is a snapshot of the data since when the Iterator was 
 * created.  While iterating through the elements other threads may add or remove elements in the 
 * List and the additions or removals will not be reflected in the iterator - hence the name 
 * "snapshot".
 * 
 * This test, tests add, remove and the usage of an iterator for the ConcurrentLinkedList in a single 
 * threaded environment.
 * 
 * @author John Dickerson - 21 Feb 2020
 */
public class ConcurrentLinkedListSingleThreadedTest {

    @Test
    public void testIterator() {

        // the values to add
        String[] valuesToAdd = { "Hello", "World!", "How", "bling", "blah", "is", "it", "doing?" };
        ConcurrentLinkedList<String> linkedList = new ConcurrentLinkedList<String>();

        for ( String value : valuesToAdd ) {

            // add the values to the list
            linkedList.add( value );
        }

        // remove some values from the list
        linkedList.remove( "bling" );
        linkedList.remove( "blah" );

        // Create a snapshot iterator
        SnapshotIterator<String> snapshotIterator = linkedList.getSnapshotIterator();

        // Add some further values to the list. These should not be present
        // in the iterator as it is snapshot iterator and has been created
        // already.
        linkedList.add( "Wow" );

        // Remove some further values from the list. These should not be
        // removed from the iterator as it is a snapshot iterator and has been
        // created already.
        linkedList.remove( "Hello" );

        int i = 0;
        String actualValue;

        // the expected values to be returned by the iterator (note that bling
        // and blah) have been removed from the list
        String[] expectedValues = { "Hello", "World!", "How", "is", "it", "doing?" };

        while ( snapshotIterator.hasNext() ) {

            actualValue = snapshotIterator.next();
            System.out.println( actualValue );
            Assert.assertEquals( actualValue, expectedValues[i] );
            i++;
        }
    }
}
