package com.uptodown.activities;

import O1.A3;
import O1.C0917w3;
import O1.C0925x3;
import O1.C0933y3;
import O1.C0941z3;
import R1.C0985p;
import S1.k;
import W2.C2219h;
import W2.C2223l;
import W2.J;
import W2.m;
import W2.q;
import W2.u;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.C1622z;
import g2.C2388j;
import h2.C2428n0;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import k2.C2610u;
import k2.C2614y;
import k3.C2616a;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import l2.C2642B;
import l2.C2657f;
import t3.s;
import w3.C2865c0;
import w3.C2908y0;
import w3.N;
import z2.O;
import z3.C2973f;
import z3.D;

public final class NotificationsRegistryActivity extends C1598a {

    /* renamed from: K  reason: collision with root package name */
    private final C2223l f14222K = m.b(new C0941z3(this));

    /* renamed from: L  reason: collision with root package name */
    private final C2223l f14223L = new ViewModelLazy(M.b(C1622z.class), new f(this), new e(this), new g((C2616a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public boolean f14224M;
    /* access modifiers changed from: private */

    /* renamed from: N  reason: collision with root package name */
    public boolean f14225N = true;
    /* access modifiers changed from: private */

    /* renamed from: O  reason: collision with root package name */
    public C0985p f14226O;

    /* renamed from: P  reason: collision with root package name */
    private c f14227P = new c(this);

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14228a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ NotificationsRegistryActivity f14229b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f14230c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(NotificationsRegistryActivity notificationsRegistryActivity, int i5, C2308e eVar) {
            super(2, eVar);
            this.f14229b = notificationsRegistryActivity;
            this.f14230c = i5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f14229b, this.f14230c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14228a;
            if (i5 == 0) {
                u.b(obj);
                NotificationsRegistryActivity notificationsRegistryActivity = this.f14229b;
                int i6 = this.f14230c;
                this.f14228a = 1;
                if (notificationsRegistryActivity.H3(i6, this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return J.f19942a;
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class b implements C2610u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ NotificationsRegistryActivity f14231a;

        b(NotificationsRegistryActivity notificationsRegistryActivity) {
            this.f14231a = notificationsRegistryActivity;
        }

        public void c(C2657f fVar) {
            t.e(fVar, "appInfo");
            Intent intent = new Intent(this.f14231a, AppDetailActivity.class);
            intent.putExtra("appInfo", fVar);
            NotificationsRegistryActivity notificationsRegistryActivity = this.f14231a;
            notificationsRegistryActivity.startActivity(intent, UptodownApp.f13477F.a(notificationsRegistryActivity));
        }

        public void d(int i5) {
            NotificationsRegistryActivity notificationsRegistryActivity = this.f14231a;
            String string = notificationsRegistryActivity.getString(R.string.app_detail_not_found);
            t.d(string, "getString(...)");
            notificationsRegistryActivity.u0(string);
        }
    }

    public static final class c implements C2614y {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ NotificationsRegistryActivity f14232a;

        c(NotificationsRegistryActivity notificationsRegistryActivity) {
            this.f14232a = notificationsRegistryActivity;
        }

        public void a(int i5) {
            this.f14232a.F3(i5, 1);
        }

        public void b(int i5) {
            this.f14232a.u3(i5);
        }

        public void c(int i5) {
            this.f14232a.F3(i5, 0);
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14233a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ NotificationsRegistryActivity f14234b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ NotificationsRegistryActivity f14235a;

            a(NotificationsRegistryActivity notificationsRegistryActivity) {
                this.f14235a = notificationsRegistryActivity;
            }

            /* renamed from: b */
            public final Object emit(O o5, C2308e eVar) {
                if (o5 instanceof O.a) {
                    this.f14235a.y3().f23387b.setVisibility(0);
                } else if (o5 instanceof O.c) {
                    this.f14235a.G3(((C1622z.a) ((O.c) o5).a()).a());
                    this.f14235a.f14225N = false;
                    this.f14235a.f14224M = false;
                    this.f14235a.y3().f23387b.setVisibility(8);
                } else if (!(o5 instanceof O.b)) {
                    throw new q();
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(NotificationsRegistryActivity notificationsRegistryActivity, C2308e eVar) {
            super(2, eVar);
            this.f14234b = notificationsRegistryActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f14234b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14233a;
            if (i5 == 0) {
                u.b(obj);
                D e5 = this.f14234b.A3().e();
                a aVar = new a(this.f14234b);
                this.f14233a = 1;
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
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class e extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14236a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(ComponentActivity componentActivity) {
            super(0);
            this.f14236a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f14236a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class f extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14237a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(ComponentActivity componentActivity) {
            super(0);
            this.f14237a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f14237a.getViewModelStore();
        }
    }

    public static final class g extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2616a f14238a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14239b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(C2616a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f14238a = aVar;
            this.f14239b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                k3.a r0 = r1.f14238a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f14239b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.NotificationsRegistryActivity.g.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    static final class h extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f14240a;

        /* renamed from: b  reason: collision with root package name */
        int f14241b;

        /* renamed from: c  reason: collision with root package name */
        /* synthetic */ Object f14242c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ NotificationsRegistryActivity f14243d;

        /* renamed from: e  reason: collision with root package name */
        int f14244e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(NotificationsRegistryActivity notificationsRegistryActivity, C2308e eVar) {
            super(eVar);
            this.f14243d = notificationsRegistryActivity;
        }

        public final Object invokeSuspend(Object obj) {
            this.f14242c = obj;
            this.f14244e |= Integer.MIN_VALUE;
            return this.f14243d.H3(0, this);
        }
    }

    static final class i extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14245a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ NotificationsRegistryActivity f14246b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f14247c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(NotificationsRegistryActivity notificationsRegistryActivity, int i5, C2308e eVar) {
            super(2, eVar);
            this.f14246b = notificationsRegistryActivity;
            this.f14247c = i5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new i(this.f14246b, this.f14247c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f14245a == 0) {
                u.b(obj);
                String format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault()).format(kotlin.coroutines.jvm.internal.b.c(System.currentTimeMillis()));
                t.d(format, "format(...)");
                C1622z n32 = this.f14246b.A3();
                NotificationsRegistryActivity notificationsRegistryActivity = this.f14246b;
                C0985p l32 = notificationsRegistryActivity.f14226O;
                t.b(l32);
                Object obj2 = l32.a().get(this.f14247c);
                t.d(obj2, "get(...)");
                n32.f(notificationsRegistryActivity, (C2642B) obj2, format);
                C0985p l33 = this.f14246b.f14226O;
                t.b(l33);
                ((C2642B) l33.a().get(this.f14247c)).k(this.f14246b.getString(R.string.file_deleted_notification, new Object[]{format}));
                C0985p l34 = this.f14246b.f14226O;
                t.b(l34);
                ((C2642B) l34.a().get(this.f14247c)).i("no_action");
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((i) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class j extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14248a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ NotificationsRegistryActivity f14249b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f14250c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(NotificationsRegistryActivity notificationsRegistryActivity, int i5, C2308e eVar) {
            super(2, eVar);
            this.f14249b = notificationsRegistryActivity;
            this.f14250c = i5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new j(this.f14249b, this.f14250c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f14248a == 0) {
                u.b(obj);
                C0985p l32 = this.f14249b.f14226O;
                t.b(l32);
                l32.notifyItemChanged(this.f14250c);
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((j) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* access modifiers changed from: private */
    public final C1622z A3() {
        return (C1622z) this.f14223L.getValue();
    }

    private final void B3() {
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            y3().f23389d.setNavigationIcon(drawable);
            y3().f23389d.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        y3().f23389d.setNavigationOnClickListener(new C0917w3(this));
        y3().f23389d.inflateMenu(R.menu.menu_notifications_registry);
        y3().f23389d.setOverflowIcon(ContextCompat.getDrawable(this, R.drawable.vector_menu_dots_color_adaptable));
        y3().f23389d.setOnMenuItemClickListener(new C0925x3(this));
        TextView textView = y3().f23391f;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        y3().f23390e.setTypeface(aVar.x());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        y3().f23388c.addItemDecoration(new B2.l(dimension, dimension));
        y3().f23388c.setLayoutManager(linearLayoutManager);
        y3().f23388c.setItemAnimator(new DefaultItemAnimator());
        y3().f23387b.setOnClickListener(new C0933y3());
    }

    /* access modifiers changed from: private */
    public static final void C3(NotificationsRegistryActivity notificationsRegistryActivity, View view) {
        notificationsRegistryActivity.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: private */
    public static final boolean D3(NotificationsRegistryActivity notificationsRegistryActivity, MenuItem menuItem) {
        t.e(menuItem, "item");
        if (menuItem.getItemId() != R.id.action_delete_all) {
            return true;
        }
        notificationsRegistryActivity.A3().b(notificationsRegistryActivity);
        return true;
    }

    /* access modifiers changed from: private */
    public static final void E3(View view) {
    }

    /* access modifiers changed from: private */
    public final void F3(int i5, int i6) {
        C0985p pVar = this.f14226O;
        if (pVar != null) {
            t.b(pVar);
            if (pVar.getItemCount() > i5) {
                C0985p pVar2 = this.f14226O;
                t.b(pVar2);
                Object obj = pVar2.a().get(i5);
                t.d(obj, "get(...)");
                C2642B b5 = (C2642B) obj;
                if (b5.a() != null) {
                    String a5 = b5.a();
                    t.b(a5);
                    List G02 = s.G0(a5, new String[]{";"}, false, 0, 6, (Object) null);
                    if (G02.size() > i6) {
                        x3((String) G02.get(i6), b5.b(), i5);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void G3(ArrayList arrayList) {
        if (!arrayList.isEmpty()) {
            C0985p pVar = this.f14226O;
            if (pVar == null) {
                this.f14226O = new C0985p(arrayList, this, this.f14227P);
                y3().f23388c.setAdapter(this.f14226O);
            } else {
                if (pVar != null) {
                    pVar.d(arrayList);
                }
                C0985p pVar2 = this.f14226O;
                if (pVar2 != null) {
                    pVar2.notifyDataSetChanged();
                }
            }
            y3().f23390e.setVisibility(8);
            return;
        }
        C0985p pVar3 = this.f14226O;
        if (pVar3 != null) {
            pVar3.d(new ArrayList());
        }
        C0985p pVar4 = this.f14226O;
        if (pVar4 != null) {
            pVar4.notifyDataSetChanged();
        }
        y3().f23390e.setVisibility(0);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006a, code lost:
        if (w3.C2872g.g(r8, r4, r0) != r1) goto L_0x006d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object H3(int r7, b3.C2308e r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.uptodown.activities.NotificationsRegistryActivity.h
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.uptodown.activities.NotificationsRegistryActivity$h r0 = (com.uptodown.activities.NotificationsRegistryActivity.h) r0
            int r1 = r0.f14244e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f14244e = r1
            goto L_0x0018
        L_0x0013:
            com.uptodown.activities.NotificationsRegistryActivity$h r0 = new com.uptodown.activities.NotificationsRegistryActivity$h
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f14242c
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f14244e
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x003f
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            W2.u.b(r8)
            goto L_0x006d
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            int r7 = r0.f14241b
            java.lang.Object r2 = r0.f14240a
            com.uptodown.activities.NotificationsRegistryActivity r2 = (com.uptodown.activities.NotificationsRegistryActivity) r2
            W2.u.b(r8)
            goto L_0x0059
        L_0x003f:
            W2.u.b(r8)
            w3.I r8 = w3.C2865c0.b()
            com.uptodown.activities.NotificationsRegistryActivity$i r2 = new com.uptodown.activities.NotificationsRegistryActivity$i
            r2.<init>(r6, r7, r5)
            r0.f14240a = r6
            r0.f14241b = r7
            r0.f14244e = r4
            java.lang.Object r8 = w3.C2872g.g(r8, r2, r0)
            if (r8 != r1) goto L_0x0058
            goto L_0x006c
        L_0x0058:
            r2 = r6
        L_0x0059:
            w3.I0 r8 = w3.C2865c0.c()
            com.uptodown.activities.NotificationsRegistryActivity$j r4 = new com.uptodown.activities.NotificationsRegistryActivity$j
            r4.<init>(r2, r7, r5)
            r0.f14240a = r5
            r0.f14244e = r3
            java.lang.Object r7 = w3.C2872g.g(r8, r4, r0)
            if (r7 != r1) goto L_0x006d
        L_0x006c:
            return r1
        L_0x006d:
            W2.J r7 = W2.J.f19942a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.NotificationsRegistryActivity.H3(int, b3.e):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final C2428n0 t3(NotificationsRegistryActivity notificationsRegistryActivity) {
        return C2428n0.c(notificationsRegistryActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final void u3(int i5) {
        C0985p pVar = this.f14226O;
        if (pVar != null) {
            t.b(pVar);
            if (pVar.getItemCount() > i5) {
                C1622z A32 = A3();
                C0985p pVar2 = this.f14226O;
                t.b(pVar2);
                A32.c(this, ((C2642B) pVar2.a().get(i5)).c());
                C0985p pVar3 = this.f14226O;
                t.b(pVar3);
                pVar3.a().remove(i5);
                C0985p pVar4 = this.f14226O;
                t.b(pVar4);
                pVar4.notifyItemRemoved(i5);
            }
        }
    }

    private final void v3(File file, int i5) {
        String string = getString(R.string.dialog_delete_download_msg, new Object[]{file.getName()});
        t.d(string, "getString(...)");
        U1(string, new A3(file, this, i5));
    }

    /* access modifiers changed from: private */
    public static final J w3(File file, NotificationsRegistryActivity notificationsRegistryActivity, int i5) {
        if (file.delete()) {
            String string = notificationsRegistryActivity.getString(R.string.snackbar_message_apk_deleted, new Object[]{file.getName()});
            t.d(string, "getString(...)");
            notificationsRegistryActivity.u0(string);
            C2908y0 unused = C2876i.d(N.a(C2865c0.b()), (C2312i) null, (w3.O) null, new a(notificationsRegistryActivity, i5, (C2308e) null), 3, (Object) null);
        }
        return J.f19942a;
    }

    private final void x3(String str, String str2, int i5) {
        switch (str.hashCode()) {
            case -1569440520:
                if (str.equals("positive_apps")) {
                    startActivity(new Intent(this, SecurityActivity.class), UptodownApp.f13477F.a(this));
                    J j5 = J.f19942a;
                    return;
                }
                break;
            case -1335458389:
                if (str.equals("delete")) {
                    if (str2 != null) {
                        v3(new File(str2), i5);
                    } else {
                        String string = getString(R.string.msg_no_action_available);
                        t.d(string, "getString(...)");
                        u0(string);
                    }
                    J j6 = J.f19942a;
                    return;
                }
                break;
            case -504325460:
                if (str.equals("open_app")) {
                    if (str2 != null) {
                        try {
                            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(str2);
                            if (launchIntentForPackage != null) {
                                startActivity(launchIntentForPackage);
                            } else {
                                String string2 = getString(R.string.app_detail_not_found);
                                t.d(string2, "getString(...)");
                                u0(string2);
                            }
                        } catch (Exception e5) {
                            e5.printStackTrace();
                            String string3 = getString(R.string.app_detail_not_found);
                            t.d(string3, "getString(...)");
                            u0(string3);
                        }
                    } else {
                        String string4 = getString(R.string.msg_no_action_available);
                        t.d(string4, "getString(...)");
                        u0(string4);
                    }
                    J j7 = J.f19942a;
                    return;
                }
                break;
            case -234430262:
                if (str.equals("updates")) {
                    startActivity(new Intent(this, Updates.class), UptodownApp.f13477F.a(this));
                    J j8 = J.f19942a;
                    return;
                }
                break;
            case 1085191854:
                if (str.equals("update_uptodown")) {
                    if (str2 != null) {
                        File file = new File(str2);
                        if (file.exists()) {
                            UptodownApp.a.X(UptodownApp.f13477F, file, this, (String) null, 4, (Object) null);
                        } else {
                            String string5 = getString(R.string.installable_files_not_found);
                            t.d(string5, "getString(...)");
                            u0(string5);
                        }
                    } else {
                        String string6 = getString(R.string.msg_no_action_available);
                        t.d(string6, "getString(...)");
                        u0(string6);
                    }
                    J j9 = J.f19942a;
                    return;
                }
                break;
            case 1117687366:
                if (str.equals("preregister")) {
                    if (str2 != null) {
                        new C2388j(this, Long.parseLong(str2), new b(this), LifecycleOwnerKt.getLifecycleScope(this));
                        return;
                    }
                    String string7 = getString(R.string.msg_no_action_available);
                    t.d(string7, "getString(...)");
                    u0(string7);
                    J j10 = J.f19942a;
                    return;
                }
                break;
            case 1312704747:
                if (str.equals("downloads")) {
                    startActivity(new Intent(this, MyDownloads.class), UptodownApp.f13477F.a(this));
                    J j11 = J.f19942a;
                    return;
                }
                break;
            case 1957569947:
                if (str.equals("install")) {
                    if (str2 != null) {
                        File file2 = new File(str2);
                        if (file2.exists()) {
                            UptodownApp.a.X(UptodownApp.f13477F, file2, this, (String) null, 4, (Object) null);
                        } else {
                            String string8 = getString(R.string.installable_files_not_found);
                            t.d(string8, "getString(...)");
                            u0(string8);
                        }
                    } else {
                        String string9 = getString(R.string.msg_no_action_available);
                        t.d(string9, "getString(...)");
                        u0(string9);
                    }
                    J j12 = J.f19942a;
                    return;
                }
                break;
        }
        String string10 = getString(R.string.msg_no_action_available);
        t.d(string10, "getString(...)");
        u0(string10);
        J j13 = J.f19942a;
    }

    /* access modifiers changed from: private */
    public final C2428n0 y3() {
        return (C2428n0) this.f14222K.getValue();
    }

    private final void z3() {
        A3().d(this);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) y3().getRoot());
        B3();
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new d(this, (C2308e) null), 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f14225N) {
            z3();
        }
    }
}
