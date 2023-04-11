package com.franklin.assignment3;

import java.io.*;
import java.net.*;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class InetPing {
    public void pingByIp(String Address)
            throws UnknownHostException, IOException
    {
        long finish = 0;
        long start = new GregorianCalendar().getTimeInMillis();
        InetAddress geek = InetAddress.getByName(Address);
        if (geek.isReachable(5000)) {
            finish = new GregorianCalendar().getTimeInMillis();
            System.out.println("Host is reachable "+"in "+(finish-start)/2+"ms(median)");
        }
        else {
            System.out.println("host is unreachable");
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String ipAddress= input.nextLine();
        new InetPing().pingByIp(ipAddress);
    }
}
