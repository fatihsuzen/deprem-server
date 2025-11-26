package com.uptodown.activities;

import B2.s;
import O1.C0738a2;
import O1.C0747b2;
import O1.C0756c2;
import O1.C0765d2;
import O1.C0773e2;
import O1.X1;
import O1.Z1;
import S1.k;
import W2.C2223l;
import W2.J;
import W2.u;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import g2.C2392n;
import h2.C2416h0;
import h2.C2445w0;
import i2.f2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import k3.p;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.t;
import l2.C2645E;
import l2.C2657f;
import l2.C2660i;
import l2.C2668q;
import org.json.JSONArray;
import org.json.JSONObject;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.I0;
import w3.M;
import w3.O;
import z2.C2962v;
import z2.Z;

public final class MoreInfo extends C1598a {

    /* renamed from: K  reason: collision with root package name */
    private final LifecycleCoroutineScope f14088K = LifecycleOwnerKt.getLifecycleScope(this);

    /* renamed from: L  reason: collision with root package name */
    private final C2223l f14089L = W2.m.b(new X1(this));
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public f2 f14090M;
    /* access modifiers changed from: private */

    /* renamed from: N  reason: collision with root package name */
    public C2657f f14091N;
    /* access modifiers changed from: private */

    /* renamed from: O  reason: collision with root package name */
    public ArrayList f14092O;
    /* access modifiers changed from: private */

    /* renamed from: P  reason: collision with root package name */
    public ArrayList f14093P;
    /* access modifiers changed from: private */

    /* renamed from: Q  reason: collision with root package name */
    public ArrayList f14094Q;

    /* renamed from: R  reason: collision with root package name */
    private final int f14095R = 2;

    public final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final C2668q f14096a;

        public a(C2668q qVar) {
            this.f14096a = qVar;
        }

        public void run() {
            String str;
            if (MoreInfo.this.f14090M != null) {
                f2 B32 = MoreInfo.this.f14090M;
                t.b(B32);
                C2668q qVar = this.f14096a;
                if (qVar != null) {
                    str = qVar.w();
                } else {
                    str = null;
                }
                B32.b0(str);
            }
        }
    }

    static final class b extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14098a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MoreInfo f14099b;

        static final class a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f14100a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ MoreInfo f14101b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(MoreInfo moreInfo, C2308e eVar) {
                super(2, eVar);
                this.f14101b = moreInfo;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f14101b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f14100a == 0) {
                    u.b(obj);
                    ArrayList u32 = this.f14101b.f14092O;
                    if (u32 != null && !u32.isEmpty()) {
                        this.f14101b.K3().f23113F.setVisibility(0);
                        TextView textView = this.f14101b.K3().f23155b0;
                        k.a aVar = S1.k.f32g;
                        textView.setTypeface(aVar.w());
                        this.f14101b.K3().f23157c0.setTypeface(aVar.x());
                        ArrayList u33 = this.f14101b.f14092O;
                        t.b(u33);
                        Iterator it = u33.iterator();
                        t.d(it, "iterator(...)");
                        String str = null;
                        while (it.hasNext()) {
                            Object next = it.next();
                            t.d(next, "next(...)");
                            String str2 = (String) next;
                            if (str == null) {
                                str = str2;
                            } else {
                                str = str + ", " + str2;
                            }
                        }
                        this.f14101b.K3().f23157c0.setText(str);
                    }
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(MoreInfo moreInfo, C2308e eVar) {
            super(2, eVar);
            this.f14099b = moreInfo;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f14099b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            JSONArray optJSONArray;
            Object f5 = C2316b.f();
            int i5 = this.f14098a;
            if (i5 == 0) {
                u.b(obj);
                Context applicationContext = this.f14099b.getApplicationContext();
                t.d(applicationContext, "getApplicationContext(...)");
                Z z4 = new Z(applicationContext);
                C2657f v32 = this.f14099b.f14091N;
                t.b(v32);
                l2.M m5 = z4.m(v32.e());
                if (!m5.b() && m5.e() != null) {
                    JSONObject e5 = m5.e();
                    t.b(e5);
                    if (e5.optInt("success") == 1 && (optJSONArray = e5.optJSONArray(DataSchemeDataSource.SCHEME_DATA)) != null) {
                        this.f14099b.f14092O = new ArrayList();
                        int length = optJSONArray.length();
                        for (int i6 = 0; i6 < length; i6++) {
                            ArrayList u32 = this.f14099b.f14092O;
                            t.b(u32);
                            u32.add(optJSONArray.get(i6).toString());
                        }
                    }
                    I0 c5 = C2865c0.c();
                    a aVar = new a(this.f14099b, (C2308e) null);
                    this.f14098a = 1;
                    if (C2872g.g(c5, aVar, this) == f5) {
                        return f5;
                    }
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class c extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f14102a;

        /* renamed from: b  reason: collision with root package name */
        Object f14103b;

        /* renamed from: c  reason: collision with root package name */
        /* synthetic */ Object f14104c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ MoreInfo f14105d;

        /* renamed from: e  reason: collision with root package name */
        int f14106e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(MoreInfo moreInfo, C2308e eVar) {
            super(eVar);
            this.f14105d = moreInfo;
        }

        public final Object invokeSuspend(Object obj) {
            this.f14104c = obj;
            this.f14106e |= Integer.MIN_VALUE;
            return this.f14105d.L3(this);
        }
    }

    static final class d extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14107a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MoreInfo f14108b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ L f14109c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(MoreInfo moreInfo, L l5, C2308e eVar) {
            super(2, eVar);
            this.f14108b = moreInfo;
            this.f14109c = l5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f14108b, this.f14109c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            String d5;
            JSONArray optJSONArray;
            C2316b.f();
            if (this.f14107a == 0) {
                u.b(obj);
                Context applicationContext = this.f14108b.getApplicationContext();
                t.d(applicationContext, "getApplicationContext(...)");
                Z z4 = new Z(applicationContext);
                C2657f v32 = this.f14108b.f14091N;
                t.b(v32);
                l2.M p5 = z4.p(v32.e());
                if (!(p5.b() || (d5 = p5.d()) == null || d5.length() == 0)) {
                    String d6 = p5.d();
                    t.b(d6);
                    JSONObject jSONObject = new JSONObject(d6);
                    if (jSONObject.optInt("success") == 1 && (optJSONArray = jSONObject.optJSONArray(DataSchemeDataSource.SCHEME_DATA)) != null) {
                        this.f14109c.f24690a = new ArrayList();
                        int length = optJSONArray.length();
                        for (int i5 = 0; i5 < length; i5++) {
                            Object obj2 = this.f14109c.f24690a;
                            t.b(obj2);
                            ((ArrayList) obj2).add(optJSONArray.getString(i5));
                        }
                    }
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class e extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14110a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ L f14111b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ MoreInfo f14112c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(L l5, MoreInfo moreInfo, C2308e eVar) {
            super(2, eVar);
            this.f14111b = l5;
            this.f14112c = moreInfo;
        }

        /* access modifiers changed from: private */
        public static final void e(MoreInfo moreInfo, View view) {
            LinearLayout linearLayout = moreInfo.K3().f23103A;
            t.d(linearLayout, "llLanguagesList");
            if (linearLayout.getVisibility() == 0) {
                moreInfo.K3().f23103A.setVisibility(8);
                moreInfo.K3().f23176m.setImageResource(R.drawable.vector_more_info_expand);
                return;
            }
            moreInfo.K3().f23103A.setVisibility(0);
            moreInfo.K3().f23176m.setImageResource(R.drawable.vector_more_info_collapse);
            moreInfo.K3().f23151Z.post(new r(moreInfo));
        }

        /* access modifiers changed from: private */
        public static final void f(MoreInfo moreInfo) {
            moreInfo.K3().f23151Z.smoothScrollTo(0, moreInfo.K3().f23129N.getTop());
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f14111b, this.f14112c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            String str;
            C2316b.f();
            if (this.f14110a == 0) {
                u.b(obj);
                Collection collection = (Collection) this.f14111b.f24690a;
                if (collection == null || collection.isEmpty()) {
                    this.f14112c.K3().f23129N.setVisibility(8);
                } else {
                    this.f14112c.K3().f23129N.setVisibility(0);
                    TextView textView = this.f14112c.K3().f23195v0;
                    k.a aVar = S1.k.f32g;
                    textView.setTypeface(aVar.w());
                    this.f14112c.K3().f23197w0.setTypeface(aVar.x());
                    String n5 = com.uptodown.activities.preferences.a.f15150a.n(this.f14112c);
                    String[] stringArray = this.f14112c.getResources().getStringArray(R.array.languageCodes);
                    t.d(stringArray, "getStringArray(...)");
                    String[] stringArray2 = this.f14112c.getResources().getStringArray(R.array.localizedLang);
                    t.d(stringArray2, "getStringArray(...)");
                    int length = stringArray.length;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= length) {
                            str = "";
                            break;
                        } else if (stringArray[i5].equals(n5)) {
                            str = stringArray2[i5];
                            break;
                        } else {
                            i5++;
                        }
                    }
                    if (str.length() > 0) {
                        Object obj2 = this.f14111b.f24690a;
                        t.b(obj2);
                        if (((ArrayList) obj2).contains(str)) {
                            Object obj3 = this.f14111b.f24690a;
                            t.b(obj3);
                            this.f14112c.K3().f23197w0.setText(this.f14112c.getString(R.string.app_info_languages, new Object[]{str, String.valueOf(((ArrayList) obj3).size() - 1)}));
                            this.f14112c.K3().f23129N.setOnClickListener(new C1614q(this.f14112c));
                            MoreInfo moreInfo = this.f14112c;
                            moreInfo.T3((ArrayList) this.f14111b.f24690a, moreInfo.K3().f23103A);
                        }
                    }
                    TextView textView2 = this.f14112c.K3().f23197w0;
                    Object obj4 = this.f14111b.f24690a;
                    t.b(obj4);
                    textView2.setText(String.valueOf(((ArrayList) obj4).size()));
                    this.f14112c.K3().f23129N.setOnClickListener(new C1614q(this.f14112c));
                    MoreInfo moreInfo2 = this.f14112c;
                    moreInfo2.T3((ArrayList) this.f14111b.f24690a, moreInfo2.K3().f23103A);
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class f extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f14113a;

        /* renamed from: b  reason: collision with root package name */
        Object f14114b;

        /* renamed from: c  reason: collision with root package name */
        /* synthetic */ Object f14115c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ MoreInfo f14116d;

        /* renamed from: e  reason: collision with root package name */
        int f14117e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(MoreInfo moreInfo, C2308e eVar) {
            super(eVar);
            this.f14116d = moreInfo;
        }

        public final Object invokeSuspend(Object obj) {
            this.f14115c = obj;
            this.f14117e |= Integer.MIN_VALUE;
            return this.f14116d.M3(this);
        }
    }

    static final class g extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14118a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MoreInfo f14119b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(MoreInfo moreInfo, C2308e eVar) {
            super(2, eVar);
            this.f14119b = moreInfo;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new g(this.f14119b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f14118a == 0) {
                u.b(obj);
                this.f14119b.K3().f23111E.setVisibility(0);
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((g) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class h extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14120a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MoreInfo f14121b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.J f14122c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(MoreInfo moreInfo, kotlin.jvm.internal.J j5, C2308e eVar) {
            super(2, eVar);
            this.f14121b = moreInfo;
            this.f14122c = j5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new h(this.f14121b, this.f14122c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f14120a == 0) {
                u.b(obj);
                Context applicationContext = this.f14121b.getApplicationContext();
                t.d(applicationContext, "getApplicationContext(...)");
                Z z4 = new Z(applicationContext);
                C2657f v32 = this.f14121b.f14091N;
                t.b(v32);
                l2.M S4 = z4.S(v32.e());
                if (!S4.b() && S4.e() != null) {
                    JSONObject e5 = S4.e();
                    t.b(e5);
                    if (!e5.isNull("success")) {
                        this.f14122c.f24688a = e5.optInt("success");
                    }
                    JSONObject optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                    if (this.f14122c.f24688a == 1 && optJSONObject != null) {
                        this.f14121b.f14093P = new ArrayList();
                        JSONArray optJSONArray = optJSONObject.optJSONArray("permissions_concern");
                        if (optJSONArray != null) {
                            int length = optJSONArray.length();
                            for (int i5 = 0; i5 < length; i5++) {
                                C2645E e6 = new C2645E();
                                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i5);
                                t.d(optJSONObject2, "optJSONObject(...)");
                                e6.a(optJSONObject2);
                                ArrayList x32 = this.f14121b.f14093P;
                                t.b(x32);
                                x32.add(e6);
                            }
                        }
                        this.f14121b.f14094Q = new ArrayList();
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("permissions");
                        if (optJSONArray2 != null) {
                            int length2 = optJSONArray2.length();
                            for (int i6 = 0; i6 < length2; i6++) {
                                C2645E e7 = new C2645E();
                                JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i6);
                                t.d(optJSONObject3, "optJSONObject(...)");
                                e7.a(optJSONObject3);
                                ArrayList z32 = this.f14121b.f14094Q;
                                t.b(z32);
                                z32.add(e7);
                            }
                        }
                    }
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((h) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class i extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14123a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.J f14124b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ MoreInfo f14125c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(kotlin.jvm.internal.J j5, MoreInfo moreInfo, C2308e eVar) {
            super(2, eVar);
            this.f14124b = j5;
            this.f14125c = moreInfo;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new i(this.f14124b, this.f14125c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            int i5;
            C2316b.f();
            if (this.f14123a == 0) {
                u.b(obj);
                if (this.f14124b.f24688a == 1) {
                    this.f14125c.K3().f23137R.setVisibility(0);
                    ArrayList x32 = this.f14125c.f14093P;
                    if (x32 == null || x32.isEmpty()) {
                        this.f14125c.K3().f23137R.setVisibility(8);
                        i5 = 0;
                    } else {
                        MoreInfo moreInfo = this.f14125c;
                        moreInfo.d4(moreInfo.f14093P, this.f14125c.K3().f23202z);
                        ArrayList x33 = this.f14125c.f14093P;
                        t.b(x33);
                        i5 = x33.size();
                    }
                    ArrayList z32 = this.f14125c.f14094Q;
                    if (z32 != null && !z32.isEmpty()) {
                        MoreInfo moreInfo2 = this.f14125c;
                        moreInfo2.d4(moreInfo2.f14094Q, this.f14125c.K3().f23107C);
                        ArrayList z33 = this.f14125c.f14094Q;
                        t.b(z33);
                        i5 += z33.size();
                    }
                    C2657f v32 = this.f14125c.f14091N;
                    if (v32 != null && v32.U() == 0) {
                        this.f14125c.K3().f23116G0.setText(String.valueOf(i5));
                    }
                } else {
                    this.f14125c.K3().f23137R.setVisibility(8);
                }
                this.f14125c.K3().f23111E.setVisibility(8);
                this.f14125c.K3().f23151Z.setVisibility(0);
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((i) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class j extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14126a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MoreInfo f14127b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(MoreInfo moreInfo, C2308e eVar) {
            super(2, eVar);
            this.f14127b = moreInfo;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new j(this.f14127b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14126a;
            if (i5 == 0) {
                u.b(obj);
                MoreInfo moreInfo = this.f14127b;
                this.f14126a = 1;
                if (moreInfo.M3(this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((j) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class k extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14128a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MoreInfo f14129b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(MoreInfo moreInfo, C2308e eVar) {
            super(2, eVar);
            this.f14129b = moreInfo;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new k(this.f14129b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14128a;
            if (i5 == 0) {
                u.b(obj);
                MoreInfo moreInfo = this.f14129b;
                this.f14128a = 1;
                if (moreInfo.J3(this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((k) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class l extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14130a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MoreInfo f14131b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(MoreInfo moreInfo, C2308e eVar) {
            super(2, eVar);
            this.f14131b = moreInfo;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new l(this.f14131b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14130a;
            if (i5 == 0) {
                u.b(obj);
                MoreInfo moreInfo = this.f14131b;
                this.f14130a = 1;
                if (moreInfo.L3(this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((l) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class m implements k2.Z {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoreInfo f14132a;

        m(MoreInfo moreInfo) {
            this.f14132a = moreInfo;
        }

        public void a(l2.L l5) {
            t.e(l5, "reportVT");
            Intent intent = new Intent(this.f14132a, VirusTotalReport.class);
            intent.putExtra("appInfo", this.f14132a.f14091N);
            intent.putExtra("appReportVT", l5);
            MoreInfo moreInfo = this.f14132a;
            moreInfo.startActivity(intent, UptodownApp.f13477F.a(moreInfo));
        }

        public void b() {
            C2657f v32 = this.f14132a.f14091N;
            t.b(v32);
            String q02 = v32.q0();
            if (!(q02 == null || q02.length() == 0)) {
                C2657f v33 = this.f14132a.f14091N;
                t.b(v33);
                String q03 = v33.q0();
                t.b(q03);
                if (Long.parseLong(q03) > 650000000) {
                    Intent intent = new Intent(this.f14132a, VirusTotalReport.class);
                    intent.putExtra("appInfo", this.f14132a.f14091N);
                    intent.putExtra("isVirusTotalReportAvaialable", false);
                    MoreInfo moreInfo = this.f14132a;
                    moreInfo.startActivity(intent, UptodownApp.f13477F.a(moreInfo));
                    return;
                }
            }
            MoreInfo moreInfo2 = this.f14132a;
            C2657f v34 = moreInfo2.f14091N;
            t.b(v34);
            moreInfo2.L2(v34.n0());
        }
    }

    /* access modifiers changed from: private */
    public static final C2416h0 H3(MoreInfo moreInfo) {
        return C2416h0.c(moreInfo.getLayoutInflater());
    }

    private final void I3(TextView textView, View view) {
        view.setVisibility(8);
        int maxLines = textView.getMaxLines();
        int i5 = this.f14095R;
        if (maxLines == i5) {
            textView.setMaxLines(Integer.MAX_VALUE);
        } else {
            textView.setMaxLines(i5);
        }
        view.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final Object J3(C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new b(this, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final C2416h0 K3() {
        return (C2416h0) this.f14089L.getValue();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0073, code lost:
        if (w3.C2872g.g(r8, r6, r0) != r1) goto L_0x0076;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object L3(b3.C2308e r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.uptodown.activities.MoreInfo.c
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.uptodown.activities.MoreInfo$c r0 = (com.uptodown.activities.MoreInfo.c) r0
            int r1 = r0.f14106e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f14106e = r1
            goto L_0x0018
        L_0x0013:
            com.uptodown.activities.MoreInfo$c r0 = new com.uptodown.activities.MoreInfo$c
            r0.<init>(r7, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f14104c
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f14106e
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            W2.u.b(r8)
            goto L_0x0076
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0035:
            java.lang.Object r2 = r0.f14103b
            kotlin.jvm.internal.L r2 = (kotlin.jvm.internal.L) r2
            java.lang.Object r4 = r0.f14102a
            com.uptodown.activities.MoreInfo r4 = (com.uptodown.activities.MoreInfo) r4
            W2.u.b(r8)
            goto L_0x0060
        L_0x0041:
            W2.u.b(r8)
            kotlin.jvm.internal.L r2 = new kotlin.jvm.internal.L
            r2.<init>()
            w3.I r8 = w3.C2865c0.b()
            com.uptodown.activities.MoreInfo$d r6 = new com.uptodown.activities.MoreInfo$d
            r6.<init>(r7, r2, r5)
            r0.f14102a = r7
            r0.f14103b = r2
            r0.f14106e = r4
            java.lang.Object r8 = w3.C2872g.g(r8, r6, r0)
            if (r8 != r1) goto L_0x005f
            goto L_0x0075
        L_0x005f:
            r4 = r7
        L_0x0060:
            w3.I0 r8 = w3.C2865c0.c()
            com.uptodown.activities.MoreInfo$e r6 = new com.uptodown.activities.MoreInfo$e
            r6.<init>(r2, r4, r5)
            r0.f14102a = r5
            r0.f14103b = r5
            r0.f14106e = r3
            java.lang.Object r8 = w3.C2872g.g(r8, r6, r0)
            if (r8 != r1) goto L_0x0076
        L_0x0075:
            return r1
        L_0x0076:
            W2.J r8 = W2.J.f19942a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MoreInfo.L3(b3.e):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x009b, code lost:
        if (w3.C2872g.g(r9, r5, r0) != r1) goto L_0x009e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object M3(b3.C2308e r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.uptodown.activities.MoreInfo.f
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.uptodown.activities.MoreInfo$f r0 = (com.uptodown.activities.MoreInfo.f) r0
            int r1 = r0.f14117e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f14117e = r1
            goto L_0x0018
        L_0x0013:
            com.uptodown.activities.MoreInfo$f r0 = new com.uptodown.activities.MoreInfo$f
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f14115c
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f14117e
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0051
            if (r2 == r5) goto L_0x0045
            if (r2 == r4) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            W2.u.b(r9)
            goto L_0x009e
        L_0x0031:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0039:
            java.lang.Object r2 = r0.f14114b
            kotlin.jvm.internal.J r2 = (kotlin.jvm.internal.J) r2
            java.lang.Object r4 = r0.f14113a
            com.uptodown.activities.MoreInfo r4 = (com.uptodown.activities.MoreInfo) r4
            W2.u.b(r9)
            goto L_0x0088
        L_0x0045:
            java.lang.Object r2 = r0.f14114b
            kotlin.jvm.internal.J r2 = (kotlin.jvm.internal.J) r2
            java.lang.Object r5 = r0.f14113a
            com.uptodown.activities.MoreInfo r5 = (com.uptodown.activities.MoreInfo) r5
            W2.u.b(r9)
            goto L_0x0071
        L_0x0051:
            W2.u.b(r9)
            kotlin.jvm.internal.J r9 = new kotlin.jvm.internal.J
            r9.<init>()
            w3.I0 r2 = w3.C2865c0.c()
            com.uptodown.activities.MoreInfo$g r7 = new com.uptodown.activities.MoreInfo$g
            r7.<init>(r8, r6)
            r0.f14113a = r8
            r0.f14114b = r9
            r0.f14117e = r5
            java.lang.Object r2 = w3.C2872g.g(r2, r7, r0)
            if (r2 != r1) goto L_0x006f
            goto L_0x009d
        L_0x006f:
            r5 = r8
            r2 = r9
        L_0x0071:
            w3.I r9 = w3.C2865c0.b()
            com.uptodown.activities.MoreInfo$h r7 = new com.uptodown.activities.MoreInfo$h
            r7.<init>(r5, r2, r6)
            r0.f14113a = r5
            r0.f14114b = r2
            r0.f14117e = r4
            java.lang.Object r9 = w3.C2872g.g(r9, r7, r0)
            if (r9 != r1) goto L_0x0087
            goto L_0x009d
        L_0x0087:
            r4 = r5
        L_0x0088:
            w3.I0 r9 = w3.C2865c0.c()
            com.uptodown.activities.MoreInfo$i r5 = new com.uptodown.activities.MoreInfo$i
            r5.<init>(r2, r4, r6)
            r0.f14113a = r6
            r0.f14114b = r6
            r0.f14117e = r3
            java.lang.Object r9 = w3.C2872g.g(r9, r5, r0)
            if (r9 != r1) goto L_0x009e
        L_0x009d:
            return r1
        L_0x009e:
            W2.J r9 = W2.J.f19942a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MoreInfo.M3(b3.e):java.lang.Object");
    }

    private final void N3(TextView textView, View view) {
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new C0738a2(textView, this, view));
    }

    /* access modifiers changed from: private */
    public static final void O3(TextView textView, MoreInfo moreInfo, View view) {
        if (s.a(textView)) {
            textView.setOnClickListener(new C0747b2(moreInfo, textView, view));
        }
    }

    /* access modifiers changed from: private */
    public static final void P3(MoreInfo moreInfo, TextView textView, View view, View view2) {
        moreInfo.I3(textView, view);
    }

    /* access modifiers changed from: private */
    public static final void Q3(MoreInfo moreInfo, View view) {
        moreInfo.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: private */
    public static final void R3(View view) {
    }

    private final void S3() {
        C2657f fVar = this.f14091N;
        t.b(fVar);
        String valueOf = String.valueOf(fVar.A());
        C2657f fVar2 = this.f14091N;
        t.b(fVar2);
        new C2392n(this, valueOf, fVar2.n0(), new m(this), LifecycleOwnerKt.getLifecycleScope(this));
    }

    /* access modifiers changed from: private */
    public final void T3(ArrayList arrayList, LinearLayout linearLayout) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        t.b(arrayList);
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            C2445w0 c5 = C2445w0.c(LayoutInflater.from(getApplicationContext()));
            t.d(c5, "inflate(...)");
            c5.getRoot().setLayoutParams(layoutParams);
            c5.f23654b.setTypeface(S1.k.f32g.x());
            TextView textView = c5.f23654b;
            Object obj = arrayList.get(i5);
            t.d(obj, "get(...)");
            String upperCase = ((String) obj).toUpperCase(Locale.ROOT);
            t.d(upperCase, "toUpperCase(...)");
            textView.setText(upperCase);
            t.b(linearLayout);
            linearLayout.addView(c5.getRoot());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0584  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x05bf  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x05fa  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0205  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0222  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x027f  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x02e0  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x02f4  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0516  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0527  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0549  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void U3() {
        /*
            r8 = this;
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23106B0
            S1.k$a r1 = S1.k.f32g
            android.graphics.Typeface r2 = r1.w()
            r0.setTypeface(r2)
            l2.f r0 = r8.f14091N
            kotlin.jvm.internal.t.b(r0)
            java.lang.String r0 = r0.S()
            r2 = 8
            if (r0 == 0) goto L_0x004e
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0023
            goto L_0x004e
        L_0x0023:
            l2.f r0 = r8.f14091N
            kotlin.jvm.internal.t.b(r0)
            boolean r0 = r0.O0()
            if (r0 != 0) goto L_0x004e
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23108C0
            android.graphics.Typeface r3 = r1.x()
            r0.setTypeface(r3)
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23108C0
            l2.f r3 = r8.f14091N
            kotlin.jvm.internal.t.b(r3)
            java.lang.String r3 = r3.S()
            r0.setText(r3)
            goto L_0x0057
        L_0x004e:
            h2.h0 r0 = r8.K3()
            android.widget.RelativeLayout r0 = r0.f23133P
            r0.setVisibility(r2)
        L_0x0057:
            l2.f r0 = r8.f14091N
            kotlin.jvm.internal.t.b(r0)
            java.lang.String r0 = r0.B0()
            if (r0 == 0) goto L_0x0096
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0069
            goto L_0x0096
        L_0x0069:
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23144U0
            android.graphics.Typeface r3 = r1.w()
            r0.setTypeface(r3)
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23146V0
            android.graphics.Typeface r3 = r1.x()
            r0.setTypeface(r3)
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23146V0
            l2.f r3 = r8.f14091N
            kotlin.jvm.internal.t.b(r3)
            java.lang.String r3 = r3.B0()
            r0.setText(r3)
            goto L_0x009f
        L_0x0096:
            h2.h0 r0 = r8.K3()
            android.widget.RelativeLayout r0 = r0.f23149X
            r0.setVisibility(r2)
        L_0x009f:
            l2.f r0 = r8.f14091N
            kotlin.jvm.internal.t.b(r0)
            l2.i r0 = r0.h()
            r3 = 2131100495(0x7f06034f, float:1.7813373E38)
            if (r0 == 0) goto L_0x012a
            l2.f r0 = r8.f14091N
            kotlin.jvm.internal.t.b(r0)
            l2.i r0 = r0.h()
            if (r0 == 0) goto L_0x00bd
            java.lang.String r0 = r0.e()
            goto L_0x00be
        L_0x00bd:
            r0 = 0
        L_0x00be:
            if (r0 == 0) goto L_0x012a
            int r0 = r0.length()
            if (r0 != 0) goto L_0x00c7
            goto L_0x012a
        L_0x00c7:
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23171j0
            android.graphics.Typeface r4 = r1.w()
            r0.setTypeface(r4)
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23173k0
            android.graphics.Typeface r4 = r1.w()
            r0.setTypeface(r4)
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23173k0
            l2.f r4 = r8.f14091N
            kotlin.jvm.internal.t.b(r4)
            l2.i r4 = r4.h()
            kotlin.jvm.internal.t.b(r4)
            java.lang.String r4 = r4.e()
            r0.setText(r4)
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23173k0
            int r4 = androidx.core.content.ContextCompat.getColor(r8, r3)
            r0.setTextColor(r4)
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23173k0
            h2.h0 r4 = r8.K3()
            android.widget.TextView r4 = r4.f23173k0
            int r4 = r4.getPaintFlags()
            r4 = r4 | r2
            r0.setPaintFlags(r4)
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23173k0
            O1.f2 r4 = new O1.f2
            r4.<init>(r8)
            r0.setOnClickListener(r4)
            goto L_0x0133
        L_0x012a:
            h2.h0 r0 = r8.K3()
            android.widget.RelativeLayout r0 = r0.f23119I
            r0.setVisibility(r2)
        L_0x0133:
            l2.f r0 = r8.f14091N
            kotlin.jvm.internal.t.b(r0)
            java.lang.String r0 = r0.g()
            if (r0 == 0) goto L_0x01b3
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0145
            goto L_0x01b3
        L_0x0145:
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23165g0
            android.graphics.Typeface r4 = r1.w()
            r0.setTypeface(r4)
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23167h0
            android.graphics.Typeface r4 = r1.w()
            r0.setTypeface(r4)
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23167h0
            l2.f r4 = r8.f14091N
            kotlin.jvm.internal.t.b(r4)
            java.lang.String r4 = r4.g()
            r0.setText(r4)
            l2.f r0 = r8.f14091N
            kotlin.jvm.internal.t.b(r0)
            java.lang.String r0 = r0.E0()
            if (r0 == 0) goto L_0x01bc
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0183
            goto L_0x01bc
        L_0x0183:
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23167h0
            int r3 = androidx.core.content.ContextCompat.getColor(r8, r3)
            r0.setTextColor(r3)
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23167h0
            h2.h0 r3 = r8.K3()
            android.widget.TextView r3 = r3.f23167h0
            int r3 = r3.getPaintFlags()
            r3 = r3 | r2
            r0.setPaintFlags(r3)
            h2.h0 r0 = r8.K3()
            android.widget.RelativeLayout r0 = r0.f23117H
            O1.g2 r3 = new O1.g2
            r3.<init>(r8)
            r0.setOnClickListener(r3)
            goto L_0x01bc
        L_0x01b3:
            h2.h0 r0 = r8.K3()
            android.widget.RelativeLayout r0 = r0.f23117H
            r0.setVisibility(r2)
        L_0x01bc:
            l2.f r0 = r8.f14091N
            kotlin.jvm.internal.t.b(r0)
            java.lang.String r0 = r0.I()
            if (r0 == 0) goto L_0x01cd
            int r0 = r0.length()
            if (r0 != 0) goto L_0x01d8
        L_0x01cd:
            l2.f r0 = r8.f14091N
            kotlin.jvm.internal.t.b(r0)
            boolean r0 = r0.M0()
            if (r0 != 0) goto L_0x0205
        L_0x01d8:
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23177m0
            android.graphics.Typeface r3 = r1.w()
            r0.setTypeface(r3)
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23179n0
            android.graphics.Typeface r3 = r1.x()
            r0.setTypeface(r3)
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23179n0
            l2.f r3 = r8.f14091N
            kotlin.jvm.internal.t.b(r3)
            java.lang.String r3 = r3.I()
            r0.setText(r3)
            goto L_0x020e
        L_0x0205:
            h2.h0 r0 = r8.K3()
            android.widget.RelativeLayout r0 = r0.f23121J
            r0.setVisibility(r2)
        L_0x020e:
            l2.f r0 = r8.f14091N
            kotlin.jvm.internal.t.b(r0)
            java.lang.String r0 = r0.T()
            r3 = 0
            r4 = 1
            if (r0 == 0) goto L_0x027f
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0222
            goto L_0x027f
        L_0x0222:
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23110D0
            android.graphics.Typeface r5 = r1.w()
            r0.setTypeface(r5)
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23112E0
            android.graphics.Typeface r5 = r1.x()
            r0.setTypeface(r5)
            l2.f r0 = r8.f14091N
            kotlin.jvm.internal.t.b(r0)
            java.lang.String r0 = r0.T()
            kotlin.jvm.internal.t.b(r0)
            java.lang.Integer r0 = t3.s.t(r0)
            if (r0 == 0) goto L_0x026c
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23112E0
            l2.f r5 = r8.f14091N
            kotlin.jvm.internal.t.b(r5)
            java.lang.String r5 = r5.T()
            java.lang.Object[] r6 = new java.lang.Object[r4]
            r6[r3] = r5
            r5 = 2131952536(0x7f130398, float:1.9541518E38)
            java.lang.String r5 = r8.getString(r5, r6)
            r0.setText(r5)
            goto L_0x0288
        L_0x026c:
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23112E0
            l2.f r5 = r8.f14091N
            kotlin.jvm.internal.t.b(r5)
            java.lang.String r5 = r5.T()
            r0.setText(r5)
            goto L_0x0288
        L_0x027f:
            h2.h0 r0 = r8.K3()
            android.widget.RelativeLayout r0 = r0.f23135Q
            r0.setVisibility(r2)
        L_0x0288:
            l2.f r0 = r8.f14091N
            kotlin.jvm.internal.t.b(r0)
            java.lang.String r0 = r0.C0()
            if (r0 == 0) goto L_0x02e0
            int r0 = r0.length()
            if (r0 != 0) goto L_0x029a
            goto L_0x02e0
        L_0x029a:
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23122J0
            android.graphics.Typeface r5 = r1.w()
            r0.setTypeface(r5)
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23124K0
            android.graphics.Typeface r5 = r1.x()
            r0.setTypeface(r5)
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23124K0
            l2.f r5 = r8.f14091N
            kotlin.jvm.internal.t.b(r5)
            java.lang.String r5 = r5.C0()
            r0.setText(r5)
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23124K0
            java.lang.String r5 = "tvReqMoreInfo"
            kotlin.jvm.internal.t.d(r0, r5)
            h2.h0 r5 = r8.K3()
            android.view.View r5 = r5.f23148W0
            java.lang.String r6 = "vReqMoreInfo"
            kotlin.jvm.internal.t.d(r5, r6)
            r8.N3(r0, r5)
            goto L_0x02e9
        L_0x02e0:
            h2.h0 r0 = r8.K3()
            android.widget.RelativeLayout r0 = r0.f23141T
            r0.setVisibility(r2)
        L_0x02e9:
            l2.f r0 = r8.f14091N
            kotlin.jvm.internal.t.b(r0)
            boolean r0 = r0.O0()
            if (r0 != 0) goto L_0x042b
            l2.f r0 = r8.f14091N
            kotlin.jvm.internal.t.b(r0)
            boolean r0 = r0.M0()
            if (r0 != 0) goto L_0x042b
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23187r0
            android.graphics.Typeface r5 = r1.w()
            r0.setTypeface(r5)
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23189s0
            android.graphics.Typeface r5 = r1.x()
            r0.setTypeface(r5)
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23189s0
            z2.v r5 = new z2.v
            r5.<init>()
            l2.f r6 = r8.f14091N
            kotlin.jvm.internal.t.b(r6)
            int r6 = r6.q()
            java.lang.String r5 = r5.i(r6, r8)
            r0.setText(r5)
            l2.f r0 = r8.f14091N
            kotlin.jvm.internal.t.b(r0)
            java.lang.String r0 = r0.n0()
            if (r0 == 0) goto L_0x0381
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0346
            goto L_0x0381
        L_0x0346:
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23128M0
            android.graphics.Typeface r5 = r1.w()
            r0.setTypeface(r5)
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23130N0
            android.graphics.Typeface r5 = r1.x()
            r0.setTypeface(r5)
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23130N0
            l2.f r5 = r8.f14091N
            kotlin.jvm.internal.t.b(r5)
            java.lang.String r5 = r5.n0()
            r0.setText(r5)
            h2.h0 r0 = r8.K3()
            android.widget.ImageView r0 = r0.f23162f
            O1.h2 r5 = new O1.h2
            r5.<init>(r8)
            r0.setOnClickListener(r5)
            goto L_0x038a
        L_0x0381:
            h2.h0 r0 = r8.K3()
            android.widget.RelativeLayout r0 = r0.f23143U
            r0.setVisibility(r2)
        L_0x038a:
            l2.f r0 = r8.f14091N
            kotlin.jvm.internal.t.b(r0)
            java.lang.String r0 = r0.q0()
            if (r0 == 0) goto L_0x03d9
            int r0 = r0.length()
            if (r0 != 0) goto L_0x039c
            goto L_0x03d9
        L_0x039c:
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23136Q0
            android.graphics.Typeface r5 = r1.w()
            r0.setTypeface(r5)
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23138R0
            android.graphics.Typeface r5 = r1.x()
            r0.setTypeface(r5)
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23138R0
            b2.k r5 = new b2.k
            r5.<init>()
            l2.f r6 = r8.f14091N
            kotlin.jvm.internal.t.b(r6)
            java.lang.String r6 = r6.q0()
            kotlin.jvm.internal.t.b(r6)
            long r6 = java.lang.Long.parseLong(r6)
            java.lang.String r5 = r5.d(r6, r8)
            r0.setText(r5)
            goto L_0x03e2
        L_0x03d9:
            h2.h0 r0 = r8.K3()
            android.widget.RelativeLayout r0 = r0.f23147W
            r0.setVisibility(r2)
        L_0x03e2:
            l2.f r0 = r8.f14091N
            kotlin.jvm.internal.t.b(r0)
            java.lang.String r0 = r0.K()
            if (r0 == 0) goto L_0x0421
            int r0 = r0.length()
            if (r0 != 0) goto L_0x03f4
            goto L_0x0421
        L_0x03f4:
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23199x0
            android.graphics.Typeface r5 = r1.w()
            r0.setTypeface(r5)
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23201y0
            android.graphics.Typeface r5 = r1.x()
            r0.setTypeface(r5)
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23201y0
            l2.f r5 = r8.f14091N
            kotlin.jvm.internal.t.b(r5)
            java.lang.String r5 = r5.K()
            r0.setText(r5)
            goto L_0x044f
        L_0x0421:
            h2.h0 r0 = r8.K3()
            android.widget.RelativeLayout r0 = r0.f23131O
            r0.setVisibility(r2)
            goto L_0x044f
        L_0x042b:
            h2.h0 r0 = r8.K3()
            android.widget.RelativeLayout r0 = r0.f23125L
            r0.setVisibility(r2)
            h2.h0 r0 = r8.K3()
            android.widget.RelativeLayout r0 = r0.f23143U
            r0.setVisibility(r2)
            h2.h0 r0 = r8.K3()
            android.widget.RelativeLayout r0 = r0.f23147W
            r0.setVisibility(r2)
            h2.h0 r0 = r8.K3()
            android.widget.RelativeLayout r0 = r0.f23131O
            r0.setVisibility(r2)
        L_0x044f:
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23114F0
            android.graphics.Typeface r5 = r1.w()
            r0.setTypeface(r5)
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23116G0
            android.graphics.Typeface r5 = r1.x()
            r0.setTypeface(r5)
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23116G0
            l2.f r5 = r8.f14091N
            kotlin.jvm.internal.t.b(r5)
            int r5 = r5.U()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r0.setText(r5)
            h2.h0 r0 = r8.K3()
            android.widget.RelativeLayout r0 = r0.f23137R
            O1.i2 r5 = new O1.i2
            r5.<init>(r8)
            r0.setOnClickListener(r5)
            l2.f r0 = r8.f14091N
            kotlin.jvm.internal.t.b(r0)
            java.lang.String r0 = r0.m()
            if (r0 == 0) goto L_0x04f1
            int r0 = r0.length()
            if (r0 != 0) goto L_0x049f
            goto L_0x04f1
        L_0x049f:
            h2.h0 r0 = r8.K3()
            android.widget.RelativeLayout r0 = r0.f23123K
            r0.setVisibility(r3)
            l2.f r0 = r8.f14091N
            kotlin.jvm.internal.t.b(r0)
            java.lang.String r3 = "supportedDevice"
            java.lang.String r0 = r0.x0(r3)
            if (r0 == 0) goto L_0x04d2
            int r3 = r0.length()
            if (r3 != 0) goto L_0x04bc
            goto L_0x04d2
        L_0x04bc:
            h2.h0 r3 = r8.K3()
            android.widget.TextView r3 = r3.f23181o0
            android.graphics.Typeface r5 = r1.w()
            r3.setTypeface(r5)
            h2.h0 r3 = r8.K3()
            android.widget.TextView r3 = r3.f23181o0
            r3.setText(r0)
        L_0x04d2:
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23183p0
            android.graphics.Typeface r3 = r1.x()
            r0.setTypeface(r3)
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23183p0
            l2.f r3 = r8.f14091N
            kotlin.jvm.internal.t.b(r3)
            java.lang.String r3 = r3.m()
            r0.setText(r3)
        L_0x04f1:
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23159d0
            android.graphics.Typeface r3 = r1.w()
            r0.setTypeface(r3)
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23161e0
            android.graphics.Typeface r3 = r1.x()
            r0.setTypeface(r3)
            l2.f r0 = r8.f14091N
            kotlin.jvm.internal.t.b(r0)
            int r0 = r0.i()
            if (r0 != r4) goto L_0x0527
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23161e0
            r3 = 2131951833(0x7f1300d9, float:1.9540092E38)
            java.lang.String r3 = r8.getString(r3)
            r0.setText(r3)
            goto L_0x0537
        L_0x0527:
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23161e0
            r3 = 2131951834(0x7f1300da, float:1.9540094E38)
            java.lang.String r3 = r8.getString(r3)
            r0.setText(r3)
        L_0x0537:
            l2.f r0 = r8.f14091N
            kotlin.jvm.internal.t.b(r0)
            java.lang.String r0 = r0.L()
            if (r0 == 0) goto L_0x0584
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0549
            goto L_0x0584
        L_0x0549:
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23132O0
            android.graphics.Typeface r3 = r1.w()
            r0.setTypeface(r3)
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23134P0
            android.graphics.Typeface r3 = r1.x()
            r0.setTypeface(r3)
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23134P0
            l2.f r3 = r8.f14091N
            kotlin.jvm.internal.t.b(r3)
            java.lang.String r3 = r3.L()
            r0.setText(r3)
            h2.h0 r0 = r8.K3()
            android.widget.ImageView r0 = r0.f23164g
            O1.j2 r3 = new O1.j2
            r3.<init>(r8)
            r0.setOnClickListener(r3)
            goto L_0x058d
        L_0x0584:
            h2.h0 r0 = r8.K3()
            android.widget.RelativeLayout r0 = r0.f23145V
            r0.setVisibility(r2)
        L_0x058d:
            l2.f r0 = r8.f14091N
            kotlin.jvm.internal.t.b(r0)
            java.lang.String r0 = r0.q0()
            if (r0 == 0) goto L_0x05ad
            int r0 = r0.length()
            if (r0 != 0) goto L_0x059f
            goto L_0x05ad
        L_0x059f:
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23142T0
            O1.k2 r3 = new O1.k2
            r3.<init>(r8)
            r0.setOnClickListener(r3)
        L_0x05ad:
            l2.f r0 = r8.f14091N
            kotlin.jvm.internal.t.b(r0)
            java.lang.String r0 = r0.B()
            if (r0 == 0) goto L_0x05fa
            int r0 = r0.length()
            if (r0 != 0) goto L_0x05bf
            goto L_0x05fa
        L_0x05bf:
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23191t0
            android.graphics.Typeface r2 = r1.w()
            r0.setTypeface(r2)
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23193u0
            android.graphics.Typeface r1 = r1.x()
            r0.setTypeface(r1)
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23193u0
            l2.f r1 = r8.f14091N
            kotlin.jvm.internal.t.b(r1)
            java.lang.String r1 = r1.B()
            kotlin.jvm.internal.t.b(r1)
            java.util.Locale r2 = java.util.Locale.ROOT
            java.lang.String r1 = r1.toUpperCase(r2)
            java.lang.String r2 = "toUpperCase(...)"
            kotlin.jvm.internal.t.d(r1, r2)
            r0.setText(r1)
            goto L_0x0603
        L_0x05fa:
            h2.h0 r0 = r8.K3()
            android.widget.RelativeLayout r0 = r0.f23127M
            r0.setVisibility(r2)
        L_0x0603:
            h2.h0 r0 = r8.K3()
            android.widget.TextView r0 = r0.f23120I0
            O1.Y1 r1 = new O1.Y1
            r1.<init>(r8)
            r0.setOnClickListener(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MoreInfo.U3():void");
    }

    /* access modifiers changed from: private */
    public static final void V3(MoreInfo moreInfo, View view) {
        moreInfo.S3();
    }

    /* access modifiers changed from: private */
    public static final void W3(MoreInfo moreInfo, View view) {
        String string = moreInfo.getString(R.string.dmca_title);
        t.d(string, "getString(...)");
        String string2 = moreInfo.getString(R.string.url_dmca);
        t.d(string2, "getString(...)");
        new C2962v().t(moreInfo, string2, string);
    }

    /* access modifiers changed from: private */
    public static final void X3(MoreInfo moreInfo, View view) {
        C2657f fVar = moreInfo.f14091N;
        t.b(fVar);
        C2660i h5 = fVar.h();
        t.b(h5);
        moreInfo.f4(h5);
    }

    /* access modifiers changed from: private */
    public static final void Y3(MoreInfo moreInfo, View view) {
        if (!moreInfo.isFinishing()) {
            C2962v vVar = new C2962v();
            C2657f fVar = moreInfo.f14091N;
            t.b(fVar);
            String E02 = fVar.E0();
            t.b(E02);
            C2962v.u(vVar, moreInfo, E02, (String) null, 4, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void Z3(MoreInfo moreInfo, View view) {
        Object systemService = moreInfo.getSystemService("clipboard");
        t.c(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        C2657f fVar = moreInfo.f14091N;
        t.b(fVar);
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText((CharSequence) null, fVar.n0()));
    }

    /* access modifiers changed from: private */
    public static final void a4(MoreInfo moreInfo, View view) {
        LinearLayout linearLayout = moreInfo.K3().f23109D;
        t.d(linearLayout, "llPermissionsMoreInfo");
        if (linearLayout.getVisibility() == 0) {
            moreInfo.K3().f23109D.setVisibility(8);
            moreInfo.K3().f23186r.setImageResource(R.drawable.vector_more_info_expand);
            return;
        }
        moreInfo.K3().f23109D.setVisibility(0);
        moreInfo.K3().f23186r.setImageResource(R.drawable.vector_more_info_collapse);
        moreInfo.K3().f23151Z.post(new Z1(moreInfo));
    }

    /* access modifiers changed from: private */
    public static final void b4(MoreInfo moreInfo) {
        moreInfo.K3().f23151Z.smoothScrollTo(0, moreInfo.K3().f23137R.getTop());
    }

    /* access modifiers changed from: private */
    public static final void c4(MoreInfo moreInfo, View view) {
        Object systemService = moreInfo.getSystemService("clipboard");
        t.c(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        C2657f fVar = moreInfo.f14091N;
        t.b(fVar);
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText((CharSequence) null, fVar.L()));
    }

    /* access modifiers changed from: private */
    public final void d4(ArrayList arrayList, LinearLayout linearLayout) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        t.b(arrayList);
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            String b5 = ((C2645E) arrayList.get(i5)).b();
            if (!(b5 == null || b5.length() == 0)) {
                C2445w0 c5 = C2445w0.c(LayoutInflater.from(getApplicationContext()));
                t.d(c5, "inflate(...)");
                c5.getRoot().setLayoutParams(layoutParams);
                c5.f23654b.setTypeface(S1.k.f32g.x());
                c5.f23654b.setText(((C2645E) arrayList.get(i5)).b());
                c5.f23654b.setOnClickListener(new C0773e2(c5));
                t.b(linearLayout);
                linearLayout.addView(c5.getRoot());
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void e4(C2445w0 w0Var, View view) {
        if (w0Var.f23654b.getMaxLines() == 1) {
            w0Var.f23654b.setMaxLines(Integer.MAX_VALUE);
        } else {
            w0Var.f23654b.setMaxLines(1);
        }
    }

    public final void f4(C2660i iVar) {
        t.e(iVar, "category");
        f2 a5 = f2.f24166k.a(iVar);
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_next_in, R.anim.slide_back_out).add(16908290, (Fragment) a5, (String) null).addToBackStack(String.valueOf(iVar.c())).commit();
        this.f14090M = a5;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Bundle extras;
        Parcelable parcelable;
        super.onCreate(bundle);
        setContentView((View) K3().getRoot());
        Intent intent = getIntent();
        if (!(intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("appInfo"))) {
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) extras.getParcelable("appInfo", C2657f.class);
            } else {
                parcelable = extras.getParcelable("appInfo");
            }
            this.f14091N = (C2657f) parcelable;
        }
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            K3().f23153a0.setNavigationIcon(drawable);
            K3().f23153a0.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        K3().f23153a0.setNavigationOnClickListener(new C0756c2(this));
        C2416h0 K32 = K3();
        TextView textView = K32.f23169i0;
        k.a aVar = S1.k.f32g;
        textView.setTypeface(aVar.w());
        K32.f23126L0.setTypeface(aVar.w());
        K32.f23185q0.setTypeface(aVar.w());
        K32.f23140S0.setTypeface(aVar.w());
        K32.f23203z0.setTypeface(aVar.x());
        K32.f23163f0.setTypeface(aVar.w());
        K32.f23175l0.setTypeface(aVar.x());
        K32.f23118H0.setTypeface(aVar.w());
        K32.f23104A0.setTypeface(aVar.x());
        K32.f23142T0.setTypeface(aVar.w());
        K32.f23120I0.setTypeface(aVar.w());
        K32.f23111E.setOnClickListener(new C0765d2());
        if (this.f14091N != null) {
            U3();
            C2657f fVar = this.f14091N;
            t.b(fVar);
            if (!fVar.O0()) {
                C2908y0 unused = C2876i.d(this.f14088K, (C2312i) null, (O) null, new j(this, (C2308e) null), 3, (Object) null);
                C2908y0 unused2 = C2876i.d(this.f14088K, (C2312i) null, (O) null, new k(this, (C2308e) null), 3, (Object) null);
                C2908y0 unused3 = C2876i.d(this.f14088K, (C2312i) null, (O) null, new l(this, (C2308e) null), 3, (Object) null);
                return;
            }
            K3().f23113F.setVisibility(8);
            K3().f23137R.setVisibility(8);
            K3().f23129N.setVisibility(8);
        }
    }
}
