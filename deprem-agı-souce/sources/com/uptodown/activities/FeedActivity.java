package com.uptodown.activities;

import O1.N;
import O1.P;
import O1.Q;
import R1.C0972c;
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
import b3.C2308e;
import c3.C2316b;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import g2.C2391m;
import h2.I;
import java.util.ArrayList;
import java.util.Iterator;
import k2.C2603m;
import k3.C2616a;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import l2.C2672v;
import l2.O;
import l2.V;
import w3.C2865c0;
import w3.C2908y0;
import z2.C2962v;
import z2.O;
import z3.C2973f;
import z3.D;

public final class FeedActivity extends C1598a {

    /* renamed from: K  reason: collision with root package name */
    private final C2223l f13689K = m.b(new N(this));

    /* renamed from: L  reason: collision with root package name */
    private final C2223l f13690L = new ViewModelLazy(M.b(Q.class), new f(this), new e(this), new g((C2616a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public C0972c f13691M;
    /* access modifiers changed from: private */

    /* renamed from: N  reason: collision with root package name */
    public final a f13692N = new a(this);

    public static final class a implements C2603m {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FeedActivity f13693a;

        /* renamed from: com.uptodown.activities.FeedActivity$a$a  reason: collision with other inner class name */
        public static final class C0121a implements k2.N {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ FeedActivity f13694a;

            C0121a(FeedActivity feedActivity) {
                this.f13694a = feedActivity;
            }

            public void a() {
                this.f13694a.o3().f22408b.setVisibility(8);
            }

            public void b(V v5) {
                t.e(v5, "user");
                this.f13694a.o3().f22408b.setVisibility(8);
                Intent intent = new Intent(this.f13694a, PublicProfileActivity.class);
                intent.putExtra("user", v5);
                FeedActivity feedActivity = this.f13694a;
                feedActivity.startActivity(intent, UptodownApp.f13477F.a(feedActivity));
            }
        }

        a(FeedActivity feedActivity) {
            this.f13693a = feedActivity;
        }

        public void a() {
            if (UptodownApp.f13477F.Z()) {
                C2962v vVar = new C2962v();
                FeedActivity feedActivity = this.f13693a;
                String string = feedActivity.getString(R.string.url_turbo);
                t.d(string, "getString(...)");
                vVar.t(feedActivity, string, this.f13693a.getString(R.string.uptodown_turbo));
            }
        }

        public void b(C2672v vVar) {
            t.e(vVar, "feedItem");
            UptodownApp.a aVar = UptodownApp.f13477F;
            if (aVar.Z()) {
                O b5 = O.f24814p.b(vVar);
                Intent intent = new Intent(this.f13693a, RepliesActivity.class);
                intent.putExtra("review", b5);
                intent.putExtra("appName", vVar.c());
                intent.putExtra("appIconUrl", vVar.b());
                intent.putExtra("appUrl", vVar.e());
                FeedActivity feedActivity = this.f13693a;
                feedActivity.startActivity(intent, aVar.a(feedActivity));
            }
        }

        public void c(long j5) {
            if (UptodownApp.f13477F.Z()) {
                this.f13693a.o3().f22408b.setVisibility(0);
                FeedActivity feedActivity = this.f13693a;
                new C2391m(feedActivity, LifecycleOwnerKt.getLifecycleScope(feedActivity)).c(String.valueOf(j5), new C0121a(this.f13693a));
            }
        }

        public void d(long j5, String str) {
            UptodownApp.a aVar = UptodownApp.f13477F;
            if (aVar.Z()) {
                V v5 = new V();
                v5.y(String.valueOf(j5));
                v5.z(str);
                Intent intent = new Intent(this.f13693a, PublicListActivity.class);
                intent.putExtra("user", v5);
                FeedActivity feedActivity = this.f13693a;
                feedActivity.startActivity(intent, aVar.a(feedActivity));
            }
        }

        public void e(long j5, String str) {
            if (UptodownApp.f13477F.Z()) {
                this.f13693a.p3().e(this.f13693a, String.valueOf(j5));
            }
        }

        public void f(long j5, String str) {
            if (UptodownApp.f13477F.Z()) {
                this.f13693a.I2(j5, str);
            }
        }
    }

    public static final class b extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f13695a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FeedActivity f13696b;

        b(LinearLayoutManager linearLayoutManager, FeedActivity feedActivity) {
            this.f13695a = linearLayoutManager;
            this.f13696b = feedActivity;
        }

        public void onScrolled(RecyclerView recyclerView, int i5, int i6) {
            t.e(recyclerView, "recyclerView");
            if (i6 > 0) {
                int findFirstVisibleItemPosition = this.f13695a.findFirstVisibleItemPosition();
                int childCount = this.f13695a.getChildCount();
                int itemCount = this.f13695a.getItemCount();
                if (!this.f13696b.p3().i() && this.f13696b.p3().h() && childCount + findFirstVisibleItemPosition >= itemCount) {
                    C0972c i32 = this.f13696b.f13691M;
                    if (i32 != null) {
                        i32.c(true);
                    }
                    this.f13696b.p3().c(this.f13696b);
                }
            }
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13697a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FeedActivity f13698b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ FeedActivity f13699a;

            a(FeedActivity feedActivity) {
                this.f13699a = feedActivity;
            }

            /* renamed from: b */
            public final Object emit(z2.O o5, C2308e eVar) {
                ArrayList arrayList;
                if (o5 instanceof O.a) {
                    this.f13699a.p3().l(true);
                    if (this.f13699a.f13691M == null) {
                        this.f13699a.o3().f22408b.setVisibility(0);
                    }
                } else if (o5 instanceof O.c) {
                    this.f13699a.p3().l(false);
                    if (this.f13699a.f13691M == null) {
                        this.f13699a.f13691M = new C0972c((ArrayList) ((O.c) o5).a(), this.f13699a.f13692N);
                        this.f13699a.o3().f22409c.setAdapter(this.f13699a.f13691M);
                    } else {
                        Iterator it = ((ArrayList) ((O.c) o5).a()).iterator();
                        t.d(it, "iterator(...)");
                        while (it.hasNext()) {
                            Object next = it.next();
                            t.d(next, "next(...)");
                            C0972c i32 = this.f13699a.f13691M;
                            t.b(i32);
                            i32.a((C2672v) next);
                        }
                    }
                    C0972c i33 = this.f13699a.f13691M;
                    if (i33 != null) {
                        i33.c(false);
                    }
                    C0972c i34 = this.f13699a.f13691M;
                    if (i34 != null) {
                        arrayList = i34.b();
                    } else {
                        arrayList = null;
                    }
                    if (arrayList == null || arrayList.isEmpty()) {
                        this.f13699a.o3().f22411e.setVisibility(0);
                    } else {
                        this.f13699a.o3().f22411e.setVisibility(8);
                    }
                    this.f13699a.o3().f22408b.setVisibility(8);
                } else if (!(o5 instanceof O.b)) {
                    throw new q();
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FeedActivity feedActivity, C2308e eVar) {
            super(2, eVar);
            this.f13698b = feedActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f13698b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f13697a;
            if (i5 == 0) {
                u.b(obj);
                D f6 = this.f13698b.p3().f();
                a aVar = new a(this.f13698b);
                this.f13697a = 1;
                if (f6.collect(aVar, this) == f5) {
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

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13700a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FeedActivity f13701b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ FeedActivity f13702a;

            a(FeedActivity feedActivity) {
                this.f13702a = feedActivity;
            }

            public final Object b(int i5, C2308e eVar) {
                if (i5 == 1) {
                    FeedActivity feedActivity = this.f13702a;
                    String string = feedActivity.getString(R.string.follow_succesfully);
                    t.d(string, "getString(...)");
                    feedActivity.u0(string);
                } else if (i5 == 2) {
                    FeedActivity feedActivity2 = this.f13702a;
                    String string2 = feedActivity2.getString(R.string.already_following);
                    t.d(string2, "getString(...)");
                    feedActivity2.u0(string2);
                }
                return J.f19942a;
            }

            public /* bridge */ /* synthetic */ Object emit(Object obj, C2308e eVar) {
                return b(((Number) obj).intValue(), eVar);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FeedActivity feedActivity, C2308e eVar) {
            super(2, eVar);
            this.f13701b = feedActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f13701b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f13700a;
            if (i5 == 0) {
                u.b(obj);
                D g5 = this.f13701b.p3().g();
                a aVar = new a(this.f13701b);
                this.f13700a = 1;
                if (g5.collect(aVar, this) == f5) {
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
        final /* synthetic */ ComponentActivity f13703a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(ComponentActivity componentActivity) {
            super(0);
            this.f13703a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f13703a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class f extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f13704a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(ComponentActivity componentActivity) {
            super(0);
            this.f13704a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f13704a.getViewModelStore();
        }
    }

    public static final class g extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2616a f13705a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f13706b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(C2616a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f13705a = aVar;
            this.f13706b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                k3.a r0 = r1.f13705a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f13706b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.FeedActivity.g.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    /* access modifiers changed from: private */
    public static final I n3(FeedActivity feedActivity) {
        return I.c(feedActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final I o3() {
        return (I) this.f13689K.getValue();
    }

    /* access modifiers changed from: private */
    public final Q p3() {
        return (Q) this.f13690L.getValue();
    }

    private final void q3() {
        setContentView((View) o3().getRoot());
        o3().f22410d.setNavigationIcon(ContextCompat.getDrawable(this, R.drawable.core_vector_back));
        o3().f22410d.setNavigationContentDescription((CharSequence) getString(R.string.back));
        o3().f22410d.setNavigationOnClickListener(new O1.O(this));
        TextView textView = o3().f22412f;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        o3().f22411e.setTypeface(aVar.x());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        o3().f22409c.setLayoutManager(linearLayoutManager);
        o3().f22409c.addOnScrollListener(new b(linearLayoutManager, this));
        o3().f22408b.setOnClickListener(new P());
    }

    /* access modifiers changed from: private */
    public static final void r3(FeedActivity feedActivity, View view) {
        feedActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void s3(View view) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        q3();
        p3().c(this);
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new c(this, (C2308e) null), 2, (Object) null);
        C2908y0 unused2 = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new d(this, (C2308e) null), 2, (Object) null);
    }
}
