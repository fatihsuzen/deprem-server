package z0;

import j$.util.DesugarCollections;
import java.util.HashMap;
import java.util.Map;
import u0.g;
import x0.C1914j;

/* renamed from: z0.e  reason: case insensitive filesystem */
class C1976e {

    /* renamed from: a  reason: collision with root package name */
    private final Map f17188a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final int f17189b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17190c;

    public C1976e(int i5, int i6) {
        this.f17189b = i5;
        this.f17190c = i6;
    }

    private String b(String str) {
        if (str != null) {
            return c(str, this.f17190c);
        }
        throw new IllegalArgumentException("Custom attribute key must not be null.");
    }

    public static String c(String str, int i5) {
        if (str == null) {
            return str;
        }
        String trim = str.trim();
        if (trim.length() > i5) {
            return trim.substring(0, i5);
        }
        return trim;
    }

    public synchronized Map a() {
        return DesugarCollections.unmodifiableMap(new HashMap(this.f17188a));
    }

    public synchronized boolean d(String str, String str2) {
        String b5 = b(str);
        if (this.f17188a.size() >= this.f17189b) {
            if (!this.f17188a.containsKey(b5)) {
                g f5 = g.f();
                f5.k("Ignored entry \"" + str + "\" when adding custom keys. Maximum allowable: " + this.f17189b);
                return false;
            }
        }
        String c5 = c(str2, this.f17190c);
        if (C1914j.z((String) this.f17188a.get(b5), c5)) {
            return false;
        }
        Map map = this.f17188a;
        if (str2 == null) {
            c5 = "";
        }
        map.put(b5, c5);
        return true;
    }

    public synchronized void e(Map map) {
        String str;
        try {
            int i5 = 0;
            for (Map.Entry entry : map.entrySet()) {
                String b5 = b((String) entry.getKey());
                if (this.f17188a.size() >= this.f17189b) {
                    if (!this.f17188a.containsKey(b5)) {
                        i5++;
                    }
                }
                String str2 = (String) entry.getValue();
                Map map2 = this.f17188a;
                if (str2 == null) {
                    str = "";
                } else {
                    str = c(str2, this.f17190c);
                }
                map2.put(b5, str);
            }
            if (i5 > 0) {
                g f5 = g.f();
                f5.k("Ignored " + i5 + " entries when adding custom keys. Maximum allowable: " + this.f17189b);
            }
        } finally {
            while (true) {
            }
        }
    }
}
