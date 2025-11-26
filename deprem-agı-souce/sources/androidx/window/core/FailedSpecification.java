package androidx.window.core;

import W2.q;
import X2.C2242i;
import androidx.window.core.SpecificationComputer;
import k3.l;
import kotlin.jvm.internal.t;

final class FailedSpecification<T> extends SpecificationComputer<T> {
    private final WindowStrictModeException exception;
    private final Logger logger;
    private final String message;
    private final String tag;
    private final T value;
    private final SpecificationComputer.VerificationMode verificationMode;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SpecificationComputer.VerificationMode.values().length];
            iArr[SpecificationComputer.VerificationMode.STRICT.ordinal()] = 1;
            iArr[SpecificationComputer.VerificationMode.LOG.ordinal()] = 2;
            iArr[SpecificationComputer.VerificationMode.QUIET.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public FailedSpecification(T t5, String str, String str2, Logger logger2, SpecificationComputer.VerificationMode verificationMode2) {
        t.e(t5, "value");
        t.e(str, "tag");
        t.e(str2, "message");
        t.e(logger2, "logger");
        t.e(verificationMode2, "verificationMode");
        this.value = t5;
        this.tag = str;
        this.message = str2;
        this.logger = logger2;
        this.verificationMode = verificationMode2;
        WindowStrictModeException windowStrictModeException = new WindowStrictModeException(createMessage(t5, str2));
        StackTraceElement[] stackTrace = windowStrictModeException.getStackTrace();
        t.d(stackTrace, "stackTrace");
        Object[] array = C2242i.N(stackTrace, 2).toArray(new StackTraceElement[0]);
        if (array != null) {
            windowStrictModeException.setStackTrace((StackTraceElement[]) array);
            this.exception = windowStrictModeException;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public T compute() {
        int i5 = WhenMappings.$EnumSwitchMapping$0[this.verificationMode.ordinal()];
        if (i5 == 1) {
            throw this.exception;
        } else if (i5 == 2) {
            this.logger.debug(this.tag, createMessage(this.value, this.message));
            return null;
        } else if (i5 == 3) {
            return null;
        } else {
            throw new q();
        }
    }

    public final WindowStrictModeException getException() {
        return this.exception;
    }

    public final Logger getLogger() {
        return this.logger;
    }

    public final String getMessage() {
        return this.message;
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
        return this;
    }
}
