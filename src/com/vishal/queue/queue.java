package com.vishal.queue;


public class queue {

	public static void main(String[] args) {
		
		printQueue(first);
		enqueue(5);
		System.out.println(peekFirst());
		enqueue(4);
		enqueue(3);
		enqueue(2);
		enqueue(1);
		printQueue(first);
		
		System.out.println("---------------");
		
		dequeue();
		dequeue();
		printQueue(first);
		
		System.out.println("---------------");
		
		enqueue(100);
		printQueue(first);
		
		System.out.println("---------------");
	}
	
	public static Node first;
	public static Node last;
	
	public static Object peekFirst(){
		if(first != null){
			return first.getData();
		}
		return null;
	}
	
	public static Object peekLast(){
		if(last != null){
			return last.getData();
		}
		return null;
	}
	
	public static boolean isEmpty(){
		return first == null;
	}
	
	public static void enqueue(int item){
		Node newNode = new Node(item);
		if(isEmpty()){
			first = newNode;
			last = newNode;
		} else {
			if(last != null){
				last.setNext(newNode);	
			}
			last = newNode;
		}
	}
	
	public static Object dequeue(){
		if(!isEmpty()){
			int item = first.getData();
			first = first.getNext();
			return item;
		}
		return null;
	}
	
	public static void printQueue(Node node){
		if(node != null){
			System.out.print(node.getData() + "; ");
			if(node.hasNext()){
				printQueue(node.getNext());
			}
		}
	}
	
	static class Node {
		
		private int data;
		private Node next;
		
		public Node(int data){
			this.data = data;
		}
		
		public boolean hasNext(){
			return next != null;
		}
		
		public Node getNext(){
			return next;
		}
		
		public void setNext(Node next){
			this.next = next;
		}
		
		public int getData(){
			return data;
		}
		
		public void setData(int data){
			this.data = data;
		}
		
	}
}
