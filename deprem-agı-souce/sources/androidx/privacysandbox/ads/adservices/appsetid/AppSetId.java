package androidx.privacysandbox.ads.adservices.appsetid;

import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class AppSetId {
    public static final Companion Companion = new Companion((C2633k) null);
    public static final int SCOPE_APP = 1;
    public static final int SCOPE_DEVELOPER = 2;
    private final String id;
    private final int scope;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        private Companion() {
        }
    }

    public AppSetId(String str, int i5) {
        t.e(str, "id");
        this.id = str;
        this.scope = i5;
        if (i5 != 1 && i5 != 2) {
            throw new IllegalArgumentException("Scope undefined.");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppSetId)) {
            return false;
        }
        AppSetId appSetId = (AppSetId) obj;
        if (!t.a(this.id, appSetId.id) || this.scope != appSetId.scope) {
            return false;
        }
        return true;
    }

    public final String getId() {
        return this.id;
    }

    public final int getScope() {
        return this.scope;
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.scope;
    }

    public String toString() {
        String str;
        if (this.scope == 1) {
            str = "SCOPE_APP";
        } else {
            str = "SCOPE_DEVELOPER";
        }
        return "AppSetId: id=" + this.id + ", scope=" + str;
    }
}
