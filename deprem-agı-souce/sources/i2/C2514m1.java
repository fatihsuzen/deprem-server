package i2;

import android.graphics.drawable.Drawable;
import android.view.View;
import h2.C2398B;

/* renamed from: i2.m1  reason: case insensitive filesystem */
public final /* synthetic */ class C2514m1 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C2540v1 f24301a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2398B f24302b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Drawable f24303c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Drawable f24304d;

    public /* synthetic */ C2514m1(C2540v1 v1Var, C2398B b5, Drawable drawable, Drawable drawable2) {
        this.f24301a = v1Var;
        this.f24302b = b5;
        this.f24303c = drawable;
        this.f24304d = drawable2;
    }

    public final void onClick(View view) {
        C2540v1.H3(this.f24301a, this.f24302b, this.f24303c, this.f24304d, view);
    }
}
