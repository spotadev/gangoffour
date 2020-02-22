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
 * A ChatUser communicates with other ChatUsers using the mediator, ChatMediator. Only the 
 * ChatMediator has reference to all ChatUsers.
 * <p>
 * The mediator design pattern is about the Mediator only having reference to all consumers and 
 * producers.  In this example the ChatUsers are both consumers and producers: they can both 
 * send and receive messages.
 *
 * @author John Dickerson - 22 Feb 2020
 */
public class ChatUserImpl implements ChatUser, Comparable<ChatUserImpl> {

    private String userId;
    private ChatMediator chatMediator;

    /**
     * The ChatMediator is passed to each ChatUser implementation. The ChatUser makes calls to the 
     * ChatMediator to send messages to other ChatUsers
     *
     * @param chatMediator 
     *      The ChatMediator holds references to other ChatUsers
     *      
     * @param userId 
     *      The userId of this ChatUser
     */
    public ChatUserImpl( ChatMediator chatMediator, String userId ) {

        this.chatMediator = chatMediator;
        this.userId = userId;
    }


    @Override
    public String getUserId() {

        return userId;
    }


    @Override
    public void sendMessage( String groupName, String message ) {

        chatMediator.sendMessage( groupName, this, message );
    }


    @Override
    public void receiveMessage( String groupName, String userId, String message ) {

        System.out.println( this.userId + "> Received Message from : " +
                userId + " [group: " + groupName + "], message :\n    " +
                message );
    }


    @Override
    public boolean createNewGroup( String group ) {

        return chatMediator.createNewGroup( group );
    }


    @Override
    public void subscribeToGroup( String groupName ) {

        chatMediator.subscribeToGroup( groupName, this );
    }


    @Override
    public String[] getGroups() {

        return chatMediator.getGroups();
    }


    @Override
    public boolean groupExists( String[] groups, String groupName ) {

        for ( String group : groups ) {

            if ( groupName.equals( group ) ) {

                return true;
            }
        }

        return false;
    }


    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result
                + ( ( chatMediator == null ) ? 0 : chatMediator.hashCode() );
        result = prime * result + ( ( userId == null ) ? 0 : userId.hashCode() );
        return result;
    }


    @Override
    public boolean equals( Object obj ) {

        if ( this == obj )
            return true;
        if ( obj == null )
            return false;
        if ( getClass() != obj.getClass() )
            return false;
        ChatUserImpl other = ( ChatUserImpl )obj;
        if ( chatMediator == null ) {
            if ( other.chatMediator != null )
                return false;
        }
        else if ( !chatMediator.equals( other.chatMediator ) )
            return false;
        if ( userId == null ) {
            if ( other.userId != null )
                return false;
        }
        else if ( !userId.equals( other.userId ) )
            return false;
        return true;
    }


    @Override
    public int compareTo( ChatUserImpl other ) {

        return this.userId.compareTo( other.userId );
    }
}
