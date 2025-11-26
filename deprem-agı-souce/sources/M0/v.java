package m0;

final class v extends k {

    /* renamed from: h  reason: collision with root package name */
    private static final Object[] f15597h;

    /* renamed from: i  reason: collision with root package name */
    static final v f15598i;

    /* renamed from: c  reason: collision with root package name */
    final transient Object[] f15599c;

    /* renamed from: d  reason: collision with root package name */
    private final transient int f15600d;

    /* renamed from: e  reason: collision with root package name */
    final transient Object[] f15601e;

    /* renamed from: f  reason: collision with root package name */
    private final transient int f15602f;

    /* renamed from: g  reason: collision with root package name */
    private final transient int f15603g;

    static {
        Object[] objArr = new Object[0];
        f15597h = objArr;
        f15598i = new v(objArr, 0, objArr, 0, 0);
    }

    v(Object[] objArr, int i5, Object[] objArr2, int i6, int i7) {
        this.f15599c = objArr;
        this.f15600d = i5;
        this.f15601e = objArr2;
        this.f15602f = i6;
        this.f15603g = i7;
    }

    /* access modifiers changed from: package-private */
    public int c(Object[] objArr, int i5) {
        System.arraycopy(this.f15599c, 0, objArr, i5, this.f15603g);
        return i5 + this.f15603g;
    }

    public boolean contains(Object obj) {
        Object[] objArr = this.f15601e;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int b5 = g.b(obj);
        while (true) {
            int i5 = b5 & this.f15602f;
            Object obj2 = objArr[i5];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            b5 = i5 + 1;
        }
    }

    /* access modifiers changed from: package-private */
    public Object[] d() {
        return this.f15599c;
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f15603g;
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return 0;
    }

    public int hashCode() {
        return this.f15600d;
    }

    /* access modifiers changed from: package-private */
    public i l() {
        return i.j(this.f15599c, this.f15603g);
    }

    /* access modifiers changed from: package-private */
    public boolean n() {
        return true;
    }

    /* renamed from: o */
    public z iterator() {
        return i().iterator();
    }

    public int size() {
        return this.f15603g;
    }
}
