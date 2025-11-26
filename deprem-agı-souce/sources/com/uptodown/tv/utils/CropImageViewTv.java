package com.uptodown.tv.utils;

import N1.a;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import x2.C2911a;

@SuppressLint({"AppCompatCustomView"})
public final class CropImageViewTv extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private C2911a f21324a;

    /* renamed from: b  reason: collision with root package name */
    private int f21325b;

    public CropImageViewTv(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (C2633k) null);
    }

    private final void a() {
        setScaleType(ImageView.ScaleType.MATRIX);
        if (getDrawable() != null) {
            this.f21324a = new C2911a(this);
        }
    }

    private final void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.f3191a);
        t.d(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.f21325b = obtainStyledAttributes.getInt(0, -1);
        obtainStyledAttributes.recycle();
    }

    public final int getCropType() {
        return this.f21325b;
    }

    public final void setCropType(int i5) {
        this.f21325b = i5;
    }

    /* access modifiers changed from: protected */
    public boolean setFrame(int i5, int i6, int i7, int i8) {
        boolean frame = super.setFrame(i5, i6, i7, i8);
        if (!(isInEditMode() || this.f21324a == null || getDrawable() == null)) {
            C2911a aVar = this.f21324a;
            t.b(aVar);
            aVar.a();
        }
        return frame;
    }

    public void setImageBitmap(Bitmap bitmap) {
        t.e(bitmap, "bm");
        super.setImageBitmap(bitmap);
        a();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        a();
    }

    public void setImageResource(int i5) {
        super.setImageResource(i5);
        a();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CropImageViewTv(Context context, AttributeSet attributeSet, int i5, int i6, C2633k kVar) {
        this(context, attributeSet, (i6 & 4) != 0 ? 0 : i5);
    }

    public CropImageViewTv(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f21325b = -1;
        b(attributeSet);
        a();
    }
}
