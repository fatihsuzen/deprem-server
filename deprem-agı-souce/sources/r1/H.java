package R1;

import R1.I;
import android.view.View;
import l2.C2657f;

public final /* synthetic */ class H implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ I f4029a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2657f f4030b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f4031c;

    public /* synthetic */ H(I i5, C2657f fVar, int i6) {
        this.f4029a = i5;
        this.f4030b = fVar;
        this.f4031c = i6;
    }

    public final boolean onLongClick(View view) {
        return I.a.n(this.f4029a, this.f4030b, this.f4031c, view);
    }
}
