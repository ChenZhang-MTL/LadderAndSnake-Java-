

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// ---------------------------------------
// Midterm Project
// LadderAndSnake
// Written by: Chen Zhang, 2211111
// ---------------------------------------

public class Board {

    //A array to represent the 'board'
	int [][] board_print = new int[10][10];	
    Cell[] board = new Cell[101];
    List<Player> players = new ArrayList<>();
    Set<Integer> occupiedPositions = new HashSet<>();

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Cell[] getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayers(Player player) {
        this.players.add(player);
    }

    public void
    initialize() {
        System.out.println("\n\nInitializing board\n");
        
        for (int i = 0; i < 10;i++)
        {
        	for (int j = 0; j<10; j++)
        	{
	        	if (i%2 ==0)
	        	{
	        		board_print[i][j] = (10-i)*10-j;
	        	}
	        	if (i%2!=0) 
	        	{
	        		board_print[i][j] = (9-i)*10+j+1;
	        	}
	        	System.out.print(board_print[i][j] + "\t");
        	}
        	System.out.print("\n\n");
        } 
        
        //positions
        setSnakes(23, 2);
        setSnakes(34, 15);
        setSnakes(52, 31);
        setSnakes(62, 43);
        setSnakes(89, 68);
        setSnakes(95, 74);
        setLadders(10, 33);
        setLadders(21, 41);
        setLadders(16, 37);
        setLadders(44, 76);
        setLadders(80, 99);


        for (int i = 0; i < 101; i++) {
            if (board[i] != null) {
                continue;
            }
            Cell t = new Cell(CellType.NORMAL);
            board[i] = t;
        }
    }

    public void movePlayer(Player player, int places) {
        int currentPosition = player.getPosition();
        String checkPos = checkEndingPosition(currentPosition, places);
        if (checkPos.equals("winner")) {
            winner(player);
        }
        if (checkPos.equals("outOfBoard")) {
            int finalPosition = 100 + (100 - (currentPosition + places));
            System.out.println(player.getName()+" move to "+(currentPosition + places)+" out of board ,rollback to "+finalPosition);
            player.setPosition(finalPosition);
        }
        if (checkPos.equals("valid")) {
            Cell t = getTile(currentPosition + places);
            if (t.getType().equals(CellType.NORMAL)) {
                player.setPosition(currentPosition + places);
                System.out.println(player.getName() +
                        " moves to position " + player.getPosition() + "\n");
            } else {
                player.setPosition(t.getDest());
                System.out.println(player.getName() +
                        " encountered a " + t.getType() + "!!" + t.getUpDownMsg() + " to position " + t.getDest()+ "\n");
            }
        }
    }

    public Cell getTile(int n) {
        return board[n];
    }

    public String checkEndingPosition(int currentPosition, int places) {

        if ((currentPosition + places) > 100) {
            return "outOfBoard";
        } else if ((currentPosition + places) == 100) {
            return "winner";
        } else {
            return "valid";
        }
    }

    public void winner(Player player) {

        System.out.print("Player " + player.getName() + " has won the game !");
        System.exit(0);
    }

    public void setSnakes(int start, int end) {
        //this function generates snakes at random positions
        occupiedPositions.add(start);
        Cell cellStart = new Cell(CellType.SNAKE, end, "Go down stairs");
        board[start] = cellStart;

        System.out.println("Created snake " + "[" + start + "," + end + "]");

    }

    public void setLadders(int start, int end) {
        //this function generates ladders randomly
        occupiedPositions.add(start);

        Cell cellStart = new Cell(CellType.LADDER, end, "Go up stairs");
        board[start] = cellStart;

        System.out.println("Created ladder " + "[" + start + "," + end + "]");

    }
}
