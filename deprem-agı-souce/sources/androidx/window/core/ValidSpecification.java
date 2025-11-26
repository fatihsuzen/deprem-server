package androidx.window.core;

import androidx.window.core.SpecificationComputer;
import k3.l;
import kotlin.jvm.internal.t;

final class ValidSpecification<T> extends SpecificationComputer<T> {
    private final Logger logger;
    private final String tag;
    private final T value;
    private final SpecificationComputer.VerificationMode verificationMode;

    public ValidSpecification(T t5, String str, SpecificationComputer.VerificationMode verificationMode2, Logger logger2) {
        t.e(t5, "value");
        t.e(str, "tag");
        t.e(verificationMode2, "verificationMode");
        t.e(logger2, "logger");
        this.value = t5;
        this.tag = str;
        this.verificationMode = verificationMode2;
        this.logger = logger2;
    }

    public T compute() {
        return this.value;
    }

    public final Logger getLogger() {
        return this.logger;
    }

    public final String getTag() {
        return this.tag;
    }

    public final T getValue() {
        return this.value;
    }

    public final SpecificationComputer.VerificationMode getVerificationMode() {
        return this.verificationMode;
    }

    public SpecificationComputer<T> require(String str, l lVar) {
        t.e(str, "message");
        t.e(lVar, "condition");
        if (((Boolean) lVar.invoke(this.value)).booleanValue()) {
            return this;
        }
        return new FailedSpecification(this.value, this.tag, str, this.logger, this.verificationMode);
    }
}
