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
 * Text book description:
 * <ul>
 *     Flyweight: A fine-grained instance used for efficient sharing. Use sharing to support 
 *     large numbers of fine-grained objects efficiently. A flyweight is a shared object that can 
 *     be used in multiple contexts simultaneously. The flyweight acts as an independent object 
 *     in each context — it’s indistinguishable from an instance of the object that’s not shared.
 * </ul>
 * When there are many instances of a class which use the same data across many instances then 
 * that data should be factored out into a read only instance of a class that allows the data to 
 * be shared between many instances.
 * <p>
 * In this example we are drawing shapes on a canvas at different locations. Some of the data for 
 * a given shape is the same.  For example a square looks the same. Other data could be different; 
 * for example the location of a square on the canvas.
 * <p>
 * We have factored out the information about rendering a square or triangle into a flyweight 
 * object which can be referenced by many CanvasElements wishing to draw a square or triangle.  
 * The CanvasElements reference the shape they are interested in and provide unique data such as 
 * the location to draw the shape at.
 * <p>
 * When there are many references to the same flyweight objects this can substantially reduce 
 * memory requirements.
 * <p>
 * @author John Dickerson - 22 Feb 2020
 */
public class FlyweightApplication {

    /**
     * Adds CanvasElements to the canvas and then renders them by printing to System.out. The 
     * adding of the CanvasElements to the canvas involves writing individual pixels from the canvas 
     * Shapes to a multi dimensional array.
     */
    public void drawCanvas() {

        Canvas canvas = new CanvasImpl();
        canvas.addCanvasElement( new CanvasElement( ShapeCache.getSquare(), 0, 0 ) );
        canvas.addCanvasElement( new CanvasElement( ShapeCache.getSquare(), 0, 6 ) );
        canvas.addCanvasElement( new CanvasElement( ShapeCache.getTriangle(), 6, 0 ) );
        canvas.addCanvasElement( new CanvasElement( ShapeCache.getTriangle(), 6, 6 ) );
        canvas.render();
    }


    public static void main( String[] args ) {

        FlyweightApplication application = new FlyweightApplication();
        application.drawCanvas();
    }
}
