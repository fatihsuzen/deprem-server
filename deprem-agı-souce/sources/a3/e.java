package A3;

import W2.J;
import W2.u;
import X2.C2250q;
import b3.C2308e;
import b3.C2312i;
import b3.C2313j;
import c3.C2316b;
import java.util.ArrayList;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import w3.M;
import w3.N;
import w3.O;
import w3.Q;
import y3.C2928a;
import y3.v;
import y3.x;
import z3.C2972e;
import z3.C2973f;
import z3.C2974g;

public abstract class e implements o {

    /* renamed from: a  reason: collision with root package name */
    public final C2312i f17268a;

    /* renamed from: b  reason: collision with root package name */
    public final int f17269b;

    /* renamed from: c  reason: collision with root package name */
    public final C2928a f17270c;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17271a;

        /* renamed from: b  reason: collision with root package name */
        private /* synthetic */ Object f17272b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2973f f17273c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ e f17274d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C2973f fVar, e eVar, C2308e eVar2) {
            super(2, eVar2);
            this.f17273c = fVar;
            this.f17274d = eVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            a aVar = new a(this.f17273c, this.f17274d, eVar);
            aVar.f17272b = obj;
            return aVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f17271a;
            if (i5 == 0) {
                u.b(obj);
                C2973f fVar = this.f17273c;
                x i6 = this.f17274d.i((M) this.f17272b);
                this.f17271a = 1;
                if (C2974g.l(fVar, i6, this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17275a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f17276b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ e f17277c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(e eVar, C2308e eVar2) {
            super(2, eVar2);
            this.f17277c = eVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            b bVar = new b(this.f17277c, eVar);
            bVar.f17276b = obj;
            return bVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f17275a;
            if (i5 == 0) {
                u.b(obj);
                e eVar = this.f17277c;
                this.f17275a = 1;
                if (eVar.e((v) this.f17276b, this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return J.f19942a;
        }

        public final Object invoke(v vVar, C2308e eVar) {
            return ((b) create(vVar, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public e(C2312i iVar, int i5, C2928a aVar) {
        this.f17268a = iVar;
        this.f17269b = i5;
        this.f17270c = aVar;
    }

    static /* synthetic */ Object d(e eVar, C2973f fVar, C2308e eVar2) {
        Object d5 = N.d(new a(fVar, eVar, (C2308e) null), eVar2);
        if (d5 == C2316b.f()) {
            return d5;
        }
        return J.f19942a;
    }

    public C2972e b(C2312i iVar, int i5, C2928a aVar) {
        C2312i plus = iVar.plus(this.f17268a);
        if (aVar == C2928a.SUSPEND) {
            int i6 = this.f17269b;
            if (i6 != -3) {
                if (i5 != -3) {
                    if (i6 != -2) {
                        if (i5 != -2) {
                            i5 += i6;
                            if (i5 < 0) {
                                i5 = Integer.MAX_VALUE;
                            }
                        }
                    }
                }
                i5 = i6;
            }
            aVar = this.f17270c;
        }
        if (t.a(plus, this.f17268a) && i5 == this.f17269b && aVar == this.f17270c) {
            return this;
        }
        return f(plus, i5, aVar);
    }

    /* access modifiers changed from: protected */
    public String c() {
        return null;
    }

    public Object collect(C2973f fVar, C2308e eVar) {
        return d(this, fVar, eVar);
    }

    /* access modifiers changed from: protected */
    public abstract Object e(v vVar, C2308e eVar);

    /* access modifiers changed from: protected */
    public abstract e f(C2312i iVar, int i5, C2928a aVar);

    public final p g() {
        return new b(this, (C2308e) null);
    }

    public final int h() {
        int i5 = this.f17269b;
        if (i5 == -3) {
            return -2;
        }
        return i5;
    }

    public x i(M m5) {
        return y3.t.d(m5, this.f17268a, h(), this.f17270c, O.ATOMIC, (k3.l) null, g(), 16, (Object) null);
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String c5 = c();
        if (c5 != null) {
            arrayList.add(c5);
        }
        if (this.f17268a != C2313j.f20794a) {
            arrayList.add("context=" + this.f17268a);
        }
        if (this.f17269b != -3) {
            arrayList.add("capacity=" + this.f17269b);
        }
        if (this.f17270c != C2928a.SUSPEND) {
            arrayList.add("onBufferOverflow=" + this.f17270c);
        }
        return Q.a(this) + '[' + C2250q.V(arrayList, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (k3.l) null, 62, (Object) null) + ']';
    }
}
