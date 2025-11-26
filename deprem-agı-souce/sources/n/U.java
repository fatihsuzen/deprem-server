package N;

import android.os.IBinder;
import android.os.Parcel;

final class U implements C0718l {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f3005a;

    U(IBinder iBinder) {
        this.f3005a = iBinder;
    }

    public final void E(C0717k kVar, C0712f fVar) {
        IBinder iBinder;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (kVar != null) {
                iBinder = kVar.asBinder();
            } else {
                iBinder = null;
            }
            obtain.writeStrongBinder(iBinder);
            if (fVar != null) {
                obtain.writeInt(1);
                l0.a(fVar, obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f3005a.transact(46, obtain, obtain2, 0);
            obtain2.readException();
            obtain2.recycle();
            obtain.recycle();
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
            throw th;
        }
    }

    public final IBinder asBinder() {
        return this.f3005a;
    }
}
