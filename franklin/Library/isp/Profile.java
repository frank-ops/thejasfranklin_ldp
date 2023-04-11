package com.franklin.Library.isp;

public class Profile implements Checkout{
    String term;
    @Override
    public void checkoutBook() {
        System.out.println("checkout from library");
    }

    @Override
    public void getDiscount() {
        System.out.println("discount Applied");
    }
}
