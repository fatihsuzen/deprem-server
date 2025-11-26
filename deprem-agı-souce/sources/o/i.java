package o;

import E1.e;
import I2.k;
import I2.l;
import O2.j;
import T3.g;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b3.C2308e;
import c.h;
import com.mbridge.msdk.MBridgeConstans;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import k4.A;
import k4.z;
import kotlin.jvm.internal.t;
import m4.d;
import s4.c;
import v4.b;
import w3.C2865c0;
import w3.C2908y0;
import w3.O;

public final class i extends b implements c.b {

    /* renamed from: m  reason: collision with root package name */
    public ConstraintLayout f979m;

    /* renamed from: n  reason: collision with root package name */
    public Button f980n;

    /* renamed from: o  reason: collision with root package name */
    public Button f981o;

    /* renamed from: p  reason: collision with root package name */
    public RecyclerView f982p;

    /* renamed from: q  reason: collision with root package name */
    public k f983q;

    /* renamed from: r  reason: collision with root package name */
    public k f984r;

    /* renamed from: s  reason: collision with root package name */
    public h f985s;

    public static final void i(PopupWindow popupWindow, i iVar, View view) {
        t.e(popupWindow, "$mypopupWindow");
        t.e(iVar, "this$0");
        popupWindow.dismiss();
        TextView textView = iVar.f26050b;
        if (textView != null) {
            textView.setText(iVar.getString(e.leg_interest_all_partners_toolbar_title));
        }
        k kVar = iVar.f983q;
        if (kVar == null) {
            t.w("viewModel");
            kVar = null;
        }
        j jVar = j.f18829a;
        kVar.getClass();
        t.e(jVar, "<set-?>");
        kVar.f997j = jVar;
        iVar.s();
    }

    public static final void k(i iVar, View view) {
        t.e(iVar, "this$0");
        iVar.dismiss();
    }

    public static final void l(i iVar, PopupWindow popupWindow, ImageView imageView, CardView cardView, TextView textView, TextView textView2, TextView textView3, View view) {
        Integer num;
        Integer num2;
        t.e(iVar, "this$0");
        t.e(popupWindow, "$mypopupWindow");
        d dVar = iVar.f26058j;
        if (!(dVar == null || (num2 = dVar.f25322g) == null)) {
            cardView.setBackgroundTintList(ColorStateList.valueOf(num2.intValue()));
        }
        d dVar2 = iVar.f26058j;
        if (!(dVar2 == null || (num = dVar2.f25326k) == null)) {
            int intValue = num.intValue();
            if (textView != null) {
                textView.setTextColor(ColorStateList.valueOf(intValue));
            }
            if (textView2 != null) {
                textView2.setTextColor(ColorStateList.valueOf(intValue));
            }
            if (textView3 != null) {
                textView3.setTextColor(ColorStateList.valueOf(intValue));
            }
        }
        popupWindow.showAsDropDown(imageView);
    }

    public static final void n(PopupWindow popupWindow, i iVar, View view) {
        t.e(popupWindow, "$mypopupWindow");
        t.e(iVar, "this$0");
        popupWindow.dismiss();
        TextView textView = iVar.f26050b;
        if (textView != null) {
            textView.setText(iVar.getString(e.leg_interest_iab_partners_toolbar_title));
        }
        k kVar = iVar.f983q;
        if (kVar == null) {
            t.w("viewModel");
            kVar = null;
        }
        j jVar = j.f18830b;
        kVar.getClass();
        t.e(jVar, "<set-?>");
        kVar.f997j = jVar;
        iVar.s();
    }

    public static final void o(i iVar, View view) {
        Map map;
        t.e(iVar, "this$0");
        k kVar = iVar.f983q;
        if (kVar == null) {
            t.w("viewModel");
            kVar = null;
        }
        P3.d dVar = kVar.f988a.f18314a;
        if (!(dVar == null || (map = dVar.f18877i) == null)) {
            for (Map.Entry entry : map.entrySet()) {
                if (!((P3.k) entry.getValue()).f18889e.isEmpty()) {
                    kVar.f988a.f18309C.unset(((P3.k) entry.getValue()).f18881a);
                }
            }
        }
        for (g gVar : kVar.f990c.f19277a) {
            if (!gVar.f19276g.isEmpty()) {
                kVar.f988a.f18310D.unset(gVar.f19270a);
            }
        }
        LinkedHashMap g5 = kVar.g();
        if (g5 != null) {
            for (Map.Entry key : g5.entrySet()) {
                kVar.f988a.f18332s.unset(Integer.parseInt((String) key.getKey()));
            }
        }
        kVar.f988a.f18336w.unsetAllOwnedItems();
        UUID uuid = z.f24676a;
        A a5 = A.OBJECT_ALL_LEGITIMATE;
        t.e(a5, "navigationTag");
        c.m().getClass();
        z.f24677b.i(String.valueOf(a5), "_legitimatePurposesConsents");
        iVar.p();
    }

    public static final void q(PopupWindow popupWindow, i iVar, View view) {
        t.e(popupWindow, "$mypopupWindow");
        t.e(iVar, "this$0");
        popupWindow.dismiss();
        TextView textView = iVar.f26050b;
        if (textView != null) {
            textView.setText(iVar.getString(e.leg_interest_non_iab_partners_toolbar_title));
        }
        k kVar = iVar.f983q;
        if (kVar == null) {
            t.w("viewModel");
            kVar = null;
        }
        j jVar = j.f18831c;
        kVar.getClass();
        t.e(jVar, "<set-?>");
        kVar.f997j = jVar;
        iVar.s();
    }

    public static final void r(i iVar, View view) {
        Map map;
        t.e(iVar, "this$0");
        k kVar = iVar.f983q;
        if (kVar == null) {
            t.w("viewModel");
            kVar = null;
        }
        P3.d dVar = kVar.f988a.f18314a;
        if (!(dVar == null || (map = dVar.f18877i) == null)) {
            for (Map.Entry entry : map.entrySet()) {
                if (!((P3.k) entry.getValue()).f18889e.isEmpty()) {
                    kVar.f988a.f18309C.set(((P3.k) entry.getValue()).f18881a);
                }
            }
        }
        for (g gVar : kVar.f990c.f19277a) {
            if (!gVar.f19276g.isEmpty()) {
                kVar.f988a.f18310D.set(gVar.f19270a);
            }
        }
        LinkedHashMap g5 = kVar.g();
        if (g5 != null) {
            for (Map.Entry key : g5.entrySet()) {
                kVar.f988a.f18332s.set(Integer.parseInt((String) key.getKey()));
            }
        }
        kVar.f988a.f18336w.setAllOwnedItems();
        UUID uuid = z.f24676a;
        A a5 = A.ACCEPT_ALL_LEGITIMATE;
        t.e(a5, "navigationTag");
        c.m().getClass();
        z.f24677b.i(String.valueOf(a5), "_legitimatePurposesConsents");
        iVar.p();
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x014f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(c.i r28) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            java.lang.String r2 = "item"
            kotlin.jvm.internal.t.e(r1, r2)
            androidx.fragment.app.FragmentActivity r2 = r0.getActivity()
            if (r2 != 0) goto L_0x0011
            goto L_0x0207
        L_0x0011:
            P3.e r3 = r1.f894a
            boolean r4 = r3 instanceof P3.k
            java.lang.String r5 = "viewModel"
            if (r4 == 0) goto L_0x019c
            androidx.fragment.app.FragmentManager r3 = r2.getSupportFragmentManager()
            java.lang.String r4 = M2.g.f18627H
            androidx.fragment.app.Fragment r3 = r3.findFragmentByTag(r4)
            if (r3 != 0) goto L_0x0207
            P3.e r3 = r1.f894a
            boolean r7 = r3 instanceof P3.k
            if (r7 == 0) goto L_0x0185
            M2.b r8 = new M2.b
            java.lang.String r9 = r3.f18882b
            P3.k r3 = (P3.k) r3
            java.lang.String r10 = r3.f18887c
            o.k r3 = r0.f983q
            if (r3 != 0) goto L_0x003b
            kotlin.jvm.internal.t.w(r5)
            r3 = 0
        L_0x003b:
            P3.e r7 = r1.f894a
            P3.k r7 = (P3.k) r7
            java.util.Set r7 = r7.f18889e
            O2.a r11 = O2.a.f18801a
            java.lang.String r12 = r3.a(r7, r11)
            o.k r3 = r0.f983q
            if (r3 != 0) goto L_0x004f
            kotlin.jvm.internal.t.w(r5)
            r3 = 0
        L_0x004f:
            P3.e r7 = r1.f894a
            P3.k r7 = (P3.k) r7
            java.util.Set r7 = r7.f18891g
            O2.a r11 = O2.a.f18802b
            java.lang.String r13 = r3.a(r7, r11)
            o.k r3 = r0.f983q
            if (r3 != 0) goto L_0x0063
            kotlin.jvm.internal.t.w(r5)
            r3 = 0
        L_0x0063:
            P3.e r7 = r1.f894a
            P3.k r7 = (P3.k) r7
            java.util.Set r7 = r7.f18892h
            O2.a r11 = O2.a.f18803c
            java.lang.String r14 = r3.a(r7, r11)
            o.k r3 = r0.f983q
            if (r3 != 0) goto L_0x0077
            kotlin.jvm.internal.t.w(r5)
            r3 = 0
        L_0x0077:
            P3.e r7 = r1.f894a
            P3.k r7 = (P3.k) r7
            java.util.Set r7 = r7.f18893i
            O2.a r11 = O2.a.f18804d
            java.lang.String r15 = r3.a(r7, r11)
            o.k r3 = r0.f983q
            if (r3 != 0) goto L_0x008b
            kotlin.jvm.internal.t.w(r5)
            r3 = 0
        L_0x008b:
            P3.e r7 = r1.f894a
            P3.k r7 = (P3.k) r7
            java.util.Set r7 = r7.f18898n
            O2.a r11 = O2.a.f18805e
            java.lang.String r16 = r3.a(r7, r11)
            P3.e r3 = r1.f894a
            P3.k r3 = (P3.k) r3
            java.lang.String r3 = r3.f18894j
            o.k r7 = r0.f983q
            if (r7 != 0) goto L_0x00a5
            kotlin.jvm.internal.t.w(r5)
            r7 = 0
        L_0x00a5:
            P3.e r11 = r1.f894a
            P3.k r11 = (P3.k) r11
            int r11 = r11.f18896l
            r7.getClass()
            java.lang.String r17 = ""
            if (r11 >= 0) goto L_0x00b7
            r26 = r2
            r2 = r17
            goto L_0x0100
        L_0x00b7:
            float r6 = (float) r11
            r19 = 1202241536(0x47a8c000, float:86400.0)
            float r6 = r6 / r19
            r19 = 1065353216(0x3f800000, float:1.0)
            int r19 = (r6 > r19 ? 1 : (r6 == r19 ? 0 : -1))
            r26 = r2
            r2 = 32
            if (r19 < 0) goto L_0x00e6
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            int r6 = m3.C2690a.a(r6)
            r11.append(r6)
            r11.append(r2)
            o4.k r2 = r7.f991d
            m4.m r2 = r2.g()
            java.lang.String r2 = r2.f25458i
            r11.append(r2)
            java.lang.String r2 = r11.toString()
            goto L_0x0100
        L_0x00e6:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r11)
            r6.append(r2)
            o4.k r2 = r7.f991d
            m4.m r2 = r2.g()
            java.lang.String r2 = r2.f25459j
            r6.append(r2)
            java.lang.String r2 = r6.toString()
        L_0x0100:
            o.k r6 = r0.f983q
            if (r6 != 0) goto L_0x0108
            kotlin.jvm.internal.t.w(r5)
            r6 = 0
        L_0x0108:
            P3.e r5 = r1.f894a
            P3.k r5 = (P3.k) r5
            java.lang.Boolean r5 = r5.f18897m
            r6.getClass()
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            boolean r7 = kotlin.jvm.internal.t.a(r5, r7)
            if (r7 == 0) goto L_0x0124
            o4.k r5 = r6.f991d
            m4.m r5 = r5.g()
            java.lang.String r5 = r5.f25462m
        L_0x0121:
            r19 = r5
            goto L_0x0137
        L_0x0124:
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            boolean r5 = kotlin.jvm.internal.t.a(r5, r7)
            if (r5 == 0) goto L_0x0135
            o4.k r5 = r6.f991d
            m4.m r5 = r5.g()
            java.lang.String r5 = r5.f25463n
            goto L_0x0121
        L_0x0135:
            r19 = r17
        L_0x0137:
            P3.e r5 = r1.f894a
            P3.k r5 = (P3.k) r5
            P3.b r5 = r5.f18899o
            if (r5 != 0) goto L_0x0140
            goto L_0x014c
        L_0x0140:
            int r5 = r5.f18866a
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r5 = r5.toString()
            if (r5 != 0) goto L_0x014f
        L_0x014c:
            r20 = r17
            goto L_0x0151
        L_0x014f:
            r20 = r5
        L_0x0151:
            P3.e r5 = r1.f894a
            int r6 = r5.f18881a
            c.k r1 = r1.f897d
            P3.k r5 = (P3.k) r5
            java.lang.String r5 = r5.f18900p
            java.lang.String r24 = "Error: cannot load vendor file"
            r25 = 4
            r11 = 0
            r22 = r1
            r18 = r2
            r17 = r3
            r23 = r5
            r21 = r6
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            java.lang.String r1 = "args"
            kotlin.jvm.internal.t.e(r8, r1)
            M2.g r6 = new M2.g
            r6.<init>()
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            java.lang.String r2 = "partner_detail_args"
            r1.putParcelable(r2, r8)
            r6.setArguments(r1)
            goto L_0x0188
        L_0x0185:
            r26 = r2
            r6 = 0
        L_0x0188:
            if (r6 != 0) goto L_0x018c
            goto L_0x0207
        L_0x018c:
            androidx.fragment.app.FragmentManager r1 = r26.getSupportFragmentManager()
            androidx.fragment.app.FragmentTransaction r1 = r1.beginTransaction()
            androidx.fragment.app.FragmentTransaction r1 = r1.add((androidx.fragment.app.Fragment) r6, (java.lang.String) r4)
            r1.commit()
            return
        L_0x019c:
            r26 = r2
            boolean r2 = r3 instanceof P3.f
            if (r2 == 0) goto L_0x0207
            androidx.fragment.app.FragmentManager r2 = r26.getSupportFragmentManager()
            java.lang.String r3 = v4.p.f26090y
            androidx.fragment.app.Fragment r2 = r2.findFragmentByTag(r3)
            if (r2 != 0) goto L_0x0207
            androidx.fragment.app.FragmentManager r2 = r26.getSupportFragmentManager()
            androidx.fragment.app.FragmentTransaction r2 = r2.beginTransaction()
            P3.e r4 = r1.f894a
            java.lang.String r6 = r4.f18882b
            P3.f r4 = (P3.f) r4
            java.lang.String r7 = r4.a()
            P3.e r4 = r1.f894a
            P3.f r4 = (P3.f) r4
            java.lang.String r8 = r4.b()
            I2.k r4 = r0.f984r
            java.lang.String r9 = "optionsViewModel"
            if (r4 != 0) goto L_0x01d2
            kotlin.jvm.internal.t.w(r9)
            r4 = 0
        L_0x01d2:
            o4.k r4 = r4.f18233f
            m4.l r4 = r4.e()
            java.lang.String r4 = r4.f25440i
            I2.k r10 = r0.f984r
            if (r10 != 0) goto L_0x01e2
            kotlin.jvm.internal.t.w(r9)
            r10 = 0
        L_0x01e2:
            o4.k r9 = r10.f18233f
            m4.l r9 = r9.e()
            java.lang.String r10 = r9.f25445n
            P3.e r9 = r1.f894a
            int r11 = r9.f18881a
            c.k r12 = r1.f897d
            o.k r1 = r0.f983q
            if (r1 != 0) goto L_0x01f8
            kotlin.jvm.internal.t.w(r5)
            r1 = 0
        L_0x01f8:
            O2.j r14 = r1.f997j
            r13 = 1
            r9 = r4
            v4.p r1 = v4.k.b(r6, r7, r8, r9, r10, r11, r12, r13, r14)
            androidx.fragment.app.FragmentTransaction r1 = r2.add((androidx.fragment.app.Fragment) r1, (java.lang.String) r3)
            r1.commit()
        L_0x0207:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o.i.d(c.i):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x0221  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0225  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(c.i r8) {
        /*
            r7 = this;
            java.lang.String r0 = "item"
            kotlin.jvm.internal.t.e(r8, r0)
            o.k r1 = r7.f983q
            r2 = 0
            java.lang.String r3 = "viewModel"
            if (r1 != 0) goto L_0x0010
            kotlin.jvm.internal.t.w(r3)
            r1 = r2
        L_0x0010:
            r1.getClass()
            kotlin.jvm.internal.t.e(r8, r0)
            c.k r0 = r8.f897d
            c.k r4 = c.k.NON_IAB_VENDOR
            java.lang.String r5 = "Non IAB_"
            if (r0 != r4) goto L_0x0054
            java.lang.Boolean r0 = r8.f895b
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            boolean r0 = kotlin.jvm.internal.t.a(r0, r6)
            if (r0 == 0) goto L_0x0054
            J2.u r0 = r1.f988a
            com.inmobi.cmp.core.model.Vector r0 = r0.f18310D
            P3.e r1 = r8.f894a
            int r1 = r1.f18881a
            r0.set((int) r1)
            java.util.UUID r0 = k4.z.f24676a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r5)
            P3.e r1 = r8.f894a
            int r1 = r1.f18881a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.Boolean r8 = r8.f895b
            boolean r8 = kotlin.jvm.internal.t.a(r8, r6)
            java.lang.String r8 = java.lang.String.valueOf(r8)
            k4.z.d(r0, r8)
            goto L_0x021d
        L_0x0054:
            c.k r0 = r8.f897d
            if (r0 != r4) goto L_0x0090
            java.lang.Boolean r0 = r8.f895b
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            boolean r0 = kotlin.jvm.internal.t.a(r0, r4)
            if (r0 == 0) goto L_0x0090
            J2.u r0 = r1.f988a
            com.inmobi.cmp.core.model.Vector r0 = r0.f18310D
            P3.e r1 = r8.f894a
            int r1 = r1.f18881a
            r0.unset((int) r1)
            java.util.UUID r0 = k4.z.f24676a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r5)
            P3.e r1 = r8.f894a
            int r1 = r1.f18881a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.Boolean r8 = r8.f895b
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            boolean r8 = kotlin.jvm.internal.t.a(r8, r1)
            java.lang.String r8 = java.lang.String.valueOf(r8)
            k4.z.d(r0, r8)
            goto L_0x021d
        L_0x0090:
            c.k r0 = r8.f897d
            c.k r4 = c.k.IAB_VENDOR
            java.lang.String r5 = "Legitimate Vendors_"
            if (r0 != r4) goto L_0x00ce
            java.lang.Boolean r0 = r8.f895b
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            boolean r0 = kotlin.jvm.internal.t.a(r0, r6)
            if (r0 == 0) goto L_0x00ce
            J2.u r0 = r1.f988a
            com.inmobi.cmp.core.model.Vector r0 = r0.f18309C
            P3.e r1 = r8.f894a
            int r1 = r1.f18881a
            r0.set((int) r1)
            java.util.UUID r0 = k4.z.f24676a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r5)
            P3.e r1 = r8.f894a
            int r1 = r1.f18881a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.Boolean r8 = r8.f895b
            boolean r8 = kotlin.jvm.internal.t.a(r8, r6)
            java.lang.String r8 = java.lang.String.valueOf(r8)
            k4.z.d(r0, r8)
            goto L_0x021d
        L_0x00ce:
            c.k r0 = r8.f897d
            if (r0 != r4) goto L_0x010a
            java.lang.Boolean r0 = r8.f895b
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            boolean r0 = kotlin.jvm.internal.t.a(r0, r4)
            if (r0 == 0) goto L_0x010a
            J2.u r0 = r1.f988a
            com.inmobi.cmp.core.model.Vector r0 = r0.f18309C
            P3.e r1 = r8.f894a
            int r1 = r1.f18881a
            r0.unset((int) r1)
            java.util.UUID r0 = k4.z.f24676a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r5)
            P3.e r1 = r8.f894a
            int r1 = r1.f18881a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.Boolean r8 = r8.f895b
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            boolean r8 = kotlin.jvm.internal.t.a(r8, r1)
            java.lang.String r8 = java.lang.String.valueOf(r8)
            k4.z.d(r0, r8)
            goto L_0x021d
        L_0x010a:
            c.k r0 = r8.f897d
            c.k r4 = c.k.PUBLISHER_VENDOR
            java.lang.String r5 = "Vendors_"
            if (r0 != r4) goto L_0x0159
            java.lang.Boolean r0 = r8.f895b
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            boolean r0 = kotlin.jvm.internal.t.a(r0, r6)
            if (r0 == 0) goto L_0x0159
            J2.u r0 = r1.f988a
            com.inmobi.cmp.core.model.Vector r0 = r0.f18334u
            P3.e r4 = r8.f894a
            int r4 = r4.f18881a
            r0.set((int) r4)
            J2.u r0 = r1.f988a
            com.inmobi.cmp.core.model.Vector r0 = r0.f18336w
            P3.e r1 = r8.f894a
            P3.k r1 = (P3.k) r1
            java.util.Set r1 = r1.f18889e
            java.util.Set r1 = X2.C2250q.r0(r1)
            r0.setItems(r1)
            java.util.UUID r0 = k4.z.f24676a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r5)
            P3.e r1 = r8.f894a
            int r1 = r1.f18881a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.Boolean r8 = r8.f895b
            boolean r8 = kotlin.jvm.internal.t.a(r8, r6)
            java.lang.String r8 = java.lang.String.valueOf(r8)
            k4.z.d(r0, r8)
            goto L_0x021d
        L_0x0159:
            c.k r0 = r8.f897d
            if (r0 != r4) goto L_0x01a6
            java.lang.Boolean r0 = r8.f895b
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            boolean r0 = kotlin.jvm.internal.t.a(r0, r4)
            if (r0 == 0) goto L_0x01a6
            J2.u r0 = r1.f988a
            com.inmobi.cmp.core.model.Vector r0 = r0.f18334u
            P3.e r4 = r8.f894a
            int r4 = r4.f18881a
            r0.unset((int) r4)
            J2.u r0 = r1.f988a
            com.inmobi.cmp.core.model.Vector r0 = r0.f18336w
            P3.e r1 = r8.f894a
            P3.k r1 = (P3.k) r1
            java.util.Set r1 = r1.f18889e
            java.util.Set r1 = X2.C2250q.r0(r1)
            r0.unset((java.util.Set<java.lang.Integer>) r1)
            java.util.UUID r0 = k4.z.f24676a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r5)
            P3.e r1 = r8.f894a
            int r1 = r1.f18881a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.Boolean r8 = r8.f895b
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            boolean r8 = kotlin.jvm.internal.t.a(r8, r1)
            java.lang.String r8 = java.lang.String.valueOf(r8)
            k4.z.d(r0, r8)
            goto L_0x021d
        L_0x01a6:
            c.k r0 = r8.f897d
            c.k r4 = c.k.PURPOSE
            java.lang.String r5 = "Legitimate Purposes_"
            if (r0 != r4) goto L_0x01e3
            java.lang.Boolean r0 = r8.f895b
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            boolean r0 = kotlin.jvm.internal.t.a(r0, r6)
            if (r0 == 0) goto L_0x01e3
            J2.u r0 = r1.f988a
            com.inmobi.cmp.core.model.Vector r0 = r0.f18332s
            P3.e r1 = r8.f894a
            int r1 = r1.f18881a
            r0.set((int) r1)
            java.util.UUID r0 = k4.z.f24676a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r5)
            P3.e r1 = r8.f894a
            int r1 = r1.f18881a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.Boolean r8 = r8.f895b
            boolean r8 = kotlin.jvm.internal.t.a(r8, r6)
            java.lang.String r8 = java.lang.String.valueOf(r8)
            k4.z.d(r0, r8)
            goto L_0x021d
        L_0x01e3:
            c.k r0 = r8.f897d
            if (r0 != r4) goto L_0x021d
            java.lang.Boolean r0 = r8.f895b
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            boolean r0 = kotlin.jvm.internal.t.a(r0, r4)
            if (r0 == 0) goto L_0x021d
            J2.u r0 = r1.f988a
            com.inmobi.cmp.core.model.Vector r0 = r0.f18332s
            P3.e r1 = r8.f894a
            int r1 = r1.f18881a
            r0.unset((int) r1)
            java.util.UUID r0 = k4.z.f24676a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r5)
            P3.e r1 = r8.f894a
            int r1 = r1.f18881a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.Boolean r8 = r8.f895b
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            boolean r8 = kotlin.jvm.internal.t.a(r8, r1)
            java.lang.String r8 = java.lang.String.valueOf(r8)
            k4.z.d(r0, r8)
        L_0x021d:
            o.k r8 = r7.f983q
            if (r8 != 0) goto L_0x0225
            kotlin.jvm.internal.t.w(r3)
            goto L_0x0226
        L_0x0225:
            r2 = r8
        L_0x0226:
            java.util.LinkedHashSet r8 = r2.b()
            r7.j(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o.i.e(c.i):void");
    }

    public final ColorStateList h() {
        Integer num;
        d dVar = this.f26058j;
        if (dVar == null || (num = dVar.f25330o) == null || dVar.f25331p == null) {
            return null;
        }
        return new ColorStateList(new int[][]{new int[]{16842910}, new int[]{-16842910}}, new int[]{num.intValue(), dVar.f25331p.intValue()});
    }

    public final void j(LinkedHashSet linkedHashSet) {
        boolean z4;
        Button button = this.f981o;
        boolean z5 = false;
        if (button != null) {
            if (!linkedHashSet.isEmpty()) {
                Iterator it = linkedHashSet.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((Boolean) it.next()).booleanValue()) {
                            z4 = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            z4 = false;
            button.setEnabled(z4);
        }
        Button button2 = this.f980n;
        if (button2 != null) {
            if (!linkedHashSet.isEmpty()) {
                Iterator it2 = linkedHashSet.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (!((Boolean) it2.next()).booleanValue()) {
                            z5 = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            button2.setEnabled(z5);
        }
    }

    public final ColorStateList m() {
        Integer num;
        d dVar = this.f26058j;
        if (dVar == null || (num = dVar.f25328m) == null || dVar.f25329n == null) {
            return null;
        }
        return new ColorStateList(new int[][]{new int[]{16842910}, new int[]{-16842910}}, new int[]{num.intValue(), dVar.f25329n.intValue()});
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ViewModelStore viewModelStore = getViewModelStore();
            t.d(viewModelStore, "viewModelStore");
            this.f983q = (k) new ViewModelProvider(viewModelStore, (ViewModelProvider.Factory) new l()).get(k.class);
            ViewModelStore viewModelStore2 = activity.getViewModelStore();
            t.d(viewModelStore2, "it.viewModelStore");
            this.f984r = (k) new ViewModelProvider(viewModelStore2, (ViewModelProvider.Factory) new l()).get(k.class);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        t.e(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(E1.c.dialog_leg_interest, viewGroup, false);
        t.d(inflate, "inflater.inflate(R.layou…terest, container, false)");
        return inflate;
    }

    public final void onPause() {
        boolean z4;
        super.onPause();
        k kVar = this.f983q;
        if (kVar == null) {
            t.w("viewModel");
            kVar = null;
        }
        SearchView searchView = this.f26053e;
        if (searchView == null) {
            z4 = false;
        } else {
            z4 = searchView.hasFocus();
        }
        kVar.f998k = z4;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        SearchView searchView;
        Integer num5;
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        super.onViewCreated(view, bundle);
        this.f979m = (ConstraintLayout) view.findViewById(E1.b.leg_interest_container);
        this.f980n = (Button) view.findViewById(E1.b.btn_remove_objections);
        this.f981o = (Button) view.findViewById(E1.b.btn_object_to_all);
        this.f982p = (RecyclerView) view.findViewById(E1.b.rv_vendors_leg_interest_list);
        k kVar = this.f983q;
        k kVar2 = null;
        if (kVar == null) {
            t.w("viewModel");
            kVar = null;
        }
        kVar.getClass();
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(kVar), C2865c0.b(), (O) null, new j(kVar, (C2308e) null), 2, (Object) null);
        TextView textView = this.f26050b;
        if (textView != null) {
            k kVar3 = this.f983q;
            if (kVar3 == null) {
                t.w("viewModel");
                kVar3 = null;
            }
            textView.setText(kVar3.e().f25405a);
        }
        ImageView imageView = this.f26051c;
        if (imageView != null) {
            imageView.setOnClickListener(new b(this));
            k kVar4 = this.f983q;
            if (kVar4 == null) {
                t.w("viewModel");
                kVar4 = null;
            }
            imageView.setContentDescription(kVar4.e().f25415k);
        }
        u();
        SearchView searchView2 = this.f26053e;
        if (searchView2 != null) {
            searchView2.setVisibility(0);
        }
        SearchView searchView3 = this.f26053e;
        if (searchView3 != null) {
            k kVar5 = this.f983q;
            if (kVar5 == null) {
                t.w("viewModel");
                kVar5 = null;
            }
            searchView3.setQueryHint(kVar5.e().f25410f);
        }
        SearchView searchView4 = this.f26053e;
        if (searchView4 != null) {
            searchView4.setOnQueryTextListener(new a(this));
        }
        k kVar6 = this.f983q;
        if (kVar6 == null) {
            t.w("viewModel");
            kVar6 = null;
        }
        List c5 = kVar6.c("");
        k kVar7 = this.f983q;
        if (kVar7 == null) {
            t.w("viewModel");
            kVar7 = null;
        }
        String str = kVar7.e().f25406b;
        k kVar8 = this.f983q;
        if (kVar8 == null) {
            t.w("viewModel");
            kVar8 = null;
        }
        String str2 = kVar8.e().f25407c;
        d dVar = this.f26058j;
        if (dVar == null) {
            num = null;
        } else {
            num = dVar.f25324i;
        }
        if (dVar == null) {
            num2 = null;
        } else {
            num2 = dVar.f25320e;
        }
        if (dVar == null) {
            num3 = null;
        } else {
            num3 = dVar.f25321f;
        }
        if (dVar == null) {
            num4 = null;
        } else {
            num4 = dVar.f25316a;
        }
        this.f985s = new h(c5, (c.b) this, str, str2, num, num2, num3, num4, this.f26059k, this.f26060l);
        RecyclerView recyclerView = this.f982p;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            h hVar = this.f985s;
            if (hVar == null) {
                t.w("switchAdapter");
                hVar = null;
            }
            recyclerView.setAdapter(hVar);
        }
        t();
        d dVar2 = this.f26058j;
        if (!(dVar2 == null || (num5 = dVar2.f25322g) == null)) {
            int intValue = num5.intValue();
            ConstraintLayout constraintLayout = this.f979m;
            if (constraintLayout != null) {
                constraintLayout.setBackgroundColor(intValue);
            }
        }
        Button button = this.f981o;
        if (button != null) {
            ColorStateList m5 = m();
            if (m5 != null) {
                button.setTextColor(m5);
            }
            ColorStateList h5 = h();
            if (h5 != null) {
                button.setBackgroundTintList(h5);
            }
        }
        Button button2 = this.f980n;
        if (button2 != null) {
            ColorStateList m6 = m();
            if (m6 != null) {
                button2.setTextColor(m6);
            }
            ColorStateList h6 = h();
            if (h6 != null) {
                button2.setBackgroundTintList(h6);
            }
        }
        Typeface typeface = this.f26060l;
        if (typeface != null) {
            Button button3 = this.f981o;
            if (button3 != null) {
                button3.setTypeface(typeface);
            }
            Button button4 = this.f980n;
            if (button4 != null) {
                button4.setTypeface(typeface);
            }
        }
        k kVar9 = this.f983q;
        if (kVar9 == null) {
            t.w("viewModel");
        } else {
            kVar2 = kVar9;
        }
        if (kVar2.f998k && (searchView = this.f26053e) != null) {
            searchView.requestFocus();
        }
    }

    public final void p() {
        h hVar = this.f985s;
        k kVar = null;
        if (hVar == null) {
            t.w("switchAdapter");
            hVar = null;
        }
        k kVar2 = this.f983q;
        if (kVar2 == null) {
            t.w("viewModel");
            kVar2 = null;
        }
        List c5 = kVar2.c("");
        hVar.getClass();
        t.e(c5, "switchItems");
        hVar.f884a = c5;
        hVar.a();
        hVar.notifyDataSetChanged();
        SearchView searchView = this.f26053e;
        if (searchView != null) {
            searchView.setQuery("", false);
        }
        k kVar3 = this.f983q;
        if (kVar3 == null) {
            t.w("viewModel");
        } else {
            kVar = kVar3;
        }
        j(kVar.b());
    }

    public final void s() {
        CharSequence query;
        boolean z4;
        SearchView searchView = this.f26053e;
        if (searchView != null && (query = searchView.getQuery()) != null) {
            h hVar = this.f985s;
            k kVar = null;
            if (hVar == null) {
                t.w("switchAdapter");
                hVar = null;
            }
            k kVar2 = this.f983q;
            if (kVar2 == null) {
                t.w("viewModel");
            } else {
                kVar = kVar2;
            }
            List c5 = kVar.c(query.toString());
            if (query.length() > 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            hVar.getClass();
            t.e(c5, "switchItems");
            hVar.f884a = c5;
            if (!z4) {
                hVar.a();
            }
            hVar.notifyDataSetChanged();
        }
    }

    public final void t() {
        Button button = this.f981o;
        k kVar = null;
        if (button != null) {
            k kVar2 = this.f983q;
            if (kVar2 == null) {
                t.w("viewModel");
                kVar2 = null;
            }
            button.setText(kVar2.e().f25409e);
        }
        k kVar3 = this.f983q;
        if (kVar3 == null) {
            t.w("viewModel");
            kVar3 = null;
        }
        j(kVar3.b());
        Button button2 = this.f981o;
        if (button2 != null) {
            button2.setOnClickListener(new g(this));
        }
        Button button3 = this.f980n;
        if (button3 != null) {
            k kVar4 = this.f983q;
            if (kVar4 == null) {
                t.w("viewModel");
            } else {
                kVar = kVar4;
            }
            button3.setText(kVar.e().f25408d);
        }
        Button button4 = this.f980n;
        if (button4 != null) {
            button4.setOnClickListener(new h(this));
        }
    }

    public final void u() {
        ImageView imageView;
        k kVar = this.f983q;
        if (kVar == null) {
            t.w("viewModel");
            kVar = null;
        }
        if (!kVar.f990c.f19277a.isEmpty()) {
            Toolbar toolbar = this.f26049a;
            if (toolbar == null) {
                imageView = null;
            } else {
                imageView = (ImageView) toolbar.findViewById(E1.b.toolbar_menu);
            }
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            View inflate = LayoutInflater.from(getContext()).inflate(E1.c.list_leg_interest_menu, (ViewGroup) null);
            CardView cardView = (CardView) inflate.findViewById(E1.b.cv_menu_item);
            TextView textView = (TextView) inflate.findViewById(E1.b.tv_menu_all);
            TextView textView2 = (TextView) inflate.findViewById(E1.b.tv_menu_iab);
            TextView textView3 = (TextView) inflate.findViewById(E1.b.tv_menu_non_iab);
            PopupWindow popupWindow = new PopupWindow(inflate, 600, -2, true);
            popupWindow.setElevation(10.0f);
            textView.setOnClickListener(new c(popupWindow, this));
            textView2.setOnClickListener(new d(popupWindow, this));
            textView3.setOnClickListener(new e(popupWindow, this));
            if (imageView != null) {
                imageView.setOnClickListener(new f(this, popupWindow, imageView, cardView, textView, textView2, textView3));
            }
        }
    }
}
