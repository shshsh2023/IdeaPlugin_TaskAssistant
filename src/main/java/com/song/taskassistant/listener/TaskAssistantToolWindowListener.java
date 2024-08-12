package com.song.taskassistant.listener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author song
 * @version 0.0.1
 * @date 2024/8/12 14:07
 */
public class TaskAssistantToolWindowListener extends WindowAdapter {

    public void windowClosing(WindowEvent e) {
        System.out.println("窗口关闭");
    }


    @Override
    public void windowOpened(WindowEvent e) {

        System.out.println("窗口打开");
    }
}

