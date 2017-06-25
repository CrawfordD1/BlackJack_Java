package example.codeclan.com.blackjack;

import example.codeclan.com.blackjack.behaviours.Choice;

/**
 * Created by user on 23/06/2017.
 */

public class Game {

    Player player;
    Dealer dealer;
    Deck deck;
    int choice = 1;

    public Game(){
        player = new Player();
        dealer = new Dealer();
        deck = new Deck();
        deck.populateDeck();
    }

    public int playGame() {
        int winner;
        player.startHand(deck);
        dealer.startHand(deck);
        System.out.println("You have drawn:");
        player.showHand();
        System.out.println("Dealer has drawn:");
        System.out.println(dealer.showOneCard());
        winner = Playerlogic();
        if (winner == 2){
            winner = DealerLogic();
        }
        return winner;

    }

    public int Playerlogic(){
        if (player.getHandValue() == 21) {
            return 1;
        }
        while (player.getHandValue() < 21 && choice == 1) {
            getPlayerChoice();
            if (player.getHandValue() == 21) {
                System.out.println("Your total is: " + player.getHandValue());
                return 1;
            }
        }
        System.out.println("Your total is: " + player.getHandValue());
        if (player.getHandValue() > 21){
            return -1;
        }
        return 2;
    }

    public int DealerLogic(){
        System.out.println("Dealer has:");
        dealer.showHand();
        if (dealer.getHandValue() == 21) {
            return -1;
        }
        while (dealer.getHandValue() <= 21) {
            if (dealer.getHandValue() < 17) {
                System.out.println("Dealer Hits!");
                dealer.addOnetoHand(deck);
                System.out.println(dealer.showOneCard());
                System.out.println("Dealer total is: " + dealer.getHandValue());
            }
            if (dealer.getHandValue() == 21) {
                System.out.println("Dealer total is: " + dealer.getHandValue());
                return -1;
            }
            if (dealer.getHandValue() > 21) {
                System.out.println("Dealer Bust!");
                return 1;
            }
            if(dealer.getHandValue() >=17 && dealer.getHandValue() <=21){
                if (dealer.getHandValue() > player.getHandValue()){
                    return -1;
                }
                else
                    return 1;
            }
        }
        return -1;
    }

    public void getPlayerChoice(){
       Choice playerChoice  = player.getChoice();
        switch (playerChoice){
            case HIT:
                player.addOnetoHand(deck);
                System.out.println(player.showOneCard());
                break;
            case STAND:
                choice = 0;
                break;
        }
    }

    public void displayWinner(int result){
        switch(result){
            case 1 :
                System.out.println("Player Wins!");
                break;
            case -1 :
                System.out.println("Dealer Wins!");
                break;
        }

    }

}
