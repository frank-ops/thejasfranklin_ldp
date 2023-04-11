package com.franklin.assignment7;

abstract class Rodent {
    public Rodent(){
        System.out.println("this is parent class");
    }
    abstract void animalFeature();
    abstract String color();
}
class Mouse extends Rodent{
    public Mouse(){
        System.out.println("com.franklin.assignment7.Mouse inheritance is created");
    }
    public void animalFeature(){
        System.out.println("lengthy tail and short ears");
    }
    public String color(){
        return "brown";
    }
}

class Gerbil extends Rodent{
    public Gerbil(){
        System.out.println("com.franklin.assignment7.Gerbil inheritance is created");
    }
    public void animalFeature(){
        System.out.println("lengthy tail and wide ears");
    }
    public String color(){
        return "light brown";
    }
}
class Hamster extends Rodent{
    public Hamster(){
        System.out.println("com.franklin.assignment7.Hamster inheritance is created");
    }
    public void animalFeature(){
        System.out.println("small tail or no tail sometimes and wide ears");
    }
    public String color(){
        return "Beige";
    }
}

public class Inheritance{
    public static void main(String[] args){
        Rodent list[]=new Rodent[3];
        list[0]=new Mouse();
        list[1]=new Gerbil();
        list[2]=new Hamster();
        list[0].animalFeature();
        System.out.println(list[0].color());
        list[1].animalFeature();
        System.out.println(list[1].color());
        list[2].animalFeature();
        System.out.println(list[2].color());
    }
}
