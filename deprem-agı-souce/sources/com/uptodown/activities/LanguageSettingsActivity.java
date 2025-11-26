package com.uptodown.activities;

import O1.C0859p0;
import O1.C0867q0;
import O1.C0874r0;
import R1.C0983n;
import S1.k;
import W2.C2223l;
import W2.J;
import W2.m;
import W2.u;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.view.PointerIconCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.uptodown.R;
import com.uptodown.activities.preferences.a;
import h2.C2406c0;
import java.util.ArrayList;
import k2.C2613x;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import l2.C2675y;
import w3.C2908y0;
import w3.M;
import w3.O;
import z2.C2940B;

public final class LanguageSettingsActivity extends C1598a {
    /* access modifiers changed from: private */

    /* renamed from: K  reason: collision with root package name */
    public C0983n f13913K;
    /* access modifiers changed from: private */

    /* renamed from: L  reason: collision with root package name */
    public a f13914L = new a(this);

    /* renamed from: M  reason: collision with root package name */
    private final C2223l f13915M = m.b(new C0859p0(this));

    /* renamed from: N  reason: collision with root package name */
    private final LifecycleCoroutineScope f13916N = LifecycleOwnerKt.getLifecycleScope(this);

    public static final class a implements C2613x {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LanguageSettingsActivity f13917a;

        a(LanguageSettingsActivity languageSettingsActivity) {
            this.f13917a = languageSettingsActivity;
        }

        public void a(C2675y yVar) {
            t.e(yVar, "lang");
            if (yVar.a() != null) {
                LanguageSettingsActivity languageSettingsActivity = this.f13917a;
                String a5 = yVar.a();
                t.b(a5);
                languageSettingsActivity.p3(a5);
            }
        }
    }

    static final class b extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f13918a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f13919b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ LanguageSettingsActivity f13920c;

        /* renamed from: d  reason: collision with root package name */
        int f13921d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(LanguageSettingsActivity languageSettingsActivity, C2308e eVar) {
            super(eVar);
            this.f13920c = languageSettingsActivity;
        }

        public final Object invokeSuspend(Object obj) {
            this.f13919b = obj;
            this.f13921d |= Integer.MIN_VALUE;
            return this.f13920c.r3(this);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13922a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ LanguageSettingsActivity f13923b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(LanguageSettingsActivity languageSettingsActivity, C2308e eVar) {
            super(2, eVar);
            this.f13923b = languageSettingsActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f13923b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f13922a == 0) {
                u.b(obj);
                this.f13923b.q3().f22850b.setVisibility(0);
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13924a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ LanguageSettingsActivity f13925b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(LanguageSettingsActivity languageSettingsActivity, C2308e eVar) {
            super(2, eVar);
            this.f13925b = languageSettingsActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f13925b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f13924a == 0) {
                u.b(obj);
                ArrayList arrayList = new ArrayList();
                String[] stringArray = this.f13925b.getResources().getStringArray(R.array.languages);
                t.d(stringArray, "getStringArray(...)");
                String[] stringArray2 = this.f13925b.getResources().getStringArray(R.array.languageCodes);
                t.d(stringArray2, "getStringArray(...)");
                String[] stringArray3 = this.f13925b.getResources().getStringArray(R.array.localizedLang);
                t.d(stringArray3, "getStringArray(...)");
                int length = stringArray.length;
                for (int i5 = 0; i5 < length; i5++) {
                    String str = stringArray[i5];
                    C2675y yVar = new C2675y();
                    yVar.f(str);
                    yVar.e(stringArray3[i5]);
                    yVar.d(stringArray2[i5]);
                    arrayList.add(yVar);
                }
                String n5 = com.uptodown.activities.preferences.a.f15150a.n(this.f13925b);
                if (n5 == null) {
                    n5 = "en";
                }
                LanguageSettingsActivity languageSettingsActivity = this.f13925b;
                languageSettingsActivity.f13913K = new C0983n(arrayList, languageSettingsActivity.f13914L, n5);
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13926a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ LanguageSettingsActivity f13927b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(LanguageSettingsActivity languageSettingsActivity, C2308e eVar) {
            super(2, eVar);
            this.f13927b = languageSettingsActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f13927b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f13926a == 0) {
                u.b(obj);
                RecyclerView recyclerView = this.f13927b.q3().f22851c;
                C0983n j32 = this.f13927b.f13913K;
                if (j32 == null) {
                    t.w("adapter");
                    j32 = null;
                }
                recyclerView.setAdapter(j32);
                this.f13927b.q3().f22850b.setVisibility(8);
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13928a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ LanguageSettingsActivity f13929b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(LanguageSettingsActivity languageSettingsActivity, C2308e eVar) {
            super(2, eVar);
            this.f13929b = languageSettingsActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new f(this.f13929b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f13928a;
            if (i5 == 0) {
                u.b(obj);
                LanguageSettingsActivity languageSettingsActivity = this.f13929b;
                this.f13928a = 1;
                if (languageSettingsActivity.r3(this) == f5) {
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
            return ((f) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* access modifiers changed from: private */
    public static final C2406c0 o3(LanguageSettingsActivity languageSettingsActivity) {
        return C2406c0.c(languageSettingsActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final void p3(String str) {
        C2940B a5 = C2940B.f26458v.a(this);
        a5.a();
        a5.t1();
        a5.m();
        a.C0147a aVar = com.uptodown.activities.preferences.a.f15150a;
        Context applicationContext = getApplicationContext();
        t.d(applicationContext, "getApplicationContext(...)");
        aVar.N0(applicationContext, str);
        setResult(PointerIconCompat.TYPE_HELP);
        finish();
    }

    /* access modifiers changed from: private */
    public final C2406c0 q3() {
        return (C2406c0) this.f13915M.getValue();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0071, code lost:
        if (w3.C2872g.g(r8, r5, r0) != r1) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0085, code lost:
        if (w3.C2872g.g(r8, r4, r0) == r1) goto L_0x0087;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object r3(b3.C2308e r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.uptodown.activities.LanguageSettingsActivity.b
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.uptodown.activities.LanguageSettingsActivity$b r0 = (com.uptodown.activities.LanguageSettingsActivity.b) r0
            int r1 = r0.f13921d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f13921d = r1
            goto L_0x0018
        L_0x0013:
            com.uptodown.activities.LanguageSettingsActivity$b r0 = new com.uptodown.activities.LanguageSettingsActivity$b
            r0.<init>(r7, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f13919b
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f13921d
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0048
            if (r2 == r5) goto L_0x0040
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            W2.u.b(r8)
            goto L_0x0088
        L_0x0030:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0038:
            java.lang.Object r2 = r0.f13918a
            com.uptodown.activities.LanguageSettingsActivity r2 = (com.uptodown.activities.LanguageSettingsActivity) r2
            W2.u.b(r8)
            goto L_0x0074
        L_0x0040:
            java.lang.Object r2 = r0.f13918a
            com.uptodown.activities.LanguageSettingsActivity r2 = (com.uptodown.activities.LanguageSettingsActivity) r2
            W2.u.b(r8)
            goto L_0x0060
        L_0x0048:
            W2.u.b(r8)
            w3.I0 r8 = w3.C2865c0.c()
            com.uptodown.activities.LanguageSettingsActivity$c r2 = new com.uptodown.activities.LanguageSettingsActivity$c
            r2.<init>(r7, r6)
            r0.f13918a = r7
            r0.f13921d = r5
            java.lang.Object r8 = w3.C2872g.g(r8, r2, r0)
            if (r8 != r1) goto L_0x005f
            goto L_0x0087
        L_0x005f:
            r2 = r7
        L_0x0060:
            w3.I r8 = w3.C2865c0.b()
            com.uptodown.activities.LanguageSettingsActivity$d r5 = new com.uptodown.activities.LanguageSettingsActivity$d
            r5.<init>(r2, r6)
            r0.f13918a = r2
            r0.f13921d = r4
            java.lang.Object r8 = w3.C2872g.g(r8, r5, r0)
            if (r8 != r1) goto L_0x0074
            goto L_0x0087
        L_0x0074:
            w3.I0 r8 = w3.C2865c0.c()
            com.uptodown.activities.LanguageSettingsActivity$e r4 = new com.uptodown.activities.LanguageSettingsActivity$e
            r4.<init>(r2, r6)
            r0.f13918a = r6
            r0.f13921d = r3
            java.lang.Object r8 = w3.C2872g.g(r8, r4, r0)
            if (r8 != r1) goto L_0x0088
        L_0x0087:
            return r1
        L_0x0088:
            W2.J r8 = W2.J.f19942a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.LanguageSettingsActivity.r3(b3.e):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final void s3(LanguageSettingsActivity languageSettingsActivity, View view) {
        languageSettingsActivity.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: private */
    public static final void t3(View view) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) q3().getRoot());
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            q3().f22852d.setNavigationIcon(drawable);
            q3().f22852d.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        q3().f22853e.setTypeface(k.f32g.w());
        q3().f22852d.setNavigationOnClickListener(new C0867q0(this));
        q3().f22850b.setOnClickListener(new C0874r0());
        q3().f22851c.setLayoutManager(new LinearLayoutManager(this, 1, false));
        q3().f22851c.setItemAnimator(new DefaultItemAnimator());
        C2908y0 unused = C2876i.d(this.f13916N, (C2312i) null, (O) null, new f(this, (C2308e) null), 3, (Object) null);
    }
}
