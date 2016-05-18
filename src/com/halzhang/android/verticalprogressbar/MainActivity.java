package com.halzhang.android.verticalprogressbar;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
    private VerticalProgressBar progressBar;
    private TextView textView;
    private Handler mHandler = new Handler();
    private int currentPro = 100;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (VerticalProgressBar) findViewById(R.id.verticalProgressBar);
        textView = (TextView) findViewById(R.id.text);
        progressBar.setMax(currentPro);
        show();
    }
    
    private void show() {
        mHandler.postDelayed(new Runnable() {
            
            @Override
            public void run() {
                Drawable draw = getResources().getDrawable(R.drawable.charge_progress_drawable_green);
                Rect rect = progressBar.getProgressDrawable().getBounds();
                progressBar.setProgressDrawable(draw);
                progressBar.getProgressDrawable().setBounds(rect);
                progressBar.setProgress(currentPro);
                currentPro--;
                if (currentPro == 0) {
                    currentPro = 100;
                }
                textView.setText("currentPro = " + currentPro);
                show();
            }
        }, 100);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
