package Q2;

import E1.c;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.Vector;
import java.util.UUID;
import k4.A;
import k4.z;
import kotlin.jvm.internal.t;
import l4.e;
import m.i;
import m.l;
import m4.d;
import n.a;
import o4.p;
import r4.b;

public final class m extends a {

    /* renamed from: m  reason: collision with root package name */
    public static final String f18916m;

    /* renamed from: a  reason: collision with root package name */
    public ConstraintLayout f18917a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f18918b;

    /* renamed from: c  reason: collision with root package name */
    public Button f18919c;

    /* renamed from: d  reason: collision with root package name */
    public Button f18920d;

    /* renamed from: e  reason: collision with root package name */
    public Button f18921e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f18922f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f18923g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f18924h;

    /* renamed from: i  reason: collision with root package name */
    public o f18925i;

    /* renamed from: j  reason: collision with root package name */
    public Typeface f18926j;

    /* renamed from: k  reason: collision with root package name */
    public Typeface f18927k;

    /* renamed from: l  reason: collision with root package name */
    public d f18928l;

    static {
        String simpleName = m.class.getSimpleName();
        t.d(simpleName, "PrivacyBottomSheet::class.java.simpleName");
        f18916m = simpleName;
    }

    public static final void i(m mVar, View view) {
        LiveData liveData;
        t.e(mVar, "this$0");
        o oVar = mVar.f18925i;
        if (oVar == null) {
            t.w("viewModel");
            oVar = null;
        }
        oVar.getClass();
        if (V2.a.e()) {
            ChoiceCmp choiceCmp = ChoiceCmp.INSTANCE;
            ChoiceCmpCallback callback = choiceCmp.getCallback();
            if (callback != null) {
                callback.onActionButtonClicked(F1.a.f2460a);
            }
            choiceCmp.setLoginProcessStart();
            UUID uuid = z.f24676a;
            liveData = z.e(A.ACTION1);
        } else {
            oVar.f18933a.x();
            oVar.b();
            p pVar = oVar.f18942j;
            pVar.getClass();
            if (l.f960a) {
                Vector vector = l.f961b;
                vector.unsetAllOwnedItems();
                r4.a aVar = pVar.f25612a;
                b bVar = b.GBC_CONSENT_STRING;
                Vector l5 = aVar.l(bVar);
                t.e(vector, "newVector");
                if (l5 != null) {
                    l5.forEach(new i(vector));
                }
                aVar.h(bVar, vector);
                ChoiceCmpCallback choiceCmpCallback = pVar.f25613b;
                if (choiceCmpCallback != null) {
                    choiceCmpCallback.onGoogleBasicConsentChange(l.a());
                }
            }
            UUID uuid2 = z.f24676a;
            liveData = z.a(A.REJECT_ALL);
        }
        liveData.observe(mVar, new l(mVar));
    }

    public static final void j(m mVar, String str) {
        t.e(mVar, "this$0");
        mVar.f();
        FragmentActivity activity = mVar.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static final void l(m mVar, View view) {
        FragmentManager supportFragmentManager;
        FragmentTransaction beginTransaction;
        FragmentTransaction add;
        t.e(mVar, "this$0");
        FragmentActivity activity = mVar.getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null && (beginTransaction = supportFragmentManager.beginTransaction()) != null && (add = beginTransaction.add((Fragment) new I2.i(), "e0.a")) != null) {
            add.commit();
        }
    }

    public static final void m(m mVar, String str) {
        t.e(mVar, "this$0");
        mVar.f();
        FragmentActivity activity = mVar.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static final void n(m mVar, View view) {
        t.e(mVar, "this$0");
        o oVar = mVar.f18925i;
        if (oVar == null) {
            t.w("viewModel");
            oVar = null;
        }
        oVar.getClass();
        ChoiceCmp choiceCmp = ChoiceCmp.INSTANCE;
        ChoiceCmpCallback callback = choiceCmp.getCallback();
        if (callback != null) {
            callback.onActionButtonClicked(F1.a.f2461b);
        }
        choiceCmp.setLoginProcessStart();
        UUID uuid = z.f24676a;
        z.e(A.ACTION2).observe(mVar, new j(mVar));
    }

    public static final void o(m mVar, String str) {
        t.e(mVar, "this$0");
        mVar.f();
        FragmentActivity activity = mVar.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static final void p(m mVar, View view) {
        t.e(mVar, "this$0");
        o oVar = mVar.f18925i;
        if (oVar == null) {
            t.w("viewModel");
            oVar = null;
        }
        oVar.f18933a.w();
        oVar.b();
        p pVar = oVar.f18942j;
        pVar.getClass();
        if (l.f960a) {
            Vector vector = l.f961b;
            vector.setAllOwnedItems();
            r4.a aVar = pVar.f25612a;
            b bVar = b.GBC_CONSENT_STRING;
            Vector l5 = aVar.l(bVar);
            t.e(vector, "newVector");
            if (l5 != null) {
                l5.forEach(new i(vector));
            }
            aVar.h(bVar, vector);
            ChoiceCmpCallback choiceCmpCallback = pVar.f25613b;
            if (choiceCmpCallback != null) {
                choiceCmpCallback.onGoogleBasicConsentChange(l.a());
            }
        }
        UUID uuid = z.f24676a;
        z.a(A.ACCEPT_ALL).observe(mVar, new k(mVar));
    }

    public final void g(ViewStub viewStub) {
        t.e(viewStub, "viewStub");
        viewStub.setLayoutResource(c.gdpr_privacy_bottom_sheet);
        View inflate = viewStub.inflate();
        t.d(inflate, "inflatedView");
        this.f18917a = (ConstraintLayout) inflate.findViewById(E1.b.privacy_container);
        this.f18918b = (ImageView) inflate.findViewById(E1.b.iv_cmp_logo);
        this.f18919c = (Button) inflate.findViewById(E1.b.btn_more_options);
        this.f18920d = (Button) inflate.findViewById(E1.b.btn_disagree);
        this.f18921e = (Button) inflate.findViewById(E1.b.btn_agree);
        this.f18922f = (TextView) inflate.findViewById(E1.b.tv_login_and_continue);
        this.f18923g = (TextView) inflate.findViewById(E1.b.tv_message);
        this.f18924h = (TextView) inflate.findViewById(E1.b.tv_title);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0064  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.text.SpannableString h(java.lang.String r5, android.text.SpannableString r6, java.lang.String r7, android.text.style.ClickableSpan r8, boolean r9) {
        /*
            r4 = this;
            java.lang.String r0 = "subString"
            kotlin.jvm.internal.t.e(r7, r0)
            r0 = 0
            if (r5 != 0) goto L_0x0009
            goto L_0x0024
        L_0x0009:
            t3.p r1 = new t3.p
            t3.r r2 = t3.r.IGNORE_CASE
            r1.<init>(r7, r2)
            r2 = 0
            r3 = 2
            s3.e r5 = t3.p.e(r1, r5, r2, r3, r0)
            java.util.Iterator r1 = r5.iterator()
            boolean r1 = r1.hasNext()
            if (r1 == 0) goto L_0x0021
            goto L_0x0022
        L_0x0021:
            r5 = r0
        L_0x0022:
            if (r5 != 0) goto L_0x0026
        L_0x0024:
            r5 = r0
            goto L_0x0058
        L_0x0026:
            if (r9 == 0) goto L_0x002f
            java.lang.Object r5 = s3.C2754h.u(r5)
        L_0x002c:
            t3.l r5 = (t3.C2788l) r5
            goto L_0x0034
        L_0x002f:
            java.lang.Object r5 = s3.C2754h.o(r5)
            goto L_0x002c
        L_0x0034:
            q3.d r5 = r5.b()
            int r9 = r5.c()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            int r5 = r5.c()
            int r7 = r7.length()
            int r7 = r7 + r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r7)
            java.lang.Integer[] r7 = new java.lang.Integer[r3]
            r7[r2] = r9
            r9 = 1
            r7[r9] = r5
            java.util.List r5 = X2.C2250q.j(r7)
        L_0x0058:
            if (r5 != 0) goto L_0x005e
            java.util.List r5 = X2.C2250q.g()
        L_0x005e:
            boolean r7 = r5.isEmpty()
            if (r7 != 0) goto L_0x00b4
            java.lang.Object r7 = X2.C2250q.M(r5)
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            java.lang.Object r9 = X2.C2250q.X(r5)
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            r1 = 33
            r6.setSpan(r8, r7, r9, r1)
            android.content.Context r7 = r4.getContext()
            if (r7 != 0) goto L_0x0084
            goto L_0x00b4
        L_0x0084:
            android.text.style.ForegroundColorSpan r8 = new android.text.style.ForegroundColorSpan
            m4.d r9 = r4.f18928l
            if (r9 != 0) goto L_0x008b
            goto L_0x008d
        L_0x008b:
            java.lang.Integer r0 = r9.f25327l
        L_0x008d:
            if (r0 != 0) goto L_0x0096
            int r9 = E1.a.colorBlueAccent
            int r7 = androidx.core.content.ContextCompat.getColor(r7, r9)
            goto L_0x009a
        L_0x0096:
            int r7 = r0.intValue()
        L_0x009a:
            r8.<init>(r7)
            java.lang.Object r7 = X2.C2250q.M(r5)
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            java.lang.Object r5 = X2.C2250q.X(r5)
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            r6.setSpan(r8, r7, r5, r1)
        L_0x00b4:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: Q2.m.h(java.lang.String, android.text.SpannableString, java.lang.String, android.text.style.ClickableSpan, boolean):android.text.SpannableString");
    }

    public final void k() {
        String str;
        String str2;
        int i5;
        Button button = this.f18921e;
        o oVar = null;
        if (button != null) {
            o oVar2 = this.f18925i;
            if (oVar2 == null) {
                t.w("viewModel");
                oVar2 = null;
            }
            button.setText(oVar2.f18940h.f25398d);
            button.setOnClickListener(new f(this));
        }
        Button button2 = this.f18920d;
        int i6 = 8;
        if (button2 != null) {
            o oVar3 = this.f18925i;
            if (oVar3 == null) {
                t.w("viewModel");
                oVar3 = null;
            }
            oVar3.getClass();
            if (V2.a.e()) {
                str2 = oVar3.f18940h.f25403i.f25333b;
            } else if (V2.a.d()) {
                String str3 = oVar3.f18940h.f25404j.f25304b;
                if (str3.length() == 0) {
                    str2 = oVar3.f18940h.f25399e;
                } else {
                    str2 = str3;
                }
            } else {
                str2 = oVar3.f18940h.f25399e;
            }
            button2.setText(str2);
            o oVar4 = this.f18925i;
            if (oVar4 == null) {
                t.w("viewModel");
                oVar4 = null;
            }
            oVar4.getClass();
            if ((!V2.a.e() || !oVar4.f18934b.f19281b.f19233X.f19209b.f19206a) && (V2.a.e() || !oVar4.f18939g)) {
                i5 = 8;
            } else {
                i5 = 0;
            }
            button2.setVisibility(i5);
            button2.setOnClickListener(new g(this));
        }
        Button button3 = this.f18919c;
        if (button3 != null) {
            o oVar5 = this.f18925i;
            if (oVar5 == null) {
                t.w("viewModel");
                oVar5 = null;
            }
            oVar5.getClass();
            if (V2.a.e()) {
                str = oVar5.f18940h.f25403i.f25332a;
            } else if (V2.a.d()) {
                String str4 = oVar5.f18940h.f25404j.f25303a;
                if (str4.length() == 0) {
                    str = oVar5.f18940h.f25397c;
                } else {
                    str = str4;
                }
            } else {
                str = oVar5.f18940h.f25397c;
            }
            button3.setText(e.a(str));
            button3.setOnClickListener(new h(this));
        }
        TextView textView = this.f18922f;
        if (textView != null) {
            o oVar6 = this.f18925i;
            if (oVar6 == null) {
                t.w("viewModel");
                oVar6 = null;
            }
            textView.setText(oVar6.f18940h.f25403i.f25334c);
            o oVar7 = this.f18925i;
            if (oVar7 == null) {
                t.w("viewModel");
            } else {
                oVar = oVar7;
            }
            oVar.getClass();
            if (V2.a.e() && oVar.f18934b.f19281b.f19233X.f19209b.f19207b) {
                i6 = 0;
            }
            textView.setVisibility(i6);
            textView.setOnClickListener(new i(this));
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ViewModelStore viewModelStore = activity.getViewModelStore();
            t.d(viewModelStore, "it.viewModelStore");
            this.f18925i = (o) new ViewModelProvider(viewModelStore, (ViewModelProvider.Factory) new p()).get(o.class);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:135:0x0289  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x02ba  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0206  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r12, android.os.Bundle r13) {
        /*
            r11 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.t.e(r12, r0)
            super.onViewCreated(r12, r13)
            android.app.Dialog r12 = r11.getDialog()
            r13 = 0
            if (r12 != 0) goto L_0x0010
            goto L_0x0013
        L_0x0010:
            r12.setCanceledOnTouchOutside(r13)
        L_0x0013:
            android.app.Dialog r12 = r11.getDialog()
            r0 = 0
            if (r12 != 0) goto L_0x001c
            r12 = r0
            goto L_0x0022
        L_0x001c:
            int r1 = com.google.android.material.R.id.design_bottom_sheet
            android.view.View r12 = r12.findViewById(r1)
        L_0x0022:
            if (r12 == 0) goto L_0x02df
            com.google.android.material.bottomsheet.BottomSheetBehavior r12 = com.google.android.material.bottomsheet.BottomSheetBehavior.from(r12)
            java.lang.String r1 = "from(bottomSheetView as View)"
            kotlin.jvm.internal.t.d(r12, r1)
            r12.setDraggable(r13)
            android.app.Dialog r12 = r11.getDialog()
            if (r12 != 0) goto L_0x0037
            goto L_0x003a
        L_0x0037:
            r12.setCancelable(r13)
        L_0x003a:
            m4.c r12 = s4.c.f25856d
            if (r12 != 0) goto L_0x003f
            goto L_0x0047
        L_0x003f:
            android.graphics.Typeface r1 = r12.f25314a
            r11.f18926j = r1
            android.graphics.Typeface r12 = r12.f25315b
            r11.f18927k = r12
        L_0x0047:
            m4.d r12 = s4.c.f25857e
            r11.f18928l = r12
            android.widget.TextView r12 = r11.f18924h
            java.lang.String r1 = "viewModel"
            if (r12 != 0) goto L_0x0052
            goto L_0x008a
        L_0x0052:
            Q2.o r2 = r11.f18925i
            if (r2 != 0) goto L_0x005a
            kotlin.jvm.internal.t.w(r1)
            r2 = r0
        L_0x005a:
            r2.getClass()
            boolean r3 = V2.a.e()
            if (r3 == 0) goto L_0x006a
            m4.i r2 = r2.f18940h
            m4.e r2 = r2.f25403i
            java.lang.String r2 = r2.f25336e
            goto L_0x0087
        L_0x006a:
            boolean r3 = V2.a.d()
            if (r3 == 0) goto L_0x0083
            m4.i r3 = r2.f18940h
            m4.a r3 = r3.f25404j
            java.lang.String r3 = r3.f25306d
            int r4 = r3.length()
            if (r4 != 0) goto L_0x0081
            m4.i r2 = r2.f18940h
            java.lang.String r2 = r2.f25395a
            goto L_0x0087
        L_0x0081:
            r2 = r3
            goto L_0x0087
        L_0x0083:
            m4.i r2 = r2.f18940h
            java.lang.String r2 = r2.f25395a
        L_0x0087:
            r12.setText(r2)
        L_0x008a:
            boolean r12 = V2.a.e()
            if (r12 != 0) goto L_0x00b9
            Q2.o r12 = r11.f18925i
            if (r12 != 0) goto L_0x0098
            kotlin.jvm.internal.t.w(r1)
            r12 = r0
        L_0x0098:
            r12.getClass()
            T3.i r2 = s4.c.j()
            T3.c r2 = r2.f19281b
            T3.d r2 = r2.f19231V
            java.lang.Boolean r2 = r2.f19263b
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            boolean r2 = kotlin.jvm.internal.t.a(r2, r3)
            if (r2 == 0) goto L_0x00bc
            m4.i r12 = r12.f18940h
            m4.a r12 = r12.f25404j
            java.lang.String r12 = r12.f25305c
            int r12 = r12.length()
            if (r12 <= 0) goto L_0x00bc
        L_0x00b9:
            r4 = r11
            goto L_0x01d9
        L_0x00bc:
            Q2.o r12 = r11.f18925i
            if (r12 != 0) goto L_0x00c4
            kotlin.jvm.internal.t.w(r1)
            r12 = r0
        L_0x00c4:
            J2.u r2 = r12.f18933a
            P3.d r2 = r2.f18314a
            if (r2 != 0) goto L_0x00cb
            goto L_0x00cf
        L_0x00cb:
            java.util.Map r2 = r2.f18877i
            if (r2 != 0) goto L_0x00d1
        L_0x00cf:
            r2 = r13
            goto L_0x0104
        L_0x00d1:
            java.util.LinkedHashMap r3 = new java.util.LinkedHashMap
            r3.<init>()
            java.util.Set r2 = r2.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x00de:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0100
            java.lang.Object r4 = r2.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getValue()
            P3.k r5 = (P3.k) r5
            java.lang.String r5 = r5.f18895k
            if (r5 != 0) goto L_0x00de
            java.lang.Object r5 = r4.getKey()
            java.lang.Object r4 = r4.getValue()
            r3.put(r5, r4)
            goto L_0x00de
        L_0x0100:
            int r2 = r3.size()
        L_0x0104:
            T3.i r3 = r12.f18934b
            T3.h r3 = r3.f19282c
            java.util.List r3 = r3.f19277a
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Iterator r3 = r3.iterator()
        L_0x0113:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x015b
            java.lang.Object r5 = r3.next()
            r6 = r5
            T3.g r6 = (T3.g) r6
            java.util.List r6 = r6.f19275f
            java.util.Set r6 = X2.C2250q.r0(r6)
            T3.i r7 = r12.f18934b
            T3.c r7 = r7.f19281b
            java.util.List r7 = r7.f19243h
            boolean r8 = b.w.a(r6)
            if (r8 == 0) goto L_0x0139
            boolean r8 = r6.isEmpty()
            if (r8 == 0) goto L_0x0139
            goto L_0x0113
        L_0x0139:
            java.util.Iterator r6 = r6.iterator()
        L_0x013d:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x0113
            java.lang.Object r8 = r6.next()
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            boolean r8 = r7.contains(r8)
            if (r8 == 0) goto L_0x013d
            r4.add(r5)
            goto L_0x0113
        L_0x015b:
            int r3 = r4.size()
            int r3 = r3 + r2
            J2.f r2 = r12.f18935c
            java.util.Map r2 = r2.f18273a
            int r2 = r2.size()
            int r2 = r2 + r3
            P3.k r12 = r12.f18936d
            r3 = 1
            if (r12 != 0) goto L_0x016f
            goto L_0x0170
        L_0x016f:
            r13 = r3
        L_0x0170:
            int r2 = r2 + r13
            java.lang.String r12 = java.lang.String.valueOf(r2)
            Q2.o r13 = r11.f18925i
            if (r13 != 0) goto L_0x017d
            kotlin.jvm.internal.t.w(r1)
            r13 = r0
        L_0x017d:
            java.lang.String r13 = r13.a()
            java.lang.String r2 = "${partners}"
            java.lang.String r12 = t3.s.J(r13, r2, r12, r3)
            int r13 = E1.e.consent_storage_method
            java.lang.String r13 = r11.getString(r13)
            java.lang.String r2 = "getString(R.string.consent_storage_method)"
            kotlin.jvm.internal.t.d(r13, r2)
            java.lang.String r2 = "${consentStorageMethod}"
            java.lang.String r12 = t3.s.J(r12, r2, r13, r3)
            java.lang.String r13 = "${consentStorageDuration}"
            java.lang.String r2 = "13"
            java.lang.String r5 = t3.s.J(r12, r13, r2, r3)
            android.text.SpannableString r6 = new android.text.SpannableString
            r6.<init>(r5)
            Q2.o r12 = r11.f18925i
            if (r12 != 0) goto L_0x01ad
            kotlin.jvm.internal.t.w(r1)
            r12 = r0
        L_0x01ad:
            m4.i r12 = r12.f18940h
            java.lang.String r7 = r12.f25400f
            Q2.d r8 = new Q2.d
            r8.<init>(r11)
            r9 = 0
            r4 = r11
            r4.h(r5, r6, r7, r8, r9)
            Q2.o r12 = r4.f18925i
            if (r12 != 0) goto L_0x01c3
            kotlin.jvm.internal.t.w(r1)
            r12 = r0
        L_0x01c3:
            m4.i r12 = r12.f18940h
            java.lang.String r7 = r12.f25402h
            Q2.e r8 = new Q2.e
            r8.<init>(r11)
            r9 = 1
            r4.h(r5, r6, r7, r8, r9)
            android.widget.TextView r12 = r4.f18923g
            if (r12 != 0) goto L_0x01d5
            goto L_0x01f1
        L_0x01d5:
            r12.setText(r6)
            goto L_0x01f1
        L_0x01d9:
            android.widget.TextView r12 = r4.f18923g
            if (r12 != 0) goto L_0x01de
            goto L_0x01f1
        L_0x01de:
            Q2.o r2 = r4.f18925i
            if (r2 != 0) goto L_0x01e6
            kotlin.jvm.internal.t.w(r1)
            r2 = r0
        L_0x01e6:
            java.lang.String r2 = r2.a()
            android.text.Spanned r13 = androidx.core.text.HtmlCompat.fromHtml(r2, r13)
            r12.setText(r13)
        L_0x01f1:
            android.widget.TextView r12 = r4.f18923g
            if (r12 != 0) goto L_0x01f6
            goto L_0x01fd
        L_0x01f6:
            android.text.method.MovementMethod r13 = android.text.method.LinkMovementMethod.getInstance()
            r12.setMovementMethod(r13)
        L_0x01fd:
            r11.k()
            m4.d r12 = r4.f18928l
            if (r12 != 0) goto L_0x0206
            goto L_0x0284
        L_0x0206:
            java.lang.Integer r13 = r12.f25322g
            if (r13 != 0) goto L_0x020b
            goto L_0x0217
        L_0x020b:
            int r13 = r13.intValue()
            androidx.constraintlayout.widget.ConstraintLayout r2 = r4.f18917a
            if (r2 != 0) goto L_0x0214
            goto L_0x0217
        L_0x0214:
            r2.setBackgroundColor(r13)
        L_0x0217:
            java.lang.Integer r13 = r12.f25323h
            if (r13 != 0) goto L_0x021c
            goto L_0x0228
        L_0x021c:
            int r13 = r13.intValue()
            android.widget.TextView r2 = r4.f18924h
            if (r2 != 0) goto L_0x0225
            goto L_0x0228
        L_0x0225:
            r2.setTextColor(r13)
        L_0x0228:
            java.lang.Integer r13 = r12.f25324i
            if (r13 != 0) goto L_0x022d
            goto L_0x0239
        L_0x022d:
            int r13 = r13.intValue()
            android.widget.TextView r2 = r4.f18923g
            if (r2 != 0) goto L_0x0236
            goto L_0x0239
        L_0x0236:
            r2.setTextColor(r13)
        L_0x0239:
            java.lang.Integer r13 = r12.f25328m
            if (r13 != 0) goto L_0x023e
            goto L_0x0252
        L_0x023e:
            int r13 = r13.intValue()
            android.widget.Button r2 = r4.f18921e
            if (r2 != 0) goto L_0x0247
            goto L_0x024a
        L_0x0247:
            r2.setTextColor(r13)
        L_0x024a:
            android.widget.Button r2 = r4.f18920d
            if (r2 != 0) goto L_0x024f
            goto L_0x0252
        L_0x024f:
            r2.setTextColor(r13)
        L_0x0252:
            java.lang.Integer r13 = r12.f25330o
            if (r13 != 0) goto L_0x0257
            goto L_0x026b
        L_0x0257:
            int r13 = r13.intValue()
            android.widget.Button r2 = r4.f18921e
            if (r2 != 0) goto L_0x0260
            goto L_0x0263
        L_0x0260:
            r2.setBackgroundColor(r13)
        L_0x0263:
            android.widget.Button r2 = r4.f18920d
            if (r2 != 0) goto L_0x0268
            goto L_0x026b
        L_0x0268:
            r2.setBackgroundColor(r13)
        L_0x026b:
            java.lang.Integer r12 = r12.f25327l
            if (r12 != 0) goto L_0x0270
            goto L_0x0284
        L_0x0270:
            int r12 = r12.intValue()
            android.widget.Button r13 = r4.f18919c
            if (r13 != 0) goto L_0x0279
            goto L_0x027c
        L_0x0279:
            r13.setTextColor(r12)
        L_0x027c:
            android.widget.TextView r13 = r4.f18922f
            if (r13 != 0) goto L_0x0281
            goto L_0x0284
        L_0x0281:
            r13.setTextColor(r12)
        L_0x0284:
            android.graphics.Typeface r12 = r4.f18926j
            if (r12 != 0) goto L_0x0289
            goto L_0x02a9
        L_0x0289:
            android.widget.TextView r13 = r4.f18924h
            if (r13 != 0) goto L_0x028e
            goto L_0x0291
        L_0x028e:
            r13.setTypeface(r12)
        L_0x0291:
            android.widget.Button r13 = r4.f18921e
            if (r13 != 0) goto L_0x0296
            goto L_0x0299
        L_0x0296:
            r13.setTypeface(r12)
        L_0x0299:
            android.widget.Button r13 = r4.f18920d
            if (r13 != 0) goto L_0x029e
            goto L_0x02a1
        L_0x029e:
            r13.setTypeface(r12)
        L_0x02a1:
            android.widget.Button r13 = r4.f18919c
            if (r13 != 0) goto L_0x02a6
            goto L_0x02a9
        L_0x02a6:
            r13.setTypeface(r12)
        L_0x02a9:
            android.graphics.Typeface r12 = r4.f18927k
            if (r12 != 0) goto L_0x02ae
            goto L_0x02b6
        L_0x02ae:
            android.widget.TextView r13 = r4.f18923g
            if (r13 != 0) goto L_0x02b3
            goto L_0x02b6
        L_0x02b3:
            r13.setTypeface(r12)
        L_0x02b6:
            Q2.o r12 = r4.f18925i
            if (r12 != 0) goto L_0x02be
            kotlin.jvm.internal.t.w(r1)
            r12 = r0
        L_0x02be:
            Q2.c r13 = new Q2.c
            r13.<init>(r11)
            r12.getClass()
            java.lang.String r1 = "result"
            kotlin.jvm.internal.t.e(r13, r1)
            w3.M r5 = androidx.lifecycle.ViewModelKt.getViewModelScope(r12)
            w3.I r6 = w3.C2865c0.b()
            Q2.n r8 = new Q2.n
            r8.<init>(r13, r12, r0)
            r9 = 2
            r10 = 0
            r7 = 0
            w3.C2908y0 unused = w3.C2876i.d(r5, r6, r7, r8, r9, r10)
            return
        L_0x02df:
            r4 = r11
            java.lang.NullPointerException r12 = new java.lang.NullPointerException
            java.lang.String r13 = "null cannot be cast to non-null type android.view.View"
            r12.<init>(r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: Q2.m.onViewCreated(android.view.View, android.os.Bundle):void");
    }
}
