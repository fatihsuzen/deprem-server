package s1;

import n1.q;
import n1.s;
import p1.C1752a;
import q1.C1759c;
import q1.C1779w;
import r1.C1814x;

public class O0 extends C1835a {
    public static /* synthetic */ boolean j(Character ch) {
        if (ch.charValue() == 'Y' || ch.charValue() == 'N' || ch.charValue() == '-') {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean k(Character ch) {
        if (ch.charValue() == 'Y' || ch.charValue() == 'N' || ch.charValue() == '-') {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean l(Character ch) {
        if (ch.charValue() == 'Y' || ch.charValue() == 'N' || ch.charValue() == '-') {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public void f(String str, C1759c cVar) {
        if (str == null || str.length() != 4) {
            throw new C1752a("Invalid uspv1 string: '" + str + "'");
        }
        try {
            cVar.get(C1779w.f16208a).setValue(Integer.valueOf(Integer.parseInt(str.substring(0, 1))));
            cVar.get(C1779w.f16209b).setValue(Character.valueOf(str.charAt(1)));
            cVar.get(C1779w.f16210c).setValue(Character.valueOf(str.charAt(2)));
            cVar.get(C1779w.f16211d).setValue(Character.valueOf(str.charAt(3)));
        } catch (Exception e5) {
            throw new C1752a("Unable to decode UspV1CoreSegment '" + str + "'", e5);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public String g(C1759c cVar) {
        return ((("" + cVar.get(C1779w.f16208a).getValue()) + cVar.get(C1779w.f16209b).getValue()) + cVar.get(C1779w.f16210c).getValue()) + cVar.get(C1779w.f16211d).getValue();
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public C1759c h() {
        C1759c cVar = new C1759c();
        cVar.b(C1779w.f16208a, new s(Integer.valueOf(C1814x.f16450f)));
        cVar.b(C1779w.f16209b, new q('-', new L0()));
        cVar.b(C1779w.f16210c, new q('-', new M0()));
        cVar.b(C1779w.f16211d, new q('-', new N0()));
        return cVar;
    }
}
