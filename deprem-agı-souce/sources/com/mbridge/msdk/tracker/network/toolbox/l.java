package com.mbridge.msdk.tracker.network.toolbox;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class l extends ByteArrayOutputStream {

    /* renamed from: a  reason: collision with root package name */
    private final c f11679a;

    public l(c cVar, int i5) {
        this.f11679a = cVar;
        this.buf = cVar.a(Math.max(i5, 256));
    }

    private void a(int i5) {
        int i6 = this.count;
        if (i6 + i5 > this.buf.length) {
            byte[] a5 = this.f11679a.a((i6 + i5) * 2);
            System.arraycopy(this.buf, 0, a5, 0, this.count);
            this.f11679a.a(this.buf);
            this.buf = a5;
        }
    }

    public final void close() throws IOException {
        this.f11679a.a(this.buf);
        this.buf = null;
        super.close();
    }

    public final void finalize() {
        this.f11679a.a(this.buf);
    }

    public final synchronized void write(byte[] bArr, int i5, int i6) {
        a(i6);
        if (bArr != null) {
            super.write(bArr, i5, i6);
        }
    }

    public final synchronized void write(int i5) {
        a(1);
        super.write(i5);
    }
}
