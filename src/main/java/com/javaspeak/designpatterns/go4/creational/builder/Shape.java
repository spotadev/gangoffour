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
package com.javaspeak.designpatterns.go4.creational.builder;


/**
 * The Shape class models different shapes
 *
 * @author John Dickerson - 22 Feb 2020
 */
public class Shape {

    // Uses array of arrays.  For example the following is a square
    //
    //     1111
    //     1001
    //     1001
    //     1111
    //
    // If the above coordinates are translated (4,1) they become:
    //
    //     00000000
    //     00001111
    //     00001001
    //     00001001
    //     00001111
    protected int[][] points;

    // 0 means paint first, larger numbers will be painted next
    protected int paintLevel;

    // Name of shape
    protected String name;
}
