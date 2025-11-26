package p4;

import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0258a f25678a = new C0258a((C2633k) null);

    /* renamed from: b  reason: collision with root package name */
    private static final ArrayList f25679b = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static volatile b[] f25680c = new b[0];

    /* renamed from: p4.a$a  reason: collision with other inner class name */
    public static final class C0258a extends b {
        public /* synthetic */ C0258a(C2633k kVar) {
            this();
        }

        public void a(String str, Object... objArr) {
            t.e(objArr, "args");
            for (b a5 : a.f25680c) {
                a5.a(str, Arrays.copyOf(objArr, objArr.length));
            }
        }

        public void b(Throwable th, String str, Object... objArr) {
            t.e(objArr, "args");
            for (b b5 : a.f25680c) {
                b5.b(th, str, Arrays.copyOf(objArr, objArr.length));
            }
        }

        public void c(String str, Object... objArr) {
            t.e(objArr, "args");
            for (b c5 : a.f25680c) {
                c5.c(str, Arrays.copyOf(objArr, objArr.length));
            }
        }

        public void d(Throwable th) {
            for (b d5 : a.f25680c) {
                d5.d(th);
            }
        }

        public void e(Throwable th, String str, Object... objArr) {
            t.e(objArr, "args");
            for (b e5 : a.f25680c) {
                e5.e(th, str, Arrays.copyOf(objArr, objArr.length));
            }
        }

        public void g(String str, Object... objArr) {
            t.e(objArr, "args");
            for (b g5 : a.f25680c) {
                g5.g(str, Arrays.copyOf(objArr, objArr.length));
            }
        }

        public void h(String str, Object... objArr) {
            t.e(objArr, "args");
            for (b h5 : a.f25680c) {
                h5.h(str, Arrays.copyOf(objArr, objArr.length));
            }
        }

        public void i(Throwable th, String str, Object... objArr) {
            t.e(objArr, "args");
            for (b i5 : a.f25680c) {
                i5.i(th, str, Arrays.copyOf(objArr, objArr.length));
            }
        }

        public final b j(String str) {
            t.e(str, "tag");
            b[] a5 = a.f25680c;
            int length = a5.length;
            int i5 = 0;
            while (i5 < length) {
                b bVar = a5[i5];
                i5++;
                bVar.f().set(str);
            }
            return this;
        }

        private C0258a() {
        }
    }

    public static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        private final ThreadLocal f25681a = new ThreadLocal();

        public abstract void a(String str, Object... objArr);

        public abstract void b(Throwable th, String str, Object... objArr);

        public abstract void c(String str, Object... objArr);

        public abstract void d(Throwable th);

        public abstract void e(Throwable th, String str, Object... objArr);

        public final /* synthetic */ ThreadLocal f() {
            return this.f25681a;
        }

        public abstract void g(String str, Object... objArr);

        public abstract void h(String str, Object... objArr);

        public abstract void i(Throwable th, String str, Object... objArr);
    }

    public static final b b(String str) {
        return f25678a.j(str);
    }
}
