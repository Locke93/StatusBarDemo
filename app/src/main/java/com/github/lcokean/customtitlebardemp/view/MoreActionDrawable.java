package com.github.lcokean.customtitlebardemp.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

import com.github.lcokean.customtitlebardemp.R;

/**
 * @author lcokean
 * @version 4.3 on 2016/7/26
 */
public class MoreActionDrawable extends Drawable {

    private int mColor = 0xFFFFFFFF;
    private Paint mPaint;

    private int mDotRadius = 3;
    private int mDotSpan = 3;

    private static final int[] moreActionAttributes = {
            R.attr.more_action_dot_radius,
            R.attr.more_action_dot_span,
            R.attr.more_action_dot_color
    };

    public MoreActionDrawable(Context context, int radius, int span, int color) {
        super();

        mDotRadius = radius;
        mDotSpan = span;
        mColor = color;

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(mColor);
    }

    public void setDotRadius(int radius) {
        mDotRadius = radius;
        invalidateSelf();
    }

    public void setDotSpan(int span) {
        mDotRadius = span;
        invalidateSelf();
    }

    public void setDotColor(int color) {
        mColor = color;
        invalidateSelf();
    }

    @Override
    public int getIntrinsicHeight() {
        //Return the vertical bounds measured, or -1 if none
        return mDotRadius * 2;
    }

    @Override
    public int getIntrinsicWidth() {
        //Return the horizontal bounds measured, or -1 if none
        return mDotRadius * 2 * 3 + 2 * mDotSpan;

    }

    @Override
    public void draw(Canvas canvas) {
        for (int i = 0; i < 3; i++) {
            float x = i * (mDotRadius * 2 + mDotSpan) + mDotRadius;
            canvas.drawCircle(x, mDotRadius, mDotRadius, mPaint);
        }
    }

    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return 0;
    }
}
