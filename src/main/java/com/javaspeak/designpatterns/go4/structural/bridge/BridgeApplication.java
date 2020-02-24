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
package com.javaspeak.designpatterns.go4.structural.bridge;

/**
 * Text book description:
 * <ul>
 *     Bridge: Separates an object’s interface from its implementation. Decouple an abstraction 
 *     from its implementation so that the two can vary independently.
 * </ul>
 * This application has an abstract class called AbstractShapeBridge which wraps ShapeBuilder so 
 * that calling the buildShape() method of AbstractShapeBridge internally calls the buildShape() 
 * method of the ShapeBuilder.
 * <p>
 * This wrapping allows the implementation of ShapeBuilder, currently TriangleBuilder, to be 
 * readily switched for another implementation such as SquareBuilder.
 * <p>
 * The implementation of the ShapeBuilder is passed through the constructor of AbstractBridge.
 * <p>
 * BridgeImpl extends AbstractBridge and adds its own method, drawShape() to draw the shape.  
 * Internally the drawShape() method makes a call to the buildShape() method in AbstractShapeBridge.
 * <p>
 * This pattern is pretty similar to the Adapter pattern.  Notice some differences though:
 * <ul>
 *     <li>
 *          Adapter is more about wrapping a third party API so it can be used by the application 
 *          API.
 *      </li>
 *     <li>
 *          Bridge is more about having the ability to slot in different implementation.
 *     </li>
 *     <li>
 *          The Bridge has an abstract class that wraps the implementation which is itself extended 
 *          to add extra functionality (e.g. ShapeBridgeImpl.drawShape())
 *     </li>
 *     <li>
 *          The Bridge pattern in this example can be considered to be a combination of the 
 *          Strategy and Template patterns
 *     </li>
 * </ul>
 * @author John Dickerson - 22 Feb 2020
 */
public class BridgeApplication {

    /**
     * Calls drawShape() on the bridge implementation
     */
    public void drawShape() {

        ShapeBridgeImpl shapeBridge = new ShapeBridgeImpl();
        shapeBridge.drawShape();
    }


    /**
     * @param args
     */
    public static void main( String[] args ) {

        BridgeApplication application = new BridgeApplication();
        application.drawShape();
    }
}
