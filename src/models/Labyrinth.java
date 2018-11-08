package models;

import models.cases.PlayerCase;
import models.cases.Case;
import models.listeners.KeyboardArrowListener;
import models.listeners.LabyrinthListener;
import utils.Tools;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Labyrinth implements LabyrinthListener, KeyboardArrowListener {
    private int maxY = 0;
    private int maxX = 0;
    private Position currentPosition;
    private HashMap<Position, Case> hashMapCase = new HashMap<>();
    private JPanel jPanel;

    Labyrinth(int caseAmount) {
        this.currentPosition = new Position(0, 0);
        initView();
        initHashMap();
    }

    Labyrinth(){
        this(0);
    }

    private void initHashMap() {
        hashMapCase = Tools.getLabFromFile();

        for (Position position: hashMapCase.keySet()){
            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridy = position.getY();
            gridBagConstraints.gridx = position.getX();

            Case case1 = hashMapCase.get(position);

            jPanel.add(case1.getComponent(), gridBagConstraints);

            if (maxX < position.getX()){
                maxX = position.getX();
            }

            if (maxY < position.getY()){
                maxY = position.getY();
            }
        }

        movePlayer(new Position(1, 0));
    }

    private void initView(){
        jPanel = new JPanel(new GridBagLayout());
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
        try {
            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridy = currentPosition.getY();
            gridBagConstraints.gridx = currentPosition.getX();
            jPanel.remove(currentPosition.getY() + currentPosition.getX());
            jPanel.add(getCaseForPosition(currentPosition).getComponent(), gridBagConstraints, currentPosition.getY() + currentPosition.getX());

            GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
            gridBagConstraints1.gridy = futurePosition.getY();
            gridBagConstraints1.gridx = futurePosition.getX();
            currentPosition = futurePosition;
            jPanel.remove(currentPosition.getY() + currentPosition.getX());
            jPanel.add(new PlayerCase(futurePosition.getY() + futurePosition.getX()).getComponent(), gridBagConstraints1, currentPosition.getY() + currentPosition.getX());
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
        return new Case(currentPosition.getY() + currentPosition.getX());
    }

    private void moveDown(){
        if(currentPosition.getY() != maxY) {
            Position position = new Position(currentPosition);
            position.setY(position.getY() + 1);
            movePlayer(position);
        }
    }

    private void moveRight(){
        if(currentPosition.getX() != maxX) {
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
        if(currentPosition.getY() != 0) {
            Position position = new Position(currentPosition);
            position.setY(position.getY() - 1);
            movePlayer(position);
        }
    }

    private void writeCase(ImageIcon imageIcon, Position position){

    }

    JPanel getComponent(){
        return jPanel;
    }
}