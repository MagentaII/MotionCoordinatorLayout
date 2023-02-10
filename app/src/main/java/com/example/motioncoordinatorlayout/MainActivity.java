package com.example.motioncoordinatorlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;

import android.os.Bundle;

import com.google.android.material.appbar.AppBarLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coordinateMotion();

    }

    private void coordinateMotion(){
        AppBarLayout appBarLayout =findViewById(R.id.appbar_layout);
        MotionLayout motionLayout = findViewById(R.id.motion_layout);
        AppBarLayout.OnOffsetChangedListener listener = new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                float seekPosition = (float)-verticalOffset / appBarLayout.getTotalScrollRange();
                motionLayout.setProgress(seekPosition);
            }
        };
        appBarLayout.addOnOffsetChangedListener(listener);
    }

}