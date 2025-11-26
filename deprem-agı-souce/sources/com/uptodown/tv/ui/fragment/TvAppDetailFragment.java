package com.uptodown.tv.ui.fragment;

import W1.C2209b;
import W2.J;
import W2.u;
import X1.C2227d;
import Y1.C2257a;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.documentfile.provider.DocumentFile;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.app.BackgroundManager;
import androidx.leanback.app.DetailsSupportFragment;
import androidx.leanback.widget.Action;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.ClassPresenterSelector;
import androidx.leanback.widget.DetailsOverviewRow;
import androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import androidx.leanback.widget.FullWidthDetailsOverviewSharedElementHelper;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.PresenterSelector;
import androidx.leanback.widget.SparseArrayObjectAdapter;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import b2.C2291k;
import b2.C2301u;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.squareup.picasso.s;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.C1598a;
import com.uptodown.activities.MoreInfo;
import com.uptodown.activities.VirusTotalReport;
import com.uptodown.activities.preferences.a;
import com.uptodown.tv.preferences.TvPrivacyPreferences;
import com.uptodown.tv.ui.activity.TvOldVersionsActivity;
import com.uptodown.workers.DownloadApkWorker;
import com.uptodown.workers.DownloadWorker;
import g2.C2388j;
import g2.C2392n;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import k2.C2601k;
import k2.C2610u;
import k2.Z;
import k3.p;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.Q;
import kotlin.jvm.internal.t;
import l2.C2657f;
import l2.C2660i;
import l2.C2667p;
import l2.C2668q;
import l2.P;
import l2.T;
import l2.V;
import u2.C2792a;
import u2.C2793b;
import u2.C2794c;
import w2.C2828a;
import w2.C2829b;
import w2.C2830c;
import w2.C2831d;
import w2.C2832e;
import w2.C2833f;
import w2.C2834g;
import w2.C2835h;
import w2.C2836i;
import w2.C2837j;
import w2.C2838k;
import w2.C2839l;
import w2.C2840m;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.I0;
import w3.M;
import w3.O;
import z2.C2940B;
import z2.C2954m;
import z2.F;

public final class TvAppDetailFragment extends DetailsSupportFragment {

    /* renamed from: q  reason: collision with root package name */
    public static final a f21187q = new a((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public C2657f f21188a;

    /* renamed from: b  reason: collision with root package name */
    private long f21189b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f21190c = -1;

    /* renamed from: d  reason: collision with root package name */
    private ArrayObjectAdapter f21191d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public BackgroundManager f21192e;

    /* renamed from: f  reason: collision with root package name */
    private AlertDialog f21193f;

    /* renamed from: g  reason: collision with root package name */
    private AlertDialog f21194g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public DetailsOverviewRow f21195h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f21196i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public T f21197j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public C2793b f21198k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f21199l = true;

    /* renamed from: m  reason: collision with root package name */
    private boolean f21200m = true;

    /* renamed from: n  reason: collision with root package name */
    private boolean f21201n;

    /* renamed from: o  reason: collision with root package name */
    private final d f21202o = new d(this);

    /* renamed from: p  reason: collision with root package name */
    private final ActivityResultLauncher f21203p;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    static final class b extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21204a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvAppDetailFragment f21205b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2657f f21206c;

        static final class a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21207a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ TvAppDetailFragment f21208b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ L f21209c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(TvAppDetailFragment tvAppDetailFragment, L l5, C2308e eVar) {
                super(2, eVar);
                this.f21208b = tvAppDetailFragment;
                this.f21209c = l5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21208b, this.f21209c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21207a == 0) {
                    u.b(obj);
                    this.f21208b.o0((C2668q) this.f21209c.f24690a);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(TvAppDetailFragment tvAppDetailFragment, C2657f fVar, C2308e eVar) {
            super(2, eVar);
            this.f21205b = tvAppDetailFragment;
            this.f21206c = fVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f21205b, this.f21206c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2657f fVar;
            C2668q qVar;
            Object f5 = C2316b.f();
            int i5 = this.f21204a;
            if (i5 == 0) {
                u.b(obj);
                L l5 = new L();
                if (!(this.f21205b.getContext() == null || (fVar = this.f21206c) == null || fVar.S() == null)) {
                    this.f21205b.f21196i = new C2954m().v(this.f21206c.S(), this.f21205b.getContext());
                    C2940B.a aVar = C2940B.f26458v;
                    Context requireContext = this.f21205b.requireContext();
                    t.d(requireContext, "requireContext(...)");
                    C2940B a5 = aVar.a(requireContext);
                    a5.a();
                    if (this.f21205b.f21196i) {
                        TvAppDetailFragment tvAppDetailFragment = this.f21205b;
                        String S4 = this.f21206c.S();
                        t.b(S4);
                        tvAppDetailFragment.f21197j = a5.G0(S4);
                        T y4 = this.f21205b.f21197j;
                        if (y4 != null) {
                            qVar = y4.a();
                        } else {
                            qVar = null;
                        }
                        l5.f24690a = qVar;
                    } else {
                        String S5 = this.f21206c.S();
                        t.b(S5);
                        l5.f24690a = a5.k0(S5, this.f21206c.A0());
                    }
                    a5.m();
                }
                I0 c5 = C2865c0.c();
                a aVar2 = new a(this.f21205b, l5, (C2308e) null);
                this.f21204a = 1;
                if (C2872g.g(c5, aVar2, this) == f5) {
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

    public static final class c implements Z {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TvAppDetailFragment f21210a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2668q f21211b;

        c(TvAppDetailFragment tvAppDetailFragment, C2668q qVar) {
            this.f21210a = tvAppDetailFragment;
            this.f21211b = qVar;
        }

        /* access modifiers changed from: private */
        public static final J e(TvAppDetailFragment tvAppDetailFragment, C2668q qVar) {
            tvAppDetailFragment.a0(qVar);
            return J.f19942a;
        }

        /* access modifiers changed from: private */
        public static final J f(TvAppDetailFragment tvAppDetailFragment) {
            tvAppDetailFragment.J();
            return J.f19942a;
        }

        public void a(l2.L l5) {
            t.e(l5, "reportVT");
            if (this.f21210a.getActivity() != null && (this.f21210a.getActivity() instanceof C1598a) && !this.f21210a.requireActivity().isFinishing()) {
                C2657f t5 = this.f21210a.f21188a;
                t.b(t5);
                t5.Y0(l5);
                if (l5.d() > 0) {
                    FragmentActivity activity = this.f21210a.getActivity();
                    t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                    C2657f t6 = this.f21210a.f21188a;
                    t.b(t6);
                    ((C1598a) activity).j2(t6, new C2839l(this.f21210a, this.f21211b), new C2840m(this.f21210a));
                    return;
                }
                this.f21210a.a0(this.f21211b);
            }
        }

        public void b() {
            this.f21210a.a0(this.f21211b);
        }
    }

    public static final class d implements C2601k {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TvAppDetailFragment f21212a;

        d(TvAppDetailFragment tvAppDetailFragment) {
            this.f21212a = tvAppDetailFragment;
        }

        public void a(long j5) {
        }

        public void b(C2660i iVar) {
            t.e(iVar, "category");
            this.f21212a.m0(iVar);
        }
    }

    public static final class e implements C2227d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ File f21213a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvAppDetailFragment f21214b;

        e(File file, TvAppDetailFragment tvAppDetailFragment) {
            this.f21213a = file;
            this.f21214b = tvAppDetailFragment;
        }

        public void a(DocumentFile documentFile) {
            t.e(documentFile, "docFile");
        }

        public void b(Object obj, int i5, int i6, long j5) {
            t.e(obj, "file");
        }

        public void c(File file) {
            t.e(file, "file");
        }

        public void d(DocumentFile documentFile) {
            t.e(documentFile, "docFile");
        }

        public void e(int i5, String str, long j5, long j6) {
            t.e(str, "currentFilename");
        }

        public void f(File file) {
            t.e(file, "file");
        }

        public void g() {
        }

        public void h(Object obj) {
            t.e(obj, "file");
        }

        public void i() {
            UptodownApp.a aVar = UptodownApp.f13477F;
            File file = this.f21213a;
            t.b(file);
            FragmentActivity requireActivity = this.f21214b.requireActivity();
            t.d(requireActivity, "requireActivity(...)");
            UptodownApp.a.X(aVar, file, requireActivity, (String) null, 4, (Object) null);
        }
    }

    public static final class f implements C2610u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TvAppDetailFragment f21215a;

        static final class a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21216a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ TvAppDetailFragment f21217b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(TvAppDetailFragment tvAppDetailFragment, C2308e eVar) {
                super(2, eVar);
                this.f21217b = tvAppDetailFragment;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21217b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object f5 = C2316b.f();
                int i5 = this.f21216a;
                if (i5 == 0) {
                    u.b(obj);
                    TvAppDetailFragment tvAppDetailFragment = this.f21217b;
                    this.f21216a = 1;
                    if (tvAppDetailFragment.c0(this) == f5) {
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

        f(TvAppDetailFragment tvAppDetailFragment) {
            this.f21215a = tvAppDetailFragment;
        }

        public void c(C2657f fVar) {
            t.e(fVar, "appInfo");
            this.f21215a.f21188a = fVar;
            C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this.f21215a), (C2312i) null, (O) null, new a(this.f21215a, (C2308e) null), 3, (Object) null);
        }

        public void d(int i5) {
        }
    }

    static final class g extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21218a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvAppDetailFragment f21219b;

        static final class a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21220a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ TvAppDetailFragment f21221b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(TvAppDetailFragment tvAppDetailFragment, C2308e eVar) {
                super(2, eVar);
                this.f21221b = tvAppDetailFragment;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21221b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21220a == 0) {
                    u.b(obj);
                    if (this.f21221b.getContext() != null) {
                        C2793b x4 = this.f21221b.f21198k;
                        t.b(x4);
                        Context requireContext = this.f21221b.requireContext();
                        t.d(requireContext, "requireContext(...)");
                        x4.a(requireContext, this.f21221b.f21188a);
                    }
                    this.f21221b.J0();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(TvAppDetailFragment tvAppDetailFragment, C2308e eVar) {
            super(2, eVar);
            this.f21219b = tvAppDetailFragment;
        }

        /* access modifiers changed from: private */
        public static final int e(P p5, P p6) {
            return p5.b() - p6.b();
        }

        /* access modifiers changed from: private */
        public static final int f(p pVar, Object obj, Object obj2) {
            return ((Number) pVar.invoke(obj, obj2)).intValue();
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new g(this.f21219b, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0063, code lost:
            if (r1.isEmpty() != false) goto L_0x0065;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r10.f21218a
                r2 = 1
                if (r1 == 0) goto L_0x0018
                if (r1 != r2) goto L_0x0010
                W2.u.b(r11)
                goto L_0x019a
            L_0x0010:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L_0x0018:
                W2.u.b(r11)
                com.uptodown.tv.ui.fragment.TvAppDetailFragment r11 = r10.f21219b
                android.content.Context r11 = r11.getContext()
                if (r11 == 0) goto L_0x0185
                z2.Z r11 = new z2.Z
                com.uptodown.tv.ui.fragment.TvAppDetailFragment r1 = r10.f21219b
                android.content.Context r1 = r1.requireContext()
                java.lang.String r3 = "requireContext(...)"
                kotlin.jvm.internal.t.d(r1, r3)
                r11.<init>(r1)
                com.uptodown.tv.ui.fragment.TvAppDetailFragment r1 = r10.f21219b
                l2.f r1 = r1.f21188a
                if (r1 == 0) goto L_0x0185
                com.uptodown.tv.ui.fragment.TvAppDetailFragment r1 = r10.f21219b
                l2.f r1 = r1.f21188a
                kotlin.jvm.internal.t.b(r1)
                java.util.ArrayList r1 = r1.D0()
                r3 = 0
                java.lang.String r4 = "data"
                java.lang.String r5 = "success"
                if (r1 == 0) goto L_0x0065
                com.uptodown.tv.ui.fragment.TvAppDetailFragment r1 = r10.f21219b
                l2.f r1 = r1.f21188a
                kotlin.jvm.internal.t.b(r1)
                java.util.ArrayList r1 = r1.D0()
                kotlin.jvm.internal.t.b(r1)
                boolean r1 = r1.isEmpty()
                if (r1 == 0) goto L_0x00c8
            L_0x0065:
                com.uptodown.tv.ui.fragment.TvAppDetailFragment r1 = r10.f21219b
                l2.f r1 = r1.f21188a
                kotlin.jvm.internal.t.b(r1)
                long r6 = r1.e()
                l2.M r1 = r11.C0(r6)
                boolean r6 = r1.b()
                if (r6 != 0) goto L_0x00c8
                org.json.JSONObject r6 = r1.e()
                if (r6 == 0) goto L_0x00c8
                org.json.JSONObject r1 = r1.e()
                kotlin.jvm.internal.t.b(r1)
                int r6 = r1.optInt(r5)
                if (r6 != r2) goto L_0x00c8
                org.json.JSONObject r1 = r1.optJSONObject(r4)
                if (r1 == 0) goto L_0x00c8
                java.util.ArrayList r6 = new java.util.ArrayList
                r6.<init>()
                java.lang.String r7 = "videos"
                org.json.JSONArray r1 = r1.optJSONArray(r7)
                if (r1 == 0) goto L_0x00bc
                r7 = r3
            L_0x00a3:
                int r8 = r1.length()
                if (r7 >= r8) goto L_0x00bc
                org.json.JSONObject r8 = r1.getJSONObject(r7)
                l2.b0$b r9 = l2.b0.f24958c
                kotlin.jvm.internal.t.b(r8)
                l2.b0 r8 = r9.a(r8)
                r6.add(r8)
                int r7 = r7 + 1
                goto L_0x00a3
            L_0x00bc:
                com.uptodown.tv.ui.fragment.TvAppDetailFragment r1 = r10.f21219b
                l2.f r1 = r1.f21188a
                kotlin.jvm.internal.t.b(r1)
                r1.b1(r6)
            L_0x00c8:
                com.uptodown.tv.ui.fragment.TvAppDetailFragment r1 = r10.f21219b
                l2.f r1 = r1.f21188a
                kotlin.jvm.internal.t.b(r1)
                java.util.ArrayList r1 = r1.m0()
                if (r1 != 0) goto L_0x0185
                com.uptodown.tv.ui.fragment.TvAppDetailFragment r1 = r10.f21219b
                l2.f r1 = r1.f21188a
                kotlin.jvm.internal.t.b(r1)
                long r6 = r1.e()
                l2.M r11 = r11.h0(r6)
                boolean r1 = r11.b()
                if (r1 != 0) goto L_0x0166
                java.lang.String r1 = r11.d()
                if (r1 == 0) goto L_0x0166
                int r1 = r1.length()
                if (r1 != 0) goto L_0x00fb
                goto L_0x0166
            L_0x00fb:
                org.json.JSONObject r1 = new org.json.JSONObject
                java.lang.String r11 = r11.d()
                kotlin.jvm.internal.t.b(r11)
                r1.<init>(r11)
                int r11 = r1.optInt(r5)
                if (r11 != r2) goto L_0x0185
                java.util.ArrayList r11 = new java.util.ArrayList
                r11.<init>()
                org.json.JSONArray r1 = r1.optJSONArray(r4)
                if (r1 == 0) goto L_0x0185
                int r4 = r1.length()
            L_0x011c:
                if (r3 >= r4) goto L_0x014c
                org.json.JSONObject r5 = r1.optJSONObject(r3)
                l2.P$b r6 = l2.P.f24840e
                kotlin.jvm.internal.t.b(r5)
                l2.P r5 = r6.a(r5)
                int r6 = r5.a()
                if (r6 != 0) goto L_0x0139
                boolean r5 = r11.add(r5)
                kotlin.coroutines.jvm.internal.b.a(r5)
                goto L_0x0149
            L_0x0139:
                com.uptodown.tv.ui.fragment.TvAppDetailFragment r6 = r10.f21219b
                l2.f r6 = r6.f21188a
                kotlin.jvm.internal.t.b(r6)
                java.lang.String r5 = r5.c()
                r6.R0(r5)
            L_0x0149:
                int r3 = r3 + 1
                goto L_0x011c
            L_0x014c:
                com.uptodown.tv.ui.fragment.a r1 = new com.uptodown.tv.ui.fragment.a
                r1.<init>()
                com.uptodown.tv.ui.fragment.b r3 = new com.uptodown.tv.ui.fragment.b
                r3.<init>(r1)
                X2.C2250q.t(r11, r3)
                com.uptodown.tv.ui.fragment.TvAppDetailFragment r1 = r10.f21219b
                l2.f r1 = r1.f21188a
                kotlin.jvm.internal.t.b(r1)
                r1.Z0(r11)
                goto L_0x0185
            L_0x0166:
                boolean r1 = r11.b()
                if (r1 == 0) goto L_0x0185
                int r11 = r11.f()
                r1 = 404(0x194, float:5.66E-43)
                if (r11 != r1) goto L_0x0185
                com.uptodown.tv.ui.fragment.TvAppDetailFragment r11 = r10.f21219b
                l2.f r11 = r11.f21188a
                kotlin.jvm.internal.t.b(r11)
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                r11.Z0(r1)
            L_0x0185:
                w3.I0 r11 = w3.C2865c0.c()
                com.uptodown.tv.ui.fragment.TvAppDetailFragment$g$a r1 = new com.uptodown.tv.ui.fragment.TvAppDetailFragment$g$a
                com.uptodown.tv.ui.fragment.TvAppDetailFragment r3 = r10.f21219b
                r4 = 0
                r1.<init>(r3, r4)
                r10.f21218a = r2
                java.lang.Object r11 = w3.C2872g.g(r11, r1, r10)
                if (r11 != r0) goto L_0x019a
                return r0
            L_0x019a:
                W2.J r11 = W2.J.f19942a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.tv.ui.fragment.TvAppDetailFragment.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((g) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class h extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21222a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvAppDetailFragment f21223b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(TvAppDetailFragment tvAppDetailFragment, C2308e eVar) {
            super(2, eVar);
            this.f21223b = tvAppDetailFragment;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new h(this.f21223b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21222a;
            if (i5 == 0) {
                u.b(obj);
                TvAppDetailFragment tvAppDetailFragment = this.f21223b;
                this.f21222a = 1;
                if (tvAppDetailFragment.s0(this) == f5) {
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
            return ((h) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class i extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21224a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvAppDetailFragment f21225b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(TvAppDetailFragment tvAppDetailFragment, C2308e eVar) {
            super(2, eVar);
            this.f21225b = tvAppDetailFragment;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new i(this.f21225b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            String str;
            C2316b.f();
            if (this.f21224a == 0) {
                u.b(obj);
                try {
                    C2657f t5 = this.f21225b.f21188a;
                    if (t5 != null) {
                        str = t5.z();
                    } else {
                        str = null;
                    }
                    if (str != null) {
                        BackgroundManager w4 = this.f21225b.f21192e;
                        if (w4 == null) {
                            return null;
                        }
                        s h5 = s.h();
                        C2657f t6 = this.f21225b.f21188a;
                        t.b(t6);
                        w4.setBitmap(h5.l(t6.z()).g());
                        return J.f19942a;
                    }
                    Drawable drawable = ContextCompat.getDrawable(this.f21225b.requireContext(), R.drawable.feature_tv);
                    BackgroundManager w5 = this.f21225b.f21192e;
                    if (w5 == null) {
                        return null;
                    }
                    w5.setDrawable(drawable);
                    return J.f19942a;
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return J.f19942a;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((i) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class j extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21226a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvAppDetailFragment f21227b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ DetailsOverviewRow f21228c;

        static final class a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21229a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ TvAppDetailFragment f21230b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(TvAppDetailFragment tvAppDetailFragment, C2308e eVar) {
                super(2, eVar);
                this.f21230b = tvAppDetailFragment;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21230b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21229a == 0) {
                    u.b(obj);
                    this.f21230b.startEntranceTransition();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(TvAppDetailFragment tvAppDetailFragment, DetailsOverviewRow detailsOverviewRow, C2308e eVar) {
            super(2, eVar);
            this.f21227b = tvAppDetailFragment;
            this.f21228c = detailsOverviewRow;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new j(this.f21227b, this.f21228c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            String str;
            Object f5 = C2316b.f();
            int i5 = this.f21226a;
            if (i5 == 0) {
                u.b(obj);
                try {
                    if (this.f21227b.getContext() != null) {
                        C2657f t5 = this.f21227b.f21188a;
                        if (t5 != null) {
                            str = t5.G();
                        } else {
                            str = null;
                        }
                        if (str != null) {
                            DetailsOverviewRow detailsOverviewRow = this.f21228c;
                            Context requireContext = this.f21227b.requireContext();
                            s h5 = s.h();
                            C2657f t6 = this.f21227b.f21188a;
                            t.b(t6);
                            detailsOverviewRow.setImageBitmap(requireContext, h5.l(t6.G()).l(R.drawable.shape_bg_placeholder).g());
                        }
                    }
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                I0 c5 = C2865c0.c();
                a aVar = new a(this.f21227b, (C2308e) null);
                this.f21226a = 1;
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
            return ((j) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class k implements M1.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TvAppDetailFragment f21231a;

        static final class a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21232a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ TvAppDetailFragment f21233b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(TvAppDetailFragment tvAppDetailFragment, C2308e eVar) {
                super(2, eVar);
                this.f21233b = tvAppDetailFragment;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21233b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object f5 = C2316b.f();
                int i5 = this.f21232a;
                if (i5 == 0) {
                    u.b(obj);
                    TvAppDetailFragment tvAppDetailFragment = this.f21233b;
                    this.f21232a = 1;
                    if (tvAppDetailFragment.s0(this) == f5) {
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

        k(TvAppDetailFragment tvAppDetailFragment) {
            this.f21231a = tvAppDetailFragment;
        }

        public void a(Exception exc) {
            t.e(exc, "e");
        }

        public void onSuccess() {
            C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this.f21231a), (C2312i) null, (O) null, new a(this.f21231a, (C2308e) null), 3, (Object) null);
        }
    }

    public static final class l implements M1.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TvAppDetailFragment f21234a;

        static final class a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21235a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ TvAppDetailFragment f21236b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(TvAppDetailFragment tvAppDetailFragment, C2308e eVar) {
                super(2, eVar);
                this.f21236b = tvAppDetailFragment;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21236b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object f5 = C2316b.f();
                int i5 = this.f21235a;
                if (i5 == 0) {
                    u.b(obj);
                    TvAppDetailFragment tvAppDetailFragment = this.f21236b;
                    DetailsOverviewRow v5 = tvAppDetailFragment.f21195h;
                    t.b(v5);
                    this.f21235a = 1;
                    if (tvAppDetailFragment.t0(v5, this) == f5) {
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

        l(TvAppDetailFragment tvAppDetailFragment) {
            this.f21234a = tvAppDetailFragment;
        }

        public void a(Exception exc) {
            t.e(exc, "e");
        }

        public void onSuccess() {
            C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this.f21234a), (C2312i) null, (O) null, new a(this.f21234a, (C2308e) null), 3, (Object) null);
        }
    }

    static final class m extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21237a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvAppDetailFragment f21238b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(TvAppDetailFragment tvAppDetailFragment, C2308e eVar) {
            super(2, eVar);
            this.f21238b = tvAppDetailFragment;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new m(this.f21238b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21237a;
            if (i5 == 0) {
                u.b(obj);
                TvAppDetailFragment tvAppDetailFragment = this.f21238b;
                C2657f t5 = tvAppDetailFragment.f21188a;
                this.f21237a = 1;
                if (tvAppDetailFragment.K(t5, this) == f5) {
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
            return ((m) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public TvAppDetailFragment() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C2836i(this));
        t.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f21203p = registerForActivityResult;
    }

    private final void A0() {
        if (getActivity() != null) {
            if (this.f21190c != 2) {
                SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter((Presenter) new C2792a());
                sparseArrayObjectAdapter.set(1, new Action(1, getString(R.string.option_button_install)));
                if (!(getActivity() == null || this.f21188a == null)) {
                    String packageName = requireActivity().getPackageName();
                    C2657f fVar = this.f21188a;
                    t.b(fVar);
                    if (!t3.s.E(packageName, fVar.S(), true)) {
                        sparseArrayObjectAdapter.set(3, new Action(3, getString(R.string.dialogo_app_old_versions)));
                    }
                }
                sparseArrayObjectAdapter.set(4, new Action(4, getString(R.string.virustotal_safety_report_title)));
                sparseArrayObjectAdapter.set(5, new Action(5, getString(R.string.app_detail_more_info_title)));
                DetailsOverviewRow detailsOverviewRow = this.f21195h;
                t.b(detailsOverviewRow);
                detailsOverviewRow.setActionsAdapter(sparseArrayObjectAdapter);
                this.f21190c = 2;
            }
            C2793b bVar = this.f21198k;
            t.b(bVar);
            bVar.b(0);
        }
    }

    private final void B0() {
        if (getActivity() != null) {
            if (this.f21190c != 7) {
                SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter((Presenter) new C2792a());
                sparseArrayObjectAdapter.set(1, new Action(1, getString(R.string.installing)));
                if (!(getActivity() == null || this.f21188a == null)) {
                    String packageName = requireActivity().getPackageName();
                    C2657f fVar = this.f21188a;
                    t.b(fVar);
                    if (!t3.s.E(packageName, fVar.S(), true)) {
                        sparseArrayObjectAdapter.set(3, new Action(3, getString(R.string.dialogo_app_old_versions)));
                    }
                }
                sparseArrayObjectAdapter.set(4, new Action(4, getString(R.string.virustotal_safety_report_title)));
                sparseArrayObjectAdapter.set(5, new Action(5, getString(R.string.app_detail_more_info_title)));
                DetailsOverviewRow detailsOverviewRow = this.f21195h;
                t.b(detailsOverviewRow);
                detailsOverviewRow.setActionsAdapter(sparseArrayObjectAdapter);
                this.f21190c = 7;
            }
            C2793b bVar = this.f21198k;
            t.b(bVar);
            bVar.c(true);
        }
    }

    private final void C0() {
        if (getActivity() != null && this.f21190c != 11) {
            SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter((Presenter) new C2792a());
            sparseArrayObjectAdapter.set(1, new Action(1, getString(R.string.app_detail_not_compatible)));
            DetailsOverviewRow detailsOverviewRow = this.f21195h;
            t.b(detailsOverviewRow);
            detailsOverviewRow.setActionsAdapter(sparseArrayObjectAdapter);
            this.f21190c = 11;
        }
    }

    private final void D0() {
        if (getActivity() != null && this.f21190c != 0) {
            SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter((Presenter) new C2792a());
            if (!(getActivity() == null || this.f21188a == null)) {
                String packageName = requireActivity().getPackageName();
                C2657f fVar = this.f21188a;
                t.b(fVar);
                if (!t3.s.E(packageName, fVar.S(), true)) {
                    sparseArrayObjectAdapter.set(1, new Action(1, getString(R.string.open)));
                    sparseArrayObjectAdapter.set(2, new Action(2, getString(R.string.dialogo_app_selected_uninstall)));
                    sparseArrayObjectAdapter.set(3, new Action(3, getString(R.string.dialogo_app_old_versions)));
                }
            }
            sparseArrayObjectAdapter.set(4, new Action(4, getString(R.string.virustotal_safety_report_title)));
            sparseArrayObjectAdapter.set(5, new Action(5, getString(R.string.app_detail_more_info_title)));
            DetailsOverviewRow detailsOverviewRow = this.f21195h;
            t.b(detailsOverviewRow);
            detailsOverviewRow.setActionsAdapter(sparseArrayObjectAdapter);
            this.f21190c = 0;
        }
    }

    private final void E0() {
        A0();
        this.f21190c = 6;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0075 A[Catch:{ Exception -> 0x0031 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void F0() {
        /*
            r9 = this;
            r0 = 5
            androidx.fragment.app.FragmentActivity r1 = r9.getActivity()     // Catch:{ Exception -> 0x0031 }
            if (r1 == 0) goto L_0x00c8
            l2.f r1 = r9.f21188a     // Catch:{ Exception -> 0x0031 }
            if (r1 == 0) goto L_0x00c8
            androidx.leanback.widget.SparseArrayObjectAdapter r1 = new androidx.leanback.widget.SparseArrayObjectAdapter     // Catch:{ Exception -> 0x0031 }
            u2.a r2 = new u2.a     // Catch:{ Exception -> 0x0031 }
            r2.<init>()     // Catch:{ Exception -> 0x0031 }
            r1.<init>((androidx.leanback.widget.Presenter) r2)     // Catch:{ Exception -> 0x0031 }
            l2.f r2 = r9.f21188a     // Catch:{ NumberFormatException -> 0x0034 }
            kotlin.jvm.internal.t.b(r2)     // Catch:{ NumberFormatException -> 0x0034 }
            java.lang.String r2 = r2.q0()     // Catch:{ NumberFormatException -> 0x0034 }
            if (r2 == 0) goto L_0x0038
            l2.f r2 = r9.f21188a     // Catch:{ NumberFormatException -> 0x0034 }
            kotlin.jvm.internal.t.b(r2)     // Catch:{ NumberFormatException -> 0x0034 }
            java.lang.String r2 = r2.q0()     // Catch:{ NumberFormatException -> 0x0034 }
            kotlin.jvm.internal.t.b(r2)     // Catch:{ NumberFormatException -> 0x0034 }
            long r2 = java.lang.Long.parseLong(r2)     // Catch:{ NumberFormatException -> 0x0034 }
            goto L_0x003a
        L_0x0031:
            r1 = move-exception
            goto L_0x00c5
        L_0x0034:
            r2 = move-exception
            r2.printStackTrace()     // Catch:{ Exception -> 0x0031 }
        L_0x0038:
            r2 = 0
        L_0x003a:
            androidx.leanback.widget.Action r4 = new androidx.leanback.widget.Action     // Catch:{ Exception -> 0x0031 }
            r5 = 2131952833(0x7f1304c1, float:1.954212E38)
            java.lang.String r5 = r9.getString(r5)     // Catch:{ Exception -> 0x0031 }
            b2.k r6 = new b2.k     // Catch:{ Exception -> 0x0031 }
            r6.<init>()     // Catch:{ Exception -> 0x0031 }
            android.content.Context r7 = r9.requireContext()     // Catch:{ Exception -> 0x0031 }
            java.lang.String r8 = "requireContext(...)"
            kotlin.jvm.internal.t.d(r7, r8)     // Catch:{ Exception -> 0x0031 }
            java.lang.String r2 = r6.d(r2, r7)     // Catch:{ Exception -> 0x0031 }
            r6 = 1
            r4.<init>(r6, r5, r2)     // Catch:{ Exception -> 0x0031 }
            r2 = 1
            r1.set(r2, r4)     // Catch:{ Exception -> 0x0031 }
            androidx.fragment.app.FragmentActivity r3 = r9.requireActivity()     // Catch:{ Exception -> 0x0031 }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ Exception -> 0x0031 }
            l2.f r4 = r9.f21188a     // Catch:{ Exception -> 0x0031 }
            kotlin.jvm.internal.t.b(r4)     // Catch:{ Exception -> 0x0031 }
            java.lang.String r4 = r4.S()     // Catch:{ Exception -> 0x0031 }
            boolean r2 = t3.s.E(r3, r4, r2)     // Catch:{ Exception -> 0x0031 }
            if (r2 != 0) goto L_0x0099
            androidx.leanback.widget.Action r2 = new androidx.leanback.widget.Action     // Catch:{ Exception -> 0x0031 }
            r3 = 2131951957(0x7f130155, float:1.9540343E38)
            java.lang.String r3 = r9.getString(r3)     // Catch:{ Exception -> 0x0031 }
            r4 = 2
            r2.<init>(r4, r3)     // Catch:{ Exception -> 0x0031 }
            r3 = 2
            r1.set(r3, r2)     // Catch:{ Exception -> 0x0031 }
            androidx.leanback.widget.Action r2 = new androidx.leanback.widget.Action     // Catch:{ Exception -> 0x0031 }
            r3 = 2131951956(0x7f130154, float:1.9540341E38)
            java.lang.String r3 = r9.getString(r3)     // Catch:{ Exception -> 0x0031 }
            r4 = 3
            r2.<init>(r4, r3)     // Catch:{ Exception -> 0x0031 }
            r3 = 3
            r1.set(r3, r2)     // Catch:{ Exception -> 0x0031 }
        L_0x0099:
            androidx.leanback.widget.Action r2 = new androidx.leanback.widget.Action     // Catch:{ Exception -> 0x0031 }
            r3 = 2131952910(0x7f13050e, float:1.9542276E38)
            java.lang.String r3 = r9.getString(r3)     // Catch:{ Exception -> 0x0031 }
            r4 = 4
            r2.<init>(r4, r3)     // Catch:{ Exception -> 0x0031 }
            r3 = 4
            r1.set(r3, r2)     // Catch:{ Exception -> 0x0031 }
            androidx.leanback.widget.Action r2 = new androidx.leanback.widget.Action     // Catch:{ Exception -> 0x0031 }
            r3 = 2131951687(0x7f130047, float:1.9539796E38)
            java.lang.String r3 = r9.getString(r3)     // Catch:{ Exception -> 0x0031 }
            r4 = 5
            r2.<init>(r4, r3)     // Catch:{ Exception -> 0x0031 }
            r1.set(r0, r2)     // Catch:{ Exception -> 0x0031 }
            androidx.leanback.widget.DetailsOverviewRow r2 = r9.f21195h     // Catch:{ Exception -> 0x0031 }
            kotlin.jvm.internal.t.b(r2)     // Catch:{ Exception -> 0x0031 }
            r2.setActionsAdapter(r1)     // Catch:{ Exception -> 0x0031 }
            goto L_0x00c8
        L_0x00c5:
            r1.printStackTrace()
        L_0x00c8:
            r9.f21190c = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.tv.ui.fragment.TvAppDetailFragment.F0():void");
    }

    private final void G0(FragmentActivity fragmentActivity) {
        this.f21198k = new C2793b(this.f21202o);
        FullWidthDetailsOverviewRowPresenter fullWidthDetailsOverviewRowPresenter = new FullWidthDetailsOverviewRowPresenter(this.f21198k, new C2794c());
        fullWidthDetailsOverviewRowPresenter.setBackgroundColor(ContextCompat.getColor(fragmentActivity, R.color.background_color));
        fullWidthDetailsOverviewRowPresenter.setInitialState(0);
        FullWidthDetailsOverviewSharedElementHelper fullWidthDetailsOverviewSharedElementHelper = new FullWidthDetailsOverviewSharedElementHelper();
        fullWidthDetailsOverviewSharedElementHelper.setSharedElementEnterTransition(fragmentActivity, "transition_name");
        fullWidthDetailsOverviewRowPresenter.setListener(fullWidthDetailsOverviewSharedElementHelper);
        fullWidthDetailsOverviewRowPresenter.setParticipatingEntranceTransition(false);
        prepareEntranceTransition();
        fullWidthDetailsOverviewRowPresenter.setOnActionClickedListener(new C2837j(this, fragmentActivity));
        fullWidthDetailsOverviewRowPresenter.setActionsBackgroundColor(ContextCompat.getColor(fragmentActivity, R.color.main_blue));
        ClassPresenterSelector classPresenterSelector = new ClassPresenterSelector();
        classPresenterSelector.addClassPresenter(DetailsOverviewRow.class, fullWidthDetailsOverviewRowPresenter);
        classPresenterSelector.addClassPresenter(ListRow.class, new ListRowPresenter());
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((PresenterSelector) classPresenterSelector);
        this.f21191d = arrayObjectAdapter;
        setAdapter(arrayObjectAdapter);
    }

    /* access modifiers changed from: private */
    public static final void H0(TvAppDetailFragment tvAppDetailFragment, FragmentActivity fragmentActivity, Action action) {
        t.e(action, "action");
        if (action.getId() == 1) {
            tvAppDetailFragment.I();
        } else if (action.getId() == 2) {
            tvAppDetailFragment.K0();
        } else if (action.getId() == 3) {
            if (tvAppDetailFragment.f21188a != null) {
                Intent intent = new Intent(fragmentActivity, TvOldVersionsActivity.class);
                intent.putExtra("appInfo", tvAppDetailFragment.f21188a);
                tvAppDetailFragment.startActivity(intent, UptodownApp.f13477F.a(fragmentActivity));
            }
        } else if (action.getId() == 4) {
            if (tvAppDetailFragment.f21188a != null) {
                Intent intent2 = new Intent(fragmentActivity, VirusTotalReport.class);
                intent2.putExtra("appInfo", tvAppDetailFragment.f21188a);
                tvAppDetailFragment.startActivity(intent2, UptodownApp.f13477F.a(fragmentActivity));
            }
        } else if (action.getId() == 5) {
            tvAppDetailFragment.n0();
        }
    }

    private final void I() {
        int i5 = this.f21190c;
        if (i5 == 0) {
            l0();
        } else if (i5 == 1) {
            Z();
        } else if (i5 == 2) {
            Z();
        } else if (i5 == 3) {
            J();
        } else if (i5 == 5) {
            Z();
        } else if (i5 == 6) {
            Z();
        }
    }

    private final void I0() {
        if (this.f21188a != null) {
            SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter((Presenter) new C2792a());
            C2657f fVar = this.f21188a;
            t.b(fVar);
            DetailsOverviewRow detailsOverviewRow = new DetailsOverviewRow(fVar);
            this.f21195h = detailsOverviewRow;
            t.b(detailsOverviewRow);
            detailsOverviewRow.setActionsAdapter(sparseArrayObjectAdapter);
            C2657f fVar2 = this.f21188a;
            t.b(fVar2);
            if (fVar2.z() != null) {
                s h5 = s.h();
                C2657f fVar3 = this.f21188a;
                t.b(fVar3);
                h5.l(fVar3.z()).e(new k(this));
            } else if (getContext() != null) {
                Drawable drawable = ContextCompat.getDrawable(requireContext(), R.drawable.feature_tv);
                BackgroundManager backgroundManager = this.f21192e;
                t.b(backgroundManager);
                backgroundManager.setDrawable(drawable);
            }
            s h6 = s.h();
            C2657f fVar4 = this.f21188a;
            t.b(fVar4);
            h6.l(fVar4.G()).e(new l(this));
            ArrayObjectAdapter arrayObjectAdapter = this.f21191d;
            t.b(arrayObjectAdapter);
            DetailsOverviewRow detailsOverviewRow2 = this.f21195h;
            t.b(detailsOverviewRow2);
            arrayObjectAdapter.add(detailsOverviewRow2);
        }
    }

    /* access modifiers changed from: private */
    public final void J() {
        if (this.f21188a != null && getContext() != null) {
            DownloadWorker.a aVar = DownloadWorker.f21359d;
            C2657f fVar = this.f21188a;
            t.b(fVar);
            aVar.d(fVar.e());
        }
    }

    /* access modifiers changed from: private */
    public final void J0() {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), (C2312i) null, (O) null, new m(this, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object K(C2657f fVar, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new b(this, fVar, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    private final void K0() {
        C2657f fVar = this.f21188a;
        if (fVar != null) {
            t.b(fVar);
            if (fVar.S() != null) {
                Context requireContext = requireContext();
                t.d(requireContext, "requireContext(...)");
                S1.j jVar = new S1.j(requireContext);
                C2657f fVar2 = this.f21188a;
                t.b(fVar2);
                String S4 = fVar2.S();
                t.b(S4);
                jVar.h(S4);
            }
        }
    }

    private final void L(C2668q qVar) {
        if (getActivity() != null && !requireActivity().isFinishing()) {
            V.b bVar = V.f24870q;
            FragmentActivity requireActivity = requireActivity();
            t.d(requireActivity, "requireActivity(...)");
            V h5 = bVar.h(requireActivity);
            if (h5 == null || !h5.q()) {
                a0(qVar);
                J j5 = J.f19942a;
                return;
            }
            C2657f fVar = this.f21188a;
            t.b(fVar);
            if (fVar.j0() == null) {
                FragmentActivity requireActivity2 = requireActivity();
                t.d(requireActivity2, "requireActivity(...)");
                C2657f fVar2 = this.f21188a;
                t.b(fVar2);
                String valueOf = String.valueOf(fVar2.A());
                C2657f fVar3 = this.f21188a;
                t.b(fVar3);
                new C2392n(requireActivity2, valueOf, fVar3.n0(), new c(this, qVar), LifecycleOwnerKt.getLifecycleScope(this));
                return;
            }
            C2657f fVar4 = this.f21188a;
            t.b(fVar4);
            l2.L j02 = fVar4.j0();
            t.b(j02);
            if (j02.d() > 0) {
                FragmentActivity activity = getActivity();
                t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                C2657f fVar5 = this.f21188a;
                t.b(fVar5);
                ((C1598a) activity).j2(fVar5, new C2830c(this, qVar), new C2831d(this));
            } else {
                a0(qVar);
            }
            J j6 = J.f19942a;
        }
    }

    /* access modifiers changed from: private */
    public static final J M(TvAppDetailFragment tvAppDetailFragment, C2668q qVar) {
        tvAppDetailFragment.a0(qVar);
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final J N(TvAppDetailFragment tvAppDetailFragment) {
        tvAppDetailFragment.J();
        return J.f19942a;
    }

    private final void O(C2668q qVar) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(getString(R.string.descarga_completada));
        builder.setTitle(qVar.i());
        builder.setPositiveButton(R.string.option_button_install, new C2838k(qVar, this));
        builder.setNegativeButton(17039360, new C2829b());
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        if (getActivity() != null && !requireActivity().isFinishing()) {
            create.show();
        }
    }

    /* access modifiers changed from: private */
    public static final void P(C2668q qVar, TvAppDetailFragment tvAppDetailFragment, DialogInterface dialogInterface, int i5) {
        t.e(dialogInterface, "dialogInterface");
        dialogInterface.dismiss();
        File n5 = qVar.n();
        if (n5 != null) {
            UptodownApp.a aVar = UptodownApp.f13477F;
            FragmentActivity requireActivity = tvAppDetailFragment.requireActivity();
            t.d(requireActivity, "requireActivity(...)");
            UptodownApp.a.X(aVar, n5, requireActivity, (String) null, 4, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void Q(DialogInterface dialogInterface, int i5) {
        t.e(dialogInterface, "dialogInterface");
        dialogInterface.dismiss();
    }

    private final void R(C2668q qVar, String str) {
        AlertDialog alertDialog = this.f21193f;
        if (alertDialog != null) {
            t.b(alertDialog);
            alertDialog.dismiss();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(str);
        builder.setPositiveButton(17039370, new C2834g(this, qVar));
        builder.setNegativeButton(17039360, new C2835h());
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        this.f21193f = create;
        if (create != null) {
            create.show();
        }
    }

    /* access modifiers changed from: private */
    public static final void S(TvAppDetailFragment tvAppDetailFragment, C2668q qVar, DialogInterface dialogInterface, int i5) {
        t.e(dialogInterface, "dialog");
        tvAppDetailFragment.a0(qVar);
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void T(DialogInterface dialogInterface, int i5) {
        t.e(dialogInterface, "dialog");
        dialogInterface.dismiss();
    }

    private final boolean U() {
        AlertDialog alertDialog = this.f21194g;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        a.C0147a aVar = com.uptodown.activities.preferences.a.f15150a;
        Context requireContext = requireContext();
        t.d(requireContext, "requireContext(...)");
        if (!aVar.W(requireContext)) {
            return false;
        }
        Context requireContext2 = requireContext();
        t.d(requireContext2, "requireContext(...)");
        if (aVar.k0(requireContext2)) {
            return false;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setMessage(getString(R.string.tracking_disabled_warning_gdpr));
        builder.setPositiveButton(R.string.gdpr_set_up, new C2832e(this));
        builder.setNegativeButton(17039360, new C2833f());
        builder.setCancelable(true);
        this.f21194g = builder.create();
        if (requireActivity().isFinishing()) {
            return false;
        }
        AlertDialog alertDialog2 = this.f21194g;
        if (alertDialog2 != null) {
            alertDialog2.show();
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final void V(TvAppDetailFragment tvAppDetailFragment, DialogInterface dialogInterface, int i5) {
        dialogInterface.dismiss();
        tvAppDetailFragment.startActivity(new Intent(tvAppDetailFragment.requireActivity(), TvPrivacyPreferences.class));
    }

    /* access modifiers changed from: private */
    public static final void W(DialogInterface dialogInterface, int i5) {
        t.e(dialogInterface, "dialogInterface");
        dialogInterface.dismiss();
    }

    private final void X(String str) {
        AlertDialog alertDialog = this.f21193f;
        if (alertDialog != null) {
            t.b(alertDialog);
            alertDialog.dismiss();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(str);
        builder.setPositiveButton(17039370, new C2828a());
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        this.f21193f = create;
        if (create != null) {
            create.show();
        }
    }

    /* access modifiers changed from: private */
    public static final void Y(DialogInterface dialogInterface, int i5) {
        t.e(dialogInterface, "dialog");
        dialogInterface.dismiss();
    }

    private final void Z() {
        File file;
        PackageManager packageManager;
        C2657f fVar = this.f21188a;
        if (fVar != null) {
            t.b(fVar);
            if (!(fVar.S() == null || getContext() == null)) {
                C2940B.a aVar = C2940B.f26458v;
                Context requireContext = requireContext();
                t.d(requireContext, "requireContext(...)");
                C2940B a5 = aVar.a(requireContext);
                a5.a();
                C2657f fVar2 = this.f21188a;
                t.b(fVar2);
                String S4 = fVar2.S();
                t.b(S4);
                C2657f fVar3 = this.f21188a;
                t.b(fVar3);
                C2668q k02 = a5.k0(S4, fVar3.A0());
                ApplicationInfo applicationInfo = null;
                if (k02 == null || !k02.f() || !k02.b()) {
                    file = null;
                } else {
                    file = k02.n();
                }
                a5.m();
                if (file != null) {
                    C2657f fVar4 = this.f21188a;
                    t.b(fVar4);
                    String S5 = fVar4.S();
                    t.b(S5);
                    T G02 = a5.G0(S5);
                    this.f21197j = G02;
                    if (G02 == null || G02.n() != 1) {
                        UptodownApp.a aVar2 = UptodownApp.f13477F;
                        FragmentActivity requireActivity = requireActivity();
                        t.d(requireActivity, "requireActivity(...)");
                        UptodownApp.a.X(aVar2, file, requireActivity, (String) null, 4, (Object) null);
                        J j5 = J.f19942a;
                        return;
                    }
                    if (!file.isDirectory()) {
                        file = new File(file.getAbsolutePath()).getParentFile();
                    }
                    File file2 = file;
                    e eVar = new e(file2, this);
                    try {
                        FragmentActivity activity = getActivity();
                        if (!(activity == null || (packageManager = activity.getPackageManager()) == null)) {
                            T t5 = this.f21197j;
                            t.b(t5);
                            applicationInfo = C2301u.a(packageManager, t5.h(), 128);
                        }
                    } catch (PackageManager.NameNotFoundException e5) {
                        e5.printStackTrace();
                    }
                    if (applicationInfo != null) {
                        File file3 = new File(applicationInfo.sourceDir);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(file3);
                        t.b(file2);
                        Context requireContext2 = requireContext();
                        t.d(requireContext2, "requireContext(...)");
                        new C2209b(arrayList, file2, eVar, false, requireContext2);
                        return;
                    }
                    String string = getString(R.string.installable_files_not_found);
                    t.d(string, "getString(...)");
                    X(string);
                    J j6 = J.f19942a;
                    return;
                }
                r0();
                J j7 = J.f19942a;
                return;
            }
        }
        r0();
        J j8 = J.f19942a;
    }

    /* access modifiers changed from: private */
    public final void a0(C2668q qVar) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            C2657f fVar = this.f21188a;
            t.b(fVar);
            qVar.c(fVar);
            int S4 = qVar.S(activity);
            if (S4 < 0) {
                String string = getString(R.string.descarga_error);
                t.d(string, "getString(...)");
                X(string);
                x0();
            } else if (!DownloadApkWorker.f21342i.b(activity, S4)) {
                Q q5 = Q.f24695a;
                String string2 = getString(R.string.msg_added_to_downlads_queue);
                t.d(string2, "getString(...)");
                C2657f fVar2 = this.f21188a;
                t.b(fVar2);
                String format = String.format(string2, Arrays.copyOf(new Object[]{fVar2.N()}, 1));
                t.d(format, "format(...)");
                X(format);
            }
        }
    }

    /* access modifiers changed from: private */
    public final Object c0(C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new g(this, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    private final void d0() {
        g0();
    }

    private final boolean f0() {
        if (Build.VERSION.SDK_INT >= 30) {
            return Environment.isExternalStorageManager();
        }
        return e0();
    }

    private final void g0() {
        if (this.f21188a != null && getActivity() != null && !i0() && !U()) {
            p0();
        }
    }

    private final boolean h0() {
        C2657f fVar = this.f21188a;
        if (fVar == null) {
            return false;
        }
        UptodownApp.a aVar = UptodownApp.f13477F;
        t.b(fVar);
        return aVar.L(fVar.S());
    }

    private final boolean i0() {
        DownloadWorker.a aVar = DownloadWorker.f21359d;
        C2657f fVar = this.f21188a;
        t.b(fVar);
        return aVar.j(fVar.e());
    }

    private final void j0(String str) {
        if (this.f21188a != null) {
            Bundle bundle = new Bundle();
            bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, str);
            C2657f fVar = this.f21188a;
            t.b(fVar);
            bundle.putString("packagename", fVar.S());
            C2657f fVar2 = this.f21188a;
            t.b(fVar2);
            if (fVar2.e() >= 0) {
                C2657f fVar3 = this.f21188a;
                t.b(fVar3);
                bundle.putString("appId", String.valueOf(fVar3.e()));
            }
            C2657f fVar4 = this.f21188a;
            t.b(fVar4);
            if (fVar4.A() >= 0) {
                C2657f fVar5 = this.f21188a;
                t.b(fVar5);
                bundle.putString("fileId", String.valueOf(fVar5.A()));
            }
            if (h0()) {
                bundle.putInt("deeplink", 1);
            } else {
                bundle.putInt("deeplink", 0);
            }
            new F(requireActivity()).d("warning", bundle);
        }
    }

    /* access modifiers changed from: private */
    public static final void k0(TvAppDetailFragment tvAppDetailFragment, ActivityResult activityResult) {
        if (tvAppDetailFragment.f0()) {
            tvAppDetailFragment.d0();
        }
    }

    private final void l0() {
        C2657f fVar = this.f21188a;
        if (fVar != null) {
            t.b(fVar);
            if (fVar.S() != null && getContext() != null) {
                PackageManager packageManager = requireContext().getPackageManager();
                C2657f fVar2 = this.f21188a;
                t.b(fVar2);
                String S4 = fVar2.S();
                t.b(S4);
                Intent leanbackLaunchIntentForPackage = packageManager.getLeanbackLaunchIntentForPackage(S4);
                if (leanbackLaunchIntentForPackage == null) {
                    PackageManager packageManager2 = requireContext().getPackageManager();
                    C2657f fVar3 = this.f21188a;
                    t.b(fVar3);
                    String S5 = fVar3.S();
                    t.b(S5);
                    leanbackLaunchIntentForPackage = packageManager2.getLaunchIntentForPackage(S5);
                }
                if (leanbackLaunchIntentForPackage != null) {
                    startActivity(leanbackLaunchIntentForPackage);
                }
            }
        }
    }

    private final void n0() {
        Bundle bundle;
        if (this.f21188a != null) {
            Intent intent = new Intent(getContext(), MoreInfo.class);
            intent.putExtra("appInfo", this.f21188a);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                bundle = UptodownApp.f13477F.a(activity);
            } else {
                bundle = null;
            }
            startActivity(intent, bundle);
        }
    }

    /* access modifiers changed from: private */
    public final void o0(C2668q qVar) {
        if (getContext() != null && this.f21188a != null) {
            String str = null;
            if (!this.f21196i) {
                a.C0147a aVar = com.uptodown.activities.preferences.a.f15150a;
                Context requireContext = requireContext();
                t.d(requireContext, "requireContext(...)");
                if (!aVar.R(requireContext)) {
                    u0();
                } else if (this.f21201n) {
                    z0();
                } else {
                    C2657f fVar = this.f21188a;
                    t.b(fVar);
                    if (fVar.M0()) {
                        v0();
                        return;
                    }
                    C2657f fVar2 = this.f21188a;
                    t.b(fVar2);
                    if (!fVar2.G0()) {
                        C0();
                        return;
                    }
                    C2657f fVar3 = this.f21188a;
                    t.b(fVar3);
                    if (fVar3.I0()) {
                        w0();
                        return;
                    }
                    C2657f fVar4 = this.f21188a;
                    t.b(fVar4);
                    if (fVar4.S() != null) {
                        C2257a i5 = S1.k.f32g.i();
                        if (i5 != null) {
                            str = i5.b();
                        }
                        C2657f fVar5 = this.f21188a;
                        t.b(fVar5);
                        if (t3.s.E(str, fVar5.S(), true)) {
                            B0();
                        } else if (qVar == null) {
                            x0();
                        } else if (qVar.f()) {
                            A0();
                        } else if (i0()) {
                            y0(qVar);
                        } else {
                            x0();
                        }
                    }
                }
            } else if (this.f21197j == null) {
                D0();
            } else {
                C2257a i6 = S1.k.f32g.i();
                if (i6 != null) {
                    str = i6.b();
                }
                C2657f fVar6 = this.f21188a;
                t.b(fVar6);
                if (t3.s.E(str, fVar6.S(), true)) {
                    B0();
                } else if (qVar == null) {
                    F0();
                } else if (qVar.f()) {
                    E0();
                } else if (i0()) {
                    y0(qVar);
                } else {
                    F0();
                }
            }
        }
    }

    private final void p0() {
        boolean z4;
        boolean z5;
        boolean z6;
        C2657f fVar = this.f21188a;
        if (fVar != null) {
            boolean z7 = true;
            if (fVar.G0()) {
                C2668q qVar = new C2668q();
                C2657f fVar2 = this.f21188a;
                t.b(fVar2);
                qVar.c(fVar2);
                C2667p pVar = new C2667p();
                Context requireContext = requireContext();
                t.d(requireContext, "requireContext(...)");
                pVar.k(requireContext);
                a.C0147a aVar = com.uptodown.activities.preferences.a.f15150a;
                Context requireContext2 = requireContext();
                t.d(requireContext2, "requireContext(...)");
                if (aVar.x1(requireContext2)) {
                    boolean i5 = pVar.i(qVar);
                    z5 = pVar.g(qVar);
                    z4 = pVar.h(qVar);
                    C2657f fVar3 = this.f21188a;
                    t.b(fVar3);
                    if (fVar3.k0() != null) {
                        C2657f fVar4 = this.f21188a;
                        t.b(fVar4);
                        ArrayList k02 = fVar4.k0();
                        t.b(k02);
                        Context requireContext3 = requireContext();
                        t.d(requireContext3, "requireContext(...)");
                        z7 = pVar.f(k02, requireContext3);
                    }
                    z6 = z7;
                    z7 = i5;
                } else {
                    z6 = true;
                    z5 = true;
                    z4 = true;
                }
                if (z7 && z5 && z4 && z6) {
                    L(qVar);
                    return;
                } else if (!z7) {
                    j0("sdk");
                    String string = getString(R.string.msg_warning_incompatible_sdk);
                    t.d(string, "getString(...)");
                    R(qVar, string);
                    return;
                } else if (!z5) {
                    j0("abi");
                    String string2 = getString(R.string.msg_warning_incompatible_abi);
                    t.d(string2, "getString(...)");
                    R(qVar, string2);
                    return;
                } else if (!z4) {
                    j0("density");
                    String string3 = getString(R.string.msg_warning_incompatible_density);
                    t.d(string3, "getString(...)");
                    R(qVar, string3);
                    return;
                } else {
                    j0("required_feature");
                    String string4 = getString(R.string.msg_warning_incompatible_required_features);
                    t.d(string4, "getString(...)");
                    R(qVar, string4);
                    return;
                }
            }
        }
        j0("no_file_id");
        String string5 = getString(R.string.msg_app_no_compatible_files);
        t.d(string5, "getString(...)");
        X(string5);
    }

    private final void q0() {
        if (!e0()) {
            ActivityCompat.requestPermissions(requireActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 645);
        } else {
            d0();
        }
    }

    private final void r0() {
        if (Build.VERSION.SDK_INT < 30) {
            q0();
        } else if (!Environment.isExternalStorageManager()) {
            try {
                this.f21203p.launch(new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION", Uri.parse("package:" + requireContext().getPackageName())));
            } catch (ActivityNotFoundException unused) {
                q0();
            }
        } else {
            q0();
        }
    }

    /* access modifiers changed from: private */
    public final Object s0(C2308e eVar) {
        return C2872g.g(C2865c0.b(), new i(this, (C2308e) null), eVar);
    }

    /* access modifiers changed from: private */
    public final Object t0(DetailsOverviewRow detailsOverviewRow, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new j(this, detailsOverviewRow, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    private final void u0() {
        if (getActivity() != null && this.f21190c != 9) {
            SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter((Presenter) new C2792a());
            sparseArrayObjectAdapter.set(1, new Action(1, getString(R.string.status_checking_device_compatibility)));
            DetailsOverviewRow detailsOverviewRow = this.f21195h;
            t.b(detailsOverviewRow);
            detailsOverviewRow.setActionsAdapter(sparseArrayObjectAdapter);
            this.f21190c = 9;
        }
    }

    private final void v0() {
        if (getActivity() != null && this.f21190c != 8) {
            SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter((Presenter) new C2792a());
            sparseArrayObjectAdapter.set(1, new Action(1, getString(R.string.coming_soon_button)));
            DetailsOverviewRow detailsOverviewRow = this.f21195h;
            t.b(detailsOverviewRow);
            detailsOverviewRow.setActionsAdapter(sparseArrayObjectAdapter);
            this.f21190c = 8;
        }
    }

    private final void w0() {
        if (getActivity() != null && this.f21190c != 13) {
            SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter((Presenter) new C2792a());
            sparseArrayObjectAdapter.set(1, new Action(1, getString(R.string.status_discontinued)));
            DetailsOverviewRow detailsOverviewRow = this.f21195h;
            t.b(detailsOverviewRow);
            detailsOverviewRow.setActionsAdapter(sparseArrayObjectAdapter);
            this.f21190c = 13;
        }
    }

    private final void x0() {
        long j5;
        if (getActivity() != null) {
            if (this.f21190c != 1) {
                try {
                    SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter((Presenter) new C2792a());
                    try {
                        C2657f fVar = this.f21188a;
                        if (fVar != null) {
                            t.b(fVar);
                            if (fVar.q0() != null) {
                                C2657f fVar2 = this.f21188a;
                                t.b(fVar2);
                                String q02 = fVar2.q0();
                                t.b(q02);
                                j5 = Long.parseLong(q02);
                                String string = requireActivity().getString(R.string.updates_button_download_app);
                                C2291k kVar = new C2291k();
                                Context requireContext = requireContext();
                                t.d(requireContext, "requireContext(...)");
                                sparseArrayObjectAdapter.set(1, new Action(1, string, kVar.d(j5, requireContext)));
                                sparseArrayObjectAdapter.set(3, new Action(3, requireActivity().getString(R.string.dialogo_app_old_versions)));
                                sparseArrayObjectAdapter.set(4, new Action(4, requireActivity().getString(R.string.virustotal_safety_report_title)));
                                sparseArrayObjectAdapter.set(5, new Action(5, requireActivity().getString(R.string.app_detail_more_info_title)));
                                DetailsOverviewRow detailsOverviewRow = this.f21195h;
                                t.b(detailsOverviewRow);
                                detailsOverviewRow.setActionsAdapter(sparseArrayObjectAdapter);
                                this.f21190c = 1;
                            }
                        }
                    } catch (NumberFormatException e5) {
                        e5.printStackTrace();
                    }
                    j5 = 0;
                    String string2 = requireActivity().getString(R.string.updates_button_download_app);
                    C2291k kVar2 = new C2291k();
                    Context requireContext2 = requireContext();
                    t.d(requireContext2, "requireContext(...)");
                    sparseArrayObjectAdapter.set(1, new Action(1, string2, kVar2.d(j5, requireContext2)));
                    sparseArrayObjectAdapter.set(3, new Action(3, requireActivity().getString(R.string.dialogo_app_old_versions)));
                    sparseArrayObjectAdapter.set(4, new Action(4, requireActivity().getString(R.string.virustotal_safety_report_title)));
                    sparseArrayObjectAdapter.set(5, new Action(5, requireActivity().getString(R.string.app_detail_more_info_title)));
                    DetailsOverviewRow detailsOverviewRow2 = this.f21195h;
                    t.b(detailsOverviewRow2);
                    detailsOverviewRow2.setActionsAdapter(sparseArrayObjectAdapter);
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
                this.f21190c = 1;
            }
            C2793b bVar = this.f21198k;
            t.b(bVar);
            bVar.b(0);
        }
    }

    private final void y0(C2668q qVar) {
        if (getActivity() != null) {
            if (this.f21190c != 3) {
                SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter((Presenter) new C2792a());
                sparseArrayObjectAdapter.set(1, new Action(1, requireActivity().getString(17039360)));
                if (this.f21188a != null) {
                    String packageName = requireActivity().getPackageName();
                    C2657f fVar = this.f21188a;
                    t.b(fVar);
                    if (!t3.s.E(packageName, fVar.S(), true)) {
                        sparseArrayObjectAdapter.set(3, new Action(3, getString(R.string.dialogo_app_old_versions)));
                    }
                }
                sparseArrayObjectAdapter.set(4, new Action(4, getString(R.string.virustotal_safety_report_title)));
                sparseArrayObjectAdapter.set(5, new Action(5, getString(R.string.app_detail_more_info_title)));
                DetailsOverviewRow detailsOverviewRow = this.f21195h;
                t.b(detailsOverviewRow);
                detailsOverviewRow.setActionsAdapter(sparseArrayObjectAdapter);
                this.f21190c = 3;
            }
            C2793b bVar = this.f21198k;
            t.b(bVar);
            bVar.b(qVar.x());
        }
    }

    private final void z0() {
        if (getActivity() != null && this.f21190c != 10) {
            SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter((Presenter) new C2792a());
            sparseArrayObjectAdapter.set(1, new Action(1, getString(R.string.app_detail_not_available)));
            DetailsOverviewRow detailsOverviewRow = this.f21195h;
            t.b(detailsOverviewRow);
            detailsOverviewRow.setActionsAdapter(sparseArrayObjectAdapter);
            this.f21190c = 10;
        }
    }

    public final void L0(int i5, String str) {
        C2657f fVar = this.f21188a;
        if (fVar != null) {
            t.b(fVar);
            if (fVar.S() != null) {
                C2657f fVar2 = this.f21188a;
                t.b(fVar2);
                if (!t3.s.E(fVar2.S(), str, true)) {
                    return;
                }
                if (i5 == 301 || i5 == 351) {
                    B0();
                    return;
                }
                D0();
                this.f21190c = 0;
            }
        }
    }

    public final void M0(String str) {
        C2657f fVar = this.f21188a;
        if (fVar != null && str != null) {
            t.b(fVar);
            if (t3.s.E(str, fVar.S(), true)) {
                J0();
            }
        }
    }

    public final void N0(int i5, C2668q qVar) {
        if (this.f21188a != null && qVar != null && qVar.w() != null) {
            String w4 = qVar.w();
            C2657f fVar = this.f21188a;
            t.b(fVar);
            if (!t3.s.E(w4, fVar.S(), true)) {
                return;
            }
            if (i5 == 200) {
                y0(qVar);
            } else if (i5 == 201) {
                y0(qVar);
            } else if (i5 == 205) {
                y0(qVar);
            } else if (i5 != 206) {
                if (i5 == 202) {
                    O(qVar);
                }
                J0();
            } else {
                y0(qVar);
            }
        }
    }

    public final void b0() {
        Context requireContext = requireContext();
        t.d(requireContext, "requireContext(...)");
        new C2388j(requireContext, this.f21189b, new f(this), LifecycleOwnerKt.getLifecycleScope(this));
    }

    public final boolean e0() {
        if (Build.VERSION.SDK_INT >= 33 || ContextCompat.checkSelfPermission(requireContext(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return true;
        }
        return false;
    }

    public void onCreate(Bundle bundle) {
        BackgroundManager backgroundManager;
        Parcelable parcelable;
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            F f5 = new F(activity);
            String simpleName = TvAppDetailFragment.class.getSimpleName();
            t.d(simpleName, "getSimpleName(...)");
            f5.f(simpleName);
            Bundle extras = activity.getIntent().getExtras();
            if (extras != null) {
                if (extras.containsKey("appId")) {
                    this.f21189b = extras.getLong("appId");
                }
                if (extras.containsKey("appInfo")) {
                    if (Build.VERSION.SDK_INT >= 33) {
                        parcelable = (Parcelable) extras.getParcelable("appInfo", C2657f.class);
                    } else {
                        parcelable = extras.getParcelable("appInfo");
                    }
                    C2657f fVar = (C2657f) parcelable;
                    this.f21188a = fVar;
                    if (fVar != null) {
                        t.b(fVar);
                        this.f21189b = fVar.e();
                    }
                }
            }
            BackgroundManager instance = BackgroundManager.getInstance(activity);
            this.f21192e = instance;
            if (!(instance == null || instance.isAttached() || (backgroundManager = this.f21192e) == null)) {
                backgroundManager.attach(activity.getWindow());
            }
            Drawable drawable = ContextCompat.getDrawable(activity, R.drawable.tv_default_background);
            BackgroundManager backgroundManager2 = this.f21192e;
            if (backgroundManager2 != null) {
                backgroundManager2.setDrawable(drawable);
            }
            G0(activity);
            I0();
            b0();
            U();
        }
    }

    public void onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
        boolean z4;
        t.e(strArr, "permissions");
        t.e(iArr, "grantResults");
        super.onRequestPermissionsResult(i5, strArr, iArr);
        if (i5 == 831) {
            if (iArr.length == 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (!z4 && iArr[0] == 0) {
                d0();
            }
        }
    }

    public void onResume() {
        super.onResume();
        if (!this.f21200m) {
            J0();
        } else {
            this.f21200m = false;
        }
    }

    public void onStart() {
        super.onStart();
        if (!this.f21199l) {
            C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), (C2312i) null, (O) null, new h(this, (C2308e) null), 3, (Object) null);
        }
        this.f21199l = false;
    }

    public void onStop() {
        BackgroundManager backgroundManager = this.f21192e;
        t.b(backgroundManager);
        backgroundManager.release();
        super.onStop();
    }

    /* access modifiers changed from: private */
    public final void m0(C2660i iVar) {
    }
}
