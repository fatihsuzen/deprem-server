package r;

import java.util.concurrent.Executor;
import v.C1892a;

class n implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f16290a;

    static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Runnable f16291a;

        a(Runnable runnable) {
            this.f16291a = runnable;
        }

        public void run() {
            try {
                this.f16291a.run();
            } catch (Exception e5) {
                C1892a.d("Executor", "Background execution failure.", e5);
            }
        }
    }

    n(Executor executor) {
        this.f16290a = executor;
    }

    public void execute(Runnable runnable) {
        this.f16290a.execute(new a(runnable));
    }
}
