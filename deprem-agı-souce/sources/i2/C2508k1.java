package i2;

import android.graphics.drawable.Drawable;
import android.view.View;
import h2.C2398B;

/* renamed from: i2.k1  reason: case insensitive filesystem */
public final /* synthetic */ class C2508k1 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C2540v1 f24288a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2398B f24289b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Drawable f24290c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Drawable f24291d;

    public /* synthetic */ C2508k1(C2540v1 v1Var, C2398B b5, Drawable drawable, Drawable drawable2) {
        this.f24288a = v1Var;
        this.f24289b = b5;
        this.f24290c = drawable;
        this.f24291d = drawable2;
    }

    public final void onClick(View view) {
        C2540v1.F3(this.f24288a, this.f24289b, this.f24290c, this.f24291d, view);
    }
}
