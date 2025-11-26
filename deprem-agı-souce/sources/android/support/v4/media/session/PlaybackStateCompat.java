package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.e;
import android.text.TextUtils;
import androidx.appcompat.R;
import java.util.ArrayList;
import java.util.List;

public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final int f162a;

    /* renamed from: b  reason: collision with root package name */
    final long f163b;

    /* renamed from: c  reason: collision with root package name */
    final long f164c;

    /* renamed from: d  reason: collision with root package name */
    final float f165d;

    /* renamed from: e  reason: collision with root package name */
    final long f166e;

    /* renamed from: f  reason: collision with root package name */
    final int f167f;

    /* renamed from: g  reason: collision with root package name */
    final CharSequence f168g;

    /* renamed from: h  reason: collision with root package name */
    final long f169h;

    /* renamed from: i  reason: collision with root package name */
    List f170i;

    /* renamed from: j  reason: collision with root package name */
    final long f171j;

    /* renamed from: k  reason: collision with root package name */
    final Bundle f172k;

    /* renamed from: l  reason: collision with root package name */
    private Object f173l;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        /* renamed from: b */
        public PlaybackStateCompat[] newArray(int i5) {
            return new PlaybackStateCompat[i5];
        }
    }

    PlaybackStateCompat(int i5, long j5, long j6, float f5, long j7, int i6, CharSequence charSequence, long j8, List list, long j9, Bundle bundle) {
        this.f162a = i5;
        this.f163b = j5;
        this.f164c = j6;
        this.f165d = f5;
        this.f166e = j7;
        this.f167f = i6;
        this.f168g = charSequence;
        this.f169h = j8;
        this.f170i = new ArrayList(list);
        this.f171j = j9;
        this.f172k = bundle;
    }

    public static PlaybackStateCompat a(Object obj) {
        Object obj2 = obj;
        ArrayList arrayList = null;
        if (obj2 == null) {
            return null;
        }
        List<Object> d5 = e.d(obj2);
        if (d5 != null) {
            arrayList = new ArrayList(d5.size());
            for (Object a5 : d5) {
                arrayList.add(CustomAction.a(a5));
            }
        }
        Bundle a6 = f.a(obj2);
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(e.i(obj2), e.h(obj2), e.c(obj2), e.g(obj2), e.a(obj2), 0, e.e(obj2), e.f(obj2), arrayList, e.b(obj2), a6);
        playbackStateCompat.f173l = obj2;
        return playbackStateCompat;
    }

    public static int i(long j5) {
        if (j5 == 4) {
            return R.styleable.AppCompatTheme_windowNoTitle;
        }
        if (j5 == 2) {
            return 127;
        }
        if (j5 == 32) {
            return 87;
        }
        if (j5 == 16) {
            return 88;
        }
        if (j5 == 1) {
            return 86;
        }
        if (j5 == 64) {
            return 90;
        }
        if (j5 == 8) {
            return 89;
        }
        return j5 == 512 ? 85 : 0;
    }

    public long b() {
        return this.f166e;
    }

    public long c() {
        return this.f164c;
    }

    public int d() {
        return this.f167f;
    }

    public int describeContents() {
        return 0;
    }

    public CharSequence e() {
        return this.f168g;
    }

    public float f() {
        return this.f165d;
    }

    public long g() {
        return this.f163b;
    }

    public int h() {
        return this.f162a;
    }

    public String toString() {
        return "PlaybackState {" + "state=" + this.f162a + ", position=" + this.f163b + ", buffered position=" + this.f164c + ", speed=" + this.f165d + ", updated=" + this.f169h + ", actions=" + this.f166e + ", error code=" + this.f167f + ", error message=" + this.f168g + ", custom actions=" + this.f170i + ", active item id=" + this.f171j + "}";
    }

    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeInt(this.f162a);
        parcel.writeLong(this.f163b);
        parcel.writeFloat(this.f165d);
        parcel.writeLong(this.f169h);
        parcel.writeLong(this.f164c);
        parcel.writeLong(this.f166e);
        TextUtils.writeToParcel(this.f168g, parcel, i5);
        parcel.writeTypedList(this.f170i);
        parcel.writeLong(this.f171j);
        parcel.writeBundle(this.f172k);
        parcel.writeInt(this.f167f);
    }

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final String f174a;

        /* renamed from: b  reason: collision with root package name */
        private final CharSequence f175b;

        /* renamed from: c  reason: collision with root package name */
        private final int f176c;

        /* renamed from: d  reason: collision with root package name */
        private final Bundle f177d;

        /* renamed from: e  reason: collision with root package name */
        private Object f178e;

        static class a implements Parcelable.Creator {
            a() {
            }

            /* renamed from: a */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            /* renamed from: b */
            public CustomAction[] newArray(int i5) {
                return new CustomAction[i5];
            }
        }

        CustomAction(String str, CharSequence charSequence, int i5, Bundle bundle) {
            this.f174a = str;
            this.f175b = charSequence;
            this.f176c = i5;
            this.f177d = bundle;
        }

        public static CustomAction a(Object obj) {
            if (obj == null) {
                return null;
            }
            CustomAction customAction = new CustomAction(e.a.a(obj), e.a.d(obj), e.a.c(obj), e.a.b(obj));
            customAction.f178e = obj;
            return customAction;
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "Action:mName='" + this.f175b + ", mIcon=" + this.f176c + ", mExtras=" + this.f177d;
        }

        public void writeToParcel(Parcel parcel, int i5) {
            parcel.writeString(this.f174a);
            TextUtils.writeToParcel(this.f175b, parcel, i5);
            parcel.writeInt(this.f176c);
            parcel.writeBundle(this.f177d);
        }

        CustomAction(Parcel parcel) {
            this.f174a = parcel.readString();
            this.f175b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f176c = parcel.readInt();
            this.f177d = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }
    }

    PlaybackStateCompat(Parcel parcel) {
        this.f162a = parcel.readInt();
        this.f163b = parcel.readLong();
        this.f165d = parcel.readFloat();
        this.f169h = parcel.readLong();
        this.f164c = parcel.readLong();
        this.f166e = parcel.readLong();
        this.f168g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f170i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f171j = parcel.readLong();
        this.f172k = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f167f = parcel.readInt();
    }
}
