package z2;

import W2.J;
import W2.u;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.text.Html;
import android.text.Spanned;
import androidx.core.content.ContextCompat;
import b2.C2286f;
import b2.C2301u;
import b3.C2308e;
import c3.C2316b;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.uptodown.R;
import j$.util.DesugarTimeZone;
import j$.util.concurrent.ConcurrentHashMap;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import m2.C2685e;
import m2.C2686f;
import w3.C2865c0;
import w3.C2872g;
import w3.M;

public final class P {

    /* renamed from: a  reason: collision with root package name */
    public static final P f26510a = new P();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static ConcurrentHashMap f26511b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    private static C2686f f26512c = new C2686f((Handler) null);

    /* renamed from: d  reason: collision with root package name */
    private static C2685e f26513d = new C2685e((Handler) null);

    /* renamed from: e  reason: collision with root package name */
    private static final ArrayList f26514e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private static final ArrayList f26515f = new ArrayList();

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f26516a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f26517b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f26518c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(String str, Context context, C2308e eVar) {
            super(2, eVar);
            this.f26517b = str;
            this.f26518c = context;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f26517b, this.f26518c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Drawable drawable;
            C2316b.f();
            if (this.f26516a == 0) {
                u.b(obj);
                if (this.f26517b != null && (drawable = (Drawable) P.f26511b.get(this.f26517b)) == null) {
                    try {
                        PackageManager packageManager = this.f26518c.getPackageManager();
                        t.d(packageManager, "getPackageManager(...)");
                        ApplicationInfo applicationInfo = C2301u.d(packageManager, this.f26517b, 0).applicationInfo;
                        if (applicationInfo != null) {
                            t.b(applicationInfo);
                            drawable = applicationInfo.loadIcon(this.f26518c.getPackageManager());
                        }
                    } catch (Exception unused) {
                        drawable = ContextCompat.getDrawable(this.f26518c, R.drawable.vector_uptodown_logo_disabled);
                    }
                    if (drawable != null) {
                        P.f26511b.put(this.f26517b, drawable);
                    }
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    private P() {
    }

    public final String b(long j5, Context context) {
        t.e(context, "context");
        long j6 = (long) 3600;
        long j7 = (j5 % ((long) 86400)) / j6;
        long j8 = (j5 % j6) / ((long) 60);
        int i5 = (j7 > 0 ? 1 : (j7 == 0 ? 0 : -1));
        if (i5 > 0 && j8 > 0) {
            String string = context.getString(R.string.time_format_hours_minutes, new Object[]{Long.valueOf(j7), Long.valueOf(j8)});
            t.b(string);
            return string;
        } else if (i5 > 0) {
            String string2 = context.getString(R.string.time_format_hours_only, new Object[]{Long.valueOf(j7)});
            t.b(string2);
            return string2;
        } else if (j8 > 0) {
            String string3 = context.getString(R.string.time_format_minutes_only, new Object[]{Long.valueOf(j8)});
            t.b(string3);
            return string3;
        } else {
            String string4 = context.getString(R.string.time_format_minutes_only, new Object[]{0});
            t.b(string4);
            return string4;
        }
    }

    public final Spanned c(String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            Spanned a5 = Html.fromHtml(str, 0);
            t.d(a5, "fromHtml(...)");
            return a5;
        }
        Spanned fromHtml = Html.fromHtml(str);
        t.d(fromHtml, "fromHtml(...)");
        return fromHtml;
    }

    public final String d() {
        DateFormat timeInstance = DateFormat.getTimeInstance();
        timeInstance.setTimeZone(DesugarTimeZone.getTimeZone("gmt"));
        timeInstance.format(new Date(System.currentTimeMillis()));
        Calendar calendar = timeInstance.getCalendar();
        int i5 = (calendar.get(12) * MBridgeCommon.DEFAULT_LOAD_TIMEOUT) + (calendar.get(13) * 1000);
        long timeInMillis = (calendar.getTimeInMillis() - ((long) (i5 + calendar.get(14)))) / ((long) 1000);
        C2286f fVar = C2286f.f20690a;
        return fVar.c("$(=a%·!45J&S" + timeInMillis);
    }

    public final C2685e e() {
        return f26513d;
    }

    public final C2686f f() {
        return f26512c;
    }

    public final ArrayList g() {
        return f26515f;
    }

    public final ArrayList h() {
        return f26514e;
    }

    public final boolean i(char c5) {
        if (1424 > c5 || c5 >= 1792) {
            return false;
        }
        return true;
    }

    public final Drawable j(Context context, String str) {
        Drawable drawable;
        t.e(context, "context");
        if (str != null) {
            drawable = (Drawable) f26511b.get(str);
        } else {
            drawable = null;
        }
        if (drawable == null) {
            return ContextCompat.getDrawable(context, R.drawable.vector_uptodown_logo_disabled);
        }
        return drawable;
    }

    public final Object k(Context context, String str, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new a(str, context, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }
}
