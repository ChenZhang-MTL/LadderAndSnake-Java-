

import java.security.SecureRandom;
import java.util.*;



//---------------------------------------
//Midterm Project
//LadderAndSnake
//Written by: Chen Zhang, 2211111
//---------------------------------------

public class LadderAndSnake {

    int playerNum;
    
    private List<Player> playerList = new ArrayList<>();
    Board board = new Board();
    Scanner scanner = new Scanner(System.in);

    public LadderAndSnake(int player) {
        this.playerNum = player;
        for (int i = 0; i < player; i++) {
            Player player1 = new Player();
            player1.setName("player" + i);
            playerList.add(player1);
        }
    }

    Random r = new Random();
    SecureRandom random = new SecureRandom();
    
    
    public int flipDice() {
        return r.nextInt(6) + 1;
    }

    public void play() {
    	
        System.out.println("Now deciding which player will start playing with dice：");
        judgePriority(playerList, 0);

        playerList.sort(new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o1.getDice() - o2.getDice() < 0 ? 1: -1;
            }
        });

        for (Player player : playerList) {
            System.out.print(player.getName() + " : " + player.getDice() + "\t");
        }
        board.initialize();
        
        System.out.print("\nReached final decision on order of playing: ");
        for (Player player : playerList) {
            System.out.print(player.getName() + "\t ");
        }

		for (Player player : playerList) {
			System.out.println("\nplease enter the name of " + player.getName());
		    String name =  scanner.nextLine();
		    player.setName(name);
		    System.out.print(player.getName() + "\t");
		}
		
		System.out.println("\nLet's Start!");
		startGame();
	}
    

    private void startGame() {
        System.out.println("=============================================================");
        for (Player player : playerList) {
            int places = random.nextInt(6) + 1;
            System.out.println(player.getName() + " current position is " + player.getPosition() + ", " +  "dice number is " + places );
            board.movePlayer(player, places);
        }
        System.out.println("\n=============================================================");
//        System.out.println("\nR = Roll the dice, Q = quit");
//        String choice = scanner.next();
//        if(choice.equals("R") || choice.equals("r")){
        startGame();
//        }
    }


    Set<Integer> exits = new HashSet<>();

    private void judgePriority(List<Player> playerList, int count) {
        System.out.println("Round " + (count + 1) + ":");
        Set<Player> samePlayer = new HashSet<>();
        for (Player player : playerList) {
            player.setDice(flipDice());
        }
        for (Player player : playerList) {
            System.out.print(player.getName() + " got a dice value of  "+ player.getDice() + "\n");
        }

        System.out.println();
        Set<Integer> sameSet = new HashSet<>();

        if (count == 0) {
            for (int i = 0; i < playerList.size(); i++) {
                boolean lineSame = false;
                for (int i1 = i + 1; i1 < playerList.size(); i1++) {
                    if (playerList.get(i).getDice() == playerList.get(i1).getDice() || exits.contains(playerList.get(i1).getDice())) {
                        lineSame = true;
                        samePlayer.add(playerList.get(i1));
                    }
                }

                if (!lineSame && !sameSet.contains(playerList.get(i).getDice())) {
                    exits.add(playerList.get(i).getDice());
                } else {
                    sameSet.add(playerList.get(i).getDice());
                    samePlayer.add(playerList.get(i));
                }
            }
        } else {
            for (Player player : playerList) {
                if (exits.contains(player.getDice())) {
                    samePlayer.add(player);
                } else {
                    exits.add(player.getDice());
                }
            }
        }

        count += 1;
        if (samePlayer.size() != 0) {
            judgePriority(new ArrayList<Player>(samePlayer), count);
        }
    }
}
