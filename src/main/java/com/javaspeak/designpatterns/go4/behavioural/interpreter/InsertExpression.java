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

import java.util.List;
import java.util.StringTokenizer;

/**
 * Used for parsing insert "Object Query Language (oql)" statements.
 * 
 * @author John Dickerson - 21 Feb 2020
 */
public class InsertExpression implements Expression {

    private String insertStatement;

    /**
     * Insert statement is passed through the consructor
     *
     * @param insertStatement 
     *      Insert statement to be parsed and executed
     */
    public InsertExpression( String insertStatement ) {

        this.insertStatement = insertStatement;
    }


    @Override
    public List<Value> interpret( InterpreterContext context ) throws Exception {

        // tokenize statement using spaces and commas as seperators
        StringTokenizer wordTokenizer = new StringTokenizer( insertStatement, ", " );

        // the first token is "insert"
        wordTokenizer.nextToken();

        // the second token is "into"
        wordTokenizer.nextToken();

        // the third token is the className of the object we wish to insert into
        String className = wordTokenizer.nextToken();

        String valuePair;

        StringTokenizer pairTokenizer;
        String fieldName;
        String fieldValue;

        // we assume that all remaining tokens have the form:
        // fieldName=fieldValue.  We also assume that fieldValue do not have
        // spaces
        while ( wordTokenizer.hasMoreTokens() &&
                ( valuePair = wordTokenizer.nextToken() ) != null ) {

            pairTokenizer = new StringTokenizer( valuePair, "=" );
            fieldName = pairTokenizer.nextToken();
            fieldValue = pairTokenizer.nextToken();
            context.setFieldValue( className, fieldName, fieldValue );
        }

        // insert statements do not return values so we return null
        return null;
    }
}
