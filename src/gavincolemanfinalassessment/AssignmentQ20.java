/*
Write a program to input a product code and output the product details if the
markup is greater than or equal to 8%. Otherwise it will display the follwing
message, "Markup less than 8%
For example:    123FRO10 - This frozen product is supplied by supplier 123 and
                the markup is 10%.
                AbcFRO2 - Markup less than 8%.
 */
package gavincolemanfinalassessment;

import java.util.Scanner;

public class AssignmentQ20 
{
    //Something new - This is a quick way to create two arrays of the same type,
    //a multidemensional array.
    //Each element in the array is itself an array.
    //Declaring this outside a method makes it accessible to all methods in the
    //class
    static String[][] productTypeCodes = {{"DRY","Dairy"},{"FRO","Frozen"},{"HRW","Hardware"}};
    
    public static void main(String[] args)
    {
        String productCode = getValidProductCode("Please enter product code: ");
    }
    
    //-------------------------------------------------------------------------
    //getValidProductCode - asks the user (using the prompt string) to enter in
    //a product code. The method then validates the code
    
    static String getValidProductCode(String prompt)
    {
        Scanner kb = new Scanner(System.in);
        String code = "";
        boolean isValidCode = false;
        
        while(!isValidCode)
        {
            //get input
            System.out.println(prompt);
            code = kb.nextLine();
            
            //check if code is the correct length
            if(code.length()<7 || code.length()>8)
            {
                System.out.println("Code must be 7 or 8 characters long. Pls try again");
            }
            
            //check that the middle 3 characters hold a valid product type code
            else if(!isValidProductTypeCode(code.substring(3,6)))
            {
                System.out.println("Code must contain valid product code -\"DRY\",\"FRO\" or \"HRW\"");
            }
        }
        return code;
    }
    
    //--------------------------------------------------------------------------
    //isValidProductTypeCode - check to see if this is a valid product type code
    //by looking up the productTypeCode array
    static boolean isValidProductTypeCode(String productCode)
    {
        boolean isValid = false;
        for(int n=0; n<productCode.length(); n++)
        {
            //the first element of the array in the productTypeCodes array contains the type code
            if(productTypeCodes[n][0].equals(productCode))
            {
                isValid = true;
                break;
            }
        }
        return isValid;
    }
}
