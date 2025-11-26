package Y1;

import kotlin.jvm.internal.t;

/* renamed from: Y1.c  reason: case insensitive filesystem */
public final class C2259c {

    /* renamed from: a  reason: collision with root package name */
    private long f20127a;

    /* renamed from: b  reason: collision with root package name */
    private int f20128b;

    /* renamed from: c  reason: collision with root package name */
    private String f20129c;

    public final String a() {
        return this.f20129c;
    }

    public final int b() {
        return this.f20128b;
    }

    public final void c(String str, int i5) {
        t.e(str, "filePath");
        this.f20129c = str;
        this.f20128b = i5;
        this.f20127a = System.currentTimeMillis();
    }

    public final void d(int i5) {
        this.f20128b = i5;
    }
}
