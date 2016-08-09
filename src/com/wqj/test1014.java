package com.wqj;

import java.util.Scanner;

/**
 * Created by MR.WEN on 2016/8/3.
 */
public class test1014 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        combine(str);
    }

    public static void combination(String str, int index, int number,
                                   StringBuilder sb) {
        if (number == -1) {
            System.out.println(sb.toString());
            return;
        }
        if (index == str.length())
            return;
        sb.append(str.charAt(index));
        combination(str, index + 1, number - 1, sb);
        sb.deleteCharAt(sb.length() - 1);
        combination(str, index + 1, number, sb);

    }

    public static void combine(String str) {
        if (str == null)
            return;
        int length = str.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            combination(str, 0, i, sb);
        }
    }


}