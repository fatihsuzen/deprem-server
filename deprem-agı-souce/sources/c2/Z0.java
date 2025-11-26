package C2;

import android.view.View;
import l2.C2657f;

public final /* synthetic */ class Z0 implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C2016f1 f17684a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2657f f17685b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f17686c;

    public /* synthetic */ Z0(C2016f1 f1Var, C2657f fVar, int i5) {
        this.f17684a = f1Var;
        this.f17685b = fVar;
        this.f17686c = i5;
    }

    public final boolean onLongClick(View view) {
        return C2016f1.s(this.f17684a, this.f17685b, this.f17686c, view);
    }
}
