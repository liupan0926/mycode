package com.example.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {

        List<Long> articleIds = new ArrayList<>();
        articleIds.add(1L);
        articleIds.add(2L);

        Map<Long, ListNode> articlesMap = new HashMap<>();

        for (Long articleId : articleIds) {
            ListNode node = null;
            if (articleId == 1L) {
                node = new ListNode(1);
            } else if (articleId == 2L) {
                node = null;
                System.out.println("getArticleById null, articleId is:" + articleId);
                continue;
            }
            articlesMap.put(articleId, node);
        }
        System.out.println(articlesMap);
    }

}
