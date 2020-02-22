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
 * This is the state object for the Starter Bank Account Type where the criteria for having one is 
 * determined by the current annual Salary. This state object will be automatically upgraded to a 
 * StandardAccountState if the salary raises above the salary defined in the enum:
 * <p>
 * SalaryGrade.STANDARD_ACCOUNT.getSalary().
 * <p>
 * Similarly the account will be automatically upgraded to a PremiereAccountState if the salary 
 * raises to:
 * <p>
 * SalaryGrade.PREMIERE_ACCOUNT.getSalary()
 * <p>
 * The other method calls do not result in the State Object being switched for another one.  However 
 * the other methods have different method implementations amongst the state objects. For example 
 * calling getOverdraft() on a PremierAccountState gives an overdraft of 5000 while calling
 * getOverdraft() on StandardAccountState gives an overdraft of 700.
 *
 * @author John Dickerson - 22 Feb 2020
 */
public class StarterAccountState extends AbstractAccountState {

    public StarterAccountState( int salary, float balance ) {

        super( salary, balance );
    }


    @Override
    public void setSalary( StateContext stateContext, int salary ) {

        if ( salary >= SalaryGrade.PREMIERE_ACCOUNT.getSalary() ) {

            stateContext.changeState( new PremiereAccountState( salary, this.balance ) );
        }
        else if ( salary >= SalaryGrade.STANDARD_ACCOUNT.getSalary() ) {

            stateContext.changeState( new StandardAccountState( salary, this.balance ) );
        }
        else {

            this.salary = salary;
        }
    }


    @Override
    public int getOverdraft() {

        return 0;
    }


    @Override
    public String getAccountName() {

        return "Starter Account";
    }
}
