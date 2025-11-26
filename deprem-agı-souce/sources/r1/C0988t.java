package R1;

import C2.C2015f0;
import C2.C2022h1;
import C2.C2029k;
import C2.U0;
import W2.J;
import X2.C2250q;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import b2.C2291k;
import com.mbridge.msdk.MBridgeConstans;
import com.squareup.picasso.s;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import h2.C2434q0;
import h2.C2435r0;
import h2.C2437s0;
import h2.C2439t0;
import h2.W;
import java.util.ArrayList;
import java.util.Iterator;
import k2.C2591a;
import k2.C2594d;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2657f;
import z2.C2954m;

/* renamed from: R1.t  reason: case insensitive filesystem */
public final class C0988t extends RecyclerView.Adapter {

    /* renamed from: e  reason: collision with root package name */
    public static final a f4287e = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private C2594d f4288a;

    /* renamed from: b  reason: collision with root package name */
    private String f4289b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList f4290c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private boolean f4291d;

    /* renamed from: R1.t$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    /* renamed from: R1.t$b */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public Object f4292a;

        /* renamed from: b  reason: collision with root package name */
        private int f4293b;

        public final Object a() {
            Object obj = this.f4292a;
            if (obj != null) {
                return obj;
            }
            t.w("item");
            return J.f19942a;
        }

        public final int b() {
            return this.f4293b;
        }

        public final void c(Object obj) {
            t.e(obj, "<set-?>");
            this.f4292a = obj;
        }

        public final void d(int i5) {
            this.f4293b = i5;
        }
    }

    /* renamed from: R1.t$c */
    public final class c extends RecyclerView.Adapter {

        /* renamed from: a  reason: collision with root package name */
        private C2594d f4294a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public Context f4295b;

        /* renamed from: c  reason: collision with root package name */
        private ArrayList f4296c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C0988t f4297d;

        /* renamed from: R1.t$c$a */
        public final class a extends C2029k {

            /* renamed from: b  reason: collision with root package name */
            private final W f4298b;

            /* renamed from: c  reason: collision with root package name */
            private C2594d f4299c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ c f4300d;

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public a(R1.C0988t.c r2, h2.W r3, k2.C2594d r4, android.content.Context r5) {
                /*
                    r1 = this;
                    java.lang.String r0 = "binding"
                    kotlin.jvm.internal.t.e(r3, r0)
                    java.lang.String r0 = "listener"
                    kotlin.jvm.internal.t.e(r4, r0)
                    java.lang.String r0 = "context"
                    kotlin.jvm.internal.t.e(r5, r0)
                    r1.f4300d = r2
                    android.widget.RelativeLayout r2 = r3.getRoot()
                    java.lang.String r0 = "getRoot(...)"
                    kotlin.jvm.internal.t.d(r2, r0)
                    r1.<init>(r2, r5)
                    r1.f4298b = r3
                    r1.f4299c = r4
                    android.widget.TextView r2 = r3.f22678j
                    S1.k$a r4 = S1.k.f32g
                    android.graphics.Typeface r5 = r4.w()
                    r2.setTypeface(r5)
                    android.widget.TextView r2 = r3.f22676h
                    android.graphics.Typeface r5 = r4.x()
                    r2.setTypeface(r5)
                    android.widget.TextView r2 = r3.f22681m
                    android.graphics.Typeface r3 = r4.x()
                    r2.setTypeface(r3)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: R1.C0988t.c.a.<init>(R1.t$c, h2.W, k2.d, android.content.Context):void");
            }

            public final void l(C2657f fVar, boolean z4) {
                t.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
                int dimension = (int) this.f4300d.f4295b.getResources().getDimension(R.dimen.margin_m);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                if (z4) {
                    layoutParams.setMargins(dimension, 0, dimension, dimension);
                } else {
                    layoutParams.setMargins(dimension, 0, 0, dimension);
                }
                this.itemView.setLayoutParams(layoutParams);
                String z5 = fVar.z();
                if (!(z5 == null || z5.length() == 0)) {
                    s.h().l(fVar.D()).n(UptodownApp.f13477F.f0(this.f4300d.f4295b)).a().f().l(R.drawable.shape_bg_placeholder).i(this.f4298b.f22670b);
                }
                View view = this.itemView;
                t.d(view, "itemView");
                c(view, this.f4299c, fVar);
                TextView textView = this.f4298b.f22678j;
                t.d(textView, "tvNameHomeCardFeaturedItem");
                TextView textView2 = this.f4298b.f22676h;
                t.d(textView2, "tvDescHomeCardFeaturedItem");
                i(fVar, textView, textView2);
                String S4 = fVar.S();
                TextView textView3 = this.f4298b.f22681m;
                t.d(textView3, "tvStatusHomeCardFeaturedItem");
                TextView textView4 = this.f4298b.f22676h;
                t.d(textView4, "tvDescHomeCardFeaturedItem");
                g(S4, textView3, textView4);
                ImageView imageView = this.f4298b.f22671c;
                t.d(imageView, "ivLogoHomeCardFeaturedItem");
                h(imageView, fVar.H());
            }
        }

        public c(C0988t tVar, C2594d dVar, Context context) {
            t.e(dVar, "listener");
            t.e(context, "context");
            this.f4297d = tVar;
            this.f4294a = dVar;
            this.f4295b = context;
        }

        public final ArrayList b() {
            return this.f4296c;
        }

        /* renamed from: c */
        public void onBindViewHolder(a aVar, int i5) {
            t.e(aVar, "holder");
            if (t.a(this.f4296c.get(i5), C2250q.X(this.f4296c))) {
                Object obj = this.f4296c.get(i5);
                t.d(obj, "get(...)");
                aVar.l((C2657f) obj, true);
                return;
            }
            Object obj2 = this.f4296c.get(i5);
            t.d(obj2, "get(...)");
            aVar.l((C2657f) obj2, false);
        }

        /* renamed from: d */
        public a onCreateViewHolder(ViewGroup viewGroup, int i5) {
            t.e(viewGroup, "parent");
            W d5 = W.d(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            t.d(d5, "inflate(...)");
            return new a(this, d5, this.f4294a, this.f4295b);
        }

        public final void e(ArrayList arrayList) {
            t.e(arrayList, "carouselApps");
            this.f4296c = arrayList;
            notifyDataSetChanged();
        }

        public int getItemCount() {
            return this.f4296c.size();
        }
    }

    /* renamed from: R1.t$d */
    public final class d extends C2029k {

        /* renamed from: b  reason: collision with root package name */
        private final c f4301b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C0988t f4302c;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public d(R1.C0988t r4, h2.C2434q0 r5, k2.C2594d r6, android.content.Context r7, java.lang.String r8) {
            /*
                r3 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.t.e(r5, r0)
                java.lang.String r0 = "listener"
                kotlin.jvm.internal.t.e(r6, r0)
                java.lang.String r0 = "context"
                kotlin.jvm.internal.t.e(r7, r0)
                java.lang.String r0 = "organizationName"
                kotlin.jvm.internal.t.e(r8, r0)
                r3.f4302c = r4
                android.widget.LinearLayout r0 = r5.getRoot()
                java.lang.String r1 = "getRoot(...)"
                kotlin.jvm.internal.t.d(r0, r1)
                r3.<init>(r0, r7)
                R1.t$c r0 = new R1.t$c
                r0.<init>(r4, r6, r7)
                r3.f4301b = r0
                androidx.recyclerview.widget.RecyclerView r4 = r5.f23455b
                androidx.recyclerview.widget.LinearLayoutManager r6 = new androidx.recyclerview.widget.LinearLayoutManager
                android.view.View r1 = r3.itemView
                android.content.Context r1 = r1.getContext()
                r2 = 0
                r6.<init>(r1, r2, r2)
                r4.setLayoutManager(r6)
                androidx.recyclerview.widget.RecyclerView r4 = r5.f23455b
                r4.setAdapter(r0)
                android.widget.TextView r4 = r5.f23456c
                S1.k$a r6 = S1.k.f32g
                android.graphics.Typeface r6 = r6.w()
                r4.setTypeface(r6)
                android.widget.TextView r4 = r5.f23456c
                r5 = 1
                java.lang.Object[] r5 = new java.lang.Object[r5]
                r5[r2] = r8
                r6 = 2131952514(0x7f130382, float:1.9541473E38)
                java.lang.String r5 = r7.getString(r6, r5)
                r4.setText(r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: R1.C0988t.d.<init>(R1.t, h2.q0, k2.d, android.content.Context, java.lang.String):void");
        }

        public final void l(ArrayList arrayList) {
            t.e(arrayList, "carouselApps");
            this.f4301b.e(arrayList);
        }

        public final c m() {
            return this.f4301b;
        }
    }

    /* renamed from: R1.t$e */
    public final class e extends C2029k {

        /* renamed from: b  reason: collision with root package name */
        private final C2435r0 f4303b;

        /* renamed from: c  reason: collision with root package name */
        private C2594d f4304c;

        /* renamed from: d  reason: collision with root package name */
        private Context f4305d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ C0988t f4306e;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public e(R1.C0988t r2, h2.C2435r0 r3, k2.C2594d r4, android.content.Context r5) {
            /*
                r1 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.t.e(r3, r0)
                java.lang.String r0 = "listener"
                kotlin.jvm.internal.t.e(r4, r0)
                java.lang.String r0 = "context"
                kotlin.jvm.internal.t.e(r5, r0)
                r1.f4306e = r2
                android.widget.RelativeLayout r2 = r3.getRoot()
                java.lang.String r0 = "getRoot(...)"
                kotlin.jvm.internal.t.d(r2, r0)
                r1.<init>(r2, r5)
                r1.f4303b = r3
                r1.f4304c = r4
                r1.f4305d = r5
                android.widget.TextView r2 = r3.f23512n
                S1.k$a r4 = S1.k.f32g
                android.graphics.Typeface r5 = r4.w()
                r2.setTypeface(r5)
                android.widget.TextView r2 = r3.f23510l
                android.graphics.Typeface r5 = r4.w()
                r2.setTypeface(r5)
                android.widget.TextView r2 = r3.f23507i
                android.graphics.Typeface r5 = r4.x()
                r2.setTypeface(r5)
                android.widget.TextView r2 = r3.f23511m
                android.graphics.Typeface r5 = r4.x()
                r2.setTypeface(r5)
                android.widget.TextView r2 = r3.f23513o
                android.graphics.Typeface r5 = r4.x()
                r2.setTypeface(r5)
                android.widget.TextView r2 = r3.f23509k
                android.graphics.Typeface r5 = r4.x()
                r2.setTypeface(r5)
                android.widget.TextView r2 = r3.f23508j
                android.graphics.Typeface r5 = r4.w()
                r2.setTypeface(r5)
                android.widget.TextView r2 = r3.f23506h
                android.graphics.Typeface r5 = r4.x()
                r2.setTypeface(r5)
                android.widget.TextView r2 = r3.f23514p
                android.graphics.Typeface r3 = r4.x()
                r2.setTypeface(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: R1.C0988t.e.<init>(R1.t, h2.r0, k2.d, android.content.Context):void");
        }

        /* access modifiers changed from: private */
        public static final void n(e eVar, C2657f fVar, View view) {
            eVar.f4304c.b(fVar);
        }

        public final void m(C2657f fVar) {
            t.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            String z4 = fVar.z();
            if (z4 == null || z4.length() == 0) {
                this.f4303b.f23500b.setImageDrawable(ContextCompat.getDrawable(this.f4305d, R.drawable.shape_bg_placeholder));
            } else {
                s.h().l(fVar.z()).n(UptodownApp.f13477F.f0(this.f4305d)).i(this.f4303b.f23500b);
            }
            View view = this.itemView;
            t.d(view, "itemView");
            c(view, this.f4304c, fVar);
            TextView textView = this.f4303b.f23510l;
            t.d(textView, "tvTopAppNameOrganization");
            TextView textView2 = this.f4303b.f23507i;
            t.d(textView2, "tvTopAppDescOrganization");
            i(fVar, textView, textView2);
            this.f4303b.f23513o.setText(String.valueOf(((double) fVar.a0()) / 10.0d));
            this.f4303b.f23509k.setText(this.f4305d.getString(R.string.downloads_counter_multiple, new Object[]{new C2291k().b((long) fVar.q())}));
            ImageView imageView = this.f4303b.f23501c;
            t.d(imageView, "ivTopAppLogoOrganization");
            h(imageView, fVar.H());
            if (!new C2954m().v(fVar.S(), this.f4305d)) {
                this.f4303b.f23508j.setOnClickListener(new C0989u(this, fVar));
            } else {
                this.f4303b.f23508j.setVisibility(8);
            }
            ProgressBar progressBar = this.f4303b.f23504f;
            t.d(progressBar, "pbProgressLogoOrganization");
            ImageView imageView2 = this.f4303b.f23501c;
            t.d(imageView2, "ivTopAppLogoOrganization");
            TextView textView3 = this.f4303b.f23507i;
            t.d(textView3, "tvTopAppDescOrganization");
            TextView textView4 = this.f4303b.f23506h;
            t.d(textView4, "tvProgressTopOrganization");
            C2435r0 r0Var = this.f4303b;
            TextView textView5 = r0Var.f23511m;
            LinearLayout linearLayout = r0Var.f23502d;
            t.d(linearLayout, "llProgressTopOrganization");
            e(fVar, progressBar, imageView2, textView3, textView4, textView5, linearLayout);
        }
    }

    /* renamed from: R1.t$f */
    public final class f extends RecyclerView.Adapter {

        /* renamed from: a  reason: collision with root package name */
        private C2594d f4307a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public Context f4308b;

        /* renamed from: c  reason: collision with root package name */
        private ArrayList f4309c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C0988t f4310d;

        /* renamed from: R1.t$f$a */
        public final class a extends C2029k {

            /* renamed from: b  reason: collision with root package name */
            private final C2439t0 f4311b;

            /* renamed from: c  reason: collision with root package name */
            private C2594d f4312c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ f f4313d;

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public a(R1.C0988t.f r2, h2.C2439t0 r3, k2.C2594d r4, android.content.Context r5) {
                /*
                    r1 = this;
                    java.lang.String r0 = "binding"
                    kotlin.jvm.internal.t.e(r3, r0)
                    java.lang.String r0 = "listener"
                    kotlin.jvm.internal.t.e(r4, r0)
                    java.lang.String r0 = "context"
                    kotlin.jvm.internal.t.e(r5, r0)
                    r1.f4313d = r2
                    android.widget.RelativeLayout r2 = r3.getRoot()
                    java.lang.String r0 = "getRoot(...)"
                    kotlin.jvm.internal.t.d(r2, r0)
                    r1.<init>(r2, r5)
                    r1.f4311b = r3
                    r1.f4312c = r4
                    android.widget.TextView r2 = r3.f23558f
                    S1.k$a r4 = S1.k.f32g
                    android.graphics.Typeface r5 = r4.w()
                    r2.setTypeface(r5)
                    android.widget.TextView r2 = r3.f23556d
                    android.graphics.Typeface r5 = r4.x()
                    r2.setTypeface(r5)
                    android.widget.TextView r2 = r3.f23559g
                    android.graphics.Typeface r5 = r4.w()
                    r2.setTypeface(r5)
                    android.widget.TextView r2 = r3.f23560h
                    android.graphics.Typeface r5 = r4.x()
                    r2.setTypeface(r5)
                    android.widget.TextView r2 = r3.f23557e
                    android.graphics.Typeface r3 = r4.x()
                    r2.setTypeface(r3)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: R1.C0988t.f.a.<init>(R1.t$f, h2.t0, k2.d, android.content.Context):void");
            }

            public final void l(C2657f fVar) {
                t.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
                View view = this.itemView;
                t.d(view, "itemView");
                c(view, this.f4312c, fVar);
                TextView textView = this.f4311b.f23558f;
                t.d(textView, "tvTopAppNameOrganization");
                TextView textView2 = this.f4311b.f23556d;
                t.d(textView2, "tvTopAppDescOrganization");
                i(fVar, textView, textView2);
                String S4 = fVar.S();
                TextView textView3 = this.f4311b.f23559g;
                t.d(textView3, "tvTopAppStatusOrganization");
                TextView textView4 = this.f4311b.f23556d;
                t.d(textView4, "tvTopAppDescOrganization");
                g(S4, textView3, textView4);
                ImageView imageView = this.f4311b.f23554b;
                t.d(imageView, "ivTopAppLogoOrganization");
                h(imageView, fVar.G());
                this.f4311b.f23560h.setText(String.valueOf(((double) fVar.a0()) / 10.0d));
                this.f4311b.f23557e.setText(this.f4313d.f4308b.getString(R.string.downloads_counter_multiple, new Object[]{new C2291k().b((long) fVar.q())}));
            }
        }

        public f(C0988t tVar, C2594d dVar, Context context) {
            t.e(dVar, "listener");
            t.e(context, "context");
            this.f4310d = tVar;
            this.f4307a = dVar;
            this.f4308b = context;
        }

        public final ArrayList b() {
            return this.f4309c;
        }

        /* renamed from: c */
        public void onBindViewHolder(a aVar, int i5) {
            t.e(aVar, "holder");
            Object obj = this.f4309c.get(i5);
            t.d(obj, "get(...)");
            aVar.l((C2657f) obj);
        }

        /* renamed from: d */
        public a onCreateViewHolder(ViewGroup viewGroup, int i5) {
            t.e(viewGroup, "parent");
            C2439t0 c5 = C2439t0.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            t.d(c5, "inflate(...)");
            return new a(this, c5, this.f4307a, this.f4308b);
        }

        public final void e(ArrayList arrayList) {
            t.e(arrayList, "importantApps");
            this.f4309c = arrayList;
            notifyDataSetChanged();
        }

        public int getItemCount() {
            return this.f4309c.size();
        }
    }

    /* renamed from: R1.t$g */
    public final class g extends C2029k {

        /* renamed from: b  reason: collision with root package name */
        private final f f4314b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C0988t f4315c;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public g(R1.C0988t r4, h2.C2437s0 r5, k2.C2594d r6, android.content.Context r7) {
            /*
                r3 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.t.e(r5, r0)
                java.lang.String r0 = "listener"
                kotlin.jvm.internal.t.e(r6, r0)
                java.lang.String r0 = "context"
                kotlin.jvm.internal.t.e(r7, r0)
                r3.f4315c = r4
                android.widget.LinearLayout r0 = r5.getRoot()
                java.lang.String r1 = "getRoot(...)"
                kotlin.jvm.internal.t.d(r0, r1)
                r3.<init>(r0, r7)
                R1.t$f r0 = new R1.t$f
                r0.<init>(r4, r6, r7)
                r3.f4314b = r0
                androidx.recyclerview.widget.RecyclerView r4 = r5.f23531b
                androidx.recyclerview.widget.LinearLayoutManager r6 = new androidx.recyclerview.widget.LinearLayoutManager
                android.view.View r7 = r3.itemView
                android.content.Context r7 = r7.getContext()
                r1 = 1
                r2 = 0
                r6.<init>(r7, r1, r2)
                r4.setLayoutManager(r6)
                androidx.recyclerview.widget.RecyclerView r4 = r5.f23531b
                r4.setAdapter(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: R1.C0988t.g.<init>(R1.t, h2.s0, k2.d, android.content.Context):void");
        }

        public final void l(ArrayList arrayList) {
            t.e(arrayList, "importantApps");
            this.f4314b.e(arrayList);
        }

        public final f m() {
            return this.f4314b;
        }
    }

    public C0988t(C2594d dVar, String str) {
        t.e(dVar, "listener");
        t.e(str, "organizationName");
        this.f4288a = dVar;
        this.f4289b = str;
    }

    public final void a(ArrayList arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.f4290c.size();
            Iterator it = arrayList.iterator();
            t.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                t.d(next, "next(...)");
                b bVar = new b();
                bVar.c((C2657f) next);
                bVar.d(5);
                this.f4290c.add(bVar);
                notifyItemInserted(C2250q.i(this.f4290c));
            }
        }
    }

    public final void b(C2657f fVar, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
        this.f4290c = new ArrayList();
        if (fVar != null) {
            b bVar = new b();
            bVar.c(fVar);
            bVar.d(1);
            this.f4290c.add(bVar);
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            b bVar2 = new b();
            bVar2.c(arrayList);
            bVar2.d(2);
            this.f4290c.add(bVar2);
        }
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            b bVar3 = new b();
            bVar3.c(arrayList2);
            bVar3.d(3);
            this.f4290c.add(bVar3);
        }
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            b bVar4 = new b();
            bVar4.c(arrayList3);
            bVar4.d(4);
            this.f4290c.add(bVar4);
            Iterator it = arrayList3.iterator();
            t.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                t.d(next, "next(...)");
                b bVar5 = new b();
                bVar5.c((C2657f) next);
                bVar5.d(5);
                this.f4290c.add(bVar5);
            }
        }
    }

    public final void c(boolean z4) {
        this.f4291d = z4;
        if (z4) {
            notifyItemInserted(getItemCount());
        } else {
            notifyItemRemoved(getItemCount());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: l2.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: l2.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: l2.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: l2.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: l2.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: l2.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: l2.f} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(java.lang.String r11, androidx.recyclerview.widget.RecyclerView r12) {
        /*
            r10 = this;
            java.lang.String r0 = "packageName"
            kotlin.jvm.internal.t.e(r11, r0)
            java.lang.String r0 = "recyclerView"
            kotlin.jvm.internal.t.e(r12, r0)
            int r0 = r10.getItemCount()
            r1 = 0
            r2 = r1
        L_0x0010:
            if (r2 >= r0) goto L_0x00c6
            androidx.recyclerview.widget.RecyclerView$ViewHolder r3 = r12.findViewHolderForAdapterPosition(r2)
            boolean r4 = r3 instanceof R1.C0988t.e
            if (r4 == 0) goto L_0x003c
            java.util.ArrayList r3 = r10.f4290c
            java.util.Iterator r3 = r3.iterator()
            r4 = r1
        L_0x0021:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x00c2
            int r5 = r4 + 1
            java.lang.Object r6 = r3.next()
            R1.t$b r6 = (R1.C0988t.b) r6
            java.lang.Object r6 = r6.a()
            boolean r6 = r6 instanceof l2.C2657f
            if (r6 == 0) goto L_0x003a
            r10.notifyItemChanged(r4)
        L_0x003a:
            r4 = r5
            goto L_0x0021
        L_0x003c:
            boolean r4 = r3 instanceof R1.C0988t.g
            r5 = 0
            if (r4 == 0) goto L_0x007c
            R1.t$g r3 = (R1.C0988t.g) r3
            R1.t$f r4 = r3.m()
            java.util.ArrayList r4 = r4.b()
            int r6 = r4.size()
            r7 = r1
        L_0x0050:
            if (r7 >= r6) goto L_0x0066
            java.lang.Object r8 = r4.get(r7)
            int r7 = r7 + 1
            r9 = r8
            l2.f r9 = (l2.C2657f) r9
            java.lang.String r9 = r9.S()
            boolean r9 = kotlin.jvm.internal.t.a(r9, r11)
            if (r9 == 0) goto L_0x0050
            r5 = r8
        L_0x0066:
            l2.f r5 = (l2.C2657f) r5
            R1.t$f r4 = r3.m()
            java.util.ArrayList r4 = r4.b()
            int r4 = X2.C2250q.R(r4, r5)
            R1.t$f r3 = r3.m()
            r3.notifyItemChanged(r4)
            goto L_0x00c2
        L_0x007c:
            boolean r4 = r3 instanceof R1.C0988t.d
            if (r4 == 0) goto L_0x00bb
            R1.t$d r3 = (R1.C0988t.d) r3
            R1.t$c r4 = r3.m()
            java.util.ArrayList r4 = r4.b()
            int r6 = r4.size()
            r7 = r1
        L_0x008f:
            if (r7 >= r6) goto L_0x00a5
            java.lang.Object r8 = r4.get(r7)
            int r7 = r7 + 1
            r9 = r8
            l2.f r9 = (l2.C2657f) r9
            java.lang.String r9 = r9.S()
            boolean r9 = kotlin.jvm.internal.t.a(r9, r11)
            if (r9 == 0) goto L_0x008f
            r5 = r8
        L_0x00a5:
            l2.f r5 = (l2.C2657f) r5
            R1.t$c r4 = r3.m()
            java.util.ArrayList r4 = r4.b()
            int r4 = X2.C2250q.R(r4, r5)
            R1.t$c r3 = r3.m()
            r3.notifyItemChanged(r4)
            goto L_0x00c2
        L_0x00bb:
            boolean r3 = r3 instanceof C2.C2022h1
            if (r3 == 0) goto L_0x00c2
            r10.notifyItemChanged(r2)
        L_0x00c2:
            int r2 = r2 + 1
            goto L_0x0010
        L_0x00c6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: R1.C0988t.d(java.lang.String, androidx.recyclerview.widget.RecyclerView):void");
    }

    public int getItemCount() {
        return this.f4290c.size() + (this.f4291d ? 1 : 0);
    }

    public int getItemViewType(int i5) {
        if (i5 == this.f4290c.size()) {
            return 6;
        }
        return ((b) this.f4290c.get(i5)).b();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5) {
        t.e(viewHolder, "holder");
        if (viewHolder instanceof e) {
            Object a5 = ((b) this.f4290c.get(i5)).a();
            t.c(a5, "null cannot be cast to non-null type com.uptodown.models.AppInfo");
            ((e) viewHolder).m((C2657f) a5);
        } else if (viewHolder instanceof g) {
            Object a6 = ((b) this.f4290c.get(i5)).a();
            t.c(a6, "null cannot be cast to non-null type java.util.ArrayList<com.uptodown.models.AppInfo>");
            ((g) viewHolder).l((ArrayList) a6);
        } else if (viewHolder instanceof d) {
            Object a7 = ((b) this.f4290c.get(i5)).a();
            t.c(a7, "null cannot be cast to non-null type java.util.ArrayList<com.uptodown.models.AppInfo>");
            ((d) viewHolder).l((ArrayList) a7);
        } else if (viewHolder instanceof C2022h1) {
            Object a8 = ((b) this.f4290c.get(i5)).a();
            t.c(a8, "null cannot be cast to non-null type com.uptodown.models.AppInfo");
            ((C2022h1) viewHolder).m((C2657f) a8, i5);
        } else if (viewHolder instanceof U0) {
            ((U0) viewHolder).a();
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "parent");
        switch (i5) {
            case 1:
                C2435r0 c5 = C2435r0.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
                t.d(c5, "inflate(...)");
                C2594d dVar = this.f4288a;
                Context context = viewGroup.getContext();
                t.d(context, "getContext(...)");
                return new e(this, c5, dVar, context);
            case 2:
                C2437s0 c6 = C2437s0.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
                t.d(c6, "inflate(...)");
                C2594d dVar2 = this.f4288a;
                Context context2 = viewGroup.getContext();
                t.d(context2, "getContext(...)");
                return new g(this, c6, dVar2, context2);
            case 3:
                C2434q0 c7 = C2434q0.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
                t.d(c7, "inflate(...)");
                C2594d dVar3 = this.f4288a;
                Context context3 = viewGroup.getContext();
                t.d(context3, "getContext(...)");
                return new d(this, c7, dVar3, context3, this.f4289b);
            case 4:
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.title_organization_apps, viewGroup, false);
                t.b(inflate);
                String string = viewGroup.getContext().getString(R.string.organization_more_apps_title, new Object[]{this.f4289b});
                t.d(string, "getString(...)");
                return new U0(inflate, string);
            case 5:
                View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.app_info_vertical_top_item, viewGroup, false);
                t.b(inflate2);
                return new C2022h1(inflate2, this.f4288a, (C2591a) null);
            case 6:
                View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pb_loading_more_content, viewGroup, false);
                t.b(inflate3);
                return new C2015f0(inflate3);
            default:
                throw new IllegalArgumentException("viewType unknown");
        }
    }
}
