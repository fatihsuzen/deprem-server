package androidx.activity;

import b3.C2308e;
import k3.l;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.activity.FullyDrawnReporterKt", f = "FullyDrawnReporter.kt", l = {185}, m = "reportWhenComplete")
final class FullyDrawnReporterKt$reportWhenComplete$1 extends d {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    FullyDrawnReporterKt$reportWhenComplete$1(C2308e eVar) {
        super(eVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FullyDrawnReporterKt.reportWhenComplete((FullyDrawnReporter) null, (l) null, this);
    }
}
