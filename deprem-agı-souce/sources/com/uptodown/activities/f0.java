package com.uptodown.activities;

import W2.J;
import W2.u;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import b3.C2308e;
import c3.C2316b;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.ArrayList;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.S;
import kotlin.jvm.internal.t;
import l2.C2667p;
import l2.M;
import l2.X;
import org.json.JSONArray;
import org.json.JSONObject;
import w3.C2865c0;
import w3.C2908y0;
import z2.O;
import z2.Z;
import z3.D;
import z3.F;
import z3.w;

public final class f0 extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final w f15002a;

    /* renamed from: b  reason: collision with root package name */
    private final D f15003b;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final X f15004a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList f15005b;

        public a(X x4, ArrayList arrayList) {
            t.e(x4, "thisDevice");
            t.e(arrayList, "userDevices");
            this.f15004a = x4;
            this.f15005b = arrayList;
        }

        public final X a() {
            return this.f15004a;
        }

        public final ArrayList b() {
            return this.f15005b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return t.a(this.f15004a, aVar.f15004a) && t.a(this.f15005b, aVar.f15005b);
        }

        public int hashCode() {
            return (this.f15004a.hashCode() * 31) + this.f15005b.hashCode();
        }

        public String toString() {
            return "UserDevicesData(thisDevice=" + this.f15004a + ", userDevices=" + this.f15005b + ')';
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f15006a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f15007b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f0 f15008c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Context context, f0 f0Var, C2308e eVar) {
            super(2, eVar);
            this.f15007b = context;
            this.f15008c = f0Var;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f15007b, this.f15008c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object obj2;
            C2316b.f();
            if (this.f15006a == 0) {
                u.b(obj);
                ArrayList arrayList = new ArrayList();
                M A02 = new Z(this.f15007b).A0();
                if (A02.b() || A02.e() == null) {
                    arrayList = new ArrayList();
                } else {
                    JSONObject e5 = A02.e();
                    t.b(e5);
                    JSONArray optJSONArray = e5.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                    if (e5.optInt("success") == 1 && optJSONArray != null) {
                        arrayList = X.f24900l.c(optJSONArray);
                    }
                }
                Context context = this.f15007b;
                int size = arrayList.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size) {
                        obj2 = null;
                        break;
                    }
                    obj2 = arrayList.get(i5);
                    i5++;
                    String c5 = ((X) obj2).c();
                    C2667p pVar = new C2667p();
                    pVar.j(context);
                    if (t.a(c5, pVar.d())) {
                        break;
                    }
                }
                X x4 = (X) obj2;
                S.a(arrayList).remove(x4);
                if (x4 != null) {
                    this.f15008c.f15002a.setValue(new O.c(new a(x4, arrayList)));
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public f0() {
        w a5 = F.a(O.a.f26507a);
        this.f15002a = a5;
        this.f15003b = a5;
    }

    public final void b(Context context) {
        t.e(context, "context");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new b(context, this, (C2308e) null), 2, (Object) null);
    }

    public final D c() {
        return this.f15003b;
    }
}
