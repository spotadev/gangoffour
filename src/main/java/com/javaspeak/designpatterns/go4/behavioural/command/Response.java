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

import java.util.Map;

/**
 * The Response is passed to the RequestProcessor's processRequest(..) method along with the 
 * Request. The RequestProcessor in turn retrieves the RequestType from the Request and from the 
 * RequestType retrieves the Command. The Request and Response is then passed to the Command's 
 * execute method.
 * 
 * @author John Dickerson - 21 Feb 2020
 */
public interface Response {

    /**
     * The handleResponse(..) method is a callback method that can be called by the RequestProcessor 
     * when it has completed processing the map of attributes retrieved from the Request.  
     * The handleResponse(..) method has a new map of response attributes passed to it.
     *
     * @param responseAttributes A map of response attributes
     */
    public void handleResponse( Map<String, String> responseAttributes );
}
