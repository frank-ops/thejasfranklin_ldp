package com.franklin.Library.dip;

public class CreditCard extends Card{
    @Override
    public void getAmount(int amount) {
        System.out.println("successfully deducted "+amount+"rs from Credit Card");
    }
}
