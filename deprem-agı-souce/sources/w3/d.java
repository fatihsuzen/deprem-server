package W3;

import c4.f;
import e4.C2357f;
import e4.L;
import e4.X;
import e4.Z;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class d implements Closeable, Flushable {

    /* renamed from: u  reason: collision with root package name */
    static final Pattern f20002u = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: a  reason: collision with root package name */
    final b4.a f20003a;

    /* renamed from: b  reason: collision with root package name */
    final File f20004b;

    /* renamed from: c  reason: collision with root package name */
    private final File f20005c;

    /* renamed from: d  reason: collision with root package name */
    private final File f20006d;

    /* renamed from: e  reason: collision with root package name */
    private final File f20007e;

    /* renamed from: f  reason: collision with root package name */
    private final int f20008f;

    /* renamed from: g  reason: collision with root package name */
    private long f20009g;

    /* renamed from: h  reason: collision with root package name */
    final int f20010h;

    /* renamed from: i  reason: collision with root package name */
    private long f20011i = 0;

    /* renamed from: j  reason: collision with root package name */
    C2357f f20012j;

    /* renamed from: k  reason: collision with root package name */
    final LinkedHashMap f20013k = new LinkedHashMap(0, 0.75f, true);

    /* renamed from: l  reason: collision with root package name */
    int f20014l;

    /* renamed from: m  reason: collision with root package name */
    boolean f20015m;

    /* renamed from: n  reason: collision with root package name */
    boolean f20016n;

    /* renamed from: o  reason: collision with root package name */
    boolean f20017o;

    /* renamed from: p  reason: collision with root package name */
    boolean f20018p;

    /* renamed from: q  reason: collision with root package name */
    boolean f20019q;

    /* renamed from: r  reason: collision with root package name */
    private long f20020r = 0;

    /* renamed from: s  reason: collision with root package name */
    private final Executor f20021s;

    /* renamed from: t  reason: collision with root package name */
    private final Runnable f20022t = new a();

    class a implements Runnable {
        a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            r1 = r5.f20023a;
            r1.f20019q = true;
            r1.f20012j = e4.L.c(e4.L.b());
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0016 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x002d */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r5 = this;
                W3.d r0 = W3.d.this
                monitor-enter(r0)
                W3.d r1 = W3.d.this     // Catch:{ all -> 0x0010 }
                boolean r2 = r1.f20016n     // Catch:{ all -> 0x0010 }
                r3 = 1
                r2 = r2 ^ r3
                boolean r4 = r1.f20017o     // Catch:{ all -> 0x0010 }
                r2 = r2 | r4
                if (r2 == 0) goto L_0x0012
                monitor-exit(r0)     // Catch:{ all -> 0x0010 }
                return
            L_0x0010:
                r1 = move-exception
                goto L_0x003d
            L_0x0012:
                r1.B()     // Catch:{ IOException -> 0x0016 }
                goto L_0x001a
            L_0x0016:
                W3.d r1 = W3.d.this     // Catch:{ all -> 0x0010 }
                r1.f20018p = r3     // Catch:{ all -> 0x0010 }
            L_0x001a:
                W3.d r1 = W3.d.this     // Catch:{ IOException -> 0x002d }
                boolean r1 = r1.s()     // Catch:{ IOException -> 0x002d }
                if (r1 == 0) goto L_0x003b
                W3.d r1 = W3.d.this     // Catch:{ IOException -> 0x002d }
                r1.y()     // Catch:{ IOException -> 0x002d }
                W3.d r1 = W3.d.this     // Catch:{ IOException -> 0x002d }
                r2 = 0
                r1.f20014l = r2     // Catch:{ IOException -> 0x002d }
                goto L_0x003b
            L_0x002d:
                W3.d r1 = W3.d.this     // Catch:{ all -> 0x0010 }
                r1.f20019q = r3     // Catch:{ all -> 0x0010 }
                e4.X r2 = e4.L.b()     // Catch:{ all -> 0x0010 }
                e4.f r2 = e4.L.c(r2)     // Catch:{ all -> 0x0010 }
                r1.f20012j = r2     // Catch:{ all -> 0x0010 }
            L_0x003b:
                monitor-exit(r0)     // Catch:{ all -> 0x0010 }
                return
            L_0x003d:
                monitor-exit(r0)     // Catch:{ all -> 0x0010 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: W3.d.a.run():void");
        }
    }

    class b extends e {
        b(X x4) {
            super(x4);
        }

        /* access modifiers changed from: protected */
        public void a(IOException iOException) {
            d.this.f20015m = true;
        }
    }

    public final class c {

        /* renamed from: a  reason: collision with root package name */
        final C0192d f20025a;

        /* renamed from: b  reason: collision with root package name */
        final boolean[] f20026b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f20027c;

        class a extends e {
            a(X x4) {
                super(x4);
            }

            /* access modifiers changed from: protected */
            public void a(IOException iOException) {
                synchronized (d.this) {
                    c.this.c();
                }
            }
        }

        c(C0192d dVar) {
            boolean[] zArr;
            this.f20025a = dVar;
            if (dVar.f20034e) {
                zArr = null;
            } else {
                zArr = new boolean[d.this.f20010h];
            }
            this.f20026b = zArr;
        }

        public void a() {
            synchronized (d.this) {
                try {
                    if (!this.f20027c) {
                        if (this.f20025a.f20035f == this) {
                            d.this.d(this, false);
                        }
                        this.f20027c = true;
                    } else {
                        throw new IllegalStateException();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void b() {
            synchronized (d.this) {
                try {
                    if (!this.f20027c) {
                        if (this.f20025a.f20035f == this) {
                            d.this.d(this, true);
                        }
                        this.f20027c = true;
                    } else {
                        throw new IllegalStateException();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            if (this.f20025a.f20035f == this) {
                int i5 = 0;
                while (true) {
                    d dVar = d.this;
                    if (i5 < dVar.f20010h) {
                        try {
                            dVar.f20003a.delete(this.f20025a.f20033d[i5]);
                        } catch (IOException unused) {
                        }
                        i5++;
                    } else {
                        this.f20025a.f20035f = null;
                        return;
                    }
                }
            }
        }

        public X d(int i5) {
            synchronized (d.this) {
                try {
                    if (!this.f20027c) {
                        C0192d dVar = this.f20025a;
                        if (dVar.f20035f != this) {
                            X b5 = L.b();
                            return b5;
                        }
                        if (!dVar.f20034e) {
                            this.f20026b[i5] = true;
                        }
                        a aVar = new a(d.this.f20003a.sink(dVar.f20033d[i5]));
                        return aVar;
                    }
                    throw new IllegalStateException();
                } catch (FileNotFoundException unused) {
                    return L.b();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* renamed from: W3.d$d  reason: collision with other inner class name */
    private final class C0192d {

        /* renamed from: a  reason: collision with root package name */
        final String f20030a;

        /* renamed from: b  reason: collision with root package name */
        final long[] f20031b;

        /* renamed from: c  reason: collision with root package name */
        final File[] f20032c;

        /* renamed from: d  reason: collision with root package name */
        final File[] f20033d;

        /* renamed from: e  reason: collision with root package name */
        boolean f20034e;

        /* renamed from: f  reason: collision with root package name */
        c f20035f;

        /* renamed from: g  reason: collision with root package name */
        long f20036g;

        C0192d(String str) {
            this.f20030a = str;
            int i5 = d.this.f20010h;
            this.f20031b = new long[i5];
            this.f20032c = new File[i5];
            this.f20033d = new File[i5];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i6 = 0; i6 < d.this.f20010h; i6++) {
                sb.append(i6);
                this.f20032c[i6] = new File(d.this.f20004b, sb.toString());
                sb.append(".tmp");
                this.f20033d[i6] = new File(d.this.f20004b, sb.toString());
                sb.setLength(length);
            }
        }

        private IOException a(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* access modifiers changed from: package-private */
        public void b(String[] strArr) {
            if (strArr.length == d.this.f20010h) {
                int i5 = 0;
                while (i5 < strArr.length) {
                    try {
                        this.f20031b[i5] = Long.parseLong(strArr[i5]);
                        i5++;
                    } catch (NumberFormatException unused) {
                        throw a(strArr);
                    }
                }
                return;
            }
            throw a(strArr);
        }

        /* access modifiers changed from: package-private */
        public e c() {
            Z z4;
            if (Thread.holdsLock(d.this)) {
                Z[] zArr = new Z[d.this.f20010h];
                long[] jArr = (long[]) this.f20031b.clone();
                int i5 = 0;
                int i6 = 0;
                while (true) {
                    try {
                        d dVar = d.this;
                        if (i6 >= dVar.f20010h) {
                            return new e(this.f20030a, this.f20036g, zArr, jArr);
                        }
                        zArr[i6] = dVar.f20003a.source(this.f20032c[i6]);
                        i6++;
                    } catch (FileNotFoundException unused) {
                        while (true) {
                            d dVar2 = d.this;
                            if (i5 >= dVar2.f20010h || (z4 = zArr[i5]) == null) {
                                try {
                                    dVar2.A(this);
                                    return null;
                                } catch (IOException unused2) {
                                    return null;
                                }
                            } else {
                                V3.c.d(z4);
                                i5++;
                            }
                        }
                    }
                }
            } else {
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: package-private */
        public void d(C2357f fVar) {
            for (long writeDecimalLong : this.f20031b) {
                fVar.writeByte(32).writeDecimalLong(writeDecimalLong);
            }
        }
    }

    public final class e implements Closeable {

        /* renamed from: a  reason: collision with root package name */
        private final String f20038a;

        /* renamed from: b  reason: collision with root package name */
        private final long f20039b;

        /* renamed from: c  reason: collision with root package name */
        private final Z[] f20040c;

        /* renamed from: d  reason: collision with root package name */
        private final long[] f20041d;

        e(String str, long j5, Z[] zArr, long[] jArr) {
            this.f20038a = str;
            this.f20039b = j5;
            this.f20040c = zArr;
            this.f20041d = jArr;
        }

        public c a() {
            return d.this.o(this.f20038a, this.f20039b);
        }

        public void close() {
            for (Z d5 : this.f20040c) {
                V3.c.d(d5);
            }
        }

        public Z d(int i5) {
            return this.f20040c[i5];
        }
    }

    d(b4.a aVar, File file, int i5, int i6, long j5, Executor executor) {
        this.f20003a = aVar;
        this.f20004b = file;
        this.f20008f = i5;
        this.f20005c = new File(file, "journal");
        this.f20006d = new File(file, "journal.tmp");
        this.f20007e = new File(file, "journal.bkp");
        this.f20010h = i6;
        this.f20009g = j5;
        this.f20021s = executor;
    }

    private void C(String str) {
        if (!f20002u.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    private synchronized void a() {
        if (isClosed()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public static d l(b4.a aVar, File file, int i5, int i6, long j5) {
        if (j5 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i6 > 0) {
            return new d(aVar, file, i5, i6, j5, new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), V3.c.B("OkHttp DiskLruCache", true)));
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    private C2357f t() {
        return L.c(new b(this.f20003a.appendingSink(this.f20005c)));
    }

    private void u() {
        this.f20003a.delete(this.f20006d);
        Iterator it = this.f20013k.values().iterator();
        while (it.hasNext()) {
            C0192d dVar = (C0192d) it.next();
            int i5 = 0;
            if (dVar.f20035f == null) {
                while (i5 < this.f20010h) {
                    this.f20011i += dVar.f20031b[i5];
                    i5++;
                }
            } else {
                dVar.f20035f = null;
                while (i5 < this.f20010h) {
                    this.f20003a.delete(dVar.f20032c[i5]);
                    this.f20003a.delete(dVar.f20033d[i5]);
                    i5++;
                }
                it.remove();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:17|18|(1:20)(1:21)|22|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r9.f20014l = r0 - r9.f20013k.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006c, code lost:
        if (r1.exhausted() == false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006e, code lost:
        y();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0072, code lost:
        r9.f20012j = t();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007b, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x005f */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:24:0x007c=Splitter:B:24:0x007c, B:17:0x005f=Splitter:B:17:0x005f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void v() {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            b4.a r1 = r9.f20003a
            java.io.File r2 = r9.f20005c
            e4.Z r1 = r1.source(r2)
            e4.g r1 = e4.L.d(r1)
            java.lang.String r2 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x005d }
            java.lang.String r3 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x005d }
            java.lang.String r4 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x005d }
            java.lang.String r5 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x005d }
            java.lang.String r6 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x005d }
            java.lang.String r7 = "libcore.io.DiskLruCache"
            boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x005d }
            if (r7 == 0) goto L_0x007c
            java.lang.String r7 = "1"
            boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x005d }
            if (r7 == 0) goto L_0x007c
            int r7 = r9.f20008f     // Catch:{ all -> 0x005d }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x005d }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x005d }
            if (r4 == 0) goto L_0x007c
            int r4 = r9.f20010h     // Catch:{ all -> 0x005d }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x005d }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x005d }
            if (r4 == 0) goto L_0x007c
            java.lang.String r4 = ""
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x005d }
            if (r4 == 0) goto L_0x007c
            r0 = 0
        L_0x0053:
            java.lang.String r2 = r1.readUtf8LineStrict()     // Catch:{ EOFException -> 0x005f }
            r9.x(r2)     // Catch:{ EOFException -> 0x005f }
            int r0 = r0 + 1
            goto L_0x0053
        L_0x005d:
            r0 = move-exception
            goto L_0x00aa
        L_0x005f:
            java.util.LinkedHashMap r2 = r9.f20013k     // Catch:{ all -> 0x005d }
            int r2 = r2.size()     // Catch:{ all -> 0x005d }
            int r0 = r0 - r2
            r9.f20014l = r0     // Catch:{ all -> 0x005d }
            boolean r0 = r1.exhausted()     // Catch:{ all -> 0x005d }
            if (r0 != 0) goto L_0x0072
            r9.y()     // Catch:{ all -> 0x005d }
            goto L_0x0078
        L_0x0072:
            e4.f r0 = r9.t()     // Catch:{ all -> 0x005d }
            r9.f20012j = r0     // Catch:{ all -> 0x005d }
        L_0x0078:
            V3.c.d(r1)
            return
        L_0x007c:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x005d }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x005d }
            r7.<init>()     // Catch:{ all -> 0x005d }
            java.lang.String r8 = "unexpected journal header: ["
            r7.append(r8)     // Catch:{ all -> 0x005d }
            r7.append(r2)     // Catch:{ all -> 0x005d }
            r7.append(r0)     // Catch:{ all -> 0x005d }
            r7.append(r3)     // Catch:{ all -> 0x005d }
            r7.append(r0)     // Catch:{ all -> 0x005d }
            r7.append(r5)     // Catch:{ all -> 0x005d }
            r7.append(r0)     // Catch:{ all -> 0x005d }
            r7.append(r6)     // Catch:{ all -> 0x005d }
            java.lang.String r0 = "]"
            r7.append(r0)     // Catch:{ all -> 0x005d }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x005d }
            r4.<init>(r0)     // Catch:{ all -> 0x005d }
            throw r4     // Catch:{ all -> 0x005d }
        L_0x00aa:
            V3.c.d(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: W3.d.v():void");
    }

    private void x(String str) {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i5 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i5);
            if (indexOf2 == -1) {
                str2 = str.substring(i5);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.f20013k.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i5, indexOf2);
            }
            C0192d dVar = (C0192d) this.f20013k.get(str2);
            if (dVar == null) {
                dVar = new C0192d(str2);
                this.f20013k.put(str2, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.f20034e = true;
                dVar.f20035f = null;
                dVar.b(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.f20035f = new c(dVar);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean A(C0192d dVar) {
        c cVar = dVar.f20035f;
        if (cVar != null) {
            cVar.c();
        }
        for (int i5 = 0; i5 < this.f20010h; i5++) {
            this.f20003a.delete(dVar.f20032c[i5]);
            long j5 = this.f20011i;
            long[] jArr = dVar.f20031b;
            this.f20011i = j5 - jArr[i5];
            jArr[i5] = 0;
        }
        this.f20014l++;
        this.f20012j.writeUtf8("REMOVE").writeByte(32).writeUtf8(dVar.f20030a).writeByte(10);
        this.f20013k.remove(dVar.f20030a);
        if (s()) {
            this.f20021s.execute(this.f20022t);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void B() {
        while (this.f20011i > this.f20009g) {
            A((C0192d) this.f20013k.values().iterator().next());
        }
        this.f20018p = false;
    }

    public synchronized void close() {
        try {
            if (this.f20016n) {
                if (!this.f20017o) {
                    for (C0192d dVar : (C0192d[]) this.f20013k.values().toArray(new C0192d[this.f20013k.size()])) {
                        c cVar = dVar.f20035f;
                        if (cVar != null) {
                            cVar.a();
                        }
                    }
                    B();
                    this.f20012j.close();
                    this.f20012j = null;
                    this.f20017o = true;
                    return;
                }
            }
            this.f20017o = true;
        } finally {
            while (true) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f7, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void d(W3.d.c r10, boolean r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            W3.d$d r0 = r10.f20025a     // Catch:{ all -> 0x002a }
            W3.d$c r1 = r0.f20035f     // Catch:{ all -> 0x002a }
            if (r1 != r10) goto L_0x00f8
            r1 = 0
            if (r11 == 0) goto L_0x004a
            boolean r2 = r0.f20034e     // Catch:{ all -> 0x002a }
            if (r2 != 0) goto L_0x004a
            r2 = r1
        L_0x000f:
            int r3 = r9.f20010h     // Catch:{ all -> 0x002a }
            if (r2 >= r3) goto L_0x004a
            boolean[] r3 = r10.f20026b     // Catch:{ all -> 0x002a }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x002a }
            if (r3 == 0) goto L_0x0030
            b4.a r3 = r9.f20003a     // Catch:{ all -> 0x002a }
            java.io.File[] r4 = r0.f20033d     // Catch:{ all -> 0x002a }
            r4 = r4[r2]     // Catch:{ all -> 0x002a }
            boolean r3 = r3.exists(r4)     // Catch:{ all -> 0x002a }
            if (r3 != 0) goto L_0x002d
            r10.a()     // Catch:{ all -> 0x002a }
            monitor-exit(r9)
            return
        L_0x002a:
            r10 = move-exception
            goto L_0x00fe
        L_0x002d:
            int r2 = r2 + 1
            goto L_0x000f
        L_0x0030:
            r10.a()     // Catch:{ all -> 0x002a }
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x002a }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x002a }
            r11.<init>()     // Catch:{ all -> 0x002a }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r11.append(r0)     // Catch:{ all -> 0x002a }
            r11.append(r2)     // Catch:{ all -> 0x002a }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x002a }
            r10.<init>(r11)     // Catch:{ all -> 0x002a }
            throw r10     // Catch:{ all -> 0x002a }
        L_0x004a:
            int r10 = r9.f20010h     // Catch:{ all -> 0x002a }
            if (r1 >= r10) goto L_0x0082
            java.io.File[] r10 = r0.f20033d     // Catch:{ all -> 0x002a }
            r10 = r10[r1]     // Catch:{ all -> 0x002a }
            if (r11 == 0) goto L_0x007a
            b4.a r2 = r9.f20003a     // Catch:{ all -> 0x002a }
            boolean r2 = r2.exists(r10)     // Catch:{ all -> 0x002a }
            if (r2 == 0) goto L_0x007f
            java.io.File[] r2 = r0.f20032c     // Catch:{ all -> 0x002a }
            r2 = r2[r1]     // Catch:{ all -> 0x002a }
            b4.a r3 = r9.f20003a     // Catch:{ all -> 0x002a }
            r3.rename(r10, r2)     // Catch:{ all -> 0x002a }
            long[] r10 = r0.f20031b     // Catch:{ all -> 0x002a }
            r3 = r10[r1]     // Catch:{ all -> 0x002a }
            b4.a r10 = r9.f20003a     // Catch:{ all -> 0x002a }
            long r5 = r10.size(r2)     // Catch:{ all -> 0x002a }
            long[] r10 = r0.f20031b     // Catch:{ all -> 0x002a }
            r10[r1] = r5     // Catch:{ all -> 0x002a }
            long r7 = r9.f20011i     // Catch:{ all -> 0x002a }
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.f20011i = r7     // Catch:{ all -> 0x002a }
            goto L_0x007f
        L_0x007a:
            b4.a r2 = r9.f20003a     // Catch:{ all -> 0x002a }
            r2.delete(r10)     // Catch:{ all -> 0x002a }
        L_0x007f:
            int r1 = r1 + 1
            goto L_0x004a
        L_0x0082:
            int r10 = r9.f20014l     // Catch:{ all -> 0x002a }
            r1 = 1
            int r10 = r10 + r1
            r9.f20014l = r10     // Catch:{ all -> 0x002a }
            r10 = 0
            r0.f20035f = r10     // Catch:{ all -> 0x002a }
            boolean r10 = r0.f20034e     // Catch:{ all -> 0x002a }
            r10 = r10 | r11
            r2 = 10
            r3 = 32
            if (r10 == 0) goto L_0x00be
            r0.f20034e = r1     // Catch:{ all -> 0x002a }
            e4.f r10 = r9.f20012j     // Catch:{ all -> 0x002a }
            java.lang.String r1 = "CLEAN"
            e4.f r10 = r10.writeUtf8(r1)     // Catch:{ all -> 0x002a }
            r10.writeByte(r3)     // Catch:{ all -> 0x002a }
            e4.f r10 = r9.f20012j     // Catch:{ all -> 0x002a }
            java.lang.String r1 = r0.f20030a     // Catch:{ all -> 0x002a }
            r10.writeUtf8(r1)     // Catch:{ all -> 0x002a }
            e4.f r10 = r9.f20012j     // Catch:{ all -> 0x002a }
            r0.d(r10)     // Catch:{ all -> 0x002a }
            e4.f r10 = r9.f20012j     // Catch:{ all -> 0x002a }
            r10.writeByte(r2)     // Catch:{ all -> 0x002a }
            if (r11 == 0) goto L_0x00dc
            long r10 = r9.f20020r     // Catch:{ all -> 0x002a }
            r1 = 1
            long r1 = r1 + r10
            r9.f20020r = r1     // Catch:{ all -> 0x002a }
            r0.f20036g = r10     // Catch:{ all -> 0x002a }
            goto L_0x00dc
        L_0x00be:
            java.util.LinkedHashMap r10 = r9.f20013k     // Catch:{ all -> 0x002a }
            java.lang.String r11 = r0.f20030a     // Catch:{ all -> 0x002a }
            r10.remove(r11)     // Catch:{ all -> 0x002a }
            e4.f r10 = r9.f20012j     // Catch:{ all -> 0x002a }
            java.lang.String r11 = "REMOVE"
            e4.f r10 = r10.writeUtf8(r11)     // Catch:{ all -> 0x002a }
            r10.writeByte(r3)     // Catch:{ all -> 0x002a }
            e4.f r10 = r9.f20012j     // Catch:{ all -> 0x002a }
            java.lang.String r11 = r0.f20030a     // Catch:{ all -> 0x002a }
            r10.writeUtf8(r11)     // Catch:{ all -> 0x002a }
            e4.f r10 = r9.f20012j     // Catch:{ all -> 0x002a }
            r10.writeByte(r2)     // Catch:{ all -> 0x002a }
        L_0x00dc:
            e4.f r10 = r9.f20012j     // Catch:{ all -> 0x002a }
            r10.flush()     // Catch:{ all -> 0x002a }
            long r10 = r9.f20011i     // Catch:{ all -> 0x002a }
            long r0 = r9.f20009g     // Catch:{ all -> 0x002a }
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 > 0) goto L_0x00ef
            boolean r10 = r9.s()     // Catch:{ all -> 0x002a }
            if (r10 == 0) goto L_0x00f6
        L_0x00ef:
            java.util.concurrent.Executor r10 = r9.f20021s     // Catch:{ all -> 0x002a }
            java.lang.Runnable r11 = r9.f20022t     // Catch:{ all -> 0x002a }
            r10.execute(r11)     // Catch:{ all -> 0x002a }
        L_0x00f6:
            monitor-exit(r9)
            return
        L_0x00f8:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x002a }
            r10.<init>()     // Catch:{ all -> 0x002a }
            throw r10     // Catch:{ all -> 0x002a }
        L_0x00fe:
            monitor-exit(r9)     // Catch:{ all -> 0x002a }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: W3.d.d(W3.d$c, boolean):void");
    }

    public synchronized void flush() {
        if (this.f20016n) {
            a();
            B();
            this.f20012j.flush();
        }
    }

    public synchronized boolean isClosed() {
        return this.f20017o;
    }

    public void m() {
        close();
        this.f20003a.deleteContents(this.f20004b);
    }

    public c n(String str) {
        return o(str, -1);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized W3.d.c o(java.lang.String r6, long r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.q()     // Catch:{ all -> 0x0022 }
            r5.a()     // Catch:{ all -> 0x0022 }
            r5.C(r6)     // Catch:{ all -> 0x0022 }
            java.util.LinkedHashMap r0 = r5.f20013k     // Catch:{ all -> 0x0022 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0022 }
            W3.d$d r0 = (W3.d.C0192d) r0     // Catch:{ all -> 0x0022 }
            r1 = -1
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            r2 = 0
            if (r1 == 0) goto L_0x0026
            if (r0 == 0) goto L_0x0024
            long r3 = r0.f20036g     // Catch:{ all -> 0x0022 }
            int r7 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r7 == 0) goto L_0x0026
            goto L_0x0024
        L_0x0022:
            r6 = move-exception
            goto L_0x0077
        L_0x0024:
            monitor-exit(r5)
            return r2
        L_0x0026:
            if (r0 == 0) goto L_0x002e
            W3.d$c r7 = r0.f20035f     // Catch:{ all -> 0x0022 }
            if (r7 == 0) goto L_0x002e
            monitor-exit(r5)
            return r2
        L_0x002e:
            boolean r7 = r5.f20018p     // Catch:{ all -> 0x0022 }
            if (r7 != 0) goto L_0x006e
            boolean r7 = r5.f20019q     // Catch:{ all -> 0x0022 }
            if (r7 == 0) goto L_0x0037
            goto L_0x006e
        L_0x0037:
            e4.f r7 = r5.f20012j     // Catch:{ all -> 0x0022 }
            java.lang.String r8 = "DIRTY"
            e4.f r7 = r7.writeUtf8(r8)     // Catch:{ all -> 0x0022 }
            r8 = 32
            e4.f r7 = r7.writeByte(r8)     // Catch:{ all -> 0x0022 }
            e4.f r7 = r7.writeUtf8(r6)     // Catch:{ all -> 0x0022 }
            r8 = 10
            r7.writeByte(r8)     // Catch:{ all -> 0x0022 }
            e4.f r7 = r5.f20012j     // Catch:{ all -> 0x0022 }
            r7.flush()     // Catch:{ all -> 0x0022 }
            boolean r7 = r5.f20015m     // Catch:{ all -> 0x0022 }
            if (r7 == 0) goto L_0x0059
            monitor-exit(r5)
            return r2
        L_0x0059:
            if (r0 != 0) goto L_0x0065
            W3.d$d r0 = new W3.d$d     // Catch:{ all -> 0x0022 }
            r0.<init>(r6)     // Catch:{ all -> 0x0022 }
            java.util.LinkedHashMap r7 = r5.f20013k     // Catch:{ all -> 0x0022 }
            r7.put(r6, r0)     // Catch:{ all -> 0x0022 }
        L_0x0065:
            W3.d$c r6 = new W3.d$c     // Catch:{ all -> 0x0022 }
            r6.<init>(r0)     // Catch:{ all -> 0x0022 }
            r0.f20035f = r6     // Catch:{ all -> 0x0022 }
            monitor-exit(r5)
            return r6
        L_0x006e:
            java.util.concurrent.Executor r6 = r5.f20021s     // Catch:{ all -> 0x0022 }
            java.lang.Runnable r7 = r5.f20022t     // Catch:{ all -> 0x0022 }
            r6.execute(r7)     // Catch:{ all -> 0x0022 }
            monitor-exit(r5)
            return r2
        L_0x0077:
            monitor-exit(r5)     // Catch:{ all -> 0x0022 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: W3.d.o(java.lang.String, long):W3.d$c");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0050, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized W3.d.e p(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.q()     // Catch:{ all -> 0x004d }
            r3.a()     // Catch:{ all -> 0x004d }
            r3.C(r4)     // Catch:{ all -> 0x004d }
            java.util.LinkedHashMap r0 = r3.f20013k     // Catch:{ all -> 0x004d }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x004d }
            W3.d$d r0 = (W3.d.C0192d) r0     // Catch:{ all -> 0x004d }
            r1 = 0
            if (r0 == 0) goto L_0x0051
            boolean r2 = r0.f20034e     // Catch:{ all -> 0x004d }
            if (r2 != 0) goto L_0x001a
            goto L_0x0051
        L_0x001a:
            W3.d$e r0 = r0.c()     // Catch:{ all -> 0x004d }
            if (r0 != 0) goto L_0x0022
            monitor-exit(r3)
            return r1
        L_0x0022:
            int r1 = r3.f20014l     // Catch:{ all -> 0x004d }
            int r1 = r1 + 1
            r3.f20014l = r1     // Catch:{ all -> 0x004d }
            e4.f r1 = r3.f20012j     // Catch:{ all -> 0x004d }
            java.lang.String r2 = "READ"
            e4.f r1 = r1.writeUtf8(r2)     // Catch:{ all -> 0x004d }
            r2 = 32
            e4.f r1 = r1.writeByte(r2)     // Catch:{ all -> 0x004d }
            e4.f r4 = r1.writeUtf8(r4)     // Catch:{ all -> 0x004d }
            r1 = 10
            r4.writeByte(r1)     // Catch:{ all -> 0x004d }
            boolean r4 = r3.s()     // Catch:{ all -> 0x004d }
            if (r4 == 0) goto L_0x004f
            java.util.concurrent.Executor r4 = r3.f20021s     // Catch:{ all -> 0x004d }
            java.lang.Runnable r1 = r3.f20022t     // Catch:{ all -> 0x004d }
            r4.execute(r1)     // Catch:{ all -> 0x004d }
            goto L_0x004f
        L_0x004d:
            r4 = move-exception
            goto L_0x0053
        L_0x004f:
            monitor-exit(r3)
            return r0
        L_0x0051:
            monitor-exit(r3)
            return r1
        L_0x0053:
            monitor-exit(r3)     // Catch:{ all -> 0x004d }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: W3.d.p(java.lang.String):W3.d$e");
    }

    public synchronized void q() {
        try {
            if (!this.f20016n) {
                if (this.f20003a.exists(this.f20007e)) {
                    if (this.f20003a.exists(this.f20005c)) {
                        this.f20003a.delete(this.f20007e);
                    } else {
                        this.f20003a.rename(this.f20007e, this.f20005c);
                    }
                }
                if (this.f20003a.exists(this.f20005c)) {
                    v();
                    u();
                    this.f20016n = true;
                    return;
                }
                y();
                this.f20016n = true;
            }
        } catch (IOException e5) {
            f i5 = f.i();
            i5.p(5, "DiskLruCache " + this.f20004b + " is corrupt: " + e5.getMessage() + ", removing", e5);
            m();
            this.f20017o = false;
        } catch (Throwable th) {
            this.f20017o = false;
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean s() {
        int i5 = this.f20014l;
        if (i5 < 2000 || i5 < this.f20013k.size()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0071, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00be, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void y() {
        /*
            r6 = this;
            monitor-enter(r6)
            e4.f r0 = r6.f20012j     // Catch:{ all -> 0x0009 }
            if (r0 == 0) goto L_0x000c
            r0.close()     // Catch:{ all -> 0x0009 }
            goto L_0x000c
        L_0x0009:
            r0 = move-exception
            goto L_0x00bf
        L_0x000c:
            b4.a r0 = r6.f20003a     // Catch:{ all -> 0x0009 }
            java.io.File r1 = r6.f20006d     // Catch:{ all -> 0x0009 }
            e4.X r0 = r0.sink(r1)     // Catch:{ all -> 0x0009 }
            e4.f r0 = e4.L.c(r0)     // Catch:{ all -> 0x0009 }
            java.lang.String r1 = "libcore.io.DiskLruCache"
            e4.f r1 = r0.writeUtf8(r1)     // Catch:{ all -> 0x0071 }
            r2 = 10
            r1.writeByte(r2)     // Catch:{ all -> 0x0071 }
            java.lang.String r1 = "1"
            e4.f r1 = r0.writeUtf8(r1)     // Catch:{ all -> 0x0071 }
            r1.writeByte(r2)     // Catch:{ all -> 0x0071 }
            int r1 = r6.f20008f     // Catch:{ all -> 0x0071 }
            long r3 = (long) r1     // Catch:{ all -> 0x0071 }
            e4.f r1 = r0.writeDecimalLong(r3)     // Catch:{ all -> 0x0071 }
            r1.writeByte(r2)     // Catch:{ all -> 0x0071 }
            int r1 = r6.f20010h     // Catch:{ all -> 0x0071 }
            long r3 = (long) r1     // Catch:{ all -> 0x0071 }
            e4.f r1 = r0.writeDecimalLong(r3)     // Catch:{ all -> 0x0071 }
            r1.writeByte(r2)     // Catch:{ all -> 0x0071 }
            r0.writeByte(r2)     // Catch:{ all -> 0x0071 }
            java.util.LinkedHashMap r1 = r6.f20013k     // Catch:{ all -> 0x0071 }
            java.util.Collection r1 = r1.values()     // Catch:{ all -> 0x0071 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0071 }
        L_0x004d:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x0071 }
            if (r3 == 0) goto L_0x0088
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x0071 }
            W3.d$d r3 = (W3.d.C0192d) r3     // Catch:{ all -> 0x0071 }
            W3.d$c r4 = r3.f20035f     // Catch:{ all -> 0x0071 }
            r5 = 32
            if (r4 == 0) goto L_0x0073
            java.lang.String r4 = "DIRTY"
            e4.f r4 = r0.writeUtf8(r4)     // Catch:{ all -> 0x0071 }
            r4.writeByte(r5)     // Catch:{ all -> 0x0071 }
            java.lang.String r3 = r3.f20030a     // Catch:{ all -> 0x0071 }
            r0.writeUtf8(r3)     // Catch:{ all -> 0x0071 }
            r0.writeByte(r2)     // Catch:{ all -> 0x0071 }
            goto L_0x004d
        L_0x0071:
            r1 = move-exception
            goto L_0x00bb
        L_0x0073:
            java.lang.String r4 = "CLEAN"
            e4.f r4 = r0.writeUtf8(r4)     // Catch:{ all -> 0x0071 }
            r4.writeByte(r5)     // Catch:{ all -> 0x0071 }
            java.lang.String r4 = r3.f20030a     // Catch:{ all -> 0x0071 }
            r0.writeUtf8(r4)     // Catch:{ all -> 0x0071 }
            r3.d(r0)     // Catch:{ all -> 0x0071 }
            r0.writeByte(r2)     // Catch:{ all -> 0x0071 }
            goto L_0x004d
        L_0x0088:
            r0.close()     // Catch:{ all -> 0x0009 }
            b4.a r0 = r6.f20003a     // Catch:{ all -> 0x0009 }
            java.io.File r1 = r6.f20005c     // Catch:{ all -> 0x0009 }
            boolean r0 = r0.exists(r1)     // Catch:{ all -> 0x0009 }
            if (r0 == 0) goto L_0x009e
            b4.a r0 = r6.f20003a     // Catch:{ all -> 0x0009 }
            java.io.File r1 = r6.f20005c     // Catch:{ all -> 0x0009 }
            java.io.File r2 = r6.f20007e     // Catch:{ all -> 0x0009 }
            r0.rename(r1, r2)     // Catch:{ all -> 0x0009 }
        L_0x009e:
            b4.a r0 = r6.f20003a     // Catch:{ all -> 0x0009 }
            java.io.File r1 = r6.f20006d     // Catch:{ all -> 0x0009 }
            java.io.File r2 = r6.f20005c     // Catch:{ all -> 0x0009 }
            r0.rename(r1, r2)     // Catch:{ all -> 0x0009 }
            b4.a r0 = r6.f20003a     // Catch:{ all -> 0x0009 }
            java.io.File r1 = r6.f20007e     // Catch:{ all -> 0x0009 }
            r0.delete(r1)     // Catch:{ all -> 0x0009 }
            e4.f r0 = r6.t()     // Catch:{ all -> 0x0009 }
            r6.f20012j = r0     // Catch:{ all -> 0x0009 }
            r0 = 0
            r6.f20015m = r0     // Catch:{ all -> 0x0009 }
            r6.f20019q = r0     // Catch:{ all -> 0x0009 }
            monitor-exit(r6)
            return
        L_0x00bb:
            r0.close()     // Catch:{ all -> 0x0009 }
            throw r1     // Catch:{ all -> 0x0009 }
        L_0x00bf:
            monitor-exit(r6)     // Catch:{ all -> 0x0009 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: W3.d.y():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002b, code lost:
        return r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean z(java.lang.String r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.q()     // Catch:{ all -> 0x0028 }
            r5.a()     // Catch:{ all -> 0x0028 }
            r5.C(r6)     // Catch:{ all -> 0x0028 }
            java.util.LinkedHashMap r0 = r5.f20013k     // Catch:{ all -> 0x0028 }
            java.lang.Object r6 = r0.get(r6)     // Catch:{ all -> 0x0028 }
            W3.d$d r6 = (W3.d.C0192d) r6     // Catch:{ all -> 0x0028 }
            r0 = 0
            if (r6 != 0) goto L_0x0017
            monitor-exit(r5)
            return r0
        L_0x0017:
            boolean r6 = r5.A(r6)     // Catch:{ all -> 0x0028 }
            if (r6 == 0) goto L_0x002a
            long r1 = r5.f20011i     // Catch:{ all -> 0x0028 }
            long r3 = r5.f20009g     // Catch:{ all -> 0x0028 }
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x002a
            r5.f20018p = r0     // Catch:{ all -> 0x0028 }
            goto L_0x002a
        L_0x0028:
            r6 = move-exception
            goto L_0x002c
        L_0x002a:
            monitor-exit(r5)
            return r6
        L_0x002c:
            monitor-exit(r5)     // Catch:{ all -> 0x0028 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: W3.d.z(java.lang.String):boolean");
    }
}
