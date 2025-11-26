package j$.util.stream;

import java.util.concurrent.CountedCompleter;

/* renamed from: j$.util.stream.v1  reason: case insensitive filesystem */
public class C0589v1 extends CountedCompleter {

    /* renamed from: a  reason: collision with root package name */
    public final H0 f1806a;

    /* renamed from: b  reason: collision with root package name */
    public final int f1807b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f1808c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f1809d;

    public C0589v1(H0 h02, Object obj, int i5) {
        this.f1808c = i5;
        this.f1806a = h02;
        this.f1807b = 0;
        this.f1809d = obj;
    }

    public C0589v1(C0589v1 v1Var, H0 h02, int i5, byte b5) {
        super(v1Var);
        this.f1806a = h02;
        this.f1807b = i5;
    }

    public final void compute() {
        C0589v1 v1Var = this;
        while (v1Var.f1806a.o() != 0) {
            v1Var.setPendingCount(v1Var.f1806a.o() - 1);
            int i5 = 0;
            int i6 = 0;
            while (i5 < v1Var.f1806a.o() - 1) {
                C0589v1 a5 = v1Var.a(i5, v1Var.f1807b + i6);
                i6 = (int) (a5.f1806a.count() + ((long) i6));
                a5.fork();
                i5++;
            }
            v1Var = v1Var.a(i5, v1Var.f1807b + i6);
        }
        switch (v1Var.f1808c) {
            case 0:
                ((G0) v1Var.f1806a).f(v1Var.f1807b, v1Var.f1809d);
                break;
            default:
                v1Var.f1806a.k((Object[]) v1Var.f1809d, v1Var.f1807b);
                break;
        }
        v1Var.propagateCompletion();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public C0589v1(C0589v1 v1Var, H0 h02, int i5) {
        this(v1Var, h02, i5, (byte) 0);
        this.f1808c = 1;
        this.f1809d = (Object[]) v1Var.f1809d;
    }

    public final C0589v1 a(int i5, int i6) {
        switch (this.f1808c) {
            case 0:
                return new C0589v1(this, ((G0) this.f1806a).a(i5), i6);
            default:
                return new C0589v1(this, this.f1806a.a(i5), i6);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public C0589v1(C0589v1 v1Var, G0 g02, int i5) {
        this(v1Var, g02, i5, (byte) 0);
        this.f1808c = 0;
        this.f1809d = v1Var.f1809d;
    }
}
