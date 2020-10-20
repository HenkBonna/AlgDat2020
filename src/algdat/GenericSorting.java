package algdat;

import java.util.ArrayList;
import java.util.Arrays;

public class GenericSorting {

	public static class Person implements Comparable<Person> {
		String firstName;
		String lastName;

		Person(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public int compareTo(Person other) {
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
			if (lastCompare == 0) {
				return this.firstName.compareTo(other.firstName);
			} else {
				return lastCompare;
			}
		}
		public String toString(){
			return firstName + " " + lastName;
		}
	}

	public static void main(String[] args) {
		Integer[] a = {1, 8, 9, 18, 98, 3, 2, 9};
		Character[] b = {'A', 'C', 'K', 'Z', 'L', 'Y', 'M'};
		String[] c = {"ASF", "Kari", "poteter", "lammelår", "eple", "Petter"};
		Person[] d = {new Person("Petter", "Pettersen"), new Person("Kari", "Pettersen"), new Person("Nils", "Abrahamsen"), new Person("Tor", "Toresen")};

		int personMaxIndex = max(d, 0, d.length);
		System.out.println("Siste person, leksikografisk er " + d[personMaxIndex]);

		System.out.println("Sorterte opersnore");
		System.out.println("Før: " + Arrays.toString(d));
		sort(d);
		System.out.println("Etter: " + Arrays.toString(d));
	}

	static
	<T extends Comparable<? super T>>
	void sort(T[] values){
		// Loops over every entry except last
		for (int i = 0; i < values.length - 1; ++i){
			// Find largest element in interval (i, a.length)
			int maxIndex = max(values, i, values.length);
			// switch largest element to pos i
			T temp = values[i];
			values[i] = values[maxIndex];
			values[maxIndex] = temp;
			// continue
		}

	}

	static
	<T extends Comparable<? super T>>
	int max(T[] values, int begin, int end) {
		T current_max = values[begin];
		int current_index = begin;

		for (int i = 1; i < end; ++i) {
			//if(values[i] > current_max){
			if (values[i].compareTo(current_max) > 0) {
				current_max = values[i];
				current_index = i;
			}
		}
		return current_index;
	}
}