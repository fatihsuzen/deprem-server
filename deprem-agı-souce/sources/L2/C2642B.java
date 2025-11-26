package l2;

import android.content.Context;
import android.database.Cursor;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import z2.C2940B;

/* renamed from: l2.B  reason: case insensitive filesystem */
public final class C2642B {

    /* renamed from: g  reason: collision with root package name */
    public static final a f24727g = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private int f24728a = -1;

    /* renamed from: b  reason: collision with root package name */
    private String f24729b;

    /* renamed from: c  reason: collision with root package name */
    private String f24730c;

    /* renamed from: d  reason: collision with root package name */
    private String f24731d;

    /* renamed from: e  reason: collision with root package name */
    private String f24732e;

    /* renamed from: f  reason: collision with root package name */
    private String f24733f;

    /* renamed from: l2.B$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final C2642B a(Context context) {
            t.e(context, "context");
            C2940B a5 = C2940B.f26458v.a(context);
            a5.a();
            C2642B t02 = a5.t0();
            a5.m();
            return t02;
        }

        private a() {
        }
    }

    public final String a() {
        return this.f24732e;
    }

    public final String b() {
        return this.f24733f;
    }

    public final int c() {
        return this.f24728a;
    }

    public final String d() {
        return this.f24731d;
    }

    public final String e() {
        return this.f24729b;
    }

    public final String f() {
        return this.f24730c;
    }

    public final void g(Cursor cursor) {
        t.e(cursor, "c");
        this.f24728a = cursor.getInt(0);
        this.f24729b = cursor.getString(1);
        this.f24730c = cursor.getString(2);
        this.f24731d = cursor.getString(3);
        this.f24732e = cursor.getString(4);
        this.f24733f = cursor.getString(5);
    }

    public final void h(Context context) {
        t.e(context, "context");
        C2940B a5 = C2940B.f26458v.a(context);
        a5.a();
        a5.W0(this);
        if (a5.n() > 100) {
            a5.K(100);
        }
        a5.m();
    }

    public final void i(String str) {
        this.f24732e = str;
    }

    public final void j(String str) {
        this.f24733f = str;
    }

    public final void k(String str) {
        this.f24731d = str;
    }

    public final void l(String str) {
        this.f24729b = str;
    }

    public final void m(String str) {
        this.f24730c = str;
    }

    public String toString() {
        return "{id=" + this.f24728a + ", timestamp=" + this.f24729b + ", title='" + this.f24730c + "', msg='" + this.f24731d + "', actions='" + this.f24732e + "', extraInfo='" + this.f24733f + "'}";
    }
}
