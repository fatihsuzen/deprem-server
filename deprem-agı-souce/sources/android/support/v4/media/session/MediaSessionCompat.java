package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.session.d;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.List;

public abstract class MediaSessionCompat {

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        ResultReceiver f153a;

        static class a implements Parcelable.Creator {
            a() {
            }

            /* renamed from: a */
            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            /* renamed from: b */
            public ResultReceiverWrapper[] newArray(int i5) {
                return new ResultReceiverWrapper[i5];
            }
        }

        ResultReceiverWrapper(Parcel parcel) {
            this.f153a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i5) {
            this.f153a.writeToParcel(parcel, i5);
        }
    }

    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final Object f154a;

        /* renamed from: b  reason: collision with root package name */
        private b f155b;

        /* renamed from: c  reason: collision with root package name */
        private Bundle f156c;

        static class a implements Parcelable.Creator {
            a() {
            }

            /* renamed from: a */
            public Token createFromParcel(Parcel parcel) {
                return new Token(parcel.readParcelable((ClassLoader) null));
            }

            /* renamed from: b */
            public Token[] newArray(int i5) {
                return new Token[i5];
            }
        }

        Token(Object obj) {
            this(obj, (b) null, (Bundle) null);
        }

        public static Token a(Object obj) {
            return b(obj, (b) null);
        }

        public static Token b(Object obj, b bVar) {
            if (obj != null) {
                return new Token(d.a(obj), bVar);
            }
            return null;
        }

        public b c() {
            return this.f155b;
        }

        public Object d() {
            return this.f154a;
        }

        public int describeContents() {
            return 0;
        }

        public void e(b bVar) {
            this.f155b = bVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            Object obj2 = this.f154a;
            if (obj2 != null) {
                Object obj3 = token.f154a;
                if (obj3 == null) {
                    return false;
                }
                return obj2.equals(obj3);
            } else if (token.f154a == null) {
                return true;
            } else {
                return false;
            }
        }

        public void f(Bundle bundle) {
            this.f156c = bundle;
        }

        public int hashCode() {
            Object obj = this.f154a;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public void writeToParcel(Parcel parcel, int i5) {
            parcel.writeParcelable((Parcelable) this.f154a, i5);
        }

        Token(Object obj, b bVar) {
            this(obj, bVar, (Bundle) null);
        }

        Token(Object obj, b bVar, Bundle bundle) {
            this.f154a = obj;
            this.f155b = bVar;
            this.f156c = bundle;
        }
    }

    public static void a(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final MediaDescriptionCompat f150a;

        /* renamed from: b  reason: collision with root package name */
        private final long f151b;

        /* renamed from: c  reason: collision with root package name */
        private Object f152c;

        static class a implements Parcelable.Creator {
            a() {
            }

            /* renamed from: a */
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            /* renamed from: b */
            public QueueItem[] newArray(int i5) {
                return new QueueItem[i5];
            }
        }

        private QueueItem(Object obj, MediaDescriptionCompat mediaDescriptionCompat, long j5) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            } else if (j5 != -1) {
                this.f150a = mediaDescriptionCompat;
                this.f151b = j5;
                this.f152c = obj;
            } else {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
        }

        public static QueueItem a(Object obj) {
            if (obj != null) {
                return new QueueItem(obj, MediaDescriptionCompat.a(d.a.a(obj)), d.a.b(obj));
            }
            return null;
        }

        public static List b(List list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object a5 : list) {
                arrayList.add(a(a5));
            }
            return arrayList;
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.f150a + ", Id=" + this.f151b + " }";
        }

        public void writeToParcel(Parcel parcel, int i5) {
            this.f150a.writeToParcel(parcel, i5);
            parcel.writeLong(this.f151b);
        }

        QueueItem(Parcel parcel) {
            this.f150a = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f151b = parcel.readLong();
        }
    }
}
