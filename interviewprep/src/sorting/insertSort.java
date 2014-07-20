package sorting;

import utils.general;

public class insertSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] randomArray = general.generateRandomArray(10);
		general.printArray(InsertionSortDescending(randomArray));
		general.printArray(InsertionSortAscending(randomArray));
		
	}

	public static int[] InsertionSortDescending( int [ ] num)	{
		int j;                     // the number of items sorted so far
	  int key;                // the item to be inserted
	  int i;  

	  for (j = 1; j < num.length; j++){    // Start with 1 (not 0)
	  	key = num[ j ];
	    for(i = j - 1; (i >= 0) && (num[ i ] < key); i--) {   // Smaller values are moving up
	    	num[ i+1 ] = num[ i ];
	    }
	    num[ i+1 ] = key;    // Put the key in its proper location
	  }
	  return num;
	}
	
	public static int[] InsertionSortAscending( int [ ] num)	{
		int j;                     // the number of items sorted so far
	  int i;  
	  int temp;                // the item to be inserted

	  for (i = 1; i < num.length; i++){    // Start with 1 (not 0)
	  	temp = num[i];
	    for(j = i - 1; (j >= 0) && (temp < num[j]); j--) {   // Smaller values are moving up
	    	num[j+1] = num[j];
	    }
	    num[j+1] = temp;    // Put the key in its proper location
	  }
	  return num;
	}
	
}
