package com.franklin.assignment1;
import java.io.File;
import java.util.Scanner;
import com.franklin.RegexSearch;
public class DirectorySearch {
    public void dSearch(String root,String fileName){
        File dir = new File(root);
        File [] list = dir.listFiles();
        for(File file:list) {
            if (file.isDirectory()) {
                dSearch(file.getAbsolutePath(), fileName);
            } else if (new RegexSearch().Regex(fileName,file.getName().toString())) {
                System.out.println(file.getAbsolutePath());
            }
        }
    }
    public static void main(String[] args){
        String limiter ;
        String root  = "F:\\eclipse\\com.franklin.Library.Library";
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("enter : Q - Quit");
            limiter = input.nextLine();
            if(limiter.charAt(0) =='Q')
            {
                break;
            }
            new DirectorySearch().dSearch(root,limiter);
        }
    }
}
