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
 * This class is the adapter. We are providing a wrapper around Shape so that when we call draw() 
 * internally we are calling shape.drawSquare()
 *
 * @author John Dickerson - 24 Feb 2020
 *
 */
public class ShapeAdapter implements Square {

    private Shape shape;

    /**
     * Constructor that wraps the Shape
     *
     * @param shape
     */
    public ShapeAdapter( Shape shape ) {

        this.shape = shape;
    }


    @Override
    public void draw() {

        // The draw() method belongs to the Application API. It wraps the third party drawSquare() 
        // method.
        shape.drawSquare();
    }
}
