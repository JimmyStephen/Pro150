package com.jinx.casino.Blackjack;

import com.jinx.casino.Models.Player;
import com.jinx.casino.Shared.Deck;

import java.util.ArrayList;


public class Controller {

    public static Deck myDeck = new Deck();
    public static Player dealer = new Player();

    public static void main(String[] args){ }

    public static void InIt(){
        //make a deck and shuffle
        myDeck.newDeck();
        myDeck.shuffleDeck();
        myDeck.shuffleDeck();

        //add the starting cards to the dealers hand
        dealer.addToHand(myDeck.drawCard());
        dealer.addToHand(myDeck.drawCard());
    }

    public static ArrayList<Deck.Card> hit(ArrayList<Deck.Card> playerHand){
        playerHand.add(myDeck.drawCard());
        if(getTotal(playerHand) >= 22) {findAce(playerHand);}
        return playerHand;
    }

    public static void dealerTurn(){
        boolean quit = (getTotal(dealer.getHand()) > 17);
        while(!quit)
        {
            dealer.addToHand(myDeck.drawCard());

            int currentTotal = getTotal(dealer.getHand());
            if(currentTotal > 21) {
                if(!findAce(dealer.getHand())) {
                    quit = true;
                }
                currentTotal = getTotal(dealer.getHand());
            }
            if(currentTotal >= 17) {quit = true;}
        }
    }

    //find the total of a players hand
    public static int getTotal(ArrayList<Deck.Card> hand){
        int total = 0;
        for (Deck.Card card : hand) {total += card.getCardValue();}
        return total;
    }

    //check to see if there is an Ace in the players hand, if there is replaced it with a Dead Ace (worth 1 instead of 11)
    public static boolean findAce(ArrayList<Deck.Card> hand){
        for (Deck.Card card: hand) {
            if(card == Deck.Card.ACE_OF_CLUBS){
                hand.remove(card);
                hand.add(Deck.Card.D_ACE_OF_CLUBS);
                return true;
            }else if(card == Deck.Card.ACE_OF_HEARTS){
                hand.remove(card);
                hand.add(Deck.Card.D_ACE_OF_HEARTS);
                return true;
            }else if(card == Deck.Card.ACE_OF_DIAMONDS){
                hand.remove(card);
                hand.add(Deck.Card.D_ACE_OF_DIAMONDS);
                return true;
            }else if(card == Deck.Card.ACE_OF_SPADES) {
                hand.remove(card);
                hand.add(Deck.Card.D_ACE_OF_SPADES);
                return true;
            }
        }
        return false;
    }

    //Takes in a player's hand and a dealer's hand and compares them to see if the player wins
    public static int findWinners(ArrayList<Deck.Card> player){
        //possible outcome
            // 1 - Player win
            // 2 - Player lose/dealer win
            // 3 - Player blackjack (1.5* bet winnings)
            // 4 - Draw (money pushback)

        //temp data
        int playerHand = getTotal(player);
        int dealerHand = getTotal(dealer.getHand());

        //check is player is over 21
        if(playerHand >= 22){
            //you can instantly leave since nothing else matters at this point
            System.out.println("Player Bust");
            //return player lose
            return 2;
        }

        //check if player has a nat 21/blackjack
        if((player.size() == 2 && playerHand == 21) && (dealer.getHandSize() != 2 || dealerHand != 21)){
            System.out.println("Player Blackjack");
            //return Player win 1.5*
            return 3;
        }

        //check if dealer has a nat 21/blackjack
        if((dealer.getHandSize() == 2 && dealerHand == 21) && (player.size() != 2 || playerHand != 21)){
            System.out.println("Dealer Blackjack");
            //return playerLose
            return 2;
        }

        //check if tie
        if(playerHand == dealerHand){
            //at this point you can leave since it is a draw
            System.out.println("Draw");
            //return money pushed back
            return 4;
        }

        //check if the dealer is over 21 if he is and the player isnt player wins
        if(dealerHand >= 22 && playerHand <= 21){
            System.out.println("Dealer Bust");
            //return player win
            return 1;
        }

        //check is player had is greater than the dealers and less than 21
        if(playerHand > dealerHand){
            System.out.println("Player Wins");
            //return player win
            return 1;
        }else{
            System.out.println("Dealer Wins");
            //return player lose
            return 2;
        }
    }
}
