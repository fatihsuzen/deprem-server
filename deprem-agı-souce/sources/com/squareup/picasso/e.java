package com.squareup.picasso;

import android.content.Context;
import com.squareup.picasso.s;
import com.squareup.picasso.x;
import e4.L;
import java.io.InputStream;

class e extends x {

    /* renamed from: a  reason: collision with root package name */
    final Context f13294a;

    e(Context context) {
        this.f13294a = context;
    }

    public boolean c(v vVar) {
        return "content".equals(vVar.f13408d.getScheme());
    }

    public x.a f(v vVar, int i5) {
        return new x.a(L.l(j(vVar)), s.e.DISK);
    }

    /* access modifiers changed from: package-private */
    public InputStream j(v vVar) {
        return this.f13294a.getContentResolver().openInputStream(vVar.f13408d);
    }
}
