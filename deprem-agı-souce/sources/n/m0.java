package N;

import android.content.ComponentName;
import android.net.Uri;

public final class m0 {

    /* renamed from: f  reason: collision with root package name */
    private static final Uri f3115f = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    /* renamed from: a  reason: collision with root package name */
    private final String f3116a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3117b;

    /* renamed from: c  reason: collision with root package name */
    private final ComponentName f3118c = null;

    /* renamed from: d  reason: collision with root package name */
    private final int f3119d = 4225;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f3120e;

    public m0(String str, String str2, int i5, boolean z4) {
        C0722p.e(str);
        this.f3116a = str;
        C0722p.e(str2);
        this.f3117b = str2;
        this.f3120e = z4;
    }

    public final ComponentName a() {
        return this.f3118c;
    }

    /* JADX WARNING: type inference failed for: r6v10, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0090 A[PHI: r2 
      PHI: (r2v2 android.content.Intent) = (r2v0 android.content.Intent), (r2v4 android.content.Intent), (r2v4 android.content.Intent) binds: [B:26:0x0050, B:28:0x005b, B:30:0x0065] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.content.Intent b(android.content.Context r6) {
        /*
            r5 = this;
            java.lang.String r0 = "ConnectionStatusConfig"
            java.lang.String r1 = r5.f3116a
            if (r1 == 0) goto L_0x00b2
            boolean r1 = r5.f3120e
            r2 = 0
            if (r1 == 0) goto L_0x00a1
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            java.lang.String r3 = r5.f3116a
            java.lang.String r4 = "serviceActionBundleKey"
            r1.putString(r4, r3)
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch:{ RemoteException -> 0x0038, IllegalArgumentException -> 0x0036 }
            android.net.Uri r3 = f3115f     // Catch:{ RemoteException -> 0x0038, IllegalArgumentException -> 0x0036 }
            android.content.ContentProviderClient r6 = r6.acquireUnstableContentProviderClient(r3)     // Catch:{ RemoteException -> 0x0038, IllegalArgumentException -> 0x0036 }
            if (r6 == 0) goto L_0x003a
            java.lang.String r3 = "serviceIntentCall"
            android.os.Bundle r1 = r6.call(r3, r2, r1)     // Catch:{ all -> 0x0031 }
            r6.release()     // Catch:{ RemoteException -> 0x002f, IllegalArgumentException -> 0x002d }
            goto L_0x0050
        L_0x002d:
            r6 = move-exception
            goto L_0x0043
        L_0x002f:
            r6 = move-exception
            goto L_0x0043
        L_0x0031:
            r1 = move-exception
            r6.release()     // Catch:{ RemoteException -> 0x0038, IllegalArgumentException -> 0x0036 }
            throw r1     // Catch:{ RemoteException -> 0x0038, IllegalArgumentException -> 0x0036 }
        L_0x0036:
            r6 = move-exception
            goto L_0x0042
        L_0x0038:
            r6 = move-exception
            goto L_0x0042
        L_0x003a:
            android.os.RemoteException r6 = new android.os.RemoteException     // Catch:{ RemoteException -> 0x0038, IllegalArgumentException -> 0x0036 }
            java.lang.String r1 = "Failed to acquire ContentProviderClient"
            r6.<init>(r1)     // Catch:{ RemoteException -> 0x0038, IllegalArgumentException -> 0x0036 }
            throw r6     // Catch:{ RemoteException -> 0x0038, IllegalArgumentException -> 0x0036 }
        L_0x0042:
            r1 = r2
        L_0x0043:
            java.lang.String r3 = "Dynamic intent resolution failed: "
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r3.concat(r6)
            android.util.Log.w(r0, r6)
        L_0x0050:
            if (r1 == 0) goto L_0x0090
            java.lang.String r6 = "serviceResponseIntentKey"
            android.os.Parcelable r6 = r1.getParcelable(r6)
            r2 = r6
            android.content.Intent r2 = (android.content.Intent) r2
            if (r2 != 0) goto L_0x0090
            java.lang.String r6 = "serviceMissingResolutionIntentKey"
            android.os.Parcelable r6 = r1.getParcelable(r6)
            android.app.PendingIntent r6 = (android.app.PendingIntent) r6
            if (r6 != 0) goto L_0x0068
            goto L_0x0090
        L_0x0068:
            java.lang.String r1 = r5.f3116a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Dynamic lookup for intent failed for action "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = " but has possible resolution"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            android.util.Log.w(r0, r1)
            N.a0 r0 = new N.a0
            K.b r1 = new K.b
            r2 = 25
            r1.<init>(r2, r6)
            r0.<init>(r1)
            throw r0
        L_0x0090:
            if (r2 != 0) goto L_0x00a1
            java.lang.String r6 = r5.f3116a
            java.lang.String r1 = "Dynamic lookup for intent failed for action: "
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r6 = r1.concat(r6)
            android.util.Log.w(r0, r6)
        L_0x00a1:
            if (r2 != 0) goto L_0x00b1
            java.lang.String r6 = r5.f3116a
            android.content.Intent r0 = new android.content.Intent
            r0.<init>(r6)
            java.lang.String r6 = r5.f3117b
            android.content.Intent r6 = r0.setPackage(r6)
            return r6
        L_0x00b1:
            return r2
        L_0x00b2:
            android.content.Intent r6 = new android.content.Intent
            r6.<init>()
            android.content.ComponentName r0 = r5.f3118c
            android.content.Intent r6 = r6.setComponent(r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: N.m0.b(android.content.Context):android.content.Intent");
    }

    public final String c() {
        return this.f3117b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m0)) {
            return false;
        }
        m0 m0Var = (m0) obj;
        if (!C0720n.a(this.f3116a, m0Var.f3116a) || !C0720n.a(this.f3117b, m0Var.f3117b) || !C0720n.a(this.f3118c, m0Var.f3118c) || this.f3120e != m0Var.f3120e) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return C0720n.b(this.f3116a, this.f3117b, this.f3118c, 4225, Boolean.valueOf(this.f3120e));
    }

    public final String toString() {
        String str = this.f3116a;
        if (str != null) {
            return str;
        }
        C0722p.k(this.f3118c);
        return this.f3118c.flattenToString();
    }
}
