package example.codeclan.com.blackjack;

import example.codeclan.com.blackjack.behaviours.Cardnum;
import example.codeclan.com.blackjack.behaviours.Suit;

/**
 * Created by user on 23/06/2017.
 */

public class Card {

    private Suit suit;
    private Cardnum cardnum;

    public Card(Cardnum cardnum, Suit suit){
        this.cardnum = cardnum;
        this.suit = suit;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public int getCardno() {
        return this.cardnum.getValue();
    }

    public String fullCard(){
        return ("- " + this.cardnum + " of " + this.suit);
    }
}
