package com.agricosacademy.agricosacademy;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity {

    private TextView tvTitle;
    private TextView tvDev;
    private TextView tvSKylark;
    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvDev = (TextView) findViewById(R.id.tv_dev);
        tvSKylark = (TextView) findViewById(R.id.tv_skylark);
        logo = (ImageView) findViewById(R.id.ic_logo);


        Animation fadeAnim = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        Animation swipeUpAnim = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        logo.startAnimation(swipeUpAnim);
        tvTitle.startAnimation(swipeUpAnim);
        tvDev.startAnimation(fadeAnim);
        tvSKylark.startAnimation(fadeAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(FullscreenActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        }, 3*1000);
    }

}
