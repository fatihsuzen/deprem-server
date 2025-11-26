package R1;

import R1.e0;
import android.view.View;
import l2.C2657f;

public final /* synthetic */ class d0 implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e0.a f4152a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2657f f4153b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f4154c;

    public /* synthetic */ d0(e0.a aVar, C2657f fVar, int i5) {
        this.f4152a = aVar;
        this.f4153b = fVar;
        this.f4154c = i5;
    }

    public final boolean onLongClick(View view) {
        return e0.a.p(this.f4152a, this.f4153b, this.f4154c, view);
    }
}
