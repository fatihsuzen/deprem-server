package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f7203a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f7204b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p.b f7205c;

    public /* synthetic */ i(o oVar, Runnable runnable, p.b bVar) {
        this.f7203a = oVar;
        this.f7204b = runnable;
        this.f7205c = bVar;
    }

    public final void run() {
        this.f7203a.f7219a.execute(new d(this.f7204b, this.f7205c));
    }
}
