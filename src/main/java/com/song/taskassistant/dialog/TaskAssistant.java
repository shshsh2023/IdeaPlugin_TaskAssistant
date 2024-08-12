package com.song.taskassistant.dialog;

import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.openapi.ui.popup.ListPopup;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import com.intellij.util.ui.JBUI;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class TaskAssistant {

    private JPanel contentPane = new JPanel(new BorderLayout(20, 10));

    private JButton button1;
    private JButton button2;
    private JSpinner spinner1;
    private JTextPane a120000TextPane;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JCheckBox checkBox4;

    public static class SouthPanelFactory {

        //静态成员变量会重复添加组件，导致界面错乱
        public static JPanel createSouthPanel(ToolWindow toolWindow) {
            JPanel southPanel = new JPanel(new GridLayout());

            southPanel.add(new Spacer());
            southPanel.add(createControlsPanel(toolWindow));
            return southPanel;
        }

        @NotNull
        private static JPanel createControlsPanel(ToolWindow toolWindow) {
            JPanel controlsPanel = new JPanel();

            JButton add = new JButton("添加");
            add.addActionListener(e -> {
                AddTask addTask = new AddTask(SwingUtilities.windowForComponent(controlsPanel), "添加任务");
                addTask.setVisible(true);
            });
            controlsPanel.add(add);

            JButton confirm = new JButton("确认");
            confirm.addActionListener(e -> {
                System.out.println("点击了ok");
            });

            controlsPanel.add(confirm);

            JButton cancel = new JButton("cancel");
            cancel.addActionListener(e -> toolWindow.hide(null));
            controlsPanel.add(cancel);

            return controlsPanel;
        }

    }


    public static class MiddlePanelFactory {

        public static JPanel createMiddlePanel() {
            JPanel middlePanel = new JPanel(new GridLayoutManager(2, 1));

            middlePanel.add(getWorkLists(), new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_NORTH,
                    GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED,
                    null, null, null));
            middlePanel.add(getTimePanel(), new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_NORTH,
                    GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED,
                    null, null, null));

            return middlePanel;
        }

        public static JPanel getTimePanel() {
            JPanel jPanel = new JPanel(new FlowLayout());

            jPanel.add(getStartDateTextPane());

            jPanel.add(getEndDateTextPane());

            return jPanel;
        }

        public static JPanel getWorkLists() {
            JPanel jPanel = new JPanel(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();

            gbc.gridx = 0;  // 列号
            gbc.gridy = GridBagConstraints.RELATIVE;  // 行号，RELATIVE 表示按顺序添加
            gbc.anchor = GridBagConstraints.NORTH;  // 将组件放置在单元格的顶部和左侧
            gbc.fill = GridBagConstraints.HORIZONTAL;  // 组件水平填充
            gbc.weightx = 1.0;  // 水平方向的扩展权重
            gbc.weighty = 0.0;  // 垂直方向的扩展权重，0.0 表示不扩展
            gbc.ipady = 5;
            gbc.insets = JBUI.insets(10, 10, 0, 0);

            jPanel.add(new JCheckBox("完成组件开发"), gbc);
            jPanel.add(new JCheckBox("完成代码测试"), gbc);
            jPanel.add(new JCheckBox("修改bug"), gbc);
            jPanel.add(new JCheckBox("<html>This is a very long text that needs to<br/>wrap into multiple lines</html>"), gbc);

            return jPanel;
        }

        public static JTextPane getStartDateTextPane() {
            JTextPane startDate = new JTextPane();

            LocalDateTime now = LocalDateTime.now();
            startDate.setText(now.format(DateTimeFormatter.ofPattern("HH:mm:ss")) + "  -");
            startDate.setEditable(false);

            return startDate;
        }

        public static JSpinner.DateEditor getEndDateTextPane() {
            JSpinner jSpinner = new JSpinner(new SpinnerDateModel());
            JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(jSpinner, "HH:mm:ss");

            jSpinner.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    System.out.println("focus");
                }
            });

            dateEditor.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    System.out.println("focus");
                }
            });

            return dateEditor;
        }

    }


    public TaskAssistant(ToolWindow toolWindow) {
        //添加中间组件
        contentPane.add(MiddlePanelFactory.createMiddlePanel(), BorderLayout.CENTER);
        //添加南边组件
        contentPane.add(SouthPanelFactory.createSouthPanel(toolWindow), BorderLayout.SOUTH);

//        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    public JPanel getContentPanel() {
        return contentPane;
    }
}
