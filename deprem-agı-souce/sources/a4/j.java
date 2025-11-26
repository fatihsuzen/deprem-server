package a4;

import V3.c;
import a4.d;
import e4.C2356e;
import e4.C2357f;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

final class j implements Closeable {

    /* renamed from: g  reason: collision with root package name */
    private static final Logger f20453g = Logger.getLogger(e.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final C2357f f20454a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f20455b;

    /* renamed from: c  reason: collision with root package name */
    private final C2356e f20456c;

    /* renamed from: d  reason: collision with root package name */
    private int f20457d = 16384;

    /* renamed from: e  reason: collision with root package name */
    private boolean f20458e;

    /* renamed from: f  reason: collision with root package name */
    final d.b f20459f;

    j(C2357f fVar, boolean z4) {
        this.f20454a = fVar;
        this.f20455b = z4;
        C2356e eVar = new C2356e();
        this.f20456c = eVar;
        this.f20459f = new d.b(eVar);
    }

    private static void A(C2357f fVar, int i5) {
        fVar.writeByte((i5 >>> 16) & 255);
        fVar.writeByte((i5 >>> 8) & 255);
        fVar.writeByte(i5 & 255);
    }

    private void z(int i5, long j5) {
        byte b5;
        while (j5 > 0) {
            int min = (int) Math.min((long) this.f20457d, j5);
            long j6 = (long) min;
            j5 -= j6;
            if (j5 == 0) {
                b5 = 4;
            } else {
                b5 = 0;
            }
            n(i5, min, (byte) 9, b5);
            this.f20454a.f(this.f20456c, j6);
        }
    }

    public synchronized void a(m mVar) {
        try {
            if (!this.f20458e) {
                this.f20457d = mVar.f(this.f20457d);
                if (mVar.c() != -1) {
                    this.f20459f.e(mVar.c());
                }
                n(0, 0, (byte) 4, (byte) 1);
                this.f20454a.flush();
            } else {
                throw new IOException("closed");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void close() {
        this.f20458e = true;
        this.f20454a.close();
    }

    public synchronized void d() {
        try {
            if (this.f20458e) {
                throw new IOException("closed");
            } else if (this.f20455b) {
                Logger logger = f20453g;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(c.o(">> CONNECTION %s", e.f20335a.m()));
                }
                this.f20454a.write(e.f20335a.K());
                this.f20454a.flush();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void flush() {
        if (!this.f20458e) {
            this.f20454a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void l(boolean z4, int i5, C2356e eVar, int i6) {
        byte b5;
        if (!this.f20458e) {
            if (z4) {
                b5 = (byte) 1;
            } else {
                b5 = 0;
            }
            m(i5, b5, eVar, i6);
        } else {
            throw new IOException("closed");
        }
    }

    /* access modifiers changed from: package-private */
    public void m(int i5, byte b5, C2356e eVar, int i6) {
        n(i5, i6, (byte) 0, b5);
        if (i6 > 0) {
            this.f20454a.f(eVar, (long) i6);
        }
    }

    public void n(int i5, int i6, byte b5, byte b6) {
        Logger logger = f20453g;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(e.b(false, i5, i6, b5, b6));
        }
        int i7 = this.f20457d;
        if (i6 > i7) {
            throw e.c("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i7), Integer.valueOf(i6));
        } else if ((Integer.MIN_VALUE & i5) == 0) {
            A(this.f20454a, i6);
            this.f20454a.writeByte(b5 & 255);
            this.f20454a.writeByte(b6 & 255);
            this.f20454a.writeInt(i5 & Integer.MAX_VALUE);
        } else {
            throw e.c("reserved bit set: %s", Integer.valueOf(i5));
        }
    }

    public synchronized void o(int i5, b bVar, byte[] bArr) {
        try {
            if (this.f20458e) {
                throw new IOException("closed");
            } else if (bVar.f20305a != -1) {
                n(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.f20454a.writeInt(i5);
                this.f20454a.writeInt(bVar.f20305a);
                if (bArr.length > 0) {
                    this.f20454a.write(bArr);
                }
                this.f20454a.flush();
            } else {
                throw e.c("errorCode.httpCode == -1", new Object[0]);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public void p(boolean z4, int i5, List list) {
        byte b5;
        if (!this.f20458e) {
            this.f20459f.g(list);
            long size = this.f20456c.size();
            int min = (int) Math.min((long) this.f20457d, size);
            long j5 = (long) min;
            int i6 = (size > j5 ? 1 : (size == j5 ? 0 : -1));
            if (i6 == 0) {
                b5 = 4;
            } else {
                b5 = 0;
            }
            if (z4) {
                b5 = (byte) (b5 | 1);
            }
            n(i5, min, (byte) 1, b5);
            this.f20454a.f(this.f20456c, j5);
            if (i6 > 0) {
                z(i5, size - j5);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }

    public int q() {
        return this.f20457d;
    }

    public synchronized void s(boolean z4, int i5, int i6) {
        if (!this.f20458e) {
            n(0, 8, (byte) 6, z4 ? (byte) 1 : 0);
            this.f20454a.writeInt(i5);
            this.f20454a.writeInt(i6);
            this.f20454a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void t(int i5, int i6, List list) {
        byte b5;
        if (!this.f20458e) {
            this.f20459f.g(list);
            long size = this.f20456c.size();
            int min = (int) Math.min((long) (this.f20457d - 4), size);
            long j5 = (long) min;
            int i7 = (size > j5 ? 1 : (size == j5 ? 0 : -1));
            if (i7 == 0) {
                b5 = 4;
            } else {
                b5 = 0;
            }
            n(i5, min + 4, (byte) 5, b5);
            this.f20454a.writeInt(i6 & Integer.MAX_VALUE);
            this.f20454a.f(this.f20456c, j5);
            if (i7 > 0) {
                z(i5, size - j5);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void u(int i5, b bVar) {
        if (this.f20458e) {
            throw new IOException("closed");
        } else if (bVar.f20305a != -1) {
            n(i5, 4, (byte) 3, (byte) 0);
            this.f20454a.writeInt(bVar.f20305a);
            this.f20454a.flush();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public synchronized void v(m mVar) {
        int i5;
        try {
            if (!this.f20458e) {
                n(0, mVar.j() * 6, (byte) 4, (byte) 0);
                for (int i6 = 0; i6 < 10; i6++) {
                    if (mVar.g(i6)) {
                        if (i6 == 4) {
                            i5 = 3;
                        } else if (i6 == 7) {
                            i5 = 4;
                        } else {
                            i5 = i6;
                        }
                        this.f20454a.writeShort(i5);
                        this.f20454a.writeInt(mVar.b(i6));
                    }
                }
                this.f20454a.flush();
            } else {
                throw new IOException("closed");
            }
        } finally {
        }
    }

    public synchronized void x(boolean z4, int i5, int i6, List list) {
        if (!this.f20458e) {
            p(z4, i5, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void y(int i5, long j5) {
        if (this.f20458e) {
            throw new IOException("closed");
        } else if (j5 == 0 || j5 > 2147483647L) {
            throw e.c("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j5));
        } else {
            n(i5, 4, (byte) 8, (byte) 0);
            this.f20454a.writeInt((int) j5);
            this.f20454a.flush();
        }
    }
}
