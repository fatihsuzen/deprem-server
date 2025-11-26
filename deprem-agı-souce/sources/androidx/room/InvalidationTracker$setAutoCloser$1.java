package androidx.room;

import k3.C2616a;
import kotlin.jvm.internal.C2639q;

/* synthetic */ class InvalidationTracker$setAutoCloser$1 extends C2639q implements C2616a {
    InvalidationTracker$setAutoCloser$1(Object obj) {
        super(0, obj, InvalidationTracker.class, "onAutoCloseCallback", "onAutoCloseCallback()V", 0);
    }

    public final void invoke() {
        ((InvalidationTracker) this.receiver).onAutoCloseCallback();
    }
}
