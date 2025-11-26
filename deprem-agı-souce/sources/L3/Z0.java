package L3;

import H3.a;
import J3.f;
import K3.c;
import K3.e;
import X2.C2250q;
import java.util.ArrayList;
import k3.C2616a;
import kotlin.jvm.internal.t;

public abstract class Z0 implements e, c {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList f18505a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private boolean f18506b;

    /* access modifiers changed from: private */
    public static final Object e(Z0 z02, a aVar, Object obj) {
        if (aVar.getDescriptor().c() || z02.decodeNotNullMark()) {
            return z02.g(aVar, obj);
        }
        return z02.decodeNull();
    }

    /* access modifiers changed from: private */
    public static final Object f(Z0 z02, a aVar, Object obj) {
        return z02.g(aVar, obj);
    }

    private final Object x(Object obj, C2616a aVar) {
        w(obj);
        Object invoke = aVar.invoke();
        if (!this.f18506b) {
            v();
        }
        this.f18506b = false;
        return invoke;
    }

    public final boolean decodeBoolean() {
        return h(v());
    }

    public final boolean decodeBooleanElement(f fVar, int i5) {
        t.e(fVar, "descriptor");
        return h(t(fVar, i5));
    }

    public final byte decodeByte() {
        return i(v());
    }

    public final byte decodeByteElement(f fVar, int i5) {
        t.e(fVar, "descriptor");
        return i(t(fVar, i5));
    }

    public final char decodeChar() {
        return j(v());
    }

    public final char decodeCharElement(f fVar, int i5) {
        t.e(fVar, "descriptor");
        return j(t(fVar, i5));
    }

    public int decodeCollectionSize(f fVar) {
        return c.a.a(this, fVar);
    }

    public final double decodeDouble() {
        return k(v());
    }

    public final double decodeDoubleElement(f fVar, int i5) {
        t.e(fVar, "descriptor");
        return k(t(fVar, i5));
    }

    public final int decodeEnum(f fVar) {
        t.e(fVar, "enumDescriptor");
        return l(v(), fVar);
    }

    public final float decodeFloat() {
        return m(v());
    }

    public final float decodeFloatElement(f fVar, int i5) {
        t.e(fVar, "descriptor");
        return m(t(fVar, i5));
    }

    public e decodeInline(f fVar) {
        t.e(fVar, "descriptor");
        return n(v(), fVar);
    }

    public final e decodeInlineElement(f fVar, int i5) {
        t.e(fVar, "descriptor");
        return n(t(fVar, i5), fVar.h(i5));
    }

    public final int decodeInt() {
        return o(v());
    }

    public final int decodeIntElement(f fVar, int i5) {
        t.e(fVar, "descriptor");
        return o(t(fVar, i5));
    }

    public final long decodeLong() {
        return p(v());
    }

    public final long decodeLongElement(f fVar, int i5) {
        t.e(fVar, "descriptor");
        return p(t(fVar, i5));
    }

    public final Void decodeNull() {
        return null;
    }

    public final Object decodeNullableSerializableElement(f fVar, int i5, a aVar, Object obj) {
        t.e(fVar, "descriptor");
        t.e(aVar, "deserializer");
        return x(t(fVar, i5), new Y0(this, aVar, obj));
    }

    public boolean decodeSequentially() {
        return c.a.b(this);
    }

    public final Object decodeSerializableElement(f fVar, int i5, a aVar, Object obj) {
        t.e(fVar, "descriptor");
        t.e(aVar, "deserializer");
        return x(t(fVar, i5), new X0(this, aVar, obj));
    }

    public abstract Object decodeSerializableValue(a aVar);

    public final short decodeShort() {
        return q(v());
    }

    public final short decodeShortElement(f fVar, int i5) {
        t.e(fVar, "descriptor");
        return q(t(fVar, i5));
    }

    public final String decodeString() {
        return r(v());
    }

    public final String decodeStringElement(f fVar, int i5) {
        t.e(fVar, "descriptor");
        return r(t(fVar, i5));
    }

    /* access modifiers changed from: protected */
    public Object g(a aVar, Object obj) {
        t.e(aVar, "deserializer");
        return decodeSerializableValue(aVar);
    }

    /* access modifiers changed from: protected */
    public abstract boolean h(Object obj);

    /* access modifiers changed from: protected */
    public abstract byte i(Object obj);

    /* access modifiers changed from: protected */
    public abstract char j(Object obj);

    /* access modifiers changed from: protected */
    public abstract double k(Object obj);

    /* access modifiers changed from: protected */
    public abstract int l(Object obj, f fVar);

    /* access modifiers changed from: protected */
    public abstract float m(Object obj);

    /* access modifiers changed from: protected */
    public e n(Object obj, f fVar) {
        t.e(fVar, "inlineDescriptor");
        w(obj);
        return this;
    }

    /* access modifiers changed from: protected */
    public abstract int o(Object obj);

    /* access modifiers changed from: protected */
    public abstract long p(Object obj);

    /* access modifiers changed from: protected */
    public abstract short q(Object obj);

    /* access modifiers changed from: protected */
    public abstract String r(Object obj);

    /* access modifiers changed from: protected */
    public final Object s() {
        return C2250q.Y(this.f18505a);
    }

    /* access modifiers changed from: protected */
    public abstract Object t(f fVar, int i5);

    public final ArrayList u() {
        return this.f18505a;
    }

    /* access modifiers changed from: protected */
    public final Object v() {
        ArrayList arrayList = this.f18505a;
        Object remove = arrayList.remove(C2250q.i(arrayList));
        this.f18506b = true;
        return remove;
    }

    /* access modifiers changed from: protected */
    public final void w(Object obj) {
        this.f18505a.add(obj);
    }
}
