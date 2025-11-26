package n1;

import j$.util.Collection;
import j$.util.stream.Collectors;
import java.util.Collection;
import java.util.function.Predicate;
import p1.d;

/* renamed from: n1.b  reason: case insensitive filesystem */
public abstract class C1725b implements C1726c {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f15613a;

    /* renamed from: b  reason: collision with root package name */
    protected Predicate f15614b = null;

    /* renamed from: c  reason: collision with root package name */
    protected Object f15615c;

    protected C1725b(boolean z4) {
        this.f15613a = z4;
    }

    public abstract void b(String str);

    public abstract String c();

    public boolean d() {
        return this.f15613a;
    }

    public abstract String e(String str, int i5);

    public C1725b f(Predicate predicate) {
        this.f15614b = predicate;
        return this;
    }

    public Object getValue() {
        return this.f15615c;
    }

    public void setValue(Object obj) {
        Predicate predicate = this.f15614b;
        if (predicate == null || predicate.test(obj)) {
            this.f15615c = obj;
        } else if (obj instanceof Collection) {
            throw new d("Invalid value '" + ((String) Collection.EL.stream((java.util.Collection) obj).map(new C1724a()).collect(Collectors.joining(","))) + "'");
        } else {
            throw new d("Invalid value '" + obj + "'");
        }
    }
}
