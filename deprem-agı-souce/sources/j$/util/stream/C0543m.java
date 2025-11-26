package j$.util.stream;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/* renamed from: j$.util.stream.m  reason: case insensitive filesystem */
public final class C0543m extends C0526i2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f1742b;

    /* renamed from: c  reason: collision with root package name */
    public Object f1743c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0543m(C0483a aVar, C0546m2 m2Var, int i5) {
        super(m2Var);
        this.f1742b = i5;
        this.f1743c = aVar;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0543m(C0546m2 m2Var) {
        super(m2Var);
        this.f1742b = 0;
    }

    public void end() {
        switch (this.f1742b) {
            case 0:
                this.f1743c = null;
                this.f1716a.end();
                return;
            default:
                super.end();
                return;
        }
    }

    public void c(long j5) {
        switch (this.f1742b) {
            case 0:
                this.f1743c = new HashSet();
                this.f1716a.c(-1);
                return;
            case 2:
                this.f1716a.c(-1);
                return;
            default:
                super.c(j5);
                return;
        }
    }

    public final void accept(Object obj) {
        switch (this.f1742b) {
            case 0:
                if (!((Set) this.f1743c).contains(obj)) {
                    ((Set) this.f1743c).add(obj);
                    this.f1716a.accept(obj);
                    return;
                }
                return;
            case 1:
                ((Consumer) ((r) this.f1743c).f1770t).accept(obj);
                this.f1716a.accept(obj);
                return;
            case 2:
                if (((Predicate) ((r) this.f1743c).f1770t).test(obj)) {
                    this.f1716a.accept(obj);
                    return;
                }
                return;
            case 3:
                this.f1716a.accept(((Function) ((r) this.f1743c).f1770t).apply(obj));
                return;
            case 4:
                this.f1716a.accept(((ToIntFunction) ((V) this.f1743c).f1594t).applyAsInt(obj));
                return;
            case 5:
                this.f1716a.accept(((ToLongFunction) ((C0514g0) this.f1743c).f1709t).applyAsLong(obj));
                return;
            default:
                this.f1716a.accept(((ToDoubleFunction) ((C0592w) this.f1743c).f1813t).applyAsDouble(obj));
                return;
        }
    }
}
