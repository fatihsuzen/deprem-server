package com.mbridge.msdk.tracker.network.toolbox;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    protected static final Comparator<byte[]> f11663a = new Comparator<byte[]>() {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((byte[]) obj).length - ((byte[]) obj2).length;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final List<byte[]> f11664b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final List<byte[]> f11665c = new ArrayList(64);

    /* renamed from: d  reason: collision with root package name */
    private int f11666d = 0;

    /* renamed from: e  reason: collision with root package name */
    private final int f11667e;

    public c(int i5) {
        this.f11667e = i5;
    }

    public final synchronized byte[] a(int i5) {
        for (int i6 = 0; i6 < this.f11665c.size(); i6++) {
            byte[] bArr = this.f11665c.get(i6);
            if (bArr.length >= i5) {
                this.f11666d -= bArr.length;
                this.f11665c.remove(i6);
                this.f11664b.remove(bArr);
                return bArr;
            }
        }
        return new byte[i5];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(byte[] r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 == 0) goto L_0x002e
            int r0 = r3.length     // Catch:{ all -> 0x002b }
            int r1 = r2.f11667e     // Catch:{ all -> 0x002b }
            if (r0 <= r1) goto L_0x0009
            goto L_0x002e
        L_0x0009:
            java.util.List<byte[]> r0 = r2.f11664b     // Catch:{ all -> 0x002b }
            r0.add(r3)     // Catch:{ all -> 0x002b }
            java.util.List<byte[]> r0 = r2.f11665c     // Catch:{ all -> 0x002b }
            java.util.Comparator<byte[]> r1 = f11663a     // Catch:{ all -> 0x002b }
            int r0 = java.util.Collections.binarySearch(r0, r3, r1)     // Catch:{ all -> 0x002b }
            if (r0 >= 0) goto L_0x001b
            int r0 = -r0
            int r0 = r0 + -1
        L_0x001b:
            java.util.List<byte[]> r1 = r2.f11665c     // Catch:{ all -> 0x002b }
            r1.add(r0, r3)     // Catch:{ all -> 0x002b }
            int r0 = r2.f11666d     // Catch:{ all -> 0x002b }
            int r3 = r3.length     // Catch:{ all -> 0x002b }
            int r0 = r0 + r3
            r2.f11666d = r0     // Catch:{ all -> 0x002b }
            r2.a()     // Catch:{ all -> 0x002b }
            monitor-exit(r2)
            return
        L_0x002b:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x002b }
            throw r3
        L_0x002e:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.tracker.network.toolbox.c.a(byte[]):void");
    }

    private synchronized void a() {
        while (this.f11666d > this.f11667e) {
            byte[] remove = this.f11664b.remove(0);
            this.f11665c.remove(remove);
            this.f11666d -= remove.length;
        }
    }
}
