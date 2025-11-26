package v3;

import W2.D;
import androidx.collection.a;
import java.io.Serializable;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import t3.s;

/* renamed from: v3.a  reason: case insensitive filesystem */
public final class C2803a implements Comparable, Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final C0263a f26045c = new C0263a((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final C2803a f26046d = new C2803a(0, 0);

    /* renamed from: a  reason: collision with root package name */
    private final long f26047a;

    /* renamed from: b  reason: collision with root package name */
    private final long f26048b;

    /* renamed from: v3.a$a  reason: collision with other inner class name */
    public static final class C0263a {
        public /* synthetic */ C0263a(C2633k kVar) {
            this();
        }

        public final C2803a a(long j5, long j6) {
            if (j5 == 0 && j6 == 0) {
                return b();
            }
            return new C2803a(j5, j6, (C2633k) null);
        }

        public final C2803a b() {
            return C2803a.f26046d;
        }

        public final C2803a c(String str) {
            t.e(str, "uuidString");
            int length = str.length();
            if (length == 32) {
                return C2804b.b(str);
            }
            if (length == 36) {
                return C2804b.c(str);
            }
            throw new IllegalArgumentException("Expected either a 36-char string in the standard hex-and-dash UUID format or a 32-char hexadecimal string, but was \"" + C2805c.g(str, 64) + "\" of length " + str.length());
        }

        private C0263a() {
        }
    }

    public /* synthetic */ C2803a(long j5, long j6, C2633k kVar) {
        this(j5, j6);
    }

    /* renamed from: b */
    public int compareTo(C2803a aVar) {
        t.e(aVar, "other");
        long j5 = this.f26047a;
        if (j5 != aVar.f26047a) {
            return Long.compare(D.b(j5) ^ Long.MIN_VALUE, D.b(aVar.f26047a) ^ Long.MIN_VALUE);
        }
        return Long.compare(D.b(this.f26048b) ^ Long.MIN_VALUE, D.b(aVar.f26048b) ^ Long.MIN_VALUE);
    }

    public final String c() {
        byte[] bArr = new byte[36];
        C2804b.a(this.f26047a, bArr, 0, 0, 4);
        bArr[8] = 45;
        C2804b.a(this.f26047a, bArr, 9, 4, 6);
        bArr[13] = 45;
        C2804b.a(this.f26047a, bArr, 14, 6, 8);
        bArr[18] = 45;
        C2804b.a(this.f26048b, bArr, 19, 0, 2);
        bArr[23] = 45;
        C2804b.a(this.f26048b, bArr, 24, 2, 8);
        return s.A(bArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2803a)) {
            return false;
        }
        C2803a aVar = (C2803a) obj;
        if (this.f26047a == aVar.f26047a && this.f26048b == aVar.f26048b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return a.a(this.f26047a ^ this.f26048b);
    }

    public String toString() {
        return c();
    }

    private C2803a(long j5, long j6) {
        this.f26047a = j5;
        this.f26048b = j6;
    }
}
