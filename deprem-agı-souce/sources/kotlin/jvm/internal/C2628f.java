package kotlin.jvm.internal;

import j3.C2583b;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import r3.C2732b;
import r3.C2735e;
import r3.C2743m;
import r3.o;

/* renamed from: kotlin.jvm.internal.f  reason: case insensitive filesystem */
public abstract class C2628f implements C2732b, Serializable {
    public static final Object NO_RECEIVER = a.f24707a;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient C2732b reflected;
    private final String signature;

    /* renamed from: kotlin.jvm.internal.f$a */
    private static class a implements Serializable {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final a f24707a = new a();

        private a() {
        }
    }

    protected C2628f(Object obj, Class cls, String str, String str2, boolean z4) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z4;
    }

    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public C2732b compute() {
        C2732b bVar = this.reflected;
        if (bVar != null) {
            return bVar;
        }
        C2732b computeReflected = computeReflected();
        this.reflected = computeReflected;
        return computeReflected;
    }

    /* access modifiers changed from: protected */
    public abstract C2732b computeReflected();

    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    public String getName() {
        return this.name;
    }

    public C2735e getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        if (this.isTopLevel) {
            return M.c(cls);
        }
        return M.b(cls);
    }

    public List<Object> getParameters() {
        return getReflected().getParameters();
    }

    /* access modifiers changed from: protected */
    public C2732b getReflected() {
        C2732b compute = compute();
        if (compute != this) {
            return compute;
        }
        throw new C2583b();
    }

    public C2743m getReturnType() {
        return getReflected().getReturnType();
    }

    public String getSignature() {
        return this.signature;
    }

    public List<Object> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    public o getVisibility() {
        return getReflected().getVisibility();
    }

    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    public boolean isFinal() {
        return getReflected().isFinal();
    }

    public boolean isOpen() {
        return getReflected().isOpen();
    }

    public boolean isSuspend() {
        return getReflected().isSuspend();
    }
}
