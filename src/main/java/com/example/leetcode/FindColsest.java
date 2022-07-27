package com.example.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * 有个内含单词的超大文本文件，给定任意两个不同的单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。
 * 如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/find-closest-lcci
 * 输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
   输出：1
 * </pre>
 * 
 * @author liupan May 28, 2022 2:24:25 PM
 */
public class FindColsest {

    public static void main(String[] args) {
        String[] words = { "I", "am", "a", "student", "from", "a", "university", "in", "a", "city" };
        String word1 = "a";
        String word2 = "I";
        System.out.println(findClosest(words, word1, word2));
    }

    public static int findClosest(String[] words, String word1, String word2) {

        int res = 0;

        Map<String, List<Integer>> wordMap = new HashMap<String, List<Integer>>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (wordMap.containsKey(word)) {
                wordMap.get(word).add(i);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                wordMap.put(word, list);
            }
        }

        List<Integer> listWord1 = wordMap.get(word1);
        List<Integer> listWord2 = wordMap.get(word2);
        if (null == listWord1 || null == listWord2) {
            return 0;
        } else {
            res = findMin(listWord1, listWord2);
        }

        return res;
    }

    private static int findMin(List<Integer> listWord1, List<Integer> listWord2) {
        int min = -1;
        for (int i = 0; i < listWord1.size(); i++) {
            int word1Index = listWord1.get(i);

            for (int j = 0; j < listWord2.size(); j++) {
                int word2Index = listWord2.get(j);

                if (min < 0) {
                    min = Math.abs(word2Index - word1Index);
                } else {
                    min = Math.min(min, Math.abs(word2Index - word1Index));
                }
                if (word1Index <= word2Index) {
                    break;
                }
            }

        }

        return min;
    }
}
