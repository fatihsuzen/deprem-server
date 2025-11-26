package com.google.android.gms.measurement.internal;

import K.C0665l;
import K.C0666m;
import N.C0722p;
import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.google.android.gms.common.util.p;
import com.google.android.gms.internal.measurement.C1056b;
import com.google.android.gms.internal.measurement.C1093f0;
import com.google.android.gms.internal.measurement.F0;
import com.mbridge.msdk.MBridgeConstans;
import f0.C1646a;
import f0.C1649d;
import f0.C1653h;
import f0.C1656k;
import f0.N;
import f0.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.google.android.gms.measurement.internal.z3  reason: case insensitive filesystem */
public final class C1465z3 extends C1649d {

    /* renamed from: a  reason: collision with root package name */
    private final q6 f6927a;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f6928b;

    /* renamed from: k  reason: collision with root package name */
    private String f6929k = null;

    public C1465z3(q6 q6Var, String str) {
        C0722p.k(q6Var);
        this.f6927a = q6Var;
    }

    private final void w0(G g5, B6 b6) {
        q6 q6Var = this.f6927a;
        q6Var.E();
        q6Var.k(g5, b6);
    }

    private final void x0(B6 b6, boolean z4) {
        C0722p.k(b6);
        String str = b6.f5765a;
        C0722p.e(str);
        y0(str, false);
        this.f6927a.N0().o(b6.f5766b);
    }

    private final void y0(String str, boolean z4) {
        boolean z5;
        if (!TextUtils.isEmpty(str)) {
            if (z4) {
                try {
                    if (this.f6928b == null) {
                        if (!"com.google.android.gms".equals(this.f6929k)) {
                            q6 q6Var = this.f6927a;
                            if (!p.a(q6Var.e(), Binder.getCallingUid()) && !C0666m.a(q6Var.e()).c(Binder.getCallingUid())) {
                                z5 = false;
                                this.f6928b = Boolean.valueOf(z5);
                            }
                        }
                        z5 = true;
                        this.f6928b = Boolean.valueOf(z5);
                    }
                    if (this.f6928b.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e5) {
                    this.f6927a.a().o().b("Measurement Service called with invalid calling package. appId", C1402q2.x(str));
                    throw e5;
                }
            }
            if (this.f6929k == null && C0665l.k(this.f6927a.e(), Binder.getCallingUid(), str)) {
                this.f6929k = str;
            }
            if (!str.equals(this.f6929k)) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
            }
            return;
        }
        this.f6927a.a().o().a("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }

    /* access modifiers changed from: package-private */
    public final G A0(G g5, B6 b6) {
        E e5;
        if (!(!"_cmp".equals(g5.f5883a) || (e5 = g5.f5884b) == null || e5.i() == 0)) {
            String g6 = e5.g("_cis");
            if ("referrer broadcast".equals(g6) || "referrer API".equals(g6)) {
                this.f6927a.a().u().b("Event has been filtered ", g5.toString());
                return new G("_cmpx", e5, g5.f5885c, g5.f5886d);
            }
        }
        return g5;
    }

    /* access modifiers changed from: package-private */
    public final void B0(Runnable runnable) {
        C0722p.k(runnable);
        q6 q6Var = this.f6927a;
        if (q6Var.b().p()) {
            runnable.run();
        } else {
            q6Var.b().t(runnable);
        }
    }

    public final void F(B6 b6) {
        C0722p.e(b6.f5765a);
        C0722p.k(b6.f5783s);
        j(new C1458y3(this, b6));
    }

    public final List H(B6 b6, Bundle bundle) {
        x0(b6, false);
        C0722p.k(b6.f5765a);
        q6 q6Var = this.f6927a;
        if (q6Var.B0().H((String) null, C1304d2.f6311Z0)) {
            try {
                return (List) q6Var.b().s(new C1403q3(this, b6, bundle)).get(WorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException e5) {
                this.f6927a.a().o().c("Failed to get trigger URIs. appId", C1402q2.x(b6.f5765a), e5);
                return Collections.EMPTY_LIST;
            }
        } else {
            try {
                return (List) this.f6927a.b().r(new C1409r3(this, b6, bundle)).get();
            } catch (InterruptedException | ExecutionException e6) {
                this.f6927a.a().o().c("Failed to get trigger URIs. appId", C1402q2.x(b6.f5765a), e6);
                return Collections.EMPTY_LIST;
            }
        }
    }

    public final void I(G g5, B6 b6) {
        C0722p.k(g5);
        x0(b6, false);
        B0(new C1375m3(this, g5, b6));
    }

    public final void J(B6 b6) {
        x0(b6, false);
        B0(new C1345i3(this, b6));
    }

    public final void K(B6 b6) {
        C0722p.e(b6.f5765a);
        C0722p.k(b6.f5783s);
        j(new C1416s3(this, b6));
    }

    public final void N(B6 b6, C1325g gVar) {
        x0(b6, false);
        B0(new C1444w3(this, b6, gVar));
    }

    public final byte[] O(G g5, String str) {
        C0722p.e(str);
        C0722p.k(g5);
        y0(str, true);
        q6 q6Var = this.f6927a;
        C1388o2 v5 = q6Var.a().v();
        C1352j2 M02 = q6Var.M0();
        String str2 = g5.f5883a;
        v5.b("Log and bundle. event", M02.a(str2));
        long a5 = q6Var.f().a() / 1000000;
        try {
            byte[] bArr = (byte[]) q6Var.b().s(new C1389o3(this, g5, str)).get();
            if (bArr == null) {
                q6Var.a().o().b("Log and bundle returned null. appId", C1402q2.x(str));
                bArr = new byte[0];
            }
            q6Var.a().v().d("Log and bundle processed. event, size, time_ms", q6Var.M0().a(str2), Integer.valueOf(bArr.length), Long.valueOf((q6Var.f().a() / 1000000) - a5));
            return bArr;
        } catch (InterruptedException e5) {
            e = e5;
            q6 q6Var2 = this.f6927a;
            q6Var2.a().o().d("Failed to log and bundle. appId, event, error", C1402q2.x(str), q6Var2.M0().a(g5.f5883a), e);
            return null;
        } catch (ExecutionException e6) {
            e = e6;
            q6 q6Var22 = this.f6927a;
            q6Var22.a().o().d("Failed to log and bundle. appId, event, error", C1402q2.x(str), q6Var22.M0().a(g5.f5883a), e);
            return null;
        }
    }

    public final void P(C1341i iVar) {
        C0722p.k(iVar);
        C0722p.k(iVar.f6472c);
        C0722p.e(iVar.f6470a);
        y0(iVar.f6470a, true);
        B0(new C1305d3(this, new C1341i(iVar)));
    }

    public final void S(v6 v6Var, B6 b6) {
        C0722p.k(v6Var);
        x0(b6, false);
        B0(new C1396p3(this, v6Var, b6));
    }

    public final C1646a T(B6 b6) {
        x0(b6, false);
        C0722p.e(b6.f5765a);
        try {
            return (C1646a) this.f6927a.b().s(new C1368l3(this, b6)).get(WorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e5) {
            this.f6927a.a().o().c("Failed to get consent. appId", C1402q2.x(b6.f5765a), e5);
            return new C1646a((Bundle) null);
        }
    }

    public final void U(Bundle bundle, B6 b6) {
        x0(b6, false);
        String str = b6.f5765a;
        C0722p.k(str);
        B0(new C1451x3(this, bundle, str, b6));
    }

    public final void V(B6 b6, N n5, C1656k kVar) {
        x0(b6, false);
        this.f6927a.b().t(new C1430u3(this, (String) C0722p.k(b6.f5765a), n5, kVar));
    }

    public final void X(B6 b6, Bundle bundle, C1653h hVar) {
        x0(b6, false);
        this.f6927a.b().t(new C1423t3(this, b6, bundle, hVar, (String) C0722p.k(b6.f5765a)));
    }

    public final void a0(B6 b6) {
        x0(b6, false);
        B0(new Z2(this, b6));
    }

    public final void e0(B6 b6) {
        x0(b6, false);
        B0(new C1281a3(this, b6));
    }

    public final List h0(String str, String str2, boolean z4, B6 b6) {
        x0(b6, false);
        String str3 = b6.f5765a;
        C0722p.k(str3);
        try {
            List<x6> list = (List) this.f6927a.b().r(new C1313e3(this, str3, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (x6 x6Var : list) {
                if (!z4) {
                    if (!z6.N(x6Var.f6894c)) {
                    }
                }
                arrayList.add(new v6(x6Var));
            }
            return arrayList;
        } catch (InterruptedException e5) {
            e = e5;
            this.f6927a.a().o().c("Failed to query user properties. appId", C1402q2.x(b6.f5765a), e);
            return Collections.EMPTY_LIST;
        } catch (ExecutionException e6) {
            e = e6;
            this.f6927a.a().o().c("Failed to query user properties. appId", C1402q2.x(b6.f5765a), e);
            return Collections.EMPTY_LIST;
        }
    }

    /* access modifiers changed from: package-private */
    public final void j(Runnable runnable) {
        C0722p.k(runnable);
        q6 q6Var = this.f6927a;
        if (q6Var.b().p()) {
            runnable.run();
        } else {
            q6Var.b().v(runnable);
        }
    }

    public final String j0(B6 b6) {
        x0(b6, false);
        return this.f6927a.p0(b6);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void k(B6 b6) {
        q6 q6Var = this.f6927a;
        q6Var.E();
        q6Var.P0(b6);
    }

    public final List k0(String str, String str2, B6 b6) {
        x0(b6, false);
        String str3 = b6.f5765a;
        C0722p.k(str3);
        try {
            return (List) this.f6927a.b().r(new C1329g3(this, str3, str, str2)).get();
        } catch (InterruptedException | ExecutionException e5) {
            this.f6927a.a().o().b("Failed to get conditional user properties", e5);
            return Collections.EMPTY_LIST;
        }
    }

    public final void l0(B6 b6) {
        C0722p.e(b6.f5765a);
        C0722p.k(b6.f5783s);
        j(new C1361k3(this, b6));
    }

    public final List m(String str, String str2, String str3, boolean z4) {
        y0(str, true);
        try {
            List<x6> list = (List) this.f6927a.b().r(new C1321f3(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (x6 x6Var : list) {
                if (!z4) {
                    if (!z6.N(x6Var.f6894c)) {
                    }
                }
                arrayList.add(new v6(x6Var));
            }
            return arrayList;
        } catch (InterruptedException e5) {
            e = e5;
            this.f6927a.a().o().c("Failed to get user properties as. appId", C1402q2.x(str), e);
            return Collections.EMPTY_LIST;
        } catch (ExecutionException e6) {
            e = e6;
            this.f6927a.a().o().c("Failed to get user properties as. appId", C1402q2.x(str), e);
            return Collections.EMPTY_LIST;
        }
    }

    public final List n0(B6 b6, boolean z4) {
        x0(b6, false);
        String str = b6.f5765a;
        C0722p.k(str);
        try {
            List<x6> list = (List) this.f6927a.b().r(new Y2(this, str)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (x6 x6Var : list) {
                if (!z4) {
                    if (!z6.N(x6Var.f6894c)) {
                    }
                }
                arrayList.add(new v6(x6Var));
            }
            return arrayList;
        } catch (InterruptedException e5) {
            e = e5;
            this.f6927a.a().o().c("Failed to get user properties. appId", C1402q2.x(b6.f5765a), e);
            return null;
        } catch (ExecutionException e6) {
            e = e6;
            this.f6927a.a().o().c("Failed to get user properties. appId", C1402q2.x(b6.f5765a), e);
            return null;
        }
    }

    public final void p(C1341i iVar, B6 b6) {
        C0722p.k(iVar);
        C0722p.k(iVar.f6472c);
        x0(b6, false);
        C1341i iVar2 = new C1341i(iVar);
        iVar2.f6470a = b6.f5765a;
        B0(new C1297c3(this, iVar2, b6));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void q0(B6 b6) {
        q6 q6Var = this.f6927a;
        q6Var.E();
        q6Var.Q0(b6);
    }

    public final void r(G g5, String str, String str2) {
        C0722p.k(g5);
        C0722p.e(str);
        y0(str, true);
        B0(new C1382n3(this, g5, str));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void r0(B6 b6, Bundle bundle, C1653h hVar, String str) {
        q6 q6Var = this.f6927a;
        q6Var.E();
        try {
            hVar.g0(q6Var.q0(b6, bundle));
        } catch (RemoteException e5) {
            this.f6927a.a().o().c("Failed to return trigger URIs for app", str, e5);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x00a5, code lost:
        if (r0.f().currentTimeMillis() >= (r2.h() + java.lang.Math.min(((java.lang.Long) com.google.android.gms.measurement.internal.C1304d2.f6370x.b((java.lang.Object) null)).longValue() * (1 << (r4 - 1)), ((java.lang.Long) com.google.android.gms.measurement.internal.C1304d2.f6372y.b((java.lang.Object) null)).longValue()))) goto L_0x00a7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void s0(java.lang.String r11, f0.N r12, f0.C1656k r13) {
        /*
            r10 = this;
            com.google.android.gms.measurement.internal.q6 r0 = r10.f6927a
            r0.E()
            com.google.android.gms.measurement.internal.T2 r1 = r0.b()
            r1.h()
            r0.O0()
            com.google.android.gms.measurement.internal.u r1 = r0.F0()
            com.google.android.gms.measurement.internal.c2 r2 = com.google.android.gms.measurement.internal.C1304d2.f6262B
            r3 = 0
            java.lang.Object r2 = r2.b(r3)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            java.util.List r12 = r1.o(r11, r12, r2)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r12 = r12.iterator()
        L_0x002d:
            boolean r2 = r12.hasNext()
            if (r2 == 0) goto L_0x0137
            java.lang.Object r2 = r12.next()
            com.google.android.gms.measurement.internal.t6 r2 = (com.google.android.gms.measurement.internal.t6) r2
            java.lang.String r4 = r2.e()
            boolean r4 = r0.t(r11, r4)
            if (r4 != 0) goto L_0x005d
            com.google.android.gms.measurement.internal.q2 r4 = r0.a()
            com.google.android.gms.measurement.internal.o2 r4 = r4.w()
            long r5 = r2.c()
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
            java.lang.String r2 = r2.e()
            java.lang.String r6 = "[sgtm] batch skipped due to destination in backoff. appId, rowId, url"
            r4.d(r6, r11, r5, r2)
            goto L_0x002d
        L_0x005d:
            int r4 = r2.i()
            if (r4 > 0) goto L_0x0064
            goto L_0x00a7
        L_0x0064:
            com.google.android.gms.measurement.internal.c2 r5 = com.google.android.gms.measurement.internal.C1304d2.f6374z
            java.lang.Object r5 = r5.b(r3)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            if (r4 <= r5) goto L_0x0074
            goto L_0x0118
        L_0x0074:
            com.google.android.gms.measurement.internal.c2 r5 = com.google.android.gms.measurement.internal.C1304d2.f6370x
            java.lang.Object r5 = r5.b(r3)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            int r4 = r4 + -1
            r7 = 1
            long r7 = r7 << r4
            long r5 = r5 * r7
            com.google.android.gms.measurement.internal.c2 r4 = com.google.android.gms.measurement.internal.C1304d2.f6372y
            java.lang.Object r4 = r4.b(r3)
            java.lang.Long r4 = (java.lang.Long) r4
            long r7 = r4.longValue()
            long r4 = java.lang.Math.min(r5, r7)
            com.google.android.gms.common.util.d r6 = r0.f()
            long r6 = r6.currentTimeMillis()
            long r8 = r2.h()
            long r8 = r8 + r4
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 < 0) goto L_0x0118
        L_0x00a7:
            com.google.android.gms.measurement.internal.X5 r2 = r2.b()
            com.google.android.gms.internal.measurement.V2 r4 = com.google.android.gms.internal.measurement.Y2.M()     // Catch:{ n5 -> 0x0109 }
            byte[] r5 = r2.f6169b     // Catch:{ n5 -> 0x0109 }
            com.google.android.gms.internal.measurement.E5 r4 = com.google.android.gms.measurement.internal.u6.W(r4, r5)     // Catch:{ n5 -> 0x0109 }
            com.google.android.gms.internal.measurement.V2 r4 = (com.google.android.gms.internal.measurement.V2) r4     // Catch:{ n5 -> 0x0109 }
            r5 = 0
        L_0x00b8:
            int r6 = r4.s()     // Catch:{ n5 -> 0x0109 }
            if (r5 >= r6) goto L_0x00d9
            com.google.android.gms.internal.measurement.a3 r6 = r4.t(r5)     // Catch:{ n5 -> 0x0109 }
            com.google.android.gms.internal.measurement.c5 r6 = r6.q()     // Catch:{ n5 -> 0x0109 }
            com.google.android.gms.internal.measurement.Z2 r6 = (com.google.android.gms.internal.measurement.Z2) r6     // Catch:{ n5 -> 0x0109 }
            com.google.android.gms.common.util.d r7 = r0.f()     // Catch:{ n5 -> 0x0109 }
            long r7 = r7.currentTimeMillis()     // Catch:{ n5 -> 0x0109 }
            r6.c1(r7)     // Catch:{ n5 -> 0x0109 }
            r4.w(r5, r6)     // Catch:{ n5 -> 0x0109 }
            int r5 = r5 + 1
            goto L_0x00b8
        L_0x00d9:
            com.google.android.gms.internal.measurement.e5 r5 = r4.o()     // Catch:{ n5 -> 0x0109 }
            com.google.android.gms.internal.measurement.Y2 r5 = (com.google.android.gms.internal.measurement.Y2) r5     // Catch:{ n5 -> 0x0109 }
            byte[] r5 = r5.e()     // Catch:{ n5 -> 0x0109 }
            r2.f6169b = r5     // Catch:{ n5 -> 0x0109 }
            com.google.android.gms.measurement.internal.q2 r5 = r0.a()     // Catch:{ n5 -> 0x0109 }
            java.lang.String r5 = r5.z()     // Catch:{ n5 -> 0x0109 }
            r6 = 2
            boolean r5 = android.util.Log.isLoggable(r5, r6)     // Catch:{ n5 -> 0x0109 }
            if (r5 == 0) goto L_0x0104
            com.google.android.gms.measurement.internal.u6 r5 = r0.K0()     // Catch:{ n5 -> 0x0109 }
            com.google.android.gms.internal.measurement.e5 r4 = r4.o()     // Catch:{ n5 -> 0x0109 }
            com.google.android.gms.internal.measurement.Y2 r4 = (com.google.android.gms.internal.measurement.Y2) r4     // Catch:{ n5 -> 0x0109 }
            java.lang.String r4 = r5.K(r4)     // Catch:{ n5 -> 0x0109 }
            r2.f6174g = r4     // Catch:{ n5 -> 0x0109 }
        L_0x0104:
            r1.add(r2)
            goto L_0x002d
        L_0x0109:
            com.google.android.gms.measurement.internal.q2 r2 = r0.a()
            com.google.android.gms.measurement.internal.o2 r2 = r2.r()
            java.lang.String r4 = "Failed to parse queued batch. appId"
            r2.b(r4, r11)
            goto L_0x002d
        L_0x0118:
            com.google.android.gms.measurement.internal.q2 r4 = r0.a()
            com.google.android.gms.measurement.internal.o2 r4 = r4.w()
            long r5 = r2.c()
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
            long r6 = r2.h()
            java.lang.Long r2 = java.lang.Long.valueOf(r6)
            java.lang.String r6 = "[sgtm] batch skipped waiting for next retry. appId, rowId, lastUploadMillis"
            r4.d(r6, r11, r5, r2)
            goto L_0x002d
        L_0x0137:
            com.google.android.gms.measurement.internal.Z5 r12 = new com.google.android.gms.measurement.internal.Z5
            r12.<init>(r1)
            r13.b0(r12)     // Catch:{ RemoteException -> 0x0159 }
            com.google.android.gms.measurement.internal.q6 r13 = r10.f6927a     // Catch:{ RemoteException -> 0x0159 }
            com.google.android.gms.measurement.internal.q2 r13 = r13.a()     // Catch:{ RemoteException -> 0x0159 }
            com.google.android.gms.measurement.internal.o2 r13 = r13.w()     // Catch:{ RemoteException -> 0x0159 }
            java.lang.String r0 = "[sgtm] Sending queued upload batches to client. appId, count"
            java.util.List r12 = r12.f6203a     // Catch:{ RemoteException -> 0x0159 }
            int r12 = r12.size()     // Catch:{ RemoteException -> 0x0159 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ RemoteException -> 0x0159 }
            r13.c(r0, r11, r12)     // Catch:{ RemoteException -> 0x0159 }
            return
        L_0x0159:
            r12 = move-exception
            com.google.android.gms.measurement.internal.q6 r13 = r10.f6927a
            com.google.android.gms.measurement.internal.q2 r13 = r13.a()
            com.google.android.gms.measurement.internal.o2 r13 = r13.o()
            java.lang.String r0 = "[sgtm] Failed to return upload batches for app"
            r13.c(r0, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1465z3.s0(java.lang.String, f0.N, f0.k):void");
    }

    public final void t(long j5, String str, String str2, String str3) {
        String str4 = str2;
        String str5 = str3;
        B0(new C1289b3(this, str4, str5, str, j5));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void t0(B6 b6, C1325g gVar) {
        q6 q6Var = this.f6927a;
        q6Var.E();
        q6Var.r0((String) C0722p.k(b6.f5765a), gVar);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void u0(Bundle bundle, String str, B6 b6) {
        q6 q6Var = this.f6927a;
        boolean H4 = q6Var.B0().H((String) null, C1304d2.f6305W0);
        if (!bundle.isEmpty() || !H4) {
            C1426u F02 = q6Var.F0();
            F02.h();
            F02.j();
            byte[] e5 = F02.f6129b.K0().J(new B(F02.f5730a, "", str, "dep", 0, 0, bundle)).e();
            X2 x22 = F02.f5730a;
            x22.a().w().c("Saving default event parameters, appId, data size", str, Integer.valueOf(e5.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put(MBridgeConstans.APP_ID, str);
            contentValues.put("parameters", e5);
            try {
                if (F02.u0().insertWithOnConflict("default_event_params", (String) null, contentValues, 5) == -1) {
                    x22.a().o().b("Failed to insert default event parameters (got -1). appId", C1402q2.x(str));
                }
            } catch (SQLiteException e6) {
                F02.f5730a.a().o().c("Error storing default event parameters. appId", C1402q2.x(str), e6);
            }
            q6 q6Var2 = this.f6927a;
            C1426u F03 = q6Var2.F0();
            long j5 = b6.f5763D;
            if (F03.H(str, j5)) {
                q6Var2.F0().I(str, Long.valueOf(j5), (String) null, bundle);
                return;
            }
            return;
        }
        C1426u F04 = this.f6927a.F0();
        F04.h();
        F04.j();
        try {
            F04.u0().execSQL("delete from default_event_params where app_id=?", new String[]{str});
        } catch (SQLiteException e7) {
            F04.f5730a.a().o().b("Error clearing default event params", e7);
        }
    }

    public final void v(B6 b6) {
        String str = b6.f5765a;
        C0722p.e(str);
        y0(str, false);
        B0(new C1353j3(this, b6));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ q6 v0() {
        return this.f6927a;
    }

    public final List y(String str, String str2, String str3) {
        y0(str, true);
        try {
            return (List) this.f6927a.b().r(new C1337h3(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e5) {
            this.f6927a.a().o().b("Failed to get conditional user properties as", e5);
            return Collections.EMPTY_LIST;
        }
    }

    /* access modifiers changed from: package-private */
    public final void z0(G g5, B6 b6) {
        C1093f0 f0Var;
        q6 q6Var = this.f6927a;
        P2 D02 = q6Var.D0();
        String str = b6.f5765a;
        if (TextUtils.isEmpty(str)) {
            f0Var = null;
        } else {
            f0Var = (C1093f0) D02.f6022j.get(str);
        }
        if (f0Var != null) {
            try {
                Map Z4 = q6Var.K0().Z(g5.f5884b.j(), true);
                String str2 = g5.f5883a;
                String a5 = x.a(str2);
                if (a5 != null) {
                    str2 = a5;
                }
                if (f0Var.b(new C1056b(str2, g5.f5886d, Z4))) {
                    if (f0Var.c()) {
                        q6 q6Var2 = this.f6927a;
                        q6Var2.a().w().b("EES edited event", g5.f5883a);
                        w0(q6Var2.K0().m(f0Var.e().c()), b6);
                    } else {
                        w0(g5, b6);
                    }
                    if (f0Var.d()) {
                        for (C1056b bVar : f0Var.e().f()) {
                            q6 q6Var3 = this.f6927a;
                            q6Var3.a().w().b("EES logging created event", bVar.b());
                            w0(q6Var3.K0().m(bVar), b6);
                        }
                        return;
                    }
                    return;
                }
            } catch (F0 unused) {
                this.f6927a.a().o().c("EES error. appId, eventName", b6.f5766b, g5.f5883a);
            }
            this.f6927a.a().w().b("EES was not applied to event", g5.f5883a);
            w0(g5, b6);
            return;
        }
        this.f6927a.a().w().b("EES not loaded for", b6.f5765a);
        w0(g5, b6);
    }
}
