package x0;

import A0.F;
import java.io.File;

/* renamed from: x0.c  reason: case insensitive filesystem */
final class C1907c extends C1903A {

    /* renamed from: a  reason: collision with root package name */
    private final F f16850a;

    /* renamed from: b  reason: collision with root package name */
    private final String f16851b;

    /* renamed from: c  reason: collision with root package name */
    private final File f16852c;

    C1907c(F f5, String str, File file) {
        if (f5 != null) {
            this.f16850a = f5;
            if (str != null) {
                this.f16851b = str;
                if (file != null) {
                    this.f16852c = file;
                    return;
                }
                throw new NullPointerException("Null reportFile");
            }
            throw new NullPointerException("Null sessionId");
        }
        throw new NullPointerException("Null report");
    }

    public F b() {
        return this.f16850a;
    }

    public File c() {
        return this.f16852c;
    }

    public String d() {
        return this.f16851b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1903A) {
            C1903A a5 = (C1903A) obj;
            if (!this.f16850a.equals(a5.b()) || !this.f16851b.equals(a5.d()) || !this.f16852c.equals(a5.c())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f16850a.hashCode() ^ 1000003) * 1000003) ^ this.f16851b.hashCode()) * 1000003) ^ this.f16852c.hashCode();
    }

    public String toString() {
        return "CrashlyticsReportWithSessionId{report=" + this.f16850a + ", sessionId=" + this.f16851b + ", reportFile=" + this.f16852c + "}";
    }
}
