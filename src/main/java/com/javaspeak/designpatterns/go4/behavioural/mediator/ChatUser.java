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
*
* A ChatUser communicates with other ChatUsers using the mediator, ChatMediator. Only the 
* ChatMediator has reference to all ChatUsers.
* <p>
* The mediator design pattern is about the Mediator only having reference to all consumers and 
* producers.  In this example the ChatUsers are both consumers and producers: they can both send 
* and receive messages.
*
* author John Dickerson - 21 Feb 2020
*/
public interface ChatUser {

    /**
     * The userId of the ChatUser is the user name of the ChatUser
     *
     * @return userId
     */
    public String getUserId();


    /**
     * The ChatUser calls this method to send messages to other ChatUser
     *
     * @param group
     * @param message
     */
    public void sendMessage( String group, String message );


    /**
     * The ChatMediator calls this message to send a message to the ChatUser
     * which it has received from another user.
     *
     * @param group  
     *      Group that the message belongs to
     *      
     * @param userId 
     *      The userId of the ChatUser sending the message
     *      
     * @param message 
     *      The message that is being sent to the ChatUser who has subscribed to the Group.
     */
    public void receiveMessage( String group, String userId, String message );


    /**
     * A ChatUser calls this method to create a new Group.
     *
     * @param groupName 
     *      The name of the group to create
     *      
     * @return 
     *      true if the group was created or false if the group already exists
     */
    public boolean createNewGroup( String groupName );


    /**
     * Subscribe to the group
     *
     * @param groupName 
     *      the group to subscribe to
     */
    public void subscribeToGroup( String groupName );


    /**
     * Gets a list of the group Names that exist
     *
     * @return 
     *      a list of the group names that exist
     */
    public String[] getGroups();


    /**
     * Checks whether the GroupName is in the array of groups
     *
     * @param groupNames
     *      groups array of group names
     *      
     * @param groupName the group name to check whether it is the array of
     * group name or not
     *
     * @return true if the groupName is in the array of group names or false
     * if it is not
     */
    public boolean groupExists( String[] groupNames, String groupName );
}
