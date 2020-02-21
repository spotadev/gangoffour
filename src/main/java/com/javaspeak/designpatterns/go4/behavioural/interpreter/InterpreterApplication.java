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
 * Text book description:
 * <ul>
 *     Interpreter: A way to include language elements in a program. Given a language, define a 
 *     representation for its grammar along with an interpreter that uses the representation to 
 *     interpret sentences in the language.
 * </ul>
 * The interpreter pattern has a InterpreterContext which the interpreted language can interact 
 * with.  This example uses "Object Query Language (oql)" as its interpreted language and the 
 * InterpreterContext is used to register Java objects with it.   The idea is that once a java 
 * object is registered in the InterpreterContext, you can use oql to update the java object with 
 * data or to select data from it.
 * <p>
 * In the example we are using oql to insert some data into Person and retrieve some data. We 
 * print the data retrieved to System.out.
 * <p>
 * The mechanics of the Interpreter pattern in this example work as follows:
 * <p>
 * The interpreter first of all separates the oql into statements. It does this by looking for 
 * a ";" separator between the statements. It then executes the statements one by one.
 * <p>
 * Note that the Interpreter uses Expression objects to help it parse data and call the right 
 * commands.  In our example we have a InsertExpression and SelectExpression which both extends 
 * the abstract class AbstractExpression.
 * <p>
 * If a oql statement starts with "insert" the interpreter knows to use the InsertExpression 
 * to perform the parsing and call setFieldValue(..) method on the InterpreterContext.
 * <p>
 * If however the oql statement starts with "select" the interpreter knows to use the 
 * SelectStatement to perform the parsing and call getFieldValue(..) method on the 
 * InterpreterContext and add the selected values to the valuesToReturn list.
 * <p>
 * @author John Dickerson - 21 Feb 2020
 */
public class InterpreterApplication {

    public void runExample() throws Exception {

        InterpreterContext interpreterContext = new InterpreterContext();

        // register an object with the interpreter which we wish to insert data into or select 
        // data from
        interpreterContext.registerObject( new Person() );

        Interpreter interpreter = new Interpreter( interpreterContext );

        // Build up an insert statement and select statement. Separate the statements by ";"
        StringBuilder sb = new StringBuilder();
        sb.append( "insert into " ).append( Person.class.getName() );
        sb.append( " firstName=John lastName=Dickerson height=180;" );
        sb.append( "select height, firstName, lastName from " );
        sb.append( Person.class.getName() ).append( ";" );

        // Object Query Language
        String oql = sb.toString();

        // Call the interpreter to execute the oql and return values.
        List<Value> values = interpreter.interpret( oql );

        // Print the values retrieved to System.Out
        for ( Value value : values ) {

            System.out.print( value + " " );
        }
    }


    public static void main( String[] args ) throws Exception {

        InterpreterApplication application = new InterpreterApplication();
        application.runExample();
    }
}
