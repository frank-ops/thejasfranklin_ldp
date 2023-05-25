package com.franklin.assignment10;

public class ListUsage {
    public static void main(String[] args){
        SList<Integer> list =  new SList<Integer>();
        list.append(list,1);
        list.append(list,2);
        list.append(list,3);
        list.append(list,4);
        list.append(list,5);
        SListIterator<Integer> it = new SListIterator<Integer>(list);
        it.pop();
        it.pop();
        it.pop();
        it.pop();
        it.iterate();
    }
}
