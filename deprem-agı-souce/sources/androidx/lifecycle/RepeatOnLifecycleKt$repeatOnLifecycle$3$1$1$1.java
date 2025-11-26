package androidx.lifecycle;

import F3.a;
import W2.J;
import W2.t;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import b3.C2308e;
import b3.C2312i;
import java.util.concurrent.CancellationException;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.t;
import w3.C2882l;
import w3.C2908y0;
import w3.M;
import w3.O;

final class RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1 implements LifecycleEventObserver {
    final /* synthetic */ M $$this$coroutineScope;
    final /* synthetic */ p $block;
    final /* synthetic */ Lifecycle.Event $cancelWorkEvent;
    final /* synthetic */ C2882l $cont;
    final /* synthetic */ L $launchedJob;
    final /* synthetic */ a $mutex;
    final /* synthetic */ Lifecycle.Event $startWorkEvent;

    @f(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1", f = "RepeatOnLifecycle.kt", l = {165, 110}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends l implements p {
        Object L$0;
        Object L$1;
        int label;

        public final C2308e create(Object obj, C2308e eVar) {
            return new AnonymousClass1(aVar, pVar, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x003f, code lost:
            if (r7.lock((java.lang.Object) null, r6) == r0) goto L_0x0053;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r6.label
                r2 = 2
                r3 = 1
                r4 = 0
                if (r1 == 0) goto L_0x002e
                if (r1 == r3) goto L_0x0021
                if (r1 != r2) goto L_0x0019
                java.lang.Object r0 = r6.L$0
                F3.a r0 = (F3.a) r0
                W2.u.b(r7)     // Catch:{ all -> 0x0017 }
                goto L_0x0055
            L_0x0017:
                r7 = move-exception
                goto L_0x0061
            L_0x0019:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L_0x0021:
                java.lang.Object r1 = r6.L$1
                k3.p r1 = (k3.p) r1
                java.lang.Object r3 = r6.L$0
                F3.a r3 = (F3.a) r3
                W2.u.b(r7)
                r7 = r3
                goto L_0x0042
            L_0x002e:
                W2.u.b(r7)
                F3.a r7 = r9
                k3.p r1 = r2
                r6.L$0 = r7
                r6.L$1 = r1
                r6.label = r3
                java.lang.Object r3 = r7.lock(r4, r6)
                if (r3 != r0) goto L_0x0042
                goto L_0x0053
            L_0x0042:
                androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 r3 = new androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1     // Catch:{ all -> 0x005d }
                r3.<init>(r1, r4)     // Catch:{ all -> 0x005d }
                r6.L$0 = r7     // Catch:{ all -> 0x005d }
                r6.L$1 = r4     // Catch:{ all -> 0x005d }
                r6.label = r2     // Catch:{ all -> 0x005d }
                java.lang.Object r1 = w3.N.d(r3, r6)     // Catch:{ all -> 0x005d }
                if (r1 != r0) goto L_0x0054
            L_0x0053:
                return r0
            L_0x0054:
                r0 = r7
            L_0x0055:
                W2.J r7 = W2.J.f19942a     // Catch:{ all -> 0x0017 }
                r0.unlock(r4)
                W2.J r7 = W2.J.f19942a
                return r7
            L_0x005d:
                r0 = move-exception
                r5 = r0
                r0 = r7
                r7 = r5
            L_0x0061:
                r0.unlock(r4)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((AnonymousClass1) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1(Lifecycle.Event event, L l5, M m5, Lifecycle.Event event2, C2882l lVar, a aVar, p pVar) {
        this.$startWorkEvent = event;
        this.$launchedJob = l5;
        this.$$this$coroutineScope = m5;
        this.$cancelWorkEvent = event2;
        this.$cont = lVar;
        this.$mutex = aVar;
        this.$block = pVar;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        t.e(lifecycleOwner, "<unused var>");
        t.e(event, NotificationCompat.CATEGORY_EVENT);
        if (event == this.$startWorkEvent) {
            L l5 = this.$launchedJob;
            M m5 = this.$$this$coroutineScope;
            final a aVar = this.$mutex;
            final p pVar = this.$block;
            l5.f24690a = C2876i.d(m5, (C2312i) null, (O) null, new AnonymousClass1((C2308e) null), 3, (Object) null);
            return;
        }
        if (event == this.$cancelWorkEvent) {
            C2908y0 y0Var = (C2908y0) this.$launchedJob.f24690a;
            if (y0Var != null) {
                C2908y0.a.a(y0Var, (CancellationException) null, 1, (Object) null);
            }
            this.$launchedJob.f24690a = null;
        }
        if (event == Lifecycle.Event.ON_DESTROY) {
            C2882l lVar = this.$cont;
            t.a aVar2 = W2.t.f19966b;
            lVar.resumeWith(W2.t.b(J.f19942a));
        }
    }
}
