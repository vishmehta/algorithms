package com.vishal.example;

import java.util.LinkedList;

public class perimiterneat2 {

	private static int colour;
	private static int perimiter;
	private static int[][] visitedMap;
	private static LinkedList<Key> queue;	
	
	public static void main(String[] args) {
		//inputs
		int[][] map = new int[][]{{1,2,1}, {2,2,2}, {1,2,1}, {1,2,1}, {3,2,2,2}};
		Key initialKey = new Key(1, 1);
		
		findPerimiter(map, initialKey);
		System.out.println("Total perimiter is " + perimiter);
	}
	
	private static void createCloneMap(int[][] map) {
		visitedMap = new int[map.length][];
		for(int i = 0; i < map.length; i++){
			visitedMap[i] = map[i].clone();
			for(int j=0; j<visitedMap[i].length; j++){
				visitedMap[i][j] = 0;
			}
		}
	}

	private static void findPerimiter(int[][] map, Key initialKey) {
		//setup
		queue = new LinkedList<Key>();
		perimiter = 0;
		colour = map[initialKey.getRow()][initialKey.getCol()];
		createCloneMap(map);
		queue.add(initialKey);
		
		while(!queue.isEmpty()){
			Key record = queue.getFirst();
			queue.removeFirst();
			if(!checkVisited(map, record)){
				markVisited(map, record);				
				checkChildRecord(map, record.getRow()+1, record.getCol()); //down
				checkChildRecord(map, record.getRow()-1, record.getCol());	//up		
				checkChildRecord(map, record.getRow(), record.getCol()+1); //right
				checkChildRecord(map, record.getRow(), record.getCol()-1);	//left		
			}
		}
	}

	private static void checkChildRecord(int[][] map, int row, int col) {
		Key child = new Key(row, col);
		try {
			if(!testColor(map, child)){
				perimiter++;
			} else {
				//if(!checkVisited(map, child) && !queue.contains(child)){
					queue.add(child);
				//}
			}
		} catch (IndexOutOfBoundsException e){
			//No where to go on the map
			perimiter++;
		}
	}
	
	private static boolean testColor(int[][] map, Key key){
		return map[key.getRow()][key.getCol()] == colour;
	}
	
	private static void markVisited(int[][] map, Key key){
		visitedMap[key.getRow()][key.getCol()] = 1;
	}
	
	private static boolean checkVisited(int[][] map, Key key){
		return visitedMap[key.getRow()][key.getCol()] == 1;
	}
	
	public static class Key{
		private int row;
		private int col;
		
		public Key(int row, int col){
			this.row = row;
			this.col = col;
		}
		
		public int getRow(){
			return row;
		}
		
		public void setRow(int row){
			this.row = row;
		}
		
		public int getCol(){
			return col;
		}
		
		public void setCol(int col){
			this.col = col;
		}
	}
	
}
