package e4;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.jvm.internal.t;

/* renamed from: e4.p  reason: case insensitive filesystem */
public final class C2367p implements Z {

    /* renamed from: a  reason: collision with root package name */
    private final C2358g f21601a;

    /* renamed from: b  reason: collision with root package name */
    private final Inflater f21602b;

    /* renamed from: c  reason: collision with root package name */
    private int f21603c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f21604d;

    public C2367p(C2358g gVar, Inflater inflater) {
        t.e(gVar, "source");
        t.e(inflater, "inflater");
        this.f21601a = gVar;
        this.f21602b = inflater;
    }

    private final void l() {
        int i5 = this.f21603c;
        if (i5 != 0) {
            int remaining = i5 - this.f21602b.getRemaining();
            this.f21603c -= remaining;
            this.f21601a.skip((long) remaining);
        }
    }

    public final long a(C2356e eVar, long j5) {
        t.e(eVar, "sink");
        int i5 = (j5 > 0 ? 1 : (j5 == 0 ? 0 : -1));
        if (i5 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j5).toString());
        } else if (this.f21604d) {
            throw new IllegalStateException("closed");
        } else if (i5 == 0) {
            return 0;
        } else {
            try {
                U C4 = eVar.C(1);
                d();
                int inflate = this.f21602b.inflate(C4.f21513a, C4.f21515c, (int) Math.min(j5, (long) (8192 - C4.f21515c)));
                l();
                if (inflate > 0) {
                    C4.f21515c += inflate;
                    long j6 = (long) inflate;
                    eVar.z(eVar.size() + j6);
                    return j6;
                }
                if (C4.f21514b == C4.f21515c) {
                    eVar.f21556a = C4.b();
                    V.b(C4);
                }
                return 0;
            } catch (DataFormatException e5) {
                throw new IOException(e5);
            }
        }
    }

    public void close() {
        if (!this.f21604d) {
            this.f21602b.end();
            this.f21604d = true;
            this.f21601a.close();
        }
    }

    public final boolean d() {
        if (!this.f21602b.needsInput()) {
            return false;
        }
        if (this.f21601a.exhausted()) {
            return true;
        }
        U u5 = this.f21601a.g().f21556a;
        t.b(u5);
        int i5 = u5.f21515c;
        int i6 = u5.f21514b;
        int i7 = i5 - i6;
        this.f21603c = i7;
        this.f21602b.setInput(u5.f21513a, i6, i7);
        return false;
    }

    public long e(C2356e eVar, long j5) {
        t.e(eVar, "sink");
        do {
            long a5 = a(eVar, j5);
            if (a5 > 0) {
                return a5;
            }
            if (this.f21602b.finished() || this.f21602b.needsDictionary()) {
                return -1;
            }
        } while (!this.f21601a.exhausted());
        throw new EOFException("source exhausted prematurely");
    }

    public a0 timeout() {
        return this.f21601a.timeout();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public C2367p(Z z4, Inflater inflater) {
        this(L.d(z4), inflater);
        t.e(z4, "source");
        t.e(inflater, "inflater");
    }
}
