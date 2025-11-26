package com.google.android.datatransport.cct;

import B.C0628a;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.browser.trusted.sharing.ShareTarget;
import com.mbridge.msdk.foundation.download.Command;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import p.C1745c;
import q.C1755a;
import q.n;
import q.o;
import q.p;
import q.q;
import q.r;
import q.s;
import q.t;
import q.u;
import q.v;
import q.w;
import q.x;
import r.h;
import r.i;
import s.f;
import s.g;
import s.m;
import v.C1892a;
import w.C1896b;

final class d implements m {

    /* renamed from: a  reason: collision with root package name */
    private final K0.a f4775a;

    /* renamed from: b  reason: collision with root package name */
    private final ConnectivityManager f4776b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f4777c;

    /* renamed from: d  reason: collision with root package name */
    final URL f4778d;

    /* renamed from: e  reason: collision with root package name */
    private final C0628a f4779e;

    /* renamed from: f  reason: collision with root package name */
    private final C0628a f4780f;

    /* renamed from: g  reason: collision with root package name */
    private final int f4781g;

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        final URL f4782a;

        /* renamed from: b  reason: collision with root package name */
        final n f4783b;

        /* renamed from: c  reason: collision with root package name */
        final String f4784c;

        a(URL url, n nVar, String str) {
            this.f4782a = url;
            this.f4783b = nVar;
            this.f4784c = str;
        }

        /* access modifiers changed from: package-private */
        public a a(URL url) {
            return new a(url, this.f4783b, this.f4784c);
        }
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        final int f4785a;

        /* renamed from: b  reason: collision with root package name */
        final URL f4786b;

        /* renamed from: c  reason: collision with root package name */
        final long f4787c;

        b(int i5, URL url, long j5) {
            this.f4785a = i5;
            this.f4786b = url;
            this.f4787c = j5;
        }
    }

    d(Context context, C0628a aVar, C0628a aVar2, int i5) {
        this.f4775a = n.b();
        this.f4777c = context;
        this.f4776b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f4778d = n(a.f4766c);
        this.f4779e = aVar2;
        this.f4780f = aVar;
        this.f4781g = i5;
    }

    public static /* synthetic */ a d(a aVar, b bVar) {
        URL url = bVar.f4786b;
        if (url == null) {
            return null;
        }
        C1892a.b("CctTransportBackend", "Following redirect to: %s", url);
        return aVar.a(bVar.f4786b);
    }

    /* access modifiers changed from: private */
    public b e(a aVar) {
        OutputStream outputStream;
        GZIPOutputStream gZIPOutputStream;
        InputStream m5;
        C1892a.f("CctTransportBackend", "Making request to: %s", aVar.f4782a);
        HttpURLConnection httpURLConnection = (HttpURLConnection) aVar.f4782a.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(this.f4781g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod(ShareTarget.METHOD_POST);
        httpURLConnection.setRequestProperty(Command.HTTP_HEADER_USER_AGENT, String.format("datatransport/%s android/", new Object[]{"3.3.0"}));
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = aVar.f4784c;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            outputStream = httpURLConnection.getOutputStream();
            gZIPOutputStream = new GZIPOutputStream(outputStream);
            this.f4775a.a(aVar.f4783b, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
            gZIPOutputStream.close();
            if (outputStream != null) {
                outputStream.close();
            }
            int responseCode = httpURLConnection.getResponseCode();
            C1892a.f("CctTransportBackend", "Status Code: %d", Integer.valueOf(responseCode));
            C1892a.b("CctTransportBackend", "Content-Type: %s", httpURLConnection.getHeaderField("Content-Type"));
            C1892a.b("CctTransportBackend", "Content-Encoding: %s", httpURLConnection.getHeaderField("Content-Encoding"));
            if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                return new b(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0);
            }
            if (responseCode != 200) {
                return new b(responseCode, (URL) null, 0);
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            try {
                m5 = m(inputStream, httpURLConnection.getHeaderField("Content-Encoding"));
                b bVar = new b(responseCode, (URL) null, v.b(new BufferedReader(new InputStreamReader(m5))).c());
                if (m5 != null) {
                    m5.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                return bVar;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
            throw th;
            throw th;
            throw th;
            throw th;
        } catch (ConnectException | UnknownHostException e5) {
            C1892a.d("CctTransportBackend", "Couldn't open connection, returning with 500", e5);
            return new b(500, (URL) null, 0);
        } catch (K0.b | IOException e6) {
            C1892a.d("CctTransportBackend", "Couldn't encode request, returning with 400", e6);
            return new b(400, (URL) null, 0);
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
    }

    private static String f(Context context) {
        String simOperator = k(context).getSimOperator();
        if (simOperator != null) {
            return simOperator;
        }
        return "";
    }

    private static int g(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return w.b.UNKNOWN_MOBILE_SUBTYPE.b();
        }
        int subtype = networkInfo.getSubtype();
        if (subtype == -1) {
            return w.b.COMBINED.b();
        }
        if (w.b.a(subtype) != null) {
            return subtype;
        }
        return 0;
    }

    private static int h(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return w.c.NONE.b();
        }
        return networkInfo.getType();
    }

    private static int i(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e5) {
            C1892a.d("CctTransportBackend", "Unable to find version code for package", e5);
            return -1;
        }
    }

    private n j(f fVar) {
        t.a aVar;
        HashMap hashMap = new HashMap();
        for (i iVar : fVar.b()) {
            String n5 = iVar.n();
            if (!hashMap.containsKey(n5)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(iVar);
                hashMap.put(n5, arrayList);
            } else {
                ((List) hashMap.get(n5)).add(iVar);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            i iVar2 = (i) ((List) entry.getValue()).get(0);
            u.a b5 = u.a().f(x.DEFAULT).g(this.f4780f.a()).h(this.f4779e.a()).b(o.a().c(o.b.ANDROID_FIREBASE).b(C1755a.a().m(Integer.valueOf(iVar2.i("sdk-version"))).j(iVar2.b("model")).f(iVar2.b("hardware")).d(iVar2.b("device")).l(iVar2.b("product")).k(iVar2.b("os-uild")).h(iVar2.b("manufacturer")).e(iVar2.b("fingerprint")).c(iVar2.b("country")).g(iVar2.b("locale")).i(iVar2.b("mcc_mnc")).b(iVar2.b("application_build")).a()).a());
            try {
                b5.i(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                b5.j((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (i iVar3 : (List) entry.getValue()) {
                h e5 = iVar3.e();
                C1745c b6 = e5.b();
                if (b6.equals(C1745c.b("proto"))) {
                    aVar = t.l(e5.a());
                } else if (b6.equals(C1745c.b("json"))) {
                    aVar = t.k(new String(e5.a(), Charset.forName(C.UTF8_NAME)));
                } else {
                    C1892a.g("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", b6);
                }
                aVar.d(iVar3.f()).e(iVar3.o()).j(iVar3.j("tz-offset")).g(w.a().c(w.c.a(iVar3.i("net-type"))).b(w.b.a(iVar3.i("mobile-subtype"))).a());
                if (iVar3.d() != null) {
                    aVar.c(iVar3.d());
                }
                if (iVar3.l() != null) {
                    aVar.b(p.a().b(s.a().b(r.a().b(iVar3.l()).a()).a()).c(p.b.EVENT_OVERRIDE).a());
                }
                if (!(iVar3.g() == null && iVar3.h() == null)) {
                    q.a a5 = q.a();
                    if (iVar3.g() != null) {
                        a5.b(iVar3.g());
                    }
                    if (iVar3.h() != null) {
                        a5.c(iVar3.h());
                    }
                    aVar.f(a5.a());
                }
                arrayList3.add(aVar.a());
            }
            b5.c(arrayList3);
            arrayList2.add(b5.a());
        }
        return n.a(arrayList2);
    }

    private static TelephonyManager k(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    static long l() {
        Calendar.getInstance();
        return (long) (TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000);
    }

    private static InputStream m(InputStream inputStream, String str) {
        if ("gzip".equals(str)) {
            return new GZIPInputStream(inputStream);
        }
        return inputStream;
    }

    private static URL n(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e5) {
            throw new IllegalArgumentException("Invalid url: " + str, e5);
        }
    }

    public g a(f fVar) {
        n j5 = j(fVar);
        URL url = this.f4778d;
        String str = null;
        if (fVar.c() != null) {
            try {
                a c5 = a.c(fVar.c());
                if (c5.d() != null) {
                    str = c5.d();
                }
                if (c5.e() != null) {
                    url = n(c5.e());
                }
            } catch (IllegalArgumentException unused) {
                return g.a();
            }
        }
        try {
            b bVar = (b) C1896b.a(5, new a(url, j5, str), new b(this), new c());
            int i5 = bVar.f4785a;
            if (i5 == 200) {
                return g.e(bVar.f4787c);
            }
            if (i5 < 500) {
                if (i5 != 404) {
                    if (i5 == 400) {
                        return g.d();
                    }
                    return g.a();
                }
            }
            return g.f();
        } catch (IOException e5) {
            C1892a.d("CctTransportBackend", "Could not make request to the backend", e5);
            return g.f();
        }
    }

    public i b(i iVar) {
        NetworkInfo activeNetworkInfo = this.f4776b.getActiveNetworkInfo();
        return iVar.p().a("sdk-version", Build.VERSION.SDK_INT).c("model", Build.MODEL).c("hardware", Build.HARDWARE).c("device", Build.DEVICE).c("product", Build.PRODUCT).c("os-uild", Build.ID).c("manufacturer", Build.MANUFACTURER).c("fingerprint", Build.FINGERPRINT).b("tz-offset", l()).a("net-type", h(activeNetworkInfo)).a("mobile-subtype", g(activeNetworkInfo)).c("country", Locale.getDefault().getCountry()).c("locale", Locale.getDefault().getLanguage()).c("mcc_mnc", f(this.f4777c)).c("application_build", Integer.toString(i(this.f4777c))).d();
    }

    d(Context context, C0628a aVar, C0628a aVar2) {
        this(context, aVar, aVar2, 130000);
    }
}
