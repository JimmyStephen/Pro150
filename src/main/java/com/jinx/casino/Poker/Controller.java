package com.jinx.casino.Poker;

import com.jinx.casino.Shared.Deck;

public class Controller {

    //Will check what player has a winning hand by comparing two of them
    //Will return the number of the player (1 for player1, 2 for player2, exc, and will return 0 for tie)
    //Might change to be //    public int checkForWin(ArrayList<Deck.Card[]> playerHands) so that it takes all players at once
    public int checkForWin(Deck.Card[] player1, Deck.Card[] player2){
        int[] p1Score = getHandScore(player1);
        int[] p2Score = getHandScore(player2);

        //check if either player has a better hand
        if(p1Score[0] > p2Score[0]){
            return 1;
        }else if(p1Score[0] < p2Score[0]){
            return 2;
        }
        //check if the high card is higher for either player
        if(p1Score[1] > p2Score[1]){
            return 1;
        }else if(p1Score[1] < p2Score[1]){
            return 2;
        }
        //check if the kicker is higher for either player
        if(p1Score[2] > p2Score[2]){
            return 1;
        }else if(p1Score[2] < p2Score[2]){
            return 2;
        }
        //check if the third highest is higher for either player
        if(p1Score[3] > p2Score[3]){
            return 1;
        }else if(p1Score[3] < p2Score[3]){
            return 2;
        }else{
            //if it is a tie down to the third card then just return that it's a tie (I cannot be bothered to go farther than this)
            return 0;
        }
    }

    public int[] getHandScore(Deck.Card[] hand){
        if(checkForRFlush(hand)) {return getRFlush(hand);}
        if(checkForSFlush(hand)) {return getSFlush(hand);}
        if(checkFor4OfAKind(hand)) {return get4OfAKind(hand);}
        if(checkForFullHouse(hand)) {return getFullHouse(hand);}
        if(checkForFlush(hand)) {return getFlush(hand);}
        if(checkForStraight(hand)) {return getStraight(hand);}
        if(checkFor3OfAKind(hand)) {return get3OfAKind(hand);}
        if(checkFor2Pair(hand)) {return get2Pair(hand);}
        if(checkForPair(hand)) {return getPair(hand);}
        else {return getHigh(hand);}
    }

    /*
    Will return an int array with the following information
    Value 0 will be the hand ranking 0 for 1 high, 1 for pair, 2 for 2 pair, exc up to 9 for Royal Straight Flush
    Value 1 will be the highest card in the hand
    Value 2 will be the second-highest
    Value 3 will be the third-highest

    NOTE: Values will return as -1 if they are unneeded for any checks, examples being 4 of a kind.
    since you cannot have a 4 of a kind of the same value using only 1 deck of cards the winner will always be
    decided using the 4 of a kind and a kicker is unnecessary
    */
    public int[] getRFlush(Deck.Card[] hand){
        sortHand(hand);
        return new int[]{9, hand[0].getPokerValue(), hand[1].getPokerValue(), hand[2].getPokerValue()};
    }
    public int[] getSFlush(Deck.Card[] hand){
        sortHand(hand);
        return new int[]{8, hand[0].getPokerValue(), hand[1].getPokerValue(), hand[2].getPokerValue()};
    }
    public int[] get4OfAKind(Deck.Card[] hand){
        //variables
        int[] temp = get3OfAKind(hand);
        int high;

        high = temp[1];
        return new int[]{6, high, -1, -1};
    }
    public int[] getFullHouse(Deck.Card[] hand){
        int[] temp = get3OfAKind(hand);
        int[] temp2 = get2Pair(hand);

        int high;
        int kicker;

        high = temp[1];

        if(temp[1] == temp2[1]){
            kicker = temp2[2];
        }else{
            kicker = temp2[1];
        }

        return new int[]{6, high, kicker, -1};
    }
    public int[] getFlush(Deck.Card[] hand){
        //order the hand high to low
        sortHand(hand);
        return new int[]{5, hand[0].getPokerValue(), hand[1].getPokerValue(), hand[2].getPokerValue()};
    }
    public int[] getStraight(Deck.Card[] hand){
        return new int[]{4, hand[0].getPokerValue(), hand[1].getPokerValue(), hand[2].getPokerValue()};
    }
    public int[] get3OfAKind(Deck.Card[] hand){
        //make variables
        Deck.Card high = null;
        Deck.Card kicker;
        Deck.Card secondKicker;

        //order the hand high to low
        sortHand(hand);

        for(int i = 0; i < hand.length; i++){
            for(int j = 0; j < hand.length; j++){
                if(i != j){
                    if(hand[i].getPokerValue() == hand[j].getPokerValue()){
                        for(int k = 0; k < hand.length; k++){
                            if(i != k && j != k){
                                if(hand[i].getPokerValue() == hand[k].getPokerValue()){
                                    high = hand[i];
                                }
                            }
                        }
                    }
                }
            }
        }

        assert high != null;
        if(hand[0].getPokerValue() != high.getPokerValue()){
            kicker = hand[0];
            if(hand[1].getPokerValue() != high.getPokerValue()){
                secondKicker = hand[1];
            }else{
                secondKicker = hand[4];
            }
        }else{
            kicker = hand[3];
            secondKicker = hand[4];
        }
        return new int[] {3, high.getPokerValue(), kicker.getPokerValue(), secondKicker.getPokerValue()};
    }
    public int[] get2Pair(Deck.Card[] hand){

        //declare variables
        int[] firstPair;
        Deck.Card secondPair = null;
        Deck.Card kicker = null;

        //sort the hand highest to lowest
        sortHand(hand);
        //get the first pair
        firstPair = getPair(hand);

        //find the second pair
        for (int i = 0; i < hand.length; i++) {
            for (int j = 0; j < hand.length; j++) {
                if (i != j) {
                    if (hand[i].getPokerValue() == hand[j].getPokerValue() && hand[i].getPokerValue() != firstPair[1]) {
                        secondPair = hand[i];
                    }
                }
            }
        }

        //find the kicker
        assert secondPair != null;
        for (Deck.Card card : hand) {
            if (card.getPokerValue() != firstPair[1] && card.getPokerValue() != secondPair.getPokerValue()) {
                kicker = card;
            }
        }

        if(kicker == null){
            if(firstPair[1] > secondPair.getPokerValue()) {
                return new int[]{2, firstPair[1], secondPair.getPokerValue(), -1};
            }else{
                return new int[]{2, secondPair.getPokerValue(), firstPair[1], -1};
            }
        }else{
            if(firstPair[1] > secondPair.getPokerValue()) {
                return new int[]{2, firstPair[1], secondPair.getPokerValue(), kicker.getPokerValue()};
            }else{
                return new int[]{2, secondPair.getPokerValue(), firstPair[1], kicker.getPokerValue()};
            }
        }
    }
    public int[] getPair(Deck.Card[] hand){

        //declare variables
        Deck.Card pair = null;
        Deck.Card kicker;
        Deck.Card third;

        //sort the hand highest to lowest
        sortHand(hand);
        //find the pair
        for(int i = 0; i < hand.length; i++){
            for(int j = 0; j < hand.length; j++){
                if(i != j){
                    if(hand[i].getPokerValue() == hand[j].getPokerValue()){
                        pair = hand[i];
                    }
                }
            }
        }

        //find the kicker and third highest
        assert pair != null;
        if(pair.getPokerValue() != hand[0].getPokerValue()){
            kicker = hand[0];
            if(pair.getPokerValue() != hand[1].getPokerValue()) {
                third = hand[1];
            }
            else{
               third = hand[2];
            }
        }else{
            kicker = hand[2];
            third = hand[3];
        }

        return new int[]{1,pair.getPokerValue(),kicker.getPokerValue(),third.getPokerValue()};
    }
    public int[] getHigh(Deck.Card[] hand){
        sortHand(hand);
        return new int[] {0, hand[0].getCardValue(), hand[1].getCardValue(), hand[2].getCardValue()};
    }

    //These methods will return true or false if they have the hand being checked
    public boolean checkForRFlush(Deck.Card[] hand){
        return checkForSFlush(hand) && hand[1].getPokerValue() == 14;
    }
    public boolean checkForSFlush(Deck.Card[] hand){
        return checkForStraight(hand) && checkForFlush(hand);
    }
    public boolean checkFor4OfAKind(Deck.Card[] hand){
        for(int i = 0; i < hand.length; i++){
            for(int j = 0; j < hand.length; j++){
                if(i != j){
                    if(hand[i].getPokerValue() == hand[j].getPokerValue()){
                        for(int k = 0; k < hand.length; k++){
                            if(i != k && j != k){
                                if(hand[i].getPokerValue() == hand[k].getPokerValue()){
                                    for(int o = 0; o < hand.length; o++){
                                        if(o != i && o != j && o != k){
                                            if(hand[i].getPokerValue() == hand[o].getPokerValue()){
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    public boolean checkForFullHouse(Deck.Card[] hand){
        if(checkFor3OfAKind(hand)){
            return checkFor2Pair(hand);
        }
        return false;
    }
    public boolean checkForFlush(Deck.Card[] hand){
        for (Deck.Card c : hand) {
            if(!hand[0].getCardSuit().equals(c.getCardSuit())){
                return false;
            }
        }
        return true;
    }
    public boolean checkForStraight(Deck.Card[] hand){
        sortHand(hand);

        if(hand[0].getPokerValue() == 15 && hand[1].getPokerValue() == 5){
             return (hand[2].getPokerValue() == 4 && hand[3].getPokerValue() == 3 && hand[4].getPokerValue() == 2);
        }else{
            for(int i = 0; i < hand.length - 1; i++){
                if((hand[i].getPokerValue() - 1) != hand[i + 1].getPokerValue()){
                    return false;
                }
            }
            return true;
        }
    }
    public boolean checkFor3OfAKind(Deck.Card[] hand){
        for(int i = 0; i < hand.length; i++){
            for(int j = 0; j < hand.length; j++){
                if(i != j){
                    if(hand[i].getPokerValue() == hand[j].getPokerValue()){
                        for(int k = 0; k < hand.length; k++){
                            if(i != k && j != k){
                                if(hand[i].getPokerValue() == hand[k].getPokerValue()){
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    public boolean checkFor2Pair(Deck.Card[] hand){
        int temp = -1;
        for(int i = 0; i < hand.length; i++){
            for(int j = 0; j < hand.length; j++){
                if(i != j){
                    if(hand[i].getPokerValue() == hand[j].getPokerValue()){
                        temp = hand[i].getPokerValue();
                    }
                }
            }
        }
        if(temp != -1) {
            for (int i = 0; i < hand.length; i++) {
                for (int j = 0; j < hand.length; j++) {
                    if (i != j) {
                        if (hand[i].getPokerValue() == hand[j].getPokerValue() && hand[i].getPokerValue() != temp) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public boolean checkForPair(Deck.Card[] hand){
        for(int i = 0; i < hand.length; i++){
            for(int j = 0; j < hand.length; j++){
                if(i != j){
                    if(hand[i].getPokerValue() == hand[j].getPokerValue()){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //sorts the hand from the highest value to lowest
    public void sortHand(Deck.Card[] hand){
        //make temp variables
        Deck.Card tempA;
        Deck.Card tempB;

        for (int i = 0; i < hand.length; i++) {
            for (int j = 0; j < hand.length; j++) {
                //set the temp variables to the locations in the array
                tempA = hand[i];
                tempB = hand[j];
                //compare the values to see if A is greater than B
                if(tempA.getPokerValue() > tempB.getPokerValue()){
                    //if A > B then swap them in the array
                    hand[j] = tempA;
                    hand[i] = tempB;
                }
            }
        }
    }
}
