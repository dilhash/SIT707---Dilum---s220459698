package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class ConditionalLoopUtils {
	
    @Test
    public void testTrueForEvenNumber() {
      boolean result = WeatherAndMathUtils.isEven(14);
      Assert.assertTrue(result==true);
    }

    @Test
    public void testFalseForEvenNumber() {
      boolean result = WeatherAndMathUtils.isEven(21);
      Assert.assertTrue(result==false);
    }
    @Test
    public void testTrueForPrimeNumberFornumber1() {
      boolean result = WeatherAndMathUtils.isPrime(1);
      Assert.assertTrue(result==true);
    }
    
    @Test
    public void testTrueForPrimeNumberFornotnumber1() {
      boolean result = WeatherAndMathUtils.isPrime(3);
      Assert.assertTrue(result==true);
    }
    
    
    @Test
    public void testFalseForPrimeNumber() {
      boolean result = WeatherAndMathUtils.isPrime(12);
      Assert.assertTrue(result==false);
    }
    

}
