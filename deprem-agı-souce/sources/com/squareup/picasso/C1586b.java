package com.squareup.picasso;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.squareup.picasso.s;
import com.squareup.picasso.x;
import e4.L;

/* renamed from: com.squareup.picasso.b  reason: case insensitive filesystem */
class C1586b extends x {

    /* renamed from: d  reason: collision with root package name */
    private static final int f13260d = 22;

    /* renamed from: a  reason: collision with root package name */
    private final Context f13261a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f13262b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private AssetManager f13263c;

    C1586b(Context context) {
        this.f13261a = context;
    }

    static String j(v vVar) {
        return vVar.f13408d.toString().substring(f13260d);
    }

    public boolean c(v vVar) {
        Uri uri = vVar.f13408d;
        if (!"file".equals(uri.getScheme()) || uri.getPathSegments().isEmpty() || !"android_asset".equals(uri.getPathSegments().get(0))) {
            return false;
        }
        return true;
    }

    public x.a f(v vVar, int i5) {
        if (this.f13263c == null) {
            synchronized (this.f13262b) {
                try {
                    if (this.f13263c == null) {
                        this.f13263c = this.f13261a.getAssets();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return new x.a(L.l(this.f13263c.open(j(vVar))), s.e.DISK);
    }
}
