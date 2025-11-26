package androidx.activity;

import android.view.View;
import y3.v;

public final /* synthetic */ class l implements View.OnLayoutChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ v f189a;

    public /* synthetic */ l(v vVar) {
        this.f189a = vVar;
    }

    public final void onLayoutChange(View view, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        PipHintTrackerKt$trackPipAnimationHintView$flow$1.invokeSuspend$lambda$0(this.f189a, view, i5, i6, i7, i8, i9, i10, i11, i12);
    }
}
