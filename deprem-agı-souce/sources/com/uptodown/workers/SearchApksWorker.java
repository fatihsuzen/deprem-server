package com.uptodown.workers;

import S1.k;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import b2.C2289i;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import t3.s;
import z2.C2940B;

public final class SearchApksWorker extends Worker {

    /* renamed from: b  reason: collision with root package name */
    public static final a f21408b = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private Context f21409a;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchApksWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        t.e(context, "context");
        t.e(workerParameters, "params");
        this.f21409a = context;
        this.f21409a = k.f32g.a(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean d(java.io.File r10, int r11) {
        /*
            r9 = this;
            java.lang.String r0 = r10.getName()
            java.lang.String r1 = "getName(...)"
            kotlin.jvm.internal.t.d(r0, r1)
            r2 = 2
            java.lang.String r3 = ".apk"
            r4 = 0
            r5 = 0
            boolean r0 = t3.s.D(r0, r3, r4, r2, r5)
            r2 = -1
            if (r0 == 0) goto L_0x0055
            android.content.Context r0 = r9.f21409a     // Catch:{ NameNotFoundException -> 0x0046 }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0046 }
            java.lang.String r1 = "getPackageManager(...)"
            kotlin.jvm.internal.t.d(r0, r1)     // Catch:{ NameNotFoundException -> 0x0046 }
            java.lang.String r1 = r10.getAbsolutePath()     // Catch:{ NameNotFoundException -> 0x0046 }
            java.lang.String r6 = "getAbsolutePath(...)"
            kotlin.jvm.internal.t.d(r1, r6)     // Catch:{ NameNotFoundException -> 0x0046 }
            r6 = 128(0x80, float:1.794E-43)
            android.content.pm.PackageInfo r0 = b2.C2301u.c(r0, r1, r6)     // Catch:{ NameNotFoundException -> 0x0046 }
            if (r0 == 0) goto L_0x0047
            android.content.Context r1 = r9.f21409a     // Catch:{ NameNotFoundException -> 0x0047 }
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0047 }
            if (r1 == 0) goto L_0x0047
            java.lang.String r6 = r0.packageName     // Catch:{ NameNotFoundException -> 0x0047 }
            java.lang.String r7 = "packageName"
            kotlin.jvm.internal.t.d(r6, r7)     // Catch:{ NameNotFoundException -> 0x0047 }
            android.content.pm.PackageInfo r5 = b2.C2301u.d(r1, r6, r4)     // Catch:{ NameNotFoundException -> 0x0047 }
            goto L_0x0047
        L_0x0046:
            r0 = r5
        L_0x0047:
            if (r0 == 0) goto L_0x0053
            b2.j r1 = new b2.j
            r1.<init>()
            long r0 = r1.m(r0)
            goto L_0x0088
        L_0x0053:
            r0 = r2
            goto L_0x0088
        L_0x0055:
            b2.K$a r0 = b2.C2279K.f20490b
            java.lang.String r6 = r10.getName()
            kotlin.jvm.internal.t.d(r6, r1)
            boolean r0 = r0.a(r6)
            if (r0 == 0) goto L_0x0053
            b2.K r0 = new b2.K
            r0.<init>()
            android.content.Context r1 = r9.f21409a
            Y1.h r0 = r0.e(r10, r1)
            if (r0 == 0) goto L_0x0087
            long r6 = r0.b()
            android.content.Context r1 = r9.f21409a     // Catch:{ NameNotFoundException -> 0x0085 }
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0085 }
            if (r1 == 0) goto L_0x0085
            java.lang.String r0 = r0.a()     // Catch:{ NameNotFoundException -> 0x0085 }
            android.content.pm.PackageInfo r5 = b2.C2301u.d(r1, r0, r4)     // Catch:{ NameNotFoundException -> 0x0085 }
        L_0x0085:
            r0 = r6
            goto L_0x0088
        L_0x0087:
            return r4
        L_0x0088:
            if (r5 == 0) goto L_0x0094
            b2.j r6 = new b2.j
            r6.<init>()
            long r5 = r6.m(r5)
            goto L_0x0095
        L_0x0094:
            r5 = r2
        L_0x0095:
            int r7 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            r8 = 1
            if (r7 <= 0) goto L_0x00bd
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x00bc
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x00aa
            z2.M r0 = z2.M.f26506a
            android.content.Context r1 = r9.f21409a
            r0.o(r1, r10, r4, r11)
            return r8
        L_0x00aa:
            if (r0 >= 0) goto L_0x00b4
            z2.M r0 = z2.M.f26506a
            android.content.Context r1 = r9.f21409a
            r0.o(r1, r10, r8, r11)
            return r8
        L_0x00b4:
            z2.M r0 = z2.M.f26506a
            android.content.Context r1 = r9.f21409a
            r0.o(r1, r10, r4, r11)
            return r8
        L_0x00bc:
            return r4
        L_0x00bd:
            z2.M r0 = z2.M.f26506a
            android.content.Context r1 = r9.f21409a
            r0.o(r1, r10, r8, r11)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.SearchApksWorker.d(java.io.File, int):boolean");
    }

    public ListenableWorker.Result doWork() {
        boolean z4;
        ListenableWorker.Result success = ListenableWorker.Result.success();
        try {
            ArrayList s5 = new C2289i().s(this.f21409a);
            C2940B a5 = C2940B.f26458v.a(this.f21409a);
            a5.a();
            ArrayList s02 = a5.s0();
            Iterator it = s5.iterator();
            t.d(it, "iterator(...)");
            int i5 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                t.d(next, "next(...)");
                File file = (File) next;
                Iterator it2 = s02.iterator();
                int i6 = 0;
                while (true) {
                    if (!it2.hasNext()) {
                        i6 = -1;
                        z4 = false;
                        break;
                    }
                    int i7 = i6 + 1;
                    if (s.E(file.getAbsolutePath(), (String) it2.next(), false)) {
                        z4 = true;
                        break;
                    }
                    i6 = i7;
                }
                if (z4) {
                    s02.remove(i6);
                } else if (i5 < 10 && d(file, i5)) {
                    a5.V0(file.getAbsolutePath());
                    i5++;
                }
            }
            Iterator it3 = s02.iterator();
            t.d(it3, "iterator(...)");
            while (it3.hasNext()) {
                Object next2 = it3.next();
                t.d(next2, "next(...)");
                a5.G((String) next2);
            }
            a5.m();
        } catch (Exception e5) {
            e5.printStackTrace();
            success = ListenableWorker.Result.failure();
        }
        t.b(success);
        return success;
    }
}
