package com.gawain.coreJava.ChapterSix;

@FunctionalInterface
// javadoc 页里会指出你的接口是一个函数式接口。
public interface IntConsumer {
    void accept(int value);
    //void test();  @FunctionalInterface仅允许一个抽象方法
}
