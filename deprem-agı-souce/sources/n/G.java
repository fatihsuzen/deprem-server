package N;

import K.C0661h;
import L.C0668a;
import android.content.Context;
import android.util.SparseIntArray;

public final class G {

    /* renamed from: a  reason: collision with root package name */
    private final SparseIntArray f2987a = new SparseIntArray();

    /* renamed from: b  reason: collision with root package name */
    private C0661h f2988b;

    public G(C0661h hVar) {
        C0722p.k(hVar);
        this.f2988b = hVar;
    }

    public final int a(Context context, int i5) {
        return this.f2987a.get(i5, -1);
    }

    public final int b(Context context, C0668a.f fVar) {
        C0722p.k(context);
        C0722p.k(fVar);
        int i5 = 0;
        if (!fVar.j()) {
            return 0;
        }
        int k5 = fVar.k();
        int a5 = a(context, k5);
        if (a5 != -1) {
            return a5;
        }
        int i6 = 0;
        while (true) {
            if (i6 >= this.f2987a.size()) {
                i5 = -1;
                break;
            }
            int keyAt = this.f2987a.keyAt(i6);
            if (keyAt > k5 && this.f2987a.get(keyAt) == 0) {
                break;
            }
            i6++;
        }
        if (i5 == -1) {
            i5 = this.f2988b.h(context, k5);
        }
        this.f2987a.put(k5, i5);
        return i5;
    }

    public final void c() {
        this.f2987a.clear();
    }
}
