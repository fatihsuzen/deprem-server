package androidx.work.impl.utils;

import android.content.Context;
import androidx.work.ForegroundInfo;
import java.util.UUID;
import k3.C2616a;

public final /* synthetic */ class B implements C2616a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkForegroundUpdater f739a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UUID f740b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ForegroundInfo f741c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Context f742d;

    public /* synthetic */ B(WorkForegroundUpdater workForegroundUpdater, UUID uuid, ForegroundInfo foregroundInfo, Context context) {
        this.f739a = workForegroundUpdater;
        this.f740b = uuid;
        this.f741c = foregroundInfo;
        this.f742d = context;
    }

    public final Object invoke() {
        return WorkForegroundUpdater.a(this.f739a, this.f740b, this.f741c, this.f742d);
    }
}
