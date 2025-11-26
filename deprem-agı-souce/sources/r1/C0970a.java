package R1;

import C2.C2008d;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import java.util.ArrayList;
import k2.C2593c;
import kotlin.jvm.internal.t;
import l2.C2673w;

/* renamed from: R1.a  reason: case insensitive filesystem */
public final class C0970a extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f4126a;

    /* renamed from: b  reason: collision with root package name */
    private final C2593c f4127b;

    public C0970a(ArrayList arrayList, C2593c cVar) {
        t.e(cVar, "listener");
        this.f4126a = arrayList;
        this.f4127b = cVar;
    }

    /* renamed from: a */
    public void onBindViewHolder(C2008d dVar, int i5) {
        C2673w wVar;
        t.e(dVar, "viewHolder");
        ArrayList arrayList = this.f4126a;
        if (arrayList != null) {
            wVar = (C2673w) arrayList.get(i5);
        } else {
            wVar = null;
        }
        t.b(wVar);
        dVar.b(wVar);
    }

    /* renamed from: b */
    public C2008d onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "viewGroup");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.app_file_item, viewGroup, false);
        t.b(inflate);
        return new C2008d(inflate, this.f4127b);
    }

    public int getItemCount() {
        ArrayList arrayList = this.f4126a;
        if (arrayList == null) {
            return 0;
        }
        t.b(arrayList);
        return arrayList.size();
    }
}
