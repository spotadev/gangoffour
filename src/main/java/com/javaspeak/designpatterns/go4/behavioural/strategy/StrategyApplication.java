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
package com.javaspeak.designpatterns.go4.behavioural.strategy;

/**
 * Text book description:
 * <ul>
 *     Strategy: Encapsulates an algorithm inside a class. Define a family of algorithms, 
 *     encapsulate each one, and make them interchangeable.  Strategy lets the algorithm vary 
 *     independently from clients that use it.
 * </ul>
 * The Strategy Pattern allows a strategy for doing something to be swapped  with another Strategy 
 * at runtime.
 * <p>
 * In this example we have a StrategyContext (ApplicationStrategy) where we set the Strategy. We 
 * then call the executeStrategy() which in turn calls the drawShape()  method on the underlying 
 * Strategy.
 * <p>
 * In this way, when we have a TriangleStrategy set we end up drawing a Triangle as a shape and 
 * when we have a SquareStrategy set we draw a Triangle.
 * 
 * @author John Dickerson - 22 Feb 2020
 */
public class StrategyApplication implements StrategyContext {

    private Strategy strategy;

    @Override
    public void setStrategy( Strategy strategy ) {

        this.strategy = strategy;
    }


    @Override
    public void executeStrategy() {

        strategy.drawShape();
    }


    /**
     * Set a SquareStrategy and call the drawShape() method which in turn draws a Square.  Then 
     * set a TriangleStrategy which calls the drawShape() method which in turn draws a Triangle.
     */
    public void runExample() {

        setStrategy( new SquareStrategy() );
        executeStrategy();
        setStrategy( new TriangleStrategy() );
        executeStrategy();
    }


    public static void main( String args[] ) {

        StrategyApplication application = new StrategyApplication();
        application.runExample();
    }
}
