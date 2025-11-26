package R3;

import H2.d;
import S3.a;
import S3.c;
import S3.e;
import S3.f;
import S3.g;
import S3.i;
import S3.k;
import S3.l;
import S3.m;
import S3.n;
import S3.o;
import S3.p;
import S3.q;
import X2.C2242i;
import com.inmobi.cmp.core.model.Vector;
import com.inmobi.cmp.model.ChoiceError;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.t;
import r4.b;

public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f19016a = {1, 2, 3, 4};

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f19017b = {5};

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f19018c = {6};

    /* renamed from: d  reason: collision with root package name */
    public static boolean f19019d;

    public static h a(String str) {
        t.e(str, TtmlNode.TAG_REGION);
        String lowerCase = str.toLowerCase(Locale.ROOT);
        t.d(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        switch (lowerCase.hashCode()) {
            case 3166:
                if (lowerCase.equals(DownloadCommon.DOWNLOAD_REPORT_CANCEL)) {
                    return h.f18998a;
                }
                break;
            case 3180:
                if (lowerCase.equals("co")) {
                    return h.f18999b;
                }
                break;
            case 3185:
                if (lowerCase.equals("ct")) {
                    return h.f19000c;
                }
                break;
            case 3201:
                if (lowerCase.equals(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_ERROR)) {
                    return h.f19007j;
                }
                break;
            case 3270:
                if (lowerCase.equals("fl")) {
                    return h.f19003f;
                }
                break;
            case 3352:
                if (lowerCase.equals("ia")) {
                    return h.f19008k;
                }
                break;
            case 3495:
                if (lowerCase.equals("mt")) {
                    return h.f19004g;
                }
                break;
            case 3511:
                if (lowerCase.equals("ne")) {
                    return h.f19009l;
                }
                break;
            case 3514:
                if (lowerCase.equals("nh")) {
                    return h.f19010m;
                }
                break;
            case 3516:
                if (lowerCase.equals("nj")) {
                    return h.f19011n;
                }
                break;
            case 3555:
                if (lowerCase.equals("or")) {
                    return h.f19005h;
                }
                break;
            case 3706:
                if (lowerCase.equals("tn")) {
                    return h.f19012o;
                }
                break;
            case 3716:
                if (lowerCase.equals("tx")) {
                    return h.f19006i;
                }
                break;
            case 3743:
                if (lowerCase.equals("ut")) {
                    return h.f19001d;
                }
                break;
            case 3755:
                if (lowerCase.equals("va")) {
                    return h.f19002e;
                }
                break;
        }
        return h.f19013p;
    }

    public static String b(h hVar) {
        t.e(hVar, MRAIDCommunicatorUtil.KEY_STATE);
        switch (hVar.ordinal()) {
            case 0:
                return DownloadCommon.DOWNLOAD_REPORT_CANCEL;
            case 1:
                return "co";
            case 2:
                return "ct";
            case 3:
                return "ut";
            case 4:
                return "va";
            case 5:
                return "fl";
            case 6:
                return "mt";
            case 7:
                return "or";
            case 8:
                return "tx";
            case 9:
                return DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_ERROR;
            case 10:
                return "ia";
            case 11:
                return "ne";
            case 12:
                return "nh";
            case 13:
                return "nj";
            case 14:
                return "tn";
            default:
                return "";
        }
    }

    public static void c(a aVar) {
        t.e(aVar, "mspaConfig");
        if (!f19019d) {
            d(aVar);
            List list = aVar.f18959d;
            if (list != null) {
                boolean z4 = f19019d;
                i iVar = i.f19015a;
                t.e(list, "mspaPurpose");
                t.e(iVar, "completion");
                i iVar2 = e.f18981c;
                if (iVar2 != null) {
                    iVar2.f(list, z4, new d(iVar));
                    return;
                }
                d.c((String) null, ChoiceError.UNEXPECTED_ERROR_OCCURRED.getMessage(), (Exception) null, Boolean.TRUE, 5);
                iVar.invoke((Object) null);
            }
        }
    }

    public static void d(a aVar) {
        i iVar;
        List list;
        Object obj;
        List<g> list2;
        List<f> list3;
        t.e(aVar, "config");
        if (!e.f18983e) {
            t.e(aVar, "mspaConfig");
            if ((e.c() && e.f18984f == J2.i.NATIONAL) || (t.a(e.a().k(b.SAVED_MSPA_JURISDICTION), "STATE_AND_NATIONAL") && e.f18984f == J2.i.STATE_AND_NATIONAL && a(e.a().k(b.SAVED_REGION)) == e.b())) {
                Vector l5 = e.a().l(b.MSPA_PURPOSE_CONSENT);
                if (!(l5 == null || (list3 = aVar.f18959d) == null)) {
                    for (f fVar : list3) {
                        Integer num = fVar.f18985a;
                        if (num != null) {
                            int intValue = num.intValue();
                            if (l5.contains(intValue)) {
                                fVar.f18987c = l5.get(intValue);
                            }
                        }
                    }
                }
                Vector l6 = e.a().l(b.MSPA_SENSITIVE_PURPOSE_CONSENT);
                if (!(l6 == null || (list = aVar.f18959d) == null)) {
                    Iterator it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        Integer num2 = ((f) obj).f18985a;
                        int Q4 = C2242i.Q(f19017b);
                        if (num2 != null && num2.intValue() == Q4) {
                            break;
                        }
                    }
                    f fVar2 = (f) obj;
                    if (!(fVar2 == null || (list2 = fVar2.f18990f) == null)) {
                        for (g gVar : list2) {
                            Integer num3 = gVar.f18993b;
                            if (num3 != null) {
                                int intValue2 = num3.intValue();
                                if (l6.contains(intValue2)) {
                                    gVar.f18995d = l6.get(intValue2);
                                }
                            }
                        }
                    }
                }
            }
            switch (e.b().ordinal()) {
                case 0:
                    iVar = new a();
                    break;
                case 1:
                    iVar = new S3.b();
                    break;
                case 2:
                    iVar = new c();
                    break;
                case 3:
                    iVar = new p();
                    break;
                case 4:
                    iVar = new q();
                    break;
                case 5:
                    iVar = new e();
                    break;
                case 6:
                    iVar = new g();
                    break;
                case 7:
                    iVar = new m();
                    break;
                case 8:
                    iVar = new o();
                    break;
                case 9:
                    iVar = new S3.d();
                    break;
                case 10:
                    iVar = new f();
                    break;
                case 11:
                    iVar = new S3.j();
                    break;
                case 12:
                    iVar = new k();
                    break;
                case 13:
                    iVar = new l();
                    break;
                case 14:
                    iVar = new n();
                    break;
                default:
                    iVar = new i();
                    break;
            }
            t.e(iVar, "<set-?>");
            e.f18981c = iVar;
            e.f18983e = true;
        }
    }
}
