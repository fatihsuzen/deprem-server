package i2;

import android.graphics.drawable.Drawable;
import android.view.View;
import h2.C2398B;

/* renamed from: i2.i1  reason: case insensitive filesystem */
public final /* synthetic */ class C2502i1 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C2540v1 f24238a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2398B f24239b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Drawable f24240c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Drawable f24241d;

    public /* synthetic */ C2502i1(C2540v1 v1Var, C2398B b5, Drawable drawable, Drawable drawable2) {
        this.f24238a = v1Var;
        this.f24239b = b5;
        this.f24240c = drawable;
        this.f24241d = drawable2;
    }

    public final void onClick(View view) {
        C2540v1.E3(this.f24238a, this.f24239b, this.f24240c, this.f24241d, view);
    }
}
