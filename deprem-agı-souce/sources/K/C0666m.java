package K;

import N.C0722p;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;

/* renamed from: K.m  reason: case insensitive filesystem */
public class C0666m {

    /* renamed from: c  reason: collision with root package name */
    private static C0666m f2726c;

    /* renamed from: a  reason: collision with root package name */
    private final Context f2727a;

    /* renamed from: b  reason: collision with root package name */
    private volatile String f2728b;

    public C0666m(Context context) {
        this.f2727a = context.getApplicationContext();
    }

    public static C0666m a(Context context) {
        C0722p.k(context);
        synchronized (C0666m.class) {
            try {
                if (f2726c == null) {
                    D.d(context);
                    f2726c = new C0666m(context);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return f2726c;
    }

    static final z d(PackageInfo packageInfo, z... zVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            C0653A a5 = new C0653A(packageInfo.signatures[0].toByteArray());
            for (int i5 = 0; i5 < zVarArr.length; i5++) {
                if (zVarArr[i5].equals(a5)) {
                    return zVarArr[i5];
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0047 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean e(android.content.pm.PackageInfo r4, boolean r5) {
        /*
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L_0x0027
            if (r4 == 0) goto L_0x0029
            java.lang.String r2 = "com.android.vending"
            java.lang.String r3 = r4.packageName
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x001a
            java.lang.String r2 = r4.packageName
            java.lang.String r3 = "com.google.android.gms"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0027
        L_0x001a:
            android.content.pm.ApplicationInfo r5 = r4.applicationInfo
            if (r5 != 0) goto L_0x0020
        L_0x001e:
            r5 = r1
            goto L_0x0027
        L_0x0020:
            int r5 = r5.flags
            r5 = r5 & 129(0x81, float:1.81E-43)
            if (r5 == 0) goto L_0x001e
            r5 = r0
        L_0x0027:
            r2 = r4
            goto L_0x002a
        L_0x0029:
            r2 = 0
        L_0x002a:
            if (r4 == 0) goto L_0x0048
            android.content.pm.Signature[] r4 = r2.signatures
            if (r4 == 0) goto L_0x0048
            if (r5 == 0) goto L_0x0039
            K.z[] r4 = K.C.f2671a
            K.z r4 = d(r2, r4)
            goto L_0x0045
        L_0x0039:
            K.z[] r4 = K.C.f2671a
            r4 = r4[r1]
            K.z[] r5 = new K.z[r0]
            r5[r1] = r4
            K.z r4 = d(r2, r5)
        L_0x0045:
            if (r4 == 0) goto L_0x0048
            return r0
        L_0x0048:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: K.C0666m.e(android.content.pm.PackageInfo, boolean):boolean");
    }

    private final M f(String str, boolean z4, boolean z5) {
        M m5;
        ApplicationInfo applicationInfo;
        if (str == null) {
            return M.c("null pkg");
        }
        if (str.equals(this.f2728b)) {
            return M.b();
        }
        if (D.e()) {
            m5 = D.b(str, C0665l.f(this.f2727a), false, false);
        } else {
            try {
                PackageInfo packageInfo = this.f2727a.getPackageManager().getPackageInfo(str, 64);
                boolean f5 = C0665l.f(this.f2727a);
                if (packageInfo == null) {
                    m5 = M.c("null pkg");
                } else {
                    Signature[] signatureArr = packageInfo.signatures;
                    if (signatureArr == null || signatureArr.length != 1) {
                        m5 = M.c("single cert required");
                    } else {
                        C0653A a5 = new C0653A(packageInfo.signatures[0].toByteArray());
                        String str2 = packageInfo.packageName;
                        M a6 = D.a(str2, a5, f5, false);
                        if (!a6.f2695a || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 2) == 0 || !D.a(str2, a5, false, true).f2695a) {
                            m5 = a6;
                        } else {
                            m5 = M.c("debuggable release cert app rejected");
                        }
                    }
                }
            } catch (PackageManager.NameNotFoundException e5) {
                return M.d("no pkg ".concat(str), e5);
            }
        }
        if (m5.f2695a) {
            this.f2728b = str;
        }
        return m5;
    }

    public boolean b(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (e(packageInfo, false)) {
            return true;
        }
        if (e(packageInfo, true)) {
            if (C0665l.f(this.f2727a)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    public boolean c(int i5) {
        M m5;
        int length;
        String[] packagesForUid = this.f2727a.getPackageManager().getPackagesForUid(i5);
        if (packagesForUid != null && (length = packagesForUid.length) != 0) {
            m5 = null;
            int i6 = 0;
            while (true) {
                if (i6 >= length) {
                    C0722p.k(m5);
                    break;
                }
                m5 = f(packagesForUid[i6], false, false);
                if (m5.f2695a) {
                    break;
                }
                i6++;
            }
        } else {
            m5 = M.c("no pkgs");
        }
        m5.e();
        return m5.f2695a;
    }
}
