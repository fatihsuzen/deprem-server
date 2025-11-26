package C0;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f2327a;

    /* renamed from: b  reason: collision with root package name */
    private final Map f2328b;

    /* renamed from: c  reason: collision with root package name */
    private final Map f2329c = new HashMap();

    public a(String str, Map map) {
        this.f2327a = str;
        this.f2328b = map;
    }

    private String a(Map map) {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        Iterator it = map.entrySet().iterator();
        Map.Entry entry = (Map.Entry) it.next();
        sb.append((String) entry.getKey());
        sb.append("=");
        if (entry.getValue() != null) {
            str = URLEncoder.encode((String) entry.getValue(), C.UTF8_NAME);
        } else {
            str = "";
        }
        sb.append(str);
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            sb.append("&");
            sb.append((String) entry2.getKey());
            sb.append("=");
            if (entry2.getValue() != null) {
                str2 = URLEncoder.encode((String) entry2.getValue(), C.UTF8_NAME);
            } else {
                str2 = "";
            }
            sb.append(str2);
        }
        return sb.toString();
    }

    private String b(String str, Map map) {
        String a5 = a(map);
        if (a5.isEmpty()) {
            return str;
        }
        if (str.contains("?")) {
            if (!str.endsWith("&")) {
                a5 = "&" + a5;
            }
            return str + a5;
        }
        return str + "?" + a5;
    }

    private String e(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, C.UTF8_NAME));
        char[] cArr = new char[8192];
        StringBuilder sb = new StringBuilder();
        while (true) {
            int read = bufferedReader.read(cArr);
            if (read == -1) {
                return sb.toString();
            }
            sb.append(cArr, 0, read);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0090  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C0.c c() {
        /*
            r5 = this;
            y0.i.d()
            r0 = 0
            java.lang.String r1 = r5.f2327a     // Catch:{ all -> 0x0087 }
            java.util.Map r2 = r5.f2328b     // Catch:{ all -> 0x0087 }
            java.lang.String r1 = r5.b(r1, r2)     // Catch:{ all -> 0x0087 }
            u0.g r2 = u0.g.f()     // Catch:{ all -> 0x0087 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0087 }
            r3.<init>()     // Catch:{ all -> 0x0087 }
            java.lang.String r4 = "GET Request URL: "
            r3.append(r4)     // Catch:{ all -> 0x0087 }
            r3.append(r1)     // Catch:{ all -> 0x0087 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0087 }
            r2.i(r3)     // Catch:{ all -> 0x0087 }
            java.net.URL r2 = new java.net.URL     // Catch:{ all -> 0x0087 }
            r2.<init>(r1)     // Catch:{ all -> 0x0087 }
            java.net.URLConnection r1 = r2.openConnection()     // Catch:{ all -> 0x0087 }
            javax.net.ssl.HttpsURLConnection r1 = (javax.net.ssl.HttpsURLConnection) r1     // Catch:{ all -> 0x0087 }
            r2 = 10000(0x2710, float:1.4013E-41)
            r1.setReadTimeout(r2)     // Catch:{ all -> 0x0062 }
            r1.setConnectTimeout(r2)     // Catch:{ all -> 0x0062 }
            java.lang.String r2 = "GET"
            r1.setRequestMethod(r2)     // Catch:{ all -> 0x0062 }
            java.util.Map r2 = r5.f2329c     // Catch:{ all -> 0x0062 }
            java.util.Set r2 = r2.entrySet()     // Catch:{ all -> 0x0062 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0062 }
        L_0x0046:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0062 }
            if (r3 == 0) goto L_0x0064
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0062 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x0062 }
            java.lang.Object r4 = r3.getKey()     // Catch:{ all -> 0x0062 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0062 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x0062 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0062 }
            r1.addRequestProperty(r4, r3)     // Catch:{ all -> 0x0062 }
            goto L_0x0046
        L_0x0062:
            r2 = move-exception
            goto L_0x0089
        L_0x0064:
            r1.connect()     // Catch:{ all -> 0x0062 }
            int r2 = r1.getResponseCode()     // Catch:{ all -> 0x0062 }
            java.io.InputStream r3 = r1.getInputStream()     // Catch:{ all -> 0x0062 }
            if (r3 == 0) goto L_0x0079
            java.lang.String r0 = r5.e(r3)     // Catch:{ all -> 0x0076 }
            goto L_0x0079
        L_0x0076:
            r2 = move-exception
            r0 = r3
            goto L_0x0089
        L_0x0079:
            if (r3 == 0) goto L_0x007e
            r3.close()
        L_0x007e:
            r1.disconnect()
            C0.c r1 = new C0.c
            r1.<init>(r2, r0)
            return r1
        L_0x0087:
            r2 = move-exception
            r1 = r0
        L_0x0089:
            if (r0 == 0) goto L_0x008e
            r0.close()
        L_0x008e:
            if (r1 == 0) goto L_0x0093
            r1.disconnect()
        L_0x0093:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: C0.a.c():C0.c");
    }

    public a d(String str, String str2) {
        this.f2329c.put(str, str2);
        return this;
    }
}
