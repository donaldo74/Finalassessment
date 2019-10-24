package gavincolemanfinalassessment;

import java.util.Scanner;
import java.util.Random;

public class AssignmentQ18 
{
    //Get the valid ID and pass it into the ChangeId method
    //Display the new ID
    public static void main(String[] args)
    {
        String validId = getValidId("Please enter a valid ID");
        display( "Your new Customer ID = " + ChangeId(validId) );
    }
    
    //------------------------------------------------------------------
    //display a string
    static void display(String str)
    {
        System.out.println(str);
    }
    
    //------------------------------------------------------------------
    //take valid ID and return new customer id
    //replace first number and replace 'R' with 'rr'
    static String ChangeId(String id)
    {
        //a stringbuilder is an easy way to append values to a string
        StringBuilder newId = new StringBuilder();
        
        //create the new first number as a random number between 1 and original 
        //value of leading number. I have interpreted this as greater than 1 and 
        //less than or including original value
        Random ran = new Random();
        int firstNum = Integer.valueOf(id.substring(0,1));
        int newFirstNum = ran.nextInt(firstNum-1);
        String newFirstChar = Integer.toString(newFirstNum + 2);
        newId.append(newFirstChar);
        //get index of R
        int idxR = id.indexOf('R',0);
        //copy original id between first char and occurance of 'R'
        newId.append(id.substring(1,idxR));
        //insert 'rr'
        newId.append("rr");
        //copy rest of original id from after 'R' to end
        newId.append(id.substring(idxR+1));
        
        return newId.toString();
    }
    //------------------------------------------------------------------
    //getValidId asks for user to enter id and then checks to see if is valid
    static String getValidId(String prompt)
    {
        Scanner kb = new Scanner(System.in);
        boolean isIdValid = false;
        String id = "";
        
        //repeat until id is valid
        while(isIdValid)
        {
            System.out.println(prompt);
            id = kb.nextLine();
            isIdValid = true; //assume the id is valid until it fails 1 or more of the tests below
            
            //check the validity of the entered id
            //this tests for every requirement each pass (even after it might have failed.
            //This is so that all helpful error messages are displayed.
            
            //Check 1st char is a number, but not 1
            if( !Character.isDigit(id.charAt(0)) || id.charAt(0) == '1')
            {
                isIdValid = false;
                System.out.println("First character must be a digit, but not 1.");
            }
            
            //check the id is 6 chars or longer
            if(id.length()<6)
            {
                isIdValid = false;
                System.out.println("Length must be greater than 5 characters");
            }
            //Something new, this uses 'Regular Expression' string matching to find any vowels.
            //Regular Expressions are very powerful for string matching, but can be quite difficult to read
            if(id.matches(".*[aeiou].*") )
            {
                isIdValid = false;
                System.out.println("Id must not contain a vowel");
            }
            //check the last char is 'z'
            if(id.charAt(id.length()-1)!= 'z')
            {
                isIdValid = false;
                System.out.println("Id must end in a z.");
            }
            //maybe a bit of a redundant check since we've tested first and last char already.
            if(id.charAt(0)==' ' || id.charAt(id.length()-1)==' ')
            {
                isIdValid = false;
                System.out.println("Id must not have leading or trailing spaces.");
            }
            //check id contains 'R'
            if(!id.contains("R"))
            {
                isIdValid = false;
                System.out.println("Id must contain R.");
            }
            //let the user know that the id has been accepted.
            if(isIdValid == true)
            {
                System.out.println("Your ID has been accepted");
            }
        }
        return id;
    }
}
