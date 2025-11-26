package z2;

import X2.C2250q;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import b2.C2301u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.t;
import l2.C2658g;
import t3.s;

public final class J {

    /* renamed from: a  reason: collision with root package name */
    public static final J f26502a = new J();

    private J() {
    }

    private final void a(Context context, String str, C2940B b5, F f5) {
        String h5 = new C2954m().h(context, str);
        if (h5 == null) {
            b5.x(str);
            return;
        }
        String b02 = b5.b0(str);
        if (b02 == null && s.E(h5, "com.uptodown", true)) {
            b5.O0(str, h5);
        } else if (!t.a(b02, h5)) {
            b5.x(str);
            if (s.E(b02, "com.uptodown", true) && s.E(h5, "com.android.vending", true) && f5 != null) {
                f5.e(str);
            }
        }
    }

    public final void b(Context context, F f5) {
        t.e(context, "context");
        C2940B a5 = C2940B.f26458v.a(context);
        a5.a();
        PackageManager packageManager = context.getPackageManager();
        t.b(packageManager);
        List<ApplicationInfo> b5 = C2301u.b(packageManager, 128);
        Iterable<ApplicationInfo> iterable = b5;
        ArrayList arrayList = new ArrayList(C2250q.p(iterable, 10));
        for (ApplicationInfo applicationInfo : iterable) {
            arrayList.add(applicationInfo.packageName);
        }
        Set r02 = C2250q.r0(arrayList);
        for (ApplicationInfo applicationInfo2 : b5) {
            String str = applicationInfo2.packageName;
            t.d(str, "packageName");
            a(context, str, a5, f5);
        }
        Iterator it = a5.c0().iterator();
        t.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            t.d(next, "next(...)");
            C2658g gVar = (C2658g) next;
            if (!r02.contains(gVar.a())) {
                a5.x(gVar.a());
            }
        }
        a5.m();
    }
}
