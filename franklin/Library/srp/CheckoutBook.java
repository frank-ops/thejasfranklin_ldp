package com.franklin.Library.srp;

import com.franklin.Library.Library;

public class CheckoutBook {
    public Library user;
    public CheckoutBook(Library user) {
        this.user=user;
    }
    public void checkoutBook(){
        System.out.println(this.toString());
        if(user.bookCount==0){
            System.out.println("no books are there to checkout");
        }
        else{
            user.booksTaken+=1;
            user.bookCount-=1;
            System.out.println("book is taken");
        }
    }
}
