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
package com.javaspeak.designpatterns.go4.structural.composite;


/**
 * Text book description:
 * <ul>
 *     Composite: A tree structure of simple and composite objects. Compose objects into tree 
 *     structures to represent part-whole hierarchies. Composite lets clients treat individual 
 *     objects and compositions of objects uniformly.
 * </ul>
 * Has a tree like structure of simple and composite objects.  A Composite object can itself hold 
 * composite objects as well as simple objects.
 * <p>
 * In this example the composite objects are modelling html tables while the simple objects are 
 * modelling text.  This example is not too disimilar to the apache tiles framework. The apache 
 * tile framework uses the composite framework.
 * 
 * @author John Dickerson - 22 Feb 2020
 */
public class CompositeApplication {

    /**
     * Shows a web page made up of tables containing text and other tables.
     */
    public void showWebPage() {

        HtmlElement pageTableElement = new TableElement();
        pageTableElement.getHtmlElements().add( new TextElement( "Composite Pattern" ) );
        HtmlElement bodyTableElement = new TableElement();
        bodyTableElement.getHtmlElements().add( new TextElement( "Hello" ) );
        bodyTableElement.getHtmlElements().add( new TextElement( "World!" ) );
        pageTableElement.getHtmlElements().add( bodyTableElement );
        pageTableElement.getHtmlElements().add( new TextElement( "Footer & Copyright" ) );
        StringBuilder htmlSb = new StringBuilder();
        htmlSb.append( "<html>\n" );
        htmlSb.append( "<head><title>Composite Pattern</title></head>\n" );
        htmlSb.append( "<body>\n" );
        htmlSb.append( pageTableElement.getHtml() );
        htmlSb.append( "</body>" );
        htmlSb.append( "</html>" );

        System.out.println( htmlSb.toString() );
    }


    public static void main( String[] args ) {

        CompositeApplication applicationComposite = new CompositeApplication();
        applicationComposite.showWebPage();
    }
}
