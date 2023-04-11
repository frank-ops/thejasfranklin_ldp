package com.franklin.assignment10;

import com.franklin.assignment10.SList;

public class SListIterator<T> {
    SList<T> list;
    public SListIterator(SList<T> list){
        this.list=list;
    }
    public void pop(){
        SList<T> buffer = list;
        SList<T> prev = null;
        while(true){
            if(buffer.next==null){
               if(prev==null)
               {
                  buffer=null;
                  System.out.println("out "+buffer.val);
               }
               else{
                   prev.next=null;
               }
               break;
            };
            prev=buffer;
            buffer=buffer.next;
        }
    }
    public void iterate(){
        SList<T> buffer = list;
        while(buffer!=null){
           System.out.println(buffer.val);
           buffer=buffer.next;
        }
    }
}
