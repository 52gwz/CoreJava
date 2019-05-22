package com.gawain.coreJava.ChapterFive;

import com.gawain.coreJava.ChapterFour.Cat;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class CopyArrayTest {
    public static void main(String[] args) {
        int[] a = {2, 3, 5};
        a = (int[]) copyOf(a, 2);
        Cat[] cats = new Cat[10];
        for (int i = 0; i < 5; i++) {
            cats[i] = new Cat("" + i);
        }
        cats = (Cat[]) copyOf(cats, 3);
        Class cl = cats[0].getClass();
        try {
            Method testM = cl.getMethod("getId");
            System.out.println(testM.invoke(cats[1]));  //参数1 指定对象 参数2 函数参数

        } catch (NoSuchMethodException e) {
            System.out.println(e);
        } catch (InvocationTargetException e) {
            System.out.println(e);
        } catch (IllegalAccessException e) {
            System.out.println(e);
        }
        try {
            Method mathMin = Math.class.getMethod("min", int.class, int.class);
//            Method mathMax = Math.class.getMethod("max", int.class, int.class);
            System.out.println(getMinMax(2, -4, mathMin));
        } catch (NoSuchMethodException e) {
            System.out.println(e);
        }


    }

    //
    public static Object copyOf(Object array, int newLength) {
        Class clA = array.getClass();
        if (!clA.isArray()) {
            //确定传入的是一个数组
            return null;
        }
        Class componentType = clA.getComponentType();
        int length = Array.getLength(array);
        //创建一个传入类型的数组引用
        Object newArray = Array.newInstance(componentType, newLength);
        System.arraycopy(array, 0, newArray, 0, Math.min(length, newLength));
        return newArray;
    }

    /**
     * Method在方法的参数中传入 可以调用不同的函数
     * 这里举一个小李子 当然实际不会这么使用
     */
    public static int getMinMax(int x, int y, Method f) {
        //这里传入的必须是静态方法
        if (!Modifier.isStatic(f.getModifiers())) {
            throw new IllegalArgumentException("Cannot put a non-static Method!");
        }
        Integer ret = null;
        try {
            ret = (Integer) f.invoke(null, x, y);
        } catch (IllegalAccessException e) {
            System.out.println(e);
        } catch (InvocationTargetException e) {
            System.out.println(e);
        }
        return ret;
    }
}
