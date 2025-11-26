package T0;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import o0.f;
import org.json.JSONException;
import org.json.JSONObject;

public class b {

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f4369c = {"*", "FCM", "GCM", ""};

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f4370a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4371b;

    public b(f fVar) {
        this.f4370a = fVar.k().getSharedPreferences("com.google.android.gms.appid", 0);
        this.f4371b = b(fVar);
    }

    private String a(String str, String str2) {
        return "|T|" + str + "|" + str2;
    }

    private static String b(f fVar) {
        String d5 = fVar.n().d();
        if (d5 != null) {
            return d5;
        }
        String c5 = fVar.n().c();
        if (!c5.startsWith("1:") && !c5.startsWith("2:")) {
            return c5;
        }
        String[] split = c5.split(":");
        if (split.length != 4) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    private static String c(PublicKey publicKey) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(publicKey.getEncoded());
            digest[0] = (byte) (((digest[0] & 15) + 112) & 255);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException unused) {
            Log.w("ContentValues", "Unexpected error, device missing required algorithms");
            return null;
        }
    }

    private String d(String str) {
        try {
            return new JSONObject(str).getString("token");
        } catch (JSONException unused) {
            return null;
        }
    }

    private PublicKey e(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 8)));
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException e5) {
            Log.w("ContentValues", "Invalid key stored " + e5);
            return null;
        }
    }

    private String g() {
        String string;
        synchronized (this.f4370a) {
            string = this.f4370a.getString("|S|id", (String) null);
        }
        return string;
    }

    private String h() {
        synchronized (this.f4370a) {
            try {
                String string = this.f4370a.getString("|S||P|", (String) null);
                if (string == null) {
                    return null;
                }
                PublicKey e5 = e(string);
                if (e5 == null) {
                    return null;
                }
                String c5 = c(e5);
                return c5;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String f() {
        synchronized (this.f4370a) {
            try {
                String g5 = g();
                if (g5 != null) {
                    return g5;
                }
                String h5 = h();
                return h5;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0030, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String i() {
        /*
            r7 = this;
            android.content.SharedPreferences r0 = r7.f4370a
            monitor-enter(r0)
            java.lang.String[] r1 = f4369c     // Catch:{ all -> 0x002d }
            int r2 = r1.length     // Catch:{ all -> 0x002d }
            r3 = 0
        L_0x0007:
            r4 = 0
            if (r3 >= r2) goto L_0x0034
            r5 = r1[r3]     // Catch:{ all -> 0x002d }
            java.lang.String r6 = r7.f4371b     // Catch:{ all -> 0x002d }
            java.lang.String r5 = r7.a(r6, r5)     // Catch:{ all -> 0x002d }
            android.content.SharedPreferences r6 = r7.f4370a     // Catch:{ all -> 0x002d }
            java.lang.String r4 = r6.getString(r5, r4)     // Catch:{ all -> 0x002d }
            if (r4 == 0) goto L_0x0031
            boolean r5 = r4.isEmpty()     // Catch:{ all -> 0x002d }
            if (r5 != 0) goto L_0x0031
            java.lang.String r1 = "{"
            boolean r1 = r4.startsWith(r1)     // Catch:{ all -> 0x002d }
            if (r1 == 0) goto L_0x002f
            java.lang.String r4 = r7.d(r4)     // Catch:{ all -> 0x002d }
            goto L_0x002f
        L_0x002d:
            r1 = move-exception
            goto L_0x0036
        L_0x002f:
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return r4
        L_0x0031:
            int r3 = r3 + 1
            goto L_0x0007
        L_0x0034:
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return r4
        L_0x0036:
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: T0.b.i():java.lang.String");
    }
}
