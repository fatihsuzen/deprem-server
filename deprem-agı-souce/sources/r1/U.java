package R1;

import C2.V1;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import h2.p1;
import java.util.ArrayList;
import k2.O;
import kotlin.jvm.internal.t;
import l2.Z;

public final class U extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList f4115a;

    /* renamed from: b  reason: collision with root package name */
    private final O f4116b;

    public U(ArrayList arrayList, O o5) {
        t.e(arrayList, "userDevices");
        t.e(o5, "listener");
        this.f4115a = arrayList;
        this.f4116b = o5;
    }

    /* renamed from: a */
    public void onBindViewHolder(V1 v12, int i5) {
        t.e(v12, "viewHolder");
        Object obj = this.f4115a.get(i5);
        t.d(obj, "get(...)");
        v12.c((Z) obj);
    }

    /* renamed from: b */
    public V1 onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "viewGroup");
        p1 c5 = p1.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        t.d(c5, "inflate(...)");
        return new V1(c5, this.f4116b);
    }

    public int getItemCount() {
        return this.f4115a.size();
    }
}
