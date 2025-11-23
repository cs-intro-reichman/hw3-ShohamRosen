// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    //System.out.println(plus(2, 3));   // 2 + 3
	    //System.out.println(minus(-7,-2));  // 7 - 2
   		 //System.out.println(minus(2,7));  // 2 - 7
 		//System.out.println(times(3,-4));  // 3 * 4
   		//System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		//System.out.println(pow(5,3));      // 5^3
   		// System.out.println(pow(3,5));      // 3^5
   		//System.out.println(div(-12,3));   // 12 / 3    
   		// System.out.println(div(5,5));    // 5 / 5  
   		// System.out.println(div(25,7));   // 25 / 7
   		// System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		// System.out.println(sqrt(36));
		// System.out.println(sqrt(263169));
   		// System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int the_sum = x2 ; 
		if (x1 < 0){
			for (int t = 0 ; t != x1 ; t-- ){
				the_sum -- ;

			}
		}
		else if (x1 >= 0) {
			for (int i = 1 ; (i <= x1) ; i++ ) {
			the_sum  ++ ; 
			
		}
		}
		return the_sum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int the_sum = x1 ;
		if (x2 < 0){
			for(int i = -1; x2 <= i ; i --)
			the_sum ++ ; 
		}
		else if (x2 > 0) {
			for(int t = 0 ; t < x2; t ++){
				the_sum -- ;
			}
		}
		return the_sum;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
        int times_x = 0;
        boolean negative = false;

        if ((x1 < 0 && x2 > 0) || (x1 > 0 && x2 < 0)) {
            negative = true;
        }

        int absX1 = x1 < 0 ? minus(0, x1) : x1;
        int absX2 = x2 < 0 ? minus(0, x2) : x2;
        for (int i = 0; i < absX2; i++) {
            times_x = plus(times_x, absX1);
        }

        return negative ? minus(0, times_x) : times_x;
    
}


	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int summary = 0 ;
		if (n == 0) {
			summary = 1 ;
		}
		else if (x > 0) {
			summary = x; 
			for (int f = 1; f < n ; f++) {
				summary = times( summary, x); 

			}	

		}
		return summary;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int check = x1 ;
		int the_time = 0;
		boolean num_minus = false; 
		if (((x1 < 0) && (x2 > 0)) || ((x1 > 0) && (x2 < 0))) {  
			num_minus = true ;
		}

		if (x1 < 0) {
			check = minus(0, x1);
			x1 = check ; 
		}
		if (x2 < 0){
			x2 = minus(0, x2); 
		}
		check = x1 ;
		while (check >= x2){
			check = minus(check, x2) ;
			the_time ++ ;
		}

		if (num_minus) {
			the_time = minus(0, the_time);

		}

		
		return the_time ;
	}


	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int the_ans = 0;
		if (x1 < x2){ //if 2 % 7 == 2 
			the_ans = x1 ;
			return  the_ans ;
		}

		int x1_minus_x2 = x1 ; //x1 minus x2 after the loop 
		int num_of_time = 0 ; //number of time x2 in x1
		int num_of_x2_in_x1 = 0 ; //the answer (how many time x2 in x1) * x1
		int after_mod = 0; // x2 - num_ox_x2_in_x1 === the modulo 

		if (x1 > x2) { //if 7 % 2 =  
			while (x1_minus_x2 >= x2){
				x1_minus_x2 = minus(x1_minus_x2, x2) ; 
				num_of_time ++; 
			}
		num_of_x2_in_x1 = times(num_of_time, x2);
		after_mod = minus(x1, num_of_x2_in_x1);	
		}
		
		return after_mod;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		if (x == 0) {
			return 0;
		}
		if (x == 1) {
			return 1;
		}
		int count = 0;
		for (int i = 0; i <= x; i++) {
			if (times(i, i) == x) {
				return i;
			}
			if (times(i, i) > x) {
				return minus(i, 1);
			}
			count = i;
		}
		return count;
	}	  	   	  
}