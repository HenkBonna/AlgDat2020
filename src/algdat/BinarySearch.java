package algdat;

import java.awt.desktop.SystemEventListener;

public class BinarySearch {

	public static void main(String[] args){
		int[] values = {1,2,4,8,17,19,22};

		for (int i = 0; i<25; i++) {
			System.out.println(i + " @ " + binarySearch(i, values, 0, values.length - 1));
		}
	}

	// Search in the interval [left, right] ((not [begin, end))
	static int binarySearch(int searchValue, int[] values, int left, int right){
		int middle = (left + right) / 2;

		if (right - left == 0){
			if (values[middle] == searchValue){
				return middle;
			}
			else {
				return -middle; // this returns where it "should" be
			}
		}

		if(values[middle] <= searchValue){
			if (values[middle] == searchValue){
				return middle;
			}
			return binarySearch(searchValue, values, middle+1, right);
		}
		else{
			return binarySearch(searchValue, values, left, middle-1);
		}
	}

}
