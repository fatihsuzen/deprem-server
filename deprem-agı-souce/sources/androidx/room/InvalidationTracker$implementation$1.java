package androidx.room;

import W2.J;
import java.util.Set;
import k3.l;
import kotlin.jvm.internal.C2639q;
import kotlin.jvm.internal.t;

/* synthetic */ class InvalidationTracker$implementation$1 extends C2639q implements l {
    InvalidationTracker$implementation$1(Object obj) {
        super(1, obj, InvalidationTracker.class, "notifyInvalidatedObservers", "notifyInvalidatedObservers(Ljava/util/Set;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Set<Integer>) (Set) obj);
        return J.f19942a;
    }

    public final void invoke(Set<Integer> set) {
        t.e(set, "p0");
        ((InvalidationTracker) this.receiver).notifyInvalidatedObservers(set);
    }
}
