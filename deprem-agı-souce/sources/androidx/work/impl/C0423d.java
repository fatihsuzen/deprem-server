package androidx.work.impl;

import androidx.work.Configuration;
import androidx.work.impl.model.WorkGenerationalId;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: androidx.work.impl.d  reason: case insensitive filesystem */
public final /* synthetic */ class C0423d implements ExecutionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Executor f553a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f554b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Configuration f555c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ WorkDatabase f556d;

    public /* synthetic */ C0423d(Executor executor, List list, Configuration configuration, WorkDatabase workDatabase) {
        this.f553a = executor;
        this.f554b = list;
        this.f555c = configuration;
        this.f556d = workDatabase;
    }

    public final void onExecuted(WorkGenerationalId workGenerationalId, boolean z4) {
        this.f553a.execute(new C0424e(this.f554b, workGenerationalId, this.f555c, this.f556d));
    }
}
