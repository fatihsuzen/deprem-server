package V1;

import X1.l;
import Y1.f;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.recyclerview.widget.RecyclerView;
import f2.g;
import java.util.ArrayList;
import kotlin.jvm.internal.t;

/* renamed from: V1.c  reason: case insensitive filesystem */
public final class C2207c extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private final l f19694a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList f19695b;

    public C2207c(ArrayList arrayList, l lVar) {
        t.e(lVar, "listener");
        this.f19694a = lVar;
        this.f19695b = arrayList;
    }

    /* renamed from: a */
    public void onBindViewHolder(g gVar, int i5) {
        t.e(gVar, "viewHolder");
        CheckBox checkBox = gVar.f21623a;
        ArrayList arrayList = this.f19695b;
        t.b(arrayList);
        checkBox.setText(((f) arrayList.get(i5)).d());
        CheckBox checkBox2 = gVar.f21623a;
        ArrayList arrayList2 = this.f19695b;
        t.b(arrayList2);
        checkBox2.setChecked(((f) arrayList2.get(i5)).a());
        CheckBox checkBox3 = gVar.f21623a;
        ArrayList arrayList3 = this.f19695b;
        t.b(arrayList3);
        checkBox3.setEnabled(((f) arrayList3.get(i5)).b());
    }

    /* renamed from: b */
    public g onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "viewGroup");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(S1.g.split_item, viewGroup, false);
        t.b(inflate);
        return new g(inflate, this.f19694a);
    }

    public int getItemCount() {
        ArrayList arrayList = this.f19695b;
        t.b(arrayList);
        return arrayList.size();
    }
}
