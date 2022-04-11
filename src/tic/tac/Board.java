package tic.tac;

import java.util.Arrays;

public class Board {

	private final int MAX_ROWS;
	private final int MAX_COLS;
	private Pieces[][] gameBoard;
	
	public Board(int max_rows, int max_cols)
	{
		this.MAX_ROWS=max_rows;
		this.MAX_COLS=max_cols;
		gameBoard= new Pieces[MAX_ROWS][MAX_COLS]; 
	}
	
	public int getMaxRows()
	{
		return MAX_ROWS;
	}
	
	public int getMaxCols()
	{
		return MAX_COLS;
	}
	
	public void printBoard()
	{
        String colHeader = "T  1 | 2 | 3 ";
        System.out.println(colHeader);
        System.out.println("-".repeat(colHeader.length()));
        for (int row=0; row < MAX_ROWS; row++)
        {
            String printStr = "";
            for (int col=0; col < MAX_COLS; col++)
            {
                String playerName;
                if (gameBoard[row][col] == null)
                {
                    playerName = " ";
                } else
                {
                    playerName = gameBoard[row][col].getName();
                }
                printStr = printStr + "|" + " " + playerName + " ";
            }
            System.out.println((row + 1) + " " + printStr.substring(1));
            if (row < (MAX_ROWS - 1))
            {
                System.out.println("-".repeat(printStr.length() + 1));
            }
        }
        
        System.out.println("\n");
	}
	
	public Boolean isSpaceFree(int row, int col)
	{
		if((row >= MAX_ROWS) || (col >= MAX_COLS)) {
			return false;
		}
		if(gameBoard[row][col]==null) {
			return true;
		}else {
			return false;
		}
	}
	
	public Boolean play(String player, int row, int col) 
	{
		if(isSpaceFree(row, col)) {
			gameBoard[row][col]= new Pieces(player, row, col);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean autoPlay(String player)
	{
		boolean played=false;
		
		for(int row=0; row <MAX_ROWS; row++) {
			for(int col=0; row <MAX_COLS; col++) {
				if(play(player, row, col)){
					played=true;
					break;
				}
			}
		}
		return played;	
	}
	
	 public boolean haveAWinner()
	    {
	        boolean winner = false;

	        // winner in rows
	        for (int row = 0; row < MAX_ROWS; row++)
	        {
	            if (!Arrays.stream(gameBoard[row]).anyMatch(obj -> obj == null))
	            {
	                winner = Arrays.stream(gameBoard[row]).map(x -> x.getName())
	                .distinct().count() <= 1;
	            }
	        }

	        // winner in cols
	        if (!winner)
	        {
	            a:
	            for (int col = 0; col < MAX_COLS; col++)
	            {
	                Pieces[] column = new Pieces[MAX_ROWS];
	                for (int row = 0; row < MAX_ROWS; row++)
	                {
	                    column[row] = gameBoard[row][col];
	                }

	                if (!Arrays.stream(column).anyMatch(obj -> obj == null))
	                {
	                    winner = Arrays.stream(column).map(x -> x.getName())
	                    .distinct().count() <= 1;
	                    if (winner)
	                    {
	                        break a;
	                    }
	                }
	            }
	        }    

	        // winner in diagonals

	        if (!winner)
	        {
	            Pieces[] diagonals = new Pieces[MAX_ROWS];
	            for (int diag = 0; diag < MAX_ROWS; diag++)
	            {
	                diagonals[diag] = gameBoard[diag][diag];
	            }
	            
	            if (!Arrays.stream(diagonals).anyMatch(obj -> obj == null))
	            {
	                winner = Arrays.stream(diagonals).map(x -> x.getName())
	                .distinct().count() <= 1;
	            }

	        }
	        return winner;
	    }
	 
	    public boolean spaceAvailable()
	    {
	        return Arrays.stream(gameBoard).flatMap(x -> Arrays.stream(x)) .anyMatch(obj -> obj == null);
	    }
}
