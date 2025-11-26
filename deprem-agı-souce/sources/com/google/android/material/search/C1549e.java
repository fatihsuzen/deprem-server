package com.google.android.material.search;

import android.animation.Animator;
import com.google.android.material.animation.AnimatableView;

/* renamed from: com.google.android.material.search.e  reason: case insensitive filesystem */
public final /* synthetic */ class C1549e implements AnimatableView.Listener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Animator f7076a;

    public /* synthetic */ C1549e(Animator animator) {
        this.f7076a = animator;
    }

    public final void onAnimationEnd() {
        this.f7076a.start();
    }
}
