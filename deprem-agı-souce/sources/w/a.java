package W;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f4419a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4420b = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";

    protected a(IBinder iBinder, String str) {
        this.f4419a = iBinder;
    }

    public final IBinder asBinder() {
        return this.f4419a;
    }

    /* access modifiers changed from: protected */
    public final Parcel i() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f4420b);
        return obtain;
    }

    /* access modifiers changed from: protected */
    public final Parcel j(int i5, Parcel parcel) {
        parcel = Parcel.obtain();
        try {
            this.f4419a.transact(i5, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e5) {
            throw e5;
        } finally {
            parcel.recycle();
        }
    }
}
