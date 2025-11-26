package H;

/* renamed from: H.b  reason: case insensitive filesystem */
public class C0642b {

    /* renamed from: a  reason: collision with root package name */
    private int f2487a = 1;

    public C0642b a(Object obj) {
        int i5;
        int i6 = this.f2487a * 31;
        if (obj == null) {
            i5 = 0;
        } else {
            i5 = obj.hashCode();
        }
        this.f2487a = i6 + i5;
        return this;
    }

    public int b() {
        return this.f2487a;
    }

    public final C0642b c(boolean z4) {
        this.f2487a = (this.f2487a * 31) + (z4 ? 1 : 0);
        return this;
    }
}
