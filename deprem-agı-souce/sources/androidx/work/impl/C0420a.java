package androidx.work.impl;

import androidx.work.impl.model.WorkGenerationalId;

/* renamed from: androidx.work.impl.a  reason: case insensitive filesystem */
public final /* synthetic */ class C0420a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Processor f530a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WorkGenerationalId f531b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f532c;

    public /* synthetic */ C0420a(Processor processor, WorkGenerationalId workGenerationalId, boolean z4) {
        this.f530a = processor;
        this.f531b = workGenerationalId;
        this.f532c = z4;
    }

    public final void run() {
        Processor.b(this.f530a, this.f531b, this.f532c);
    }
}
