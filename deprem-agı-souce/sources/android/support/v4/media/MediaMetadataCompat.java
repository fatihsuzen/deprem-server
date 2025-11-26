package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;

public final class MediaMetadataCompat implements Parcelable {
    public static final Parcelable.Creator<MediaMetadataCompat> CREATOR = new a();

    /* renamed from: d  reason: collision with root package name */
    static final ArrayMap f121d;

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f122e = {"android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER"};

    /* renamed from: f  reason: collision with root package name */
    private static final String[] f123f = {"android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART"};

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f124g = {"android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI"};

    /* renamed from: a  reason: collision with root package name */
    final Bundle f125a;

    /* renamed from: b  reason: collision with root package name */
    private Object f126b;

    /* renamed from: c  reason: collision with root package name */
    private MediaDescriptionCompat f127c;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public MediaMetadataCompat createFromParcel(Parcel parcel) {
            return new MediaMetadataCompat(parcel);
        }

        /* renamed from: b */
        public MediaMetadataCompat[] newArray(int i5) {
            return new MediaMetadataCompat[i5];
        }
    }

    static {
        ArrayMap arrayMap = new ArrayMap();
        f121d = arrayMap;
        arrayMap.put("android.media.metadata.TITLE", 1);
        arrayMap.put("android.media.metadata.ARTIST", 1);
        arrayMap.put("android.media.metadata.DURATION", 0);
        arrayMap.put("android.media.metadata.ALBUM", 1);
        arrayMap.put("android.media.metadata.AUTHOR", 1);
        arrayMap.put("android.media.metadata.WRITER", 1);
        arrayMap.put("android.media.metadata.COMPOSER", 1);
        arrayMap.put("android.media.metadata.COMPILATION", 1);
        arrayMap.put("android.media.metadata.DATE", 1);
        arrayMap.put("android.media.metadata.YEAR", 0);
        arrayMap.put("android.media.metadata.GENRE", 1);
        arrayMap.put("android.media.metadata.TRACK_NUMBER", 0);
        arrayMap.put("android.media.metadata.NUM_TRACKS", 0);
        arrayMap.put("android.media.metadata.DISC_NUMBER", 0);
        arrayMap.put("android.media.metadata.ALBUM_ARTIST", 1);
        arrayMap.put("android.media.metadata.ART", 2);
        arrayMap.put("android.media.metadata.ART_URI", 1);
        arrayMap.put("android.media.metadata.ALBUM_ART", 2);
        arrayMap.put("android.media.metadata.ALBUM_ART_URI", 1);
        arrayMap.put("android.media.metadata.USER_RATING", 3);
        arrayMap.put("android.media.metadata.RATING", 3);
        arrayMap.put("android.media.metadata.DISPLAY_TITLE", 1);
        arrayMap.put("android.media.metadata.DISPLAY_SUBTITLE", 1);
        arrayMap.put("android.media.metadata.DISPLAY_DESCRIPTION", 1);
        arrayMap.put("android.media.metadata.DISPLAY_ICON", 2);
        arrayMap.put("android.media.metadata.DISPLAY_ICON_URI", 1);
        arrayMap.put("android.media.metadata.MEDIA_ID", 1);
        arrayMap.put("android.media.metadata.BT_FOLDER_TYPE", 0);
        arrayMap.put("android.media.metadata.MEDIA_URI", 1);
        arrayMap.put("android.media.metadata.ADVERTISEMENT", 0);
        arrayMap.put("android.media.metadata.DOWNLOAD_STATUS", 0);
    }

    MediaMetadataCompat(Parcel parcel) {
        this.f125a = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
    }

    public static MediaMetadataCompat a(Object obj) {
        if (obj == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        e.a(obj, obtain, 0);
        obtain.setDataPosition(0);
        MediaMetadataCompat createFromParcel = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        createFromParcel.f126b = obj;
        return createFromParcel;
    }

    public Bitmap b(String str) {
        try {
            return (Bitmap) this.f125a.getParcelable(str);
        } catch (Exception e5) {
            Log.w("MediaMetadata", "Failed to retrieve a key as Bitmap.", e5);
            return null;
        }
    }

    public MediaDescriptionCompat c() {
        Uri uri;
        Bitmap bitmap;
        Uri uri2;
        MediaDescriptionCompat mediaDescriptionCompat = this.f127c;
        if (mediaDescriptionCompat != null) {
            return mediaDescriptionCompat;
        }
        String e5 = e("android.media.metadata.MEDIA_ID");
        CharSequence[] charSequenceArr = new CharSequence[3];
        CharSequence f5 = f("android.media.metadata.DISPLAY_TITLE");
        if (TextUtils.isEmpty(f5)) {
            int i5 = 0;
            int i6 = 0;
            while (i5 < 3) {
                String[] strArr = f122e;
                if (i6 >= strArr.length) {
                    break;
                }
                int i7 = i6 + 1;
                CharSequence f6 = f(strArr[i6]);
                if (!TextUtils.isEmpty(f6)) {
                    charSequenceArr[i5] = f6;
                    i5++;
                }
                i6 = i7;
            }
        } else {
            charSequenceArr[0] = f5;
            charSequenceArr[1] = f("android.media.metadata.DISPLAY_SUBTITLE");
            charSequenceArr[2] = f("android.media.metadata.DISPLAY_DESCRIPTION");
        }
        int i8 = 0;
        while (true) {
            String[] strArr2 = f123f;
            uri = null;
            if (i8 >= strArr2.length) {
                bitmap = null;
                break;
            }
            bitmap = b(strArr2[i8]);
            if (bitmap != null) {
                break;
            }
            i8++;
        }
        int i9 = 0;
        while (true) {
            String[] strArr3 = f124g;
            if (i9 >= strArr3.length) {
                uri2 = null;
                break;
            }
            String e6 = e(strArr3[i9]);
            if (!TextUtils.isEmpty(e6)) {
                uri2 = Uri.parse(e6);
                break;
            }
            i9++;
        }
        String e7 = e("android.media.metadata.MEDIA_URI");
        if (!TextUtils.isEmpty(e7)) {
            uri = Uri.parse(e7);
        }
        MediaDescriptionCompat.b bVar = new MediaDescriptionCompat.b();
        bVar.f(e5);
        bVar.i(charSequenceArr[0]);
        bVar.h(charSequenceArr[1]);
        bVar.b(charSequenceArr[2]);
        bVar.d(bitmap);
        bVar.e(uri2);
        bVar.g(uri);
        Bundle bundle = new Bundle();
        if (this.f125a.containsKey("android.media.metadata.BT_FOLDER_TYPE")) {
            bundle.putLong("android.media.extra.BT_FOLDER_TYPE", d("android.media.metadata.BT_FOLDER_TYPE"));
        }
        if (this.f125a.containsKey("android.media.metadata.DOWNLOAD_STATUS")) {
            bundle.putLong("android.media.extra.DOWNLOAD_STATUS", d("android.media.metadata.DOWNLOAD_STATUS"));
        }
        if (!bundle.isEmpty()) {
            bVar.c(bundle);
        }
        MediaDescriptionCompat a5 = bVar.a();
        this.f127c = a5;
        return a5;
    }

    public long d(String str) {
        return this.f125a.getLong(str, 0);
    }

    public int describeContents() {
        return 0;
    }

    public String e(String str) {
        CharSequence charSequence = this.f125a.getCharSequence(str);
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public CharSequence f(String str) {
        return this.f125a.getCharSequence(str);
    }

    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeBundle(this.f125a);
    }
}
