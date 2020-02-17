package com.hyw.offer.leet.code;

import java.util.HashSet;
import java.util.Set;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/14 15:55
 * Description：TODO
 */
public class Main219 {

    public static void main(String[] args) {
        int[] nums ={1,2,3,1};
        Main219 main219 = new Main219();
        System.out.println(main219.containsNearbyDuplicate(nums, 3));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        Set<Integer> containSet = new HashSet<>(k);
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                containSet.remove(nums[i - k - 1]);
            }
            if (containSet.contains(nums[i])) {
                return true;
            }
            containSet.add(nums[i]);
        }


        return false;
    }
    
}
