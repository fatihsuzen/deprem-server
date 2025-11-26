package b2;

import S1.k;
import U1.C2201a;
import W2.J;
import W2.u;
import X1.C2224a;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageInstallObserver;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.ResultReceiver;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.io.File;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.M;
import w3.N;
import w3.O;

/* renamed from: b2.J  reason: case insensitive filesystem */
public final class C2278J {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f20481a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final C2224a f20482b;

    /* renamed from: b2.J$a */
    public final class a extends IPackageInstallObserver.Stub {
        public a() {
        }

        public void packageInstalled(String str, int i5) {
            t.e(str, "packageName");
            if (i5 == 1) {
                C2224a b5 = C2278J.this.f20482b;
                if (b5 != null) {
                    b5.b(str);
                }
                k.a aVar = k.f32g;
                if (aVar.v() != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("packageName", str);
                    ResultReceiver v5 = aVar.v();
                    if (v5 != null) {
                        v5.send(352, bundle);
                    }
                }
            }
            k.f32g.e();
        }
    }

    /* renamed from: b2.J$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20484a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2278J f20485b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ File f20486c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C2278J j5, File file, C2308e eVar) {
            super(2, eVar);
            this.f20485b = j5;
            this.f20486c = file;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f20485b, this.f20486c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f20484a;
            if (i5 == 0) {
                u.b(obj);
                C2278J j5 = this.f20485b;
                File file = this.f20486c;
                this.f20484a = 1;
                if (j5.h(file, this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: b2.J$c */
    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20487a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2278J f20488b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ File f20489c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(C2278J j5, File file, C2308e eVar) {
            super(2, eVar);
            this.f20488b = j5;
            this.f20489c = file;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f20488b, this.f20489c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f20487a == 0) {
                u.b(obj);
                try {
                    if (new C2201a(this.f20488b.f20481a).t()) {
                        this.f20488b.g(this.f20489c);
                        return J.f19942a;
                    }
                    C2224a b5 = this.f20488b.f20482b;
                    if (b5 == null) {
                        return null;
                    }
                    b5.f(this.f20489c.getPath());
                    return J.f19942a;
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return J.f19942a;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public C2278J(Context context, C2224a aVar) {
        t.e(context, "context");
        this.f20481a = context;
        this.f20482b = aVar;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(12:11|12|13|14|(4:16|(1:18)|19|(2:21|(2:23|24)(1:62))(1:61))|25|26|(1:28)|29|(2:31|(1:33))|34|63) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x008e */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0092 A[Catch:{ Exception -> 0x002d, Error -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a4 A[Catch:{ Exception -> 0x002d, Error -> 0x002a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g(java.io.File r22) {
        /*
            r21 = this;
            r1 = r21
            java.lang.String r0 = "versionCode"
            java.lang.String r2 = "fileName"
            java.lang.String r3 = "packageName"
            java.lang.String r4 = "getAbsolutePath(...)"
            java.lang.String r5 = "getName(...)"
            r6 = 353(0x161, float:4.95E-43)
            android.content.Context r7 = r1.f20481a     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            android.content.pm.PackageManager r7 = r7.getPackageManager()     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            kotlin.jvm.internal.t.b(r7)     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            java.lang.String r8 = r22.getAbsolutePath()     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            kotlin.jvm.internal.t.d(r8, r4)     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            r9 = 128(0x80, float:1.794E-43)
            android.content.pm.PackageInfo r8 = b2.C2301u.c(r7, r8, r9)     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            r9 = 0
            if (r8 == 0) goto L_0x0030
            android.content.pm.ApplicationInfo r10 = r8.applicationInfo     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            goto L_0x0031
        L_0x002a:
            r0 = move-exception
            goto L_0x015e
        L_0x002d:
            r0 = move-exception
            goto L_0x0191
        L_0x0030:
            r10 = r9
        L_0x0031:
            if (r10 == 0) goto L_0x0132
            android.content.pm.ApplicationInfo r10 = r8.applicationInfo     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            kotlin.jvm.internal.t.b(r10)     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            java.lang.String r10 = r10.packageName     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            b2.j r11 = new b2.j     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            r11.<init>()     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            long r11 = r11.m(r8)     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            r13 = 0
            android.content.Context r14 = r1.f20481a     // Catch:{ NameNotFoundException -> 0x008e }
            android.content.pm.PackageManager r14 = r14.getPackageManager()     // Catch:{ NameNotFoundException -> 0x008e }
            java.lang.String r15 = "getPackageManager(...)"
            kotlin.jvm.internal.t.d(r14, r15)     // Catch:{ NameNotFoundException -> 0x008e }
            kotlin.jvm.internal.t.b(r10)     // Catch:{ NameNotFoundException -> 0x008e }
            android.content.pm.PackageInfo r14 = b2.C2301u.d(r14, r10, r13)     // Catch:{ NameNotFoundException -> 0x008e }
            b2.j r15 = new b2.j     // Catch:{ NameNotFoundException -> 0x008e }
            r15.<init>()     // Catch:{ NameNotFoundException -> 0x008e }
            long r14 = r15.m(r14)     // Catch:{ NameNotFoundException -> 0x008e }
            int r14 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
            if (r14 <= 0) goto L_0x008e
            X1.a r14 = r1.f20482b     // Catch:{ NameNotFoundException -> 0x008e }
            if (r14 == 0) goto L_0x0071
            java.lang.String r15 = r22.getName()     // Catch:{ NameNotFoundException -> 0x008e }
            kotlin.jvm.internal.t.d(r15, r5)     // Catch:{ NameNotFoundException -> 0x008e }
            r14.e(r15)     // Catch:{ NameNotFoundException -> 0x008e }
        L_0x0071:
            S1.k$a r14 = S1.k.f32g     // Catch:{ NameNotFoundException -> 0x008e }
            android.os.ResultReceiver r15 = r14.v()     // Catch:{ NameNotFoundException -> 0x008e }
            if (r15 == 0) goto L_0x01c3
            android.os.Bundle r15 = new android.os.Bundle     // Catch:{ NameNotFoundException -> 0x008e }
            r15.<init>()     // Catch:{ NameNotFoundException -> 0x008e }
            r15.putString(r3, r10)     // Catch:{ NameNotFoundException -> 0x008e }
            r15.putLong(r0, r11)     // Catch:{ NameNotFoundException -> 0x008e }
            android.os.ResultReceiver r14 = r14.v()     // Catch:{ NameNotFoundException -> 0x008e }
            if (r14 == 0) goto L_0x01c3
            r14.send(r6, r15)     // Catch:{ NameNotFoundException -> 0x008e }
            return
        L_0x008e:
            X1.a r14 = r1.f20482b     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            if (r14 == 0) goto L_0x009c
            java.lang.String r15 = r22.getName()     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            kotlin.jvm.internal.t.d(r15, r5)     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            r14.a(r15)     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
        L_0x009c:
            S1.k$a r14 = S1.k.f32g     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            android.os.ResultReceiver r15 = r14.v()     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            if (r15 == 0) goto L_0x00ba
            android.os.Bundle r15 = new android.os.Bundle     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            r15.<init>()     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            r15.putString(r3, r10)     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            r15.putLong(r0, r11)     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            android.os.ResultReceiver r0 = r14.v()     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            if (r0 == 0) goto L_0x00ba
            r10 = 351(0x15f, float:4.92E-43)
            r0.send(r10, r15)     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
        L_0x00ba:
            b2.j r0 = new b2.j     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            r0.<init>()     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            android.content.pm.ApplicationInfo r10 = r8.applicationInfo     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            kotlin.jvm.internal.t.b(r10)     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            java.lang.String r11 = r22.getAbsolutePath()     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            kotlin.jvm.internal.t.d(r11, r4)     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            java.lang.String r18 = r0.b(r10, r11, r7)     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            b2.j r0 = new b2.j     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            r0.<init>()     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            long r16 = r0.m(r8)     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            b2.i r0 = new b2.i     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            r0.<init>()     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            java.lang.String r10 = r22.getAbsolutePath()     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            kotlin.jvm.internal.t.d(r10, r4)     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            long r19 = r0.j(r10)     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            java.lang.String r15 = r8.packageName     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            kotlin.jvm.internal.t.d(r15, r3)     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            r14.B(r15, r16, r18, r19)     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            b2.J$a r0 = new b2.J$a     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            r0.<init>()     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            r3 = 4
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            java.lang.Class<android.net.Uri> r8 = android.net.Uri.class
            r4[r13] = r8     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            java.lang.Class<android.content.pm.IPackageInstallObserver> r8 = android.content.pm.IPackageInstallObserver.class
            r10 = 1
            r4[r10] = r8     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            r11 = 2
            r4[r11] = r8     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            r12 = 3
            r4[r12] = r8     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            java.lang.Class r8 = r7.getClass()     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            java.lang.String r14 = "installPackage"
            java.lang.Object[] r4 = java.util.Arrays.copyOf(r4, r3)     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            java.lang.Class[] r4 = (java.lang.Class[]) r4     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            java.lang.reflect.Method r4 = r8.getMethod(r14, r4)     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            android.net.Uri r8 = android.net.Uri.fromFile(r22)     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r11)     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            r3[r13] = r8     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            r3[r10] = r0     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            r3[r11] = r14     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            r3[r12] = r9     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            r4.invoke(r7, r3)     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            goto L_0x01c3
        L_0x0132:
            X1.a r0 = r1.f20482b     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            if (r0 == 0) goto L_0x0140
            java.lang.String r3 = r22.getName()     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            kotlin.jvm.internal.t.d(r3, r5)     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            r0.d(r3)     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
        L_0x0140:
            S1.k$a r0 = S1.k.f32g     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            android.os.ResultReceiver r3 = r0.v()     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            if (r3 == 0) goto L_0x01c3
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            r3.<init>()     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            java.lang.String r4 = r22.getName()     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            r3.putString(r2, r4)     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            android.os.ResultReceiver r0 = r0.v()     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            if (r0 == 0) goto L_0x01c3
            r0.send(r6, r3)     // Catch:{ Exception -> 0x002d, Error -> 0x002a }
            return
        L_0x015e:
            S1.k$a r3 = S1.k.f32g
            r3.e()
            X1.a r4 = r1.f20482b
            if (r4 == 0) goto L_0x0175
            java.lang.String r7 = r22.getName()
            kotlin.jvm.internal.t.d(r7, r5)
            java.lang.String r0 = r0.getMessage()
            r4.c(r7, r0)
        L_0x0175:
            android.os.ResultReceiver r0 = r3.v()
            if (r0 == 0) goto L_0x01c3
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r4 = r22.getName()
            r0.putString(r2, r4)
            android.os.ResultReceiver r2 = r3.v()
            if (r2 == 0) goto L_0x01c3
            r2.send(r6, r0)
            goto L_0x01c3
        L_0x0191:
            S1.k$a r3 = S1.k.f32g
            r3.e()
            X1.a r4 = r1.f20482b
            if (r4 == 0) goto L_0x01a8
            java.lang.String r7 = r22.getName()
            kotlin.jvm.internal.t.d(r7, r5)
            java.lang.String r0 = r0.getMessage()
            r4.c(r7, r0)
        L_0x01a8:
            android.os.ResultReceiver r0 = r3.v()
            if (r0 == 0) goto L_0x01c3
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r4 = r22.getName()
            r0.putString(r2, r4)
            android.os.ResultReceiver r2 = r3.v()
            if (r2 == 0) goto L_0x01c3
            r2.send(r6, r0)
        L_0x01c3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.C2278J.g(java.io.File):void");
    }

    /* access modifiers changed from: private */
    public final Object h(File file, C2308e eVar) {
        return C2872g.g(C2865c0.b(), new c(this, file, (C2308e) null), eVar);
    }

    public final boolean e() {
        PackageManager packageManager = this.f20481a.getPackageManager();
        int checkPermission = packageManager.checkPermission("android.permission.INSTALL_PACKAGES", this.f20481a.getPackageName());
        int checkPermission2 = packageManager.checkPermission("android.permission.DELETE_PACKAGES", this.f20481a.getPackageName());
        if (checkPermission == 0 && checkPermission2 == 0) {
            return true;
        }
        try {
            t.b(packageManager);
            String packageName = this.f20481a.getPackageName();
            t.d(packageName, "getPackageName(...)");
            return i(C2301u.d(packageManager, packageName, 4096));
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public final void f(File file) {
        t.e(file, "file");
        C2908y0 unused = C2876i.d(N.a(C2865c0.b()), (C2312i) null, (O) null, new b(this, file, (C2308e) null), 3, (Object) null);
    }

    public final boolean i(PackageInfo packageInfo) {
        ApplicationInfo applicationInfo;
        if (packageInfo != null) {
            applicationInfo = packageInfo.applicationInfo;
        } else {
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            return false;
        }
        ApplicationInfo applicationInfo2 = packageInfo.applicationInfo;
        t.b(applicationInfo2);
        if ((applicationInfo2.flags & TsExtractor.TS_STREAM_TYPE_AC3) != 0) {
            return true;
        }
        return false;
    }
}
