package q3;

import kotlin.jvm.internal.C2633k;

/* renamed from: q3.d  reason: case insensitive filesystem */
public final class C2728d extends C2726b implements C2725a {

    /* renamed from: e  reason: collision with root package name */
    public static final a f25698e = new a((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final C2728d f25699f = new C2728d(1, 0);

    /* renamed from: q3.d$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final C2728d a() {
            return C2728d.f25699f;
        }

        private a() {
        }
    }

    public C2728d(int i5, int i6) {
        super(i5, i6, 1);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2728d)) {
            return false;
        }
        if (isEmpty() && ((C2728d) obj).isEmpty()) {
            return true;
        }
        C2728d dVar = (C2728d) obj;
        if (c() == dVar.c() && f() == dVar.f()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (c() * 31) + f();
    }

    public boolean isEmpty() {
        if (c() > f()) {
            return true;
        }
        return false;
    }

    public boolean k(int i5) {
        if (c() > i5 || i5 > f()) {
            return false;
        }
        return true;
    }

    /* renamed from: l */
    public Integer getEndInclusive() {
        return Integer.valueOf(f());
    }

    /* renamed from: n */
    public Integer getStart() {
        return Integer.valueOf(c());
    }

    public String toString() {
        return c() + ".." + f();
    }
}
