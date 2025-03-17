package com.example.mobileadvance.bai1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class AnimatedView extends View {
    private Paint paint;
    private int x = 0;
    private int dx = 10;

    public AnimatedView(Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(x, 300, 50, paint);
        x += dx;
        if (x > getWidth() || x < 0) dx = -dx;
        postInvalidateDelayed(30);

        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);

        // Vẽ hình chữ nhật
        canvas.drawRect(50, 50, 200, 200, paint);

        // Vẽ đường thẳng
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
        canvas.drawLine(100, 300, 400, 300, paint);

        // Vẽ hình tròn
        paint.setColor(Color.GREEN);
        canvas.drawCircle(300, 500, 100, paint);
    }
}