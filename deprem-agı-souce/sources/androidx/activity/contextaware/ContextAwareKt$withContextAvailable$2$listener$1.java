package androidx.activity.contextaware;

import W2.t;
import W2.u;
import android.content.Context;
import k3.l;
import kotlin.jvm.internal.t;
import w3.C2882l;

public final class ContextAwareKt$withContextAvailable$2$listener$1 implements OnContextAvailableListener {
    final /* synthetic */ C2882l $co;
    final /* synthetic */ l $onContextAvailable;

    public ContextAwareKt$withContextAvailable$2$listener$1(C2882l lVar, l lVar2) {
        this.$co = lVar;
        this.$onContextAvailable = lVar2;
    }

    public void onContextAvailable(Context context) {
        Object obj;
        t.e(context, "context");
        C2882l lVar = this.$co;
        l lVar2 = this.$onContextAvailable;
        try {
            t.a aVar = W2.t.f19966b;
            obj = W2.t.b(lVar2.invoke(context));
        } catch (Throwable th) {
            t.a aVar2 = W2.t.f19966b;
            obj = W2.t.b(u.a(th));
        }
        lVar.resumeWith(obj);
    }
}
