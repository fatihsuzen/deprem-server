package x0;

import A0.F;
import F0.j;
import G0.d;
import G0.e;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: x0.z  reason: case insensitive filesystem */
public class C1929z {

    /* renamed from: g  reason: collision with root package name */
    private static final Map f16957g;

    /* renamed from: h  reason: collision with root package name */
    static final String f16958h = String.format(Locale.US, "Crashlytics Android SDK/%s", new Object[]{"20.0.3"});

    /* renamed from: a  reason: collision with root package name */
    private final Context f16959a;

    /* renamed from: b  reason: collision with root package name */
    private final I f16960b;

    /* renamed from: c  reason: collision with root package name */
    private final C1906b f16961c;

    /* renamed from: d  reason: collision with root package name */
    private final d f16962d;

    /* renamed from: e  reason: collision with root package name */
    private final j f16963e;

    /* renamed from: f  reason: collision with root package name */
    private final u0.j f16964f = u0.j.f16663a;

    static {
        HashMap hashMap = new HashMap();
        f16957g = hashMap;
        hashMap.put("armeabi", 5);
        hashMap.put("armeabi-v7a", 6);
        hashMap.put("arm64-v8a", 9);
        hashMap.put("x86", 0);
        hashMap.put("x86_64", 1);
    }

    public C1929z(Context context, I i5, C1906b bVar, d dVar, j jVar) {
        this.f16959a = context;
        this.f16960b = i5;
        this.f16961c = bVar;
        this.f16962d = dVar;
        this.f16963e = jVar;
    }

    private F.e.d.a.c A(F.a aVar) {
        return this.f16964f.a(aVar.e(), aVar.d(), aVar.c());
    }

    private F.a a(F.a aVar) {
        List list;
        if (!this.f16963e.b().f2422b.f2431c || this.f16961c.f16843c.size() <= 0) {
            list = null;
        } else {
            ArrayList arrayList = new ArrayList();
            for (C1911g gVar : this.f16961c.f16843c) {
                arrayList.add(F.a.C0021a.a().d(gVar.c()).b(gVar.a()).c(gVar.b()).a());
            }
            list = DesugarCollections.unmodifiableList(arrayList);
        }
        return F.a.a().c(aVar.c()).e(aVar.e()).g(aVar.g()).i(aVar.i()).d(aVar.d()).f(aVar.f()).h(aVar.h()).j(aVar.j()).b(list).a();
    }

    private F.b b() {
        return F.b().l("20.0.3").h(this.f16961c.f16841a).i(this.f16960b.a().c()).g(this.f16960b.a().e()).f(this.f16960b.a().d()).d(this.f16961c.f16846f).e(this.f16961c.f16847g).k(4);
    }

    private static long f(long j5) {
        if (j5 > 0) {
            return j5;
        }
        return 0;
    }

    private static int g() {
        Integer num;
        String str = Build.CPU_ABI;
        if (!TextUtils.isEmpty(str) && (num = (Integer) f16957g.get(str.toLowerCase(Locale.US))) != null) {
            return num.intValue();
        }
        return 7;
    }

    private F.e.d.a.b.C0025a h() {
        return F.e.d.a.b.C0025a.a().b(0).d(0).c(this.f16961c.f16845e).e(this.f16961c.f16842b).a();
    }

    private List i() {
        return Collections.singletonList(h());
    }

    private F.e.d.a j(int i5, F.a aVar) {
        boolean z4;
        if (aVar.c() != 100) {
            z4 = true;
        } else {
            z4 = false;
        }
        return F.e.d.a.a().c(Boolean.valueOf(z4)).d(A(aVar)).h(i5).f(o(aVar)).a();
    }

    private F.e.d.a k(int i5, e eVar, Thread thread, int i6, int i7, boolean z4) {
        Boolean bool;
        boolean z5;
        F.e.d.a.c e5 = this.f16964f.e(this.f16959a);
        if (e5.b() > 0) {
            if (e5.b() != 100) {
                z5 = true;
            } else {
                z5 = false;
            }
            bool = Boolean.valueOf(z5);
        } else {
            bool = null;
        }
        return F.e.d.a.a().c(bool).d(e5).b(this.f16964f.d(this.f16959a)).h(i5).f(p(eVar, thread, i6, i7, z4)).a();
    }

    private F.e.d.c l(int i5) {
        Double d5;
        C1910f a5 = C1910f.a(this.f16959a);
        Float b5 = a5.b();
        if (b5 != null) {
            d5 = Double.valueOf(b5.doubleValue());
        } else {
            d5 = null;
        }
        int c5 = a5.c();
        boolean n5 = C1914j.n(this.f16959a);
        long f5 = f(C1914j.b(this.f16959a) - C1914j.a(this.f16959a));
        return F.e.d.c.a().b(d5).c(c5).f(n5).e(i5).g(f5).d(C1914j.c(Environment.getDataDirectory().getPath())).a();
    }

    private F.e.d.a.b.c m(e eVar, int i5, int i6) {
        return n(eVar, i5, i6, 0);
    }

    private F.e.d.a.b.c n(e eVar, int i5, int i6, int i7) {
        String str = eVar.f2476b;
        String str2 = eVar.f2475a;
        StackTraceElement[] stackTraceElementArr = eVar.f2477c;
        int i8 = 0;
        if (stackTraceElementArr == null) {
            stackTraceElementArr = new StackTraceElement[0];
        }
        e eVar2 = eVar.f2478d;
        if (i7 >= i6) {
            e eVar3 = eVar2;
            while (eVar3 != null) {
                eVar3 = eVar3.f2478d;
                i8++;
            }
        }
        F.e.d.a.b.c.C0028a d5 = F.e.d.a.b.c.a().f(str).e(str2).c(r(stackTraceElementArr, i5)).d(i8);
        if (eVar2 != null && i8 == 0) {
            d5.b(n(eVar2, i5, i6, i7 + 1));
        }
        return d5.a();
    }

    private F.e.d.a.b o(F.a aVar) {
        return F.e.d.a.b.a().b(aVar).e(w()).c(i()).a();
    }

    private F.e.d.a.b p(e eVar, Thread thread, int i5, int i6, boolean z4) {
        return F.e.d.a.b.a().f(z(eVar, thread, i5, z4)).d(m(eVar, i5, i6)).e(w()).c(i()).a();
    }

    private F.e.d.a.b.C0031e.C0033b q(StackTraceElement stackTraceElement, F.e.d.a.b.C0031e.C0033b.C0034a aVar) {
        long j5;
        long j6 = 0;
        if (stackTraceElement.isNativeMethod()) {
            j5 = Math.max((long) stackTraceElement.getLineNumber(), 0);
        } else {
            j5 = 0;
        }
        String str = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
        String fileName = stackTraceElement.getFileName();
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            j6 = (long) stackTraceElement.getLineNumber();
        }
        return aVar.e(j5).f(str).b(fileName).d(j6).a();
    }

    private List r(StackTraceElement[] stackTraceElementArr, int i5) {
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement q5 : stackTraceElementArr) {
            arrayList.add(q(q5, F.e.d.a.b.C0031e.C0033b.a().c(i5)));
        }
        return DesugarCollections.unmodifiableList(arrayList);
    }

    private F.e.a s() {
        return F.e.a.a().e(this.f16960b.f()).g(this.f16961c.f16846f).d(this.f16961c.f16847g).f(this.f16960b.a().c()).b(this.f16961c.f16848h.d()).c(this.f16961c.f16848h.e()).a();
    }

    private F.e t(String str, long j5) {
        return F.e.a().m(j5).j(str).h(f16958h).b(s()).l(v()).e(u()).i(3).a();
    }

    private F.e.c u() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int g5 = g();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        long b5 = C1914j.b(this.f16959a);
        long blockCount = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        boolean x4 = C1914j.x();
        int l5 = C1914j.l();
        String str = Build.MANUFACTURER;
        return F.e.c.a().b(g5).f(Build.MODEL).c(availableProcessors).h(b5).d(blockCount).i(x4).j(l5).e(str).g(Build.PRODUCT).a();
    }

    private F.e.C0038e v() {
        return F.e.C0038e.a().d(3).e(Build.VERSION.RELEASE).b(Build.VERSION.CODENAME).c(C1914j.y()).a();
    }

    private F.e.d.a.b.C0029d w() {
        return F.e.d.a.b.C0029d.a().d("0").c("0").b(0).a();
    }

    private F.e.d.a.b.C0031e x(Thread thread, StackTraceElement[] stackTraceElementArr) {
        return y(thread, stackTraceElementArr, 0);
    }

    private F.e.d.a.b.C0031e y(Thread thread, StackTraceElement[] stackTraceElementArr, int i5) {
        return F.e.d.a.b.C0031e.a().d(thread.getName()).c(i5).b(r(stackTraceElementArr, i5)).a();
    }

    private List z(e eVar, Thread thread, int i5, boolean z4) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(y(thread, eVar.f2477c, i5));
        if (z4) {
            for (Map.Entry next : Thread.getAllStackTraces().entrySet()) {
                Thread thread2 = (Thread) next.getKey();
                if (!thread2.equals(thread)) {
                    arrayList.add(x(thread2, this.f16962d.a((StackTraceElement[]) next.getValue())));
                }
            }
        }
        return DesugarCollections.unmodifiableList(arrayList);
    }

    public F.e.d c(F.a aVar) {
        int i5 = this.f16959a.getResources().getConfiguration().orientation;
        return F.e.d.a().g("anr").f(aVar.i()).b(j(i5, a(aVar))).c(l(i5)).a();
    }

    public F.e.d d(Throwable th, Thread thread, String str, long j5, int i5, int i6, boolean z4) {
        int i7 = this.f16959a.getResources().getConfiguration().orientation;
        e a5 = e.a(th, this.f16962d);
        int i8 = i7;
        return F.e.d.a().g(str).f(j5).b(k(i8, a5, thread, i5, i6, z4)).c(l(i8)).a();
    }

    public F e(String str, long j5) {
        return b().m(t(str, j5)).a();
    }
}
