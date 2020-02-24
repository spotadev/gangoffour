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

import java.util.List;

/**
 * Used to define the structure of composite and simple elements.
 * <p>
 * AbstractHtmlElement provides an implementation for getHtmlElements() but leaves getHtml() to be 
 * implemented by parent classes.  Both TextElement and HtmlElement extend AbstractHtmlElement and 
 * provide an implementation for getHtml() method.  HtmlElement is a composite element which can 
 * itself be comprised of composite elements while TextElement is simple.  TextElement is simple 
 * as it does not make use of getHtmlElements() in its getHtml() method.
 *
 * @author John Dickerson - 24 Feb 2020
 */
public interface HtmlElement {

    /**
     * Returns a list of HtmlElement. The calling code can call this method and a HtmlElement to 
     * the end of the list
     *
     * @return List of HtmlElement
     */
    public List<HtmlElement> getHtmlElements();


    /**
     * Returns the Html.  If the HtmlElement is a simple element it will not be using the 
     * List<HtmlElement>, however if it is a composite element it will iterate through the child 
     * HtmlElements and call getHtml() on each of them while building up the html to return.
     *
     * @return Html
     */
    public String getHtml();
}
