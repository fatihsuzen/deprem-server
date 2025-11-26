package androidx.activity;

import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import k3.C2616a;
import k3.l;
import kotlin.jvm.internal.t;

public final class OnBackPressedDispatcher$Api34Impl$createOnBackAnimationCallback$1 implements OnBackAnimationCallback {
    final /* synthetic */ C2616a $onBackCancelled;
    final /* synthetic */ C2616a $onBackInvoked;
    final /* synthetic */ l $onBackProgressed;
    final /* synthetic */ l $onBackStarted;

    OnBackPressedDispatcher$Api34Impl$createOnBackAnimationCallback$1(l lVar, l lVar2, C2616a aVar, C2616a aVar2) {
        this.$onBackStarted = lVar;
        this.$onBackProgressed = lVar2;
        this.$onBackInvoked = aVar;
        this.$onBackCancelled = aVar2;
    }

    public void onBackCancelled() {
        this.$onBackCancelled.invoke();
    }

    public void onBackInvoked() {
        this.$onBackInvoked.invoke();
    }

    public void onBackProgressed(BackEvent backEvent) {
        t.e(backEvent, "backEvent");
        this.$onBackProgressed.invoke(new BackEventCompat(backEvent));
    }

    public void onBackStarted(BackEvent backEvent) {
        t.e(backEvent, "backEvent");
        this.$onBackStarted.invoke(new BackEventCompat(backEvent));
    }
}
