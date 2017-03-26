package com.example.user.takuzu.Presentation.game;

import android.widget.Toast;

import com.example.user.takuzu.Domain.Model.GameBoard;
import com.example.user.takuzu.R;

import butterknife.BindView;
import nucleus.factory.RequiresPresenter;
import nucleus.view.NucleusActivity;

/**
 * Created by Rechtig on 19.03.2017.
 */

@RequiresPresenter(GamePresenter.class)
public class GameActivity extends NucleusActivity<GamePresenter> implements GameView {


    @BindView(R.id.game_board_layout)
    GameBoardLayout gameBoardLayout;

    @Override
    public void showGameBoard(GameBoard gameBoard) {
        gameBoardLayout.setBoard(gameBoard);
    }

    @Override
    public void warn(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
