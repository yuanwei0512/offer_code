package com.hyw.offer.leet.code;

import java.util.Set;
import java.util.TreeSet;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/14 16:12
 * Description：TODO
 */
public class Main220 {

    public static void main(String[] args) {
        Main220 main220 = new Main220();
        int[] nums = {0, 2147483647};
        System.out.println(main220.containsNearbyAlmostDuplicate(nums, 1, 2147483647));
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        TreeSet<Long> treeSet = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                treeSet.remove(nums[i - k - 1]);
            }
            Long ceiling = treeSet.ceiling((long) (nums[i] - t));
            Long floor = treeSet.floor((long) (nums[i] + t));
            if ((ceiling != null && ceiling <= nums[i] + t) || (floor != null && floor >= nums[i] - t) ) {
                return true;
            }
            treeSet.add((long) nums[i]);

        }
        return false;
    }

}
