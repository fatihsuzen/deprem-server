package R1;

import C2.N1;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import h2.k1;
import java.util.ArrayList;
import k2.O;
import kotlin.jvm.internal.t;
import l2.X;

public final class S extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList f4107a;

    /* renamed from: b  reason: collision with root package name */
    private final O f4108b;

    public S(ArrayList arrayList, O o5) {
        t.e(arrayList, "userDevices");
        t.e(o5, "listener");
        this.f4107a = arrayList;
        this.f4108b = o5;
    }

    /* renamed from: a */
    public void onBindViewHolder(N1 n12, int i5) {
        t.e(n12, "viewHolder");
        Object obj = this.f4107a.get(i5);
        t.d(obj, "get(...)");
        n12.e((X) obj);
    }

    /* renamed from: b */
    public N1 onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "viewGroup");
        k1 c5 = k1.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        t.d(c5, "inflate(...)");
        return new N1(c5, this.f4108b);
    }

    public int getItemCount() {
        return this.f4107a.size();
    }
}
