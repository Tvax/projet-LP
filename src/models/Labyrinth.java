package models;

import models.cases.Case;
import models.cases.StartCase;
import models.listeners.KeyboardArrowListener;
import models.listeners.LabyrinthListener;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Labyrinth implements LabyrinthListener, KeyboardArrowListener {
    private int caseAmount;
    private Position currentPosition;
    private HashMap<Position, Case> hashMapCase = new HashMap<>();
    private JPanel jPanel;

    Labyrinth(int caseAmount) {
        this.caseAmount = caseAmount;
        initView(caseAmount);
        initHashMap(caseAmount);
    }

    private void initHashMap(int cases) {
        for (int currentY = 0; currentY < cases; currentY++) {
            for (int currentX = 0; currentX < cases; currentX++){
                Case aCase = new Case(currentY + currentX);
                hashMapCase.put(new Position(currentY, currentX), aCase);
                GridBagConstraints gridBagConstraints = new GridBagConstraints();
                gridBagConstraints.gridy = currentY;
                gridBagConstraints.gridx = currentX;
                jPanel.add(aCase.getComponent(), gridBagConstraints);
            }
        }

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridx = 0;
        jPanel.add(new StartCase(44).getComponent(), gridBagConstraints);
    }

    private void initView(int caseAmount){
//        gridLayout = new GridLayout(caseAmount, caseAmount/2);
        jPanel = new JPanel(new GridBagLayout());
//        for (Case aCase : hashMapCase.values()){
//            GridBagConstraints gridBagConstraints = new GridBagConstraints();
//            gridBagConstraints.gridx = 0;
//            gridBagConstraints.gridy = 0;
//            jPanel.add(aCase.getComponent(), gridBagConstraints);
//        }
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

    @Override
    public void UpKey() {
        if(currentPosition.getY() != 0){

        }
    }

    @Override
    public void DownKey() {
        if(currentPosition.getY() != caseAmount){

        }
    }

    @Override
    public void LeftKey() {

    }

    @Override
    public void RightKey() {

    }

    private void moveUp(){
        while(hashMapCase.keySet().iterator().hasNext()){
            Position position = hashMapCase.keySet().iterator().next();


        }
    }

    private void writeCase(ImageIcon imageIcon, Position position){

    }

    JPanel getComponent(){
        return jPanel;
    }
}