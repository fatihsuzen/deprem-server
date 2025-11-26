package androidx.privacysandbox.ads.adservices.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface ExperimentalFeatures {

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Ext10OptIn {
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Ext11OptIn {
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Ext12OptIn {
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Ext8OptIn {
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface RegisterSourceOptIn {
    }
}
