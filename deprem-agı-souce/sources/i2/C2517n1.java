package i2;

import android.graphics.drawable.Drawable;
import android.view.View;
import h2.C2398B;

/* renamed from: i2.n1  reason: case insensitive filesystem */
public final /* synthetic */ class C2517n1 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C2540v1 f24307a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2398B f24308b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Drawable f24309c;

    public /* synthetic */ C2517n1(C2540v1 v1Var, C2398B b5, Drawable drawable) {
        this.f24307a = v1Var;
        this.f24308b = b5;
        this.f24309c = drawable;
    }

    public final void onClick(View view) {
        C2540v1.I3(this.f24307a, this.f24308b, this.f24309c, view);
    }
}
