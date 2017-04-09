package com.example.user.takuzu.Domain.Model;

/**
 * Created by user on 08.04.2017.
 */

public class NotSolvedException extends Exception {

    private NotSolvedReason reason;
    private int line;

    public NotSolvedException(NotSolvedReason reason) {

    }
}
