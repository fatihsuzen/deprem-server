package R1;

import R1.K;
import android.view.View;
import l2.C2657f;

public final /* synthetic */ class J implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ K f4047a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2657f f4048b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f4049c;

    public /* synthetic */ J(K k5, C2657f fVar, int i5) {
        this.f4047a = k5;
        this.f4048b = fVar;
        this.f4049c = i5;
    }

    public final boolean onLongClick(View view) {
        return K.a.n(this.f4047a, this.f4048b, this.f4049c, view);
    }
}
