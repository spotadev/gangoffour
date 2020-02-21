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
 * The RequestProcessor calls the execute(..) method of Command passing in the request and 
 * response to it.
 * <p>
 * The Command to call the execute() method on is retrieved from the RequestType stored in the 
 * request.
 * 
 * @author John Dickerson - 21 Feb 2020
 */
public interface Request {

    /**
     * The requestId provides a unique identify for the request. The current implementation does 
     * not use it.
     *
     * @return requestId 
     *      The requestId unique identifies the request
     */
    public Long getRequestId();


    /**
     * The RequestType holds the mapping to a Command
     *
     * The RequestProcessor uses the RequestType from a Request to retrieve the Command to call 
     * execute(..) on.
     *
     * @return RequestType 
     *      RequestType holds the mapping to a Command
     */
    public RequestType getRequestType();


    /**
     * Retrieves a map of Request attributes which are String key value pairs.
     * <p>
     * The idea is that the execute(..) method of Command will read the request attributes; process 
     * them and then return them in a new map via the callback method handleResponse(..) in the 
     * response argument of the execute(..) method
     *
     * @return Map 
     *      Map of modified attributes
     */
    public Map<String, String> getRequestAttributes();
}
