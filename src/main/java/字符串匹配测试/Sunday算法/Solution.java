package 字符串匹配测试.Sunday算法;

import java.util.Arrays;

public class Solution {

    public static int[] getOCC(String p) {
        int[] occ = new int[128];
        Arrays.fill(occ, -1);
        for (int i = 0; i < p.length(); i++) {
            occ[p.charAt(i)] = i;
        }
        return occ;
    }

    public static int strSunday(String s, String p) {
        int[] occ = getOCC(p);
        int n = s.length();
        int m = p.length();
        int jump = 0;
        for (int i = 0; i <= n - m; i += jump) {
            int j = 0;
            while (j < m && s.charAt(i + j) == p.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i;
            }
            jump = i + m < n ? m - occ[s.charAt(i + m)] : 1;
        }
        return -1;
    }


    public static void main(String[] args) {
        String haystack = "acbdajasdhfuasdfjkhafjggfsgs";
        String needle = "asd";
        System.out.println(strSunday(haystack, needle));

    }


}
