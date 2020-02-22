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

import java.util.LinkedList;

/**
 * The Template Method Pattern uses an abstract class. The abstract class has a method 
 * ( buildPage() ) which calls the abstract methods in the correct order.
 * <p>
 * The implementation of the abstract methods is left to sub classes of the abstract class.
 *
 * @author John Dickerson - 22 Feb 2020
 */
public abstract class AbstractHtmlPage {

    // abstract methods
    public abstract String getTitle();

    public abstract String getHeader();

    public abstract String getContent();

    public abstract String getFooter();


    /**
     * Parses the xml of the document into a LinkedList
     *
     * @param html 
     *      html to parse
     *      
     * @return LinkedList
     * 
     * @throws FormatException 
     *      FormatException is thrown if the html is not well formed.
     */
    private LinkedList<String> getLinkedList( String html ) throws FormatException {

        int start;
        int end;

        LinkedList<String> elements = new LinkedList<String>();

        while ( html.length() != 0 ) {

            start = html.indexOf( "<" );
            end = html.indexOf( ">" );

            if ( start > 0 ) {

                elements.add( html.substring( 0, start ) );
            }

            if ( start != -1 && end == -1 ) {

                throw new FormatException( "Found < but cannot find closing >" );
            }

            if ( start != -1 ) {

                elements.add( html.substring( start, end + 1 ) );

                if ( html.length() > end ) {

                    html = html.substring( end + 1 );
                }
            }
            else {

                elements.add( html );
                html = "";
            }
        }

        return elements;
    }


    /**
     * Build up the String for the tabs
     *
     * @param level 
     *      the number of tabs
     *      
     * @return 
     *      the String of spaces representing the tabs
     */
    private String getTab( int level ) {

        StringBuilder sb = new StringBuilder();

        for ( int i = 0; i < level; i++ ) {

            sb.append( "   " );
        }

        return sb.toString();
    }


    /**
     * This method formats the html with proper space indents
     *
     * @param html 
     *      The html to format
     *      
     * @return 
     *      formatted html with proper indents
     *      
     * @throws FormatException 
     *      FormatException thrown if html not well formed.
     */
    private String formatHtml( String html ) throws FormatException {

        String formattedHtml = html.trim();
        formattedHtml = formattedHtml.replaceAll( "\n", "" );
        formattedHtml = formattedHtml.replaceAll( "\t", "" );
        int currentLevel = -1;
        LinkedList<String> elements = getLinkedList( formattedHtml );
        StringBuilder sb = new StringBuilder();
        String element;

        for ( int i = 0; i < elements.size(); i++ ) {

            element = elements.get( i );

            if ( elements.get( i ).startsWith( "<" ) ) {

                if ( element.indexOf( "/" ) == -1 ) {

                    if ( !( i > 0 && elements.get( i - 1 ).startsWith( "</" ) ) ) {

                        currentLevel++;
                    }

                    sb.append( getTab( currentLevel ) );
                    sb.append( elements.get( i ) );
                }
                else {

                    currentLevel--;
                    sb.append( getTab( currentLevel ) );
                    sb.append( element );
                }
            }
            else {
                currentLevel++;
                sb.append( getTab( currentLevel ) );
                sb.append( element );
            }

            sb.append( "\n" );
        }

        return sb.toString();
    }


    /**
     * This method determines the order which the abstract methods are called
     *
     * @return 
     *      unformatted html
     */
    private String buildPage() {

        StringBuffer sb = new StringBuffer( "<html><head><title>" );
        sb.append( getTitle() );
        sb.append( "</title></head><body>" );
        sb.append( "<table width=\"100%\" cellspacing=\"10\" " );
        sb.append( "cellpadding=\"10\" ><tr><td>" );
        sb.append( getHeader() );
        sb.append( "</td></tr><tr><td>" );
        sb.append( getTitle() );
        sb.append( "</td></tr><tr><td>" );
        sb.append( getContent() );
        sb.append( "</td></tr><tr><td>" );
        sb.append( getFooter() );
        sb.append( "</td></tr>" );
        sb.append( "</table></body></html>" );

        return sb.toString();
    }


    /**
     * Gets the formatted html
     *
     * @return 
     *      formated html
     *      
     * @throws 
     *      FormatException FormatException is thrown if the html is badly ormed
     */
    public String getHtml() throws FormatException {

        String html = buildPage();
        String formattedHtml = formatHtml( html );
        return formattedHtml;
    }
}
