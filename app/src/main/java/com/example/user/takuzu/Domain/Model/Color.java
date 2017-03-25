package com.example.user.takuzu.Domain.Model;

/**
 * Created by user on 06.03.2017.
 */

public enum Color {
    RED,BLUE,EMPTY;

    private Color change;
    public static final int NUMBER_OF_COLORS = 3;
    static{
        RED.change = BLUE;
        BLUE.change = EMPTY;
        EMPTY.change = RED;
    }

    public Color change(){
        return change;
    }

    public static Color byInt(int number){
        Color newColor;
        switch (number){
            case 1: {
                newColor = RED;
                break;
            }
            case 2:{
                newColor = BLUE;
                break;
            }
            default:{
                newColor = EMPTY;
            }
        }
        return newColor;
    }
}
