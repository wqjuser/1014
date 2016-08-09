package com.wqj;

import java.math.BigInteger;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int d = s.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = s.nextInt();
        }
        int chazhao = 0;
        BigInteger count = BigInteger.valueOf(0);
        BigInteger er = BigInteger.valueOf(2);
        for (int i = 0; i < num.length; i++) {
            int j = i + 2;
            if (j < num.length) {
                if (num[j] - num[i] <= d) {
                    chazhao = searchRecursive(num, d, j, num[i]);
                    BigInteger middle = BigInteger.valueOf(chazhao - i);
                    BigInteger end = BigInteger.valueOf(chazhao - i - 1);
                    count = count.add(middle.multiply(end).divide(er));
                }
            }
        }

        System.out.println(count);

//       combine(str);
////        System.out.println(l);
////        System.out.println(str);
//        for (int i = 0; i < l.size(); i++) {
//            if (l.get(i).toString().length() == 3) {
//                l1.add(l.get(i));
//            }
//        }
//       System.out.println(l1);
//        for (int i = 0; i < l1.size(); i++) {
//            String[] res = l1.get(i).toString().split("");
//            if (Integer.parseInt(res[2]) - Integer.parseInt(res[0]) <= d) {
//                count++;
//            }
//        }
//
//        System.out.println(count);
//    }
//
//
//    public static void combination(String str, int index, int number,
//                                   StringBuilder sb) {
//        if (number == -1) {
//            l.add(sb.toString());
//            return;
//        }
//
//        if (index == str.length())
//            return;
//        sb.append(str.charAt(index));
//        combination(str, index + 1, number - 1, sb);
//        sb.deleteCharAt(sb.length() - 1);
//        combination(str, index + 1, number, sb);
//
//    }
//
//    public static void combine(String str) {
//        if (str == null)
//            return;
//        int length = str.length();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < length; i++) {
//            combination(str, 0, i, sb);
//        }
//    }
    }

    public static int searchRecursive(int[] array, int d, int start,
                                      int jianshu) {
        int begin = start;// 起始位置
        int end = array.length - 1;// 结束位置

        if (array == null) {
            return -1;
        }
        while (begin <= end) {
            int middle = (begin + end) / 2;
            int middleValue = array[middle];
            if (middle + 1 < array.length && middleValue - jianshu <= d && array[middle + 1] - jianshu <= d) {
                begin = middle + 1;
            } else if (middle + 1 < array.length && middleValue - jianshu > d && array[middle + 1] - jianshu > d) {
                end = middle - 1;
            } else if (middle + 1 < array.length && middleValue - jianshu <= d && array[middle + 1] - jianshu > d) {
                return middle;
            } else {
                break;
            }

        }
        return array.length - 1;
    }

//    public static int search(int[] nums, int num, int cu
//            , int diyi) {
//
//        int low = cu;
//        int high = nums.length - 1;
//
//        while (low <= high) {
//            int mid = (low + high) / 2;
//            if (mid + 1 < nums.length && nums[mid] - diyi <= num && nums[mid + 1] - diyi <= num) {
//                low = mid + 1;
//            } else if (mid + 1 < nums.length && nums[mid] - diyi > num && nums[mid + 1] - diyi > num) {
//                high = mid - 1;
//            } else if (mid + 1 < nums.length && nums[mid] - diyi <= num && nums[mid + 1] - diyi > num) {
//                return mid;
//            } else {
//                break;
//            }
//        }
//
//        return nums.length - 1;
//    }
}
