package R1;

import C2.C2015f0;
import C2.N;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import h2.P;
import java.util.ArrayList;
import k2.C2605o;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.V;

/* renamed from: R1.d  reason: case insensitive filesystem */
public final class C0973d extends RecyclerView.Adapter {

    /* renamed from: d  reason: collision with root package name */
    public static final a f4148d = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f4149a;

    /* renamed from: b  reason: collision with root package name */
    private final C2605o f4150b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4151c;

    /* renamed from: R1.d$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public C0973d(ArrayList arrayList, C2605o oVar) {
        t.e(arrayList, "followList");
        t.e(oVar, "listener");
        this.f4149a = arrayList;
        this.f4150b = oVar;
    }

    public final void a(V v5) {
        t.e(v5, "user");
        this.f4149a.add(v5);
        notifyItemInserted(getItemCount());
    }

    public final ArrayList b() {
        return this.f4149a;
    }

    public final void c(boolean z4) {
        this.f4151c = z4;
        if (z4) {
            notifyItemInserted(getItemCount());
        } else {
            notifyItemRemoved(getItemCount());
        }
    }

    public int getItemCount() {
        return this.f4149a.size() + (this.f4151c ? 1 : 0);
    }

    public int getItemViewType(int i5) {
        if (i5 == this.f4149a.size()) {
            return 1;
        }
        return 0;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5) {
        t.e(viewHolder, "viewHolder");
        if (viewHolder instanceof N) {
            Object obj = this.f4149a.get(i5);
            t.d(obj, "get(...)");
            ((N) viewHolder).c((V) obj, i5);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "viewGroup");
        if (i5 == 0) {
            P c5 = P.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            t.d(c5, "inflate(...)");
            return new N(c5, this.f4150b);
        } else if (i5 == 1) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pb_loading_more_content, viewGroup, false);
            t.b(inflate);
            return new C2015f0(inflate);
        } else {
            throw new IllegalArgumentException("viewType unknown");
        }
    }
}
