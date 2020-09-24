package algdat;

public class TernaryIf {
	public static void main(String[] args) {
		for (int i = 0; i < 10; ++i) {
			int a = i;
			int b = myTernaryIfTest(a);
			System.out.println(b);
		}
	}
	public static int myTernaryIfTest(int value){

		/*
		if (value < 5){
			return 0;
		}
		else{
			return 98;
		}
		 */
		// Altarnative for above:
		return (value < 5) ? 0 : 98;


	}


}
