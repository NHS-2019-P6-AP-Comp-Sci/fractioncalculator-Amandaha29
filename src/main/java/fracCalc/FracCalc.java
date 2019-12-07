/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) 
    { 
    	{
    		System.out.println("Welcome to Frac Calc! please enter fractions. Enter \"quit\" if you would like to exit FracCalc."); 

    		Scanner response = new Scanner(System.in);
    		String input = response.nextLine(); // input is what the user enters
    		
    		
    		
    		while(!input.equalsIgnoreCase("quit")) // while the user has not typed quit or Quit run the function 
			{
    			System.out.println(produceAnswer(input));
    			
    			System.out.println("Welcome to Frac Calc! please enter fractions. Enter \"quit\"  if you would like to exit FracCalc."); 
    	    	input = response.nextLine();

			}
    		
   
    		response.close();
    		System.out.println("Thank you for using FracCalc. Goodbye.");
    	}
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
		
		// Gets terms based on where the spaces are 
		int space = input.indexOf(" ");
		if (space == -1)
		{
			return ("statement invalid");
		}
		else
		{		
			// Get parts of calculation 
			
			
			String token = getPt(input);
			input = removePt(input);
			parseFraction(token);
			
			
			
			int firstNumerator = finalNumerator;
			int firstDenominator = finalDenominator;
			
			token = getPt(input);
			input = removePt(input);
			String Operator = token;
			
			token = getPt(input);
			input = removePt(input);
			parseFraction(token);
			int secondNumerator = finalNumerator;
			int secondDenominator = finalDenominator;
			
			
	

			boolean calcCheck = false;

            calcCheck = calculate(firstNumerator, firstDenominator, secondNumerator, secondDenominator, Operator);
		
		
			if (calcCheck)
			{
				return printFraction(finalNumerator, finalDenominator);
			}
			else 
			{
				
				return "error detected.";
			}
		}
    }

    // TODO: Fill in the space below with any helper methods that you think you will need

//get parts to calculate
    
	private static String getPt(String input)
	{
		
		int space = input.indexOf(' ');
		if (space == -1)
			return input;
		return input.substring(0, space);
	}
	
	
	public static String removePt(String input)
	{
	
		int space = input.indexOf(" ");
		if (space == -1)
			return "";
		return input.substring(space + 1);
	}



	
	static int finalNumerator;
	static int finalDenominator;


// do calculation 
	public static boolean calculate(int num1, int dem1, int num2,
			int dem2, String operator)
	{
		if (operator.equals("+"))
		{
			finalNumerator = num1 * dem2 + num2 * dem1;
			finalDenominator = dem1 * dem2;
		}
		else if (operator.equals("-"))
		{
			finalNumerator = num1 * dem2 - num2 * dem1;
			finalDenominator = dem1 * dem2;
		}
		else if (operator.equals("*"))
		{
		    finalNumerator = num1 * num2;
			finalDenominator = dem1 * dem2;
		}
		else if (operator.equals("/"))
		{
			finalNumerator = num1 * dem2;
			finalDenominator = dem1 * num2;
		}
		
		// check for format error
		else
		{
			System.out.println("ERROR: Input is in an invalid format.");
			return false;
		}
		return true;
	}

	
	

	private static void parseFraction(String input)
	{

		int underscore = input.indexOf('_');
		int slash = input.indexOf('/');
		if (underscore > 0)
		{
			// mixed number.
			int whole = Integer.parseInt(input.substring(0, underscore));
		    finalNumerator = Integer.parseInt(input.substring(underscore + 1, slash));
			
			if (whole < 0)
			finalNumerator = 0 - finalNumerator;
			finalDenominator = Integer.parseInt(input.substring(slash + 1));
			finalNumerator =finalNumerator + whole * finalDenominator;
		}
		else if (slash > 0)
		{

			finalNumerator = Integer.parseInt(input.substring(0, slash));
			finalDenominator = Integer.parseInt(input.substring(slash + 1));
		}
		else
		{
			// whole number.
			finalNumerator = Integer.parseInt(input);
			finalDenominator = 1;
		}
	}
	
	
	
	// Simplify and print fraction.
	private static String printFraction(int numerator, int denominator)
	{
		String result = "";
	// if denominator is negative make numerator negative instead
		if (denominator < 0)
		{
			denominator = Math.abs(denominator) ;
			numerator = 0 - numerator;
		}
		if (numerator < 0)
		{
	// print "-" with negative fractions 
			result += "-";
			numerator = Math.abs(numerator);
		}
			
		
	// find common denominator 
		int commonDem = findDem(numerator, denominator);
		numerator = numerator / commonDem;
		denominator = denominator / commonDem;

	//  simplify to  mixed number.
		int wholeNum = numerator / denominator;
		numerator = numerator % denominator;


		if (numerator == 0)
		{
			result += wholeNum;
		}
		else
		{
			if (wholeNum > 0)
			{
		
				result += (wholeNum + "_");
		}
		
			result += (numerator + "/" + denominator);
		}
		return result;
	}

	
	
	

	private static int findDem(int num, int dem)
	{
		while (true) {
			if (num < dem) {
				int t = num;
				num = dem;
				dem = t;
			}
			if (dem == 0)
				return num;
			num = num % dem;
		}
	}

}






