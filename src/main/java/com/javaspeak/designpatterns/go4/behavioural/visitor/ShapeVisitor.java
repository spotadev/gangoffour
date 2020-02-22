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
 *
 * Both BigShapeVisitor and SmallShapeVisitor implement this interface.
 * <p>
 * BigShapeVisitor encapsulates the code for drawing big triangles and big squares while 
 * SmallShapeVisitor encapsulates the code for drawing small triangles and small square.
 * <p>
 * The visitors, BigShapeVisitor and SmallShapeVisitor make it easier to maintain code relating to 
 * big and small shapes.
 * <p>
 * Calling accept on a TriangleVisitable or SquareVisitable delegates the call to the visitor passed 
 * in as a method argument to the accept method. The visit method is called on the ShapeVisitor, 
 * BigShapeVisitor or SmallShapeVisitor.
 * <p>
 * Notice that the visit methods are overloaded and once takes in a TriangleVisitable and the other 
 * a SquareVisitable.
 *
 * @author John Dickerson - 22 Feb 2020
 */
public interface ShapeVisitor {

    /**
     * Gets the name of the ShapeVisitor, e.g. SmallShapeVisitor or BigShapeVisitor
     *
     * @return 
     *  name of the ShapeVisitor
     */
    String getName();


    /**
     * Calling accept on a TriangleVisitable delegates the call to the visitor passed in as a
     * method argument to the accept method. The visit method is called on the ShapeVisitor: 
     * BigShapeVisitor or SmallShapeVisitor.  BigShapeVisitor and  SmallShapeVisitor implement this
     * ShapeVisitor interface and do the actual drawing of the triangle.
     *
     * @param triangleVisitable 
     *      The TriangleVisitable to retrieve triangle properties from such as the character to 
     *      use to draw the triangle with.
     */
    void visit( TriangleVisitable triangleVisitable );


    /**
     * Calling accept on a SquareVisitable delegates the call to the visitor passed in as a method 
     * argument to the accept method. The visit method is called on the ShapeVisitor, 
     * BigShapeVisitor or SmallShapeVisitor.  BigShapeVisitor and  SmallShapeVisitor implement this
     * ShapeVisitor interface and do the actual drawing of the square.
     *
     * @param squareVisitable 
     *      The SquareVisitable to retrieve triangle properties from such as the character to use 
     *      to draw the triangle with.
     */
    void visit( SquareVisitable squareVisitable );
}
