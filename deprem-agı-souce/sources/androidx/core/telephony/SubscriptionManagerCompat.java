package androidx.core.telephony;

import android.os.Build;
import android.telephony.SubscriptionManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RequiresApi(22)
public class SubscriptionManagerCompat {
    private static Method sGetSlotIndexMethod;

    @RequiresApi(29)
    private static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static int getSlotIndex(int i5) {
            return SubscriptionManager.getSlotIndex(i5);
        }
    }

    private SubscriptionManagerCompat() {
    }

    public static int getSlotIndex(int i5) {
        if (i5 == -1) {
            return -1;
        }
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 29) {
            return Api29Impl.getSlotIndex(i5);
        }
        try {
            if (sGetSlotIndexMethod == null) {
                Class cls = Integer.TYPE;
                Class<SubscriptionManager> cls2 = SubscriptionManager.class;
                if (i6 >= 26) {
                    sGetSlotIndexMethod = cls2.getDeclaredMethod("getSlotIndex", new Class[]{cls});
                } else {
                    sGetSlotIndexMethod = cls2.getDeclaredMethod("getSlotId", new Class[]{cls});
                }
                sGetSlotIndexMethod.setAccessible(true);
            }
            Integer num = (Integer) sGetSlotIndexMethod.invoke((Object) null, new Object[]{Integer.valueOf(i5)});
            if (num != null) {
                return num.intValue();
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        return -1;
    }
}
