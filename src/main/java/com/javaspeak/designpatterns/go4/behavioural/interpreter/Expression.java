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

/**
 * Typically an interpreted language encapsulates the parsing into different expressions.   In 
 * this example all Expressions need to extend AbstractExpression.  In this example we have an 
 * InsertExpression and a SelectExpression.
 * <p>
 * The interpreter parses the "Object Query Language (oql) into statements and then checks which 
 * expression to use to parse each statement. For example the InsertExpression is used for parsing 
 * oql which is inserting data into objects and the SelectExpression is used for parsing oql which 
 * is used for retrieving data from objects.
 * 
 * @author John Dickerson - 21 Feb 2020
 */
public interface Expression {

    /**
     * Classes implementing AbstractExpression should pass the oql to parse through their 
     * constructor
     *
     * @param context 
     *      The InterpreterContext which holds a registry of objects.
     *
     * @return return List of Value or null.  
     *      The InsertExpression returns null while the SelectExpression returns a list of Value.
     *
     * @throws Exception if oql is not well formed.
     */
    public List<Value> interpret(
            InterpreterContext context ) throws Exception;
}
