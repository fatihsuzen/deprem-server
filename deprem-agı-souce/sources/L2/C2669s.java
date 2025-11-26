package l2;

import android.content.Context;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import z2.C2940B;
import z2.Z;

/* renamed from: l2.s  reason: case insensitive filesystem */
public final class C2669s implements Parcelable {
    public static Parcelable.Creator<C2669s> CREATOR = new a();

    /* renamed from: d  reason: collision with root package name */
    public static final b f25189d = new b((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private int f25190a = -1;

    /* renamed from: b  reason: collision with root package name */
    private long f25191b;

    /* renamed from: c  reason: collision with root package name */
    private String f25192c;

    /* renamed from: l2.s$a */
    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public C2669s createFromParcel(Parcel parcel) {
            t.e(parcel, "source");
            return new C2669s(parcel);
        }

        /* renamed from: b */
        public C2669s[] newArray(int i5) {
            return new C2669s[i5];
        }
    }

    /* renamed from: l2.s$b */
    public static final class b {
        public /* synthetic */ b(C2633k kVar) {
            this();
        }

        private b() {
        }
    }

    public C2669s() {
    }

    public final void a(long j5, String str) {
        t.e(str, "categoryType");
        this.f25191b = j5;
        this.f25192c = str;
    }

    public final long b() {
        return this.f25191b;
    }

    public final String c() {
        return this.f25192c;
    }

    public final void d(Context context, String str) {
        t.e(context, "context");
        t.e(str, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        String str2 = this.f25192c;
        if (str2 != null && str2.length() != 0) {
            Z z4 = new Z(context);
            long j5 = this.f25191b;
            String str3 = this.f25192c;
            t.b(str3);
            z4.O0(j5, str, str3);
        }
    }

    public int describeContents() {
        return hashCode();
    }

    public final void e(Cursor cursor) {
        t.e(cursor, "c");
        this.f25190a = cursor.getInt(0);
        this.f25191b = cursor.getLong(1);
        this.f25192c = cursor.getString(2);
    }

    public final int f(Context context) {
        t.e(context, "context");
        C2940B a5 = C2940B.f26458v.a(context);
        a5.a();
        C2669s o02 = a5.o0(this.f25191b);
        if (o02 == null) {
            o02 = a5.S0(this);
        }
        a5.m();
        return o02.f25190a;
    }

    public final void g(Context context) {
        t.e(context, "context");
        C2940B a5 = C2940B.f26458v.a(context);
        a5.a();
        a5.p1(this.f25191b);
        a5.m();
    }

    public final void h(int i5) {
        this.f25190a = i5;
    }

    public String toString() {
        return "{id='" + this.f25190a + "'appID='" + this.f25191b + "'categoryType='" + this.f25192c + "'}";
    }

    public void writeToParcel(Parcel parcel, int i5) {
        t.e(parcel, "parcel");
        parcel.writeInt(this.f25190a);
        parcel.writeLong(this.f25191b);
        parcel.writeString(this.f25192c);
    }

    public C2669s(Parcel parcel) {
        t.e(parcel, "source");
        this.f25190a = parcel.readInt();
        this.f25191b = parcel.readLong();
        this.f25192c = parcel.readString();
    }
}
