package androidx.lifecycle;

import W2.J;
import W2.u;
import androidx.lifecycle.Lifecycle;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.C2865c0;
import w3.C2872g;
import w3.I0;
import w3.M;

@f(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", l = {83}, m = "invokeSuspend")
final class RepeatOnLifecycleKt$repeatOnLifecycle$3 extends l implements p {
    final /* synthetic */ p $block;
    final /* synthetic */ Lifecycle.State $state;
    final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
    private /* synthetic */ Object L$0;
    int label;

    @f(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", l = {161}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1  reason: invalid class name */
    static final class AnonymousClass1 extends l implements p {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        public final C2308e create(Object obj, C2308e eVar) {
            return new AnonymousClass1(lifecycle, state, m5, pVar, eVar);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: kotlin.jvm.internal.L} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: kotlin.jvm.internal.L} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                r13 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r13.label
                r2 = 0
                r3 = 1
                if (r1 == 0) goto L_0x0037
                if (r1 != r3) goto L_0x002f
                java.lang.Object r0 = r13.L$5
                k3.p r0 = (k3.p) r0
                java.lang.Object r0 = r13.L$4
                w3.M r0 = (w3.M) r0
                java.lang.Object r0 = r13.L$3
                androidx.lifecycle.Lifecycle r0 = (androidx.lifecycle.Lifecycle) r0
                java.lang.Object r0 = r13.L$2
                androidx.lifecycle.Lifecycle$State r0 = (androidx.lifecycle.Lifecycle.State) r0
                java.lang.Object r0 = r13.L$1
                r1 = r0
                kotlin.jvm.internal.L r1 = (kotlin.jvm.internal.L) r1
                java.lang.Object r0 = r13.L$0
                r4 = r0
                kotlin.jvm.internal.L r4 = (kotlin.jvm.internal.L) r4
                W2.u.b(r14)     // Catch:{ all -> 0x002b }
                goto L_0x00a9
            L_0x002b:
                r0 = move-exception
                r14 = r0
                goto L_0x00c0
            L_0x002f:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r0)
                throw r14
            L_0x0037:
                W2.u.b(r14)
                androidx.lifecycle.Lifecycle r14 = r4
                androidx.lifecycle.Lifecycle$State r14 = r14.getCurrentState()
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.DESTROYED
                if (r14 != r1) goto L_0x0047
                W2.J r14 = W2.J.f19942a
                return r14
            L_0x0047:
                kotlin.jvm.internal.L r6 = new kotlin.jvm.internal.L
                r6.<init>()
                kotlin.jvm.internal.L r1 = new kotlin.jvm.internal.L
                r1.<init>()
                androidx.lifecycle.Lifecycle$State r14 = r5     // Catch:{ all -> 0x00a1 }
                androidx.lifecycle.Lifecycle r12 = r4     // Catch:{ all -> 0x00a1 }
                w3.M r7 = r6     // Catch:{ all -> 0x00a1 }
                k3.p r11 = r7     // Catch:{ all -> 0x00a1 }
                r13.L$0 = r6     // Catch:{ all -> 0x00a1 }
                r13.L$1 = r1     // Catch:{ all -> 0x00a1 }
                r13.L$2 = r14     // Catch:{ all -> 0x00a1 }
                r13.L$3 = r12     // Catch:{ all -> 0x00a1 }
                r13.L$4 = r7     // Catch:{ all -> 0x00a1 }
                r13.L$5 = r11     // Catch:{ all -> 0x00a1 }
                r13.label = r3     // Catch:{ all -> 0x00a1 }
                w3.n r9 = new w3.n     // Catch:{ all -> 0x00a1 }
                b3.e r4 = c3.C2316b.c(r13)     // Catch:{ all -> 0x00a1 }
                r9.<init>(r4, r3)     // Catch:{ all -> 0x00a1 }
                r9.D()     // Catch:{ all -> 0x00a1 }
                androidx.lifecycle.Lifecycle$Event$Companion r4 = androidx.lifecycle.Lifecycle.Event.Companion     // Catch:{ all -> 0x00a1 }
                androidx.lifecycle.Lifecycle$Event r5 = r4.upTo(r14)     // Catch:{ all -> 0x00a1 }
                androidx.lifecycle.Lifecycle$Event r8 = r4.downFrom(r14)     // Catch:{ all -> 0x00a1 }
                r14 = 0
                F3.a r10 = F3.g.b(r14, r3, r2)     // Catch:{ all -> 0x00a1 }
                androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1 r4 = new androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1     // Catch:{ all -> 0x00a1 }
                r4.<init>(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x00a1 }
                r1.f24690a = r4     // Catch:{ all -> 0x00a1 }
                java.lang.String r14 = "null cannot be cast to non-null type androidx.lifecycle.LifecycleEventObserver"
                kotlin.jvm.internal.t.c(r4, r14)     // Catch:{ all -> 0x00a1 }
                androidx.lifecycle.LifecycleEventObserver r4 = (androidx.lifecycle.LifecycleEventObserver) r4     // Catch:{ all -> 0x00a1 }
                r12.addObserver(r4)     // Catch:{ all -> 0x00a1 }
                java.lang.Object r14 = r9.x()     // Catch:{ all -> 0x00a1 }
                java.lang.Object r4 = c3.C2316b.f()     // Catch:{ all -> 0x00a1 }
                if (r14 != r4) goto L_0x00a5
                kotlin.coroutines.jvm.internal.h.c(r13)     // Catch:{ all -> 0x00a1 }
                goto L_0x00a5
            L_0x00a1:
                r0 = move-exception
                r14 = r0
                r4 = r6
                goto L_0x00c0
            L_0x00a5:
                if (r14 != r0) goto L_0x00a8
                return r0
            L_0x00a8:
                r4 = r6
            L_0x00a9:
                java.lang.Object r14 = r4.f24690a
                w3.y0 r14 = (w3.C2908y0) r14
                if (r14 == 0) goto L_0x00b2
                w3.C2908y0.a.a(r14, r2, r3, r2)
            L_0x00b2:
                java.lang.Object r14 = r1.f24690a
                androidx.lifecycle.LifecycleEventObserver r14 = (androidx.lifecycle.LifecycleEventObserver) r14
                if (r14 == 0) goto L_0x00bd
                androidx.lifecycle.Lifecycle r0 = r4
                r0.removeObserver(r14)
            L_0x00bd:
                W2.J r14 = W2.J.f19942a
                return r14
            L_0x00c0:
                java.lang.Object r0 = r4.f24690a
                w3.y0 r0 = (w3.C2908y0) r0
                if (r0 == 0) goto L_0x00c9
                w3.C2908y0.a.a(r0, r2, r3, r2)
            L_0x00c9:
                java.lang.Object r0 = r1.f24690a
                androidx.lifecycle.LifecycleEventObserver r0 = (androidx.lifecycle.LifecycleEventObserver) r0
                if (r0 == 0) goto L_0x00d4
                androidx.lifecycle.Lifecycle r1 = r4
                r1.removeObserver(r0)
            L_0x00d4:
                throw r14
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((AnonymousClass1) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RepeatOnLifecycleKt$repeatOnLifecycle$3(Lifecycle lifecycle, Lifecycle.State state, p pVar, C2308e eVar) {
        super(2, eVar);
        this.$this_repeatOnLifecycle = lifecycle;
        this.$state = state;
        this.$block = pVar;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        RepeatOnLifecycleKt$repeatOnLifecycle$3 repeatOnLifecycleKt$repeatOnLifecycle$3 = new RepeatOnLifecycleKt$repeatOnLifecycle$3(this.$this_repeatOnLifecycle, this.$state, this.$block, eVar);
        repeatOnLifecycleKt$repeatOnLifecycle$3.L$0 = obj;
        return repeatOnLifecycleKt$repeatOnLifecycle$3;
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            final M m5 = (M) this.L$0;
            I0 F4 = C2865c0.c().F();
            final Lifecycle lifecycle = this.$this_repeatOnLifecycle;
            final Lifecycle.State state = this.$state;
            final p pVar = this.$block;
            AnonymousClass1 r32 = new AnonymousClass1((C2308e) null);
            this.label = 1;
            if (C2872g.g(F4, r32, this) == f5) {
                return f5;
            }
        } else if (i5 == 1) {
            u.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return J.f19942a;
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((RepeatOnLifecycleKt$repeatOnLifecycle$3) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
