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
package com.javaspeak.designpatterns.go4.creational.abstractfactory;

import com.javaspeak.designpatterns.go4.creational.abstractfactory.ShapeSelector.ShapeType;

/**
 * Text book description:
 * <ul>
 *     "Abstract Factory:  Creates an instance of several families of classes. Provide an 
 *     interface for creating families of related or dependent objects without specifying 
 *     their concrete classes."
 * </ul>
 * The idea behind the AbstractFactory pattern is that the implementation of some functionality 
 * can be changed by plugging in a different Factory.  
 * <p>
 * None of the calling code in the application needs to change to accommodate a different factory 
 * apart from the code that decides which Factory to use.
 * <p>
 * In the code example the application retrieves a factory; then from the factory it gets a 
 * shape which it then draws.  If the SquareFactory is plugged in,  then a Square is drawn.  
 * If the TriangleFactory is plugged in a Triangle is drawn.
 * <p>
 * The calling code in the application looks like:
 * <pre>
 *   public void drawShapes(){
 * 
 *         ShapeSelector.getShapeFactory( ShapeType.SQUARE ).getShape().drawShape();
 *         ShapeSelector.getShapeFactory( ShapeType.TRIANGLE ).getShape().drawShape();
 *   }
 * </pre>
 * Notice that a ShapeSelector is used to return SquareFactory or a TriangleFactory.  Notice that 
 * getShape() is then called on the factory which returns a Square or Triangle depending on 
 * whether the factory is a SquareFactory or a TriangleFactory. Finally drawShape() is called.  
 * If the shape is a Square a Square is drawn while if the shape is a Triangle a Triangle is drawn:
 * <pre>
 * X X X X
 * X     X
 * X     X
 * X X X X
 * 
 * 
 *     x   
 *    x x  
 *   x   x 
 *  x     x
 * x x x x x
 *</pre>
 * 
 * @author John Dickerson - 22 Feb 2020
 */
public class AbstractFactoryApplication {

    public void drawShapes() {

        ShapeSelector.getShapeFactory( ShapeType.SQUARE ).getShape().drawShape();
        ShapeSelector.getShapeFactory( ShapeType.TRIANGLE ).getShape().drawShape();
    }

    public static void main( String[] args ) {

        AbstractFactoryApplication application = new AbstractFactoryApplication();
        application.drawShapes();
    }
}
