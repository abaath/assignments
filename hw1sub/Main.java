package hw1;
public class Main {
    /*
        5.
     */
	public static void squishArray(int[] numbers) {
	    if(numbers== null  || numbers.length== 0) {
	    	return;
	    }

	    int current= 0;
	    for(int next = 1; next < numbers.length; next++) {
	        if(numbers[next]!= numbers[current]) {
	        	current++;
	            if(current< numbers.length) {
	                numbers[current]=numbers[next];
	            }
	        }
	    }
	    

	    for(int i= current+ 1;i< numbers.length; i++) {
	        numbers[i] = -1;
	    }
	    
	}

    /*
        6.
     */
    public static String compressString(String s){
        // TODO
    	 if(s== null|| s.isEmpty()){
    		 return "string empty";
    	 }

    	 StringBuilder sb= new StringBuilder();
         int charCount=1;

       for(int i= 1; i< s.length(); i++) {
    	   if(s.charAt(i)== s.charAt(i- 1)) {
    		  charCount++;

    	   }else{
    		   char previousChar = s.charAt(i - 1);
    		   sb.append(charCount);
    		   sb.append(previousChar);
    		   charCount= 1;
            }
         }
       
      

       char lastChar=s.charAt(s.length() - 1);
       sb.append(charCount);
       sb.append(lastChar);     
       
       return sb.toString(); 
     }

}
