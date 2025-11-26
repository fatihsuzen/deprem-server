package androidx.constraintlayout.core.state;

public final /* synthetic */ class a implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f236a;

    public /* synthetic */ a(String str) {
        this.f236a = str;
    }

    public final float getInterpolation(float f5) {
        return Transition.d(this.f236a, f5);
    }
}
