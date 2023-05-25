package com.franklin.Library.srp;

import com.franklin.Library.Library;

public class AddBook {
    Library user;
    public AddBook(Library user){
        this.user=user;
    }
    public void addBook(int book){
        System.out.println(book+" book(s) are added");
        user.bookCount+=book;
    }
}
