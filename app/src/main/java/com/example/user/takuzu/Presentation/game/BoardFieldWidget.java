package com.example.user.takuzu.Presentation.game;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;

import com.example.user.takuzu.R;
import com.example.user.takuzu.Domain.Model.GameField;
//import com.example.user.takuzu.Domain.Model.Player;
//
/**
 * Created by user on 15.01.2017.
 */

public class BoardFieldWidget extends View {

    private TextPaint textPaint;
    private Paint circlePaint;
    private Paint gridPaint;
    private GameField gameField;
    private int row;
    private int column;
    private float marginSize;

    public BoardFieldWidget(Context context, GameField gameField, int row, int column) {
        super(context);
        init(gameField, row, column);
    }

    private void init(GameField gameField, int row, int column) {
        this.gameField = gameField;
        this.row = row;
        this.column = column;
        setClickable(true);
//        textPaint = new TextPaint();
//        textPaint.setTextSize(40);
//        textPaint.setColor(gameField.player() == Player.ANON ? Color.LTGRAY : gameField.player() == Player.FIRST_PLAYER ? Color.RED : Color.BLUE);
//
//        circlePaint = new Paint();
//        circlePaint.setColor(gameField.player() == Player.ANON ? Color.LTGRAY : gameField.player() == Player.FIRST_PLAYER ? Color.RED : Color.BLUE);

        gridPaint = new Paint();
        gridPaint.setColor(Color.LTGRAY);

        int[] attrs = new int[]{R.attr.selectableItemBackground};
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs);
        int backgroundResource = typedArray.getResourceId(0, 0);
        setBackgroundResource(backgroundResource);
        typedArray.recycle();

        float fieldSize = getResources().getDimension(R.dimen.field_size);
        marginSize = getResources().getDimension(R.dimen.field_margin_size);
        GridLayout.LayoutParams param = new GridLayout.LayoutParams();
        param.height = (int) fieldSize;
        param.width = (int) fieldSize;
        param.rightMargin = 4;
        param.topMargin = 4;
        param.setGravity(Gravity.CENTER);
        param.rowSpec = GridLayout.spec(row);
        param.columnSpec = GridLayout.spec(column);
        setLayoutParams(param);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();


        int atomWidth = width / 3;

        canvas.drawRect(0, 0, width, height, gridPaint);

//        if (gameField.atomCount() == 1) {
//            canvas.drawOval((width/2)-(atomWidth/2), (height/2)-(atomWidth/2), (width/2)+(atomWidth/2), (height/2)+(atomWidth/2), circlePaint);
//        } else if (gameField.atomCount() == 2){
//            canvas.drawOval(marginSize, marginSize, atomWidth+marginSize, atomWidth+marginSize, circlePaint);
//            canvas.drawOval((width-atomWidth)-marginSize, (height-atomWidth)-marginSize, width-marginSize, height-marginSize, circlePaint);
//        } else if (gameField.atomCount() == 3) {
//            canvas.drawOval((width/2)-(atomWidth/2), marginSize, (width/2)+(atomWidth/2), marginSize+atomWidth, circlePaint);
//
//            canvas.drawOval((width-atomWidth)-marginSize, (height-atomWidth)-marginSize, width-marginSize, height-marginSize, circlePaint);
//            canvas.drawOval(marginSize, (height-atomWidth)-marginSize, marginSize + atomWidth, height-marginSize, circlePaint);
//
//        }


    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
