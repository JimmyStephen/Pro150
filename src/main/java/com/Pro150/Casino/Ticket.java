package com.Pro150.Casino;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Ticket {
    int[] numbers =new int[7];
    private static int getRandomInt(int min, int max){
        Random rng = new Random();
        int randNum = rng.nextInt(max - min + 1)+ min;
        return randNum;
    }

public void fillticket(){
    for(int i=0; i<numbers.length; i++){

        numbers[i] = getRandomInt(1,99);
    }
    }
}
