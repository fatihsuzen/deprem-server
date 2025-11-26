package u0;

import A0.F;
import X2.C2250q;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.t;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final j f16663a = new j();

    private j() {
    }

    public static /* synthetic */ F.e.d.a.c c(j jVar, String str, int i5, int i6, boolean z4, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i5 = 0;
        }
        if ((i7 & 4) != 0) {
            i6 = 0;
        }
        if ((i7 & 8) != 0) {
            z4 = false;
        }
        return jVar.b(str, i5, i6, z4);
    }

    private final String f() {
        String a5;
        int i5 = Build.VERSION.SDK_INT;
        if (i5 > 33) {
            String a6 = Process.myProcessName();
            t.b(a6);
            return a6;
        } else if (i5 < 28 || (a5 = Application.getProcessName()) == null) {
            return "";
        } else {
            return a5;
        }
    }

    public final F.e.d.a.c a(String str, int i5, int i6) {
        t.e(str, "processName");
        return c(this, str, i5, i6, false, 8, (Object) null);
    }

    public final F.e.d.a.c b(String str, int i5, int i6, boolean z4) {
        t.e(str, "processName");
        F.e.d.a.c a5 = F.e.d.a.c.a().e(str).d(i5).c(i6).b(z4).a();
        t.d(a5, "build(...)");
        return a5;
    }

    public final List d(Context context) {
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> list;
        t.e(context, "context");
        int i5 = context.getApplicationInfo().uid;
        String str = context.getApplicationInfo().processName;
        Object systemService = context.getSystemService("activity");
        if (systemService instanceof ActivityManager) {
            activityManager = (ActivityManager) systemService;
        } else {
            activityManager = null;
        }
        if (activityManager == null || (list = activityManager.getRunningAppProcesses()) == null) {
            list = C2250q.g();
        }
        ArrayList arrayList = new ArrayList();
        for (Object next : C2250q.J(list)) {
            if (((ActivityManager.RunningAppProcessInfo) next).uid == i5) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(C2250q.p(arrayList, 10));
        int size = arrayList.size();
        int i6 = 0;
        while (i6 < size) {
            Object obj = arrayList.get(i6);
            i6++;
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) obj;
            arrayList2.add(F.e.d.a.c.a().e(runningAppProcessInfo.processName).d(runningAppProcessInfo.pid).c(runningAppProcessInfo.importance).b(t.a(runningAppProcessInfo.processName, str)).a());
        }
        return arrayList2;
    }

    public final F.e.d.a.c e(Context context) {
        Object obj;
        t.e(context, "context");
        int myPid = Process.myPid();
        Iterator it = d(context).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((F.e.d.a.c) obj).c() == myPid) {
                break;
            }
        }
        F.e.d.a.c cVar = (F.e.d.a.c) obj;
        if (cVar != null) {
            return cVar;
        }
        return c(this, f(), myPid, 0, false, 12, (Object) null);
    }
}
