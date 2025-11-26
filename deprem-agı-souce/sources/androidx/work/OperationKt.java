package androidx.work;

import W2.J;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.concurrent.futures.ListenableFutureKt;
import androidx.lifecycle.MutableLiveData;
import androidx.work.Operation;
import b3.C2308e;
import java.util.concurrent.Executor;
import k3.C2616a;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;
import n0.C1722d;

public final class OperationKt {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object await(androidx.work.Operation r4, b3.C2308e r5) {
        /*
            boolean r0 = r5 instanceof androidx.work.OperationKt$await$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            androidx.work.OperationKt$await$1 r0 = (androidx.work.OperationKt$await$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.work.OperationKt$await$1 r0 = new androidx.work.OperationKt$await$1
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            W2.u.b(r5)
            goto L_0x0046
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            W2.u.b(r5)
            n0.d r4 = r4.getResult()
            java.lang.String r5 = "getResult(...)"
            kotlin.jvm.internal.t.d(r4, r5)
            r0.label = r3
            java.lang.Object r5 = androidx.concurrent.futures.ListenableFutureKt.await(r4, r0)
            if (r5 != r1) goto L_0x0046
            return r1
        L_0x0046:
            java.lang.String r4 = "await(...)"
            kotlin.jvm.internal.t.d(r5, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.OperationKt.await(androidx.work.Operation, b3.e):java.lang.Object");
    }

    private static final Object await$$forInline(Operation operation, C2308e eVar) {
        C1722d result = operation.getResult();
        t.d(result, "getResult(...)");
        r.c(0);
        Object await = ListenableFutureKt.await(result, eVar);
        r.c(1);
        t.d(await, "await(...)");
        return await;
    }

    public static final Operation launchOperation(Tracer tracer, String str, Executor executor, C2616a aVar) {
        t.e(tracer, "tracer");
        t.e(str, "label");
        t.e(executor, "executor");
        t.e(aVar, "block");
        MutableLiveData mutableLiveData = new MutableLiveData(Operation.IN_PROGRESS);
        C1722d future = CallbackToFutureAdapter.getFuture(new h(executor, tracer, str, aVar, mutableLiveData));
        t.d(future, "getFuture(...)");
        return new OperationImpl(mutableLiveData, future);
    }

    /* access modifiers changed from: private */
    public static final J launchOperation$lambda$2(Executor executor, Tracer tracer, String str, C2616a aVar, MutableLiveData mutableLiveData, CallbackToFutureAdapter.Completer completer) {
        t.e(completer, "completer");
        executor.execute(new i(tracer, str, aVar, mutableLiveData, completer));
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final void launchOperation$lambda$2$lambda$1(Tracer tracer, String str, C2616a aVar, MutableLiveData mutableLiveData, CallbackToFutureAdapter.Completer completer) {
        boolean isEnabled = tracer.isEnabled();
        if (isEnabled) {
            try {
                tracer.beginSection(str);
            } catch (Throwable th) {
                if (isEnabled) {
                    tracer.endSection();
                }
                throw th;
            }
        }
        aVar.invoke();
        Operation.State.SUCCESS success = Operation.SUCCESS;
        mutableLiveData.postValue(success);
        completer.set(success);
        J j5 = J.f19942a;
        if (isEnabled) {
            tracer.endSection();
        }
    }
}
