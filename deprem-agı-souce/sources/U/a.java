package U;

import android.os.IBinder;
import android.os.IInterface;
import b0.C1005d;

public interface a extends IInterface {

    /* renamed from: U.a$a  reason: collision with other inner class name */
    public static abstract class C0060a extends C1005d implements a {
        public C0060a() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        public static a j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            if (queryLocalInterface instanceof a) {
                return (a) queryLocalInterface;
            }
            return new c(iBinder);
        }
    }
}
