package Z0;

final class a extends f {

    /* renamed from: a  reason: collision with root package name */
    private final String f4498a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4499b;

    a(String str, String str2) {
        if (str != null) {
            this.f4498a = str;
            if (str2 != null) {
                this.f4499b = str2;
                return;
            }
            throw new NullPointerException("Null version");
        }
        throw new NullPointerException("Null libraryName");
    }

    public String b() {
        return this.f4498a;
    }

    public String c() {
        return this.f4499b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (!this.f4498a.equals(fVar.b()) || !this.f4499b.equals(fVar.c())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f4498a.hashCode() ^ 1000003) * 1000003) ^ this.f4499b.hashCode();
    }

    public String toString() {
        return "LibraryVersion{libraryName=" + this.f4498a + ", version=" + this.f4499b + "}";
    }
}
