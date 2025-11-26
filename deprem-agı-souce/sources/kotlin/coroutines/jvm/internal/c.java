package kotlin.coroutines.jvm.internal;

import b3.C2308e;
import b3.C2312i;

public final class c implements C2308e {

    /* renamed from: a  reason: collision with root package name */
    public static final c f24678a = new c();

    private c() {
    }

    public C2312i getContext() {
        throw new IllegalStateException("This continuation is already complete");
    }

    public void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete");
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
