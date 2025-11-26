package b2;

import Y1.g;
import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.C2625c;
import kotlin.jvm.internal.t;
import t3.s;

/* renamed from: b2.I  reason: case insensitive filesystem */
public final class C2277I {
    public final ArrayList a(String str) {
        File[] listFiles;
        boolean z4;
        t.e(str, "packagename");
        ArrayList arrayList = new ArrayList();
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/Obb/" + str);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            if (listFiles.length == 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (!z4) {
                Iterator a5 = C2625c.a(listFiles);
                while (a5.hasNext()) {
                    File file2 = (File) a5.next();
                    if (file2.isFile()) {
                        String name = file2.getName();
                        t.d(name, "getName(...)");
                        if (s.D(name, ".obb", false, 2, (Object) null)) {
                            arrayList.add(file2);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:25|26|27|28|29|30|31|32|38) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00b3 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00cf */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005c A[SYNTHETIC, Splitter:B:14:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0074 A[SYNTHETIC, Splitter:B:20:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[ExcHandler: IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:1:0x001a] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d2 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.ArrayList b(android.content.Context r14) {
        /*
            r13 = this;
            java.lang.Class<android.os.storage.StorageManager> r0 = android.os.storage.StorageManager.class
            java.lang.String r1 = "context"
            kotlin.jvm.internal.t.e(r14, r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.String r2 = "storage"
            java.lang.Object r14 = r14.getSystemService(r2)
            java.lang.String r2 = "null cannot be cast to non-null type android.os.storage.StorageManager"
            kotlin.jvm.internal.t.c(r14, r2)
            android.os.storage.StorageManager r14 = (android.os.storage.StorageManager) r14
            r2 = 0
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6 }
            java.lang.String r4 = "getVolumeList"
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r2)     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6 }
            java.lang.Class[] r3 = (java.lang.Class[]) r3     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6 }
            java.lang.reflect.Method r3 = r0.getMethod(r4, r3)     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6 }
            r4 = 1
            r3.setAccessible(r4)     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6 }
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6 }
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r2)     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6 }
            java.lang.Object r3 = r3.invoke(r14, r5)     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6 }
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.Array<*>"
            kotlin.jvm.internal.t.c(r3, r5)     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6 }
            java.lang.Object[] r3 = (java.lang.Object[]) r3     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6 }
            int r5 = r3.length     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6 }
            r6 = r2
        L_0x003f:
            if (r6 >= r5) goto L_0x00d6
            r7 = r3[r6]     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6 }
            if (r7 == 0) goto L_0x00d2
            r8 = 0
            java.lang.Class r9 = r7.getClass()     // Catch:{ NoSuchMethodException -> 0x0059, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6 }
            java.lang.String r10 = "getPath"
            java.lang.reflect.Method r9 = r9.getMethod(r10, r8)     // Catch:{ NoSuchMethodException -> 0x0059, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6 }
            java.lang.Object r9 = r9.invoke(r7, r8)     // Catch:{ NoSuchMethodException -> 0x0059, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6 }
            if (r9 == 0) goto L_0x0059
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ NoSuchMethodException -> 0x0059, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6 }
            goto L_0x005a
        L_0x0059:
            r9 = r8
        L_0x005a:
            if (r9 != 0) goto L_0x0072
            java.lang.Class r10 = r7.getClass()     // Catch:{ NoSuchMethodException -> 0x0072, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6 }
            java.lang.String r11 = "getDirectory"
            java.lang.reflect.Method r10 = r10.getMethod(r11, r8)     // Catch:{ NoSuchMethodException -> 0x0072, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6 }
            java.lang.Object r10 = r10.invoke(r7, r8)     // Catch:{ NoSuchMethodException -> 0x0072, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6 }
            if (r10 == 0) goto L_0x0072
            java.io.File r10 = (java.io.File) r10     // Catch:{ NoSuchMethodException -> 0x0072, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6 }
            java.lang.String r9 = r10.getAbsolutePath()     // Catch:{ NoSuchMethodException -> 0x0072, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6 }
        L_0x0072:
            if (r9 == 0) goto L_0x00d2
            Y1.g r10 = new Y1.g     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6 }
            r10.<init>(r9)     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6 }
            java.io.File r11 = new java.io.File     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6 }
            r11.<init>(r9)     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6 }
            boolean r9 = r11.exists()     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6 }
            if (r9 == 0) goto L_0x00d2
            boolean r9 = r11.isDirectory()     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6 }
            if (r9 == 0) goto L_0x00d2
            long r11 = r11.getUsableSpace()     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6 }
            r10.e(r11)     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6 }
            java.lang.String r9 = "getVolumeState"
            java.lang.Class[] r11 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x00b3 }
            java.lang.Class<java.lang.String> r12 = java.lang.String.class
            r11[r2] = r12     // Catch:{ Exception -> 0x00b3 }
            java.lang.reflect.Method r9 = r0.getMethod(r9, r11)     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r11 = r10.b()     // Catch:{ Exception -> 0x00b3 }
            java.lang.Object[] r12 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x00b3 }
            r12[r2] = r11     // Catch:{ Exception -> 0x00b3 }
            java.lang.Object r9 = r9.invoke(r14, r12)     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r11 = "null cannot be cast to non-null type kotlin.String"
            kotlin.jvm.internal.t.c(r9, r11)     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x00b3 }
            r10.g(r9)     // Catch:{ Exception -> 0x00b3 }
        L_0x00b3:
            java.lang.Class r9 = r7.getClass()     // Catch:{ Exception -> 0x00cf }
            java.lang.String r11 = "isRemovable"
            java.lang.reflect.Method r9 = r9.getMethod(r11, r8)     // Catch:{ Exception -> 0x00cf }
            java.lang.Object r7 = r9.invoke(r7, r8)     // Catch:{ Exception -> 0x00cf }
            java.lang.String r8 = "null cannot be cast to non-null type kotlin.Boolean"
            kotlin.jvm.internal.t.c(r7, r8)     // Catch:{ Exception -> 0x00cf }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ Exception -> 0x00cf }
            boolean r7 = r7.booleanValue()     // Catch:{ Exception -> 0x00cf }
            r10.f(r7)     // Catch:{ Exception -> 0x00cf }
        L_0x00cf:
            r1.add(r10)     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00d6 }
        L_0x00d2:
            int r6 = r6 + 1
            goto L_0x003f
        L_0x00d6:
            r1.trimToSize()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.C2277I.b(android.content.Context):java.util.ArrayList");
    }

    public final ArrayList c(Context context) {
        t.e(context, "context");
        ArrayList arrayList = new ArrayList();
        try {
            ArrayList b5 = b(context);
            int size = b5.size();
            for (int i5 = 0; i5 < size; i5++) {
                if (!s.V(((g) b5.get(i5)).b(), "/emulated/", false, 2, (Object) null) && ((g) b5.get(i5)).d() && ((g) b5.get(i5)).c()) {
                    File file = new File(((g) b5.get(i5)).b() + ("/Android/data/" + context.getPackageName()));
                    if (!file.exists()) {
                        if (file.mkdirs()) {
                            arrayList.add(b5.get(i5));
                        }
                    } else if (file.canWrite()) {
                        arrayList.add(b5.get(i5));
                    }
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }
}
