package x0;

import F0.j;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;
import u0.C1886a;
import u0.g;

/* renamed from: x0.B  reason: case insensitive filesystem */
class C1904B implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private final a f16786a;

    /* renamed from: b  reason: collision with root package name */
    private final j f16787b;

    /* renamed from: c  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f16788c;

    /* renamed from: d  reason: collision with root package name */
    private final C1886a f16789d;

    /* renamed from: e  reason: collision with root package name */
    private final AtomicBoolean f16790e = new AtomicBoolean(false);

    /* renamed from: x0.B$a */
    interface a {
        void a(j jVar, Thread thread, Throwable th);
    }

    public C1904B(a aVar, j jVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, C1886a aVar2) {
        this.f16786a = aVar;
        this.f16787b = jVar;
        this.f16788c = uncaughtExceptionHandler;
        this.f16789d = aVar2;
    }

    private boolean b(Thread thread, Throwable th) {
        if (thread == null) {
            g.f().d("Crashlytics will not record uncaught exception; null thread");
            return false;
        } else if (th == null) {
            g.f().d("Crashlytics will not record uncaught exception; null throwable");
            return false;
        } else if (!this.f16789d.b()) {
            return true;
        } else {
            g.f().b("Crashlytics will not record uncaught exception; native crash exists for session.");
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return this.f16790e.get();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        if (r7.f16788c != null) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
        u0.g.f().b("Completed exception processing. Invoking default exception handler.");
        r7.f16788c.uncaughtException(r8, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0037, code lost:
        u0.g.f().b("Completed exception processing, but no default exception handler.");
        java.lang.System.exit(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0041, code lost:
        r7.f16790e.set(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0046, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
        if (r7.f16788c == null) goto L_0x0037;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void uncaughtException(java.lang.Thread r8, java.lang.Throwable r9) {
        /*
            r7 = this;
            java.lang.String r0 = "Completed exception processing, but no default exception handler."
            java.lang.String r1 = "Completed exception processing. Invoking default exception handler."
            java.util.concurrent.atomic.AtomicBoolean r2 = r7.f16790e
            r3 = 1
            r2.set(r3)
            r2 = 0
            boolean r4 = r7.b(r8, r9)     // Catch:{ Exception -> 0x001b }
            if (r4 == 0) goto L_0x001d
            x0.B$a r4 = r7.f16786a     // Catch:{ Exception -> 0x001b }
            F0.j r5 = r7.f16787b     // Catch:{ Exception -> 0x001b }
            r4.a(r5, r8, r9)     // Catch:{ Exception -> 0x001b }
            goto L_0x0026
        L_0x0019:
            r4 = move-exception
            goto L_0x0055
        L_0x001b:
            r4 = move-exception
            goto L_0x0047
        L_0x001d:
            u0.g r4 = u0.g.f()     // Catch:{ Exception -> 0x001b }
            java.lang.String r5 = "Uncaught exception will not be recorded by Crashlytics."
            r4.b(r5)     // Catch:{ Exception -> 0x001b }
        L_0x0026:
            java.lang.Thread$UncaughtExceptionHandler r4 = r7.f16788c
            if (r4 == 0) goto L_0x0037
        L_0x002a:
            u0.g r0 = u0.g.f()
            r0.b(r1)
            java.lang.Thread$UncaughtExceptionHandler r0 = r7.f16788c
            r0.uncaughtException(r8, r9)
            goto L_0x0041
        L_0x0037:
            u0.g r8 = u0.g.f()
            r8.b(r0)
            java.lang.System.exit(r3)
        L_0x0041:
            java.util.concurrent.atomic.AtomicBoolean r8 = r7.f16790e
            r8.set(r2)
            return
        L_0x0047:
            u0.g r5 = u0.g.f()     // Catch:{ all -> 0x0019 }
            java.lang.String r6 = "An error occurred in the uncaught exception handler"
            r5.e(r6, r4)     // Catch:{ all -> 0x0019 }
            java.lang.Thread$UncaughtExceptionHandler r4 = r7.f16788c
            if (r4 == 0) goto L_0x0037
            goto L_0x002a
        L_0x0055:
            java.lang.Thread$UncaughtExceptionHandler r5 = r7.f16788c
            if (r5 == 0) goto L_0x0066
            u0.g r0 = u0.g.f()
            r0.b(r1)
            java.lang.Thread$UncaughtExceptionHandler r0 = r7.f16788c
            r0.uncaughtException(r8, r9)
            goto L_0x0070
        L_0x0066:
            u0.g r8 = u0.g.f()
            r8.b(r0)
            java.lang.System.exit(r3)
        L_0x0070:
            java.util.concurrent.atomic.AtomicBoolean r8 = r7.f16790e
            r8.set(r2)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: x0.C1904B.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
    }
}
