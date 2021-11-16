package com.Pro150.Casino.Shared;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Deck {

    private static ArrayList<Card> deck = new ArrayList<>();

    public Deck(){
        newDeck();
    }

    //will return how many cards are in the deck
    public int remainingCards(){
        return deck.size() - 1;
    }

    //will create a new deck of 52 cards
    public  void newDeck(){
        deck.addAll(Arrays.asList(Card.values()).subList(0, 52));
    }

    //will shuffle the deck using all the cards currently in the deck
    public void shuffleDeck(){
        ArrayList<Card> retVal = new ArrayList<>();
        int i = 0;
        while(i<52){
            int pick = new Random().nextInt(deck.size());
            retVal.add(deck.get(pick));
            deck.remove(pick);
            i++;
        }
        deck = retVal;
    }

    //Will return the value of a card and remove it from the current deck to effectively draw a card
    public Card drawCard(){
        Card retVal = deck.get(0);
        deck.remove(0);
        return retVal;
    }

    //Contains all 52 cards (No Jokers) and 4 additional cards for Aces called D_ACE_OF_X used for values of 1 instead of 11
    //These will not be used with the deck unless specifically called
    public enum Card{
        TWO_OF_HEARTS(2),
        THREE_OF_HEARTS(3),
        FOUR_OF_HEARTS(4),
        FIVE_OF_HEARTS(5),
        SIX_OF_HEARTS(6),
        SEVEN_OF_HEARTS(7),
        EIGHT_OF_HEARTS(8),
        NINE_OF_HEARTS(9),
        TEN_OF_HEARTS(10),
        JACK_OF_HEARTS(10),
        QUEEN_OF_HEARTS(10),
        KING_OF_HEARTS(10),
        ACE_OF_HEARTS(11),

        TWO_OF_DIAMONDS(2),
        THREE_OF_DIAMONDS(3),
        FOUR_OF_DIAMONDS(4),
        FIVE_OF_DIAMONDS(5),
        SIX_OF_DIAMONDS(6),
        SEVEN_OF_DIAMONDS(7),
        EIGHT_OF_DIAMONDS(8),
        NINE_OF_DIAMONDS(9),
        TEN_OF_DIAMONDS(10),
        JACK_OF_DIAMONDS(10),
        QUEEN_OF_DIAMONDS(10),
        KING_OF_DIAMONDS(10),
        ACE_OF_DIAMONDS(11),

        TWO_OF_CLUBS(2),
        THREE_OF_CLUBS(3),
        FOUR_OF_CLUBS(4),
        FIVE_OF_CLUBS(5),
        SIX_OF_CLUBS(6),
        SEVEN_OF_CLUBS(7),
        EIGHT_OF_CLUBS(8),
        NINE_OF_CLUBS(9),
        TEN_OF_CLUBS(10),
        JACK_OF_CLUBS(10),
        QUEEN_OF_CLUBS(10),
        KING_OF_CLUBS(10),
        ACE_OF_CLUBS(11),

        TWO_OF_SPADES(2),
        THREE_OF_SPADES(3),
        FOUR_OF_SPADES(4),
        FIVE_OF_SPADES(5),
        SIX_OF_SPADES(6),
        SEVEN_OF_SPADES(7),
        EIGHT_OF_SPADES(8),
        NINE_OF_SPADES(9),
        TEN_OF_SPADES(10),
        JACK_OF_SPADES(10),
        QUEEN_OF_SPADES(10),
        KING_OF_SPADES(10),
        ACE_OF_SPADES(11),

        D_ACE_OF_HEARTS(1),
        D_ACE_OF_DIAMONDS(1),
        D_ACE_OF_CLUBS(1),
        D_ACE_OF_SPADES(1);

        final int cardValue;

        Card(int value)
        {
            this.cardValue = value;
        }

        public int getCardValue() {
            return cardValue;
        }
    }
}
