package j$.util.concurrent;

public final class g extends l {

    /* renamed from: e  reason: collision with root package name */
    public final l[] f1316e;

    public g(l[] lVarArr) {
        super(-1, (Object) null, (Object) null);
        this.f1316e = lVarArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
        if ((r0 instanceof j$.util.concurrent.g) == false) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002f, code lost:
        return r0.a(r4, r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final j$.util.concurrent.l a(int r4, java.lang.Object r5) {
        /*
            r3 = this;
            j$.util.concurrent.l[] r0 = r3.f1316e
        L_0x0002:
            int r1 = r0.length
            if (r1 == 0) goto L_0x0034
            int r1 = r1 + -1
            r1 = r1 & r4
            j$.util.concurrent.l r0 = j$.util.concurrent.ConcurrentHashMap.k(r0, r1)
            if (r0 != 0) goto L_0x000f
            goto L_0x0034
        L_0x000f:
            int r1 = r0.f1323a
            if (r1 != r4) goto L_0x0020
            java.lang.Object r2 = r0.f1324b
            if (r2 == r5) goto L_0x001f
            if (r2 == 0) goto L_0x0020
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0020
        L_0x001f:
            return r0
        L_0x0020:
            if (r1 >= 0) goto L_0x0030
            boolean r1 = r0 instanceof j$.util.concurrent.g
            if (r1 == 0) goto L_0x002b
            j$.util.concurrent.g r0 = (j$.util.concurrent.g) r0
            j$.util.concurrent.l[] r0 = r0.f1316e
            goto L_0x0002
        L_0x002b:
            j$.util.concurrent.l r4 = r0.a(r4, r5)
            return r4
        L_0x0030:
            j$.util.concurrent.l r0 = r0.f1326d
            if (r0 != 0) goto L_0x000f
        L_0x0034:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.g.a(int, java.lang.Object):j$.util.concurrent.l");
    }
}
