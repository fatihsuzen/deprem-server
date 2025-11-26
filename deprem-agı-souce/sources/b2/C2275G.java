package b2;

import X2.C2250q;
import Y1.f;
import android.content.Context;
import android.os.Build;
import com.uptodown.core.activities.InstallerActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.C2625c;
import kotlin.jvm.internal.t;
import t3.p;
import t3.s;

/* renamed from: b2.G  reason: case insensitive filesystem */
public final class C2275G {

    /* renamed from: a  reason: collision with root package name */
    private final Context f20473a;

    /* renamed from: b  reason: collision with root package name */
    private InstallerActivity.a f20474b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList f20475c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private ArrayList f20476d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private ArrayList f20477e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private ArrayList f20478f = new ArrayList();

    public C2275G(Context context) {
        t.e(context, "context");
        this.f20473a = context;
    }

    /* access modifiers changed from: private */
    public static final int A(f fVar, f fVar2) {
        t.e(fVar, "f1");
        t.e(fVar2, "f2");
        if (fVar.e() == null) {
            return 1;
        }
        if (fVar2.e() == null) {
            return -1;
        }
        File e5 = fVar.e();
        t.b(e5);
        String name = e5.getName();
        t.d(name, "getName(...)");
        File e6 = fVar2.e();
        t.b(e6);
        String name2 = e6.getName();
        t.d(name2, "getName(...)");
        return s.x(name, name2, true);
    }

    private final void j() {
        Iterator a5 = C2625c.a(Build.SUPPORTED_ABIS);
        boolean z4 = false;
        while (a5.hasNext()) {
            String str = (String) a5.next();
            Iterator it = this.f20475c.iterator();
            t.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                t.d(next, "next(...)");
                f fVar = (f) next;
                if (fVar.f() != null) {
                    String f5 = fVar.f();
                    t.b(f5);
                    if (s.E(str, new p("_").h(f5, "-"), true)) {
                        if (!z4) {
                            fVar.g(true);
                            z4 = true;
                        }
                        fVar.h(true);
                    }
                }
            }
        }
        Iterator it2 = this.f20476d.iterator();
        t.d(it2, "iterator(...)");
        while (it2.hasNext()) {
            Object next2 = it2.next();
            t.d(next2, "next(...)");
            if (((f) next2).a()) {
                return;
            }
        }
        Iterator it3 = this.f20476d.iterator();
        t.d(it3, "iterator(...)");
        while (it3.hasNext()) {
            Object next3 = it3.next();
            t.d(next3, "next(...)");
            ((f) next3).g(true);
        }
    }

    private final void k() {
        InstallerActivity.a aVar = this.f20474b;
        if (aVar != null) {
            t.b(aVar);
            if (aVar.a() > -1) {
                ArrayList arrayList = new ArrayList();
                Iterator it = this.f20475c.iterator();
                t.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    t.d(next, "next(...)");
                    f fVar = (f) next;
                    InstallerActivity.a aVar2 = this.f20474b;
                    t.b(aVar2);
                    if (q(fVar, aVar2.a())) {
                        arrayList.add(fVar);
                    }
                }
                this.f20475c = arrayList;
                ArrayList arrayList2 = new ArrayList();
                Iterator it2 = this.f20476d.iterator();
                t.d(it2, "iterator(...)");
                while (it2.hasNext()) {
                    Object next2 = it2.next();
                    t.d(next2, "next(...)");
                    f fVar2 = (f) next2;
                    InstallerActivity.a aVar3 = this.f20474b;
                    t.b(aVar3);
                    if (q(fVar2, aVar3.a())) {
                        arrayList2.add(fVar2);
                    }
                }
                this.f20476d = arrayList2;
                ArrayList arrayList3 = new ArrayList();
                Iterator it3 = this.f20477e.iterator();
                t.d(it3, "iterator(...)");
                while (it3.hasNext()) {
                    Object next3 = it3.next();
                    t.d(next3, "next(...)");
                    f fVar3 = (f) next3;
                    InstallerActivity.a aVar4 = this.f20474b;
                    t.b(aVar4);
                    if (q(fVar3, aVar4.a())) {
                        arrayList3.add(fVar3);
                    }
                }
                this.f20477e = arrayList3;
                ArrayList arrayList4 = new ArrayList();
                Iterator it4 = this.f20478f.iterator();
                t.d(it4, "iterator(...)");
                while (it4.hasNext()) {
                    Object next4 = it4.next();
                    t.d(next4, "next(...)");
                    f fVar4 = (f) next4;
                    InstallerActivity.a aVar5 = this.f20474b;
                    t.b(aVar5);
                    if (q(fVar4, aVar5.a())) {
                        arrayList4.add(fVar4);
                    }
                }
                this.f20478f = arrayList4;
            }
        }
    }

    private final boolean q(f fVar, int i5) {
        if (i5 == -1 || fVar.c() == -1 || fVar.c() == i5) {
            return true;
        }
        return false;
    }

    private final void r() {
        C2250q.t(this.f20475c, new x());
        C2250q.t(this.f20475c, new y());
        C2250q.t(this.f20476d, new z());
        C2250q.t(this.f20476d, new C2270B(new C2269A()));
        C2250q.t(this.f20477e, new C2271C());
        C2250q.t(this.f20477e, new C2273E(new C2272D()));
        C2250q.t(this.f20478f, new C2274F());
    }

    /* access modifiers changed from: private */
    public static final int s(f fVar, f fVar2) {
        t.e(fVar, "o1");
        t.e(fVar2, "o2");
        if (fVar.e() == null) {
            return 1;
        }
        if (fVar2.e() == null) {
            return -1;
        }
        File e5 = fVar.e();
        t.b(e5);
        String name = e5.getName();
        t.d(name, "getName(...)");
        File e6 = fVar2.e();
        t.b(e6);
        String name2 = e6.getName();
        t.d(name2, "getName(...)");
        return s.x(name, name2, true);
    }

    /* access modifiers changed from: private */
    public static final int t(f fVar, f fVar2) {
        t.e(fVar, "o1");
        t.e(fVar2, "o2");
        if (fVar.e() == null) {
            return 1;
        }
        if (fVar2.e() == null) {
            return -1;
        }
        return Boolean.compare(!fVar.a(), !fVar2.a());
    }

    /* access modifiers changed from: private */
    public static final int u(f fVar, f fVar2) {
        t.e(fVar, "d1");
        t.e(fVar2, "d2");
        if (fVar.e() == null) {
            return 1;
        }
        if (fVar2.e() == null) {
            return -1;
        }
        File e5 = fVar.e();
        t.b(e5);
        String name = e5.getName();
        t.d(name, "getName(...)");
        File e6 = fVar2.e();
        t.b(e6);
        String name2 = e6.getName();
        t.d(name2, "getName(...)");
        return s.x(name, name2, true);
    }

    /* access modifiers changed from: private */
    public static final int v(f fVar, f fVar2) {
        t.e(fVar, "o1");
        t.e(fVar2, "o2");
        return Boolean.compare(!fVar.a(), !fVar2.a());
    }

    /* access modifiers changed from: private */
    public static final int w(k3.p pVar, Object obj, Object obj2) {
        return ((Number) pVar.invoke(obj, obj2)).intValue();
    }

    /* access modifiers changed from: private */
    public static final int x(f fVar, f fVar2) {
        t.e(fVar, "d1");
        t.e(fVar2, "d2");
        if (fVar.e() == null) {
            return 1;
        }
        if (fVar2.e() == null) {
            return -1;
        }
        File e5 = fVar.e();
        t.b(e5);
        String name = e5.getName();
        t.d(name, "getName(...)");
        File e6 = fVar2.e();
        t.b(e6);
        String name2 = e6.getName();
        t.d(name2, "getName(...)");
        return s.x(name, name2, true);
    }

    /* access modifiers changed from: private */
    public static final int y(f fVar, f fVar2) {
        t.e(fVar, "o1");
        t.e(fVar2, "o2");
        return Boolean.compare(!fVar.a(), !fVar2.a());
    }

    /* access modifiers changed from: private */
    public static final int z(k3.p pVar, Object obj, Object obj2) {
        return ((Number) pVar.invoke(obj, obj2)).intValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x018d, code lost:
        if (r4.equals("arm64_v8a") == false) goto L_0x0221;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0197, code lost:
        if (r4.equals("armeabi_v7a") == false) goto L_0x0221;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x01a1, code lost:
        if (r4.equals("xhdpi") == false) goto L_0x0221;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x01ab, code lost:
        if (r4.equals("tvdpi") == false) goto L_0x0221;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x01b5, code lost:
        if (r4.equals("mips") == false) goto L_0x0221;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x01bf, code lost:
        if (r4.equals("mdpi") == false) goto L_0x0221;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x01c8, code lost:
        if (r4.equals("ldpi") == false) goto L_0x0221;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x01d1, code lost:
        if (r4.equals("hdpi") == false) goto L_0x0221;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x01da, code lost:
        if (r4.equals("x86") != false) goto L_0x0201;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x01e3, code lost:
        if (r4.equals("armeabi") == false) goto L_0x0221;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x01ec, code lost:
        if (r4.equals("xxhdpi") == false) goto L_0x0221;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01f5, code lost:
        if (r4.equals("x86_64") == false) goto L_0x0221;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01fe, code lost:
        if (r4.equals("mips64") == false) goto L_0x0221;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0201, code lost:
        r6 = new Y1.f();
        r6.k(r3);
        r6.l(r4);
        r6.j(r4);
        r6.i(r5);
        r11.f20475c.add(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x021f, code lost:
        if (r4.equals("xxxhdpi") == false) goto L_0x0221;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0221, code lost:
        r6 = new Y1.f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        r8 = new java.util.Locale.Builder().setLanguage(r4).build();
        r6.j(r8.getDisplayLanguage(r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x023b, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x023c, code lost:
        r8.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0259, code lost:
        r6 = new Y1.f();
        r6.k(r3);
        r6.l(r4);
        r6.j(r4);
        r6.g(t3.s.E(r4, r0, true));
        r6.h(true);
        r6.i(r5);
        r11.f20476d.add(r6);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void B(java.util.ArrayList r12) {
        /*
            r11 = this;
            java.lang.String r0 = "files"
            kotlin.jvm.internal.t.e(r12, r0)
            android.content.Context r0 = r11.f20473a
            int r1 = S1.i.dpi_device
            java.lang.String r0 = r0.getString(r1)
            java.lang.String r1 = "getString(...)"
            kotlin.jvm.internal.t.d(r0, r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r11.f20475c = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r11.f20476d = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r11.f20477e = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r11.f20478f = r1
            java.util.Locale r1 = java.util.Locale.getDefault()
            java.lang.String r1 = r1.getLanguage()
            android.content.Context r2 = r11.f20473a
            android.content.pm.PackageManager r2 = r2.getPackageManager()
            java.util.Iterator r12 = r12.iterator()
            java.lang.String r3 = "iterator(...)"
            kotlin.jvm.internal.t.d(r12, r3)
        L_0x0045:
            boolean r3 = r12.hasNext()
            if (r3 == 0) goto L_0x02a1
            java.lang.Object r3 = r12.next()
            java.lang.String r4 = "next(...)"
            kotlin.jvm.internal.t.d(r3, r4)
            java.io.File r3 = (java.io.File) r3
            b2.b r4 = new b2.b
            r4.<init>()
            java.lang.String r5 = r3.getAbsolutePath()
            java.lang.String r4 = r4.f(r5)
            b2.a r5 = new b2.a
            r5.<init>()
            int r5 = r5.e(r4)
            kotlin.jvm.internal.t.b(r2)
            java.lang.String r6 = r3.getAbsolutePath()
            java.lang.String r7 = "getAbsolutePath(...)"
            kotlin.jvm.internal.t.d(r6, r7)
            r7 = 128(0x80, float:1.794E-43)
            android.content.pm.PackageInfo r6 = b2.C2301u.c(r2, r6, r7)
            r7 = 1
            if (r6 == 0) goto L_0x010f
            com.uptodown.core.activities.InstallerActivity$a r8 = r11.f20474b
            if (r8 != 0) goto L_0x010f
            android.content.pm.ApplicationInfo r8 = r6.applicationInfo     // Catch:{ Exception -> 0x00c8 }
            if (r8 == 0) goto L_0x0045
            b2.i r8 = new b2.i     // Catch:{ Exception -> 0x00c8 }
            r8.<init>()     // Catch:{ Exception -> 0x00c8 }
            boolean r8 = r8.o(r6)     // Catch:{ Exception -> 0x00c8 }
            if (r8 == 0) goto L_0x00ca
            com.uptodown.core.activities.InstallerActivity$a r4 = new com.uptodown.core.activities.InstallerActivity$a     // Catch:{ Exception -> 0x00c8 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x00c8 }
            r11.f20474b = r4     // Catch:{ Exception -> 0x00c8 }
            kotlin.jvm.internal.t.b(r4)     // Catch:{ Exception -> 0x00c8 }
            r4.f(r5)     // Catch:{ Exception -> 0x00c8 }
            com.uptodown.core.activities.InstallerActivity$a r3 = r11.f20474b     // Catch:{ Exception -> 0x00c8 }
            kotlin.jvm.internal.t.b(r3)     // Catch:{ Exception -> 0x00c8 }
            java.lang.String r4 = r6.packageName     // Catch:{ Exception -> 0x00c8 }
            r3.g(r4)     // Catch:{ Exception -> 0x00c8 }
            com.uptodown.core.activities.InstallerActivity$a r3 = r11.f20474b     // Catch:{ Exception -> 0x00c8 }
            kotlin.jvm.internal.t.b(r3)     // Catch:{ Exception -> 0x00c8 }
            java.lang.String r4 = r6.versionName     // Catch:{ Exception -> 0x00c8 }
            r3.i(r4)     // Catch:{ Exception -> 0x00c8 }
            com.uptodown.core.activities.InstallerActivity$a r3 = r11.f20474b     // Catch:{ Exception -> 0x00c8 }
            kotlin.jvm.internal.t.b(r3)     // Catch:{ Exception -> 0x00c8 }
            b2.j r4 = new b2.j     // Catch:{ Exception -> 0x00c8 }
            r4.<init>()     // Catch:{ Exception -> 0x00c8 }
            long r4 = r4.m(r6)     // Catch:{ Exception -> 0x00c8 }
            r3.h(r4)     // Catch:{ Exception -> 0x00c8 }
            goto L_0x0045
        L_0x00c8:
            r3 = move-exception
            goto L_0x010a
        L_0x00ca:
            java.lang.String r6 = "name=\"com.android.vending.splits\""
            r8 = 2
            r9 = 0
            r10 = 0
            boolean r4 = t3.s.V(r4, r6, r10, r8, r9)     // Catch:{ Exception -> 0x00c8 }
            if (r4 == 0) goto L_0x00e4
            com.uptodown.core.activities.InstallerActivity$a r4 = new com.uptodown.core.activities.InstallerActivity$a     // Catch:{ Exception -> 0x00c8 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x00c8 }
            r11.f20474b = r4     // Catch:{ Exception -> 0x00c8 }
            kotlin.jvm.internal.t.b(r4)     // Catch:{ Exception -> 0x00c8 }
            r4.f(r5)     // Catch:{ Exception -> 0x00c8 }
            goto L_0x0045
        L_0x00e4:
            Y1.f r4 = new Y1.f     // Catch:{ Exception -> 0x00c8 }
            r4.<init>()     // Catch:{ Exception -> 0x00c8 }
            r4.k(r3)     // Catch:{ Exception -> 0x00c8 }
            java.lang.String r6 = r3.getName()     // Catch:{ Exception -> 0x00c8 }
            r4.l(r6)     // Catch:{ Exception -> 0x00c8 }
            java.lang.String r3 = r3.getName()     // Catch:{ Exception -> 0x00c8 }
            r4.j(r3)     // Catch:{ Exception -> 0x00c8 }
            r4.g(r7)     // Catch:{ Exception -> 0x00c8 }
            r4.h(r7)     // Catch:{ Exception -> 0x00c8 }
            r4.i(r5)     // Catch:{ Exception -> 0x00c8 }
            java.util.ArrayList r3 = r11.f20478f     // Catch:{ Exception -> 0x00c8 }
            r3.add(r4)     // Catch:{ Exception -> 0x00c8 }
            goto L_0x0045
        L_0x010a:
            r3.printStackTrace()
            goto L_0x0045
        L_0x010f:
            b2.a r6 = new b2.a
            r6.<init>()
            boolean r6 = r6.c(r4)
            if (r6 == 0) goto L_0x0139
            Y1.f r4 = new Y1.f
            r4.<init>()
            r4.k(r3)
            java.lang.String r3 = r3.getName()
            r4.j(r3)
            r4.g(r7)
            r4.h(r7)
            r4.i(r5)
            java.util.ArrayList r3 = r11.f20478f
            r3.add(r4)
            goto L_0x0045
        L_0x0139:
            b2.a r6 = new b2.a
            r6.<init>()
            boolean r6 = r6.b(r4)
            if (r6 == 0) goto L_0x016a
            Y1.f r4 = new Y1.f
            r4.<init>()
            r4.k(r3)
            java.lang.String r6 = r3.getName()
            r4.l(r6)
            java.lang.String r3 = r3.getName()
            r4.j(r3)
            r4.g(r7)
            r4.h(r7)
            r4.i(r5)
            java.util.ArrayList r3 = r11.f20478f
            r3.add(r4)
            goto L_0x0045
        L_0x016a:
            b2.a r6 = new b2.a
            r6.<init>()
            boolean r6 = r6.d(r4)
            if (r6 == 0) goto L_0x027b
            b2.a r6 = new b2.a
            r6.<init>()
            java.lang.String r4 = r6.a(r4)
            int r6 = r4.hashCode()
            switch(r6) {
                case -1619189395: goto L_0x0219;
                case -1073971299: goto L_0x01f8;
                case -806050265: goto L_0x01ef;
                case -745448715: goto L_0x01e6;
                case -738963905: goto L_0x01dd;
                case 117110: goto L_0x01d4;
                case 3197941: goto L_0x01cb;
                case 3317105: goto L_0x01c2;
                case 3346896: goto L_0x01b9;
                case 3351711: goto L_0x01af;
                case 110743451: goto L_0x01a5;
                case 114020461: goto L_0x019b;
                case 146933760: goto L_0x0191;
                case 1433054842: goto L_0x0187;
                default: goto L_0x0185;
            }
        L_0x0185:
            goto L_0x0221
        L_0x0187:
            java.lang.String r6 = "arm64_v8a"
            boolean r6 = r4.equals(r6)
            if (r6 != 0) goto L_0x0201
            goto L_0x0221
        L_0x0191:
            java.lang.String r6 = "armeabi_v7a"
            boolean r6 = r4.equals(r6)
            if (r6 != 0) goto L_0x0201
            goto L_0x0221
        L_0x019b:
            java.lang.String r6 = "xhdpi"
            boolean r6 = r4.equals(r6)
            if (r6 != 0) goto L_0x0259
            goto L_0x0221
        L_0x01a5:
            java.lang.String r6 = "tvdpi"
            boolean r6 = r4.equals(r6)
            if (r6 != 0) goto L_0x0259
            goto L_0x0221
        L_0x01af:
            java.lang.String r6 = "mips"
            boolean r6 = r4.equals(r6)
            if (r6 != 0) goto L_0x0201
            goto L_0x0221
        L_0x01b9:
            java.lang.String r6 = "mdpi"
            boolean r6 = r4.equals(r6)
            if (r6 != 0) goto L_0x0259
            goto L_0x0221
        L_0x01c2:
            java.lang.String r6 = "ldpi"
            boolean r6 = r4.equals(r6)
            if (r6 != 0) goto L_0x0259
            goto L_0x0221
        L_0x01cb:
            java.lang.String r6 = "hdpi"
            boolean r6 = r4.equals(r6)
            if (r6 != 0) goto L_0x0259
            goto L_0x0221
        L_0x01d4:
            java.lang.String r6 = "x86"
            boolean r6 = r4.equals(r6)
            if (r6 == 0) goto L_0x0221
            goto L_0x0201
        L_0x01dd:
            java.lang.String r6 = "armeabi"
            boolean r6 = r4.equals(r6)
            if (r6 != 0) goto L_0x0201
            goto L_0x0221
        L_0x01e6:
            java.lang.String r6 = "xxhdpi"
            boolean r6 = r4.equals(r6)
            if (r6 != 0) goto L_0x0259
            goto L_0x0221
        L_0x01ef:
            java.lang.String r6 = "x86_64"
            boolean r6 = r4.equals(r6)
            if (r6 != 0) goto L_0x0201
            goto L_0x0221
        L_0x01f8:
            java.lang.String r6 = "mips64"
            boolean r6 = r4.equals(r6)
            if (r6 != 0) goto L_0x0201
            goto L_0x0221
        L_0x0201:
            Y1.f r6 = new Y1.f
            r6.<init>()
            r6.k(r3)
            r6.l(r4)
            r6.j(r4)
            r6.i(r5)
            java.util.ArrayList r3 = r11.f20475c
            r3.add(r6)
            goto L_0x0045
        L_0x0219:
            java.lang.String r6 = "xxxhdpi"
            boolean r6 = r4.equals(r6)
            if (r6 != 0) goto L_0x0259
        L_0x0221:
            Y1.f r6 = new Y1.f
            r6.<init>()
            java.util.Locale$Builder r8 = new java.util.Locale$Builder     // Catch:{ Exception -> 0x023b }
            r8.<init>()     // Catch:{ Exception -> 0x023b }
            java.util.Locale$Builder r8 = r8.setLanguage(r4)     // Catch:{ Exception -> 0x023b }
            java.util.Locale r8 = r8.build()     // Catch:{ Exception -> 0x023b }
            java.lang.String r8 = r8.getDisplayLanguage(r8)     // Catch:{ Exception -> 0x023b }
            r6.j(r8)     // Catch:{ Exception -> 0x023b }
            goto L_0x023f
        L_0x023b:
            r8 = move-exception
            r8.printStackTrace()
        L_0x023f:
            r6.k(r3)
            r6.l(r4)
            boolean r3 = t3.s.E(r4, r1, r7)
            r6.g(r3)
            r6.h(r7)
            r6.i(r5)
            java.util.ArrayList r3 = r11.f20477e
            r3.add(r6)
            goto L_0x0045
        L_0x0259:
            Y1.f r6 = new Y1.f
            r6.<init>()
            r6.k(r3)
            r6.l(r4)
            r6.j(r4)
            boolean r3 = t3.s.E(r4, r0, r7)
            r6.g(r3)
            r6.h(r7)
            r6.i(r5)
            java.util.ArrayList r3 = r11.f20476d
            r3.add(r6)
            goto L_0x0045
        L_0x027b:
            Y1.f r4 = new Y1.f
            r4.<init>()
            r4.k(r3)
            java.lang.String r6 = r3.getName()
            r4.l(r6)
            java.lang.String r3 = r3.getName()
            r4.j(r3)
            r4.g(r7)
            r4.h(r7)
            r4.i(r5)
            java.util.ArrayList r3 = r11.f20478f
            r3.add(r4)
            goto L_0x0045
        L_0x02a1:
            r11.k()
            r11.j()
            r11.r()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.C2275G.B(java.util.ArrayList):void");
    }

    public final ArrayList C() {
        ArrayList arrayList = new ArrayList();
        InstallerActivity.a aVar = this.f20474b;
        if (aVar != null) {
            t.b(aVar);
            arrayList.add(aVar.b());
        }
        Iterator it = this.f20475c.iterator();
        t.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            t.d(next, "next(...)");
            f fVar = (f) next;
            if (fVar.a()) {
                File e5 = fVar.e();
                t.b(e5);
                arrayList.add(e5);
            }
        }
        Iterator it2 = this.f20476d.iterator();
        t.d(it2, "iterator(...)");
        while (it2.hasNext()) {
            Object next2 = it2.next();
            t.d(next2, "next(...)");
            f fVar2 = (f) next2;
            if (fVar2.a()) {
                File e6 = fVar2.e();
                t.b(e6);
                arrayList.add(e6);
            }
        }
        Iterator it3 = this.f20477e.iterator();
        t.d(it3, "iterator(...)");
        while (it3.hasNext()) {
            Object next3 = it3.next();
            t.d(next3, "next(...)");
            f fVar3 = (f) next3;
            if (fVar3.a()) {
                File e7 = fVar3.e();
                t.b(e7);
                arrayList.add(e7);
            }
        }
        Iterator it4 = this.f20478f.iterator();
        t.d(it4, "iterator(...)");
        while (it4.hasNext()) {
            Object next4 = it4.next();
            t.d(next4, "next(...)");
            f fVar4 = (f) next4;
            if (fVar4.a()) {
                File e8 = fVar4.e();
                t.b(e8);
                arrayList.add(e8);
            }
        }
        return arrayList;
    }

    public final ArrayList l() {
        return this.f20475c;
    }

    public final InstallerActivity.a m() {
        return this.f20474b;
    }

    public final ArrayList n() {
        return this.f20476d;
    }

    public final ArrayList o() {
        return this.f20478f;
    }

    public final ArrayList p() {
        return this.f20477e;
    }
}
