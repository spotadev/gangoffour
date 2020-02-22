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
package com.javaspeak.designpatterns.go4.behavioural.mediator;


/**
 * This mediator is central to the Mediator pattern.
 * <p>
 * The ChatMediator mediates between the ChatUsers.  Only the ChatMediator has a references to 
 * all consumers and producers.  In this example the ChatUsers are both consumers and producers: 
 * they can both send and receive messages.  A ChatUser sends and receives a message via the 
 * ChatMediator.
 * 
 * @author John Dickerson - 21 Feb 2020
 */
public interface ChatMediator {

    /**
     * Returns all groups
     *
     * @return 
     *      all groups
     */
    public String[] getGroups();


    /**
     * Creates a new group
     *
     * @param groupName 
     *      Group Name to create the group with
     *      
     * @return 
     *      true if the group was created. false indicates the group was not created because it 
     *      exists already.
     */
    public boolean createNewGroup( String groupName );


    /**
     * Subscribe to the group.  If the group does not exist create it and subscribe
     *
     * @param groupName  
     *      GroupName to subscribe to
     *      
     * @param chatUser 
     *      ChatUser which is subscribing
     */
    public void subscribeToGroup( String groupName, ChatUser chatUser );


    /**
     * Send message to group
     *
     * @param group 
     *      Group to send message to
     *      
     * @param chatUser 
     *      ChatUser which is sending the message
     *      
     * @param message 
     *      the message to send to the group
     */
    public void sendMessage( String group, ChatUser chatUser, String message );
}
