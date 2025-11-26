package R1;

import C2.Q0;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import java.util.ArrayList;
import k2.C2590G;
import kotlin.jvm.internal.t;
import l2.C2655d;

public final class C extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f3998a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f3999b;

    /* renamed from: c  reason: collision with root package name */
    private final C2590G f4000c;

    public C(ArrayList arrayList, Context context, C2590G g5) {
        t.e(arrayList, "rollbackApps");
        t.e(context, "context");
        t.e(g5, "listener");
        this.f3998a = arrayList;
        this.f3999b = context;
        this.f4000c = g5;
    }

    public final ArrayList a() {
        return this.f3998a;
    }

    /* renamed from: b */
    public void onBindViewHolder(Q0 q02, int i5) {
        t.e(q02, "viewHolder");
        Object obj = this.f3998a.get(i5);
        t.d(obj, "get(...)");
        q02.e((C2655d) obj, this.f3999b);
    }

    /* renamed from: c */
    public Q0 onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "viewGroup");
        View inflate = LayoutInflater.from(this.f3999b).inflate(R.layout.rollback_item, viewGroup, false);
        t.b(inflate);
        return new Q0(inflate, this.f4000c);
    }

    public final void d(ArrayList arrayList) {
        if (arrayList != null) {
            this.f3998a = new ArrayList(arrayList);
        } else {
            this.f3998a = new ArrayList();
        }
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.f3998a.size();
    }
}
