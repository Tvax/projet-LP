package models;

public class Position {
    private int x;
    private int y;

    public Position(Position position) {
        this.setY(position.getY());
        this.setX(position.getX());
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Position(int y, int x){
        this.setX(x);
        this.setY(y);
    }

    @Override
    public boolean equals(Object o) {
        Position position = (Position) o;
        return (this.getY() == position.getY() && this.getX() == position.getX());
    }
}
