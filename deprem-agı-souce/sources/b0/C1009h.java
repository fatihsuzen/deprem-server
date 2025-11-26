package b0;

/* renamed from: b0.h  reason: case insensitive filesystem */
public class C1009h {

    /* renamed from: a  reason: collision with root package name */
    private final Class f4514a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f4515b;

    private C1009h(Class cls, Object obj) {
        this.f4514a = cls;
        this.f4515b = obj;
    }

    public static C1009h a(Class cls, Object obj) {
        return new C1009h(cls, obj);
    }

    public final Class b() {
        return this.f4514a;
    }

    public final Object c() {
        return this.f4515b;
    }
}
