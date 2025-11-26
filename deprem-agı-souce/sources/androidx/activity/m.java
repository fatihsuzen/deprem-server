package androidx.activity;

import android.view.View;
import android.view.ViewTreeObserver;
import y3.v;

public final /* synthetic */ class m implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ v f190a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f191b;

    public /* synthetic */ m(v vVar, View view) {
        this.f190a = vVar;
        this.f191b = view;
    }

    public final void onScrollChanged() {
        PipHintTrackerKt$trackPipAnimationHintView$flow$1.invokeSuspend$lambda$1(this.f190a, this.f191b);
    }
}
