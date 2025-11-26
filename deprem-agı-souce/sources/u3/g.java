package U3;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class g {

    /* renamed from: A  reason: collision with root package name */
    public static final g f19391A = d("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);

    /* renamed from: A0  reason: collision with root package name */
    public static final g f19392A0 = d("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);

    /* renamed from: B  reason: collision with root package name */
    public static final g f19393B = d("TLS_KRB5_WITH_RC4_128_MD5", 36);

    /* renamed from: B0  reason: collision with root package name */
    public static final g f19394B0 = d("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);

    /* renamed from: C  reason: collision with root package name */
    public static final g f19395C = d("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);

    /* renamed from: C0  reason: collision with root package name */
    public static final g f19396C0 = d("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);

    /* renamed from: D  reason: collision with root package name */
    public static final g f19397D = d("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);

    /* renamed from: D0  reason: collision with root package name */
    public static final g f19398D0 = d("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);

    /* renamed from: E  reason: collision with root package name */
    public static final g f19399E = d("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);

    /* renamed from: E0  reason: collision with root package name */
    public static final g f19400E0 = d("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);

    /* renamed from: F  reason: collision with root package name */
    public static final g f19401F = d("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);

    /* renamed from: F0  reason: collision with root package name */
    public static final g f19402F0 = d("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);

    /* renamed from: G  reason: collision with root package name */
    public static final g f19403G = d("TLS_RSA_WITH_AES_128_CBC_SHA", 47);

    /* renamed from: G0  reason: collision with root package name */
    public static final g f19404G0 = d("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);

    /* renamed from: H  reason: collision with root package name */
    public static final g f19405H = d("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);

    /* renamed from: H0  reason: collision with root package name */
    public static final g f19406H0 = d("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);

    /* renamed from: I  reason: collision with root package name */
    public static final g f19407I = d("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);

    /* renamed from: I0  reason: collision with root package name */
    public static final g f19408I0 = d("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);

    /* renamed from: J  reason: collision with root package name */
    public static final g f19409J = d("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);

    /* renamed from: J0  reason: collision with root package name */
    public static final g f19410J0 = d("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);

    /* renamed from: K  reason: collision with root package name */
    public static final g f19411K = d("TLS_RSA_WITH_AES_256_CBC_SHA", 53);

    /* renamed from: K0  reason: collision with root package name */
    public static final g f19412K0 = d("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);

    /* renamed from: L  reason: collision with root package name */
    public static final g f19413L = d("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);

    /* renamed from: L0  reason: collision with root package name */
    public static final g f19414L0 = d("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);

    /* renamed from: M  reason: collision with root package name */
    public static final g f19415M = d("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);

    /* renamed from: M0  reason: collision with root package name */
    public static final g f19416M0 = d("TLS_ECDH_anon_WITH_NULL_SHA", 49173);

    /* renamed from: N  reason: collision with root package name */
    public static final g f19417N = d("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);

    /* renamed from: N0  reason: collision with root package name */
    public static final g f19418N0 = d("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);

    /* renamed from: O  reason: collision with root package name */
    public static final g f19419O = d("TLS_RSA_WITH_NULL_SHA256", 59);

    /* renamed from: O0  reason: collision with root package name */
    public static final g f19420O0 = d("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);

    /* renamed from: P  reason: collision with root package name */
    public static final g f19421P = d("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);

    /* renamed from: P0  reason: collision with root package name */
    public static final g f19422P0 = d("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);

    /* renamed from: Q  reason: collision with root package name */
    public static final g f19423Q = d("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);

    /* renamed from: Q0  reason: collision with root package name */
    public static final g f19424Q0 = d("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);

    /* renamed from: R  reason: collision with root package name */
    public static final g f19425R = d("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);

    /* renamed from: R0  reason: collision with root package name */
    public static final g f19426R0 = d("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);

    /* renamed from: S  reason: collision with root package name */
    public static final g f19427S = d("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);

    /* renamed from: S0  reason: collision with root package name */
    public static final g f19428S0 = d("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);

    /* renamed from: T  reason: collision with root package name */
    public static final g f19429T = d("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);

    /* renamed from: T0  reason: collision with root package name */
    public static final g f19430T0 = d("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);

    /* renamed from: U  reason: collision with root package name */
    public static final g f19431U = d("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);

    /* renamed from: U0  reason: collision with root package name */
    public static final g f19432U0 = d("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);

    /* renamed from: V  reason: collision with root package name */
    public static final g f19433V = d("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);

    /* renamed from: V0  reason: collision with root package name */
    public static final g f19434V0 = d("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);

    /* renamed from: W  reason: collision with root package name */
    public static final g f19435W = d("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);

    /* renamed from: W0  reason: collision with root package name */
    public static final g f19436W0 = d("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);

    /* renamed from: X  reason: collision with root package name */
    public static final g f19437X = d("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);

    /* renamed from: X0  reason: collision with root package name */
    public static final g f19438X0 = d("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);

    /* renamed from: Y  reason: collision with root package name */
    public static final g f19439Y = d("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);

    /* renamed from: Y0  reason: collision with root package name */
    public static final g f19440Y0 = d("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);

    /* renamed from: Z  reason: collision with root package name */
    public static final g f19441Z = d("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);

    /* renamed from: Z0  reason: collision with root package name */
    public static final g f19442Z0 = d("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);

    /* renamed from: a0  reason: collision with root package name */
    public static final g f19443a0 = d("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);

    /* renamed from: a1  reason: collision with root package name */
    public static final g f19444a1 = d("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);

    /* renamed from: b  reason: collision with root package name */
    static final Comparator f19445b;

    /* renamed from: b0  reason: collision with root package name */
    public static final g f19446b0 = d("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", TsExtractor.TS_STREAM_TYPE_E_AC3);

    /* renamed from: b1  reason: collision with root package name */
    public static final g f19447b1 = d("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);

    /* renamed from: c  reason: collision with root package name */
    private static final Map f19448c;

    /* renamed from: c0  reason: collision with root package name */
    public static final g f19449c0 = d("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);

    /* renamed from: c1  reason: collision with root package name */
    public static final g f19450c1 = d("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);

    /* renamed from: d  reason: collision with root package name */
    public static final g f19451d = d("SSL_RSA_WITH_NULL_MD5", 1);

    /* renamed from: d0  reason: collision with root package name */
    public static final g f19452d0 = d("TLS_PSK_WITH_RC4_128_SHA", TsExtractor.TS_STREAM_TYPE_DTS);

    /* renamed from: d1  reason: collision with root package name */
    public static final g f19453d1 = d("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);

    /* renamed from: e  reason: collision with root package name */
    public static final g f19454e = d("SSL_RSA_WITH_NULL_SHA", 2);

    /* renamed from: e0  reason: collision with root package name */
    public static final g f19455e0 = d("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);

    /* renamed from: e1  reason: collision with root package name */
    public static final g f19456e1 = d("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);

    /* renamed from: f  reason: collision with root package name */
    public static final g f19457f = d("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);

    /* renamed from: f0  reason: collision with root package name */
    public static final g f19458f0 = d("TLS_PSK_WITH_AES_128_CBC_SHA", 140);

    /* renamed from: f1  reason: collision with root package name */
    public static final g f19459f1 = d("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);

    /* renamed from: g  reason: collision with root package name */
    public static final g f19460g = d("SSL_RSA_WITH_RC4_128_MD5", 4);

    /* renamed from: g0  reason: collision with root package name */
    public static final g f19461g0 = d("TLS_PSK_WITH_AES_256_CBC_SHA", 141);

    /* renamed from: g1  reason: collision with root package name */
    public static final g f19462g1 = d("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);

    /* renamed from: h  reason: collision with root package name */
    public static final g f19463h = d("SSL_RSA_WITH_RC4_128_SHA", 5);

    /* renamed from: h0  reason: collision with root package name */
    public static final g f19464h0 = d("TLS_RSA_WITH_SEED_CBC_SHA", 150);

    /* renamed from: h1  reason: collision with root package name */
    public static final g f19465h1 = d("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);

    /* renamed from: i  reason: collision with root package name */
    public static final g f19466i = d("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);

    /* renamed from: i0  reason: collision with root package name */
    public static final g f19467i0 = d("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);

    /* renamed from: i1  reason: collision with root package name */
    public static final g f19468i1 = d("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);

    /* renamed from: j  reason: collision with root package name */
    public static final g f19469j = d("SSL_RSA_WITH_DES_CBC_SHA", 9);

    /* renamed from: j0  reason: collision with root package name */
    public static final g f19470j0 = d("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);

    /* renamed from: j1  reason: collision with root package name */
    public static final g f19471j1 = d("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);

    /* renamed from: k  reason: collision with root package name */
    public static final g f19472k = d("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);

    /* renamed from: k0  reason: collision with root package name */
    public static final g f19473k0 = d("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);

    /* renamed from: k1  reason: collision with root package name */
    public static final g f19474k1 = d("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);

    /* renamed from: l  reason: collision with root package name */
    public static final g f19475l = d("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);

    /* renamed from: l0  reason: collision with root package name */
    public static final g f19476l0 = d("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);

    /* renamed from: m  reason: collision with root package name */
    public static final g f19477m = d("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);

    /* renamed from: m0  reason: collision with root package name */
    public static final g f19478m0 = d("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);

    /* renamed from: n  reason: collision with root package name */
    public static final g f19479n = d("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);

    /* renamed from: n0  reason: collision with root package name */
    public static final g f19480n0 = d("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);

    /* renamed from: o  reason: collision with root package name */
    public static final g f19481o = d("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);

    /* renamed from: o0  reason: collision with root package name */
    public static final g f19482o0 = d("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);

    /* renamed from: p  reason: collision with root package name */
    public static final g f19483p = d("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);

    /* renamed from: p0  reason: collision with root package name */
    public static final g f19484p0 = d("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);

    /* renamed from: q  reason: collision with root package name */
    public static final g f19485q = d("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);

    /* renamed from: q0  reason: collision with root package name */
    public static final g f19486q0 = d("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);

    /* renamed from: r  reason: collision with root package name */
    public static final g f19487r = d("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);

    /* renamed from: r0  reason: collision with root package name */
    public static final g f19488r0 = d("TLS_FALLBACK_SCSV", 22016);

    /* renamed from: s  reason: collision with root package name */
    public static final g f19489s = d("SSL_DH_anon_WITH_RC4_128_MD5", 24);

    /* renamed from: s0  reason: collision with root package name */
    public static final g f19490s0 = d("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);

    /* renamed from: t  reason: collision with root package name */
    public static final g f19491t = d("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);

    /* renamed from: t0  reason: collision with root package name */
    public static final g f19492t0 = d("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);

    /* renamed from: u  reason: collision with root package name */
    public static final g f19493u = d("SSL_DH_anon_WITH_DES_CBC_SHA", 26);

    /* renamed from: u0  reason: collision with root package name */
    public static final g f19494u0 = d("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);

    /* renamed from: v  reason: collision with root package name */
    public static final g f19495v = d("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);

    /* renamed from: v0  reason: collision with root package name */
    public static final g f19496v0 = d("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);

    /* renamed from: w  reason: collision with root package name */
    public static final g f19497w = d("TLS_KRB5_WITH_DES_CBC_SHA", 30);

    /* renamed from: w0  reason: collision with root package name */
    public static final g f19498w0 = d("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);

    /* renamed from: x  reason: collision with root package name */
    public static final g f19499x = d("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);

    /* renamed from: x0  reason: collision with root package name */
    public static final g f19500x0 = d("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);

    /* renamed from: y  reason: collision with root package name */
    public static final g f19501y = d("TLS_KRB5_WITH_RC4_128_SHA", 32);

    /* renamed from: y0  reason: collision with root package name */
    public static final g f19502y0 = d("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);

    /* renamed from: z  reason: collision with root package name */
    public static final g f19503z = d("TLS_KRB5_WITH_DES_CBC_MD5", 34);

    /* renamed from: z0  reason: collision with root package name */
    public static final g f19504z0 = d("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);

    /* renamed from: a  reason: collision with root package name */
    final String f19505a;

    class a implements Comparator {
        a() {
        }

        /* renamed from: a */
        public int compare(String str, String str2) {
            int min = Math.min(str.length(), str2.length());
            int i5 = 4;
            while (i5 < min) {
                char charAt = str.charAt(i5);
                char charAt2 = str2.charAt(i5);
                if (charAt == charAt2) {
                    i5++;
                } else if (charAt < charAt2) {
                    return -1;
                } else {
                    return 1;
                }
            }
            int length = str.length();
            int length2 = str2.length();
            if (length == length2) {
                return 0;
            }
            if (length < length2) {
                return -1;
            }
            return 1;
        }
    }

    static {
        a aVar = new a();
        f19445b = aVar;
        f19448c = new TreeMap(aVar);
    }

    private g(String str) {
        str.getClass();
        this.f19505a = str;
    }

    public static synchronized g a(String str) {
        g gVar;
        synchronized (g.class) {
            Map map = f19448c;
            gVar = (g) map.get(str);
            if (gVar == null) {
                gVar = new g(str);
                map.put(str, gVar);
            }
        }
        return gVar;
    }

    static List b(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String a5 : strArr) {
            arrayList.add(a(a5));
        }
        return DesugarCollections.unmodifiableList(arrayList);
    }

    private static g d(String str, int i5) {
        return a(str);
    }

    public String c() {
        return this.f19505a;
    }

    public String toString() {
        return this.f19505a;
    }
}
