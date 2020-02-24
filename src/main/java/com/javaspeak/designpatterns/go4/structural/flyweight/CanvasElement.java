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
package com.javaspeak.designpatterns.go4.structural.flyweight;


/**
 * @author John Dickerson - 23 Feb 2020
 */
/**
 * References Shape. Shape is a flyweight object which can be used by many CanvasElement instances.  
 * The implementation for Shape encapsulates the data required to render the underlying shape.  
 * Shape does not specify the coordinates of the Shape on the Canvas as different CanvasElements 
 * are likely to position the shapes in different locations on the Canvas.  Instead CanvasElement 
 * defines unique data such as the location of the Shape on the Canvas.
 * <p>
 * The Shape is integral to the flyweight pattern. Its data has been refactored out of CanvasElement 
 * into the Shape implementation as it is identical data required by many instances.
 *
 * @author John Dickerson - 23 Feb 2020
 */
public class CanvasElement {

    private Shape shape;
    private int xcoordinate;
    private int ycoordinate;

    /**
     * Constructor
     *
     * @param shape  
     *      The flyweight instance to reference
     *
     * @param xcoordinate 
     *      The X location of the Shape on the canvas
     *
     * @param ycoordinate 
     *      The Y location of the Shape on the canvas
     */
    public CanvasElement( Shape shape, int xcoordinate, int ycoordinate ) {

        this.shape = shape;
        this.xcoordinate = xcoordinate;
        this.ycoordinate = ycoordinate;
    }


    public Shape getShape() {

        return shape;
    }


    public int getXcoordinate() {

        return xcoordinate;
    }


    public int getYcoordinate() {

        return ycoordinate;
    }
}
