package com.example.kimayadesai.quizkv2;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

/**
 * Created by kimayadesai on 4/11/18.
 */

public class MyAnimation {
    public static Animation flipAnimation() {
        Animation flip;
        flip = new RotateAnimation(0,50);
        flip.setDuration(5000);
        flip.setInterpolator(new AccelerateInterpolator());
        return flip;
    }
}
