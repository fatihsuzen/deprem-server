package p;

/* renamed from: p.b  reason: case insensitive filesystem */
final class C1744b extends g {

    /* renamed from: a  reason: collision with root package name */
    private final Integer f15676a;

    C1744b(Integer num) {
        this.f15676a = num;
    }

    public Integer a() {
        return this.f15676a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        Integer num = this.f15676a;
        Integer a5 = ((g) obj).a();
        if (num != null) {
            return num.equals(a5);
        }
        if (a5 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i5;
        Integer num = this.f15676a;
        if (num == null) {
            i5 = 0;
        } else {
            i5 = num.hashCode();
        }
        return i5 ^ 1000003;
    }

    public String toString() {
        return "ProductData{productId=" + this.f15676a + "}";
    }
}
