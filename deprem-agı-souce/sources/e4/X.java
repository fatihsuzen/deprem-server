package e4;

import java.io.Closeable;
import java.io.Flushable;

public interface X extends Closeable, Flushable {
    void close();

    void f(C2356e eVar, long j5);

    void flush();

    a0 timeout();
}
