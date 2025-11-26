package q3;

import kotlin.jvm.internal.t;

/* renamed from: q3.a  reason: case insensitive filesystem */
public interface C2725a {

    /* renamed from: q3.a$a  reason: collision with other inner class name */
    public static final class C0259a {
        public static boolean a(C2725a aVar, Comparable comparable) {
            t.e(comparable, "value");
            if (comparable.compareTo(aVar.getStart()) < 0 || comparable.compareTo(aVar.getEndInclusive()) > 0) {
                return false;
            }
            return true;
        }

        public static boolean b(C2725a aVar) {
            if (aVar.getStart().compareTo(aVar.getEndInclusive()) > 0) {
                return true;
            }
            return false;
        }
    }

    Comparable getEndInclusive();

    Comparable getStart();
}
