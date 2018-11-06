package models;

import models.cases.Case;
import models.listeners.LabyrinthListener;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Labyrinth implements LabyrinthListener {
    private GridLayout gridLayout;
    private HashMap<Integer, Case> hashMapCase = new HashMap<>();
    private JPanel jPanel;

    Labyrinth(int caseAmount) {
        initView(caseAmount);
        initHashMap(caseAmount);
    }

    private void initHashMap(int cases) {
        for (int i = 0; i < cases; i++) {
            Case tmp = new Case(i);
            hashMapCase.put(i, tmp);
            jPanel.add(tmp.getComponent());
        }
    }

    private void initView(int caseAmount){
        gridLayout = new GridLayout(2, 2);
        jPanel = new JPanel(gridLayout);
    }

    @Override
    public void onGameFinished() {

    }

    @Override
    public void onGameStarted() {

    }

    @Override
    public void onGameLost() {

    }

    public JPanel getComponent(){
        return jPanel;
    }
}