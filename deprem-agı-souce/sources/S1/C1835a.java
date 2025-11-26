package s1;

import p1.C1754c;
import q1.C1758b;

/* renamed from: s1.a  reason: case insensitive filesystem */
public abstract class C1835a implements C1839c {

    /* renamed from: a  reason: collision with root package name */
    protected C1758b f16524a = h();

    /* renamed from: b  reason: collision with root package name */
    private String f16525b = null;

    /* renamed from: c  reason: collision with root package name */
    private boolean f16526c = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f16527d = true;

    public void a(String str, Object obj) {
        if (!this.f16527d) {
            f(this.f16525b, this.f16524a);
            this.f16526c = false;
            this.f16527d = true;
        }
        if (this.f16524a.a(str)) {
            this.f16524a.get(str).setValue(obj);
            this.f16526c = true;
            return;
        }
        throw new C1754c(str + " not found");
    }

    public String b() {
        String str = this.f16525b;
        if (str == null || str.isEmpty() || this.f16526c) {
            i();
            this.f16525b = g(this.f16524a);
            this.f16526c = false;
            this.f16527d = true;
        }
        return this.f16525b;
    }

    public Object c(String str) {
        if (!this.f16527d) {
            f(this.f16525b, this.f16524a);
            this.f16526c = false;
            this.f16527d = true;
        }
        if (this.f16524a.a(str)) {
            return this.f16524a.get(str).getValue();
        }
        throw new C1754c("Invalid field: '" + str + "'");
    }

    public boolean d(String str) {
        return this.f16524a.a(str);
    }

    public void e(String str) {
        this.f16525b = str;
        this.f16526c = false;
        this.f16527d = false;
    }

    /* access modifiers changed from: protected */
    public abstract void f(String str, C1758b bVar);

    /* access modifiers changed from: protected */
    public abstract String g(C1758b bVar);

    /* access modifiers changed from: protected */
    public abstract C1758b h();

    public /* synthetic */ void i() {
        C1837b.a(this);
    }
}
