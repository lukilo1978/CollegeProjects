package ProjectJava;


	import java.util.*;

	public class ProjectTicTacToe {

		static String[] board;
		static String turn;
        static String playerName;

		// CheckWinner method will
		// decide the combination
		// of three box given below.
		static String checkWinner()
		{
			for (int a = 0; a < 8; a++) {
				String line = null;

				switch (a) {
				case 0:
					line = board[0] + board[1] + board[2];
					break;
				case 1:
					line = board[3] + board[4] + board[5];
					break;
				case 2:
					line = board[6] + board[7] + board[8];
					break;
				case 3:
					line = board[0] + board[3] + board[6];
					break;
				case 4:
					line = board[1] + board[4] + board[7];
					break;
				case 5:
					line = board[2] + board[5] + board[8];
					break;
				case 6:
					line = board[0] + board[4] + board[8];
					break;
				case 7:
					line = board[2] + board[4] + board[6];
					break;
				}
				//For X winner
				if (line.equals("XXX")) {
					return "X";
				}
				
				// For O winner
				else if (line.equals("OOO")) {
					return "O";
				}
			}
			
			for (int a = 0; a < 9; a++) {
				if (Arrays.asList(board).contains(
						String.valueOf(a + 1))) {
					break;
				}
				else if (a == 8) {
					return "draw";
				}
			}

		// To enter the X Or O at the exact place on board.
			System.out.println(
				playerName + "'s turn, enter a slot number to place "
				+ turn + " in:");
			return null;
		}
		
		// To print out the board.
		/* |---|---|---|
		| 1 | 2 | 3 |
		|-----------|
		| 4 | 5 | 6 |
		|-----------|
		| 7 | 8 | 9 |
		|---|---|---|*/

		static void printBoard()
		{
			System.out.println("|---|---|---|");
			System.out.println("| " + board[0] + " | "+ board[1] + " | " + board[2]+ " |");
			
			System.out.println("|-----------|");
			System.out.println("| " + board[3] + " | "+ board[4] + " | " + board[5]+ " |");
			
			System.out.println("|-----------|");
			System.out.println("| " + board[6] + " | "+ board[7] + " | " + board[8]+ " |");
			
			System.out.println("|---|---|---|");
		}

		public static void main(String[] args)
		{
			Scanner in = new Scanner(System.in);
			
			
			Player player1;
			Player player2;
			
			System.out.println("Please enter the name of the Player 1");
			String namePlayer1 = in.next();
			
			System.out.println("Please enter the name of the Player 2");
			String namePlayer2 = in.next();
			
			
			player1 = new Player (namePlayer1,"X");
			
			player2 = new Player (namePlayer2,"O");
			
			System.out.println("Welcome "+ player1.name + " your symbol is "+ player1.symbol);
			System.out.println();
			
			System.out.println("Welcome "+ player2.name + " your symbol is "+ player2.symbol);
			System.out.println();
			
			do {
				
				String winner = null;
				board = new String[9];
				turn = "X";

			for (int a = 0; a < 9; a++) {
				board[a] = String.valueOf(a + 1);
			}

			System.out.println("Welcome to 3x3 Tic Tac Toe.");
			printBoard();

			System.out.println(player1.name+" will play first. Enter a slot number to place X in:");

			while (winner == null) {
				
				int numInput;
				String input;
				
			
				
			// Exception handling.
			// numInput will take input from user like from 1 to 9.
			// If it is not in range from 1 to 9.
			// then it will show you an error "Invalid input."
				try {
					input = in.next();
					numInput = Integer.parseInt(input);
					
					if (!(numInput > 0 && numInput <= 9)) {
						System.out.println(
							"Invalid input; re-enter slot number:");
						continue;
					}
				}
				catch (Exception e) {
					System.out.println(
						"Invalid input; re-enter slot number:");
					continue;
				}
				
				// This game has two player x and O.
				// Here is the logic to decide the turn.
				if (board[numInput - 1].equals(String.valueOf(numInput))) {
					
					board[numInput - 1] = turn;

					if (turn.equals("X")) {
						if (player1.symbol.equals(turn)) 
						turn = player2.symbol;
						playerName = player2.name;
					}
					else {
						turn = player1.symbol;
						playerName = player1.name;
						
					}

					printBoard();
					winner = checkWinner();
				}
				else {
					System.out.println(
						"Slot already taken; re-enter slot number:");
				}
			}
		
			// If no one win or lose from both player x and O.
			// then here is the logic to print "draw".
			if (winner.equalsIgnoreCase("draw")) {
				System.out.println(
					"It's a draw! Thanks for playing.");
			}
		
			// For winner -to display Congratulations! message.
			else {
				if (player1.symbol.equals(winner)) {
					
					System.out.println("Congratulations! " + player1.name+ " have won! Thanks for playing.");
				}
				else {
					System.out.println("Congratulations! " + player2.name+ " have won! Thanks for playing.");
				}
				
			}
			System.out.println();
			System.out.println("Type play to play again or exit to exit the game");
			}
			while (! in.next().toUpperCase().equals("EXIT"));
			
		in.close();
		}
	}



