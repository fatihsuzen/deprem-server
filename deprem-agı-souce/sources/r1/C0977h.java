package R1;

import R1.C0978i;
import android.view.View;
import l2.C2657f;

/* renamed from: R1.h  reason: case insensitive filesystem */
public final /* synthetic */ class C0977h implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0978i.a f4215a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2657f f4216b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f4217c;

    public /* synthetic */ C0977h(C0978i.a aVar, C2657f fVar, int i5) {
        this.f4215a = aVar;
        this.f4216b = fVar;
        this.f4217c = i5;
    }

    public final boolean onLongClick(View view) {
        return C0978i.a.e(this.f4215a, this.f4216b, this.f4217c, view);
    }
}
