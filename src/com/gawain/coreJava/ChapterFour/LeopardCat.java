package com.gawain.coreJava.ChapterFour;

/**
 * 豹猫
 */
public class LeopardCat extends Cat {
    private int age;
    private int totalKill = 0;

    public LeopardCat(String name, int age) {
        super(name);
        this.age = age;
    }

    public void Attack() {
        //超类中的protect方法子类可以访问 同包的也可也
        super.testPermission();
        totalKill++;
    }

    //也可以重写
    protected void testPermission() {

    }


    @Override
    public int getId() {
        return super.getId() + 10;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);

    }
}