package androidx.activity.contextaware;

import W2.J;
import android.content.Context;
import b3.C2308e;
import c3.C2316b;
import k3.l;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.r;
import w3.C2886n;

public final class ContextAwareKt {
    public static final <R> Object withContextAvailable(ContextAware contextAware, l lVar, C2308e eVar) {
        Context peekAvailableContext = contextAware.peekAvailableContext();
        if (peekAvailableContext != null) {
            return lVar.invoke(peekAvailableContext);
        }
        C2886n nVar = new C2886n(C2316b.c(eVar), 1);
        nVar.D();
        ContextAwareKt$withContextAvailable$2$listener$1 contextAwareKt$withContextAvailable$2$listener$1 = new ContextAwareKt$withContextAvailable$2$listener$1(nVar, lVar);
        contextAware.addOnContextAvailableListener(contextAwareKt$withContextAvailable$2$listener$1);
        nVar.g(new ContextAwareKt$withContextAvailable$2$1(contextAware, contextAwareKt$withContextAvailable$2$listener$1));
        Object x4 = nVar.x();
        if (x4 == C2316b.f()) {
            h.c(eVar);
        }
        return x4;
    }

    private static final <R> Object withContextAvailable$$forInline(ContextAware contextAware, l lVar, C2308e eVar) {
        Context peekAvailableContext = contextAware.peekAvailableContext();
        if (peekAvailableContext != null) {
            return lVar.invoke(peekAvailableContext);
        }
        r.c(0);
        C2886n nVar = new C2886n(C2316b.c(eVar), 1);
        nVar.D();
        ContextAwareKt$withContextAvailable$2$listener$1 contextAwareKt$withContextAvailable$2$listener$1 = new ContextAwareKt$withContextAvailable$2$listener$1(nVar, lVar);
        contextAware.addOnContextAvailableListener(contextAwareKt$withContextAvailable$2$listener$1);
        nVar.g(new ContextAwareKt$withContextAvailable$2$1(contextAware, contextAwareKt$withContextAvailable$2$listener$1));
        J j5 = J.f19942a;
        Object x4 = nVar.x();
        if (x4 == C2316b.f()) {
            h.c(eVar);
        }
        r.c(1);
        return x4;
    }
}
