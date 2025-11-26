package androidx.collection;

import k3.l;
import kotlin.jvm.internal.u;

final class ScatterSet$toString$1 extends u implements l {
    final /* synthetic */ ScatterSet<E> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScatterSet$toString$1(ScatterSet<E> scatterSet) {
        super(1);
        this.this$0 = scatterSet;
    }

    public final CharSequence invoke(E e5) {
        if (e5 == this.this$0) {
            return "(this)";
        }
        return String.valueOf(e5);
    }
}
