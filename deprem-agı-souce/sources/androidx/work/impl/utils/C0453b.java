package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;

/* renamed from: androidx.work.impl.utils.b  reason: case insensitive filesystem */
public final /* synthetic */ class C0453b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkDatabase f749a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f750b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WorkManagerImpl f751c;

    public /* synthetic */ C0453b(WorkDatabase workDatabase, String str, WorkManagerImpl workManagerImpl) {
        this.f749a = workDatabase;
        this.f750b = str;
        this.f751c = workManagerImpl;
    }

    public final void run() {
        CancelWorkRunnable.forTag$lambda$3$lambda$2(this.f749a, this.f750b, this.f751c);
    }
}
