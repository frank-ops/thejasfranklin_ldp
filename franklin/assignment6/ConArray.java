package com.franklin.assignment6;

public class ConArray {
    String name;
    public ConArray(String name){
       System.out.println("instance created with name"+name);
    }
    public static void main(String[] args){
        //task -3
        ConArray[] ob = new ConArray[5];
        //task-4
        for(int i=0;i<ob.length;i++){
            String name=""+i;
            ob[i]=new ConArray(name);
        }
    }
}
