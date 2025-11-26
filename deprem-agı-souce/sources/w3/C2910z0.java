package w3;

import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.t;

/* renamed from: w3.z0  reason: case insensitive filesystem */
public final class C2910z0 extends CancellationException {

    /* renamed from: a  reason: collision with root package name */
    public final transient C2908y0 f26327a;

    public C2910z0(String str, Throwable th, C2908y0 y0Var) {
        super(str);
        this.f26327a = y0Var;
        if (th != null) {
            initCause(th);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2910z0)) {
            return false;
        }
        C2910z0 z0Var = (C2910z0) obj;
        if (!t.a(z0Var.getMessage(), getMessage()) || !t.a(z0Var.f26327a, this.f26327a) || !t.a(z0Var.getCause(), getCause())) {
            return false;
        }
        return true;
    }

    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        int i5;
        String message = getMessage();
        t.b(message);
        int hashCode = ((message.hashCode() * 31) + this.f26327a.hashCode()) * 31;
        Throwable cause = getCause();
        if (cause != null) {
            i5 = cause.hashCode();
        } else {
            i5 = 0;
        }
        return hashCode + i5;
    }

    public String toString() {
        return super.toString() + "; job=" + this.f26327a;
    }
}
