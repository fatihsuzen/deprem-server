package com.uptodown.activities;

import O1.S;
import O1.T;
import O1.U;
import O1.V;
import R1.C0973d;
import S1.k;
import W2.C2219h;
import W2.C2223l;
import W2.J;
import W2.m;
import W2.q;
import W2.u;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import b3.C2308e;
import c3.C2316b;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import g2.C2391m;
import java.util.ArrayList;
import java.util.Iterator;
import k2.C2605o;
import k2.N;
import k3.C2616a;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import w3.C2865c0;
import w3.C2908y0;
import z2.O;
import z3.C2973f;
import z3.D;

public final class FollowListActivity extends C1598a {

    /* renamed from: O  reason: collision with root package name */
    public static final a f13707O = new a((C2633k) null);

    /* renamed from: K  reason: collision with root package name */
    private final C2223l f13708K = m.b(new S(this));

    /* renamed from: L  reason: collision with root package name */
    private final C2223l f13709L = new ViewModelLazy(M.b(V.class), new g(this), new f(this), new h((C2616a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public C0973d f13710M;
    /* access modifiers changed from: private */

    /* renamed from: N  reason: collision with root package name */
    public final c f13711N = new c(this);

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public static final class b extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f13712a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FollowListActivity f13713b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f13714c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f13715d;

        b(LinearLayoutManager linearLayoutManager, FollowListActivity followListActivity, int i5, String str) {
            this.f13712a = linearLayoutManager;
            this.f13713b = followListActivity;
            this.f13714c = i5;
            this.f13715d = str;
        }

        public void onScrolled(RecyclerView recyclerView, int i5, int i6) {
            t.e(recyclerView, "recyclerView");
            if (i6 > 0) {
                int findFirstVisibleItemPosition = this.f13712a.findFirstVisibleItemPosition();
                int childCount = this.f13712a.getChildCount();
                int itemCount = this.f13712a.getItemCount();
                if (!this.f13713b.p3().i() && this.f13713b.p3().h() && childCount + findFirstVisibleItemPosition >= itemCount) {
                    C0973d i32 = this.f13713b.f13710M;
                    if (i32 != null) {
                        i32.c(true);
                    }
                    int i7 = this.f13714c;
                    if (i7 == 1) {
                        this.f13713b.p3().f(this.f13713b, this.f13715d);
                    } else if (i7 == 2) {
                        this.f13713b.p3().g(this.f13713b, this.f13715d);
                    }
                }
            }
        }
    }

    public static final class c implements C2605o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FollowListActivity f13716a;

        public static final class a implements N {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ FollowListActivity f13717a;

            a(FollowListActivity followListActivity) {
                this.f13717a = followListActivity;
            }

            public void a() {
            }

            public void b(l2.V v5) {
                t.e(v5, "user");
                Intent intent = new Intent(this.f13717a, PublicProfileActivity.class);
                intent.putExtra("user", v5);
                FollowListActivity followListActivity = this.f13717a;
                followListActivity.startActivity(intent, UptodownApp.f13477F.a(followListActivity));
            }
        }

        c(FollowListActivity followListActivity) {
            this.f13716a = followListActivity;
        }

        public void a(String str) {
            t.e(str, "userID");
            if (UptodownApp.f13477F.Z()) {
                FollowListActivity followListActivity = this.f13716a;
                new C2391m(followListActivity, LifecycleOwnerKt.getLifecycleScope(followListActivity)).c(str, new a(this.f13716a));
            }
        }

        public void b(String str, int i5) {
            t.e(str, "userID");
            if (UptodownApp.f13477F.Z() && this.f13716a.f13710M != null) {
                C0973d i32 = this.f13716a.f13710M;
                t.b(i32);
                Object obj = i32.b().get(i5);
                t.d(obj, "get(...)");
                l2.V v5 = (l2.V) obj;
                if (v5.i() == 1) {
                    V l32 = this.f13716a.p3();
                    FollowListActivity followListActivity = this.f13716a;
                    String j5 = v5.j();
                    t.b(j5);
                    l32.p(followListActivity, j5);
                    C0973d i33 = this.f13716a.f13710M;
                    t.b(i33);
                    ((l2.V) i33.b().get(i5)).x(0);
                } else {
                    V l33 = this.f13716a.p3();
                    FollowListActivity followListActivity2 = this.f13716a;
                    String j6 = v5.j();
                    t.b(j6);
                    l33.c(followListActivity2, j6);
                    C0973d i34 = this.f13716a.f13710M;
                    t.b(i34);
                    ((l2.V) i34.b().get(i5)).x(1);
                }
                C0973d i35 = this.f13716a.f13710M;
                if (i35 != null) {
                    i35.notifyItemChanged(i5);
                }
            }
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13718a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FollowListActivity f13719b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ FollowListActivity f13720a;

            a(FollowListActivity followListActivity) {
                this.f13720a = followListActivity;
            }

            /* renamed from: b */
            public final Object emit(O o5, C2308e eVar) {
                ArrayList arrayList;
                if (o5 instanceof O.a) {
                    this.f13720a.p3().n(true);
                    if (this.f13720a.f13710M == null) {
                        this.f13720a.o3().f22547b.setVisibility(0);
                    }
                } else if (o5 instanceof O.c) {
                    this.f13720a.p3().n(false);
                    if (this.f13720a.f13710M == null) {
                        this.f13720a.f13710M = new C0973d((ArrayList) ((O.c) o5).a(), this.f13720a.f13711N);
                        this.f13720a.o3().f22548c.setAdapter(this.f13720a.f13710M);
                    } else {
                        Iterator it = ((ArrayList) ((O.c) o5).a()).iterator();
                        t.d(it, "iterator(...)");
                        while (it.hasNext()) {
                            Object next = it.next();
                            t.d(next, "next(...)");
                            C0973d i32 = this.f13720a.f13710M;
                            t.b(i32);
                            i32.a((l2.V) next);
                        }
                    }
                    C0973d i33 = this.f13720a.f13710M;
                    if (i33 != null) {
                        i33.c(false);
                    }
                    C0973d i34 = this.f13720a.f13710M;
                    if (i34 != null) {
                        arrayList = i34.b();
                    } else {
                        arrayList = null;
                    }
                    if (arrayList == null || arrayList.isEmpty()) {
                        this.f13720a.o3().f22550e.setVisibility(0);
                    } else {
                        this.f13720a.o3().f22550e.setVisibility(8);
                    }
                    this.f13720a.o3().f22547b.setVisibility(8);
                } else if (!(o5 instanceof O.b)) {
                    throw new q();
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FollowListActivity followListActivity, C2308e eVar) {
            super(2, eVar);
            this.f13719b = followListActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f13719b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f13718a;
            if (i5 == 0) {
                u.b(obj);
                D k5 = this.f13719b.p3().k();
                a aVar = new a(this.f13719b);
                this.f13718a = 1;
                if (k5.collect(aVar, this) == f5) {
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

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13721a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FollowListActivity f13722b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ FollowListActivity f13723a;

            a(FollowListActivity followListActivity) {
                this.f13723a = followListActivity;
            }

            public final Object b(int i5, C2308e eVar) {
                if (this.f13723a.p3().d()) {
                    if (i5 == 1) {
                        FollowListActivity followListActivity = this.f13723a;
                        String string = followListActivity.getString(R.string.follow_succesfully);
                        t.d(string, "getString(...)");
                        followListActivity.u0(string);
                    } else {
                        FollowListActivity followListActivity2 = this.f13723a;
                        String string2 = followListActivity2.getString(R.string.unfollow_succesfully);
                        t.d(string2, "getString(...)");
                        followListActivity2.u0(string2);
                    }
                    this.f13723a.p3().l(false);
                }
                return J.f19942a;
            }

            public /* bridge */ /* synthetic */ Object emit(Object obj, C2308e eVar) {
                return b(((Number) obj).intValue(), eVar);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(FollowListActivity followListActivity, C2308e eVar) {
            super(2, eVar);
            this.f13722b = followListActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f13722b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f13721a;
            if (i5 == 0) {
                u.b(obj);
                D e5 = this.f13722b.p3().e();
                a aVar = new a(this.f13722b);
                this.f13721a = 1;
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
            return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class f extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f13724a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(ComponentActivity componentActivity) {
            super(0);
            this.f13724a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f13724a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class g extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f13725a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(ComponentActivity componentActivity) {
            super(0);
            this.f13725a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f13725a.getViewModelStore();
        }
    }

    public static final class h extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2616a f13726a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f13727b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(C2616a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f13726a = aVar;
            this.f13727b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                k3.a r0 = r1.f13726a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f13727b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.FollowListActivity.h.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    /* access modifiers changed from: private */
    public static final h2.O n3(FollowListActivity followListActivity) {
        return h2.O.c(followListActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final h2.O o3() {
        return (h2.O) this.f13708K.getValue();
    }

    /* access modifiers changed from: private */
    public final V p3() {
        return (V) this.f13709L.getValue();
    }

    private final void q3(String str, String str2, int i5) {
        setContentView((View) o3().getRoot());
        o3().f22549d.setNavigationIcon(ContextCompat.getDrawable(this, R.drawable.core_vector_back));
        o3().f22549d.setNavigationContentDescription((CharSequence) getString(R.string.back));
        o3().f22549d.setNavigationOnClickListener(new T(this));
        TextView textView = o3().f22551f;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        o3().f22550e.setTypeface(aVar.x());
        if (i5 == 1) {
            o3().f22551f.setText(getString(R.string.user_followers, new Object[]{str2}));
        } else if (i5 == 2) {
            o3().f22551f.setText(getString(R.string.user_followed, new Object[]{str2}));
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        o3().f22548c.addItemDecoration(new B2.l(dimension, dimension));
        o3().f22548c.setLayoutManager(linearLayoutManager);
        o3().f22548c.addOnScrollListener(new b(linearLayoutManager, this, i5, str));
        o3().f22547b.setOnClickListener(new U());
    }

    /* access modifiers changed from: private */
    public static final void r3(FollowListActivity followListActivity, View view) {
        followListActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void s3(View view) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String str;
        String str2;
        Bundle extras;
        super.onCreate(bundle);
        Intent intent = getIntent();
        int i5 = 0;
        if (intent == null || (extras = intent.getExtras()) == null) {
            str2 = null;
            str = null;
        } else {
            if (extras.containsKey(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY)) {
                i5 = extras.getInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
            }
            if (extras.containsKey("userID")) {
                str = extras.getString("userID");
            } else {
                str = null;
            }
            if (extras.containsKey("username")) {
                str2 = extras.getString("username");
            } else {
                str2 = null;
            }
        }
        if (!(str == null || str.length() == 0 || str2 == null || str2.length() == 0)) {
            q3(str, str2, i5);
            if (i5 == 1) {
                p3().f(this, str);
            } else if (i5 == 2) {
                p3().g(this, str);
            }
        }
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new d(this, (C2308e) null), 2, (Object) null);
        C2908y0 unused2 = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new e(this, (C2308e) null), 2, (Object) null);
    }
}
