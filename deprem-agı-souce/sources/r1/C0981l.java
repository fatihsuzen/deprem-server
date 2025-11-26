package R1;

import R1.C0980k;
import android.view.View;
import l2.C2657f;

/* renamed from: R1.l  reason: case insensitive filesystem */
public final /* synthetic */ class C0981l implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0980k.b f4260a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2657f f4261b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f4262c;

    public /* synthetic */ C0981l(C0980k.b bVar, C2657f fVar, int i5) {
        this.f4260a = bVar;
        this.f4261b = fVar;
        this.f4262c = i5;
    }

    public final boolean onLongClick(View view) {
        return C0980k.b.n(this.f4260a, this.f4261b, this.f4262c, view);
    }
}
