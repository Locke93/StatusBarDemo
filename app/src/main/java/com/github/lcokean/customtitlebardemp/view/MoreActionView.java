package com.github.lcokean.customtitlebardemp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.github.lcokean.customtitlebardemp.R;


public class MoreActionView extends ImageView {

    public MoreActionView(Context context, AttributeSet attrs) {
        super(context, attrs);

        int color = 0xFFFFFFFF;
        int radius = 3;
        int span = 5;

        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.MoreActionView, 0, 0);
        if (arr != null) {
            if (arr.hasValue(R.styleable.MoreActionView_more_action_dot_radius)) {
                radius = (int) arr.getDimension(R.styleable.MoreActionView_more_action_dot_radius, radius);
            }

            if (arr.hasValue(R.styleable.MoreActionView_more_action_dot_span)) {
                span = (int) arr.getDimension(R.styleable.MoreActionView_more_action_dot_span, span);
            }

            color = arr.getColor(R.styleable.MoreActionView_more_action_dot_color, color);
            arr.recycle();
        }
        setImageDrawable(new MoreActionDrawable(context, radius, span, color));
    }

}
