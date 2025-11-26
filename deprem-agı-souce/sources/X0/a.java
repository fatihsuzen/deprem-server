package X0;

public final class a {

    /* renamed from: p  reason: collision with root package name */
    private static final a f4430p = new C0063a().a();

    /* renamed from: a  reason: collision with root package name */
    private final long f4431a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4432b;

    /* renamed from: c  reason: collision with root package name */
    private final String f4433c;

    /* renamed from: d  reason: collision with root package name */
    private final c f4434d;

    /* renamed from: e  reason: collision with root package name */
    private final d f4435e;

    /* renamed from: f  reason: collision with root package name */
    private final String f4436f;

    /* renamed from: g  reason: collision with root package name */
    private final String f4437g;

    /* renamed from: h  reason: collision with root package name */
    private final int f4438h;

    /* renamed from: i  reason: collision with root package name */
    private final int f4439i;

    /* renamed from: j  reason: collision with root package name */
    private final String f4440j;

    /* renamed from: k  reason: collision with root package name */
    private final long f4441k;

    /* renamed from: l  reason: collision with root package name */
    private final b f4442l;

    /* renamed from: m  reason: collision with root package name */
    private final String f4443m;

    /* renamed from: n  reason: collision with root package name */
    private final long f4444n;

    /* renamed from: o  reason: collision with root package name */
    private final String f4445o;

    /* renamed from: X0.a$a  reason: collision with other inner class name */
    public static final class C0063a {

        /* renamed from: a  reason: collision with root package name */
        private long f4446a = 0;

        /* renamed from: b  reason: collision with root package name */
        private String f4447b = "";

        /* renamed from: c  reason: collision with root package name */
        private String f4448c = "";

        /* renamed from: d  reason: collision with root package name */
        private c f4449d = c.UNKNOWN;

        /* renamed from: e  reason: collision with root package name */
        private d f4450e = d.UNKNOWN_OS;

        /* renamed from: f  reason: collision with root package name */
        private String f4451f = "";

        /* renamed from: g  reason: collision with root package name */
        private String f4452g = "";

        /* renamed from: h  reason: collision with root package name */
        private int f4453h = 0;

        /* renamed from: i  reason: collision with root package name */
        private int f4454i = 0;

        /* renamed from: j  reason: collision with root package name */
        private String f4455j = "";

        /* renamed from: k  reason: collision with root package name */
        private long f4456k = 0;

        /* renamed from: l  reason: collision with root package name */
        private b f4457l = b.UNKNOWN_EVENT;

        /* renamed from: m  reason: collision with root package name */
        private String f4458m = "";

        /* renamed from: n  reason: collision with root package name */
        private long f4459n = 0;

        /* renamed from: o  reason: collision with root package name */
        private String f4460o = "";

        C0063a() {
        }

        public a a() {
            long j5 = this.f4446a;
            String str = this.f4447b;
            String str2 = this.f4448c;
            c cVar = this.f4449d;
            d dVar = this.f4450e;
            String str3 = this.f4451f;
            String str4 = this.f4452g;
            int i5 = this.f4453h;
            int i6 = this.f4454i;
            String str5 = this.f4455j;
            long j6 = this.f4456k;
            b bVar = this.f4457l;
            String str6 = this.f4458m;
            return new a(j5, str, str2, cVar, dVar, str3, str4, i5, i6, str5, j6, bVar, str6, this.f4459n, this.f4460o);
        }

        public C0063a b(String str) {
            this.f4458m = str;
            return this;
        }

        public C0063a c(String str) {
            this.f4452g = str;
            return this;
        }

        public C0063a d(String str) {
            this.f4460o = str;
            return this;
        }

        public C0063a e(b bVar) {
            this.f4457l = bVar;
            return this;
        }

        public C0063a f(String str) {
            this.f4448c = str;
            return this;
        }

        public C0063a g(String str) {
            this.f4447b = str;
            return this;
        }

        public C0063a h(c cVar) {
            this.f4449d = cVar;
            return this;
        }

        public C0063a i(String str) {
            this.f4451f = str;
            return this;
        }

        public C0063a j(int i5) {
            this.f4453h = i5;
            return this;
        }

        public C0063a k(long j5) {
            this.f4446a = j5;
            return this;
        }

        public C0063a l(d dVar) {
            this.f4450e = dVar;
            return this;
        }

        public C0063a m(String str) {
            this.f4455j = str;
            return this;
        }

        public C0063a n(int i5) {
            this.f4454i = i5;
            return this;
        }
    }

    public enum b implements N0.c {
        UNKNOWN_EVENT(0),
        MESSAGE_DELIVERED(1),
        MESSAGE_OPEN(2);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f4465a;

        private b(int i5) {
            this.f4465a = i5;
        }

        public int getNumber() {
            return this.f4465a;
        }
    }

    public enum c implements N0.c {
        UNKNOWN(0),
        DATA_MESSAGE(1),
        TOPIC(2),
        DISPLAY_NOTIFICATION(3);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f4471a;

        private c(int i5) {
            this.f4471a = i5;
        }

        public int getNumber() {
            return this.f4471a;
        }
    }

    public enum d implements N0.c {
        UNKNOWN_OS(0),
        ANDROID(1),
        IOS(2),
        WEB(3);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f4477a;

        private d(int i5) {
            this.f4477a = i5;
        }

        public int getNumber() {
            return this.f4477a;
        }
    }

    a(long j5, String str, String str2, c cVar, d dVar, String str3, String str4, int i5, int i6, String str5, long j6, b bVar, String str6, long j7, String str7) {
        this.f4431a = j5;
        this.f4432b = str;
        this.f4433c = str2;
        this.f4434d = cVar;
        this.f4435e = dVar;
        this.f4436f = str3;
        this.f4437g = str4;
        this.f4438h = i5;
        this.f4439i = i6;
        this.f4440j = str5;
        this.f4441k = j6;
        this.f4442l = bVar;
        this.f4443m = str6;
        this.f4444n = j7;
        this.f4445o = str7;
    }

    public static C0063a p() {
        return new C0063a();
    }

    public String a() {
        return this.f4443m;
    }

    public long b() {
        return this.f4441k;
    }

    public long c() {
        return this.f4444n;
    }

    public String d() {
        return this.f4437g;
    }

    public String e() {
        return this.f4445o;
    }

    public b f() {
        return this.f4442l;
    }

    public String g() {
        return this.f4433c;
    }

    public String h() {
        return this.f4432b;
    }

    public c i() {
        return this.f4434d;
    }

    public String j() {
        return this.f4436f;
    }

    public int k() {
        return this.f4438h;
    }

    public long l() {
        return this.f4431a;
    }

    public d m() {
        return this.f4435e;
    }

    public String n() {
        return this.f4440j;
    }

    public int o() {
        return this.f4439i;
    }
}
