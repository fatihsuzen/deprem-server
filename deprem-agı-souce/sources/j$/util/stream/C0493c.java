package j$.util.stream;

/* renamed from: j$.util.stream.c  reason: case insensitive filesystem */
public abstract class C0493c {

    /* renamed from: a  reason: collision with root package name */
    public final int f1676a;

    /* renamed from: b  reason: collision with root package name */
    public int f1677b;

    /* renamed from: c  reason: collision with root package name */
    public int f1678c;

    /* renamed from: d  reason: collision with root package name */
    public long[] f1679d;

    public abstract void clear();

    public C0493c() {
        this.f1676a = 4;
    }

    public C0493c(int i5) {
        if (i5 >= 0) {
            this.f1676a = Math.max(4, 32 - Integer.numberOfLeadingZeros(i5 - 1));
            return;
        }
        throw new IllegalArgumentException("Illegal Capacity: " + i5);
    }

    public final long count() {
        int i5 = this.f1678c;
        if (i5 == 0) {
            return (long) this.f1677b;
        }
        return this.f1679d[i5] + ((long) this.f1677b);
    }
}
