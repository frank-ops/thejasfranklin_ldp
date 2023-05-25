package com.franklin.Library.dip;

public class MembershipRenewal {
    Card card;
    public MembershipRenewal(Card card){
        this.card=card;
    }
    public void payment(int amount){
        card.getAmount(amount);
    }
    public static void main(String[] args){
        Card card=new CreditCard();
        MembershipRenewal m=new MembershipRenewal(card);
        m.payment(1200);
    }
}
