package com.gawain.coreJava.ChapterSix;

import com.gawain.coreJava.ChapterFour.Cat;

import javax.swing.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class Lambda {
    public static void main(String[] args) {
        String[] strs = {"1", "233", "42", ""};
        // <?extends T> 下界通配符
        // <? super T> 上界通配符

        Arrays.sort(strs, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(strs));
        //timer是swing包中的不是util
        Timer timer = new Timer(1000, event ->
                System.out.println("当前时间:" + new Date())
        );
        timer.start();
        // java.util.function 包中有一个尤其有用的接口 Predicate:
        /**
         * ArrayList 类有一个 removeIf 方法，它的参数就是一个 Predicate。
         * 这个接口专门用来传递 lambda 表达式。
         * 例如，下面的语句将从一个数组列表删除所有 null 值:
         * list.removeIf(e -> e == null);
         */

        // ::方法引用
        //Timer t = new Timer(1000, System.out::println);
        //等价于event -> System.out.println(event)
        //t.start();

        //这是下面的第3种情况 String 成为方法的目标
        Arrays.sort(strs, String::compareToIgnoreCase);
        //(x, y) -> x.compareToIgnoreCase(y)
        /**
         * 从这些例子可以看出，要用::操作符分隔方法名与对象或类名。
         * 主要有 3 种情况:
         * •object::instanceMethod
         * •Class ::static Method
         * •Class ::instanceMethod
         */
        lambdaTest("HelloWorld");
        repeat(10, i -> System.out.println("Countdown:" + (9 - i)));
        /**
         * Comparator 接口包含很多方便的静态方法来创建比较器:
         * Comparator.comparing(键函数)
         * comparingInt可以减少自动装箱
         */
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("这个名字够不够长");
        cats[1] = new Cat("我觉得ok");
        cats[2] = new Cat("秀啊弟弟，按笔画三大基地时间");
        Arrays.sort(cats,Comparator.reverseOrder()
        );
        System.out.println(Arrays.toString(cats));
        //naturalOrder是返回自然排序的比较器也就是在类中实现的Comparable

    }

    /**
     * lambda中可以调用方法外围的变量
     * 但是不能对这个变量做改动 即使是外部也不行
     * 在 lambda 表达式中声明与一个局部变量同名的参数或局部变量是不合法的。
     * 通常lambda会在单独的线程中执行
     * Runnable可以实现无参数或无返回值的动作运行
     */

    public static void lambdaTest(String text) {
        Timer t = new Timer(1000, (event) -> {
            //text = text + "!"; Error！
            System.out.println(text);

        });
        t.start();
    }

    //创建一个能接收lambda的方法
    public static void repeat(int n, IntConsumer action) {
        for (int i = 0; i < n; i++) {
            action.accept(i);
        }
    }
}
