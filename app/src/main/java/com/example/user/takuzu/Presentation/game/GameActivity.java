package com.example.user.takuzu.Presentation.game;

import android.os.Bundle;
import android.widget.Toast;

import com.example.user.takuzu.Domain.Model.GameBoard;
import com.example.user.takuzu.R;

import butterknife.BindView;
import butterknife.ButterKnife;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ButterKnife.bind(this);

        int gameSize = getIntent().getIntExtra("size", 4);

        getPresenter().createGame(gameSize);

        gameBoardLayout.setOnMoveListener((x, y) -> getPresenter().onMoveMade(x, y));
    }

    @Override
    public void showGameBoard(GameBoard gameBoard) {
        gameBoardLayout.setBoard(gameBoard);
    }

    @Override
    public void warn(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
