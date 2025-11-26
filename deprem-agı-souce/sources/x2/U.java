package X2;

import Y2.h;
import java.util.Collections;
import java.util.Set;
import kotlin.jvm.internal.t;

abstract class U {
    public static Set a(Set set) {
        t.e(set, "builder");
        return ((h) set).f();
    }

    public static Set b() {
        return new h();
    }

    public static Set c(Object obj) {
        Set singleton = Collections.singleton(obj);
        t.d(singleton, "singleton(...)");
        return singleton;
    }
}
