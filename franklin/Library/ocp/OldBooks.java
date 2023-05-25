package com.franklin.Library.ocp;

public class OldBooks implements Deadline{
    @Override
    public void showDeadline() {
        System.out.println("deadline for old books is 10 days");
    }
}
