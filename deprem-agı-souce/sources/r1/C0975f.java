package R1;

import C2.C2003b0;
import C2.C2024i0;
import C2.C2034l1;
import C2.C2058u;
import C2.V;
import C2.X;
import C2.X1;
import C2.Z;
import W2.J;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.uptodown.R;
import java.util.ArrayList;
import java.util.Iterator;
import k2.C2587D;
import k2.C2591a;
import k2.C2611v;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2657f;
import l2.C2660i;
import l2.S;

/* renamed from: R1.f  reason: case insensitive filesystem */
public final class C0975f extends RecyclerView.Adapter {

    /* renamed from: o  reason: collision with root package name */
    public static final a f4193o = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final C2611v f4194a;

    /* renamed from: b  reason: collision with root package name */
    private final C2591a f4195b;

    /* renamed from: c  reason: collision with root package name */
    private final C2587D f4196c;

    /* renamed from: d  reason: collision with root package name */
    private final String f4197d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList f4198e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private int f4199f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f4200g = -1;

    /* renamed from: h  reason: collision with root package name */
    private int f4201h = -1;

    /* renamed from: i  reason: collision with root package name */
    private int f4202i = -1;

    /* renamed from: j  reason: collision with root package name */
    private int f4203j = -1;

    /* renamed from: k  reason: collision with root package name */
    private int f4204k = -1;

    /* renamed from: l  reason: collision with root package name */
    private int f4205l = -1;

    /* renamed from: m  reason: collision with root package name */
    private int f4206m = -1;

    /* renamed from: n  reason: collision with root package name */
    private int f4207n = -1;

    /* renamed from: R1.f$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    /* renamed from: R1.f$b */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList f4208a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList f4209b;

        /* renamed from: c  reason: collision with root package name */
        public String f4210c;

        public final ArrayList a() {
            ArrayList arrayList = this.f4209b;
            if (arrayList != null) {
                return arrayList;
            }
            t.w("categories");
            return null;
        }

        public final ArrayList b() {
            ArrayList arrayList = this.f4208a;
            if (arrayList != null) {
                return arrayList;
            }
            t.w("homeFeatures");
            return null;
        }

        public final String c() {
            String str = this.f4210c;
            if (str != null) {
                return str;
            }
            t.w(CampaignEx.JSON_KEY_TITLE);
            return null;
        }

        public final void d(ArrayList arrayList) {
            t.e(arrayList, "<set-?>");
            this.f4209b = arrayList;
        }

        public final void e(ArrayList arrayList) {
            t.e(arrayList, "<set-?>");
            this.f4208a = arrayList;
        }

        public final void f(String str) {
            t.e(str, "<set-?>");
            this.f4210c = str;
        }
    }

    /* renamed from: R1.f$c */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public Object f4211a;

        /* renamed from: b  reason: collision with root package name */
        private int f4212b = -1;

        public final Object a() {
            Object obj = this.f4211a;
            if (obj != null) {
                return obj;
            }
            t.w("item");
            return J.f19942a;
        }

        public final int b() {
            return this.f4212b;
        }

        public final void c(Object obj) {
            t.e(obj, "<set-?>");
            this.f4211a = obj;
        }

        public final void d(int i5) {
            this.f4212b = i5;
        }
    }

    public C0975f(C2611v vVar, C2591a aVar, C2587D d5, String str) {
        t.e(vVar, "listener");
        t.e(aVar, "actionsClickListener");
        t.e(d5, "promotedListener");
        t.e(str, "fragmentName");
        this.f4194a = vVar;
        this.f4195b = aVar;
        this.f4196c = d5;
        this.f4197d = str;
    }

    private final void c(ArrayList arrayList, ArrayList arrayList2, String str) {
        b bVar = new b();
        bVar.f(str);
        bVar.e(arrayList);
        bVar.d(arrayList2);
        c cVar = new c();
        cVar.c(bVar);
        cVar.d(0);
        this.f4198e.add(cVar);
    }

    private final void d(ArrayList arrayList, int i5) {
        Iterator it = arrayList.iterator();
        t.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            t.d(next, "next(...)");
            S s5 = (S) next;
            if (s5.b().c() == i5) {
                j(s5);
                arrayList.remove(s5);
                return;
            }
        }
    }

    private final void g(ArrayList arrayList) {
        c cVar = new c();
        cVar.c(arrayList);
        cVar.d(7);
        this.f4198e.add(cVar);
        notifyItemInserted(this.f4198e.size() - 1);
    }

    private final void h(ArrayList arrayList) {
        if (!arrayList.isEmpty()) {
            d(arrayList, 558);
        }
        if (!arrayList.isEmpty()) {
            d(arrayList, 566);
        }
        if (!arrayList.isEmpty()) {
            d(arrayList, 562);
        }
        if (!arrayList.isEmpty()) {
            d(arrayList, 564);
        }
        if (!arrayList.isEmpty()) {
            d(arrayList, 559);
        }
        if (!arrayList.isEmpty()) {
            d(arrayList, 645);
        }
        if (!arrayList.isEmpty()) {
            d(arrayList, 560);
        }
        if (!arrayList.isEmpty()) {
            d(arrayList, 561);
        }
        if (!arrayList.isEmpty()) {
            d(arrayList, 565);
        }
        if (!arrayList.isEmpty()) {
            d(arrayList, 593);
        }
        if (!arrayList.isEmpty()) {
            d(arrayList, 568);
        }
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            t.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                t.d(next, "next(...)");
                j((S) next);
            }
        }
    }

    private final void i(ArrayList arrayList, ArrayList arrayList2, String str) {
        b bVar = new b();
        bVar.f(str);
        bVar.e(arrayList);
        bVar.d(arrayList2);
        c cVar = new c();
        cVar.c(bVar);
        cVar.d(0);
        this.f4198e.add(cVar);
    }

    private final void j(S s5) {
        if (s5 != null) {
            c cVar = new c();
            cVar.c(s5);
            cVar.d(s5.c());
            this.f4198e.add(cVar);
            notifyItemInserted(this.f4198e.size() - 1);
        }
    }

    private final void t(S s5, int i5) {
        if (i5 >= 0 && i5 < this.f4198e.size()) {
            c cVar = new c();
            cVar.c(s5);
            cVar.d(s5.c());
            this.f4198e.set(i5, cVar);
            notifyItemChanged(i5);
        }
    }

    public final void a(S s5) {
        t.e(s5, "floatingCategory");
        j(s5);
    }

    public final void b(C2657f fVar) {
        t.e(fVar, "appReplacement");
        int i5 = 0;
        for (c cVar : this.f4198e) {
            int i6 = i5 + 1;
            if (cVar == null || cVar.b() != 0) {
                i5 = i6;
            } else {
                Object a5 = cVar.a();
                t.c(a5, "null cannot be cast to non-null type com.uptodown.adapters.HomeAdapter.HomeHeader");
                ((b) a5).b().add(fVar);
                notifyItemChanged(i5);
                return;
            }
        }
    }

    public final void e(S s5) {
        t.e(s5, "miniTop");
        j(s5);
    }

    public final void f(ArrayList arrayList, C2660i iVar) {
        t.e(arrayList, "miniTops");
        t.e(iVar, "category");
        if (iVar.c() == 523) {
            h(arrayList);
            return;
        }
        Iterator it = arrayList.iterator();
        t.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            t.d(next, "next(...)");
            j((S) next);
        }
    }

    public int getItemCount() {
        return this.f4198e.size();
    }

    public int getItemViewType(int i5) {
        c cVar = (c) this.f4198e.get(i5);
        if (cVar != null) {
            return cVar.b();
        }
        return -1;
    }

    public final void k(ArrayList arrayList) {
        t.e(arrayList, "floatingCategories");
        if (!arrayList.isEmpty()) {
            g(arrayList);
        }
    }

    public final void l(C2657f fVar) {
        t.e(fVar, "mainApp");
        c cVar = new c();
        cVar.c(fVar);
        cVar.d(3);
        this.f4198e.set(this.f4201h, cVar);
        notifyItemChanged(this.f4201h);
    }

    public final void m(ArrayList arrayList) {
        t.e(arrayList, "miniTops");
        Iterator it = arrayList.iterator();
        t.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            t.d(next, "next(...)");
            S s5 = (S) next;
            int c5 = s5.b().c();
            if (c5 == 521) {
                t(s5, this.f4202i);
            } else if (c5 == 523) {
                t(s5, this.f4203j);
            } else if (c5 != 524) {
                j(s5);
            } else {
                t(s5, this.f4204k);
            }
        }
    }

    public final void n(ArrayList arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            Object obj = arrayList.get(0);
            t.d(obj, "get(...)");
            t((S) obj, this.f4205l);
            if (arrayList.size() > 1) {
                Object obj2 = arrayList.get(1);
                t.d(obj2, "get(...)");
                t((S) obj2, this.f4206m);
            }
            if (arrayList.size() > 2) {
                Object obj3 = arrayList.get(2);
                t.d(obj3, "get(...)");
                t((S) obj3, this.f4207n);
            }
        }
    }

    public final void o(ArrayList arrayList, ArrayList arrayList2, S s5, S s6, String str) {
        ArrayList a5;
        ArrayList a6;
        ArrayList a7;
        t.e(arrayList, "appsFeatured");
        t.e(arrayList2, "leafCategories");
        t.e(str, CampaignEx.JSON_KEY_TITLE);
        this.f4198e = new ArrayList();
        if (!arrayList.isEmpty()) {
            c(arrayList, arrayList2, str);
        }
        if (!(s5 == null || (a7 = s5.a()) == null || !(!a7.isEmpty()))) {
            j(s5);
        }
        if (arrayList2.isEmpty() || ((C2660i) arrayList2.get(0)).f() != 523) {
            if (s6 != null && (a5 = s6.a()) != null && (!a5.isEmpty())) {
                j(s6);
            }
        } else if (s6 != null && (a6 = s6.a()) != null && (!a6.isEmpty())) {
            j(s6);
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5) {
        Object obj;
        Object obj2;
        t.e(viewHolder, "viewHolder");
        if (viewHolder instanceof C2058u) {
            ((C2058u) viewHolder).a();
            return;
        }
        Object obj3 = null;
        if (viewHolder instanceof V) {
            V v5 = (V) viewHolder;
            c cVar = (c) this.f4198e.get(i5);
            if (cVar != null) {
                obj3 = cVar.a();
            }
            t.c(obj3, "null cannot be cast to non-null type com.uptodown.adapters.HomeAdapter.HomeHeader");
            v5.k((b) obj3);
        } else if (viewHolder instanceof Z) {
            c cVar2 = (c) this.f4198e.get(i5);
            if (cVar2 != null) {
                obj2 = cVar2.a();
            } else {
                obj2 = null;
            }
            if (obj2 instanceof S) {
                Z z4 = (Z) viewHolder;
                c cVar3 = (c) this.f4198e.get(i5);
                if (cVar3 != null) {
                    obj3 = cVar3.a();
                }
                t.c(obj3, "null cannot be cast to non-null type com.uptodown.models.TopByCategory");
                z4.b((S) obj3);
            }
        } else if (viewHolder instanceof X) {
            c cVar4 = (c) this.f4198e.get(i5);
            if (cVar4 != null) {
                obj = cVar4.a();
            } else {
                obj = null;
            }
            if (obj instanceof S) {
                X x4 = (X) viewHolder;
                c cVar5 = (c) this.f4198e.get(i5);
                if (cVar5 != null) {
                    obj3 = cVar5.a();
                }
                t.c(obj3, "null cannot be cast to non-null type com.uptodown.models.TopByCategory");
                x4.b((S) obj3);
            }
        } else if (viewHolder instanceof C2024i0) {
            C2024i0 i0Var = (C2024i0) viewHolder;
            c cVar6 = (c) this.f4198e.get(i5);
            if (cVar6 != null) {
                obj3 = cVar6.a();
            }
            t.c(obj3, "null cannot be cast to non-null type com.uptodown.models.AppInfo");
            i0Var.n((C2657f) obj3);
        } else if (viewHolder instanceof X1) {
            X1 x12 = (X1) viewHolder;
            c cVar7 = (c) this.f4198e.get(i5);
            if (cVar7 != null) {
                obj3 = cVar7.a();
            }
            t.c(obj3, "null cannot be cast to non-null type com.uptodown.models.TopByCategory");
            x12.c((S) obj3);
        } else if (viewHolder instanceof C2034l1) {
            C2034l1 l1Var = (C2034l1) viewHolder;
            c cVar8 = (c) this.f4198e.get(i5);
            if (cVar8 != null) {
                obj3 = cVar8.a();
            }
            t.c(obj3, "null cannot be cast to non-null type com.uptodown.models.TopByCategory");
            l1Var.b((S) obj3);
        } else if (viewHolder instanceof C2003b0) {
            C2003b0 b0Var = (C2003b0) viewHolder;
            c cVar9 = (c) this.f4198e.get(i5);
            if (cVar9 != null) {
                obj3 = cVar9.a();
            }
            t.c(obj3, "null cannot be cast to non-null type com.uptodown.models.TopByCategory");
            b0Var.b((S) obj3);
        } else if (viewHolder instanceof C2.J) {
            C2.J j5 = (C2.J) viewHolder;
            c cVar10 = (c) this.f4198e.get(i5);
            if (cVar10 != null) {
                obj3 = cVar10.a();
            }
            t.c(obj3, "null cannot be cast to non-null type java.util.ArrayList<com.uptodown.models.Category>");
            j5.b((ArrayList) obj3);
        } else {
            throw new IllegalArgumentException("ViewHolder unknown!!");
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "viewGroup");
        switch (i5) {
            case -1:
                return new C2058u(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.empty_view, viewGroup, false));
            case 0:
                return new V(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_fragment_header, viewGroup, false), this.f4194a, this.f4195b, this.f4196c);
            case 1:
                return new Z(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_recycler_view_top, viewGroup, false), this.f4194a, this.f4195b);
            case 3:
                return new C2024i0(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_gallery_featured, viewGroup, false), this.f4194a, this.f4195b);
            case 4:
                return new X1(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_recycler_view_top, viewGroup, false), this.f4194a, this.f4195b, this.f4197d);
            case 5:
                return new C2034l1(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_recycler_view_top, viewGroup, false), this.f4194a, this.f4195b);
            case 6:
                return new C2003b0(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_recycler_view_top, viewGroup, false), this.f4194a, this.f4195b);
            case 7:
                return new C2.J(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.floating_categories, viewGroup, false), this.f4194a);
            case 8:
                return new X(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_recycler_view_top, viewGroup, false), this.f4194a, this.f4195b);
            default:
                throw new IllegalArgumentException("viewType unknown");
        }
    }

    public final void p(ArrayList arrayList, S s5, S s6, String str) {
        t.e(arrayList, "homeFeatures");
        t.e(str, CampaignEx.JSON_KEY_TITLE);
        this.f4198e = new ArrayList();
        i(arrayList, new ArrayList(), str);
        j(s5);
        this.f4198e.add((Object) null);
        this.f4199f = this.f4198e.size() - 1;
        j(s6);
        this.f4198e.add((Object) null);
        this.f4206m = this.f4198e.size() - 1;
        this.f4198e.add((Object) null);
        this.f4200g = this.f4198e.size() - 1;
        this.f4198e.add((Object) null);
        this.f4207n = this.f4198e.size() - 1;
        this.f4198e.add((Object) null);
        this.f4201h = this.f4198e.size() - 1;
        this.f4198e.add((Object) null);
        this.f4202i = this.f4198e.size() - 1;
        this.f4198e.add((Object) null);
        this.f4203j = this.f4198e.size() - 1;
        this.f4198e.add((Object) null);
        this.f4204k = this.f4198e.size() - 1;
    }

    public final ArrayList q() {
        return this.f4198e;
    }

    public final void r(S s5) {
        t.e(s5, "top");
        t(s5, this.f4199f);
    }

    public final void s(S s5) {
        t.e(s5, "top");
        t(s5, this.f4200g);
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
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: l2.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: l2.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: l2.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: l2.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v12, resolved type: l2.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: l2.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: l2.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v16, resolved type: l2.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v15, resolved type: l2.f} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void u(java.lang.String r11, androidx.recyclerview.widget.RecyclerView r12) {
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
            if (r2 >= r0) goto L_0x016f
            androidx.recyclerview.widget.RecyclerView$ViewHolder r3 = r12.findViewHolderForAdapterPosition(r2)
            boolean r4 = r3 instanceof C2.Z
            r5 = 0
            if (r4 == 0) goto L_0x0057
            C2.Z r3 = (C2.Z) r3
            R1.K r4 = r3.d()
            java.util.ArrayList r4 = r4.c()
            int r6 = r4.size()
            r7 = r1
        L_0x002a:
            if (r7 >= r6) goto L_0x0040
            java.lang.Object r8 = r4.get(r7)
            int r7 = r7 + 1
            r9 = r8
            l2.f r9 = (l2.C2657f) r9
            java.lang.String r9 = r9.S()
            boolean r9 = kotlin.jvm.internal.t.a(r9, r11)
            if (r9 == 0) goto L_0x002a
            r5 = r8
        L_0x0040:
            l2.f r5 = (l2.C2657f) r5
            R1.K r4 = r3.d()
            java.util.ArrayList r4 = r4.c()
            int r4 = X2.C2250q.R(r4, r5)
            R1.K r3 = r3.d()
            r3.notifyItemChanged(r4)
            goto L_0x016b
        L_0x0057:
            boolean r4 = r3 instanceof C2.X
            if (r4 == 0) goto L_0x0097
            C2.X r3 = (C2.X) r3
            R1.I r4 = r3.d()
            java.util.ArrayList r4 = r4.b()
            int r6 = r4.size()
            r7 = r1
        L_0x006a:
            if (r7 >= r6) goto L_0x0080
            java.lang.Object r8 = r4.get(r7)
            int r7 = r7 + 1
            r9 = r8
            l2.f r9 = (l2.C2657f) r9
            java.lang.String r9 = r9.S()
            boolean r9 = kotlin.jvm.internal.t.a(r9, r11)
            if (r9 == 0) goto L_0x006a
            r5 = r8
        L_0x0080:
            l2.f r5 = (l2.C2657f) r5
            R1.I r4 = r3.d()
            java.util.ArrayList r4 = r4.b()
            int r4 = X2.C2250q.R(r4, r5)
            R1.I r3 = r3.d()
            r3.notifyItemChanged(r4)
            goto L_0x016b
        L_0x0097:
            boolean r4 = r3 instanceof C2.C2024i0
            if (r4 == 0) goto L_0x00ae
            C2.i0 r3 = (C2.C2024i0) r3
            java.lang.String r3 = r3.p()
            boolean r3 = kotlin.jvm.internal.t.a(r3, r11)
            if (r3 == 0) goto L_0x016b
            int r3 = r10.f4201h
            r10.notifyItemChanged(r3)
            goto L_0x016b
        L_0x00ae:
            boolean r4 = r3 instanceof C2.X1
            if (r4 == 0) goto L_0x00ee
            C2.X1 r3 = (C2.X1) r3
            R1.e0 r4 = r3.e()
            java.util.ArrayList r4 = r4.m()
            int r6 = r4.size()
            r7 = r1
        L_0x00c1:
            if (r7 >= r6) goto L_0x00d7
            java.lang.Object r8 = r4.get(r7)
            int r7 = r7 + 1
            r9 = r8
            l2.f r9 = (l2.C2657f) r9
            java.lang.String r9 = r9.S()
            boolean r9 = kotlin.jvm.internal.t.a(r9, r11)
            if (r9 == 0) goto L_0x00c1
            r5 = r8
        L_0x00d7:
            l2.f r5 = (l2.C2657f) r5
            R1.e0 r4 = r3.e()
            java.util.ArrayList r4 = r4.m()
            int r4 = X2.C2250q.R(r4, r5)
            R1.e0 r3 = r3.e()
            r3.notifyItemChanged(r4)
            goto L_0x016b
        L_0x00ee:
            boolean r4 = r3 instanceof C2.C2034l1
            if (r4 == 0) goto L_0x012d
            C2.l1 r3 = (C2.C2034l1) r3
            R1.k r4 = r3.d()
            java.util.ArrayList r4 = r4.a()
            int r6 = r4.size()
            r7 = r1
        L_0x0101:
            if (r7 >= r6) goto L_0x0117
            java.lang.Object r8 = r4.get(r7)
            int r7 = r7 + 1
            r9 = r8
            l2.f r9 = (l2.C2657f) r9
            java.lang.String r9 = r9.S()
            boolean r9 = kotlin.jvm.internal.t.a(r9, r11)
            if (r9 == 0) goto L_0x0101
            r5 = r8
        L_0x0117:
            l2.f r5 = (l2.C2657f) r5
            R1.k r4 = r3.d()
            java.util.ArrayList r4 = r4.a()
            int r4 = X2.C2250q.R(r4, r5)
            R1.k r3 = r3.d()
            r3.notifyItemChanged(r4)
            goto L_0x016b
        L_0x012d:
            boolean r4 = r3 instanceof C2.C2003b0
            if (r4 == 0) goto L_0x016b
            C2.b0 r3 = (C2.C2003b0) r3
            R1.m r4 = r3.d()
            java.util.ArrayList r4 = r4.a()
            int r6 = r4.size()
            r7 = r1
        L_0x0140:
            if (r7 >= r6) goto L_0x0156
            java.lang.Object r8 = r4.get(r7)
            int r7 = r7 + 1
            r9 = r8
            l2.f r9 = (l2.C2657f) r9
            java.lang.String r9 = r9.S()
            boolean r9 = kotlin.jvm.internal.t.a(r9, r11)
            if (r9 == 0) goto L_0x0140
            r5 = r8
        L_0x0156:
            l2.f r5 = (l2.C2657f) r5
            R1.m r4 = r3.d()
            java.util.ArrayList r4 = r4.a()
            int r4 = X2.C2250q.R(r4, r5)
            R1.m r3 = r3.d()
            r3.notifyItemChanged(r4)
        L_0x016b:
            int r2 = r2 + 1
            goto L_0x0010
        L_0x016f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: R1.C0975f.u(java.lang.String, androidx.recyclerview.widget.RecyclerView):void");
    }
}
