package s3;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.t;

/* renamed from: s3.a  reason: case insensitive filesystem */
public final class C2747a implements C2751e {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference f25822a;

    public C2747a(C2751e eVar) {
        t.e(eVar, "sequence");
        this.f25822a = new AtomicReference(eVar);
    }

    public Iterator iterator() {
        C2751e eVar = (C2751e) this.f25822a.getAndSet((Object) null);
        if (eVar != null) {
            return eVar.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
