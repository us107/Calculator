package myFirstproject;

import javax.swing.*;
import java.awt.*;

class GUI2d extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        // Set rendering hints for better graphics quality
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Draw a background rectangle
        g2d.setColor(new Color(60, 63, 65));
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Draw a gradient rectangle
        GradientPaint gradient = new GradientPaint(0, 0, Color.GRAY, getWidth(), getHeight(), Color.BLACK);
        g2d.setPaint(gradient);
        g2d.fillRoundRect(10, 10, getWidth() - 20, getHeight() - 20, 25, 25);
     // Draw stars
        g2d.setColor(Color.WHITE);
        g2d.setStroke(new BasicStroke(3));
        
       
        // Draw some text
        g2d.setFont(new Font("Times roman", Font.BOLD, 24));
        g2d.drawString("Calculator", getWidth() / 2 - 60, 30);
    }
}
