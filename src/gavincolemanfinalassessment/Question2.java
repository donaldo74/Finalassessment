/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gavincolemanfinalassessment;

import java.util.Scanner;
/**
 * Question 2
 * Requirement is to request and validate code, return a new code containing a 
 * number chosen by user
 * @author gavin
 */
public class Question2 
{
    public static void main(String[] args)
    {
        String productName = getValidProduct();
    }
        
    static String getValidProduct()
    {
        //request product name
        Scanner kb = new Scanner(System.in);
        String productName = "";
        boolean isValidName = false;
        //loop until valid name is entered
        while(!isValidName)
        {
            //assume name is valid until it fails tests below
            isValidName = true;
            System.out.println("Enter product name: ");
            productName = kb.nextLine();
            
            //check length, if it fails test then set isValidName flag to false
            //& provide useful message
            if(productName.length() <6)
            {
                System.out.println("Name must be 6 characters or longer");
                isValidName = false;
            }
            
            //and check last char is an X, setting flag and providing a message
            //if test fails
            if(productName.charAt(productName.length()-1) != 'X')
            {
                System.out.println("Last letter of product name must be an X");
                isValidName = false;
            }
        }
        System.out.println("Your product name has been accepted");
        return productName; 
    }
}
    
