package androidx.activity;

import W2.J;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.RequiresApi;
import b3.C2308e;
import c3.C2316b;
import z3.C2974g;

public final class PipHintTrackerKt {
    @RequiresApi(26)
    public static final Object trackPipAnimationHintView(Activity activity, View view, C2308e eVar) {
        Object collect = C2974g.d(new PipHintTrackerKt$trackPipAnimationHintView$flow$1(view, (C2308e) null)).collect(new PipHintTrackerKt$trackPipAnimationHintView$2(activity), eVar);
        if (collect == C2316b.f()) {
            return collect;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final Rect trackPipAnimationHintView$positionInWindow(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect;
    }
}
