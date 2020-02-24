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
package com.javaspeak.designpatterns.go4.structural.proxy;


/**
 * @author John Dickerson - 23 Feb 2020
 */
/**
 * This proxy class proxies the shape Subject.  After calling drawShape() on the subject it logs 
 * to Systm.out how many times the drawShape() method has been called.
 * <p>
 * Note that the relationship to the subject is ususally determined at compile time with the proxy 
 * pattern.
 * <p>
 * With the decorator pattern which is quite similar the relationship is usually defined at runtime.  
 * A runtime relationship means that the class being decorated is passed in via a constructor or 
 * setter and a compile time relationship means the proxy is hard coded to proxy a specific class.
 * <p>
 * Decorators are often chained together while proxies are not chained.
 *
 *  @author John Dickerson - 23 Feb 2020
 */
public class TriangleProxy implements Shape {

    private Shape subject;
    private int numberTimesInvoked;

    /**
     * Constructor
     * <p>
     * Instantiates subject we are proxying
     */
    public TriangleProxy() {

        this.subject = new Triangle();
    }


    @Override
    public void drawShape() {

        this.subject.drawShape();
        numberTimesInvoked++;
        System.out.println( "drawShape() has been invoked " + numberTimesInvoked + " times" );
    }
}
