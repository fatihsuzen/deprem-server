package R1;

import C2.C2014f;
import C2.C2015f0;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import java.util.ArrayList;
import java.util.Iterator;
import k2.C2591a;
import k2.C2594d;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2657f;

public final class E extends RecyclerView.Adapter {

    /* renamed from: d  reason: collision with root package name */
    public static final a f4004d = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f4005a;

    /* renamed from: b  reason: collision with root package name */
    private final C2594d f4006b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4007c;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public E(ArrayList arrayList, C2594d dVar) {
        t.e(arrayList, "searchResults");
        t.e(dVar, "listener");
        this.f4005a = arrayList;
        this.f4006b = dVar;
    }

    public final void a(ArrayList arrayList) {
        t.e(arrayList, DataSchemeDataSource.SCHEME_DATA);
        Iterator it = arrayList.iterator();
        t.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            t.d(next, "next(...)");
            C2657f fVar = (C2657f) next;
            if (!this.f4005a.contains(fVar)) {
                this.f4005a.add(fVar);
            }
        }
        notifyDataSetChanged();
    }

    public final ArrayList b() {
        return this.f4005a;
    }

    public final void c(ArrayList arrayList) {
        t.e(arrayList, DataSchemeDataSource.SCHEME_DATA);
        this.f4005a = arrayList;
        notifyDataSetChanged();
    }

    public final void d(boolean z4) {
        this.f4007c = z4;
        if (z4) {
            notifyItemInserted(getItemCount());
        } else {
            notifyItemRemoved(getItemCount());
        }
    }

    public int getItemCount() {
        return this.f4005a.size() + (this.f4007c ? 1 : 0);
    }

    public int getItemViewType(int i5) {
        if (i5 == this.f4005a.size()) {
            return 1;
        }
        return 0;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5) {
        t.e(viewHolder, "viewHolder");
        if (viewHolder instanceof C2014f) {
            Object obj = this.f4005a.get(i5);
            t.d(obj, "get(...)");
            ((C2014f) viewHolder).m((C2657f) obj, i5);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "viewGroup");
        if (i5 == 0) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.search_app_info_item, viewGroup, false);
            t.b(inflate);
            return new C2014f(inflate, this.f4006b, (C2591a) null);
        } else if (i5 == 1) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pb_loading_more_content, viewGroup, false);
            t.b(inflate2);
            return new C2015f0(inflate2);
        } else {
            throw new IllegalArgumentException("viewType unknown");
        }
    }
}
