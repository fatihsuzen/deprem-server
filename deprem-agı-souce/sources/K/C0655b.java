package K;

import N.C0720n;
import O.C0732a;
import O.C0734c;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

/* renamed from: K.b  reason: case insensitive filesystem */
public final class C0655b extends C0732a {
    @NonNull
    public static final Parcelable.Creator<C0655b> CREATOR = new r();

    /* renamed from: e  reason: collision with root package name */
    public static final C0655b f2701e = new C0655b(0);

    /* renamed from: a  reason: collision with root package name */
    final int f2702a;

    /* renamed from: b  reason: collision with root package name */
    private final int f2703b;

    /* renamed from: c  reason: collision with root package name */
    private final PendingIntent f2704c;

    /* renamed from: d  reason: collision with root package name */
    private final String f2705d;

    C0655b(int i5, int i6, PendingIntent pendingIntent, String str) {
        this.f2702a = i5;
        this.f2703b = i6;
        this.f2704c = pendingIntent;
        this.f2705d = str;
    }

    static String j(int i5) {
        if (i5 == 99) {
            return "UNFINISHED";
        }
        if (i5 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i5) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i5) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    case 25:
                        return "API_INSTALL_REQUIRED";
                    default:
                        return "UNKNOWN_ERROR_CODE(" + i5 + ")";
                }
        }
    }

    public int c() {
        return this.f2703b;
    }

    public String d() {
        return this.f2705d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0655b)) {
            return false;
        }
        C0655b bVar = (C0655b) obj;
        if (this.f2703b != bVar.f2703b || !C0720n.a(this.f2704c, bVar.f2704c) || !C0720n.a(this.f2705d, bVar.f2705d)) {
            return false;
        }
        return true;
    }

    public PendingIntent f() {
        return this.f2704c;
    }

    public boolean g() {
        if (this.f2703b == 0 || this.f2704c == null) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return C0720n.b(Integer.valueOf(this.f2703b), this.f2704c, this.f2705d);
    }

    public boolean i() {
        if (this.f2703b == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        C0720n.a c5 = C0720n.c(this);
        c5.a("statusCode", j(this.f2703b));
        c5.a("resolution", this.f2704c);
        c5.a("message", this.f2705d);
        return c5.toString();
    }

    public void writeToParcel(Parcel parcel, int i5) {
        int i6 = this.f2702a;
        int a5 = C0734c.a(parcel);
        C0734c.j(parcel, 1, i6);
        C0734c.j(parcel, 2, c());
        C0734c.o(parcel, 3, f(), i5, false);
        C0734c.p(parcel, 4, d(), false);
        C0734c.b(parcel, a5);
    }

    public C0655b(int i5) {
        this(i5, (PendingIntent) null, (String) null);
    }

    public C0655b(int i5, PendingIntent pendingIntent) {
        this(i5, pendingIntent, (String) null);
    }

    public C0655b(int i5, PendingIntent pendingIntent, String str) {
        this(1, i5, pendingIntent, str);
    }
}
