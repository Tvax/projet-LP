package models;

import utils.Constants;

public class Plate {
    private Labyrinthe labyrinthe1;
    private Labyrinthe labyrinthe2;

    public Plate(){
        labyrinthe1 = new Labyrinthe(Constants.LAB_CASES_COUNT);
        labyrinthe2 = new Labyrinthe(Constants.LAB_CASES_COUNT);
    }
}
