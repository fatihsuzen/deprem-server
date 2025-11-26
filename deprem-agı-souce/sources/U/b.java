package U;

import N.C0722p;
import U.a;
import android.os.IBinder;
import java.lang.reflect.Field;

public final class b extends a.C0060a {

    /* renamed from: a  reason: collision with root package name */
    private final Object f4381a;

    private b(Object obj) {
        this.f4381a = obj;
    }

    public static Object k(a aVar) {
        if (aVar instanceof b) {
            return ((b) aVar).f4381a;
        }
        IBinder asBinder = aVar.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        Field field = null;
        int i5 = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i5++;
                field = field2;
            }
        }
        if (i5 == 1) {
            C0722p.k(field);
            if (!field.isAccessible()) {
                field.setAccessible(true);
                try {
                    return field.get(asBinder);
                } catch (NullPointerException e5) {
                    throw new IllegalArgumentException("Binder object is null.", e5);
                } catch (IllegalAccessException e6) {
                    throw new IllegalArgumentException("Could not access the field in remoteBinder.", e6);
                }
            } else {
                throw new IllegalArgumentException("IObjectWrapper declared field not private!");
            }
        } else {
            throw new IllegalArgumentException("Unexpected number of IObjectWrapper declared fields: " + declaredFields.length);
        }
    }

    public static a q0(Object obj) {
        return new b(obj);
    }
}
