package r;

import java.util.Arrays;
import java.util.Map;
import r.i;

/* renamed from: r.b  reason: case insensitive filesystem */
final class C1781b extends i {

    /* renamed from: a  reason: collision with root package name */
    private final String f16235a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer f16236b;

    /* renamed from: c  reason: collision with root package name */
    private final h f16237c;

    /* renamed from: d  reason: collision with root package name */
    private final long f16238d;

    /* renamed from: e  reason: collision with root package name */
    private final long f16239e;

    /* renamed from: f  reason: collision with root package name */
    private final Map f16240f;

    /* renamed from: g  reason: collision with root package name */
    private final Integer f16241g;

    /* renamed from: h  reason: collision with root package name */
    private final String f16242h;

    /* renamed from: i  reason: collision with root package name */
    private final byte[] f16243i;

    /* renamed from: j  reason: collision with root package name */
    private final byte[] f16244j;

    /* renamed from: r.b$b  reason: collision with other inner class name */
    static final class C0162b extends i.a {

        /* renamed from: a  reason: collision with root package name */
        private String f16245a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f16246b;

        /* renamed from: c  reason: collision with root package name */
        private h f16247c;

        /* renamed from: d  reason: collision with root package name */
        private Long f16248d;

        /* renamed from: e  reason: collision with root package name */
        private Long f16249e;

        /* renamed from: f  reason: collision with root package name */
        private Map f16250f;

        /* renamed from: g  reason: collision with root package name */
        private Integer f16251g;

        /* renamed from: h  reason: collision with root package name */
        private String f16252h;

        /* renamed from: i  reason: collision with root package name */
        private byte[] f16253i;

        /* renamed from: j  reason: collision with root package name */
        private byte[] f16254j;

        C0162b() {
        }

        public i d() {
            String str = "";
            if (this.f16245a == null) {
                str = str + " transportName";
            }
            if (this.f16247c == null) {
                str = str + " encodedPayload";
            }
            if (this.f16248d == null) {
                str = str + " eventMillis";
            }
            if (this.f16249e == null) {
                str = str + " uptimeMillis";
            }
            if (this.f16250f == null) {
                str = str + " autoMetadata";
            }
            if (str.isEmpty()) {
                return new C1781b(this.f16245a, this.f16246b, this.f16247c, this.f16248d.longValue(), this.f16249e.longValue(), this.f16250f, this.f16251g, this.f16252h, this.f16253i, this.f16254j);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        /* access modifiers changed from: protected */
        public Map e() {
            Map map = this.f16250f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        /* access modifiers changed from: protected */
        public i.a f(Map map) {
            if (map != null) {
                this.f16250f = map;
                return this;
            }
            throw new NullPointerException("Null autoMetadata");
        }

        public i.a g(Integer num) {
            this.f16246b = num;
            return this;
        }

        public i.a h(h hVar) {
            if (hVar != null) {
                this.f16247c = hVar;
                return this;
            }
            throw new NullPointerException("Null encodedPayload");
        }

        public i.a i(long j5) {
            this.f16248d = Long.valueOf(j5);
            return this;
        }

        public i.a j(byte[] bArr) {
            this.f16253i = bArr;
            return this;
        }

        public i.a k(byte[] bArr) {
            this.f16254j = bArr;
            return this;
        }

        public i.a l(Integer num) {
            this.f16251g = num;
            return this;
        }

        public i.a m(String str) {
            this.f16252h = str;
            return this;
        }

        public i.a n(String str) {
            if (str != null) {
                this.f16245a = str;
                return this;
            }
            throw new NullPointerException("Null transportName");
        }

        public i.a o(long j5) {
            this.f16249e = Long.valueOf(j5);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public Map c() {
        return this.f16240f;
    }

    public Integer d() {
        return this.f16236b;
    }

    public h e() {
        return this.f16237c;
    }

    public boolean equals(Object obj) {
        Integer num;
        Integer num2;
        String str;
        byte[] bArr;
        byte[] bArr2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (this.f16235a.equals(iVar.n()) && ((num = this.f16236b) != null ? num.equals(iVar.d()) : iVar.d() == null) && this.f16237c.equals(iVar.e()) && this.f16238d == iVar.f() && this.f16239e == iVar.o() && this.f16240f.equals(iVar.c()) && ((num2 = this.f16241g) != null ? num2.equals(iVar.l()) : iVar.l() == null) && ((str = this.f16242h) != null ? str.equals(iVar.m()) : iVar.m() == null)) {
                byte[] bArr3 = this.f16243i;
                boolean z4 = iVar instanceof C1781b;
                if (z4) {
                    bArr = ((C1781b) iVar).f16243i;
                } else {
                    bArr = iVar.g();
                }
                if (Arrays.equals(bArr3, bArr)) {
                    byte[] bArr4 = this.f16244j;
                    if (z4) {
                        bArr2 = ((C1781b) iVar).f16244j;
                    } else {
                        bArr2 = iVar.h();
                    }
                    if (Arrays.equals(bArr4, bArr2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public long f() {
        return this.f16238d;
    }

    public byte[] g() {
        return this.f16243i;
    }

    public byte[] h() {
        return this.f16244j;
    }

    public int hashCode() {
        int i5;
        int i6;
        int hashCode = (this.f16235a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f16236b;
        int i7 = 0;
        if (num == null) {
            i5 = 0;
        } else {
            i5 = num.hashCode();
        }
        long j5 = this.f16238d;
        long j6 = this.f16239e;
        int hashCode2 = (((((((((hashCode ^ i5) * 1000003) ^ this.f16237c.hashCode()) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003) ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003) ^ this.f16240f.hashCode()) * 1000003;
        Integer num2 = this.f16241g;
        if (num2 == null) {
            i6 = 0;
        } else {
            i6 = num2.hashCode();
        }
        int i8 = (hashCode2 ^ i6) * 1000003;
        String str = this.f16242h;
        if (str != null) {
            i7 = str.hashCode();
        }
        return ((((i8 ^ i7) * 1000003) ^ Arrays.hashCode(this.f16243i)) * 1000003) ^ Arrays.hashCode(this.f16244j);
    }

    public Integer l() {
        return this.f16241g;
    }

    public String m() {
        return this.f16242h;
    }

    public String n() {
        return this.f16235a;
    }

    public long o() {
        return this.f16239e;
    }

    public String toString() {
        return "EventInternal{transportName=" + this.f16235a + ", code=" + this.f16236b + ", encodedPayload=" + this.f16237c + ", eventMillis=" + this.f16238d + ", uptimeMillis=" + this.f16239e + ", autoMetadata=" + this.f16240f + ", productId=" + this.f16241g + ", pseudonymousId=" + this.f16242h + ", experimentIdsClear=" + Arrays.toString(this.f16243i) + ", experimentIdsEncrypted=" + Arrays.toString(this.f16244j) + "}";
    }

    private C1781b(String str, Integer num, h hVar, long j5, long j6, Map map, Integer num2, String str2, byte[] bArr, byte[] bArr2) {
        this.f16235a = str;
        this.f16236b = num;
        this.f16237c = hVar;
        this.f16238d = j5;
        this.f16239e = j6;
        this.f16240f = map;
        this.f16241g = num2;
        this.f16242h = str2;
        this.f16243i = bArr;
        this.f16244j = bArr2;
    }
}
