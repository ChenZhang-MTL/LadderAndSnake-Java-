

// ---------------------------------------
// Midterm Project
// LadderAndSnake
// Written by: Chen Zhang, 2211111
// ---------------------------------------

import java.util.Scanner;


public class PlayLadderAndSnake {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
    	welcome();
        Integer num = getPlayerNum();
        if(num == null){
            return;
        }
        new LadderAndSnake(num).play();
    }
    
    public static void welcome() {
    	System.out.println("---------------------------------------");
    	System.out.println("Midterm Project");
    	System.out.println("LadderAndSnake");
    	System.out.println("Written by: Chen Zhang, 2211111");
    	System.out.println("---------------------------------------");
    }

    private static Integer getPlayerNum(){
        int attempt = 0;
        System.out.println("Enter the # of player for your game - Number must be between 2 and 4 inclusively:");
        Integer result = null;
        while (attempt <= 3){
            int oj = scanner.nextInt();
            if(oj >= 2 && oj <= 4){
                result = oj;
                break;
            }else {
            	if (attempt == 2) {
            		System.out.println("Bad Attempt "+(attempt+1)+" - Invalid # of player. Please enter a # between 2 and 4 inclusively. This is your last attempt");
            	}
            	else if (attempt == 3) {
            		System.out.println("Bad Attempt "+(attempt+1)+"! You have exhausted all your chances. Program will terminated!");
            	}
            	else{
            		System.out.println("Bad Attempt "+(attempt+1)+" - Invalid # of player. Please enter a # between 2 and 4 inclusively:");
            	}
            }
            attempt ++;
        }
        if(result == null){
            System.exit(0);
        }

        return result;
    }
}
