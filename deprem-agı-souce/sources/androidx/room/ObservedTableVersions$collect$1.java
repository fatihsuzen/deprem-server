package androidx.room;

import b3.C2308e;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import z3.C2973f;

@f(c = "androidx.room.ObservedTableVersions", f = "InvalidationTracker.kt", l = {602}, m = "collect")
final class ObservedTableVersions$collect$1 extends d {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObservedTableVersions this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ObservedTableVersions$collect$1(ObservedTableVersions observedTableVersions, C2308e eVar) {
        super(eVar);
        this.this$0 = observedTableVersions;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.collect((C2973f) null, this);
    }
}
