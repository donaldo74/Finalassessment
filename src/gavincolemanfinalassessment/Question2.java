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
    //e). Write a main method, which will use the methods described above,
    //    to input a product name and output the product code.
    public static void main(String[] args)
    {
        String productName = getValidProduct();
        String productCode = createProductCode(productName);
        Display("Your new product code = " + productCode);
    }
    
    //d). Write a method, called Display(), which will output to the
    //    screen, a message.
    static void Display(String str)
    {
        System.out.println(str);
    }
    
    //c). Write a method, called createProductCode(), which accepts a product
    //    name as a parameter and returns a product code.
    static String createProductCode(String productName)
    {
        // get second character
        String secondChar = String.valueOf(productName.charAt(1));
        // get a number between 65 and 90
        int num = getValidInteger(65,90);
        //get last 3 characters
        String last3Chars = productName.substring(productName.length()-3);
        //concat to make new code
        String productCode = secondChar + num + last3Chars;
        return productCode;
    }
    
    
    
    //b). Write a method, called getValidInteger(), that returns a positive
    //    integer in the range specified by two parameters.
    static int getValidInteger(int lower, int upper)
    {
        Scanner kb = new Scanner(System.in);
        boolean validInteger = false;
        int value = 0;
        //loop until number in required range
        while(!validInteger)
        {
            validInteger = true;
            //This try catch block will capture 'exception' errors.
            //If the user enters a non number it will throw an exception
            //and the code jumps to the catch block
            try
            {
                System.out.printf("Please enter in a number between %d and %d (inclusive):",lower, upper);
                value = kb.nextInt();
            }
            catch (Exception e)
            {
                validInteger = false;
                kb.nextLine();
            }
 
            //test if number is in requested range
            if(value < lower || value > upper)
            {
                validInteger = false;
            }
        }
        return value;
    }
    
    
    //a) Write a method, called getValidProduct(), that returns a string which
    //is a valid product name.    
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
    
