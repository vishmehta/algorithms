package example;

import java.util.LinkedList;

public class perimiterneat {

	private static int colour;
	private static int perimiter;
	private static int[][] visitedMap;
	private static int[][] map;
	private static LinkedList<Key> queue;	
	
	public static void main(String[] args) {
		//inputs
		map = new int[][]{{1,2,1}, {2,2,2}, {1,2,1}, {1,2,1}, {3,2,2,2}};

		//Record initialRecord = new Record(1, 1);
		Key initialRecord = new Key(1, 1);
		queue = new LinkedList<Key>();

		//setup
		perimiter = 0;
		colour = map[initialRecord.getRow()][initialRecord.getCol()];
		//assume map is not empty
		//assumption its the same for all arrays in the array
		createCloneMap();
			
		findPerimiter(initialRecord);
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

	private static void findPerimiter(Key initialRecord) {
		queue.add(initialRecord);
		while(!queue.isEmpty()){
			Key record = queue.getFirst();
			queue.removeFirst();
			if(!checkVisited(record)){
				markVisited(record);				
				checkChildRecord(new Key(record.getRow()+1, record.getCol()));
				checkChildRecord(new Key(record.getRow()-1, record.getCol()));			
				checkChildRecord(new Key(record.getRow(), record.getCol()+1));
				checkChildRecord(new Key(record.getRow(), record.getCol()-1));			
			}
		}
	}

	private static void checkChildRecord(Key child) {
		try {
			if(!testColor(child)){
				perimiter++;
			} else {
				if(!checkVisited(child) && !queue.contains(child)){
					queue.add(child);
				}
			}
		} catch (IndexOutOfBoundsException e){
			//No where to go on the map
			perimiter++;
		}
	}
	
	private static boolean testColor(Key rec){
		return map[rec.getRow()][rec.getCol()] == colour;
	}
	
	private static void markVisited(Key rec){
		visitedMap[rec.getRow()][rec.getCol()] = 1;
	}
	
	private static boolean checkVisited(Key rec){
		return visitedMap[rec.getRow()][rec.getCol()] == 1;
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
