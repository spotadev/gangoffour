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
package com.javaspeak.designpatterns.go4.behavioural.interpreter;

/**
 * Value is a wrapper that wraps values of different types and provides helper methods to 
 * retrieve the types in different formats.  Note that attempting to retrieve a value in the wrong 
 * format could result in an error.
 * 
 * @author John Dickerson - 21 Feb 2020
 */
public class Value {

    private Object object;

    /**
     * Constructor
     *
     * @param object
     */
    public Value( Object object ) {

        this.object = object;
    }


    /**
     * If the object is instance of String return it, else call toString() method on it.  This 
     * method should not cause a ClassCastException if used incorrectly.
     *
     * @return String value
     */
    public String getString() {

        if ( object instanceof String ) {

            return ( String )object;
        }
        else {

            return object.toString();
        }
    }


    /**
     * This method will cast the object to Integer or attempt to convert the value to an Integer.
     *
     * @return Integer
     */
    public Integer getInteger() {

        if ( object instanceof Integer ) {

            return ( Integer )object;
        }
        else {

            // Note that if the object cannot be represented as an Integer this could throw an error
            return Integer.parseInt( object.toString() );
        }
    }


    /**
     * Returns the object with no conversion
     *
     * @return object
     */
    public Object getObject() {

        return object;
    }


    public String toString() {

        if ( object instanceof String ) {

            return getString();
        }
        else if ( object instanceof Integer ) {

            return getInteger().toString();
        }
        else if ( object != null ) {

            return object.toString();
        }
        else {

            return null;
        }
    }
}
