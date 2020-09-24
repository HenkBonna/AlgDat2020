package algdat;

public class Forelesning010920 {

	/* 	Notes



	 */
	// Kildekode-skisse til Quicksort v1
	/*
	void quicksort(int[] a, int begin, int end){
		if(begin+1 = end){ // Stop kriterie
			return;
		}
		int p = byttPivotBakerst(a, begin, end); // Vi lar byttPivotBakerst også returnere pivoten sin verdi, p
		int q = partisjoner(a, p, begin, end);	// (Skal gjøre dette i oblig) returnerer index til sortert posisjon
		byttPivotTilbake(a, end-1, q);
		quicksort(a, begin, q);
		quicksort(a, q+1, end);
	}
	 */

	public static void main(String[] args){
		int[] a = {2,7,8,4,7,2};


	}

}
