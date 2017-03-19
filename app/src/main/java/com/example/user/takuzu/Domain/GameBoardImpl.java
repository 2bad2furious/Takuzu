package com.example.user.takuzu.Domain;

import com.example.user.takuzu.Domain.Model.Color;
import com.example.user.takuzu.Domain.Model.Coordinates;
import com.example.user.takuzu.Domain.Model.GameBoard;
import com.example.user.takuzu.Domain.Model.GameField;

/**
 * Created by user on 06.03.2017.
 */

public class GameBoardImpl implements GameBoard {
    private GameField[][] arr;

    public GameBoardImpl(int size){
        arr = new GameField[size][size];
    }

    private GameBoardImpl(GameField[][] arr){
        this.arr = arr;
    }

    public GameField[][] getArr(){
        return arr.clone();
    }

    @Override
    public GameBoard change(Coordinates coordinates) {
        Color newColor = null;
        switch(arr[coordinates.getX()][coordinates.getY()].getColor()){
            case RED:{
                newColor = Color.BLUE;
                break;
            }
            case BLUE:{
                newColor = Color.EMPTY;
                break;
            }
            case EMPTY:{
                newColor = Color.RED;
                break;
            }
        }
        GameField[][] newArr = arr.clone();
        newArr[coordinates.getX()][coordinates.getY()] = new GameField(newColor);
        return new GameBoardImpl(arr);
    }
}
