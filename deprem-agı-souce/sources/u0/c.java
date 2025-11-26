package U0;

import N.C0722p;
import R0.b;
import U0.d;
import U0.f;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.TrafficStats;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import androidx.browser.trusted.sharing.ShareTarget;
import com.google.android.gms.common.util.a;
import com.google.android.gms.common.util.i;
import com.google.firebase.installations.d;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import k0.C1701o;
import org.json.JSONException;
import org.json.JSONObject;

public class c {

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f4399d = Pattern.compile("[0-9]+s");

    /* renamed from: e  reason: collision with root package name */
    private static final Charset f4400e = Charset.forName(C.UTF8_NAME);

    /* renamed from: a  reason: collision with root package name */
    private final Context f4401a;

    /* renamed from: b  reason: collision with root package name */
    private final b f4402b;

    /* renamed from: c  reason: collision with root package name */
    private final e f4403c = new e();

    public c(Context context, b bVar) {
        this.f4401a = context;
        this.f4402b = bVar;
    }

    private static String a(String str, String str2, String str3) {
        String str4;
        if (TextUtils.isEmpty(str)) {
            str4 = "";
        } else {
            str4 = ", " + str;
        }
        return String.format("Firebase options used while communicating with Firebase server APIs: %s, %s%s", new Object[]{str2, str3, str4});
    }

    private static JSONObject b(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("fid", str);
            jSONObject.put("appId", str2);
            jSONObject.put("authVersion", "FIS_v2");
            jSONObject.put("sdkVersion", "a:19.0.1");
            return jSONObject;
        } catch (JSONException e5) {
            throw new IllegalStateException(e5);
        }
    }

    private static JSONObject c() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sdkVersion", "a:19.0.1");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("installation", jSONObject);
            return jSONObject2;
        } catch (JSONException e5) {
            throw new IllegalStateException(e5);
        }
    }

    private String f() {
        try {
            Context context = this.f4401a;
            byte[] a5 = a.a(context, context.getPackageName());
            if (a5 != null) {
                return i.b(a5, false);
            }
            Log.e("ContentValues", "Could not get fingerprint hash for package: " + this.f4401a.getPackageName());
            return null;
        } catch (PackageManager.NameNotFoundException e5) {
            Log.e("ContentValues", "No such package: " + this.f4401a.getPackageName(), e5);
            return null;
        }
    }

    private URL g(String str) {
        try {
            return new URL(String.format("https://%s/%s/%s", new Object[]{"firebaseinstallations.googleapis.com", "v1", str}));
        } catch (MalformedURLException e5) {
            throw new d(e5.getMessage(), d.a.UNAVAILABLE);
        }
    }

    private static byte[] h(JSONObject jSONObject) {
        return jSONObject.toString().getBytes(C.UTF8_NAME);
    }

    private static boolean i(int i5) {
        if (i5 < 200 || i5 >= 300) {
            return false;
        }
        return true;
    }

    private static void j() {
        Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
    }

    private static void k(HttpURLConnection httpURLConnection, String str, String str2, String str3) {
        String o5 = o(httpURLConnection);
        if (!TextUtils.isEmpty(o5)) {
            Log.w("Firebase-Installations", o5);
            Log.w("Firebase-Installations", a(str, str2, str3));
        }
    }

    private HttpURLConnection l(URL url, String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.addRequestProperty("Content-Type", "application/json");
            httpURLConnection.addRequestProperty("Accept", "application/json");
            httpURLConnection.addRequestProperty("Content-Encoding", "gzip");
            httpURLConnection.addRequestProperty("Cache-Control", "no-cache");
            httpURLConnection.addRequestProperty("X-Android-Package", this.f4401a.getPackageName());
            P0.i iVar = (P0.i) this.f4402b.get();
            if (iVar != null) {
                try {
                    httpURLConnection.addRequestProperty("x-firebase-client", (String) C1701o.a(iVar.a()));
                } catch (ExecutionException e5) {
                    Log.w("ContentValues", "Failed to get heartbeats header", e5);
                } catch (InterruptedException e6) {
                    Thread.currentThread().interrupt();
                    Log.w("ContentValues", "Failed to get heartbeats header", e6);
                }
            }
            httpURLConnection.addRequestProperty("X-Android-Cert", f());
            httpURLConnection.addRequestProperty("x-goog-api-key", str);
            return httpURLConnection;
        } catch (IOException unused) {
            throw new d("Firebase Installations Service is unavailable. Please try again later.", d.a.UNAVAILABLE);
        }
    }

    static long m(String str) {
        C0722p.b(f4399d.matcher(str).matches(), "Invalid Expiration Timestamp.");
        if (str == null || str.length() == 0) {
            return 0;
        }
        return Long.parseLong(str.substring(0, str.length() - 1));
    }

    private d n(HttpURLConnection httpURLConnection) {
        InputStream inputStream = httpURLConnection.getInputStream();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, f4400e));
        f.a a5 = f.a();
        d.a a6 = d.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals(RewardPlus.NAME)) {
                a6.f(jsonReader.nextString());
            } else if (nextName.equals("fid")) {
                a6.c(jsonReader.nextString());
            } else if (nextName.equals("refreshToken")) {
                a6.d(jsonReader.nextString());
            } else if (nextName.equals("authToken")) {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName2 = jsonReader.nextName();
                    if (nextName2.equals("token")) {
                        a5.c(jsonReader.nextString());
                    } else if (nextName2.equals("expiresIn")) {
                        a5.d(m(jsonReader.nextString()));
                    } else {
                        jsonReader.skipValue();
                    }
                }
                a6.b(a5.a());
                jsonReader.endObject();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        inputStream.close();
        return a6.e(d.b.OK).a();
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0050 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String o(java.net.HttpURLConnection r7) {
        /*
            java.io.InputStream r0 = r7.getErrorStream()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.io.BufferedReader r2 = new java.io.BufferedReader
            java.io.InputStreamReader r3 = new java.io.InputStreamReader
            java.nio.charset.Charset r4 = f4400e
            r3.<init>(r0, r4)
            r2.<init>(r3)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0050, all -> 0x0028 }
            r0.<init>()     // Catch:{ IOException -> 0x0050, all -> 0x0028 }
        L_0x0019:
            java.lang.String r3 = r2.readLine()     // Catch:{ IOException -> 0x0050, all -> 0x0028 }
            if (r3 == 0) goto L_0x002a
            r0.append(r3)     // Catch:{ IOException -> 0x0050, all -> 0x0028 }
            r3 = 10
            r0.append(r3)     // Catch:{ IOException -> 0x0050, all -> 0x0028 }
            goto L_0x0019
        L_0x0028:
            r7 = move-exception
            goto L_0x004c
        L_0x002a:
            java.lang.String r3 = "Error when communicating with the Firebase Installations server API. HTTP response: [%d %s: %s]"
            int r4 = r7.getResponseCode()     // Catch:{ IOException -> 0x0050, all -> 0x0028 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ IOException -> 0x0050, all -> 0x0028 }
            java.lang.String r7 = r7.getResponseMessage()     // Catch:{ IOException -> 0x0050, all -> 0x0028 }
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x0050, all -> 0x0028 }
            r6 = 0
            r5[r6] = r4     // Catch:{ IOException -> 0x0050, all -> 0x0028 }
            r4 = 1
            r5[r4] = r7     // Catch:{ IOException -> 0x0050, all -> 0x0028 }
            r7 = 2
            r5[r7] = r0     // Catch:{ IOException -> 0x0050, all -> 0x0028 }
            java.lang.String r7 = java.lang.String.format(r3, r5)     // Catch:{ IOException -> 0x0050, all -> 0x0028 }
            r2.close()     // Catch:{ IOException -> 0x004b }
        L_0x004b:
            return r7
        L_0x004c:
            r2.close()     // Catch:{ IOException -> 0x004f }
        L_0x004f:
            throw r7
        L_0x0050:
            r2.close()     // Catch:{ IOException -> 0x0053 }
        L_0x0053:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: U0.c.o(java.net.HttpURLConnection):java.lang.String");
    }

    private f p(HttpURLConnection httpURLConnection) {
        InputStream inputStream = httpURLConnection.getInputStream();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, f4400e));
        f.a a5 = f.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("token")) {
                a5.c(jsonReader.nextString());
            } else if (nextName.equals("expiresIn")) {
                a5.d(m(jsonReader.nextString()));
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        inputStream.close();
        return a5.b(f.b.OK).a();
    }

    private void q(HttpURLConnection httpURLConnection, String str, String str2) {
        s(httpURLConnection, h(b(str, str2)));
    }

    private void r(HttpURLConnection httpURLConnection) {
        s(httpURLConnection, h(c()));
    }

    private static void s(URLConnection uRLConnection, byte[] bArr) {
        OutputStream outputStream = uRLConnection.getOutputStream();
        if (outputStream != null) {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
            try {
                gZIPOutputStream.write(bArr);
            } finally {
                try {
                    gZIPOutputStream.close();
                    outputStream.close();
                } catch (IOException unused) {
                }
            }
        } else {
            throw new IOException("Cannot send request to FIS servers. No OutputStream available.");
        }
    }

    public d d(String str, String str2, String str3, String str4, String str5) {
        d n5;
        if (this.f4403c.b()) {
            int i5 = 0;
            URL g5 = g(String.format("projects/%s/installations", new Object[]{str3}));
            while (i5 <= 1) {
                TrafficStats.setThreadStatsTag(32769);
                HttpURLConnection l5 = l(g5, str);
                try {
                    l5.setRequestMethod(ShareTarget.METHOD_POST);
                    l5.setDoOutput(true);
                    if (str5 != null) {
                        l5.addRequestProperty("x-goog-fis-android-iid-migration-auth", str5);
                    }
                    q(l5, str2, str4);
                    int responseCode = l5.getResponseCode();
                    this.f4403c.f(responseCode);
                    if (i(responseCode)) {
                        n5 = n(l5);
                    } else {
                        k(l5, str4, str, str3);
                        if (responseCode != 429) {
                            if (responseCode < 500 || responseCode >= 600) {
                                j();
                                n5 = d.a().e(d.b.BAD_CONFIG).a();
                            }
                            l5.disconnect();
                            TrafficStats.clearThreadStatsTag();
                            i5++;
                        } else {
                            throw new com.google.firebase.installations.d("Firebase servers have received too many requests from this client in a short period of time. Please try again later.", d.a.TOO_MANY_REQUESTS);
                        }
                    }
                    l5.disconnect();
                    TrafficStats.clearThreadStatsTag();
                    return n5;
                } catch (IOException | AssertionError unused) {
                } catch (Throwable th) {
                    l5.disconnect();
                    TrafficStats.clearThreadStatsTag();
                    throw th;
                }
            }
            throw new com.google.firebase.installations.d("Firebase Installations Service is unavailable. Please try again later.", d.a.UNAVAILABLE);
        }
        throw new com.google.firebase.installations.d("Firebase Installations Service is unavailable. Please try again later.", d.a.UNAVAILABLE);
    }

    public f e(String str, String str2, String str3, String str4) {
        f p5;
        if (this.f4403c.b()) {
            int i5 = 0;
            URL g5 = g(String.format("projects/%s/installations/%s/authTokens:generate", new Object[]{str3, str2}));
            while (i5 <= 1) {
                TrafficStats.setThreadStatsTag(32771);
                HttpURLConnection l5 = l(g5, str);
                try {
                    l5.setRequestMethod(ShareTarget.METHOD_POST);
                    l5.addRequestProperty("Authorization", "FIS_v2 " + str4);
                    l5.setDoOutput(true);
                    r(l5);
                    int responseCode = l5.getResponseCode();
                    this.f4403c.f(responseCode);
                    if (i(responseCode)) {
                        p5 = p(l5);
                    } else {
                        k(l5, (String) null, str, str3);
                        if (responseCode == 401 || responseCode == 404) {
                            p5 = f.a().b(f.b.AUTH_ERROR).a();
                        } else if (responseCode != 429) {
                            if (responseCode < 500 || responseCode >= 600) {
                                j();
                                p5 = f.a().b(f.b.BAD_CONFIG).a();
                            }
                            l5.disconnect();
                            TrafficStats.clearThreadStatsTag();
                            i5++;
                        } else {
                            throw new com.google.firebase.installations.d("Firebase servers have received too many requests from this client in a short period of time. Please try again later.", d.a.TOO_MANY_REQUESTS);
                        }
                    }
                    l5.disconnect();
                    TrafficStats.clearThreadStatsTag();
                    return p5;
                } catch (IOException | AssertionError unused) {
                } catch (Throwable th) {
                    l5.disconnect();
                    TrafficStats.clearThreadStatsTag();
                    throw th;
                }
            }
            throw new com.google.firebase.installations.d("Firebase Installations Service is unavailable. Please try again later.", d.a.UNAVAILABLE);
        }
        throw new com.google.firebase.installations.d("Firebase Installations Service is unavailable. Please try again later.", d.a.UNAVAILABLE);
    }
}
