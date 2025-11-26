package androidx.work.impl.constraints;

import k3.l;
import w3.C2908y0;
import y3.v;

public final /* synthetic */ class b implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C2908y0 f544a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ v f545b;

    public /* synthetic */ b(C2908y0 y0Var, v vVar) {
        this.f544a = y0Var;
        this.f545b = vVar;
    }

    public final Object invoke(Object obj) {
        return NetworkRequestConstraintController$track$1.invokeSuspend$lambda$0(this.f544a, this.f545b, (ConstraintsState) obj);
    }
}
