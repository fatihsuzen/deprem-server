package g0;

import K.C0661h;
import K.C0662i;
import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* renamed from: g0.a  reason: case insensitive filesystem */
public abstract class C1664a {

    /* renamed from: a  reason: collision with root package name */
    private static final C0661h f15344a = C0661h.f();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f15345b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static Method f15346c = null;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f15347d = false;

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r11) {
        /*
            java.lang.String r0 = "Context must not be null"
            N.C0722p.l(r11, r0)
            K.h r0 = f15344a
            r1 = 11925000(0xb5f608, float:1.6710484E-38)
            r0.k(r11, r1)
            long r0 = android.os.SystemClock.uptimeMillis()
            java.lang.Object r2 = f15345b
            monitor-enter(r2)
            boolean r3 = f15347d     // Catch:{ all -> 0x0026 }
            r4 = 0
            if (r3 != 0) goto L_0x0047
            com.google.android.gms.dynamite.DynamiteModule$b r3 = com.google.android.gms.dynamite.DynamiteModule.f4901f     // Catch:{ a -> 0x0029 }
            java.lang.String r5 = "com.google.android.gms.providerinstaller.dynamite"
            com.google.android.gms.dynamite.DynamiteModule r3 = com.google.android.gms.dynamite.DynamiteModule.e(r11, r3, r5)     // Catch:{ a -> 0x0029 }
            android.content.Context r3 = r3.b()     // Catch:{ a -> 0x0029 }
            goto L_0x003e
        L_0x0026:
            r11 = move-exception
            goto L_0x00a7
        L_0x0029:
            r3 = move-exception
            java.lang.String r5 = "ProviderInstaller"
            java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x0026 }
            java.lang.String r6 = "Failed to load providerinstaller module: "
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0026 }
            java.lang.String r3 = r6.concat(r3)     // Catch:{ all -> 0x0026 }
            android.util.Log.w(r5, r3)     // Catch:{ all -> 0x0026 }
            r3 = r4
        L_0x003e:
            if (r3 == 0) goto L_0x0047
            java.lang.String r0 = "com.google.android.gms.providerinstaller.ProviderInstallerImpl"
            b(r3, r11, r0)     // Catch:{ all -> 0x0026 }
            monitor-exit(r2)     // Catch:{ all -> 0x0026 }
            goto L_0x0097
        L_0x0047:
            boolean r3 = f15347d     // Catch:{ all -> 0x0026 }
            android.content.Context r5 = K.C0665l.d(r11)     // Catch:{ all -> 0x0026 }
            if (r5 != 0) goto L_0x0050
            goto L_0x008f
        L_0x0050:
            r4 = 1
            f15347d = r4     // Catch:{ all -> 0x0026 }
            if (r3 != 0) goto L_0x008e
            long r6 = android.os.SystemClock.uptimeMillis()     // Catch:{ Exception -> 0x007e }
            java.lang.String r3 = "com.google.android.gms.common.security.ProviderInstallerImpl"
            java.lang.String r8 = "reportRequestStats2"
            java.lang.ClassLoader r9 = r5.getClassLoader()     // Catch:{ Exception -> 0x007e }
            java.lang.Class<android.content.Context> r10 = android.content.Context.class
            b0.h r10 = b0.C1009h.a(r10, r11)     // Catch:{ Exception -> 0x007e }
            b0.g r0 = b0.C1008g.d(r0)     // Catch:{ Exception -> 0x007e }
            b0.g r1 = b0.C1008g.d(r6)     // Catch:{ Exception -> 0x007e }
            r6 = 3
            b0.h[] r6 = new b0.C1009h[r6]     // Catch:{ Exception -> 0x007e }
            r7 = 0
            r6[r7] = r10     // Catch:{ Exception -> 0x007e }
            r6[r4] = r0     // Catch:{ Exception -> 0x007e }
            r0 = 2
            r6[r0] = r1     // Catch:{ Exception -> 0x007e }
            b0.C1011j.b(r3, r8, r9, r6)     // Catch:{ Exception -> 0x007e }
            goto L_0x008e
        L_0x007e:
            r0 = move-exception
            java.lang.String r1 = "ProviderInstaller"
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0026 }
            java.lang.String r3 = "Failed to report request stats: "
            java.lang.String r0 = r3.concat(r0)     // Catch:{ all -> 0x0026 }
            android.util.Log.w(r1, r0)     // Catch:{ all -> 0x0026 }
        L_0x008e:
            r4 = r5
        L_0x008f:
            if (r4 == 0) goto L_0x0098
            java.lang.String r0 = "com.google.android.gms.common.security.ProviderInstallerImpl"
            b(r4, r11, r0)     // Catch:{ all -> 0x0026 }
            monitor-exit(r2)     // Catch:{ all -> 0x0026 }
        L_0x0097:
            return
        L_0x0098:
            java.lang.String r11 = "ProviderInstaller"
            java.lang.String r0 = "Failed to get remote context"
            android.util.Log.e(r11, r0)     // Catch:{ all -> 0x0026 }
            K.i r11 = new K.i     // Catch:{ all -> 0x0026 }
            r0 = 8
            r11.<init>(r0)     // Catch:{ all -> 0x0026 }
            throw r11     // Catch:{ all -> 0x0026 }
        L_0x00a7:
            monitor-exit(r2)     // Catch:{ all -> 0x0026 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: g0.C1664a.a(android.content.Context):void");
    }

    private static void b(Context context, Context context2, String str) {
        String str2;
        try {
            if (f15346c == null) {
                f15346c = context.getClassLoader().loadClass(str).getMethod("insertProvider", new Class[]{Context.class});
            }
            f15346c.invoke((Object) null, new Object[]{context});
        } catch (Exception e5) {
            Throwable cause = e5.getCause();
            if (Log.isLoggable("ProviderInstaller", 6)) {
                if (cause == null) {
                    str2 = e5.toString();
                } else {
                    str2 = cause.toString();
                }
                Log.e("ProviderInstaller", "Failed to install provider: ".concat(String.valueOf(str2)));
            }
            throw new C0662i(8);
        }
    }
}
