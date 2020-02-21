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

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * In the interpreter pattern, Expressions interact with the InterpreterContext to retrieve 
 * information from it or update it.
 * <p>
 * Expressions are used to parse code snippets of interpreted language.  In this example we have 
 * InsertExpression to parse "Object Query Language" insert statements and we have a 
 * SelectExpression to parse select statements.
 * <p>
 * The InsertExpression updates the fields of registered objects in the InterpreterContext using 
 * methods provided by the InterpreterContext.
 * <p>
 * Similarly the SelectExpression selects fields from the registered objects in the 
 * InterpreterContext using methods provided by the InterpreterContext.
 * <p>
 * Note that the InterpreterContext holds registered objects in a map and uses reflection to update 
 * or retrieve the fields of the registered objects. You will note that in this example we have 
 * only registered one object called Person and its fields are private.  Using reflection we are 
 * able to access private fields; infact there are no public getters or setters in the registered 
 * Person object.
 * 
 * @author John Dickerson - 21 Feb 2020
 */
public class InterpreterContext {

    // Map to hold registered Java objects
    private Map<String, Object> objects = new HashMap<String, Object>();

    /**
     * Adds or updates an object in the map
     *
     * @param object 
     *  The object to add or update
     */
    public void registerObject( Object object ) {

        objects.put( object.getClass().getName(), object );
    }


    /**
     * Retrieve object by className
     *
     * @param className 
     *  The className of the object to retrieve
     *
     * @return registered Object
     */
    public Object getObject( String className ) {

        return objects.get( className );
    }


    /**
     * Constructor
     */
    public InterpreterContext() {

    }


    /**
     * Uses reflection to retrieve the value of a field from an object in the Map
     *
     * @param className 
     *      The class name of the object in the map
     *      
     * @param fieldName 
     *      The fieldName we wish to retrieve the value for
     *      
     * @return the Field Value
     * @throws NoSuchFieldException
     * @throws SecurityException
     * @throws IllegalAccessException
     */
    public Object getFieldValue( String className, String fieldName )
            throws NoSuchFieldException, SecurityException, IllegalAccessException {

        Object instance = objects.get( className );

        // throw an error if there is no registered object of that className in
        // the map
        if ( instance == null ) {

            throw new ObjectNotRegisteredException();
        }

        // retrieve the Field
        Field field = instance.getClass().getDeclaredField( fieldName );

        // allow us to access a private method
        field.setAccessible( true );

        // return the field value
        return field.get( instance );
    }


    /**
     * Uses reflection to set a field value of an object in the map. Note that
     * the implementation is very sparse - it only supports String and Integer.
     *
     * @param className class name of the object which has the field we wish to
     * update
     *
     * @param fieldName name of field we wish to update
     *
     * @param fieldValue value we wil update the field with
     *
     * @throws NoSuchFieldException
     * @throws SecurityException
     * @throws IllegalAccessException
     */
    public void setFieldValue(
            String className, String fieldName, String fieldValue )
            throws NoSuchFieldException, SecurityException,
            IllegalAccessException {

        Object instance = objects.get( className );

        // throw an error if there is no registered object of that className in
        // the map
        if ( instance == null ) {

            throw new ObjectNotRegisteredException();
        }

        // retrieve field we wish to update
        Field field = instance.getClass().getDeclaredField( fieldName );
        field.setAccessible( true );

        // If the field is an Integer convert the String passed in to a Integer
        if ( field.getType().equals( Integer.class ) ) {

            field.set( instance, Integer.parseInt( fieldValue ) );
        }
        else {

            field.set( instance, fieldValue );
        }
    }
}
