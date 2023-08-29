package 基础api;

import sun.nio.ch.sctp.SctpNet;

import java.util.Scanner;

public class TestAPI {

    public static void main(String[] args) {

        System.out.println(Math.round(3.0));


        Scanner sc = new Scanner(System.in);
        System.out.println("请输入a: ");
        int a = sc.nextInt();
        System.out.println("请输入b: ");
        int b = sc.nextInt();
        System.out.println("请输入c: ");
        int c = sc.nextInt();
        double dt = Math.pow(b, 2) - 4*a*c;
        if (dt < 0) System.out.println("此方程无解");
        else if (dt == 0) {
            double res = (-b) / (2*a);
            System.out.println("此方程只有一个解: " + res);
        } else {
            System.out.println("此方程");
            double x1 = ((-b) + dt) / 2*a;
            double x2 = ((-b) - dt) / 2*a;
            System.out.println("解1: " + x1);
            System.out.println("解2: " + x2);
        }

    }


}
