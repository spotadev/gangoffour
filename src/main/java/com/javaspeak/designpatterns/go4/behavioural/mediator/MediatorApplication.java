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
 * Text book description:
 * <ul>
 *     Defines simplified communication between classes. Define an object that encapsulates how a 
 *     set of objects interact. Mediator promotes loose coupling by keeping objects from referring 
 *     to each other explicitly, and it lets you vary their interaction independently.
 * </ul>
 * In this example the ChatMediator mediates between the ChatUsers.  Only the ChatMediator  has 
 * references to all consumers and producers.  In this  example the  ChatUsers are both consumers 
 * and producers: they can both send and receive  messages.  A ChatUser sends and receives a message 
 * via the ChatMediator.
 * <p>
 * Before a ChatUser can send a message a group must exist.  The ChatUser can check whether a group 
 * exists and if it does not create one by calling the createNewGroup(..) method on the  
 * ChatMediator. Once a group exists ChatUsers can subscribe to the group.  ChatUsers can then send 
 * messages to the group by calling the sendMessage(..) method on the ChatMediator.  The 
 * ChatMediator in return calls receiveMessage(..) on each of the ChatUsers that is subscribed to 
 * the group.
 *
 * @author John Dickerson - 21 Feb 2020
 */
public class MediatorApplication {

    public void runExample() {

        // The chatMediator to pass through the constructor of each ChatUser
        ChatMediator chatMediator = new ChatMediatorImpl();

        ChatUser chatUserOne = new ChatUserImpl( chatMediator, "chatUserOne" );
        ChatUser chatUserTwo = new ChatUserImpl( chatMediator, "chatUserTwo" );
        ChatUser chatUserThree = new ChatUserImpl( chatMediator, "chatUserThree" );

        String[] groups = chatUserOne.getGroups();

        String groupName = "kite surfing";

        // ChatUserOne checks if the "kite surfing" group already exists
        // and creates one if it does not exist
        if ( !chatUserOne.groupExists( groups, groupName ) ) {

            chatUserOne.createNewGroup( groupName );
        }

        // three ChatUsers subscribe to the "kite surfing" group
        chatUserOne.subscribeToGroup( groupName );
        chatUserTwo.subscribeToGroup( groupName );
        chatUserThree.subscribeToGroup( groupName );

        // ChatUserOne sends a message to the group
        chatUserOne.sendMessage( groupName,
                "Kite meet at Shoreham, Saturday. Any one want to go?" );

        // ChatUserTwo sends a message to the group
        chatUserTwo.sendMessage( groupName, "Yes I would like to go" );

        // ChatUserThree sends a message to the group
        chatUserThree.sendMessage( groupName, "Count me in as well" );
    }


    public static void main( String args[] ) {

        MediatorApplication application = new MediatorApplication();
        application.runExample();
    }
}
