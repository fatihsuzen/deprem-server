package j$.time.chrono;

import j$.time.LocalDateTime;
import j$.time.b;
import j$.time.j;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Locale;

/* renamed from: j$.time.chrono.a  reason: case insensitive filesystem */
public abstract class C0455a implements l {

    /* renamed from: a  reason: collision with root package name */
    public static final ConcurrentHashMap f1039a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    public static final ConcurrentHashMap f1040b = new ConcurrentHashMap();

    public final int compareTo(Object obj) {
        return d().compareTo(((l) obj).d());
    }

    static {
        new Locale("ja", "JP", "JP");
    }

    public static l e(l lVar, String str) {
        String j5;
        l lVar2 = (l) f1039a.putIfAbsent(str, lVar);
        if (lVar2 == null && (j5 = lVar.j()) != null) {
            f1040b.putIfAbsent(j5, lVar);
        }
        return lVar2;
    }

    public C0459e p(LocalDateTime localDateTime) {
        try {
            return o(localDateTime).s(j.x(localDateTime));
        } catch (b e5) {
            throw new RuntimeException("Unable to obtain ChronoLocalDateTime from TemporalAccessor: " + LocalDateTime.class, e5);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C0455a) && d().compareTo(((C0455a) obj).d()) == 0;
    }

    public final int hashCode() {
        return getClass().hashCode() ^ d().hashCode();
    }

    public final String toString() {
        return d();
    }
}
