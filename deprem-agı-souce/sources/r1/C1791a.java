package r1;

import java.util.List;
import p1.C1754c;
import s1.C1839c;

/* renamed from: r1.a  reason: case insensitive filesystem */
public abstract class C1791a implements C1792b {

    /* renamed from: a  reason: collision with root package name */
    private List f16386a = g();

    /* renamed from: b  reason: collision with root package name */
    private String f16387b = null;

    /* renamed from: c  reason: collision with root package name */
    private boolean f16388c = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f16389d = true;

    public void a(String str, Object obj) {
        if (!this.f16389d) {
            this.f16386a = e(this.f16387b);
            this.f16388c = false;
            this.f16389d = true;
        }
        for (C1839c cVar : this.f16386a) {
            if (cVar.d(str)) {
                cVar.a(str, obj);
                this.f16388c = true;
                return;
            }
        }
        throw new C1754c("Invalid field: '" + str + "'");
    }

    public String b() {
        String str = this.f16387b;
        if (str == null || str.isEmpty() || this.f16388c) {
            this.f16387b = f(this.f16386a);
            this.f16388c = false;
            this.f16389d = true;
        }
        return this.f16387b;
    }

    public Object c(String str) {
        if (!this.f16389d) {
            this.f16386a = e(this.f16387b);
            this.f16388c = false;
            this.f16389d = true;
        }
        for (C1839c cVar : this.f16386a) {
            if (cVar.d(str)) {
                return cVar.c(str);
            }
        }
        throw new C1754c("Invalid field: '" + str + "'");
    }

    public void d(String str) {
        this.f16387b = str;
        this.f16388c = false;
        this.f16389d = false;
    }

    /* access modifiers changed from: protected */
    public abstract List e(String str);

    /* access modifiers changed from: protected */
    public abstract String f(List list);

    /* access modifiers changed from: protected */
    public abstract List g();
}
