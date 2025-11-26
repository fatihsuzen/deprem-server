package L3;

import java.lang.ref.SoftReference;
import k3.C2616a;
import kotlin.jvm.internal.t;

/* renamed from: L3.m0  reason: case insensitive filesystem */
final class C2101m0 {

    /* renamed from: a  reason: collision with root package name */
    public volatile SoftReference f18560a = new SoftReference((Object) null);

    public final synchronized Object a(C2616a aVar) {
        t.e(aVar, "factory");
        Object obj = this.f18560a.get();
        if (obj != null) {
            return obj;
        }
        Object invoke = aVar.invoke();
        this.f18560a = new SoftReference(invoke);
        return invoke;
    }
}
