package N;

import android.util.Log;

public abstract class d0 {

    /* renamed from: a  reason: collision with root package name */
    private Object f3059a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3060b = false;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C0709c f3061c;

    public d0(C0709c cVar, Object obj) {
        this.f3061c = cVar;
        this.f3059a = obj;
    }

    /* access modifiers changed from: protected */
    public abstract void a(Object obj);

    /* access modifiers changed from: protected */
    public abstract void b();

    public final void c() {
        Object obj;
        synchronized (this) {
            try {
                obj = this.f3059a;
                if (this.f3060b) {
                    String obj2 = toString();
                    Log.w("GmsClient", "Callback proxy " + obj2 + " being reused. This is not safe.");
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (obj != null) {
            a(obj);
        }
        synchronized (this) {
            this.f3060b = true;
        }
        e();
    }

    public final void d() {
        synchronized (this) {
            this.f3059a = null;
        }
    }

    public final void e() {
        d();
        synchronized (this.f3061c.f3033r) {
            this.f3061c.f3033r.remove(this);
        }
    }
}
