package com.song.taskassistant.factory;

import com.intellij.openapi.wm.ToolWindow;
import com.song.taskassistant.dialog.TaskAssistant;

/**
 * @author song
 * @version 0.0.1
 * @date 2024/8/12 20:08
 */
public class TaskAssistantFactory {

    private static TaskAssistant taskAssistant;


    public static TaskAssistant createContent(ToolWindow toolWindow) {
        if(taskAssistant == null){
            taskAssistant  = new TaskAssistant(toolWindow);
        }
        return taskAssistant;
    }
}
