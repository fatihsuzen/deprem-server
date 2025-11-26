package R3;

import T3.i;
import kotlin.jvm.internal.t;
import r4.a;
import r4.b;
import s4.c;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    public static i f18979a;

    /* renamed from: b  reason: collision with root package name */
    public static a f18980b;

    /* renamed from: c  reason: collision with root package name */
    public static S3.i f18981c;

    /* renamed from: d  reason: collision with root package name */
    public static h f18982d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f18983e;

    /* renamed from: f  reason: collision with root package name */
    public static J2.i f18984f = J2.i.NATIONAL;

    public static a a() {
        a aVar = f18980b;
        if (aVar != null) {
            return aVar;
        }
        t.w("sharedStorage");
        return null;
    }

    public static h b() {
        h hVar = f18982d;
        if (hVar != null) {
            return hVar;
        }
        h a5 = j.a(c.f25865m);
        i iVar = f18979a;
        i iVar2 = null;
        if (iVar == null) {
            t.w("portalConfig");
            iVar = null;
        }
        if (!t.a(iVar.f19281b.f19219J, "NATIONAL")) {
            i iVar3 = f18979a;
            if (iVar3 == null) {
                t.w("portalConfig");
                iVar3 = null;
            }
            if (!iVar3.f19281b.f19220K || !c()) {
                i iVar4 = f18979a;
                if (iVar4 == null) {
                    t.w("portalConfig");
                    iVar4 = null;
                }
                if (!iVar4.f19281b.f19220K || a5 == h.f19013p || c()) {
                    i iVar5 = f18979a;
                    if (iVar5 != null) {
                        iVar2 = iVar5;
                    } else {
                        t.w("portalConfig");
                    }
                    if (!iVar2.f19281b.f19220K && a5 == h.f19013p && t.a(a().k(b.SAVED_MSPA_JURISDICTION), "STATE_AND_NATIONAL")) {
                        a5 = j.a(a().k(b.SAVED_REGION));
                    }
                }
                f18982d = a5;
                return a5;
            }
        }
        a5 = h.f19013p;
        f18982d = a5;
        return a5;
    }

    public static boolean c() {
        return t.a(a().k(b.SAVED_MSPA_JURISDICTION), "NATIONAL");
    }
}
