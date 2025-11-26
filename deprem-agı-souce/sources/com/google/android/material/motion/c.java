package com.google.android.material.motion;

import android.animation.TypeEvaluator;

public final /* synthetic */ class c implements TypeEvaluator {
    public final Object evaluate(float f5, Object obj, Object obj2) {
        return MaterialMainContainerBackHelper.lerpCornerRadii((float[]) obj, (float[]) obj2, f5);
    }
}
