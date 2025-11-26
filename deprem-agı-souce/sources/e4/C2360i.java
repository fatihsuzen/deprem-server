package e4;

import W2.J;
import java.io.Closeable;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.t;

/* renamed from: e4.i  reason: case insensitive filesystem */
public abstract class C2360i implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f21571a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f21572b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f21573c;

    /* renamed from: d  reason: collision with root package name */
    private final ReentrantLock f21574d = c0.b();

    /* renamed from: e4.i$a */
    private static final class a implements X {

        /* renamed from: a  reason: collision with root package name */
        private final C2360i f21575a;

        /* renamed from: b  reason: collision with root package name */
        private long f21576b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f21577c;

        public a(C2360i iVar, long j5) {
            t.e(iVar, "fileHandle");
            this.f21575a = iVar;
            this.f21576b = j5;
        }

        public void close() {
            if (!this.f21577c) {
                this.f21577c = true;
                ReentrantLock o5 = this.f21575a.o();
                o5.lock();
                try {
                    C2360i iVar = this.f21575a;
                    iVar.f21573c = iVar.f21573c - 1;
                    if (this.f21575a.f21573c == 0) {
                        if (this.f21575a.f21572b) {
                            J j5 = J.f19942a;
                            o5.unlock();
                            this.f21575a.p();
                        }
                    }
                } finally {
                    o5.unlock();
                }
            }
        }

        public void f(C2356e eVar, long j5) {
            t.e(eVar, "source");
            if (!this.f21577c) {
                long j6 = j5;
                this.f21575a.A(this.f21576b, eVar, j6);
                this.f21576b += j6;
                return;
            }
            throw new IllegalStateException("closed");
        }

        public void flush() {
            if (!this.f21577c) {
                this.f21575a.q();
                return;
            }
            throw new IllegalStateException("closed");
        }

        public a0 timeout() {
            return a0.f21531e;
        }
    }

    /* renamed from: e4.i$b */
    private static final class b implements Z {

        /* renamed from: a  reason: collision with root package name */
        private final C2360i f21578a;

        /* renamed from: b  reason: collision with root package name */
        private long f21579b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f21580c;

        public b(C2360i iVar, long j5) {
            t.e(iVar, "fileHandle");
            this.f21578a = iVar;
            this.f21579b = j5;
        }

        public void close() {
            if (!this.f21580c) {
                this.f21580c = true;
                ReentrantLock o5 = this.f21578a.o();
                o5.lock();
                try {
                    C2360i iVar = this.f21578a;
                    iVar.f21573c = iVar.f21573c - 1;
                    if (this.f21578a.f21573c == 0) {
                        if (this.f21578a.f21572b) {
                            J j5 = J.f19942a;
                            o5.unlock();
                            this.f21578a.p();
                        }
                    }
                } finally {
                    o5.unlock();
                }
            }
        }

        public long e(C2356e eVar, long j5) {
            t.e(eVar, "sink");
            if (!this.f21580c) {
                long l5 = this.f21578a.v(this.f21579b, eVar, j5);
                if (l5 != -1) {
                    this.f21579b += l5;
                }
                return l5;
            }
            throw new IllegalStateException("closed");
        }

        public a0 timeout() {
            return a0.f21531e;
        }
    }

    public C2360i(boolean z4) {
        this.f21571a = z4;
    }

    /* access modifiers changed from: private */
    public final void A(long j5, C2356e eVar, long j6) {
        long j7 = j6;
        C2353b.b(eVar.size(), 0, j7);
        long j8 = j5 + j7;
        long j9 = j5;
        while (j9 < j8) {
            U u5 = eVar.f21556a;
            t.b(u5);
            int min = (int) Math.min(j8 - j9, (long) (u5.f21515c - u5.f21514b));
            u(j9, u5.f21513a, u5.f21514b, min);
            u5.f21514b += min;
            long j10 = (long) min;
            j9 += j10;
            eVar.z(eVar.size() - j10);
            if (u5.f21514b == u5.f21515c) {
                eVar.f21556a = u5.b();
                V.b(u5);
            }
        }
    }

    /* access modifiers changed from: private */
    public final long v(long j5, C2356e eVar, long j6) {
        C2356e eVar2 = eVar;
        long j7 = j6;
        if (j7 >= 0) {
            long j8 = j7 + j5;
            long j9 = j5;
            while (true) {
                if (j9 >= j8) {
                    break;
                }
                U C4 = eVar2.C(1);
                byte[] bArr = C4.f21513a;
                int i5 = C4.f21515c;
                int s5 = s(j9, bArr, i5, (int) Math.min(j8 - j9, (long) (8192 - i5)));
                if (s5 == -1) {
                    if (C4.f21514b == C4.f21515c) {
                        eVar2.f21556a = C4.b();
                        V.b(C4);
                    }
                    if (j5 == j9) {
                        return -1;
                    }
                } else {
                    C4.f21515c += s5;
                    long j10 = (long) s5;
                    j9 += j10;
                    eVar2.z(eVar2.size() + j10);
                }
            }
            return j9 - j5;
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j7).toString());
    }

    public static /* synthetic */ X y(C2360i iVar, long j5, int i5, Object obj) {
        if (obj == null) {
            if ((i5 & 1) != 0) {
                j5 = 0;
            }
            return iVar.x(j5);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
    }

    public final void close() {
        ReentrantLock reentrantLock = this.f21574d;
        reentrantLock.lock();
        try {
            if (!this.f21572b) {
                this.f21572b = true;
                if (this.f21573c != 0) {
                    reentrantLock.unlock();
                    return;
                }
                J j5 = J.f19942a;
                reentrantLock.unlock();
                p();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public final void flush() {
        if (this.f21571a) {
            ReentrantLock reentrantLock = this.f21574d;
            reentrantLock.lock();
            try {
                if (!this.f21572b) {
                    J j5 = J.f19942a;
                    reentrantLock.unlock();
                    q();
                    return;
                }
                throw new IllegalStateException("closed");
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        } else {
            throw new IllegalStateException("file handle is read-only");
        }
    }

    public final ReentrantLock o() {
        return this.f21574d;
    }

    /* access modifiers changed from: protected */
    public abstract void p();

    /* access modifiers changed from: protected */
    public abstract void q();

    /* access modifiers changed from: protected */
    public abstract int s(long j5, byte[] bArr, int i5, int i6);

    /* JADX INFO: finally extract failed */
    public final long size() {
        ReentrantLock reentrantLock = this.f21574d;
        reentrantLock.lock();
        try {
            if (!this.f21572b) {
                J j5 = J.f19942a;
                reentrantLock.unlock();
                return t();
            }
            throw new IllegalStateException("closed");
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public abstract long t();

    /* access modifiers changed from: protected */
    public abstract void u(long j5, byte[] bArr, int i5, int i6);

    /* JADX INFO: finally extract failed */
    public final X x(long j5) {
        if (this.f21571a) {
            ReentrantLock reentrantLock = this.f21574d;
            reentrantLock.lock();
            try {
                if (!this.f21572b) {
                    this.f21573c++;
                    reentrantLock.unlock();
                    return new a(this, j5);
                }
                throw new IllegalStateException("closed");
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        } else {
            throw new IllegalStateException("file handle is read-only");
        }
    }

    /* JADX INFO: finally extract failed */
    public final Z z(long j5) {
        ReentrantLock reentrantLock = this.f21574d;
        reentrantLock.lock();
        try {
            if (!this.f21572b) {
                this.f21573c++;
                reentrantLock.unlock();
                return new b(this, j5);
            }
            throw new IllegalStateException("closed");
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
