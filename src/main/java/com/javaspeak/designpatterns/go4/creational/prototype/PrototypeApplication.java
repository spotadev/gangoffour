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
package com.javaspeak.designpatterns.go4.creational.prototype;


/**
 * Text book description:
 * <ul>
 *     "Prototype: A fully initialized instance to be copied or cloned. Specify the kinds of 
 *     objects to create using a prototypical instance, and create new objects by copying this 
 *     prototype. "
 * </ul>
 * The prototype factory pattern uses a map of pre-initialized instances where there is one of 
 * each type in the map.
 * <p>
 * When an instance of a certain type is requested the relevant instance is retrieved and cloned.
 * <p> 
 * This pattern is typically used where expensive initialisation in the constructor is present 
 * so it is cheaper to clone the class than do an expensive initialisation every time a new 
 * instance is required.
 * <p>
 * In this example there is a map of different shapes in the PrototypeFactory
 * <p>
 * When a Shape such as a Square is requested using the getShape() method, the appropriate instance 
 * is retrieved from the map and cloned.
 * 
 * @author John Dickerson - 22 Feb 2020
 */
public class PrototypeApplication {

    /**
     * Retrieves a cloned copy of the required Shape from the Prototype Factory
     *
     * @throws CloneNotSupportedException
     */
    public void draw() throws CloneNotSupportedException {

        ProtypeFactory.getShape( ShapeType.SQUARE ).draw();
        ProtypeFactory.getShape( ShapeType.TRIANGLE ).draw();
    }


    public static void main( String[] args ) throws CloneNotSupportedException {

        PrototypeApplication application = new PrototypeApplication();
        application.draw();
    }
}
