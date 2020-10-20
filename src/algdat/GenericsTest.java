package algdat;

public class GenericsTest {

	public static void main(String[] args){
		Integer[] a = {1,8,9,18,98,3,2,9};
		Character[] b = {'A', 'C', 'K', 'Z', 'L', 'Y', 'M'};
		String[] c = {"ASF","Kari","poteter","lammelår","eple","Petter"};
		Person[] d = {new Person("Petter", "Pettersen"), new Person("Kari", "Pettersen"), new Person("Nils", "Abrahamsen"), new Person("Tor", "Toresen")};


		System.out.println("Maks av int-array:");
		System.out.println(max(a));

		System.out.println("Maks av char-array:");
		System.out.println(max(b));

		System.out.println("Generic Maks av int-array:");
		System.out.println(max_generic(a));

		System.out.println("Generic Maks av char-array:");
		System.out.println(max_generic(b));

		System.out.println("Generic Maks av string-array:");
		System.out.println(max_generic(c));

		System.out.println("Generic Maks av person-array:");
		System.out.println(max_generic(d));
	}

	// Denne følgende metoden fungerer for alle datatyper som implementerer Comparable interface'et
	static <T extends Comparable<? super T>> int max_generic(T[] values) {
		T current_max = values[0];
		int current_index = 0;

		for (int i = 1; i < values.length; ++i) {
			//if(values[i] > current_max){
			if (values[i].compareTo(current_max) > 0) {
				current_max = values[i];
				current_index = i;
			}
		}
		return current_index;
	}

	public static class Person implements Comparable<Person>{
		String firstName;
		String lastName;

		Person(String firstName, String lastName){
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public int compareTo(Person other){
			/*
			 if (thislastName  < other.lastName){
			 	return -1;
			 }
			 else if (this.lastName == other.lastName){
			 	return 0;
			 }
			 else {
			 	return 1;
			 }
			 */
			int lastCompare = this.lastName.compareTo(other.lastName);
			if (lastCompare == 0){
				return this.firstName.compareTo(other.firstName);
			}
			else{
				return lastCompare;
			}
		}
	}

	// Non-generic methods
	static int max(Integer[] values){
		int current_max = values[0];
		int current_index = 0;

		for(int i = 1; i < values.length; ++i){
			if(values[i] > current_max){
				current_max = values[i];
				current_index = i;
			}
		}
		return current_index;
	}
	static int max(Character[] values){
		char current_max = values[0];
		int current_index = 0;

		for(int i = 1; i < values.length; ++i){
			if(values[i] > current_max){
				current_max = values[i];
				current_index = i;
			}
		}
		return current_index;
	}
}
