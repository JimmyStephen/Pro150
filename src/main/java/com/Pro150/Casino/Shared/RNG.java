package com.Pro150.Casino.Shared;
import java.util.Random;


public class RNG {



        public static int Run(){
            Random rand = new Random();
            int max = 9;
            int int_rand = rand.nextInt(max) +1;
            return int_rand;
        }


}
