package android.support.customtabs;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.customtabs.a;

public interface d extends IInterface {

    /* renamed from: f  reason: collision with root package name */
    public static final String f78f = "android$support$customtabs$IPostMessageService".replace('$', '.');

    public static abstract class a extends Binder implements d {
        static final int TRANSACTION_onMessageChannelReady = 2;
        static final int TRANSACTION_onPostMessage = 3;

        /* renamed from: android.support.customtabs.d$a$a  reason: collision with other inner class name */
        private static class C0005a implements d {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f79a;

            C0005a(IBinder iBinder) {
                this.f79a = iBinder;
            }

            public IBinder asBinder() {
                return this.f79a;
            }

            public void onMessageChannelReady(a aVar, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(d.f78f);
                    obtain.writeStrongInterface(aVar);
                    b.d(obtain, bundle, 0);
                    this.f79a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onPostMessage(a aVar, String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(d.f78f);
                    obtain.writeStrongInterface(aVar);
                    obtain.writeString(str);
                    b.d(obtain, bundle, 0);
                    this.f79a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, d.f78f);
        }

        public static d asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(d.f78f);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof d)) {
                return new C0005a(iBinder);
            }
            return (d) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i5, Parcel parcel, Parcel parcel2, int i6) throws RemoteException {
            String str = d.f78f;
            if (i5 >= 1 && i5 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i5 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i5 == 2) {
                onMessageChannelReady(a.C0000a.asInterface(parcel.readStrongBinder()), (Bundle) b.c(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
            } else if (i5 != 3) {
                return super.onTransact(i5, parcel, parcel2, i6);
            } else {
                onPostMessage(a.C0000a.asInterface(parcel.readStrongBinder()), parcel.readString(), (Bundle) b.c(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
            }
            return true;
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

    void onMessageChannelReady(a aVar, Bundle bundle);

    void onPostMessage(a aVar, String str, Bundle bundle);
}
