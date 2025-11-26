package V1;

import S1.g;
import X1.C2230g;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import f2.e;
import java.util.ArrayList;
import kotlin.jvm.internal.t;

/* renamed from: V1.b  reason: case insensitive filesystem */
public final class C2206b extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private final C2230g f19690a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList f19691b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f19692c;

    /* renamed from: d  reason: collision with root package name */
    private boolean[] f19693d;

    public C2206b(C2230g gVar) {
        t.e(gVar, "listener");
        this.f19690a = gVar;
    }

    public final int a() {
        boolean[] zArr = this.f19693d;
        if (zArr == null) {
            return 0;
        }
        t.b(zArr);
        int i5 = 0;
        for (boolean z4 : zArr) {
            if (z4) {
                i5++;
            }
        }
        return i5;
    }

    public final ArrayList b() {
        ArrayList arrayList = new ArrayList();
        if (this.f19691b != null) {
            boolean[] zArr = this.f19693d;
            t.b(zArr);
            int length = zArr.length;
            for (int i5 = 0; i5 < length; i5++) {
                if (zArr[i5]) {
                    ArrayList arrayList2 = this.f19691b;
                    t.b(arrayList2);
                    arrayList.add(arrayList2.get(i5));
                }
            }
        }
        return arrayList;
    }

    public final boolean c() {
        return this.f19692c;
    }

    /* renamed from: d */
    public void onBindViewHolder(e eVar, int i5) {
        t.e(eVar, "viewHolder");
        ArrayList arrayList = this.f19691b;
        if (arrayList != null) {
            t.b(arrayList);
            Object obj = arrayList.get(i5);
            t.d(obj, "get(...)");
            boolean z4 = this.f19692c;
            boolean[] zArr = this.f19693d;
            t.b(zArr);
            eVar.c(obj, z4, zArr[i5]);
        }
    }

    /* renamed from: e */
    public e onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "viewGroup");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(g.file_item, viewGroup, false);
        t.d(inflate, "inflate(...)");
        return new e(inflate, this.f19690a);
    }

    public final void f(ArrayList arrayList) {
        if (arrayList != null) {
            this.f19691b = arrayList;
            this.f19693d = new boolean[arrayList.size()];
        } else {
            this.f19691b = new ArrayList();
            this.f19693d = new boolean[0];
        }
        notifyDataSetChanged();
    }

    public final void g(int i5) {
        boolean[] zArr = this.f19693d;
        t.b(zArr);
        boolean[] zArr2 = this.f19693d;
        t.b(zArr2);
        zArr[i5] = !zArr2[i5];
        notifyItemChanged(i5);
    }

    public int getItemCount() {
        ArrayList arrayList = this.f19691b;
        if (arrayList == null) {
            return 0;
        }
        t.b(arrayList);
        return arrayList.size();
    }

    public final void h(boolean z4) {
        this.f19692c = z4;
        if (!z4) {
            ArrayList arrayList = this.f19691b;
            if (arrayList != null) {
                t.b(arrayList);
                this.f19693d = new boolean[arrayList.size()];
            } else {
                this.f19693d = new boolean[0];
            }
        }
        notifyDataSetChanged();
    }
}
