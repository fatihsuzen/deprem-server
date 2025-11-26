package com.squareup.picasso;

import M1.b;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.squareup.picasso.s;

class k extends C1585a {

    /* renamed from: m  reason: collision with root package name */
    b f13320m;

    k(s sVar, ImageView imageView, v vVar, int i5, int i6, int i7, Drawable drawable, String str, Object obj, b bVar, boolean z4) {
        super(sVar, imageView, vVar, i5, i6, i7, drawable, str, obj, z4);
        this.f13320m = bVar;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        super.a();
        if (this.f13320m != null) {
            this.f13320m = null;
        }
    }

    public void b(Bitmap bitmap, s.e eVar) {
        if (bitmap != null) {
            ImageView imageView = (ImageView) this.f13249c.get();
            if (imageView != null) {
                s sVar = this.f13247a;
                Bitmap bitmap2 = bitmap;
                s.e eVar2 = eVar;
                t.c(imageView, sVar.f13361d, bitmap2, eVar2, this.f13250d, sVar.f13369l);
                b bVar = this.f13320m;
                if (bVar != null) {
                    bVar.onSuccess();
                    return;
                }
                return;
            }
            return;
        }
        throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[]{this}));
    }

    public void c(Exception exc) {
        ImageView imageView = (ImageView) this.f13249c.get();
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).stop();
            }
            int i5 = this.f13253g;
            if (i5 != 0) {
                imageView.setImageResource(i5);
            } else {
                Drawable drawable2 = this.f13254h;
                if (drawable2 != null) {
                    imageView.setImageDrawable(drawable2);
                }
            }
            b bVar = this.f13320m;
            if (bVar != null) {
                bVar.a(exc);
            }
        }
    }
}
