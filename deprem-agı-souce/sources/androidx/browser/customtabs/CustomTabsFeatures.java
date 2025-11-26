package androidx.browser.customtabs;

import androidx.annotation.RestrictTo;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class CustomTabsFeatures {
    public static final String ENGAGEMENT_SIGNALS = "ENGAGEMENT_SIGNALS";

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface CustomTabsFeature {
    }

    private CustomTabsFeatures() {
    }
}
