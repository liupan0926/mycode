package com.example.application;

import java.util.ArrayList;

public class SolutionTest {
    
    public static void main(String[] args) {
        int number = 900;
        
        int ss = reverseInteger(number);
        
        System.out.println(ss);
        
    }
    
    
    public static int reverseInteger(int number) {
        // write your code here

        int res = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        int size = 0;
        while (number > 0) {
            int x = number % 10;
            number = number / 10;
            list.add(x);
            size++;
        }
        for (Integer x : list) {
            res = res + x * pow(10, size - 1);
            size--;
        }
        return res;
    }

    public static int pow(int a, int b) {
        
        if (b == 0) {
            return 1;
        } else {
            int res = 1;
            while (b > 0) {
                res = res * a;
                b--;
            }
            return res;
        }
    }
}
