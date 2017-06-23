package example.codeclan.com.blackjack;

import example.codeclan.com.blackjack.behaviours.Choice;
import java.util.Scanner;

/**
 * Created by user on 23/06/2017.
 */

public class Player extends Hand {

    private Scanner sc;

    public Player(){
        sc = new Scanner(System.in);
    }

    public Choice getChoice(){
        System.out.println("Your total is: " + getHandValue() + " | Would you like to 'Hit' or 'Stand'?");
        String input = sc.nextLine().toUpperCase();
        char choice = input.charAt(0);
        switch(choice){
            case 'H':
                return Choice.HIT;
            case 'S':
                return Choice.STAND;
            default :
                System.out.println("Invalid Choice");
                return getChoice();
        }
    }
}
