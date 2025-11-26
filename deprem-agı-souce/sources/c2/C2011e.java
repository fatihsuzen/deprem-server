package C2;

import android.view.View;
import l2.C2657f;

/* renamed from: C2.e  reason: case insensitive filesystem */
public final /* synthetic */ class C2011e implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C2014f f17732a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2657f f17733b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f17734c;

    public /* synthetic */ C2011e(C2014f fVar, C2657f fVar2, int i5) {
        this.f17732a = fVar;
        this.f17733b = fVar2;
        this.f17734c = i5;
    }

    public final boolean onLongClick(View view) {
        return C2014f.n(this.f17732a, this.f17733b, this.f17734c, view);
    }
}
