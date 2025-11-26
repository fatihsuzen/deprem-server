package androidx.work.impl.utils;

import androidx.work.Data;
import java.util.UUID;
import k3.C2616a;

public final /* synthetic */ class C implements C2616a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkProgressUpdater f743a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UUID f744b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Data f745c;

    public /* synthetic */ C(WorkProgressUpdater workProgressUpdater, UUID uuid, Data data) {
        this.f743a = workProgressUpdater;
        this.f744b = uuid;
        this.f745c = data;
    }

    public final Object invoke() {
        return WorkProgressUpdater.a(this.f743a, this.f744b, this.f745c);
    }
}
