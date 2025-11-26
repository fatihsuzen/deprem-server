package j$.time;

import java.io.ObjectInputStream;
import java.io.Serializable;

public final class a extends j$.com.android.tools.r8.a implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public static final a f1026b = new a(ZoneOffset.UTC);
    private static final long serialVersionUID = 6740630888130243051L;

    /* renamed from: a  reason: collision with root package name */
    public final ZoneId f1027a;

    public a(ZoneId zoneId) {
        this.f1027a = zoneId;
    }

    static {
        System.currentTimeMillis();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.f1027a.equals(((a) obj).f1027a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1027a.hashCode() + 1;
    }

    public final String toString() {
        ZoneId zoneId = this.f1027a;
        return "SystemClock[" + zoneId + "]";
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
    }
}
