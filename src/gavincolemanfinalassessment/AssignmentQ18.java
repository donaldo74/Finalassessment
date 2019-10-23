package gavincolemanfinalassessment;

import java.util.Scanner;

public class AssignmentQ18 
{
    //Get the valid ID and pass it into the ChangeId method
    //Display the new ID
    public static void main(String[] args)
    {
        String validID = getValidId("Please enter a valid ID");
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
        }
        return id;
    }
}
