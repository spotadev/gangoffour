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
 * Text book description:
 * <ul>
 *     Visitor:  Defines a new operation to a class without change. Represent an operation to be 
 *     performed on the elements of an object structure. Visitor lets you define a new operation 
 *     without changing the classes of the elements on which it operates.
 * </ul>
 * This example uses the Visitor Pattern.
 * <p>
 * The output of running the example looks like:
 * <pre>
 * ============================================
 * SmallShapeVisitor
 * ============================================
 *   T
 *  TTT
 * TTTTT
 * 
 * xxxx
 * xxxx
 * xxxx
 * 
 * ============================================
 * BigShapeVisitor
 * ============================================
 *     T
 *    TTT
 *   TTTTT
 *  TTTTTTT
 * TTTTTTTTT
 * 
 * Triangle
 * 
 * xxxxxxxx
 * xxxxxxxx
 * xxxxxxxx
 * xxxxxxxx
 * xxxxxxxx
 * 
 * Square
 * </pre>
 * <p>
 * There are two Visitors, one is called BigShapeVisitor and the other SmallShapeVisitor.  As 
 * the names imply BigShapeVisitor is responsible for drawing big Shapes and SmallShapeVisitor 
 * is responsible for drawing small shapes.
 * <p>
 * It make senses to centralise the code for drawing Big Shapes in one place and the code for 
 * drawing small shapes in another.
 * <p>
 * As time goes on we may want to create new Visitors like "ShinyShapeVisitor" or "3DShapeVisitor".
 * <p>
 * Instead of having to go and edit many different shape classes to produce a different version of 
 * their shape a new Visitor can be created and the code placed in one centralised place.
 * <p>
 * When we call the accept( ShapeVisitor shapeVisitor ) method on a TriangleVisitable or 
 * SquareVisitable we pass it an implementation of ShapeVisitor. Implementations include 
 * BigShapeVisitor or SmallShapeVisitor. Internal to the accept method of TriangleVisitable or 
 * SquareVisitable you will see the visit method is called on the Visitor passing a reference of this:
 * <pre>
 * // inside TriangleVisitable or SquareVisitable
 * public void accept( ShapeVisitor shapeVisitor ) {
 * 
 *    shapeVisitor.visit( this );
 * } 
 * </pre>
 * In the Visitor you will find overloaded visit methods, one for each Visitable
 * <pre>
 * // inside BigShapeVisitor or SmallShapeVisitor
 * public void visit( TriangleVisitable triangleVisitable ) {
 *  
 *     // ... code goes here to draw the big or small version of a Triangle
 *     // depending on whether this class is a BigShapeVisitor or
 *     // SmallShapeVisitor
 * }
 * 
 * public void visit( SquareVisitable squareVisitable ) {
 *  
 *     // ... code here to draw big or small version of a Square
 *     // depending on whether this class is a BigShapeVisitor or
 *     // SmallShapeVisitor
 * }
 * </pre> 
 * SquareVisitable and TriangleVisitable are Visitables.  These classes may hold information 
 * useful for all Visitors. This information may be different between between the Visitables 
 * as it can be specific to the Visitable itself.  For example the TriangleVisitable has a 
 * method "getCharacter()" which allows the BigShapeVisitor and SmallShapeVisitor to know what 
 * character to draw the triangle with.  Note that SquareVisitable does not have a "getCharacter()" 
 * method but instead has a personalized "getTitle()" method.
 * <p>
 * @author John Dickerson - 22 Feb 2020
 */
public class VisitorApplication {

    private void runExample() {

        ShapeVisitor[] shapeVisitors =
                new ShapeVisitor[] { new SmallShapeVisitor(), new BigShapeVisitor() };

        ShapeVisitable[] shapeVisitables =
                new ShapeVisitable[] { new TriangleVisitable(), new SquareVisitable() };

        for ( ShapeVisitor shapeVisitor : shapeVisitors ) {

            System.out.println( "============================================" );
            System.out.println( shapeVisitor.getName() );
            System.out.println( "============================================" );

            for ( ShapeVisitable shapeVisitable : shapeVisitables ) {

                shapeVisitable.accept( shapeVisitor );
            }
        }
    }


    public static void main( String[] args ) {

        VisitorApplication application = new VisitorApplication();
        application.runExample();
    }
}
