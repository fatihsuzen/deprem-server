package android.support.customtabs;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public interface a extends IInterface {

    /* renamed from: c  reason: collision with root package name */
    public static final String f72c = "android$support$customtabs$ICustomTabsCallback".replace('$', '.');

    /* renamed from: android.support.customtabs.a$a  reason: collision with other inner class name */
    public static abstract class C0000a extends Binder implements a {
        static final int TRANSACTION_extraCallback = 3;
        static final int TRANSACTION_extraCallbackWithResult = 7;
        static final int TRANSACTION_onActivityLayout = 10;
        static final int TRANSACTION_onActivityResized = 8;
        static final int TRANSACTION_onMessageChannelReady = 4;
        static final int TRANSACTION_onMinimized = 11;
        static final int TRANSACTION_onNavigationEvent = 2;
        static final int TRANSACTION_onPostMessage = 5;
        static final int TRANSACTION_onRelationshipValidationResult = 6;
        static final int TRANSACTION_onUnminimized = 12;
        static final int TRANSACTION_onWarmupCompleted = 9;

        /* renamed from: android.support.customtabs.a$a$a  reason: collision with other inner class name */
        private static class C0001a implements a {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f73a;

            C0001a(IBinder iBinder) {
                this.f73a = iBinder;
            }

            public IBinder asBinder() {
                return this.f73a;
            }

            public void extraCallback(String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f72c);
                    obtain.writeString(str);
                    b.d(obtain, bundle, 0);
                    this.f73a.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public Bundle extraCallbackWithResult(String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f72c);
                    obtain.writeString(str);
                    b.d(obtain, bundle, 0);
                    this.f73a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return (Bundle) b.c(obtain2, Bundle.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onActivityLayout(int i5, int i6, int i7, int i8, int i9, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f72c);
                    obtain.writeInt(i5);
                    obtain.writeInt(i6);
                    obtain.writeInt(i7);
                    obtain.writeInt(i8);
                    obtain.writeInt(i9);
                    b.d(obtain, bundle, 0);
                    this.f73a.transact(10, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onActivityResized(int i5, int i6, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f72c);
                    obtain.writeInt(i5);
                    obtain.writeInt(i6);
                    b.d(obtain, bundle, 0);
                    this.f73a.transact(8, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onMessageChannelReady(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f72c);
                    b.d(obtain, bundle, 0);
                    this.f73a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onMinimized(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f72c);
                    b.d(obtain, bundle, 0);
                    this.f73a.transact(11, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onNavigationEvent(int i5, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f72c);
                    obtain.writeInt(i5);
                    b.d(obtain, bundle, 0);
                    this.f73a.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onPostMessage(String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f72c);
                    obtain.writeString(str);
                    b.d(obtain, bundle, 0);
                    this.f73a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onRelationshipValidationResult(int i5, Uri uri, boolean z4, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f72c);
                    obtain.writeInt(i5);
                    b.d(obtain, uri, 0);
                    obtain.writeInt(z4 ? 1 : 0);
                    b.d(obtain, bundle, 0);
                    this.f73a.transact(6, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onUnminimized(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f72c);
                    b.d(obtain, bundle, 0);
                    this.f73a.transact(12, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onWarmupCompleted(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f72c);
                    b.d(obtain, bundle, 0);
                    this.f73a.transact(9, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public C0000a() {
            attachInterface(this, a.f72c);
        }

        public static a asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(a.f72c);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0001a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i5, Parcel parcel, Parcel parcel2, int i6) throws RemoteException {
            boolean z4;
            String str = a.f72c;
            if (i5 >= 1 && i5 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i5 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            switch (i5) {
                case 2:
                    onNavigationEvent(parcel.readInt(), (Bundle) b.c(parcel, Bundle.CREATOR));
                    break;
                case 3:
                    extraCallback(parcel.readString(), (Bundle) b.c(parcel, Bundle.CREATOR));
                    break;
                case 4:
                    onMessageChannelReady((Bundle) b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    break;
                case 5:
                    onPostMessage(parcel.readString(), (Bundle) b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    break;
                case 6:
                    int readInt = parcel.readInt();
                    Uri uri = (Uri) b.c(parcel, Uri.CREATOR);
                    if (parcel.readInt() != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    onRelationshipValidationResult(readInt, uri, z4, (Bundle) b.c(parcel, Bundle.CREATOR));
                    break;
                case 7:
                    Bundle extraCallbackWithResult = extraCallbackWithResult(parcel.readString(), (Bundle) b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    b.d(parcel2, extraCallbackWithResult, 1);
                    break;
                case 8:
                    onActivityResized(parcel.readInt(), parcel.readInt(), (Bundle) b.c(parcel, Bundle.CREATOR));
                    break;
                case 9:
                    onWarmupCompleted((Bundle) b.c(parcel, Bundle.CREATOR));
                    break;
                case 10:
                    onActivityLayout(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), (Bundle) b.c(parcel, Bundle.CREATOR));
                    break;
                case 11:
                    onMinimized((Bundle) b.c(parcel, Bundle.CREATOR));
                    break;
                case 12:
                    onUnminimized((Bundle) b.c(parcel, Bundle.CREATOR));
                    break;
                default:
                    return super.onTransact(i5, parcel, parcel2, i6);
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

    void extraCallback(String str, Bundle bundle);

    Bundle extraCallbackWithResult(String str, Bundle bundle);

    void onActivityLayout(int i5, int i6, int i7, int i8, int i9, Bundle bundle);

    void onActivityResized(int i5, int i6, Bundle bundle);

    void onMessageChannelReady(Bundle bundle);

    void onMinimized(Bundle bundle);

    void onNavigationEvent(int i5, Bundle bundle);

    void onPostMessage(String str, Bundle bundle);

    void onRelationshipValidationResult(int i5, Uri uri, boolean z4, Bundle bundle);

    void onUnminimized(Bundle bundle);

    void onWarmupCompleted(Bundle bundle);
}
