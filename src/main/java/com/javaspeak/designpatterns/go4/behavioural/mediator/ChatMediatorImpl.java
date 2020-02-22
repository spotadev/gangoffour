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

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * This mediator is central to the Mediator pattern.
 * <p>
 * The ChatMediator mediates between the ChatUsers.  Only the ChatMediator has a references to all 
 * consumers and producers.  In this example the ChatUsers are both consumers and producers: they 
 * can both send and receive messages.  A ChatUser sends and receives a message via the 
 * ChatMediator.
 *
 * @author John Dickerson - 22 Feb 2020
 */
public class ChatMediatorImpl implements ChatMediator {

    private Set<String> groups = new ConcurrentSkipListSet<String>();

    private Map<String, Set<ChatUser>> chatUsersByGroup =
            new ConcurrentHashMap<String, Set<ChatUser>>();

    @Override
    public String[] getGroups() {

        return groups.toArray( new String[] {} );
    }


    @Override
    public boolean createNewGroup( String groupName ) {

        if ( groups.contains( groupName ) ) {

            return false;
        }
        else {

            groups.add( groupName );
            return true;
        }
    }


    @Override
    public void subscribeToGroup( String group, ChatUser chatUser ) {

        Set<ChatUser> groupChatUsers = chatUsersByGroup.get( group );

        if ( groupChatUsers == null ) {

            groupChatUsers = new ConcurrentSkipListSet<ChatUser>();
            chatUsersByGroup.put( group, groupChatUsers );
        }

        groupChatUsers.add( chatUser );
    }


    @Override
    public void sendMessage( String groupName, ChatUser chatUser, String message ) {

        Set<ChatUser> groupChatUsers = chatUsersByGroup.get( groupName );

        if ( groupChatUsers.contains( chatUser ) ) {

            for ( ChatUser groupChatUser : groupChatUsers ) {

                if ( !groupChatUser.equals( chatUser ) ) {

                    groupChatUser.receiveMessage( groupName, chatUser.getUserId(), message );
                }
            }
        }
    }
}
