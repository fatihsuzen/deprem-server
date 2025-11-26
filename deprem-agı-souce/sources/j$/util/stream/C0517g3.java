package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.Consumer;

/* renamed from: j$.util.stream.g3  reason: case insensitive filesystem */
public final class C0517g3 extends C0522h3 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f1711b;

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public C0517g3(int i5) {
        this.f1711b = new Object[i5];
    }

    public final void accept(Object obj) {
        int i5 = this.f1714a;
        this.f1714a = i5 + 1;
        this.f1711b[i5] = obj;
    }
}
