package com.hyw.offer.leet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/26 15:26
 * Description：TODO
 */
public class Main210 {

    static int WHITE = 1;
    static int GRAY = 2;
    static int BLACK = 3;

    boolean isPossible;
    Map<Integer, Integer> color;
    Map<Integer, List<Integer>> adjList;


    private void init(int numCourses) {
        this.isPossible = true;
        this.color = new HashMap<Integer, Integer>();
        this.adjList = new HashMap<Integer, List<Integer>>();

        // By default all vertces are WHITE
        for (int i = 0; i < numCourses; i++) {
            this.color.put(i, WHITE);
        }
    }

    private void dfs(int node) {

        if (!isPossible) {
            return;
        }
        color.put(node, GRAY);
        List<Integer> list = adjList.get(node);
        if (list != null) {
            list.forEach(num -> {
                if (color.get(num) == WHITE) {
                    dfs(num);
                } else if (color.get(num) == GRAY) {
                    isPossible = false;
                }
            });
        }
        color.put(node, BLACK);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        this.init(numCourses);
        for (int[] prerequisite : prerequisites) {
            int first = prerequisite[0];
            int second = prerequisite[1];
            List<Integer> list = adjList.getOrDefault(first, new ArrayList<>());
            list.add(second);
            adjList.put(first, list);
        }

        for (int i = 0; i < numCourses; i++) {
            if (color.get(i) == WHITE) {
                dfs(i);
            }
        }

        return isPossible;

    }




}
