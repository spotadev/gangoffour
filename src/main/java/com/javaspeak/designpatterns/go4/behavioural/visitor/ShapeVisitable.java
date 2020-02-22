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
package com.javaspeak.designpatterns.go4.behavioural.visitor;

/**
 * SquareVisitable and TriangleVisitable implement this class.  The calling code in 
 * ApplicationVisitor calls the accept method on SquareVisitable and TriangleVisitable two times 
 * each. On once occasion it calls passing the SmallShapeVisitor through the accept method and the 
 * second time it passes the BigShapeVisitor.  Both SquareVisitable and TriangleVisitable in turn
 * call the visit method on the Visitor classes, SmallShapeVisitor and BigShapeVisitor.
 * <p>
 * The result is a small triangle is drawn when passing the SmallShapeVisitor into the accept 
 * method of TriangleVisitable and similarly a small square is drawn when passing the  
 * SmallShapeVisitor into the accept method of SquareVisitable.
 * <p>
 * Both the small triangle and small square drawing code is encapsulated in the SmallShapeVisitor 
 * instead of being in both TriangleVisitable and SquareVisitable.  What this means is that the 
 * TriangleVisitable and SquareVisitable code does not need to change if a new style of drawing a
 * triangle and square (such as in 3D) is invented.  The 3D implementation of both a triangle and 
 * square could then be encapsulated in a new Visitor called 3DShapeVisitor.
 * <p>
 * A big triangle is drawn passing the BigShapeVisitor into the the accept method of 
 * TriangleVisitable and similarly a big square is drawn passing the BigShapeVisitor into the accept 
 * method of  SquareVisitable.  Both the big triangle and big square drawing code is encapsulated 
 * in the BigShapeVisitor instead of being in both TriangleVisitable and SquareVisitable. This makes 
 * it easy to maintain code relating to big shapes across all shapes.
 *
 * @author John Dickerson - 22 Feb 2020
 */
public interface ShapeVisitable {

    /**
     * The Calling code, ApplicationVisitor, calls the accept method on TriangleVisitable or 
     * SquareVisitable passing in SmallShapeVisitor or BigShapeVisitor. The accept implementation 
     * will in turn call one of the overloaded visit methods of SmallShapeVisitor or BigShapeVisitor
     *
     * @param shapeVisitor 
     *      The ShapeVisitor, either SmallShapeVisitor or BigShapeVisitor, to call the overloaded 
     *      visit method on, and in so doing draw a shape.
     */
    void accept( ShapeVisitor shapeVisitor );
}
