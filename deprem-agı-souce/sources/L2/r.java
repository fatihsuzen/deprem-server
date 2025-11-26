package l2;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import org.json.JSONObject;

public final class r implements Parcelable {
    public static Parcelable.Creator<r> CREATOR = new a();

    /* renamed from: k  reason: collision with root package name */
    public static final b f25178k = new b((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private long f25179a = -1;

    /* renamed from: b  reason: collision with root package name */
    private long f25180b = -1;

    /* renamed from: c  reason: collision with root package name */
    private long f25181c = -1;

    /* renamed from: d  reason: collision with root package name */
    private String f25182d;

    /* renamed from: e  reason: collision with root package name */
    private long f25183e = -1;

    /* renamed from: f  reason: collision with root package name */
    private long f25184f;

    /* renamed from: g  reason: collision with root package name */
    private String f25185g;

    /* renamed from: h  reason: collision with root package name */
    private String f25186h;

    /* renamed from: i  reason: collision with root package name */
    private int f25187i;

    /* renamed from: j  reason: collision with root package name */
    private long f25188j;

    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public r createFromParcel(Parcel parcel) {
            t.e(parcel, "source");
            return new r(parcel);
        }

        /* renamed from: b */
        public r[] newArray(int i5) {
            return new r[i5];
        }
    }

    public static final class b {
        public /* synthetic */ b(C2633k kVar) {
            this();
        }

        public final r a(JSONObject jSONObject) {
            t.e(jSONObject, "jsonObject");
            r rVar = new r();
            if (!jSONObject.isNull("fileID")) {
                rVar.m(jSONObject.optLong("fileID"));
            }
            if (!jSONObject.isNull(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY)) {
                rVar.r(jSONObject.optString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY));
            }
            if (!jSONObject.isNull("size")) {
                rVar.q(jSONObject.optLong("size"));
            }
            if (!jSONObject.isNull("sha256")) {
                rVar.n(jSONObject.optString("sha256"));
            }
            return rVar;
        }

        private b() {
        }
    }

    public r() {
    }

    public final String a() {
        return this.f25186h;
    }

    public final int b() {
        return this.f25187i;
    }

    public final long c() {
        return this.f25180b;
    }

    public final long d() {
        return this.f25181c;
    }

    public int describeContents() {
        return hashCode();
    }

    public final String e() {
        return this.f25185g;
    }

    public final long f() {
        return this.f25179a;
    }

    public final long g() {
        return this.f25188j;
    }

    public final long h() {
        return this.f25184f;
    }

    public final long i() {
        return this.f25183e;
    }

    public final void j(Cursor cursor) {
        t.e(cursor, "c");
        this.f25179a = cursor.getLong(0);
        this.f25180b = cursor.getLong(1);
        this.f25181c = cursor.getLong(2);
        this.f25182d = cursor.getString(3);
        this.f25183e = cursor.getLong(4);
        this.f25184f = cursor.getLong(5);
        this.f25185g = cursor.getString(6);
        this.f25186h = cursor.getString(7);
        this.f25187i = cursor.getInt(8);
        this.f25188j = cursor.getLong(9);
    }

    public final void k(String str) {
        this.f25186h = str;
    }

    public final void l(int i5) {
        this.f25187i = i5;
    }

    public final void m(long j5) {
        this.f25181c = j5;
    }

    public final void n(String str) {
        this.f25185g = str;
    }

    public final void o(long j5) {
        this.f25188j = j5;
    }

    public final void p(long j5) {
        this.f25184f = j5;
    }

    public final void q(long j5) {
        this.f25183e = j5;
    }

    public final void r(String str) {
        this.f25182d = str;
    }

    public String toString() {
        return "{id='" + this.f25179a + "', downloadId='" + this.f25180b + "', fileId='" + this.f25181c + "', type=" + this.f25182d + ", sizeExpected='" + this.f25183e + "', sizeDownloaded='" + this.f25184f + "', filehashExpected='" + this.f25185g + "', absolutePath='" + this.f25186h + "', attempts=" + this.f25187i + ", nextAttemptTimeStamp=" + this.f25188j + '}';
    }

    public void writeToParcel(Parcel parcel, int i5) {
        t.e(parcel, "parcel");
        parcel.writeLong(this.f25179a);
        parcel.writeLong(this.f25180b);
        parcel.writeLong(this.f25181c);
        parcel.writeString(this.f25182d);
        parcel.writeLong(this.f25183e);
        parcel.writeLong(this.f25184f);
        parcel.writeString(this.f25185g);
        parcel.writeString(this.f25186h);
        parcel.writeInt(this.f25187i);
        parcel.writeLong(this.f25188j);
    }

    public r(Parcel parcel) {
        t.e(parcel, "source");
        this.f25179a = parcel.readLong();
        this.f25180b = parcel.readLong();
        this.f25181c = parcel.readLong();
        this.f25182d = parcel.readString();
        this.f25183e = parcel.readLong();
        this.f25184f = parcel.readLong();
        this.f25185g = parcel.readString();
        this.f25186h = parcel.readString();
        this.f25187i = parcel.readInt();
        this.f25188j = parcel.readLong();
    }
}
