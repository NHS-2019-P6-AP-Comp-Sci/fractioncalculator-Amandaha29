/**
 * @author Mr. Rasmussen
 */

package fracCalc;


import java.util.Scanner; 

public class FracCalc {

    public static void main(String[] args)
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner input = new Scanner(System.in);
    	System.out.println("Welcome to Frac Calc! please enter fractions"); 
    	
        // TODO: Read the input from the user and call produceAnswer with an equation
    	String initResponse = input.nextLine();
    	
    	
    	while(!initResponse.equals("quit")) {
    		
    	String result = produceAnswer(initResponse);
    	System.out.println(result);
	    System.out.println("Welcome to Frac Calc! please enter fractions"); 
    	initResponse = input.nextLine();
    	
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
    public static String produceAnswer(String input){
        // TODO: Implement this function to produce the solution to the input
    	String org = input;
    	
    	// split string into 3 parts
    	
    	// first Operand conversion
    	
    	String firstOper = org.substring(0,org.indexOf(" "));
    	
    	
    
        String firstWhole = Whole(firstOper); 
       String firstNum= Num(firstOper);
       String firstDem= Dem(firstOper);
       
    	int firstWholeNum = Integer.parseInt(firstWhole);	
       	int firstNumNum = Integer.parseInt(firstNum);		
       	int firstDemNum = Integer.parseInt(firstDem);
       	
       	org = org.substring(org.indexOf(" ")+1);
       
      // Operator
    	
    	String Operator = org.substring(0,org.indexOf(" "));
    	
    	
    	
   org = org.substring(org.indexOf(" ")+1);
   String secondOper = org;
   
   
    	
 
    String secondWhole = Whole(secondOper); 
    String secondNum= Num(secondOper);
    String secondDem= Dem(secondOper);
    
   	int secondWholeNum = Integer.parseInt(secondWhole);	
   	int secondNumNum = Integer.parseInt(secondNum);		
   	int secondDemNum = Integer.parseInt(secondDem);		
   	
  		
     Calculate(Operator,secondWholeNum,secondNumNum,secondDemNum,firstWholeNum,firstNumNum,firstDemNum);
     
     
    }
       
    
    
    

    
    // TODO: Fill in the space below with any helper methods that you think you will need
    
    public static void Calculate(String opperator,int secondWholeNum, int secondNumNum,int secondDemNum, int firstWholeNum, int firstNumNum, int firstDemNum) {
    	
    	
    	if (opperator.equals("+")) {
    		int WholeNum = secondWholeNum + firstWholeNum;
    		int NumNum = secondNumNum + firstNumNum;
    		System.out.println(WholeNum + NumNum);
 
    		
    	}
    	
    	else if (opperator.equals("-")) {
    		int WholeNum = secondWholeNum + firstWholeNum;
    		int NumNum = secondNumNum + firstNumNum;
    		System.out.println(WholeNum + NumNum);
 
    		
    	}
    	
    	
    	
    	else if (opperator.equals("/")) {
    		int WholeNum = secondWholeNum / firstWholeNum;
    		int NumNum = secondNumNum/ firstNumNum;
    		System.out.println(WholeNum + NumNum);
 
    		
    	}
    	
    	
    	else {
    		int WholeNum = secondWholeNum * firstWholeNum;
    		int NumNum = secondNumNum * firstNumNum;
    		System.out.println(WholeNum + NumNum);
 
    		
    	}
    	
    	
    	
    }
    
    
    
    
    
    
    public static String Whole(String str) {
    	
        if (str.indexOf("_") != -1) {
        	return str.substring(0,str.indexOf("_"));
        	
    
        }
        
        else if (str.indexOf("/") != -1) {
        	return "0";
       	
        }
        
        else {
        	return str;
        }
        
    }
    
    
    public static String Num(String str) {
        if (str.indexOf("_") != -1) {
        	return str.substring(str.indexOf("_")+1,str.indexOf("/"));
    
        }
        
        else if (str.indexOf("/") != -1) {
        	return str.substring(0,str.indexOf("/"));
       	
        }
        
        else {
        	return "0";
        }
          
    }
    
    public static String Dem(String str) {
        if (str.indexOf("/") != -1) {
        	return str.substring(str.indexOf("/")+1);
    
        }
        
        
        else {
        	return "1";
        }
          
    }
    
    
    

}
