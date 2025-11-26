package c2;

import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import e2.C2347a;
import e2.C2348b;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* renamed from: c2.a  reason: case insensitive filesystem */
public abstract class C2314a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f20796a = false;

    /* renamed from: b  reason: collision with root package name */
    public static int f20797b = 20000;

    /* renamed from: c2.a$a  reason: collision with other inner class name */
    class C0211a extends C2347a {

        /* renamed from: p  reason: collision with root package name */
        final /* synthetic */ Set f20798p;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0211a(int i5, boolean z4, String[] strArr, Set set) {
            super(i5, z4, strArr);
            this.f20798p = set;
        }

        public void c(int i5, String str) {
            if (i5 == 158) {
                this.f20798p.addAll(Arrays.asList(str.split(" ")));
            }
            super.c(i5, str);
        }
    }

    /* renamed from: c2.a$b */
    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f20799a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                c2.a$c[] r0 = c2.C2314a.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f20799a = r0
                c2.a$c r1 = c2.C2314a.c.VERBOSE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20799a     // Catch:{ NoSuchFieldError -> 0x001d }
                c2.a$c r1 = c2.C2314a.c.ERROR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20799a     // Catch:{ NoSuchFieldError -> 0x0028 }
                c2.a$c r1 = c2.C2314a.c.DEBUG     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f20799a     // Catch:{ NoSuchFieldError -> 0x0033 }
                c2.a$c r1 = c2.C2314a.c.WARN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: c2.C2314a.b.<clinit>():void");
        }
    }

    /* renamed from: c2.a$c */
    public enum c {
        VERBOSE,
        ERROR,
        DEBUG,
        WARN
    }

    private static void a(C2348b bVar, C2347a aVar) {
        while (!aVar.i()) {
            e("RootShell v1.4", bVar.G(aVar));
            e("RootShell v1.4", "Processed " + aVar.f21434d + " of " + aVar.f21433c + " output from command.");
            synchronized (aVar) {
                try {
                    if (!aVar.i()) {
                        aVar.wait(AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                    }
                } catch (InterruptedException e5) {
                    e5.printStackTrace();
                }
            }
            if (!aVar.h() && !aVar.i()) {
                boolean z4 = bVar.f21465l;
                if (!z4 && !bVar.f21466m) {
                    e("RootShell v1.4", "Waiting for a command to be executed in a shell that is not executing and not reading! \n\n Command: " + aVar.g());
                    Exception exc = new Exception();
                    exc.setStackTrace(Thread.currentThread().getStackTrace());
                    exc.printStackTrace();
                } else if (!z4 || bVar.f21466m) {
                    e("RootShell v1.4", "Waiting for a command to be executed in a shell that is not reading! \n\n Command: " + aVar.g());
                    Exception exc2 = new Exception();
                    exc2.setStackTrace(Thread.currentThread().getStackTrace());
                    exc2.printStackTrace();
                } else {
                    e("RootShell v1.4", "Waiting for a command to be executed in a shell that is executing but not reading! \n\n Command: " + aVar.g());
                    Exception exc3 = new Exception();
                    exc3.setStackTrace(Thread.currentThread().getStackTrace());
                    exc3.printStackTrace();
                }
            }
        }
    }

    public static boolean b() {
        HashSet<String> hashSet = new HashSet<>();
        try {
            c("Checking for Root access");
            C0211a aVar = new C0211a(158, false, new String[]{"id"}, hashSet);
            C2348b.L().w(aVar);
            a(C2348b.L(), aVar);
            for (String str : hashSet) {
                c(str);
                if (str.toLowerCase().contains("uid=0")) {
                    c("Access Given");
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static void c(String str) {
        f((String) null, str, c.DEBUG, (Exception) null);
    }

    public static void d(String str, c cVar, Exception exc) {
        f((String) null, str, cVar, exc);
    }

    public static void e(String str, String str2) {
        f(str, str2, c.DEBUG, (Exception) null);
    }

    public static void f(String str, String str2, c cVar, Exception exc) {
        if (str2 != null && !str2.equals("") && f20796a) {
            if (str == null) {
                str = "RootShell v1.4";
            }
            int i5 = b.f20799a[cVar.ordinal()];
            if (i5 == 1) {
                Log.v(str, str2);
            } else if (i5 == 2) {
                Log.e(str, str2, exc);
            } else if (i5 == 3) {
                Log.d(str, str2);
            } else if (i5 == 4) {
                Log.w(str, str2);
            }
        }
    }
}
