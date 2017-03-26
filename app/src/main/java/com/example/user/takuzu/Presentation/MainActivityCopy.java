package com.example.user.takuzu.Presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.user.takuzu.Presentation.game.GameActivity;
import com.example.user.takuzu.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivityCopy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.startGame)
    public void submit(View view){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}
