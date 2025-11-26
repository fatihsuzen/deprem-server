package android.support.customtabs;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.customtabs.a;
import java.util.List;

public interface b extends IInterface {

    /* renamed from: d  reason: collision with root package name */
    public static final String f74d = "android$support$customtabs$ICustomTabsService".replace('$', '.');

    public static abstract class a extends Binder implements b {
        static final int TRANSACTION_extraCommand = 5;
        static final int TRANSACTION_isEngagementSignalsApiAvailable = 13;
        static final int TRANSACTION_mayLaunchUrl = 4;
        static final int TRANSACTION_newSession = 3;
        static final int TRANSACTION_newSessionWithExtras = 10;
        static final int TRANSACTION_postMessage = 8;
        static final int TRANSACTION_receiveFile = 12;
        static final int TRANSACTION_requestPostMessageChannel = 7;
        static final int TRANSACTION_requestPostMessageChannelWithExtras = 11;
        static final int TRANSACTION_setEngagementSignalsCallback = 14;
        static final int TRANSACTION_updateVisuals = 6;
        static final int TRANSACTION_validateRelationship = 9;
        static final int TRANSACTION_warmup = 2;

        /* renamed from: android.support.customtabs.b$a$a  reason: collision with other inner class name */
        private static class C0002a implements b {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f75a;

            C0002a(IBinder iBinder) {
                this.f75a = iBinder;
            }

            public IBinder asBinder() {
                return this.f75a;
            }

            public Bundle extraCommand(String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f74d);
                    obtain.writeString(str);
                    C0003b.f(obtain, bundle, 0);
                    this.f75a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return (Bundle) C0003b.d(obtain2, Bundle.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isEngagementSignalsApiAvailable(a aVar, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f74d);
                    obtain.writeStrongInterface(aVar);
                    boolean z4 = false;
                    C0003b.f(obtain, bundle, 0);
                    this.f75a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z4 = true;
                    }
                    return z4;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean mayLaunchUrl(a aVar, Uri uri, Bundle bundle, List list) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f74d);
                    obtain.writeStrongInterface(aVar);
                    boolean z4 = false;
                    C0003b.f(obtain, uri, 0);
                    C0003b.f(obtain, bundle, 0);
                    C0003b.e(obtain, list, 0);
                    this.f75a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z4 = true;
                    }
                    return z4;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean newSession(a aVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f74d);
                    obtain.writeStrongInterface(aVar);
                    boolean z4 = false;
                    this.f75a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z4 = true;
                    }
                    return z4;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean newSessionWithExtras(a aVar, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f74d);
                    obtain.writeStrongInterface(aVar);
                    boolean z4 = false;
                    C0003b.f(obtain, bundle, 0);
                    this.f75a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z4 = true;
                    }
                    return z4;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int postMessage(a aVar, String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f74d);
                    obtain.writeStrongInterface(aVar);
                    obtain.writeString(str);
                    C0003b.f(obtain, bundle, 0);
                    this.f75a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean receiveFile(a aVar, Uri uri, int i5, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f74d);
                    obtain.writeStrongInterface(aVar);
                    boolean z4 = false;
                    C0003b.f(obtain, uri, 0);
                    obtain.writeInt(i5);
                    C0003b.f(obtain, bundle, 0);
                    this.f75a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z4 = true;
                    }
                    return z4;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean requestPostMessageChannel(a aVar, Uri uri) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f74d);
                    obtain.writeStrongInterface(aVar);
                    boolean z4 = false;
                    C0003b.f(obtain, uri, 0);
                    this.f75a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z4 = true;
                    }
                    return z4;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean requestPostMessageChannelWithExtras(a aVar, Uri uri, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f74d);
                    obtain.writeStrongInterface(aVar);
                    boolean z4 = false;
                    C0003b.f(obtain, uri, 0);
                    C0003b.f(obtain, bundle, 0);
                    this.f75a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z4 = true;
                    }
                    return z4;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean setEngagementSignalsCallback(a aVar, IBinder iBinder, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f74d);
                    obtain.writeStrongInterface(aVar);
                    obtain.writeStrongBinder(iBinder);
                    boolean z4 = false;
                    C0003b.f(obtain, bundle, 0);
                    this.f75a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z4 = true;
                    }
                    return z4;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean updateVisuals(a aVar, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f74d);
                    obtain.writeStrongInterface(aVar);
                    boolean z4 = false;
                    C0003b.f(obtain, bundle, 0);
                    this.f75a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z4 = true;
                    }
                    return z4;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean validateRelationship(a aVar, int i5, Uri uri, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f74d);
                    obtain.writeStrongInterface(aVar);
                    obtain.writeInt(i5);
                    boolean z4 = false;
                    C0003b.f(obtain, uri, 0);
                    C0003b.f(obtain, bundle, 0);
                    this.f75a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z4 = true;
                    }
                    return z4;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean warmup(long j5) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f74d);
                    obtain.writeLong(j5);
                    boolean z4 = false;
                    this.f75a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z4 = true;
                    }
                    return z4;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, b.f74d);
        }

        public static b asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(b.f74d);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
                return new C0002a(iBinder);
            }
            return (b) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i5, Parcel parcel, Parcel parcel2, int i6) throws RemoteException {
            String str = b.f74d;
            if (i5 >= 1 && i5 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i5 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            switch (i5) {
                case 2:
                    boolean warmup = warmup(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(warmup ? 1 : 0);
                    break;
                case 3:
                    boolean newSession = newSession(a.C0000a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(newSession ? 1 : 0);
                    break;
                case 4:
                    Parcelable.Creator creator = Bundle.CREATOR;
                    boolean mayLaunchUrl = mayLaunchUrl(a.C0000a.asInterface(parcel.readStrongBinder()), (Uri) C0003b.d(parcel, Uri.CREATOR), (Bundle) C0003b.d(parcel, creator), parcel.createTypedArrayList(creator));
                    parcel2.writeNoException();
                    parcel2.writeInt(mayLaunchUrl ? 1 : 0);
                    break;
                case 5:
                    Bundle extraCommand = extraCommand(parcel.readString(), (Bundle) C0003b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    C0003b.f(parcel2, extraCommand, 1);
                    break;
                case 6:
                    boolean updateVisuals = updateVisuals(a.C0000a.asInterface(parcel.readStrongBinder()), (Bundle) C0003b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(updateVisuals ? 1 : 0);
                    break;
                case 7:
                    boolean requestPostMessageChannel = requestPostMessageChannel(a.C0000a.asInterface(parcel.readStrongBinder()), (Uri) C0003b.d(parcel, Uri.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(requestPostMessageChannel ? 1 : 0);
                    break;
                case 8:
                    int postMessage = postMessage(a.C0000a.asInterface(parcel.readStrongBinder()), parcel.readString(), (Bundle) C0003b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(postMessage);
                    break;
                case 9:
                    boolean validateRelationship = validateRelationship(a.C0000a.asInterface(parcel.readStrongBinder()), parcel.readInt(), (Uri) C0003b.d(parcel, Uri.CREATOR), (Bundle) C0003b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(validateRelationship ? 1 : 0);
                    break;
                case 10:
                    boolean newSessionWithExtras = newSessionWithExtras(a.C0000a.asInterface(parcel.readStrongBinder()), (Bundle) C0003b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(newSessionWithExtras ? 1 : 0);
                    break;
                case 11:
                    boolean requestPostMessageChannelWithExtras = requestPostMessageChannelWithExtras(a.C0000a.asInterface(parcel.readStrongBinder()), (Uri) C0003b.d(parcel, Uri.CREATOR), (Bundle) C0003b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(requestPostMessageChannelWithExtras ? 1 : 0);
                    break;
                case 12:
                    boolean receiveFile = receiveFile(a.C0000a.asInterface(parcel.readStrongBinder()), (Uri) C0003b.d(parcel, Uri.CREATOR), parcel.readInt(), (Bundle) C0003b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(receiveFile ? 1 : 0);
                    break;
                case 13:
                    boolean isEngagementSignalsApiAvailable = isEngagementSignalsApiAvailable(a.C0000a.asInterface(parcel.readStrongBinder()), (Bundle) C0003b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(isEngagementSignalsApiAvailable ? 1 : 0);
                    break;
                case 14:
                    boolean engagementSignalsCallback = setEngagementSignalsCallback(a.C0000a.asInterface(parcel.readStrongBinder()), parcel.readStrongBinder(), (Bundle) C0003b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(engagementSignalsCallback ? 1 : 0);
                    break;
                default:
                    return super.onTransact(i5, parcel, parcel2, i6);
            }
            return true;
        }
    }

    /* renamed from: android.support.customtabs.b$b  reason: collision with other inner class name */
    public static class C0003b {
        /* access modifiers changed from: private */
        public static Object d(Parcel parcel, Parcelable.Creator creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* access modifiers changed from: private */
        public static void e(Parcel parcel, List list, int i5) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = list.size();
            parcel.writeInt(size);
            for (int i6 = 0; i6 < size; i6++) {
                f(parcel, (Parcelable) list.get(i6), i5);
            }
        }

        /* access modifiers changed from: private */
        public static void f(Parcel parcel, Parcelable parcelable, int i5) {
            if (parcelable != null) {
                parcel.writeInt(1);
                parcelable.writeToParcel(parcel, i5);
                return;
            }
            parcel.writeInt(0);
        }
    }

    Bundle extraCommand(String str, Bundle bundle);

    boolean isEngagementSignalsApiAvailable(a aVar, Bundle bundle);

    boolean mayLaunchUrl(a aVar, Uri uri, Bundle bundle, List list);

    boolean newSession(a aVar);

    boolean newSessionWithExtras(a aVar, Bundle bundle);

    int postMessage(a aVar, String str, Bundle bundle);

    boolean receiveFile(a aVar, Uri uri, int i5, Bundle bundle);

    boolean requestPostMessageChannel(a aVar, Uri uri);

    boolean requestPostMessageChannelWithExtras(a aVar, Uri uri, Bundle bundle);

    boolean setEngagementSignalsCallback(a aVar, IBinder iBinder, Bundle bundle);

    boolean updateVisuals(a aVar, Bundle bundle);

    boolean validateRelationship(a aVar, int i5, Uri uri, Bundle bundle);

    boolean warmup(long j5);
}
