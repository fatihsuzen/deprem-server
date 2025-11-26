package com.uptodown.activities;

import W2.J;
import W2.u;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import b3.C2308e;
import c3.C2316b;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.squareup.picasso.s;
import java.util.ArrayList;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import l2.C2657f;
import l2.M;
import org.json.JSONArray;
import org.json.JSONObject;
import w3.C2865c0;
import w3.C2908y0;
import z2.O;
import z2.Z;
import z3.D;
import z3.F;
import z3.w;

public final class O extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final w f14251a;

    /* renamed from: b  reason: collision with root package name */
    private final D f14252b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f14253c;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList f14254a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f14255b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f14256c;

        public a(ArrayList arrayList, boolean z4, boolean z5) {
            t.e(arrayList, "searchResults");
            this.f14254a = arrayList;
            this.f14255b = z4;
            this.f14256c = z5;
        }

        public final boolean a() {
            return this.f14255b;
        }

        public final boolean b() {
            return this.f14256c;
        }

        public final ArrayList c() {
            return this.f14254a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return t.a(this.f14254a, aVar.f14254a) && this.f14255b == aVar.f14255b && this.f14256c == aVar.f14256c;
        }

        public int hashCode() {
            return (((this.f14254a.hashCode() * 31) + androidx.privacysandbox.ads.adservices.adid.a.a(this.f14255b)) * 31) + androidx.privacysandbox.ads.adservices.adid.a.a(this.f14256c);
        }

        public String toString() {
            return "SearchData(searchResults=" + this.f14254a + ", firstRequest=" + this.f14255b + ", hasMoreResults=" + this.f14256c + ')';
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14257a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ O f14258b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f14259c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f14260d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f14261e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(O o5, Context context, String str, int i5, C2308e eVar) {
            super(2, eVar);
            this.f14258b = o5;
            this.f14259c = context;
            this.f14260d = str;
            this.f14261e = i5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f14258b, this.f14259c, this.f14260d, this.f14261e, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f14257a == 0) {
                u.b(obj);
                this.f14258b.f14251a.setValue(O.a.f26507a);
                ArrayList arrayList = new ArrayList();
                M f12 = new Z(this.f14259c).f1(this.f14260d, 30, this.f14261e);
                boolean z4 = false;
                boolean z5 = true;
                if (!f12.b() && f12.e() != null) {
                    JSONObject e5 = f12.e();
                    t.b(e5);
                    JSONObject optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                    if (optJSONObject != null) {
                        JSONArray optJSONArray = optJSONObject.optJSONArray("results");
                        if (e5.optInt("success") == 1 && optJSONArray != null) {
                            int length = optJSONArray.length();
                            for (int i5 = 0; i5 < length; i5++) {
                                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i5);
                                C2657f.b bVar = C2657f.f25002J0;
                                t.b(optJSONObject2);
                                C2657f b5 = C2657f.b.b(bVar, optJSONObject2, (Context) null, 2, (Object) null);
                                arrayList.add(b5);
                                s.h().l(b5.H()).d();
                            }
                        }
                    }
                }
                if (this.f14261e <= 0) {
                    z4 = true;
                } else if (arrayList.size() < 29) {
                    z5 = false;
                }
                this.f14258b.f14251a.setValue(new O.c(new a(arrayList, z4, z5)));
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public O() {
        w a5 = F.a(O.b.f26508a);
        this.f14251a = a5;
        this.f14252b = a5;
    }

    public final void b(Context context, String str, int i5) {
        t.e(context, "context");
        t.e(str, "textToSearch");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new b(this, context, str, i5, (C2308e) null), 2, (Object) null);
    }

    public final D c() {
        return this.f14252b;
    }

    public final boolean d() {
        return this.f14253c;
    }

    public final void e(boolean z4) {
        this.f14253c = z4;
    }
}
