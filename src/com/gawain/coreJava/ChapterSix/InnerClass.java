package com.gawain.coreJava.ChapterSix;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class InnerClass {
    InnerClass() {
        System.out.println("Outer build");
    }

    private class InnerClassTest {
        InnerClassTest() {
            System.out.println("Inner build");
        }

        public void beep() {
            // 内部类既可以访问自身的数据域，
            // 也可以访问创建它的外围类对象的数据域.
            if (InnerClass.this.isBeep) {
                Toolkit.getDefaultToolkit().beep();
            }
        }

    }

    private boolean isBeep = true;

    public void start() {
        new InnerClassTest().beep();
    }

    public static void main(String[] args) {
        new InnerClass().start();
        /**
         * 内部类的创建过程
         * 编译器为内部类添加了一个指向外部类对象对的引用
         * 在内部类的构造函数中 会添加一个指向外部类的对象引用 也就是前面创建的那个
         * 从这里也间接说明了成员内部类是依赖于外部类的，如果没有创建外部类的对象
         * 则无法对外部类引用进行初始化赋值，也就无法创建成员内部类的对象了。
         * 内部类中不能有静态方法
         * 局部类不能用 public 或 private 访问说明符进行声明。
         * 它的作用域被限定在声明这个局部类的块中。
         */
        TimerClock.start(1000, true);
    }
}

class TimerClock {
    public static void start(int interval, final boolean beep) {
        //        ActionListener listener = new TimerPrinter();     这里依旧可以创建？？
        new Timer(interval, new TimerPrinter() {    //匿名内部类 这里使用lambda表达式当然更好
            //匿名内部类中不可以有构造器

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(new Date());

                if (beep) {   //这里可以直接访问方法域 但是变量必须是final
                    //因为在start方法结束时actionPerformed依旧在执行 需要拷贝一份beep
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        }).start();

        double[] ds = new double[10];
        for (int i = 0; i < 10; i++) {
            ds[i] = Math.random() * 100;
        }
        ArrayAlgo.Pair pair = ArrayAlgo.minmax(ds);
        System.out.println("min = " + pair.getFirst());
        System.out.println("max = " + pair.getSecond());
    }
}