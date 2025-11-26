package androidx.work.impl.constraints.controllers;

import k3.C2616a;

public final /* synthetic */ class a implements C2616a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseConstraintController f547a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseConstraintController$track$1$listener$1 f548b;

    public /* synthetic */ a(BaseConstraintController baseConstraintController, BaseConstraintController$track$1$listener$1 baseConstraintController$track$1$listener$1) {
        this.f547a = baseConstraintController;
        this.f548b = baseConstraintController$track$1$listener$1;
    }

    public final Object invoke() {
        return BaseConstraintController$track$1.invokeSuspend$lambda$0(this.f547a, this.f548b);
    }
}
