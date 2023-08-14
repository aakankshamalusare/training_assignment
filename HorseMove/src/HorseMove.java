import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

import java.util.Set;

public class HorseMove {
	
	char[][] chess = {{'-','-','-','-','-','-','-','-'},
			{'-','-','-','-','-','-','-','-'},
			{'-','-','-','-','-','-','-','-'},
			{'-','-','-','-','-','-','-','-'},
			{'-','-','-','-','-','-','-','-'},
			{'-','-','-','-','-','-','-','-'},
			{'-','-','-','-','-','-','-','-'},
			{'-','-','-','-','-','-','-','-'},
	};
	
	
	
	static boolean isValidPosition(int row, int col) {
		
		if(row <= 0 || row >8 || col <= 0 || col >8) {
			
			return false;
		
		}
		
		return true;
	}
	
	

    Set<int[]> findPossibleMoves(int cRow, int cCol) {
    	
    	chess[cRow][cCol]='H';
		
    	Set<int[]> possibleMoves = new HashSet<>();
    	int[][] possibleMove = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
    	
    	for(int[] move : possibleMove) {
    		
    		int newRow = cRow+move[0];
    		int newCol = cCol+move[1];
    		
    		if(isValidPosition(newRow,newCol)) {
    			
    			int temp[] = {newRow,newCol};
    			chess[newRow][newCol]='h';
    			possibleMoves.add(temp);
    		}
    	}
    	
		return possibleMoves;
	}
    
    
    public void printBoard() {
    	
    
     System.out.println("-------------------------------");
    	
	 for(int i = 0;i<chess.length;i++) {
			
			for(int j = 0;j<chess.length;j++) {
				
				System.out.print(chess[i][j]+" | ");
				
			}
			
			System.out.println("\n-------------------------------");
			
		}
    }
	




	public static void main(String[] args) {
	
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cRow = 0;
		int cCol = 0;
		char ch =0;
		
		do {
		System.out.println("Enter current position of Horse(x,y)");
		
		try {
			
			
			cRow = Integer.parseInt(br.readLine());

            cCol = Integer.parseInt(br.readLine());
		
		}catch(IOException ie) {
			
			
		}
		
			
		
			HorseMove obj = new HorseMove();
			Set<int[]> possibleMoves = obj.findPossibleMoves(cRow,cCol);
		
			System.out.println("Possible moves: "+possibleMoves.size());
	
		/*Iterator<int[]> iterator = possibleMoves.iterator();
		
		while(iterator.hasNext()) {
			
			int[] move = iterator.next();
			
			for(int val : move) {
				
				System.out.print(val+" ");
			}
			
			System.out.println();
		}*/
		
			obj.printBoard();
			
			System.out.println("Do u want to continue (y/n): ");
			
			try {
				
				ch = br.readLine().charAt(0);
			
			}catch(IOException ie) {
				
				
			}
			
		}while(ch=='y'||ch=='Y');
			
			
		
		
		
		
	

	}


}
