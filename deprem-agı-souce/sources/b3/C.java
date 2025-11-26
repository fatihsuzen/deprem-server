package B3;

import W2.t;
import W2.u;
import a.a;

public abstract class C {

    /* renamed from: a  reason: collision with root package name */
    private static final StackTraceElement f17368a = new a().a();

    /* renamed from: b  reason: collision with root package name */
    private static final String f17369b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f17370c;

    static {
        Object obj;
        Object obj2;
        try {
            t.a aVar = t.f19966b;
            obj = t.b(kotlin.coroutines.jvm.internal.a.class.getCanonicalName());
        } catch (Throwable th) {
            t.a aVar2 = t.f19966b;
            obj = t.b(u.a(th));
        }
        if (t.e(obj) != null) {
            obj = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        f17369b = (String) obj;
        try {
            obj2 = t.b(C.class.getCanonicalName());
        } catch (Throwable th2) {
            t.a aVar3 = t.f19966b;
            obj2 = t.b(u.a(th2));
        }
        if (t.e(obj2) != null) {
            obj2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        f17370c = (String) obj2;
    }

    public static final Throwable a(Throwable th) {
        return th;
    }
}
