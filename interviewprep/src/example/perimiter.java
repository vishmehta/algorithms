package example;

import java.util.LinkedList;

public class perimiter {

	private static int colour;
	private static int perimiter;
	private static int[][] visitedMap;
	private static int[][] map;
	private static LinkedList<Record> queue;	
	
	public static void main(String[] args) {
		//inputs
		map = new int[][]{{1,2,1}, {2,2,2}, {1,2,1}, {1,2,1}, {3,2,2,2}};

		//Record initialRecord = new Record(1, 1);
		Record initialRecord = new Record(1, 1);
		queue = new LinkedList<Record>();
		queue.add(initialRecord);
		
		//setup
		perimiter = 0;
		colour = map[initialRecord.getRow()][initialRecord.getCol()];
		//assume map is not empty
		createCloneMap();

		printMap(map);
		System.out.println("--------------------------------------");
		System.out.println("--------------------------------------");
		findPerimiter();
		System.out.println("--------------------------------------");
		System.out.println("--------------------------------------");
		System.out.println("Total perimiter is " + perimiter);
	}
	
	private static void createCloneMap() {
		visitedMap = new int[map.length][];
		for(int i = 0; i < map.length; i++){
			visitedMap[i] = map[i].clone();
		}
		for(int i=0; i<visitedMap.length; i++){
			for(int j=0; j<visitedMap[i].length; j++){
				visitedMap[i][j] = 0;
			}
		}		
	}
	
	private static void findPerimiter() {
		while(!queue.isEmpty()){
			printQueue();
			System.out.println("Checking record: " + queue.getFirst().getRow() + "," + queue.getFirst().getCol() + ", Colour = " + colour);

			Record record = queue.getFirst();
			queue.removeFirst();
			if(!checkVisited(record)){
			markVisited(record);

			Record downChild = new Record(record.getRow()+1, record.getCol());
			Record upChild = new Record(record.getRow()-1, record.getCol());
			Record rightChild = new Record(record.getRow(), record.getCol()+1);
			Record leftChild = new Record(record.getRow(), record.getCol()-1);
			
			checkChildRecord(upChild);
			checkChildRecord(rightChild);			
			checkChildRecord(leftChild);
			checkChildRecord(downChild);
			
			printQueue();
			printMap(visitedMap);
		
			System.out.println("--------------------------------------");
			}
		}
	}


	private static void printQueue() {
		System.out.print("Queue: ");
		for(int i = 0; i < queue.size(); i++){
			System.out.print(queue.get(i).getRow() + "," + queue.get(i).getCol() + "; ");				
		}
		System.out.println("");
	}

	private static void checkChildRecord(Record child) {
		try {
			System.out.println("Checking child: " + child.getRow() + "," + child.getCol());
			if(!testColor(child)){
				perimiter++;
			} else {
				if(!checkVisited(child) && !queue.contains(child)){
					queue.add(child);
				}
			}
		} catch (IndexOutOfBoundsException e){
			//No more left in the map
			System.out.println("IndexOutOfBoundsException");
			perimiter++;
		}
		System.out.println("Perimiter is " + perimiter);
	}

	private static void printMap(int [][] printMap){
		System.out.print("   | ");
		for(int j = 0; j < printMap[0].length; j++){
			System.out.print(j + ":| ");
		}
		System.out.println("");
		for(int i = 0; i < printMap.length; i++){
			System.out.print(i + ": | ");
			for(int j = 0; j < printMap[i].length; j++){
				System.out.print(printMap[i][j] + " | ");
			}
			System.out.println("");
		}
		
	}
	
	private static boolean testColor(Record rec){
		return map[rec.getRow()][rec.getCol()] == colour;
	}
	
	private static void markVisited(Record rec){
		visitedMap[rec.getRow()][rec.getCol()] = 1;
	}
	
	private static boolean checkVisited(Record rec){
		return visitedMap[rec.getRow()][rec.getCol()] == 1;
	}
	
	public static class Record{
		private int row;
		private int col;
		
		public Record(int row, int col){
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
