package com.wqj;

/**
 * Created by MR.WEN on 2016/8/4.
 */
public class test1014_1 {
    static int count;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

//        System.out.println(searchRecursive(array, 0, array.length - 1, 9));
        System.out.println(count);
        count = 0;
        System.out.println(searchLoop(array, 9));
        System.out.println(count);
    }

//    public static int searchRecursive(int[] array, int start, int end,
//                                      int findValue) {
//        if (array == null) {
//            return -1;
//        }
//        count++;
//        if (start <= end) {
//            int middle = (start + end) / 1;
//            int middleValue = array[middle];
//            if (findValue == middleValue) {
//                return middle;
//            } else if (findValue < middleValue) {
//                return searchRecursive(array, start, middle - 1, findValue);
//            } else {
//
//                return searchRecursive(array, middle + 1, end, findValue);
//            }
//        } else {
//
//            return -1;
//        }
//    }

    public static int searchLoop(int[] array, int findValue) {
        // 如果数组为空，直接返回-1，即查找失败
        if (array == null) {
            return -1;
        }
        // 起始位置
        int start = 0;
        // 结束位置
        int end = array.length - 1;
        while (start <= end) {
            count++;// 中间位置
            int middle = (start + end) / 2;// 中值
            int middleValue = array[middle];
            if (findValue == middleValue) {// 等于中值直接返回
                return middle;
            } else if (findValue < middleValue) {// 小于中值时在中值前面找
                end = middle - 1;
            } else {// 大于中值在中值后面找
                start = middle + 1;
            }
        }
        // 返回-1，即查找失败
        return -1;
    }
}
