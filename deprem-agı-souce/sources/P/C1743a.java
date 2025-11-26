package p;

/* renamed from: p.a  reason: case insensitive filesystem */
final class C1743a extends C1746d {

    /* renamed from: a  reason: collision with root package name */
    private final Integer f15672a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f15673b;

    /* renamed from: c  reason: collision with root package name */
    private final f f15674c;

    /* renamed from: d  reason: collision with root package name */
    private final g f15675d;

    C1743a(Integer num, Object obj, f fVar, g gVar, C1747e eVar) {
        this.f15672a = num;
        if (obj != null) {
            this.f15673b = obj;
            if (fVar != null) {
                this.f15674c = fVar;
                this.f15675d = gVar;
                return;
            }
            throw new NullPointerException("Null priority");
        }
        throw new NullPointerException("Null payload");
    }

    public Integer a() {
        return this.f15672a;
    }

    public C1747e b() {
        return null;
    }

    public Object c() {
        return this.f15673b;
    }

    public f d() {
        return this.f15674c;
    }

    public g e() {
        return this.f15675d;
    }

    public boolean equals(Object obj) {
        g gVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1746d) {
            C1746d dVar = (C1746d) obj;
            Integer num = this.f15672a;
            if (num != null ? num.equals(dVar.a()) : dVar.a() == null) {
                if (this.f15673b.equals(dVar.c()) && this.f15674c.equals(dVar.d()) && ((gVar = this.f15675d) != null ? gVar.equals(dVar.e()) : dVar.e() == null)) {
                    dVar.b();
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i5;
        Integer num = this.f15672a;
        int i6 = 0;
        if (num == null) {
            i5 = 0;
        } else {
            i5 = num.hashCode();
        }
        int hashCode = (((((i5 ^ 1000003) * 1000003) ^ this.f15673b.hashCode()) * 1000003) ^ this.f15674c.hashCode()) * 1000003;
        g gVar = this.f15675d;
        if (gVar != null) {
            i6 = gVar.hashCode();
        }
        return (hashCode ^ i6) * 1000003;
    }

    public String toString() {
        return "Event{code=" + this.f15672a + ", payload=" + this.f15673b + ", priority=" + this.f15674c + ", productData=" + this.f15675d + ", eventContext=" + null + "}";
    }
}
