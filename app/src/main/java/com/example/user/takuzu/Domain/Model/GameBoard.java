package com.example.user.takuzu.Domain.Model;

/**
 * Created by user on 19.03.2017.
 */

public interface GameBoard {
    GameField[][] getArr();
    GameBoard change(Coordinates coordinates);
}
