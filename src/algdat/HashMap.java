package algdat;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMap {

	public static void main(String[] args) {
		System.out.println("Hashmap test");

		int hashMapSize = 7;
		ArrayList<LinkedList<String>> hashMap = new ArrayList<>(hashMapSize);


		for (int i = 0; i < hashMapSize; i++) {
			hashMap.add(i, new LinkedList<>());
		}

		// Lager test strenger
		String[] strings = new String[5];
		strings[0] = "Hei";
		strings[1] = "På deg din gamle sjokolade";
		strings[2] = "Peder";
		strings[3] = "Test";
		strings[4] = "Hallo";

		for (int i = 0; i < strings.length; i++) {
			int hash = hash(strings[i]);
			int hashMapIndex = computeHashMapIndex(hash, hashMapSize);
			System.out.println("Legger inn " + strings[i] + " med hash " + hash + " på plass " + hashMapIndex);
			hashMap.get(hashMapIndex).addFirst(strings[i]);
		}



		int hash = hash("Test");
		int hashMapIndex = computeHashMapIndex(hash, hashMapSize);
		hashMap.get(hashMapIndex);
		System.out.println(hashMap.get(hashMapIndex).toString());


	}

	static int computeHashMapIndex(int hash, int hashMapSize) {
		return hash % hashMapSize;
	}


	static int hash(String data) {
		int hash = 0;

		// Sum av alle bokstavene (ikke optimalt).
		//for (int i = 0; i < data.length(); i++) {
		//	hash = hash + (int) data.charAt(i);
		//}

		for (int i = data.length() - 1; i >= 0; i--) {
			char c = data.charAt(i);
			hash = (hash + c) * 31;
		}
		if (hash < 0) {
			hash = -hash;
		}
		return hash;
	}
}
