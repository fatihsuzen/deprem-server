package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.util.Log;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.internal.measurement.t0  reason: case insensitive filesystem */
public final class C1218t0 extends C1262y0 {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference f5578a = new AtomicReference();

    /* renamed from: b  reason: collision with root package name */
    private boolean f5579b;

    public static final Object r0(Bundle bundle, Class cls) {
        Object obj;
        if (bundle == null || (obj = bundle.get(CampaignEx.JSON_KEY_AD_R)) == null) {
            return null;
        }
        try {
            return cls.cast(obj);
        } catch (ClassCastException e5) {
            Log.w("AM", String.format("Unexpected object type. Expected, Received: %s, %s", new Object[]{cls.getCanonicalName(), obj.getClass().getCanonicalName()}), e5);
            throw e5;
        }
    }

    public final void W(Bundle bundle) {
        AtomicReference atomicReference = this.f5578a;
        synchronized (atomicReference) {
            try {
                atomicReference.set(bundle);
                this.f5579b = true;
                this.f5578a.notify();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String j(long j5) {
        return (String) r0(q0(j5), String.class);
    }

    public final Long k(long j5) {
        return (Long) r0(q0(j5), Long.class);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:5|6|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x000d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle q0(long r3) {
        /*
            r2 = this;
            java.util.concurrent.atomic.AtomicReference r0 = r2.f5578a
            monitor-enter(r0)
            boolean r1 = r2.f5579b     // Catch:{ all -> 0x000b }
            if (r1 != 0) goto L_0x0010
            r0.wait(r3)     // Catch:{ InterruptedException -> 0x000d }
            goto L_0x0010
        L_0x000b:
            r3 = move-exception
            goto L_0x001a
        L_0x000d:
            monitor-exit(r0)     // Catch:{ all -> 0x000b }
            r3 = 0
            return r3
        L_0x0010:
            java.util.concurrent.atomic.AtomicReference r3 = r2.f5578a     // Catch:{ all -> 0x000b }
            java.lang.Object r3 = r3.get()     // Catch:{ all -> 0x000b }
            android.os.Bundle r3 = (android.os.Bundle) r3     // Catch:{ all -> 0x000b }
            monitor-exit(r0)     // Catch:{ all -> 0x000b }
            return r3
        L_0x001a:
            monitor-exit(r0)     // Catch:{ all -> 0x000b }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C1218t0.q0(long):android.os.Bundle");
    }
}
