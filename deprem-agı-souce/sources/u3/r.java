package U3;

import V3.c;
import e4.C2356e;
import j$.util.DesugarCollections;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public final class r {

    /* renamed from: j  reason: collision with root package name */
    private static final char[] f19556j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a  reason: collision with root package name */
    final String f19557a;

    /* renamed from: b  reason: collision with root package name */
    private final String f19558b;

    /* renamed from: c  reason: collision with root package name */
    private final String f19559c;

    /* renamed from: d  reason: collision with root package name */
    final String f19560d;

    /* renamed from: e  reason: collision with root package name */
    final int f19561e;

    /* renamed from: f  reason: collision with root package name */
    private final List f19562f;

    /* renamed from: g  reason: collision with root package name */
    private final List f19563g;

    /* renamed from: h  reason: collision with root package name */
    private final String f19564h;

    /* renamed from: i  reason: collision with root package name */
    private final String f19565i;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        String f19566a;

        /* renamed from: b  reason: collision with root package name */
        String f19567b = "";

        /* renamed from: c  reason: collision with root package name */
        String f19568c = "";

        /* renamed from: d  reason: collision with root package name */
        String f19569d;

        /* renamed from: e  reason: collision with root package name */
        int f19570e = -1;

        /* renamed from: f  reason: collision with root package name */
        final List f19571f;

        /* renamed from: g  reason: collision with root package name */
        List f19572g;

        /* renamed from: h  reason: collision with root package name */
        String f19573h;

        /* renamed from: U3.r$a$a  reason: collision with other inner class name */
        enum C0182a {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f19571f = arrayList;
            arrayList.add("");
        }

        private static String b(String str, int i5, int i6) {
            return c.b(r.r(str, i5, i6, false));
        }

        private boolean f(String str) {
            if (str.equals(".") || str.equalsIgnoreCase("%2e")) {
                return true;
            }
            return false;
        }

        private boolean g(String str) {
            if (str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e")) {
                return true;
            }
            return false;
        }

        private static int i(String str, int i5, int i6) {
            try {
                int parseInt = Integer.parseInt(r.a(str, i5, i6, "", false, false, false, true, (Charset) null));
                if (parseInt <= 0 || parseInt > 65535) {
                    return -1;
                }
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }

        private void j() {
            List list = this.f19571f;
            if (!((String) list.remove(list.size() - 1)).isEmpty() || this.f19571f.isEmpty()) {
                this.f19571f.add("");
                return;
            }
            List list2 = this.f19571f;
            list2.set(list2.size() - 1, "");
        }

        private static int l(String str, int i5, int i6) {
            while (i5 < i6) {
                char charAt = str.charAt(i5);
                if (charAt == ':') {
                    return i5;
                }
                if (charAt == '[') {
                    do {
                        i5++;
                        if (i5 >= i6) {
                            break;
                        }
                    } while (str.charAt(i5) == ']');
                }
                i5++;
            }
            return i6;
        }

        private void m(String str, int i5, int i6, boolean z4, boolean z5) {
            String a5 = r.a(str, i5, i6, " \"<>^`{}|/\\?#", z5, false, false, true, (Charset) null);
            if (!f(a5)) {
                if (g(a5)) {
                    j();
                    return;
                }
                List list = this.f19571f;
                if (((String) list.get(list.size() - 1)).isEmpty()) {
                    List list2 = this.f19571f;
                    list2.set(list2.size() - 1, a5);
                } else {
                    this.f19571f.add(a5);
                }
                if (z4) {
                    this.f19571f.add("");
                }
            }
        }

        private void o(String str, int i5, int i6) {
            boolean z4;
            if (i5 != i6) {
                char charAt = str.charAt(i5);
                if (charAt == '/' || charAt == '\\') {
                    this.f19571f.clear();
                    this.f19571f.add("");
                    i5++;
                } else {
                    List list = this.f19571f;
                    list.set(list.size() - 1, "");
                }
                int i7 = i5;
                while (i7 < i6) {
                    int l5 = c.l(str, i7, i6, "/\\");
                    if (l5 < i6) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    String str2 = str;
                    m(str2, i7, l5, z4, true);
                    if (z4) {
                        l5++;
                    }
                    i7 = l5;
                    str = str2;
                }
            }
        }

        private static int q(String str, int i5, int i6) {
            if (i6 - i5 < 2) {
                return -1;
            }
            char charAt = str.charAt(i5);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i5++;
                    if (i5 >= i6) {
                        break;
                    }
                    char charAt2 = str.charAt(i5);
                    if ((charAt2 < 'a' || charAt2 > 'z') && ((charAt2 < 'A' || charAt2 > 'Z') && !((charAt2 >= '0' && charAt2 <= '9') || charAt2 == '+' || charAt2 == '-' || charAt2 == '.'))) {
                        if (charAt2 == ':') {
                            return i5;
                        }
                    }
                }
            }
            return -1;
        }

        private static int r(String str, int i5, int i6) {
            int i7 = 0;
            while (i5 < i6) {
                char charAt = str.charAt(i5);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i7++;
                i5++;
            }
            return i7;
        }

        public r a() {
            if (this.f19566a == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.f19569d != null) {
                return new r(this);
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        /* access modifiers changed from: package-private */
        public int c() {
            int i5 = this.f19570e;
            if (i5 != -1) {
                return i5;
            }
            return r.d(this.f19566a);
        }

        public a d(String str) {
            List list;
            if (str != null) {
                list = r.y(r.b(str, " \"'<>#", true, false, true, true));
            } else {
                list = null;
            }
            this.f19572g = list;
            return this;
        }

        public a e(String str) {
            if (str != null) {
                String b5 = b(str, 0, str.length());
                if (b5 != null) {
                    this.f19569d = b5;
                    return this;
                }
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            throw new NullPointerException("host == null");
        }

        /* access modifiers changed from: package-private */
        public C0182a h(r rVar, String str) {
            String str2;
            int l5;
            char c5;
            String str3;
            int i5;
            r rVar2 = rVar;
            String str4 = str;
            int z4 = c.z(str4, 0, str4.length());
            int A4 = c.A(str4, z4, str4.length());
            if (q(str4, z4, A4) != -1) {
                if (str4.regionMatches(true, z4, "https:", 0, 6)) {
                    this.f19566a = "https";
                    z4 += 6;
                    str4 = str;
                } else {
                    str4 = str;
                    if (!str4.regionMatches(true, z4, "http:", 0, 5)) {
                        return C0182a.UNSUPPORTED_SCHEME;
                    }
                    this.f19566a = "http";
                    z4 += 5;
                }
            } else if (rVar2 == null) {
                return C0182a.MISSING_SCHEME;
            } else {
                this.f19566a = rVar2.f19557a;
            }
            int r5 = r(str4, z4, A4);
            char c6 = '#';
            if (r5 >= 2 || rVar2 == null || !rVar2.f19557a.equals(this.f19566a)) {
                int i6 = z4 + r5;
                boolean z5 = false;
                boolean z6 = false;
                while (true) {
                    l5 = c.l(str4, i6, A4, "@/\\?#");
                    if (l5 != A4) {
                        c5 = str4.charAt(l5);
                    } else {
                        c5 = 65535;
                    }
                    if (c5 == 65535 || c5 == c6 || c5 == '/' || c5 == '\\' || c5 == '?') {
                        int i7 = l5;
                        str2 = str4;
                        int i8 = i6;
                        int l6 = l(str2, i8, i7);
                        int i9 = l6 + 1;
                    } else {
                        if (c5 != '@') {
                            str3 = str4;
                        } else {
                            if (!z5) {
                                int k5 = c.k(str4, i6, l5, ':');
                                int i10 = l5;
                                String str5 = "%40";
                                String a5 = r.a(str, i6, k5, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, (Charset) null);
                                if (z6) {
                                    a5 = this.f19567b + str5 + a5;
                                }
                                this.f19567b = a5;
                                if (k5 != i10) {
                                    int i11 = k5 + 1;
                                    i5 = i10;
                                    this.f19568c = r.a(str, i11, i5, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, (Charset) null);
                                    z5 = true;
                                } else {
                                    i5 = i10;
                                }
                                str3 = str;
                                z6 = true;
                            } else {
                                i5 = l5;
                                StringBuilder sb = new StringBuilder();
                                sb.append(this.f19568c);
                                sb.append("%40");
                                str3 = str;
                                sb.append(r.a(str3, i6, i5, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, (Charset) null));
                                this.f19568c = sb.toString();
                            }
                            i6 = i5 + 1;
                        }
                        str4 = str3;
                        c6 = '#';
                    }
                }
                int i72 = l5;
                str2 = str4;
                int i82 = i6;
                int l62 = l(str2, i82, i72);
                int i92 = l62 + 1;
                if (i92 < i72) {
                    this.f19569d = b(str2, i82, l62);
                    int i12 = i(str2, i92, i72);
                    this.f19570e = i12;
                    if (i12 == -1) {
                        return C0182a.INVALID_PORT;
                    }
                } else {
                    this.f19569d = b(str2, i82, l62);
                    this.f19570e = r.d(this.f19566a);
                }
                if (this.f19569d == null) {
                    return C0182a.INVALID_HOST;
                }
                z4 = i72;
            } else {
                this.f19567b = rVar2.j();
                this.f19568c = rVar2.f();
                this.f19569d = rVar2.f19560d;
                this.f19570e = rVar2.f19561e;
                this.f19571f.clear();
                this.f19571f.addAll(rVar2.h());
                if (z4 == A4 || str4.charAt(z4) == '#') {
                    d(rVar2.i());
                }
                str2 = str4;
            }
            int l7 = c.l(str2, z4, A4, "?#");
            o(str2, z4, l7);
            if (l7 < A4 && str2.charAt(l7) == '?') {
                int k6 = c.k(str2, l7, A4, '#');
                this.f19572g = r.y(r.a(str2, l7 + 1, k6, " \"'<>#", true, false, true, true, (Charset) null));
                l7 = k6;
            }
            if (l7 < A4 && str2.charAt(l7) == '#') {
                this.f19573h = r.a(str2, l7 + 1, A4, "", true, false, false, false, (Charset) null);
            }
            return C0182a.SUCCESS;
        }

        public a k(int i5) {
            if (i5 <= 0 || i5 > 65535) {
                throw new IllegalArgumentException("unexpected port: " + i5);
            }
            this.f19570e = i5;
            return this;
        }

        /* access modifiers changed from: package-private */
        public a n() {
            int size = this.f19571f.size();
            for (int i5 = 0; i5 < size; i5++) {
                this.f19571f.set(i5, r.b((String) this.f19571f.get(i5), "[]", true, true, false, true));
            }
            List list = this.f19572g;
            if (list != null) {
                int size2 = list.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    String str = (String) this.f19572g.get(i6);
                    if (str != null) {
                        this.f19572g.set(i6, r.b(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.f19573h;
            if (str2 != null) {
                this.f19573h = r.b(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public a p(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            } else if (str.equalsIgnoreCase("http")) {
                this.f19566a = "http";
                return this;
            } else if (str.equalsIgnoreCase("https")) {
                this.f19566a = "https";
                return this;
            } else {
                throw new IllegalArgumentException("unexpected scheme: " + str);
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f19566a);
            sb.append("://");
            if (!this.f19567b.isEmpty() || !this.f19568c.isEmpty()) {
                sb.append(this.f19567b);
                if (!this.f19568c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f19568c);
                }
                sb.append('@');
            }
            if (this.f19569d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.f19569d);
                sb.append(']');
            } else {
                sb.append(this.f19569d);
            }
            int c5 = c();
            if (c5 != r.d(this.f19566a)) {
                sb.append(':');
                sb.append(c5);
            }
            r.q(sb, this.f19571f);
            if (this.f19572g != null) {
                sb.append('?');
                r.m(sb, this.f19572g);
            }
            if (this.f19573h != null) {
                sb.append('#');
                sb.append(this.f19573h);
            }
            return sb.toString();
        }
    }

    r(a aVar) {
        List list;
        this.f19557a = aVar.f19566a;
        this.f19558b = s(aVar.f19567b, false);
        this.f19559c = s(aVar.f19568c, false);
        this.f19560d = aVar.f19569d;
        this.f19561e = aVar.c();
        this.f19562f = t(aVar.f19571f, false);
        List list2 = aVar.f19572g;
        String str = null;
        if (list2 != null) {
            list = t(list2, true);
        } else {
            list = null;
        }
        this.f19563g = list;
        String str2 = aVar.f19573h;
        this.f19564h = str2 != null ? s(str2, false) : str;
        this.f19565i = aVar.toString();
    }

    static String a(String str, int i5, int i6, String str2, boolean z4, boolean z5, boolean z6, boolean z7, Charset charset) {
        int i7 = i5;
        while (i7 < i6) {
            int codePointAt = str.codePointAt(i7);
            if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z7) || str2.indexOf(codePointAt) != -1 || ((codePointAt == 37 && (!z4 || (z5 && !v(str, i7, i6)))) || (codePointAt == 43 && z6)))) {
                C2356e eVar = new C2356e();
                eVar.Q(str, i5, i7);
                c(eVar, str, i7, i6, str2, z4, z5, z6, z7, charset);
                return eVar.readUtf8();
            }
            i7 += Character.charCount(codePointAt);
        }
        return str.substring(i5, i6);
    }

    static String b(String str, String str2, boolean z4, boolean z5, boolean z6, boolean z7) {
        return a(str, 0, str.length(), str2, z4, z5, z6, z7, (Charset) null);
    }

    static void c(C2356e eVar, String str, int i5, int i6, String str2, boolean z4, boolean z5, boolean z6, boolean z7, Charset charset) {
        String str3;
        C2356e eVar2 = null;
        while (i5 < i6) {
            int codePointAt = str.codePointAt(i5);
            if (!z4 || !(codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                if (codePointAt == 43 && z6) {
                    if (z4) {
                        str3 = "+";
                    } else {
                        str3 = "%2B";
                    }
                    eVar.writeUtf8(str3);
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z7) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z4 || (z5 && !v(str, i5, i6)))))) {
                    if (eVar2 == null) {
                        eVar2 = new C2356e();
                    }
                    if (charset == null || charset.equals(c.f19708j)) {
                        eVar2.R(codePointAt);
                    } else {
                        eVar2.O(str, i5, Character.charCount(codePointAt) + i5, charset);
                    }
                    while (!eVar2.exhausted()) {
                        byte readByte = eVar2.readByte();
                        eVar.writeByte(37);
                        char[] cArr = f19556j;
                        eVar.writeByte(cArr[((readByte & 255) >> 4) & 15]);
                        eVar.writeByte(cArr[readByte & 15]);
                    }
                } else {
                    eVar.R(codePointAt);
                }
            }
            i5 += Character.charCount(codePointAt);
        }
    }

    public static int d(String str) {
        if (str.equals("http")) {
            return 80;
        }
        if (str.equals("https")) {
            return 443;
        }
        return -1;
    }

    static void m(StringBuilder sb, List list) {
        int size = list.size();
        for (int i5 = 0; i5 < size; i5 += 2) {
            String str = (String) list.get(i5);
            String str2 = (String) list.get(i5 + 1);
            if (i5 > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    public static r p(String str) {
        a aVar = new a();
        if (aVar.h((r) null, str) == a.C0182a.SUCCESS) {
            return aVar.a();
        }
        return null;
    }

    static void q(StringBuilder sb, List list) {
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            sb.append('/');
            sb.append((String) list.get(i5));
        }
    }

    static String r(String str, int i5, int i6, boolean z4) {
        for (int i7 = i5; i7 < i6; i7++) {
            char charAt = str.charAt(i7);
            if (charAt == '%' || (charAt == '+' && z4)) {
                C2356e eVar = new C2356e();
                eVar.Q(str, i5, i7);
                u(eVar, str, i7, i6, z4);
                return eVar.readUtf8();
            }
        }
        return str.substring(i5, i6);
    }

    static String s(String str, boolean z4) {
        return r(str, 0, str.length(), z4);
    }

    private List t(List list, boolean z4) {
        String str;
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i5 = 0; i5 < size; i5++) {
            String str2 = (String) list.get(i5);
            if (str2 != null) {
                str = s(str2, z4);
            } else {
                str = null;
            }
            arrayList.add(str);
        }
        return DesugarCollections.unmodifiableList(arrayList);
    }

    static void u(C2356e eVar, String str, int i5, int i6, boolean z4) {
        int i7;
        while (i5 < i6) {
            int codePointAt = str.codePointAt(i5);
            if (codePointAt == 37 && (i7 = i5 + 2) < i6) {
                int h5 = c.h(str.charAt(i5 + 1));
                int h6 = c.h(str.charAt(i7));
                if (!(h5 == -1 || h6 == -1)) {
                    eVar.writeByte((h5 << 4) + h6);
                    i5 = i7;
                    i5 += Character.charCount(codePointAt);
                }
            } else if (codePointAt == 43 && z4) {
                eVar.writeByte(32);
                i5 += Character.charCount(codePointAt);
            }
            eVar.R(codePointAt);
            i5 += Character.charCount(codePointAt);
        }
    }

    static boolean v(String str, int i5, int i6) {
        int i7 = i5 + 2;
        if (i7 >= i6 || str.charAt(i5) != '%' || c.h(str.charAt(i5 + 1)) == -1 || c.h(str.charAt(i7)) == -1) {
            return false;
        }
        return true;
    }

    static List y(String str) {
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        while (i5 <= str.length()) {
            int indexOf = str.indexOf(38, i5);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i5);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i5, indexOf));
                arrayList.add((Object) null);
            } else {
                arrayList.add(str.substring(i5, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i5 = indexOf + 1;
        }
        return arrayList;
    }

    public String A() {
        return this.f19557a;
    }

    public URI B() {
        String aVar = n().n().toString();
        try {
            return new URI(aVar);
        } catch (URISyntaxException e5) {
            try {
                return URI.create(aVar.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e5);
            }
        }
    }

    public String e() {
        if (this.f19564h == null) {
            return null;
        }
        return this.f19565i.substring(this.f19565i.indexOf(35) + 1);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof r) || !((r) obj).f19565i.equals(this.f19565i)) {
            return false;
        }
        return true;
    }

    public String f() {
        if (this.f19559c.isEmpty()) {
            return "";
        }
        int indexOf = this.f19565i.indexOf(64);
        return this.f19565i.substring(this.f19565i.indexOf(58, this.f19557a.length() + 3) + 1, indexOf);
    }

    public String g() {
        int indexOf = this.f19565i.indexOf(47, this.f19557a.length() + 3);
        String str = this.f19565i;
        return this.f19565i.substring(indexOf, c.l(str, indexOf, str.length(), "?#"));
    }

    public List h() {
        int indexOf = this.f19565i.indexOf(47, this.f19557a.length() + 3);
        String str = this.f19565i;
        int l5 = c.l(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < l5) {
            int i5 = indexOf + 1;
            int k5 = c.k(this.f19565i, i5, l5, '/');
            arrayList.add(this.f19565i.substring(i5, k5));
            indexOf = k5;
        }
        return arrayList;
    }

    public int hashCode() {
        return this.f19565i.hashCode();
    }

    public String i() {
        if (this.f19563g == null) {
            return null;
        }
        int indexOf = this.f19565i.indexOf(63) + 1;
        String str = this.f19565i;
        return this.f19565i.substring(indexOf, c.k(str, indexOf, str.length(), '#'));
    }

    public String j() {
        if (this.f19558b.isEmpty()) {
            return "";
        }
        int length = this.f19557a.length() + 3;
        String str = this.f19565i;
        return this.f19565i.substring(length, c.l(str, length, str.length(), ":@"));
    }

    public String k() {
        return this.f19560d;
    }

    public boolean l() {
        return this.f19557a.equals("https");
    }

    public a n() {
        int i5;
        a aVar = new a();
        aVar.f19566a = this.f19557a;
        aVar.f19567b = j();
        aVar.f19568c = f();
        aVar.f19569d = this.f19560d;
        if (this.f19561e != d(this.f19557a)) {
            i5 = this.f19561e;
        } else {
            i5 = -1;
        }
        aVar.f19570e = i5;
        aVar.f19571f.clear();
        aVar.f19571f.addAll(h());
        aVar.d(i());
        aVar.f19573h = e();
        return aVar;
    }

    public a o(String str) {
        a aVar = new a();
        if (aVar.h(this, str) == a.C0182a.SUCCESS) {
            return aVar;
        }
        return null;
    }

    public String toString() {
        return this.f19565i;
    }

    public int w() {
        return this.f19561e;
    }

    public String x() {
        if (this.f19563g == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        m(sb, this.f19563g);
        return sb.toString();
    }

    public r z(String str) {
        a o5 = o(str);
        if (o5 != null) {
            return o5.a();
        }
        return null;
    }
}
