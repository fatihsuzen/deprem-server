package z2;

import A2.b;
import P1.c;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import b2.C2286f;
import b2.C2301u;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2655d;
import l2.C2657f;
import l2.C2667p;
import l2.C2670t;
import l2.C2673w;
import l2.C2676z;
import l2.M;
import l2.O;
import l2.Q;
import l2.V;
import m2.C2684d;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import t3.C2780d;
import t3.p;
import t3.s;

public final class Z {

    /* renamed from: b  reason: collision with root package name */
    public static final a f26527b = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f26528a;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final byte[] a(String str) {
            t.e(str, TypedValues.Custom.S_STRING);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            byte[] bytes = str.getBytes(C2780d.f25888b);
            t.d(bytes, "getBytes(...)");
            gZIPOutputStream.write(bytes);
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            t.b(byteArray);
            return byteArray;
        }

        /* JADX WARNING: Removed duplicated region for block: B:62:0x00db A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String b(java.lang.String r7) {
            /*
                r6 = this;
                java.lang.String r0 = "en"
                if (r7 != 0) goto L_0x0005
                return r0
            L_0x0005:
                int r1 = r7.hashCode()
                java.lang.String r2 = "in"
                java.lang.String r3 = "id"
                java.lang.String r4 = "kr"
                java.lang.String r5 = "cn"
                switch(r1) {
                    case 3121: goto L_0x00d3;
                    case 3179: goto L_0x00cb;
                    case 3201: goto L_0x00c1;
                    case 3241: goto L_0x00bd;
                    case 3246: goto L_0x00b3;
                    case 3276: goto L_0x00a9;
                    case 3329: goto L_0x009f;
                    case 3355: goto L_0x0097;
                    case 3365: goto L_0x008f;
                    case 3371: goto L_0x0085;
                    case 3383: goto L_0x0079;
                    case 3428: goto L_0x006e;
                    case 3431: goto L_0x0065;
                    case 3588: goto L_0x0058;
                    case 3645: goto L_0x004d;
                    case 3651: goto L_0x0042;
                    case 3700: goto L_0x0037;
                    case 3710: goto L_0x002c;
                    case 3763: goto L_0x0021;
                    case 3886: goto L_0x0016;
                    default: goto L_0x0014;
                }
            L_0x0014:
                goto L_0x00db
            L_0x0016:
                java.lang.String r1 = "zh"
                boolean r7 = r7.equals(r1)
                if (r7 != 0) goto L_0x0020
                goto L_0x00db
            L_0x0020:
                return r5
            L_0x0021:
                java.lang.String r1 = "vi"
                boolean r7 = r7.equals(r1)
                if (r7 != 0) goto L_0x002b
                goto L_0x00db
            L_0x002b:
                return r1
            L_0x002c:
                java.lang.String r1 = "tr"
                boolean r7 = r7.equals(r1)
                if (r7 != 0) goto L_0x0036
                goto L_0x00db
            L_0x0036:
                return r1
            L_0x0037:
                java.lang.String r1 = "th"
                boolean r7 = r7.equals(r1)
                if (r7 != 0) goto L_0x0041
                goto L_0x00db
            L_0x0041:
                return r1
            L_0x0042:
                java.lang.String r1 = "ru"
                boolean r7 = r7.equals(r1)
                if (r7 != 0) goto L_0x004c
                goto L_0x00db
            L_0x004c:
                return r1
            L_0x004d:
                java.lang.String r1 = "ro"
                boolean r7 = r7.equals(r1)
                if (r7 != 0) goto L_0x0057
                goto L_0x00db
            L_0x0057:
                return r1
            L_0x0058:
                java.lang.String r1 = "pt"
                boolean r7 = r7.equals(r1)
                if (r7 != 0) goto L_0x0062
                goto L_0x00db
            L_0x0062:
                java.lang.String r7 = "br"
                return r7
            L_0x0065:
                boolean r7 = r7.equals(r4)
                if (r7 != 0) goto L_0x006d
                goto L_0x00db
            L_0x006d:
                return r4
            L_0x006e:
                java.lang.String r1 = "ko"
                boolean r7 = r7.equals(r1)
                if (r7 != 0) goto L_0x0078
                goto L_0x00db
            L_0x0078:
                return r4
            L_0x0079:
                java.lang.String r1 = "ja"
                boolean r7 = r7.equals(r1)
                if (r7 != 0) goto L_0x0082
                goto L_0x00db
            L_0x0082:
                java.lang.String r7 = "jp"
                return r7
            L_0x0085:
                java.lang.String r1 = "it"
                boolean r7 = r7.equals(r1)
                if (r7 != 0) goto L_0x008e
                goto L_0x00db
            L_0x008e:
                return r1
            L_0x008f:
                boolean r7 = r7.equals(r2)
                if (r7 != 0) goto L_0x0096
                goto L_0x00db
            L_0x0096:
                return r3
            L_0x0097:
                boolean r7 = r7.equals(r3)
                if (r7 != 0) goto L_0x009e
                goto L_0x00db
            L_0x009e:
                return r3
            L_0x009f:
                java.lang.String r1 = "hi"
                boolean r7 = r7.equals(r1)
                if (r7 != 0) goto L_0x00a8
                goto L_0x00db
            L_0x00a8:
                return r2
            L_0x00a9:
                java.lang.String r1 = "fr"
                boolean r7 = r7.equals(r1)
                if (r7 != 0) goto L_0x00b2
                goto L_0x00db
            L_0x00b2:
                return r1
            L_0x00b3:
                java.lang.String r1 = "es"
                boolean r7 = r7.equals(r1)
                if (r7 != 0) goto L_0x00bc
                goto L_0x00db
            L_0x00bc:
                return r1
            L_0x00bd:
                r7.equals(r0)
                goto L_0x00db
            L_0x00c1:
                java.lang.String r1 = "de"
                boolean r7 = r7.equals(r1)
                if (r7 != 0) goto L_0x00ca
                goto L_0x00db
            L_0x00ca:
                return r1
            L_0x00cb:
                boolean r7 = r7.equals(r5)
                if (r7 != 0) goto L_0x00d2
                goto L_0x00db
            L_0x00d2:
                return r5
            L_0x00d3:
                java.lang.String r1 = "ar"
                boolean r7 = r7.equals(r1)
                if (r7 != 0) goto L_0x00dc
            L_0x00db:
                return r0
            L_0x00dc:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: z2.Z.a.b(java.lang.String):java.lang.String");
        }

        public final String c(Context context) {
            t.e(context, "context");
            return s.L("https://www.uptodown.com/turbo?platform=android", "www", b(com.uptodown.activities.preferences.a.f15150a.n(context)), false, 4, (Object) null);
        }

        private a() {
        }
    }

    public Z(Context context) {
        t.e(context, "context");
        this.f26528a = context;
    }

    private final JSONObject G(M m5, String str) {
        String d5 = m5.d();
        if (!(d5 == null || d5.length() == 0)) {
            try {
                String d6 = m5.d();
                t.b(d6);
                return new JSONObject(d6);
            } catch (JSONException unused) {
                Bundle bundle = new Bundle();
                bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "jsonException");
                bundle.putString("url", str);
                new F(this.f26528a).d("apiRead", bundle);
            }
        }
        return null;
    }

    private final M H(String str, HashMap hashMap, String str2) {
        BufferedReader bufferedReader;
        OutputStream outputStream;
        M m5 = new M();
        if (hashMap == null) {
            try {
                hashMap = new HashMap();
            } catch (SocketTimeoutException unused) {
                m5.h("SocketTimeoutException");
            } catch (IllegalStateException unused2) {
                m5.h("IllegalStateException");
            } catch (IllegalArgumentException unused3) {
                m5.h("IllegalArgumentException");
            } catch (SecurityException unused4) {
                m5.h("SecurityException");
            } catch (NullPointerException unused5) {
                m5.h("NullPointerException");
            } catch (MalformedURLException unused6) {
                m5.h("MalformedURLException");
            } catch (ProtocolException unused7) {
                m5.h("ProtocolException");
            } catch (SSLHandshakeException unused8) {
                m5.h("SSLHandshakeException");
            } catch (IOException unused9) {
                m5.h("IOException");
            } catch (Exception unused10) {
                m5.h("Exception");
            } catch (Throwable th) {
                c.f3900a.a(str, hashMap, m5);
                throw th;
            }
        }
        if (!hashMap.containsKey("lang")) {
            hashMap.put("lang", f26527b.b(com.uptodown.activities.preferences.a.f15150a.n(this.f26528a)));
        }
        if (!hashMap.containsKey("id_plataforma")) {
            hashMap.put("id_plataforma", "13");
        }
        C2667p pVar = new C2667p();
        pVar.j(this.f26528a);
        if (!hashMap.containsKey("identifier") && pVar.d() != null) {
            String d5 = pVar.d();
            t.b(d5);
            hashMap.put("identifier", d5);
        }
        if (s.E(str2, ShareTarget.METHOD_GET, true)) {
            str = str + '?' + R(hashMap);
        } else if (s.E(str2, ShareTarget.METHOD_POST, true) && pVar.d() != null) {
            HashMap hashMap2 = new HashMap();
            String d6 = pVar.d();
            t.b(d6);
            hashMap2.put("identifier", d6);
            str = str + '?' + R(hashMap2);
        }
        new N().a(this.f26528a);
        URLConnection openConnection = new URL(str).openConnection();
        t.c(openConnection, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
        httpsURLConnection.setReadTimeout(30000);
        httpsURLConnection.setConnectTimeout(30000);
        httpsURLConnection.setRequestMethod(str2);
        httpsURLConnection.setDoInput(true);
        if (s.E(str2, ShareTarget.METHOD_POST, true)) {
            httpsURLConnection.setDoOutput(true);
        }
        C2941C.f26481a.a(httpsURLConnection);
        String L4 = com.uptodown.activities.preferences.a.f15150a.L(this.f26528a);
        String string = this.f26528a.getSharedPreferences("SharedPreferencesUser", 0).getString("is_turbo", "");
        httpsURLConnection.setRequestProperty("Identificador", "Uptodown_Android");
        httpsURLConnection.setRequestProperty("Identificador-Version", "694");
        if (L4 != null) {
            if (L4.length() != 0) {
                httpsURLConnection.setRequestProperty("UTOKEN", L4);
            }
        }
        if (string != null) {
            if (string.length() != 0) {
                httpsURLConnection.setRequestProperty("TURBOTOKEN", string);
            }
        }
        httpsURLConnection.setRequestProperty("APIKEY", P.f26510a.d());
        if (s.E(str2, ShareTarget.METHOD_POST, true) && (outputStream = httpsURLConnection.getOutputStream()) != null) {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, C.UTF8_NAME));
            bufferedWriter.write(R(hashMap));
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
        }
        int responseCode = httpsURLConnection.getResponseCode();
        m5.k(responseCode);
        if (responseCode < 200 || responseCode >= 300) {
            bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getErrorStream()));
        } else {
            bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb.append(readLine);
            } else {
                m5.i(sb.toString());
                m5.a(this.f26528a);
                c.f3900a.a(str, hashMap, m5);
                return m5;
            }
        }
        c.f3900a.a(str, hashMap, m5);
        return m5;
    }

    private final M I(String str, HashMap hashMap) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : hashMap.entrySet()) {
            jSONObject.put((String) entry.getKey(), entry.getValue());
        }
        C2667p pVar = new C2667p();
        pVar.j(this.f26528a);
        if (pVar.d() != null) {
            HashMap hashMap2 = new HashMap();
            String d5 = pVar.d();
            t.b(d5);
            hashMap2.put("identifier", d5);
            str = str + '?' + R(hashMap2);
        }
        M a5 = new b().a(jSONObject, (C2684d) null, this.f26528a, str);
        a5.a(this.f26528a);
        c.f3900a.a(str, hashMap, a5);
        return a5;
    }

    private final String R(HashMap hashMap) {
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
        t.d(sb2, "toString(...)");
        return sb2;
    }

    private final JSONArray S0(ArrayList arrayList) {
        Z z4 = this;
        ArrayList arrayList2 = arrayList;
        JSONArray jSONArray = new JSONArray();
        PackageManager packageManager = z4.f26528a.getPackageManager();
        int size = arrayList2.size();
        int i5 = 0;
        while (i5 < size) {
            C2954m mVar = new C2954m();
            t.b(packageManager);
            String o5 = ((C2655d) arrayList2.get(i5)).o();
            t.b(o5);
            Iterator it = mVar.j(packageManager, o5).iterator();
            t.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                t.d(next, "next(...)");
                String str = (String) next;
                JSONObject jSONObject = new JSONObject();
                if (((C2655d) arrayList2.get(i5)).c() != null) {
                    jSONObject.put(RewardPlus.NAME, ((C2655d) arrayList2.get(i5)).c());
                } else if (((C2655d) arrayList2.get(i5)).m() != null) {
                    jSONObject.put(RewardPlus.NAME, ((C2655d) arrayList2.get(i5)).m());
                } else if (((C2655d) arrayList2.get(i5)).o() != null) {
                    jSONObject.put(RewardPlus.NAME, ((C2655d) arrayList2.get(i5)).o());
                }
                jSONObject.put("packagename", ((C2655d) arrayList2.get(i5)).o());
                if (((C2655d) arrayList2.get(i5)).o() != null) {
                    C2954m mVar2 = new C2954m();
                    Context context = z4.f26528a;
                    String o6 = ((C2655d) arrayList2.get(i5)).o();
                    t.b(o6);
                    String h5 = mVar2.h(context, o6);
                    if (new C2954m().z(h5)) {
                        jSONObject.put("installerPackagename", h5);
                    }
                }
                jSONObject.put("versionCode", ((C2655d) arrayList2.get(i5)).A());
                jSONObject.put("versionName", ((C2655d) arrayList2.get(i5)).B());
                jSONObject.put("isSystemApp", ((C2655d) arrayList2.get(i5)).E());
                jSONObject.put("sha256Base", ((C2655d) arrayList2.get(i5)).r());
                jSONObject.put("md5Signature", str);
                jSONObject.put("minSDKVersion", ((C2655d) arrayList2.get(i5)).l());
                if (((C2655d) arrayList2.get(i5)).x() > 0) {
                    jSONObject.put("targetSDKVersion", ((C2655d) arrayList2.get(i5)).x());
                }
                if (((C2655d) arrayList2.get(i5)).n() != null) {
                    ArrayList n5 = ((C2655d) arrayList2.get(i5)).n();
                    t.b(n5);
                    if (!n5.isEmpty()) {
                        JSONArray jSONArray2 = new JSONArray();
                        ArrayList n6 = ((C2655d) arrayList2.get(i5)).n();
                        t.b(n6);
                        Iterator it2 = n6.iterator();
                        t.d(it2, "iterator(...)");
                        while (it2.hasNext()) {
                            Object next2 = it2.next();
                            t.d(next2, "next(...)");
                            C2673w wVar = (C2673w) next2;
                            if (wVar.c() != null) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put(RewardPlus.NAME, wVar.b());
                                jSONObject2.put("sha256", wVar.c());
                                jSONArray2.put(jSONObject2);
                            }
                        }
                        if (jSONArray2.length() > 0) {
                            jSONObject.put("obbs", jSONArray2);
                        }
                    }
                }
                if (((C2655d) arrayList2.get(i5)).v() != null) {
                    ArrayList v5 = ((C2655d) arrayList2.get(i5)).v();
                    t.b(v5);
                    if (!v5.isEmpty()) {
                        JSONArray jSONArray3 = new JSONArray();
                        ArrayList v6 = ((C2655d) arrayList2.get(i5)).v();
                        t.b(v6);
                        Iterator it3 = v6.iterator();
                        t.d(it3, "iterator(...)");
                        while (it3.hasNext()) {
                            Object next3 = it3.next();
                            t.d(next3, "next(...)");
                            C2673w wVar2 = (C2673w) next3;
                            if (wVar2.c() != null) {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put(RewardPlus.NAME, wVar2.b());
                                jSONObject3.put("sha256", wVar2.c());
                                jSONArray3.put(jSONObject3);
                            }
                        }
                        if (jSONArray3.length() > 0) {
                            jSONObject.put("splits", jSONArray3);
                        }
                    }
                }
                if (jSONObject.length() > 0) {
                    jSONArray.put(jSONObject);
                }
                z4 = this;
            }
            i5++;
            z4 = this;
        }
        return jSONArray;
    }

    private final String T0(C2667p pVar) {
        String jSONObject = pVar.l().toString(2);
        t.d(jSONObject, "toString(...)");
        return jSONObject;
    }

    private final String U0(C2676z zVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (zVar.c() > 0) {
                jSONObject.put("total_memory", zVar.c());
            }
            if (zVar.a() > 0) {
                jSONObject.put("free_memory", zVar.a());
            }
            if (zVar.d() > 0) {
                jSONObject.put("total_ram_memory", zVar.d());
            }
            if (zVar.a() > 0) {
                jSONObject.put("free_ram_memory", zVar.b());
            }
            return jSONObject.toString(2);
        } catch (JSONException e5) {
            e5.printStackTrace();
            return "";
        }
    }

    private final JSONObject W0(Q q5) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("lang", q5.d());
        if (q5.h()) {
            jSONObject.put("notifications_on", 1);
        } else {
            jSONObject.put("notifications_on", 0);
        }
        jSONObject.put("notifications_frecuency", Integer.parseInt(q5.c()));
        if (q5.i()) {
            jSONObject.put("only_wifi", 1);
        } else {
            jSONObject.put("only_wifi", 0);
        }
        jSONObject.put("download_updates_options", q5.f());
        jSONObject.put("delete_apk", 1);
        if (q5.g()) {
            jSONObject.put("install_apk_root", 1);
        } else {
            jSONObject.put("install_apk_root", 0);
        }
        jSONObject.put("versioncode", q5.e());
        return jSONObject;
    }

    private final HashMap s() {
        HashMap hashMap = new HashMap();
        C2667p pVar = new C2667p();
        pVar.k(this.f26528a);
        String c5 = pVar.c();
        if (!(c5 == null || c5.length() == 0)) {
            hashMap.put("countryIsoCode", c5);
        }
        return hashMap;
    }

    public final M A(int i5) {
        String str = "/eapi/floating-category-related/" + i5;
        M H4 = H(C2963w.f26560a.a() + str, (HashMap) null, ShareTarget.METHOD_GET);
        H4.j(F(H4, str));
        return H4;
    }

    public final M A0() {
        M H4 = H(C2963w.f26560a.a() + "/eapi/user-data/devices", (HashMap) null, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/user-data/devices"));
        return H4;
    }

    public final M B(int i5, int i6, String str) {
        t.e(str, "userID");
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i5));
        hashMap.put("page[offset]", String.valueOf(i6));
        M H4 = H(C2963w.f26560a.a() + "/eapi/user/" + str + "/followers", hashMap, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/user/userID/followers"));
        return H4;
    }

    public final M B0() {
        M H4 = H(C2963w.f26560a.a() + "/eapi/user/username-formats", (HashMap) null, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/user/username-formats"));
        return H4;
    }

    public final M C(int i5, int i6, String str) {
        t.e(str, "userID");
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i5));
        hashMap.put("page[offset]", String.valueOf(i6));
        M H4 = H(C2963w.f26560a.a() + "/eapi/user/" + str + "/followings", hashMap, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/user/userID/followings"));
        return H4;
    }

    public final M C0(long j5) {
        M H4 = H(C2963w.f26560a.a() + "/eapi/apps/" + j5 + "/video", (HashMap) null, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/apps/appId/video"));
        return H4;
    }

    public final M D() {
        M H4 = H(C2963w.f26560a.a() + "/eapi/home", (HashMap) null, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/home"));
        return H4;
    }

    public final M D0(String str) {
        t.e(str, "fileId");
        M H4 = H(C2963w.f26560a.a() + "/eapi/v2/virus-total/" + str + "/report", (HashMap) null, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/v2/virus-total/fileId/report"));
        return H4;
    }

    public final M E() {
        M H4 = H(C2963w.f26560a.a() + "/eapi/home/features", (HashMap) null, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/home/features"));
        return H4;
    }

    public final M E0(String str) {
        t.e(str, "sha256");
        M H4 = H(C2963w.f26560a.a() + "/eapi/v2/virus-total-by-sha256/" + str + "/report", (HashMap) null, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/v2/virus-total-by-sha256/sha256/report"));
        return H4;
    }

    public final JSONObject F(M m5, String str) {
        String d5;
        t.e(m5, "responseJson");
        t.e(str, "urlEndpoint");
        if (!(m5.b() || (d5 = m5.d()) == null || d5.length() == 0)) {
            try {
                String d6 = m5.d();
                t.b(d6);
                return new JSONObject(d6);
            } catch (JSONException unused) {
                Bundle bundle = new Bundle();
                bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "jsonException");
                bundle.putString("url", str);
                new F(this.f26528a).d("apiRead", bundle);
            }
        }
        return null;
    }

    public final M F0(int i5, int i6) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i5));
        hashMap.put("page[offset]", String.valueOf(i6));
        M H4 = H(C2963w.f26560a.a() + "/eapi/v2/my-wishlist", hashMap, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/v2/my-wishlist"));
        return H4;
    }

    public final M G0(long j5) {
        M H4 = H(C2963w.f26560a.b() + "/dwn/" + j5 + "/native-external/increase", (HashMap) null, ShareTarget.METHOD_POST);
        H4.j(F(H4, "/dwn/appID/native-external/increase"));
        return H4;
    }

    public final M H0(long j5) {
        M H4 = H(C2963w.f26560a.b() + "/dwn/" + j5 + "/native-external-update/increase", (HashMap) null, ShareTarget.METHOD_POST);
        H4.j(F(H4, "/dwn/appID/native-external-update/increase"));
        return H4;
    }

    public final M I0(int i5) {
        String str = "/eapi/user/categories/isFavorite/" + i5;
        M H4 = H(C2963w.f26560a.a() + str, (HashMap) null, ShareTarget.METHOD_GET);
        H4.j(F(H4, str));
        return H4;
    }

    public final M J(int i5, int i6) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i5));
        hashMap.put("page[offset]", String.valueOf(i6));
        M H4 = H(C2963w.f26560a.a() + "/eapi/apps/latest-updates", hashMap, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/apps/latest-updates"));
        return H4;
    }

    public final M J0() {
        M H4 = H("https://adservice.google.com/getconfig/pubvendors", (HashMap) null, ShareTarget.METHOD_GET);
        H4.j(F(H4, "adservice.google.com/getconfig/pubvendors"));
        return H4;
    }

    public final M K(int i5, int i6) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i5));
        hashMap.put("page[offset]", String.valueOf(i6));
        M H4 = H(C2963w.f26560a.a() + "/eapi/apps/latest-updates-home", hashMap, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/apps/latest-updates-home"));
        return H4;
    }

    public final M K0(long j5) {
        M H4 = H(C2963w.f26560a.a() + "/eapi/answer/" + j5 + "/like", (HashMap) null, ShareTarget.METHOD_POST);
        H4.j(F(H4, "/eapi/answer/idReply/like"));
        return H4;
    }

    public final M L(int i5, int i6) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i5));
        hashMap.put("page[offset]", String.valueOf(i6));
        M H4 = H(C2963w.f26560a.a() + "/eapi/my-recommended-list", hashMap, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/my-recommended-list"));
        return H4;
    }

    public final M L0(long j5) {
        M H4 = H(C2963w.f26560a.a() + "/eapi/comment/" + j5 + "/like", (HashMap) null, ShareTarget.METHOD_POST);
        H4.j(F(H4, "/eapi/comment/idReview/like"));
        return H4;
    }

    public final M M(long j5) {
        M H4 = H(C2963w.f26560a.a() + "/eapi/app/" + j5 + "/my-comment", (HashMap) null, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/app/appID/my-comment"));
        return H4;
    }

    public final M M0(ArrayList arrayList) {
        t.e(arrayList, "events");
        HashMap hashMap = new HashMap();
        JSONArray jSONArray = new JSONArray();
        Iterator it = arrayList.iterator();
        t.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            t.d(next, "next(...)");
            C2670t tVar = (C2670t) next;
            if (tVar.b() != null) {
                String b5 = tVar.b();
                t.b(b5);
                jSONArray.put(new JSONObject(b5));
            }
        }
        hashMap.put("events", jSONArray.toString());
        M H4 = H(C2963w.f26560a.a() + "/eapi/logs/event", hashMap, ShareTarget.METHOD_POST);
        H4.j(F(H4, "/eapi/logs/event"));
        return H4;
    }

    public final M N(int i5, int i6) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i5));
        hashMap.put("page[offset]", String.valueOf(i6));
        M H4 = H(C2963w.f26560a.a() + "/eapi/apps/new-releases", hashMap, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/apps/new-releases"));
        return H4;
    }

    public final M N0(ArrayList arrayList) {
        t.e(arrayList, "errors");
        HashMap hashMap = new HashMap();
        JSONArray jSONArray = new JSONArray();
        Iterator it = arrayList.iterator();
        t.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            t.d(next, "next(...)");
            C2670t tVar = (C2670t) next;
            if (tVar.b() != null) {
                String b5 = tVar.b();
                t.b(b5);
                jSONArray.put(new JSONObject(b5));
            }
        }
        hashMap.put("errors", jSONArray.toString());
        M H4 = H(C2963w.f26560a.a() + "/eapi/logs/error", hashMap, ShareTarget.METHOD_POST);
        H4.j(F(H4, "/eapi/logs/error"));
        return H4;
    }

    public final M O(int i5, int i6) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i5));
        hashMap.put("page[offset]", String.valueOf(i6));
        M H4 = H(C2963w.f26560a.a() + "/eapi/apps/new-releases-home", hashMap, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/apps/new-releases-home"));
        return H4;
    }

    public final M O0(long j5, String str, String str2) {
        t.e(str, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        t.e(str2, TypedValues.TransitionType.S_FROM);
        HashMap hashMap = new HashMap();
        hashMap.put("appID", String.valueOf(j5));
        hashMap.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, str);
        hashMap.put(TypedValues.TransitionType.S_FROM, str2);
        hashMap.putAll(s());
        M H4 = H(C2963w.f26560a.a() + "/eapi/promo-track", hashMap, ShareTarget.METHOD_POST);
        H4.j(F(H4, "/eapi/promo-track"));
        return H4;
    }

    public final M P(long j5, int i5) {
        HashMap hashMap = new HashMap();
        hashMap.put("page", String.valueOf(i5));
        M H4 = H(C2963w.f26560a.a() + "/eapi/organization/" + j5 + "/apps", hashMap, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/organization/organizationId/apps"));
        return H4;
    }

    public final M P0(String str, String str2) {
        t.e(str, NotificationCompat.CATEGORY_EMAIL);
        t.e(str2, "pass");
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EMAIL, str);
        String f5 = C2286f.f20690a.f(str2);
        t.b(f5);
        hashMap.put("password", f5);
        C2667p pVar = new C2667p();
        pVar.j(this.f26528a);
        if (pVar.d() != null) {
            String d5 = pVar.d();
            t.b(d5);
            hashMap.put("deviceIdentifier", d5);
        }
        M H4 = H(C2963w.f26560a.a() + "/eapi/v2/user/login", hashMap, ShareTarget.METHOD_POST);
        if (H4.b()) {
            H4.j(G(H4, "/eapi/v2/user/login"));
            return H4;
        }
        H4.j(F(H4, "/eapi/v2/user/login"));
        return H4;
    }

    public final M Q(long j5) {
        M H4 = H(C2963w.f26560a.a() + "/eapi/organization/" + j5, (HashMap) null, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/organization/organizationId"));
        return H4;
    }

    public final M Q0() {
        M H4 = H(C2963w.f26560a.a() + "/eapi/main-app", (HashMap) null, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/main-app"));
        return H4;
    }

    public final M R0(long j5, int i5, int i6) {
        C2667p pVar = new C2667p();
        pVar.j(this.f26528a);
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i5));
        hashMap.put("page[offset]", String.valueOf(i6));
        M H4 = H(C2963w.f26560a.a() + "/eapi/v3/app/" + j5 + "/device/" + pVar.d() + "/compatible/versions", hashMap, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/v3/app/appID/device/identifier/compatible/versions"));
        return H4;
    }

    public final M S(long j5) {
        M H4 = H(C2963w.f26560a.a() + "/eapi/apps/" + j5 + "/permissions", (HashMap) null, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/apps/appId/permissions"));
        return H4;
    }

    public final M T(String str) {
        t.e(str, "identifier");
        M H4 = H(C2963w.f26560a.a() + "/eapi/v2/virus-total-by-identifier/" + str + "/report", (HashMap) null, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/v2/virus-total-by-identifier/identifier/report"));
        return H4;
    }

    public final M U() {
        M H4 = H(C2963w.f26560a.a() + "/eapi/v2/pre-register-apps-by-user", s(), ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/v2/pre-register-apps-by-user"));
        return H4;
    }

    public final M V(int i5) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i5));
        hashMap.putAll(s());
        M H4 = H(C2963w.f26560a.a() + "/eapi/v2/pre-register-apps-by-user", hashMap, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/v2/pre-register-apps-by-user"));
        return H4;
    }

    public final ArrayList V0(M m5) {
        t.e(m5, "res");
        ArrayList arrayList = new ArrayList();
        if (!m5.b() && m5.e() != null) {
            JSONObject e5 = m5.e();
            t.b(e5);
            JSONArray optJSONArray = e5.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
            JSONObject e6 = m5.e();
            t.b(e6);
            if (e6.optInt("success") == 1 && optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i5 = 0; i5 < length; i5++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i5);
                    t.d(optJSONObject, "optJSONObject(...)");
                    arrayList.add(C2657f.b.b(C2657f.f25002J0, optJSONObject, (Context) null, 2, (Object) null));
                }
            }
        }
        return arrayList;
    }

    public final M W(int i5, int i6) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i5));
        hashMap.put("page[offset]", String.valueOf(i6));
        M H4 = H(C2963w.f26560a.a() + "/eapi/my-profile-wishlist", hashMap, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/my-profile-wishlist"));
        return H4;
    }

    public final M X(long j5) {
        if (j5 == 0) {
            M m5 = new M();
            m5.k(MBridgeCommon.CampaignState.STATE_LOAD_FAILED_RESOURCE_DOWNLOAD_ERROR);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", 0);
            m5.i(jSONObject.toString());
            return m5;
        }
        HashMap hashMap = new HashMap();
        C2667p pVar = new C2667p();
        pVar.k(this.f26528a);
        String c5 = pVar.c();
        if (!(c5 == null || c5.length() == 0)) {
            hashMap.put("countryIsoCode", c5);
        }
        return H(C2963w.f26560a.a() + "/eapi/v3/apps/" + j5 + "/device/" + pVar.d(), hashMap, ShareTarget.METHOD_GET);
    }

    public final M X0(long j5, String str) {
        String str2;
        t.e(str, MimeTypes.BASE_TYPE_TEXT);
        HashMap hashMap = new HashMap();
        hashMap.put(MimeTypes.BASE_TYPE_TEXT, str);
        try {
            PackageManager packageManager = this.f26528a.getPackageManager();
            t.d(packageManager, "getPackageManager(...)");
            String packageName = this.f26528a.getPackageName();
            t.d(packageName, "getPackageName(...)");
            PackageInfo d5 = C2301u.d(packageManager, packageName, 0);
            str2 = ' ' + d5.versionName;
        } catch (Exception e5) {
            e5.printStackTrace();
            str2 = "";
        }
        hashMap.put("uagent", "uptodownandroid" + str2);
        M H4 = H(C2963w.f26560a.a() + "/eapi/comments/" + j5 + "/answers", hashMap, ShareTarget.METHOD_POST);
        H4.j(F(H4, "/eapi/comments/idReply/answers/post"));
        return H4;
    }

    public final M Y() {
        String str = "/eapi/promo-assign/provider/" + 1;
        M H4 = H(C2963w.f26560a.a() + str, (HashMap) null, ShareTarget.METHOD_GET);
        H4.j(F(H4, str));
        return H4;
    }

    public final M Y0(long j5, O o5) {
        String str;
        String str2;
        t.e(o5, "review");
        HashMap hashMap = new HashMap();
        if (o5.j() != null) {
            String j6 = o5.j();
            t.b(j6);
            if (j6.length() > 0) {
                String j7 = o5.j();
                t.b(j7);
                hashMap.put(MimeTypes.BASE_TYPE_TEXT, j7);
            }
        }
        hashMap.put(CampaignEx.JSON_KEY_STAR, String.valueOf(o5.i()));
        try {
            PackageManager packageManager = this.f26528a.getPackageManager();
            t.d(packageManager, "getPackageManager(...)");
            String packageName = this.f26528a.getPackageName();
            t.d(packageName, "getPackageName(...)");
            PackageInfo d5 = C2301u.d(packageManager, packageName, 0);
            str = ' ' + d5.versionName;
        } catch (Exception e5) {
            e5.printStackTrace();
            str = "";
        }
        hashMap.put("uagent", "uptodownandroid" + str);
        V h5 = V.f24870q.h(this.f26528a);
        if (h5 != null) {
            str2 = h5.j();
        } else {
            str2 = null;
        }
        if (str2 != null) {
            String j8 = h5.j();
            t.b(j8);
            hashMap.put("id_user", j8);
        }
        M H4 = H(C2963w.f26560a.a() + "/eapi/apps/" + j5 + "/comments", hashMap, ShareTarget.METHOD_POST);
        H4.j(F(H4, "/eapi/apps/appId/comments/post"));
        return H4;
    }

    public final M Z(long j5) {
        M H4 = H(C2963w.f26560a.a() + "/eapi/v2/apps/" + j5 + "/promoted", (HashMap) null, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/v2/apps/appID/promoted"));
        return H4;
    }

    public final M Z0(String str, String str2) {
        t.e(str, NotificationCompat.CATEGORY_EMAIL);
        t.e(str2, "email2");
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EMAIL, str);
        hashMap.put("email2", str2);
        M H4 = H(C2963w.f26560a.a() + "/eapi/user/recoverPasswordMail", hashMap, ShareTarget.METHOD_POST);
        if (H4.b()) {
            H4.j(G(H4, "/eapi/user/recoverPasswordMail"));
            return H4;
        }
        H4.j(F(H4, "/eapi/user/recoverPasswordMail"));
        return H4;
    }

    public final M a(int i5) {
        HashMap hashMap = new HashMap();
        hashMap.put("floatingCategoryID", String.valueOf(i5));
        M H4 = H(C2963w.f26560a.a() + "/eapi/user/categories/add", hashMap, ShareTarget.METHOD_POST);
        H4.j(F(H4, "/eapi/user/categories/add"));
        return H4;
    }

    public final M a0(int i5, int i6, int i7) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i6));
        hashMap.put("page[offset]", String.valueOf(i7));
        String str = "/eapi/categories/" + i5 + "/apps/news";
        M H4 = H(C2963w.f26560a.a() + str, hashMap, ShareTarget.METHOD_GET);
        H4.j(F(H4, str));
        return H4;
    }

    public final M a1(long j5, long j6, List list) {
        t.e(list, "devicesID");
        HashMap hashMap = new HashMap();
        hashMap.put("deviceID", String.valueOf(j6));
        hashMap.put("targetDeviceIDs", list.toString());
        String str = "/eapi/app/" + j5 + "/remote-install";
        M H4 = H(C2963w.f26560a.a() + str, hashMap, ShareTarget.METHOD_POST);
        H4.j(F(H4, str));
        return H4;
    }

    public final M b(long j5) {
        M H4 = H(C2963w.f26560a.a() + "/eapi/app/" + j5 + "/pre-register/add", s(), ShareTarget.METHOD_POST);
        H4.j(F(H4, "/eapi/app/appID/pre-register/add"));
        return H4;
    }

    public final M b0(String str, int i5, int i6) {
        t.e(str, "userID");
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i5));
        hashMap.put("page[offset]", String.valueOf(i6));
        M H4 = H(C2963w.f26560a.a() + "/eapi/user/" + str + "/recommended-list", hashMap, ShareTarget.METHOD_GET);
        StringBuilder sb = new StringBuilder();
        sb.append("/eapi/user/");
        sb.append(str);
        sb.append("/recommended-list");
        H4.j(F(H4, sb.toString()));
        return H4;
    }

    public final M b1(int i5) {
        HashMap hashMap = new HashMap();
        hashMap.put("floatingCategoryID", String.valueOf(i5));
        M H4 = H(C2963w.f26560a.a() + "/eapi/user/categories/delete", hashMap, ShareTarget.METHOD_POST);
        H4.j(F(H4, "/eapi/user/categories/delete"));
        return H4;
    }

    public final M c(long j5) {
        String str = "/eapi/app/" + j5 + "/recommended/add";
        M H4 = H(C2963w.f26560a.a() + str, (HashMap) null, ShareTarget.METHOD_POST);
        H4.j(F(H4, str));
        return H4;
    }

    public final M c0(long j5) {
        C2667p pVar = new C2667p();
        pVar.j(this.f26528a);
        String str = "/eapi/app/" + j5 + "/my-devices/" + pVar.d();
        M H4 = H(C2963w.f26560a.a() + str, (HashMap) null, ShareTarget.METHOD_GET);
        H4.j(F(H4, str));
        return H4;
    }

    public final M c1(long j5) {
        String str = "/eapi/app/" + j5 + "/recommended/delete";
        M H4 = H(C2963w.f26560a.a() + str, (HashMap) null, ShareTarget.METHOD_POST);
        H4.j(F(H4, str));
        return H4;
    }

    public final M d(long j5) {
        M H4 = H(C2963w.f26560a.a() + "/eapi/app/" + j5 + "/alternatives", (HashMap) null, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/app/appID/alternatives"));
        return H4;
    }

    public final M d0(String str) {
        t.e(str, "identifier");
        M H4 = H(C2963w.f26560a.a() + "/eapi/my-remote-apps/" + str, (HashMap) null, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/my-remote-apps/identifier"));
        return H4;
    }

    public final M d1(C2667p pVar, boolean z4) {
        t.e(pVar, "device");
        JSONObject l5 = pVar.l();
        String str = C2963w.f26560a.c() + "/eapi/v2/tracker/device";
        HashMap hashMap = new HashMap();
        hashMap.put("device", l5.toString());
        if (z4) {
            return I(str, hashMap);
        }
        return H(str, hashMap, ShareTarget.METHOD_POST);
    }

    public final M e() {
        M H4 = H(C2963w.f26560a.a() + "/eapi/event-log/version", (HashMap) null, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/event-log/version"));
        return H4;
    }

    public final M e0(long j5, int i5, int i6) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i5));
        hashMap.put("page[offset]", String.valueOf(i6));
        M H4 = H(C2963w.f26560a.a() + "/eapi/comments/" + j5 + "/answers", hashMap, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/comments/idReview/answers"));
        return H4;
    }

    public final M e1(ArrayList arrayList, String str, boolean z4) {
        t.e(arrayList, "apps");
        t.e(str, "identifier");
        String str2 = C2963w.f26560a.c() + "/eapi/v3/tracker/apps/save";
        JSONArray S02 = S0(arrayList);
        HashMap hashMap = new HashMap();
        hashMap.put("identifier", str);
        hashMap.put("apps", S02.toString());
        hashMap.put("app_version", "694");
        if (z4) {
            return I(str2, hashMap);
        }
        return H(str2, hashMap, ShareTarget.METHOD_POST);
    }

    public final M f(long j5) {
        M H4 = H(C2963w.f26560a.a() + "/eapi/app/" + j5 + "/pre-register/cancel", s(), ShareTarget.METHOD_POST);
        H4.j(F(H4, "/eapi/app/appID/pre-register/cancel"));
        return H4;
    }

    public final M f0(long j5, int i5, int i6, String str) {
        t.e(str, "ordination");
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i5));
        hashMap.put("page[offset]", String.valueOf(i6));
        hashMap.put("order", str);
        M H4 = H(C2963w.f26560a.a() + "/eapi/apps/" + j5 + "/comments", hashMap, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/apps/appId/comments"));
        return H4;
    }

    public final M f1(String str, int i5, int i6) {
        String str2;
        int i7;
        boolean z4;
        t.e(str, MimeTypes.BASE_TYPE_TEXT);
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i5));
        hashMap.put("page[offset]", String.valueOf(i6));
        try {
            String h5 = new p("\\n").h(str, " ");
            int length = h5.length() - 1;
            int i8 = 0;
            boolean z5 = false;
            while (true) {
                if (i8 > length) {
                    break;
                }
                if (!z5) {
                    i7 = i8;
                } else {
                    i7 = length;
                }
                if (t.g(h5.charAt(i7), 32) <= 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (!z5) {
                    if (!z4) {
                        z5 = true;
                    } else {
                        i8++;
                    }
                } else if (!z4) {
                    break;
                } else {
                    length--;
                }
            }
            str2 = URLEncoder.encode(h5.subSequence(i8, length + 1).toString(), C.UTF8_NAME);
        } catch (UnsupportedEncodingException e5) {
            e5.printStackTrace();
            str2 = null;
        }
        M H4 = H(C2963w.f26560a.a() + "/eapi/v2/apps/search" + '/' + str2, hashMap, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/v2/apps/search"));
        return H4;
    }

    public final M g(String str, String str2) {
        t.e(str, "password");
        t.e(str2, "repeatPassword");
        HashMap hashMap = new HashMap();
        hashMap.put("password1", str);
        hashMap.put("password2", str2);
        M H4 = H(C2963w.f26560a.a() + "/eapi/user/set-new-password", hashMap, ShareTarget.METHOD_POST);
        if (H4.b()) {
            H4.j(G(H4, "/eapi/user/set-new-password"));
            return H4;
        }
        H4.j(F(H4, "/eapi/user/set-new-password"));
        return H4;
    }

    public final M g0(long j5, int i5, int i6) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i5));
        hashMap.put("page[offset]", String.valueOf(i6));
        M H4 = H(C2963w.f26560a.a() + "/eapi/apps/" + j5 + "/comments-with-text", hashMap, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/apps/appId/comments-with-text"));
        return H4;
    }

    public final M g1(String str) {
        t.e(str, "token");
        HashMap hashMap = new HashMap();
        hashMap.put("fcmToken", str);
        C2667p pVar = new C2667p();
        pVar.j(this.f26528a);
        if (pVar.d() != null) {
            String d5 = pVar.d();
            t.b(d5);
            hashMap.put("identifier", d5);
        }
        M H4 = H(C2963w.f26560a.a() + "/eapi/v3/device/fcm-token", hashMap, ShareTarget.METHOD_POST);
        H4.j(F(H4, "/eapi/v3/device/fcm-token"));
        return H4;
    }

    public final M h(String str, int i5) {
        t.e(str, "username");
        HashMap hashMap = new HashMap();
        hashMap.put("newUsername", str);
        hashMap.put("usernameFormatID", String.valueOf(i5));
        M H4 = H(C2963w.f26560a.a() + "/eapi/user/change-username", hashMap, ShareTarget.METHOD_POST);
        if (H4.b()) {
            H4.j(G(H4, "/eapi/user/change-username"));
            return H4;
        }
        H4.j(F(H4, "/eapi/user/change-username"));
        return H4;
    }

    public final M h0(long j5) {
        M H4 = H(C2963w.f26560a.a() + "/eapi/app/" + j5 + "/screenshots", (HashMap) null, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/app/appId/screenshots"));
        return H4;
    }

    public final M h1(C2667p pVar, Q q5) {
        t.e(pVar, "device");
        t.e(q5, "settingsUTD");
        HashMap hashMap = new HashMap();
        hashMap.put("device", T0(pVar));
        JSONObject W02 = W0(q5);
        if (W02 != null) {
            hashMap.put("settings", W02.toString());
        }
        M H4 = H(C2963w.f26560a.c() + "/eapi/v2/tracker/identifier/" + pVar.d() + "/settings", hashMap, ShareTarget.METHOD_POST);
        H4.j(F(H4, "/eapi/v2/tracker/identifier/identifier/settings"));
        return H4;
    }

    public final boolean i(M m5) {
        long j5;
        t.e(m5, "res");
        boolean z4 = false;
        if (m5.b()) {
            if (m5.f() == 503) {
                String d5 = m5.d();
                if (!(d5 == null || d5.length() == 0)) {
                    try {
                        String d6 = m5.d();
                        t.b(d6);
                        JSONObject jSONObject = new JSONObject(d6);
                        if (!jSONObject.isNull("seconds")) {
                            j5 = jSONObject.optLong("seconds");
                            com.uptodown.activities.preferences.a.f15150a.p1(this.f26528a, j5);
                            C2940B a5 = C2940B.f26458v.a(this.f26528a);
                            a5.a();
                            a5.S();
                            a5.m();
                        }
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
                j5 = 7200;
                com.uptodown.activities.preferences.a.f15150a.p1(this.f26528a, j5);
                C2940B a52 = C2940B.f26458v.a(this.f26528a);
                a52.a();
                a52.S();
                a52.m();
            }
            return false;
        }
        String d7 = m5.d();
        if (d7 == null || d7.length() == 0) {
            z4 = true;
        }
        return !z4;
    }

    public final M i0(String str) {
        t.e(str, "identifier");
        return H(C2963w.f26560a.c() + "/eapi/v2/tracker/device/" + str + "/status", (HashMap) null, ShareTarget.METHOD_GET);
    }

    public final M i1(String str, String str2, C2667p pVar, C2676z zVar) {
        t.e(str, NotificationCompat.CATEGORY_EMAIL);
        t.e(str2, "suggestion");
        t.e(pVar, "device");
        t.e(zVar, "memory");
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EMAIL, str);
        hashMap.put(NotificationCompat.CATEGORY_MESSAGE, str2);
        hashMap.put("device", T0(pVar));
        hashMap.put("memory", U0(zVar));
        M H4 = H(C2963w.f26560a.a() + "/eapi/nativeapp/sendsuggestion", hashMap, ShareTarget.METHOD_POST);
        H4.j(F(H4, "/eapi/nativeapp/sendsuggestion"));
        return H4;
    }

    public final M j(long j5) {
        M H4 = H(C2963w.f26560a.a() + "/eapi/app/" + j5 + "/pre-registered", s(), ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/app/appID/pre-registered"));
        return H4;
    }

    public final M j0(String str) {
        t.e(str, "userID");
        M H4 = H(C2963w.f26560a.a() + "/eapi/turbosubscription/get-url-portal/" + str + '/', (HashMap) null, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/turbosubscription/get-url-portal/userID/"));
        return H4;
    }

    public final M j1(X x4) {
        t.e(x4, "usage");
        HashMap hashMap = new HashMap();
        hashMap.put("usageTime", String.valueOf(x4.d()));
        hashMap.put("downloads", String.valueOf(x4.a()));
        hashMap.put("installations", String.valueOf(x4.b()));
        hashMap.put("updates", String.valueOf(x4.c()));
        hashMap.put("lastUpdate", String.valueOf(System.currentTimeMillis() / ((long) 1000)));
        M H4 = H(C2963w.f26560a.a() + "/eapi/user-data/native-app-usage", hashMap, ShareTarget.METHOD_POST);
        H4.j(F(H4, "/eapi/user-data/native-app-usage"));
        return H4;
    }

    public final M k(String str) {
        t.e(str, "followUserID");
        M H4 = H(C2963w.f26560a.a() + "/eapi/user/follow/" + str, (HashMap) null, ShareTarget.METHOD_POST);
        H4.j(F(H4, "/eapi/user/follow/followUserID"));
        return H4;
    }

    public final M k0(int i5, int i6) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i5));
        hashMap.put("page[offset]", String.valueOf(i6));
        M H4 = H(C2963w.f26560a.a() + "/eapi/v2/app/top-platform", hashMap, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/v2/app/top-platform"));
        return H4;
    }

    public final M k1() {
        M H4 = H(C2963w.f26560a.a() + "/eapi/my-recommended-list/private", (HashMap) null, ShareTarget.METHOD_POST);
        H4.j(F(H4, "/eapi/my-recommended-list/private"));
        return H4;
    }

    public final M l(ArrayList arrayList, int i5, int i6) {
        t.e(arrayList, "categories");
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i5));
        hashMap.put("page[offset]", String.valueOf(i6));
        hashMap.put("categoryIDs", arrayList.toString());
        M H4 = H(C2963w.f26560a.a() + "/eapi/floating-category/additional/apps", hashMap, ShareTarget.METHOD_POST);
        H4.j(F(H4, "/eapi/floating-category/additional/apps"));
        return H4;
    }

    public final M l0(int i5, int i6, int i7) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i6));
        hashMap.put("page[offset]", String.valueOf(i7));
        String str = "/eapi/category/" + i5 + "/apps/top";
        M H4 = H(C2963w.f26560a.a() + str, hashMap, ShareTarget.METHOD_GET);
        H4.j(F(H4, str));
        return H4;
    }

    public final M l1() {
        M H4 = H(C2963w.f26560a.a() + "/eapi/my-recommended-list/public", (HashMap) null, ShareTarget.METHOD_POST);
        H4.j(F(H4, "/eapi/my-recommended-list/public"));
        return H4;
    }

    public final M m(long j5) {
        M H4 = H(C2963w.f26560a.a() + "/eapi/v2/app/" + j5 + "/abis", (HashMap) null, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/v2/app/appId/abis"));
        return H4;
    }

    public final M m0(int i5, int i6, int i7) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i6));
        hashMap.put("page[offset]", String.valueOf(i7));
        String str = "/eapi/v2/leaf-category/" + i5 + "/apps/top";
        M H4 = H(C2963w.f26560a.a() + str, hashMap, ShareTarget.METHOD_GET);
        H4.j(F(H4, str));
        return H4;
    }

    public final M m1(long j5) {
        HashMap hashMap = new HashMap();
        hashMap.put("avatarID", String.valueOf(j5));
        M H4 = H(C2963w.f26560a.a() + "/eapi/user/avatar", hashMap, ShareTarget.METHOD_POST);
        H4.j(F(H4, "/eapi/user/avatar"));
        return H4;
    }

    public final M n(String str) {
        t.e(str, "packagename");
        M H4 = H(C2963w.f26560a.a() + "/eapi/apps/byPackagename" + '/' + str, (HashMap) null, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/apps/byPackagename"));
        return H4;
    }

    public final M n0(int i5, int i6, int i7) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i6));
        hashMap.put("page[offset]", String.valueOf(i7));
        String str = "/eapi/floating-category/" + i5 + "/apps";
        M H4 = H(C2963w.f26560a.a() + str, hashMap, ShareTarget.METHOD_GET);
        H4.j(F(H4, str));
        return H4;
    }

    public final M n1(String str, String str2, String str3) {
        t.e(str, RewardPlus.NAME);
        t.e(str2, "pass");
        t.e(str3, NotificationCompat.CATEGORY_EMAIL);
        HashMap hashMap = new HashMap();
        hashMap.put("username", str);
        String f5 = C2286f.f20690a.f(str2);
        t.b(f5);
        hashMap.put("password", f5);
        hashMap.put(NotificationCompat.CATEGORY_EMAIL, str3);
        hashMap.put("terms", "1");
        M H4 = H(C2963w.f26560a.a() + "/eapi/user/signup", hashMap, ShareTarget.METHOD_POST);
        if (H4.b()) {
            H4.j(G(H4, "/eapi/user/signup"));
            return H4;
        }
        H4.j(F(H4, "/eapi/user/signup"));
        return H4;
    }

    public final M o(String str) {
        t.e(str, "downloadURL");
        HashMap hashMap = new HashMap();
        hashMap.put("downloadURL", str);
        return H(C2963w.f26560a.a() + "/eapi/app/get-by-download-url", hashMap, ShareTarget.METHOD_GET);
    }

    public final M o0(int i5, int i6, int i7) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i6));
        hashMap.put("page[offset]", String.valueOf(i7));
        String str = "/eapi/floating-category/" + i5 + "/apps-list";
        M H4 = H(C2963w.f26560a.a() + str, hashMap, ShareTarget.METHOD_GET);
        H4.j(F(H4, str));
        return H4;
    }

    public final M o1(String str, String str2) {
        t.e(str, "accessToken");
        t.e(str2, "provider");
        HashMap hashMap = new HashMap();
        hashMap.put("provider", str2);
        hashMap.put("accessToken", str);
        C2667p pVar = new C2667p();
        pVar.j(this.f26528a);
        if (pVar.d() != null) {
            String d5 = pVar.d();
            t.b(d5);
            hashMap.put("deviceIdentifier", d5);
        }
        M H4 = H(C2963w.f26560a.a() + "/eapi/user/usertokenSignup", hashMap, ShareTarget.METHOD_POST);
        if (H4.b()) {
            H4.j(G(H4, "/eapi/user/usertokenSignup"));
            return H4;
        }
        H4.j(F(H4, "/eapi/user/usertokenSignup"));
        return H4;
    }

    public final M p(long j5) {
        M H4 = H(C2963w.f26560a.a() + "/eapi/v2/app/" + j5 + "/languages", (HashMap) null, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/v2/app/appId/languages"));
        return H4;
    }

    public final M p0() {
        C2667p pVar = new C2667p();
        pVar.j(this.f26528a);
        M H4 = H(C2963w.f26560a.c() + "/eapi/androidtracker/device-apps-installed" + '/' + pVar.d(), (HashMap) null, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/androidtracker/device-apps-installed"));
        return H4;
    }

    public final M p1(long j5, int i5, int i6) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i5));
        hashMap.put("page[offset]", String.valueOf(i6));
        M H4 = H(C2963w.f26560a.a() + "/eapi/" + j5 + "/similar", hashMap, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/appID/similar"));
        return H4;
    }

    public final M q() {
        HashMap hashMap = new HashMap();
        M H4 = H(C2963w.f26560a.a() + "/eapi/v2/categories/parents", hashMap, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/v2/categories/parents"));
        return H4;
    }

    public final M q0(String str) {
        t.e(str, "identifier");
        return H(C2963w.f26560a.c() + "/eapi/v3/tracker/updates/" + str, (HashMap) null, ShareTarget.METHOD_GET);
    }

    public final M q1(String str) {
        t.e(str, "followUserID");
        M H4 = H(C2963w.f26560a.a() + "/eapi/user/unfollow/" + str, (HashMap) null, ShareTarget.METHOD_POST);
        H4.j(F(H4, "/eapi/user/unfollow/followUserID"));
        return H4;
    }

    public final M r(int i5) {
        String str = "/eapi/v2/categories/" + i5 + "/leaf-categories";
        M H4 = H(C2963w.f26560a.a() + str, (HashMap) null, ShareTarget.METHOD_GET);
        H4.j(F(H4, str));
        return H4;
    }

    public final M r0(String str, int i5, String str2) {
        t.e(str, "fileId");
        t.e(str2, "appId");
        HashMap hashMap = new HashMap();
        hashMap.put("update", String.valueOf(i5));
        return H(C2963w.f26560a.a() + "/eapi/apps/" + str2 + "/file/" + str + "/downloadUrl", hashMap, ShareTarget.METHOD_GET);
    }

    public final M r1(String str) {
        t.e(str, "deviceID");
        M H4 = H(C2963w.f26560a.a() + "/eapi/user-data/device/" + str + "/unlink", (HashMap) null, ShareTarget.METHOD_POST);
        H4.j(F(H4, "/eapi/user-data/device/deviceID/unlink"));
        return H4;
    }

    public final M s0(String str, int i5, String str2) {
        t.e(str, "fileId");
        t.e(str2, "appId");
        HashMap hashMap = new HashMap();
        hashMap.put("update", String.valueOf(i5));
        return H(C2963w.f26560a.a() + "/eapi/apps/" + str2 + "/file/" + str + "/resumeDownloadURL", hashMap, ShareTarget.METHOD_GET);
    }

    public final M s1(String str, String str2) {
        t.e(str, "deviceID");
        t.e(str2, "newName");
        HashMap hashMap = new HashMap();
        hashMap.put(RewardPlus.NAME, str2);
        M H4 = H(C2963w.f26560a.a() + "/eapi/user-data/device/" + str + "/update-name", hashMap, ShareTarget.METHOD_POST);
        H4.j(F(H4, "/eapi/user-data/device/deviceID/update-name"));
        return H4;
    }

    public final M t(int i5, int i6, int i7) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i6));
        hashMap.put("page[offset]", String.valueOf(i7));
        String str = "/eapi/v2/floating-category/" + i5 + "/data-and-apps-list";
        M H4 = H(C2963w.f26560a.a() + str, hashMap, ShareTarget.METHOD_GET);
        H4.j(F(H4, str));
        return H4;
    }

    public final M t0(String str, String str2) {
        t.e(str, "packagename");
        t.e(str2, "md5signature");
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("packagename", str);
        jSONObject.put("md5Signature", str2);
        hashMap.put(MBridgeConstans.DYNAMIC_VIEW_WX_APP, jSONObject.toString());
        M H4 = H(C2963w.f26560a.a() + "/eapi/nativeapp/getappurlbypackagenamemd5signature", hashMap, ShareTarget.METHOD_POST);
        H4.j(F(H4, "/eapi/nativeapp/getappurlbypackagenamemd5signature"));
        return H4;
    }

    public final M t1(long j5) {
        M H4 = H(C2963w.f26560a.a() + "/eapi/app/" + j5 + "/wishlist/add", (HashMap) null, ShareTarget.METHOD_POST);
        H4.j(F(H4, "/eapi/app/appID/wishlist/add"));
        return H4;
    }

    public final M u(String str) {
        t.e(str, "identifier");
        return H(C2963w.f26560a.c() + "/eapi/v2/tracker/device/" + str, (HashMap) null, ShareTarget.METHOD_GET);
    }

    public final M u0() {
        M H4 = H(C2963w.f26560a.a() + "/eapi/v2/user/avatars", (HashMap) null, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/v2/user/avatars"));
        return H4;
    }

    public final M u1(long j5) {
        M H4 = H(C2963w.f26560a.a() + "/eapi/app/" + j5 + "/wishlist/delete", (HashMap) null, ShareTarget.METHOD_POST);
        H4.j(F(H4, "/eapi/app/appID/wishlist/delete"));
        return H4;
    }

    public final M v() {
        M H4 = H(C2963w.f26560a.a() + "/eapi/user/categories", (HashMap) null, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/user/categories"));
        return H4;
    }

    public final M v0(String str, int i5, int i6) {
        t.e(str, "userID");
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i5));
        hashMap.put("page[offset]", String.valueOf(i6));
        M H4 = H(C2963w.f26560a.a() + "/eapi/user/" + str + "/comments", hashMap, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/user/userID/comments"));
        return H4;
    }

    public final M w(int i5) {
        String str = "/eapi/category/" + i5 + "/features";
        M H4 = H(C2963w.f26560a.a() + str, new HashMap(), ShareTarget.METHOD_GET);
        H4.j(F(H4, str));
        return H4;
    }

    public final M w0() {
        HashMap hashMap = new HashMap();
        C2667p pVar = new C2667p();
        pVar.j(this.f26528a);
        if (pVar.d() != null) {
            String d5 = pVar.d();
            t.b(d5);
            hashMap.put("deviceIdentifier", d5);
        }
        return H(C2963w.f26560a.a() + "/eapi/user/getUpdatedData", hashMap, ShareTarget.METHOD_GET);
    }

    public final M x(int i5, int i6) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i5));
        hashMap.put("page[offset]", String.valueOf(i6));
        M H4 = H(C2963w.f26560a.a() + "/eapi/my-feed", hashMap, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/my-feed"));
        return H4;
    }

    public final M x0(String str) {
        t.e(str, "userID");
        M H4 = H(C2963w.f26560a.a() + "/eapi/profile/" + str + "/data", (HashMap) null, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/profile/userID/data"));
        return H4;
    }

    public final M y(String str) {
        t.e(str, "identifier");
        return H(C2963w.f26560a.c() + "/eapi/v2/tracker/app-to-upload/" + str, (HashMap) null, ShareTarget.METHOD_GET);
    }

    public final M y0() {
        M H4 = H(C2963w.f26560a.a() + "/eapi/user-data/stats", (HashMap) null, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/user-data/stats"));
        return H4;
    }

    public final M z(long j5) {
        M H4 = H(C2963w.f26560a.a() + "/eapi/floating-categories/app" + '/' + j5, (HashMap) null, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/floating-categories/app"));
        return H4;
    }

    public final M z0(String str) {
        t.e(str, "deviceID");
        M H4 = H(C2963w.f26560a.a() + "/eapi/user-data/device" + '/' + str, (HashMap) null, ShareTarget.METHOD_GET);
        H4.j(F(H4, "/eapi/user-data/device"));
        return H4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Z(Context context, C2684d dVar) {
        this(context);
        t.e(context, "context");
    }
}
