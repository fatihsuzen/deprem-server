package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import com.squareup.picasso.s;
import e4.Z;

public abstract class x {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final s.e f13455a;

        /* renamed from: b  reason: collision with root package name */
        private final Bitmap f13456b;

        /* renamed from: c  reason: collision with root package name */
        private final Z f13457c;

        /* renamed from: d  reason: collision with root package name */
        private final int f13458d;

        public a(Bitmap bitmap, s.e eVar) {
            this((Bitmap) C.e(bitmap, "bitmap == null"), (Z) null, eVar, 0);
        }

        public Bitmap a() {
            return this.f13456b;
        }

        /* access modifiers changed from: package-private */
        public int b() {
            return this.f13458d;
        }

        public s.e c() {
            return this.f13455a;
        }

        public Z d() {
            return this.f13457c;
        }

        public a(Z z4, s.e eVar) {
            this((Bitmap) null, (Z) C.e(z4, "source == null"), eVar, 0);
        }

        a(Bitmap bitmap, Z z4, s.e eVar, int i5) {
            if ((bitmap != null) != (z4 != null)) {
                this.f13456b = bitmap;
                this.f13457c = z4;
                this.f13455a = (s.e) C.e(eVar, "loadedFrom == null");
                this.f13458d = i5;
                return;
            }
            throw new AssertionError();
        }
    }

    static void a(int i5, int i6, int i7, int i8, BitmapFactory.Options options, v vVar) {
        int i9;
        double floor;
        if (i8 > i6 || i7 > i5) {
            if (i6 == 0) {
                floor = Math.floor((double) (((float) i7) / ((float) i5)));
            } else if (i5 == 0) {
                floor = Math.floor((double) (((float) i8) / ((float) i6)));
            } else {
                int floor2 = (int) Math.floor((double) (((float) i8) / ((float) i6)));
                int floor3 = (int) Math.floor((double) (((float) i7) / ((float) i5)));
                if (vVar.f13416l) {
                    i9 = Math.max(floor2, floor3);
                } else {
                    i9 = Math.min(floor2, floor3);
                }
            }
            i9 = (int) floor;
        } else {
            i9 = 1;
        }
        options.inSampleSize = i9;
        options.inJustDecodeBounds = false;
    }

    static void b(int i5, int i6, BitmapFactory.Options options, v vVar) {
        a(i5, i6, options.outWidth, options.outHeight, options, vVar);
    }

    static BitmapFactory.Options d(v vVar) {
        boolean z4;
        boolean c5 = vVar.c();
        if (vVar.f13423s != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!c5 && !z4 && !vVar.f13422r) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = c5;
        boolean z5 = vVar.f13422r;
        options.inInputShareable = z5;
        options.inPurgeable = z5;
        if (z4) {
            options.inPreferredConfig = vVar.f13423s;
        }
        return options;
    }

    static boolean g(BitmapFactory.Options options) {
        if (options == null || !options.inJustDecodeBounds) {
            return false;
        }
        return true;
    }

    public abstract boolean c(v vVar);

    /* access modifiers changed from: package-private */
    public int e() {
        return 0;
    }

    public abstract a f(v vVar, int i5);

    /* access modifiers changed from: package-private */
    public boolean h(boolean z4, NetworkInfo networkInfo) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        return false;
    }
}
