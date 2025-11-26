package e4;

import java.io.RandomAccessFile;
import kotlin.jvm.internal.t;

public final class r extends C2360i {

    /* renamed from: e  reason: collision with root package name */
    private final RandomAccessFile f21607e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(boolean z4, RandomAccessFile randomAccessFile) {
        super(z4);
        t.e(randomAccessFile, "randomAccessFile");
        this.f21607e = randomAccessFile;
    }

    /* access modifiers changed from: protected */
    public synchronized void p() {
        this.f21607e.close();
    }

    /* access modifiers changed from: protected */
    public synchronized void q() {
        this.f21607e.getFD().sync();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int s(long r2, byte[] r4, int r5, int r6) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.lang.String r0 = "array"
            kotlin.jvm.internal.t.e(r4, r0)     // Catch:{ all -> 0x001f }
            java.io.RandomAccessFile r0 = r1.f21607e     // Catch:{ all -> 0x001f }
            r0.seek(r2)     // Catch:{ all -> 0x001f }
            r2 = 0
        L_0x000c:
            if (r2 >= r6) goto L_0x0021
            java.io.RandomAccessFile r3 = r1.f21607e     // Catch:{ all -> 0x001f }
            int r0 = r6 - r2
            int r3 = r3.read(r4, r5, r0)     // Catch:{ all -> 0x001f }
            r0 = -1
            if (r3 != r0) goto L_0x001d
            if (r2 != 0) goto L_0x0021
            monitor-exit(r1)
            return r0
        L_0x001d:
            int r2 = r2 + r3
            goto L_0x000c
        L_0x001f:
            r2 = move-exception
            goto L_0x0023
        L_0x0021:
            monitor-exit(r1)
            return r2
        L_0x0023:
            monitor-exit(r1)     // Catch:{ all -> 0x001f }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: e4.r.s(long, byte[], int, int):int");
    }

    /* access modifiers changed from: protected */
    public synchronized long t() {
        return this.f21607e.length();
    }

    /* access modifiers changed from: protected */
    public synchronized void u(long j5, byte[] bArr, int i5, int i6) {
        t.e(bArr, "array");
        this.f21607e.seek(j5);
        this.f21607e.write(bArr, i5, i6);
    }
}
