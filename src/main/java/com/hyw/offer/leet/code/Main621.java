package com.hyw.offer.leet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/4/1 15:19
 * Description：TODO
 */

public class Main621 {

    public static void main(String[] args) {
        Main621 main621 = new Main621();
        char[] tasks = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        System.out.println(main621.leastInterval(tasks, 2));
    }

    /*public int leastInterval(char[] tasks, int n) {

        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.merge(task, 1, Integer::sum);
        }
        int count = 0;
        List<Integer> values = new ArrayList<>(map.values());
        values.sort((o1, o2) -> o2 - o1);


        while (true) {
            int min = Math.min(values.size(), n + 1);
            int oldSize = values.size();

            for (int i = 0; i < min; i++) {
                values.set(i, values.get(i) - 1);
            }
            values = values.stream()
                    .filter(value -> value > 0)
                    .sorted((o1, o2) -> o2 - o1)
                    .collect(Collectors.toList());
            if (values.size() != 0) {
                count += n + 1;
            } else {
                count += oldSize;
                break;
            }
        }
        return count;
    }*/

    public int leastInterval(char[] tasks, int n) {

        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.merge(task, 1, Integer::sum);
        }
        List<Integer> values = new ArrayList<>(map.values());
        values.sort(Integer::compareTo);
        int lenght = values.size();
        int maxValue = values.get(lenght - 1);
        int count = (maxValue - 1) * (n + 1) + 1;
        for (int i = lenght - 2; i >= 0; i--) {
            if (maxValue == values.get(i)) {
                count++;
            }
        }
        return Math.max(count, tasks.length);

    }

}
