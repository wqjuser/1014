package com.wqj;

/**
 * Created by MR.WEN on 2016/8/5.
 */


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//测试正确的例子
public class test1014_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int shuzunum = scanner.nextInt();
        int b = scanner.nextInt();

        int[] nums = new int[shuzunum];
        for (int i = 0; i < shuzunum; i++) {
            nums[i] = scanner.nextInt();
        }
        int find = 0;
        int chushi = 0;
        BigInteger result = BigInteger.valueOf(0);
        BigInteger er = BigInteger.valueOf(2);

        for (int i = 0; i < nums.length; i++) {

            int j = i + 2;
            if (j < nums.length) {
                if (nums[j] - nums[i] <= b) {
                    find = test1014_2.search(nums, b, j, nums[i]);
                    BigInteger zhong = BigInteger.valueOf(find - i);
                    BigInteger hou = BigInteger.valueOf(find - i - 1);
                    result = result.add(zhong.multiply(hou).divide(er));
                }


            }

        }
        System.out.println(result);
    }

    public static int search(int[] nums, int num, int cu            //strart
                             , int diyi) {

        int low = cu;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid + 1 < nums.length && nums[mid] - diyi <= num && nums[mid + 1] - diyi <= num) {
                low = mid + 1;
            } else if (mid + 1 < nums.length && nums[mid] - diyi > num && nums[mid + 1] - diyi > num) {
                high = mid - 1;
            } else if (mid + 1 < nums.length && nums[mid] - diyi <= num && nums[mid + 1] - diyi > num) {
                return mid;
            } else {
                break;
            }
        }

        return nums.length - 1;
    }



}
