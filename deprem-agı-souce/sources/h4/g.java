package h4;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import g4.b;
import java.net.URLEncoder;
import java.util.Map;
import p4.a;

public class g {

    /* renamed from: c  reason: collision with root package name */
    private static final String f23761c = b.i(g.class);

    /* renamed from: a  reason: collision with root package name */
    private final long f23762a;

    /* renamed from: b  reason: collision with root package name */
    private final String f23763b;

    public g(Map map) {
        this(d(map));
    }

    private static String c(String str) {
        try {
            return URLEncoder.encode(str, C.UTF8_NAME).replaceAll("\\+", "%20");
        } catch (Exception e5) {
            a.b(f23761c).e(e5, "Cannot encode %s", str);
            return "";
        }
    }

    private static String d(Map map) {
        StringBuilder sb = new StringBuilder(100);
        sb.append('?');
        for (Map.Entry entry : map.entrySet()) {
            sb.append(c((String) entry.getKey()));
            sb.append('=');
            sb.append(c((String) entry.getValue()));
            sb.append('&');
        }
        return sb.substring(0, sb.length() - 1);
    }

    public String a() {
        return this.f23763b;
    }

    public long b() {
        return this.f23762a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            g gVar = (g) obj;
            if (this.f23762a != gVar.f23762a || !this.f23763b.equals(gVar.f23763b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j5 = this.f23762a;
        return (((int) (j5 ^ (j5 >>> 32))) * 31) + this.f23763b.hashCode();
    }

    public String toString() {
        return a();
    }

    public g(String str) {
        this(System.currentTimeMillis(), str);
    }

    public g(long j5, String str) {
        this.f23762a = j5;
        this.f23763b = str;
    }
}
