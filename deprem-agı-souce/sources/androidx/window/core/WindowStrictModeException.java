package androidx.window.core;

import kotlin.jvm.internal.t;

public final class WindowStrictModeException extends Exception {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WindowStrictModeException(String str) {
        super(str);
        t.e(str, "message");
    }
}
