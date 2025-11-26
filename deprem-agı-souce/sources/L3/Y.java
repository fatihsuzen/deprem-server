package L3;

import j3.C2582a;
import java.util.List;
import kotlin.jvm.internal.t;
import r3.C2733c;
import r3.C2734d;
import r3.C2743m;

final class Y implements C2743m {

    /* renamed from: a  reason: collision with root package name */
    private final C2743m f18499a;

    public Y(C2743m mVar) {
        t.e(mVar, TtmlNode.ATTR_TTS_ORIGIN);
        this.f18499a = mVar;
    }

    public boolean b() {
        return this.f18499a.b();
    }

    public List d() {
        return this.f18499a.d();
    }

    public C2734d e() {
        return this.f18499a.e();
    }

    public boolean equals(Object obj) {
        Y y4;
        C2743m mVar;
        C2743m mVar2;
        if (obj == null) {
            return false;
        }
        C2743m mVar3 = this.f18499a;
        C2734d dVar = null;
        if (obj instanceof Y) {
            y4 = (Y) obj;
        } else {
            y4 = null;
        }
        if (y4 != null) {
            mVar = y4.f18499a;
        } else {
            mVar = null;
        }
        if (!t.a(mVar3, mVar)) {
            return false;
        }
        C2734d e5 = e();
        if (e5 instanceof C2733c) {
            if (obj instanceof C2743m) {
                mVar2 = (C2743m) obj;
            } else {
                mVar2 = null;
            }
            if (mVar2 != null) {
                dVar = mVar2.e();
            }
            if (dVar != null && (dVar instanceof C2733c)) {
                return t.a(C2582a.a((C2733c) e5), C2582a.a((C2733c) dVar));
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f18499a.hashCode();
    }

    public String toString() {
        return "KTypeWrapper: " + this.f18499a;
    }
}
