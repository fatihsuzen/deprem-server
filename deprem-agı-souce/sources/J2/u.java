package J2;

import P3.d;
import P3.k;
import X2.C2242i;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import b.w;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.Vector;
import com.inmobi.cmp.model.ChoiceError;
import j$.time.ZonedDateTime;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import s4.c;

public final class u {

    /* renamed from: A  reason: collision with root package name */
    public final Vector f18307A;

    /* renamed from: B  reason: collision with root package name */
    public final Vector f18308B;

    /* renamed from: C  reason: collision with root package name */
    public Vector f18309C;

    /* renamed from: D  reason: collision with root package name */
    public final Vector f18310D;

    /* renamed from: E  reason: collision with root package name */
    public Vector f18311E;

    /* renamed from: F  reason: collision with root package name */
    public Vector f18312F;

    /* renamed from: G  reason: collision with root package name */
    public l f18313G;

    /* renamed from: a  reason: collision with root package name */
    public d f18314a = null;

    /* renamed from: b  reason: collision with root package name */
    public long f18315b;

    /* renamed from: c  reason: collision with root package name */
    public long f18316c;

    /* renamed from: d  reason: collision with root package name */
    public ZonedDateTime f18317d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18318e = true;

    /* renamed from: f  reason: collision with root package name */
    public boolean f18319f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f18320g;

    /* renamed from: h  reason: collision with root package name */
    public String f18321h = "AA";

    /* renamed from: i  reason: collision with root package name */
    public int f18322i = 2;

    /* renamed from: j  reason: collision with root package name */
    public int f18323j;

    /* renamed from: k  reason: collision with root package name */
    public int f18324k = 2;

    /* renamed from: l  reason: collision with root package name */
    public String f18325l = "EN";

    /* renamed from: m  reason: collision with root package name */
    public int f18326m = 10;

    /* renamed from: n  reason: collision with root package name */
    public int f18327n = 2021;

    /* renamed from: o  reason: collision with root package name */
    public int f18328o;

    /* renamed from: p  reason: collision with root package name */
    public int f18329p;

    /* renamed from: q  reason: collision with root package name */
    public Vector f18330q = new Vector((Map) null, 1, (C2633k) null);

    /* renamed from: r  reason: collision with root package name */
    public Vector f18331r = new Vector((Map) null, 1, (C2633k) null);

    /* renamed from: s  reason: collision with root package name */
    public Vector f18332s = new Vector((Map) null, 1, (C2633k) null);

    /* renamed from: t  reason: collision with root package name */
    public final Vector f18333t = new Vector((Map) null, 1, (C2633k) null);

    /* renamed from: u  reason: collision with root package name */
    public final Vector f18334u = new Vector((Map) null, 1, (C2633k) null);

    /* renamed from: v  reason: collision with root package name */
    public Vector f18335v = new Vector((Map) null, 1, (C2633k) null);

    /* renamed from: w  reason: collision with root package name */
    public Vector f18336w = new Vector((Map) null, 1, (C2633k) null);

    /* renamed from: x  reason: collision with root package name */
    public Vector f18337x = new Vector((Map) null, 1, (C2633k) null);

    /* renamed from: y  reason: collision with root package name */
    public Vector f18338y = new Vector((Map) null, 1, (C2633k) null);

    /* renamed from: z  reason: collision with root package name */
    public Vector f18339z;

    public u() {
        new LinkedHashSet();
        this.f18339z = new Vector((Map) null, 1, (C2633k) null);
        this.f18307A = new Vector((Map) null, 1, (C2633k) null);
        this.f18308B = new Vector((Map) null, 1, (C2633k) null);
        this.f18309C = new Vector((Map) null, 1, (C2633k) null);
        this.f18310D = new Vector((Map) null, 1, (C2633k) null);
        this.f18311E = new Vector((Map) null, 1, (C2633k) null);
        this.f18312F = new Vector((Map) null, 1, (C2633k) null);
        this.f18313G = new l(this.f18314a);
    }

    public static final boolean c(u uVar, k kVar) {
        uVar.getClass();
        List list = c.j().f19281b.f19245j;
        Set<Number> set = kVar.f18889e;
        if (w.a(set) && set.isEmpty()) {
            return false;
        }
        for (Number intValue : set) {
            if (list.contains(Integer.valueOf(intValue.intValue()))) {
                return true;
            }
        }
        return false;
    }

    public static boolean d(k kVar) {
        List list = c.j().f19281b.f19243h;
        Set<Number> set = kVar.f18888d;
        if (w.a(set) && set.isEmpty()) {
            return false;
        }
        for (Number intValue : set) {
            if (list.contains(Integer.valueOf(intValue.intValue()))) {
                return true;
            }
        }
        return false;
    }

    public final int a() {
        return this.f18326m;
    }

    public final void b(String str) {
        t.e(str, "value");
        String[] iSOCountries = Locale.getISOCountries();
        t.d(iSOCountries, "getISOCountries()");
        Locale locale = Locale.getDefault();
        t.d(locale, "getDefault()");
        String upperCase = str.toUpperCase(locale);
        t.d(upperCase, "this as java.lang.String).toUpperCase(locale)");
        if (C2242i.L(iSOCountries, upperCase)) {
            Locale locale2 = Locale.getDefault();
            t.d(locale2, "getDefault()");
            String upperCase2 = str.toUpperCase(locale2);
            t.d(upperCase2, "this as java.lang.String).toUpperCase(locale)");
            this.f18321h = upperCase2;
            return;
        }
        String str2 = "";
        w wVar = new w("publisherCountryCode", str, str2);
        ChoiceCmpCallback callback = ChoiceCmp.INSTANCE.getCallback();
        if (callback != null) {
            callback.onCmpError(ChoiceError.TC_MODEL_PROPERTY_ERROR);
        }
        String message = wVar.getMessage();
        if (message != null) {
            str2 = message;
        }
        Boolean bool = Boolean.TRUE;
        t.e(str2, NotificationCompat.CATEGORY_MESSAGE);
        if (t.a(bool, bool)) {
            int a5 = H2.c.a(5);
            if (a5 == 0) {
                Log.v("f.u", str2, wVar);
            } else if (a5 == 1) {
                Log.d("f.u", str2, wVar);
            } else if (a5 == 2) {
                Log.i("f.u", str2, wVar);
            } else if (a5 == 3) {
                Log.w("f.u", str2, wVar);
            } else if (a5 == 4) {
                Log.e("f.u", str2, wVar);
            }
        }
    }

    public final int e() {
        return this.f18327n;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof u) && t.a(this.f18314a, ((u) obj).f18314a)) {
            return true;
        }
        return false;
    }

    public final int f() {
        Integer num;
        d dVar = this.f18314a;
        if (dVar == null) {
            num = null;
        } else {
            num = dVar.f18871c;
        }
        if (num == null) {
            return this.f18324k;
        }
        return num.intValue();
    }

    public final Vector g() {
        return this.f18335v;
    }

    public final String h() {
        return this.f18321h;
    }

    public final int hashCode() {
        d dVar = this.f18314a;
        if (dVar == null) {
            return 0;
        }
        return dVar.hashCode();
    }

    public final Vector i() {
        return this.f18337x;
    }

    public final Vector j() {
        return this.f18338y;
    }

    public final Vector k() {
        return this.f18336w;
    }

    public final l l() {
        return this.f18313G;
    }

    public final Vector m() {
        return this.f18331r;
    }

    public final Vector n() {
        return this.f18332s;
    }

    public final boolean o() {
        return this.f18320g;
    }

    public final Vector p() {
        return this.f18330q;
    }

    public final boolean q() {
        return this.f18319f;
    }

    public final Vector r() {
        return this.f18339z;
    }

    public final Vector s() {
        return this.f18309C;
    }

    public final Vector t() {
        return this.f18312F;
    }

    public final String toString() {
        return "TCModel(gvl=" + this.f18314a + ')';
    }

    public final Vector u() {
        return this.f18311E;
    }

    public final boolean v() {
        return this.f18318e;
    }

    public final void w() {
        this.f18308B.setAllOwnedItems();
        this.f18339z.forEach(new q(this));
        this.f18331r.setAllOwnedItems();
        this.f18332s.setAllOwnedItems();
        this.f18330q.setAllOwnedItems();
        this.f18309C.forEach(new r(this));
        this.f18307A.forEach(new p(this));
        this.f18310D.setAllOwnedItems();
        this.f18335v.setAllOwnedItems();
        this.f18336w.setAllOwnedItems();
    }

    public final void x() {
        this.f18339z.forEach(new t(this));
        this.f18309C.forEach(new r(this));
        Vector vector = this.f18308B;
        vector.unset(vector.getKeys());
        this.f18307A.unsetAllOwnedItems();
        this.f18330q.unsetAllOwnedItems();
        this.f18331r.unsetAllOwnedItems();
        this.f18332s.setAllOwnedItems();
        this.f18309C.forEach(new s(this));
        this.f18335v.unsetAllOwnedItems();
        this.f18336w.unsetAllOwnedItems();
    }
}
