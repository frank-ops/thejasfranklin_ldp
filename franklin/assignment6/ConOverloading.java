package com.franklin.assignment6;

public class ConOverloading {
    int value;
    String name;
    public ConOverloading(String name){
        this(15);
        System.out.println("constructor 1 invoked");
        this.name=name;
        System.out.println("object is created with name as "+this.name+" and value as "+this.value);
    }
    public ConOverloading(int value){
        this.value=value;
        System.out.println("constructor 2 invoked");
    }
    public static void main(String[] args){
        ConOverloading obj =new ConOverloading("franklin");
    }
}
