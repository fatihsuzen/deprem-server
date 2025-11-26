package com.uptodown.activities;

import O1.H;
import O1.I;
import O1.K;
import S1.k;
import W2.C2223l;
import W2.J;
import W2.m;
import W2.u;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.uptodown.R;
import h2.C2423l;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.t;
import l2.C2667p;
import l2.C2676z;
import org.json.JSONObject;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.I0;
import w3.M;
import w3.N;
import w3.O;
import w3.X;
import z2.D;
import z2.Z;

public final class ContactUsActivity extends C1598a {

    /* renamed from: K  reason: collision with root package name */
    private final C2223l f13668K = m.b(new H(this));
    /* access modifiers changed from: private */

    /* renamed from: L  reason: collision with root package name */
    public boolean f13669L;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13670a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ContactUsActivity f13671b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(ContactUsActivity contactUsActivity, C2308e eVar) {
            super(2, eVar);
            this.f13671b = contactUsActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f13671b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f13670a;
            if (i5 == 0) {
                u.b(obj);
                ContactUsActivity contactUsActivity = this.f13671b;
                String obj2 = contactUsActivity.p3().f23293b.getText().toString();
                String obj3 = this.f13671b.p3().f23294c.getText().toString();
                this.f13670a = 1;
                if (contactUsActivity.u3(obj2, obj3, this) == f5) {
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
            return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13672a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ContactUsActivity f13673b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f13674c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f13675d;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f13676a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ kotlin.jvm.internal.J f13677b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ContactUsActivity f13678c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ L f13679d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(kotlin.jvm.internal.J j5, ContactUsActivity contactUsActivity, L l5, C2308e eVar) {
                super(2, eVar);
                this.f13677b = j5;
                this.f13678c = contactUsActivity;
                this.f13679d = l5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f13677b, this.f13678c, this.f13679d, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object f5 = C2316b.f();
                int i5 = this.f13676a;
                if (i5 == 0) {
                    u.b(obj);
                    if (this.f13677b.f24688a == 1) {
                        ContactUsActivity contactUsActivity = this.f13678c;
                        String string = contactUsActivity.getString(R.string.sugerencia_enviada);
                        t.d(string, "getString(...)");
                        contactUsActivity.u0(string);
                        this.f13676a = 1;
                        if (X.b(1000, this) == f5) {
                            return f5;
                        }
                    } else {
                        L l5 = this.f13679d;
                        if (l5.f24690a == null) {
                            l5.f24690a = this.f13678c.getResources().getString(R.string.error_generico);
                        }
                        if (((CharSequence) this.f13679d.f24690a).length() > 0) {
                            this.f13678c.u0((String) this.f13679d.f24690a);
                        }
                        this.f13678c.f13669L = false;
                        this.f13678c.p3().f23295d.setVisibility(8);
                        return J.f19942a;
                    }
                } else if (i5 == 1) {
                    u.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                this.f13678c.finish();
                this.f13678c.f13669L = false;
                this.f13678c.p3().f23295d.setVisibility(8);
                return J.f19942a;
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(ContactUsActivity contactUsActivity, String str, String str2, C2308e eVar) {
            super(2, eVar);
            this.f13673b = contactUsActivity;
            this.f13674c = str;
            this.f13675d = str2;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f13673b, this.f13674c, this.f13675d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f13672a;
            if (i5 == 0) {
                u.b(obj);
                kotlin.jvm.internal.J j5 = new kotlin.jvm.internal.J();
                L l5 = new L();
                l5.f24690a = "";
                C2667p pVar = new C2667p();
                Context applicationContext = this.f13673b.getApplicationContext();
                t.d(applicationContext, "getApplicationContext(...)");
                pVar.k(applicationContext);
                C2676z zVar = new C2676z();
                D d5 = new D();
                Context applicationContext2 = this.f13673b.getApplicationContext();
                t.d(applicationContext2, "getApplicationContext(...)");
                zVar.g(d5.f(applicationContext2));
                D d6 = new D();
                Context applicationContext3 = this.f13673b.getApplicationContext();
                t.d(applicationContext3, "getApplicationContext(...)");
                zVar.e(d6.a(applicationContext3));
                D d7 = new D();
                Context applicationContext4 = this.f13673b.getApplicationContext();
                t.d(applicationContext4, "getApplicationContext(...)");
                zVar.h(d7.g(applicationContext4));
                D d8 = new D();
                Context applicationContext5 = this.f13673b.getApplicationContext();
                t.d(applicationContext5, "getApplicationContext(...)");
                zVar.f(d8.b(applicationContext5));
                Context applicationContext6 = this.f13673b.getApplicationContext();
                t.d(applicationContext6, "getApplicationContext(...)");
                l2.M i12 = new Z(applicationContext6).i1(this.f13674c, this.f13675d, pVar, zVar);
                if (!i12.b() && i12.e() != null) {
                    JSONObject e5 = i12.e();
                    t.b(e5);
                    if (e5.optInt("success") == 0) {
                        l5.f24690a = i12.g(e5);
                    } else {
                        j5.f24688a = 1;
                    }
                }
                I0 c5 = C2865c0.c();
                a aVar = new a(j5, this.f13673b, l5, (C2308e) null);
                this.f13672a = 1;
                if (C2872g.g(c5, aVar, this) == f5) {
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
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* access modifiers changed from: private */
    public static final C2423l n3(ContactUsActivity contactUsActivity) {
        return C2423l.c(contactUsActivity.getLayoutInflater());
    }

    private final boolean o3() {
        Editable text = p3().f23293b.getText();
        if (text == null || text.length() == 0) {
            String string = getString(R.string.falta_email_sugerencia);
            t.d(string, "getString(...)");
            u0(string);
            return false;
        }
        Editable text2 = p3().f23294c.getText();
        if (text2 != null && text2.length() != 0) {
            return true;
        }
        String string2 = getString(R.string.falta_texto_sugerencia);
        t.d(string2, "getString(...)");
        u0(string2);
        return false;
    }

    /* access modifiers changed from: private */
    public final C2423l p3() {
        return (C2423l) this.f13668K.getValue();
    }

    /* access modifiers changed from: private */
    public static final void q3(ContactUsActivity contactUsActivity, View view) {
        contactUsActivity.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: private */
    public static final void r3(ContactUsActivity contactUsActivity, View view, boolean z4) {
        if (z4) {
            contactUsActivity.p3().f23293b.setHint("");
        } else {
            contactUsActivity.p3().f23293b.setHint(contactUsActivity.getString(R.string.hint_email_registro));
        }
    }

    /* access modifiers changed from: private */
    public static final void s3(ContactUsActivity contactUsActivity, View view, boolean z4) {
        if (z4) {
            contactUsActivity.p3().f23294c.setHint("");
        } else {
            contactUsActivity.p3().f23294c.setHint(contactUsActivity.getString(R.string.hint_text_suggestion));
        }
    }

    /* access modifiers changed from: private */
    public static final void t3(ContactUsActivity contactUsActivity, View view) {
        if (!contactUsActivity.f13669L) {
            contactUsActivity.p3().f23295d.setVisibility(0);
            contactUsActivity.f13669L = true;
            if (contactUsActivity.o3()) {
                C2908y0 unused = C2876i.d(N.a(C2865c0.b()), (C2312i) null, (O) null, new a(contactUsActivity, (C2308e) null), 3, (Object) null);
                return;
            }
            contactUsActivity.f13669L = false;
            contactUsActivity.p3().f23295d.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public final Object u3(String str, String str2, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new b(this, str, str2, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) p3().getRoot());
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            p3().f23296e.setNavigationIcon(drawable);
            p3().f23296e.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        p3().f23296e.setNavigationOnClickListener(new I(this));
        TextView textView = p3().f23298g;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        p3().f23293b.setTypeface(aVar.x());
        p3().f23293b.setOnFocusChangeListener(new O1.J(this));
        p3().f23294c.setTypeface(aVar.x());
        p3().f23294c.setOnFocusChangeListener(new K(this));
        p3().f23297f.setTypeface(aVar.w());
        p3().f23297f.setOnClickListener(new O1.L(this));
    }
}
