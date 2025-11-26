package com.squareup.picasso;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.squareup.picasso.s;
import com.squareup.picasso.x;

class y extends x {

    /* renamed from: a  reason: collision with root package name */
    private final Context f13459a;

    y(Context context) {
        this.f13459a = context;
    }

    private static Bitmap j(Resources resources, int i5, v vVar) {
        BitmapFactory.Options d5 = x.d(vVar);
        if (x.g(d5)) {
            BitmapFactory.decodeResource(resources, i5, d5);
            x.b(vVar.f13412h, vVar.f13413i, d5, vVar);
        }
        return BitmapFactory.decodeResource(resources, i5, d5);
    }

    public boolean c(v vVar) {
        if (vVar.f13409e != 0) {
            return true;
        }
        return "android.resource".equals(vVar.f13408d.getScheme());
    }

    public x.a f(v vVar, int i5) {
        Resources n5 = C.n(this.f13459a, vVar);
        return new x.a(j(n5, C.m(n5, vVar), vVar), s.e.DISK);
    }
}
