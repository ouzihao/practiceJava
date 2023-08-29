package 字符串匹配测试;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class testkmp {

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

    public static int strStrKmp(String haystack, String needle, List<Integer> res) {
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
        String s = "ababa";
        String p = "aba";
        List<Integer> res = new ArrayList<>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        strStrKmp(s,p,res);
        //System.out.println(res.toString());
        for (int num : res) {
            //System.out.println(num);
            bw.write(num + " ");
        }
        bw.flush();


    }
}
