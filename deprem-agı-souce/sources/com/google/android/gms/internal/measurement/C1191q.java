package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.q  reason: case insensitive filesystem */
public final class C1191q extends C1137k implements C1164n {

    /* renamed from: c  reason: collision with root package name */
    protected final List f5539c;

    /* renamed from: d  reason: collision with root package name */
    protected final List f5540d;

    /* renamed from: e  reason: collision with root package name */
    protected U1 f5541e;

    private C1191q(C1191q qVar) {
        super(qVar.f5405a);
        ArrayList arrayList = new ArrayList(qVar.f5539c.size());
        this.f5539c = arrayList;
        arrayList.addAll(qVar.f5539c);
        ArrayList arrayList2 = new ArrayList(qVar.f5540d.size());
        this.f5540d = arrayList2;
        arrayList2.addAll(qVar.f5540d);
        this.f5541e = qVar.f5541e;
    }

    public final r a(U1 u12, List list) {
        U1 c5 = this.f5541e.c();
        int i5 = 0;
        while (true) {
            List list2 = this.f5539c;
            if (i5 >= list2.size()) {
                break;
            }
            if (i5 < list.size()) {
                c5.f((String) list2.get(i5), u12.a((r) list.get(i5)));
            } else {
                c5.f((String) list2.get(i5), r.f5553b0);
            }
            i5++;
        }
        for (r rVar : this.f5540d) {
            r a5 = c5.a(rVar);
            if (a5 instanceof C1208s) {
                a5 = c5.a(rVar);
            }
            if (a5 instanceof C1110h) {
                return ((C1110h) a5).a();
            }
        }
        return r.f5553b0;
    }

    public final r j() {
        return new C1191q(this);
    }

    public C1191q(String str, List list, List list2, U1 u12) {
        super(str);
        this.f5539c = new ArrayList();
        this.f5541e = u12;
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.f5539c.add(((r) it.next()).b());
            }
        }
        this.f5540d = new ArrayList(list2);
    }
}
