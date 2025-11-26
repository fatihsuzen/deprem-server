package R1;

import C2.C2055t;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import k2.C2602l;
import kotlin.jvm.internal.t;
import l2.C2668q;
import t3.s;

/* renamed from: R1.b  reason: case insensitive filesystem */
public final class C0971b extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private final C2602l f4135a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList f4136b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private boolean f4137c;

    /* renamed from: d  reason: collision with root package name */
    private boolean[] f4138d;

    /* renamed from: e  reason: collision with root package name */
    private int f4139e = -1;

    public C0971b(C2602l lVar) {
        t.e(lVar, "listener");
        this.f4135a = lVar;
    }

    private final void a(C2055t tVar, C2668q qVar, boolean z4, boolean z5, int i5) {
        boolean z6;
        if (qVar.f()) {
            if (this.f4139e == i5) {
                z6 = true;
            } else {
                z6 = false;
            }
            tVar.q(qVar, z4, z5, z6);
            return;
        }
        tVar.r(qVar, z4, z5);
    }

    private final void b(ArrayList arrayList, ArrayList arrayList2) {
        this.f4136b = new ArrayList();
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            this.f4136b.addAll(arrayList2);
        }
        if (!arrayList.isEmpty()) {
            this.f4136b.addAll(arrayList);
        }
        this.f4138d = new boolean[this.f4136b.size()];
    }

    public final int c() {
        boolean[] zArr = this.f4138d;
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

    public final ArrayList d() {
        return this.f4136b;
    }

    public final int e(String str) {
        t.e(str, "packagename");
        int i5 = 0;
        for (C2668q w4 : this.f4136b) {
            int i6 = i5 + 1;
            if (s.E(w4.w(), str, true)) {
                return i5;
            }
            i5 = i6;
        }
        return -1;
    }

    public final int f() {
        return this.f4139e;
    }

    public final ArrayList g() {
        ArrayList arrayList = new ArrayList();
        boolean[] zArr = this.f4138d;
        t.b(zArr);
        int length = zArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (zArr[i5]) {
                boolean[] zArr2 = this.f4138d;
                t.b(zArr2);
                if (i5 < zArr2.length) {
                    arrayList.add(this.f4136b.get(i5));
                }
            }
        }
        return arrayList;
    }

    public int getItemCount() {
        return this.f4136b.size();
    }

    public final boolean h() {
        return this.f4137c;
    }

    public final void i(File file, Context context) {
        t.e(file, "file");
        t.e(context, "context");
        Iterator it = this.f4136b.iterator();
        int i5 = 0;
        while (true) {
            if (!it.hasNext()) {
                i5 = -1;
                break;
            }
            int i6 = i5 + 1;
            if (t.a(((C2668q) it.next()).m(context), file)) {
                break;
            }
            i5 = i6;
        }
        if (i5 >= 0) {
            notifyItemChanged(i5);
        }
    }

    public final void j() {
        this.f4139e = -1;
    }

    public final void k(ArrayList arrayList, ArrayList arrayList2) {
        t.e(arrayList, "downloads");
        b(arrayList, arrayList2);
        notifyDataSetChanged();
    }

    public final void l(File file, Context context) {
        t.e(file, "file");
        t.e(context, "context");
        Iterator it = this.f4136b.iterator();
        int i5 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            int i6 = i5 + 1;
            if (t.a(((C2668q) it.next()).m(context), file)) {
                this.f4139e = i5;
                break;
            }
            i5 = i6;
        }
        int i7 = this.f4139e;
        if (i7 >= 0) {
            notifyItemChanged(i7);
        }
    }

    public final void m(int i5) {
        boolean[] zArr = this.f4138d;
        t.b(zArr);
        boolean[] zArr2 = this.f4138d;
        t.b(zArr2);
        zArr[i5] = !zArr2[i5];
        notifyItemChanged(i5);
    }

    public final void n(boolean z4) {
        this.f4137c = z4;
        if (!z4) {
            if (!this.f4136b.isEmpty()) {
                this.f4138d = new boolean[this.f4136b.size()];
            } else {
                this.f4138d = new boolean[0];
            }
        }
        notifyDataSetChanged();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5) {
        t.e(viewHolder, "viewHolder");
        Object obj = this.f4136b.get(i5);
        t.d(obj, "get(...)");
        boolean z4 = this.f4137c;
        boolean[] zArr = this.f4138d;
        t.b(zArr);
        a((C2055t) viewHolder, (C2668q) obj, z4, zArr[i5], i5);
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "viewGroup");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.download_item, viewGroup, false);
        t.b(inflate);
        return new C2055t(inflate, this.f4135a);
    }
}
