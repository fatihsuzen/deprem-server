package u4;

import R2.c;
import T3.i;
import X2.C2250q;
import androidx.lifecycle.ViewModel;
import com.inmobi.cmp.ChoiceCmpCallback;
import k4.l;
import kotlin.jvm.internal.t;
import m4.b;
import m4.p;
import r4.a;

public final class f extends ViewModel {

    /* renamed from: a  reason: collision with root package name */
    public final a f26031a;

    /* renamed from: b  reason: collision with root package name */
    public final ChoiceCmpCallback f26032b;

    /* renamed from: c  reason: collision with root package name */
    public final b f26033c;

    /* renamed from: d  reason: collision with root package name */
    public final i f26034d;

    /* renamed from: e  reason: collision with root package name */
    public final l f26035e;

    /* renamed from: f  reason: collision with root package name */
    public final c f26036f;

    public f(a aVar, ChoiceCmpCallback choiceCmpCallback, b bVar, i iVar, l lVar, c cVar) {
        t.e(aVar, "sharedStorage");
        t.e(bVar, "screenTexts");
        t.e(lVar, "tracking");
        t.e(cVar, "gbcPurposeResponse");
        this.f26031a = aVar;
        this.f26032b = choiceCmpCallback;
        this.f26033c = bVar;
        this.f26034d = iVar;
        this.f26035e = lVar;
        this.f26036f = cVar;
    }

    public final String a() {
        p pVar;
        String str;
        i iVar = this.f26034d;
        if (iVar == null || (pVar = iVar.f19285f) == null || (str = pVar.f25482h) == null) {
            return "";
        }
        return str;
    }

    public final String b() {
        if (!this.f26033c.f25309b.isEmpty()) {
            return (String) C2250q.M(this.f26033c.f25309b);
        }
        return "";
    }

    public final String c() {
        p pVar;
        String str;
        i iVar = this.f26034d;
        if (iVar == null || (pVar = iVar.f19285f) == null || (str = pVar.f25481g) == null) {
            return "";
        }
        return str;
    }

    public final String d() {
        p pVar;
        String str;
        i iVar = this.f26034d;
        if (iVar == null || (pVar = iVar.f19285f) == null || (str = pVar.f25480f) == null) {
            return "";
        }
        return str;
    }
}
