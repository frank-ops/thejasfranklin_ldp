package com.franklin.Library.srp;

import com.franklin.Library.Library;

public class DisplayBooks {
    public Library user;
    public DisplayBooks(Library user) {
         this.user=user;
    }
    public void displayBooks(){
        System.out.println("books available "+user.bookCount);
    }
}
