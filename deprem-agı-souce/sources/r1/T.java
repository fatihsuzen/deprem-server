package R1;

import C2.C2015f0;
import C2.S1;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import h2.n1;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import k2.X;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2668q;
import l2.Y;
import l2.r;
import t3.s;
import z2.C2940B;

public final class T extends RecyclerView.Adapter {

    /* renamed from: f  reason: collision with root package name */
    public static final a f4109f = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f4110a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f4111b;

    /* renamed from: c  reason: collision with root package name */
    private final X f4112c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4113d;

    /* renamed from: e  reason: collision with root package name */
    private int f4114e = -1;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public T(ArrayList arrayList, Context context, X x4) {
        t.e(arrayList, "userList");
        t.e(context, "context");
        t.e(x4, "listener");
        this.f4110a = arrayList;
        this.f4111b = context;
        this.f4112c = x4;
    }

    public final void a(ArrayList arrayList) {
        t.e(arrayList, DataSchemeDataSource.SCHEME_DATA);
        this.f4110a.addAll(arrayList);
        notifyDataSetChanged();
    }

    public final ArrayList b() {
        return this.f4110a;
    }

    public final void c(File file, Context context) {
        C2668q qVar;
        t.e(file, "file");
        t.e(context, "context");
        C2940B a5 = C2940B.f26458v.a(context);
        a5.a();
        Iterator it = this.f4110a.iterator();
        int i5 = 0;
        while (true) {
            if (!it.hasNext()) {
                i5 = -1;
                break;
            }
            int i6 = i5 + 1;
            Y y4 = (Y) it.next();
            String g5 = y4.g();
            if (!(g5 == null || g5.length() == 0)) {
                String g6 = y4.g();
                t.b(g6);
                l2.T G02 = a5.G0(g6);
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

    public final void d() {
        this.f4114e = -1;
        notifyDataSetChanged();
    }

    public final void e(File file, Context context) {
        C2668q qVar;
        t.e(file, "file");
        t.e(context, "context");
        C2940B a5 = C2940B.f26458v.a(context);
        a5.a();
        Iterator it = this.f4110a.iterator();
        int i5 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            int i6 = i5 + 1;
            Y y4 = (Y) it.next();
            String g5 = y4.g();
            if (!(g5 == null || g5.length() == 0)) {
                String g6 = y4.g();
                t.b(g6);
                l2.T G02 = a5.G0(g6);
                if (G02 != null) {
                    qVar = G02.b(context);
                } else {
                    qVar = null;
                }
                if (qVar != null && qVar.o().size() == 1 && s.E(((r) qVar.o().get(0)).a(), file.getAbsolutePath(), true)) {
                    this.f4114e = i5;
                    break;
                }
            }
            i5 = i6;
        }
        a5.m();
        int i7 = this.f4114e;
        if (i7 >= 0) {
            notifyItemChanged(i7);
        }
    }

    public final void f(boolean z4) {
        this.f4113d = z4;
        if (z4) {
            notifyItemInserted(getItemCount());
        } else {
            notifyItemRemoved(getItemCount());
        }
    }

    public int getItemCount() {
        return this.f4110a.size() + (this.f4113d ? 1 : 0);
    }

    public int getItemViewType(int i5) {
        if (i5 == this.f4110a.size()) {
            return 1;
        }
        return 0;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5) {
        boolean z4;
        t.e(viewHolder, "viewHolder");
        if (viewHolder instanceof S1) {
            S1 s12 = (S1) viewHolder;
            Object obj = this.f4110a.get(i5);
            t.d(obj, "get(...)");
            Y y4 = (Y) obj;
            if (this.f4114e == i5) {
                z4 = true;
            } else {
                z4 = false;
            }
            s12.n(y4, z4);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "viewGroup");
        if (i5 == 0) {
            n1 c5 = n1.c(LayoutInflater.from(this.f4111b), viewGroup, false);
            t.d(c5, "inflate(...)");
            return new S1(c5, this.f4111b, this.f4112c);
        } else if (i5 == 1) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pb_loading_more_content, viewGroup, false);
            t.b(inflate);
            return new C2015f0(inflate);
        } else {
            throw new IllegalArgumentException("viewType unknown");
        }
    }
}
