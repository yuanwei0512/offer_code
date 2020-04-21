package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author yuanwei
 * DateTime：2020/4/20 17:31
 * Description：TODO
 */
public class Main165 {

    public static void main(String[] args) {
        Main165 main165 = new Main165();
        System.out.println(main165.compareVersion("1.0", "1"));
    }

    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int n = Math.min(split1.length, split2.length);
        int i = 0;
        for (; i < n; i++) {
            Integer value1 = Integer.valueOf(split1[i]);
            Integer value2 = Integer.valueOf(split2[i]);
            if (value1 > value2) {
                return 1;
            } else if (value1 < value2) {
                return -1;
            }
        }
        if (split1.length - split2.length > 0) {
            for (; i < split1.length; i++) {
                if (Integer.valueOf(split1[i]) != 0) {
                    return 1;
                }
            }
        } else if (split1.length - split2.length < 0) {
            for (; i < split2.length; i++) {
                if (Integer.valueOf(split2[i]) != 0) {
                    return -1;
                }
            }
        }
        return 0;
    }




}
