package R1;

import C2.C2016f1;
import C2.C2022h1;
import C2.C2028j1;
import C2.Y0;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import java.util.ArrayList;
import java.util.Iterator;
import k2.C2591a;
import k2.C2594d;
import k2.C2595e;
import k2.C2599i;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2657f;
import l2.C2660i;
import l2.S;

public final class G extends RecyclerView.Adapter {

    /* renamed from: l  reason: collision with root package name */
    public static final a f4014l = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final C2594d f4015a;

    /* renamed from: b  reason: collision with root package name */
    private final C2595e f4016b;

    /* renamed from: c  reason: collision with root package name */
    private final C2591a f4017c;

    /* renamed from: d  reason: collision with root package name */
    private final C2599i f4018d;

    /* renamed from: e  reason: collision with root package name */
    private final String f4019e;

    /* renamed from: f  reason: collision with root package name */
    private final String f4020f;

    /* renamed from: g  reason: collision with root package name */
    private final String f4021g;

    /* renamed from: h  reason: collision with root package name */
    private final String f4022h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f4023i;

    /* renamed from: j  reason: collision with root package name */
    private ArrayList f4024j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    private int f4025k;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private C2657f f4026a;

        /* renamed from: b  reason: collision with root package name */
        private int f4027b = 1;

        /* renamed from: c  reason: collision with root package name */
        private int f4028c = 1;

        public final int a() {
            return this.f4028c;
        }

        public final C2657f b() {
            return this.f4026a;
        }

        public final int c() {
            return this.f4027b;
        }

        public final void d(int i5) {
            this.f4028c = i5;
        }

        public final void e(C2657f fVar) {
            this.f4026a = fVar;
        }

        public final void f(int i5) {
            this.f4027b = i5;
        }
    }

    public G(C2594d dVar, C2595e eVar, C2591a aVar, C2599i iVar, String str, String str2, String str3, String str4, boolean z4) {
        t.e(dVar, "listener");
        t.e(eVar, "topItemsListener");
        t.e(aVar, "actionsClickListener");
        t.e(str3, "readMore");
        t.e(str4, "readLess");
        this.f4015a = dVar;
        this.f4016b = eVar;
        this.f4017c = aVar;
        this.f4018d = iVar;
        this.f4019e = str;
        this.f4020f = str2;
        this.f4021g = str3;
        this.f4022h = str4;
        this.f4023i = z4;
    }

    private final boolean e(C2660i iVar) {
        return iVar.m();
    }

    public final void a(ArrayList arrayList, boolean z4) {
        t.e(arrayList, "apps");
        int size = this.f4024j.size();
        Iterator it = arrayList.iterator();
        t.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            t.d(next, "next(...)");
            b bVar = new b();
            bVar.e((C2657f) next);
            bVar.f(0);
            if (z4) {
                int i5 = this.f4025k + 1;
                this.f4025k = i5;
                bVar.d(i5);
            } else {
                bVar.d(0);
            }
            this.f4024j.add(bVar);
        }
        notifyItemRangeInserted(size, this.f4024j.size());
    }

    public final void b(S s5) {
        t.e(s5, "topByCategory");
        this.f4024j = new ArrayList();
        if (!e(s5.b())) {
            Iterator it = s5.a().iterator();
            t.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                t.d(next, "next(...)");
                b bVar = new b();
                bVar.e((C2657f) next);
                bVar.f(0);
                bVar.d(0);
                this.f4024j.add(bVar);
            }
            return;
        }
        String b5 = s5.b().b();
        if (!(b5 == null || b5.length() == 0)) {
            b bVar2 = new b();
            bVar2.f(2);
            this.f4024j.add(bVar2);
        }
        int i5 = 0;
        for (C2657f fVar : s5.a()) {
            int i6 = i5 + 1;
            b bVar3 = new b();
            bVar3.e(fVar);
            if (i5 == 0 && fVar.N0()) {
                bVar3.f(3);
            } else if (i5 >= 10) {
                bVar3.f(0);
            } else if (s5.b().c() == 1090) {
                bVar3.f(4);
            } else {
                bVar3.f(1);
            }
            this.f4025k = i6;
            bVar3.d(i6);
            this.f4024j.add(bVar3);
            i5 = i6;
        }
    }

    public final ArrayList c() {
        return this.f4024j;
    }

    public final void d(C2657f fVar) {
        t.e(fVar, "appInfo");
        int i5 = 0;
        for (b b5 : this.f4024j) {
            int i6 = i5 + 1;
            C2657f b6 = b5.b();
            if (b6 == null || b6.e() != fVar.e()) {
                i5 = i6;
            } else {
                notifyItemChanged(i5);
                return;
            }
        }
    }

    public int getItemCount() {
        return this.f4024j.size();
    }

    public int getItemViewType(int i5) {
        return ((b) this.f4024j.get(i5)).c();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5) {
        t.e(viewHolder, "viewHolder");
        if (viewHolder instanceof C2016f1) {
            if (this.f4023i) {
                C2657f b5 = ((b) this.f4024j.get(i5)).b();
                t.b(b5);
                ((C2016f1) viewHolder).r(b5, ((b) this.f4024j.get(i5)).a() - 1, i5);
                return;
            }
            C2657f b6 = ((b) this.f4024j.get(i5)).b();
            t.b(b6);
            ((C2016f1) viewHolder).r(b6, ((b) this.f4024j.get(i5)).a(), i5);
        } else if (viewHolder instanceof Y0) {
            C2657f b7 = ((b) this.f4024j.get(i5)).b();
            t.b(b7);
            ((Y0) viewHolder).o(b7, ((b) this.f4024j.get(i5)).a(), i5);
        } else if (viewHolder instanceof C2022h1) {
            if (this.f4023i) {
                C2657f b8 = ((b) this.f4024j.get(i5)).b();
                t.b(b8);
                ((C2022h1) viewHolder).m(b8, ((b) this.f4024j.get(i5)).a() - 1);
                return;
            }
            C2657f b9 = ((b) this.f4024j.get(i5)).b();
            t.b(b9);
            ((C2022h1) viewHolder).m(b9, ((b) this.f4024j.get(i5)).a());
        } else if (!(viewHolder instanceof C2028j1)) {
            throw new IllegalArgumentException("ViewHolder unknown!!");
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "viewGroup");
        if (i5 == 0) {
            return new C2022h1(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.app_info_top_by_cat_item_small, viewGroup, false), this.f4015a, this.f4017c);
        }
        if (i5 == 1) {
            return new C2016f1(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.app_info_top_by_cat_item, viewGroup, false), this.f4015a, this.f4016b, this.f4017c);
        }
        if (i5 == 2) {
            return new C2028j1(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.top_by_category_title_view, viewGroup, false), this.f4019e, this.f4020f, this.f4021g, this.f4022h, this.f4018d);
        }
        if (i5 == 3) {
            return new C2016f1(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.app_info_promoted_top_by_cat_item, viewGroup, false), this.f4015a, this.f4016b, this.f4017c);
        }
        if (i5 == 4) {
            return new Y0(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.app_info_top_by_cat_item, viewGroup, false), this.f4015a, this.f4016b, this.f4017c);
        }
        throw new IllegalArgumentException("viewType unknown");
    }
}
