package com.example.user.takuzu.Domain.Game;

import com.example.user.takuzu.Domain.Model.Coordinates;
import com.example.user.takuzu.Domain.Model.GameBoard;

/**
 * Created by user on 06.03.2017.
 */

public interface Game {
    GameBoard onMoveMade(Coordinates coordinates);
    boolean isMovePossible(Coordinates coordinates);
    GameBoard getGameBoard();
    boolean isGameOver();
}
