package x3;

import W2.J;
import android.os.Handler;
import android.os.Looper;
import b3.C2312i;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import q3.C2729e;
import w3.B0;
import w3.C2865c0;
import w3.C2869e0;
import w3.C2882l;
import w3.L0;
import w3.W;

/* renamed from: x3.e  reason: case insensitive filesystem */
public final class C2917e extends C2918f implements W {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f26333a;

    /* renamed from: b  reason: collision with root package name */
    private final String f26334b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f26335c;

    /* renamed from: d  reason: collision with root package name */
    private final C2917e f26336d;

    /* renamed from: x3.e$a */
    public static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2882l f26337a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2917e f26338b;

        public a(C2882l lVar, C2917e eVar) {
            this.f26337a = lVar;
            this.f26338b = eVar;
        }

        public final void run() {
            this.f26337a.h(this.f26338b, J.f19942a);
        }
    }

    private C2917e(Handler handler, String str, boolean z4) {
        super((C2633k) null);
        C2917e eVar;
        this.f26333a = handler;
        this.f26334b = str;
        this.f26335c = z4;
        if (z4) {
            eVar = this;
        } else {
            eVar = new C2917e(handler, str, true);
        }
        this.f26336d = eVar;
    }

    private final void J(C2312i iVar, Runnable runnable) {
        B0.c(iVar, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        C2865c0.b().dispatch(iVar, runnable);
    }

    /* access modifiers changed from: private */
    public static final void L(C2917e eVar, Runnable runnable) {
        eVar.f26333a.removeCallbacks(runnable);
    }

    /* access modifiers changed from: private */
    public static final J M(C2917e eVar, Runnable runnable, Throwable th) {
        eVar.f26333a.removeCallbacks(runnable);
        return J.f19942a;
    }

    /* renamed from: K */
    public C2917e F() {
        return this.f26336d;
    }

    public void dispatch(C2312i iVar, Runnable runnable) {
        if (!this.f26333a.post(runnable)) {
            J(iVar, runnable);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2917e)) {
            return false;
        }
        C2917e eVar = (C2917e) obj;
        if (eVar.f26333a == this.f26333a && eVar.f26335c == this.f26335c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i5;
        int identityHashCode = System.identityHashCode(this.f26333a);
        if (this.f26335c) {
            i5 = 1231;
        } else {
            i5 = 1237;
        }
        return identityHashCode ^ i5;
    }

    public boolean isDispatchNeeded(C2312i iVar) {
        if (!this.f26335c || !t.a(Looper.myLooper(), this.f26333a.getLooper())) {
            return true;
        }
        return false;
    }

    public void o(long j5, C2882l lVar) {
        a aVar = new a(lVar, this);
        if (this.f26333a.postDelayed(aVar, C2729e.f(j5, 4611686018427387903L))) {
            lVar.g(new C2916d(this, aVar));
        } else {
            J(lVar.getContext(), aVar);
        }
    }

    public C2869e0 q(long j5, Runnable runnable, C2312i iVar) {
        if (this.f26333a.postDelayed(runnable, C2729e.f(j5, 4611686018427387903L))) {
            return new C2915c(this, runnable);
        }
        J(iVar, runnable);
        return L0.f26244a;
    }

    public String toString() {
        String G4 = G();
        if (G4 != null) {
            return G4;
        }
        String str = this.f26334b;
        if (str == null) {
            str = this.f26333a.toString();
        }
        if (!this.f26335c) {
            return str;
        }
        return str + ".immediate";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C2917e(Handler handler, String str, int i5, C2633k kVar) {
        this(handler, (i5 & 2) != 0 ? null : str);
    }

    public C2917e(Handler handler, String str) {
        this(handler, str, false);
    }
}
