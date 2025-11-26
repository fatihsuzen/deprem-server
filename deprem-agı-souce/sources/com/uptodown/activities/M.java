package com.uptodown.activities;

import W2.J;
import W2.u;
import X2.C2250q;
import a3.C2265a;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import b2.C2290j;
import b3.C2308e;
import c3.C2316b;
import java.util.ArrayList;
import java.util.Comparator;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import l2.C2655d;
import t3.s;
import w3.C2865c0;
import w3.C2908y0;
import z2.C2954m;
import z2.O;
import z3.D;
import z3.F;
import z3.w;

public final class M extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final w f13969a;

    /* renamed from: b  reason: collision with root package name */
    private final D f13970b;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList f13971a;

        public a(ArrayList arrayList) {
            t.e(arrayList, "rollbackApps");
            this.f13971a = arrayList;
        }

        public final ArrayList a() {
            return this.f13971a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && t.a(this.f13971a, ((a) obj).f13971a);
        }

        public int hashCode() {
            return this.f13971a.hashCode();
        }

        public String toString() {
            return "RollbackData(rollbackApps=" + this.f13971a + ')';
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13972a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f13973b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ M f13974c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f13975d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(boolean z4, M m5, Context context, C2308e eVar) {
            super(2, eVar);
            this.f13973b = z4;
            this.f13974c = m5;
            this.f13975d = context;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f13973b, this.f13974c, this.f13975d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f13972a == 0) {
                u.b(obj);
                if (this.f13973b) {
                    this.f13974c.f13969a.setValue(O.a.f26507a);
                }
                this.f13974c.f13969a.setValue(new O.c(new a(this.f13974c.e(this.f13975d, new C2954m().D(this.f13975d)))));
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class c implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return C2265a.a(((C2655d) obj).m(), ((C2655d) obj2).m());
        }
    }

    public M() {
        w a5 = F.a(O.a.f26507a);
        this.f13969a = a5;
        this.f13970b = a5;
    }

    /* access modifiers changed from: private */
    public final ArrayList e(Context context, ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (!s.E(context.getPackageName(), ((C2655d) arrayList.get(i5)).o(), true)) {
                C2290j jVar = new C2290j();
                String o5 = ((C2655d) arrayList.get(i5)).o();
                t.b(o5);
                if (!jVar.p(context, o5) && !((C2655d) arrayList.get(i5)).F() && ((C2655d) arrayList.get(i5)).h() == 1) {
                    arrayList2.add(arrayList.get(i5));
                }
            }
        }
        if (arrayList2.size() > 1) {
            C2250q.t(arrayList2, new c());
        }
        return arrayList2;
    }

    public final void c(Context context, boolean z4) {
        t.e(context, "context");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new b(z4, this, context, (C2308e) null), 2, (Object) null);
    }

    public final D d() {
        return this.f13970b;
    }
}
