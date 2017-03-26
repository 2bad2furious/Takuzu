package com.example.user.takuzu.Domain;

import com.example.user.takuzu.Domain.Model.Color;
import com.example.user.takuzu.Domain.Model.Coordinates;
import com.example.user.takuzu.Domain.Model.GameBoard;
import com.example.user.takuzu.Domain.Model.GameField;
import com.example.user.takuzu.Domain.Model.Solver;

import java.security.InvalidParameterException;
import java.util.Random;

/**
 * Created by user on 06.03.2017.
 */

public class GameBoardImpl implements GameBoard {
    private final float LOCKED_FIELDS_PERCENT = 1/6;
    private static Random rn = new Random();
    private GameField[][] fields;

    public GameBoardImpl(int size){
        fields = generate(size);
    }

    private GameBoardImpl(GameField[][] arr){
        this.fields = arr;
    }

    public GameField[][] fields() {
        return copy(fields);
    }

    @Override
    public int rows() {
        if(fields[0] == null) throw new IllegalArgumentException("You fucking cock");
        return fields[0].length;
    }

    @Override
    public int columns() {
        return fields.length;
    }

    private GameField[][] copy(GameField[][] arr){
        if(arr[0] == null) throw new IllegalArgumentException("Bollocks");
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
        if(fields[coordinates.getX()][coordinates.getY()].isLocked())
            throw new IllegalArgumentException("This field is locked");

        Color newColor = fields[coordinates.getX()][coordinates.getY()].getColor().change();

        GameField[][] newArr = copy(fields);
        newArr[coordinates.getX()][coordinates.getY()] = new GameField(newColor,false);

        return new GameBoardImpl(newArr);
    }

    private GameField[][] generate(int size){
        if(size < 0) throw new InvalidParameterException("Field's size cannot be negative");
        GameField[][] arr = new GameField[size][size];
        int pocetLocknutejch = (int) Math.floor(size*size*LOCKED_FIELDS_PERCENT);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                boolean lock = (pocetLocknutejch>0)?(rn.nextInt()%(1/LOCKED_FIELDS_PERCENT) == 0):false;

                arr[i][j] = new GameField(Color.byInt(rn.nextInt(Color.NUMBER_OF_COLORS)),lock);

                if(lock) pocetLocknutejch--;
            }
        }
        if(!isValid(arr)) arr = generate(size);
        return arr;
    }

    private boolean isValid(GameField[][] arr){
        return Solver.isSolvable(arr);
    }
}
