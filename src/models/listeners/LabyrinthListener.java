package models.listeners;

public interface LabyrinthListener {
    void onGameFinished();
    void onGameStarted();
    void onGameLost();
}
