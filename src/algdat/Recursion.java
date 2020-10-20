package algdat;
// Forelesninger uke5
public class Recursion {

	public static void main(String[] args){
		int value = 15;
		int returnValue = recursiveFunction(value);
		System.out.println("Main: " + returnValue);

		System.out.println("5!: " + factorial(5));
		System.out.println("8!: " + factorial(8));

	}

	static int factorial(int n){
		if (n == 1){
			return 1;
		}
		else{
			return n * factorial(n-1);
		}
	}

	// Dummy testfunction
	static int recursiveFunction(int value){
		System.out.println("Recursive funtion:" + value);

		if (value <= 5){
			return -9;
		}
		else {
			return recursiveFunction(value - 1);
		}
	}

}
