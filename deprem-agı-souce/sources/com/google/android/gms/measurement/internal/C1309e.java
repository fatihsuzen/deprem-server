package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.measurement.internal.e  reason: case insensitive filesystem */
final class C1309e extends C1292b6 {

    /* renamed from: d  reason: collision with root package name */
    private String f6384d;

    /* renamed from: e  reason: collision with root package name */
    private Set f6385e;

    /* renamed from: f  reason: collision with root package name */
    private Map f6386f;

    /* renamed from: g  reason: collision with root package name */
    private Long f6387g;

    /* renamed from: h  reason: collision with root package name */
    private Long f6388h;

    C1309e(q6 q6Var) {
        super(q6Var);
    }

    private final I6 n(Integer num) {
        if (this.f6386f.containsKey(num)) {
            return (I6) this.f6386f.get(num);
        }
        I6 i6 = new I6(this, this.f6384d, (byte[]) null);
        this.f6386f.put(num, i6);
        return i6;
    }

    private final boolean o(int i5, int i6) {
        I6 i62 = (I6) this.f6386f.get(Integer.valueOf(i5));
        if (i62 == null) {
            return false;
        }
        return i62.c().get(i6);
    }

    /* access modifiers changed from: protected */
    public final boolean l() {
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v1, resolved type: com.google.android.gms.measurement.internal.C} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v2, resolved type: com.google.android.gms.internal.measurement.f3} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v6, resolved type: com.google.android.gms.internal.measurement.f3} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v13, resolved type: com.google.android.gms.measurement.internal.C} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v14, resolved type: com.google.android.gms.measurement.internal.C} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v15, resolved type: com.google.android.gms.measurement.internal.C} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v25, resolved type: java.util.Iterator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v16, resolved type: com.google.android.gms.measurement.internal.C} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v17, resolved type: com.google.android.gms.measurement.internal.C} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v32, resolved type: java.util.Iterator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v18, resolved type: com.google.android.gms.internal.measurement.f3} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v61, resolved type: androidx.collection.ArrayMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v19, resolved type: com.google.android.gms.measurement.internal.C} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v1, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v2, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v3, resolved type: java.util.Iterator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v4, resolved type: java.util.Iterator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v5, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v6, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v7, resolved type: java.util.Iterator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v8, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v37, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v9, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v10, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v11, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v12, resolved type: java.util.Iterator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v13, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v14, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v38, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v15, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v16, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v17, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v18, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v19, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v20, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v21, resolved type: com.google.android.gms.measurement.internal.C} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v21, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v22, resolved type: com.google.android.gms.measurement.internal.C} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v22, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v23, resolved type: com.google.android.gms.measurement.internal.C} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v11, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v12, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v23, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v24, resolved type: com.google.android.gms.measurement.internal.C} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v24, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v31, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v25, resolved type: com.google.android.gms.measurement.internal.C} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v26, resolved type: com.google.android.gms.measurement.internal.C} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v15, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v32, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v27, resolved type: com.google.android.gms.measurement.internal.C} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v33, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v34, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v61, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v28, resolved type: com.google.android.gms.measurement.internal.C} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v16, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v35, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v17, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v29, resolved type: com.google.android.gms.measurement.internal.C} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v18, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v36, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v19, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v30, resolved type: com.google.android.gms.measurement.internal.C} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v31, resolved type: com.google.android.gms.measurement.internal.C} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v32, resolved type: com.google.android.gms.measurement.internal.C} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v63, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v24, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v64, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v33, resolved type: com.google.android.gms.internal.measurement.f3} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: androidx.collection.ArrayMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v38, resolved type: com.google.android.gms.internal.measurement.f3} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v10, resolved type: androidx.collection.ArrayMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v39, resolved type: com.google.android.gms.measurement.internal.C} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v40, resolved type: com.google.android.gms.internal.measurement.f3} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v49, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v51, resolved type: com.google.android.gms.measurement.internal.C} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v52, resolved type: com.google.android.gms.measurement.internal.C} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v53, resolved type: com.google.android.gms.measurement.internal.C} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v54, resolved type: com.google.android.gms.measurement.internal.C} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v55, resolved type: com.google.android.gms.measurement.internal.C} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v56, resolved type: com.google.android.gms.measurement.internal.C} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v57, resolved type: com.google.android.gms.measurement.internal.C} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v58, resolved type: com.google.android.gms.measurement.internal.C} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v57, resolved type: java.util.Iterator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v58, resolved type: java.util.Iterator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v59, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v60, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v48, resolved type: java.util.Iterator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v46, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v58, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v59, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v63, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v64, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v59, resolved type: com.google.android.gms.measurement.internal.C} */
    /* JADX WARNING: type inference failed for: r8v26, types: [java.util.Iterator] */
    /* JADX WARNING: type inference failed for: r5v24, types: [java.util.Iterator] */
    /* JADX WARNING: type inference failed for: r18v14 */
    /* JADX WARNING: type inference failed for: r3v62 */
    /* JADX WARNING: type inference failed for: r18v20 */
    /* JADX WARNING: type inference failed for: r18v21 */
    /* JADX WARNING: type inference failed for: r18v22, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r18v23 */
    /* JADX WARNING: type inference failed for: r18v25, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r18v26 */
    /* JADX WARNING: type inference failed for: r18v27 */
    /* JADX WARNING: type inference failed for: r18v28 */
    /* JADX WARNING: type inference failed for: r18v29 */
    /* JADX WARNING: type inference failed for: r22v34 */
    /* JADX WARNING: type inference failed for: r18v47 */
    /* JADX WARNING: type inference failed for: r18v48 */
    /* JADX WARNING: type inference failed for: r18v49 */
    /* JADX WARNING: type inference failed for: r5v51 */
    /* JADX WARNING: type inference failed for: r18v61 */
    /* JADX WARNING: type inference failed for: r18v62 */
    /* JADX WARNING: type inference failed for: r18v65 */
    /* JADX WARNING: type inference failed for: r18v66 */
    /* JADX WARNING: type inference failed for: r18v67 */
    /* JADX WARNING: type inference failed for: r18v68 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x02e5, code lost:
        if (r6 == null) goto L_0x02e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:274:0x066a, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:275:0x066b, code lost:
        r18 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:289:0x06a1, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:290:0x06a2, code lost:
        r18 = r3;
        r22 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:292:0x06a9, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:293:0x06ab, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:297:0x06b3, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:302:0x06cb, code lost:
        r5.close();
        r18 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:306:0x06d5, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:381:0x0878, code lost:
        if (r13 != null) goto L_0x0854;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:420:0x0997, code lost:
        if (r12 != false) goto L_0x099e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:462:0x056f, code lost:
        r22 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:463:0x056f, code lost:
        r22 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:464:0x056f, code lost:
        r22 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:466:0x056f, code lost:
        r22 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0168, code lost:
        if (r5 != null) goto L_0x0149;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0247  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0257  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x03f3  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x05a4  */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x066a A[Catch:{ SQLiteException -> 0x0660, all -> 0x065e }, ExcHandler: all (th java.lang.Throwable), PHI: r3 
      PHI: (r3v62 ?) = (r3v61 android.database.Cursor), (r3v63 android.database.Cursor), (r3v63 android.database.Cursor), (r3v63 android.database.Cursor) binds: [B:252:0x0625, B:257:0x062e, B:262:0x0643, B:263:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:252:0x0625] */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x06a9 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:247:0x060f] */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x06cb  */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x06d5  */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x06ed  */
    /* JADX WARNING: Removed duplicated region for block: B:328:0x077c  */
    /* JADX WARNING: Removed duplicated region for block: B:384:0x0881  */
    /* JADX WARNING: Removed duplicated region for block: B:439:0x0a48  */
    /* JADX WARNING: Removed duplicated region for block: B:442:0x0a50  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01a2 A[Catch:{ SQLiteException -> 0x01b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01bc A[SYNTHETIC, Splitter:B:70:0x01bc] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List m(java.lang.String r35, java.util.List r36, java.util.List r37, java.lang.Long r38, java.lang.Long r39, boolean r40) {
        /*
            r34 = this;
            r1 = r34
            java.lang.String r9 = "current_results"
            N.C0722p.e(r35)
            N.C0722p.k(r36)
            N.C0722p.k(r37)
            r0 = r35
            r1.f6384d = r0
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r1.f6385e = r0
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            r1.f6386f = r0
            r0 = r38
            r1.f6387g = r0
            r0 = r39
            r1.f6388h = r0
            java.util.Iterator r0 = r36.iterator()
        L_0x002b:
            boolean r2 = r0.hasNext()
            r10 = 0
            r11 = 1
            if (r2 == 0) goto L_0x0047
            java.lang.Object r2 = r0.next()
            com.google.android.gms.internal.measurement.O2 r2 = (com.google.android.gms.internal.measurement.O2) r2
            java.lang.String r2 = r2.I()
            java.lang.String r3 = "_s"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x002b
            r2 = r11
            goto L_0x0048
        L_0x0047:
            r2 = r10
        L_0x0048:
            com.google.android.gms.internal.measurement.O6.a()
            com.google.android.gms.measurement.internal.X2 r0 = r1.f5730a
            com.google.android.gms.measurement.internal.m r3 = r0.w()
            java.lang.String r4 = r1.f6384d
            com.google.android.gms.measurement.internal.c2 r5 = com.google.android.gms.measurement.internal.C1304d2.f6273G0
            boolean r12 = r3.H(r4, r5)
            com.google.android.gms.internal.measurement.O6.a()
            com.google.android.gms.measurement.internal.m r0 = r0.w()
            java.lang.String r3 = r1.f6384d
            com.google.android.gms.measurement.internal.c2 r4 = com.google.android.gms.measurement.internal.C1304d2.f6271F0
            boolean r13 = r0.H(r3, r4)
            if (r2 == 0) goto L_0x00ad
            com.google.android.gms.measurement.internal.q6 r0 = r1.f6129b
            com.google.android.gms.measurement.internal.u r3 = r0.F0()
            java.lang.String r4 = r1.f6384d
            r3.j()
            r3.h()
            N.C0722p.e(r4)
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            java.lang.String r5 = "current_session_count"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r10)
            r0.put(r5, r6)
            android.database.sqlite.SQLiteDatabase r5 = r3.u0()     // Catch:{ SQLiteException -> 0x0099 }
            java.lang.String r6 = "events"
            java.lang.String r7 = "app_id = ?"
            java.lang.String[] r8 = new java.lang.String[]{r4}     // Catch:{ SQLiteException -> 0x0099 }
            r5.update(r6, r0, r7, r8)     // Catch:{ SQLiteException -> 0x0099 }
            goto L_0x00ad
        L_0x0099:
            r0 = move-exception
            com.google.android.gms.measurement.internal.X2 r3 = r3.f5730a
            com.google.android.gms.measurement.internal.q2 r3 = r3.a()
            com.google.android.gms.measurement.internal.o2 r3 = r3.o()
            java.lang.Object r4 = com.google.android.gms.measurement.internal.C1402q2.x(r4)
            java.lang.String r5 = "Error resetting session-scoped event counts. appId"
            r3.c(r5, r4, r0)
        L_0x00ad:
            java.util.Map r0 = java.util.Collections.EMPTY_MAP
            java.lang.String r14 = "Failed to merge filter. appId"
            java.lang.String r15 = "Database error querying filters. appId"
            java.lang.String r3 = "data"
            java.lang.String r4 = "audience_id"
            if (r13 == 0) goto L_0x014c
            if (r12 == 0) goto L_0x014c
            com.google.android.gms.measurement.internal.q6 r6 = r1.f6129b
            com.google.android.gms.measurement.internal.u r6 = r6.F0()
            java.lang.String r7 = r1.f6384d
            N.C0722p.e(r7)
            androidx.collection.ArrayMap r8 = new androidx.collection.ArrayMap
            r8.<init>()
            android.database.sqlite.SQLiteDatabase r16 = r6.u0()
            java.lang.String r17 = "event_filters"
            java.lang.String[] r18 = new java.lang.String[]{r4, r3}     // Catch:{ SQLiteException -> 0x0150, all -> 0x014e }
            java.lang.String r19 = "app_id=?"
            java.lang.String[] r20 = new java.lang.String[]{r7}     // Catch:{ SQLiteException -> 0x0150, all -> 0x014e }
            r22 = 0
            r23 = 0
            r21 = 0
            android.database.Cursor r5 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x0150, all -> 0x014e }
            boolean r16 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0121 }
            if (r16 == 0) goto L_0x0149
        L_0x00eb:
            byte[] r0 = r5.getBlob(r11)     // Catch:{ SQLiteException -> 0x0121 }
            com.google.android.gms.internal.measurement.y1 r11 = com.google.android.gms.internal.measurement.C1271z1.R()     // Catch:{ IOException -> 0x0129 }
            com.google.android.gms.internal.measurement.E5 r0 = com.google.android.gms.measurement.internal.u6.W(r11, r0)     // Catch:{ IOException -> 0x0129 }
            com.google.android.gms.internal.measurement.y1 r0 = (com.google.android.gms.internal.measurement.C1263y1) r0     // Catch:{ IOException -> 0x0129 }
            com.google.android.gms.internal.measurement.e5 r0 = r0.o()     // Catch:{ IOException -> 0x0129 }
            com.google.android.gms.internal.measurement.z1 r0 = (com.google.android.gms.internal.measurement.C1271z1) r0     // Catch:{ IOException -> 0x0129 }
            boolean r11 = r0.L()     // Catch:{ SQLiteException -> 0x0121 }
            if (r11 != 0) goto L_0x0106
            goto L_0x013b
        L_0x0106:
            int r11 = r5.getInt(r10)     // Catch:{ SQLiteException -> 0x0121 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ SQLiteException -> 0x0121 }
            java.lang.Object r16 = r8.get(r11)     // Catch:{ SQLiteException -> 0x0121 }
            java.util.List r16 = (java.util.List) r16     // Catch:{ SQLiteException -> 0x0121 }
            if (r16 != 0) goto L_0x0123
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0121 }
            r10.<init>()     // Catch:{ SQLiteException -> 0x0121 }
            r8.put(r11, r10)     // Catch:{ SQLiteException -> 0x0121 }
            goto L_0x0125
        L_0x011f:
            r0 = move-exception
            goto L_0x016b
        L_0x0121:
            r0 = move-exception
            goto L_0x0155
        L_0x0123:
            r10 = r16
        L_0x0125:
            r10.add(r0)     // Catch:{ SQLiteException -> 0x0121 }
            goto L_0x013b
        L_0x0129:
            r0 = move-exception
            com.google.android.gms.measurement.internal.X2 r10 = r6.f5730a     // Catch:{ SQLiteException -> 0x0121 }
            com.google.android.gms.measurement.internal.q2 r10 = r10.a()     // Catch:{ SQLiteException -> 0x0121 }
            com.google.android.gms.measurement.internal.o2 r10 = r10.o()     // Catch:{ SQLiteException -> 0x0121 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.C1402q2.x(r7)     // Catch:{ SQLiteException -> 0x0121 }
            r10.c(r14, r11, r0)     // Catch:{ SQLiteException -> 0x0121 }
        L_0x013b:
            boolean r0 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x0121 }
            if (r0 != 0) goto L_0x0146
            r5.close()
            r10 = r8
            goto L_0x0171
        L_0x0146:
            r10 = 0
            r11 = 1
            goto L_0x00eb
        L_0x0149:
            r5.close()
        L_0x014c:
            r10 = r0
            goto L_0x0171
        L_0x014e:
            r0 = move-exception
            goto L_0x0152
        L_0x0150:
            r0 = move-exception
            goto L_0x0154
        L_0x0152:
            r5 = 0
            goto L_0x016b
        L_0x0154:
            r5 = 0
        L_0x0155:
            com.google.android.gms.measurement.internal.X2 r6 = r6.f5730a     // Catch:{ all -> 0x011f }
            com.google.android.gms.measurement.internal.q2 r6 = r6.a()     // Catch:{ all -> 0x011f }
            com.google.android.gms.measurement.internal.o2 r6 = r6.o()     // Catch:{ all -> 0x011f }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.C1402q2.x(r7)     // Catch:{ all -> 0x011f }
            r6.c(r15, r7, r0)     // Catch:{ all -> 0x011f }
            java.util.Map r0 = java.util.Collections.EMPTY_MAP     // Catch:{ all -> 0x011f }
            if (r5 == 0) goto L_0x014c
            goto L_0x0149
        L_0x016b:
            if (r5 == 0) goto L_0x0170
            r5.close()
        L_0x0170:
            throw r0
        L_0x0171:
            com.google.android.gms.measurement.internal.q6 r0 = r1.f6129b
            com.google.android.gms.measurement.internal.u r5 = r0.F0()
            java.lang.String r6 = r1.f6384d
            r5.j()
            r5.h()
            N.C0722p.e(r6)
            android.database.sqlite.SQLiteDatabase r16 = r5.u0()
            java.lang.String r17 = "audience_filter_values"
            java.lang.String[] r18 = new java.lang.String[]{r4, r9}     // Catch:{ SQLiteException -> 0x0224, all -> 0x0222 }
            java.lang.String r19 = "app_id=?"
            java.lang.String[] r20 = new java.lang.String[]{r6}     // Catch:{ SQLiteException -> 0x0224, all -> 0x0222 }
            r22 = 0
            r23 = 0
            r21 = 0
            android.database.Cursor r7 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x0224, all -> 0x0222 }
            boolean r0 = r7.moveToFirst()     // Catch:{ SQLiteException -> 0x01b3 }
            if (r0 != 0) goto L_0x01bc
            java.util.Map r0 = java.util.Collections.EMPTY_MAP     // Catch:{ SQLiteException -> 0x01b3 }
            r7.close()
            r11 = r0
            r17 = r2
            r18 = r3
            r19 = r4
            goto L_0x024b
        L_0x01b0:
            r0 = move-exception
            goto L_0x021f
        L_0x01b3:
            r0 = move-exception
            r17 = r2
        L_0x01b6:
            r18 = r3
        L_0x01b8:
            r19 = r4
            goto L_0x0230
        L_0x01bc:
            androidx.collection.ArrayMap r8 = new androidx.collection.ArrayMap     // Catch:{ SQLiteException -> 0x01b3 }
            r8.<init>()     // Catch:{ SQLiteException -> 0x01b3 }
        L_0x01c1:
            r11 = 0
            int r16 = r7.getInt(r11)     // Catch:{ SQLiteException -> 0x01b3 }
            r11 = 1
            byte[] r0 = r7.getBlob(r11)     // Catch:{ SQLiteException -> 0x01b3 }
            com.google.android.gms.internal.measurement.e3 r11 = com.google.android.gms.internal.measurement.C1096f3.N()     // Catch:{ IOException -> 0x01e9 }
            com.google.android.gms.internal.measurement.E5 r0 = com.google.android.gms.measurement.internal.u6.W(r11, r0)     // Catch:{ IOException -> 0x01e9 }
            com.google.android.gms.internal.measurement.e3 r0 = (com.google.android.gms.internal.measurement.C1087e3) r0     // Catch:{ IOException -> 0x01e9 }
            com.google.android.gms.internal.measurement.e5 r0 = r0.o()     // Catch:{ IOException -> 0x01e9 }
            com.google.android.gms.internal.measurement.f3 r0 = (com.google.android.gms.internal.measurement.C1096f3) r0     // Catch:{ IOException -> 0x01e9 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x01b3 }
            r8.put(r11, r0)     // Catch:{ SQLiteException -> 0x01b3 }
            r17 = r2
            r18 = r3
            r19 = r4
            goto L_0x0207
        L_0x01e9:
            r0 = move-exception
            com.google.android.gms.measurement.internal.X2 r11 = r5.f5730a     // Catch:{ SQLiteException -> 0x01b3 }
            com.google.android.gms.measurement.internal.q2 r11 = r11.a()     // Catch:{ SQLiteException -> 0x01b3 }
            com.google.android.gms.measurement.internal.o2 r11 = r11.o()     // Catch:{ SQLiteException -> 0x01b3 }
            r17 = r2
            java.lang.String r2 = "Failed to merge filter results. appId, audienceId, error"
            r18 = r3
            java.lang.Object r3 = com.google.android.gms.measurement.internal.C1402q2.x(r6)     // Catch:{ SQLiteException -> 0x021b }
            r19 = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x0219 }
            r11.d(r2, r3, r4, r0)     // Catch:{ SQLiteException -> 0x0219 }
        L_0x0207:
            boolean r0 = r7.moveToNext()     // Catch:{ SQLiteException -> 0x0219 }
            if (r0 != 0) goto L_0x0212
            r7.close()
            r11 = r8
            goto L_0x024b
        L_0x0212:
            r2 = r17
            r3 = r18
            r4 = r19
            goto L_0x01c1
        L_0x0219:
            r0 = move-exception
            goto L_0x0230
        L_0x021b:
            r0 = move-exception
            goto L_0x01b8
        L_0x021d:
            r0 = move-exception
            goto L_0x01b6
        L_0x021f:
            r5 = r7
            goto L_0x0a4e
        L_0x0222:
            r0 = move-exception
            goto L_0x022c
        L_0x0224:
            r0 = move-exception
            r17 = r2
            r18 = r3
            r19 = r4
            goto L_0x022f
        L_0x022c:
            r5 = 0
            goto L_0x0a4e
        L_0x022f:
            r7 = 0
        L_0x0230:
            com.google.android.gms.measurement.internal.X2 r2 = r5.f5730a     // Catch:{ all -> 0x01b0 }
            com.google.android.gms.measurement.internal.q2 r2 = r2.a()     // Catch:{ all -> 0x01b0 }
            com.google.android.gms.measurement.internal.o2 r2 = r2.o()     // Catch:{ all -> 0x01b0 }
            java.lang.String r3 = "Database error querying filter results. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.C1402q2.x(r6)     // Catch:{ all -> 0x01b0 }
            r2.c(r3, r4, r0)     // Catch:{ all -> 0x01b0 }
            java.util.Map r0 = java.util.Collections.EMPTY_MAP     // Catch:{ all -> 0x01b0 }
            if (r7 == 0) goto L_0x024a
            r7.close()
        L_0x024a:
            r11 = r0
        L_0x024b:
            boolean r0 = r11.isEmpty()
            if (r0 == 0) goto L_0x0257
        L_0x0251:
            r10 = r18
            r11 = r19
            goto L_0x059a
        L_0x0257:
            java.util.HashSet r2 = new java.util.HashSet
            java.util.Set r0 = r11.keySet()
            r2.<init>(r0)
            if (r17 == 0) goto L_0x03f7
            java.lang.String r3 = r1.f6384d
            com.google.android.gms.measurement.internal.q6 r0 = r1.f6129b
            com.google.android.gms.measurement.internal.u r4 = r0.F0()
            java.lang.String r5 = r1.f6384d
            r4.j()
            r4.h()
            N.C0722p.e(r5)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r6 = r4.u0()
            java.lang.String r7 = "select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;"
            java.lang.String[] r8 = new java.lang.String[]{r5, r5}     // Catch:{ SQLiteException -> 0x02ca, all -> 0x02c8 }
            android.database.Cursor r6 = r6.rawQuery(r7, r8)     // Catch:{ SQLiteException -> 0x02ca, all -> 0x02c8 }
            boolean r7 = r6.moveToFirst()     // Catch:{ SQLiteException -> 0x02ab }
            if (r7 == 0) goto L_0x02c2
        L_0x028e:
            r7 = 0
            int r8 = r6.getInt(r7)     // Catch:{ SQLiteException -> 0x02ab }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r8)     // Catch:{ SQLiteException -> 0x02ab }
            java.lang.Object r8 = r0.get(r7)     // Catch:{ SQLiteException -> 0x02ab }
            java.util.List r8 = (java.util.List) r8     // Catch:{ SQLiteException -> 0x02ab }
            if (r8 != 0) goto L_0x02a7
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x02ab }
            r8.<init>()     // Catch:{ SQLiteException -> 0x02ab }
            r0.put(r7, r8)     // Catch:{ SQLiteException -> 0x02ab }
        L_0x02a7:
            r7 = 1
            goto L_0x02ad
        L_0x02a9:
            r0 = move-exception
            goto L_0x02c5
        L_0x02ab:
            r0 = move-exception
            goto L_0x02d0
        L_0x02ad:
            int r16 = r6.getInt(r7)     // Catch:{ SQLiteException -> 0x02ab }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x02ab }
            r8.add(r7)     // Catch:{ SQLiteException -> 0x02ab }
            boolean r7 = r6.moveToNext()     // Catch:{ SQLiteException -> 0x02ab }
            if (r7 != 0) goto L_0x028e
        L_0x02be:
            r6.close()
            goto L_0x02e8
        L_0x02c2:
            java.util.Map r0 = java.util.Collections.EMPTY_MAP     // Catch:{ SQLiteException -> 0x02ab }
            goto L_0x02be
        L_0x02c5:
            r5 = r6
            goto L_0x03f1
        L_0x02c8:
            r0 = move-exception
            goto L_0x02cc
        L_0x02ca:
            r0 = move-exception
            goto L_0x02cf
        L_0x02cc:
            r5 = 0
            goto L_0x03f1
        L_0x02cf:
            r6 = 0
        L_0x02d0:
            com.google.android.gms.measurement.internal.X2 r4 = r4.f5730a     // Catch:{ all -> 0x02a9 }
            com.google.android.gms.measurement.internal.q2 r4 = r4.a()     // Catch:{ all -> 0x02a9 }
            com.google.android.gms.measurement.internal.o2 r4 = r4.o()     // Catch:{ all -> 0x02a9 }
            java.lang.String r7 = "Database error querying scoped filters. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.C1402q2.x(r5)     // Catch:{ all -> 0x02a9 }
            r4.c(r7, r5, r0)     // Catch:{ all -> 0x02a9 }
            java.util.Map r0 = java.util.Collections.EMPTY_MAP     // Catch:{ all -> 0x02a9 }
            if (r6 == 0) goto L_0x02e8
            goto L_0x02be
        L_0x02e8:
            N.C0722p.e(r3)
            N.C0722p.k(r11)
            androidx.collection.ArrayMap r3 = new androidx.collection.ArrayMap
            r3.<init>()
            boolean r4 = r11.isEmpty()
            if (r4 == 0) goto L_0x02fd
        L_0x02f9:
            r17 = r2
            goto L_0x03ef
        L_0x02fd:
            java.util.Set r4 = r11.keySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x0305:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x02f9
            java.lang.Object r5 = r4.next()
            java.lang.Integer r5 = (java.lang.Integer) r5
            r5.intValue()
            java.lang.Object r6 = r11.get(r5)
            com.google.android.gms.internal.measurement.f3 r6 = (com.google.android.gms.internal.measurement.C1096f3) r6
            java.lang.Object r7 = r0.get(r5)
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L_0x0328
            boolean r8 = r7.isEmpty()
            if (r8 == 0) goto L_0x0330
        L_0x0328:
            r16 = r0
            r17 = r2
            r21 = r4
            goto L_0x03eb
        L_0x0330:
            com.google.android.gms.measurement.internal.q6 r8 = r1.f6129b
            r16 = r0
            com.google.android.gms.measurement.internal.u6 r0 = r8.K0()
            r17 = r2
            java.util.List r2 = r6.H()
            java.util.List r0 = r0.R(r2, r7)
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x03e5
            com.google.android.gms.internal.measurement.c5 r2 = r6.q()
            com.google.android.gms.internal.measurement.e3 r2 = (com.google.android.gms.internal.measurement.C1087e3) r2
            r2.w()
            r2.t(r0)
            com.google.android.gms.measurement.internal.u6 r0 = r8.K0()
            java.util.List r8 = r6.F()
            java.util.List r0 = r0.R(r8, r7)
            r2.s()
            r2.r(r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r8 = r6.J()
            java.util.Iterator r8 = r8.iterator()
        L_0x0373:
            boolean r20 = r8.hasNext()
            if (r20 == 0) goto L_0x039b
            java.lang.Object r20 = r8.next()
            r21 = r4
            r4 = r20
            com.google.android.gms.internal.measurement.M2 r4 = (com.google.android.gms.internal.measurement.M2) r4
            int r20 = r4.G()
            r22 = r8
            java.lang.Integer r8 = java.lang.Integer.valueOf(r20)
            boolean r8 = r7.contains(r8)
            if (r8 != 0) goto L_0x0396
            r0.add(r4)
        L_0x0396:
            r4 = r21
            r8 = r22
            goto L_0x0373
        L_0x039b:
            r21 = r4
            r2.y()
            r2.x(r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r4 = r6.L()
            java.util.Iterator r4 = r4.iterator()
        L_0x03b0:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x03ce
            java.lang.Object r6 = r4.next()
            com.google.android.gms.internal.measurement.h3 r6 = (com.google.android.gms.internal.measurement.C1114h3) r6
            int r8 = r6.G()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            boolean r8 = r7.contains(r8)
            if (r8 != 0) goto L_0x03b0
            r0.add(r6)
            goto L_0x03b0
        L_0x03ce:
            r2.A()
            r2.z(r0)
            com.google.android.gms.internal.measurement.e5 r0 = r2.o()
            com.google.android.gms.internal.measurement.f3 r0 = (com.google.android.gms.internal.measurement.C1096f3) r0
            r3.put(r5, r0)
        L_0x03dd:
            r0 = r16
            r2 = r17
            r4 = r21
            goto L_0x0305
        L_0x03e5:
            r0 = r16
            r2 = r17
            goto L_0x0305
        L_0x03eb:
            r3.put(r5, r6)
            goto L_0x03dd
        L_0x03ef:
            r0 = r3
            goto L_0x03fa
        L_0x03f1:
            if (r5 == 0) goto L_0x03f6
            r5.close()
        L_0x03f6:
            throw r0
        L_0x03f7:
            r17 = r2
            r0 = r11
        L_0x03fa:
            java.util.Iterator r16 = r17.iterator()
        L_0x03fe:
            boolean r2 = r16.hasNext()
            if (r2 == 0) goto L_0x0251
            java.lang.Object r2 = r16.next()
            java.lang.Integer r2 = (java.lang.Integer) r2
            r2.intValue()
            java.lang.Object r3 = r0.get(r2)
            com.google.android.gms.internal.measurement.f3 r3 = (com.google.android.gms.internal.measurement.C1096f3) r3
            java.util.BitSet r4 = new java.util.BitSet
            r4.<init>()
            java.util.BitSet r5 = new java.util.BitSet
            r5.<init>()
            androidx.collection.ArrayMap r6 = new androidx.collection.ArrayMap
            r6.<init>()
            if (r3 == 0) goto L_0x042a
            int r7 = r3.K()
            if (r7 != 0) goto L_0x042d
        L_0x042a:
            r20 = r0
            goto L_0x0467
        L_0x042d:
            java.util.List r7 = r3.J()
            java.util.Iterator r7 = r7.iterator()
        L_0x0435:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x042a
            java.lang.Object r8 = r7.next()
            com.google.android.gms.internal.measurement.M2 r8 = (com.google.android.gms.internal.measurement.M2) r8
            boolean r17 = r8.F()
            if (r17 == 0) goto L_0x0435
            int r17 = r8.G()
            r20 = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r17)
            boolean r17 = r8.H()
            if (r17 == 0) goto L_0x0460
            long r21 = r8.I()
            java.lang.Long r8 = java.lang.Long.valueOf(r21)
            goto L_0x0461
        L_0x0460:
            r8 = 0
        L_0x0461:
            r6.put(r0, r8)
            r0 = r20
            goto L_0x0435
        L_0x0467:
            androidx.collection.ArrayMap r7 = new androidx.collection.ArrayMap
            r7.<init>()
            if (r3 == 0) goto L_0x0474
            int r0 = r3.M()
            if (r0 != 0) goto L_0x0477
        L_0x0474:
            r22 = r3
            goto L_0x04b9
        L_0x0477:
            java.util.List r0 = r3.L()
            java.util.Iterator r0 = r0.iterator()
        L_0x047f:
            boolean r8 = r0.hasNext()
            if (r8 == 0) goto L_0x0474
            java.lang.Object r8 = r0.next()
            com.google.android.gms.internal.measurement.h3 r8 = (com.google.android.gms.internal.measurement.C1114h3) r8
            boolean r17 = r8.F()
            if (r17 == 0) goto L_0x047f
            int r17 = r8.I()
            if (r17 <= 0) goto L_0x047f
            int r17 = r8.G()
            r21 = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r17)
            int r17 = r8.I()
            r22 = r3
            int r3 = r17 + -1
            long r23 = r8.J(r3)
            java.lang.Long r3 = java.lang.Long.valueOf(r23)
            r7.put(r0, r3)
            r0 = r21
            r3 = r22
            goto L_0x047f
        L_0x04b9:
            if (r22 == 0) goto L_0x0502
            r0 = 0
        L_0x04bc:
            int r3 = r22.G()
            int r3 = r3 * 64
            if (r0 >= r3) goto L_0x0502
            java.util.List r3 = r22.F()
            boolean r3 = com.google.android.gms.measurement.internal.u6.P(r3, r0)
            if (r3 == 0) goto L_0x04f4
            com.google.android.gms.measurement.internal.X2 r3 = r1.f5730a
            com.google.android.gms.measurement.internal.q2 r3 = r3.a()
            com.google.android.gms.measurement.internal.o2 r3 = r3.w()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r0)
            r17 = r12
            java.lang.String r12 = "Filter already evaluated. audience ID, filter ID"
            r3.c(r12, r2, r8)
            r5.set(r0)
            java.util.List r3 = r22.H()
            boolean r3 = com.google.android.gms.measurement.internal.u6.P(r3, r0)
            if (r3 == 0) goto L_0x04f6
            r4.set(r0)
            goto L_0x04fd
        L_0x04f4:
            r17 = r12
        L_0x04f6:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
            r6.remove(r3)
        L_0x04fd:
            int r0 = r0 + 1
            r12 = r17
            goto L_0x04bc
        L_0x0502:
            r17 = r12
            java.lang.Object r0 = r11.get(r2)
            r3 = r0
            com.google.android.gms.internal.measurement.f3 r3 = (com.google.android.gms.internal.measurement.C1096f3) r3
            if (r13 == 0) goto L_0x056f
            if (r17 == 0) goto L_0x056f
            java.lang.Object r0 = r10.get(r2)
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L_0x056f
            java.lang.Long r8 = r1.f6388h
            if (r8 == 0) goto L_0x056f
            java.lang.Long r8 = r1.f6387g
            if (r8 != 0) goto L_0x0520
            goto L_0x056f
        L_0x0520:
            java.util.Iterator r0 = r0.iterator()
        L_0x0524:
            boolean r8 = r0.hasNext()
            if (r8 == 0) goto L_0x056f
            java.lang.Object r8 = r0.next()
            com.google.android.gms.internal.measurement.z1 r8 = (com.google.android.gms.internal.measurement.C1271z1) r8
            int r12 = r8.G()
            r21 = r0
            java.lang.Long r0 = r1.f6388h
            long r22 = r0.longValue()
            r24 = 1000(0x3e8, double:4.94E-321)
            long r22 = r22 / r24
            boolean r0 = r8.O()
            if (r0 == 0) goto L_0x054e
            java.lang.Long r0 = r1.f6387g
            long r22 = r0.longValue()
            long r22 = r22 / r24
        L_0x054e:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r12)
            boolean r8 = r6.containsKey(r0)
            if (r8 == 0) goto L_0x055f
            java.lang.Long r8 = java.lang.Long.valueOf(r22)
            r6.put(r0, r8)
        L_0x055f:
            boolean r8 = r7.containsKey(r0)
            if (r8 == 0) goto L_0x056c
            java.lang.Long r8 = java.lang.Long.valueOf(r22)
            r7.put(r0, r8)
        L_0x056c:
            r0 = r21
            goto L_0x0524
        L_0x056f:
            com.google.android.gms.measurement.internal.I6 r0 = new com.google.android.gms.measurement.internal.I6
            r8 = r2
            java.lang.String r2 = r1.f6384d
            r12 = r8
            r8 = 0
            r33 = r18
            r18 = r10
            r10 = r33
            r33 = r19
            r19 = r11
            r11 = r33
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            java.util.Map r2 = r1.f6386f
            r2.put(r12, r0)
            r0 = r18
            r18 = r10
            r10 = r0
            r0 = r19
            r19 = r11
            r11 = r0
            r12 = r17
            r0 = r20
            goto L_0x03fe
        L_0x059a:
            boolean r0 = r36.isEmpty()
            java.lang.String r2 = "Skipping failed audience ID"
            if (r0 == 0) goto L_0x05a4
            goto L_0x077a
        L_0x05a4:
            com.google.android.gms.measurement.internal.J6 r3 = new com.google.android.gms.measurement.internal.J6
            r4 = 0
            r3.<init>(r1, r4)
            androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap
            r4.<init>()
            java.util.Iterator r5 = r36.iterator()
        L_0x05b3:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x077a
            java.lang.Object r0 = r5.next()
            com.google.android.gms.internal.measurement.O2 r0 = (com.google.android.gms.internal.measurement.O2) r0
            java.lang.String r6 = r1.f6384d
            com.google.android.gms.internal.measurement.O2 r19 = r3.a(r6, r0)
            if (r19 == 0) goto L_0x05b3
            com.google.android.gms.measurement.internal.q6 r6 = r1.f6129b
            com.google.android.gms.measurement.internal.u r7 = r6.F0()
            java.lang.String r8 = r1.f6384d
            java.lang.String r12 = r19.I()
            com.google.android.gms.measurement.internal.C r7 = r7.Z(r8, r0, r12)
            com.google.android.gms.measurement.internal.u r0 = r6.F0()
            r0.w0(r7)
            if (r40 != 0) goto L_0x05b3
            long r12 = r7.f5793c
            java.lang.String r8 = r19.I()
            java.lang.Object r0 = r4.get(r8)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 != 0) goto L_0x06d9
            com.google.android.gms.measurement.internal.u r6 = r6.F0()
            r24 = r3
            java.lang.String r3 = r1.f6384d
            r6.j()
            r6.h()
            N.C0722p.e(r3)
            N.C0722p.e(r8)
            r36 = r5
            androidx.collection.ArrayMap r5 = new androidx.collection.ArrayMap
            r5.<init>()
            android.database.sqlite.SQLiteDatabase r25 = r6.u0()
            java.lang.String r26 = "event_filters"
            java.lang.String[] r27 = new java.lang.String[]{r11, r10}     // Catch:{ SQLiteException -> 0x06af, all -> 0x06a9 }
            java.lang.String r28 = "app_id=? AND event_name=?"
            java.lang.String[] r29 = new java.lang.String[]{r3, r8}     // Catch:{ SQLiteException -> 0x06af, all -> 0x06a9 }
            r31 = 0
            r32 = 0
            r30 = 0
            r16 = r3
            android.database.Cursor r3 = r25.query(r26, r27, r28, r29, r30, r31, r32)     // Catch:{ SQLiteException -> 0x06ab, all -> 0x06a9 }
            boolean r0 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x06a1, all -> 0x066a }
            if (r0 == 0) goto L_0x0694
            r22 = r7
        L_0x062d:
            r7 = 1
            byte[] r0 = r3.getBlob(r7)     // Catch:{ SQLiteException -> 0x066e, all -> 0x066a }
            com.google.android.gms.internal.measurement.y1 r7 = com.google.android.gms.internal.measurement.C1271z1.R()     // Catch:{ IOException -> 0x0672 }
            com.google.android.gms.internal.measurement.E5 r0 = com.google.android.gms.measurement.internal.u6.W(r7, r0)     // Catch:{ IOException -> 0x0672 }
            com.google.android.gms.internal.measurement.y1 r0 = (com.google.android.gms.internal.measurement.C1263y1) r0     // Catch:{ IOException -> 0x0672 }
            com.google.android.gms.internal.measurement.e5 r0 = r0.o()     // Catch:{ IOException -> 0x0672 }
            com.google.android.gms.internal.measurement.z1 r0 = (com.google.android.gms.internal.measurement.C1271z1) r0     // Catch:{ IOException -> 0x0672 }
            r7 = 0
            int r17 = r3.getInt(r7)     // Catch:{ SQLiteException -> 0x066e, all -> 0x066a }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r17)     // Catch:{ SQLiteException -> 0x066e, all -> 0x066a }
            java.lang.Object r17 = r5.get(r7)     // Catch:{ SQLiteException -> 0x066e, all -> 0x066a }
            java.util.List r17 = (java.util.List) r17     // Catch:{ SQLiteException -> 0x066e, all -> 0x066a }
            if (r17 != 0) goto L_0x0662
            r18 = r3
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0660, all -> 0x065e }
            r3.<init>()     // Catch:{ SQLiteException -> 0x0660, all -> 0x065e }
            r5.put(r7, r3)     // Catch:{ SQLiteException -> 0x0660, all -> 0x065e }
            goto L_0x0666
        L_0x065e:
            r0 = move-exception
            goto L_0x069e
        L_0x0660:
            r0 = move-exception
            goto L_0x06a6
        L_0x0662:
            r18 = r3
            r3 = r17
        L_0x0666:
            r3.add(r0)     // Catch:{ SQLiteException -> 0x0660, all -> 0x065e }
            goto L_0x0686
        L_0x066a:
            r0 = move-exception
            r18 = r3
            goto L_0x069e
        L_0x066e:
            r0 = move-exception
            r18 = r3
            goto L_0x06a6
        L_0x0672:
            r0 = move-exception
            r18 = r3
            com.google.android.gms.measurement.internal.X2 r3 = r6.f5730a     // Catch:{ SQLiteException -> 0x0660, all -> 0x065e }
            com.google.android.gms.measurement.internal.q2 r3 = r3.a()     // Catch:{ SQLiteException -> 0x0660, all -> 0x065e }
            com.google.android.gms.measurement.internal.o2 r3 = r3.o()     // Catch:{ SQLiteException -> 0x0660, all -> 0x065e }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.C1402q2.x(r16)     // Catch:{ SQLiteException -> 0x0660, all -> 0x065e }
            r3.c(r14, r7, r0)     // Catch:{ SQLiteException -> 0x0660, all -> 0x065e }
        L_0x0686:
            boolean r0 = r18.moveToNext()     // Catch:{ SQLiteException -> 0x0660, all -> 0x065e }
            if (r0 != 0) goto L_0x0691
            r18.close()
            r0 = r5
            goto L_0x06ce
        L_0x0691:
            r3 = r18
            goto L_0x062d
        L_0x0694:
            r18 = r3
            r22 = r7
            java.util.Map r0 = java.util.Collections.EMPTY_MAP     // Catch:{ SQLiteException -> 0x0660, all -> 0x065e }
            r18.close()
            goto L_0x06ce
        L_0x069e:
            r5 = r18
            goto L_0x06d3
        L_0x06a1:
            r0 = move-exception
            r18 = r3
            r22 = r7
        L_0x06a6:
            r5 = r18
            goto L_0x06b6
        L_0x06a9:
            r0 = move-exception
            goto L_0x06b3
        L_0x06ab:
            r0 = move-exception
        L_0x06ac:
            r22 = r7
            goto L_0x06b5
        L_0x06af:
            r0 = move-exception
            r16 = r3
            goto L_0x06ac
        L_0x06b3:
            r5 = 0
            goto L_0x06d3
        L_0x06b5:
            r5 = 0
        L_0x06b6:
            com.google.android.gms.measurement.internal.X2 r3 = r6.f5730a     // Catch:{ all -> 0x06d2 }
            com.google.android.gms.measurement.internal.q2 r3 = r3.a()     // Catch:{ all -> 0x06d2 }
            com.google.android.gms.measurement.internal.o2 r3 = r3.o()     // Catch:{ all -> 0x06d2 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.C1402q2.x(r16)     // Catch:{ all -> 0x06d2 }
            r3.c(r15, r6, r0)     // Catch:{ all -> 0x06d2 }
            java.util.Map r0 = java.util.Collections.EMPTY_MAP     // Catch:{ all -> 0x06d2 }
            if (r5 == 0) goto L_0x06ce
            r5.close()
        L_0x06ce:
            r4.put(r8, r0)
            goto L_0x06df
        L_0x06d2:
            r0 = move-exception
        L_0x06d3:
            if (r5 == 0) goto L_0x06d8
            r5.close()
        L_0x06d8:
            throw r0
        L_0x06d9:
            r24 = r3
            r36 = r5
            r22 = r7
        L_0x06df:
            java.util.Set r3 = r0.keySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x06e7:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0774
            java.lang.Object r5 = r3.next()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r6 = r5.intValue()
            java.util.Set r7 = r1.f6385e
            boolean r7 = r7.contains(r5)
            if (r7 == 0) goto L_0x070d
            com.google.android.gms.measurement.internal.X2 r6 = r1.f5730a
            com.google.android.gms.measurement.internal.q2 r6 = r6.a()
            com.google.android.gms.measurement.internal.o2 r6 = r6.w()
            r6.b(r2, r5)
            goto L_0x06e7
        L_0x070d:
            java.lang.Object r7 = r0.get(r5)
            java.util.List r7 = (java.util.List) r7
            java.util.Iterator r7 = r7.iterator()
            r8 = 1
        L_0x0718:
            boolean r16 = r7.hasNext()
            if (r16 == 0) goto L_0x075f
            java.lang.Object r8 = r7.next()
            com.google.android.gms.internal.measurement.z1 r8 = (com.google.android.gms.internal.measurement.C1271z1) r8
            r25 = r0
            com.google.android.gms.measurement.internal.b r0 = new com.google.android.gms.measurement.internal.b
            r26 = r3
            java.lang.String r3 = r1.f6384d
            r0.<init>(r1, r3, r6, r8)
            java.lang.Long r3 = r1.f6387g
            r16 = r0
            java.lang.Long r0 = r1.f6388h
            int r8 = r8.G()
            boolean r23 = r1.o(r6, r8)
            r18 = r0
            r17 = r3
            r20 = r12
            boolean r8 = r16.k(r17, r18, r19, r20, r22, r23)
            r0 = r16
            if (r8 == 0) goto L_0x0759
            com.google.android.gms.measurement.internal.I6 r3 = r1.n(r5)
            r3.a(r0)
            r12 = r20
            r0 = r25
            r3 = r26
            goto L_0x0718
        L_0x0759:
            java.util.Set r0 = r1.f6385e
            r0.add(r5)
            goto L_0x0765
        L_0x075f:
            r25 = r0
            r26 = r3
            r20 = r12
        L_0x0765:
            if (r8 != 0) goto L_0x076c
            java.util.Set r0 = r1.f6385e
            r0.add(r5)
        L_0x076c:
            r12 = r20
            r0 = r25
            r3 = r26
            goto L_0x06e7
        L_0x0774:
            r5 = r36
            r3 = r24
            goto L_0x05b3
        L_0x077a:
            if (r40 != 0) goto L_0x0a48
            boolean r0 = r37.isEmpty()
            if (r0 == 0) goto L_0x0784
            goto L_0x09a6
        L_0x0784:
            androidx.collection.ArrayMap r3 = new androidx.collection.ArrayMap
            r3.<init>()
            java.util.Iterator r4 = r37.iterator()
        L_0x078d:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x09a6
            java.lang.Object r0 = r4.next()
            r5 = r0
            com.google.android.gms.internal.measurement.r3 r5 = (com.google.android.gms.internal.measurement.C1203r3) r5
            java.lang.String r6 = r5.H()
            java.lang.Object r0 = r3.get(r6)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 != 0) goto L_0x0885
            com.google.android.gms.measurement.internal.q6 r0 = r1.f6129b
            com.google.android.gms.measurement.internal.u r7 = r0.F0()
            java.lang.String r8 = r1.f6384d
            r7.j()
            r7.h()
            N.C0722p.e(r8)
            N.C0722p.e(r6)
            androidx.collection.ArrayMap r12 = new androidx.collection.ArrayMap
            r12.<init>()
            android.database.sqlite.SQLiteDatabase r16 = r7.u0()
            java.lang.String r17 = "property_filters"
            java.lang.String[] r18 = new java.lang.String[]{r11, r10}     // Catch:{ SQLiteException -> 0x085c, all -> 0x085a }
            java.lang.String r19 = "app_id=? AND property_name=?"
            java.lang.String[] r20 = new java.lang.String[]{r8, r6}     // Catch:{ SQLiteException -> 0x085c, all -> 0x085a }
            r22 = 0
            r23 = 0
            r21 = 0
            android.database.Cursor r13 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x085c, all -> 0x085a }
            boolean r0 = r13.moveToFirst()     // Catch:{ SQLiteException -> 0x0820 }
            if (r0 == 0) goto L_0x084e
        L_0x07df:
            r14 = 1
            byte[] r0 = r13.getBlob(r14)     // Catch:{ SQLiteException -> 0x0820 }
            com.google.android.gms.internal.measurement.G1 r14 = com.google.android.gms.internal.measurement.H1.N()     // Catch:{ IOException -> 0x0824 }
            com.google.android.gms.internal.measurement.E5 r0 = com.google.android.gms.measurement.internal.u6.W(r14, r0)     // Catch:{ IOException -> 0x0824 }
            com.google.android.gms.internal.measurement.G1 r0 = (com.google.android.gms.internal.measurement.G1) r0     // Catch:{ IOException -> 0x0824 }
            com.google.android.gms.internal.measurement.e5 r0 = r0.o()     // Catch:{ IOException -> 0x0824 }
            com.google.android.gms.internal.measurement.H1 r0 = (com.google.android.gms.internal.measurement.H1) r0     // Catch:{ IOException -> 0x0824 }
            r14 = 0
            int r16 = r13.getInt(r14)     // Catch:{ SQLiteException -> 0x0820 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x0820 }
            java.lang.Object r16 = r12.get(r14)     // Catch:{ SQLiteException -> 0x0820 }
            java.util.List r16 = (java.util.List) r16     // Catch:{ SQLiteException -> 0x0820 }
            if (r16 != 0) goto L_0x0816
            r36 = r4
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0812 }
            r4.<init>()     // Catch:{ SQLiteException -> 0x0812 }
            r12.put(r14, r4)     // Catch:{ SQLiteException -> 0x0812 }
            goto L_0x081a
        L_0x0810:
            r0 = move-exception
            goto L_0x0858
        L_0x0812:
            r0 = move-exception
        L_0x0813:
            r16 = r8
            goto L_0x0865
        L_0x0816:
            r36 = r4
            r4 = r16
        L_0x081a:
            r4.add(r0)     // Catch:{ SQLiteException -> 0x0812 }
            r16 = r8
            goto L_0x083c
        L_0x0820:
            r0 = move-exception
            r36 = r4
            goto L_0x0813
        L_0x0824:
            r0 = move-exception
            r36 = r4
            com.google.android.gms.measurement.internal.X2 r4 = r7.f5730a     // Catch:{ SQLiteException -> 0x0812 }
            com.google.android.gms.measurement.internal.q2 r4 = r4.a()     // Catch:{ SQLiteException -> 0x0812 }
            com.google.android.gms.measurement.internal.o2 r4 = r4.o()     // Catch:{ SQLiteException -> 0x0812 }
            java.lang.String r14 = "Failed to merge filter"
            r16 = r8
            java.lang.Object r8 = com.google.android.gms.measurement.internal.C1402q2.x(r16)     // Catch:{ SQLiteException -> 0x084c }
            r4.c(r14, r8, r0)     // Catch:{ SQLiteException -> 0x084c }
        L_0x083c:
            boolean r0 = r13.moveToNext()     // Catch:{ SQLiteException -> 0x084c }
            if (r0 != 0) goto L_0x0847
            r13.close()
            r0 = r12
            goto L_0x087b
        L_0x0847:
            r4 = r36
            r8 = r16
            goto L_0x07df
        L_0x084c:
            r0 = move-exception
            goto L_0x0865
        L_0x084e:
            r36 = r4
            r16 = r8
            java.util.Map r0 = java.util.Collections.EMPTY_MAP     // Catch:{ SQLiteException -> 0x084c }
        L_0x0854:
            r13.close()
            goto L_0x087b
        L_0x0858:
            r5 = r13
            goto L_0x087f
        L_0x085a:
            r0 = move-exception
            goto L_0x0862
        L_0x085c:
            r0 = move-exception
            r36 = r4
            r16 = r8
            goto L_0x0864
        L_0x0862:
            r5 = 0
            goto L_0x087f
        L_0x0864:
            r13 = 0
        L_0x0865:
            com.google.android.gms.measurement.internal.X2 r4 = r7.f5730a     // Catch:{ all -> 0x0810 }
            com.google.android.gms.measurement.internal.q2 r4 = r4.a()     // Catch:{ all -> 0x0810 }
            com.google.android.gms.measurement.internal.o2 r4 = r4.o()     // Catch:{ all -> 0x0810 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.C1402q2.x(r16)     // Catch:{ all -> 0x0810 }
            r4.c(r15, r7, r0)     // Catch:{ all -> 0x0810 }
            java.util.Map r0 = java.util.Collections.EMPTY_MAP     // Catch:{ all -> 0x0810 }
            if (r13 == 0) goto L_0x087b
            goto L_0x0854
        L_0x087b:
            r3.put(r6, r0)
            goto L_0x0887
        L_0x087f:
            if (r5 == 0) goto L_0x0884
            r5.close()
        L_0x0884:
            throw r0
        L_0x0885:
            r36 = r4
        L_0x0887:
            java.util.Set r4 = r0.keySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x088f:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x08b4
            java.lang.Object r6 = r4.next()
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r7 = r6.intValue()
            java.util.Set r8 = r1.f6385e
            boolean r8 = r8.contains(r6)
            if (r8 == 0) goto L_0x08b8
            com.google.android.gms.measurement.internal.X2 r0 = r1.f5730a
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()
            com.google.android.gms.measurement.internal.o2 r0 = r0.w()
            r0.b(r2, r6)
        L_0x08b4:
            r4 = r36
            goto L_0x078d
        L_0x08b8:
            java.lang.Object r8 = r0.get(r6)
            java.util.List r8 = (java.util.List) r8
            java.util.Iterator r8 = r8.iterator()
            r12 = 1
        L_0x08c3:
            boolean r13 = r8.hasNext()
            if (r13 == 0) goto L_0x0991
            java.lang.Object r12 = r8.next()
            com.google.android.gms.internal.measurement.H1 r12 = (com.google.android.gms.internal.measurement.H1) r12
            com.google.android.gms.measurement.internal.X2 r13 = r1.f5730a
            com.google.android.gms.measurement.internal.q2 r14 = r13.a()
            java.lang.String r14 = r14.z()
            r37 = r0
            r0 = 2
            boolean r0 = android.util.Log.isLoggable(r14, r0)
            if (r0 == 0) goto L_0x0928
            com.google.android.gms.measurement.internal.q2 r0 = r13.a()
            com.google.android.gms.measurement.internal.o2 r0 = r0.w()
            boolean r14 = r12.F()
            if (r14 == 0) goto L_0x08fb
            int r14 = r12.G()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
        L_0x08f8:
            r16 = r2
            goto L_0x08fd
        L_0x08fb:
            r14 = 0
            goto L_0x08f8
        L_0x08fd:
            com.google.android.gms.measurement.internal.j2 r2 = r13.D()
            r40 = r3
            java.lang.String r3 = r12.H()
            java.lang.String r2 = r2.c(r3)
            java.lang.String r3 = "Evaluating filter. audience, filter, property"
            r0.d(r3, r6, r14, r2)
            com.google.android.gms.measurement.internal.q2 r0 = r13.a()
            com.google.android.gms.measurement.internal.o2 r0 = r0.w()
            com.google.android.gms.measurement.internal.q6 r2 = r1.f6129b
            com.google.android.gms.measurement.internal.u6 r2 = r2.K0()
            java.lang.String r2 = r2.M(r12)
            java.lang.String r3 = "Filter definition"
            r0.b(r3, r2)
            goto L_0x092c
        L_0x0928:
            r16 = r2
            r40 = r3
        L_0x092c:
            boolean r0 = r12.F()
            if (r0 == 0) goto L_0x0969
            int r0 = r12.G()
            r2 = 256(0x100, float:3.59E-43)
            if (r0 <= r2) goto L_0x093b
            goto L_0x0969
        L_0x093b:
            com.google.android.gms.measurement.internal.d r0 = new com.google.android.gms.measurement.internal.d
            java.lang.String r2 = r1.f6384d
            r0.<init>(r1, r2, r7, r12)
            java.lang.Long r2 = r1.f6387g
            java.lang.Long r3 = r1.f6388h
            int r12 = r12.G()
            boolean r12 = r1.o(r7, r12)
            boolean r12 = r0.k(r2, r3, r5, r12)
            if (r12 == 0) goto L_0x0963
            com.google.android.gms.measurement.internal.I6 r2 = r1.n(r6)
            r2.a(r0)
            r0 = r37
            r3 = r40
            r2 = r16
            goto L_0x08c3
        L_0x0963:
            java.util.Set r0 = r1.f6385e
            r0.add(r6)
            goto L_0x0997
        L_0x0969:
            com.google.android.gms.measurement.internal.q2 r0 = r13.a()
            com.google.android.gms.measurement.internal.o2 r0 = r0.r()
            java.lang.String r2 = r1.f6384d
            java.lang.Object r2 = com.google.android.gms.measurement.internal.C1402q2.x(r2)
            boolean r3 = r12.F()
            if (r3 == 0) goto L_0x0986
            int r3 = r12.G()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0987
        L_0x0986:
            r3 = 0
        L_0x0987:
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r7 = "Invalid property filter ID. appId, id"
            r0.c(r7, r2, r3)
            goto L_0x0999
        L_0x0991:
            r37 = r0
            r16 = r2
            r40 = r3
        L_0x0997:
            if (r12 != 0) goto L_0x099e
        L_0x0999:
            java.util.Set r0 = r1.f6385e
            r0.add(r6)
        L_0x099e:
            r0 = r37
            r3 = r40
            r2 = r16
            goto L_0x088f
        L_0x09a6:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Map r0 = r1.f6386f
            java.util.Set r0 = r0.keySet()
            java.util.Set r3 = r1.f6385e
            r0.removeAll(r3)
            java.util.Iterator r3 = r0.iterator()
        L_0x09ba:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0a47
            java.lang.Object r0 = r3.next()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r4 = r0.intValue()
            java.util.Map r5 = r1.f6386f
            java.lang.Object r5 = r5.get(r0)
            com.google.android.gms.measurement.internal.I6 r5 = (com.google.android.gms.measurement.internal.I6) r5
            N.C0722p.k(r5)
            com.google.android.gms.internal.measurement.C2 r4 = r5.b(r4)
            r2.add(r4)
            com.google.android.gms.measurement.internal.q6 r5 = r1.f6129b
            com.google.android.gms.measurement.internal.u r5 = r5.F0()
            java.lang.String r6 = r1.f6384d
            com.google.android.gms.internal.measurement.f3 r4 = r4.H()
            r5.j()
            r5.h()
            N.C0722p.e(r6)
            N.C0722p.k(r4)
            byte[] r4 = r4.e()
            android.content.ContentValues r7 = new android.content.ContentValues
            r7.<init>()
            java.lang.String r8 = "app_id"
            r7.put(r8, r6)
            r7.put(r11, r0)
            r7.put(r9, r4)
            android.database.sqlite.SQLiteDatabase r0 = r5.u0()     // Catch:{ SQLiteException -> 0x0a30 }
            java.lang.String r4 = "audience_filter_values"
            r8 = 5
            r10 = 0
            long r7 = r0.insertWithOnConflict(r4, r10, r7, r8)     // Catch:{ SQLiteException -> 0x0a2e }
            r12 = -1
            int r0 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r0 != 0) goto L_0x09ba
            com.google.android.gms.measurement.internal.X2 r0 = r5.f5730a     // Catch:{ SQLiteException -> 0x0a2e }
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()     // Catch:{ SQLiteException -> 0x0a2e }
            com.google.android.gms.measurement.internal.o2 r0 = r0.o()     // Catch:{ SQLiteException -> 0x0a2e }
            java.lang.String r4 = "Failed to insert filter results (got -1). appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.C1402q2.x(r6)     // Catch:{ SQLiteException -> 0x0a2e }
            r0.b(r4, r7)     // Catch:{ SQLiteException -> 0x0a2e }
            goto L_0x09ba
        L_0x0a2e:
            r0 = move-exception
            goto L_0x0a32
        L_0x0a30:
            r0 = move-exception
            r10 = 0
        L_0x0a32:
            com.google.android.gms.measurement.internal.X2 r4 = r5.f5730a
            com.google.android.gms.measurement.internal.q2 r4 = r4.a()
            com.google.android.gms.measurement.internal.o2 r4 = r4.o()
            java.lang.Object r5 = com.google.android.gms.measurement.internal.C1402q2.x(r6)
            java.lang.String r6 = "Error storing filter results. appId"
            r4.c(r6, r5, r0)
            goto L_0x09ba
        L_0x0a47:
            return r2
        L_0x0a48:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            return r0
        L_0x0a4e:
            if (r5 == 0) goto L_0x0a53
            r5.close()
        L_0x0a53:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1309e.m(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long, boolean):java.util.List");
    }
}
