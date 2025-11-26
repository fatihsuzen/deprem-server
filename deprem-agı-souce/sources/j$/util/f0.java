package j$.util;

public interface f0 extends Spliterator {
    void forEachRemaining(Object obj);

    boolean tryAdvance(Object obj);

    f0 trySplit();
}
