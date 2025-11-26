package d;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

public interface a extends IInterface {

    /* renamed from: j  reason: collision with root package name */
    public static final String f921j = "android$support$v4$os$IResultReceiver".replace('$', '.');

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

    void o0(int i5, Bundle bundle);

    /* renamed from: d.a$a  reason: collision with other inner class name */
    public static abstract class C0018a extends Binder implements a {

        /* renamed from: d.a$a$a  reason: collision with other inner class name */
        private static class C0019a implements a {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f922a;

            C0019a(IBinder iBinder) {
                this.f922a = iBinder;
            }

            public IBinder asBinder() {
                return this.f922a;
            }

            public void o0(int i5, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f921j);
                    obtain.writeInt(i5);
                    b.d(obtain, bundle, 0);
                    this.f922a.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public C0018a() {
            attachInterface(this, a.f921j);
        }

        public static a i(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(a.f921j);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0019a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public boolean onTransact(int i5, Parcel parcel, Parcel parcel2, int i6) {
            String str = a.f921j;
            if (i5 >= 1 && i5 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i5 == 1598968902) {
                parcel2.writeString(str);
                return true;
            } else if (i5 != 1) {
                return super.onTransact(i5, parcel, parcel2, i6);
            } else {
                o0(parcel.readInt(), (Bundle) b.c(parcel, Bundle.CREATOR));
                return true;
            }
        }

        public IBinder asBinder() {
            return this;
        }
    }
}
