package android.content.pm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IPackageDeleteObserver extends IInterface {

    public static abstract class Stub extends Binder implements IPackageDeleteObserver {
        public Stub() {
            throw new RuntimeException("Stub!");
        }

        public static IPackageDeleteObserver asInterface(IBinder iBinder) {
            throw new RuntimeException("Stub!");
        }

        public IBinder asBinder() {
            throw new RuntimeException("Stub!");
        }

        public boolean onTransact(int i5, Parcel parcel, Parcel parcel2, int i6) throws RemoteException {
            throw new RuntimeException("Stub!");
        }
    }

    void packageDeleted(String str, int i5) throws RemoteException;
}
