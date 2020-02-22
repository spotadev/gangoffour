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
package com.javaspeak.designpatterns.go4.behavioural.state;

/**
 * Text book description:
 * <ul>
 *      State: Alter an object's behaviour when its state changes. Allow an object to alter its 
 *      behaviour when its internal state changes. The object will appear to change its class.
 * </ul>
 * This example uses the state pattern.  State objects that extends an abstract state class can be 
 * switched from one to the other at runtime.
 * <p>
 * A StateContext delegates methods calls to the current state object.  The StateContext object 
 * has the same method names as the State objects.
 * <p>
 * During a method call the State object can decide to switch it's self for another State object.
 * <p>
 * In other words some or all of the methods in the State object have the ability to switch the 
 * State object for another state object.
 * <p>
 * The new state object also extends the same abstract state object and has the same method 
 * signatures, however the implementation of the methods are likely to be different.  This pattern 
 * uses polymorphism to modify the behaviour at runtime.
 * <p>
 * In this example the ApplicationState class is the StateContext and holds a reference to the 
 * current State Object extending AbstractAccountState. There are 3 classes that extend 
 * AbstractAccountState: StarterAccountState, StandardAccountState and PremiereAccountState.
 * <p>
 * This example models a Bank Account that can be upgraded or down graded according to the current 
 * annual salary of the account holder.  The setSalary( int salary ) method in ApplicationState 
 * delegates to the current State Object by calling its setSalary( StateContext stateContext, 
 * int salary ) method.
 * <p>
 * Notice that ApplicationState passes a reference of itself ( StateContext stateContext ) in the 
 * setSalary(..) method.  The reason it does this is so that the State Object, e.g. 
 * StandardAccountState can then call the stateContext to switch the current State object for 
 * another one:
 * <pre>
 * {@code
 *     if ( salary >= SalaryGrade.PREMIERE_ACCOUNT.getSalary() ){
 * 
 *         stateContext.changeState( new PremiereAccountState( salary, balance ) );
 *     }
 *     else if ( ! ( salary >= SalaryGrade.STANDARD_ACCOUNT.getSalary() ) ){
 * 
 *         stateContext.changeState( new StarterAccountState( salary, balance ) );
 *     }
 *     else {
 *        this.salary = salary;
 *     }
 * }
 * </pre> 
 * In fact changing the salary via the setSalary(..) method can consequently result in the account 
 * being upgraded or down graded.  Notice that not all method calls of ApplicationState delegated 
 * to a state object result in the State object being swapped for another State Object. For example 
 * the setBalance(..) method does not result in the state object switching, the reason for this is 
 * that the current bank account type depends on the annual salary and not the current bank balance.
 * <p>
 * @author John Dickerson - 22 Feb 2020
 */
public class StateApplication implements StateContext {

    private AbstractAccountState accountState;

    /**
     * Initialise state with the Starter Bank Account and a balance of 200 GBP
     */
    public StateApplication() {

        accountState = new StarterAccountState( 0, 200 );
    }


    @Override
    public void changeState( AbstractAccountState newState ) {

        accountState = newState;
    }


    @Override
    public void setSalary( int salary ) {

        accountState.setSalary( this, salary );
    }


    @Override
    public int getSalary() {

        return accountState.getSalary();
    }


    @Override
    public float getBalance() {

        return accountState.getBalance();
    }


    @Override
    public void setBalance( float balance ) {

        accountState.balance = balance;
    }


    @Override
    public int getOverdraft() {

        return accountState.getOverdraft();
    }


    @Override
    public String getAccountName() {

        return accountState.getAccountName();
    }


    /**
     * Run the example.  Note the accountState.toString() method is in the AbstractAccountState 
     * which the state objects extend.  The toString() method prints out the state of the object.
     * <p>
     * Notice that the setSalary(..) method in this class delegates to the current state object and 
     * calls the state object's setSalary(..) method.  Notice that the setSalary(..) method of the 
     * state object has the ability to switch the current bank account state object to another one.
     */
    private void runExample() {

        System.out.println( "===============================================" );
        setBalance( 500 );
        System.out.println( accountState.toString() );
        System.out.println( "===============================================" );
        setSalary( 4000 );
        setBalance( 1000 );
        System.out.println( accountState.toString() );
        System.out.println( "===============================================" );
        setSalary( 7200 );
        setBalance( 3000 );
        System.out.println( accountState.toString() );
        System.out.println( "===============================================" );
        setSalary( 82000 );
        setBalance( 7000 );
        System.out.println( accountState.toString() );
        System.out.println( "===============================================" );
    }


    public static void main( String[] args ) {

        StateApplication application = new StateApplication();
        application.runExample();
    }
}
