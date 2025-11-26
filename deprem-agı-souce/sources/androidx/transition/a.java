package androidx.transition;

import androidx.core.os.CancellationSignal;

public final /* synthetic */ class a implements CancellationSignal.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f482a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Transition f483b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Runnable f484c;

    public /* synthetic */ a(Runnable runnable, Transition transition, Runnable runnable2) {
        this.f482a = runnable;
        this.f483b = transition;
        this.f484c = runnable2;
    }

    public final void onCancel() {
        FragmentTransitionSupport.a(this.f482a, this.f483b, this.f484c);
    }
}
