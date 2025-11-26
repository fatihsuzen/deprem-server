package R1;

import C2.C2002b;
import C2.C2023i;
import C2.C2033l0;
import C2.C2040n1;
import C2.C2046p1;
import C2.C2069x1;
import C2.Y1;
import C2.a2;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import com.uptodown.activities.preferences.a;
import java.io.File;
import java.util.ArrayList;
import k2.C2592b;
import k2.C2612w;
import k2.J;
import k2.K;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2655d;
import l2.T;
import z2.E;

public final class L extends RecyclerView.Adapter {

    /* renamed from: j  reason: collision with root package name */
    public static final b f4064j = new b((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final J f4065a;

    /* renamed from: b  reason: collision with root package name */
    private final C2592b f4066b;

    /* renamed from: c  reason: collision with root package name */
    private final K f4067c;

    /* renamed from: d  reason: collision with root package name */
    private final C2612w f4068d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList f4069e;

    /* renamed from: f  reason: collision with root package name */
    private c f4070f = new c();

    /* renamed from: g  reason: collision with root package name */
    private int f4071g = -1;

    /* renamed from: h  reason: collision with root package name */
    private boolean f4072h;

    /* renamed from: i  reason: collision with root package name */
    private int f4073i;

    public static final class b {
        public /* synthetic */ b(C2633k kVar) {
            this();
        }

        private b() {
        }
    }

    private static final class c {

        /* renamed from: a  reason: collision with root package name */
        private int f4079a;

        public final int a() {
            return this.f4079a;
        }

        public final void b(int i5) {
            this.f4079a = i5;
        }
    }

    public L(J j5, C2592b bVar, K k5, C2612w wVar) {
        t.e(j5, "updateListener");
        t.e(bVar, "appListener");
        t.e(k5, "updatesTrackingListener");
        t.e(wVar, "infoClickListener");
        this.f4065a = j5;
        this.f4066b = bVar;
        this.f4067c = k5;
        this.f4068d = wVar;
    }

    private final void a(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, Context context) {
        i(new ArrayList());
        File i5 = new E().i(context);
        if (i5.exists() && new E().m(context, i5) < 262144000) {
            b().add("warning_not_space");
        }
        if (arrayList != null) {
            this.f4070f.b(arrayList.size());
        }
        b().add(this.f4070f);
        this.f4073i = b().size() - 1;
        if (!com.uptodown.activities.preferences.a.f15150a.k0(context)) {
            b().add("tracking_disabled");
            return;
        }
        if (arrayList != null) {
            b().addAll(arrayList);
        }
        if (arrayList4 != null && !arrayList4.isEmpty()) {
            b().add("title_disable_app");
            b().addAll(arrayList4);
        }
        if (arrayList2 != null && arrayList2.size() > 0) {
            b().add("title_recent_updates");
            b().addAll(arrayList2);
        }
        if (arrayList3 != null && arrayList3.size() > 0) {
            b().add("title_ignored");
            b().addAll(arrayList3);
        }
    }

    public final ArrayList b() {
        ArrayList arrayList = this.f4069e;
        if (arrayList != null) {
            return arrayList;
        }
        t.w(DataSchemeDataSource.SCHEME_DATA);
        return null;
    }

    public final int c() {
        return this.f4073i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001a, code lost:
        r4 = (l2.C2655d) r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(java.lang.String r8) {
        /*
            r7 = this;
            java.util.ArrayList r0 = r7.b()
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L_0x0009:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x004c
            int r2 = r1 + 1
            java.lang.Object r3 = r0.next()
            boolean r4 = r3 instanceof l2.C2655d
            r5 = 1
            if (r4 == 0) goto L_0x0035
            r4 = r3
            l2.d r4 = (l2.C2655d) r4
            java.lang.String r6 = r4.o()
            if (r6 == 0) goto L_0x0035
            int r6 = r6.length()
            if (r6 != 0) goto L_0x002a
            goto L_0x0035
        L_0x002a:
            java.lang.String r4 = r4.o()
            boolean r4 = t3.s.E(r4, r8, r5)
            if (r4 == 0) goto L_0x0035
            goto L_0x004d
        L_0x0035:
            boolean r4 = r3 instanceof R1.L.a
            if (r4 == 0) goto L_0x004a
            R1.L$a r3 = (R1.L.a) r3
            l2.T r3 = r3.b()
            java.lang.String r3 = r3.h()
            boolean r3 = t3.s.E(r3, r8, r5)
            if (r3 == 0) goto L_0x004a
            goto L_0x004d
        L_0x004a:
            r1 = r2
            goto L_0x0009
        L_0x004c:
            r1 = -1
        L_0x004d:
            if (r1 < 0) goto L_0x0052
            r7.notifyItemChanged(r1)
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: R1.L.d(java.lang.String):void");
    }

    public final void e() {
        this.f4072h = true;
        int i5 = 0;
        int i6 = -1;
        int i7 = 0;
        for (Object obj : b()) {
            int i8 = i5 + 1;
            if (obj instanceof a) {
                if (i6 == -1) {
                    i6 = i5;
                } else {
                    i7++;
                }
            } else if (i6 != -1) {
                break;
            }
            i5 = i8;
        }
        if (i6 >= 0) {
            notifyItemRangeChanged(i6, i7);
        } else {
            notifyDataSetChanged();
        }
    }

    /* JADX WARNING: type inference failed for: r9v2, types: [java.util.ArrayList] */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0033, code lost:
        r6 = (l2.C2655d) r5;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(java.io.File r13, android.content.Context r14) {
        /*
            r12 = this;
            java.lang.String r0 = "file"
            kotlin.jvm.internal.t.e(r13, r0)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.t.e(r14, r0)
            z2.B$a r0 = z2.C2940B.f26458v
            z2.B r0 = r0.a(r14)
            r0.a()
            java.util.ArrayList r1 = r12.b()
            java.util.Iterator r1 = r1.iterator()
            r2 = -1
            r3 = 0
        L_0x001d:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x00eb
            int r4 = r3 + 1
            java.lang.Object r5 = r1.next()
            boolean r6 = r5 instanceof l2.C2655d
            java.lang.String r7 = "next(...)"
            java.lang.String r8 = "iterator(...)"
            r9 = 0
            r10 = 1
            if (r6 == 0) goto L_0x0089
            r6 = r5
            l2.d r6 = (l2.C2655d) r6
            java.lang.String r11 = r6.o()
            if (r11 == 0) goto L_0x0089
            int r11 = r11.length()
            if (r11 != 0) goto L_0x0043
            goto L_0x0089
        L_0x0043:
            java.lang.String r5 = r6.o()
            kotlin.jvm.internal.t.b(r5)
            l2.T r5 = r0.G0(r5)
            if (r5 == 0) goto L_0x0054
            l2.q r9 = r5.b(r14)
        L_0x0054:
            if (r9 == 0) goto L_0x00e8
            java.util.ArrayList r5 = r9.o()
            int r5 = r5.size()
            if (r5 <= 0) goto L_0x00e8
            java.util.ArrayList r5 = r9.o()
            java.util.Iterator r5 = r5.iterator()
            kotlin.jvm.internal.t.d(r5, r8)
        L_0x006b:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00e8
            java.lang.Object r6 = r5.next()
            kotlin.jvm.internal.t.d(r6, r7)
            l2.r r6 = (l2.r) r6
            java.lang.String r6 = r6.a()
            java.lang.String r8 = r13.getAbsolutePath()
            boolean r6 = t3.s.E(r6, r8, r10)
            if (r6 == 0) goto L_0x006b
            goto L_0x00e7
        L_0x0089:
            boolean r6 = r5 instanceof R1.L.a
            if (r6 == 0) goto L_0x00e8
            R1.L$a r5 = (R1.L.a) r5
            l2.T r6 = r5.b()
            l2.q r6 = r6.a()
            if (r6 == 0) goto L_0x009d
            java.util.ArrayList r9 = r6.o()
        L_0x009d:
            if (r9 == 0) goto L_0x00e8
            l2.T r6 = r5.b()
            l2.q r6 = r6.a()
            kotlin.jvm.internal.t.b(r6)
            java.util.ArrayList r6 = r6.o()
            int r6 = r6.size()
            if (r6 <= 0) goto L_0x00e8
            l2.T r5 = r5.b()
            l2.q r5 = r5.a()
            kotlin.jvm.internal.t.b(r5)
            java.util.ArrayList r5 = r5.o()
            java.util.Iterator r5 = r5.iterator()
            kotlin.jvm.internal.t.d(r5, r8)
        L_0x00ca:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00e8
            java.lang.Object r6 = r5.next()
            kotlin.jvm.internal.t.d(r6, r7)
            l2.r r6 = (l2.r) r6
            java.lang.String r6 = r6.a()
            java.lang.String r8 = r13.getAbsolutePath()
            boolean r6 = t3.s.E(r6, r8, r10)
            if (r6 == 0) goto L_0x00ca
        L_0x00e7:
            r2 = r3
        L_0x00e8:
            r3 = r4
            goto L_0x001d
        L_0x00eb:
            r0.m()
            if (r2 < 0) goto L_0x00f3
            r12.notifyItemChanged(r2)
        L_0x00f3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: R1.L.f(java.io.File, android.content.Context):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
        r4 = (l2.C2655d) r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g(android.content.Context r8, java.lang.String r9) {
        /*
            r7 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.t.e(r8, r0)
            if (r9 == 0) goto L_0x0084
            int r0 = r9.length()
            if (r0 != 0) goto L_0x000f
            goto L_0x0084
        L_0x000f:
            java.util.ArrayList r0 = r7.b()
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L_0x0018:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x005b
            int r2 = r1 + 1
            java.lang.Object r3 = r0.next()
            boolean r4 = r3 instanceof l2.C2655d
            r5 = 1
            if (r4 == 0) goto L_0x0044
            r4 = r3
            l2.d r4 = (l2.C2655d) r4
            java.lang.String r6 = r4.o()
            if (r6 == 0) goto L_0x0044
            int r6 = r6.length()
            if (r6 != 0) goto L_0x0039
            goto L_0x0044
        L_0x0039:
            java.lang.String r4 = r4.o()
            boolean r4 = t3.s.E(r4, r9, r5)
            if (r4 == 0) goto L_0x0044
            goto L_0x005c
        L_0x0044:
            boolean r4 = r3 instanceof R1.L.a
            if (r4 == 0) goto L_0x0059
            R1.L$a r3 = (R1.L.a) r3
            l2.T r3 = r3.b()
            java.lang.String r3 = r3.h()
            boolean r3 = t3.s.E(r3, r9, r5)
            if (r3 == 0) goto L_0x0059
            goto L_0x005c
        L_0x0059:
            r1 = r2
            goto L_0x0018
        L_0x005b:
            r1 = -1
        L_0x005c:
            if (r1 < 0) goto L_0x0084
            z2.B$a r0 = z2.C2940B.f26458v
            z2.B r8 = r0.a(r8)
            r8.a()
            l2.T r9 = r8.G0(r9)
            r8.m()
            if (r9 == 0) goto L_0x0081
            boolean r8 = r9.m()
            if (r8 == 0) goto L_0x0081
            java.util.ArrayList r8 = r7.b()
            r8.remove(r1)
            r7.notifyItemRemoved(r1)
            return
        L_0x0081:
            r7.notifyItemChanged(r1)
        L_0x0084:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: R1.L.g(android.content.Context, java.lang.String):void");
    }

    public int getItemCount() {
        return b().size();
    }

    public int getItemViewType(int i5) {
        Object obj = b().get(i5);
        t.d(obj, "get(...)");
        if (obj instanceof C2655d) {
            if (((C2655d) obj).e() == 1) {
                return 9;
            }
            return 1;
        } else if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.a().e() == 1) {
                return 9;
            }
            if (aVar.b().m()) {
                return 10;
            }
            return 0;
        } else if (obj instanceof String) {
            String str = (String) obj;
            switch (str.hashCode()) {
                case -1764562172:
                    if (str.equals("tracking_disabled")) {
                        return 4;
                    }
                    break;
                case -864119891:
                    if (str.equals("title_recent_updates")) {
                        return 5;
                    }
                    break;
                case 446114743:
                    if (str.equals("warning_not_space")) {
                        return 2;
                    }
                    break;
                case 903589355:
                    if (str.equals("title_ignored")) {
                        return 6;
                    }
                    break;
                case 1477891299:
                    if (str.equals("title_disable_app")) {
                        return 7;
                    }
                    break;
            }
            throw new IllegalArgumentException();
        } else if (obj instanceof c) {
            return 8;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public final void h() {
        this.f4071g = -1;
    }

    public final void i(ArrayList arrayList) {
        t.e(arrayList, "<set-?>");
        this.f4069e = arrayList;
    }

    public final void j(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, Context context) {
        t.e(context, "context");
        a(arrayList, arrayList2, arrayList3, arrayList4, context);
        notifyDataSetChanged();
    }

    /* JADX WARNING: type inference failed for: r8v2, types: [java.util.ArrayList] */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0032, code lost:
        r5 = (l2.C2655d) r4;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void k(java.io.File r12, android.content.Context r13) {
        /*
            r11 = this;
            java.lang.String r0 = "file"
            kotlin.jvm.internal.t.e(r12, r0)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.t.e(r13, r0)
            z2.B$a r0 = z2.C2940B.f26458v
            z2.B r0 = r0.a(r13)
            r0.a()
            java.util.ArrayList r1 = r11.b()
            java.util.Iterator r1 = r1.iterator()
            r2 = 0
        L_0x001c:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x00ed
            int r3 = r2 + 1
            java.lang.Object r4 = r1.next()
            boolean r5 = r4 instanceof l2.C2655d
            java.lang.String r6 = "next(...)"
            java.lang.String r7 = "iterator(...)"
            r8 = 0
            r9 = 1
            if (r5 == 0) goto L_0x008a
            r5 = r4
            l2.d r5 = (l2.C2655d) r5
            java.lang.String r10 = r5.o()
            if (r10 == 0) goto L_0x008a
            int r10 = r10.length()
            if (r10 != 0) goto L_0x0042
            goto L_0x008a
        L_0x0042:
            java.lang.String r4 = r5.o()
            kotlin.jvm.internal.t.b(r4)
            l2.T r4 = r0.G0(r4)
            if (r4 == 0) goto L_0x0053
            l2.q r8 = r4.b(r13)
        L_0x0053:
            if (r8 == 0) goto L_0x00ea
            java.util.ArrayList r4 = r8.o()
            int r4 = r4.size()
            if (r4 <= 0) goto L_0x00ea
            java.util.ArrayList r4 = r8.o()
            java.util.Iterator r4 = r4.iterator()
            kotlin.jvm.internal.t.d(r4, r7)
        L_0x006a:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00ea
            java.lang.Object r5 = r4.next()
            kotlin.jvm.internal.t.d(r5, r6)
            l2.r r5 = (l2.r) r5
            java.lang.String r5 = r5.a()
            java.lang.String r7 = r12.getAbsolutePath()
            boolean r5 = t3.s.E(r5, r7, r9)
            if (r5 == 0) goto L_0x006a
            r11.f4071g = r2
            goto L_0x00ea
        L_0x008a:
            boolean r5 = r4 instanceof R1.L.a
            if (r5 == 0) goto L_0x00ea
            R1.L$a r4 = (R1.L.a) r4
            l2.T r5 = r4.b()
            l2.q r5 = r5.a()
            if (r5 == 0) goto L_0x009e
            java.util.ArrayList r8 = r5.o()
        L_0x009e:
            if (r8 == 0) goto L_0x00ea
            l2.T r5 = r4.b()
            l2.q r5 = r5.a()
            kotlin.jvm.internal.t.b(r5)
            java.util.ArrayList r5 = r5.o()
            int r5 = r5.size()
            if (r5 <= 0) goto L_0x00ea
            l2.T r4 = r4.b()
            l2.q r4 = r4.a()
            kotlin.jvm.internal.t.b(r4)
            java.util.ArrayList r4 = r4.o()
            java.util.Iterator r4 = r4.iterator()
            kotlin.jvm.internal.t.d(r4, r7)
        L_0x00cb:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00ea
            java.lang.Object r5 = r4.next()
            kotlin.jvm.internal.t.d(r5, r6)
            l2.r r5 = (l2.r) r5
            java.lang.String r5 = r5.a()
            java.lang.String r7 = r12.getAbsolutePath()
            boolean r5 = t3.s.E(r5, r7, r9)
            if (r5 == 0) goto L_0x00cb
            r11.f4071g = r2
        L_0x00ea:
            r2 = r3
            goto L_0x001c
        L_0x00ed:
            r0.m()
            int r12 = r11.f4071g
            if (r12 < 0) goto L_0x00f7
            r11.notifyItemChanged(r12)
        L_0x00f7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: R1.L.k(java.io.File, android.content.Context):void");
    }

    public final void l(boolean z4) {
        this.f4072h = z4;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5) {
        t.e(viewHolder, "viewHolder");
        if (viewHolder instanceof C2023i) {
            Object obj = b().get(i5);
            t.c(obj, "null cannot be cast to non-null type com.uptodown.models.App");
            ((C2023i) viewHolder).e((C2655d) obj);
            return;
        }
        boolean z4 = true;
        if (viewHolder instanceof C2069x1) {
            C2069x1 x1Var = (C2069x1) viewHolder;
            Object obj2 = b().get(i5);
            t.c(obj2, "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData");
            a aVar = (a) obj2;
            if (this.f4071g != i5) {
                z4 = false;
            }
            x1Var.n(aVar, z4, this.f4072h);
        } else if (viewHolder instanceof C2033l0) {
            ((C2033l0) viewHolder).e(true);
        } else if (viewHolder instanceof Y1) {
            ((Y1) viewHolder).a(true);
        } else if (viewHolder instanceof C2046p1) {
            ((C2046p1) viewHolder).b(this.f4070f.a());
        } else if (viewHolder instanceof a2) {
            a.C0147a aVar2 = com.uptodown.activities.preferences.a.f15150a;
            Context context = viewHolder.itemView.getContext();
            t.d(context, "getContext(...)");
            ((a2) viewHolder).c(!aVar2.k0(context));
        } else if (viewHolder instanceof C2002b) {
            Object obj3 = b().get(i5);
            t.d(obj3, "get(...)");
            if (obj3 instanceof C2655d) {
                Object obj4 = b().get(i5);
                t.c(obj4, "null cannot be cast to non-null type com.uptodown.models.App");
                ((C2002b) viewHolder).c((C2655d) obj4);
            } else if (obj3 instanceof a) {
                Object obj5 = b().get(i5);
                t.c(obj5, "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData");
                ((C2002b) viewHolder).c(((a) obj5).a());
            }
        } else if (viewHolder instanceof C2040n1) {
            Object obj6 = b().get(i5);
            t.c(obj6, "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData");
            ((C2040n1) viewHolder).c((a) obj6);
        } else {
            throw new IllegalArgumentException("ViewHolder unknown!!");
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "viewGroup");
        switch (i5) {
            case 0:
                return new C2069x1(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.update_item, viewGroup, false), this.f4065a);
            case 1:
                return new C2023i(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.installed_app_item, viewGroup, false), this.f4066b);
            case 2:
                return new Y1(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.warning_not_space_available, viewGroup, false));
            case 4:
                return new a2(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tracking_disabled, viewGroup, false), this.f4067c);
            case 5:
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tv_myappsupdates_title, viewGroup, false);
                String string = viewGroup.getContext().getString(R.string.recent_updates);
                t.d(string, "getString(...)");
                return new C2033l0(inflate, string, (C2612w) null);
            case 6:
                View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tv_myappsupdates_title, viewGroup, false);
                String string2 = viewGroup.getContext().getString(R.string.update_ignored);
                t.d(string2, "getString(...)");
                return new C2033l0(inflate2, string2, (C2612w) null);
            case 7:
                View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tv_myappsupdates_title, viewGroup, false);
                String string3 = viewGroup.getContext().getString(R.string.disabled_apps);
                t.d(string3, "getString(...)");
                return new C2033l0(inflate3, string3, this.f4068d);
            case 8:
                return new C2046p1(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.updates_header, viewGroup, false), this.f4067c);
            case 9:
                return new C2002b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.installed_app_item, viewGroup, false), this.f4066b);
            case 10:
                return new C2040n1(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.installed_app_item, viewGroup, false), this.f4066b);
            default:
                throw new IllegalArgumentException("viewType unknown");
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final C2655d f4074a;

        /* renamed from: b  reason: collision with root package name */
        private final T f4075b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f4076c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f4077d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f4078e;

        public a(C2655d dVar, T t5, boolean z4, boolean z5, boolean z6) {
            t.e(dVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            t.e(t5, "update");
            this.f4074a = dVar;
            this.f4075b = t5;
            this.f4076c = z4;
            this.f4077d = z5;
            this.f4078e = z6;
        }

        public final C2655d a() {
            return this.f4074a;
        }

        public final T b() {
            return this.f4075b;
        }

        public final boolean c() {
            return this.f4078e;
        }

        public final boolean d() {
            return this.f4077d;
        }

        public final boolean e() {
            return this.f4076c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (t.a(this.f4074a, aVar.f4074a) && t.a(this.f4075b, aVar.f4075b) && this.f4076c == aVar.f4076c && this.f4077d == aVar.f4077d && this.f4078e == aVar.f4078e) {
                return true;
            }
            return false;
        }

        public final void f(boolean z4) {
            this.f4078e = z4;
        }

        public final void g(boolean z4) {
            this.f4077d = z4;
        }

        public final void h(boolean z4) {
            this.f4076c = z4;
        }

        public int hashCode() {
            return (((((((this.f4074a.hashCode() * 31) + this.f4075b.hashCode()) * 31) + androidx.privacysandbox.ads.adservices.adid.a.a(this.f4076c)) * 31) + androidx.privacysandbox.ads.adservices.adid.a.a(this.f4077d)) * 31) + androidx.privacysandbox.ads.adservices.adid.a.a(this.f4078e);
        }

        public String toString() {
            return "AppUpdateData(app=" + this.f4074a + ", update=" + this.f4075b + ", isStartAnimationRunning=" + this.f4076c + ", isIconAnimationAplied=" + this.f4077d + ", isEndAnimationRunning=" + this.f4078e + ')';
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ a(l2.C2655d r2, l2.T r3, boolean r4, boolean r5, boolean r6, int r7, kotlin.jvm.internal.C2633k r8) {
            /*
                r1 = this;
                r8 = r7 & 4
                r0 = 0
                if (r8 == 0) goto L_0x0006
                r4 = r0
            L_0x0006:
                r8 = r7 & 8
                if (r8 == 0) goto L_0x000b
                r5 = r0
            L_0x000b:
                r7 = r7 & 16
                if (r7 == 0) goto L_0x0016
                r7 = r0
            L_0x0010:
                r6 = r5
                r5 = r4
                r4 = r3
                r3 = r2
                r2 = r1
                goto L_0x0018
            L_0x0016:
                r7 = r6
                goto L_0x0010
            L_0x0018:
                r2.<init>(r3, r4, r5, r6, r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: R1.L.a.<init>(l2.d, l2.T, boolean, boolean, boolean, int, kotlin.jvm.internal.k):void");
        }
    }
}
