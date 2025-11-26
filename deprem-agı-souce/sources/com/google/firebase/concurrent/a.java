package com.google.firebase.concurrent;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f7174a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f7175b;

    public /* synthetic */ a(b bVar, Runnable runnable) {
        this.f7174a = bVar;
        this.f7175b = runnable;
    }

    public final void run() {
        b.a(this.f7174a, this.f7175b);
    }
}
