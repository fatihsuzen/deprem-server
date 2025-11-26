package j$.time.format;

public final class l implements f {

    /* renamed from: a  reason: collision with root package name */
    public final String f1119a;

    public l(String str) {
        this.f1119a = str;
    }

    public final boolean e(p pVar, StringBuilder sb) {
        sb.append(this.f1119a);
        return true;
    }

    public final String toString() {
        String replace = this.f1119a.replace("'", "''");
        return "'" + replace + "'";
    }
}
