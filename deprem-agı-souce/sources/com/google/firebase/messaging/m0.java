package com.google.firebase.messaging;

import java.util.concurrent.ScheduledFuture;
import k0.C1692f;
import k0.C1698l;

public final /* synthetic */ class m0 implements C1692f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ScheduledFuture f7455a;

    public /* synthetic */ m0(ScheduledFuture scheduledFuture) {
        this.f7455a = scheduledFuture;
    }

    public final void a(C1698l lVar) {
        this.f7455a.cancel(false);
    }
}
