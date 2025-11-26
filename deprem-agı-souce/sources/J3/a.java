package J3;

import X2.C2250q;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.t;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f18347a;

    /* renamed from: b  reason: collision with root package name */
    private List f18348b = C2250q.g();

    /* renamed from: c  reason: collision with root package name */
    private final List f18349c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private final Set f18350d = new HashSet();

    /* renamed from: e  reason: collision with root package name */
    private final List f18351e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final List f18352f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private final List f18353g = new ArrayList();

    public a(String str) {
        t.e(str, "serialName");
        this.f18347a = str;
    }

    public static /* synthetic */ void b(a aVar, String str, f fVar, List list, boolean z4, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            list = C2250q.g();
        }
        if ((i5 & 8) != 0) {
            z4 = false;
        }
        aVar.a(str, fVar, list, z4);
    }

    public final void a(String str, f fVar, List list, boolean z4) {
        t.e(str, "elementName");
        t.e(fVar, "descriptor");
        t.e(list, "annotations");
        if (this.f18350d.add(str)) {
            this.f18349c.add(str);
            this.f18351e.add(fVar);
            this.f18352f.add(list);
            this.f18353g.add(Boolean.valueOf(z4));
            return;
        }
        throw new IllegalArgumentException(("Element with name '" + str + "' is already registered in " + this.f18347a).toString());
    }

    public final List c() {
        return this.f18348b;
    }

    public final List d() {
        return this.f18352f;
    }

    public final List e() {
        return this.f18351e;
    }

    public final List f() {
        return this.f18349c;
    }

    public final List g() {
        return this.f18353g;
    }

    public final void h(List list) {
        t.e(list, "<set-?>");
        this.f18348b = list;
    }
}
