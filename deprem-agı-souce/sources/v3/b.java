package V3;

public abstract class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    protected final String f19698a;

    public b(String str, Object... objArr) {
        this.f19698a = c.o(str, objArr);
    }

    /* access modifiers changed from: protected */
    public abstract void e();

    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f19698a);
        try {
            e();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
