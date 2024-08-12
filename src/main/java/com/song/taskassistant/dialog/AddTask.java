package com.song.taskassistant.dialog;

import com.intellij.ui.components.JBTextArea;
import com.intellij.ui.components.JBTextField;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddTask extends JDialog {

    private JPanel contentPane = new JPanel(new BorderLayout());

    private JButton buttonOK;
    private JButton buttonCancel;


    public AddTask(Window window, String title) {
        super(window, title);
        setLocationRelativeTo(window);
        setSize(400, 200);

        setModal(true);
        getRootPane().setDefaultButton(buttonCancel);

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(
                e -> onCancel(),
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT
        );

        contentPane.add(createCenterPanel(), BorderLayout.CENTER);
        contentPane.add(createSouthPanel(), BorderLayout.SOUTH);

        setContentPane(contentPane);
    }


    public JPanel createCenterPanel() {
        JPanel jPanel = new JPanel();
        JTextPane jTextArea = new JTextPane();
        jTextArea.setText("<html>This is a very long text that needs to<br/>wrap into multiple lines</html>");
        jPanel.add(jTextArea);

        return jPanel;
    }

    public JPanel createSouthPanel() {
        JPanel jPanel = new JPanel(new FlowLayout());

        buttonOK = new JButton("确认");
        buttonCancel = new JButton("取消");


        jPanel.add(new Spacer());
        jPanel.add(buttonOK);
        jPanel.add(buttonCancel);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        return jPanel;
    }


    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }


}
