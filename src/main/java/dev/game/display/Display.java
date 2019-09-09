package dev.game.display;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Display {
    private JFrame frame;
    private Canvas canvas;
    private String title;
    private int width, height;

    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        createDisplay();
    }

    private void createDisplay() {
        URL iconURL = getClass().getResource("/favicon.jpg");
        ImageIcon icon = new ImageIcon(iconURL);

        frame = new JFrame(title);
        frame.setUndecorated(true);
        frame.getContentPane().setBackground(Color.black);
        frame.setSize(width + 100, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setIconImage(icon.getImage());

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();
    }

    public JFrame getFrame() {
        return frame;
    }

    public Canvas getCanvas() {
        return canvas;
    }
}
