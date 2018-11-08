package models;

import models.cases.Case;
import models.cases.FinishCase;
import models.cases.StartCase;
import models.listeners.KeyboardArrowListener;
import models.listeners.LabyrinthListener;
import utils.Tools;

import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.nio.file.Files;
import java.util.HashMap;

public class Labyrinth implements LabyrinthListener, KeyboardArrowListener {
    private int caseAmount;
    private Position currentPosition;
    private HashMap<Position, Case> hashMapCase = new HashMap<>();
    private JPanel jPanel;

    Labyrinth(int caseAmount) {
        this.caseAmount = caseAmount;
        this.currentPosition = new Position(0, 0);
        initView(caseAmount);
        initHashMap(caseAmount);
    }

    private void initHashMap(int cases) {
        hashMapCase = Tools.getLabFromFile();
//        for (int currentY = 0; currentY < cases; currentY++) {
//            for (int currentX = 0; currentX < cases; currentX++){
//                Case aCase = new Case(currentY + currentX);
//                hashMapCase.put(new Position(currentY, currentX), aCase);
//                GridBagConstraints gridBagConstraints = new GridBagConstraints();
//                gridBagConstraints.gridy = currentY;
//                gridBagConstraints.gridx = currentX;
//                jPanel.add(aCase.getComponent(), gridBagConstraints, aCase.getID());
//            }
//        }

        for (Position position: hashMapCase.keySet()){
            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridy = position.getY();
            gridBagConstraints.gridx = position.getX();

            Case case1 = hashMapCase.get(position);

            jPanel.add(case1.getComponent(), gridBagConstraints);
        }

        movePlayer(new Position(1, 0));
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
        moveUp();
    }

    @Override
    public void DownKey() {
        moveDown();
    }

    @Override
    public void LeftKey() {
        moveLeft();
    }

    @Override
    public void RightKey() {
        moveRight();
    }

    private void movePlayer(Position futurePosition){
        /*JOptionPane jop1;
        jop1 = new JOptionPane();
        jop1.showMessageDialog(null, "Félicitation, vous avez déplacé votre joueur !!!!", "Information", JOptionPane.INFORMATION_MESSAGE);*/

        try {
            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridy = currentPosition.getY();
            gridBagConstraints.gridx = currentPosition.getX();
            jPanel.remove(currentPosition.getY() + currentPosition.getX());
            jPanel.add(new Case(currentPosition.getY() + currentPosition.getX()).getComponent(), gridBagConstraints, currentPosition.getY() + currentPosition.getX());

            GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
            gridBagConstraints1.gridy = futurePosition.getY();
            gridBagConstraints1.gridx = futurePosition.getX();
            currentPosition = futurePosition;
            jPanel.remove(currentPosition.getY() + currentPosition.getX());
            jPanel.add(new StartCase(futurePosition.getY() + futurePosition.getX()).getComponent(), gridBagConstraints1, currentPosition.getY() + currentPosition.getX());
            jPanel.repaint();
            jPanel.revalidate();
        }catch (Exception e){

        }
    }

    private Case getCaseForPosition(Position position){
        for(Position pos: hashMapCase.keySet()){
            if(pos.equals(position)){
                return hashMapCase.get(position);
            }
        }
        return null;
    }

    private void moveDown(){
        if(currentPosition.getY() != caseAmount) {
            Position position = new Position(currentPosition);
            position.setY(position.getY() + 1);
            movePlayer(position);
        }
    }

    private void moveRight(){
        if(currentPosition.getX() != caseAmount) {
            Position position = new Position(currentPosition);
            position.setX(position.getX() + 1);
            movePlayer(position);
        }
    }

    private void moveLeft(){
        if(currentPosition.getX() != 0) {
            Position position = new Position(currentPosition);
            position.setX(position.getX() - 1);
            movePlayer(position);
        }
    }

    private void moveUp(){
//        Case case1 = hashMapCase.get(new Position(currentPosition.getY() -1, currentPosition.getX()));
//        Case case1 = getCaseForPosition(currentPosition);

        if(currentPosition.getY() != 0) {
            Position position = new Position(currentPosition);
            position.setY(position.getY() - 1);
            movePlayer(position);
        }

//        while(hashMapCase.keySet().iterator().hasNext()){
//            Position position = hashMapCase.keySet().iterator().next();
////            if (position.getY() == )
//        }
    }

    private void writeCase(ImageIcon imageIcon, Position position){

    }

    JPanel getComponent(){
        return jPanel;
    }
}