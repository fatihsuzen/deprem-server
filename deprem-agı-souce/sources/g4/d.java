package g4;

import java.util.HashMap;
import java.util.Map;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap f22227a;

    public d() {
        this.f22227a = new HashMap(14);
    }

    public synchronized String a(c cVar) {
        return (String) this.f22227a.get(cVar.toString());
    }

    public synchronized boolean b(c cVar) {
        return this.f22227a.containsKey(cVar.toString());
    }

    public synchronized d c(c cVar, String str) {
        d(cVar.toString(), str);
        return this;
    }

    public synchronized d d(String str, String str2) {
        if (str2 == null) {
            try {
                this.f22227a.remove(str);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        } else if (str2.length() > 0) {
            this.f22227a.put(str, str2);
        }
        return this;
    }

    public synchronized Map e() {
        return new HashMap(this.f22227a);
    }

    public synchronized d f(c cVar, int i5) {
        return h(cVar, String.valueOf(i5));
    }

    public synchronized d g(c cVar, long j5) {
        return h(cVar, String.valueOf(j5));
    }

    public synchronized d h(c cVar, String str) {
        if (!b(cVar)) {
            c(cVar, str);
        }
        return this;
    }

    public d(d dVar) {
        HashMap hashMap = new HashMap(14);
        this.f22227a = hashMap;
        hashMap.putAll(dVar.f22227a);
    }
}
