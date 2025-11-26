package Z;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f4491a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4492b;

    protected a(IBinder iBinder, String str) {
        this.f4491a = iBinder;
        this.f4492b = str;
    }

    public final IBinder asBinder() {
        return this.f4491a;
    }

    /* access modifiers changed from: protected */
    public final Parcel i() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f4492b);
        return obtain;
    }

    /* access modifiers changed from: protected */
    public final void j(int i5, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            this.f4491a.transact(i5, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public final void k(int i5, Parcel parcel) {
        try {
            this.f4491a.transact(1, parcel, (Parcel) null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
