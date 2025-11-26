package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

public final class l implements M1.a {

    /* renamed from: a  reason: collision with root package name */
    final LruCache f13321a;

    class a extends LruCache {
        a(int i5) {
            super(i5);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int sizeOf(String str, b bVar) {
            return bVar.f13324b;
        }
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        final Bitmap f13323a;

        /* renamed from: b  reason: collision with root package name */
        final int f13324b;

        b(Bitmap bitmap, int i5) {
            this.f13323a = bitmap;
            this.f13324b = i5;
        }
    }

    public l(Context context) {
        this(C.b(context));
    }

    public int a() {
        return this.f13321a.maxSize();
    }

    public void b(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || bitmap == null");
        }
        int j5 = C.j(bitmap);
        if (j5 > a()) {
            this.f13321a.remove(str);
        } else {
            this.f13321a.put(str, new b(bitmap, j5));
        }
    }

    public Bitmap get(String str) {
        b bVar = (b) this.f13321a.get(str);
        if (bVar != null) {
            return bVar.f13323a;
        }
        return null;
    }

    public int size() {
        return this.f13321a.size();
    }

    public l(int i5) {
        this.f13321a = new a(i5);
    }
}
