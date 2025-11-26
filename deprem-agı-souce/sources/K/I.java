package K;

import N.w0;
import O.C0732a;
import O.C0734c;
import U.a;
import U.b;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;

public final class I extends C0732a {
    public static final Parcelable.Creator<I> CREATOR = new J();

    /* renamed from: a  reason: collision with root package name */
    private final String f2689a;

    /* renamed from: b  reason: collision with root package name */
    private final z f2690b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f2691c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f2692d;

    I(String str, z zVar, boolean z4, boolean z5) {
        this.f2689a = str;
        this.f2690b = zVar;
        this.f2691c = z4;
        this.f2692d = z5;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        String str = this.f2689a;
        int a5 = C0734c.a(parcel);
        C0734c.p(parcel, 1, str, false);
        z zVar = this.f2690b;
        if (zVar == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            zVar = null;
        }
        C0734c.i(parcel, 2, zVar, false);
        C0734c.c(parcel, 3, this.f2691c);
        C0734c.c(parcel, 4, this.f2692d);
        C0734c.b(parcel, a5);
    }

    I(String str, IBinder iBinder, boolean z4, boolean z5) {
        byte[] bArr;
        this.f2689a = str;
        C0653A a5 = null;
        if (iBinder != null) {
            try {
                a C4 = w0.j(iBinder).C();
                if (C4 == null) {
                    bArr = null;
                } else {
                    bArr = (byte[]) b.k(C4);
                }
                if (bArr != null) {
                    a5 = new C0653A(bArr);
                } else {
                    Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                }
            } catch (RemoteException e5) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e5);
            }
        }
        this.f2690b = a5;
        this.f2691c = z4;
        this.f2692d = z5;
    }
}
