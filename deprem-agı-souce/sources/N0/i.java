package N0;

import K0.b;
import K0.c;
import K0.g;

class i implements g {

    /* renamed from: a  reason: collision with root package name */
    private boolean f3187a = false;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3188b = false;

    /* renamed from: c  reason: collision with root package name */
    private c f3189c;

    /* renamed from: d  reason: collision with root package name */
    private final f f3190d;

    i(f fVar) {
        this.f3190d = fVar;
    }

    private void a() {
        if (!this.f3187a) {
            this.f3187a = true;
            return;
        }
        throw new b("Cannot encode a second value in the ValueEncoderContext");
    }

    public g b(String str) {
        a();
        this.f3190d.i(this.f3189c, str, this.f3188b);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void c(c cVar, boolean z4) {
        this.f3187a = false;
        this.f3189c = cVar;
        this.f3188b = z4;
    }

    public g f(boolean z4) {
        a();
        this.f3190d.o(this.f3189c, z4, this.f3188b);
        return this;
    }
}
