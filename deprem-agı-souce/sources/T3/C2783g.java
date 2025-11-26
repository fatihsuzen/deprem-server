package t3;

import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

/* renamed from: t3.g  reason: case insensitive filesystem */
public final class C2783g {

    /* renamed from: d  reason: collision with root package name */
    public static final b f25908d = new b((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final C2783g f25909e;

    /* renamed from: f  reason: collision with root package name */
    private static final C2783g f25910f;

    /* renamed from: a  reason: collision with root package name */
    private final boolean f25911a;

    /* renamed from: b  reason: collision with root package name */
    private final a f25912b;

    /* renamed from: c  reason: collision with root package name */
    private final c f25913c;

    /* renamed from: t3.g$a */
    public static final class a {

        /* renamed from: j  reason: collision with root package name */
        public static final C0261a f25914j = new C0261a((C2633k) null);
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public static final a f25915k = new a(Integer.MAX_VALUE, Integer.MAX_VALUE, "  ", "", "", "");

        /* renamed from: a  reason: collision with root package name */
        private final int f25916a;

        /* renamed from: b  reason: collision with root package name */
        private final int f25917b;

        /* renamed from: c  reason: collision with root package name */
        private final String f25918c;

        /* renamed from: d  reason: collision with root package name */
        private final String f25919d;

        /* renamed from: e  reason: collision with root package name */
        private final String f25920e;

        /* renamed from: f  reason: collision with root package name */
        private final String f25921f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f25922g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f25923h;

        /* renamed from: i  reason: collision with root package name */
        private final boolean f25924i;

        /* renamed from: t3.g$a$a  reason: collision with other inner class name */
        public static final class C0261a {
            public /* synthetic */ C0261a(C2633k kVar) {
                this();
            }

            public final a a() {
                return a.f25915k;
            }

            private C0261a() {
            }
        }

        public a(int i5, int i6, String str, String str2, String str3, String str4) {
            boolean z4;
            boolean z5;
            t.e(str, "groupSeparator");
            t.e(str2, "byteSeparator");
            t.e(str3, "bytePrefix");
            t.e(str4, "byteSuffix");
            this.f25916a = i5;
            this.f25917b = i6;
            this.f25918c = str;
            this.f25919d = str2;
            this.f25920e = str3;
            this.f25921f = str4;
            boolean z6 = false;
            if (i5 == Integer.MAX_VALUE && i6 == Integer.MAX_VALUE) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.f25922g = z4;
            if (str3.length() == 0 && str4.length() == 0 && str2.length() <= 1) {
                z5 = true;
            } else {
                z5 = false;
            }
            this.f25923h = z5;
            this.f25924i = (C2784h.b(str) || C2784h.b(str2) || C2784h.b(str3) || C2784h.b(str4)) ? true : z6;
        }

        public final StringBuilder b(StringBuilder sb, String str) {
            t.e(sb, "sb");
            t.e(str, "indent");
            sb.append(str);
            sb.append("bytesPerLine = ");
            sb.append(this.f25916a);
            sb.append(",");
            sb.append(10);
            sb.append(str);
            sb.append("bytesPerGroup = ");
            sb.append(this.f25917b);
            sb.append(",");
            sb.append(10);
            sb.append(str);
            sb.append("groupSeparator = \"");
            sb.append(this.f25918c);
            sb.append("\",");
            sb.append(10);
            sb.append(str);
            sb.append("byteSeparator = \"");
            sb.append(this.f25919d);
            sb.append("\",");
            sb.append(10);
            sb.append(str);
            sb.append("bytePrefix = \"");
            sb.append(this.f25920e);
            sb.append("\",");
            sb.append(10);
            sb.append(str);
            sb.append("byteSuffix = \"");
            sb.append(this.f25921f);
            sb.append("\"");
            return sb;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("BytesHexFormat(");
            sb.append(10);
            b(sb, "    ").append(10);
            sb.append(")");
            return sb.toString();
        }
    }

    /* renamed from: t3.g$b */
    public static final class b {
        public /* synthetic */ b(C2633k kVar) {
            this();
        }

        public final C2783g a() {
            return C2783g.f25909e;
        }

        private b() {
        }
    }

    /* renamed from: t3.g$c */
    public static final class c {

        /* renamed from: h  reason: collision with root package name */
        public static final a f25925h = new a((C2633k) null);
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public static final c f25926i = new c("", "", false, 1);

        /* renamed from: a  reason: collision with root package name */
        private final String f25927a;

        /* renamed from: b  reason: collision with root package name */
        private final String f25928b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f25929c;

        /* renamed from: d  reason: collision with root package name */
        private final int f25930d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f25931e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f25932f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f25933g;

        /* renamed from: t3.g$c$a */
        public static final class a {
            public /* synthetic */ a(C2633k kVar) {
                this();
            }

            public final c a() {
                return c.f25926i;
            }

            private a() {
            }
        }

        public c(String str, String str2, boolean z4, int i5) {
            boolean z5;
            boolean z6;
            t.e(str, "prefix");
            t.e(str2, "suffix");
            this.f25927a = str;
            this.f25928b = str2;
            this.f25929c = z4;
            this.f25930d = i5;
            boolean z7 = false;
            if (str.length() == 0 && str2.length() == 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            this.f25931e = z5;
            if (!z5 || i5 != 1) {
                z6 = false;
            } else {
                z6 = true;
            }
            this.f25932f = z6;
            this.f25933g = (C2784h.b(str) || C2784h.b(str2)) ? true : z7;
        }

        public final StringBuilder b(StringBuilder sb, String str) {
            t.e(sb, "sb");
            t.e(str, "indent");
            sb.append(str);
            sb.append("prefix = \"");
            sb.append(this.f25927a);
            sb.append("\",");
            sb.append(10);
            sb.append(str);
            sb.append("suffix = \"");
            sb.append(this.f25928b);
            sb.append("\",");
            sb.append(10);
            sb.append(str);
            sb.append("removeLeadingZeros = ");
            sb.append(this.f25929c);
            sb.append(',');
            sb.append(10);
            sb.append(str);
            sb.append("minLength = ");
            sb.append(this.f25930d);
            return sb;
        }

        public final boolean c() {
            return this.f25933g;
        }

        public final String d() {
            return this.f25927a;
        }

        public final String e() {
            return this.f25928b;
        }

        public final boolean f() {
            return this.f25931e;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("NumberHexFormat(");
            sb.append(10);
            b(sb, "    ").append(10);
            sb.append(")");
            return sb.toString();
        }
    }

    static {
        a.C0261a aVar = a.f25914j;
        a a5 = aVar.a();
        c.a aVar2 = c.f25925h;
        f25909e = new C2783g(false, a5, aVar2.a());
        f25910f = new C2783g(true, aVar.a(), aVar2.a());
    }

    public C2783g(boolean z4, a aVar, c cVar) {
        t.e(aVar, "bytes");
        t.e(cVar, "number");
        this.f25911a = z4;
        this.f25912b = aVar;
        this.f25913c = cVar;
    }

    public final c b() {
        return this.f25913c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HexFormat(");
        sb.append(10);
        sb.append("    upperCase = ");
        sb.append(this.f25911a);
        sb.append(",");
        sb.append(10);
        sb.append("    bytes = BytesHexFormat(");
        sb.append(10);
        this.f25912b.b(sb, "        ").append(10);
        sb.append("    ),");
        sb.append(10);
        sb.append("    number = NumberHexFormat(");
        sb.append(10);
        this.f25913c.b(sb, "        ").append(10);
        sb.append("    )");
        sb.append(10);
        sb.append(")");
        return sb.toString();
    }
}
