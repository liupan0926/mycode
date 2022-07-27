package com.example.javabase;

public class Chaixiang {

    public static void main(String[] args) {
        //        Integer a = new Integer(1);
        //        Integer b = new Integer(1);
        //        System.out.println(a == b);
        //        System.out.println(a.equals(b));
        //        a = 2;
        //        b = 2;
        //        System.out.println(a == b);

        int c = 1;
        updateData1(c);
        System.out.println(c);

        Integer d = 1;
        updateData2(d);
        System.out.println(d);
    }

    public static void updateData1(int a) {
        a = 2;
        return;
    }

    public static void updateData2(Integer a) {
        a = 3;
        return;
    }

}
