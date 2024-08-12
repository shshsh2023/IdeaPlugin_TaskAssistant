package com.song.taskassistant.ui;

import com.intellij.ide.ui.laf.darcula.ui.DarculaButtonUI;
import com.intellij.ui.JBColor;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * @author song
 * @version 0.0.1
 * @date 2024/8/10 21:41
 */
public class CustomButtonUI extends DarculaButtonUI {

    public static ComponentUI createUI(JComponent c) {
        return new CustomButtonUI();
    }

    @Override
    public void paint(Graphics g, JComponent c) {
//        super.paint(g, c);
        JButton button = (JButton) c;
        Graphics2D graphics2D = (Graphics2D) g;

        graphics2D.setColor(JBColor.BLUE);

        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        graphics2D.fill(new RoundRectangle2D.Float(0,0, button.getWidth(), button.getHeight(), 10, 10));
//        graphics2D.fillRect(0, 0, button.getWidth(), button.getHeight());

//        graphics2D.setColor(JBColor.LIGHT_GRAY); // Border color
//        graphics2D.drawRect(0, 0, button.getWidth() - 1, button.getHeight() - 1);

        // Draw the button text
        Font serif = new Font("default", Font.BOLD, button.getFont().getSize());
        graphics2D.setFont(serif);



        FontMetrics fm = graphics2D.getFontMetrics();
        String text = button.getText();
        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getAscent();

        graphics2D.setColor(JBColor.WHITE); // Text color
        graphics2D.drawString(text, (button.getWidth() - textWidth) / 2, (button.getHeight() + textHeight) / 2-2);

    }
}
