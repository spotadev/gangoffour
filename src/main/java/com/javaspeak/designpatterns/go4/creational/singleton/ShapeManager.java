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
package com.javaspeak.designpatterns.go4.creational.singleton;

/**
 * This class is a singleton. It has a private constructor so it cannot be instantiated directly 
 * by other classes.  Instead it has a static block which initializes the instance which can then 
 * be retrieved using a static getInstance() method.
 * <p>
 * Once the instance has been retrieved the buildSquare() method can be called on the instance.
 *
 * @author John Dickerson - 24 Feb 2020
 */
public class ShapeManager {

    private final static ShapeManager instance;

    static {
        // static block used for initialization
        instance = new ShapeManager();
    }

    /**
     * Private constructor
     */
    private ShapeManager() {

    }


    /**
     * This method provides the only access to an instance of ShapeManager
     *
     * @return instance of ShapeManager
     */
    public static ShapeManager getInstance() {

        return instance;
    }


    /**
     * Instance method
     *
     * @return
     */
    public Square buildSquare() {

        return new Square();
    }
}
