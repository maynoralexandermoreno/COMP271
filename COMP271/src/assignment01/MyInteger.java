/*
 * Note: 
 * Static methods are methods you can call without creating an object. For example, you don't need to create a Math object to call Math.pow(x,y);
 * Non-static methods are methods you need to make objects for in order to call. For example, you need a String object before you can call toUpperCase();
 * 
 * This is why isEven(), isOdd(), and isPrime() are non-static methods, since they need to be called using a MyInteger object.
 * 		In other words, they answer the question of is MyInteger even, odd, or prime.
 * This is why isEven(int), isOdd(int), and isPrimen(int) are static methods, since return information is not about the MyInteger object, but rather any int.
 * 		In other words, they answer the question of is this int even, odd, or prime.
 * isEven/Odd/Prime(MyInteger) can, in this instance, either be static or non-static, since the information asked but the problem asks it to be static.
 * 		An example of where it would need to be static is the String function isEqualTo(String s).
 */

package assignment01;

public class MyInteger {
	
//the integer value, set to private so as to prevent it from being changed by other programs without going through the program	
	private int value = 0 ;
	
//the MyInteger constructor
	public MyInteger(int value){
		this.value = value;
	}

//the MyInteger value Getter
	public int getInteger(){
		return value;
	}

//the "is MyInteger even, odd, prime" questions; these are methods that only the object itself can call.
	public boolean isEven(){
		if (this.value % 2 == 0){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean isOdd(){
		if (this.value % 2 != 0){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean isPrime(){
		double sqrt = Math.sqrt(this.value);		
		
		for (int i = 2; i <= sqrt; i++ ){
			if (this.value % i == 0){
				return false;
			}	
		}
		return true;
	}
	
//The "is this other, random integer even, odd, or prime" question
	public static boolean isEven(int x){
		if (x % 2 == 0){
			return true;
		}
		else{
			return false;
		}
	}
	public static boolean isOdd(int x){
		if (x % 2 != 0){
			return true;
		}
		else{
			return false;
		}
	}
	public static boolean isPrime(int x){
		double sqrt = Math.sqrt(x);		
		
		for (int i = 2; i <= sqrt; i++ ){
			if (x % i == 0){
				return false;
			}	
		}
		return true;
	}
	
//The questions, with MyInteger object as a parameter. 
	public static boolean isEven(MyInteger y){
		if (y.value % 2 == 0){
			return true;
		}
		else{
			return false;
		}
	}	
	public static boolean isOdd(MyInteger y){
		if (y.value % 2 != 0){
			return true;
		}
		else{
			return false;
		}
	}
	public static boolean isPrime(MyInteger y){
		double sqrt = Math.sqrt(y.value);		
		
		for (int i = 2; i <= sqrt; i++ ){
			if (y.value % i == 0){
				return false;
			}	
		}
		return true;
	}
	
//The question of does it equal the specified numbers for an int and a MyInteger object
	public boolean equals(int x){
		if (this.value == x){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean equals(MyInteger y){
		if (this.value == y.value){
			return true;
		}
		else{
			return false;
		}
	}

//the methods to create int values from either an array of numeric characters or a string
	public static int parseInt(char[] x){
		String temp = new String(x);
		int i = Integer.parseInt(temp);
		return i;	
	}
	public static int parseInt(String s){
		int i = Integer.parseInt(s);
		return i;
	}
}
