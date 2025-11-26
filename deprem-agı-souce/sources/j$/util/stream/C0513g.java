package j$.util.stream;

import j$.util.Spliterator;
import java.util.Iterator;

/* renamed from: j$.util.stream.g  reason: case insensitive filesystem */
public interface C0513g extends AutoCloseable {
    boolean isParallel();

    Iterator iterator();

    C0513g onClose(Runnable runnable);

    C0513g parallel();

    C0513g sequential();

    Spliterator spliterator();

    C0513g unordered();
}
