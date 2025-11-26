package j$.time.format;

import j$.time.chrono.l;
import j$.time.chrono.s;
import j$.time.temporal.q;
import j$.time.temporal.r;
import java.util.Locale;

public final class m implements f {

    /* renamed from: a  reason: collision with root package name */
    public final q f1120a;

    /* renamed from: b  reason: collision with root package name */
    public final v f1121b;

    /* renamed from: c  reason: collision with root package name */
    public final b f1122c;

    /* renamed from: d  reason: collision with root package name */
    public volatile i f1123d;

    public m(q qVar, v vVar, b bVar) {
        this.f1120a = qVar;
        this.f1121b = vVar;
        this.f1122c = bVar;
    }

    public final boolean e(p pVar, StringBuilder sb) {
        String str;
        Long a5 = pVar.a(this.f1120a);
        if (a5 == null) {
            return false;
        }
        l lVar = (l) pVar.f1134a.h(r.f1200b);
        if (lVar == null || lVar == s.f1072c) {
            b bVar = this.f1122c;
            long longValue = a5.longValue();
            v vVar = this.f1121b;
            Locale locale = pVar.f1135b.f1095b;
            str = bVar.f1100a.a(longValue, vVar);
        } else {
            b bVar2 = this.f1122c;
            long longValue2 = a5.longValue();
            v vVar2 = this.f1121b;
            Locale locale2 = pVar.f1135b.f1095b;
            str = bVar2.f1100a.a(longValue2, vVar2);
        }
        if (str == null) {
            if (this.f1123d == null) {
                this.f1123d = new i(this.f1120a, 1, 19, u.NORMAL);
            }
            return this.f1123d.e(pVar, sb);
        }
        sb.append(str);
        return true;
    }

    public final String toString() {
        v vVar = v.FULL;
        q qVar = this.f1120a;
        v vVar2 = this.f1121b;
        if (vVar2 == vVar) {
            return "Text(" + qVar + ")";
        }
        return "Text(" + qVar + "," + vVar2 + ")";
    }
}
