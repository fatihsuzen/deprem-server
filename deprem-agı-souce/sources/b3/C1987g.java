package B3;

import b3.C2312i;

/* renamed from: B3.g  reason: case insensitive filesystem */
public final class C1987g extends RuntimeException {

    /* renamed from: a  reason: collision with root package name */
    private final transient C2312i f17392a;

    public C1987g(C2312i iVar) {
        this.f17392a = iVar;
    }

    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public String getLocalizedMessage() {
        return this.f17392a.toString();
    }
}
