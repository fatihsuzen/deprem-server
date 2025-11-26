package com.uptodown.activities;

import R1.L;
import W2.J;
import W2.u;
import X2.C2250q;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import b2.C2290j;
import b3.C2308e;
import c3.C2316b;
import com.uptodown.UptodownApp;
import com.uptodown.activities.preferences.a;
import java.util.ArrayList;
import java.util.Iterator;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2646F;
import l2.C2655d;
import l2.T;
import t3.s;
import w3.C2865c0;
import w3.C2908y0;
import w3.M;
import z2.C2940B;
import z2.C2954m;
import z2.O;
import z3.D;
import z3.F;
import z3.w;

/* renamed from: com.uptodown.activities.v  reason: case insensitive filesystem */
public final class C1618v extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final w f15157a;

    /* renamed from: b  reason: collision with root package name */
    private final D f15158b;

    /* renamed from: c  reason: collision with root package name */
    private final w f15159c = F.a(Boolean.FALSE);

    /* renamed from: d  reason: collision with root package name */
    private String f15160d;

    /* renamed from: e  reason: collision with root package name */
    private w f15161e = F.a(0);

    /* renamed from: com.uptodown.activities.v$a */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList f15162a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList f15163b;

        /* renamed from: c  reason: collision with root package name */
        private final ArrayList f15164c;

        /* renamed from: d  reason: collision with root package name */
        private final ArrayList f15165d;

        /* renamed from: e  reason: collision with root package name */
        private final ArrayList f15166e;

        /* renamed from: f  reason: collision with root package name */
        private final ArrayList f15167f;

        public a(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, ArrayList arrayList5, ArrayList arrayList6) {
            t.e(arrayList, "tmpAppUpdateData");
            t.e(arrayList2, "tmpUserApps");
            t.e(arrayList3, "tmpSystemApps");
            t.e(arrayList4, "tmpDisabledApps");
            t.e(arrayList5, "tmpSystemServices");
            t.e(arrayList6, "tmpPositiveApps");
            this.f15162a = arrayList;
            this.f15163b = arrayList2;
            this.f15164c = arrayList3;
            this.f15165d = arrayList4;
            this.f15166e = arrayList5;
            this.f15167f = arrayList6;
        }

        public final ArrayList a() {
            return this.f15162a;
        }

        public final ArrayList b() {
            return this.f15165d;
        }

        public final ArrayList c() {
            return this.f15164c;
        }

        public final ArrayList d() {
            return this.f15166e;
        }

        public final ArrayList e() {
            return this.f15163b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return t.a(this.f15162a, aVar.f15162a) && t.a(this.f15163b, aVar.f15163b) && t.a(this.f15164c, aVar.f15164c) && t.a(this.f15165d, aVar.f15165d) && t.a(this.f15166e, aVar.f15166e) && t.a(this.f15167f, aVar.f15167f);
        }

        public int hashCode() {
            return (((((((((this.f15162a.hashCode() * 31) + this.f15163b.hashCode()) * 31) + this.f15164c.hashCode()) * 31) + this.f15165d.hashCode()) * 31) + this.f15166e.hashCode()) * 31) + this.f15167f.hashCode();
        }

        public String toString() {
            return "MyAppsData(tmpAppUpdateData=" + this.f15162a + ", tmpUserApps=" + this.f15163b + ", tmpSystemApps=" + this.f15164c + ", tmpDisabledApps=" + this.f15165d + ", tmpSystemServices=" + this.f15166e + ", tmpPositiveApps=" + this.f15167f + ')';
        }
    }

    /* renamed from: com.uptodown.activities.v$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f15168a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f15169b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C1618v f15170c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f15171d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(boolean z4, C1618v vVar, Context context, C2308e eVar) {
            super(2, eVar);
            this.f15169b = z4;
            this.f15170c = vVar;
            this.f15171d = context;
        }

        /* access modifiers changed from: private */
        public static final boolean d(ArrayList arrayList, C2655d dVar) {
            if (b.w.a(arrayList) && arrayList.isEmpty()) {
                return false;
            }
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList.get(i5);
                i5++;
                if (t.a(((L.a) obj).a().o(), dVar.o())) {
                    return true;
                }
            }
            return false;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f15169b, this.f15170c, this.f15171d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f15168a == 0) {
                u.b(obj);
                if (this.f15169b) {
                    this.f15170c.f15157a.setValue(O.a.f26507a);
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                ArrayList arrayList5 = new ArrayList();
                ArrayList D4 = new C2954m().D(this.f15171d);
                a.C0147a aVar = com.uptodown.activities.preferences.a.f15150a;
                boolean h02 = aVar.h0(this.f15171d);
                boolean i02 = aVar.i0(this.f15171d);
                Iterator it = D4.iterator();
                t.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    t.d(next, "next(...)");
                    C2655d dVar = (C2655d) next;
                    C2290j jVar = new C2290j();
                    Context context = this.f15171d;
                    String o5 = dVar.o();
                    t.b(o5);
                    if (jVar.p(context, o5)) {
                        kotlin.coroutines.jvm.internal.b.a(arrayList3.add(dVar));
                    } else if (dVar.H()) {
                        if (i02) {
                            arrayList4.add(dVar);
                        }
                    } else if (!dVar.F()) {
                        kotlin.coroutines.jvm.internal.b.a(arrayList.add(dVar));
                    } else if (h02) {
                        arrayList2.add(dVar);
                    }
                    UptodownApp.a aVar2 = UptodownApp.f13477F;
                    if (aVar2.t() != null) {
                        ArrayList t5 = aVar2.t();
                        t.b(t5);
                        Iterator it2 = t5.iterator();
                        t.d(it2, "iterator(...)");
                        while (it2.hasNext()) {
                            Object next2 = it2.next();
                            t.d(next2, "next(...)");
                            C2646F f5 = (C2646F) next2;
                            if (t.a(f5.c(), dVar.r())) {
                                dVar.X(f5);
                                arrayList5.add(dVar);
                            }
                        }
                    }
                }
                int intValue = ((Number) this.f15170c.f().getValue()).intValue();
                if (intValue == 0) {
                    C2954m.a aVar3 = C2954m.f26533a;
                    aVar3.l(arrayList, this.f15171d);
                    aVar3.l(arrayList2, this.f15171d);
                    aVar3.l(arrayList4, this.f15171d);
                    aVar3.l(arrayList3, this.f15171d);
                } else if (intValue == 1) {
                    C2954m.a aVar4 = C2954m.f26533a;
                    aVar4.i(arrayList, this.f15171d);
                    aVar4.i(arrayList2, this.f15171d);
                    aVar4.i(arrayList4, this.f15171d);
                    aVar4.i(arrayList3, this.f15171d);
                } else if (intValue == 2) {
                    C2954m.a aVar5 = C2954m.f26533a;
                    aVar5.n(arrayList, this.f15171d);
                    aVar5.n(arrayList2, this.f15171d);
                    aVar5.n(arrayList4, this.f15171d);
                    aVar5.n(arrayList3, this.f15171d);
                }
                String g5 = this.f15170c.g();
                if (g5 == null || g5.length() == 0) {
                    C2940B a5 = C2940B.f26458v.a(this.f15171d);
                    a5.a();
                    ArrayList arrayList6 = new ArrayList();
                    int size = arrayList.size();
                    int i5 = 0;
                    while (i5 < size) {
                        Object obj2 = arrayList.get(i5);
                        i5++;
                        C2655d dVar2 = (C2655d) obj2;
                        if (dVar2.w() == C2655d.c.OUTDATED) {
                            String o6 = dVar2.o();
                            t.b(o6);
                            T G02 = a5.G0(o6);
                            if (G02 != null) {
                                arrayList6.add(new L.a(dVar2, G02, false, false, false, 28, (C2633k) null));
                            }
                        }
                    }
                    a5.m();
                    C2250q.y(arrayList, new C1619w(arrayList6));
                    this.f15170c.f15157a.setValue(new O.c(new a(arrayList6, arrayList, arrayList2, arrayList3, arrayList4, arrayList5)));
                } else {
                    C1618v vVar = this.f15170c;
                    String g6 = vVar.g();
                    t.b(g6);
                    ArrayList b5 = vVar.h(arrayList, g6);
                    C1618v vVar2 = this.f15170c;
                    String g7 = vVar2.g();
                    t.b(g7);
                    ArrayList b6 = vVar2.h(arrayList2, g7);
                    C1618v vVar3 = this.f15170c;
                    String g8 = vVar3.g();
                    t.b(g8);
                    ArrayList b7 = vVar3.h(arrayList3, g8);
                    C1618v vVar4 = this.f15170c;
                    String g9 = vVar4.g();
                    t.b(g9);
                    this.f15170c.f15157a.setValue(new O.c(new a(new ArrayList(), b5, b6, b7, vVar4.h(arrayList4, g9), arrayList5)));
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public C1618v() {
        w a5 = F.a(O.a.f26507a);
        this.f15157a = a5;
        this.f15158b = a5;
    }

    /* access modifiers changed from: private */
    public final ArrayList h(ArrayList arrayList, String str) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            C2655d dVar = (C2655d) obj;
            String m5 = dVar.m();
            boolean z4 = true;
            if (m5 == null || m5.length() == 0) {
                String o5 = dVar.o();
                if (!(o5 == null || o5.length() == 0)) {
                    String o6 = dVar.o();
                    t.b(o6);
                    z4 = s.T(o6, str, true);
                }
            } else {
                String m6 = dVar.m();
                t.b(m6);
                z4 = s.T(m6, str, true);
            }
            if (z4) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    public final void c(Context context, boolean z4) {
        t.e(context, "context");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new b(z4, this, context, (C2308e) null), 2, (Object) null);
    }

    public final w d() {
        return this.f15159c;
    }

    public final D e() {
        return this.f15158b;
    }

    public final w f() {
        return this.f15161e;
    }

    public final String g() {
        return this.f15160d;
    }

    public final void i(String str) {
        this.f15160d = str;
    }
}
