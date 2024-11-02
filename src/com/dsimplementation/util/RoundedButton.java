package com.dsimplementation.util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class RoundedButton extends JButton {
    private static final long serialVersionUID = 1L;
    private Color backgroundColor;
    private int cornerRadius;
    private int borderThickness;

    public RoundedButton(int cornerRadius, ImageIcon image, int borderThickness) {
        this.cornerRadius = cornerRadius;
        this.borderThickness = borderThickness;
        this.backgroundColor = getBackground();  // Default background color
        setIcon(image);
        setContentAreaFilled(false); // Prevents default background painting
        setFocusPainted(false);      // Removes focus ring
        setOpaque(false);            // Allows rounded edges
    }

    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        
        // Anti-aliasing for smoother edges
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Draw rounded rectangle background with thicker border
        g2.setColor(backgroundColor != null ? backgroundColor : getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);

        // Center icon within the rounded area
        int iconX = (getWidth() - getIcon().getIconWidth()) / 2;
        int iconY = (getHeight() - getIcon().getIconHeight()) / 2;
        getIcon().paintIcon(this, g2, iconX, iconY);

        g2.dispose();
        super.paintComponent(g); // Call super to ensure default painting behavior
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(borderThickness)); // Set thicker border
        g2.setColor(getForeground());
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);

        g2.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(30, 30); // Fixed size of 30x30
    }
}
