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

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Used for parsing select "Object Query Language (oql)" statements.
 * 
 * @author John Dickerson - 21 Feb 2020
 */
public class SelectExpression implements Expression {

    // select statement to parse
    private String selectStatement;

    // select statement is passed through constructor
    public SelectExpression( String selectStatement ) {

        this.selectStatement = selectStatement;
    }


    @Override
    public List<Value> interpret( InterpreterContext context ) throws Exception {

        // tokenize statement using spaces and commas as seperators
        StringTokenizer wordTokenizer = new StringTokenizer( selectStatement, ", " );

        // the first token is "select"
        wordTokenizer.nextToken();

        String tokenString;

        // creates a list to hold the fieldNames
        List<String> fieldNames =
                new ArrayList<String>( wordTokenizer.countTokens() );

        // add all tokens before the toek "from" to the fieldNames list
        while ( wordTokenizer.hasMoreTokens() &&
                !( tokenString = wordTokenizer.nextToken() ).equals( "from" ) ) {

            fieldNames.add( tokenString );
        }

        // the next token is the className
        String className = wordTokenizer.nextToken();

        // initialize the list of field values to return
        List<Value> fieldValues = new ArrayList<Value>( fieldNames.size() );

        Value value;

        for ( String fieldName : fieldNames ) {

            // make a call to the InterpreterContext to retrieve the field value
            // for the field in the specified object registered with the
            // InterpreterContext
            value = new Value( context.getFieldValue( className, fieldName ) );

            // add the field value to the list of Values to return.
            fieldValues.add( value );
        }

        // return the field values
        return fieldValues;
    }
}
