package com.song.taskassistant.toolwindows;

import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import com.song.taskassistant.dialog.TaskAssistant;
import com.song.taskassistant.factory.TaskAssistantFactory;
import org.jetbrains.annotations.NotNull;

/**
 * @author song
 * @version 0.0.1
 * @date 2024/8/12 9:21
 */
public class TaskAssistantToolWindowPlugin implements ToolWindowFactory, DumbAware {

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        TaskAssistant taskAssistant = TaskAssistantFactory.createContent(toolWindow);
        System.out.println(taskAssistant.hashCode());
        Content time = ContentFactory.getInstance().createContent(taskAssistant.getContentPanel(), "制定任务", false);
        toolWindow.getContentManager().addContent(time);

    }

}
