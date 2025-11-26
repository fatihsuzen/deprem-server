package R1;

import C2.C2015f0;
import C2.D;
import C2.H;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import h2.L;
import h2.N;
import java.util.ArrayList;
import k2.C2603m;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2672v;

/* renamed from: R1.c  reason: case insensitive filesystem */
public final class C0972c extends RecyclerView.Adapter {

    /* renamed from: d  reason: collision with root package name */
    public static final a f4141d = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f4142a;

    /* renamed from: b  reason: collision with root package name */
    private final C2603m f4143b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4144c;

    /* renamed from: R1.c$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public C0972c(ArrayList arrayList, C2603m mVar) {
        t.e(arrayList, "feed");
        t.e(mVar, "listener");
        this.f4142a = arrayList;
        this.f4143b = mVar;
    }

    public final void a(C2672v vVar) {
        t.e(vVar, "feedItem");
        this.f4142a.add(vVar);
        notifyItemInserted(getItemCount());
    }

    public final ArrayList b() {
        return this.f4142a;
    }

    public final void c(boolean z4) {
        this.f4144c = z4;
        if (z4) {
            notifyItemInserted(getItemCount());
        } else {
            notifyItemRemoved(getItemCount());
        }
    }

    public int getItemCount() {
        return this.f4142a.size() + (this.f4144c ? 1 : 0);
    }

    public int getItemViewType(int i5) {
        if (i5 == this.f4142a.size()) {
            return 2;
        }
        Object obj = this.f4142a.get(i5);
        t.d(obj, "get(...)");
        if (t.a(((C2672v) obj).r(), "subscription")) {
            return 1;
        }
        return 0;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5) {
        t.e(viewHolder, "viewHolder");
        if (viewHolder instanceof D) {
            Object obj = this.f4142a.get(i5);
            t.d(obj, "get(...)");
            ((D) viewHolder).i((C2672v) obj);
        } else if (viewHolder instanceof H) {
            Object obj2 = this.f4142a.get(i5);
            t.d(obj2, "get(...)");
            ((H) viewHolder).d((C2672v) obj2);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "viewGroup");
        if (i5 == 0) {
            L c5 = L.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            t.d(c5, "inflate(...)");
            return new D(c5, this.f4143b);
        } else if (i5 == 1) {
            N c6 = N.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            t.d(c6, "inflate(...)");
            return new H(c6, this.f4143b);
        } else if (i5 == 2) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pb_loading_more_content, viewGroup, false);
            t.b(inflate);
            return new C2015f0(inflate);
        } else {
            throw new IllegalArgumentException("viewType unknown");
        }
    }
}
