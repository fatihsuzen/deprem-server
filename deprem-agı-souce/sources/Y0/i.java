package y0;

import android.os.Looper;
import java.util.concurrent.ExecutorService;
import k3.C2616a;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.C2639q;
import kotlin.jvm.internal.t;
import t3.s;
import u0.g;

public final class i {

    /* renamed from: e  reason: collision with root package name */
    public static final a f17082e = new a((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static boolean f17083f;

    /* renamed from: a  reason: collision with root package name */
    public final e f17084a;

    /* renamed from: b  reason: collision with root package name */
    public final e f17085b;

    /* renamed from: c  reason: collision with root package name */
    public final e f17086c;

    /* renamed from: d  reason: collision with root package name */
    public final e f17087d;

    public static final class a {

        /* renamed from: y0.i$a$a  reason: collision with other inner class name */
        /* synthetic */ class C0166a extends C2639q implements C2616a {
            C0166a(Object obj) {
                super(0, obj, a.class, "isBackgroundThread", "isBackgroundThread()Z", 0);
            }

            /* renamed from: g */
            public final Boolean invoke() {
                return Boolean.valueOf(((a) this.receiver).p());
            }
        }

        /* synthetic */ class b extends C2639q implements C2616a {
            b(Object obj) {
                super(0, obj, a.class, "isBlockingThread", "isBlockingThread()Z", 0);
            }

            /* renamed from: g */
            public final Boolean invoke() {
                return Boolean.valueOf(((a) this.receiver).q());
            }
        }

        /* synthetic */ class c extends C2639q implements C2616a {
            c(Object obj) {
                super(0, obj, a.class, "isNotMainThread", "isNotMainThread()Z", 0);
            }

            /* renamed from: g */
            public final Boolean invoke() {
                return Boolean.valueOf(((a) this.receiver).r());
            }
        }

        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        /* access modifiers changed from: private */
        public static final String h() {
            return "Must be called on a background thread, was called on " + i.f17082e.o() + '.';
        }

        /* access modifiers changed from: private */
        public static final String j() {
            return "Must be called on a blocking thread, was called on " + i.f17082e.o() + '.';
        }

        /* access modifiers changed from: private */
        public static final String l() {
            return "Must not be called on a main thread, was called on " + i.f17082e.o() + '.';
        }

        private final void m(C2616a aVar, C2616a aVar2) {
            if (!((Boolean) aVar.invoke()).booleanValue()) {
                g.f().b((String) aVar2.invoke());
                n();
            }
        }

        private final String o() {
            return Thread.currentThread().getName();
        }

        /* access modifiers changed from: private */
        public final boolean p() {
            String o5 = o();
            t.d(o5, "<get-threadName>(...)");
            return s.V(o5, "Firebase Background Thread #", false, 2, (Object) null);
        }

        /* access modifiers changed from: private */
        public final boolean q() {
            String o5 = o();
            t.d(o5, "<get-threadName>(...)");
            return s.V(o5, "Firebase Blocking Thread #", false, 2, (Object) null);
        }

        /* access modifiers changed from: private */
        public final boolean r() {
            if (!Looper.getMainLooper().isCurrentThread()) {
                return true;
            }
            return false;
        }

        public final void g() {
            m(new C0166a(this), new f());
        }

        public final void i() {
            m(new b(this), new h());
        }

        public final void k() {
            m(new c(this), new g());
        }

        public final boolean n() {
            return i.f17083f;
        }

        public final void s(boolean z4) {
            i.f17083f = z4;
        }

        private a() {
        }
    }

    public i(ExecutorService executorService, ExecutorService executorService2) {
        t.e(executorService, "backgroundExecutorService");
        t.e(executorService2, "blockingExecutorService");
        this.f17084a = new e(executorService);
        this.f17085b = new e(executorService);
        this.f17086c = new e(executorService);
        this.f17087d = new e(executorService2);
    }

    public static final void c() {
        f17082e.g();
    }

    public static final void d() {
        f17082e.i();
    }

    public static final void e() {
        f17082e.k();
    }

    public static final void f(boolean z4) {
        f17082e.s(z4);
    }
}
