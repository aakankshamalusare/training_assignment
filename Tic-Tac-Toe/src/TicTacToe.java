import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class TicTacToe {

	private boolean gameOver = false;
	private String player1;
	private String player2;
	private String current;
	private HashMap<String,Character> player;
	private char[][] board = {{'-','-','-'},{'-','-','-'},{'-','-','-'}};
	
	private BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	
	public TicTacToe() {
		
	}
	
	public TicTacToe(String player1,String player2) {
		
		this.player1 = player1;
		this.player2 = player2;
		player = new HashMap<>();
		
		List<Character> symbols = Arrays.asList('X','O');
		Collections.shuffle(symbols);
		
		player.put(player1,symbols.get(0));
		player.put(player2, symbols.get(1));
		
		current = player1;
		
		
	}
	
	
    public boolean isGameOver() {
		return gameOver;
	}

	

	
	/*
	 * Description: Print the current state of board
	 */
	
    private void printBoard() {
		
		for(int i = 0;i<board.length;i++) {
			
			for(int j = 0;j<board.length;j++) {
				
				System.out.print(board[i][j]);
				
				if(j<2) {
					
					System.out.print(" | ");
				}
			}
			
			System.out.println();
			
			if(i<2) {
				
				System.out.println("----------");
			}
		}
	}
	
	
	/*
	 * Description: Check whether player is won game or not
	 */
	
	private boolean hasWon(int row,int col) {
		
		// Check Row
		if(board[row][0] == board[row][1] && board[row][0]== board[row][2]) {
			
			return true;
		}
		
		//Check Column
		if(board[0][col] == board[1][col] && board[0][col]== board[2][col]) {
			
			return true;
			
		}
		
		// Check Diagonal
		if(row == col && board[0][0] == board[1][1] && board[0][0]== board[2][2]) {
			
			return true;
			
		}
		
		// Check Anti-Diagonal
		if( row+col == board.length-1 && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
			
			return true;
		}
		
		return false;
		
		
	}
	
	

	/*
	 * Description : Check board is full or not
	 */
	
	private boolean isBoardFull() {
		
		for(int i =0;i<board.length;i++) {
			
			for(int j=0;j<board.length;j++) {
				
				if(board[i][j]=='-') {
					
					return false;
				}
			}
		}
		return true;
	}
	
	
	/*
	 * Description : Checks whether player make valid move or not
	 */
	private boolean isValid(int row,int col) {
		
		        // IsValid Move or Not
		
			if(row<0 || row>2 || col <0 || col >2|| board[row][col]!='-') {
					
					return false;
					
					
				}
				
				
			return true;
	}
	
	
	
	
	/*
	 *  Decription : Tic-tac-toe game
	 */
	
	public void gameMoves() {
		
		
		System.out.println("Enter Position "+current+"("+player.get(current)+"):");
		int move = 0;
		
		try {
			
			move =  Integer.parseInt(br.readLine());
			
		
		}catch(IOException ie) {
			
			
		}
		
		// Convert moves into row and col
		
		int row = (move-1)/3;
		int col = (move-1) %3;
		

		
		if(!isValid(row,col)) {
			
			System.out.println("Invalid Move");
			return;
		}
		
		
		
		if (board[row][col]=='-') {
			
			board[row][col] = player.get(current);
			
			 if(hasWon(row,col)) {
				
				gameOver = true ;
				System.out.println("Player "+current+" Win Game! ");
				
			
			 }else if(isBoardFull()) {
				
				gameOver =  true;
				System.out.println("Game Over!");
			
			
			}else {
				
				if(current.equals(player1))
				     current = player2;
				else
					current = player1;
		    }
			 
		}
		
		printBoard();
			
	 
		
	}

	
	
     public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter Player1 Name:");
		String player1= null;
		
		try {
				
				player1 = br.readLine();

		}catch(IOException ie) {
			
			
		}
		
		System.out.println("Enter Player2 Name:");
		String player2= null;
		
		try {
				
				player2 = br.readLine();

		}catch(IOException ie) {
			
			
		}
		
		TicTacToe obj = new TicTacToe(player1,player2);
		
		while(!obj.isGameOver()) {
			
			obj.gameMoves();
		}
			
			
		}
	}
