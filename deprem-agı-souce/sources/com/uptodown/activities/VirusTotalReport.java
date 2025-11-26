package com.uptodown.activities;

import O1.o7;
import O1.p7;
import O1.q7;
import O1.r7;
import O1.s7;
import S1.k;
import W2.C2219h;
import W2.C2223l;
import W2.J;
import W2.m;
import W2.q;
import W2.u;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import b3.C2308e;
import c3.C2316b;
import com.squareup.picasso.s;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.i0;
import h2.u1;
import java.util.ArrayList;
import java.util.Arrays;
import k3.C2616a;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.Q;
import kotlin.jvm.internal.t;
import l2.C2655d;
import l2.C2657f;
import l2.C2666o;
import l2.C2674x;
import l2.L;
import w3.C2865c0;
import w3.C2908y0;
import z2.C2962v;
import z2.O;
import z2.P;
import z3.C2973f;
import z3.D;
import z3.w;

public final class VirusTotalReport extends C1598a {

    /* renamed from: M  reason: collision with root package name */
    public static final a f14774M = new a((C2633k) null);

    /* renamed from: K  reason: collision with root package name */
    private final C2223l f14775K = m.b(new o7(this));

    /* renamed from: L  reason: collision with root package name */
    private final C2223l f14776L = new ViewModelLazy(M.b(i0.class), new d(this), new c(this), new e((C2616a) null, this));

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14777a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ VirusTotalReport f14778b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ VirusTotalReport f14779a;

            a(VirusTotalReport virusTotalReport) {
                this.f14779a = virusTotalReport;
            }

            /* renamed from: b */
            public final Object emit(O o5, C2308e eVar) {
                if (o5 instanceof O.a) {
                    this.f14779a.q3().f23604k.setVisibility(0);
                } else if (o5 instanceof O.c) {
                    if (((i0.a) ((O.c) o5).a()).a() != null) {
                        this.f14779a.z3();
                        this.f14779a.A3();
                        this.f14779a.B3();
                    } else {
                        this.f14779a.q3().f23609p.setVisibility(8);
                        this.f14779a.q3().f23615v.setVisibility(0);
                        this.f14779a.q3().f23604k.setVisibility(8);
                    }
                } else if (!(o5 instanceof O.b)) {
                    throw new q();
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(VirusTotalReport virusTotalReport, C2308e eVar) {
            super(2, eVar);
            this.f14778b = virusTotalReport;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f14778b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14777a;
            if (i5 == 0) {
                u.b(obj);
                D e5 = this.f14778b.t3().e();
                a aVar = new a(this.f14778b);
                this.f14777a = 1;
                if (e5.collect(aVar, this) == f5) {
                    return f5;
                }
            } else if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                u.b(obj);
            }
            throw new C2219h();
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class c extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14780a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ComponentActivity componentActivity) {
            super(0);
            this.f14780a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f14780a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class d extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14781a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(ComponentActivity componentActivity) {
            super(0);
            this.f14781a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f14781a.getViewModelStore();
        }
    }

    public static final class e extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2616a f14782a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14783b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(C2616a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f14782a = aVar;
            this.f14783b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                k3.a r0 = r1.f14782a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f14783b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.VirusTotalReport.e.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0125, code lost:
        if (r2.size() > 0) goto L_0x013b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void A3() {
        /*
            r8 = this;
            com.uptodown.activities.i0 r0 = r8.t3()
            z3.w r0 = r0.h()
            java.lang.Object r0 = r0.getValue()
            r1 = 0
            r2 = 2131951914(0x7f13012a, float:1.9540256E38)
            java.lang.String r3 = "format(...)"
            r4 = 1
            java.lang.String r5 = "getString(...)"
            r6 = 2131952907(0x7f13050b, float:1.954227E38)
            r7 = 2131952909(0x7f13050d, float:1.9542274E38)
            if (r0 == 0) goto L_0x014e
            kotlin.jvm.internal.Q r0 = kotlin.jvm.internal.Q.f24695a
            java.lang.String r0 = r8.getString(r6)
            kotlin.jvm.internal.t.d(r0, r5)
            com.uptodown.activities.i0 r5 = r8.t3()
            z3.w r5 = r5.h()
            java.lang.Object r5 = r5.getValue()
            kotlin.jvm.internal.t.b(r5)
            l2.L r5 = (l2.L) r5
            int r5 = r5.e()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.Object[] r6 = new java.lang.Object[r4]
            r6[r1] = r5
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r6, r4)
            java.lang.String r0 = java.lang.String.format(r0, r5)
            kotlin.jvm.internal.t.d(r0, r3)
            h2.u1 r3 = r8.q3()
            android.widget.TextView r3 = r3.f23587A
            S1.k$a r5 = S1.k.f32g
            android.graphics.Typeface r5 = r5.w()
            r3.setTypeface(r5)
            h2.u1 r3 = r8.q3()
            android.widget.TextView r3 = r3.f23587A
            com.uptodown.activities.i0 r5 = r8.t3()
            z3.w r5 = r5.h()
            java.lang.Object r5 = r5.getValue()
            kotlin.jvm.internal.t.b(r5)
            l2.L r5 = (l2.L) r5
            int r5 = r5.d()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r3.setText(r5)
            com.uptodown.activities.i0 r3 = r8.t3()
            z3.w r3 = r3.h()
            java.lang.Object r3 = r3.getValue()
            kotlin.jvm.internal.t.b(r3)
            l2.L r3 = (l2.L) r3
            java.lang.String r3 = r3.c()
            if (r3 == 0) goto L_0x00c4
            int r3 = r3.length()
            if (r3 != 0) goto L_0x009d
            goto L_0x00c4
        L_0x009d:
            h2.u1 r2 = r8.q3()
            android.widget.TextView r2 = r2.f23613t
            com.uptodown.activities.i0 r3 = r8.t3()
            z3.w r3 = r3.h()
            java.lang.Object r3 = r3.getValue()
            kotlin.jvm.internal.t.b(r3)
            l2.L r3 = (l2.L) r3
            java.lang.String r3 = r3.c()
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r1] = r3
            java.lang.String r3 = r8.getString(r7, r4)
            r2.setText(r3)
            goto L_0x00d9
        L_0x00c4:
            h2.u1 r3 = r8.q3()
            android.widget.TextView r3 = r3.f23613t
            java.lang.String r2 = r8.getString(r2)
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r1] = r2
            java.lang.String r2 = r8.getString(r7, r4)
            r3.setText(r2)
        L_0x00d9:
            com.uptodown.activities.i0 r2 = r8.t3()
            z3.w r2 = r2.h()
            java.lang.Object r2 = r2.getValue()
            kotlin.jvm.internal.t.b(r2)
            l2.L r2 = (l2.L) r2
            int r2 = r2.d()
            r3 = 8
            if (r2 > 0) goto L_0x013b
            com.uptodown.activities.i0 r2 = r8.t3()
            z3.w r2 = r2.h()
            java.lang.Object r2 = r2.getValue()
            kotlin.jvm.internal.t.b(r2)
            l2.L r2 = (l2.L) r2
            java.util.ArrayList r2 = r2.b()
            if (r2 == 0) goto L_0x0128
            com.uptodown.activities.i0 r2 = r8.t3()
            z3.w r2 = r2.h()
            java.lang.Object r2 = r2.getValue()
            kotlin.jvm.internal.t.b(r2)
            l2.L r2 = (l2.L) r2
            java.util.ArrayList r2 = r2.b()
            kotlin.jvm.internal.t.b(r2)
            int r2 = r2.size()
            if (r2 <= 0) goto L_0x0128
            goto L_0x013b
        L_0x0128:
            h2.u1 r2 = r8.q3()
            android.widget.RelativeLayout r2 = r2.f23606m
            r2.setVisibility(r3)
            h2.u1 r2 = r8.q3()
            android.widget.RelativeLayout r2 = r2.f23605l
            r2.setVisibility(r1)
            goto L_0x0182
        L_0x013b:
            h2.u1 r2 = r8.q3()
            android.widget.RelativeLayout r2 = r2.f23606m
            r2.setVisibility(r1)
            h2.u1 r1 = r8.q3()
            android.widget.RelativeLayout r1 = r1.f23605l
            r1.setVisibility(r3)
            goto L_0x0182
        L_0x014e:
            kotlin.jvm.internal.Q r0 = kotlin.jvm.internal.Q.f24695a
            java.lang.String r0 = r8.getString(r6)
            kotlin.jvm.internal.t.d(r0, r5)
            r5 = 2131952950(0x7f130536, float:1.9542357E38)
            java.lang.String r5 = r8.getString(r5)
            java.lang.Object[] r6 = new java.lang.Object[r4]
            r6[r1] = r5
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r6, r4)
            java.lang.String r0 = java.lang.String.format(r0, r5)
            kotlin.jvm.internal.t.d(r0, r3)
            h2.u1 r3 = r8.q3()
            android.widget.TextView r3 = r3.f23613t
            java.lang.String r2 = r8.getString(r2)
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r1] = r2
            java.lang.String r1 = r8.getString(r7, r4)
            r3.setText(r1)
        L_0x0182:
            z2.P r1 = z2.P.f26510a
            android.text.Spanned r0 = r1.c(r0)
            h2.u1 r1 = r8.q3()
            android.widget.TextView r1 = r1.f23614u
            S1.k$a r2 = S1.k.f32g
            android.graphics.Typeface r3 = r2.x()
            r1.setTypeface(r3)
            h2.u1 r1 = r8.q3()
            android.widget.TextView r1 = r1.f23614u
            r1.setText(r0)
            h2.u1 r0 = r8.q3()
            android.widget.TextView r0 = r0.f23613t
            android.graphics.Typeface r1 = r2.x()
            r0.setTypeface(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.VirusTotalReport.A3():void");
    }

    /* access modifiers changed from: private */
    public final void B3() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, (int) getResources().getDimension(R.dimen.margin_s), 0, 0);
        if (t3().h().getValue() != null) {
            Object value = t3().h().getValue();
            t.b(value);
            if (((L) value).b() != null) {
                Object value2 = t3().h().getValue();
                t.b(value2);
                ArrayList b5 = ((L) value2).b();
                t.b(b5);
                if (b5.size() > 0) {
                    Object value3 = t3().h().getValue();
                    t.b(value3);
                    ArrayList b6 = ((L) value3).b();
                    t.b(b6);
                    int size = b6.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        View inflate = getLayoutInflater().inflate(R.layout.scan_positive, q3().f23602i, false);
                        t.c(inflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
                        RelativeLayout relativeLayout = (RelativeLayout) inflate;
                        relativeLayout.setLayoutParams(layoutParams);
                        Object value4 = t3().h().getValue();
                        t.b(value4);
                        ArrayList b7 = ((L) value4).b();
                        t.b(b7);
                        ((TextView) relativeLayout.findViewById(R.id.tv_antivirus_name)).setText(((C2674x) b7.get(i5)).b());
                        Object value5 = t3().h().getValue();
                        t.b(value5);
                        ArrayList b8 = ((L) value5).b();
                        t.b(b8);
                        ((TextView) relativeLayout.findViewById(R.id.tv_virus_name)).setText(((C2674x) b8.get(i5)).c());
                        q3().f23602i.addView(relativeLayout);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static final u1 p3(VirusTotalReport virusTotalReport) {
        return u1.c(virusTotalReport.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final u1 q3() {
        return (u1) this.f14775K.getValue();
    }

    private final String r3() {
        Q q5 = Q.f24695a;
        String string = getString(R.string.vt_report_not_avaialable);
        t.d(string, "getString(...)");
        String format = String.format(string, Arrays.copyOf(new Object[]{getString(R.string.privacy_policies), getString(R.string.is_uptodown_safe)}, 2));
        t.d(format, "format(...)");
        String string2 = getString(R.string.app_technical_data_avaialable_at_utd_description);
        t.d(string2, "getString(...)");
        String format2 = String.format(string2, Arrays.copyOf(new Object[]{getString(R.string.app_technical_data_avaialable_at_utd), "packagename"}, 2));
        t.d(format2, "format(...)");
        return format + format2;
    }

    private final void s3() {
        i0 t32 = t3();
        Object value = t3().c().getValue();
        t.b(value);
        t32.b(this, ((C2657f) value).A(), ((Number) t3().f().getValue()).longValue(), ((Boolean) t3().i().getValue()).booleanValue());
    }

    /* access modifiers changed from: private */
    public final i0 t3() {
        return (i0) this.f14776L.getValue();
    }

    private final void u3() {
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            q3().f23610q.setNavigationIcon(drawable);
            q3().f23610q.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        q3().f23610q.setNavigationOnClickListener(new q7(this));
        TextView textView = q3().f23592F;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        if (t3().c().getValue() != null) {
            Object value = t3().c().getValue();
            t.b(value);
            String H4 = ((C2657f) value).H();
            if (H4 == null || H4.length() == 0) {
                q3().f23595b.f22658b.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vector_app_icon_placeholder));
            } else {
                s h5 = s.h();
                Object value2 = t3().c().getValue();
                t.b(value2);
                h5.l(((C2657f) value2).H()).n(UptodownApp.f13477F.g0(this)).i(q3().f23595b.f22658b);
            }
        } else if (t3().d().getValue() != null) {
            P p5 = P.f26510a;
            Object value3 = t3().d().getValue();
            t.b(value3);
            q3().f23595b.f22658b.setImageDrawable(p5.j(this, ((C2655d) value3).o()));
        }
        q3().f23595b.f22659c.setTypeface(aVar.w());
        if (t3().c().getValue() != null) {
            TextView textView2 = q3().f23595b.f22659c;
            Object value4 = t3().c().getValue();
            t.b(value4);
            textView2.setText(((C2657f) value4).N());
        } else if (t3().d().getValue() != null) {
            TextView textView3 = q3().f23595b.f22659c;
            Object value5 = t3().d().getValue();
            t.b(value5);
            textView3.setText(((C2655d) value5).m());
        }
        q3().f23595b.f22660d.setTypeface(aVar.x());
        CharSequence charSequence = (CharSequence) t3().g().getValue();
        if (charSequence != null && charSequence.length() != 0) {
            q3().f23595b.f22660d.setText((CharSequence) t3().g().getValue());
        } else if (t3().c().getValue() != null) {
            TextView textView4 = q3().f23595b.f22660d;
            Object value6 = t3().c().getValue();
            t.b(value6);
            textView4.setText(((C2657f) value6).B0());
        } else if (t3().d().getValue() != null) {
            TextView textView5 = q3().f23595b.f22660d;
            Object value7 = t3().d().getValue();
            t.b(value7);
            textView5.setText(((C2655d) value7).B());
        }
        q3().f23612s.setTypeface(aVar.x());
        q3().f23611r.setTypeface(aVar.w());
        q3().f23611r.setOnClickListener(new r7(this));
        q3().f23589C.setTypeface(aVar.x());
        q3().f23588B.setTypeface(aVar.w());
        q3().f23591E.setTypeface(aVar.x());
        q3().f23590D.setTypeface(aVar.w());
        q3().f23618y.setTypeface(aVar.x());
        q3().f23617x.setTypeface(aVar.x());
        q3().f23616w.setTypeface(aVar.x());
        q3().f23593G.setTypeface(aVar.x());
        q3().f23615v.setTypeface(aVar.x());
        q3().f23604k.setOnClickListener(new s7());
    }

    /* access modifiers changed from: private */
    public static final void v3(VirusTotalReport virusTotalReport, View view) {
        virusTotalReport.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: private */
    public static final void w3(VirusTotalReport virusTotalReport, View view) {
        if (virusTotalReport.t3().h().getValue() != null) {
            Object value = virusTotalReport.t3().h().getValue();
            t.b(value);
            virusTotalReport.L2(((L) value).f());
        }
    }

    /* access modifiers changed from: private */
    public static final void x3(View view) {
    }

    /* access modifiers changed from: private */
    public static final void y3(VirusTotalReport virusTotalReport, View view) {
        C2962v vVar = new C2962v();
        String string = virusTotalReport.getString(R.string.url_is_utd_safe);
        t.d(string, "getString(...)");
        vVar.t(virusTotalReport, string, (String) null);
    }

    /* access modifiers changed from: private */
    public final void z3() {
        String str;
        String str2;
        String str3;
        L l5 = (L) t3().h().getValue();
        String str4 = null;
        if (l5 != null) {
            str = l5.f();
        } else {
            str = null;
        }
        if (str == null || str.length() == 0) {
            C2657f fVar = (C2657f) t3().c().getValue();
            if (fVar != null) {
                str3 = fVar.n0();
            } else {
                str3 = null;
            }
            if (str3 == null || str3.length() == 0) {
                q3().f23607n.setVisibility(8);
            } else {
                TextView textView = q3().f23589C;
                Object value = t3().c().getValue();
                t.b(value);
                textView.setText(((C2657f) value).n0());
            }
        } else {
            TextView textView2 = q3().f23589C;
            Object value2 = t3().h().getValue();
            t.b(value2);
            textView2.setText(((L) value2).f());
        }
        C2657f fVar2 = (C2657f) t3().c().getValue();
        if (fVar2 != null) {
            str2 = fVar2.L();
        } else {
            str2 = null;
        }
        if (str2 == null || str2.length() == 0) {
            TextView textView3 = q3().f23591E;
            C2655d dVar = (C2655d) t3().d().getValue();
            if (dVar != null) {
                str4 = dVar.k();
            }
            textView3.setText(str4);
        } else {
            TextView textView4 = q3().f23591E;
            C2657f fVar3 = (C2657f) t3().c().getValue();
            if (fVar3 != null) {
                str4 = fVar3.L();
            }
            textView4.setText(str4);
        }
        q3().f23604k.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Parcelable parcelable;
        Parcelable parcelable2;
        Parcelable parcelable3;
        super.onCreate(bundle);
        setContentView((View) q3().getRoot());
        Intent intent = getIntent();
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null && extras.containsKey("appInfo")) {
                w c5 = t3().c();
                if (Build.VERSION.SDK_INT >= 33) {
                    parcelable3 = (Parcelable) extras.getParcelable("appInfo", C2657f.class);
                } else {
                    parcelable3 = extras.getParcelable("appInfo");
                }
                c5.setValue(parcelable3);
            }
            if (extras != null && extras.containsKey("app_selected")) {
                w d5 = t3().d();
                if (Build.VERSION.SDK_INT >= 33) {
                    parcelable2 = (Parcelable) extras.getParcelable("app_selected", C2655d.class);
                } else {
                    parcelable2 = extras.getParcelable("app_selected");
                }
                d5.setValue(parcelable2);
            }
            if (extras != null && extras.containsKey("old_version_name")) {
                t3().g().setValue(extras.getString("old_version_name"));
            }
            if (extras != null && extras.containsKey("oldVersionId")) {
                t3().i().setValue(Boolean.TRUE);
                t3().f().setValue(Long.valueOf(extras.getLong("oldVersionId")));
            }
            if (extras != null && extras.containsKey("appReportVT")) {
                w h5 = t3().h();
                if (Build.VERSION.SDK_INT >= 33) {
                    parcelable = (Parcelable) extras.getParcelable("appReportVT", L.class);
                } else {
                    parcelable = extras.getParcelable("appReportVT");
                }
                h5.setValue(parcelable);
            }
            if (extras != null && extras.containsKey("isVirusTotalReportAvaialable")) {
                t3().j().setValue(Boolean.valueOf(extras.getBoolean("isVirusTotalReportAvaialable")));
            }
        }
        u3();
        if (t3().h().getValue() != null) {
            A3();
            B3();
            z3();
        } else if (!((Boolean) t3().j().getValue()).booleanValue()) {
            q3().f23603j.setVisibility(8);
            q3().f23619z.setVisibility(0);
            q3().f23619z.setTypeface(k.f32g.x());
            q3().f23619z.setText(C2666o.f25106g.h(this, r3()));
            q3().f23619z.setOnClickListener(new p7(this));
            z3();
        } else {
            s3();
        }
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new b(this, (C2308e) null), 2, (Object) null);
    }
}
