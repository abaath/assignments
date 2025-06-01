package hw1;
import java.util.*;
public class Calculator {

    /* 1. Evaluate a mathematical string that consists of addition and subtraction operators.
          Example: "12+5-3" ----> 14

       Extra Credit: Have your function also handle multiplication and division. Remember the
       order of operations matters!
     */
	public int evaluateString(String s) {
	    if(s==null || s.isEmpty()) {
	        return Integer.SIZE;
	    }

	    List<Integer> numbers= new ArrayList<>();
	    List<Character>operators= new ArrayList<>();

	    int num = 0;
	    char last= '+';//initialize
	  for(int i= 0;i< s.length();i++) {
	    char ch= s.charAt(i);

	    if(Character.isDigit(ch)) {
	    	num= num* 10+ (ch -'0');
	            
	        }

	        if(!Character.isDigit(ch) && ch != ' ' || i == s.length() - 1) {
	            if(last=='*') {
	                int prev= numbers.remove(numbers.size() - 1);
	         
	                numbers.add(prev* num);
	                
	            }else if(last=='/') {
	                int prev= numbers.remove(numbers.size() - 1);
	                numbers.add(prev/ num);
	                
	            }else {
	                numbers.add(num);
	              //  operators.add(lastOp);
	            }
	            operators.add(last);

	            last= ch;
	            num= 0;
	        }
	    }

	    if(numbers.isEmpty()) 
	    	{
	    	return (Integer) null;
	    	}

	    int result= numbers.get(0);
	    
	    
	    for(int i= 1;i< numbers.size(); i++) {
	        char op=operators.get(i- 1);
	        
	        
	        if(op=='+') {
	            result+= numbers.get(i);
	          //  return[numbers.get(i)];
	        }else if (op== '-') {
	            result= result -numbers.get(i);
	        }
	    }
	    
	    

	    return result;
	}
	



    /*
        4. Find the root of the Polynomial using the Newton-Raphson method starting at the point x.
        Note that we defined a variable called tolerance. Use this threshold when determining whether
        your algorithm has converged or not.
     */
	 public double newtonRaphson(Polynomial p, double initialGuess) {
	        double tolerance = .001;
	        double x= initialGuess;
	        double h= 0.00001;

	        while(true) {
	            double fx= p.evaluatePolynomial(x);
	            double dfx=(p.evaluatePolynomial(x + h)- p.evaluatePolynomial(x - h)) / (2 * h);//derivativr

	            if(Math.abs(dfx)< 1e-10) {
	            	break;
	            	}

	            double next= x - fx / dfx;
	            if(Math.abs(next - x)< tolerance) {
	                x= next;
	                break;//value close enough makes it false
	            }x= next;
	        }

	        return x;
	    }
}