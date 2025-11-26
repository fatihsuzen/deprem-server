package androidx.privacysandbox.ads.adservices.measurement;

import android.net.Uri;
import android.view.InputEvent;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.util.List;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

@ExperimentalFeatures.RegisterSourceOptIn
public final class SourceRegistrationRequest {
    private final InputEvent inputEvent;
    private final List<Uri> registrationUris;

    public static final class Builder {
        private InputEvent inputEvent;
        private final List<Uri> registrationUris;

        public Builder(List<? extends Uri> list) {
            t.e(list, "registrationUris");
            this.registrationUris = list;
        }

        public final SourceRegistrationRequest build() {
            return new SourceRegistrationRequest(this.registrationUris, this.inputEvent);
        }

        public final Builder setInputEvent(InputEvent inputEvent2) {
            t.e(inputEvent2, "inputEvent");
            this.inputEvent = inputEvent2;
            return this;
        }
    }

    public SourceRegistrationRequest(List<? extends Uri> list, InputEvent inputEvent2) {
        t.e(list, "registrationUris");
        this.registrationUris = list;
        this.inputEvent = inputEvent2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SourceRegistrationRequest)) {
            return false;
        }
        SourceRegistrationRequest sourceRegistrationRequest = (SourceRegistrationRequest) obj;
        if (!t.a(this.registrationUris, sourceRegistrationRequest.registrationUris) || !t.a(this.inputEvent, sourceRegistrationRequest.inputEvent)) {
            return false;
        }
        return true;
    }

    public final InputEvent getInputEvent() {
        return this.inputEvent;
    }

    public final List<Uri> getRegistrationUris() {
        return this.registrationUris;
    }

    public int hashCode() {
        int hashCode = this.registrationUris.hashCode();
        InputEvent inputEvent2 = this.inputEvent;
        if (inputEvent2 != null) {
            return (hashCode * 31) + inputEvent2.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        return "AppSourcesRegistrationRequest { " + ("RegistrationUris=[" + this.registrationUris + "], InputEvent=" + this.inputEvent) + " }";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SourceRegistrationRequest(List list, InputEvent inputEvent2, int i5, C2633k kVar) {
        this(list, (i5 & 2) != 0 ? null : inputEvent2);
    }
}
