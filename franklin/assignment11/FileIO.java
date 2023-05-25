package com.franklin.assignment11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class FileIO
{
    public static void main(String[] args) throws IOException
    {
        File f=new File("input.txt");
        HashMap<Character,Integer> counter = new HashMap<Character,Integer>();
        FileReader fr=new FileReader(f);
        BufferedReader br=new BufferedReader(fr);
        int c = 0;
        while((c = br.read()) != -1)
        {
            char character = (char) c;
            if (counter.containsKey(character)) {
                counter.put(character, counter.get(character) + 1);
            }
            else {
                counter.put(character, 1);
            }
        }
        File fileRes = new File("output.txt");
        FileWriter fw = new FileWriter(fileRes);
        fw.write("count of characters\n");
        counter.forEach((key,value)->{
         String text=key+" : "+value+"\n";
           try {
                fw.append(text);
           }
           catch(Exception e){
               System.out.println(e);
           }
        });
        fw.close();
    }
}
