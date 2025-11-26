package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f7206a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f7207b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p.b f7208c;

    public /* synthetic */ j(o oVar, Runnable runnable, p.b bVar) {
        this.f7206a = oVar;
        this.f7207b = runnable;
        this.f7208c = bVar;
    }

    public final void run() {
        this.f7206a.f7219a.execute(new m(this.f7207b, this.f7208c));
    }
}
