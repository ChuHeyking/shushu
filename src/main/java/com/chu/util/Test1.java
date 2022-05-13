package com.chu.util;

public class Test1 {
    public static void main(String[] args) {
        String a = "1 2 3 4";
        String[] split = a.split("\\ ");
        for (String s : split) {
            System.out.println(s);
        }
        //System.out.println(split[0]);
    }
}
