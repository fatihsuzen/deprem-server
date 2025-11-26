package z2;

import android.app.AppOpsManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import androidx.core.content.ContextCompat;
import com.uptodown.activities.preferences.a;
import java.util.List;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class X {

    /* renamed from: e  reason: collision with root package name */
    public static final a f26521e = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private int f26522a;

    /* renamed from: b  reason: collision with root package name */
    private int f26523b;

    /* renamed from: c  reason: collision with root package name */
    private int f26524c;

    /* renamed from: d  reason: collision with root package name */
    private long f26525d;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final boolean a(Context context) {
            t.e(context, "context");
            AppOpsManager appOpsManager = (AppOpsManager) ContextCompat.getSystemService(context, AppOpsManager.class);
            Integer num = null;
            if (Build.VERSION.SDK_INT >= 29) {
                if (appOpsManager != null) {
                    num = Integer.valueOf(appOpsManager.unsafeCheckOpNoThrow("android:get_usage_stats", Process.myUid(), context.getPackageName()));
                }
                if (num != null && num.intValue() == 0) {
                    return true;
                }
                return false;
            }
            if (appOpsManager != null) {
                num = Integer.valueOf(appOpsManager.checkOpNoThrow("android:get_usage_stats", Process.myUid(), context.getPackageName()));
            }
            if (num != null && num.intValue() == 0) {
                return true;
            }
            return false;
        }

        private a() {
        }
    }

    private final boolean i(Context context) {
        return com.uptodown.activities.preferences.a.f15150a.d(context, "stats_enabled", false);
    }

    public final int a() {
        return this.f26522a;
    }

    public final int b() {
        return this.f26523b;
    }

    public final int c() {
        return this.f26524c;
    }

    public final long d() {
        return this.f26525d;
    }

    public final long e(Context context) {
        long totalTimeInForeground;
        t.e(context, "context");
        if (!i(context)) {
            return 0;
        }
        Object systemService = context.getSystemService("usagestats");
        t.c(systemService, "null cannot be cast to non-null type android.app.usage.UsageStatsManager");
        UsageStatsManager usageStatsManager = (UsageStatsManager) systemService;
        long currentTimeMillis = System.currentTimeMillis();
        a.C0147a aVar = com.uptodown.activities.preferences.a.f15150a;
        long x4 = aVar.x(context, currentTimeMillis - ((long) 86400000));
        if (currentTimeMillis - x4 < ((long) 82800000)) {
            return 0;
        }
        aVar.X0(context, currentTimeMillis);
        List<UsageStats> queryUsageStats = usageStatsManager.queryUsageStats(0, x4, currentTimeMillis);
        t.d(queryUsageStats, "queryUsageStats(...)");
        long j5 = 0;
        for (UsageStats next : queryUsageStats) {
            if (next.getPackageName().equals(context.getPackageName())) {
                if (Build.VERSION.SDK_INT >= 29) {
                    totalTimeInForeground = next.getTotalTimeVisible();
                } else {
                    totalTimeInForeground = next.getTotalTimeInForeground();
                }
                j5 += totalTimeInForeground;
            }
        }
        if (j5 >= 0) {
            return j5 / ((long) 1000);
        }
        return j5;
    }

    public final void f(Context context) {
        t.e(context, "context");
        if (i(context)) {
            a.C0147a aVar = com.uptodown.activities.preferences.a.f15150a;
            int l5 = aVar.l(context, "stats_downloads", 0) + 1;
            this.f26522a = l5;
            aVar.M0(context, "stats_downloads", l5);
        }
    }

    public final void g(Context context) {
        t.e(context, "context");
        if (i(context)) {
            a.C0147a aVar = com.uptodown.activities.preferences.a.f15150a;
            int l5 = aVar.l(context, "stats_installs", 0) + 1;
            this.f26523b = l5;
            aVar.M0(context, "stats_installs", l5);
        }
    }

    public final void h(Context context) {
        t.e(context, "context");
        if (i(context)) {
            a.C0147a aVar = com.uptodown.activities.preferences.a.f15150a;
            int l5 = aVar.l(context, "stats_updates", 0) + 1;
            this.f26524c = l5;
            aVar.M0(context, "stats_updates", l5);
        }
    }

    public final void j(Context context) {
        t.e(context, "context");
        a.C0147a aVar = com.uptodown.activities.preferences.a.f15150a;
        this.f26522a = aVar.l(context, "stats_downloads", 0);
        this.f26523b = aVar.l(context, "stats_installs", 0);
        this.f26524c = aVar.l(context, "stats_updates", 0);
        this.f26525d = aVar.z(context, "stats_time", 0);
    }

    public final void k(Context context) {
        t.e(context, "context");
        this.f26522a = 0;
        this.f26523b = 0;
        this.f26524c = 0;
        this.f26525d = 0;
        a.C0147a aVar = com.uptodown.activities.preferences.a.f15150a;
        aVar.M0(context, "stats_downloads", 0);
        aVar.M0(context, "stats_installs", this.f26523b);
        aVar.M0(context, "stats_updates", this.f26524c);
        aVar.Z0(context, "stats_time", this.f26525d);
    }

    public final void l(Context context, boolean z4) {
        t.e(context, "context");
        com.uptodown.activities.preferences.a.f15150a.v0(context, "stats_enabled", z4);
    }

    public final void m(long j5) {
        this.f26525d = j5;
    }
}
