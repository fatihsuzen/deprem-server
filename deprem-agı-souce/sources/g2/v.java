package g2;

import W2.J;
import W2.u;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import k2.I;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import l2.C2655d;
import l2.C2657f;
import org.json.JSONObject;
import w3.C2865c0;
import w3.C2872g;
import w3.M;
import w3.O;
import z2.C2940B;
import z2.F;
import z2.Z;

public final class v {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f22105a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public C2657f f22106b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public C2655d f22107c;

    /* renamed from: d  reason: collision with root package name */
    private I f22108d;

    /* renamed from: e  reason: collision with root package name */
    private M f22109e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f22110f;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f22111a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ v f22112b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(v vVar, C2308e eVar) {
            super(2, eVar);
            this.f22112b = vVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f22112b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f22111a;
            if (i5 == 0) {
                u.b(obj);
                v vVar = this.f22112b;
                this.f22111a = 1;
                if (vVar.m(this) == f5) {
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
        int f22113a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ v f22114b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(v vVar, C2308e eVar) {
            super(2, eVar);
            this.f22114b = vVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f22114b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f22113a == 0) {
                u.b(obj);
                if (this.f22114b.f22107c != null) {
                    C2655d b5 = this.f22114b.f22107c;
                    t.b(b5);
                    if (b5.z() == null) {
                        v vVar = this.f22114b;
                        Context e5 = vVar.f22105a;
                        C2655d b6 = this.f22114b.f22107c;
                        t.b(b6);
                        String o5 = b6.o();
                        t.b(o5);
                        C2655d b7 = this.f22114b.f22107c;
                        t.b(b7);
                        String k5 = b7.k();
                        t.b(k5);
                        vVar.f22110f = vVar.i(e5, o5, k5);
                        C2655d b8 = this.f22114b.f22107c;
                        t.b(b8);
                        b8.g0(this.f22114b.f22110f);
                        C2940B a5 = C2940B.f26458v.a(this.f22114b.f22105a);
                        a5.a();
                        C2655d b9 = this.f22114b.f22107c;
                        t.b(b9);
                        a5.y1(b9);
                        a5.m();
                    } else {
                        v vVar2 = this.f22114b;
                        C2655d b10 = vVar2.f22107c;
                        t.b(b10);
                        vVar2.f22110f = b10.z();
                    }
                } else if (this.f22114b.f22106b != null) {
                    C2657f c5 = this.f22114b.f22106b;
                    t.b(c5);
                    if (c5.y0() == null) {
                        v vVar3 = this.f22114b;
                        Context e6 = vVar3.f22105a;
                        C2657f c6 = this.f22114b.f22106b;
                        t.b(c6);
                        String S4 = c6.S();
                        t.b(S4);
                        C2657f c7 = this.f22114b.f22106b;
                        t.b(c7);
                        String L4 = c7.L();
                        t.b(L4);
                        vVar3.f22110f = vVar3.i(e6, S4, L4);
                    } else {
                        v vVar4 = this.f22114b;
                        C2657f c8 = vVar4.f22106b;
                        t.b(c8);
                        vVar4.f22110f = c8.y0();
                    }
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public v(Context context, C2657f fVar, C2655d dVar, I i5, M m5) {
        t.e(context, "context");
        t.e(m5, "scope");
        this.f22105a = context;
        this.f22106b = fVar;
        this.f22107c = dVar;
        this.f22108d = i5;
        this.f22109e = m5;
        k();
    }

    /* access modifiers changed from: private */
    public final String i(Context context, String str, String str2) {
        int i5;
        l2.M t02 = new Z(context).t0(str, str2);
        if (t02.e() == null) {
            return null;
        }
        JSONObject e5 = t02.e();
        t.b(e5);
        if (!e5.isNull("success")) {
            i5 = e5.optInt("success");
        } else {
            i5 = 0;
        }
        JSONObject optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
        if (i5 != 1 || optJSONObject == null || optJSONObject.isNull("app_url")) {
            return null;
        }
        return optJSONObject.optString("app_url");
    }

    private final void j(String str, String str2, String str3) {
        if (str3 != null) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.addFlags(524288);
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", this.f22105a.getString(R.string.share_app_details_msg, new Object[]{str}));
            intent.putExtra("android.intent.extra.TEXT", str3);
            Context context = this.f22105a;
            context.startActivity(Intent.createChooser(intent, context.getString(R.string.option_button_share)));
            Bundle bundle = new Bundle();
            bundle.putString("packagename", str2);
            new F(this.f22105a).d("share_app", bundle);
            return;
        }
        I i5 = this.f22108d;
        if (i5 != null) {
            i5.a(str);
        }
    }

    private final void k() {
        C2876i.d(this.f22109e, (C2312i) null, (O) null, new a(this, (C2308e) null), 3, (Object) null).s(new u(this));
    }

    /* access modifiers changed from: private */
    public static final J l(v vVar, Throwable th) {
        C2655d dVar = vVar.f22107c;
        if (dVar != null) {
            t.b(dVar);
            String m5 = dVar.m();
            t.b(m5);
            C2655d dVar2 = vVar.f22107c;
            t.b(dVar2);
            String o5 = dVar2.o();
            t.b(o5);
            vVar.j(m5, o5, vVar.f22110f);
        } else {
            C2657f fVar = vVar.f22106b;
            if (fVar != null) {
                t.b(fVar);
                String N4 = fVar.N();
                t.b(N4);
                C2657f fVar2 = vVar.f22106b;
                t.b(fVar2);
                String S4 = fVar2.S();
                t.b(S4);
                vVar.j(N4, S4, vVar.f22110f);
            }
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final Object m(C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new b(this, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }
}
