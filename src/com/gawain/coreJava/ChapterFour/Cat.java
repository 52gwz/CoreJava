package com.gawain.coreJava.ChapterFour;

public class Cat implements Comparable<Cat>,Cloneable {
    private String name;
    private static int nextId;      //静态类和子类共享
    private int id = signId();      //初始值不一定是常量值。


    public Cat(String name) {
        this.name = name;
    }

    public Cat() {
        //多个参数不同的构造器称为重载(Overloading)
        //创建对象时 编译器会找出合适的构造器 这个过程称为重载解析(Overloading Resolution)
        this("不知名的小猫");
    }


    private static int signId() {
        int id = nextId;

        nextId++;
        return id;
    }

    //超类中的private方法不可以被子类访问 同样不能被继承
    protected void testPermission() {
        System.out.println("testPermission");
    }

    public int getId() {
        return this.id;
    }

    public String getName(){return name;}

    public void testDouble(double db) {
        System.out.println(db);
    }


    @Override
    public boolean equals(Object obj) {      //Another
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            System.out.println("等于自己");
            return true;
        }
        if (this.getClass() != obj.getClass()) {
            System.out.println("不同类型");
            return false;
        }
        Cat other = (Cat) obj;
        return other.name.equals(name) && this.id == other.id;
    }

    @Override
    public final int compareTo(Cat o) {
        /**
         * 如果存在这样一种通用算法 它能够对两个不同的子类对象进行比较
         * 则应该在超 类中提供一个 compareTo 方法
         * 并将这个方法声明为final
         */
        return Integer.compare(name.length(), o.name.length());
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "猫名：" + name + " id：" + id;
    }
}

