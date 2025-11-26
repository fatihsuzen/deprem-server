package e4;

import f4.d;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class Q implements Comparable {

    /* renamed from: b  reason: collision with root package name */
    public static final a f21501b = new a((C2633k) null);

    /* renamed from: c  reason: collision with root package name */
    public static final String f21502c;

    /* renamed from: a  reason: collision with root package name */
    private final C2359h f21503a;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public static /* synthetic */ Q d(a aVar, File file, boolean z4, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                z4 = false;
            }
            return aVar.a(file, z4);
        }

        public static /* synthetic */ Q e(a aVar, String str, boolean z4, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                z4 = false;
            }
            return aVar.b(str, z4);
        }

        public static /* synthetic */ Q f(a aVar, Path path, boolean z4, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                z4 = false;
            }
            return aVar.c(path, z4);
        }

        public final Q a(File file, boolean z4) {
            t.e(file, "<this>");
            String file2 = file.toString();
            t.d(file2, "toString()");
            return b(file2, z4);
        }

        public final Q b(String str, boolean z4) {
            t.e(str, "<this>");
            return d.k(str, z4);
        }

        public final Q c(Path path, boolean z4) {
            t.e(path, "<this>");
            return b(path.toString(), z4);
        }

        private a() {
        }
    }

    static {
        String str = File.separator;
        t.d(str, "separator");
        f21502c = str;
    }

    public Q(C2359h hVar) {
        t.e(hVar, "bytes");
        this.f21503a = hVar;
    }

    /* renamed from: a */
    public int compareTo(Q q5) {
        t.e(q5, "other");
        return b().compareTo(q5.b());
    }

    public final C2359h b() {
        return this.f21503a;
    }

    public final Q c() {
        int h5 = d.o(this);
        if (h5 == -1) {
            return null;
        }
        return new Q(b().H(0, h5));
    }

    public final List d() {
        ArrayList arrayList = new ArrayList();
        int h5 = d.o(this);
        if (h5 == -1) {
            h5 = 0;
        } else if (h5 < b().F() && b().h(h5) == 92) {
            h5++;
        }
        int F4 = b().F();
        int i5 = h5;
        while (h5 < F4) {
            if (b().h(h5) == 47 || b().h(h5) == 92) {
                arrayList.add(b().H(i5, h5));
                i5 = h5 + 1;
            }
            h5++;
        }
        if (i5 < b().F()) {
            arrayList.add(b().H(i5, b().F()));
        }
        return arrayList;
    }

    public final String e() {
        return f().L();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Q) || !t.a(((Q) obj).b(), b())) {
            return false;
        }
        return true;
    }

    public final C2359h f() {
        int d5 = d.l(this);
        if (d5 != -1) {
            return C2359h.I(b(), d5 + 1, 0, 2, (Object) null);
        }
        if (m() == null || b().F() != 2) {
            return b();
        }
        return C2359h.f21567e;
    }

    public final Q g() {
        return f21501b.b(toString(), true);
    }

    public final Q h() {
        if (t.a(b(), d.f21631d) || t.a(b(), d.f21628a) || t.a(b(), d.f21629b) || d.n(this)) {
            return null;
        }
        int d5 = d.l(this);
        if (d5 != 2 || m() == null) {
            if (d5 == 1 && b().G(d.f21629b)) {
                return null;
            }
            if (d5 != -1 || m() == null) {
                if (d5 == -1) {
                    return new Q(d.f21631d);
                }
                if (d5 == 0) {
                    return new Q(C2359h.I(b(), 0, 1, 1, (Object) null));
                }
                return new Q(C2359h.I(b(), 0, d5, 1, (Object) null));
            } else if (b().F() == 2) {
                return null;
            } else {
                return new Q(C2359h.I(b(), 0, 2, 1, (Object) null));
            }
        } else if (b().F() == 3) {
            return null;
        } else {
            return new Q(C2359h.I(b(), 0, 3, 1, (Object) null));
        }
    }

    public int hashCode() {
        return b().hashCode();
    }

    public final Q i(Q q5) {
        t.e(q5, "other");
        if (t.a(c(), q5.c())) {
            List d5 = d();
            List d6 = q5.d();
            int min = Math.min(d5.size(), d6.size());
            int i5 = 0;
            while (i5 < min && t.a(d5.get(i5), d6.get(i5))) {
                i5++;
            }
            if (i5 == min && b().F() == q5.b().F()) {
                return a.e(f21501b, ".", false, 1, (Object) null);
            }
            if (d6.subList(i5, d6.size()).indexOf(d.f21632e) == -1) {
                C2356e eVar = new C2356e();
                C2359h f5 = d.m(q5);
                if (f5 == null && (f5 = d.m(this)) == null) {
                    f5 = d.s(f21502c);
                }
                int size = d6.size();
                for (int i6 = i5; i6 < size; i6++) {
                    eVar.F(d.f21632e);
                    eVar.F(f5);
                }
                int size2 = d5.size();
                while (i5 < size2) {
                    eVar.F((C2359h) d5.get(i5));
                    eVar.F(f5);
                    i5++;
                }
                return d.q(eVar, false);
            }
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + q5).toString());
        }
        throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + q5).toString());
    }

    public final boolean isAbsolute() {
        if (d.o(this) != -1) {
            return true;
        }
        return false;
    }

    public final Q j(Q q5, boolean z4) {
        t.e(q5, "child");
        return d.j(this, q5, z4);
    }

    public final Q k(String str) {
        t.e(str, "child");
        return d.j(this, d.q(new C2356e().writeUtf8(str), false), false);
    }

    public final Path l() {
        Path a5 = Paths.get(toString(), new String[0]);
        t.d(a5, "get(toString())");
        return a5;
    }

    public final Character m() {
        if (C2359h.p(b(), d.f21628a, 0, 2, (Object) null) != -1 || b().F() < 2 || b().h(1) != 58) {
            return null;
        }
        char h5 = (char) b().h(0);
        if (('a' > h5 || h5 >= '{') && ('A' > h5 || h5 >= '[')) {
            return null;
        }
        return Character.valueOf(h5);
    }

    public final File toFile() {
        return new File(toString());
    }

    public String toString() {
        return b().L();
    }
}
