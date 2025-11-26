package com.uptodown.activities;

import O1.A5;
import O1.B5;
import O1.C0903u5;
import O1.C0911v5;
import O1.C0919w5;
import O1.C0927x5;
import O1.C0935y5;
import O1.C0943z5;
import R1.E;
import S1.k;
import W2.C2219h;
import W2.C2223l;
import W2.J;
import W2.m;
import W2.u;
import android.app.SearchManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.views.InstantAutoCompleteTextView;
import h2.R0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import k2.C2594d;
import k3.C2616a;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import l2.C2649I;
import l2.C2657f;
import t3.s;
import w3.C2865c0;
import w3.C2908y0;
import w3.O;
import w3.X;
import z2.C2940B;
import z2.F;
import z3.C2973f;
import z3.D;

public final class SearchActivity extends C1598a {

    /* renamed from: R  reason: collision with root package name */
    public static final b f14513R = new b((C2633k) null);

    /* renamed from: K  reason: collision with root package name */
    private final C2223l f14514K = m.b(new C0903u5(this));

    /* renamed from: L  reason: collision with root package name */
    private final C2223l f14515L = new ViewModelLazy(M.b(O.class), new j(this), new i(this), new k((C2616a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public C2908y0 f14516M;
    /* access modifiers changed from: private */

    /* renamed from: N  reason: collision with root package name */
    public E f14517N;
    /* access modifiers changed from: private */

    /* renamed from: O  reason: collision with root package name */
    public a f14518O;
    /* access modifiers changed from: private */

    /* renamed from: P  reason: collision with root package name */
    public boolean f14519P = true;

    /* renamed from: Q  reason: collision with root package name */
    private final ActivityResultLauncher f14520Q;

    private final class a extends ArrayAdapter implements Filterable {

        /* renamed from: a  reason: collision with root package name */
        private final LayoutInflater f14521a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SearchActivity f14522b;

        /* renamed from: com.uptodown.activities.SearchActivity$a$a  reason: collision with other inner class name */
        public static final class C0136a extends Filter {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ SearchActivity f14523a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ a f14524b;

            C0136a(SearchActivity searchActivity, a aVar) {
                this.f14523a = searchActivity;
                this.f14524b = aVar;
            }

            public CharSequence convertResultToString(Object obj) {
                t.e(obj, "resultValue");
                String a5 = ((C2649I) obj).a();
                t.b(a5);
                return a5;
            }

            /* access modifiers changed from: protected */
            public Filter.FilterResults performFiltering(CharSequence charSequence) {
                t.e(charSequence, "charSequence");
                C2940B.a aVar = C2940B.f26458v;
                Context applicationContext = this.f14523a.getApplicationContext();
                t.d(applicationContext, "getApplicationContext(...)");
                C2940B a5 = aVar.a(applicationContext);
                a5.a();
                ArrayList C02 = a5.C0();
                a5.m();
                if (charSequence.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    int size = C02.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        String a6 = ((C2649I) C02.get(i5)).a();
                        if (a6 != null && s.V(a6, charSequence, false, 2, (Object) null)) {
                            arrayList.add(C02.get(i5));
                        }
                    }
                    C02 = arrayList;
                }
                Filter.FilterResults filterResults = new Filter.FilterResults();
                filterResults.values = C02;
                filterResults.count = C02.size();
                return filterResults;
            }

            /* access modifiers changed from: protected */
            public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                t.e(charSequence, "charSequence");
                t.e(filterResults, "filterResults");
                this.f14524b.clear();
                Object obj = filterResults.values;
                t.c(obj, "null cannot be cast to non-null type kotlin.collections.List<*>");
                for (C2649I add : (List) obj) {
                    this.f14524b.add(add);
                }
                if (filterResults.count > 0) {
                    a o32 = this.f14523a.f14518O;
                    t.b(o32);
                    o32.notifyDataSetChanged();
                    return;
                }
                a o33 = this.f14523a.f14518O;
                t.b(o33);
                o33.notifyDataSetInvalidated();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SearchActivity searchActivity, Context context) {
            super(context, -1);
            t.e(context, "context");
            this.f14522b = searchActivity;
            LayoutInflater from = LayoutInflater.from(context);
            t.d(from, "from(...)");
            this.f14521a = from;
        }

        /* access modifiers changed from: private */
        public static final void b(SearchActivity searchActivity, View view) {
            t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
            if (UptodownApp.f13477F.Z()) {
                Object tag = view.getTag();
                t.c(tag, "null cannot be cast to non-null type kotlin.String");
                C2940B.a aVar = C2940B.f26458v;
                Context applicationContext = searchActivity.getApplicationContext();
                t.d(applicationContext, "getApplicationContext(...)");
                C2940B a5 = aVar.a(applicationContext);
                a5.a();
                int L4 = a5.L((String) tag);
                a5.m();
                if (L4 > 0) {
                    a o32 = searchActivity.f14518O;
                    t.b(o32);
                    o32.getFilter().filter(searchActivity.y3().f22621b.f22631b.getText().toString());
                }
            }
        }

        public Filter getFilter() {
            return new C0136a(this.f14522b, this);
        }

        public View getView(int i5, View view, ViewGroup viewGroup) {
            LinearLayout linearLayout;
            t.e(viewGroup, "parent");
            C2649I i6 = (C2649I) getItem(i5);
            if (i6 != null) {
                if (view != null) {
                    linearLayout = (LinearLayout) view;
                } else {
                    View inflate = this.f14521a.inflate(R.layout.recent_search_item, viewGroup, false);
                    t.c(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
                    linearLayout = (LinearLayout) inflate;
                }
                TextView textView = (TextView) linearLayout.findViewById(R.id.tv_query_recent_search_item);
                ImageView imageView = (ImageView) linearLayout.findViewById(R.id.iv_delete_recent_search_item);
                imageView.setTag(i6.a());
                imageView.setOnClickListener(new N(this.f14522b));
                textView.setTypeface(S1.k.f32g.x());
                textView.setText(i6.a());
                return linearLayout;
            }
            View inflate2 = this.f14521a.inflate(R.layout.recent_search_item, viewGroup, false);
            t.c(inflate2, "null cannot be cast to non-null type android.widget.LinearLayout");
            return (LinearLayout) inflate2;
        }
    }

    public static final class b {
        public /* synthetic */ b(C2633k kVar) {
            this();
        }

        private b() {
        }
    }

    public static final class c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SearchActivity f14525a;

        public c(SearchActivity searchActivity) {
            this.f14525a = searchActivity;
        }

        public void afterTextChanged(Editable editable) {
            String t32 = this.f14525a.M3(String.valueOf(editable));
            int length = t32.length();
            if (2 > length || length >= 40) {
                if (this.f14525a.f14516M != null) {
                    C2908y0 q32 = this.f14525a.f14516M;
                    t.b(q32);
                    C2908y0.a.a(q32, (CancellationException) null, 1, (Object) null);
                }
                if (this.f14525a.f14517N != null) {
                    E n32 = this.f14525a.f14517N;
                    t.b(n32);
                    n32.c(new ArrayList());
                }
            } else {
                this.f14525a.N3(t32, 2);
            }
            if (String.valueOf(editable).length() > 0) {
                this.f14525a.y3().f22621b.f22633d.setVisibility(0);
                this.f14525a.y3().f22621b.f22634e.setVisibility(8);
                return;
            }
            E n33 = this.f14525a.f14517N;
            if (n33 != null) {
                n33.c(new ArrayList());
            }
            this.f14525a.y3().f22621b.f22633d.setVisibility(8);
            this.f14525a.y3().f22621b.f22634e.setVisibility(0);
        }

        public void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        }

        public void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        }
    }

    public static final class d extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f14526a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SearchActivity f14527b;

        d(LinearLayoutManager linearLayoutManager, SearchActivity searchActivity) {
            this.f14526a = linearLayoutManager;
            this.f14527b = searchActivity;
        }

        public void onScrolled(RecyclerView recyclerView, int i5, int i6) {
            t.e(recyclerView, "recyclerView");
            if (i6 > 0) {
                int childCount = this.f14526a.getChildCount();
                int itemCount = this.f14526a.getItemCount();
                int findFirstVisibleItemPosition = this.f14526a.findFirstVisibleItemPosition();
                SearchActivity searchActivity = this.f14527b;
                String t32 = searchActivity.M3(searchActivity.y3().f22621b.f22631b.getText().toString());
                if (t32.length() > 2 && childCount + findFirstVisibleItemPosition >= itemCount && !this.f14527b.z3().d()) {
                    this.f14527b.P3(t32);
                }
            }
        }
    }

    public static final class e implements C2594d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SearchActivity f14528a;

        e(SearchActivity searchActivity) {
            this.f14528a = searchActivity;
        }

        public void b(C2657f fVar) {
            t.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            if (UptodownApp.f13477F.Z()) {
                this.f14528a.H2(fVar.e());
            }
        }
    }

    static final class f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14529a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SearchActivity f14530b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ SearchActivity f14531a;

            a(SearchActivity searchActivity) {
                this.f14531a = searchActivity;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:5:0x0022, code lost:
                if (r4.b().size() == 0) goto L_0x0024;
             */
            /* renamed from: b */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(z2.O r4, b3.C2308e r5) {
                /*
                    r3 = this;
                    z2.O$a r5 = z2.O.a.f26507a
                    boolean r5 = kotlin.jvm.internal.t.a(r4, r5)
                    r0 = 0
                    if (r5 == 0) goto L_0x0031
                    com.uptodown.activities.SearchActivity r4 = r3.f14531a
                    R1.E r4 = r4.f14517N
                    if (r4 == 0) goto L_0x0024
                    com.uptodown.activities.SearchActivity r4 = r3.f14531a
                    R1.E r4 = r4.f14517N
                    kotlin.jvm.internal.t.b(r4)
                    java.util.ArrayList r4 = r4.b()
                    int r4 = r4.size()
                    if (r4 != 0) goto L_0x0177
                L_0x0024:
                    com.uptodown.activities.SearchActivity r4 = r3.f14531a
                    h2.R0 r4 = r4.y3()
                    android.view.View r4 = r4.f22622c
                    r4.setVisibility(r0)
                    goto L_0x0177
                L_0x0031:
                    boolean r5 = r4 instanceof z2.O.c
                    if (r5 == 0) goto L_0x016f
                    com.uptodown.activities.SearchActivity r5 = r3.f14531a
                    z2.O$c r4 = (z2.O.c) r4
                    java.lang.Object r1 = r4.a()
                    com.uptodown.activities.O$a r1 = (com.uptodown.activities.O.a) r1
                    boolean r1 = r1.b()
                    r5.f14519P = r1
                    com.uptodown.activities.SearchActivity r5 = r3.f14531a
                    R1.E r5 = r5.f14517N
                    r1 = 8
                    if (r5 != 0) goto L_0x0072
                    com.uptodown.activities.SearchActivity r5 = r3.f14531a
                    java.lang.Object r4 = r4.a()
                    com.uptodown.activities.O$a r4 = (com.uptodown.activities.O.a) r4
                    java.util.ArrayList r4 = r4.c()
                    r5.K3(r4)
                    com.uptodown.activities.SearchActivity r4 = r3.f14531a
                    h2.R0 r4 = r4.y3()
                    androidx.recyclerview.widget.RecyclerView r4 = r4.f22623d
                    com.uptodown.activities.SearchActivity r5 = r3.f14531a
                    R1.E r5 = r5.f14517N
                    r4.setAdapter(r5)
                    goto L_0x014f
                L_0x0072:
                    com.uptodown.activities.SearchActivity r5 = r3.f14531a
                    h2.R0 r5 = r5.y3()
                    h2.S0 r5 = r5.f22621b
                    com.uptodown.views.InstantAutoCompleteTextView r5 = r5.f22631b
                    android.text.Editable r5 = r5.getText()
                    java.lang.String r5 = r5.toString()
                    int r5 = r5.length()
                    if (r5 <= 0) goto L_0x013e
                    com.uptodown.activities.SearchActivity r5 = r3.f14531a
                    h2.R0 r5 = r5.y3()
                    androidx.recyclerview.widget.RecyclerView r5 = r5.f22623d
                    androidx.recyclerview.widget.RecyclerView$Adapter r5 = r5.getAdapter()
                    if (r5 != 0) goto L_0x00a9
                    com.uptodown.activities.SearchActivity r5 = r3.f14531a
                    h2.R0 r5 = r5.y3()
                    androidx.recyclerview.widget.RecyclerView r5 = r5.f22623d
                    com.uptodown.activities.SearchActivity r2 = r3.f14531a
                    R1.E r2 = r2.f14517N
                    r5.setAdapter(r2)
                L_0x00a9:
                    java.lang.Object r5 = r4.a()
                    com.uptodown.activities.O$a r5 = (com.uptodown.activities.O.a) r5
                    boolean r5 = r5.a()
                    if (r5 == 0) goto L_0x00d7
                    com.uptodown.activities.SearchActivity r5 = r3.f14531a
                    R1.E r5 = r5.f14517N
                    kotlin.jvm.internal.t.b(r5)
                    java.lang.Object r4 = r4.a()
                    com.uptodown.activities.O$a r4 = (com.uptodown.activities.O.a) r4
                    java.util.ArrayList r4 = r4.c()
                    r5.c(r4)
                    com.uptodown.activities.SearchActivity r4 = r3.f14531a
                    h2.R0 r4 = r4.y3()
                    androidx.recyclerview.widget.RecyclerView r4 = r4.f22623d
                    r4.scrollToPosition(r0)
                    goto L_0x00fd
                L_0x00d7:
                    java.lang.Object r5 = r4.a()
                    com.uptodown.activities.O$a r5 = (com.uptodown.activities.O.a) r5
                    java.util.ArrayList r5 = r5.c()
                    int r5 = r5.size()
                    if (r5 <= 0) goto L_0x00fd
                    com.uptodown.activities.SearchActivity r5 = r3.f14531a
                    R1.E r5 = r5.f14517N
                    kotlin.jvm.internal.t.b(r5)
                    java.lang.Object r4 = r4.a()
                    com.uptodown.activities.O$a r4 = (com.uptodown.activities.O.a) r4
                    java.util.ArrayList r4 = r4.c()
                    r5.a(r4)
                L_0x00fd:
                    com.uptodown.activities.SearchActivity r4 = r3.f14531a
                    R1.E r4 = r4.f14517N
                    kotlin.jvm.internal.t.b(r4)
                    java.util.ArrayList r4 = r4.b()
                    int r4 = r4.size()
                    if (r4 != 0) goto L_0x0127
                    com.uptodown.activities.SearchActivity r4 = r3.f14531a
                    h2.R0 r4 = r4.y3()
                    android.widget.TextView r4 = r4.f22624e
                    r4.setVisibility(r0)
                    com.uptodown.activities.SearchActivity r4 = r3.f14531a
                    h2.R0 r4 = r4.y3()
                    androidx.recyclerview.widget.RecyclerView r4 = r4.f22623d
                    r4.setVisibility(r1)
                    goto L_0x014f
                L_0x0127:
                    com.uptodown.activities.SearchActivity r4 = r3.f14531a
                    h2.R0 r4 = r4.y3()
                    android.widget.TextView r4 = r4.f22624e
                    r4.setVisibility(r1)
                    com.uptodown.activities.SearchActivity r4 = r3.f14531a
                    h2.R0 r4 = r4.y3()
                    androidx.recyclerview.widget.RecyclerView r4 = r4.f22623d
                    r4.setVisibility(r0)
                    goto L_0x014f
                L_0x013e:
                    com.uptodown.activities.SearchActivity r4 = r3.f14531a
                    R1.E r4 = r4.f14517N
                    kotlin.jvm.internal.t.b(r4)
                    java.util.ArrayList r5 = new java.util.ArrayList
                    r5.<init>()
                    r4.c(r5)
                L_0x014f:
                    com.uptodown.activities.SearchActivity r4 = r3.f14531a
                    com.uptodown.activities.O r4 = r4.z3()
                    r4.e(r0)
                    com.uptodown.activities.SearchActivity r4 = r3.f14531a
                    R1.E r4 = r4.f14517N
                    if (r4 == 0) goto L_0x0163
                    r4.d(r0)
                L_0x0163:
                    com.uptodown.activities.SearchActivity r4 = r3.f14531a
                    h2.R0 r4 = r4.y3()
                    android.view.View r4 = r4.f22622c
                    r4.setVisibility(r1)
                    goto L_0x0177
                L_0x016f:
                    z2.O$b r5 = z2.O.b.f26508a
                    boolean r4 = kotlin.jvm.internal.t.a(r4, r5)
                    if (r4 == 0) goto L_0x017a
                L_0x0177:
                    W2.J r4 = W2.J.f19942a
                    return r4
                L_0x017a:
                    W2.q r4 = new W2.q
                    r4.<init>()
                    throw r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.SearchActivity.f.a.emit(z2.O, b3.e):java.lang.Object");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(SearchActivity searchActivity, C2308e eVar) {
            super(2, eVar);
            this.f14530b = searchActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new f(this.f14530b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14529a;
            if (i5 == 0) {
                u.b(obj);
                D c5 = this.f14530b.z3().c();
                a aVar = new a(this.f14530b);
                this.f14529a = 1;
                if (c5.collect(aVar, this) == f5) {
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
            return ((f) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class g extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14532a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f14533b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ SearchActivity f14534c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f14535d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(int i5, SearchActivity searchActivity, String str, C2308e eVar) {
            super(2, eVar);
            this.f14533b = i5;
            this.f14534c = searchActivity;
            this.f14535d = str;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new g(this.f14533b, this.f14534c, this.f14535d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14532a;
            if (i5 == 0) {
                u.b(obj);
                this.f14532a = 1;
                if (X.b(((long) this.f14533b) * 1000, this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            O r32 = this.f14534c.z3();
            SearchActivity searchActivity = this.f14534c;
            r32.b(searchActivity, searchActivity.M3(this.f14535d), 0);
            return J.f19942a;
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((g) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class h extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14536a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SearchActivity f14537b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f14538c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(SearchActivity searchActivity, String str, C2308e eVar) {
            super(2, eVar);
            this.f14537b = searchActivity;
            this.f14538c = str;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new h(this.f14537b, this.f14538c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f14536a == 0) {
                u.b(obj);
                O r32 = this.f14537b.z3();
                SearchActivity searchActivity = this.f14537b;
                String t32 = searchActivity.M3(this.f14538c);
                E n32 = this.f14537b.f14517N;
                t.b(n32);
                r32.b(searchActivity, t32, n32.getItemCount());
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((h) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class i extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14539a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(ComponentActivity componentActivity) {
            super(0);
            this.f14539a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f14539a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class j extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14540a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(ComponentActivity componentActivity) {
            super(0);
            this.f14540a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f14540a.getViewModelStore();
        }
    }

    public static final class k extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2616a f14541a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14542b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(C2616a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f14541a = aVar;
            this.f14542b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                k3.a r0 = r1.f14541a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f14542b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.SearchActivity.k.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    public SearchActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C0911v5(this));
        t.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f14520Q = registerForActivityResult;
    }

    private final void A3(Intent intent) {
        String stringExtra;
        if (t.a("android.intent.action.SEARCH", intent.getAction()) && (stringExtra = intent.getStringExtra(MBridgeConstans.DYNAMIC_VIEW_WX_QUERY)) != null) {
            O3(this, stringExtra, 0, 2, (Object) null);
        }
    }

    private final void B3() {
        Object systemService = getSystemService("input_method");
        t.c(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(y3().f22621b.f22631b.getWindowToken(), 0);
    }

    private final void C3() {
        setContentView((View) y3().getRoot());
        ImageView imageView = (ImageView) findViewById(R.id.iv_back_search_bar);
        if (imageView != null) {
            imageView.setOnClickListener(new C0919w5(this));
        }
        y3().f22621b.f22633d.setOnClickListener(new C0927x5(this));
        y3().f22621b.f22634e.setOnClickListener(new C0935y5(this));
        y3().f22621b.f22631b.requestFocus();
        InstantAutoCompleteTextView instantAutoCompleteTextView = y3().f22621b.f22631b;
        k.a aVar = S1.k.f32g;
        instantAutoCompleteTextView.setTypeface(aVar.x());
        y3().f22621b.f22631b.setOnEditorActionListener(new C0943z5(this));
        this.f14518O = new a(this, this);
        y3().f22621b.f22631b.setAdapter(this.f14518O);
        y3().f22621b.f22631b.setOnItemClickListener(new A5(this));
        InstantAutoCompleteTextView instantAutoCompleteTextView2 = y3().f22621b.f22631b;
        t.d(instantAutoCompleteTextView2, "actvSearchBar");
        instantAutoCompleteTextView2.addTextChangedListener(new c(this));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        y3().f22623d.setLayoutManager(linearLayoutManager);
        y3().f22623d.setItemAnimator(new DefaultItemAnimator());
        y3().f22623d.addOnScrollListener(new d(linearLayoutManager, this));
        RecyclerView recyclerView = y3().f22623d;
        t.d(recyclerView, "rvSearchActivity");
        hideKeyboardOnScroll(recyclerView);
        y3().f22622c.setOnClickListener(new B5());
        y3().f22624e.setTypeface(aVar.x());
    }

    /* access modifiers changed from: private */
    public static final void D3(SearchActivity searchActivity, View view) {
        if (UptodownApp.f13477F.Z()) {
            searchActivity.finish();
        }
    }

    /* access modifiers changed from: private */
    public static final void E3(SearchActivity searchActivity, View view) {
        if (UptodownApp.f13477F.Z()) {
            searchActivity.y3().f22621b.f22631b.setText("");
        }
    }

    /* access modifiers changed from: private */
    public static final void F3(SearchActivity searchActivity, View view) {
        if (UptodownApp.f13477F.Z()) {
            searchActivity.J3();
        }
    }

    /* access modifiers changed from: private */
    public static final boolean G3(SearchActivity searchActivity, TextView textView, int i5, KeyEvent keyEvent) {
        t.e(textView, "v");
        if (i5 != 3) {
            return false;
        }
        String obj = textView.getText().toString();
        if (obj.length() <= 0) {
            return true;
        }
        searchActivity.B3();
        O3(searchActivity, obj, 0, 2, (Object) null);
        Bundle bundle = new Bundle();
        bundle.putString(MimeTypes.BASE_TYPE_TEXT, obj);
        F s22 = searchActivity.s2();
        if (s22 != null) {
            s22.d("search", bundle);
        }
        searchActivity.Q3(obj);
        searchActivity.y3().f22621b.f22631b.dismissDropDown();
        return true;
    }

    /* access modifiers changed from: private */
    public static final void H3(SearchActivity searchActivity, AdapterView adapterView, View view, int i5, long j5) {
        t.e(adapterView, "adapterView");
        if (UptodownApp.f13477F.Z()) {
            Object itemAtPosition = adapterView.getItemAtPosition(i5);
            t.c(itemAtPosition, "null cannot be cast to non-null type com.uptodown.models.RecentSearch");
            C2649I i6 = (C2649I) itemAtPosition;
            if (i6.a() != null) {
                String a5 = i6.a();
                t.b(a5);
                O3(searchActivity, a5, 0, 2, (Object) null);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void I3(View view) {
    }

    private final void J3() {
        try {
            this.f14520Q.launch(new Intent("android.speech.action.RECOGNIZE_SPEECH"));
        } catch (ActivityNotFoundException e5) {
            e5.printStackTrace();
            String string = getString(R.string.feature_not_supported);
            t.d(string, "getString(...)");
            u0(string);
        }
    }

    /* access modifiers changed from: private */
    public final void K3(ArrayList arrayList) {
        this.f14517N = new E(arrayList, new e(this));
    }

    private final String L3(String str) {
        return new t3.p("[^a-zA-Z0-9 ]+").h(str, "");
    }

    /* access modifiers changed from: private */
    public final String M3(String str) {
        t.b(str);
        return s.L(str, "/", "", false, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void N3(String str, int i5) {
        C2908y0 y0Var = this.f14516M;
        if (y0Var != null) {
            t.b(y0Var);
            C2908y0.a.a(y0Var, (CancellationException) null, 1, (Object) null);
        }
        this.f14516M = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), (C2312i) null, (O) null, new g(i5, this, str, (C2308e) null), 3, (Object) null);
    }

    static /* synthetic */ void O3(SearchActivity searchActivity, String str, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i5 = 0;
        }
        searchActivity.N3(str, i5);
    }

    /* access modifiers changed from: private */
    public final void P3(String str) {
        if (this.f14519P) {
            C2908y0 y0Var = this.f14516M;
            if (y0Var != null) {
                t.b(y0Var);
                if (!y0Var.C()) {
                    return;
                }
            }
            if (this.f14517N != null) {
                z3().e(true);
                E e5 = this.f14517N;
                if (e5 != null) {
                    e5.d(true);
                }
                this.f14516M = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), (C2312i) null, (O) null, new h(this, str, (C2308e) null), 3, (Object) null);
            }
        }
    }

    private final void Q3(String str) {
        C2649I i5 = new C2649I();
        i5.c(L3(str));
        i5.d(String.valueOf(System.currentTimeMillis()));
        C2940B a5 = C2940B.f26458v.a(this);
        a5.a();
        Iterator it = a5.C0().iterator();
        t.d(it, "iterator(...)");
        while (true) {
            if (!it.hasNext()) {
                a5.Z0(i5);
                break;
            }
            Object next = it.next();
            t.d(next, "next(...)");
            if (s.E(((C2649I) next).a(), str, true)) {
                break;
            }
        }
        a5.m();
    }

    /* access modifiers changed from: private */
    public static final void R3(SearchActivity searchActivity, ActivityResult activityResult) {
        String str;
        if (activityResult.getResultCode() == -1 && activityResult.getData() != null) {
            Intent data = activityResult.getData();
            t.b(data);
            ArrayList<String> stringArrayListExtra = data.getStringArrayListExtra("android.speech.extra.RESULTS");
            if (stringArrayListExtra != null) {
                str = stringArrayListExtra.get(0);
            } else {
                str = null;
            }
            searchActivity.y3().f22621b.f22631b.setText(str);
        }
    }

    /* access modifiers changed from: private */
    public static final R0 x3(SearchActivity searchActivity) {
        return R0.c(searchActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final R0 y3() {
        return (R0) this.f14514K.getValue();
    }

    /* access modifiers changed from: private */
    public final O z3() {
        return (O) this.f14515L.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C3();
        a aVar = this.f14518O;
        t.b(aVar);
        aVar.getFilter().filter(y3().f22621b.f22631b.getText().toString());
        Intent intent = getIntent();
        if (intent != null) {
            A3(intent);
        }
        y3().f22622c.setVisibility(8);
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (O) null, new f(this, (C2308e) null), 2, (Object) null);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        t.e(menu, "menu");
        MenuInflater menuInflater = getMenuInflater();
        t.d(menuInflater, "getMenuInflater(...)");
        menuInflater.inflate(R.menu.menu_search, menu);
        Object systemService = getSystemService("search");
        t.c(systemService, "null cannot be cast to non-null type android.app.SearchManager");
        SearchManager searchManager = (SearchManager) systemService;
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        if (searchView == null) {
            return true;
        }
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        t.e(intent, "intent");
        super.onNewIntent(intent);
        A3(intent);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        B3();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        InstantAutoCompleteTextView instantAutoCompleteTextView = y3().f22621b.f22631b;
        t.d(instantAutoCompleteTextView, "actvSearchBar");
        showKeyboard(instantAutoCompleteTextView);
    }

    public boolean onSearchRequested() {
        startSearch((String) null, false, new Bundle(), false);
        return true;
    }
}
