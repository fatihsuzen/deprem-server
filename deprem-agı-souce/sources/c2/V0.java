package C2;

import android.view.View;
import l2.C2657f;

public final /* synthetic */ class V0 implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Y0 f17630a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2657f f17631b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f17632c;

    public /* synthetic */ V0(Y0 y02, C2657f fVar, int i5) {
        this.f17630a = y02;
        this.f17631b = fVar;
        this.f17632c = i5;
    }

    public final boolean onLongClick(View view) {
        return Y0.p(this.f17630a, this.f17631b, this.f17632c, view);
    }
}
