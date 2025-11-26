package com.uptodown.activities;

import O1.W;
import O1.X;
import O1.Y;
import R1.C0974e;
import S1.j;
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
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.SimpleItemAnimator;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.C1605h;
import g2.C2379a;
import h2.Q;
import java.util.ArrayList;
import k2.C2592b;
import k2.C2597g;
import k3.C2616a;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import l2.C2655d;
import l2.C2657f;
import t3.s;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import z2.O;
import z3.C2973f;
import z3.D;

public final class FreeUpSpaceActivity extends C1598a {

    /* renamed from: K  reason: collision with root package name */
    private final C2223l f13728K = m.b(new W(this));

    /* renamed from: L  reason: collision with root package name */
    private final C2223l f13729L = new ViewModelLazy(M.b(C1605h.class), new e(this), new d(this), new f((C2616a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public C0974e f13730M;

    /* renamed from: N  reason: collision with root package name */
    private C2657f f13731N;

    /* renamed from: O  reason: collision with root package name */
    private final a f13732O = new a(this);

    public static final class a implements C2592b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FreeUpSpaceActivity f13733a;

        a(FreeUpSpaceActivity freeUpSpaceActivity) {
            this.f13733a = freeUpSpaceActivity;
        }

        public void a(int i5) {
            C0974e i32;
            ArrayList a5;
            C2655d dVar;
            String o5;
            if (UptodownApp.f13477F.Z() && (i32 = this.f13733a.f13730M) != null && (a5 = i32.a()) != null && (dVar = (C2655d) a5.get(i5)) != null && (o5 = dVar.o()) != null) {
                new j(this.f13733a).h(o5);
            }
        }

        public void b(int i5) {
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13734a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FreeUpSpaceActivity f13735b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f13736c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f13737d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FreeUpSpaceActivity freeUpSpaceActivity, String str, String str2, C2308e eVar) {
            super(2, eVar);
            this.f13735b = freeUpSpaceActivity;
            this.f13736c = str;
            this.f13737d = str2;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f13735b, this.f13736c, this.f13737d, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0056, code lost:
            if (r0.equals("app_updated") != false) goto L_0x0062;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x005f, code lost:
            if (r0.equals("app_installed") == false) goto L_0x0068;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r4) {
            /*
                r3 = this;
                c3.C2316b.f()
                int r0 = r3.f13734a
                if (r0 != 0) goto L_0x0070
                W2.u.b(r4)
                com.uptodown.activities.FreeUpSpaceActivity r4 = r3.f13735b
                java.lang.String r0 = r3.f13736c
                int r4 = r4.s3(r0)
                if (r4 < 0) goto L_0x0068
                java.lang.String r0 = r3.f13737d
                int r1 = r0.hashCode()
                r2 = -1972881700(0xffffffff8a6836dc, float:-1.11807116E-32)
                if (r1 == r2) goto L_0x0059
                r2 = -1487908707(0xffffffffa750509d, float:-2.89095E-15)
                if (r1 == r2) goto L_0x0050
                r2 = 389690339(0x173a33e3, float:6.016533E-25)
                if (r1 == r2) goto L_0x002a
                goto L_0x0068
            L_0x002a:
                java.lang.String r1 = "app_uninstalled"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto L_0x0033
                goto L_0x0068
            L_0x0033:
                com.uptodown.activities.FreeUpSpaceActivity r0 = r3.f13735b
                R1.e r0 = r0.f13730M
                kotlin.jvm.internal.t.b(r0)
                java.util.ArrayList r0 = r0.a()
                r0.remove(r4)
                com.uptodown.activities.FreeUpSpaceActivity r0 = r3.f13735b
                R1.e r0 = r0.f13730M
                kotlin.jvm.internal.t.b(r0)
                r0.notifyItemRemoved(r4)
                goto L_0x0068
            L_0x0050:
                java.lang.String r4 = "app_updated"
                boolean r4 = r0.equals(r4)
                if (r4 == 0) goto L_0x0068
                goto L_0x0062
            L_0x0059:
                java.lang.String r4 = "app_installed"
                boolean r4 = r0.equals(r4)
                if (r4 != 0) goto L_0x0062
                goto L_0x0068
            L_0x0062:
                com.uptodown.activities.FreeUpSpaceActivity r4 = r3.f13735b
                r0 = 0
                r4.z3(r0)
            L_0x0068:
                com.uptodown.activities.FreeUpSpaceActivity r4 = r3.f13735b
                r4.A3()
                W2.J r4 = W2.J.f19942a
                return r4
            L_0x0070:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r0)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.FreeUpSpaceActivity.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13738a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FreeUpSpaceActivity f13739b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ FreeUpSpaceActivity f13740a;

            /* renamed from: com.uptodown.activities.FreeUpSpaceActivity$c$a$a  reason: collision with other inner class name */
            static final class C0122a extends l implements p {

                /* renamed from: a  reason: collision with root package name */
                int f13741a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ FreeUpSpaceActivity f13742b;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C0122a(FreeUpSpaceActivity freeUpSpaceActivity, C2308e eVar) {
                    super(2, eVar);
                    this.f13742b = freeUpSpaceActivity;
                }

                public final C2308e create(Object obj, C2308e eVar) {
                    return new C0122a(this.f13742b, eVar);
                }

                public final Object invokeSuspend(Object obj) {
                    C2316b.f();
                    if (this.f13741a == 0) {
                        u.b(obj);
                        this.f13742b.t3().f22608c.setVisibility(0);
                        return J.f19942a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                public final Object invoke(w3.M m5, C2308e eVar) {
                    return ((C0122a) create(m5, eVar)).invokeSuspend(J.f19942a);
                }
            }

            static final class b extends l implements p {

                /* renamed from: a  reason: collision with root package name */
                int f13743a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ FreeUpSpaceActivity f13744b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ O f13745c;

                /* renamed from: com.uptodown.activities.FreeUpSpaceActivity$c$a$b$a  reason: collision with other inner class name */
                public static final class C0123a implements C2597g {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ FreeUpSpaceActivity f13746a;

                    /* renamed from: com.uptodown.activities.FreeUpSpaceActivity$c$a$b$a$a  reason: collision with other inner class name */
                    static final class C0124a extends l implements p {

                        /* renamed from: a  reason: collision with root package name */
                        int f13747a;

                        /* renamed from: b  reason: collision with root package name */
                        final /* synthetic */ FreeUpSpaceActivity f13748b;

                        /* renamed from: c  reason: collision with root package name */
                        final /* synthetic */ String f13749c;

                        /* renamed from: d  reason: collision with root package name */
                        final /* synthetic */ long f13750d;

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        C0124a(FreeUpSpaceActivity freeUpSpaceActivity, String str, long j5, C2308e eVar) {
                            super(2, eVar);
                            this.f13748b = freeUpSpaceActivity;
                            this.f13749c = str;
                            this.f13750d = j5;
                        }

                        public final C2308e create(Object obj, C2308e eVar) {
                            return new C0124a(this.f13748b, this.f13749c, this.f13750d, eVar);
                        }

                        public final Object invokeSuspend(Object obj) {
                            ArrayList arrayList;
                            C2316b.f();
                            if (this.f13747a == 0) {
                                u.b(obj);
                                int l32 = this.f13748b.u3(this.f13749c);
                                if (l32 >= 0) {
                                    C0974e i32 = this.f13748b.f13730M;
                                    if (i32 != null) {
                                        arrayList = i32.a();
                                    } else {
                                        arrayList = null;
                                    }
                                    t.b(arrayList);
                                    ((C2655d) arrayList.get(l32)).b0(this.f13750d);
                                    C0974e i33 = this.f13748b.f13730M;
                                    if (i33 != null) {
                                        i33.notifyItemChanged(this.f13748b.u3(this.f13749c));
                                    }
                                }
                                return J.f19942a;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }

                        public final Object invoke(w3.M m5, C2308e eVar) {
                            return ((C0124a) create(m5, eVar)).invokeSuspend(J.f19942a);
                        }
                    }

                    C0123a(FreeUpSpaceActivity freeUpSpaceActivity) {
                        this.f13746a = freeUpSpaceActivity;
                    }

                    public void a(String str, long j5) {
                        t.e(str, "packageName");
                        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this.f13746a), C2865c0.c(), (w3.O) null, new C0124a(this.f13746a, str, j5, (C2308e) null), 2, (Object) null);
                    }
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                b(FreeUpSpaceActivity freeUpSpaceActivity, O o5, C2308e eVar) {
                    super(2, eVar);
                    this.f13744b = freeUpSpaceActivity;
                    this.f13745c = o5;
                }

                public final C2308e create(Object obj, C2308e eVar) {
                    return new b(this.f13744b, this.f13745c, eVar);
                }

                public final Object invokeSuspend(Object obj) {
                    C2316b.f();
                    if (this.f13743a == 0) {
                        u.b(obj);
                        this.f13744b.t3().f22608c.setVisibility(8);
                        this.f13744b.B3(((C1605h.a) ((O.c) this.f13745c).a()).a());
                        if (!((Boolean) this.f13744b.v3().c().getValue()).booleanValue()) {
                            new C2379a(new C0123a(this.f13744b), LifecycleOwnerKt.getLifecycleScope(this.f13744b), this.f13744b);
                            this.f13744b.v3().c().setValue(kotlin.coroutines.jvm.internal.b.a(true));
                        }
                        return J.f19942a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                public final Object invoke(w3.M m5, C2308e eVar) {
                    return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
                }
            }

            a(FreeUpSpaceActivity freeUpSpaceActivity) {
                this.f13740a = freeUpSpaceActivity;
            }

            /* renamed from: b */
            public final Object emit(O o5, C2308e eVar) {
                if (o5 instanceof O.a) {
                    Object g5 = C2872g.g(C2865c0.c(), new C0122a(this.f13740a, (C2308e) null), eVar);
                    if (g5 == C2316b.f()) {
                        return g5;
                    }
                    return J.f19942a;
                } else if (o5 instanceof O.c) {
                    Object g6 = C2872g.g(C2865c0.c(), new b(this.f13740a, o5, (C2308e) null), eVar);
                    if (g6 == C2316b.f()) {
                        return g6;
                    }
                    return J.f19942a;
                } else if (o5 instanceof O.b) {
                    return J.f19942a;
                } else {
                    throw new q();
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FreeUpSpaceActivity freeUpSpaceActivity, C2308e eVar) {
            super(2, eVar);
            this.f13739b = freeUpSpaceActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f13739b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f13738a;
            if (i5 == 0) {
                u.b(obj);
                D d5 = this.f13739b.v3().d();
                a aVar = new a(this.f13739b);
                this.f13738a = 1;
                if (d5.collect(aVar, this) == f5) {
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
            return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class d extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f13751a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(ComponentActivity componentActivity) {
            super(0);
            this.f13751a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f13751a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class e extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f13752a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(ComponentActivity componentActivity) {
            super(0);
            this.f13752a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f13752a.getViewModelStore();
        }
    }

    public static final class f extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2616a f13753a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f13754b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(C2616a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f13753a = aVar;
            this.f13754b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                k3.a r0 = r1.f13753a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f13754b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.FreeUpSpaceActivity.f.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x00ab  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void A3() {
        /*
            r17 = this;
            r0 = r17
            l2.f r1 = r0.f13731N
            if (r1 == 0) goto L_0x0021
            if (r1 == 0) goto L_0x000d
            java.lang.String r1 = r1.q0()
            goto L_0x000e
        L_0x000d:
            r1 = 0
        L_0x000e:
            if (r1 == 0) goto L_0x0021
            l2.f r1 = r0.f13731N     // Catch:{ Exception -> 0x0021 }
            kotlin.jvm.internal.t.b(r1)     // Catch:{ Exception -> 0x0021 }
            java.lang.String r1 = r1.q0()     // Catch:{ Exception -> 0x0021 }
            kotlin.jvm.internal.t.b(r1)     // Catch:{ Exception -> 0x0021 }
            long r1 = java.lang.Long.parseLong(r1)     // Catch:{ Exception -> 0x0021 }
            goto L_0x0023
        L_0x0021:
            r1 = 0
        L_0x0023:
            z2.E r3 = new z2.E
            r3.<init>()
            java.io.File r3 = r3.h(r0)
            z2.E r4 = new z2.E
            r4.<init>()
            long r4 = r4.m(r0, r3)
            long r6 = r3.getTotalSpace()
            double r1 = (double) r1
            r8 = 4612248968380809216(0x4002000000000000, double:2.25)
            double r1 = r1 * r8
            long r1 = (long) r1
            long r8 = r6 - r4
            r3 = 100
            long r10 = (long) r3
            long r10 = r10 * r8
            long r10 = r10 / r6
            r12 = 9
            long r12 = r12 * r6
            r14 = 10
            long r12 = r12 / r14
            long r12 = r6 - r12
            int r3 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            r14 = 0
            r15 = 8
            if (r3 <= 0) goto L_0x00ab
            b2.k r3 = new b2.k
            r3.<init>()
            long r1 = r1 - r4
            java.lang.String r1 = r3.d(r1, r0)
            h2.Q r2 = r0.t3()
            h2.v1 r2 = r2.f22607b
            android.widget.ProgressBar r2 = r2.f23639d
            int r3 = (int) r10
            r2.setProgress(r3)
            h2.Q r2 = r0.t3()
            h2.v1 r2 = r2.f22607b
            android.widget.ProgressBar r2 = r2.f23638c
            r2.setVisibility(r15)
            h2.Q r2 = r0.t3()
            h2.v1 r2 = r2.f22607b
            android.widget.ProgressBar r2 = r2.f23639d
            r2.setVisibility(r14)
            h2.Q r2 = r0.t3()
            h2.v1 r2 = r2.f22607b
            android.widget.TextView r2 = r2.f23642g
            r3 = 2131952030(0x7f13019e, float:1.9540491E38)
            java.lang.String r3 = r0.getString(r3)
            r2.setText(r3)
            h2.Q r2 = r0.t3()
            h2.v1 r2 = r2.f22607b
            android.widget.TextView r2 = r2.f23643h
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r14] = r1
            r1 = 2131952461(0x7f13034d, float:1.9541365E38)
            java.lang.String r1 = r0.getString(r1, r3)
            r2.setText(r1)
            goto L_0x016e
        L_0x00ab:
            int r1 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            r2 = 2
            r3 = 2131952016(0x7f130190, float:1.9540463E38)
            if (r1 >= 0) goto L_0x0111
            h2.Q r1 = r0.t3()
            h2.v1 r1 = r1.f22607b
            android.widget.ProgressBar r1 = r1.f23639d
            int r4 = (int) r10
            r1.setProgress(r4)
            h2.Q r1 = r0.t3()
            h2.v1 r1 = r1.f22607b
            android.widget.ProgressBar r1 = r1.f23638c
            r1.setVisibility(r15)
            h2.Q r1 = r0.t3()
            h2.v1 r1 = r1.f22607b
            android.widget.ProgressBar r1 = r1.f23639d
            r1.setVisibility(r14)
            h2.Q r1 = r0.t3()
            h2.v1 r1 = r1.f22607b
            android.widget.TextView r1 = r1.f23642g
            r4 = 2131952030(0x7f13019e, float:1.9540491E38)
            java.lang.String r4 = r0.getString(r4)
            r1.setText(r4)
            h2.Q r1 = r0.t3()
            h2.v1 r1 = r1.f22607b
            android.widget.TextView r1 = r1.f23643h
            b2.k r4 = new b2.k
            r4.<init>()
            java.lang.String r4 = r4.d(r8, r0)
            b2.k r5 = new b2.k
            r5.<init>()
            java.lang.String r5 = r5.d(r6, r0)
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r14] = r4
            r16 = 1
            r2[r16] = r5
            java.lang.String r2 = r0.getString(r3, r2)
            r1.setText(r2)
            goto L_0x016e
        L_0x0111:
            h2.Q r1 = r0.t3()
            h2.v1 r1 = r1.f22607b
            android.widget.ProgressBar r1 = r1.f23638c
            int r4 = (int) r10
            r1.setProgress(r4)
            h2.Q r1 = r0.t3()
            h2.v1 r1 = r1.f22607b
            android.widget.ProgressBar r1 = r1.f23639d
            r1.setVisibility(r15)
            h2.Q r1 = r0.t3()
            h2.v1 r1 = r1.f22607b
            android.widget.ProgressBar r1 = r1.f23638c
            r1.setVisibility(r14)
            h2.Q r1 = r0.t3()
            h2.v1 r1 = r1.f22607b
            android.widget.TextView r1 = r1.f23642g
            r4 = 2131952017(0x7f130191, float:1.9540465E38)
            java.lang.String r4 = r0.getString(r4)
            r1.setText(r4)
            h2.Q r1 = r0.t3()
            h2.v1 r1 = r1.f22607b
            android.widget.TextView r1 = r1.f23643h
            b2.k r4 = new b2.k
            r4.<init>()
            java.lang.String r4 = r4.d(r8, r0)
            b2.k r5 = new b2.k
            r5.<init>()
            java.lang.String r5 = r5.d(r6, r0)
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r14] = r4
            r16 = 1
            r2[r16] = r5
            java.lang.String r2 = r0.getString(r3, r2)
            r1.setText(r2)
        L_0x016e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.FreeUpSpaceActivity.A3():void");
    }

    /* access modifiers changed from: private */
    public final void B3(ArrayList arrayList) {
        C0974e eVar = this.f13730M;
        if (eVar == null) {
            this.f13730M = new C0974e(arrayList, this, this.f13732O);
            t3().f22609d.setAdapter(this.f13730M);
            return;
        }
        t.b(eVar);
        eVar.b(arrayList);
    }

    /* access modifiers changed from: private */
    public static final Q q3(FreeUpSpaceActivity freeUpSpaceActivity) {
        return Q.c(freeUpSpaceActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final int s3(String str) {
        ArrayList arrayList;
        C0974e eVar = this.f13730M;
        ArrayList<C2655d> arrayList2 = null;
        if (eVar != null) {
            arrayList = eVar.a();
        } else {
            arrayList = null;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return -1;
        }
        C0974e eVar2 = this.f13730M;
        if (eVar2 != null) {
            arrayList2 = eVar2.a();
        }
        t.b(arrayList2);
        int i5 = 0;
        for (C2655d o5 : arrayList2) {
            int i6 = i5 + 1;
            if (s.E(o5.o(), str, true)) {
                return i5;
            }
            i5 = i6;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public final Q t3() {
        return (Q) this.f13728K.getValue();
    }

    /* access modifiers changed from: private */
    public final int u3(String str) {
        ArrayList arrayList;
        C0974e eVar = this.f13730M;
        ArrayList<C2655d> arrayList2 = null;
        if (eVar != null) {
            arrayList = eVar.a();
        } else {
            arrayList = null;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return -1;
        }
        C0974e eVar2 = this.f13730M;
        if (eVar2 != null) {
            arrayList2 = eVar2.a();
        }
        t.b(arrayList2);
        int i5 = 0;
        for (C2655d o5 : arrayList2) {
            int i6 = i5 + 1;
            if (s.E(o5.o(), str, true)) {
                return i5;
            }
            i5 = i6;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public final C1605h v3() {
        return (C1605h) this.f13729L.getValue();
    }

    private final void w3() {
        setContentView((View) t3().getRoot());
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            t3().f22610e.setNavigationIcon(drawable);
            t3().f22610e.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        t3().f22610e.setNavigationOnClickListener(new X(this));
        TextView textView = t3().f22611f;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        t3().f22607b.f23642g.setTypeface(aVar.x());
        t3().f22607b.f23643h.setTypeface(aVar.x());
        t3().f22607b.f23641f.setTypeface(aVar.w());
        t3().f22607b.f23641f.setVisibility(8);
        A3();
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        t3().f22609d.addItemDecoration(new B2.l(dimension, dimension));
        t3().f22609d.setLayoutManager(new LinearLayoutManager(this, 1, false));
        t3().f22609d.setItemAnimator(new DefaultItemAnimator());
        SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) t3().f22609d.getItemAnimator();
        t.b(simpleItemAnimator);
        simpleItemAnimator.setSupportsChangeAnimations(false);
        t3().f22608c.setOnClickListener(new Y());
    }

    /* access modifiers changed from: private */
    public static final void x3(FreeUpSpaceActivity freeUpSpaceActivity, View view) {
        freeUpSpaceActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void y3(View view) {
    }

    /* access modifiers changed from: private */
    public final void z3(boolean z4) {
        v3().b(this, z4);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Bundle extras;
        Parcelable parcelable;
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (!(intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("appInfo"))) {
            Intent intent2 = getIntent();
            t.b(intent2);
            Bundle extras2 = intent2.getExtras();
            t.b(extras2);
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) extras2.getParcelable("appInfo", C2657f.class);
            } else {
                parcelable = extras2.getParcelable("appInfo");
            }
            this.f13731N = (C2657f) parcelable;
        }
        w3();
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), (C2312i) null, (w3.O) null, new c(this, (C2308e) null), 3, (Object) null);
    }

    public boolean onKeyDown(int i5, KeyEvent keyEvent) {
        t.e(keyEvent, NotificationCompat.CATEGORY_EVENT);
        if (i5 != 82) {
            return super.onKeyDown(i5, keyEvent);
        }
        t3().f22610e.showOverflowMenu();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        z3(true);
        z2.M.f26506a.h(this);
    }

    public final Object r3(String str, String str2, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.c(), new b(this, str2, str, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }
}
