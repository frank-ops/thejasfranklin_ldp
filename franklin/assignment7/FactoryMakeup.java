package com.franklin.assignment7;

interface Cycles{
    void ride();
}
interface CycleFactory{
    Cycles manufacture();
}
class Bicycles implements Cycles{
    public void ride(){
        System.out.println("riding a bicycle");
    }
}
class Unicycles implements Cycles{
    public void ride(){
        System.out.println("riding a unicycle");
    }
}
class Tricycles implements Cycles{
    public void ride(){
        System.out.println("riding a tricycle");
    }
}
class BicycleFactory implements  CycleFactory{
    public Bicycles manufacture(){
        System.out.println("com.franklin.assignment7.Bicycle manufactured");
        return new Bicycles();
    }
}
class UnicycleFactory implements  CycleFactory{
    public Unicycles manufacture(){
        System.out.println("com.franklin.assignment7.Unicycle manufactured");
        return new Unicycles();
    }
}
class TricycleFactory implements  CycleFactory{
    public Tricycles manufacture(){
        System.out.println("com.franklin.assignment7.Tricycle manufactured");
        return new Tricycles();
    }
}
public class FactoryMakeup {
    public static void main(String[] args) {
        BicycleFactory bFactory = new BicycleFactory();
        UnicycleFactory uFactory = new UnicycleFactory();
        TricycleFactory tFactory = new TricycleFactory();
        Bicycles bicycle = bFactory.manufacture();
        Unicycles unicycle = uFactory.manufacture();
        Tricycles tricycle = tFactory.manufacture();
        bicycle.ride();
        unicycle.ride();
        tricycle.ride();
    }
}
