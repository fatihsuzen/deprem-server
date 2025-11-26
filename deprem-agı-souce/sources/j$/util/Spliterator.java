package j$.util;

import java.util.Comparator;
import java.util.function.Consumer;

public interface Spliterator<T> {

    public final /* synthetic */ class Wrapper implements java.util.Spliterator {
        public /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.Spliterator convert(Spliterator spliterator) {
            if (spliterator == null) {
                return null;
            }
            return spliterator instanceof g0 ? ((g0) spliterator).f1384a : spliterator instanceof f0 ? e0.a((f0) spliterator) : new Wrapper();
        }

        public final /* synthetic */ int characteristics() {
            return Spliterator.this.characteristics();
        }

        public final /* synthetic */ boolean equals(Object obj) {
            Spliterator spliterator = Spliterator.this;
            if (obj instanceof Wrapper) {
                obj = Spliterator.this;
            }
            return spliterator.equals(obj);
        }

        public final /* synthetic */ long estimateSize() {
            return Spliterator.this.estimateSize();
        }

        public final /* synthetic */ void forEachRemaining(Consumer consumer) {
            Spliterator.this.forEachRemaining(consumer);
        }

        public final /* synthetic */ Comparator getComparator() {
            return Spliterator.this.getComparator();
        }

        public final /* synthetic */ long getExactSizeIfKnown() {
            return Spliterator.this.getExactSizeIfKnown();
        }

        public final /* synthetic */ boolean hasCharacteristics(int i5) {
            return Spliterator.this.hasCharacteristics(i5);
        }

        public final /* synthetic */ int hashCode() {
            return Spliterator.this.hashCode();
        }

        public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
            return Spliterator.this.tryAdvance(consumer);
        }

        public final /* synthetic */ java.util.Spliterator trySplit() {
            return convert(Spliterator.this.trySplit());
        }
    }

    int characteristics();

    long estimateSize();

    void forEachRemaining(Consumer consumer);

    Comparator getComparator();

    long getExactSizeIfKnown();

    boolean hasCharacteristics(int i5);

    boolean tryAdvance(Consumer consumer);

    Spliterator trySplit();
}
