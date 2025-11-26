package c3;

import W2.u;
import b3.C2308e;
import b3.C2312i;
import b3.C2313j;
import k3.p;
import k3.q;
import kotlin.coroutines.jvm.internal.h;
import kotlin.coroutines.jvm.internal.j;
import kotlin.jvm.internal.S;
import kotlin.jvm.internal.t;

abstract class c {

    public static final class a extends j {

        /* renamed from: a  reason: collision with root package name */
        private int f20810a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ p f20811b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f20812c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(C2308e eVar, p pVar, Object obj) {
            super(eVar);
            this.f20811b = pVar;
            this.f20812c = obj;
            t.c(eVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        /* access modifiers changed from: protected */
        public Object invokeSuspend(Object obj) {
            int i5 = this.f20810a;
            if (i5 == 0) {
                this.f20810a = 1;
                u.b(obj);
                t.c(this.f20811b, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                return ((p) S.c(this.f20811b, 2)).invoke(this.f20812c, this);
            } else if (i5 == 1) {
                this.f20810a = 2;
                u.b(obj);
                return obj;
            } else {
                throw new IllegalStateException("This coroutine had already completed");
            }
        }
    }

    public static final class b extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        private int f20813a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ p f20814b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f20815c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(C2308e eVar, C2312i iVar, p pVar, Object obj) {
            super(eVar, iVar);
            this.f20814b = pVar;
            this.f20815c = obj;
            t.c(eVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        /* access modifiers changed from: protected */
        public Object invokeSuspend(Object obj) {
            int i5 = this.f20813a;
            if (i5 == 0) {
                this.f20813a = 1;
                u.b(obj);
                t.c(this.f20814b, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                return ((p) S.c(this.f20814b, 2)).invoke(this.f20815c, this);
            } else if (i5 == 1) {
                this.f20813a = 2;
                u.b(obj);
                return obj;
            } else {
                throw new IllegalStateException("This coroutine had already completed");
            }
        }
    }

    /* renamed from: c3.c$c  reason: collision with other inner class name */
    public static final class C0212c extends j {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0212c(C2308e eVar) {
            super(eVar);
            t.c(eVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        /* access modifiers changed from: protected */
        public Object invokeSuspend(Object obj) {
            u.b(obj);
            return obj;
        }
    }

    public static final class d extends kotlin.coroutines.jvm.internal.d {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(C2308e eVar, C2312i iVar) {
            super(eVar, iVar);
            t.c(eVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        /* access modifiers changed from: protected */
        public Object invokeSuspend(Object obj) {
            u.b(obj);
            return obj;
        }
    }

    public static C2308e a(p pVar, Object obj, C2308e eVar) {
        t.e(pVar, "<this>");
        t.e(eVar, "completion");
        C2308e a5 = h.a(eVar);
        if (pVar instanceof kotlin.coroutines.jvm.internal.a) {
            return ((kotlin.coroutines.jvm.internal.a) pVar).create(obj, a5);
        }
        C2312i context = a5.getContext();
        if (context == C2313j.f20794a) {
            return new a(a5, pVar, obj);
        }
        return new b(a5, context, pVar, obj);
    }

    private static final C2308e b(C2308e eVar) {
        C2312i context = eVar.getContext();
        if (context == C2313j.f20794a) {
            return new C0212c(eVar);
        }
        return new d(eVar, context);
    }

    public static C2308e c(C2308e eVar) {
        kotlin.coroutines.jvm.internal.d dVar;
        C2308e intercepted;
        t.e(eVar, "<this>");
        if (eVar instanceof kotlin.coroutines.jvm.internal.d) {
            dVar = (kotlin.coroutines.jvm.internal.d) eVar;
        } else {
            dVar = null;
        }
        if (dVar == null || (intercepted = dVar.intercepted()) == null) {
            return eVar;
        }
        return intercepted;
    }

    public static Object d(p pVar, Object obj, C2308e eVar) {
        t.e(pVar, "<this>");
        t.e(eVar, "completion");
        return ((p) S.c(pVar, 2)).invoke(obj, b(h.a(eVar)));
    }

    public static Object e(q qVar, Object obj, Object obj2, C2308e eVar) {
        t.e(qVar, "<this>");
        t.e(eVar, "completion");
        return ((q) S.c(qVar, 3)).invoke(obj, obj2, b(h.a(eVar)));
    }
}
