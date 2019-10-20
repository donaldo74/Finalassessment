package gavincolemanfinalassessment;


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
