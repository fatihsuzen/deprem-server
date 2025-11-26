package j$.util.stream;

import j$.util.C0471g;
import j$.util.stream.IntStream;
import java.util.function.IntFunction;
import java.util.function.LongFunction;

public final class L implements IntFunction, LongFunction {

    /* renamed from: a  reason: collision with root package name */
    public IntFunction f1526a;

    public Object apply(int i5) {
        Object apply = this.f1526a.apply(i5);
        if (apply == null) {
            return null;
        }
        if (apply instanceof IntStream) {
            return IntStream.Wrapper.convert((IntStream) apply);
        }
        if (apply instanceof java.util.stream.IntStream) {
            return IntStream.VivifiedWrapper.convert((java.util.stream.IntStream) apply);
        }
        C0471g.a(apply.getClass(), "java.util.stream.IntStream");
        throw null;
    }

    public Object apply(long j5) {
        return C0594w1.Y(j5, this.f1526a);
    }
}
