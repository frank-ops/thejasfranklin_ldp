package com.franklin.Library.lsp;

public class SuperUser extends UserActions implements PrimeActions{
    @Override
    public void payBill() {
        System.out.println("bill payment was done by super user");
    }

    @Override
    public void renewAccount() {
        System.out.println("renew account was done by super user");
    }

    @Override
    public void extendLimit() {
        System.out.println("book limit was extended by super user");
    }
}
