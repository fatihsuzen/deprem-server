package r2;

import android.content.Context;
import android.provider.Settings;
import android.util.Base64;
import androidx.browser.trusted.sharing.ShareTarget;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import p2.C2712a;
import p2.b;
import q2.C2714a;
import q2.C2717d;
import t3.C2780d;
import t3.s;

/* renamed from: r2.a  reason: case insensitive filesystem */
public final class C2730a {

    /* renamed from: b  reason: collision with root package name */
    public static final C0260a f25713b = new C0260a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    public final Context f25714a;

    /* renamed from: r2.a$a  reason: collision with other inner class name */
    public static final class C0260a {
        public C0260a(C2633k kVar) {
        }
    }

    public C2730a(Context context) {
        t.e(context, "context");
        this.f25714a = context;
    }

    public static String a(HashMap hashMap) {
        StringBuilder sb = new StringBuilder();
        boolean z4 = true;
        for (Map.Entry entry : hashMap.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if (z4) {
                z4 = false;
            } else {
                sb.append("&");
            }
            sb.append(URLEncoder.encode(str, C.UTF8_NAME));
            sb.append("=");
            sb.append(URLEncoder.encode(str2, C.UTF8_NAME));
        }
        String sb2 = sb.toString();
        t.d(sb2, "result.toString()");
        return sb2;
    }

    public final C2717d b(String str) {
        BufferedReader bufferedReader;
        OutputStream outputStream;
        t.e(str, "token");
        HashMap hashMap = new HashMap();
        String jSONObject = new C2712a(this.f25714a, str).a(this.f25714a).toString();
        t.d(jSONObject, "jsonObjectContext.toString()");
        hashMap.put("context", jSONObject);
        String jSONObject2 = new b(this.f25714a).a().toString();
        t.d(jSONObject2, "jsonObjectFile.toString()");
        hashMap.put("file", jSONObject2);
        StringBuilder sb = new StringBuilder();
        C2714a aVar = C2714a.f25682a;
        sb.append(aVar.b());
        sb.append("/eapi/sdk-installation/" + Settings.Secure.getString(this.f25714a.getContentResolver(), "android_id"));
        String sb2 = sb.toString();
        C2717d dVar = new C2717d();
        try {
            if (s.E(ShareTarget.METHOD_POST, ShareTarget.METHOD_GET, true)) {
                sb2 = sb2 + '?' + a(hashMap);
            }
            URLConnection openConnection = new URL(sb2).openConnection();
            t.c(openConnection, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
            httpsURLConnection.setReadTimeout(DefaultLoadControl.DEFAULT_MIN_BUFFER_MS);
            httpsURLConnection.setConnectTimeout(DefaultLoadControl.DEFAULT_MIN_BUFFER_MS);
            httpsURLConnection.setRequestMethod(ShareTarget.METHOD_POST);
            httpsURLConnection.setDoInput(true);
            if (s.E(ShareTarget.METHOD_POST, ShareTarget.METHOD_POST, true)) {
                httpsURLConnection.setDoOutput(true);
            }
            if (s.V("https://secure.uptodown.com", "www.xxxyyyxxx.com", false, 2, (Object) null)) {
                Charset charset = C2780d.f25888b;
                byte[] bytes = "".getBytes(charset);
                t.d(bytes, "getBytes(...)");
                byte[] encode = Base64.encode(bytes, 0);
                t.d(encode, "encode(devValue.toByteArray(), Base64.DEFAULT)");
                httpsURLConnection.setRequestProperty("", new String(encode, charset));
            }
            httpsURLConnection.setRequestProperty("Identificador", "Uptodown_Android");
            httpsURLConnection.setRequestProperty("Identificador-Version", "999");
            httpsURLConnection.setRequestProperty("APIKEY", aVar.a());
            if (s.E(ShareTarget.METHOD_POST, ShareTarget.METHOD_POST, true) && (outputStream = httpsURLConnection.getOutputStream()) != null) {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, C.UTF8_NAME));
                bufferedWriter.write(a(hashMap));
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
            }
            int responseCode = httpsURLConnection.getResponseCode();
            dVar.e(responseCode);
            if (responseCode == 200) {
                bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
            } else {
                bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getErrorStream()));
                dVar.c(true);
            }
            StringBuilder sb3 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb3.append(readLine);
                } else {
                    dVar.d(sb3.toString());
                    return dVar;
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
            dVar.c(true);
            dVar.d(e5.getMessage());
            return dVar;
        }
    }
}
