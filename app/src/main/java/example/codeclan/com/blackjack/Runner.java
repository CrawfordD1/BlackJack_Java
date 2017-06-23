package example.codeclan.com.blackjack;

/**
 * Created by user on 23/06/2017.
 */

public class Runner {
    public static void main(String[] args) {
        Game game = new Game();
        int winner = game.playGame();
        game.displayWinner(winner);
    }
}
