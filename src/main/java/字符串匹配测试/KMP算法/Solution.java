package 字符串匹配测试.KMP算法;

public class Solution {

    public static int[] getNext(int[] next, String p) {
        int j = -1;
        next[0] = j;
        for (int i = 1; i < p.length(); i++) {
            while (j > -1 && p.charAt(i) != p.charAt(j + 1)) {
                j = next[j];
            }
            if (p.charAt(i) == p.charAt(j + 1)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static int strKmp(String s, String p) {
        int[] next = new int[p.length()];
        getNext(next, p);
        int j = -1;
        for (int i = 0; i < s.length(); i++) {
            while (j > -1 && s.charAt(i) != p.charAt(j + 1)) {
                j = next[j];
            }
            if (s.charAt(i) == p.charAt(j + 1)) {
                j++;
            }
            if (j == p.length() - 1) {
                System.out.println(i - p.length() + 1);
                break;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "acbdajasdhfuasdfjkhafjggfsgs";
        String needle = "asd";
        strKmp(haystack, needle);

    }

}
