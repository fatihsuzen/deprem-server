package W3;

import e4.C2356e;
import e4.C2363l;
import e4.X;
import java.io.IOException;

abstract class e extends C2363l {

    /* renamed from: b  reason: collision with root package name */
    private boolean f20043b;

    e(X x4) {
        super(x4);
    }

    /* access modifiers changed from: protected */
    public abstract void a(IOException iOException);

    public void close() {
        if (!this.f20043b) {
            try {
                super.close();
            } catch (IOException e5) {
                this.f20043b = true;
                a(e5);
            }
        }
    }

    public void f(C2356e eVar, long j5) {
        if (this.f20043b) {
            eVar.skip(j5);
            return;
        }
        try {
            super.f(eVar, j5);
        } catch (IOException e5) {
            this.f20043b = true;
            a(e5);
        }
    }

    public void flush() {
        if (!this.f20043b) {
            try {
                super.flush();
            } catch (IOException e5) {
                this.f20043b = true;
                a(e5);
            }
        }
    }
}
