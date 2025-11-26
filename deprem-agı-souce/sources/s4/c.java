package s4;

import J2.u;
import T3.i;
import T3.j;
import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import androidx.core.os.ConfigurationCompat;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.data.model.ChoiceColor;
import com.inmobi.cmp.data.model.ChoiceStyle;
import com.inmobi.cmp.data.model.ThemeMode;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Locale;
import k1.C1703a;
import k4.l;
import m4.d;
import m4.g;
import n4.a;
import n4.h;
import o4.B;
import o4.C2707b;
import o4.C2708c;
import o4.C2711f;
import o4.D;
import o4.k;
import o4.m;
import o4.o;
import o4.p;
import o4.r;
import o4.t;
import o4.v;

public abstract class c {

    /* renamed from: A  reason: collision with root package name */
    public static r f25851A;

    /* renamed from: B  reason: collision with root package name */
    public static D f25852B;

    /* renamed from: a  reason: collision with root package name */
    public static Application f25853a;

    /* renamed from: b  reason: collision with root package name */
    public static a f25854b;

    /* renamed from: c  reason: collision with root package name */
    public static ChoiceStyle f25855c = new ChoiceStyle();

    /* renamed from: d  reason: collision with root package name */
    public static m4.c f25856d;

    /* renamed from: e  reason: collision with root package name */
    public static d f25857e;

    /* renamed from: f  reason: collision with root package name */
    public static u f25858f;

    /* renamed from: g  reason: collision with root package name */
    public static i f25859g;

    /* renamed from: h  reason: collision with root package name */
    public static r4.a f25860h;

    /* renamed from: i  reason: collision with root package name */
    public static h f25861i;

    /* renamed from: j  reason: collision with root package name */
    public static l f25862j;

    /* renamed from: k  reason: collision with root package name */
    public static R2.c f25863k;

    /* renamed from: l  reason: collision with root package name */
    public static R3.a f25864l;

    /* renamed from: m  reason: collision with root package name */
    public static String f25865m = "";

    /* renamed from: n  reason: collision with root package name */
    public static String f25866n = "";

    /* renamed from: o  reason: collision with root package name */
    public static C1703a f25867o;

    /* renamed from: p  reason: collision with root package name */
    public static q4.c f25868p;

    /* renamed from: q  reason: collision with root package name */
    public static B f25869q;

    /* renamed from: r  reason: collision with root package name */
    public static C2711f f25870r;

    /* renamed from: s  reason: collision with root package name */
    public static m f25871s;

    /* renamed from: t  reason: collision with root package name */
    public static p f25872t;

    /* renamed from: u  reason: collision with root package name */
    public static C2708c f25873u;

    /* renamed from: v  reason: collision with root package name */
    public static k f25874v;

    /* renamed from: w  reason: collision with root package name */
    public static t f25875w;

    /* renamed from: x  reason: collision with root package name */
    public static v f25876x;

    /* renamed from: y  reason: collision with root package name */
    public static o f25877y;

    /* renamed from: z  reason: collision with root package name */
    public static C2707b f25878z;

    public static Locale a() {
        if (f25853a != null) {
            Locale locale = ConfigurationCompat.getLocales(c().getResources().getConfiguration()).get(0);
            if (locale == null) {
                locale = Locale.US;
            }
            kotlin.jvm.internal.t.d(locale, "{\n            Configurat…0] ?: Locale.US\n        }");
            return locale;
        }
        Locale locale2 = Locale.US;
        kotlin.jvm.internal.t.d(locale2, "{\n            Locale.US\n        }");
        return locale2;
    }

    public static C2707b b(Context context) {
        ChoiceColor choiceColor;
        ChoiceColor choiceColor2;
        kotlin.jvm.internal.t.e(context, "context");
        if (f25878z == null) {
            i iVar = f25859g;
            if (iVar == null) {
                kotlin.jvm.internal.t.w("portalConfig");
                iVar = null;
            }
            T3.l lVar = iVar.f19286g;
            if (lVar == null) {
                choiceColor = null;
            } else if (kotlin.jvm.internal.t.a(lVar.f19295a, "LIGHT")) {
                choiceColor = lVar.f19296b;
            } else if (kotlin.jvm.internal.t.a(lVar.f19295a, "DARK")) {
                choiceColor = lVar.f19297c;
            } else {
                ChoiceColor choiceColor3 = lVar.f19296b;
                if (choiceColor3 != null && lVar.f19297c != null) {
                    int i5 = context.getResources().getConfiguration().uiMode & 48;
                    if (i5 == 16) {
                        choiceColor = lVar.f19296b;
                    } else if (i5 == 32) {
                        choiceColor = lVar.f19297c;
                    }
                } else if (choiceColor3 == null) {
                    choiceColor = lVar.f19297c;
                }
                choiceColor = lVar.f19296b;
            }
            if (f25855c.getThemeMode() == ThemeMode.LIGHT) {
                choiceColor2 = f25855c.getLightModeColors();
            } else if (f25855c.getThemeMode() == ThemeMode.DARK) {
                choiceColor2 = f25855c.getDarkModeColors();
            } else {
                if (f25855c.getLightModeColors() != null && f25855c.getDarkModeColors() != null) {
                    int i6 = context.getResources().getConfiguration().uiMode & 48;
                    if (i6 == 16) {
                        choiceColor2 = f25855c.getLightModeColors();
                    } else if (i6 == 32) {
                        choiceColor2 = f25855c.getDarkModeColors();
                    }
                } else if (f25855c.getLightModeColors() == null) {
                    choiceColor2 = f25855c.getDarkModeColors();
                }
                choiceColor2 = f25855c.getLightModeColors();
            }
            f25878z = new C2707b(choiceColor, choiceColor2, new q4.a());
        }
        C2707b bVar = f25878z;
        if (bVar != null) {
            return bVar;
        }
        kotlin.jvm.internal.t.w("choiceStyleSheetRepository");
        return null;
    }

    public static Application c() {
        Application application = f25853a;
        if (application != null) {
            return application;
        }
        kotlin.jvm.internal.t.w(MimeTypes.BASE_TYPE_APPLICATION);
        return null;
    }

    public static m d() {
        if (f25871s == null) {
            f25871s = new m(l(), m(), ChoiceCmp.INSTANCE.getCallback());
        }
        m mVar = f25871s;
        if (mVar != null) {
            return mVar;
        }
        kotlin.jvm.internal.t.w("consentRepository_");
        return null;
    }

    public static R2.c e() {
        R2.c cVar = f25863k;
        if (cVar != null) {
            return cVar;
        }
        return new R2.c();
    }

    public static p f() {
        if (f25872t == null) {
            f25872t = new p(l(), ChoiceCmp.INSTANCE.getCallback());
        }
        p pVar = f25872t;
        if (pVar != null) {
            return pVar;
        }
        kotlin.jvm.internal.t.w("gbcConsentRepository_");
        return null;
    }

    public static C1703a g() {
        if (f25867o == null) {
            f25867o = new C1703a();
        }
        C1703a aVar = f25867o;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.t.w("gppModel");
        return null;
    }

    public static R3.a h() {
        R3.a aVar = f25864l;
        if (aVar != null) {
            return aVar;
        }
        return new R3.a((String) null, (ArrayList) null, 15);
    }

    public static a i() {
        if (f25854b == null) {
            Object systemService = c().getSystemService("connectivity");
            if (systemService != null) {
                f25854b = new a((ConnectivityManager) systemService);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
            }
        }
        a aVar = f25854b;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.t.w("networkUtil_");
        return null;
    }

    public static i j() {
        i iVar = f25859g;
        if (iVar != null) {
            return iVar;
        }
        return new i((j) null, (T3.c) null, (T3.h) null, (g) null, (m4.p) null, (T3.l) null, 0, 255);
    }

    public static h k() {
        if (f25861i == null) {
            f25861i = new h();
        }
        h hVar = f25861i;
        if (hVar != null) {
            return hVar;
        }
        kotlin.jvm.internal.t.w("requestApi_");
        return null;
    }

    public static r4.a l() {
        if (f25860h == null) {
            f25860h = new r4.a(c());
        }
        r4.a aVar = f25860h;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.t.w("storage_");
        return null;
    }

    public static u m() {
        if (f25858f == null) {
            f25858f = new u();
        }
        u uVar = f25858f;
        if (uVar != null) {
            return uVar;
        }
        kotlin.jvm.internal.t.w("tcModel");
        return null;
    }

    public static l n() {
        T3.c cVar;
        if (f25862j == null) {
            u m5 = m();
            ChoiceCmp choiceCmp = ChoiceCmp.INSTANCE;
            i portalConfig$app_release = choiceCmp.getPortalConfig$app_release();
            if (portalConfig$app_release == null) {
                cVar = null;
            } else {
                cVar = portalConfig$app_release.f19281b;
            }
            f25862j = new l(m5, cVar, i(), k(), choiceCmp.getCallback(), l(), choiceCmp.getAppPackageId());
        }
        l lVar = f25862j;
        if (lVar != null) {
            return lVar;
        }
        kotlin.jvm.internal.t.w("tracking");
        return null;
    }

    public static k o() {
        if (f25874v == null) {
            Locale a5 = a();
            a i5 = i();
            r4.a l5 = l();
            h k5 = k();
            if (f25868p == null) {
                f25868p = new q4.c();
            }
            q4.c cVar = f25868p;
            if (cVar == null) {
                kotlin.jvm.internal.t.w("coreUiLabelsResolver");
                cVar = null;
            }
            f25874v = new k(a5, i5, l5, k5, new q4.l(cVar));
        }
        k kVar = f25874v;
        if (kVar != null) {
            return kVar;
        }
        kotlin.jvm.internal.t.w("translationsTextRepository_");
        return null;
    }
}
