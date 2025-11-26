package V2;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import kotlin.jvm.internal.t;

public abstract class b {
    public static final Parcelable a(Bundle bundle, String str, Class cls) {
        Parcelable parcelable;
        t.e(str, "key");
        t.e(cls, "clazz");
        if (Build.VERSION.SDK_INT >= 33) {
            parcelable = (Parcelable) bundle.getParcelable(str, cls);
            if (parcelable == null) {
                parcelable = (Parcelable) cls.getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
            }
        } else {
            parcelable = bundle.getParcelable(str);
            if (parcelable == null) {
                parcelable = (Parcelable) cls.getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
            }
        }
        if (parcelable != null) {
            return parcelable;
        }
        Object newInstance = cls.getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        t.d(newInstance, "clazz.getDeclaredConstructor().newInstance()");
        return (Parcelable) newInstance;
    }
}
