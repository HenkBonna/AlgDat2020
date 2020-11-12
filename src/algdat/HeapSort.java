package algdat;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HeapSort {
	public static void main(String[] args){
		int values[] = {-99, 5, 9, 8, 3, 1};
		heapsort(values);



	}

	static void heapsort(int[] values){

		System.out.println("Array før heapify: " + Arrays.toString(values));
		heapify(values);
		System.out.println("Array etter heapify: " + Arrays.toString(values));

		for (int i = 1; i < values.length; i++){
			int first = 1;
			int last = values.length - i;

			System.out.println("Bytter "  + first + " med " + last);


			int tmp = values[first];
			values[first] = values[last];
			values[last] = tmp;

			int current = first;
			int leftChild = current * 2;
			int rightChild = current * 2 + 1;
			while(true){
				// Venstre barn er minst av barna, og mindre enn parent
				if (leftChild < last
						&& values[leftChild] < values[rightChild]
						&& values[leftChild] < values[current]){
					System.out.println("Bytter "  + current + " med " + leftChild);
					int tmp2 = values[leftChild];
					values[leftChild] = values[current];
					values[current] = tmp2;
					current = leftChild;
				}
				// Høyre barn er minst av barna, og mindre enn parent
				else if (rightChild < last
						&&values[rightChild] < values[leftChild]
						&& values[rightChild] < values[current]){
					System.out.println("Bytter "  + current + " med " + rightChild);
					int tmp2 = values[rightChild];
					values[rightChild] = values[current];
					values[current] = tmp2;
					current = rightChild;
				}
				// Vi har funnet riktig plass til elementet
				else {
					break;
				}
				leftChild = current * 2;
				rightChild = current * 2 + 1;
			}
		}
		System.out.println("Array etter uttakt: " + Arrays.toString(values));


	}

	static void heapify(int[] values){
		for (int i = 1; i < values.length; i++){

			int current  = i;
			int parent = i / 2;

			while(parent > 0 && values[parent] > values[current]){
				System.out.println("Bytter " + current + " med " + parent);
				int tmp = values[parent];
				values[parent] = values[current];
				values[current] = tmp;
				current = parent;
				parent = current / 2;
			}
		}
	}
}
