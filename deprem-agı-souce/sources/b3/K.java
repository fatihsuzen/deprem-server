package B3;

import b3.C2312i;
import k3.p;
import kotlin.jvm.internal.t;
import w3.U0;

public abstract class K {

    /* renamed from: a  reason: collision with root package name */
    public static final D f17373a = new D("NO_THREAD_ELEMENTS");

    /* renamed from: b  reason: collision with root package name */
    private static final p f17374b = new H();

    /* renamed from: c  reason: collision with root package name */
    private static final p f17375c = new I();

    /* renamed from: d  reason: collision with root package name */
    private static final p f17376d = new J();

    /* access modifiers changed from: private */
    public static final Object d(Object obj, C2312i.b bVar) {
        Integer num;
        int i5;
        if (!(bVar instanceof U0)) {
            return obj;
        }
        if (obj instanceof Integer) {
            num = (Integer) obj;
        } else {
            num = null;
        }
        if (num != null) {
            i5 = num.intValue();
        } else {
            i5 = 1;
        }
        if (i5 == 0) {
            return bVar;
        }
        return Integer.valueOf(i5 + 1);
    }

    /* access modifiers changed from: private */
    public static final U0 e(U0 u02, C2312i.b bVar) {
        if (u02 != null) {
            return u02;
        }
        if (bVar instanceof U0) {
            return (U0) bVar;
        }
        return null;
    }

    public static final void f(C2312i iVar, Object obj) {
        if (obj != f17373a) {
            if (obj instanceof Q) {
                ((Q) obj).b(iVar);
                return;
            }
            Object fold = iVar.fold((Object) null, f17375c);
            t.c(fold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            ((U0) fold).u(iVar, obj);
        }
    }

    public static final Object g(C2312i iVar) {
        Object fold = iVar.fold(0, f17374b);
        t.b(fold);
        return fold;
    }

    /* access modifiers changed from: private */
    public static final Q h(Q q5, C2312i.b bVar) {
        if (bVar instanceof U0) {
            U0 u02 = (U0) bVar;
            q5.a(u02, u02.x(q5.f17383a));
        }
        return q5;
    }

    public static final Object i(C2312i iVar, Object obj) {
        if (obj == null) {
            obj = g(iVar);
        }
        if (obj == 0) {
            return f17373a;
        }
        if (obj instanceof Integer) {
            return iVar.fold(new Q(iVar, ((Number) obj).intValue()), f17376d);
        }
        t.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((U0) obj).x(iVar);
    }
}
