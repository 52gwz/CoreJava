package com.gawain.coreJava.ChapterSix;

import com.gawain.coreJava.ChapterFour.Cat;
import com.gawain.coreJava.ChapterFour.LeopardCat;

import java.util.Arrays;
import java.util.Comparator;

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
        //另一种实现sort比较的方法 就是创建一个比较器
        Cat[] cats1 = new Cat[3];
        cats1[0] = new LeopardCat("小老徐",233);
        cats1[1] = new Cat();
        cats1[2] = new Cat("大哥安柏华");
        Arrays.sort(cats1,new LengthComparator());  //这里用lambda应该更好
        for (Cat cat : cats1) {
            System.out.println(cat);
        }
        // 总结 可以使用两种方法实现Arrays的sort
        // 一种是在类里实现Comparable
        // 另一种就是在sort中填入一个比较器(comparator)
        /**
         * clone是Object对象的一个protect方法
         * 这个方法如果作用在自己写的类中
         * 如果你的类中调用了其他对象 这个对象并不会被拷贝（浅度拷贝）
         * 如果你的子对象是不可变或者没有改动 那么不影响
         * 1 ) 默认的 clone 方法是否满足要求;
         * 2 ) 是否可以在可变的子对象上调用 clone 来修补默认的 clone 方法;
         * 3 ) 应不应该使用 clone()
         * 实际上第 3 个选项是默认选项。如果选择第1项或第2项，类必须:
         * 1 ) 实现 Cloneable 接口;
         * 2 ) 重新定义 clone 方法， 并指定 public 访问修饰符。
         */
        cats[0].clone();    //这里本应抛异常 但是在main中被throw掉了
        // 想要clone就必须实现cloneable接口
        /**
         * 所有数组类型都有一个 public 的 clone 方法，而不是 protected
         * 可以用这个方法 建立一个新数组，包含原数组所有元素的副本。
         */

    }

}

class LengthComparator implements Comparator<Cat>,Cloneable{
    @Override
    public int compare(Cat o1, Cat o2) {
        return o1.getName().length() - o2.getName().length();
    }
}