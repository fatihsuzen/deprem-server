package w3;

/* renamed from: w3.h0  reason: case insensitive filesystem */
final class C2875h0 implements C2900u0 {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f26285a;

    public C2875h0(boolean z4) {
        this.f26285a = z4;
    }

    public J0 b() {
        return null;
    }

    public boolean isActive() {
        return this.f26285a;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        if (isActive()) {
            str = "Active";
        } else {
            str = "New";
        }
        sb.append(str);
        sb.append('}');
        return sb.toString();
    }
}
