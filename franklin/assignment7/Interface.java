package com.franklin.assignment7;

interface Interface1 {
    void method1();
    void method2();
}

interface Interface2 {
    void method3();
    void method4();
}

interface Interface3 {
    void method5();
    void method6();
}

interface CombinedInterface extends Interface1, Interface2, Interface3 {
    void method7();
}

class ConcreteClass {
    void someMethod() {
        System.out.println("This is a method of the concrete class");
    }
}

class MyClass extends ConcreteClass implements CombinedInterface {
    @Override
    public void method1() {
        System.out.println("Method 1");
    }

    @Override
    public void method2() {
        System.out.println("Method 2");
    }

    @Override
    public void method3() {
        System.out.println("Method 3");
    }

    @Override
    public void method4() {
        System.out.println("Method 4");
    }

    @Override
    public void method5() {
        System.out.println("Method 5");
    }

    @Override
    public void method6() {
        System.out.println("Method 6");
    }

    @Override
    public void method7() {
        System.out.println("Method 7");
    }
}

public class Interface {
    static void methodA(Interface1 interface1) {
        interface1.method1();
        interface1.method2();
    }

    static void methodB(Interface2 interface2) {
        interface2.method3();
        interface2.method4();
    }

    static void methodC(Interface3 interface3) {
        interface3.method5();
        interface3.method6();
    }

    static void methodD(CombinedInterface combinedInterface) {
        combinedInterface.method1();
        combinedInterface.method2();
        combinedInterface.method3();
        combinedInterface.method4();
        combinedInterface.method5();
        combinedInterface.method6();
        combinedInterface.method7();
    }

    public static void main(String[] args) {
        MyClass myObject = new MyClass();
        methodA(myObject);
        methodB(myObject);
        methodC(myObject);
        methodD(myObject);
    }
}
