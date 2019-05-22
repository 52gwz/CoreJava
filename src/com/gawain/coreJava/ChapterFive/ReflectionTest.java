package com.gawain.coreJava.ChapterFive;

import java.lang.reflect.*;
import java.util.Scanner;

public class ReflectionTest {

    public static void main(String[] args) {
        String name;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Class Name (e.g. java.util.Date):");
        name = in.next();
        try {
            Class cl = Class.forName(name);        //根据包名找到类
            Class superClass = cl.getSuperclass(); //根据类找到超类(父类)
            String modifiers = Modifier.toString(cl.getModifiers());    //返回修饰符
            if (modifiers.length() > 0) System.out.print(modifiers + " ");   //打印类的修饰符
            System.out.print("class " + name);    //打印类名or包名
            //打印父类信息
            if (superClass != null && superClass != Object.class) {
                //父类不为空且不是Object类
                System.out.print(" extends " + superClass.getName());
            }
            System.out.print("\n{\n");
            printConstructors(cl);
            printMethods(cl);
            printFields(cl);
            System.out.println("}");
        } catch (ClassNotFoundException e) {
            System.out.println("Cannot Find Class");
            System.out.println(e);
        }

    }

    //打印类的构造器
    public static void printConstructors(Class cl) {
        Constructor[] constructors = cl.getConstructors();
        for (Constructor c : constructors) {
            String name = c.getName();  //构造器的名
            String modifiers = Modifier.toString(c.getModifiers()); //构造器的修饰符
            //打印修饰符和name
            System.out.print("\t" + modifiers + " " + name + "(");

            //打印参数类型
            Class[] paramTypes = c.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) System.out.print(", ");
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    public static void printMethods(Class cl) {
        Method[] methods = cl.getDeclaredMethods(); //公开方法
        for (Method m : methods) {
            Class retType = m.getReturnType();  //获取返回类型
            String name = m.getName();          //获取方法名

            System.out.print("\t");
            //打印修饰符,返回类型和方法名
            String modifiers = Modifier.toString(m.getModifiers()); //方法修饰符
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(retType.getName() + " " + name + "(");
            //打印参数
            Class[] paramTypes = m.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) System.out.print(",");
                System.out.print(paramTypes[i].getName());

            }
            System.out.println(");");
        }
    }

    //打印类所有字段(类的成员)
    public static void printFields(Class cl){
        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields) {
            Class type = field.getType();
            String name = field.getName();
            System.out.print("\t");

            String modifiers = Modifier.toString(field.getModifiers());
            if(modifiers.length() > 0){
                System.out.print(modifiers + " ");
            }
            System.out.println(type.getName() + " " + name + ";");
        }
    }
}
