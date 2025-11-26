package A0;

import A0.F;
import L0.a;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;

/* renamed from: A0.a  reason: case insensitive filesystem */
public final class C0621a implements a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f1886a = new C0621a();

    /* renamed from: A0.a$a  reason: collision with other inner class name */
    private static final class C0039a implements K0.d {

        /* renamed from: a  reason: collision with root package name */
        static final C0039a f1887a = new C0039a();

        /* renamed from: b  reason: collision with root package name */
        private static final K0.c f1888b = K0.c.d("arch");

        /* renamed from: c  reason: collision with root package name */
        private static final K0.c f1889c = K0.c.d("libraryName");

        /* renamed from: d  reason: collision with root package name */
        private static final K0.c f1890d = K0.c.d("buildId");

        private C0039a() {
        }

        /* renamed from: b */
        public void a(F.a.C0021a aVar, K0.e eVar) {
            eVar.a(f1888b, aVar.b());
            eVar.a(f1889c, aVar.d());
            eVar.a(f1890d, aVar.c());
        }
    }

    /* renamed from: A0.a$b */
    private static final class b implements K0.d {

        /* renamed from: a  reason: collision with root package name */
        static final b f1891a = new b();

        /* renamed from: b  reason: collision with root package name */
        private static final K0.c f1892b = K0.c.d("pid");

        /* renamed from: c  reason: collision with root package name */
        private static final K0.c f1893c = K0.c.d("processName");

        /* renamed from: d  reason: collision with root package name */
        private static final K0.c f1894d = K0.c.d("reasonCode");

        /* renamed from: e  reason: collision with root package name */
        private static final K0.c f1895e = K0.c.d("importance");

        /* renamed from: f  reason: collision with root package name */
        private static final K0.c f1896f = K0.c.d("pss");

        /* renamed from: g  reason: collision with root package name */
        private static final K0.c f1897g = K0.c.d("rss");

        /* renamed from: h  reason: collision with root package name */
        private static final K0.c f1898h = K0.c.d(CampaignEx.JSON_KEY_TIMESTAMP);

        /* renamed from: i  reason: collision with root package name */
        private static final K0.c f1899i = K0.c.d("traceFile");

        /* renamed from: j  reason: collision with root package name */
        private static final K0.c f1900j = K0.c.d("buildIdMappingForArch");

        private b() {
        }

        /* renamed from: b */
        public void a(F.a aVar, K0.e eVar) {
            eVar.d(f1892b, aVar.d());
            eVar.a(f1893c, aVar.e());
            eVar.d(f1894d, aVar.g());
            eVar.d(f1895e, aVar.c());
            eVar.c(f1896f, aVar.f());
            eVar.c(f1897g, aVar.h());
            eVar.c(f1898h, aVar.i());
            eVar.a(f1899i, aVar.j());
            eVar.a(f1900j, aVar.b());
        }
    }

    /* renamed from: A0.a$c */
    private static final class c implements K0.d {

        /* renamed from: a  reason: collision with root package name */
        static final c f1901a = new c();

        /* renamed from: b  reason: collision with root package name */
        private static final K0.c f1902b = K0.c.d("key");

        /* renamed from: c  reason: collision with root package name */
        private static final K0.c f1903c = K0.c.d("value");

        private c() {
        }

        /* renamed from: b */
        public void a(F.c cVar, K0.e eVar) {
            eVar.a(f1902b, cVar.b());
            eVar.a(f1903c, cVar.c());
        }
    }

    /* renamed from: A0.a$d */
    private static final class d implements K0.d {

        /* renamed from: a  reason: collision with root package name */
        static final d f1904a = new d();

        /* renamed from: b  reason: collision with root package name */
        private static final K0.c f1905b = K0.c.d("sdkVersion");

        /* renamed from: c  reason: collision with root package name */
        private static final K0.c f1906c = K0.c.d("gmpAppId");

        /* renamed from: d  reason: collision with root package name */
        private static final K0.c f1907d = K0.c.d("platform");

        /* renamed from: e  reason: collision with root package name */
        private static final K0.c f1908e = K0.c.d("installationUuid");

        /* renamed from: f  reason: collision with root package name */
        private static final K0.c f1909f = K0.c.d("firebaseInstallationId");

        /* renamed from: g  reason: collision with root package name */
        private static final K0.c f1910g = K0.c.d("firebaseAuthenticationToken");

        /* renamed from: h  reason: collision with root package name */
        private static final K0.c f1911h = K0.c.d("appQualitySessionId");

        /* renamed from: i  reason: collision with root package name */
        private static final K0.c f1912i = K0.c.d("buildVersion");

        /* renamed from: j  reason: collision with root package name */
        private static final K0.c f1913j = K0.c.d("displayVersion");

        /* renamed from: k  reason: collision with root package name */
        private static final K0.c f1914k = K0.c.d("session");

        /* renamed from: l  reason: collision with root package name */
        private static final K0.c f1915l = K0.c.d("ndkPayload");

        /* renamed from: m  reason: collision with root package name */
        private static final K0.c f1916m = K0.c.d("appExitInfo");

        private d() {
        }

        /* renamed from: b */
        public void a(F f5, K0.e eVar) {
            eVar.a(f1905b, f5.m());
            eVar.a(f1906c, f5.i());
            eVar.d(f1907d, f5.l());
            eVar.a(f1908e, f5.j());
            eVar.a(f1909f, f5.h());
            eVar.a(f1910g, f5.g());
            eVar.a(f1911h, f5.d());
            eVar.a(f1912i, f5.e());
            eVar.a(f1913j, f5.f());
            eVar.a(f1914k, f5.n());
            eVar.a(f1915l, f5.k());
            eVar.a(f1916m, f5.c());
        }
    }

    /* renamed from: A0.a$e */
    private static final class e implements K0.d {

        /* renamed from: a  reason: collision with root package name */
        static final e f1917a = new e();

        /* renamed from: b  reason: collision with root package name */
        private static final K0.c f1918b = K0.c.d("files");

        /* renamed from: c  reason: collision with root package name */
        private static final K0.c f1919c = K0.c.d("orgId");

        private e() {
        }

        /* renamed from: b */
        public void a(F.d dVar, K0.e eVar) {
            eVar.a(f1918b, dVar.b());
            eVar.a(f1919c, dVar.c());
        }
    }

    /* renamed from: A0.a$f */
    private static final class f implements K0.d {

        /* renamed from: a  reason: collision with root package name */
        static final f f1920a = new f();

        /* renamed from: b  reason: collision with root package name */
        private static final K0.c f1921b = K0.c.d("filename");

        /* renamed from: c  reason: collision with root package name */
        private static final K0.c f1922c = K0.c.d("contents");

        private f() {
        }

        /* renamed from: b */
        public void a(F.d.b bVar, K0.e eVar) {
            eVar.a(f1921b, bVar.c());
            eVar.a(f1922c, bVar.b());
        }
    }

    /* renamed from: A0.a$g */
    private static final class g implements K0.d {

        /* renamed from: a  reason: collision with root package name */
        static final g f1923a = new g();

        /* renamed from: b  reason: collision with root package name */
        private static final K0.c f1924b = K0.c.d("identifier");

        /* renamed from: c  reason: collision with root package name */
        private static final K0.c f1925c = K0.c.d("version");

        /* renamed from: d  reason: collision with root package name */
        private static final K0.c f1926d = K0.c.d("displayVersion");

        /* renamed from: e  reason: collision with root package name */
        private static final K0.c f1927e = K0.c.d("organization");

        /* renamed from: f  reason: collision with root package name */
        private static final K0.c f1928f = K0.c.d("installationUuid");

        /* renamed from: g  reason: collision with root package name */
        private static final K0.c f1929g = K0.c.d("developmentPlatform");

        /* renamed from: h  reason: collision with root package name */
        private static final K0.c f1930h = K0.c.d("developmentPlatformVersion");

        private g() {
        }

        /* renamed from: b */
        public void a(F.e.a aVar, K0.e eVar) {
            eVar.a(f1924b, aVar.e());
            eVar.a(f1925c, aVar.h());
            eVar.a(f1926d, aVar.d());
            K0.c cVar = f1927e;
            aVar.g();
            eVar.a(cVar, (Object) null);
            eVar.a(f1928f, aVar.f());
            eVar.a(f1929g, aVar.b());
            eVar.a(f1930h, aVar.c());
        }
    }

    /* renamed from: A0.a$h */
    private static final class h implements K0.d {

        /* renamed from: a  reason: collision with root package name */
        static final h f1931a = new h();

        /* renamed from: b  reason: collision with root package name */
        private static final K0.c f1932b = K0.c.d("clsId");

        private h() {
        }

        public /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
            android.support.v4.media.a.a(obj);
            b((F.e.a.b) null, (K0.e) obj2);
        }

        public void b(F.e.a.b bVar, K0.e eVar) {
            throw null;
        }
    }

    /* renamed from: A0.a$i */
    private static final class i implements K0.d {

        /* renamed from: a  reason: collision with root package name */
        static final i f1933a = new i();

        /* renamed from: b  reason: collision with root package name */
        private static final K0.c f1934b = K0.c.d("arch");

        /* renamed from: c  reason: collision with root package name */
        private static final K0.c f1935c = K0.c.d("model");

        /* renamed from: d  reason: collision with root package name */
        private static final K0.c f1936d = K0.c.d("cores");

        /* renamed from: e  reason: collision with root package name */
        private static final K0.c f1937e = K0.c.d("ram");

        /* renamed from: f  reason: collision with root package name */
        private static final K0.c f1938f = K0.c.d("diskSpace");

        /* renamed from: g  reason: collision with root package name */
        private static final K0.c f1939g = K0.c.d("simulator");

        /* renamed from: h  reason: collision with root package name */
        private static final K0.c f1940h = K0.c.d(MRAIDCommunicatorUtil.KEY_STATE);

        /* renamed from: i  reason: collision with root package name */
        private static final K0.c f1941i = K0.c.d("manufacturer");

        /* renamed from: j  reason: collision with root package name */
        private static final K0.c f1942j = K0.c.d("modelClass");

        private i() {
        }

        /* renamed from: b */
        public void a(F.e.c cVar, K0.e eVar) {
            eVar.d(f1934b, cVar.b());
            eVar.a(f1935c, cVar.f());
            eVar.d(f1936d, cVar.c());
            eVar.c(f1937e, cVar.h());
            eVar.c(f1938f, cVar.d());
            eVar.g(f1939g, cVar.j());
            eVar.d(f1940h, cVar.i());
            eVar.a(f1941i, cVar.e());
            eVar.a(f1942j, cVar.g());
        }
    }

    /* renamed from: A0.a$j */
    private static final class j implements K0.d {

        /* renamed from: a  reason: collision with root package name */
        static final j f1943a = new j();

        /* renamed from: b  reason: collision with root package name */
        private static final K0.c f1944b = K0.c.d("generator");

        /* renamed from: c  reason: collision with root package name */
        private static final K0.c f1945c = K0.c.d("identifier");

        /* renamed from: d  reason: collision with root package name */
        private static final K0.c f1946d = K0.c.d("appQualitySessionId");

        /* renamed from: e  reason: collision with root package name */
        private static final K0.c f1947e = K0.c.d("startedAt");

        /* renamed from: f  reason: collision with root package name */
        private static final K0.c f1948f = K0.c.d("endedAt");

        /* renamed from: g  reason: collision with root package name */
        private static final K0.c f1949g = K0.c.d("crashed");

        /* renamed from: h  reason: collision with root package name */
        private static final K0.c f1950h = K0.c.d(MBridgeConstans.DYNAMIC_VIEW_WX_APP);

        /* renamed from: i  reason: collision with root package name */
        private static final K0.c f1951i = K0.c.d("user");

        /* renamed from: j  reason: collision with root package name */
        private static final K0.c f1952j = K0.c.d("os");

        /* renamed from: k  reason: collision with root package name */
        private static final K0.c f1953k = K0.c.d("device");

        /* renamed from: l  reason: collision with root package name */
        private static final K0.c f1954l = K0.c.d("events");

        /* renamed from: m  reason: collision with root package name */
        private static final K0.c f1955m = K0.c.d("generatorType");

        private j() {
        }

        /* renamed from: b */
        public void a(F.e eVar, K0.e eVar2) {
            eVar2.a(f1944b, eVar.g());
            eVar2.a(f1945c, eVar.j());
            eVar2.a(f1946d, eVar.c());
            eVar2.c(f1947e, eVar.l());
            eVar2.a(f1948f, eVar.e());
            eVar2.g(f1949g, eVar.n());
            eVar2.a(f1950h, eVar.b());
            eVar2.a(f1951i, eVar.m());
            eVar2.a(f1952j, eVar.k());
            eVar2.a(f1953k, eVar.d());
            eVar2.a(f1954l, eVar.f());
            eVar2.d(f1955m, eVar.h());
        }
    }

    /* renamed from: A0.a$k */
    private static final class k implements K0.d {

        /* renamed from: a  reason: collision with root package name */
        static final k f1956a = new k();

        /* renamed from: b  reason: collision with root package name */
        private static final K0.c f1957b = K0.c.d("execution");

        /* renamed from: c  reason: collision with root package name */
        private static final K0.c f1958c = K0.c.d("customAttributes");

        /* renamed from: d  reason: collision with root package name */
        private static final K0.c f1959d = K0.c.d("internalKeys");

        /* renamed from: e  reason: collision with root package name */
        private static final K0.c f1960e = K0.c.d("background");

        /* renamed from: f  reason: collision with root package name */
        private static final K0.c f1961f = K0.c.d("currentProcessDetails");

        /* renamed from: g  reason: collision with root package name */
        private static final K0.c f1962g = K0.c.d("appProcessDetails");

        /* renamed from: h  reason: collision with root package name */
        private static final K0.c f1963h = K0.c.d("uiOrientation");

        private k() {
        }

        /* renamed from: b */
        public void a(F.e.d.a aVar, K0.e eVar) {
            eVar.a(f1957b, aVar.f());
            eVar.a(f1958c, aVar.e());
            eVar.a(f1959d, aVar.g());
            eVar.a(f1960e, aVar.c());
            eVar.a(f1961f, aVar.d());
            eVar.a(f1962g, aVar.b());
            eVar.d(f1963h, aVar.h());
        }
    }

    /* renamed from: A0.a$l */
    private static final class l implements K0.d {

        /* renamed from: a  reason: collision with root package name */
        static final l f1964a = new l();

        /* renamed from: b  reason: collision with root package name */
        private static final K0.c f1965b = K0.c.d("baseAddress");

        /* renamed from: c  reason: collision with root package name */
        private static final K0.c f1966c = K0.c.d("size");

        /* renamed from: d  reason: collision with root package name */
        private static final K0.c f1967d = K0.c.d(RewardPlus.NAME);

        /* renamed from: e  reason: collision with root package name */
        private static final K0.c f1968e = K0.c.d("uuid");

        private l() {
        }

        /* renamed from: b */
        public void a(F.e.d.a.b.C0025a aVar, K0.e eVar) {
            eVar.c(f1965b, aVar.b());
            eVar.c(f1966c, aVar.d());
            eVar.a(f1967d, aVar.c());
            eVar.a(f1968e, aVar.f());
        }
    }

    /* renamed from: A0.a$m */
    private static final class m implements K0.d {

        /* renamed from: a  reason: collision with root package name */
        static final m f1969a = new m();

        /* renamed from: b  reason: collision with root package name */
        private static final K0.c f1970b = K0.c.d("threads");

        /* renamed from: c  reason: collision with root package name */
        private static final K0.c f1971c = K0.c.d("exception");

        /* renamed from: d  reason: collision with root package name */
        private static final K0.c f1972d = K0.c.d("appExitInfo");

        /* renamed from: e  reason: collision with root package name */
        private static final K0.c f1973e = K0.c.d("signal");

        /* renamed from: f  reason: collision with root package name */
        private static final K0.c f1974f = K0.c.d("binaries");

        private m() {
        }

        /* renamed from: b */
        public void a(F.e.d.a.b bVar, K0.e eVar) {
            eVar.a(f1970b, bVar.f());
            eVar.a(f1971c, bVar.d());
            eVar.a(f1972d, bVar.b());
            eVar.a(f1973e, bVar.e());
            eVar.a(f1974f, bVar.c());
        }
    }

    /* renamed from: A0.a$n */
    private static final class n implements K0.d {

        /* renamed from: a  reason: collision with root package name */
        static final n f1975a = new n();

        /* renamed from: b  reason: collision with root package name */
        private static final K0.c f1976b = K0.c.d(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);

        /* renamed from: c  reason: collision with root package name */
        private static final K0.c f1977c = K0.c.d("reason");

        /* renamed from: d  reason: collision with root package name */
        private static final K0.c f1978d = K0.c.d(com.mbridge.msdk.foundation.entity.b.JSON_KEY_FRAME_ADS);

        /* renamed from: e  reason: collision with root package name */
        private static final K0.c f1979e = K0.c.d("causedBy");

        /* renamed from: f  reason: collision with root package name */
        private static final K0.c f1980f = K0.c.d("overflowCount");

        private n() {
        }

        /* renamed from: b */
        public void a(F.e.d.a.b.c cVar, K0.e eVar) {
            eVar.a(f1976b, cVar.f());
            eVar.a(f1977c, cVar.e());
            eVar.a(f1978d, cVar.c());
            eVar.a(f1979e, cVar.b());
            eVar.d(f1980f, cVar.d());
        }
    }

    /* renamed from: A0.a$o */
    private static final class o implements K0.d {

        /* renamed from: a  reason: collision with root package name */
        static final o f1981a = new o();

        /* renamed from: b  reason: collision with root package name */
        private static final K0.c f1982b = K0.c.d(RewardPlus.NAME);

        /* renamed from: c  reason: collision with root package name */
        private static final K0.c f1983c = K0.c.d("code");

        /* renamed from: d  reason: collision with root package name */
        private static final K0.c f1984d = K0.c.d("address");

        private o() {
        }

        /* renamed from: b */
        public void a(F.e.d.a.b.C0029d dVar, K0.e eVar) {
            eVar.a(f1982b, dVar.d());
            eVar.a(f1983c, dVar.c());
            eVar.c(f1984d, dVar.b());
        }
    }

    /* renamed from: A0.a$p */
    private static final class p implements K0.d {

        /* renamed from: a  reason: collision with root package name */
        static final p f1985a = new p();

        /* renamed from: b  reason: collision with root package name */
        private static final K0.c f1986b = K0.c.d(RewardPlus.NAME);

        /* renamed from: c  reason: collision with root package name */
        private static final K0.c f1987c = K0.c.d("importance");

        /* renamed from: d  reason: collision with root package name */
        private static final K0.c f1988d = K0.c.d(com.mbridge.msdk.foundation.entity.b.JSON_KEY_FRAME_ADS);

        private p() {
        }

        /* renamed from: b */
        public void a(F.e.d.a.b.C0031e eVar, K0.e eVar2) {
            eVar2.a(f1986b, eVar.d());
            eVar2.d(f1987c, eVar.c());
            eVar2.a(f1988d, eVar.b());
        }
    }

    /* renamed from: A0.a$q */
    private static final class q implements K0.d {

        /* renamed from: a  reason: collision with root package name */
        static final q f1989a = new q();

        /* renamed from: b  reason: collision with root package name */
        private static final K0.c f1990b = K0.c.d("pc");

        /* renamed from: c  reason: collision with root package name */
        private static final K0.c f1991c = K0.c.d("symbol");

        /* renamed from: d  reason: collision with root package name */
        private static final K0.c f1992d = K0.c.d("file");

        /* renamed from: e  reason: collision with root package name */
        private static final K0.c f1993e = K0.c.d(TypedValues.CycleType.S_WAVE_OFFSET);

        /* renamed from: f  reason: collision with root package name */
        private static final K0.c f1994f = K0.c.d("importance");

        private q() {
        }

        /* renamed from: b */
        public void a(F.e.d.a.b.C0031e.C0033b bVar, K0.e eVar) {
            eVar.c(f1990b, bVar.e());
            eVar.a(f1991c, bVar.f());
            eVar.a(f1992d, bVar.b());
            eVar.c(f1993e, bVar.d());
            eVar.d(f1994f, bVar.c());
        }
    }

    /* renamed from: A0.a$r */
    private static final class r implements K0.d {

        /* renamed from: a  reason: collision with root package name */
        static final r f1995a = new r();

        /* renamed from: b  reason: collision with root package name */
        private static final K0.c f1996b = K0.c.d("processName");

        /* renamed from: c  reason: collision with root package name */
        private static final K0.c f1997c = K0.c.d("pid");

        /* renamed from: d  reason: collision with root package name */
        private static final K0.c f1998d = K0.c.d("importance");

        /* renamed from: e  reason: collision with root package name */
        private static final K0.c f1999e = K0.c.d("defaultProcess");

        private r() {
        }

        /* renamed from: b */
        public void a(F.e.d.a.c cVar, K0.e eVar) {
            eVar.a(f1996b, cVar.d());
            eVar.d(f1997c, cVar.c());
            eVar.d(f1998d, cVar.b());
            eVar.g(f1999e, cVar.e());
        }
    }

    /* renamed from: A0.a$s */
    private static final class s implements K0.d {

        /* renamed from: a  reason: collision with root package name */
        static final s f2000a = new s();

        /* renamed from: b  reason: collision with root package name */
        private static final K0.c f2001b = K0.c.d("batteryLevel");

        /* renamed from: c  reason: collision with root package name */
        private static final K0.c f2002c = K0.c.d("batteryVelocity");

        /* renamed from: d  reason: collision with root package name */
        private static final K0.c f2003d = K0.c.d("proximityOn");

        /* renamed from: e  reason: collision with root package name */
        private static final K0.c f2004e = K0.c.d("orientation");

        /* renamed from: f  reason: collision with root package name */
        private static final K0.c f2005f = K0.c.d("ramUsed");

        /* renamed from: g  reason: collision with root package name */
        private static final K0.c f2006g = K0.c.d("diskUsed");

        private s() {
        }

        /* renamed from: b */
        public void a(F.e.d.c cVar, K0.e eVar) {
            eVar.a(f2001b, cVar.b());
            eVar.d(f2002c, cVar.c());
            eVar.g(f2003d, cVar.g());
            eVar.d(f2004e, cVar.e());
            eVar.c(f2005f, cVar.f());
            eVar.c(f2006g, cVar.d());
        }
    }

    /* renamed from: A0.a$t */
    private static final class t implements K0.d {

        /* renamed from: a  reason: collision with root package name */
        static final t f2007a = new t();

        /* renamed from: b  reason: collision with root package name */
        private static final K0.c f2008b = K0.c.d(CampaignEx.JSON_KEY_TIMESTAMP);

        /* renamed from: c  reason: collision with root package name */
        private static final K0.c f2009c = K0.c.d(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);

        /* renamed from: d  reason: collision with root package name */
        private static final K0.c f2010d = K0.c.d(MBridgeConstans.DYNAMIC_VIEW_WX_APP);

        /* renamed from: e  reason: collision with root package name */
        private static final K0.c f2011e = K0.c.d("device");

        /* renamed from: f  reason: collision with root package name */
        private static final K0.c f2012f = K0.c.d("log");

        /* renamed from: g  reason: collision with root package name */
        private static final K0.c f2013g = K0.c.d("rollouts");

        private t() {
        }

        /* renamed from: b */
        public void a(F.e.d dVar, K0.e eVar) {
            eVar.c(f2008b, dVar.f());
            eVar.a(f2009c, dVar.g());
            eVar.a(f2010d, dVar.b());
            eVar.a(f2011e, dVar.c());
            eVar.a(f2012f, dVar.d());
            eVar.a(f2013g, dVar.e());
        }
    }

    /* renamed from: A0.a$u */
    private static final class u implements K0.d {

        /* renamed from: a  reason: collision with root package name */
        static final u f2014a = new u();

        /* renamed from: b  reason: collision with root package name */
        private static final K0.c f2015b = K0.c.d("content");

        private u() {
        }

        /* renamed from: b */
        public void a(F.e.d.C0036d dVar, K0.e eVar) {
            eVar.a(f2015b, dVar.b());
        }
    }

    /* renamed from: A0.a$v */
    private static final class v implements K0.d {

        /* renamed from: a  reason: collision with root package name */
        static final v f2016a = new v();

        /* renamed from: b  reason: collision with root package name */
        private static final K0.c f2017b = K0.c.d("rolloutVariant");

        /* renamed from: c  reason: collision with root package name */
        private static final K0.c f2018c = K0.c.d("parameterKey");

        /* renamed from: d  reason: collision with root package name */
        private static final K0.c f2019d = K0.c.d("parameterValue");

        /* renamed from: e  reason: collision with root package name */
        private static final K0.c f2020e = K0.c.d("templateVersion");

        private v() {
        }

        /* renamed from: b */
        public void a(F.e.d.C0037e eVar, K0.e eVar2) {
            eVar2.a(f2017b, eVar.d());
            eVar2.a(f2018c, eVar.b());
            eVar2.a(f2019d, eVar.c());
            eVar2.c(f2020e, eVar.e());
        }
    }

    /* renamed from: A0.a$w */
    private static final class w implements K0.d {

        /* renamed from: a  reason: collision with root package name */
        static final w f2021a = new w();

        /* renamed from: b  reason: collision with root package name */
        private static final K0.c f2022b = K0.c.d("rolloutId");

        /* renamed from: c  reason: collision with root package name */
        private static final K0.c f2023c = K0.c.d("variantId");

        private w() {
        }

        /* renamed from: b */
        public void a(F.e.d.C0037e.b bVar, K0.e eVar) {
            eVar.a(f2022b, bVar.b());
            eVar.a(f2023c, bVar.c());
        }
    }

    /* renamed from: A0.a$x */
    private static final class x implements K0.d {

        /* renamed from: a  reason: collision with root package name */
        static final x f2024a = new x();

        /* renamed from: b  reason: collision with root package name */
        private static final K0.c f2025b = K0.c.d("assignments");

        private x() {
        }

        /* renamed from: b */
        public void a(F.e.d.f fVar, K0.e eVar) {
            eVar.a(f2025b, fVar.b());
        }
    }

    /* renamed from: A0.a$y */
    private static final class y implements K0.d {

        /* renamed from: a  reason: collision with root package name */
        static final y f2026a = new y();

        /* renamed from: b  reason: collision with root package name */
        private static final K0.c f2027b = K0.c.d("platform");

        /* renamed from: c  reason: collision with root package name */
        private static final K0.c f2028c = K0.c.d("version");

        /* renamed from: d  reason: collision with root package name */
        private static final K0.c f2029d = K0.c.d("buildVersion");

        /* renamed from: e  reason: collision with root package name */
        private static final K0.c f2030e = K0.c.d("jailbroken");

        private y() {
        }

        /* renamed from: b */
        public void a(F.e.C0038e eVar, K0.e eVar2) {
            eVar2.d(f2027b, eVar.c());
            eVar2.a(f2028c, eVar.d());
            eVar2.a(f2029d, eVar.b());
            eVar2.g(f2030e, eVar.e());
        }
    }

    /* renamed from: A0.a$z */
    private static final class z implements K0.d {

        /* renamed from: a  reason: collision with root package name */
        static final z f2031a = new z();

        /* renamed from: b  reason: collision with root package name */
        private static final K0.c f2032b = K0.c.d("identifier");

        private z() {
        }

        /* renamed from: b */
        public void a(F.e.f fVar, K0.e eVar) {
            eVar.a(f2032b, fVar.b());
        }
    }

    private C0621a() {
    }

    public void a(L0.b bVar) {
        d dVar = d.f1904a;
        bVar.a(F.class, dVar);
        bVar.a(C0622b.class, dVar);
        j jVar = j.f1943a;
        bVar.a(F.e.class, jVar);
        bVar.a(h.class, jVar);
        g gVar = g.f1923a;
        bVar.a(F.e.a.class, gVar);
        bVar.a(i.class, gVar);
        h hVar = h.f1931a;
        bVar.a(F.e.a.b.class, hVar);
        bVar.a(j.class, hVar);
        z zVar = z.f2031a;
        bVar.a(F.e.f.class, zVar);
        bVar.a(A.class, zVar);
        y yVar = y.f2026a;
        bVar.a(F.e.C0038e.class, yVar);
        bVar.a(z.class, yVar);
        i iVar = i.f1933a;
        bVar.a(F.e.c.class, iVar);
        bVar.a(k.class, iVar);
        t tVar = t.f2007a;
        bVar.a(F.e.d.class, tVar);
        bVar.a(l.class, tVar);
        k kVar = k.f1956a;
        bVar.a(F.e.d.a.class, kVar);
        bVar.a(m.class, kVar);
        m mVar = m.f1969a;
        bVar.a(F.e.d.a.b.class, mVar);
        bVar.a(n.class, mVar);
        p pVar = p.f1985a;
        bVar.a(F.e.d.a.b.C0031e.class, pVar);
        bVar.a(r.class, pVar);
        q qVar = q.f1989a;
        bVar.a(F.e.d.a.b.C0031e.C0033b.class, qVar);
        bVar.a(s.class, qVar);
        n nVar = n.f1975a;
        bVar.a(F.e.d.a.b.c.class, nVar);
        bVar.a(p.class, nVar);
        b bVar2 = b.f1891a;
        bVar.a(F.a.class, bVar2);
        bVar.a(C0623c.class, bVar2);
        C0039a aVar = C0039a.f1887a;
        bVar.a(F.a.C0021a.class, aVar);
        bVar.a(C0624d.class, aVar);
        o oVar = o.f1981a;
        bVar.a(F.e.d.a.b.C0029d.class, oVar);
        bVar.a(q.class, oVar);
        l lVar = l.f1964a;
        bVar.a(F.e.d.a.b.C0025a.class, lVar);
        bVar.a(o.class, lVar);
        c cVar = c.f1901a;
        bVar.a(F.c.class, cVar);
        bVar.a(C0625e.class, cVar);
        r rVar = r.f1995a;
        bVar.a(F.e.d.a.c.class, rVar);
        bVar.a(t.class, rVar);
        s sVar = s.f2000a;
        bVar.a(F.e.d.c.class, sVar);
        bVar.a(u.class, sVar);
        u uVar = u.f2014a;
        bVar.a(F.e.d.C0036d.class, uVar);
        bVar.a(v.class, uVar);
        x xVar = x.f2024a;
        bVar.a(F.e.d.f.class, xVar);
        bVar.a(y.class, xVar);
        v vVar = v.f2016a;
        bVar.a(F.e.d.C0037e.class, vVar);
        bVar.a(w.class, vVar);
        w wVar = w.f2021a;
        bVar.a(F.e.d.C0037e.b.class, wVar);
        bVar.a(x.class, wVar);
        e eVar = e.f1917a;
        bVar.a(F.d.class, eVar);
        bVar.a(C0626f.class, eVar);
        f fVar = f.f1920a;
        bVar.a(F.d.b.class, fVar);
        bVar.a(C0627g.class, fVar);
    }
}
