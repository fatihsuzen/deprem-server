package androidx.dynamicanimation.animation;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnimationHandler f343a;

    public /* synthetic */ b(AnimationHandler animationHandler) {
        this.f343a = animationHandler;
    }

    public final void run() {
        this.f343a.mCallbackDispatcher.dispatchAnimationFrame();
    }
}
