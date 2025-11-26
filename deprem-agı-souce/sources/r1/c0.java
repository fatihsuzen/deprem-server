package R1;

import R1.e0;
import android.view.View;
import l2.C2657f;

public final /* synthetic */ class c0 implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e0.a f4145a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2657f f4146b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f4147c;

    public /* synthetic */ c0(e0.a aVar, C2657f fVar, int i5) {
        this.f4145a = aVar;
        this.f4146b = fVar;
        this.f4147c = i5;
    }

    public final boolean onLongClick(View view) {
        return e0.a.s(this.f4145a, this.f4146b, this.f4147c, view);
    }
}
