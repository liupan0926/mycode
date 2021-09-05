package com.example.application;

import java.util.LinkedHashMap;

/**
 * 本地的相关算法类 类LRUCacheTest.java的实现描述：TODO 类实现描述
 * 
 * @author liupan Sep 4, 2021 11:21:36 AM
 */
public class LRUCacheTest {

    public void lruTest() {
        LinkedHashMap<String, String> cacheList = this.init();
        
        System.out.println(cacheList.size());
        System.out.println(cacheList);

    }

    public static LinkedHashMap<String, String> init() {

        final int size = 3;
        LinkedHashMap<String, String> cacheList = new LinkedHashMap<String, String>(size, 0.75F, true) {
            @Override
            protected boolean removeEldestEntry(java.util.Map.Entry<String, String> eldest) {
                return size() > size;
            }
        };

        cacheList.put("1", "1");
        cacheList.put("3", "3");
        cacheList.put("4", "4");
        cacheList.put("2", "2");
        cacheList.put("3", "3");
        
        return cacheList;
    }
    
}
