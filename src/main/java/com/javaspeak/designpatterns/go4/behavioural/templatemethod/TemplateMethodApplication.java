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
package com.javaspeak.designpatterns.go4.behavioural.templatemethod;

/**
 * The Template Method Pattern uses an abstract class. The abstract class has a method 
 * ( called buildPage() in this example ) which calls the abstract methods in the correct order.
 * <p>
 * The exact implementation of the abstract methods is left to sub classes of the abstract class.
 * <p>
 * In this example AbstractHtmlPage is extended by the class HomePage to provide implementation of 
 * the abstract methods, getTitle(), getHeader(), getContent(), getFooter();
 *
 * @author John Dickerson - 22 Feb 2020
 */
public class TemplateMethodApplication {

    private void runExample() throws FormatException {

        AbstractHtmlPage htmlPage = new HomePage();
        String html = htmlPage.getHtml();
        System.out.println( html );
    }


    public static void main( String[] args ) throws FormatException {

        TemplateMethodApplication application = new TemplateMethodApplication();
        application.runExample();
    }
}
