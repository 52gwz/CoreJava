package com.gawain.coreJava.ChapterSix;

import com.gawain.coreJava.ChapterFour.Cat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TachibanaCat extends Cat implements Named{
    @Override
    public String getName() {
        //优先继承类
        return super.getName() + " 标记 ";
    }
    public static void main(String[] args) {
        TachibanaCat cat = new TachibanaCat();
        System.out.println(cat.getName());
        ActionListener listener = new TimerPrinter();
        Timer t = new Timer(1000,listener);
        t.start();
    }
}

class TimerPrinter implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        Toolkit.getDefaultToolkit().beep();
    }
}
