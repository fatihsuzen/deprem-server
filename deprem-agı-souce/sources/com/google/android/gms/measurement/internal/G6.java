package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;

public final class G6 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private final X2 f5904a;

    public G6(X2 x22) {
        this.f5904a = x22;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a() {
        this.f5904a.N().o(((Long) C1304d2.f6266D.b((Object) null)).longValue());
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onReceive(android.content.Context r3, android.content.Intent r4) {
        /*
            r2 = this;
            if (r4 != 0) goto L_0x0012
            com.google.android.gms.measurement.internal.X2 r3 = r2.f5904a
            com.google.android.gms.measurement.internal.q2 r3 = r3.a()
            com.google.android.gms.measurement.internal.o2 r3 = r3.r()
            java.lang.String r4 = "App receiver called with null intent"
            r3.a(r4)
            return
        L_0x0012:
            java.lang.String r3 = r4.getAction()
            if (r3 != 0) goto L_0x0028
            com.google.android.gms.measurement.internal.X2 r3 = r2.f5904a
            com.google.android.gms.measurement.internal.q2 r3 = r3.a()
            com.google.android.gms.measurement.internal.o2 r3 = r3.r()
            java.lang.String r4 = "App receiver called with null action"
            r3.a(r4)
            return
        L_0x0028:
            int r4 = r3.hashCode()
            r0 = -1928239649(0xffffffff8d1165df, float:-4.4804198E-31)
            r1 = 1
            if (r4 == r0) goto L_0x0042
            r0 = 1279883384(0x4c497878, float:5.2814304E7)
            if (r4 == r0) goto L_0x0038
            goto L_0x004c
        L_0x0038:
            java.lang.String r4 = "com.google.android.gms.measurement.BATCHES_AVAILABLE"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x004c
            r3 = r1
            goto L_0x004d
        L_0x0042:
            java.lang.String r4 = "com.google.android.gms.measurement.TRIGGERS_AVAILABLE"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x004c
            r3 = 0
            goto L_0x004d
        L_0x004c:
            r3 = -1
        L_0x004d:
            if (r3 == 0) goto L_0x007d
            if (r3 == r1) goto L_0x0061
            com.google.android.gms.measurement.internal.X2 r3 = r2.f5904a
            com.google.android.gms.measurement.internal.q2 r3 = r3.a()
            com.google.android.gms.measurement.internal.o2 r3 = r3.r()
            java.lang.String r4 = "App receiver called with unknown action"
            r3.a(r4)
            return
        L_0x0061:
            com.google.android.gms.measurement.internal.X2 r3 = r2.f5904a
            com.google.android.gms.measurement.internal.q2 r4 = r3.a()
            com.google.android.gms.measurement.internal.o2 r4 = r4.w()
            java.lang.String r0 = "[sgtm] App Receiver notified batches are available"
            r4.a(r0)
            com.google.android.gms.measurement.internal.T2 r3 = r3.b()
            com.google.android.gms.measurement.internal.D6 r4 = new com.google.android.gms.measurement.internal.D6
            r4.<init>(r2)
            r3.t(r4)
            return
        L_0x007d:
            com.google.android.gms.measurement.internal.X2 r3 = r2.f5904a
            com.google.android.gms.internal.measurement.C1145k7.a()
            com.google.android.gms.measurement.internal.m r4 = r3.w()
            r0 = 0
            com.google.android.gms.measurement.internal.c2 r1 = com.google.android.gms.measurement.internal.C1304d2.f6295R0
            boolean r4 = r4.H(r0, r1)
            if (r4 != 0) goto L_0x0090
            return
        L_0x0090:
            com.google.android.gms.measurement.internal.q2 r4 = r3.a()
            com.google.android.gms.measurement.internal.o2 r4 = r4.w()
            java.lang.String r0 = "App receiver notified triggers are available"
            r4.a(r0)
            com.google.android.gms.measurement.internal.T2 r4 = r3.b()
            com.google.android.gms.measurement.internal.E6 r0 = new com.google.android.gms.measurement.internal.E6
            r0.<init>(r3)
            r4.t(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.G6.onReceive(android.content.Context, android.content.Intent):void");
    }
}
