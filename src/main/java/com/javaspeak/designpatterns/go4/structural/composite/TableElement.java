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
 * Extends AbstractHtmlElement to provide a composite implementation for a Html table.  An html 
 * table is considered a composite object as it can itself contain composite objects such as other 
 * html tables.
 * <p>
 * TableElement wraps the child HtmlElements in "tr" and "td" html tags.
 *
 * @author John Dickerson - 24 Feb 2020
 */
public class TableElement extends AbstractHtmlElement {

    @Override
    public String getHtml() {

        if ( htmlElements != null ) {
            StringBuilder sb = new StringBuilder();

            sb.append( "<table cellspacing=\"5\" cellpadding=\"5\">\n" );

            for ( HtmlElement pageElement : htmlElements ) {
                sb.append( "<tr><td>" );
                sb.append( pageElement.getHtml() ).append( "</td></tr>\n" );
            }

            sb.append( "</table>\n" );
            return sb.toString();
        }

        return "";
    }
}
