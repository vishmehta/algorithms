package sorting;

import utils.general;

public class bubbleSort {

	public static void main(String[] args) {
		
		int[] array = {12,9,4,99,120,1,3,10};
		int[] array2 = new int []{23, 565, 12, 11, 90, 23};
		
		int [] result = bubbleSortAscending(array);
		general.printArray(result);
		int [] result2 = bubbleSortDescending(array);
		general.printArray(result2);
	
		int [] result3 = bubbleSortAscending(array2);
		general.printArray(result3);
		int [] result4 = bubbleSortDescending(array2);
		general.printArray(result4);

	}

	private static int[] bubbleSortAscending(int[] num) {
		 for (int i = 0; i < num.length; i++) {
		    for (int x = 1; x < num.length - i; x++) {
		        if (num[x - 1] > num[x]) {
		            int temp = num[x - 1];
		            num[x - 1] = num[x];
		            num[x] = temp;
		        }
		    }
		  }
		 return num;
	}
	
	private static int[] bubbleSortDescending(int[] num) {
		 for (int i = 0; i < num.length; i++) {
		    for (int x = 1; x < num.length - i; x++) {
		        if (num[x - 1] < num[x]) {
		          	general.swap(num, x, x-1);
		        }
		    }
		  }
		 return num;
	}
	

}
