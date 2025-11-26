package w3;

import b3.C2312i;

public final class a1 extends I {

    /* renamed from: a  reason: collision with root package name */
    public static final a1 f26269a = new a1();

    private a1() {
    }

    public void dispatch(C2312i iVar, Runnable runnable) {
        e1 e1Var = (e1) iVar.get(e1.f26280b);
        if (e1Var != null) {
            e1Var.f26281a = true;
            return;
        }
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }

    public boolean isDispatchNeeded(C2312i iVar) {
        return false;
    }

    public I limitedParallelism(int i5, String str) {
        throw new UnsupportedOperationException("limitedParallelism is not supported for Dispatchers.Unconfined");
    }

    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
