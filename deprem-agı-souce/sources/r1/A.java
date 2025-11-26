package R1;

import C2.C2015f0;
import C2.G0;
import X2.C2250q;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import java.util.ArrayList;
import java.util.Iterator;
import k2.C2588E;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2651K;

public final class A extends RecyclerView.Adapter {

    /* renamed from: e  reason: collision with root package name */
    public static final a f3988e = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f3989a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f3990b;

    /* renamed from: c  reason: collision with root package name */
    private final C2588E f3991c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3992d;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public A(ArrayList arrayList, Context context, C2588E e5) {
        t.e(arrayList, "datos");
        t.e(context, "context");
        t.e(e5, "listener");
        this.f3989a = arrayList;
        this.f3990b = context;
        this.f3991c = e5;
    }

    public final void a(ArrayList arrayList) {
        t.e(arrayList, "replies");
        Iterator it = arrayList.iterator();
        t.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            t.d(next, "next(...)");
            this.f3989a.add((C2651K) next);
            notifyItemInserted(C2250q.i(this.f3989a));
        }
    }

    public final ArrayList b() {
        return this.f3989a;
    }

    public final void c(boolean z4) {
        this.f3992d = z4;
        if (z4) {
            notifyItemInserted(getItemCount());
        } else {
            notifyItemRemoved(getItemCount());
        }
    }

    public final void d(C2651K k5) {
        t.e(k5, "reply");
        Iterator it = this.f3989a.iterator();
        int i5 = 0;
        while (true) {
            if (!it.hasNext()) {
                i5 = -1;
                break;
            }
            int i6 = i5 + 1;
            if (((C2651K) it.next()).d() == k5.d()) {
                break;
            }
            i5 = i6;
        }
        this.f3989a.set(i5, k5);
        notifyItemChanged(i5);
    }

    public int getItemCount() {
        return this.f3989a.size() + (this.f3992d ? 1 : 0);
    }

    public int getItemViewType(int i5) {
        if (i5 == this.f3989a.size()) {
            return 1;
        }
        return 0;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5) {
        t.e(viewHolder, "viewHolder");
        if (viewHolder instanceof G0) {
            Object obj = this.f3989a.get(i5);
            t.d(obj, "get(...)");
            ((G0) viewHolder).f((C2651K) obj, i5);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "viewGroup");
        if (i5 == 0) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.reply, viewGroup, false);
            t.b(inflate);
            return new G0(inflate, this.f3990b, this.f3991c);
        } else if (i5 == 1) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pb_loading_more_content, viewGroup, false);
            t.b(inflate2);
            return new C2015f0(inflate2);
        } else {
            throw new IllegalArgumentException("viewType unknown");
        }
    }
}
