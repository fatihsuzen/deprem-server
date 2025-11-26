package androidx.room.util;

import androidx.annotation.RestrictTo;
import kotlin.jvm.internal.t;
import t3.s;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class KClassUtil {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <T, C> T findAndInstantiateDatabaseImpl(Class<C> cls, String str) {
        String str2;
        String str3;
        t.e(cls, "klass");
        t.e(str, "suffix");
        Package packageR = cls.getPackage();
        if (packageR == null || (str2 = packageR.getName()) == null) {
            str2 = "";
        }
        String canonicalName = cls.getCanonicalName();
        t.b(canonicalName);
        if (str2.length() != 0) {
            canonicalName = canonicalName.substring(str2.length() + 1);
            t.d(canonicalName, "substring(...)");
        }
        String str4 = canonicalName;
        String str5 = s.K(str4, '.', '_', false, 4, (Object) null) + str;
        try {
            if (str2.length() == 0) {
                str3 = str5;
            } else {
                str3 = str2 + '.' + str5;
            }
            Class<?> cls2 = Class.forName(str3, true, cls.getClassLoader());
            t.c(cls2, "null cannot be cast to non-null type java.lang.Class<T of androidx.room.util.KClassUtil.findAndInstantiateDatabaseImpl>");
            return cls2.getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("Cannot find implementation for " + cls.getCanonicalName() + ". " + str5 + " does not exist. Is Room annotation processor correctly configured?", e5);
        } catch (IllegalAccessException e6) {
            throw new RuntimeException("Cannot access the constructor " + cls.getCanonicalName(), e6);
        } catch (InstantiationException e7) {
            throw new RuntimeException("Failed to create an instance of " + cls.getCanonicalName(), e7);
        }
    }

    public static /* synthetic */ Object findAndInstantiateDatabaseImpl$default(Class cls, String str, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str = "_Impl";
        }
        return findAndInstantiateDatabaseImpl(cls, str);
    }
}
