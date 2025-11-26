package com.uptodown.activities;

import W2.J;
import W2.q;
import W2.u;
import X2.C2250q;
import a3.C2265a;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import b2.C2290j;
import b3.C2308e;
import c3.C2316b;
import com.uptodown.workers.DownloadWorker;
import d3.C2345b;
import g2.C2380b;
import h3.C2454c;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import l2.C2668q;
import l2.r;
import t3.s;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.M;
import z2.C2940B;
import z2.E;
import z2.O;
import z3.D;
import z3.F;
import z3.w;

/* renamed from: com.uptodown.activities.x  reason: case insensitive filesystem */
public final class C1620x extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final w f15173a;

    /* renamed from: b  reason: collision with root package name */
    private final D f15174b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final w f15175c = F.a(new ArrayList());
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final w f15176d = F.a(new ArrayList());

    /* renamed from: e  reason: collision with root package name */
    private String f15177e;

    /* renamed from: f  reason: collision with root package name */
    private w f15178f = F.a(1);
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f15179g;

    /* renamed from: com.uptodown.activities.x$a */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList f15180a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList f15181b;

        public a(ArrayList arrayList, ArrayList arrayList2) {
            t.e(arrayList, "downloads");
            t.e(arrayList2, "downloadsQueue");
            this.f15180a = arrayList;
            this.f15181b = arrayList2;
        }

        public final ArrayList a() {
            return this.f15180a;
        }

        public final ArrayList b() {
            return this.f15181b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return t.a(this.f15180a, aVar.f15180a) && t.a(this.f15181b, aVar.f15181b);
        }

        public int hashCode() {
            return (this.f15180a.hashCode() * 31) + this.f15181b.hashCode();
        }

        public String toString() {
            return "MyDownloadsData(downloads=" + this.f15180a + ", downloadsQueue=" + this.f15181b + ')';
        }
    }

    /* renamed from: com.uptodown.activities.x$b */
    public enum b {
        NAME,
        DATE,
        SIZE;

        static {
            b[] a5;
            f15186e = C2345b.a(a5);
        }
    }

    /* renamed from: com.uptodown.activities.x$c */
    public /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f15187a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.uptodown.activities.x$b[] r0 = com.uptodown.activities.C1620x.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.uptodown.activities.x$b r1 = com.uptodown.activities.C1620x.b.DATE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.uptodown.activities.x$b r1 = com.uptodown.activities.C1620x.b.SIZE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.uptodown.activities.x$b r1 = com.uptodown.activities.C1620x.b.NAME     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f15187a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.C1620x.c.<clinit>():void");
        }
    }

    /* renamed from: com.uptodown.activities.x$d */
    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f15188a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2668q f15189b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f15190c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(C2668q qVar, Context context, C2308e eVar) {
            super(2, eVar);
            this.f15189b = qVar;
            this.f15190c = context;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f15189b, this.f15190c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f15188a == 0) {
                u.b(obj);
                DownloadWorker.a aVar = DownloadWorker.f21359d;
                if (aVar.k(this.f15189b.h(), this.f15189b.E())) {
                    aVar.d(this.f15189b.h());
                }
                C2940B a5 = C2940B.f26458v.a(this.f15190c);
                a5.a();
                boolean z4 = true;
                if (a5.A(this.f15189b) != 1) {
                    z4 = false;
                }
                a5.m();
                this.f15189b.g();
                return kotlin.coroutines.jvm.internal.b.a(z4);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: com.uptodown.activities.x$e */
    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f15191a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f15192b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C1620x f15193c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f15194d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ b f15195e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(boolean z4, C1620x xVar, Context context, b bVar, C2308e eVar) {
            super(2, eVar);
            this.f15192b = z4;
            this.f15193c = xVar;
            this.f15194d = context;
            this.f15195e = bVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f15192b, this.f15193c, this.f15194d, this.f15195e, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            File file;
            C2316b.f();
            if (this.f15191a == 0) {
                u.b(obj);
                if (this.f15192b) {
                    this.f15193c.f15173a.setValue(O.a.f26507a);
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                C2940B a5 = C2940B.f26458v.a(this.f15194d);
                a5.a();
                Iterator it = a5.p0().iterator();
                t.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    t.d(next, "next(...)");
                    C2668q qVar = (C2668q) next;
                    if (qVar.P()) {
                        if (qVar.M()) {
                            kotlin.coroutines.jvm.internal.b.a(arrayList.add(qVar));
                        } else if (qVar.o().size() == 0) {
                            kotlin.coroutines.jvm.internal.b.b(a5.A(qVar));
                        } else if (qVar.o().size() != 1) {
                            if (((r) qVar.o().get(0)).a() != null) {
                                String a6 = ((r) qVar.o().get(0)).a();
                                t.b(a6);
                                file = new File(a6).getParentFile();
                            } else {
                                file = null;
                            }
                            if (file == null || file.exists()) {
                                Iterator it2 = qVar.o().iterator();
                                t.d(it2, "iterator(...)");
                                while (it2.hasNext()) {
                                    Object next2 = it2.next();
                                    t.d(next2, "next(...)");
                                    r rVar = (r) next2;
                                    if (rVar.a() == null) {
                                        a5.A(qVar);
                                    } else {
                                        String a7 = rVar.a();
                                        t.b(a7);
                                        if (!new File(a7).exists()) {
                                            a5.A(qVar);
                                        }
                                    }
                                    Iterator it3 = qVar.o().iterator();
                                    t.d(it3, "iterator(...)");
                                    while (it3.hasNext()) {
                                        Object next3 = it3.next();
                                        t.d(next3, "next(...)");
                                        r rVar2 = (r) next3;
                                        if (rVar2.a() != null) {
                                            String a8 = rVar2.a();
                                            t.b(a8);
                                            File file2 = new File(a8);
                                            if (file2.exists()) {
                                                file2.delete();
                                            }
                                        }
                                    }
                                    J j5 = J.f19942a;
                                }
                                kotlin.coroutines.jvm.internal.b.a(arrayList2.add(qVar));
                            } else {
                                kotlin.coroutines.jvm.internal.b.b(a5.A(qVar));
                            }
                        } else if (((r) qVar.o().get(0)).a() == null) {
                            kotlin.coroutines.jvm.internal.b.b(a5.A(qVar));
                        } else {
                            String a9 = ((r) qVar.o().get(0)).a();
                            t.b(a9);
                            File file3 = new File(a9);
                            if (!file3.exists()) {
                                kotlin.coroutines.jvm.internal.b.b(a5.A(qVar));
                            } else {
                                qVar.s(this.f15194d, file3);
                                kotlin.coroutines.jvm.internal.b.a(arrayList2.add(qVar));
                            }
                        }
                    }
                }
                a5.m();
                arrayList2.addAll(this.f15193c.n(this.f15194d));
                if (!this.f15193c.f15179g) {
                    new C2380b(this.f15194d, ViewModelKt.getViewModelScope(this.f15193c));
                    this.f15193c.f15179g = true;
                }
                this.f15193c.f15176d.setValue(arrayList);
                this.f15193c.f15175c.setValue(arrayList2);
                if (this.f15193c.p() != null) {
                    String p5 = this.f15193c.p();
                    t.b(p5);
                    if (p5.length() > 0) {
                        C1620x xVar = this.f15193c;
                        xVar.l(xVar.p(), this.f15195e);
                        return J.f19942a;
                    }
                }
                this.f15193c.s(arrayList2, this.f15195e);
                this.f15193c.f15173a.setValue(new O.c(new a(arrayList2, arrayList)));
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: com.uptodown.activities.x$f */
    static final class f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f15196a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1620x f15197b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f15198c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ b f15199d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(C1620x xVar, String str, b bVar, C2308e eVar) {
            super(2, eVar);
            this.f15197b = xVar;
            this.f15198c = str;
            this.f15199d = bVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new f(this.f15197b, this.f15198c, this.f15199d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f15196a == 0) {
                u.b(obj);
                C1620x xVar = this.f15197b;
                ArrayList g5 = xVar.q((ArrayList) xVar.f15175c.getValue(), this.f15198c);
                this.f15197b.s(g5, this.f15199d);
                C1620x xVar2 = this.f15197b;
                this.f15197b.f15173a.setValue(new O.c(new a(g5, xVar2.q((ArrayList) xVar2.f15176d.getValue(), this.f15198c))));
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((f) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: com.uptodown.activities.x$g */
    public static final class g implements Comparator {
        public final int compare(Object obj, Object obj2) {
            C2668q qVar = (C2668q) obj2;
            if (!qVar.o().isEmpty() && ((r) qVar.o().get(0)).a() != null) {
                String a5 = ((r) qVar.o().get(0)).a();
                t.b(a5);
                File file = new File(a5);
                if (file.exists()) {
                    file.lastModified();
                }
            }
            C2668q qVar2 = (C2668q) obj;
            if (!qVar2.o().isEmpty() && ((r) qVar2.o().get(0)).a() != null) {
                String a6 = ((r) qVar2.o().get(0)).a();
                t.b(a6);
                File file2 = new File(a6);
                if (file2.exists()) {
                    file2.lastModified();
                }
            }
            return C2265a.a(0L, 0L);
        }
    }

    /* renamed from: com.uptodown.activities.x$h */
    public static final class h implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return C2265a.a(((C2668q) obj).i(), ((C2668q) obj2).i());
        }
    }

    /* renamed from: com.uptodown.activities.x$i */
    public static final class i implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return C2265a.a(Long.valueOf(((C2668q) obj).z()), Long.valueOf(((C2668q) obj2).z()));
        }
    }

    public C1620x() {
        w a5 = F.a(O.a.f26507a);
        this.f15173a = a5;
        this.f15174b = a5;
    }

    /* access modifiers changed from: private */
    public final void l(String str, b bVar) {
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new f(this, str, bVar, (C2308e) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final ArrayList n(Context context) {
        ArrayList arrayList = new ArrayList();
        Iterator it = new E().a().iterator();
        t.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            t.d(next, "next(...)");
            File file = (File) next;
            C2668q qVar = new C2668q();
            qVar.W(C2454c.b(file));
            qVar.e0(C2454c.b(file));
            qVar.d0(0);
            qVar.f0(-1);
            C2290j jVar = new C2290j();
            String absolutePath = file.getAbsolutePath();
            t.d(absolutePath, "getAbsolutePath(...)");
            qVar.b0(jVar.h(context, absolutePath));
            r rVar = new r();
            rVar.k(file.getAbsolutePath());
            rVar.q(file.length());
            rVar.p(file.length());
            qVar.o().add(rVar);
            qVar.s(context, file);
            arrayList.add(qVar);
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final ArrayList q(ArrayList arrayList, String str) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            C2668q qVar = (C2668q) obj;
            String i6 = qVar.i();
            String str2 = "";
            boolean z4 = true;
            if (i6 == null || i6.length() == 0) {
                String w4 = qVar.w();
                if (!(w4 == null || w4.length() == 0)) {
                    String w5 = qVar.w();
                    t.b(w5);
                    if (str != null) {
                        str2 = str;
                    }
                    z4 = s.T(w5, str2, true);
                }
            } else {
                String i7 = qVar.i();
                t.b(i7);
                if (str != null) {
                    str2 = str;
                }
                z4 = s.T(i7, str2, true);
            }
            if (z4) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    /* access modifiers changed from: private */
    public final void s(ArrayList arrayList, b bVar) {
        int i5 = c.f15187a[bVar.ordinal()];
        if (i5 == 1) {
            t(arrayList);
        } else if (i5 == 2) {
            v(arrayList);
        } else if (i5 == 3) {
            u(arrayList);
        } else {
            throw new q();
        }
    }

    private final void t(ArrayList arrayList) {
        if (arrayList.size() > 1) {
            C2250q.t(arrayList, new g());
        }
    }

    private final void u(ArrayList arrayList) {
        if (arrayList.size() > 1) {
            C2250q.t(arrayList, new h());
        }
    }

    private final void v(ArrayList arrayList) {
        if (arrayList.size() > 1) {
            C2250q.t(arrayList, new i());
        }
    }

    public final Object j(Context context, C2668q qVar, C2308e eVar) {
        return C2872g.g(C2865c0.b(), new d(qVar, context, (C2308e) null), eVar);
    }

    public final void k(Context context, b bVar, boolean z4) {
        t.e(context, "context");
        t.e(bVar, "sortType");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new e(z4, this, context, bVar, (C2308e) null), 2, (Object) null);
    }

    public final D m() {
        return this.f15174b;
    }

    public final w o() {
        return this.f15178f;
    }

    public final String p() {
        return this.f15177e;
    }

    public final void r(String str) {
        this.f15177e = str;
    }
}
