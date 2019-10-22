package gavincolemanfinalassessment;

import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author Gavin
 */
public class Question3 
{
    // a). Write the code to declare the arrays and populate them
    //     with the sample data.
    // By declaring these arrays outside a function (but still in the class)
    // they can still be accessed by all methods.
    static String[] bands = {"backstreet boys","chicago","queen","foreigner","INXS"};
    static double[] sales = {37,38.5,34.5,37.5,43};
    
    public static void main(String[] args)
    {
        DisplayBandsAboveAverage();
        ViewBandSales();
        CreateRapperName();
    }
    
    /* 
    (iii) CReate the rapper name for the bands. The rapper name should be
    stored in a parallel array called rapper[]. When all the rapper names 
    have been created, each band's name and rapper name should be displayed.
    */
    static void CreateRapperName()
    {
        String [] rapper = new String[bands.length];
        
        //Print out each band and its rapper name.
        System.out.println("band\t\tRapper");
        for(int n=0; n<rapper.length; n++)
        {
            rapper[n] = ConstructRapperName(bands[n]);
            System.out.println(bands[n] + "\t" + rapper[n]);
        }
    }
    
    // I found it easier to split out the name construcyion into a 
    // separate method. It makes it easier to see whats going on in 
    // CreateRapperName. This method creates a rapper name for the
    // band name.
    static String ConstructRapperName(String name)
    {
        //Setup array with cartoon characters
        String [] cartoon = {"popeye_the_sailor_man","goofy","tweety&sylvester","snoopy","yogi","tom&gerry","topcat"};
        //Get first character
        String firstChar = name.substring(0,1);
        
        //Generate random number to select cartoon character;
        Random ran = new Random();
        int r = ran.nextInt(cartoon.length);
        String character = cartoon[r];
        
        //Make rapper name from first char and cartoon character
        String rapperName = firstChar + character;
        
        //If the name is too long, then truncate it.
        if(rapperName.length()>= 10)
        {
            rapperName = rapperName.substring(0,10);
        }
        else
        {
            //If name is less than 10 chars, add e up to the last but 1 character
            //and then postfix with az.
            int shortBy = 10 - rapperName.length();
            for(int n=0; n< shortBy-1;n++)
            {
                rapperName = rapperName + "e";
            }
            rapperName += "z";
        }
        return rapperName;
    }
    
    
    // (ii). Allow the user to enter the name of a band anddisplay it's
    //  sales or an error message if the band does not exist in the array.
    static void ViewBandSales()
    {
        Scanner kb = new Scanner(System.in);
        System.out.println("Please enter name of band: ");
        String band = kb.nextLine();
        int idx = -1;
        for(int n=0; n< bands.length; n++)
        {
            if(band.equals(bands[n]))
            {
                idx = n;
                break;
            }
        }
        
        if(idx != -1)
        {
            System.out.println("Sales for " + bands[idx] + " = " + sales[idx]);
        }
        else
        {
            System.out.println("Band name " + band + " not found.");
        }
    }
    
    
    // (i). Calculate and display the average sales and the name(s) of bands
    // with more than average sales.
    static void DisplayBandsAboveAverage()
    {
        //Calculate average
        double sum = 0.0;
        for(int n=0; n< sales.length; n++)
        {
            sum += sales[n];
        }
        double average = sum/sales.length;
        System.out.println("Average sales = " + average);
        
        //Display bands with sales better than average.
        System.out.println("Bands with sales above average: ");
        for(int n=0; n<sales.length; n++)
        {
            if(sales[n] > average)
            {
                System.out.println(bands[n]+ " (" + sales[n] + ")");
            }
        }
    }
}
