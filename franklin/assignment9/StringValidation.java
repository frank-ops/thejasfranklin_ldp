package com.franklin.assignment9;

import com.franklin.RegexSearch;

import java.util.Scanner;

public class StringValidation {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        if(new RegexSearch().RegexSen("^[A-Z]\\w*\\.$",text)){
            System.out.println("matches the condition of capital letter at first and period at last");
        }
        else{
            System.out.println("unmatched with condition of capital letter at first and period at last");
        }
    }
}
