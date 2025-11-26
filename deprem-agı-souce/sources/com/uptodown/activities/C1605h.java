package com.uptodown.activities;

import W2.J;
import W2.u;
import X2.C2250q;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import b2.C2290j;
import b3.C2308e;
import c3.C2316b;
import java.util.ArrayList;
import java.util.Iterator;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import l2.C2655d;
import w3.C2865c0;
import w3.C2908y0;
import w3.M;
import z2.C2954m;
import z2.O;
import z3.D;
import z3.F;
import z3.w;

/* renamed from: com.uptodown.activities.h  reason: case insensitive filesystem */
public final class C1605h extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final w f15030a;

    /* renamed from: b  reason: collision with root package name */
    private final D f15031b;

    /* renamed from: c  reason: collision with root package name */
    private final w f15032c = F.a(Boolean.FALSE);

    /* renamed from: com.uptodown.activities.h$a */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList f15033a;

        public a(ArrayList arrayList) {
            t.e(arrayList, "tmpUserApps");
            this.f15033a = arrayList;
        }

        public final ArrayList a() {
            return this.f15033a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && t.a(this.f15033a, ((a) obj).f15033a);
        }

        public int hashCode() {
            return this.f15033a.hashCode();
        }

        public String toString() {
            return "FreeUpSpaceData(tmpUserApps=" + this.f15033a + ')';
        }
    }

    /* renamed from: com.uptodown.activities.h$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f15034a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f15035b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C1605h f15036c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f15037d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(boolean z4, C1605h hVar, Context context, C2308e eVar) {
            super(2, eVar);
            this.f15035b = z4;
            this.f15036c = hVar;
            this.f15037d = context;
        }

        /* access modifiers changed from: private */
        public static final int e(C2655d dVar, C2655d dVar2) {
            return t.h(dVar2.t(), dVar.t());
        }

        /* access modifiers changed from: private */
        public static final int f(p pVar, Object obj, Object obj2) {
            return ((Number) pVar.invoke(obj, obj2)).intValue();
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f15035b, this.f15036c, this.f15037d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f15034a == 0) {
                u.b(obj);
                if (this.f15035b) {
                    this.f15036c.f15030a.setValue(O.a.f26507a);
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = new C2954m().D(this.f15037d).iterator();
                t.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    t.d(next, "next(...)");
                    C2655d dVar = (C2655d) next;
                    C2290j jVar = new C2290j();
                    Context context = this.f15037d;
                    String o5 = dVar.o();
                    t.b(o5);
                    if (!jVar.p(context, o5) && !dVar.H() && !dVar.F()) {
                        arrayList.add(dVar);
                    }
                }
                C2250q.t(arrayList, new C1607j(new C1606i()));
                this.f15036c.f15030a.setValue(new O.c(new a(arrayList)));
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public C1605h() {
        w a5 = F.a(O.a.f26507a);
        this.f15030a = a5;
        this.f15031b = a5;
    }

    public final void b(Context context, boolean z4) {
        t.e(context, "context");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new b(z4, this, context, (C2308e) null), 2, (Object) null);
    }

    public final w c() {
        return this.f15032c;
    }

    public final D d() {
        return this.f15031b;
    }
}
