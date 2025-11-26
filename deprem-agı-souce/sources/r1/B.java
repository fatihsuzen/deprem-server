package R1;

import C2.C2015f0;
import C2.N0;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import java.util.ArrayList;
import java.util.Iterator;
import k2.C2589F;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.O;

public final class B extends RecyclerView.Adapter {

    /* renamed from: e  reason: collision with root package name */
    public static final a f3993e = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f3994a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f3995b;

    /* renamed from: c  reason: collision with root package name */
    private final C2589F f3996c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3997d;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public B(ArrayList arrayList, Context context, C2589F f5) {
        t.e(arrayList, "datos");
        t.e(context, "context");
        t.e(f5, "listener");
        this.f3994a = arrayList;
        this.f3995b = context;
        this.f3996c = f5;
    }

    public final void a(O o5) {
        t.e(o5, "review");
        this.f3994a.add(o5);
        notifyItemInserted(getItemCount());
    }

    public final ArrayList b() {
        return this.f3994a;
    }

    public final void c(boolean z4) {
        this.f3997d = z4;
        if (z4) {
            notifyItemInserted(getItemCount());
        } else {
            notifyItemRemoved(getItemCount());
        }
    }

    public final void d(O o5) {
        t.e(o5, "review");
        Iterator it = this.f3994a.iterator();
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
        this.f3994a.set(i5, o5);
        notifyItemChanged(i5);
    }

    public int getItemCount() {
        return this.f3994a.size() + (this.f3997d ? 1 : 0);
    }

    public int getItemViewType(int i5) {
        if (i5 == this.f3994a.size()) {
            return 2;
        }
        if (((O) this.f3994a.get(i5)).p()) {
            return 1;
        }
        return 0;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5) {
        t.e(viewHolder, "viewHolder");
        if (viewHolder instanceof N0) {
            Object obj = this.f3994a.get(i5);
            t.d(obj, "get(...)");
            O o5 = (O) obj;
            if (o5.p()) {
                ((N0) viewHolder).h(o5, i5);
            } else {
                ((N0) viewHolder).g(o5, i5);
            }
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "viewGroup");
        if (i5 == 1) {
            return new N0(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.review_turbo, viewGroup, false), this.f3995b, this.f3996c);
        }
        if (i5 != 2) {
            return new N0(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.review, viewGroup, false), this.f3995b, this.f3996c);
        }
        return new C2015f0(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pb_loading_more_content, viewGroup, false));
    }
}
