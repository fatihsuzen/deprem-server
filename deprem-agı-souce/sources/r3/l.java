package R3;

import com.inmobi.cmp.core.model.Vector;
import com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Set;
import kotlin.jvm.internal.t;

public abstract class l {
    public static PrivacyEncodingMode a(String str) {
        PrivacyEncodingMode privacyEncodingMode;
        if (str == null) {
            privacyEncodingMode = null;
        } else {
            String upperCase = str.toUpperCase(Locale.ROOT);
            t.d(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            if (t.a(upperCase, "TCF")) {
                privacyEncodingMode = PrivacyEncodingMode.TCF;
            } else if (t.a(upperCase, "GPP")) {
                privacyEncodingMode = PrivacyEncodingMode.GPP;
            } else {
                privacyEncodingMode = PrivacyEncodingMode.TCF_AND_GPP;
            }
        }
        if (privacyEncodingMode == null) {
            return PrivacyEncodingMode.TCF_AND_GPP;
        }
        return privacyEncodingMode;
    }

    public static LinkedHashMap b(Vector vector) {
        t.e(vector, "vector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        vector.forEach(new k(linkedHashMap));
        return linkedHashMap;
    }

    public static LinkedHashMap c(Vector vector, Set set) {
        LinkedHashMap linkedHashMap;
        t.e(vector, "vector");
        if (set == null) {
            linkedHashMap = null;
        } else {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                int intValue = ((Number) it.next()).intValue();
                linkedHashMap2.put(String.valueOf(intValue), Boolean.valueOf(vector.contains(intValue)));
            }
            linkedHashMap = linkedHashMap2;
        }
        if (linkedHashMap != null) {
            return linkedHashMap;
        }
        t.e(vector, "vector");
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        vector.forEach(new k(linkedHashMap3));
        return linkedHashMap3;
    }
}
