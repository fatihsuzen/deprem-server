package j$.time.format;

public final class e implements f {

    /* renamed from: a  reason: collision with root package name */
    public final f[] f1103a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f1104b;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public e(java.util.List r2, boolean r3) {
        /*
            r1 = this;
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            int r0 = r2.size()
            j$.time.format.f[] r0 = new j$.time.format.f[r0]
            java.lang.Object[] r2 = r2.toArray(r0)
            j$.time.format.f[] r2 = (j$.time.format.f[]) r2
            r1.<init>((j$.time.format.f[]) r2, (boolean) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.e.<init>(java.util.List, boolean):void");
    }

    public e(f[] fVarArr, boolean z4) {
        this.f1103a = fVarArr;
        this.f1104b = z4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
        if (r2 != false) goto L_0x0021;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002f, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean e(j$.time.format.p r8, java.lang.StringBuilder r9) {
        /*
            r7 = this;
            int r0 = r9.length()
            r1 = 1
            boolean r2 = r7.f1104b
            if (r2 == 0) goto L_0x000e
            int r3 = r8.f1136c
            int r3 = r3 + r1
            r8.f1136c = r3
        L_0x000e:
            j$.time.format.f[] r3 = r7.f1103a     // Catch:{ all -> 0x0027 }
            int r4 = r3.length     // Catch:{ all -> 0x0027 }
            r5 = 0
        L_0x0012:
            if (r5 >= r4) goto L_0x002c
            r6 = r3[r5]     // Catch:{ all -> 0x0027 }
            boolean r6 = r6.e(r8, r9)     // Catch:{ all -> 0x0027 }
            if (r6 != 0) goto L_0x0029
            r9.setLength(r0)     // Catch:{ all -> 0x0027 }
            if (r2 == 0) goto L_0x002f
        L_0x0021:
            int r9 = r8.f1136c
            int r9 = r9 - r1
            r8.f1136c = r9
            return r1
        L_0x0027:
            r9 = move-exception
            goto L_0x0030
        L_0x0029:
            int r5 = r5 + 1
            goto L_0x0012
        L_0x002c:
            if (r2 == 0) goto L_0x002f
            goto L_0x0021
        L_0x002f:
            return r1
        L_0x0030:
            if (r2 == 0) goto L_0x0037
            int r0 = r8.f1136c
            int r0 = r0 - r1
            r8.f1136c = r0
        L_0x0037:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.e.e(j$.time.format.p, java.lang.StringBuilder):boolean");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        f[] fVarArr = this.f1103a;
        if (fVarArr != null) {
            boolean z4 = this.f1104b;
            sb.append(z4 ? "[" : "(");
            for (f append : fVarArr) {
                sb.append(append);
            }
            sb.append(z4 ? "]" : ")");
        }
        return sb.toString();
    }
}
