package Models;

import com.Pro150.Casino.Shared.Deck;

import java.util.ArrayList;

public class Player {

    private ArrayList<Deck.Card> hand = new ArrayList<>();
    private int currentHandTotal;

    public void setHand(ArrayList<Deck.Card> hand) {
        this.hand = hand;
    }
    public void setCurrentHandTotal(int currentHandTotal) {
        this.currentHandTotal = currentHandTotal;
    }
    public ArrayList<Deck.Card> getHand() {
        return hand;
    }
    public int getCurrentHandTotal() {
        return currentHandTotal;
    }
    public int getHandSize(){
        return hand.size();
    }

    public void addToHand(Deck.Card cardToAdd){
        hand.add(cardToAdd);
    }
}
