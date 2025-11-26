package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;
import java.util.concurrent.Callable;

public final /* synthetic */ class k implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f7209a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Callable f7210b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p.b f7211c;

    public /* synthetic */ k(o oVar, Callable callable, p.b bVar) {
        this.f7209a = oVar;
        this.f7210b = callable;
        this.f7211c = bVar;
    }

    public final Object call() {
        return this.f7209a.f7219a.submit(new n(this.f7210b, this.f7211c));
    }
}
