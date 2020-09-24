package algdat;

public class LecturesWeek3 {
	// Usortert søk, sortert søk, binærsøk

	static int usortertSok(int[] a, int value){
		for (int i = 0; i < a.length; ++i){
			if (a[i] == value){
				return i;
			}
		}
		return -1;
	}

	static int sortertSok1(int[] a, int value){
		for (int i = 0; i < a.length; ++i){
			if(a[i] == value){
				return i;
			}
		}
		return -1;
	}

	static int sortertSok2(int[] a, int value){
		int stepLength = 2;
		for (int i = 0; i < a.length; i = i + stepLength){ // i + can effectivize quite a bit.
			if (a[i] >= value){
				int begin = i - stepLength;
				int end = i + 1;
				// This block is in essence the same code as sortertSok1
				for (int j  = begin; j < end; ++j){
					if (a[j] == value){
						return j;
					}
				}
				return -1;
				//
			}
		}
		return -1;
	}
	// binærsøk


	public static void main(String[] args){
		int[] a = {9,3,2,7,4};
		int[] b = {2,3,4,7,9};		// gjennomgang av logikk for binary search
		int[] c = {2,3,4,7,9};	// siden 6 >= 4 søker vi i [m,h]
			//	   v	   h
			// m = (v+h) / 2 = (0+4) / 2 = 2
			// => (4,7,9)
			//	   v   h
			//	m = (v+h) / 2 = (2+4) / 2 = 3	// Siden 6 < 7, søker vi i [v, m-1]
			//	4
			//	v=2, h=2, m=2

		usortertSok(a, 4);



	}

}
