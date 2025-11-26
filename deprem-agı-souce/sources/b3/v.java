package B3;

import b3.C2312i;
import w3.C2869e0;
import w3.C2882l;
import w3.I;
import w3.T;
import w3.W;

public final class v extends I implements W {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ W f17425a;

    /* renamed from: b  reason: collision with root package name */
    private final I f17426b;

    /* renamed from: c  reason: collision with root package name */
    private final String f17427c;

    public v(I i5, String str) {
        W w4;
        if (i5 instanceof W) {
            w4 = (W) i5;
        } else {
            w4 = null;
        }
        this.f17425a = w4 == null ? T.a() : w4;
        this.f17426b = i5;
        this.f17427c = str;
    }

    public void dispatch(C2312i iVar, Runnable runnable) {
        this.f17426b.dispatch(iVar, runnable);
    }

    public void dispatchYield(C2312i iVar, Runnable runnable) {
        this.f17426b.dispatchYield(iVar, runnable);
    }

    public boolean isDispatchNeeded(C2312i iVar) {
        return this.f17426b.isDispatchNeeded(iVar);
    }

    public void o(long j5, C2882l lVar) {
        this.f17425a.o(j5, lVar);
    }

    public C2869e0 q(long j5, Runnable runnable, C2312i iVar) {
        return this.f17425a.q(j5, runnable, iVar);
    }

    public String toString() {
        return this.f17427c;
    }
}
