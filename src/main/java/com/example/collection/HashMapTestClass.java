package com.example.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

/**
 * 类HashMapTestClass.java的实现描述：TODO 类实现描述
 * 
 * @author liupan Jun 14, 2022 3:55:19 PM
 */
public class HashMapTestClass {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();

        map.put(null, "123");

        System.out.println(map.get(null));

        Hashtable<String, String> tb = new Hashtable<>();
        //        tb.put(null, "123");
        //        System.out.println(tb.get(null));

        HashSet<String> set = new HashSet<>();

        boolean r1 = set.add("123");
        boolean r2 = set.add("456");
        boolean r3 = set.add("123");
        boolean r4 = set.add(null);

        System.out.println(set);
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);
        
        List l1 = new ArrayList<>();
        
        List l2 = new LinkedList<>();

    }
}
