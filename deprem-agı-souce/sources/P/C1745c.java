package p;

/* renamed from: p.c  reason: case insensitive filesystem */
public final class C1745c {

    /* renamed from: a  reason: collision with root package name */
    private final String f15677a;

    private C1745c(String str) {
        if (str != null) {
            this.f15677a = str;
            return;
        }
        throw new NullPointerException("name is null");
    }

    public static C1745c b(String str) {
        return new C1745c(str);
    }

    public String a() {
        return this.f15677a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1745c)) {
            return false;
        }
        return this.f15677a.equals(((C1745c) obj).f15677a);
    }

    public int hashCode() {
        return this.f15677a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Encoding{name=\"" + this.f15677a + "\"}";
    }
}
