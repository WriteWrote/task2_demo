package com.company;

import com.company.linedrawers.BriezenhaimLineDrawer;
import com.company.linedrawers.GraphicsLineDrawer;
import com.company.utils.DrawUtils;

import javax.sound.sampled.Line;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class MainPanel extends JPanel implements MouseMotionListener {
    private Point position = new Point(0, 0);

    public MainPanel() {
        this.addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        //super.paintComponent(g);
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics bi_g = bi.createGraphics();

        LineDrawer ld = new GraphicsLineDrawer(bi_g);
        // алгоритм, который сам придумывает, почему и как выбирать drawer (мин - свитч и иф или четыре панели/объекта для сравнения)
        // шикарно - порождающий паттерн проектирования (конкретнее - абстрактная фабрика)
        LineDrawer brd = new BriezenhaimLineDrawer();
        drawAll(ld);
        g.drawImage(bi, 0, 0, null);
        bi_g.dispose();
    }

    private void drawAll(LineDrawer ld) {
        /**/
        DrawUtils.drawSnowFlake(ld, 100, 100, 50, 13);
        ld.drawLine(getWidth() / 2, getHeight() / 2, position.x, position.y);
        /**/
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        position = new Point(e.getX(), e.getY());
        repaint();
    }
}
