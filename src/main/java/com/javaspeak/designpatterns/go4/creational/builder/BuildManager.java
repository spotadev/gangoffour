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

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * BuildManager has a constructShape(..) method which calls the appropriate methods on the 
 * SquareBuilder and TriangleBuilder to populate the Shape instance with values which model a 
 * Square and Triangle respectively.
 * <p>
 * When a shape is constructed it is added to the "shapes" SortedSet.
 * <p>
 * The SortedSet sorts the Shapes by their paintingLevel.  Shapes which are on level 0 will be 
 * painted before Shapes which are on a higher level.
 *
 * @author John Dickerson - 22 Feb 2020
 */
public class BuildManager {

    int[][] points;

    /**
     *  When a shape is constructed it is added to the "shapes" SortedSet.
     * <p>
     * The SortedSet sorts the Shapes by their paintingLevel.  Shapes which are on level 0 will be 
     * painted before Shapes which are on a higher level.
     */
    private SortedSet<Shape> shapes = new TreeSet<Shape>(

            new Comparator<Shape>() {

                public int compare( Shape shape1, Shape shape2 ) {

                    return Integer.valueOf( shape1.paintLevel ).compareTo( shape2.paintLevel );
                }
            } );

    /**
     * Finds the maximum dimension for the different Shape instances in the shapes SortedSet
     *
     * @param shapes 
     *      the shapes to find the maximum dimension for
     *      
     * @return 
     *      max dimension
     */
    private Dimension getMaxDimension( SortedSet<Shape> shapes ) {

        int height = 0;
        int width = 0;

        for ( Shape shape : shapes ) {

            if ( shape.points.length > height ) {

                height = shape.points.length;
            }

            if ( shape.points[0].length > width ) {

                width = shape.points[0].length;
            }
        }

        return new Dimension( width, height );
    }


    /**
     * The constructShape(..) method is responsible for calling the builder methods in the correct 
     * order.  For example a shape cannot have its coordinates translated before it has created its 
     * points.
     *
     * @param shapeBuilder
     */
    public void constructShape( ShapeBuilder shapeBuilder ) {

        shapeBuilder.setName();
        shapeBuilder.setPaintingLevel();
        shapeBuilder.buildPoints();
        shapeBuilder.translateCoordinates();
        shapes.add( shapeBuilder.getShape() );
    }


    /**
     * This method iterates through the shapes and copies their coordinates in to a new points 
     * array.  Note that shapes which are copied after others overwrite previous points.
     */
    public void mergeCoordinates() {

        Dimension dimension = getMaxDimension( shapes );
        points = new int[dimension.getHeight()][dimension.getWidth()];

        for ( Shape shape : shapes ) {

            int[][] shapePoints = shape.points;

            for ( int y = 0; y < shapePoints.length; y++ ) {

                for ( int x = 0; x < shapePoints[y].length; x++ ) {

                    if ( shapePoints[y][x] == 1 ) {

                        points[y][x] = shapePoints[y][x];
                    }
                }
            }
        }
    }


    /**
     * Paints the merged coordinates
     */
    public void paint() {

        for ( int i = 0; i < points.length; i++ ) {

            StringBuilder sb = new StringBuilder();

            for ( int y = 0; y < points[i].length; y++ ) {

                if ( points[i][y] == 1 ) {

                    sb.append( points[i][y] );
                }
                else {

                    sb.append( " " );
                }
            }

            System.out.println( sb.toString() );
        }
    }
}
