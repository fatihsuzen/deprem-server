package android.support.customtabs.trusted;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public interface a extends IInterface {

    /* renamed from: g  reason: collision with root package name */
    public static final String f80g = "android$support$customtabs$trusted$ITrustedWebActivityCallback".replace('$', '.');

    /* renamed from: android.support.customtabs.trusted.a$a  reason: collision with other inner class name */
    public static abstract class C0006a extends Binder implements a {
        static final int TRANSACTION_onExtraCallback = 2;

        /* renamed from: android.support.customtabs.trusted.a$a$a  reason: collision with other inner class name */
        private static class C0007a implements a {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f81a;

            C0007a(IBinder iBinder) {
                this.f81a = iBinder;
            }

            public IBinder asBinder() {
                return this.f81a;
            }

            public void onExtraCallback(String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f80g);
                    obtain.writeString(str);
                    b.d(obtain, bundle, 0);
                    this.f81a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0006a() {
            attachInterface(this, a.f80g);
        }

        public static a asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(a.f80g);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0007a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i5, Parcel parcel, Parcel parcel2, int i6) throws RemoteException {
            String str = a.f80g;
            if (i5 >= 1 && i5 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i5 == 1598968902) {
                parcel2.writeString(str);
                return true;
            } else if (i5 != 2) {
                return super.onTransact(i5, parcel, parcel2, i6);
            } else {
                onExtraCallback(parcel.readString(), (Bundle) b.c(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            }
        }
    }

    public static class b {
        /* access modifiers changed from: private */
        public static Object c(Parcel parcel, Parcelable.Creator creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* access modifiers changed from: private */
        public static void d(Parcel parcel, Parcelable parcelable, int i5) {
            if (parcelable != null) {
                parcel.writeInt(1);
                parcelable.writeToParcel(parcel, i5);
                return;
            }
            parcel.writeInt(0);
        }
    }

    void onExtraCallback(String str, Bundle bundle);
}
