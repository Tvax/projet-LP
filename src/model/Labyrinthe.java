package model;

import java.util.HashMap;

public class Labyrinthe {
    HashMap hashMapCase = new HashMap<>();

    public Labyrinthe(int numberOfCase) {
        initHashMap(numberOfCase);
    }

    private void initHashMap(int cases) {
        for (int i = 0; i < cases; i++) {
            hashMapCase.put(i, new Case());
        }
    }
}