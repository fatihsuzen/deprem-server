package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.s;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* renamed from: com.squareup.picasso.a  reason: case insensitive filesystem */
abstract class C1585a {

    /* renamed from: a  reason: collision with root package name */
    final s f13247a;

    /* renamed from: b  reason: collision with root package name */
    final v f13248b;

    /* renamed from: c  reason: collision with root package name */
    final WeakReference f13249c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f13250d;

    /* renamed from: e  reason: collision with root package name */
    final int f13251e;

    /* renamed from: f  reason: collision with root package name */
    final int f13252f;

    /* renamed from: g  reason: collision with root package name */
    final int f13253g;

    /* renamed from: h  reason: collision with root package name */
    final Drawable f13254h;

    /* renamed from: i  reason: collision with root package name */
    final String f13255i;

    /* renamed from: j  reason: collision with root package name */
    final Object f13256j;

    /* renamed from: k  reason: collision with root package name */
    boolean f13257k;

    /* renamed from: l  reason: collision with root package name */
    boolean f13258l;

    /* renamed from: com.squareup.picasso.a$a  reason: collision with other inner class name */
    static class C0115a extends WeakReference {

        /* renamed from: a  reason: collision with root package name */
        final C1585a f13259a;

        C0115a(C1585a aVar, Object obj, ReferenceQueue referenceQueue) {
            super(obj, referenceQueue);
            this.f13259a = aVar;
        }
    }

    C1585a(s sVar, Object obj, v vVar, int i5, int i6, int i7, Drawable drawable, String str, Object obj2, boolean z4) {
        C0115a aVar;
        this.f13247a = sVar;
        this.f13248b = vVar;
        if (obj == null) {
            aVar = null;
        } else {
            aVar = new C0115a(this, obj, sVar.f13367j);
        }
        this.f13249c = aVar;
        this.f13251e = i5;
        this.f13252f = i6;
        this.f13250d = z4;
        this.f13253g = i7;
        this.f13254h = drawable;
        this.f13255i = str;
        this.f13256j = obj2 == null ? this : obj2;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f13258l = true;
    }

    /* access modifiers changed from: package-private */
    public abstract void b(Bitmap bitmap, s.e eVar);

    /* access modifiers changed from: package-private */
    public abstract void c(Exception exc);

    /* access modifiers changed from: package-private */
    public String d() {
        return this.f13255i;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f13251e;
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f13252f;
    }

    /* access modifiers changed from: package-private */
    public s g() {
        return this.f13247a;
    }

    /* access modifiers changed from: package-private */
    public s.f h() {
        return this.f13248b.f13424t;
    }

    /* access modifiers changed from: package-private */
    public v i() {
        return this.f13248b;
    }

    /* access modifiers changed from: package-private */
    public Object j() {
        return this.f13256j;
    }

    /* access modifiers changed from: package-private */
    public Object k() {
        WeakReference weakReference = this.f13249c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return this.f13258l;
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        return this.f13257k;
    }
}
