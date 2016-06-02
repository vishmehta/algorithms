package com.vishal.stack;

import com.vishal.utils.Node;

public class stacks {

	public static void main(String[] args) {

		printStack(top);
		push(5);
		push(4);
		push(3);
		System.out.println("Peeking: " + peek());
		push(2);
		push(1);
		printStack(top);
		
		System.out.println("---------------");
		
		pop();
		pop();
		printStack(top);
		
		System.out.println("---------------");
		
		push(100);
		printStack(top);
		
		System.out.println("---------------");
		
	}
	
	public static Node top;
	
	public static boolean isEmpty(){
		return top == null;
	}
	
	public static void push(int item){
		Node newNode = new Node(item);
		newNode.setNext(top);
		top = newNode;
	}
	
	public static Object pop(){
		if(!isEmpty()){
			int item = top.getData();
			top = top.getNext();
			return item;
		}
		return null;
	}
	
	public static Object peek(){
		if(!isEmpty()){
			return top.getData();
		}
		return null;
	}
	
	public static void printStack(Node n){
		if(n != null){
			System.out.println(n.getData());
			if(n.hasNext()){
				printStack(n.getNext());
			}
		}
	}
	
	
}
