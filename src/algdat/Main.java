package algdat;

import java.util.ArrayList;

public class Main {

	/**
	 * Short method for calculating and printing the LIX value of
	 * a given piece of text.
	 * This is a simplification of the LIX calculation.
	 * By splitting the lines at spaces, " " and periods "\\.",
	 * we can roughly divide the words and sentences. However,
	 * this does not count quite every word, as some sentences
	 * may end in "!", "?" or any other non-period symbol This
	 * could be fixed, however it was deemed unnecessary to spend
	 * time doing so for this project.
	 */

	public static String LIX(String tekst) {

		// Create arrays for words, and sentences
		String[] words = tekst.split(" ");
		String[] sentences = tekst.split("\\.");
		// ArrayList for longWords
		ArrayList<String> longWords = new ArrayList<>();

		for (String word : words) {
			// Add words longer than 6 letters into longWords
			if (word.length() > 6) {
				longWords.add(word);
			}
		}

		// Calculate the amounts for each factor. Using double
		// to clean up LIX - formula
		double A = words.length;
		double B = sentences.length;
		double C = longWords.size();

		// Lix formula.
		double LIX = (A / B) + ((100 * C) / A);
		// Output:
		String out = "Antall ord: " + A + "\nAntall setninger: "
				+ B + "\nAntall vanskelige ord (>6 bokstaver): "
				+ C + "\nKalkulert LIX: " + LIX;
		return out;
	}

}
