package com.gawain.coreJava.ChapterFive;

import com.gawain.coreJava.ChapterFour.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Objects;


public class Inheritance {
    public static void main(String[] args) {
        Cat[] cats2 = new Cat[3];
        for (int i = 0; i < cats2.length; i++) {
            if (i % 2 == 0) {
                //一个对象变量 可以指向多种类型叫做多态(polymorphism)
                cats2[i] = new LeopardCat("Peace and Love", 18);
            } else {
                cats2[i] = new Cat();
            }
        }
        //在运行时能够自动选择调用哪个方法的现象叫做动态绑定(dynamic biding)
        for (Cat cat : cats2) {
            System.out.println(cat.getId());
        }
        //允许类型转换(int 可以转换成 double, Manager 可以转换成 Employee, 等等)
        cats2[0].testDouble(233);
        LeopardCat[] lpCats = new LeopardCat[cats2.length];
        //在覆盖一个方法的时候，子类方法不能低于超类方法的可见性。
        /**
         *  public 对所有包类都可见
         *  private仅对本类可见
         *  protect仅对子类和同包可见
         *  default仅对本包可见
         */
        //在比较或使用对象时 一定要注意对象有没有可能为null
        //某些情况下比较两个字符串对象可以使用Objects.equals()
        System.out.println(lpCats.getClass());
        /***
         * Java Equals 规范:
         * 1 ) 自反性: 对于任何非空引用 x, x.equals(x) 应该返回 true。
         * 2 ) 对称性: 对于任何引用 x 和 y, 当且仅当 y.equals(x) 返回 true, x.equals(y) 也应该返 回 true。
         * 3 ) 传递性: 对于任何引用 x、 y 和 z, 如果 x.equals(y) 返 N true， y.equals(z) 返回 true, x.equals(z) 也应该返回 true。
         * 4 ) 一致性: 如果 x 和 y 引用的对象没有发生变化， 反复调用 x.equals(y) 应该返回同样 的结果。
         * 5 ) 对于任意非空引用 x, x.equals(null) 应该返回 false,
         */
        System.out.println(new Cat().getClass() == new LeopardCat("GWZ", 18).getClass());
        //equals方法显式参数必须是Object 请记得使用@Override!
        //两个数组中的对象比较可以用Arrays.equals()
        System.out.println(cats2.hashCode());
        String str1 = "abc";
        String str2 = "abc";
        System.out.println(str1 == str2);
        // true，因为s1和s2是同一个字符串常量abc的引用，是同一个对象地址，所以相同
        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(s1 == s2);
        // false，因为s1和s2是两个不同的对象，虽然字符串值都是abc，但是用==比较不相同。

        /**
         * HashCode()
         */
        String s = "Ok";
        StringBuilder sb = new StringBuilder(s);
        System.out.println(s.hashCode() + " " + sb.hashCode());
        String t = new String("Ok");
        StringBuilder tb = new StringBuilder(t);
        System.out.println(t.hashCode() + " " + tb.hashCode());
        //不同 因为StringBuilder中没有声明hashCode()方法 调用了Object的hashCode()
        /**
         * Equals 与 hashCode 的定义必须一致: 如果 x.equals(y) 返回 true
         * 那么x.hashCode() 就必 须与 y.hashCode() 具有相同的值。
         * 例如，如果用定义的 Employee.equals 比较雇员的ID
         * 那么hashCode方法就需要散列ID，而不是雇员的姓名或存储地址。
         *
         * 和Equals一样 两个数组域中的hashCode 可以使用Arrays.hashCode()生成
         */
        /**
         * 需要对String频繁操作时 请使用StringBuilder
         * @see <a href="https://blog.csdn.net/qq_33417486/article/details/82787598">更多关于String的问题</a>
         * String StringBuffer StringBuilder的特点:
         * 1.String 长度大小不可变
         * 2.StringBuffer 和 StringBuilder 长度可变
         * 3.StringBuffer 线程安全 StringBuilder 线程不安全
         * 4.StringBuilder 速度快
         */
        System.out.println(System.out);
        //没有覆盖toString的方法打印所属类名和16进制hashcode
        //TODO:尝试拿雇员和经理例子实现Equals和HashCode并确保他们的特性还在

        ArrayList<String> strAry = new ArrayList<>(100);
        strAry.add("数组中唯一元素");
        //当确定ArrayList大小不会变化时 可以使用trimToSize
        strAry.trimToSize();
        System.out.println(strAry.size());
        ArrayList<String> arrayList = new ArrayList<>();
        EmployeeDB employeeDB = new EmployeeDB();
        employeeDB.update(arrayList);
        employeeDB.find("233");
        /**
         * list.add(3);
         * 将自动地变换成
         * list.add(Integer.value0f(3));
         * 这个过程叫做自动装箱或者说打包(autoboxing/autowrapping)
         * 相反地，当将一个 Integer 对象赋给一个 int 值时，将会自动地拆箱。
         * 也就是说，编译器将下列语句:
         * int n = list.get(i);
         * 翻译成
         * int n = list.get(i).intValue();
         * 同样，算数表达式n++同样会进行自动拆装箱
         * 编译器在生成类的字节码时，插入必要的方法调用 虚拟机负责执行
         */
        /**
         * 两个Integer在-128~127之间进行比较时相等
         * 这是因为这个范围是Integer.valueOf是否要缓存的区间
         * 下次再声明对象就会直接在缓存中取了
         */

        Integer a = Integer.valueOf(-128);  //和下面的语句等价
        Integer b = -128;
        System.out.println(a == b);
        //IntHolder类型在传参的时候可以修改本体值
        //Q:为什么main所属的类不能创建内部类
        //A:内部类实例首先要实例化外部类
        Test tff = new Test();
        System.out.printf("%d %s", 23, "hello");
        //等价
        System.out.printf("%d %s", new Object[]{new Integer(23), "hello"});
        System.out.println(max(23.3, 1, 2.2, 0));
        Size eS = Enum.valueOf(Size.class,"SMALL");
        //返回包含全部索引的数组
        Size[] sizes = Size.values();
        for (Size size : sizes) {
            System.out.println(size);
        }
        //返回在索引的位置
        System.out.println(Size.SMALL.ordinal());
        /**
         * Java程序在运行时一直对所有对象进行所谓的运行时类型标识。
         * 记录了每个对象的所属类，用来保存这些信息的类就是Class类
         */
        Class cl = sizes.getClass();
        //如果类在一个包里， 包的名字也作为类名的一部分:
        Class catCl = null;
        System.out.println(cl.getName());
        try{
            catCl = Class.forName("com.gawain.coreJava.ChapterFour.Cat");
        }catch (ClassNotFoundException e){
            System.out.println(e);
        }
        Class cl1 = int[].class;
        System.out.println(cl1);
        Object obj = null;
        try{
            obj = catCl.newInstance();
        }catch (InstantiationException e){
            System.out.println(e);
        }catch (IllegalAccessException e){
            System.out.println(e);
        }
    }

    static class Test {
    }
    //可以将任何参数为数组的方法改为...
    public static double max(double... value){
        double largest = Double.NEGATIVE_INFINITY;
        for (double v : value) {
            if(v > largest){
                largest = v;
            }
        }
        return largest;
    }
}


//抽象类特点：
//1.只要有一个抽象方法 类就必须声明为抽象类
//2.抽象类不可以实例化 但是可以创建对象变量
//例如:Person = new Student();
abstract class Person {
    private String name;


    abstract void getDescription();

    //抽象类中可以有具体实现的方法 但是大部分认为这样不妥 尽量放在子类中
    public String getName() {
        return name;
    }


}

class EmployeeDB {
    private ArrayList list;

    EmployeeDB() {
        list = new ArrayList();
    }

    public void update(ArrayList list) {
        this.list = list;
    }

    public ArrayList find(String query) {
        if (list != null) {
            list.add(query);
        } else {
            return null;
        }
        return list;
    }
}