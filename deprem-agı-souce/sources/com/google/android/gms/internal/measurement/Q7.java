package com.google.android.gms.internal.measurement;

import androidx.core.app.NotificationCompat;
import java.util.List;

public final class Q7 extends C1137k {

    /* renamed from: c  reason: collision with root package name */
    private final C1243v7 f5155c;

    public Q7(C1243v7 v7Var) {
        super("internal.logger");
        this.f5155c = v7Var;
        this.f5406b.put("log", new P7(this, false, true));
        this.f5406b.put(NotificationCompat.GROUP_KEY_SILENT, new C1224t6(this, NotificationCompat.GROUP_KEY_SILENT));
        ((C1137k) this.f5406b.get(NotificationCompat.GROUP_KEY_SILENT)).g("log", new P7(this, true, true));
        this.f5406b.put("unmonitored", new U6(this, "unmonitored"));
        ((C1137k) this.f5406b.get("unmonitored")).g("log", new P7(this, false, false));
    }

    public final r a(U1 u12, List list) {
        return r.f5553b0;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ C1243v7 h() {
        return this.f5155c;
    }
}
