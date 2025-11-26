package f4;

import X2.C2250q;
import e4.C2356e;
import e4.C2359h;
import e4.Q;
import java.util.ArrayList;
import kotlin.jvm.internal.t;

public abstract class d {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final C2359h f21628a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final C2359h f21629b;

    /* renamed from: c  reason: collision with root package name */
    private static final C2359h f21630c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final C2359h f21631d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final C2359h f21632e;

    static {
        C2359h.a aVar = C2359h.f21566d;
        f21628a = aVar.c("/");
        f21629b = aVar.c("\\");
        f21630c = aVar.c("/\\");
        f21631d = aVar.c(".");
        f21632e = aVar.c("..");
    }

    public static final Q j(Q q5, Q q6, boolean z4) {
        t.e(q5, "<this>");
        t.e(q6, "child");
        if (q6.isAbsolute() || q6.m() != null) {
            return q6;
        }
        C2359h m5 = m(q5);
        if (m5 == null && (m5 = m(q6)) == null) {
            m5 = s(Q.f21502c);
        }
        C2356e eVar = new C2356e();
        eVar.F(q5.b());
        if (eVar.size() > 0) {
            eVar.F(m5);
        }
        eVar.F(q6.b());
        return q(eVar, z4);
    }

    public static final Q k(String str, boolean z4) {
        t.e(str, "<this>");
        return q(new C2356e().writeUtf8(str), z4);
    }

    /* access modifiers changed from: private */
    public static final int l(Q q5) {
        int u5 = C2359h.u(q5.b(), f21628a, 0, 2, (Object) null);
        if (u5 != -1) {
            return u5;
        }
        return C2359h.u(q5.b(), f21629b, 0, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final C2359h m(Q q5) {
        C2359h b5 = q5.b();
        C2359h hVar = f21628a;
        if (C2359h.p(b5, hVar, 0, 2, (Object) null) != -1) {
            return hVar;
        }
        C2359h b6 = q5.b();
        C2359h hVar2 = f21629b;
        if (C2359h.p(b6, hVar2, 0, 2, (Object) null) != -1) {
            return hVar2;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final boolean n(Q q5) {
        if (!q5.b().g(f21632e) || (q5.b().F() != 2 && !q5.b().x(q5.b().F() - 3, f21628a, 0, 1) && !q5.b().x(q5.b().F() - 3, f21629b, 0, 1))) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final int o(Q q5) {
        if (q5.b().F() == 0) {
            return -1;
        }
        if (q5.b().h(0) == 47) {
            return 1;
        }
        if (q5.b().h(0) != 92) {
            if (q5.b().F() > 2 && q5.b().h(1) == 58 && q5.b().h(2) == 92) {
                char h5 = (char) q5.b().h(0);
                if ('a' <= h5 && h5 < '{') {
                    return 3;
                }
                if ('A' > h5 || h5 >= '[') {
                    return -1;
                }
                return 3;
            }
            return -1;
        } else if (q5.b().F() <= 2 || q5.b().h(1) != 92) {
            return 1;
        } else {
            int n5 = q5.b().n(f21629b, 2);
            if (n5 == -1) {
                return q5.b().F();
            }
            return n5;
        }
    }

    private static final boolean p(C2356e eVar, C2359h hVar) {
        if (!t.a(hVar, f21629b) || eVar.size() < 2 || eVar.q(1) != 58) {
            return false;
        }
        char q5 = (char) eVar.q(0);
        if ('a' <= q5 && q5 < '{') {
            return true;
        }
        if ('A' > q5 || q5 >= '[') {
            return false;
        }
        return true;
    }

    public static final Q q(C2356e eVar, boolean z4) {
        C2359h hVar;
        boolean z5;
        boolean z6;
        C2359h hVar2;
        C2356e eVar2 = eVar;
        t.e(eVar2, "<this>");
        C2356e eVar3 = new C2356e();
        C2359h hVar3 = null;
        int i5 = 0;
        while (true) {
            if (!eVar2.k(0, f21628a)) {
                hVar = f21629b;
                if (!eVar2.k(0, hVar)) {
                    break;
                }
            }
            byte readByte = eVar2.readByte();
            if (hVar3 == null) {
                hVar3 = r(readByte);
            }
            i5++;
        }
        if (i5 < 2 || !t.a(hVar3, hVar)) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (z5) {
            t.b(hVar3);
            eVar3.F(hVar3);
            eVar3.F(hVar3);
        } else if (i5 > 0) {
            t.b(hVar3);
            eVar3.F(hVar3);
        } else {
            long s5 = eVar2.s(f21630c);
            if (hVar3 == null) {
                if (s5 == -1) {
                    hVar3 = s(Q.f21502c);
                } else {
                    hVar3 = r(eVar2.q(s5));
                }
            }
            if (p(eVar2, hVar3)) {
                if (s5 == 2) {
                    eVar3.f(eVar2, 3);
                } else {
                    eVar3.f(eVar2, 2);
                }
            }
        }
        if (eVar3.size() > 0) {
            z6 = true;
        } else {
            z6 = false;
        }
        ArrayList arrayList = new ArrayList();
        while (!eVar2.exhausted()) {
            long s6 = eVar2.s(f21630c);
            if (s6 == -1) {
                hVar2 = eVar2.y();
            } else {
                hVar2 = eVar2.readByteString(s6);
                eVar2.readByte();
            }
            C2359h hVar4 = f21632e;
            if (t.a(hVar2, hVar4)) {
                if (!z6 || !arrayList.isEmpty()) {
                    if (!z4 || (!z6 && (arrayList.isEmpty() || t.a(C2250q.X(arrayList), hVar4)))) {
                        arrayList.add(hVar2);
                    } else if (!z5 || arrayList.size() != 1) {
                        C2250q.A(arrayList);
                    }
                }
            } else if (!t.a(hVar2, f21631d) && !t.a(hVar2, C2359h.f21567e)) {
                arrayList.add(hVar2);
            }
        }
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (i6 > 0) {
                eVar3.F(hVar3);
            }
            eVar3.F((C2359h) arrayList.get(i6));
        }
        if (eVar3.size() == 0) {
            eVar3.F(f21631d);
        }
        return new Q(eVar3.y());
    }

    private static final C2359h r(byte b5) {
        if (b5 == 47) {
            return f21628a;
        }
        if (b5 == 92) {
            return f21629b;
        }
        throw new IllegalArgumentException("not a directory separator: " + b5);
    }

    /* access modifiers changed from: private */
    public static final C2359h s(String str) {
        if (t.a(str, "/")) {
            return f21628a;
        }
        if (t.a(str, "\\")) {
            return f21629b;
        }
        throw new IllegalArgumentException("not a directory separator: " + str);
    }
}
