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
package com.javaspeak.designpatterns.go4.structural.adapter;


/**
 * Text book description:
 * <ul>
 *     Adapter: Match interfaces of different classes.  Convert the interface of a class into 
 *     another interface clients expect. Adapter lets classes work together that couldn’t otherwise 
 *     because of incompatible interfaces.
 * </ul>
 * An Adapter is used to provide a wrapper to a third party class so that it can be called by the 
 * Application.
 * <p>
 * The Application may expect to call a certain method of an interface which is part of its own API.  
 * However we wish to call a method of some other third party API.
 * <p>
 * What we do is we wrap the third party class in an adapter that implements our application API. 
 * When we call the application API method it internally calls the third party implementation.
 * <p>
 * For example imagine the Application client code wishes to call the draw() method on a Square.  
 * Square is part of the application API.
 * <p>
 * We create a ShapeAdapter to wrap ShapeImpl which is part of a third party implementation.
 * <p>
 * When we call draw() on the ShapeAdapter it internally calls drawSquare() on the ShapeImpl class.
 * <p>
 * We have adapted the share.drawSquare() method so that it is executed when we call our application 
 * API square.draw() method.
 * 
 * @author John Dickerson - 22 Feb 2020
 */
public class AdapterApplication {

    /**
     * In this method we create an adapter for ShapeImpl. When we call square.draw() it internally 
     * calls shape.drawSquare()
     */
    public void callClientMethod() {

        Square square = new ShapeAdapter( new ShapeImpl() );
        square.draw();
    }


    public static void main( String[] args ) {

        AdapterApplication application = new AdapterApplication();
        application.callClientMethod();
    }
}
