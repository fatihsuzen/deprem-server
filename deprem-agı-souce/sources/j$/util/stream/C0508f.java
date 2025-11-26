package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.IntStream;
import j$.util.stream.Stream;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.stream.BaseStream;

/* renamed from: j$.util.stream.f  reason: case insensitive filesystem */
public final /* synthetic */ class C0508f implements BaseStream {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0513g f1702a;

    public /* synthetic */ C0508f(C0513g gVar) {
        this.f1702a = gVar;
    }

    public static /* synthetic */ BaseStream f(C0513g gVar) {
        if (gVar == null) {
            return null;
        }
        return gVar instanceof C0503e ? ((C0503e) gVar).f1700a : gVar instanceof D ? C.f((D) gVar) : gVar instanceof IntStream ? IntStream.Wrapper.convert((IntStream) gVar) : gVar instanceof C0549n0 ? C0544m0.f((C0549n0) gVar) : gVar instanceof Stream ? Stream.Wrapper.convert((Stream) gVar) : new C0508f(gVar);
    }

    public final /* synthetic */ void close() {
        this.f1702a.close();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        C0513g gVar = this.f1702a;
        if (obj instanceof C0508f) {
            obj = ((C0508f) obj).f1702a;
        }
        return gVar.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f1702a.hashCode();
    }

    public final /* synthetic */ boolean isParallel() {
        return this.f1702a.isParallel();
    }

    public final /* synthetic */ Iterator iterator() {
        return this.f1702a.iterator();
    }

    public final /* synthetic */ BaseStream onClose(Runnable runnable) {
        return f(this.f1702a.onClose(runnable));
    }

    public final /* synthetic */ BaseStream parallel() {
        return f(this.f1702a.parallel());
    }

    public final /* synthetic */ BaseStream sequential() {
        return f(this.f1702a.sequential());
    }

    public final /* synthetic */ Spliterator spliterator() {
        return Spliterator.Wrapper.convert(this.f1702a.spliterator());
    }

    public final /* synthetic */ BaseStream unordered() {
        return f(this.f1702a.unordered());
    }
}
