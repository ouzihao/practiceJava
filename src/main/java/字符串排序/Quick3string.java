package 字符串排序;

import java.util.Arrays;

public class Quick3string {

    private static int charAt(String s, int d) {
        if (d < s.length()) {
            return s.charAt(d);
        }
        return -1;
    }

    public static void sort(String[] a) {
        sort(a, 0, a.length - 1, 0);
    }

    public static void sort(String[] a, int low, int high, int d) {
        if (high <= low) {
            return;
        }
        int lt = low;
        int gt = high;
        int i = low + 1;
        int v = charAt(a[low], d);
        while (i <= gt) {
            int t = charAt(a[i], d);
            if (v > t) {
                exchange(a, lt++, i++);
            } else if (v < t) {
                exchange(a, gt--, i);
            } else {
                i++;
            }
        }

        sort(a, low, lt - 1, d);
        if (v >= 0) sort(a, lt, gt, d + 1);
        sort(a, gt + 1, high, d);
    }

    private static void exchange(String[] a, int i, int j) {
        String t = new String(a[i]);
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        String[] a = {"she", "sells", "seashells", "by", "the", "sea", "shore", "the",
                "shells", "she", "sells", "are", "surely", "seashells"};
        Quick3string.sort(a);
        System.out.println(Arrays.toString(a));
    }


}
