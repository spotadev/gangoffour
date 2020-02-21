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

/**
 * The interpreter class is responsible for holding a reference to the InterpreterContext and for 
 * determining which Expressions to use for parsing the interpreted language.  The interpreter 
 * parses "Object Query Language (oql)" into statements and then executes the statements. Different 
 * Expression objects are used for parsing different kinds of statements.
 * <p>
 * For example a InsertExpression is used for parsing oql insert statements and a SelectExpression 
 * is used for parsing oql select statements.
 * <p>
 * In out example the InterpreterContext registers Java objects and allows us to update their 
 * values and select values from them by making method calls.  The Expression objects, 
 * InsertExpression and SelectExpression make calls to the InterpeterContext to update the 
 * registered objects with new values or to retrieve values.
 * 
 * @author John Dickerson - 21 Feb 2020
 */
public class Interpreter {

    // Context holding registered objects
    private InterpreterContext interpreterContext;

    /**
     * Constructor to pass in the context
     *
     * @param interpreterContext
     */
    public Interpreter( InterpreterContext interpreterContext ) {

        this.interpreterContext = interpreterContext;
    }


    /**
     * Performs the following steps:
     * <ul>
     *      <li>
     *          Parses "Object Query Language (oql)" into statements by looking
     *          for ";" separators.
     *      </li>
     *      <li>
     *          Checks the first word of each statement to determine which Expression to use to 
     *          parse the statement. If a "select" is present uses a SelectExpression. If a 
     *          "insert" is present uses a InsertExpression.
     *      </li>
     *      <li>
     *          interprets the Expression. The Expression in turn parses the oql and makes calls 
     *          to the InterpreterContext to either insert data into the registered objects or 
     *          retrieve data from them.
     *      </li>
     * </ul>
     *
     * @param oql
     *      The language to interpret
     * @return
     *      List of Expressions
     * @throws Exception
     */
    public List<Value> interpret( String oql ) throws Exception {

        // separate statements by ";"
        String[] statements = oql.split( ";" );

        // create a list of values to return. Note that multile select
        // statements can be called but only one list of values is returned.
        List<Value> valuesToReturn = new ArrayList<Value>();

        // For each statement choose a Expression to do the work
        for ( String statement : statements ) {

            statement = statement.trim();

            Expression expression;

            // if the statements start with "select" use a SelectExpression to
            // parse statement.  If starts with "insert" use a InsertExpression
            // to parse statement
            if ( statement.toLowerCase().startsWith( "select" ) ) {

                expression = new SelectExpression( statement );

                valuesToReturn.addAll(
                        expression.interpret( interpreterContext ) );
            }
            else if ( statement.toLowerCase().startsWith( "insert" ) ) {

                expression = new InsertExpression( statement );
                expression.interpret( interpreterContext );
            }
            else {

                // The statements starts with an unexpected word so throw
                // an error
                throw new Exception( "Incorrect syntax in : " + statement );
            }
        }

        return valuesToReturn;
    }
}
