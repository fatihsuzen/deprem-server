package b0;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: b0.a  reason: case insensitive filesystem */
public abstract class C1002a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f4510a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4511b;

    protected C1002a(IBinder iBinder, String str) {
        this.f4510a = iBinder;
        this.f4511b = str;
    }

    public final IBinder asBinder() {
        return this.f4510a;
    }

    /* access modifiers changed from: protected */
    public final Parcel i(int i5, Parcel parcel) {
        parcel = Parcel.obtain();
        try {
            this.f4510a.transact(i5, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e5) {
            throw e5;
        } finally {
            parcel.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public final Parcel j() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f4511b);
        return obtain;
    }
}
