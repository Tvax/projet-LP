package models;

import utils.Constants;
import utils.Strings;

import javax.swing.*;
import java.awt.*;

public class Plate {
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

        jPanel.add(labyrinthe1.getComponent());
        jPanel.add(labyrinthe2.getComponent());

        return jPanel;
    }
}
