package e4;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.jvm.internal.t;

/* renamed from: e4.o  reason: case insensitive filesystem */
public final class C2366o implements Z {

    /* renamed from: a  reason: collision with root package name */
    private byte f21596a;

    /* renamed from: b  reason: collision with root package name */
    private final T f21597b;

    /* renamed from: c  reason: collision with root package name */
    private final Inflater f21598c;

    /* renamed from: d  reason: collision with root package name */
    private final C2367p f21599d;

    /* renamed from: e  reason: collision with root package name */
    private final CRC32 f21600e = new CRC32();

    public C2366o(Z z4) {
        t.e(z4, "source");
        T t5 = new T(z4);
        this.f21597b = t5;
        Inflater inflater = new Inflater(true);
        this.f21598c = inflater;
        this.f21599d = new C2367p((C2358g) t5, inflater);
    }

    private final void a(String str, int i5, int i6) {
        if (i6 != i5) {
            String format = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i6), Integer.valueOf(i5)}, 3));
            t.d(format, "format(this, *args)");
            throw new IOException(format);
        }
    }

    private final void d() {
        boolean z4;
        this.f21597b.require(10);
        byte q5 = this.f21597b.f21509b.q(3);
        if (((q5 >> 1) & 1) == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            m(this.f21597b.f21509b, 0, 10);
        }
        a("ID1ID2", 8075, this.f21597b.readShort());
        this.f21597b.skip(8);
        if (((q5 >> 2) & 1) == 1) {
            this.f21597b.require(2);
            if (z4) {
                m(this.f21597b.f21509b, 0, 2);
            }
            long readShortLe = (long) (this.f21597b.f21509b.readShortLe() & 65535);
            this.f21597b.require(readShortLe);
            if (z4) {
                m(this.f21597b.f21509b, 0, readShortLe);
            }
            this.f21597b.skip(readShortLe);
        }
        if (((q5 >> 3) & 1) == 1) {
            long indexOf = this.f21597b.indexOf((byte) 0);
            if (indexOf != -1) {
                if (z4) {
                    m(this.f21597b.f21509b, 0, indexOf + 1);
                }
                this.f21597b.skip(indexOf + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((q5 >> 4) & 1) == 1) {
            long indexOf2 = this.f21597b.indexOf((byte) 0);
            if (indexOf2 != -1) {
                if (z4) {
                    m(this.f21597b.f21509b, 0, indexOf2 + 1);
                }
                this.f21597b.skip(indexOf2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z4) {
            a("FHCRC", this.f21597b.readShortLe(), (short) ((int) this.f21600e.getValue()));
            this.f21600e.reset();
        }
    }

    private final void l() {
        a("CRC", this.f21597b.readIntLe(), (int) this.f21600e.getValue());
        a("ISIZE", this.f21597b.readIntLe(), (int) this.f21598c.getBytesWritten());
    }

    private final void m(C2356e eVar, long j5, long j6) {
        U u5 = eVar.f21556a;
        t.b(u5);
        while (true) {
            int i5 = u5.f21515c;
            int i6 = u5.f21514b;
            if (j5 < ((long) (i5 - i6))) {
                break;
            }
            j5 -= (long) (i5 - i6);
            u5 = u5.f21518f;
            t.b(u5);
        }
        while (j6 > 0) {
            int i7 = (int) (((long) u5.f21514b) + j5);
            int min = (int) Math.min((long) (u5.f21515c - i7), j6);
            this.f21600e.update(u5.f21513a, i7, min);
            j6 -= (long) min;
            u5 = u5.f21518f;
            t.b(u5);
            j5 = 0;
        }
    }

    public void close() {
        this.f21599d.close();
    }

    public long e(C2356e eVar, long j5) {
        C2366o oVar;
        t.e(eVar, "sink");
        int i5 = (j5 > 0 ? 1 : (j5 == 0 ? 0 : -1));
        if (i5 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j5).toString());
        } else if (i5 == 0) {
            return 0;
        } else {
            if (this.f21596a == 0) {
                d();
                this.f21596a = 1;
            }
            if (this.f21596a == 1) {
                long size = eVar.size();
                long e5 = this.f21599d.e(eVar, j5);
                if (e5 != -1) {
                    m(eVar, size, e5);
                    return e5;
                }
                oVar = this;
                oVar.f21596a = 2;
            } else {
                oVar = this;
            }
            if (oVar.f21596a == 2) {
                l();
                oVar.f21596a = 3;
                if (!oVar.f21597b.exhausted()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    public a0 timeout() {
        return this.f21597b.timeout();
    }
}
