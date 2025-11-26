package l2;

import android.content.Context;
import androidx.collection.a;
import d3.C2345b;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import z2.C2940B;

/* renamed from: l2.a  reason: case insensitive filesystem */
public final class C2652a {

    /* renamed from: f  reason: collision with root package name */
    public static final C0250a f24934f = new C0250a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f24935a;

    /* renamed from: b  reason: collision with root package name */
    private final long f24936b;

    /* renamed from: c  reason: collision with root package name */
    private int f24937c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f24938d = -1;

    /* renamed from: e  reason: collision with root package name */
    private b f24939e = b.DOWNLOADED;

    /* renamed from: l2.a$a  reason: collision with other inner class name */
    public static final class C0250a {
        public /* synthetic */ C0250a(C2633k kVar) {
            this();
        }

        public final b a(int i5) {
            b bVar = b.DOWNLOADED;
            if (i5 == bVar.ordinal()) {
                return bVar;
            }
            b bVar2 = b.INSTALLED;
            if (i5 == bVar2.ordinal()) {
                return bVar2;
            }
            throw new IllegalArgumentException();
        }

        private C0250a() {
        }
    }

    /* renamed from: l2.a$b */
    public enum b {
        DOWNLOADED,
        INSTALLED;

        static {
            b[] a5;
            f24943d = C2345b.a(a5);
        }
    }

    public C2652a(String str, long j5) {
        t.e(str, "packageName");
        this.f24935a = str;
        this.f24936b = j5;
    }

    public final int a() {
        return this.f24938d;
    }

    public final int b() {
        return this.f24937c;
    }

    public final String c() {
        return this.f24935a;
    }

    public final b d() {
        return this.f24939e;
    }

    public final long e() {
        return this.f24936b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2652a)) {
            return false;
        }
        C2652a aVar = (C2652a) obj;
        if (t.a(this.f24935a, aVar.f24935a) && this.f24936b == aVar.f24936b) {
            return true;
        }
        return false;
    }

    public final C2652a f(Context context) {
        C2652a aVar;
        t.e(context, "context");
        C2940B a5 = C2940B.f26458v.a(context);
        a5.a();
        int i5 = this.f24938d;
        if (i5 != -1) {
            aVar = a5.U(i5);
        } else {
            int i6 = this.f24937c;
            if (i6 != -1) {
                aVar = a5.W(i6);
            } else {
                aVar = a5.V(this.f24935a, this.f24936b);
            }
        }
        a5.m();
        return aVar;
    }

    public final void g(Context context) {
        C2652a aVar;
        t.e(context, "context");
        C2940B a5 = C2940B.f26458v.a(context);
        a5.a();
        int i5 = this.f24938d;
        if (i5 != -1) {
            aVar = a5.U(i5);
        } else {
            int i6 = this.f24937c;
            if (i6 != -1) {
                aVar = a5.W(i6);
            } else {
                aVar = a5.V(this.f24935a, this.f24936b);
            }
        }
        if (aVar != null) {
            a5.x1(this);
        } else {
            a5.K0(this);
        }
        a5.m();
    }

    public final void h(int i5) {
        this.f24938d = i5;
    }

    public int hashCode() {
        return (this.f24935a.hashCode() * 31) + a.a(this.f24936b);
    }

    public final void i(int i5) {
        this.f24937c = i5;
    }

    public final void j(b bVar) {
        t.e(bVar, "<set-?>");
        this.f24939e = bVar;
    }

    public String toString() {
        return "ActiveNotification(packageName=" + this.f24935a + ", versionCode=" + this.f24936b + ')';
    }
}
