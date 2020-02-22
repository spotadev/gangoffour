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
 * BigShapeVisitor is responsible for drawing big Shapes.
 * <p>
 * It make senses to centralise the code for drawing Big Shapes.
 * <p>
 * <p>
 * As time goes on we may want to create new Visitors like "ShinyShapeVisitor" or "3DShapeVisitor".
 * <p>
 * Instead of having to go and edit many different shape classes to produce a different version of 
 * their shape a new Visitor can be created and the code placed in one centralised place.
 * <p>
 * When we call the "accept( ShapeVisitor shapeVisitor )" method on a TriangleVisitable or 
 * SquareVisitable we pass it an implementation of ShapeVisitor such as this BigShapeVisitor.
 * <p>
 * Internal to the accept method of TriangleVisitable or SquareVisitable you will see the visit 
 * method is called on the Visitor (e.g. this class)
 *
 * @author John Dickerson - 22 Feb 2020
 */
public class BigShapeVisitor implements ShapeVisitor {

    @Override
    public String getName() {

        return "BigShapeVisitor";
    }


    @Override
    public void visit( TriangleVisitable triangleVisitable ) {

        StringBuilder shapeSB = new StringBuilder();
        shapeSB.append( "    x    \n" );
        shapeSB.append( "   xxx   \n" );
        shapeSB.append( "  xxxxx  \n" );
        shapeSB.append( " xxxxxxx \n" );
        shapeSB.append( "xxxxxxxxx\n" );
        shapeSB.append( "\nTriangle\n" );

        String characterToBuild = triangleVisitable.getCharacter();

        String shape = shapeSB.toString();
        shape = shape.replaceAll( "x", characterToBuild );

        System.out.println( shape );
    }


    @Override
    public void visit( SquareVisitable squareVisitable ) {

        StringBuilder shapeSB = new StringBuilder();
        shapeSB.append( "xxxxxxxx\n" );
        shapeSB.append( "xxxxxxxx\n" );
        shapeSB.append( "xxxxxxxx\n" );
        shapeSB.append( "xxxxxxxx\n" );
        shapeSB.append( "xxxxxxxx\n" );
        shapeSB.append( "\n" );
        shapeSB.append( squareVisitable.getTitle() ).append( "\n" );

        System.out.println( shapeSB.toString() );
    }
}
