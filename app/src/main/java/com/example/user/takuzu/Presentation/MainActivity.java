package com.example.user.takuzu.Presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.user.takuzu.Presentation.game.GameActivity;
import com.example.user.takuzu.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.startEasy)
    public void startEasy(View view){
        submit(R.string.start_easy);
    }

    @OnClick(R.id.startMedium)
    public void startMedium(View view){
        submit(R.string.start_medium);
    }

    @OnClick(R.id.startHard)
    public void startHard(View view){
        submit(R.string.start_hard);
    }

    @OnClick(R.id.startUltimate)
    public void startUltra(View view){
        submit(R.string.start_ultimate);
    }

    public void submit(int size){
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("size", size);
        startActivity(intent);
    }
}
