/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gavincolemanfinalassessment;

import java.util.Scanner;
/**
 * Assessment 3 - Question 1
 * Program requires salary and returns tax payable and net salary.
 * The tax rate for salaries between €5000 and €20000 inclusive is 2%.
 * Salaries over €20000 and less than €50000 pay 4% tax.
 * Salaries of €50000 or more are taxed at a rate of 10%.
 * The max tax that anyone can pay is €20000. No tax is paid by people who 
 * earn less than €5000.
 * @author gavin
 */
public class Question1 
{
    public static void main(String[] args)
    {
        //Request salary from the user
        Scanner kb = new Scanner(System.in);
        System.out.println("Please enter your salary:");
        double salary = kb.nextDouble();
        
        //Calculate the tax rate
        double taxRate;
        if(salary < 5000)
        {
            taxRate = 0;
        }
        else if(salary <= 20000)
        {
            taxRate = 0.02;
        }
        else if(salary < 50000){
            taxRate = 0.04;
        }
        else
        {
            taxRate = 0.1;
        }
        
        //Cap tax payable at 20,000
        double taxPayable = salary * taxRate;
        if(taxPayable > 2000)
        {
            taxPayable = 2000;
        }
        
        //Calculate net pay
        double netPay = salary -taxPayable;
        
        //Display results
        System.out.println("Your tax rate = " + taxRate*100 + "%");
        System.out.println("Your tax payable = €" + taxPayable);
        System.out.println("Your net pay = €" + netPay);
    }
}
