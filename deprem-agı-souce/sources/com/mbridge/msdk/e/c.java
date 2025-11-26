package com.mbridge.msdk.e;

import K.C0660g;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import java.util.ArrayList;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f8764a = "";

    /* renamed from: b  reason: collision with root package name */
    private static boolean f8765b = false;

    public static void a() {
        if (ah.a().a("cronet_env_check", false)) {
            try {
                C0660g.n().a(com.mbridge.msdk.foundation.controller.c.m().c());
                C0660g.n().k(com.mbridge.msdk.foundation.controller.c.m().c(), 11925000);
                try {
                    String b5 = b();
                    boolean isEmpty = TextUtils.isEmpty(b5);
                    f8765b = !isEmpty;
                    if (!isEmpty) {
                        f8764a = b5;
                    }
                } catch (Throwable th) {
                    af.b("CronetEnvCheckUtil", th.getMessage());
                }
            } catch (Throwable th2) {
                af.b("CronetEnvCheckUtil", th2.getMessage());
                f8765b = false;
            }
        }
    }

    private static String b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Pair.create(1, "org.chromium.net.impl.JavaCronetProvider"));
        arrayList.add(Pair.create(2, "org.chromium.net.impl.NativeCronetProvider"));
        arrayList.add(Pair.create(3, "com.google.android.gms.net.PlayServicesCronetProvider"));
        arrayList.add(Pair.create(4, "com.google.android.gms.net.GmsCoreCronetProvider"));
        try {
            StringBuilder sb = new StringBuilder();
            ClassLoader classLoader = com.mbridge.msdk.foundation.controller.c.m().c().getClassLoader();
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList.get(i5);
                i5++;
                Pair pair = (Pair) obj;
                if (!TextUtils.isEmpty(classLoader.loadClass((String) pair.second).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{com.mbridge.msdk.foundation.controller.c.m().c()}).getClass().getName())) {
                    if (sb.length() > 0) {
                        sb.append(",");
                    }
                    sb.append(pair.first);
                }
            }
            return sb.toString();
        } catch (Throwable th) {
            af.b("CronetEnvCheckUtil", th.getMessage());
            return "";
        }
    }
}
