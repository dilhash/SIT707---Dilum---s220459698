package web.service;

public class MathQuestionService {

	/**
	 * Calculate Q1 result.
	 * @param number1
	 * @param number2
	 * @return
	 */
	public static double q1Addition(String number1, String number2) {
		if ((numberValidation(number1) && numberValidation(number2))==true) {
            double result = Double.parseDouble(number1) + Double.parseDouble(number2);
            return result;
        } else {
            // Return NaN (Not a Number) to indicate an error
            return Double.NaN;
        }
		
	}
	
	/**
	 * Calculate Q2 result.
	 * @param number1
	 * @param number2
	 * @return
	 */
	public static double q2Subtraction(String number1, String number2) {
		if ((numberValidation(number1) && numberValidation(number2))==true) {
			double result = Double.valueOf(number1) - Double.valueOf(number2);
            return result;
        } else {
            // Return NaN (Not a Number) to indicate an error
            return Double.NaN;
        }
	}
	
	/**
	 * Calculate Q2 result.
	 * @param number1
	 * @param number2
	 * @return
	 */
	public static double qa3multipy(String number1, String number2) {
		if ((numberValidation(number1) && numberValidation(number2))==true) {
			double result = Double.valueOf(number1) * Double.valueOf(number2);
            return result;
        } else {
            // Return NaN (Not a Number) to indicate an error
            return Double.NaN;
        }
	}
	
	public static boolean numberValidation(String number) {
	    try {
	        // Attempt to parse the input strings to doubles
	        double validatenumber = Double.parseDouble(number);
	        // If parsing succeeds, return true
	        return true;
	    } catch (NumberFormatException e) {
	        // If parsing fails for either number, return false
	        return false;
	    }
	}

}
