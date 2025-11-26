package b1;

import X2.C2250q;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.google.android.gms.common.util.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.t;

public final class G {

    /* renamed from: a  reason: collision with root package name */
    public static final G f4531a = new G();

    private G() {
    }

    private final String c() {
        String a5;
        int i5 = Build.VERSION.SDK_INT;
        if (i5 > 33) {
            String a6 = Process.myProcessName();
            t.d(a6, "myProcessName(...)");
            return a6;
        } else if (i5 >= 28 && (a5 = Application.getProcessName()) != null) {
            return a5;
        } else {
            String a7 = n.a();
            if (a7 != null) {
                return a7;
            }
            return "";
        }
    }

    public final List a(Context context) {
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
            String str2 = runningAppProcessInfo.processName;
            t.d(str2, "processName");
            arrayList2.add(new F(str2, runningAppProcessInfo.pid, runningAppProcessInfo.importance, t.a(runningAppProcessInfo.processName, str)));
        }
        return arrayList2;
    }

    public final F b(Context context) {
        Object obj;
        t.e(context, "context");
        int myPid = Process.myPid();
        Iterator it = a(context).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((F) obj).b() == myPid) {
                break;
            }
        }
        F f5 = (F) obj;
        if (f5 == null) {
            return new F(c(), myPid, 0, false);
        }
        return f5;
    }
}
