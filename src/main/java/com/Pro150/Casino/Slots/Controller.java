package com.Pro150.Casino.Slots;

public class Controller {
  
    private static int[] rewards = {1000,2000,5000,8000,10000,20000,50000};
    private static int slotPos = 0;
    private enum Icons{
        grape,
        strawberry,
        Seven,
        Bar,
        Lemon,
        Chest,
        Pie
    };
    private static Icons[] icons = new Icons[3];

    public static int Spin(){
        Random rand = new Random();
        int slot = rand.nextInt(7);
        icons[slotPos] = GetIcon(slot);
        slotPos++;
        if(slotPos == 3){
            int reward = winLose(slot);
        }
      return reward;
    }
    public static int winLose(int slot){
        if(icons[1] == icons[2] && icons[1] == icons[3]){
            slotPos = 0;
            return rewards[slot];
        }
        else{
            slotPos = 0;
            return 0;
        }
    }
    public static Icons GetIcon(int i){
        if(i == 1){
            return Icons.grape;
        }
        else if(i == 2){
            return Icons.Lemon;
        }
        else if(i == 3){
            return Icons.strawberry;
        }
        else if(i == 4){
            return Icons.Pie;
        }
        else if(i == 5){
            return Icons.Chest;
        }
        else if(i == 6){
            return Icons.Bar;
        }
        else if(i == 7){
            return Icons.Seven;
        }
        else{
            return null;
        }
    }
}
