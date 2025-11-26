package y;

import A.C0620b;
import B.C0628a;
import T2.a;
import android.content.Context;
import java.util.concurrent.Executor;
import s.e;
import t.C1876b;
import z.C1951c;
import z.C1952d;

public final class s implements C1876b {

    /* renamed from: a  reason: collision with root package name */
    private final a f17054a;

    /* renamed from: b  reason: collision with root package name */
    private final a f17055b;

    /* renamed from: c  reason: collision with root package name */
    private final a f17056c;

    /* renamed from: d  reason: collision with root package name */
    private final a f17057d;

    /* renamed from: e  reason: collision with root package name */
    private final a f17058e;

    /* renamed from: f  reason: collision with root package name */
    private final a f17059f;

    /* renamed from: g  reason: collision with root package name */
    private final a f17060g;

    /* renamed from: h  reason: collision with root package name */
    private final a f17061h;

    /* renamed from: i  reason: collision with root package name */
    private final a f17062i;

    public s(a aVar, a aVar2, a aVar3, a aVar4, a aVar5, a aVar6, a aVar7, a aVar8, a aVar9) {
        this.f17054a = aVar;
        this.f17055b = aVar2;
        this.f17056c = aVar3;
        this.f17057d = aVar4;
        this.f17058e = aVar5;
        this.f17059f = aVar6;
        this.f17060g = aVar7;
        this.f17061h = aVar8;
        this.f17062i = aVar9;
    }

    public static s a(a aVar, a aVar2, a aVar3, a aVar4, a aVar5, a aVar6, a aVar7, a aVar8, a aVar9) {
        return new s(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9);
    }

    public static r c(Context context, e eVar, C1952d dVar, x xVar, Executor executor, C0620b bVar, C0628a aVar, C0628a aVar2, C1951c cVar) {
        return new r(context, eVar, dVar, xVar, executor, bVar, aVar, aVar2, cVar);
    }

    /* renamed from: b */
    public r get() {
        return c((Context) this.f17054a.get(), (e) this.f17055b.get(), (C1952d) this.f17056c.get(), (x) this.f17057d.get(), (Executor) this.f17058e.get(), (C0620b) this.f17059f.get(), (C0628a) this.f17060g.get(), (C0628a) this.f17061h.get(), (C1951c) this.f17062i.get());
    }
}
