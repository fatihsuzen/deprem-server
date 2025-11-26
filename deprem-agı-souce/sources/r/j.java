package r;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

abstract class j {
    static Executor a() {
        return new n(Executors.newSingleThreadExecutor());
    }
}
