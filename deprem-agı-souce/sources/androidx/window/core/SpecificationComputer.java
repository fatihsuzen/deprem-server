package androidx.window.core;

import k3.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public abstract class SpecificationComputer<T> {
    public static final Companion Companion = new Companion((C2633k) null);

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public static /* synthetic */ SpecificationComputer startSpecification$default(Companion companion, Object obj, String str, VerificationMode verificationMode, Logger logger, int i5, Object obj2) {
            if ((i5 & 2) != 0) {
                verificationMode = BuildConfig.INSTANCE.getVerificationMode();
            }
            if ((i5 & 4) != 0) {
                logger = AndroidLogger.INSTANCE;
            }
            return companion.startSpecification(obj, str, verificationMode, logger);
        }

        public final <T> SpecificationComputer<T> startSpecification(T t5, String str, VerificationMode verificationMode, Logger logger) {
            t.e(t5, "<this>");
            t.e(str, "tag");
            t.e(verificationMode, "verificationMode");
            t.e(logger, "logger");
            return new ValidSpecification(t5, str, verificationMode, logger);
        }

        private Companion() {
        }
    }

    public enum VerificationMode {
        STRICT,
        LOG,
        QUIET
    }

    public abstract T compute();

    /* access modifiers changed from: protected */
    public final String createMessage(Object obj, String str) {
        t.e(obj, "value");
        t.e(str, "message");
        return str + " value: " + obj;
    }

    public abstract SpecificationComputer<T> require(String str, l lVar);
}
