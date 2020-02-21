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

import java.util.HashMap;
import java.util.Map;

/**
 * Text book description:
 * <ul>
 * Command: Encapsulate a command request as an object. Encapsulate a request as an object, 
 * thereby letting you parameterize clients with different requests, queue or log requests, 
 * and support undoable operations.
 * </ul>
 * The Command pattern can be seen in web frameworks like the Struts framework.
 * <p>
 * In the Struts framework different urls are mapped to different Commands. A centralised 
 * Controller called the Dispatcher Controller delegates to a particular Command object to do 
 * some processing when it receives a particular url.  After the Command has finished processing 
 * the request and attributes are forwarded to a JSP servlet which merges HTML and the attributes 
 * into the response.
 * <p>
 * This example shows similarity to the Struts framework:
 * <p>
 * A call is made to the processRequest method of the RequestProcessor passing it a map of 
 * attributes.
 * <p>
 * The RequestProcessor retrieves the RequestType from  the request and executes a command which is 
 * mapped to that RequestType.
 * <p>
 * The Command class reads the map of attributes and creates a modified new map of the attributes 
 * which it calls the handleResponse(..) method of the Response with. The handleResponse 
 * method prints the modified attributes to System.out.
 * <p>
 * This example calls the RequestProcessor twice, each time with a different RequestType.
 * <p>
 * The first RequestType is RequestType.CAPITALISE and the RequestProcessor calls the 
 * CapitaliseCommand.
 * <p>
 * The second RequestType is RequestType.SORT and the requestProcessor calls the SortCommand
 * <p>
 * Both the calls to the RequestProcessor use the same ResponseHandler which prints the 
 * following to System.out:
 * <ul>
 *    ===============================================<br/>
 *    message : HELLO WORLD!<br/>
 *    quote : COMMON SENSE IS NOT COMMON<br/>
 *    name : JOHN DICKERSON<br/>
 *    ===============================================<br/>
 *    quote : Common Sense is not Common<br/>
 *    message : Hello World!<br/>
 *    name : John Dickerson<br/>
 *    ===============================================<br/>
 * </ul>
 * Notice that the first command capitalised the text and the second command sorted the attribute 
 * keys by the attribute values.
 * <p>
 * @author John Dickerson - 21 Feb 2020
 */
public class CommandApplication {

    private Response response =
            new Response() {

                @Override
                public void handleResponse(
                        Map<String, String> responseAttributes ) {

                    for ( String key : responseAttributes.keySet() ) {

                        System.out.println(
                                key + " : " + responseAttributes.get( key ) );
                    }
                }
            };

    public void runExample() {

        RequestProcessor requestProcessor = new RequestProcessorImpl();

        Long requestId = 1L;
        Map<String, String> requestAttributes = new HashMap<String, String>();
        requestAttributes.put( "name", "John Dickerson" );
        requestAttributes.put( "message", "Hello World!" );
        requestAttributes.put( "quote", "Common Sense is not Common" );

        Request request = new RequestImpl( requestId, RequestType.CAPITALISE, requestAttributes );
        System.out.println( "===============================================" );
        requestProcessor.processRequest( request, response );

        request = new RequestImpl( requestId, RequestType.SORT, requestAttributes );
        System.out.println( "===============================================" );
        requestProcessor.processRequest( request, response );
        System.out.println( "===============================================" );
    }


    public static void main( String args[] ) {

        CommandApplication application = new CommandApplication();
        application.runExample();
    }
}
