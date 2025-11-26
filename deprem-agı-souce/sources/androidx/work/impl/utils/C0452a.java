package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;

/* renamed from: androidx.work.impl.utils.a  reason: case insensitive filesystem */
public final /* synthetic */ class C0452a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkDatabase f746a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f747b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WorkManagerImpl f748c;

    public /* synthetic */ C0452a(WorkDatabase workDatabase, String str, WorkManagerImpl workManagerImpl) {
        this.f746a = workDatabase;
        this.f747b = str;
        this.f748c = workManagerImpl;
    }

    public final void run() {
        CancelWorkRunnable.forNameInline$lambda$5(this.f746a, this.f747b, this.f748c);
    }
}
