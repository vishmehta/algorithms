package com.vishal.utils;

public class TreeNode {

	private Node currentNode;
	private Node leftNode;
	private Node rightNode;
	
	public Node getCurrentNode(){
		return currentNode;
	}
	
	public void setCurrentNode(Node node){
		this.currentNode = node;
	}
	
	public Node getLeftNode(){
		return leftNode;
	}
	
	public void setLeftNode(Node node){
		this.leftNode = node;
	}
	
	public Node getRightNode(){
		return rightNode;
	}
	
	public void setRightNode(Node node){
		this.rightNode = node;
	}
	
}
