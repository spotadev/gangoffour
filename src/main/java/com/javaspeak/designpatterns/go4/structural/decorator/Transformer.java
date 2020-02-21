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
 * This interface is central to this example's Decorator pattern. This Transformer (Decorator) has 
 * a transform method which can transform data of type E.
 * <p>
 * The implementation of this Transformer interface can optionally decorate another Transformer.
 * <p>
 * What the decoration means is that the implementation of the transform( E input ) method should 
 * do its transformation on E and then if a Transformer has been previously added via its
 * addDecoration( Transformer transformer ) method then it should call the transform( E input ) 
 * method of that transformer.
 * <p>
 * This allows many Decorators to be chained together, each Decorator holding a reference to 
 * (decorating) the next Decorator. The last Decorator in the chain will not hold a reference to 
 * another Decorator.
 * 
 * @author John Dickerson - 20 February 2020
 */
public interface Transformer<E> {

    /**
     * The implementation of this method should perform a transformation on the input.  If the 
     * Transformer holds a reference to another Transformer it should then call transform( E input ) 
     * on the Transformer.
     *
     * @param input 
     *      - the data to transform
     *      
     * @return data
     *      - the transformed data
     */
    public E transform( E input );


    /**
     * The implementation of this method needs to add a reference to the next transformer in 
     * the chain.
     *
     * @param transformer 
     *      - the next transformer in the chain.
     */
    public void addDecoration( Transformer<E> transformer );
}
