package androidx.savedstate.serialization;

import I3.a;
import J3.f;
import kotlin.jvm.internal.C2640s;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.Q;

public final class SavedStateCodecUtilsKt {
    private static final f booleanArrayDescriptor = a.b().getDescriptor();
    private static final f charArrayDescriptor = a.d().getDescriptor();
    private static final f doubleArrayDescriptor = a.e().getDescriptor();
    private static final f floatArrayDescriptor = a.f().getDescriptor();
    private static final f intArrayDescriptor = a.g().getDescriptor();
    private static final f intListDescriptor = a.h(a.E(C2640s.f24719a)).getDescriptor();
    private static final f longArrayDescriptor = a.i().getDescriptor();
    private static final f stringArrayDescriptor;
    private static final f stringListDescriptor;

    static {
        Q q5 = Q.f24695a;
        stringListDescriptor = a.h(a.H(q5)).getDescriptor();
        stringArrayDescriptor = a.a(M.b(String.class), a.H(q5)).getDescriptor();
    }

    public static final f getBooleanArrayDescriptor() {
        return booleanArrayDescriptor;
    }

    public static final f getCharArrayDescriptor() {
        return charArrayDescriptor;
    }

    public static final f getDoubleArrayDescriptor() {
        return doubleArrayDescriptor;
    }

    public static final f getFloatArrayDescriptor() {
        return floatArrayDescriptor;
    }

    public static final f getIntArrayDescriptor() {
        return intArrayDescriptor;
    }

    public static final f getIntListDescriptor() {
        return intListDescriptor;
    }

    public static final f getLongArrayDescriptor() {
        return longArrayDescriptor;
    }

    public static final f getStringArrayDescriptor() {
        return stringArrayDescriptor;
    }

    public static /* synthetic */ void getStringArrayDescriptor$annotations() {
    }

    public static final f getStringListDescriptor() {
        return stringListDescriptor;
    }
}
