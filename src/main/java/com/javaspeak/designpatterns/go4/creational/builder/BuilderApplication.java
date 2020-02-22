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
 * Text book description:
 * <ul>
 *     "Builder: Separates object construction from its representation. Separate the construction 
 *     of a complex object from its representation so that the same construction processes can 
 *     create different representations."
 * </ul>
 * This application uses a buildManager which calls constructShape(..) on different builders to 
 * construct different shapes. The class Shape is used to encapsulate shapes.   SquareBuilder and 
 * TriangleBuilder are used to populate Shape with the correct values for a Square and Triangle 
 * respectively.
 * <p>
 * The constructShape(..) method calls several methods on the builders to build a shape.  The 
 * constructShape(..) method of the buildManager calls the builder methods in the correct order:
 * <pre>
 *     shapeBuilder.setName();
 *     shapeBuilder.setPaintingLevel();
 *     shapeBuilder.buildPoints();
 *     shapeBuilder.translateCoordinates();
 * </pre> 
 * The name is the name of the shape, e.g. triangle.
 * <p> 
 * The paintinglevel is the order to paint the shape. For example any shape with level 0 will be 
 * painted before any shape with level 1.
 * <p>
 * shapeBuilder.buildPoints() builds the points for the shape.
 * <p> 
 * translateCoordinates() translates the points. e.g. it can move a shape both vertically and 
 * horizontally.
 * <p>
 * Once the Shape has been built it can be retrieved from the builder using getShape()
 * 
 * @author John Dickerson - 22 Feb 2020
 */
public class BuilderApplication {

    /**
     * Constructs the Shapes using the SquareBuilder and TriangleBuilder and then merges their 
     * coordinates together into a points array in BuildManager and then finally paints the merged 
     * points.
     */
    public void render() {

        BuildManager buildManager = new BuildManager();
        buildManager.constructShape( new SquareBuilder() );
        buildManager.constructShape( new TriangleBuilder() );
        buildManager.mergeCoordinates();
        buildManager.paint();
    }

    public static void main( String[] args ) {

        BuilderApplication application = new BuilderApplication();
        application.render();
    }
}
