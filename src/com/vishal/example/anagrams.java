package com.vishal.example;

public class anagrams {


	public static void main(String[] args) {

		String a = "abcdef";
		String b = "bcdeff";
		
		boolean anagram = isAnagram(a, b);
		
		System.out.println(anagram);
		
		
	}

	private static boolean isAnagram(String a, String b) {
		int[] a_char_set = new int[256]; 
		int[] b_char_set = new int[256]; 
		
		for (int i = 0; i < a.length(); i++) {
			int value = a.charAt(i);
			a_char_set[value]++;
		}
		for (int i = 0; i < b.length(); i++) {
			int value = b.charAt(i);
			b_char_set[value]++;		
		}
		
		for (int i = 0; i < a_char_set.length; i++) {
				if(a_char_set[i] != b_char_set[i]) return false;	
		}
		return true;
	}

}
