package androidx.work.impl;

import androidx.work.ListenableWorker;
import k3.l;

public final /* synthetic */ class C implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ListenableWorker f523a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f524b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f525c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ WorkerWrapper f526d;

    public /* synthetic */ C(ListenableWorker listenableWorker, boolean z4, String str, WorkerWrapper workerWrapper) {
        this.f523a = listenableWorker;
        this.f524b = z4;
        this.f525c = str;
        this.f526d = workerWrapper;
    }

    public final Object invoke(Object obj) {
        return WorkerWrapper.runWorker$lambda$4(this.f523a, this.f524b, this.f525c, this.f526d, (Throwable) obj);
    }
}
