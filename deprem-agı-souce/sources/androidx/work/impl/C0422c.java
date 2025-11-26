package androidx.work.impl;

import n0.C1722d;

/* renamed from: androidx.work.impl.c  reason: case insensitive filesystem */
public final /* synthetic */ class C0422c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Processor f538a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C1722d f539b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WorkerWrapper f540c;

    public /* synthetic */ C0422c(Processor processor, C1722d dVar, WorkerWrapper workerWrapper) {
        this.f538a = processor;
        this.f539b = dVar;
        this.f540c = workerWrapper;
    }

    public final void run() {
        Processor.c(this.f538a, this.f539b, this.f540c);
    }
}
