package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/11 15:12
 * Description：TODO
 */
public class Main209 {

    public static void main(String[] args) {
        Main209 main209 = new Main209();
        int[] nums = {1,2,3,4,5};
        System.out.println(main209.minimunSize(nums, 15));
    }


    public int minimunSize(int[] nums, int s) {
        int l = 0;
        int r = -1;
        int temp = 0;
        int resultSize = nums.length + 1;
        while (l < nums.length ) {
            if (temp < s && r+1 < nums.length) {
                temp += nums[++r];
                    r++;
            } else  {
                temp -= nums[l++];

            }
            if (temp >= s) {

                resultSize = Math.min(resultSize, r - l + 1);

            }


        }

        return resultSize;
    }

    /**
     *
     * @return 自己方式实现
     */
    public int minimunSize2(int[] nums, int s) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int resultSize = nums.length;
        int n = nums.length;
        int i = 0;
        int j = i + 1;
        while (i < j && i < n && j < n) {
            int temp = 0;
            for (int k = i; k <= j; k++) {
                temp += nums[k];
                if (temp >= s) {
                    break;
                }
            }
            if (temp >= s) {
                System.out.println(i + "  " + j + "  " + temp);
                resultSize = Math.min(resultSize, j - i + 1);
                i++;
                j = i + 1;
            } else {
                j++;
            }

        }
        return resultSize;
    }

}
