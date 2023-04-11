package com.franklin.assignment5.main;

import com.franklin.assignment5.data.Data;
import com.franklin.assignment5.singleton.Singleton;

public class PakageMain {
    public static void main(String[] args) {
        Data obj1 = new Data();
        obj1.printVariables();
        obj1.printLocalVariables();

        Singleton obj2 = Singleton.initializeString("Hello World");
        obj2.printString();
    }
}
