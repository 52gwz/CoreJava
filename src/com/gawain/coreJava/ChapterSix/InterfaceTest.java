package com.gawain.coreJava.ChapterSix;

import com.gawain.coreJava.ChapterFour.Cat;
import com.gawain.coreJava.ChapterFour.LeopardCat;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class InterfaceTest {
    public static void main(String[] args) throws Exception {
        Cat[] cats = new Cat[5];
        //foreach不能用作数组赋值
        for (int i = cats.length - 1; i >= 0; i--) {
            cats[i] = new Cat(i + "");
        }
        Arrays.sort(cats);
        for (Cat cat : cats) {
            System.out.println(cat);
        }
        LeopardCat lc = new LeopardCat("豹猫",2);
        System.out.println(lc.compareTo(cats[0]));
        System.out.println(cats[0].compareTo(lc));
        //接口中的域会自动被声明为public static final
        Cat aCat = (Cat)cats[0].clone();
        /**
         * default关键字可以为接口提供默认的方法实现
         * 这个方法同样可以调用接口中其他方法的实现:
         *
         * public interface Collection {
         * int size(); // 一个抽象方法
         *      default boolean isEmpty(){
         *          return size() == 0; //调用这个抽象方法
         *      }
         * }
         * 这样实现 Collection 的程序员就不用操心实现 isEmpty 方法了。
         */
        //MouseAdapter是MouseListener的空实现(伴随类)
        /**
         * 警告: 千万不要让一个默认方法重新定义 Object 类中的某个方法。
         * 例如，不能为 toString 或 equals 定义默认方法。
         * 由于“类优先”规则，这样的方法绝对无法超越 Object.toString 或 Objects.equals。
         */


    }

}
