package com.xiaokaige.base.innerclass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @author: zk
 * Date: 2021/9/30
 * Time: 16:53
 */
public class TalkingClock {
    private int interval;

    private boolean beep;

    public static void main(String[] args) {
        TalkingClock talkingClock = new TalkingClock(1000, true);
        talkingClock.start();

        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }

    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    //内部类
    public class TimePrinter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("At the tone, the time is " + new Date());
            if (beep) {
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }

    public void start(){
        ActionListener actionListener = new TimePrinter();
        Timer timer = new Timer(interval, actionListener);
        timer.start();
    }
}
