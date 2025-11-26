package L3;

public abstract class K0 {
    public static /* synthetic */ void c(K0 k02, int i5, int i6, Object obj) {
        if (obj == null) {
            if ((i6 & 1) != 0) {
                i5 = k02.d() + 1;
            }
            k02.b(i5);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: ensureCapacity");
    }

    public abstract Object a();

    public abstract void b(int i5);

    public abstract int d();
}
