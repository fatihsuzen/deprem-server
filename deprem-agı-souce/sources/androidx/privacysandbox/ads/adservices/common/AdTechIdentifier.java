package androidx.privacysandbox.ads.adservices.common;

import android.annotation.SuppressLint;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import kotlin.jvm.internal.t;

@SuppressLint({"ClassVerificationFailure"})
public final class AdTechIdentifier {
    private final String identifier;

    public AdTechIdentifier(String str) {
        t.e(str, "identifier");
        this.identifier = str;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.common.AdTechIdentifier convertToAdServices$ads_adservices_release() {
        android.adservices.common.AdTechIdentifier a5 = android.adservices.common.AdTechIdentifier.fromString(this.identifier);
        t.d(a5, "fromString(identifier)");
        return a5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdTechIdentifier)) {
            return false;
        }
        return t.a(this.identifier, ((AdTechIdentifier) obj).identifier);
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public int hashCode() {
        return this.identifier.hashCode();
    }

    public String toString() {
        return String.valueOf(this.identifier);
    }
}
