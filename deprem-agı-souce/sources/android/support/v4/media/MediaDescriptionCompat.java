package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.c;
import android.support.v4.media.d;

public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f104a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f105b;

    /* renamed from: c  reason: collision with root package name */
    private final CharSequence f106c;

    /* renamed from: d  reason: collision with root package name */
    private final CharSequence f107d;

    /* renamed from: e  reason: collision with root package name */
    private final Bitmap f108e;

    /* renamed from: f  reason: collision with root package name */
    private final Uri f109f;

    /* renamed from: g  reason: collision with root package name */
    private final Bundle f110g;

    /* renamed from: h  reason: collision with root package name */
    private final Uri f111h;

    /* renamed from: i  reason: collision with root package name */
    private Object f112i;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            return MediaDescriptionCompat.a(c.a(parcel));
        }

        /* renamed from: b */
        public MediaDescriptionCompat[] newArray(int i5) {
            return new MediaDescriptionCompat[i5];
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private String f113a;

        /* renamed from: b  reason: collision with root package name */
        private CharSequence f114b;

        /* renamed from: c  reason: collision with root package name */
        private CharSequence f115c;

        /* renamed from: d  reason: collision with root package name */
        private CharSequence f116d;

        /* renamed from: e  reason: collision with root package name */
        private Bitmap f117e;

        /* renamed from: f  reason: collision with root package name */
        private Uri f118f;

        /* renamed from: g  reason: collision with root package name */
        private Bundle f119g;

        /* renamed from: h  reason: collision with root package name */
        private Uri f120h;

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.f113a, this.f114b, this.f115c, this.f116d, this.f117e, this.f118f, this.f119g, this.f120h);
        }

        public b b(CharSequence charSequence) {
            this.f116d = charSequence;
            return this;
        }

        public b c(Bundle bundle) {
            this.f119g = bundle;
            return this;
        }

        public b d(Bitmap bitmap) {
            this.f117e = bitmap;
            return this;
        }

        public b e(Uri uri) {
            this.f118f = uri;
            return this;
        }

        public b f(String str) {
            this.f113a = str;
            return this;
        }

        public b g(Uri uri) {
            this.f120h = uri;
            return this;
        }

        public b h(CharSequence charSequence) {
            this.f115c = charSequence;
            return this;
        }

        public b i(CharSequence charSequence) {
            this.f114b = charSequence;
            return this;
        }
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f104a = str;
        this.f105b = charSequence;
        this.f106c = charSequence2;
        this.f107d = charSequence3;
        this.f108e = bitmap;
        this.f109f = uri;
        this.f110g = bundle;
        this.f111h = uri2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.v4.media.MediaDescriptionCompat a(java.lang.Object r8) {
        /*
            r0 = 0
            if (r8 == 0) goto L_0x0074
            android.support.v4.media.MediaDescriptionCompat$b r1 = new android.support.v4.media.MediaDescriptionCompat$b
            r1.<init>()
            java.lang.String r2 = android.support.v4.media.c.f(r8)
            r1.f(r2)
            java.lang.CharSequence r2 = android.support.v4.media.c.h(r8)
            r1.i(r2)
            java.lang.CharSequence r2 = android.support.v4.media.c.g(r8)
            r1.h(r2)
            java.lang.CharSequence r2 = android.support.v4.media.c.b(r8)
            r1.b(r2)
            android.graphics.Bitmap r2 = android.support.v4.media.c.d(r8)
            r1.d(r2)
            android.net.Uri r2 = android.support.v4.media.c.e(r8)
            r1.e(r2)
            android.os.Bundle r2 = android.support.v4.media.c.c(r8)
            java.lang.String r3 = "android.support.v4.media.description.MEDIA_URI"
            if (r2 == 0) goto L_0x0044
            android.support.v4.media.session.MediaSessionCompat.a(r2)
            android.os.Parcelable r4 = r2.getParcelable(r3)
            android.net.Uri r4 = (android.net.Uri) r4
            goto L_0x0045
        L_0x0044:
            r4 = r0
        L_0x0045:
            if (r4 == 0) goto L_0x005d
            java.lang.String r5 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            boolean r6 = r2.containsKey(r5)
            if (r6 == 0) goto L_0x0057
            int r6 = r2.size()
            r7 = 2
            if (r6 != r7) goto L_0x0057
            goto L_0x005e
        L_0x0057:
            r2.remove(r3)
            r2.remove(r5)
        L_0x005d:
            r0 = r2
        L_0x005e:
            r1.c(r0)
            if (r4 == 0) goto L_0x0067
            r1.g(r4)
            goto L_0x006e
        L_0x0067:
            android.net.Uri r0 = android.support.v4.media.d.a(r8)
            r1.g(r0)
        L_0x006e:
            android.support.v4.media.MediaDescriptionCompat r0 = r1.a()
            r0.f112i = r8
        L_0x0074:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaDescriptionCompat.a(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }

    public Bitmap b() {
        return this.f108e;
    }

    public Object c() {
        Object obj = this.f112i;
        if (obj != null) {
            return obj;
        }
        Object b5 = c.a.b();
        c.a.g(b5, this.f104a);
        c.a.i(b5, this.f105b);
        c.a.h(b5, this.f106c);
        c.a.c(b5, this.f107d);
        c.a.e(b5, this.f108e);
        c.a.f(b5, this.f109f);
        c.a.d(b5, this.f110g);
        d.a.a(b5, this.f111h);
        Object a5 = c.a.a(b5);
        this.f112i = a5;
        return a5;
    }

    public CharSequence d() {
        return this.f106c;
    }

    public int describeContents() {
        return 0;
    }

    public CharSequence e() {
        return this.f105b;
    }

    public String toString() {
        return this.f105b + ", " + this.f106c + ", " + this.f107d;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        c.i(c(), parcel, i5);
    }
}
