package T3;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f19206a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f19207b;

    public /* synthetic */ a() {
        this(false, false);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f19206a == aVar.f19206a && this.f19207b == aVar.f19207b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        boolean z4 = this.f19206a;
        boolean z5 = true;
        if (z4) {
            z4 = true;
        }
        int i5 = (z4 ? 1 : 0) * true;
        boolean z6 = this.f19207b;
        if (!z6) {
            z5 = z6;
        }
        return i5 + (z5 ? 1 : 0);
    }

    public final String toString() {
        return "ActionButtonSettings(action1Enabled=" + this.f19206a + ", action2Enabled=" + this.f19207b + ')';
    }

    public a(boolean z4, boolean z5) {
        this.f19206a = z4;
        this.f19207b = z5;
    }
}
