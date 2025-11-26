package androidx.dynamicanimation.animation;

import android.view.Choreographer;

public final /* synthetic */ class f implements Choreographer.FrameCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f345a;

    public /* synthetic */ f(Runnable runnable) {
        this.f345a = runnable;
    }

    public final void doFrame(long j5) {
        this.f345a.run();
    }
}
