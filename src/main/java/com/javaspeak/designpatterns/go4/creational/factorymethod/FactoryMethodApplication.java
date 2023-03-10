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
package com.javaspeak.designpatterns.go4.creational.factorymethod;


/**
 * Text book description:
 * <ul>
 *     "Factory Method: Creates an instance of several derived classes. Define an interface for 
 *     creating an object, but let subclasses decide which class to instantiate. Factory Method 
 *     lets a class defer instantiation to subclasses."
 * </ul>
 * Factory Methods in this example are createSquare() and createTriangle():
 * <pre>
 *      Drawing drawing = new Drawing();
 *      drawing.createSquare().draw();
 *      drawing.createTriangle().draw();
 * </pre>
 * createSquare() creates a Square instance and createTriangle() creates a Triangle instance.  
 * Both Square and Triangle implement Shape which has a draw() method.
 * <p>
 * @author John Dickerson - 22 Feb 2020
 */
public class FactoryMethodApplication {

    /**
     * Draws Shapes
     */
    public void draw() {

        Drawing drawing = new Drawing();
        drawing.createSquare().draw();
        drawing.createTriangle().draw();
    }


    public static void main( String[] args ) {

        FactoryMethodApplication application = new FactoryMethodApplication();
        application.draw();
    }
}
