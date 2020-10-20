package algdat;

import java.util.ArrayList;
import java.util.Arrays;

public class VisitorPatternTest {

	public static class Person{
		String firstName;
		String lastName;

		Person(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public String toString(){
			return firstName + " " + lastName;
		}
	}

	// An interface - ensuring all classes that implements this
	// contains these functions.
	@FunctionalInterface
	public interface Comparator<T> {
		int compare(T a, T b);
	}

	public static class DescendingPersonComparator
			implements Comparator<Person> {
		public int compare(Person a, Person b) {
			int lastCompare = a.lastName.compareTo(b.lastName);
			if (lastCompare == 0) {
				return a.firstName.compareTo(b.firstName);
			} else {
				return lastCompare;
			}
		}
	}

	public static class AscendingPersonComparator
			implements Comparator<Person> {
		public int compare(Person a, Person b) {
			int lastCompare = b.lastName.compareTo(a.lastName);
			if (lastCompare == 0) {
				return b.firstName.compareTo(a.firstName);
			} else {
				return lastCompare;
			}
		}
	}

	public static class OddEvenComparator
			implements Comparator<Integer> {
		public int compare(Integer a, Integer b){
			// Først sammenlikn "etternavn" => even or odd

			// both are even or both are even
			if (a % 2 == b % 2){
				return a.compareTo(b);
			}
			// a er oddetall, b er partall
			else if (a % 2 > b % 2){
				return 1;
			}
			// b er oddetall, a er partall
			else if (b % 2 > a % 2){
				return -1;
			}
			// NaN, infinity, etc. should throw excepttion
			return 0;
		}
	}

	/**
	 * Denne funksjonen finner største verdi i values.
	 * Bruker sammenlikningsfunksjonen i objektet comp for sammenlikning.
	 * @param values
	 * @param begin
	 * @param end
	 * @param comp
	 * @param <T>
	 * @return
	 */
	public static <T> int max(T[] values, int begin, int end, Comparator<T> comp){

		T current_max = values[begin];
		int current_index = begin;

		for (int i = 1; i < end; ++i) {
			//if(values[i] > current_max){
			if (comp.compare(values[i], current_max) > 0) {
				current_max = values[i];
				current_index = i;
			}
		}
		return current_index;

	}

	public static <T> void sort(T[] values, Comparator<T> comp){

		// Loops over every entry except last
		for (int i = 0; i < values.length - 1; ++i) {
			// Find largest element in interval (i, a.length)
			int maxIndex = max(values, i, values.length, comp);
			// switch largest element to pos i
			T temp = values[i];
			values[i] = values[maxIndex];
			values[maxIndex] = temp;
		}
	}

	public static void main(String[] args){
		Person[] persons = {new Person("Petter", "Pettersen"),
				new Person("Kari", "Pettersen"),
				new Person("Nils", "Abrahamsen"),
				new Person("Tor", "Toresen")};

		// 0 Lag comparator objektet
		// Vi kan nå kjøre comp.compare(a,b);
		AscendingPersonComparator comp_ascending = new AscendingPersonComparator();
		DescendingPersonComparator comp_descending = new DescendingPersonComparator();

		// 1 Lage sortering-funksjonen som tar in både person-arrayet og en sammenlikningsfunksjon
		System.out.println("Før sortering: " + Arrays.toString(persons));
		System.out.println("Sorterer!");
		sort(persons, comp_ascending);
		System.out.println("Etter sortering: (Ascending)" + Arrays.toString(persons));
		sort(persons, comp_descending);
		System.out.println("Etter sortering: (Descending)" + Arrays.toString(persons));
		System.out.println(Arrays.toString(persons));


		Integer[] integers = {9,8,7,6,5,4,3,2,1,0};

		// Vil sortere sånn at vi får oddetall til venstre, og partall til høyre
		// Partall og oddetall skal være inbyrdes sortert.
		OddEvenComparator oddEven = new OddEvenComparator();
		System.out.println("Før sortering: " + Arrays.toString(integers));
		sort(integers, oddEven);
		System.out.println("Etter sortering: " + Arrays.toString(integers));

		// Hva skal noe være?
		// - Partall og oddetalls-sjekk
		// - Skille mellom partall og oddetall
		// Tanke: Bruk "Er det partall?" som "etternavn", og så størrelse på tallet som "fornavn".
		// 'noe' må være en Komparator<T>

	}
}
