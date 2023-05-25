package com.franklin.Library.isp;

public class AlterProfile implements Membership {
    Profile P;
    public AlterProfile(Profile P){
        this.P=P;
    }

    @Override
    public void updateToHalfEarly() {
        P.term="half early";
    }

    @Override
    public void updateToMonthly() {
        P.term="monthly";
    }

    @Override
    public void updateToQuarterly() {
        P.term="quarterly";
    }
}
