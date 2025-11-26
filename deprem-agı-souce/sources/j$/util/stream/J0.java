package j$.util.stream;

public abstract class J0 implements H0 {

    /* renamed from: a  reason: collision with root package name */
    public final H0 f1504a;

    /* renamed from: b  reason: collision with root package name */
    public final H0 f1505b;

    /* renamed from: c  reason: collision with root package name */
    public final long f1506c;

    public final int o() {
        return 2;
    }

    public J0(H0 h02, H0 h03) {
        this.f1504a = h02;
        this.f1505b = h03;
        this.f1506c = h03.count() + h02.count();
    }

    public final H0 a(int i5) {
        if (i5 == 0) {
            return this.f1504a;
        }
        if (i5 == 1) {
            return this.f1505b;
        }
        throw new IndexOutOfBoundsException();
    }

    public final long count() {
        return this.f1506c;
    }
}
