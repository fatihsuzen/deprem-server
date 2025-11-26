package r;

import java.util.Set;
import p.C1745c;
import p.h;
import p.i;
import p.j;

final class q implements j {

    /* renamed from: a  reason: collision with root package name */
    private final Set f16292a;

    /* renamed from: b  reason: collision with root package name */
    private final p f16293b;

    /* renamed from: c  reason: collision with root package name */
    private final t f16294c;

    q(Set set, p pVar, t tVar) {
        this.f16292a = set;
        this.f16293b = pVar;
        this.f16294c = tVar;
    }

    public i a(String str, Class cls, C1745c cVar, h hVar) {
        if (this.f16292a.contains(cVar)) {
            return new s(this.f16293b, str, cVar, hVar, this.f16294c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", new Object[]{cVar, this.f16292a}));
    }
}
