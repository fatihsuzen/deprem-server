package R1;

import C2.C2015f0;
import C2.H1;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import java.util.ArrayList;
import java.util.Iterator;
import k2.M;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.O;

public final class P extends RecyclerView.Adapter {

    /* renamed from: d  reason: collision with root package name */
    public static final a f4101d = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f4102a;

    /* renamed from: b  reason: collision with root package name */
    private final M f4103b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4104c;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public P(ArrayList arrayList, M m5) {
        t.e(arrayList, "reviews");
        t.e(m5, "listener");
        this.f4102a = arrayList;
        this.f4103b = m5;
    }

    public final void a(ArrayList arrayList) {
        t.e(arrayList, DataSchemeDataSource.SCHEME_DATA);
        this.f4102a.addAll(arrayList);
        notifyDataSetChanged();
    }

    public final ArrayList b() {
        return this.f4102a;
    }

    public final void c(boolean z4) {
        this.f4104c = z4;
        if (z4) {
            notifyItemInserted(getItemCount());
        } else {
            notifyItemRemoved(getItemCount());
        }
    }

    public final void d(O o5) {
        t.e(o5, "review");
        Iterator it = this.f4102a.iterator();
        int i5 = 0;
        while (true) {
            if (!it.hasNext()) {
                i5 = -1;
                break;
            }
            int i6 = i5 + 1;
            if (((O) it.next()).g() == o5.g()) {
                break;
            }
            i5 = i6;
        }
        this.f4102a.set(i5, o5);
        notifyItemChanged(i5);
    }

    public int getItemCount() {
        return this.f4102a.size() + (this.f4104c ? 1 : 0);
    }

    public int getItemViewType(int i5) {
        if (i5 == this.f4102a.size()) {
            return 1;
        }
        return 0;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5) {
        t.e(viewHolder, "viewHolder");
        if (viewHolder instanceof H1) {
            Object obj = this.f4102a.get(i5);
            t.d(obj, "get(...)");
            ((H1) viewHolder).h((O) obj, i5);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "viewGroup");
        if (i5 == 0) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.review, viewGroup, false);
            M m5 = this.f4103b;
            Context context = viewGroup.getContext();
            t.d(context, "getContext(...)");
            return new H1(inflate, m5, context);
        } else if (i5 == 1) {
            return new C2015f0(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pb_loading_more_content, viewGroup, false));
        } else {
            throw new IllegalArgumentException("viewType unknown");
        }
    }
}
