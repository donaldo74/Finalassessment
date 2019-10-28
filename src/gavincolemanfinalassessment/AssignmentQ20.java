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
        int markUp = getMarkUp(productCode);
        if(markUp >=8)
        {
            Display("This " + getProductType(productCode) + " product is supplied by supplier "
            + getSupplierId(productCode) + " and the markup is " + markUp + "%" +"\n");
        }
        else
        {
            Display("Markup is less than 8%");
        }
    }
    
    //e.------------------------------------------------------------------------
    //Display - displays the string on the command line.
    static void Display(String str)
    {
        System.out.print(str);
    }
    
    //d.------------------------------------------------------------------------
    //getMarkUp - gets the last one or two digits from the code which represent
    //the markup
    static int getMarkUp(String productCode)
    {
        String markUp = productCode.substring(6);
        return Integer.valueOf(markUp);
    }
    
    //b.------------------------------------------------------------------------
    //getProductType - examine the product code to find and return the product type
    static String getProductType(String productCode)
    {
        String productType = "";
        //first cut the product type from the product code.
        String typeCode = productCode.substring(3,6);
        //the codes are stored in a 2 dimensional array, each element is an array
        //of 2 values.
        //loop through the array, getting the prod array for each code, this 
        //contains the code and the type.
        for(String[]prod : productTypeCodes)
        {
            //check if typeCode matches the first element.
            if(prod[0].equals(typeCode))
            {
                //if it does, assign the second element to productType, exit the
                //loop once its been found.
                productType = prod[1];
                break;
            }
        }
        return productType;
    }
    //c.-----------------------------------------------------------------------
    //getSupplierId - returns the supplier code from the product code, which is
    //contained in the first three characters.
    
    static String getSupplierId(String productCode)
    {
        return productCode.substring(0,3);
    }
    //a.-----------------------------------------------------------------------
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
            
            //check the last one or two characters are numbers
            else if( !isNumber(code.substring(6)))
            {
                System.out.println("Characters after product numbers must be numbers, representing markup, Please try again");
            }
            else
            {
                System.out.println("Code is valid");
                isValidCode = true;
            }
        }
        return code;
    }
    
    //--------------------------------------------------------------------------
    //Helper method to check if the string is a number
    static boolean isNumber(String str)
    {
        boolean isNum = true;
        for(char c: str.toCharArray())
        {
            if(!Character.isDigit(c))
            {
                isNum = false;
                break;
            }
        }
        return isNum;
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
