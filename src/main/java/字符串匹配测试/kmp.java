package 字符串匹配测试;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class kmp {

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

    public static int strStrKmp(String haystack, String needle, List<Integer> res) throws IOException {
        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = -1;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > -1 && haystack.charAt(i) != needle.charAt(j + 1)) {
                j = next[j];
            }
            if (haystack.charAt(i) == needle.charAt(j + 1)) {
                j++;
            }
            if (j == needle.length() - 1) {
                //bw.write(i - needle.length() + 1 + " ");
                res.add(i - needle.length() + 1);
                j = next[j];
            }
        }
        return -1;
    }


    public static void main(String[] args) throws IOException {
        int N = 100010;
        int M = 1000010;
        int[] ne = new int[N];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer n = Integer.parseInt(br.readLine());
        String sp = br.readLine();
        Integer m = Integer.parseInt(br.readLine());
        String ss = br.readLine();
//        char[] p = sp.toCharArray();
//        char[] s = ss.toCharArray();
        List<Integer> res = new ArrayList<>();
        //bw.write(12 + " ");
        strStrKmp(ss, sp, res);
        for (int num : res) {
            bw.write(num + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
