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
 * This abstract class provides instantiates a Shape class and provides an implementation for the 
 * getShape() method.  It has several abstract methods that need to be implemented by builders 
 * extending ShapeBuilder.
 *
 * @author John Dickerson - 22 Feb 2020
 */
public abstract class ShapeBuilder {

    protected Shape shape = new Shape();

    /**
     * Implementing class need to populate the points array in the Shape class
     */
    public abstract void buildPoints();


    /**
     *  Implementing class need to specify the paintingLevel in the Shape class. The paintingLevel 
     *  specifies what order the shapes need to be painted in.  "0" means painted first while larger 
     *  numbers will be printed next.
     */
    public abstract void setPaintingLevel();


    /**
     * Implementing class need to specify the name of the shape. For example a TriangleBuilder 
     * should name the shape a Triangle
     */
    public abstract void setName();


    /**
     * Implementing classes can provide an implementation that translates the points. For example a 
     * translation of (1,2) moves each point down by one and to the right by 2.
     */
    public abstract void translateCoordinates();


    /**
     * Returns a reference to the shape
     *
     * @return 
     *      the shape
     */
    public Shape getShape() {

        return this.shape;
    }
}
