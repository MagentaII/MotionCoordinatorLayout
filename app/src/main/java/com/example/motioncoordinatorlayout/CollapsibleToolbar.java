package com.example.motioncoordinatorlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewParent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.MotionLayout;

import com.google.android.material.appbar.AppBarLayout;

public class CollapsibleToolbar extends MotionLayout implements AppBarLayout.OnOffsetChangedListener {
    public CollapsibleToolbar(@NonNull Context context) {
        super(context);
    }

    public CollapsibleToolbar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CollapsibleToolbar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        float seekPosition = (float)-verticalOffset / appBarLayout.getTotalScrollRange();
        setProgress(seekPosition);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        final ViewParent parent = getParent();
        ((AppBarLayout) parent).addOnOffsetChangedListener(this);
    }
}
