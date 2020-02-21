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
 * This class is a Decorator. It holds a reference to another decorator. The decorators implement 
 * Transformer.  The reference to another decorator can be added by calling 
 * addDecoration( Transformer<String> transformer).
 * <p>
 * After calling transform on some input data it calls transform on the decorator it references.
 * <p>
 * In this way a chain of decorators (transformers) is created, the last transformer in the chain 
 * holding no reference to a decorator.
 * 
 * @author John Dickerson - 20 February 2020
 */
public class RemoveMultipleSpacesTransformer implements Transformer<String> {

    private Transformer<String> transformer;

    @Override
    public void addDecoration( Transformer<String> transformer ) {

        this.transformer = transformer;
    }


    @Override
    public String transform( String input ) {

        String output = input.replaceAll( "\\s+", " " );

        if ( this.transformer != null ) {

            return this.transform( output );
        }

        return output;
    }
}
