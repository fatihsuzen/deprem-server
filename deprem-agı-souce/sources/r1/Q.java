package R1;

import C2.K1;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import h2.i1;
import java.util.ArrayList;
import k2.C2592b;
import kotlin.jvm.internal.t;
import l2.X;

public final class Q extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f4105a;

    /* renamed from: b  reason: collision with root package name */
    private final C2592b f4106b;

    public Q(ArrayList arrayList, C2592b bVar) {
        t.e(arrayList, "userDeviceApps");
        t.e(bVar, "listener");
        this.f4105a = arrayList;
        this.f4106b = bVar;
    }

    public final ArrayList a() {
        return this.f4105a;
    }

    /* renamed from: b */
    public void onBindViewHolder(K1 k12, int i5) {
        t.e(k12, "viewHolder");
        Object obj = this.f4105a.get(i5);
        t.d(obj, "get(...)");
        k12.f((X.c) obj);
    }

    /* renamed from: c */
    public K1 onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "viewGroup");
        i1 c5 = i1.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        t.d(c5, "inflate(...)");
        return new K1(c5, this.f4106b);
    }

    public final void d(ArrayList arrayList) {
        t.e(arrayList, "userDeviceApps");
        this.f4105a = arrayList;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.f4105a.size();
    }
}
