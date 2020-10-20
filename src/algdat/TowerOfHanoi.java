package algdat;

public class TowerOfHanoi {

	public static void main(String[] args){

		towerOfHanoi('A','B','C',5);

	}

	/**
	 * Solves tower of Hanoi puzzle
	 * @param a => start pin with disks
	 * @param b => helping-pin
	 * @param c => the pin we end on
	 */

	public static void towerOfHanoi(char a, char b, char c, int brikkeNr){
		if (brikkeNr == 0){
			return;
		}
		// Flytt alle untatt nederste fra A til B (Hjelpepinnen)

		towerOfHanoi(a,c,b, brikkeNr-1);

		// Flytt nederste fra A til C
		System.out.println("Flytter brikke " + brikkeNr + " fra " + a + " til " + c);

		towerOfHanoi(b,a,c, brikkeNr-1);


		// Flytt alle fra B til C

	}

}
