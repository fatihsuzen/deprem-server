package k0;

import java.util.concurrent.Executor;

final class M implements Executor {
    M() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
