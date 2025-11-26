package e2;

import c2.C2314a;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.List;

/* renamed from: e2.b  reason: case insensitive filesystem */
public class C2348b {

    /* renamed from: A  reason: collision with root package name */
    public static d f21449A = d.NORMAL;

    /* renamed from: w  reason: collision with root package name */
    private static C2348b f21450w;

    /* renamed from: x  reason: collision with root package name */
    private static C2348b f21451x;

    /* renamed from: y  reason: collision with root package name */
    private static C2348b f21452y;

    /* renamed from: z  reason: collision with root package name */
    private static String[] f21453z = {null, null};

    /* renamed from: a  reason: collision with root package name */
    private int f21454a = 25000;

    /* renamed from: b  reason: collision with root package name */
    private e f21455b = null;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public d f21456c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f21457d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Process f21458e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final BufferedReader f21459f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final BufferedReader f21460g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final OutputStreamWriter f21461h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final List f21462i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public boolean f21463j;

    /* renamed from: k  reason: collision with root package name */
    private Boolean f21464k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f21465l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f21466m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f21467n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public int f21468o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public int f21469p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public int f21470q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public int f21471r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public int f21472s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f21473t;

    /* renamed from: u  reason: collision with root package name */
    private Runnable f21474u;

    /* renamed from: v  reason: collision with root package name */
    private Runnable f21475v;

    /* renamed from: e2.b$a */
    class a implements Runnable {
        a() {
        }

        public void run() {
            while (true) {
                try {
                    synchronized (C2348b.this.f21462i) {
                        while (!C2348b.this.f21463j && C2348b.this.f21470q >= C2348b.this.f21462i.size()) {
                            C2348b bVar = C2348b.this;
                            bVar.f21465l = false;
                            bVar.f21462i.wait();
                        }
                    }
                    if (C2348b.this.f21470q >= C2348b.this.f21468o) {
                        while (C2348b.this.f21469p != C2348b.this.f21470q) {
                            C2314a.c("Waiting for read and write to catch up before cleanup.");
                        }
                        C2348b.this.x();
                    }
                    if (C2348b.this.f21470q < C2348b.this.f21462i.size()) {
                        C2348b bVar2 = C2348b.this;
                        bVar2.f21465l = true;
                        C2347a aVar = (C2347a) bVar2.f21462i.get(C2348b.this.f21470q);
                        aVar.l();
                        C2314a.c("Executing: " + aVar.g() + " with context: " + C2348b.this.f21456c);
                        C2348b.this.f21461h.write(aVar.g());
                        C2348b.this.f21461h.flush();
                        C2348b.this.f21461h.write("\necho F*D^W@#FGF " + C2348b.this.f21471r + " $?\n");
                        C2348b.this.f21461h.flush();
                        C2348b.m(C2348b.this);
                        C2348b.v(C2348b.this);
                    } else if (C2348b.this.f21463j) {
                        break;
                    }
                } catch (IOException e5) {
                    e = e5;
                } catch (InterruptedException e6) {
                    e = e6;
                } catch (Throwable th) {
                    while (true) {
                    }
                    throw th;
                }
            }
            C2348b bVar3 = C2348b.this;
            bVar3.f21465l = false;
            bVar3.f21461h.write("\nexit 0\n");
            C2348b.this.f21461h.flush();
            C2314a.c("Closing shell");
            int unused = C2348b.this.f21470q = 0;
            C2348b bVar4 = C2348b.this;
            bVar4.C(bVar4.f21461h);
            try {
                C2314a.d(e.getMessage(), C2314a.c.ERROR, e);
                int unused2 = C2348b.this.f21470q = 0;
                C2348b bVar42 = C2348b.this;
                bVar42.C(bVar42.f21461h);
            } catch (Throwable th2) {
                int unused3 = C2348b.this.f21470q = 0;
                C2348b bVar5 = C2348b.this;
                bVar5.C(bVar5.f21461h);
                throw th2;
            }
        }
    }

    /* renamed from: e2.b$b  reason: collision with other inner class name */
    class C0219b extends Thread {
        C0219b() {
        }

        public void run() {
            synchronized (C2348b.this.f21462i) {
                C2348b.this.f21462i.notifyAll();
            }
        }
    }

    /* renamed from: e2.b$c */
    class c implements Runnable {
        c() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            e2.C2348b.f(r9.f21478a).waitFor();
            e2.C2348b.f(r9.f21478a).destroy();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0080, code lost:
            if (e2.C2348b.o(r9.f21478a) < e2.C2348b.a(r9.f21478a).size()) goto L_0x0082;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0082, code lost:
            if (r1 == null) goto L_0x0084;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0084, code lost:
            r1 = (e2.C2347a) e2.C2348b.a(r9.f21478a).get(e2.C2348b.o(r9.f21478a));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x009a, code lost:
            if (r1.f21433c < r1.f21434d) goto L_0x009c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x009c, code lost:
            r1.n("All output not processed!");
            r1.n("Did you forget the super.commandOutput call or are you waiting on the command object?");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a7, code lost:
            r1.n("Unexpected Termination.");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ac, code lost:
            e2.C2348b.q(r9.f21478a);
            r1 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b3, code lost:
            e2.C2348b.p(r9.f21478a, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x0148, code lost:
            r9.f21478a.K(r1);
            r4 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x0152, code lost:
            if (r1.f21433c <= r1.f21434d) goto L_0x018c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x0154, code lost:
            if (r4 != 0) goto L_0x0178;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x0156, code lost:
            r4 = r4 + 1;
            c2.C2314a.c("Waiting for output to be processed. " + r1.f21434d + " Of " + r1.f21433c);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
            monitor-enter(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
            wait(com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x017e, code lost:
            monitor-exit(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x0183, code lost:
            r5 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
            c2.C2314a.c(r5.getMessage());
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0070 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x0140 */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x0148 A[EDGE_INSN: B:85:0x0148->B:58:0x0148 ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x0002 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r9 = this;
                r0 = 0
            L_0x0001:
                r1 = r0
            L_0x0002:
                r2 = 1
                r3 = 0
                e2.b r4 = e2.C2348b.this     // Catch:{ IOException -> 0x002e }
                boolean r4 = r4.f21463j     // Catch:{ IOException -> 0x002e }
                if (r4 == 0) goto L_0x0031
                e2.b r4 = e2.C2348b.this     // Catch:{ IOException -> 0x002e }
                java.io.BufferedReader r4 = r4.f21459f     // Catch:{ IOException -> 0x002e }
                boolean r4 = r4.ready()     // Catch:{ IOException -> 0x002e }
                if (r4 != 0) goto L_0x0031
                e2.b r4 = e2.C2348b.this     // Catch:{ IOException -> 0x002e }
                int r4 = r4.f21469p     // Catch:{ IOException -> 0x002e }
                e2.b r5 = e2.C2348b.this     // Catch:{ IOException -> 0x002e }
                java.util.List r5 = r5.f21462i     // Catch:{ IOException -> 0x002e }
                int r5 = r5.size()     // Catch:{ IOException -> 0x002e }
                if (r4 >= r5) goto L_0x005e
                goto L_0x0031
            L_0x002b:
                r0 = move-exception
                goto L_0x01af
            L_0x002e:
                r0 = move-exception
                goto L_0x01a3
            L_0x0031:
                e2.b r4 = e2.C2348b.this     // Catch:{ IOException -> 0x002e }
                r4.f21466m = r3     // Catch:{ IOException -> 0x002e }
                java.io.BufferedReader r4 = r4.f21459f     // Catch:{ IOException -> 0x002e }
                java.lang.String r4 = r4.readLine()     // Catch:{ IOException -> 0x002e }
                e2.b r5 = e2.C2348b.this     // Catch:{ IOException -> 0x002e }
                r5.f21466m = r2     // Catch:{ IOException -> 0x002e }
                if (r4 != 0) goto L_0x0044
                goto L_0x005e
            L_0x0044:
                if (r1 != 0) goto L_0x00f2
                int r5 = r5.f21469p     // Catch:{ IOException -> 0x002e }
                e2.b r6 = e2.C2348b.this     // Catch:{ IOException -> 0x002e }
                java.util.List r6 = r6.f21462i     // Catch:{ IOException -> 0x002e }
                int r6 = r6.size()     // Catch:{ IOException -> 0x002e }
                if (r5 < r6) goto L_0x00e0
                e2.b r4 = e2.C2348b.this     // Catch:{ IOException -> 0x002e }
                boolean r4 = r4.f21463j     // Catch:{ IOException -> 0x002e }
                if (r4 == 0) goto L_0x0002
            L_0x005e:
                e2.b r4 = e2.C2348b.this     // Catch:{ Exception -> 0x0070 }
                java.lang.Process r4 = r4.f21458e     // Catch:{ Exception -> 0x0070 }
                r4.waitFor()     // Catch:{ Exception -> 0x0070 }
                e2.b r4 = e2.C2348b.this     // Catch:{ Exception -> 0x0070 }
                java.lang.Process r4 = r4.f21458e     // Catch:{ Exception -> 0x0070 }
                r4.destroy()     // Catch:{ Exception -> 0x0070 }
            L_0x0070:
                e2.b r4 = e2.C2348b.this     // Catch:{ IOException -> 0x002e }
                int r4 = r4.f21469p     // Catch:{ IOException -> 0x002e }
                e2.b r5 = e2.C2348b.this     // Catch:{ IOException -> 0x002e }
                java.util.List r5 = r5.f21462i     // Catch:{ IOException -> 0x002e }
                int r5 = r5.size()     // Catch:{ IOException -> 0x002e }
                if (r4 >= r5) goto L_0x00b3
                if (r1 != 0) goto L_0x0096
                e2.b r1 = e2.C2348b.this     // Catch:{ IOException -> 0x002e }
                java.util.List r1 = r1.f21462i     // Catch:{ IOException -> 0x002e }
                e2.b r4 = e2.C2348b.this     // Catch:{ IOException -> 0x002e }
                int r4 = r4.f21469p     // Catch:{ IOException -> 0x002e }
                java.lang.Object r1 = r1.get(r4)     // Catch:{ IOException -> 0x002e }
                e2.a r1 = (e2.C2347a) r1     // Catch:{ IOException -> 0x002e }
            L_0x0096:
                int r4 = r1.f21433c     // Catch:{ IOException -> 0x002e }
                int r5 = r1.f21434d     // Catch:{ IOException -> 0x002e }
                if (r4 >= r5) goto L_0x00a7
                java.lang.String r4 = "All output not processed!"
                r1.n(r4)     // Catch:{ IOException -> 0x002e }
                java.lang.String r4 = "Did you forget the super.commandOutput call or are you waiting on the command object?"
                r1.n(r4)     // Catch:{ IOException -> 0x002e }
                goto L_0x00ac
            L_0x00a7:
                java.lang.String r4 = "Unexpected Termination."
                r1.n(r4)     // Catch:{ IOException -> 0x002e }
            L_0x00ac:
                e2.b r1 = e2.C2348b.this     // Catch:{ IOException -> 0x002e }
                e2.C2348b.q(r1)     // Catch:{ IOException -> 0x002e }
                r1 = r0
                goto L_0x0070
            L_0x00b3:
                e2.b r0 = e2.C2348b.this     // Catch:{ IOException -> 0x002e }
                int unused = r0.f21469p = r3     // Catch:{ IOException -> 0x002e }
            L_0x00b8:
                e2.b r0 = e2.C2348b.this
                java.io.OutputStreamWriter r1 = r0.f21461h
                r0.C(r1)
                e2.b r0 = e2.C2348b.this
                java.io.BufferedReader r1 = r0.f21460g
                r0.B(r1)
                e2.b r0 = e2.C2348b.this
                java.io.BufferedReader r1 = r0.f21459f
                r0.B(r1)
                java.lang.String r0 = "Shell destroyed"
                c2.C2314a.c(r0)
                e2.b r0 = e2.C2348b.this
                r0.f21467n = r2
                r0.f21466m = r3
                goto L_0x01ae
            L_0x00e0:
                e2.b r1 = e2.C2348b.this     // Catch:{ IOException -> 0x002e }
                java.util.List r1 = r1.f21462i     // Catch:{ IOException -> 0x002e }
                e2.b r5 = e2.C2348b.this     // Catch:{ IOException -> 0x002e }
                int r5 = r5.f21469p     // Catch:{ IOException -> 0x002e }
                java.lang.Object r1 = r1.get(r5)     // Catch:{ IOException -> 0x002e }
                e2.a r1 = (e2.C2347a) r1     // Catch:{ IOException -> 0x002e }
            L_0x00f2:
                java.lang.String r5 = "F*D^W@#FGF"
                int r5 = r4.indexOf(r5)     // Catch:{ IOException -> 0x002e }
                r6 = -1
                if (r5 != r6) goto L_0x0101
                int r7 = r1.f21444n     // Catch:{ IOException -> 0x002e }
                r1.j(r7, r4)     // Catch:{ IOException -> 0x002e }
                goto L_0x0120
            L_0x0101:
                if (r5 <= 0) goto L_0x0120
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x002e }
                r7.<init>()     // Catch:{ IOException -> 0x002e }
                java.lang.String r8 = "Found token, line: "
                r7.append(r8)     // Catch:{ IOException -> 0x002e }
                r7.append(r4)     // Catch:{ IOException -> 0x002e }
                java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x002e }
                c2.C2314a.c(r7)     // Catch:{ IOException -> 0x002e }
                int r7 = r1.f21444n     // Catch:{ IOException -> 0x002e }
                java.lang.String r8 = r4.substring(r3, r5)     // Catch:{ IOException -> 0x002e }
                r1.j(r7, r8)     // Catch:{ IOException -> 0x002e }
            L_0x0120:
                if (r5 < 0) goto L_0x0002
                java.lang.String r4 = r4.substring(r5)     // Catch:{ IOException -> 0x002e }
                java.lang.String r5 = " "
                java.lang.String[] r4 = r4.split(r5)     // Catch:{ IOException -> 0x002e }
                int r5 = r4.length     // Catch:{ IOException -> 0x002e }
                r7 = 2
                if (r5 < r7) goto L_0x0002
                r5 = r4[r2]     // Catch:{ IOException -> 0x002e }
                if (r5 == 0) goto L_0x0002
                int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ NumberFormatException -> 0x0139 }
                goto L_0x013a
            L_0x0139:
                r5 = r3
            L_0x013a:
                r4 = r4[r7]     // Catch:{ NumberFormatException -> 0x0140 }
                int r6 = java.lang.Integer.parseInt(r4)     // Catch:{ NumberFormatException -> 0x0140 }
            L_0x0140:
                e2.b r4 = e2.C2348b.this     // Catch:{ IOException -> 0x002e }
                int r4 = r4.f21472s     // Catch:{ IOException -> 0x002e }
                if (r5 != r4) goto L_0x0002
                e2.b r4 = e2.C2348b.this     // Catch:{ IOException -> 0x002e }
                r4.K(r1)     // Catch:{ IOException -> 0x002e }
                r4 = r3
            L_0x014e:
                int r5 = r1.f21433c     // Catch:{ IOException -> 0x002e }
                int r7 = r1.f21434d     // Catch:{ IOException -> 0x002e }
                if (r5 <= r7) goto L_0x018c
                if (r4 != 0) goto L_0x0178
                int r4 = r4 + 1
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x002e }
                r5.<init>()     // Catch:{ IOException -> 0x002e }
                java.lang.String r7 = "Waiting for output to be processed. "
                r5.append(r7)     // Catch:{ IOException -> 0x002e }
                int r7 = r1.f21434d     // Catch:{ IOException -> 0x002e }
                r5.append(r7)     // Catch:{ IOException -> 0x002e }
                java.lang.String r7 = " Of "
                r5.append(r7)     // Catch:{ IOException -> 0x002e }
                int r7 = r1.f21433c     // Catch:{ IOException -> 0x002e }
                r5.append(r7)     // Catch:{ IOException -> 0x002e }
                java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x002e }
                c2.C2314a.c(r5)     // Catch:{ IOException -> 0x002e }
            L_0x0178:
                monitor-enter(r9)     // Catch:{ Exception -> 0x0183 }
                r7 = 2000(0x7d0, double:9.88E-321)
                r9.wait(r7)     // Catch:{ all -> 0x0180 }
                monitor-exit(r9)     // Catch:{ all -> 0x0180 }
                goto L_0x014e
            L_0x0180:
                r5 = move-exception
                monitor-exit(r9)     // Catch:{ all -> 0x0180 }
                throw r5     // Catch:{ Exception -> 0x0183 }
            L_0x0183:
                r5 = move-exception
                java.lang.String r5 = r5.getMessage()     // Catch:{ IOException -> 0x002e }
                c2.C2314a.c(r5)     // Catch:{ IOException -> 0x002e }
                goto L_0x014e
            L_0x018c:
                java.lang.String r4 = "Read all output"
                c2.C2314a.c(r4)     // Catch:{ IOException -> 0x002e }
                r1.k(r6)     // Catch:{ IOException -> 0x002e }
                r1.b()     // Catch:{ IOException -> 0x002e }
                e2.b r1 = e2.C2348b.this     // Catch:{ IOException -> 0x002e }
                e2.C2348b.q(r1)     // Catch:{ IOException -> 0x002e }
                e2.b r1 = e2.C2348b.this     // Catch:{ IOException -> 0x002e }
                e2.C2348b.e(r1)     // Catch:{ IOException -> 0x002e }
                goto L_0x0001
            L_0x01a3:
                java.lang.String r1 = r0.getMessage()     // Catch:{ all -> 0x002b }
                c2.a$c r4 = c2.C2314a.c.ERROR     // Catch:{ all -> 0x002b }
                c2.C2314a.d(r1, r4, r0)     // Catch:{ all -> 0x002b }
                goto L_0x00b8
            L_0x01ae:
                return
            L_0x01af:
                e2.b r1 = e2.C2348b.this
                java.io.OutputStreamWriter r4 = r1.f21461h
                r1.C(r4)
                e2.b r1 = e2.C2348b.this
                java.io.BufferedReader r4 = r1.f21460g
                r1.B(r4)
                e2.b r1 = e2.C2348b.this
                java.io.BufferedReader r4 = r1.f21459f
                r1.B(r4)
                java.lang.String r1 = "Shell destroyed"
                c2.C2314a.c(r1)
                e2.b r1 = e2.C2348b.this
                r1.f21467n = r2
                r1.f21466m = r3
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: e2.C2348b.c.run():void");
        }
    }

    /* renamed from: e2.b$d */
    public enum d {
        NORMAL("normal"),
        SHELL("u:r:shell:s0"),
        SYSTEM_SERVER("u:r:system_server:s0"),
        SYSTEM_APP("u:r:system_app:s0"),
        PLATFORM_APP("u:r:platform_app:s0"),
        UNTRUSTED_APP("u:r:untrusted_app:s0"),
        RECOVERY("u:r:recovery:s0");
        

        /* renamed from: a  reason: collision with root package name */
        private String f21487a;

        private d(String str) {
            this.f21487a = str;
        }

        public String b() {
            return this.f21487a;
        }
    }

    /* renamed from: e2.b$e */
    public enum e {
        NORMAL,
        ROOT,
        CUSTOM
    }

    /* renamed from: e2.b$f */
    protected static class f extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public int f21492a;

        /* renamed from: b  reason: collision with root package name */
        public C2348b f21493b;

        /* synthetic */ f(C2348b bVar, a aVar) {
            this(bVar);
        }

        private void a() {
            Field field;
            try {
                Class<?> cls = this.f21493b.f21458e.getClass();
                try {
                    field = cls.getDeclaredField("pid");
                } catch (NoSuchFieldException unused) {
                    field = cls.getDeclaredField("id");
                }
                field.setAccessible(true);
                int intValue = ((Integer) field.get(this.f21493b.f21458e)).intValue();
                OutputStreamWriter t5 = this.f21493b.f21461h;
                t5.write("(echo -17 > /proc/" + intValue + "/oom_adj) &> /dev/null\n");
                this.f21493b.f21461h.write("(echo -17 > /proc/$$/oom_adj) &> /dev/null\n");
                this.f21493b.f21461h.flush();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }

        public void run() {
            try {
                this.f21493b.f21461h.write("echo Started\n");
                this.f21493b.f21461h.flush();
                while (true) {
                    String readLine = this.f21493b.f21459f.readLine();
                    if (readLine == null) {
                        throw new EOFException();
                    } else if (!"".equals(readLine)) {
                        if ("Started".equals(readLine)) {
                            this.f21492a = 1;
                            a();
                            return;
                        }
                        String unused = this.f21493b.f21457d = "unknown error occurred.";
                    }
                }
            } catch (IOException e5) {
                this.f21492a = -42;
                if (e5.getMessage() != null) {
                    String unused2 = this.f21493b.f21457d = e5.getMessage();
                } else {
                    String unused3 = this.f21493b.f21457d = "RootAccess denied?.";
                }
            }
        }

        private f(C2348b bVar) {
            this.f21492a = -911;
            this.f21493b = bVar;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:25|26|27|28|29) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:30|31|32|33|34) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x019a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x01b6 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:32:0x01b6=Splitter:B:32:0x01b6, B:27:0x019a=Splitter:B:27:0x019a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private C2348b(java.lang.String r6, e2.C2348b.e r7, e2.C2348b.d r8, int r9) {
        /*
            r5 = this;
            r5.<init>()
            r0 = 25000(0x61a8, float:3.5032E-41)
            r5.f21454a = r0
            r0 = 0
            r5.f21455b = r0
            e2.b$d r1 = e2.C2348b.d.NORMAL
            r5.f21456c = r1
            java.lang.String r2 = ""
            r5.f21457d = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r5.f21462i = r2
            r2 = 0
            r5.f21463j = r2
            r5.f21464k = r0
            r5.f21465l = r2
            r5.f21466m = r2
            r5.f21467n = r2
            r3 = 5000(0x1388, float:7.006E-42)
            r5.f21468o = r3
            r5.f21469p = r2
            r5.f21470q = r2
            r5.f21471r = r2
            r5.f21472s = r2
            r5.f21473t = r2
            e2.b$a r3 = new e2.b$a
            r3.<init>()
            r5.f21474u = r3
            e2.b$c r3 = new e2.b$c
            r3.<init>()
            r5.f21475v = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Starting shell: "
            r3.append(r4)
            r3.append(r6)
            java.lang.String r3 = r3.toString()
            c2.C2314a.c(r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Context: "
            r3.append(r4)
            java.lang.String r4 = r8.b()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            c2.C2314a.c(r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Timeout: "
            r3.append(r4)
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            c2.C2314a.c(r3)
            r5.f21455b = r7
            if (r9 <= 0) goto L_0x0085
            goto L_0x0087
        L_0x0085:
            int r9 = r5.f21454a
        L_0x0087:
            r5.f21454a = r9
            r5.f21456c = r8
            if (r8 != r1) goto L_0x0099
            java.lang.Runtime r7 = java.lang.Runtime.getRuntime()
            java.lang.Process r6 = r7.exec(r6)
            r5.f21458e = r6
            goto L_0x012a
        L_0x0099:
            java.lang.String r7 = r5.H(r2)
            r8 = 1
            java.lang.String r8 = r5.H(r8)
            boolean r9 = r5.I()
            if (r9 == 0) goto L_0x00db
            if (r7 == 0) goto L_0x00db
            if (r8 == 0) goto L_0x00db
            java.lang.String r9 = "SUPERSU"
            boolean r9 = r7.endsWith(r9)
            if (r9 == 0) goto L_0x00db
            java.lang.Integer r9 = java.lang.Integer.valueOf(r8)
            int r9 = r9.intValue()
            r1 = 190(0xbe, float:2.66E-43)
            if (r9 < r1) goto L_0x00db
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r6)
            java.lang.String r6 = " --context "
            r7.append(r6)
            e2.b$d r6 = r5.f21456c
            java.lang.String r6 = r6.b()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            goto L_0x0120
        L_0x00db:
            java.lang.String r9 = "Su binary --context switch not supported!"
            c2.C2314a.c(r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r1 = "Su binary display version: "
            r9.append(r1)
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            c2.C2314a.c(r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r9 = "Su binary internal version: "
            r7.append(r9)
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            c2.C2314a.c(r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "SELinuxEnforcing: "
            r7.append(r8)
            boolean r8 = r5.I()
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            c2.C2314a.c(r7)
        L_0x0120:
            java.lang.Runtime r7 = java.lang.Runtime.getRuntime()
            java.lang.Process r6 = r7.exec(r6)
            r5.f21458e = r6
        L_0x012a:
            java.io.BufferedReader r6 = new java.io.BufferedReader
            java.io.InputStreamReader r7 = new java.io.InputStreamReader
            java.lang.Process r8 = r5.f21458e
            java.io.InputStream r8 = r8.getInputStream()
            java.lang.String r9 = "UTF-8"
            r7.<init>(r8, r9)
            r6.<init>(r7)
            r5.f21459f = r6
            java.io.BufferedReader r6 = new java.io.BufferedReader
            java.io.InputStreamReader r7 = new java.io.InputStreamReader
            java.lang.Process r8 = r5.f21458e
            java.io.InputStream r8 = r8.getErrorStream()
            r7.<init>(r8, r9)
            r6.<init>(r7)
            r5.f21460g = r6
            java.io.OutputStreamWriter r6 = new java.io.OutputStreamWriter
            java.lang.Process r7 = r5.f21458e
            java.io.OutputStream r7 = r7.getOutputStream()
            r6.<init>(r7, r9)
            r5.f21461h = r6
            e2.b$f r6 = new e2.b$f
            r6.<init>(r5, r0)
            r6.start()
            int r7 = r5.f21454a     // Catch:{ InterruptedException -> 0x01cd }
            long r7 = (long) r7     // Catch:{ InterruptedException -> 0x01cd }
            r6.join(r7)     // Catch:{ InterruptedException -> 0x01cd }
            int r7 = r6.f21492a     // Catch:{ InterruptedException -> 0x01cd }
            r8 = -911(0xfffffffffffffc71, float:NaN)
            if (r7 == r8) goto L_0x01b1
            r8 = -42
            if (r7 == r8) goto L_0x0195
            java.lang.Thread r7 = new java.lang.Thread     // Catch:{ InterruptedException -> 0x01cd }
            java.lang.Runnable r8 = r5.f21474u     // Catch:{ InterruptedException -> 0x01cd }
            java.lang.String r9 = "Shell Input"
            r7.<init>(r8, r9)     // Catch:{ InterruptedException -> 0x01cd }
            r8 = 5
            r7.setPriority(r8)     // Catch:{ InterruptedException -> 0x01cd }
            r7.start()     // Catch:{ InterruptedException -> 0x01cd }
            java.lang.Thread r7 = new java.lang.Thread     // Catch:{ InterruptedException -> 0x01cd }
            java.lang.Runnable r9 = r5.f21475v     // Catch:{ InterruptedException -> 0x01cd }
            java.lang.String r0 = "Shell Output"
            r7.<init>(r9, r0)     // Catch:{ InterruptedException -> 0x01cd }
            r7.setPriority(r8)     // Catch:{ InterruptedException -> 0x01cd }
            r7.start()     // Catch:{ InterruptedException -> 0x01cd }
            return
        L_0x0195:
            java.lang.Process r7 = r5.f21458e     // Catch:{ Exception -> 0x019a }
            r7.destroy()     // Catch:{ Exception -> 0x019a }
        L_0x019a:
            java.io.BufferedReader r7 = r5.f21459f     // Catch:{ InterruptedException -> 0x01cd }
            r5.B(r7)     // Catch:{ InterruptedException -> 0x01cd }
            java.io.BufferedReader r7 = r5.f21460g     // Catch:{ InterruptedException -> 0x01cd }
            r5.B(r7)     // Catch:{ InterruptedException -> 0x01cd }
            java.io.OutputStreamWriter r7 = r5.f21461h     // Catch:{ InterruptedException -> 0x01cd }
            r5.C(r7)     // Catch:{ InterruptedException -> 0x01cd }
            d2.a r7 = new d2.a     // Catch:{ InterruptedException -> 0x01cd }
            java.lang.String r8 = "Root Access Denied"
            r7.<init>(r8)     // Catch:{ InterruptedException -> 0x01cd }
            throw r7     // Catch:{ InterruptedException -> 0x01cd }
        L_0x01b1:
            java.lang.Process r7 = r5.f21458e     // Catch:{ Exception -> 0x01b6 }
            r7.destroy()     // Catch:{ Exception -> 0x01b6 }
        L_0x01b6:
            java.io.BufferedReader r7 = r5.f21459f     // Catch:{ InterruptedException -> 0x01cd }
            r5.B(r7)     // Catch:{ InterruptedException -> 0x01cd }
            java.io.BufferedReader r7 = r5.f21460g     // Catch:{ InterruptedException -> 0x01cd }
            r5.B(r7)     // Catch:{ InterruptedException -> 0x01cd }
            java.io.OutputStreamWriter r7 = r5.f21461h     // Catch:{ InterruptedException -> 0x01cd }
            r5.C(r7)     // Catch:{ InterruptedException -> 0x01cd }
            java.util.concurrent.TimeoutException r7 = new java.util.concurrent.TimeoutException     // Catch:{ InterruptedException -> 0x01cd }
            java.lang.String r8 = r5.f21457d     // Catch:{ InterruptedException -> 0x01cd }
            r7.<init>(r8)     // Catch:{ InterruptedException -> 0x01cd }
            throw r7     // Catch:{ InterruptedException -> 0x01cd }
        L_0x01cd:
            r6.interrupt()
            java.lang.Thread r6 = java.lang.Thread.currentThread()
            r6.interrupt()
            java.util.concurrent.TimeoutException r6 = new java.util.concurrent.TimeoutException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: e2.C2348b.<init>(java.lang.String, e2.b$e, e2.b$d, int):void");
    }

    public static void A() {
        C2314a.c("Request to close custom shell!");
        C2348b bVar = f21452y;
        if (bVar != null) {
            bVar.y();
        }
    }

    /* access modifiers changed from: private */
    public void B(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public void C(Writer writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void D() {
        C2314a.c("Request to close root shell!");
        C2348b bVar = f21450w;
        if (bVar != null) {
            bVar.y();
        }
    }

    public static void E() {
        C2314a.c("Request to close normal shell!");
        C2348b bVar = f21451x;
        if (bVar != null) {
            bVar.y();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:20|21|(1:23)|24|25|26|27|(2:(2:30|(2:32|(1:60)(2:61|58))(3:34|35|(1:59)(2:62|58)))(0)|38)|37|38|39) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x003f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0042 */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x004c A[Catch:{ IOException -> 0x0017, InterruptedException -> 0x0015, all -> 0x0013 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized java.lang.String H(boolean r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            r0 = r8 ^ 1
            java.lang.String[] r1 = f21453z     // Catch:{ all -> 0x0013 }
            r1 = r1[r0]     // Catch:{ all -> 0x0013 }
            if (r1 != 0) goto L_0x0075
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x0017, InterruptedException -> 0x0015 }
            if (r8 == 0) goto L_0x0019
            java.lang.String r3 = "su -V"
            goto L_0x001b
        L_0x0013:
            r8 = move-exception
            goto L_0x007b
        L_0x0015:
            r8 = move-exception
            goto L_0x006b
        L_0x0017:
            r8 = move-exception
            goto L_0x0070
        L_0x0019:
            java.lang.String r3 = "su -v"
        L_0x001b:
            java.lang.Process r2 = r2.exec(r3, r1)     // Catch:{ IOException -> 0x0017, InterruptedException -> 0x0015 }
            r2.waitFor()     // Catch:{ IOException -> 0x0017, InterruptedException -> 0x0015 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0013 }
            r3.<init>()     // Catch:{ all -> 0x0013 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ all -> 0x0013 }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ all -> 0x0013 }
            java.io.InputStream r6 = r2.getInputStream()     // Catch:{ all -> 0x0013 }
            r5.<init>(r6)     // Catch:{ all -> 0x0013 }
            r4.<init>(r5)     // Catch:{ all -> 0x0013 }
        L_0x0035:
            java.lang.String r5 = r4.readLine()     // Catch:{ IOException -> 0x003f }
            if (r5 == 0) goto L_0x003f
            r3.add(r5)     // Catch:{ IOException -> 0x003f }
            goto L_0x0035
        L_0x003f:
            r4.close()     // Catch:{ IOException -> 0x0042 }
        L_0x0042:
            r2.destroy()     // Catch:{ all -> 0x0013 }
            int r2 = r3.size()     // Catch:{ all -> 0x0013 }
            r4 = 0
        L_0x004a:
            if (r4 >= r2) goto L_0x0066
            java.lang.Object r5 = r3.get(r4)     // Catch:{ all -> 0x0013 }
            int r4 = r4 + 1
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0013 }
            if (r8 != 0) goto L_0x005f
            java.lang.String r6 = "."
            boolean r6 = r5.contains(r6)     // Catch:{ all -> 0x0013 }
            if (r6 == 0) goto L_0x004a
            goto L_0x0065
        L_0x005f:
            int r6 = java.lang.Integer.parseInt(r5)     // Catch:{ NumberFormatException -> 0x004a }
            if (r6 <= 0) goto L_0x004a
        L_0x0065:
            r1 = r5
        L_0x0066:
            java.lang.String[] r8 = f21453z     // Catch:{ all -> 0x0013 }
            r8[r0] = r1     // Catch:{ all -> 0x0013 }
            goto L_0x0075
        L_0x006b:
            r8.printStackTrace()     // Catch:{ all -> 0x0013 }
            monitor-exit(r7)
            return r1
        L_0x0070:
            r8.printStackTrace()     // Catch:{ all -> 0x0013 }
            monitor-exit(r7)
            return r1
        L_0x0075:
            java.lang.String[] r8 = f21453z     // Catch:{ all -> 0x0013 }
            r8 = r8[r0]     // Catch:{ all -> 0x0013 }
            monitor-exit(r7)
            return r8
        L_0x007b:
            monitor-exit(r7)     // Catch:{ all -> 0x0013 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: e2.C2348b.H(boolean):java.lang.String");
    }

    public static C2348b L() {
        return M(0, 3);
    }

    public static C2348b M(int i5, int i6) {
        return N(i5, f21449A, i6);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        r1 = r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static e2.C2348b N(int r4, e2.C2348b.d r5, int r6) {
        /*
            e2.b r0 = f21450w
            if (r0 != 0) goto L_0x0056
            java.lang.String r0 = "Starting Root Shell!"
            c2.C2314a.c(r0)
            java.lang.String r0 = "su"
            r1 = 0
        L_0x000c:
            e2.b r2 = f21450w
            if (r2 != 0) goto L_0x00a6
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0032, a -> 0x0030, TimeoutException -> 0x002e }
            r2.<init>()     // Catch:{ IOException -> 0x0032, a -> 0x0030, TimeoutException -> 0x002e }
            java.lang.String r3 = "Trying to open Root Shell, attempt #"
            r2.append(r3)     // Catch:{ IOException -> 0x0032, a -> 0x0030, TimeoutException -> 0x002e }
            r2.append(r1)     // Catch:{ IOException -> 0x0032, a -> 0x0030, TimeoutException -> 0x002e }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x0032, a -> 0x0030, TimeoutException -> 0x002e }
            c2.C2314a.c(r2)     // Catch:{ IOException -> 0x0032, a -> 0x0030, TimeoutException -> 0x002e }
            e2.b r2 = new e2.b     // Catch:{ IOException -> 0x0032, a -> 0x0030, TimeoutException -> 0x002e }
            e2.b$e r3 = e2.C2348b.e.ROOT     // Catch:{ IOException -> 0x0032, a -> 0x0030, TimeoutException -> 0x002e }
            r2.<init>(r0, r3, r5, r4)     // Catch:{ IOException -> 0x0032, a -> 0x0030, TimeoutException -> 0x002e }
            f21450w = r2     // Catch:{ IOException -> 0x0032, a -> 0x0030, TimeoutException -> 0x002e }
            goto L_0x000c
        L_0x002e:
            r2 = move-exception
            goto L_0x0034
        L_0x0030:
            r2 = move-exception
            goto L_0x0040
        L_0x0032:
            r2 = move-exception
            goto L_0x004b
        L_0x0034:
            int r3 = r1 + 1
            if (r1 >= r6) goto L_0x003a
        L_0x0038:
            r1 = r3
            goto L_0x000c
        L_0x003a:
            java.lang.String r4 = "TimeoutException, could not start shell"
            c2.C2314a.c(r4)
            throw r2
        L_0x0040:
            int r3 = r1 + 1
            if (r1 >= r6) goto L_0x0045
            goto L_0x0038
        L_0x0045:
            java.lang.String r4 = "RootDeniedException, could not start shell"
            c2.C2314a.c(r4)
            throw r2
        L_0x004b:
            int r3 = r1 + 1
            if (r1 >= r6) goto L_0x0050
            goto L_0x0038
        L_0x0050:
            java.lang.String r4 = "IOException, could not start shell"
            c2.C2314a.c(r4)
            throw r2
        L_0x0056:
            e2.b$d r4 = r0.f21456c
            if (r4 == r5) goto L_0x00a1
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0084, a -> 0x0082, TimeoutException -> 0x0080 }
            r4.<init>()     // Catch:{ IOException -> 0x0084, a -> 0x0082, TimeoutException -> 0x0080 }
            java.lang.String r0 = "Context is different than open shell, switching context... "
            r4.append(r0)     // Catch:{ IOException -> 0x0084, a -> 0x0082, TimeoutException -> 0x0080 }
            e2.b r0 = f21450w     // Catch:{ IOException -> 0x0084, a -> 0x0082, TimeoutException -> 0x0080 }
            e2.b$d r0 = r0.f21456c     // Catch:{ IOException -> 0x0084, a -> 0x0082, TimeoutException -> 0x0080 }
            r4.append(r0)     // Catch:{ IOException -> 0x0084, a -> 0x0082, TimeoutException -> 0x0080 }
            java.lang.String r0 = " VS "
            r4.append(r0)     // Catch:{ IOException -> 0x0084, a -> 0x0082, TimeoutException -> 0x0080 }
            r4.append(r5)     // Catch:{ IOException -> 0x0084, a -> 0x0082, TimeoutException -> 0x0080 }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x0084, a -> 0x0082, TimeoutException -> 0x0080 }
            c2.C2314a.c(r4)     // Catch:{ IOException -> 0x0084, a -> 0x0082, TimeoutException -> 0x0080 }
            e2.b r4 = f21450w     // Catch:{ IOException -> 0x0084, a -> 0x0082, TimeoutException -> 0x0080 }
            r4.O(r5)     // Catch:{ IOException -> 0x0084, a -> 0x0082, TimeoutException -> 0x0080 }
            goto L_0x00a6
        L_0x0080:
            r4 = move-exception
            goto L_0x0086
        L_0x0082:
            r4 = move-exception
            goto L_0x008f
        L_0x0084:
            r4 = move-exception
            goto L_0x0098
        L_0x0086:
            if (r6 <= 0) goto L_0x0089
            goto L_0x00a6
        L_0x0089:
            java.lang.String r5 = "TimeoutException, could not switch context!"
            c2.C2314a.c(r5)
            throw r4
        L_0x008f:
            if (r6 <= 0) goto L_0x0092
            goto L_0x00a6
        L_0x0092:
            java.lang.String r5 = "RootDeniedException, could not switch context!"
            c2.C2314a.c(r5)
            throw r4
        L_0x0098:
            if (r6 <= 0) goto L_0x009b
            goto L_0x00a6
        L_0x009b:
            java.lang.String r5 = "IOException, could not switch context!"
            c2.C2314a.c(r5)
            throw r4
        L_0x00a1:
            java.lang.String r4 = "Using Existing Root Shell!"
            c2.C2314a.c(r4)
        L_0x00a6:
            e2.b r4 = f21450w
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: e2.C2348b.N(int, e2.b$d, int):e2.b");
    }

    static /* synthetic */ int e(C2348b bVar) {
        int i5 = bVar.f21472s;
        bVar.f21472s = i5 + 1;
        return i5;
    }

    static /* synthetic */ int m(C2348b bVar) {
        int i5 = bVar.f21470q;
        bVar.f21470q = i5 + 1;
        return i5;
    }

    static /* synthetic */ int q(C2348b bVar) {
        int i5 = bVar.f21469p;
        bVar.f21469p = i5 + 1;
        return i5;
    }

    static /* synthetic */ int v(C2348b bVar) {
        int i5 = bVar.f21471r;
        bVar.f21471r = i5 + 1;
        return i5;
    }

    /* access modifiers changed from: private */
    public void x() {
        this.f21473t = true;
        int i5 = this.f21468o;
        int abs = Math.abs(i5 - (i5 / 4));
        C2314a.c("Cleaning up: " + abs);
        for (int i6 = 0; i6 < abs; i6++) {
            this.f21462i.remove(0);
        }
        this.f21469p = this.f21462i.size() - 1;
        this.f21470q = this.f21462i.size() - 1;
        this.f21473t = false;
    }

    public static void z() {
        C2314a.c("Request to close all shells!");
        E();
        D();
        A();
    }

    public int F(C2347a aVar) {
        return this.f21462i.indexOf(aVar);
    }

    public String G(C2347a aVar) {
        return "Command is in position " + F(aVar) + " currently executing command at position " + this.f21470q + " and the number of commands is " + this.f21462i.size();
    }

    public synchronized boolean I() {
        FileInputStream fileInputStream;
        boolean z4;
        try {
            if (this.f21464k == null) {
                boolean z5 = null;
                if (new File("/sys/fs/selinux/enforce").exists()) {
                    try {
                        fileInputStream = new FileInputStream("/sys/fs/selinux/enforce");
                        if (fileInputStream.read() == 49) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        z5 = Boolean.valueOf(z4);
                        fileInputStream.close();
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        fileInputStream.close();
                        throw th;
                    }
                }
                if (z5 == null) {
                    z5 = true;
                }
                this.f21464k = z5;
            }
        } catch (Throwable th2) {
            while (true) {
                throw th2;
            }
        }
        return this.f21464k.booleanValue();
    }

    /* access modifiers changed from: protected */
    public void J() {
        new C0219b().start();
    }

    public void K(C2347a aVar) {
        while (this.f21460g.ready() && aVar != null) {
            try {
                String readLine = this.f21460g.readLine();
                if (readLine != null) {
                    aVar.j(aVar.f21444n, readLine);
                } else {
                    return;
                }
            } catch (Exception e5) {
                C2314a.d(e5.getMessage(), C2314a.c.ERROR, e5);
                return;
            }
        }
    }

    public C2348b O(d dVar) {
        if (this.f21455b == e.ROOT) {
            try {
                D();
            } catch (Exception unused) {
                C2314a.c("Problem closing shell while trying to switch context...");
            }
            return N(this.f21454a, dVar, 3);
        }
        C2314a.c("Can only switch context on a root shell!");
        return this;
    }

    public C2347a w(C2347a aVar) {
        if (this.f21463j) {
            throw new IllegalStateException("Unable to add commands to a closed shell");
        } else if (!aVar.f21437g) {
            do {
            } while (this.f21473t);
            this.f21462i.add(aVar);
            J();
            return aVar;
        } else {
            throw new IllegalStateException("This command has already been executed. (Don't re-use command instances.)");
        }
    }

    public void y() {
        C2314a.c("Request to close shell!");
        int i5 = 0;
        while (this.f21465l) {
            C2314a.c("Waiting on shell to finish executing before closing...");
            i5++;
            if (i5 > 10000) {
                break;
            }
        }
        synchronized (this.f21462i) {
            this.f21463j = true;
            J();
        }
        C2314a.c("Shell Closed!");
        if (this == f21450w) {
            f21450w = null;
        } else if (this == f21451x) {
            f21451x = null;
        } else if (this == f21452y) {
            f21452y = null;
        }
    }
}
