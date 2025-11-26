package j$.time.format;

import j$.time.temporal.a;
import j$.time.temporal.h;
import j$.time.temporal.j;
import j$.time.temporal.l;
import j$.time.temporal.q;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class n {

    /* renamed from: f  reason: collision with root package name */
    public static final a f1124f = new a(0);

    /* renamed from: a  reason: collision with root package name */
    public n f1125a;

    /* renamed from: b  reason: collision with root package name */
    public final n f1126b;

    /* renamed from: c  reason: collision with root package name */
    public final List f1127c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f1128d;

    /* renamed from: e  reason: collision with root package name */
    public int f1129e;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put('G', a.ERA);
        hashMap.put('y', a.YEAR_OF_ERA);
        hashMap.put('u', a.YEAR);
        h hVar = j.f1189a;
        hashMap.put('Q', hVar);
        hashMap.put('q', hVar);
        a aVar = a.MONTH_OF_YEAR;
        hashMap.put('M', aVar);
        hashMap.put('L', aVar);
        hashMap.put('D', a.DAY_OF_YEAR);
        hashMap.put('d', a.DAY_OF_MONTH);
        hashMap.put('F', a.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        a aVar2 = a.DAY_OF_WEEK;
        hashMap.put('E', aVar2);
        hashMap.put('c', aVar2);
        hashMap.put('e', aVar2);
        hashMap.put('a', a.AMPM_OF_DAY);
        hashMap.put('H', a.HOUR_OF_DAY);
        hashMap.put('k', a.CLOCK_HOUR_OF_DAY);
        hashMap.put('K', a.HOUR_OF_AMPM);
        hashMap.put('h', a.CLOCK_HOUR_OF_AMPM);
        hashMap.put('m', a.MINUTE_OF_HOUR);
        hashMap.put('s', a.SECOND_OF_MINUTE);
        a aVar3 = a.NANO_OF_SECOND;
        hashMap.put('S', aVar3);
        hashMap.put('A', a.MILLI_OF_DAY);
        hashMap.put('n', aVar3);
        hashMap.put('N', a.NANO_OF_DAY);
        hashMap.put('g', l.f1196a);
    }

    public n() {
        this.f1125a = this;
        this.f1127c = new ArrayList();
        this.f1129e = -1;
        this.f1126b = null;
        this.f1128d = false;
    }

    public n(n nVar) {
        this.f1125a = this;
        this.f1127c = new ArrayList();
        this.f1129e = -1;
        this.f1126b = nVar;
        this.f1128d = true;
    }

    public final void g(q qVar, int i5) {
        Objects.requireNonNull(qVar, "field");
        if (i5 < 1 || i5 > 19) {
            throw new IllegalArgumentException("The width must be from 1 to 19 inclusive but was " + i5);
        }
        f(new i(qVar, i5, i5, u.NOT_NEGATIVE));
    }

    public final void h(q qVar, int i5, int i6, u uVar) {
        if (i5 == i6 && uVar == u.NOT_NEGATIVE) {
            g(qVar, i6);
            return;
        }
        Objects.requireNonNull(qVar, "field");
        Objects.requireNonNull(uVar, "signStyle");
        if (i5 < 1 || i5 > 19) {
            throw new IllegalArgumentException("The minimum width must be from 1 to 19 inclusive but was " + i5);
        } else if (i6 < 1 || i6 > 19) {
            throw new IllegalArgumentException("The maximum width must be from 1 to 19 inclusive but was " + i6);
        } else if (i6 >= i5) {
            f(new i(qVar, i5, i6, uVar));
        } else {
            throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + i6 + " < " + i5);
        }
    }

    public final void f(i iVar) {
        i iVar2;
        n nVar = this.f1125a;
        int i5 = nVar.f1129e;
        if (i5 >= 0) {
            i iVar3 = (i) ((ArrayList) nVar.f1127c).get(i5);
            int i6 = iVar.f1109b;
            int i7 = iVar.f1110c;
            if (i6 == i7 && iVar.f1111d == u.NOT_NEGATIVE) {
                iVar2 = iVar3.b(i7);
                b(iVar.a());
                this.f1125a.f1129e = i5;
            } else {
                iVar2 = iVar3.a();
                this.f1125a.f1129e = b(iVar);
            }
            ((ArrayList) this.f1125a.f1127c).set(i5, iVar2);
            return;
        }
        nVar.f1129e = b(iVar);
    }

    public final void e(a aVar, Map map) {
        Objects.requireNonNull(aVar, "field");
        Objects.requireNonNull(map, "textLookup");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        v vVar = v.FULL;
        b(new m(aVar, vVar, new b(new r(0, Collections.singletonMap(vVar, linkedHashMap)))));
    }

    public final void c(char c5) {
        b(new d(c5));
    }

    public final void d(String str) {
        Objects.requireNonNull(str, "literal");
        if (str.isEmpty()) {
            return;
        }
        if (str.length() == 1) {
            b(new d(str.charAt(0)));
        } else {
            b(new l(str));
        }
    }

    public final void a(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        e eVar = dateTimeFormatter.f1094a;
        if (eVar.f1104b) {
            eVar = new e(eVar.f1103a, false);
        }
        b(eVar);
    }

    public final void j() {
        n nVar = this.f1125a;
        nVar.f1129e = -1;
        this.f1125a = new n(nVar);
    }

    public final void i() {
        n nVar = this.f1125a;
        if (nVar.f1126b == null) {
            throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
        } else if (((ArrayList) nVar.f1127c).size() > 0) {
            n nVar2 = this.f1125a;
            e eVar = new e(nVar2.f1127c, nVar2.f1128d);
            this.f1125a = this.f1125a.f1126b;
            b(eVar);
        } else {
            this.f1125a = this.f1125a.f1126b;
        }
    }

    public final int b(f fVar) {
        Objects.requireNonNull(fVar, "pp");
        n nVar = this.f1125a;
        nVar.getClass();
        ((ArrayList) nVar.f1127c).add(fVar);
        n nVar2 = this.f1125a;
        nVar2.f1129e = -1;
        return ((ArrayList) nVar2.f1127c).size() - 1;
    }

    public final DateTimeFormatter k(t tVar, j$.time.chrono.l lVar) {
        return l(Locale.getDefault(), tVar, lVar);
    }

    public final DateTimeFormatter l(Locale locale, t tVar, j$.time.chrono.l lVar) {
        Objects.requireNonNull(locale, "locale");
        while (this.f1125a.f1126b != null) {
            i();
        }
        e eVar = new e(this.f1127c, false);
        s sVar = s.f1138a;
        return new DateTimeFormatter(eVar, locale, tVar, lVar);
    }
}
