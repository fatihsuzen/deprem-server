package androidx.work.impl;

import androidx.work.impl.model.WorkSpec;
import java.util.List;
import java.util.Set;

public final /* synthetic */ class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkDatabase f775a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WorkSpec f776b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WorkSpec f777c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ List f778d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f779e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Set f780f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f781g;

    public /* synthetic */ x(WorkDatabase workDatabase, WorkSpec workSpec, WorkSpec workSpec2, List list, String str, Set set, boolean z4) {
        this.f775a = workDatabase;
        this.f776b = workSpec;
        this.f777c = workSpec2;
        this.f778d = list;
        this.f779e = str;
        this.f780f = set;
        this.f781g = z4;
    }

    public final void run() {
        WorkerUpdater.updateWorkImpl$lambda$3(this.f775a, this.f776b, this.f777c, this.f778d, this.f779e, this.f780f, this.f781g);
    }
}
