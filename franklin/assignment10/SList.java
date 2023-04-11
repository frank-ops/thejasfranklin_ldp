package com.franklin.assignment10;

public class SList<T>
{
    public
    T val;
    SList<T> last;
    public SList<T> next=null;
    public SList(){
    }
    public void append(SList call, T val)
    {
        if(last==null)
        {
            call.val=val;
            last=call;
            return;
        }
        else
        {
            SList l=new SList();
            l.val=val;
            this.last.next=l;
            this.last=l;
            return;
        }
    }
}
