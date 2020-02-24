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

import java.util.ArrayList;
import java.util.List;

/**
 * CanvasElements are added to this canvas and then rendered to System.out
 *
 * @author John Dickerson - 23 Feb 2020
 */
public class CanvasImpl implements Canvas {

    private List<CanvasElement> canvasElements = new ArrayList<CanvasElement>();

    /**
     * Works out the dimension of the Canvas required to accomodate all the Canvas Elements
     *
     * @param canvasElements  
     *      CanvasElements which will be added to the Canvas
     *
     * @return 
     *      the Dimension of the Canvas
     */
    private Dimension getCanvasDimension( List<CanvasElement> canvasElements ) {

        int height = 0;
        int width = 0;

        for ( CanvasElement canvasElement : canvasElements ) {

            int shapeLength =
                    canvasElement.getShape().points.length +
                            canvasElement.getYcoordinate();

            if ( shapeLength > height ) {

                height = shapeLength;
            }

            int shapeWidth =
                    canvasElement.getShape().points[0].length +
                            canvasElement.getXcoordinate();

            if ( shapeWidth > width ) {

                width = shapeWidth;
            }
        }

        return new Dimension( width, height );
    }


    /**
     * Renders a CanvasElement on the canvas. This involves copying the pixels of the shape onto 
     * the canvasPixels array.
     *
     * @param canvasElement
     * @param canvasPixels
     */
    private void render( CanvasElement canvasElement, int[][] canvasPixels ) {

        int[][] points = canvasElement.getShape().points;

        for ( int y = 0; y < points.length; y++ ) {

            for ( int x = 0; x < points[y].length; x++ ) {

                canvasPixels[y + canvasElement.getYcoordinate()][x + canvasElement
                        .getXcoordinate()] =
                                points[y][x];
            }
        }

    }


    /**
     * Paints the canvas pixels to System.out
     *
     * @param canvasPixels 
     *      The canvas pixels to paint to System.out
     */
    private void paint( int[][] canvasPixels ) {

        for ( int y = 0; y < canvasPixels.length; y++ ) {

            StringBuilder sb = new StringBuilder();

            for ( int x = 0; x < canvasPixels[y].length; x++ ) {

                if ( canvasPixels[y][x] == 1 ) {

                    sb.append( canvasPixels[y][x] );
                }
                else {

                    sb.append( " " );
                }
            }

            System.out.println( sb.toString() );
        }
    }


    @Override
    public void addCanvasElement( CanvasElement canvasElement ) {

        canvasElements.add( canvasElement );
    }


    @Override
    public void render() {

        Dimension canvasDimension = getCanvasDimension( canvasElements );

        int[][] canvasPixels =
                new int[canvasDimension.getHeight()][canvasDimension.getWidth()];

        for ( CanvasElement canvasElement : canvasElements ) {

            render( canvasElement, canvasPixels );
        }

        paint( canvasPixels );
    }
}
