package script;


import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

class YangHuiTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入要打印的行数：");
        int n = input.nextInt();
        printYangHuiTriangle(n);
    }

    public static void printYangHuiTriangle(int n) {
        int[][] triangle = new int[n][n];
        for (int i = 0; i < n; i++) {
            triangle[i][0] = 1;
            triangle[i][i] = 1;
            for (int j = 1; j < i; j++) {
                triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class StringPrint {
    public static void main(String[] args) {
        String [] cmowers = {"沉默","王二","一枚有趣的程序员"};

//        Arrays.stream(cmowers).forEach(System.out::println);
//        Arrays.asList(cmowers).stream().forEach(e -> System.out.println(e));
//        Stream.of(cmowers).forEach(System.out::println);

        List<String> stringList = Arrays.asList(cmowers);
        System.out.println(stringList.toString());
        System.out.println(Arrays.asList(cmowers));

        String[][] deepArray = new String[][] {{"沉默", "王二"}, {"一枚有趣的程序员"}};
        System.out.println(Arrays.deepToString(deepArray));



    }
}