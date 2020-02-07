package com.hyw.offer.sort;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/17 9:39
 * Description：TODO
 */
public class MyTest {



    private static void ShellInsertSort(int[] a, int dk) {
        for (int i = dk; i< a.length; i++) {
            if (a[i] < a[i - dk]) {
                int j;
                int x = a[i];
                a[i] = a[i - dk];
                for (j = i - dk; j > 0 && a[j] > x; j = j - dk) {
                    a[j + dk] = a[j];
                }
                a[j] = x;

            }
        }

    }

    public static int[] quickSort(int[] arr, int low, int hight) {
        int start = low;
        int end = hight;
        int key = arr[low];

        while (start < end) {

            while (end >start && arr[end] > key) {
                end--;
            }
            if (arr[end] <= key) {
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }

            while (end > start && arr[start] < key) {
                start++;
            }
            if (arr[start] >= key) {
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }

        }
        return arr;
    }


    public static int binarySearch(int[] array, int a) {
        int low = 0;
        int hight = array.length - 1;
        while (low < hight) {
            int mid = (hight - low) + low;
            if (array[a] == array[mid]) {
                return array[mid];
            }
            if (array[a] > array[mid]) {
                low = mid + 1;
            }
            if (array[a] < array[mid]) {
                hight = mid - 1;
            }
        }
        return -1;
    }

    public static int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int index = i - 1;

            while (index >= 0 && insertValue < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index] = insertValue;
        }
        return arr;
    }

}
