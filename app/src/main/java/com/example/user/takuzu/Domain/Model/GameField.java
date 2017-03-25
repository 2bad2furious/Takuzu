package com.example.user.takuzu.Domain.Model;

/**
 * Created by user on 06.03.2017.
 */

public class GameField {
    private Color color;
    private boolean locked;

    public GameField(Color color, boolean locked) {
        this.color = color;
        this.locked = locked;
    }

    public Color getColor(){
        return color;
    }

    public boolean isLocked() {
        return locked;
    }

    public GameField copy(){
        return new GameField(color,locked);
    }
}
