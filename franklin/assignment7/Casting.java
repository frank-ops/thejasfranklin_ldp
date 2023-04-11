package com.franklin.assignment7;

class Cycle{
    public void ride(){
        System.out.println("riding cycle");
    }
}
class Unicycle extends Cycle{
    public void ride(){
        System.out.println("riding com.franklin.assignment7.Unicycle");
    }
    public void balance(){
        System.out.println("it can be balanced easily");
    }
}
class Bicycle extends Cycle{
    public void ride(){
        System.out.println("riding com.franklin.assignment7.Bicycle");
    }
    public void balance(){
        System.out.println("it can be balanced easily");
    }
}
class Tricycle extends Cycle{
    public void ride(){
        System.out.println("riding com.franklin.assignment7.Tricycle");
    }
}
public class Casting {
    public static void main(String[] args){
        //Up-casting
        Cycle[] C= {new Unicycle(),
         new Bicycle(),
         new Tricycle()};
        C[0].ride();
        C[1].ride();
        C[2].ride();
        //Down-casting
        Unicycle U = (Unicycle) C[0];
        Bicycle B = (Bicycle) C[1];
        Tricycle T = (Tricycle) C[2];
        U.balance();
        B.balance();
       // T.balance(); this gives error because there is no balance in the downcasted object of com.franklin.assignment7.Tricycle
    }
}
