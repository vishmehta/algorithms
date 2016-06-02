package com.vishal.sorting;

import com.vishal.utils.general;

public class quickSort {

	public static void main(String[] args) {

		int[] emptyArray = new int[]{};
		int[] array = {12,9,4,99,120,1,3,10};
		int[] array2 = new int []{23, 565, 12, 11, 90, 23};
		int[] array3 = {84, 69, 76, 86, 94, 91};
				
		general.printArray(sort(emptyArray));
		general.printArray(sort(array));
		general.printArray(sort(array2));
		general.printArray(sort(array3));

		general.printArray(Quicksort(array, 0, array.length - 1));
		
		int[] randomArray = general.generateRandomArray(10);
		general.printArray(Quicksort(randomArray, 0, randomArray.length - 1));

	}
	

  // Reorganizes the given list so all elements less than the first are 
  // before it and all greater elements are after it.                   
  public static int partition(int A[], int f, int l) {
     int pivot = A[f];
     while (f < l) {
        while (A[f] < pivot) f++;
        while (A[l] > pivot) l--;
        general.swap (A, f, l);
     }
     return f;
  }

  public static int[] Quicksort(int A[], int f, int l) {
     if (f >= l) return A;
     int pivot_index = partition(A, f, l);
     Quicksort(A, f, pivot_index);
     Quicksort(A, pivot_index+1, l);
     return A;
  }
  
	public static void basicQuickSort(int arr[], int beginIdx, int len) {
    if ( len <= 1 )
         return;
    
    final int endIdx = beginIdx+len-1;

    // Pivot selection
    final int pivotPos = beginIdx+len/2;
    final int pivot = arr[pivotPos];
    general.swap(arr, pivotPos, endIdx);

    // partitioning
    int p = beginIdx;
    for(int i = beginIdx; i != endIdx; ++i) {
         if ( arr[i] <= pivot ) {
             general.swap(arr, i, p++);
         }
     }
     general.swap(arr, p, endIdx);

     // recursive call
     basicQuickSort(arr, beginIdx, p-beginIdx);
     basicQuickSort(arr, p+1,  endIdx-p);
}
	
	private static int[] numbers;
  private static int number;

  public static int[] sort(int[] values) {
    // check for empty or null array
    if (values ==null || values.length==0){
      return values;
    }
    numbers = values;
    number = values.length;
    quicksort(0, number - 1);
    return values;
  }

  private static void quicksort(int low, int high) {
  	int i = low, j = high;
    // Get the pivot element from the middle of the list
    int pivot = numbers[low + (high-low)/2];

    // Divide into two lists
    while (i <= j) {
      // If the current value from the left list is smaller then the pivot
      // element then get the next element from the left list
      while (numbers[i] < pivot) {
        i++;
      }
      // If the current value from the right list is larger then the pivot
      // element then get the next element from the right list
      while (numbers[j] > pivot) {
        j--;
      }

      // If we have found a values in the left list which is larger then
      // the pivot element and if we have found a value in the right list
      // which is smaller then the pivot element then we exchange the
      // values.
      // As we are done we can increase i and j
      if (i <= j) {
      	general.swap(numbers, i, j);
        i++;
        j--;
      }
    }
    // Recursion
    if (low < j)
      quicksort(low, j);
    if (i < high)
      quicksort(i, high);
  }

}
