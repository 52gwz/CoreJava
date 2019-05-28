package com.gawain.coreJava.ChapterThree;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Date;

public class BasicJava {
    private static Date deadLine = new Date();
    public static strictfp void main(String[] args) {
        String 我打你妈的 = "真白给啊";
        System.out.println(我打你妈的);
        //final变量不可修改且常用大写 不同于C/C++ const仅做保留字
        final char C;
        C = '$';
        //此方法检查字符是否可做变量名开头
        System.out.println(Character.isJavaIdentifierStart(C));
        System.out.println(2.0 - 1.1);
        System.out.println(-7 % 5);
        Scanner in = null;
        //启动路径
        System.out.println(System.getProperty("user.dir"));
        try {
            Path p = Paths.get("src/myFile.txt");
            in = new Scanner(p, "UTF-8");
        } catch (IOException e) {
            System.out.println(e);
        }

        System.out.println(in.nextLine());
        if (1 != 1) System.out.println("233");
        else System.out.println("555");
        /**
         * break标签用于跳出多层循环
         * 在if或者块中同样可以使用
         */
        break_up:
        while (true) {
            System.out.println("outer loop");
            while (true) {
                System.out.println("inner loop");
                if (true) {
                    break break_up;
                }
            }
        }
        int[] nums = {2, 3, 5, 3};
        for (int num :
                nums) {
            System.out.println(num);
        }
        //Arrays类用于方便操作数组
        //Arrays.copyOf 复制数组到另外一个数组中
        //Arrays.sort 排序 快排算法
        System.out.println(Arrays.toString(nums));
        //二维数组可以用Arrays.deepToString()
        //命令行执行参数 在configurations中的 Program arguments 修改
        if (args[1].equals("say")) {
            if (!args[2].equals("")) {
                System.out.println(args[2]);
            }
        }
        int[] num1 = {2, 3, 3};
        int[] num2 = num1;
        num2[0] = 233;
        System.out.println(num1[0]);
        //不规则数组：
        int[][] numbers = new int[5][];
//        int[] numbers2 = new int[5];
        for (int i = 0; i < numbers.length; i+=2) {
            numbers[i] = new int[i + 1];
        }
        System.out.println(new Date());
        Date birthday;
        System.out.println(deadLine);
        //局部变量不会初始化为null
        //System.out.println(birthday);
        Date date1 = (Date)deadLine.clone();
        System.out.println(date1.equals(deadLine));
        System.out.println(LocalDate.now());
        LocalDate sbZhang = LocalDate.now();
        System.out.println(sbZhang.getDayOfWeek());
        /**
         * 什么时候使用static方法
         * 方法不需要访问对象状态，其所需参数都是通过显式参数提供(例如: Math.pow)
         * 一个方法只需要访问类的静态域(例如: Employee.getNextId)
         */
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        System.out.println(currencyFormatter.format(10));
    }
}
