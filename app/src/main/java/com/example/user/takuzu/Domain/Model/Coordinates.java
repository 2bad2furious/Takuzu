package com.example.user.takuzu.Domain.Model;

/**
 * Created by user on 06.03.2017.
 */

public class Coordinates {
    public final int x;
    public final int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
