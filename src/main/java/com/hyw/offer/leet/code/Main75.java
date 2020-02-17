package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/10 14:53
 * Description：TODO
 */
public class Main75 {


    public static void main(String[] args) {
        int[] nums ={1,2,0,1,2,1,0};
        Main75 main75 = new Main75();
        main75.sortColors(nums);
        System.out.println(nums);
    }


    public void sortColors(int[] nums) {
        // [0....zeor]存放0
        int zero = -1;
        // [tow....last]存放2
        int two = nums.length;
        int temp = 0;
        for (int i = 0; i < two; ) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 0) {
                zero++;
                temp = nums[i];
                nums[i] = nums[zero];
                nums[zero] = temp;
                i++;
            } else {
                assert nums[i] == 2;
                two--;
                temp = nums[two];
                nums[two] = nums[i];
                nums[i] = temp;
            }
        }
    }


}
