package com.github.lcokean.customtitlebardemp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.github.library.StatusBarCompat;
import com.github.lcokean.customtitlebardemp.base.TitleBaseActivity;

public class MainActivity extends TitleBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTitle();
    }

    private void initTitle() {
        getTitleHeaderBar().setTitle("快看上面的状态栏");

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int r = (int) (Math.random() * 255);
                int g = (int) (Math.random() * 255);
                int b = (int) (Math.random() * 255);
                int color = Color.rgb(r, g, b);
                StatusBarCompat.setStatusBarColor(MainActivity.this, color);
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //透明状态栏
                StatusBarCompat.translucentStatusBar(MainActivity.this);
            }
        });

    }

}
