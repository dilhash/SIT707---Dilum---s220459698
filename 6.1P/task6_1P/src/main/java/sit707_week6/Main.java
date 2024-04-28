/***
 package sit707_week6;

import java.text.SimpleDateFormat;
import java.util.Date;


//	public static final double DANGEROUS_WINDSPEED = 70.0;
//	public static final double DANGEROUS_RAINFALL = 6.0;
//	public static final double CONCERNING_WINDSPEED = 45.0;
//	public static final double CONCERNING_RAINFALL = 4.0;


public class Main 
{
    public static void main( String[] args )
    {

     // Example 3: Warning - Concerning Wind Speed
        System.out.println("Warn weather testing  - windSpeed  exceeds CONCERNING_WINDSPEED");
        double windSpeed3 = 46.0;
        double rainfall3 = 3.0;
        String advice3  = WeatherAndMathUtils.weatherAdvice(windSpeed3, rainfall3);
        System.out.println("Advice =  "  + advice3);

        
        // Example 2: Warning - Concerning Wind Speed
        System.out.println("Warn weather testing  - precipitation exceeds CONCERNING_RAINFALL");
        double windSpeed4 = 30.0;
        double rainfall4 = 5.0;
        String advice4  = WeatherAndMathUtils.weatherAdvice(windSpeed4, rainfall4);
        System.out.println("Advice =  "  + advice4);

        // Example 5: Warning - Concerning Wind Speed
        System.out.println("Cancle weather testing  - 	precipitation exceeds DANGEROUS_RAINFALL");
        double windSpeed5 = 30.0;
        double rainfall5 = 6.1;
        String advice5  = WeatherAndMathUtils.weatherAdvice(windSpeed5, rainfall5);
        System.out.println("Advice =  "  + advice5);

        // Example 2: Warning - Concerning Wind Speed
        System.out.println("Normal");
        double windSpeed6 = 30.0;
        double rainfall6 = 2.0;
        String advice6  = WeatherAndMathUtils.weatherAdvice(windSpeed6, rainfall6);
        System.out.println("Advice =  "  + advice6);

        
        
        
    }
}

**/
