package algdat;

import java.util.Arrays;
import java.util.Random;

public class Tabell {

	public static void bytt(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void bytt(char[] c, int i, int j){
		char temp = c[i];
		c[i] = c[j];
		c[j] = temp;
	}

	public static int[] randPerm(int n){	// Creates a random permutation of given length n
		Random r = new Random();
		int[] a = new int[n];

		Arrays.setAll(a, i -> i + 1);

		for (int k = n-1; k > 0; --k){
			int i = r.nextInt(k+1);
			bytt(a,k,i);
		}
		return a;
	}

	public static void randPerm(int[] a){	// Shuffles values of a given array
		Random r = new Random();

		for (int k = a.length - 1; k > 0; --k){
			int i = r.nextInt(k+1);
			bytt(a,k,i);
		}
	}

	public static int max(int[] a, int from, int to){
		if (from < 0 || to > a.length || from >= to){	// Checking that range makes sense
			throw new IllegalArgumentException("Illegalt intervall!");
		}
		int max_pos = from;
		int max_val = a[from];

		for (int i = from+1; i < to; ++i){
			if (a[i] > max_val){
				max_pos = i;
				max_val = a[i];
			}
		}
		return max_pos;
	}

	public static int max(int[] a){
		return max(a,0, a.length);
	}


	public static int min(int[] a, int from, int to){	// Returns min of given range
		if (from < 0 || to > a.length || from >= to){	// Checking that range makes sense
			throw new IllegalArgumentException("Illegalt intervall!");
		}
		int min_pos = from;
		int min_val = a[from];

		for (int i = from+1; i < to; ++i){
			if (a[i] < min_val){
				min_pos = i;
				min_val = a[i];
			}
		}
		return min_pos;
	}
	public static int min(int[] a){	// Returns min of whole array
		return(min(a, 0, a.length));
	}

	public static void skriv(int[] a, int from, int to){
		System.out.print(a[from]);
		for (int i = from + 1; i < to; ++i){
			System.out.print(" " + a[i]);
		}
	}

	public static void skriv(int[] a){
		skriv(a,0,a.length);
	}


}
