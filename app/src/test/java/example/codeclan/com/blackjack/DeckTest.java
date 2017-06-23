package example.codeclan.com.blackjack;

import org.junit.Before;
import org.junit.Test;
import example.codeclan.com.blackjack.behaviours.Cardnum;
import example.codeclan.com.blackjack.behaviours.Suit;
import static org.junit.Assert.*;
import org.mockito.*;
import static org.mockito.Mockito.*;

/**
 * Created by user on 23/06/2017.
 */

public class DeckTest {

    Deck deck;
    Player player;
    Dealer dealer;
    Deck spyDeck;

    @Before
    public void before(){
        deck = new Deck();
        deck.populateDeck();
        player = new Player();
        dealer = new Dealer();
        spyDeck = Mockito.spy(deck);
    }

    @Test
    public void testPopulateDeck(){
        assertEquals(52, deck.deckSize());
    }

    @Test
    public void testStartHandEmpty(){
        assertEquals(0, player.getHandValue());
    }

    @Test
    public void testaddTwoCards(){
        player.startHand(deck);
        assertEquals(2, player.getHandCardTotal());
    }

    @Test
    public void testgetHandValue(){
        Mockito.when(spyDeck.getCard()).thenReturn(new Card(Cardnum.KING, Suit.CLUBS));
        player.startHand(spyDeck);
        assertEquals(20, player.getHandValue());
    }

    @Test
    public void testgetLastCard(){
        Mockito.when(spyDeck.getCard()).thenReturn(new Card(Cardnum.SEVEN, Suit.CLUBS));
        player.startHand(spyDeck);
        Mockito.when(spyDeck.getCard()).thenReturn(new Card(Cardnum.KING, Suit.CLUBS));
        player.addOnetoHand(spyDeck);
        assertEquals(10, player.getLastCard().getCardno());
        assertEquals(24, player.getHandValue());
    }

    @Test
    public void testDoubleAce(){
        Mockito.when(spyDeck.getCard()).thenReturn(new Card(Cardnum.ACE, Suit.CLUBS));
        player.startHand(spyDeck);
        assertEquals(12, player.getHandValue());
    }

    @Test
    public void testTripleAce(){
        Mockito.when(spyDeck.getCard()).thenReturn(new Card(Cardnum.ACE, Suit.CLUBS));
        player.startHand(spyDeck);
        assertEquals(12, player.getHandValue());
        player.addOnetoHand(spyDeck);
        assertEquals(13, player.getHandValue());
    }

    @Test
    public void testFourAce(){
        Mockito.when(spyDeck.getCard()).thenReturn(new Card(Cardnum.ACE, Suit.CLUBS));
        player.startHand(spyDeck);
        assertEquals(12, player.getHandValue());
        player.addOnetoHand(spyDeck);
        assertEquals(13, player.getHandValue());
        player.addOnetoHand(spyDeck);
        assertEquals(14, player.getHandValue());
    }

}
