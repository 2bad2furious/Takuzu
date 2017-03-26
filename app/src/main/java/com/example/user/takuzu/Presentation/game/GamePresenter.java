package com.example.user.takuzu.Presentation.game;

import android.os.Bundle;

import com.example.user.takuzu.Domain.Game.Game;
import com.example.user.takuzu.Domain.GameImpl;
import com.example.user.takuzu.Domain.Model.Coordinates;
import com.example.user.takuzu.Domain.Model.GameBoard;

import nucleus.presenter.RxPresenter;

/**
 * Created by Rechtig on 19.03.2017.
 */

public class GamePresenter extends RxPresenter<GameView> {

    private Game game;

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        game = GameImpl.createNew(6, 4);

        view().subscribe(view -> {
            if (view != null) {
                view.showGameBoard(game.getGameBoard());
            }
        });
    }

    public void onMoveMade(int x, int y) {
        if (!game.isMovePossible(new Coordinates(x, y))) {
            view().subscribe(view -> {
                        if (view != null) {
                            view.warn("You can't play here, try again!");
                        }
                    }
            );
        } else {
            GameBoard newGameBoard = game.onMoveMade(new Coordinates(x, y));

            view().subscribe(view -> {
                if (view != null) {
                    view.showGameBoard(newGameBoard);
                }
            });
        }
    }
}
