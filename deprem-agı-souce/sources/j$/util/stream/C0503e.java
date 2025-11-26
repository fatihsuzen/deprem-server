package j$.util.stream;

import j$.util.Spliterator;
import j$.util.g0;
import j$.util.stream.IntStream;
import java.util.Iterator;
import java.util.stream.BaseStream;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/* renamed from: j$.util.stream.e  reason: case insensitive filesystem */
public final /* synthetic */ class C0503e implements C0513g {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseStream f1700a;

    public /* synthetic */ C0503e(BaseStream baseStream) {
        this.f1700a = baseStream;
    }

    public static /* synthetic */ C0513g f(BaseStream baseStream) {
        if (baseStream == null) {
            return null;
        }
        return baseStream instanceof C0508f ? ((C0508f) baseStream).f1702a : baseStream instanceof DoubleStream ? B.f((DoubleStream) baseStream) : baseStream instanceof IntStream ? IntStream.VivifiedWrapper.convert((java.util.stream.IntStream) baseStream) : baseStream instanceof LongStream ? C0539l0.f((LongStream) baseStream) : baseStream instanceof Stream ? X2.f((Stream) baseStream) : new C0503e(baseStream);
    }

    public final /* synthetic */ void close() {
        this.f1700a.close();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        BaseStream baseStream = this.f1700a;
        if (obj instanceof C0503e) {
            obj = ((C0503e) obj).f1700a;
        }
        return baseStream.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f1700a.hashCode();
    }

    public final /* synthetic */ boolean isParallel() {
        return this.f1700a.isParallel();
    }

    public final /* synthetic */ Iterator iterator() {
        return this.f1700a.iterator();
    }

    public final /* synthetic */ C0513g onClose(Runnable runnable) {
        return f(this.f1700a.onClose(runnable));
    }

    public final /* synthetic */ C0513g parallel() {
        return f(this.f1700a.parallel());
    }

    public final /* synthetic */ C0513g sequential() {
        return f(this.f1700a.sequential());
    }

    public final /* synthetic */ Spliterator spliterator() {
        return g0.a(this.f1700a.spliterator());
    }

    public final /* synthetic */ C0513g unordered() {
        return f(this.f1700a.unordered());
    }
}
