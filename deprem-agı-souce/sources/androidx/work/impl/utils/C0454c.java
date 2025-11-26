package androidx.work.impl.utils;

import androidx.work.impl.WorkManagerImpl;
import k3.C2616a;

/* renamed from: androidx.work.impl.utils.c  reason: case insensitive filesystem */
public final /* synthetic */ class C0454c implements C2616a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkManagerImpl f752a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f753b;

    public /* synthetic */ C0454c(WorkManagerImpl workManagerImpl, String str) {
        this.f752a = workManagerImpl;
        this.f753b = str;
    }

    public final Object invoke() {
        return CancelWorkRunnable.forTag$lambda$3(this.f752a, this.f753b);
    }
}
