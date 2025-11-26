package g4;

import W2.J;
import android.content.Context;
import android.content.SharedPreferences;
import h4.f;
import j4.d;
import j4.e;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class b {

    /* renamed from: e  reason: collision with root package name */
    public static final a f22173e = new a((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static volatile b f22174f;

    /* renamed from: a  reason: collision with root package name */
    private final Map f22175a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f22176b;

    /* renamed from: c  reason: collision with root package name */
    private final SharedPreferences f22177c;

    /* renamed from: d  reason: collision with root package name */
    private f f22178d;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final synchronized b a(Context context) {
            try {
                t.e(context, "context");
                if (b.f22174f == null) {
                    synchronized (b.class) {
                        if (b.f22174f == null) {
                            b.f22174f = new b(context, (C2633k) null);
                        }
                        J j5 = J.f19942a;
                    }
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            } finally {
            }
            return b.f22174f;
        }

        public final String b(Class... clsArr) {
            t.e(clsArr, "classes");
            int length = clsArr.length;
            String[] strArr = new String[length];
            int length2 = clsArr.length;
            for (int i5 = 0; i5 < length2; i5++) {
                strArr[i5] = clsArr[i5].getSimpleName();
            }
            return c((String[]) Arrays.copyOf(strArr, length));
        }

        public final String c(String... strArr) {
            t.e(strArr, "tags");
            StringBuilder sb = new StringBuilder("MATOMO:");
            int length = strArr.length;
            for (int i5 = 0; i5 < length; i5++) {
                sb.append(strArr[i5]);
                if (i5 < strArr.length - 1) {
                    sb.append(":");
                }
            }
            String sb2 = sb.toString();
            t.d(sb2, "toString(...)");
            return sb2;
        }

        private a() {
        }
    }

    public /* synthetic */ b(Context context, C2633k kVar) {
        this(context);
    }

    public static final synchronized b f(Context context) {
        b a5;
        synchronized (b.class) {
            a5 = f22173e.a(context);
        }
        return a5;
    }

    public static final String i(Class... clsArr) {
        return f22173e.b(clsArr);
    }

    public final Context c() {
        return this.f22176b;
    }

    public final d d() {
        return new d(this.f22176b, new e(), new j4.a());
    }

    public final f e() {
        return this.f22178d;
    }

    public final SharedPreferences g() {
        return this.f22177c;
    }

    public final SharedPreferences h(e eVar) {
        SharedPreferences sharedPreferences;
        String str;
        t.e(eVar, "tracker");
        synchronized (this.f22175a) {
            sharedPreferences = (SharedPreferences) this.f22175a.get(eVar);
            if (sharedPreferences == null) {
                try {
                    str = "org.matomo.sdk_" + j4.b.b(eVar.d());
                } catch (Exception e5) {
                    p4.a.f25678a.d(e5);
                    str = "org.matomo.sdk_" + eVar.d();
                }
                sharedPreferences = this.f22176b.getSharedPreferences(str, 0);
                this.f22175a.put(eVar, sharedPreferences);
            }
        }
        return sharedPreferences;
    }

    private b(Context context) {
        this.f22175a = new HashMap();
        this.f22178d = new h4.b();
        this.f22176b = context.getApplicationContext();
        this.f22177c = context.getSharedPreferences("org.matomo.sdk", 0);
    }
}
