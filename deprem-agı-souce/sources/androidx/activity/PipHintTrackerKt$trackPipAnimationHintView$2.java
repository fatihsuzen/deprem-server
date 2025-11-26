package androidx.activity;

import W2.J;
import android.app.Activity;
import android.graphics.Rect;
import b3.C2308e;
import z3.C2973f;

final class PipHintTrackerKt$trackPipAnimationHintView$2<T> implements C2973f {
    final /* synthetic */ Activity $this_trackPipAnimationHintView;

    PipHintTrackerKt$trackPipAnimationHintView$2(Activity activity) {
        this.$this_trackPipAnimationHintView = activity;
    }

    public final Object emit(Rect rect, C2308e eVar) {
        Api26Impl.INSTANCE.setPipParamsSourceRectHint(this.$this_trackPipAnimationHintView, rect);
        return J.f19942a;
    }
}
