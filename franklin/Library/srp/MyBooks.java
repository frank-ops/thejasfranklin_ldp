package com.franklin.Library.srp;

import com.franklin.Library.Library;

public class MyBooks {
    public Library user;
    public MyBooks(Library user) {
        this.user=user;
    }
    public void myBooks(){
        System.out.println(this.toString());
        if(user.booksTaken==0){
            System.out.println("no books are there in users name");
        }
        else{
            System.out.println("books taken till now "+user.booksTaken);
        }
    }
}
