package android.support.customtabs;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public interface c extends IInterface {

    /* renamed from: e  reason: collision with root package name */
    public static final String f76e = "android$support$customtabs$IEngagementSignalsCallback".replace('$', '.');

    public static abstract class a extends Binder implements c {
        static final int TRANSACTION_onGreatestScrollPercentageIncreased = 3;
        static final int TRANSACTION_onSessionEnded = 4;
        static final int TRANSACTION_onVerticalScrollEvent = 2;

        /* renamed from: android.support.customtabs.c$a$a  reason: collision with other inner class name */
        private static class C0004a implements c {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f77a;

            C0004a(IBinder iBinder) {
                this.f77a = iBinder;
            }

            public IBinder asBinder() {
                return this.f77a;
            }

            public void onGreatestScrollPercentageIncreased(int i5, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(c.f76e);
                    obtain.writeInt(i5);
                    b.d(obtain, bundle, 0);
                    this.f77a.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onSessionEnded(boolean z4, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(c.f76e);
                    obtain.writeInt(z4 ? 1 : 0);
                    b.d(obtain, bundle, 0);
                    this.f77a.transact(4, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onVerticalScrollEvent(boolean z4, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(c.f76e);
                    obtain.writeInt(z4 ? 1 : 0);
                    b.d(obtain, bundle, 0);
                    this.f77a.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, c.f76e);
        }

        public static c asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(c.f76e);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof c)) {
                return new C0004a(iBinder);
            }
            return (c) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i5, Parcel parcel, Parcel parcel2, int i6) throws RemoteException {
            String str = c.f76e;
            if (i5 >= 1 && i5 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i5 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            boolean z4 = false;
            if (i5 == 2) {
                if (parcel.readInt() != 0) {
                    z4 = true;
                }
                onVerticalScrollEvent(z4, (Bundle) b.c(parcel, Bundle.CREATOR));
            } else if (i5 == 3) {
                onGreatestScrollPercentageIncreased(parcel.readInt(), (Bundle) b.c(parcel, Bundle.CREATOR));
            } else if (i5 != 4) {
                return super.onTransact(i5, parcel, parcel2, i6);
            } else {
                if (parcel.readInt() != 0) {
                    z4 = true;
                }
                onSessionEnded(z4, (Bundle) b.c(parcel, Bundle.CREATOR));
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

    void onGreatestScrollPercentageIncreased(int i5, Bundle bundle);

    void onSessionEnded(boolean z4, Bundle bundle);

    void onVerticalScrollEvent(boolean z4, Bundle bundle);
}
