package com.franklin.Library.srp;

import com.franklin.Library.Library;

public class ReturnBook {
    public Library user;
    public ReturnBook(Library user) {
        this.user=user;
    }
    public void returnBook(){
        System.out.println(this.toString());
        if(user.booksTaken==0){
            System.out.println("no books to return");
        }
        else{
            user.booksTaken-=1;
            user.bookCount=user.bookCount+1;
            System.out.println("book is returned");
        }
    }
}
