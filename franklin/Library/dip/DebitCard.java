package com.franklin.Library.dip;

public class DebitCard extends Card{
    @Override
    public void getAmount(int amount) {
        System.out.println("successfully deducted "+amount+"rs from Debit Card");
    }
}
