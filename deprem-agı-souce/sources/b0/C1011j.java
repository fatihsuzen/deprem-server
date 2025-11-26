package b0;

/* renamed from: b0.j  reason: case insensitive filesystem */
public abstract class C1011j {
    public static Object a(Class cls, String str, C1009h... hVarArr) {
        return c(cls, "isIsolated", (Object) null, false, hVarArr);
    }

    public static Object b(String str, String str2, ClassLoader classLoader, C1009h... hVarArr) {
        return c(classLoader.loadClass("com.google.android.gms.common.security.ProviderInstallerImpl"), "reportRequestStats2", (Object) null, false, hVarArr);
    }

    private static Object c(Class cls, String str, Object obj, boolean z4, C1009h... hVarArr) {
        int length = hVarArr.length;
        Class[] clsArr = new Class[length];
        Object[] objArr = new Object[length];
        for (int i5 = 0; i5 < hVarArr.length; i5++) {
            C1009h hVar = hVarArr[i5];
            hVar.getClass();
            clsArr[i5] = hVar.b();
            objArr[i5] = hVarArr[i5].c();
        }
        return cls.getDeclaredMethod(str, clsArr).invoke((Object) null, objArr);
    }
}
