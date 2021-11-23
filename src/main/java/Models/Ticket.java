package Models;

import java.util.Random;

public class Ticket {

    public void generateTicket(){
        fillticket();
    }

    int[] numbers = new int[7];


public void fillticket(){
    for(int i=0; i<numbers.length; i++){
        numbers[i] = getRandomInt(1,99);
    }
    }

    private static int getRandomInt(int min, int max){
        Random rng = new Random();
        int randNum = rng.nextInt(max - min + 1)+ min;
        return randNum;
    }
}
