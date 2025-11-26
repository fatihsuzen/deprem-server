package s;

import B.C0628a;
import android.content.Context;

final class c extends h {

    /* renamed from: a  reason: collision with root package name */
    private final Context f16458a;

    /* renamed from: b  reason: collision with root package name */
    private final C0628a f16459b;

    /* renamed from: c  reason: collision with root package name */
    private final C0628a f16460c;

    /* renamed from: d  reason: collision with root package name */
    private final String f16461d;

    c(Context context, C0628a aVar, C0628a aVar2, String str) {
        if (context != null) {
            this.f16458a = context;
            if (aVar != null) {
                this.f16459b = aVar;
                if (aVar2 != null) {
                    this.f16460c = aVar2;
                    if (str != null) {
                        this.f16461d = str;
                        return;
                    }
                    throw new NullPointerException("Null backendName");
                }
                throw new NullPointerException("Null monotonicClock");
            }
            throw new NullPointerException("Null wallClock");
        }
        throw new NullPointerException("Null applicationContext");
    }

    public Context b() {
        return this.f16458a;
    }

    public String c() {
        return this.f16461d;
    }

    public C0628a d() {
        return this.f16460c;
    }

    public C0628a e() {
        return this.f16459b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (!this.f16458a.equals(hVar.b()) || !this.f16459b.equals(hVar.e()) || !this.f16460c.equals(hVar.d()) || !this.f16461d.equals(hVar.c())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.f16458a.hashCode() ^ 1000003) * 1000003) ^ this.f16459b.hashCode()) * 1000003) ^ this.f16460c.hashCode()) * 1000003) ^ this.f16461d.hashCode();
    }

    public String toString() {
        return "CreationContext{applicationContext=" + this.f16458a + ", wallClock=" + this.f16459b + ", monotonicClock=" + this.f16460c + ", backendName=" + this.f16461d + "}";
    }
}
