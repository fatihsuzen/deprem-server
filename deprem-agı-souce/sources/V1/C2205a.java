package V1;

import S1.g;
import X1.C2233j;
import Z1.h;
import android.net.nsd.NsdServiceInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import f2.b;
import java.util.ArrayList;
import kotlin.jvm.internal.t;

/* renamed from: V1.a  reason: case insensitive filesystem */
public final class C2205a extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f19688a;

    /* renamed from: b  reason: collision with root package name */
    private C2233j f19689b;

    public C2205a(ArrayList arrayList, C2233j jVar) {
        t.e(jVar, "listener");
        this.f19688a = arrayList;
        this.f19689b = jVar;
    }

    /* renamed from: a */
    public void onBindViewHolder(b bVar, int i5) {
        t.e(bVar, "holder");
        TextView c5 = bVar.c();
        h.a aVar = h.f20257h;
        ArrayList arrayList = this.f19688a;
        t.b(arrayList);
        String serviceName = ((NsdServiceInfo) arrayList.get(i5)).getServiceName();
        t.d(serviceName, "getServiceName(...)");
        c5.setText(aVar.c(serviceName));
    }

    /* renamed from: b */
    public b onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(g.device_item, viewGroup, false);
        t.d(inflate, "inflate(...)");
        return new b(inflate, this.f19689b);
    }

    public int getItemCount() {
        ArrayList arrayList = this.f19688a;
        t.b(arrayList);
        return arrayList.size();
    }
}
