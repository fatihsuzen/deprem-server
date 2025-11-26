package R1;

import C2.C2023i;
import C2.C2033l0;
import C2.C2069x1;
import R1.L;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import k2.C2592b;
import k2.C2612w;
import k2.J;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2655d;
import l2.C2668q;
import l2.T;
import l2.r;
import t3.s;
import z2.C2940B;

/* renamed from: R1.o  reason: case insensitive filesystem */
public final class C0984o extends RecyclerView.Adapter {

    /* renamed from: f  reason: collision with root package name */
    public static final a f4269f = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final C2592b f4270a;

    /* renamed from: b  reason: collision with root package name */
    private final J f4271b;

    /* renamed from: c  reason: collision with root package name */
    private final C2612w f4272c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList f4273d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private int f4274e = -1;

    /* renamed from: R1.o$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public C0984o(C2592b bVar, J j5, C2612w wVar) {
        t.e(bVar, "appListener");
        t.e(wVar, "infoClickListener");
        this.f4270a = bVar;
        this.f4271b = j5;
        this.f4272c = wVar;
    }

    private final void a(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, ArrayList arrayList5) {
        ArrayList arrayList6 = new ArrayList();
        this.f4273d = arrayList6;
        arrayList6.addAll(arrayList);
        this.f4273d.addAll(arrayList2);
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            this.f4273d.add("title_system_app");
            this.f4273d.addAll(arrayList3);
        }
        if (arrayList4 != null && !arrayList4.isEmpty()) {
            this.f4273d.add("title_disable_app");
            this.f4273d.addAll(arrayList4);
        }
        if (arrayList5 != null && !arrayList5.isEmpty()) {
            this.f4273d.add("title_system_service");
            this.f4273d.addAll(arrayList5);
        }
    }

    public final ArrayList b() {
        return this.f4273d;
    }

    public final void c() {
        notifyDataSetChanged();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0018, code lost:
        r4 = (l2.C2655d) r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(java.lang.String r8) {
        /*
            r7 = this;
            java.util.ArrayList r0 = r7.f4273d
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L_0x0007:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x004a
            int r2 = r1 + 1
            java.lang.Object r3 = r0.next()
            boolean r4 = r3 instanceof l2.C2655d
            r5 = 1
            if (r4 == 0) goto L_0x0033
            r4 = r3
            l2.d r4 = (l2.C2655d) r4
            java.lang.String r6 = r4.o()
            if (r6 == 0) goto L_0x0033
            int r6 = r6.length()
            if (r6 != 0) goto L_0x0028
            goto L_0x0033
        L_0x0028:
            java.lang.String r4 = r4.o()
            boolean r4 = t3.s.E(r4, r8, r5)
            if (r4 == 0) goto L_0x0033
            goto L_0x004b
        L_0x0033:
            boolean r4 = r3 instanceof R1.L.a
            if (r4 == 0) goto L_0x0048
            R1.L$a r3 = (R1.L.a) r3
            l2.T r3 = r3.b()
            java.lang.String r3 = r3.h()
            boolean r3 = t3.s.E(r3, r8, r5)
            if (r3 == 0) goto L_0x0048
            goto L_0x004b
        L_0x0048:
            r1 = r2
            goto L_0x0007
        L_0x004a:
            r1 = -1
        L_0x004b:
            if (r1 < 0) goto L_0x0050
            r7.notifyItemChanged(r1)
        L_0x0050:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: R1.C0984o.d(java.lang.String):void");
    }

    public final void e(File file, Context context) {
        C2655d dVar;
        String o5;
        C2668q qVar;
        t.e(file, "xapkFile");
        t.e(context, "context");
        C2940B a5 = C2940B.f26458v.a(context);
        a5.a();
        Iterator it = this.f4273d.iterator();
        int i5 = 0;
        while (true) {
            if (!it.hasNext()) {
                i5 = -1;
                break;
            }
            int i6 = i5 + 1;
            Object next = it.next();
            if (!(!(next instanceof C2655d) || (o5 = dVar.o()) == null || o5.length() == 0)) {
                String o6 = (dVar = (C2655d) next).o();
                t.b(o6);
                T G02 = a5.G0(o6);
                if (G02 != null) {
                    qVar = G02.b(context);
                } else {
                    qVar = null;
                }
                if (qVar != null && qVar.o().size() == 1 && s.E(((r) qVar.o().get(0)).a(), file.getAbsolutePath(), true)) {
                    break;
                }
            }
            i5 = i6;
        }
        a5.m();
        if (i5 >= 0) {
            notifyItemChanged(i5);
        }
    }

    public final void f() {
        this.f4274e = -1;
    }

    public final void g(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, ArrayList arrayList5) {
        t.e(arrayList, "appUpdateData");
        t.e(arrayList2, "apps");
        a(arrayList, arrayList2, arrayList3, arrayList4, arrayList5);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.f4273d.size();
    }

    public int getItemViewType(int i5) {
        Object obj = this.f4273d.get(i5);
        t.d(obj, "get(...)");
        if (obj instanceof L.a) {
            return 1;
        }
        if (obj instanceof C2655d) {
            return 0;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            int hashCode = str.hashCode();
            if (hashCode != 1477891299) {
                if (hashCode != 1692569964) {
                    if (hashCode == 2032679000 && str.equals("title_system_app")) {
                        return 2;
                    }
                } else if (str.equals("title_system_service")) {
                    return 3;
                }
            } else if (str.equals("title_disable_app")) {
                return 4;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    public final void h(File file, Context context) {
        C2655d dVar;
        String o5;
        C2668q qVar;
        t.e(file, "file");
        t.e(context, "context");
        C2940B a5 = C2940B.f26458v.a(context);
        a5.a();
        Iterator it = this.f4273d.iterator();
        int i5 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            int i6 = i5 + 1;
            Object next = it.next();
            if (!(!(next instanceof C2655d) || (o5 = dVar.o()) == null || o5.length() == 0)) {
                String o6 = (dVar = (C2655d) next).o();
                t.b(o6);
                T G02 = a5.G0(o6);
                if (G02 != null) {
                    qVar = G02.b(context);
                } else {
                    qVar = null;
                }
                if (qVar != null && qVar.o().size() == 1 && s.E(((r) qVar.o().get(0)).a(), file.getAbsolutePath(), true)) {
                    this.f4274e = i5;
                    break;
                }
            }
            i5 = i6;
        }
        a5.m();
        int i7 = this.f4274e;
        if (i7 >= 0) {
            notifyItemChanged(i7);
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5) {
        t.e(viewHolder, "viewHolder");
        if (viewHolder instanceof C2023i) {
            Object obj = this.f4273d.get(i5);
            t.c(obj, "null cannot be cast to non-null type com.uptodown.models.App");
            ((C2023i) viewHolder).e((C2655d) obj);
            return;
        }
        boolean z4 = true;
        if (viewHolder instanceof C2069x1) {
            C2069x1 x1Var = (C2069x1) viewHolder;
            Object obj2 = this.f4273d.get(i5);
            t.c(obj2, "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData");
            L.a aVar = (L.a) obj2;
            if (this.f4274e != i5) {
                z4 = false;
            }
            x1Var.n(aVar, z4, false);
        } else if (viewHolder instanceof C2033l0) {
            ((C2033l0) viewHolder).c(true);
        } else {
            throw new IllegalArgumentException("ViewHolder unknown!!");
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "viewGroup");
        if (i5 == 0) {
            return new C2023i(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.installed_app_item, viewGroup, false), this.f4270a);
        }
        if (i5 == 1) {
            return new C2069x1(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.update_item, viewGroup, false), this.f4271b);
        }
        if (i5 == 2) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tv_myappsupdates_title, viewGroup, false);
            String string = inflate.getContext().getString(R.string.system_apps_title);
            t.d(string, "getString(...)");
            return new C2033l0(inflate, string, (C2612w) null);
        } else if (i5 == 3) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tv_myappsupdates_title, viewGroup, false);
            String string2 = inflate2.getContext().getString(R.string.menu_item_title_system_services);
            t.d(string2, "getString(...)");
            return new C2033l0(inflate2, string2, (C2612w) null);
        } else if (i5 == 4) {
            View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tv_myappsupdates_title, viewGroup, false);
            String string3 = inflate3.getContext().getString(R.string.disabled_apps);
            t.d(string3, "getString(...)");
            return new C2033l0(inflate3, string3, this.f4272c);
        } else {
            throw new IllegalArgumentException("viewType unknown");
        }
    }
}
