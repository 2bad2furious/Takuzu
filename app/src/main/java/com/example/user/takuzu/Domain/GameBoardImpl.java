package com.example.user.takuzu.Domain;

import com.example.user.takuzu.Domain.Model.Color;
import com.example.user.takuzu.Domain.Model.Coordinates;
import com.example.user.takuzu.Domain.Model.GameBoard;
import com.example.user.takuzu.Domain.Model.GameField;

/**
 * Created by user on 06.03.2017.
 */

public class GameBoardImpl implements GameBoard {
    private GameField[][] fields;

    public GameBoardImpl(int size){
        fields = new GameField[size][size];
    }

    private GameBoardImpl(GameField[][] arr){
        this.fields = arr;
    }

    public GameField[][] fields() {
        return copy(fields);
    }

    private GameField[][] copy(GameField[][] arr){
        if(arr[0] == null) throw new IllegalArgumentException("You fucking cock");
        GameField[][] newArr = new GameField[arr.length][arr[0].length];
        for (int x = 0;x < arr.length;x++) {
            for (int y = 0;y < arr[x].length;y++) {
                newArr[x][y] = arr[x][y].copy();
            }
        }
        return newArr;
    }

    @Override
    public GameBoard change(Coordinates coordinates) {
        Color newColor = null;
        switch(fields[coordinates.getX()][coordinates.getY()].getColor()){
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
        GameField[][] newArr = copy(fields);
        newArr[coordinates.getX()][coordinates.getY()] = new GameField(newColor);
        return new GameBoardImpl(fields);
    }
}
