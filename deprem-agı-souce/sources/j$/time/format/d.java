package j$.time.format;

public final class d implements f {

    /* renamed from: a  reason: collision with root package name */
    public final char f1102a;

    public d(char c5) {
        this.f1102a = c5;
    }

    public final boolean e(p pVar, StringBuilder sb) {
        sb.append(this.f1102a);
        return true;
    }

    public final String toString() {
        char c5 = this.f1102a;
        if (c5 == '\'') {
            return "''";
        }
        return "'" + c5 + "'";
    }
}
