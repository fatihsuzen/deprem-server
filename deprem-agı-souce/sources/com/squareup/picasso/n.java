package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import com.squareup.picasso.s;
import com.squareup.picasso.x;
import e4.L;
import e4.Z;

class n extends e {

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f13332b = {"orientation"};

    enum a {
        MICRO(3, 96, 96),
        MINI(1, 512, 384),
        FULL(2, -1, -1);
        

        /* renamed from: a  reason: collision with root package name */
        final int f13337a;

        /* renamed from: b  reason: collision with root package name */
        final int f13338b;

        /* renamed from: c  reason: collision with root package name */
        final int f13339c;

        private a(int i5, int i6, int i7) {
            this.f13337a = i5;
            this.f13338b = i6;
            this.f13339c = i7;
        }
    }

    n(Context context) {
        super(context);
    }

    static int k(ContentResolver contentResolver, Uri uri) {
        Cursor cursor = null;
        try {
            Cursor query = contentResolver.query(uri, f13332b, (String) null, (String[]) null, (String) null);
            if (query != null) {
                if (query.moveToFirst()) {
                    int i5 = query.getInt(0);
                    query.close();
                    return i5;
                }
            }
            if (query != null) {
                query.close();
            }
            return 0;
        } catch (RuntimeException unused) {
            if (cursor != null) {
                cursor.close();
            }
            return 0;
        } catch (Throwable th) {
            Throwable th2 = th;
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    static a l(int i5, int i6) {
        a aVar = a.MICRO;
        if (i5 <= aVar.f13338b && i6 <= aVar.f13339c) {
            return aVar;
        }
        a aVar2 = a.MINI;
        if (i5 > aVar2.f13338b || i6 > aVar2.f13339c) {
            return a.FULL;
        }
        return aVar2;
    }

    public boolean c(v vVar) {
        Uri uri = vVar.f13408d;
        if (!"content".equals(uri.getScheme()) || !"media".equals(uri.getAuthority())) {
            return false;
        }
        return true;
    }

    public x.a f(v vVar, int i5) {
        boolean z4;
        v vVar2;
        Bitmap bitmap;
        ContentResolver contentResolver = this.f13294a.getContentResolver();
        int k5 = k(contentResolver, vVar.f13408d);
        String type = contentResolver.getType(vVar.f13408d);
        int i6 = 1;
        if (type == null || !type.startsWith("video/")) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (vVar.c()) {
            a l5 = l(vVar.f13412h, vVar.f13413i);
            if (!z4 && l5 == a.FULL) {
                return new x.a((Bitmap) null, L.l(j(vVar)), s.e.DISK, k5);
            }
            long parseId = ContentUris.parseId(vVar.f13408d);
            BitmapFactory.Options d5 = x.d(vVar);
            d5.inJustDecodeBounds = true;
            vVar2 = vVar;
            x.a(vVar.f13412h, vVar.f13413i, l5.f13338b, l5.f13339c, d5, vVar2);
            if (z4) {
                if (l5 != a.FULL) {
                    i6 = l5.f13337a;
                }
                bitmap = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, parseId, i6, d5);
            } else {
                bitmap = MediaStore.Images.Thumbnails.getThumbnail(contentResolver, parseId, l5.f13337a, d5);
            }
            if (bitmap != null) {
                return new x.a(bitmap, (Z) null, s.e.DISK, k5);
            }
        } else {
            vVar2 = vVar;
        }
        return new x.a((Bitmap) null, L.l(j(vVar2)), s.e.DISK, k5);
    }
}
