package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.O2;
import j$.util.Objects;

final class J6 {

    /* renamed from: a  reason: collision with root package name */
    private O2 f5940a;

    /* renamed from: b  reason: collision with root package name */
    private Long f5941b;

    /* renamed from: c  reason: collision with root package name */
    private long f5942c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ C1309e f5943d;

    /* synthetic */ J6(C1309e eVar, byte[] bArr) {
        Objects.requireNonNull(eVar);
        this.f5943d = eVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: java.lang.String} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f1, code lost:
        if (r4 == null) goto L_0x0099;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01d1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.O2 a(java.lang.String r18, com.google.android.gms.internal.measurement.O2 r19) {
        /*
            r17 = this;
            r1 = r17
            r3 = r18
            r8 = r19
            java.lang.String r0 = r8.I()
            java.util.List r9 = r8.F()
            com.google.android.gms.measurement.internal.e r2 = r1.f5943d
            com.google.android.gms.measurement.internal.q6 r4 = r2.f6129b
            r4.K0()
            java.lang.String r5 = "_eid"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.u6.u(r8, r5)
            java.lang.Long r6 = (java.lang.Long) r6
            if (r6 == 0) goto L_0x0215
            java.lang.String r7 = "_ep"
            boolean r7 = r0.equals(r7)
            r10 = 0
            if (r7 == 0) goto L_0x01d5
            N.C0722p.k(r6)
            r4.K0()
            java.lang.String r0 = "_en"
            java.lang.Object r0 = com.google.android.gms.measurement.internal.u6.u(r8, r0)
            r12 = r0
            java.lang.String r12 = (java.lang.String) r12
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            r7 = 0
            if (r0 == 0) goto L_0x004f
            com.google.android.gms.measurement.internal.X2 r0 = r2.f5730a
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()
            com.google.android.gms.measurement.internal.o2 r0 = r0.p()
            java.lang.String r2 = "Extra parameter without an event name. eventId"
            r0.b(r2, r6)
            return r7
        L_0x004f:
            com.google.android.gms.internal.measurement.O2 r0 = r1.f5940a
            if (r0 == 0) goto L_0x0065
            java.lang.Long r0 = r1.f5941b
            if (r0 == 0) goto L_0x0065
            long r13 = r6.longValue()
            java.lang.Long r0 = r1.f5941b
            long r15 = r0.longValue()
            int r0 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r0 == 0) goto L_0x011b
        L_0x0065:
            com.google.android.gms.measurement.internal.u r2 = r4.F0()
            r2.h()
            r2.j()
            android.database.sqlite.SQLiteDatabase r0 = r2.u0()     // Catch:{ SQLiteException -> 0x00e0, all -> 0x00dd }
            java.lang.String r4 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            java.lang.String r13 = r6.toString()     // Catch:{ SQLiteException -> 0x00e0, all -> 0x00dd }
            java.lang.String[] r13 = new java.lang.String[]{r3, r13}     // Catch:{ SQLiteException -> 0x00e0, all -> 0x00dd }
            android.database.Cursor r4 = r0.rawQuery(r4, r13)     // Catch:{ SQLiteException -> 0x00e0, all -> 0x00dd }
            boolean r0 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x009d }
            if (r0 != 0) goto L_0x009f
            com.google.android.gms.measurement.internal.X2 r0 = r2.f5730a     // Catch:{ SQLiteException -> 0x009d }
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()     // Catch:{ SQLiteException -> 0x009d }
            com.google.android.gms.measurement.internal.o2 r0 = r0.w()     // Catch:{ SQLiteException -> 0x009d }
            java.lang.String r13 = "Main event not found"
            r0.a(r13)     // Catch:{ SQLiteException -> 0x009d }
        L_0x0096:
            r4.close()
        L_0x0099:
            r0 = r7
            goto L_0x00f4
        L_0x009b:
            r0 = move-exception
            goto L_0x00da
        L_0x009d:
            r0 = move-exception
            goto L_0x00e2
        L_0x009f:
            r0 = 0
            byte[] r0 = r4.getBlob(r0)     // Catch:{ SQLiteException -> 0x009d }
            r13 = 1
            long r13 = r4.getLong(r13)     // Catch:{ SQLiteException -> 0x009d }
            java.lang.Long r13 = java.lang.Long.valueOf(r13)     // Catch:{ SQLiteException -> 0x009d }
            com.google.android.gms.internal.measurement.N2 r14 = com.google.android.gms.internal.measurement.O2.P()     // Catch:{ IOException -> 0x00c5 }
            com.google.android.gms.internal.measurement.E5 r0 = com.google.android.gms.measurement.internal.u6.W(r14, r0)     // Catch:{ IOException -> 0x00c5 }
            com.google.android.gms.internal.measurement.N2 r0 = (com.google.android.gms.internal.measurement.N2) r0     // Catch:{ IOException -> 0x00c5 }
            com.google.android.gms.internal.measurement.e5 r0 = r0.o()     // Catch:{ IOException -> 0x00c5 }
            com.google.android.gms.internal.measurement.O2 r0 = (com.google.android.gms.internal.measurement.O2) r0     // Catch:{ IOException -> 0x00c5 }
            android.util.Pair r0 = android.util.Pair.create(r0, r13)     // Catch:{ SQLiteException -> 0x009d }
            r4.close()
            goto L_0x00f4
        L_0x00c5:
            r0 = move-exception
            com.google.android.gms.measurement.internal.X2 r13 = r2.f5730a     // Catch:{ SQLiteException -> 0x009d }
            com.google.android.gms.measurement.internal.q2 r13 = r13.a()     // Catch:{ SQLiteException -> 0x009d }
            com.google.android.gms.measurement.internal.o2 r13 = r13.o()     // Catch:{ SQLiteException -> 0x009d }
            java.lang.String r14 = "Failed to merge main event. appId, eventId"
            java.lang.Object r15 = com.google.android.gms.measurement.internal.C1402q2.x(r3)     // Catch:{ SQLiteException -> 0x009d }
            r13.d(r14, r15, r6, r0)     // Catch:{ SQLiteException -> 0x009d }
            goto L_0x0096
        L_0x00da:
            r7 = r4
            goto L_0x01cf
        L_0x00dd:
            r0 = move-exception
            goto L_0x01cf
        L_0x00e0:
            r0 = move-exception
            r4 = r7
        L_0x00e2:
            com.google.android.gms.measurement.internal.X2 r2 = r2.f5730a     // Catch:{ all -> 0x009b }
            com.google.android.gms.measurement.internal.q2 r2 = r2.a()     // Catch:{ all -> 0x009b }
            com.google.android.gms.measurement.internal.o2 r2 = r2.o()     // Catch:{ all -> 0x009b }
            java.lang.String r13 = "Error selecting main event"
            r2.b(r13, r0)     // Catch:{ all -> 0x009b }
            if (r4 == 0) goto L_0x0099
            goto L_0x0096
        L_0x00f4:
            if (r0 == 0) goto L_0x01bd
            java.lang.Object r2 = r0.first
            if (r2 != 0) goto L_0x00fc
            goto L_0x01bd
        L_0x00fc:
            com.google.android.gms.internal.measurement.O2 r2 = (com.google.android.gms.internal.measurement.O2) r2
            r1.f5940a = r2
            java.lang.Object r0 = r0.second
            java.lang.Long r0 = (java.lang.Long) r0
            long r13 = r0.longValue()
            r1.f5942c = r13
            com.google.android.gms.measurement.internal.e r0 = r1.f5943d
            com.google.android.gms.measurement.internal.q6 r0 = r0.f6129b
            r0.K0()
            com.google.android.gms.internal.measurement.O2 r0 = r1.f5940a
            java.lang.Object r0 = com.google.android.gms.measurement.internal.u6.u(r0, r5)
            java.lang.Long r0 = (java.lang.Long) r0
            r1.f5941b = r0
        L_0x011b:
            long r4 = r1.f5942c
            r13 = -1
            long r4 = r4 + r13
            r1.f5942c = r4
            int r0 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r0 > 0) goto L_0x015f
            com.google.android.gms.measurement.internal.e r0 = r1.f5943d
            com.google.android.gms.measurement.internal.q6 r0 = r0.f6129b
            com.google.android.gms.measurement.internal.u r2 = r0.F0()
            r2.h()
            com.google.android.gms.measurement.internal.X2 r0 = r2.f5730a
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()
            com.google.android.gms.measurement.internal.o2 r0 = r0.w()
            java.lang.String r4 = "Clearing complex main event info. appId"
            r0.b(r4, r3)
            android.database.sqlite.SQLiteDatabase r0 = r2.u0()     // Catch:{ SQLiteException -> 0x014e }
            java.lang.String r4 = "delete from main_event_params where app_id=?"
            java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch:{ SQLiteException -> 0x014e }
            r0.execSQL(r4, r3)     // Catch:{ SQLiteException -> 0x014e }
            goto L_0x016f
        L_0x014e:
            r0 = move-exception
            com.google.android.gms.measurement.internal.X2 r2 = r2.f5730a
            com.google.android.gms.measurement.internal.q2 r2 = r2.a()
            com.google.android.gms.measurement.internal.o2 r2 = r2.o()
            java.lang.String r3 = "Error clearing complex main event"
            r2.b(r3, r0)
            goto L_0x016f
        L_0x015f:
            com.google.android.gms.measurement.internal.e r0 = r1.f5943d
            com.google.android.gms.measurement.internal.q6 r0 = r0.f6129b
            com.google.android.gms.measurement.internal.u r2 = r0.F0()
            r4 = r6
            long r5 = r1.f5942c
            com.google.android.gms.internal.measurement.O2 r7 = r1.f5940a
            r2.F(r3, r4, r5, r7)
        L_0x016f:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.google.android.gms.internal.measurement.O2 r2 = r1.f5940a
            java.util.List r2 = r2.F()
            java.util.Iterator r2 = r2.iterator()
        L_0x017e:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x019f
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.S2 r3 = (com.google.android.gms.internal.measurement.S2) r3
            com.google.android.gms.measurement.internal.e r4 = r1.f5943d
            com.google.android.gms.measurement.internal.q6 r4 = r4.f6129b
            r4.K0()
            java.lang.String r4 = r3.G()
            com.google.android.gms.internal.measurement.S2 r4 = com.google.android.gms.measurement.internal.u6.r(r8, r4)
            if (r4 != 0) goto L_0x017e
            r0.add(r3)
            goto L_0x017e
        L_0x019f:
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x01aa
            r0.addAll(r9)
            r9 = r0
            goto L_0x01bb
        L_0x01aa:
            com.google.android.gms.measurement.internal.e r0 = r1.f5943d
            com.google.android.gms.measurement.internal.X2 r0 = r0.f5730a
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()
            com.google.android.gms.measurement.internal.o2 r0 = r0.p()
            java.lang.String r2 = "No unique parameters in main event. eventName"
            r0.b(r2, r12)
        L_0x01bb:
            r0 = r12
            goto L_0x0215
        L_0x01bd:
            com.google.android.gms.measurement.internal.e r0 = r1.f5943d
            com.google.android.gms.measurement.internal.X2 r0 = r0.f5730a
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()
            com.google.android.gms.measurement.internal.o2 r0 = r0.p()
            java.lang.String r2 = "Extra parameter without existing main event. eventName, eventId"
            r0.c(r2, r12, r6)
            return r7
        L_0x01cf:
            if (r7 == 0) goto L_0x01d4
            r7.close()
        L_0x01d4:
            throw r0
        L_0x01d5:
            r1.f5941b = r6
            r1.f5940a = r8
            r4.K0()
            java.lang.Long r3 = java.lang.Long.valueOf(r10)
            java.lang.String r5 = "_epc"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.u6.v(r8, r5, r3)
            java.lang.Long r3 = (java.lang.Long) r3
            long r12 = r3.longValue()
            r1.f5942c = r12
            int r3 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r3 > 0) goto L_0x0202
            com.google.android.gms.measurement.internal.X2 r2 = r2.f5730a
            com.google.android.gms.measurement.internal.q2 r2 = r2.a()
            com.google.android.gms.measurement.internal.o2 r2 = r2.p()
            java.lang.String r3 = "Complex event with zero extra param count. eventName"
            r2.b(r3, r0)
            goto L_0x0215
        L_0x0202:
            com.google.android.gms.measurement.internal.u r2 = r4.F0()
            java.lang.Object r3 = N.C0722p.k(r6)
            r4 = r3
            java.lang.Long r4 = (java.lang.Long) r4
            long r5 = r1.f5942c
            r3 = r18
            r7 = r8
            r2.F(r3, r4, r5, r7)
        L_0x0215:
            com.google.android.gms.internal.measurement.c5 r2 = r19.q()
            com.google.android.gms.internal.measurement.N2 r2 = (com.google.android.gms.internal.measurement.N2) r2
            r2.E(r0)
            r2.B()
            r2.A(r9)
            com.google.android.gms.internal.measurement.e5 r0 = r2.o()
            com.google.android.gms.internal.measurement.O2 r0 = (com.google.android.gms.internal.measurement.O2) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.J6.a(java.lang.String, com.google.android.gms.internal.measurement.O2):com.google.android.gms.internal.measurement.O2");
    }
}
