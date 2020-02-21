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
package com.javaspeak.designpatterns.go4.behavioural.command;


/**
 * The application calling code calls the processRequest(..) method of RequestProcessor. The 
 * implementation of processRequest retrieves the RequestType from the request and from the 
 * RequestType gets the Command that is mapped to it.  It then calls the execute method of the 
 * Command.
 * <p>
 * The execute method of Command in turn reads a map of attributes from the request; processes 
 * them and creates a new map which is passes as an argument to the callback method 
 * handleResponse(..) of the response.
 * 
 * @author John Dickerson - 21 Feb 2020
 */
public interface RequestProcessor {

    /**
     * Delegates the request and response to a Command.  The request has a RequestType which 
     * holds a reference to the Command.
     *
     * @param request 
     *      The request holding a map of attributes and a RequestType which references the Command 
     *      to execute.
     *
     * @param response 
     *      The response which has a call back method called handleResponse(..) which a new map 
     *      of processed attributes can be passed to.
     */
    public void processRequest( Request request, Response response );
}
