package com.franklin.Library.ocp;

public class NewBooks implements Deadline{
    @Override
    public void showDeadline() {
        System.out.println("deadline for old books is 8 days");
    }
}
