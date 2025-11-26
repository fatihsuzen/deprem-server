package x1;

import A1.f;
import android.content.Context;
import java.util.Date;
import u1.n;
import x1.d;

public class a implements d.a {

    /* renamed from: f  reason: collision with root package name */
    private static a f16965f = new a(new d());

    /* renamed from: a  reason: collision with root package name */
    protected f f16966a = new f();

    /* renamed from: b  reason: collision with root package name */
    private Date f16967b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f16968c;

    /* renamed from: d  reason: collision with root package name */
    private d f16969d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f16970e;

    private a(d dVar) {
        this.f16969d = dVar;
    }

    public static a a() {
        return f16965f;
    }

    private void d() {
        if (this.f16968c && this.f16967b != null) {
            for (n t5 : c.e().a()) {
                t5.t().g(c());
            }
        }
    }

    public void b(Context context) {
        if (!this.f16968c) {
            this.f16969d.a(context);
            this.f16969d.b(this);
            this.f16969d.i();
            this.f16970e = this.f16969d.g();
            this.f16968c = true;
        }
    }

    public Date c() {
        Date date = this.f16967b;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public void e() {
        Date a5 = this.f16966a.a();
        Date date = this.f16967b;
        if (date == null || a5.after(date)) {
            this.f16967b = a5;
            d();
        }
    }

    public void a(boolean z4) {
        if (!this.f16970e && z4) {
            e();
        }
        this.f16970e = z4;
    }
}
