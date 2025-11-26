package androidx.lifecycle;

import W2.J;
import b3.C2312i;
import b3.C2313j;
import k3.p;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import w3.C2865c0;
import w3.C2908y0;
import w3.N;
import w3.T0;

public final class CoroutineLiveData<T> extends MediatorLiveData<T> {
    private BlockRunner<T> blockRunner;
    private EmittedSource emittedSource;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CoroutineLiveData(C2312i iVar, long j5, p pVar, int i5, C2633k kVar) {
        this((i5 & 1) != 0 ? C2313j.f20794a : iVar, (i5 & 2) != 0 ? 5000 : j5, pVar);
    }

    /* access modifiers changed from: private */
    public static final J _init_$lambda$0(CoroutineLiveData coroutineLiveData) {
        coroutineLiveData.blockRunner = null;
        return J.f19942a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object clearSource$lifecycle_livedata_release(b3.C2308e r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.lifecycle.CoroutineLiveData$clearSource$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            androidx.lifecycle.CoroutineLiveData$clearSource$1 r0 = (androidx.lifecycle.CoroutineLiveData$clearSource$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.lifecycle.CoroutineLiveData$clearSource$1 r0 = new androidx.lifecycle.CoroutineLiveData$clearSource$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            W2.u.b(r5)
            goto L_0x0041
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0031:
            W2.u.b(r5)
            androidx.lifecycle.EmittedSource r5 = r4.emittedSource
            if (r5 == 0) goto L_0x0041
            r0.label = r3
            java.lang.Object r5 = r5.disposeNow(r0)
            if (r5 != r1) goto L_0x0041
            return r1
        L_0x0041:
            r5 = 0
            r4.emittedSource = r5
            W2.J r5 = W2.J.f19942a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.CoroutineLiveData.clearSource$lifecycle_livedata_release(b3.e):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0047, code lost:
        if (clearSource$lifecycle_livedata_release(r0) == r1) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0053, code lost:
        if (r7 != r1) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0055, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object emitSource$lifecycle_livedata_release(androidx.lifecycle.LiveData<T> r6, b3.C2308e r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.lifecycle.CoroutineLiveData$emitSource$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            androidx.lifecycle.CoroutineLiveData$emitSource$1 r0 = (androidx.lifecycle.CoroutineLiveData$emitSource$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.lifecycle.CoroutineLiveData$emitSource$1 r0 = new androidx.lifecycle.CoroutineLiveData$emitSource$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            W2.u.b(r7)
            goto L_0x0056
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0034:
            java.lang.Object r6 = r0.L$0
            androidx.lifecycle.LiveData r6 = (androidx.lifecycle.LiveData) r6
            W2.u.b(r7)
            goto L_0x004a
        L_0x003c:
            W2.u.b(r7)
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r5.clearSource$lifecycle_livedata_release(r0)
            if (r7 != r1) goto L_0x004a
            goto L_0x0055
        L_0x004a:
            r7 = 0
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r7 = androidx.lifecycle.CoroutineLiveDataKt.addDisposableSource(r5, r6, r0)
            if (r7 != r1) goto L_0x0056
        L_0x0055:
            return r1
        L_0x0056:
            androidx.lifecycle.EmittedSource r7 = (androidx.lifecycle.EmittedSource) r7
            r5.emittedSource = r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.CoroutineLiveData.emitSource$lifecycle_livedata_release(androidx.lifecycle.LiveData, b3.e):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public void onActive() {
        super.onActive();
        BlockRunner<T> blockRunner2 = this.blockRunner;
        if (blockRunner2 != null) {
            blockRunner2.maybeRun();
        }
    }

    /* access modifiers changed from: protected */
    public void onInactive() {
        super.onInactive();
        BlockRunner<T> blockRunner2 = this.blockRunner;
        if (blockRunner2 != null) {
            blockRunner2.cancel();
        }
    }

    public CoroutineLiveData(C2312i iVar, long j5, p pVar) {
        t.e(iVar, "context");
        t.e(pVar, "block");
        long j6 = j5;
        p pVar2 = pVar;
        this.blockRunner = new BlockRunner<>(this, pVar2, j6, N.a(C2865c0.c().F().plus(iVar).plus(T0.a((C2908y0) iVar.get(C2908y0.f26320k0)))), new d(this));
    }
}
