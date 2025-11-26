package com.mbridge.msdk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.mbridge.msdk.foundation.same.c.b;
import com.mbridge.msdk.foundation.same.c.c;
import com.mbridge.msdk.foundation.tools.af;

@SuppressLint({"AppCompatCustomView"})
public class MBImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private Bitmap f13210a = null;

    /* renamed from: b  reason: collision with root package name */
    private String f13211b;

    public MBImageView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Bitmap bitmap = this.f13210a;
        if (bitmap == null || !bitmap.isRecycled()) {
            super.onDraw(canvas);
            return;
        }
        af.b("mb-widget-imageview", "onDraw bitmap recycled");
        if (getContext() != null) {
            b.a(getContext()).a(this.f13211b, new c() {
                public final void onFailedLoad(String str, String str2) {
                    af.b("mb-widget-imageview", str2 + " load failed:" + str);
                }

                public final void onSuccessLoad(Bitmap bitmap, String str) {
                    MBImageView.this.setImageBitmap(bitmap);
                }
            });
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.f13210a = bitmap;
        if (bitmap == null || !bitmap.isRecycled()) {
            super.setImageBitmap(bitmap);
            return;
        }
        this.f13210a = null;
        super.setImageBitmap((Bitmap) null);
        af.b("mb-widget-imageview", "setImageBitmap recycled");
    }

    public void setImageUrl(String str) {
        this.f13211b = str;
    }

    public MBImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBImageView(Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }
}
