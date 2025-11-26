package l0;

final class i extends g {

    /* renamed from: a  reason: collision with root package name */
    private final Object f15526a;

    i(Object obj) {
        this.f15526a = obj;
    }

    public Object b() {
        return this.f15526a;
    }

    public boolean c() {
        return true;
    }

    public boolean equals(Object obj) {
        if (obj instanceof i) {
            return this.f15526a.equals(((i) obj).f15526a);
        }
        return false;
    }

    public int hashCode() {
        return this.f15526a.hashCode() + 1502476572;
    }

    public String toString() {
        String valueOf = String.valueOf(this.f15526a);
        StringBuilder sb = new StringBuilder(valueOf.length() + 13);
        sb.append("Optional.of(");
        sb.append(valueOf);
        sb.append(")");
        return sb.toString();
    }
}
