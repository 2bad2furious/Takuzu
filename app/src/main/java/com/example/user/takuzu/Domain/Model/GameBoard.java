package com.example.user.takuzu.Domain.Model;

/**
 * Created by user on 19.03.2017.
 */

public interface GameBoard {
    GameField[][] fields();
    int rows();
    int columns();
    GameBoard change(Coordinates coordinates);
    boolean isLocked(Coordinates coordinates);
    boolean isOnBoard(Coordinates coordinates);
    boolean isBoardFull();
    double filled();

}
