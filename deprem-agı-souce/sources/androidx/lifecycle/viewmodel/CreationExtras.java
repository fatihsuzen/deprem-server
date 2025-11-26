package androidx.lifecycle.viewmodel;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public abstract class CreationExtras {
    public static final Companion Companion = new Companion((C2633k) null);
    private final Map<Key<?>, Object> extras = new LinkedHashMap();

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public final /* synthetic */ <T> Key<T> Key() {
            t.j();
            return new CreationExtras$Companion$Key$1();
        }

        private Companion() {
        }
    }

    public static final class Empty extends CreationExtras {
        public static final Empty INSTANCE = new Empty();

        private Empty() {
        }

        public <T> T get(Key<T> key) {
            t.e(key, "key");
            return null;
        }
    }

    public interface Key<T> {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CreationExtras) || !t.a(this.extras, ((CreationExtras) obj).extras)) {
            return false;
        }
        return true;
    }

    public abstract <T> T get(Key<T> key);

    public final Map<Key<?>, Object> getExtras$lifecycle_viewmodel_release() {
        return this.extras;
    }

    public int hashCode() {
        return this.extras.hashCode();
    }

    public String toString() {
        return "CreationExtras(extras=" + this.extras + ')';
    }
}
