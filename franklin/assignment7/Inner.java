package com.franklin.assignment7;

class Primary {
    private String arg;

    public Primary(String arg) {
        this.arg = arg;
    }

    public class InnerClass {
        private String innerArg;

        public InnerClass(String innerArg) {
            System.out.println("inner class called");
            this.innerArg = innerArg;
        }
    }
}

class Secondary {
    public static class SecondaryInnerClass extends Primary.InnerClass {
        private String secondaryInnerArg;

        public SecondaryInnerClass(String secondaryInnerArg, Primary p, String innerArg) {
            p.super(innerArg);
            this.secondaryInnerArg = secondaryInnerArg;
        }
    }
}

public class Inner {
    public static void main(String[] args){
        Primary ob1 = new Primary("thejas");
        Secondary.SecondaryInnerClass ob = new Secondary.SecondaryInnerClass("franklin",ob1,"thejas") ;
    }
}
