package A3;

import W2.J;
import W2.t;
import b3.C2308e;
import java.util.Arrays;
import kotlin.jvm.internal.t;

public abstract class b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public d[] f17264a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f17265b;

    /* renamed from: c  reason: collision with root package name */
    private int f17266c;

    /* access modifiers changed from: protected */
    public final d e() {
        d dVar;
        synchronized (this) {
            try {
                d[] dVarArr = this.f17264a;
                if (dVarArr == null) {
                    dVarArr = g(2);
                    this.f17264a = dVarArr;
                } else if (this.f17265b >= dVarArr.length) {
                    Object[] copyOf = Arrays.copyOf(dVarArr, dVarArr.length * 2);
                    t.d(copyOf, "copyOf(...)");
                    this.f17264a = (d[]) copyOf;
                    dVarArr = (d[]) copyOf;
                }
                int i5 = this.f17266c;
                do {
                    dVar = dVarArr[i5];
                    if (dVar == null) {
                        dVar = f();
                        dVarArr[i5] = dVar;
                    }
                    i5++;
                    if (i5 >= dVarArr.length) {
                        i5 = 0;
                    }
                    t.c(dVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                } while (!dVar.a(this));
                this.f17266c = i5;
                this.f17265b++;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    /* access modifiers changed from: protected */
    public abstract d f();

    /* access modifiers changed from: protected */
    public abstract d[] g(int i5);

    /* access modifiers changed from: protected */
    public final void h(d dVar) {
        int i5;
        C2308e[] b5;
        synchronized (this) {
            try {
                int i6 = this.f17265b - 1;
                this.f17265b = i6;
                if (i6 == 0) {
                    this.f17266c = 0;
                }
                t.c(dVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                b5 = dVar.b(this);
            } catch (Throwable th) {
                throw th;
            }
        }
        for (C2308e eVar : b5) {
            if (eVar != null) {
                t.a aVar = W2.t.f19966b;
                eVar.resumeWith(W2.t.b(J.f19942a));
            }
        }
    }

    /* access modifiers changed from: protected */
    public final int i() {
        return this.f17265b;
    }

    /* access modifiers changed from: protected */
    public final d[] j() {
        return this.f17264a;
    }
}
