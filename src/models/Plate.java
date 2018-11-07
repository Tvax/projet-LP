package models;

import models.listeners.KeyboardArrowListener;
import utils.Constants;
import utils.Strings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Plate implements KeyboardArrowListener {
    private Labyrinth labyrinthe1;
    private Labyrinth labyrinthe2;
    private JFrame frame;
    private JPanel jPanel;

    public Plate(){
        labyrinthe1 = new Labyrinth(Constants.LAB_CASES_COUNT);
        labyrinthe2 = new Labyrinth(Constants.LAB_CASES_COUNT);
        initWindow();
    }

    private void initWindow(){
        frame = new JFrame(Strings.window_name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.add(getBasejPanel());
        frame.setSize(400, 300);
        frame.addKeyListener(getKeyListener());
        frame.pack();
        frame.setVisible(true);
    }

//    private JPanel getBaseContent(){
//        JPanel jpanel = new JPanel();
//        jpanel.setadd(labyrinthe1.getComponent());
//        return jpanel;
//    }

    private JPanel getBasejPanel(){
        GridLayout gridLayout = new GridLayout(2, 2);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(gridLayout);
//        jPanel.addKeyListener(getKeyListener());

        jPanel.add(labyrinthe1.getComponent());
//        jPanel.add(labyrinthe2.getComponent());

        return jPanel;
    }

    private KeyListener getKeyListener(){
        return new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                switch (keyEvent.getKeyCode()){
                    case KeyEvent.VK_UP:
                        labyrinthe1.UpKey();
                        labyrinthe2.UpKey();
                        break;
                    case KeyEvent.VK_DOWN:
                        labyrinthe1.DownKey();
                        labyrinthe2.DownKey();
                        break;
                    case KeyEvent.VK_RIGHT:
                        labyrinthe1.RightKey();
                        labyrinthe2.RightKey();
                        break;
                    case KeyEvent.VK_LEFT:
                        labyrinthe1.LeftKey();
                        labyrinthe2.LeftKey();
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        };
    }

    @Override
    public void UpKey() {

    }

    @Override
    public void DownKey() {

    }

    @Override
    public void LeftKey() {

    }

    @Override
    public void RightKey() {

    }
}
