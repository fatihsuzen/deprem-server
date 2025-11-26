package com.squareup.picasso;

import M1.b;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.s;

class h extends C1585a {

    /* renamed from: m  reason: collision with root package name */
    private final Object f13318m = new Object();

    /* renamed from: n  reason: collision with root package name */
    private b f13319n;

    h(s sVar, v vVar, int i5, int i6, Object obj, String str, b bVar) {
        super(sVar, (Object) null, vVar, i5, i6, 0, (Drawable) null, str, obj, false);
        this.f13319n = bVar;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        super.a();
        this.f13319n = null;
    }

    /* access modifiers changed from: package-private */
    public void b(Bitmap bitmap, s.e eVar) {
        b bVar = this.f13319n;
        if (bVar != null) {
            bVar.onSuccess();
        }
    }

    /* access modifiers changed from: package-private */
    public void c(Exception exc) {
        b bVar = this.f13319n;
        if (bVar != null) {
            bVar.a(exc);
        }
    }

    /* access modifiers changed from: package-private */
    public Object k() {
        return this.f13318m;
    }
}
