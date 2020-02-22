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
 * This builder configures the Shape class in the parent ShapeBuilder class
 * to model a Triangle.
 *
 * @author John Dickerson - 22 Feb 2020
 */
public class TriangleBuilder extends ShapeBuilder {

    @Override
    public void setName() {

        this.shape.name = "Triangle";
    }


    @Override
    public void buildPoints() {

        //         1
        //       1   1
        //     1       1
        //   1 1 1 1 1 1 1

        this.shape.points = new int[4][7];
        this.shape.points[0][3] = 1;
        this.shape.points[1][2] = 1;
        this.shape.points[1][4] = 1;
        this.shape.points[2][1] = 1;
        this.shape.points[2][5] = 1;
        this.shape.points[3][0] = 1;
        this.shape.points[3][1] = 1;
        this.shape.points[3][2] = 1;
        this.shape.points[3][3] = 1;
        this.shape.points[3][4] = 1;
        this.shape.points[3][5] = 1;
        this.shape.points[3][6] = 1;
    }


    @Override
    public void setPaintingLevel() {

        shape.paintLevel = 2;
    }


    @Override
    public void translateCoordinates() {

        // translate (4,4)
        int xTranslate = 2;
        int yTranslate = 1;

        int[][] translatedPoints =
                new int[this.shape.points.length + yTranslate][this.shape.points[0].length
                        + xTranslate];

        for ( int y = 0; y < this.shape.points.length; y++ ) {

            for ( int x = 0; x < this.shape.points[y].length; x++ ) {

                translatedPoints[y + yTranslate][x + xTranslate] =
                        this.shape.points[y][x];
            }
        }

        this.shape.points = translatedPoints;
    }
}
