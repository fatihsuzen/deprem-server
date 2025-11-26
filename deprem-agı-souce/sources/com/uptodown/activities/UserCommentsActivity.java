package com.uptodown.activities;

import B2.o;
import O1.C6;
import O1.D6;
import R1.P;
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
import com.google.android.material.snackbar.Snackbar;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.d0;
import g2.C2388j;
import h2.h1;
import java.util.Arrays;
import k2.C2610u;
import k3.C2616a;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.Q;
import kotlin.jvm.internal.t;
import l2.C2657f;
import l2.O;
import l2.V;
import w3.C2865c0;
import w3.C2908y0;
import z2.O;
import z3.C2973f;
import z3.D;

public final class UserCommentsActivity extends C1598a {

    /* renamed from: K  reason: collision with root package name */
    private final C2223l f14694K = m.b(new D6(this));

    /* renamed from: L  reason: collision with root package name */
    private final C2223l f14695L = new ViewModelLazy(M.b(d0.class), new f(this), new e(this), new g((C2616a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public P f14696M;
    /* access modifiers changed from: private */

    /* renamed from: N  reason: collision with root package name */
    public b f14697N = new b(this);

    public static final class a extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f14698a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UserCommentsActivity f14699b;

        a(LinearLayoutManager linearLayoutManager, UserCommentsActivity userCommentsActivity) {
            this.f14698a = linearLayoutManager;
            this.f14699b = userCommentsActivity;
        }

        public void onScrolled(RecyclerView recyclerView, int i5, int i6) {
            t.e(recyclerView, "recyclerView");
            if (i6 > 0) {
                int findFirstVisibleItemPosition = this.f14698a.findFirstVisibleItemPosition();
                int childCount = this.f14698a.getChildCount();
                int itemCount = this.f14698a.getItemCount();
                if (!this.f14699b.q3().h() && !((Boolean) this.f14699b.q3().f().getValue()).booleanValue() && childCount + findFirstVisibleItemPosition >= itemCount) {
                    P h32 = this.f14699b.f14696M;
                    if (h32 != null) {
                        h32.c(true);
                    }
                    this.f14699b.q3().e(this.f14699b);
                }
            }
        }
    }

    public static final class b implements k2.M {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UserCommentsActivity f14700a;

        public static final class a implements C2610u {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ UserCommentsActivity f14701a;

            a(UserCommentsActivity userCommentsActivity) {
                this.f14701a = userCommentsActivity;
            }

            public void c(C2657f fVar) {
                t.e(fVar, "appInfo");
                Intent intent = new Intent(this.f14701a, AppDetailActivity.class);
                intent.putExtra("appInfo", fVar);
                UserCommentsActivity userCommentsActivity = this.f14701a;
                userCommentsActivity.startActivity(intent, UptodownApp.f13477F.a(userCommentsActivity));
            }

            public void d(int i5) {
            }
        }

        b(UserCommentsActivity userCommentsActivity) {
            this.f14700a = userCommentsActivity;
        }

        public void a(int i5) {
            Intent intent = new Intent(this.f14700a, RepliesActivity.class);
            P h32 = this.f14700a.f14696M;
            t.b(h32);
            Object obj = h32.b().get(i5);
            t.d(obj, "get(...)");
            O o5 = (O) obj;
            o5.B(((V) this.f14700a.q3().k().getValue()).q() ? 1 : 0);
            o5.E(((V) this.f14700a.q3().k().getValue()).o());
            o5.C(((V) this.f14700a.q3().k().getValue()).j());
            intent.putExtra("review", o5);
            intent.putExtra("username", ((V) this.f14700a.q3().k().getValue()).k());
            intent.putExtra("appName", o5.c());
            intent.putExtra("appIconUrl", o5.e());
            intent.putExtra("userAvatarUrl", ((V) this.f14700a.q3().k().getValue()).a());
            UserCommentsActivity userCommentsActivity = this.f14700a;
            userCommentsActivity.startActivity(intent, UptodownApp.f13477F.a(userCommentsActivity));
        }

        public void b(int i5) {
            if (UptodownApp.f13477F.Z()) {
                O.b bVar = O.f24814p;
                P h32 = this.f14700a.f14696M;
                t.b(h32);
                if (!bVar.d(((O) h32.b().get(i5)).g())) {
                    d0 k32 = this.f14700a.q3();
                    UserCommentsActivity userCommentsActivity = this.f14700a;
                    P h33 = userCommentsActivity.f14696M;
                    t.b(h33);
                    Object obj = h33.b().get(i5);
                    t.d(obj, "get(...)");
                    k32.l(userCommentsActivity, (O) obj);
                }
            }
        }

        public void c(int i5) {
            if (UptodownApp.f13477F.Z()) {
                UserCommentsActivity userCommentsActivity = this.f14700a;
                P h32 = userCommentsActivity.f14696M;
                t.b(h32);
                new C2388j(userCommentsActivity, ((O) h32.b().get(i5)).b(), new a(this.f14700a), LifecycleOwnerKt.getLifecycleScope(this.f14700a));
            }
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14702a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UserCommentsActivity f14703b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ UserCommentsActivity f14704a;

            a(UserCommentsActivity userCommentsActivity) {
                this.f14704a = userCommentsActivity;
            }

            /* renamed from: b */
            public final Object emit(z2.O o5, C2308e eVar) {
                String str;
                if (o5 instanceof O.a) {
                    this.f14704a.n3().f23205b.setVisibility(0);
                } else if (o5 instanceof O.c) {
                    O.c cVar = (O.c) o5;
                    if (((d0.a) cVar.a()).b() == null || !((d0.a) cVar.a()).c()) {
                        this.f14704a.n3().f23208e.setTypeface(k.f32g.x());
                        this.f14704a.n3().f23208e.setVisibility(0);
                    } else {
                        V h5 = V.f24870q.h(this.f14704a);
                        if (h5 != null) {
                            str = h5.j();
                        } else {
                            str = null;
                        }
                        if (t.a(str, ((d0.a) cVar.a()).b().j())) {
                            this.f14704a.n3().f23209f.setText(this.f14704a.getString(R.string.public_profile_my_reviews));
                        } else {
                            TextView textView = this.f14704a.n3().f23209f;
                            Q q5 = Q.f24695a;
                            String string = this.f14704a.getString(R.string.user_reviews);
                            t.d(string, "getString(...)");
                            String format = String.format(string, Arrays.copyOf(new Object[]{((d0.a) cVar.a()).b().k()}, 1));
                            t.d(format, "format(...)");
                            textView.setText(format);
                        }
                        if (!((d0.a) cVar.a()).a().isEmpty()) {
                            if (this.f14704a.f14696M == null) {
                                this.f14704a.f14696M = new P(((d0.a) cVar.a()).a(), this.f14704a.f14697N);
                                this.f14704a.n3().f23206c.setAdapter(this.f14704a.f14696M);
                            } else {
                                P h32 = this.f14704a.f14696M;
                                t.b(h32);
                                h32.a(((d0.a) cVar.a()).a());
                            }
                        }
                        P h33 = this.f14704a.f14696M;
                        if (h33 != null) {
                            h33.c(false);
                        }
                    }
                    this.f14704a.n3().f23205b.setVisibility(8);
                } else if (!(o5 instanceof O.b)) {
                    throw new q();
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(UserCommentsActivity userCommentsActivity, C2308e eVar) {
            super(2, eVar);
            this.f14703b = userCommentsActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f14703b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14702a;
            if (i5 == 0) {
                u.b(obj);
                D g5 = this.f14703b.q3().g();
                a aVar = new a(this.f14703b);
                this.f14702a = 1;
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
            return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14705a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UserCommentsActivity f14706b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ UserCommentsActivity f14707a;

            a(UserCommentsActivity userCommentsActivity) {
                this.f14707a = userCommentsActivity;
            }

            /* renamed from: b */
            public final Object emit(z2.O o5, C2308e eVar) {
                if (o5 instanceof O.c) {
                    O.c cVar = (O.c) o5;
                    if (((O.c) cVar.a()).b() == 1) {
                        P h32 = this.f14707a.f14696M;
                        if (h32 != null) {
                            h32.d(((O.c) cVar.a()).a());
                        }
                    } else {
                        Snackbar.make((View) this.f14707a.n3().f23206c, (int) R.string.error_generico, -1).show();
                        UserCommentsActivity userCommentsActivity = this.f14707a;
                        String string = userCommentsActivity.getString(R.string.error_generico);
                        t.d(string, "getString(...)");
                        userCommentsActivity.u0(string);
                    }
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(UserCommentsActivity userCommentsActivity, C2308e eVar) {
            super(2, eVar);
            this.f14706b = userCommentsActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f14706b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14705a;
            if (i5 == 0) {
                u.b(obj);
                D j5 = this.f14706b.q3().j();
                a aVar = new a(this.f14706b);
                this.f14705a = 1;
                if (j5.collect(aVar, this) == f5) {
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
        final /* synthetic */ ComponentActivity f14708a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(ComponentActivity componentActivity) {
            super(0);
            this.f14708a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f14708a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class f extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14709a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(ComponentActivity componentActivity) {
            super(0);
            this.f14709a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f14709a.getViewModelStore();
        }
    }

    public static final class g extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2616a f14710a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14711b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(C2616a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f14710a = aVar;
            this.f14711b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                k3.a r0 = r1.f14710a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f14711b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.UserCommentsActivity.g.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    /* access modifiers changed from: private */
    public static final h1 m3(UserCommentsActivity userCommentsActivity) {
        return h1.c(userCommentsActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final h1 n3() {
        return (h1) this.f14694K.getValue();
    }

    private final void o3() {
        String j5 = ((V) q3().k().getValue()).j();
        if (j5 != null && j5.length() != 0) {
            q3().e(this);
        }
    }

    private final String p3() {
        Bundle extras;
        if (getIntent() == null || (extras = getIntent().getExtras()) == null || !extras.containsKey("userID")) {
            return null;
        }
        return extras.getString("userID");
    }

    /* access modifiers changed from: private */
    public final d0 q3() {
        return (d0) this.f14695L.getValue();
    }

    private final void r3() {
        n3().f23207d.setNavigationIcon(ContextCompat.getDrawable(this, R.drawable.core_vector_back));
        n3().f23207d.setNavigationContentDescription((CharSequence) getString(R.string.back));
        n3().f23207d.setNavigationOnClickListener(new C6(this));
        n3().f23209f.setTypeface(k.f32g.w());
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        n3().f23206c.addItemDecoration(new o(dimension, dimension, dimension, dimension));
        n3().f23206c.setLayoutManager(linearLayoutManager);
        n3().f23206c.setItemAnimator((RecyclerView.ItemAnimator) null);
        n3().f23206c.addOnScrollListener(new a(linearLayoutManager, this));
        o3();
    }

    /* access modifiers changed from: private */
    public static final void s3(UserCommentsActivity userCommentsActivity, View view) {
        userCommentsActivity.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) n3().getRoot());
        ((V) q3().k().getValue()).y(p3());
        r3();
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new c(this, (C2308e) null), 2, (Object) null);
        C2908y0 unused2 = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new d(this, (C2308e) null), 2, (Object) null);
    }
}
