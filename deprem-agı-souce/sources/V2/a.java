package V2;

import R3.f;
import R3.j;
import T3.k;
import X2.C2250q;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import k4.h;
import kotlin.jvm.internal.t;
import r4.b;
import s4.c;
import t3.s;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f19696a;

    public static String a(h hVar, r4.a aVar) {
        k kVar;
        t.e(hVar, "regulation");
        t.e(aVar, "sharedStorage");
        int ordinal = hVar.ordinal();
        if (ordinal == 0) {
            t.e(aVar, "storage");
            b bVar = b.CCPA_SHOWN;
            aVar.getClass();
            t.e(bVar, "preferenceKey");
            if (aVar.f25721a.getBoolean("CCPAShown", false)) {
                t.e(aVar, "storage");
                t.e(b.CCPA_CONSENT_EXPLICITLY, "preferenceKey");
                if (aVar.f25721a.getBoolean("CCPAConsentGivenExplicitly", false)) {
                    t.e(aVar, "storage");
                    if (t.a(aVar.b(2, 3), "Y")) {
                        kVar = k.YES;
                    } else {
                        kVar = k.NO;
                    }
                    t.e(kVar, "value");
                    if (kVar == k.YES) {
                        return "Reject";
                    }
                }
            }
            return "All";
        } else if (ordinal == 1) {
            t.e(aVar, "storage");
            String k5 = aVar.k(b.GDPR_STATUS);
            if (k5.length() != 0) {
                return k5;
            }
            t.e(aVar, "storage");
            t.e(b.GDPR_SHOWN, "preferenceKey");
            if (aVar.f25721a.getBoolean("GDPRShown", false)) {
                return "Bounce";
            }
            return "NA";
        } else if (ordinal != 2) {
            return null;
        } else {
            if (!j.f19019d) {
                return b().f24560a;
            }
            t.e(aVar, "storage");
            b bVar2 = b.MSPA_CONSENT_EXPLICITLY;
            aVar.getClass();
            t.e(bVar2, "preferenceKey");
            if (!aVar.f25721a.getBoolean("MSPAConsentGivenExplicitly", false)) {
                return b().f24560a;
            }
            t.e(aVar, "storage");
            return aVar.k(b.MSPA_STATUS);
        }
    }

    public static k4.b b() {
        k4.b bVar;
        List list = c.h().f18959d;
        if (list == null) {
            bVar = null;
        } else {
            if (!list.isEmpty()) {
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (!t.a(((f) it.next()).f18986b, Boolean.FALSE)) {
                        if (!list.isEmpty()) {
                            Iterator it2 = list.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    if (!t.a(((f) it2.next()).f18986b, Boolean.TRUE)) {
                                        bVar = k4.b.ACCEPT_PARTIAL;
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        }
                        bVar = k4.b.REJECT;
                    }
                }
            }
            bVar = k4.b.ACCEPT_ALL;
        }
        if (bVar == null) {
            return k4.b.NA;
        }
        return bVar;
    }

    public static String c() {
        String str = f19696a;
        if (str != null) {
            return str;
        }
        String str2 = c.j().f19281b.f19250o;
        if (t.a(str2, "autoDetectedLanguage")) {
            Locale a5 = c.a();
            String lowerCase = (a5.getLanguage() + '-' + a5.getCountry()).toLowerCase(a5);
            t.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            List list = c.j().f19281b.f19235Z;
            String lowerCase2 = ((String) C2250q.M(s.G0(lowerCase, new String[]{"-"}, false, 0, 6, (Object) null))).toLowerCase(Locale.ROOT);
            t.d(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            if (list.contains(lowerCase)) {
                str2 = lowerCase;
            } else if (list.contains(lowerCase2)) {
                str2 = lowerCase2;
            } else {
                str2 = "en";
            }
        }
        t.e(str2, "<set-?>");
        f19696a = str2;
        if (str2 != null) {
            return str2;
        }
        t.w("_lang");
        return null;
    }

    public static boolean d() {
        return t.a(c.j().f19281b.f19231V.f19263b, Boolean.TRUE);
    }

    public static boolean e() {
        if (!t.a(c.j().f19281b.f19231V.f19264c, Boolean.TRUE)) {
            return false;
        }
        List list = c.j().f19281b.f19233X.f19208a;
        String upperCase = c.f25866n.toUpperCase(Locale.ROOT);
        t.d(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        if (list.contains(upperCase)) {
            return true;
        }
        return false;
    }
}
