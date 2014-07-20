package utils;
import java.util.Hashtable;
import java.util.Random;

public class general {

	public static void printArray(int [] num){
		for (int i=0; i < num.length; i++){
      System.out.print(num[i]+ " ");
		}
		System.out.println("");
	}
	
	public static void swap(int[] a, int i, int j) {
    // TODO Auto-generated method stub
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
	}
  
	public static int[] generateRandomArray(int size){
		Hashtable<Integer, String> hastable = new Hashtable<Integer, String>();
		int[] array = new int[size];
		Random randomGenerator = new Random();
		for(int i = 0; i < array.length; i++) {
			array[i] = randomGenerator.nextInt(50);
		}
		System.out.print("Original: ");
		printArray(array);
		return array;
	}
	
	
}
