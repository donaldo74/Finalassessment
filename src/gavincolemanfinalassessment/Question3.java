package gavincolemanfinalassessment;

import java.util.Scanner;
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
    static String[] bands = {"backstreet boys","chicago","queen","foreigner"};
    static double[] sales = {37,38.5,34.5,37.5};
    
    public static void main(String[] args)
    {
        DisplayBandsAboveAverage();
        ViewBandSales();
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
