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
package com.javaspeak.designpatterns.go4.behavioural.chainofresponsibility;


/**
 * Text book description:
 * <ul>
 *   Chain of Responsibility: A way of passing a request between a chain of objects. Avoid 
 *    coupling the sender of a request to its receiver by giving more than one object a chance to 
 *    handle the request. Chain the receiving objects and pass the request along the chain until 
 *    an object handles it.
 * </ul>
 * The chain of responsibility pattern is about a chain of decorators each decorator decorating 
 * another decorator. The chain of responsibility pattern accentuates the chaining while the 
 * decorator pattern accentuates how a class can decorate another class to provide extra 
 * functionality without extending it.
 * <p>
 * In the chain of responsibility pattern the order that the decorators are chained is considered 
 * important while with the decorator pattern it is more about adding extra behaviour to the class 
 * and the ordering or the fact that multiple decorators can be chained together is not so 
 * important.
 * <p>
 * The Chain of Responsibility pattern is structurally like a Decorator pattern. It is different 
 * only in emphasis. It is behavioural pattern and describes the behaviour of chaining multiple 
 * decorators together.
 * <p>
 * Note that the Chain of Responsibility pattern is popular in Servlet Engines.  Servlet Filters 
 * can be chained together to work on the request.
 * <p>
 * As the Chain of Responsibility pattern is in all intense and purposes the same structurally as 
 * the Decorator pattern you can look at the code examples in the Decorator pattern 
 * (ApplicationDecorator).
 * 
 * @see com.javaspeak.designpatterns.go4.structural.decorator.ApplicationDecorator
 * 
 * @author John Dickerson - 21 February 2020
 */
public class ChainOfResponsibilityApplication {

    // As explained above, while the "Chain of Responsibility" design pattern is a behavioural 
    // pattern, in code it is the same as the structural "Decorator" design pattern.  Therefore
    // take a look at ApplicationDecorator.
}
