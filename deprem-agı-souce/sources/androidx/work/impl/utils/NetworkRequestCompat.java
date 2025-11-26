package androidx.work.impl.utils;

import android.net.NetworkRequest;
import androidx.work.Logger;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class NetworkRequestCompat {
    public static final Companion Companion = new Companion((C2633k) null);
    /* access modifiers changed from: private */
    public static final String TAG;
    private final Object wrapped;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public final String getTAG() {
            return NetworkRequestCompat.TAG;
        }

        private Companion() {
        }
    }

    static {
        String tagWithPrefix = Logger.tagWithPrefix("NetworkRequestCompat");
        t.d(tagWithPrefix, "tagWithPrefix(...)");
        TAG = tagWithPrefix;
    }

    public NetworkRequestCompat() {
        this((Object) null, 1, (C2633k) null);
    }

    public static /* synthetic */ NetworkRequestCompat copy$default(NetworkRequestCompat networkRequestCompat, Object obj, int i5, Object obj2) {
        if ((i5 & 1) != 0) {
            obj = networkRequestCompat.wrapped;
        }
        return networkRequestCompat.copy(obj);
    }

    public final Object component1() {
        return this.wrapped;
    }

    public final NetworkRequestCompat copy(Object obj) {
        return new NetworkRequestCompat(obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof NetworkRequestCompat) && t.a(this.wrapped, ((NetworkRequestCompat) obj).wrapped);
    }

    public final NetworkRequest getNetworkRequest() {
        return (NetworkRequest) this.wrapped;
    }

    public final Object getWrapped() {
        return this.wrapped;
    }

    public int hashCode() {
        Object obj = this.wrapped;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        return "NetworkRequestCompat(wrapped=" + this.wrapped + ')';
    }

    public NetworkRequestCompat(Object obj) {
        this.wrapped = obj;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NetworkRequestCompat(Object obj, int i5, C2633k kVar) {
        this((i5 & 1) != 0 ? null : obj);
    }
}
