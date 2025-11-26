package i2;

import android.graphics.drawable.Drawable;
import android.view.View;
import h2.C2398B;

/* renamed from: i2.l1  reason: case insensitive filesystem */
public final /* synthetic */ class C2511l1 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C2540v1 f24294a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2398B f24295b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Drawable f24296c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Drawable f24297d;

    public /* synthetic */ C2511l1(C2540v1 v1Var, C2398B b5, Drawable drawable, Drawable drawable2) {
        this.f24294a = v1Var;
        this.f24295b = b5;
        this.f24296c = drawable;
        this.f24297d = drawable2;
    }

    public final void onClick(View view) {
        C2540v1.G3(this.f24294a, this.f24295b, this.f24296c, this.f24297d, view);
    }
}
