package com.example.user.takuzu.Presentation.game;

import com.example.user.takuzu.Domain.Model.GameBoard;

/**
 * Created by Rechtig on 19.03.2017.
 */

public interface GameView {
    void showGameBoard(GameBoard gameBoard);
    void warn(String message);
}
