package com.company;

import com.company.linedrawers.BriezenhaimLineDrawer;
import com.company.linedrawers.DDALineDrawer;
import com.company.linedrawers.GraphicsLineDrawer;
import com.company.pixeldrawes.GraphicsPixelDrawer;
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

        bi_g.setColor(Color.white);
        bi_g.fillRect(0, 0, getWidth(), getHeight());
        bi_g.setColor(Color.black);

        PixelDrawer pd = new GraphicsPixelDrawer(bi_g);
        LineDrawer ld = new DDALineDrawer(pd);
        // алгоритм, который сам придумывает, почему и как выбирать drawer (мин - свитч и иф или четыре панели/объекта для сравнения)
        // шикарно - порождающий паттерн проектирования (конкретнее - абстрактная фабрика)
        //LineDrawer brd = new BriezenhaimLineDrawer();
        drawAll(ld);
        g.drawImage(bi, 0, 0, null);
        bi_g.dispose();
    }

    private void drawAll(LineDrawer ld) {
        /**/
        DrawUtils.drawSnowFlake(ld, getWidth() / 2, getHeight() / 2, 100, 13);
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
