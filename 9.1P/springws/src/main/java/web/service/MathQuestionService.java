package web.service;

public class MathQuestionService {

	/**
	 * Calculate Q1 result.
	 * @param number1
	 * @param number2
	 * @return
	 */
	public static double q1Addition(String number1, String number2) {
		double result = Double.valueOf(number1) + Double.valueOf(number2);
		return result;
	}
	
	/**
	 * Calculate Q2 result.
	 * @param number1
	 * @param number2
	 * @return
	 */
	public static double q2Subtraction(String number1, String number2) {
		double result = Double.valueOf(number1) - Double.valueOf(number2);
		return result;
	}
	
	/**
	 * Calculate Q2 result.
	 * @param number1
	 * @param number2
	 * @return
	 */
	public static double qa3multipy(String number1, String number2) {
		double result = Double.valueOf(number1) * Double.valueOf(number2);
		return result;
	}
	
	public static boolean numberValidation(String number1, String number2, String number3) {
	    try {
	        // Attempt to parse the input strings to doubles
	        double num1 = Double.parseDouble(number1);
	        double num2 = Double.parseDouble(number2);
	        double num3 = Double.parseDouble(number3);
	        // If parsing succeeds, return true
	        return true;
	    } catch (NumberFormatException e) {
	        // If parsing fails for either number, return false
	        return false;
	    }
	}

}
