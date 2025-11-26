package R1;

import C2.C2014f;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import java.util.ArrayList;
import k2.C2591a;
import k2.C2611v;
import kotlin.jvm.internal.t;
import l2.C2657f;

/* renamed from: R1.m  reason: case insensitive filesystem */
public final class C0982m extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private C2611v f4263a;

    /* renamed from: b  reason: collision with root package name */
    private C2591a f4264b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList f4265c = new ArrayList();

    public C0982m(C2611v vVar, C2591a aVar) {
        t.e(vVar, "listener");
        t.e(aVar, "actionsClickListener");
        this.f4263a = vVar;
        this.f4264b = aVar;
    }

    public final ArrayList a() {
        return this.f4265c;
    }

    /* renamed from: b */
    public void onBindViewHolder(C2014f fVar, int i5) {
        t.e(fVar, "holder");
        Object obj = this.f4265c.get(i5);
        t.d(obj, "get(...)");
        fVar.m((C2657f) obj, i5);
    }

    /* renamed from: c */
    public C2014f onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.app_info_item_small, viewGroup, false);
        t.b(inflate);
        return new C2014f(inflate, this.f4263a, this.f4264b);
    }

    public final void d(ArrayList arrayList) {
        t.e(arrayList, "appList");
        ArrayList arrayList2 = this.f4265c;
        arrayList2.clear();
        arrayList2.addAll(arrayList);
    }

    public int getItemCount() {
        return this.f4265c.size();
    }
}
