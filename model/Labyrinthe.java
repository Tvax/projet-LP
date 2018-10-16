import java.util.HashMap;

public class Labyrinthe {
    HashMap cases = new HashMap<>();

    public Labyrinthe(int numberOfCase) {
        initHashMap(numberOfCase);
    }

    private void initHashMap(int cases) {
        for (int i = 0; i < cases; i++) {
            cases.put(new Integer(i), new Case());
        }
    }
}