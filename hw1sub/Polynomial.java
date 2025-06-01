package hw1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Polynomial<T> {
    private double [] coefficients;
    private int power;
    public Polynomial(int power, double[] coefficients){
        if(coefficients.length != power + 1){
            String errorString = "Mismatched number of coefficients for degree %d polynomial";
            throw new IllegalArgumentException(String.format(errorString, power));
        }
        this.power = power;
        this.coefficients = coefficients;
    }

    // Returns the degree of the polynomial
    public int getPolynomialDegree(){
        return this.power;
    }

    /*
        Get the coefficient ak.
        If a polynomial can be written as p = a0 + a1 * x + a2 * x^2 + ...,
        getKthCoefficient(0) will return a0, getKthCoefficient(1) returns a1 and so on.
     */
    public double getKthCoefficient(int k){
        if(k < 0 || k > getPolynomialDegree()){
            String errorString = "Invalid requested term for a polynomial of degree %d";
            throw new IllegalArgumentException(String.format(errorString, getPolynomialDegree()));
        }
        return coefficients[k];
    }

    // 2. Return a polynomial that represents the derivative of the Polynomial
    public Polynomial getDerivative(){
        // Do not remove this condition
        if(getPolynomialDegree() == 0){
            return new Polynomial(0, new double[0]);
        }
        // TODO
        double[] derivativeCoefficients= new double[power];
        for(int i=1; i<= power; i++) {
            derivativeCoefficients[i- 1]= coefficients[i]* i;
        }
        return new Polynomial(power- 1, derivativeCoefficients);
      //  return null;
    }

    // 3. Evaluate the polynomial at the given point x
    public double evaluatePolynomial(double x){
        // TODO
    	 double result= 0;
    	    double exponent= 1; // x^i

    	    for(int i= 0;i <= power; i++) {
    	        result+= coefficients[i]* exponent; // x^i
    	        exponent*= x; 
    	    }
//
//    	    if (result == 0) {
//    	        return result;
//    	    }else {
//    	        return result;
//    	    }
    	    return result;
    }

    public boolean equals(Polynomial p) {
        if (p == null) {
            return false;
        } else if(p.getPolynomialDegree() != this.getPolynomialDegree()){
            return false;
        }

        int polyDegree = this.getPolynomialDegree();
        for(int k = 0; k <= polyDegree; k++){
            if(getKthCoefficient(k) != p.getKthCoefficient(k)){
                return false;
            }
        }
        return true;
    }
}
