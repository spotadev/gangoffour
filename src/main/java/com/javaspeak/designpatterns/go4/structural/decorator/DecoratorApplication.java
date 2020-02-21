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
package com.javaspeak.designpatterns.go4.structural.decorator;

/**
 * Text book description:
 * <ul>
 *    "Decorator: Add responsibilities to objects dynamically.  Attach additional responsibilities 
 *    to an object dynamically. Decorators provide a flexible alternative to subclassing for 
 *    extending functionality."
 * </ul>
 * The Decorator pattern is useful when some data needs to be transformed several times by 
 * different plugable transformers.
 * <p>
 * A Decorator can transform the data and then call another Decorator it is chained to, to do some 
 * further processing on the data.  When the data has been transformed by all the decorators it 
 * is returned.
 * <p>
 * In our example we have 2 decorators.  One decorator transforms the text to upper case and the 
 * other decorator replaces multiple spaces with one space.
 * <p>
 * Each Decorator (transformer) holds a reference to another Decorator unless it is the last 
 * Decorator in the chain.
 * <p>
 * Note that the code for the structural Decorator pattern is the same as the behavioural Chain 
 * of Responsibility pattern.
 * 
 * @see com.javaspeak.designpatterns.go4.behavioural.chainofresponsibility.ChainOfResponsibilityApplication
 * 
 * @author John Dickerson - 20 February 2020
 */
public class DecoratorApplication {

    private Transformer<String> transformer;

    public void buildDecorators() {

        Transformer<String> removeMultipleSpacesTransformer = new RemoveMultipleSpacesTransformer();
        transformer = new TextCapitaliseTransformer();
        transformer.addDecoration( removeMultipleSpacesTransformer );
    }


    public void transform() {

        String message = "Hello    World!";
        System.out.println( this.transformer.transform( message ) );
    }


    public static void main( String[] args ) {

        DecoratorApplication application = new DecoratorApplication();
        application.buildDecorators();
        application.transform();
    }
}
