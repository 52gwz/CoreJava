package com.gawain.coreJava.ChapterFour;

import java.text.NumberFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class ClassAndObject {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        int day = date.getDayOfMonth();
        int month = date.getMonthValue();
        DayOfWeek weekday = date.getDayOfWeek();    //这个月第一天的星期
        int value = weekday.getValue();
        date = date.minusDays(day - 1);

        System.out.println("Mon\tTue\tWed\tThu\tFri\tSat\tSun");
        for (int i = 1; i < value; i++) {
            System.out.print("\t");
        }
        while (date.getMonthValue() == month) {
            if (date.getDayOfMonth() != day) {
                System.out.print(date.getDayOfMonth() + "\t");
            } else {
                System.out.print(date.getDayOfMonth() + "*\t");
            }

            date = date.plusDays(1);
            if (date.getDayOfWeek() == DayOfWeek.SATURDAY) {
                //星期天换行
                System.out.print("\n");
            }
        }
        System.out.println();
        //方法可以访问所属类的所有对象的私有数据
        Cat chineseCat = new Cat("中华田园猫");
        Cat americanCat = new Cat("美短");
        System.out.println(chineseCat.equals(americanCat));
        /**
         * 什么时候使用static方法
         * 方法不需要访问对象状态，其所需参数都是通过显式参数提供(例如: Math.pow)
         * 一个方法只需要访问类的静态域(例如: Employee.getNextId)
         */
        //静态工厂
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        System.out.println(currencyFormatter.format(10));
        //方法同样可以重载
        //描述构造器的参数类型的叫做签名(signature)
        //重点是 返回值不同和重载没得关系
        Cat[] cats = new Cat[5];
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat();
            System.out.println(cats[i].getId());
            //之前已经创建了两个小猫哟 id = 2
        }
        /**
         * 例如，java.util和java.sql包都有日期(Date) 类。如果在程序中导入了这两个包:
         * import java.util.*;
         * import java.sql.*;
         * 在程序使用 Date 类的时候， 就会出现一个编译错误:
         * Date today; // Error java.util .Date or java.sql .Date?
         * 此时编译器无法确定程序使用的是哪一个 Date 类。
         * 可以采用增加一个特定的 import 语句来 解决这个问题:
         * import java.util.Date;
         * 如果两个类都要使用 只能在类声明前加入包名
         */
        //使用静态导入可以忽略类名 import static
        //优先使用不可变的类
        /**
         * 更改对象的问题在于，如果多个线程试图同时更新一个对象，就会发生并发更改。
         * 其结果是不可预料的。
         * 如果类是不可变的，就可以安全地在多个线程间共享其对象。
         */
    }
}

