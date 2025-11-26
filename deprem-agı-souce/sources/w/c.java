package W;

import android.os.Parcel;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    private static final ClassLoader f4421a = c.class.getClassLoader();

    public static void a(Parcel parcel, boolean z4) {
        parcel.writeInt(1);
    }

    public static boolean b(Parcel parcel) {
        if (parcel.readInt() != 0) {
            return true;
        }
        return false;
    }
}
